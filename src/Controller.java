import Interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Timer;

/**
 * @author Felix Dreiling
 * Version 1.5
 */

public class Controller implements Runnable, IController {
    
    private IUpdateRequester gui;
    private MulticastSocket socket = null;
    private NetworkInterface netIf = null;
    private InetSocketAddress sAddress = null;
    private InetAddress group;
    private int port;
    private byte buffReceive[] = new byte[1024];
    private byte buffSend[] = new byte[1024];
    private DatagramPacket pack = null;
    private boolean connected = false;
    private DefaultListModel user_model;
    private DefaultListModel ip_model;
    private int refreshTime = 1000;
    private Timer refreshTimer;
    private RefreshListener listener;
    private Thread t;
    private final AtomicBoolean running = new AtomicBoolean(false);
    
    public Controller(IUpdateRequester caller) {
        gui = caller;
        
        user_model = new DefaultListModel();
        ip_model = new DefaultListModel();
        listener = new RefreshListener();
        refreshTimer = new Timer(refreshTime,listener);
        
        port = 5053;
        try {
            group = InetAddress.getByName("224.0.1.113");
        } 
        catch (UnknownHostException ex) {
        }
    }
    
    public int SetConnection(String g, String p)
    {
        try {
            port = Integer.parseInt(p);
        }
        catch (NumberFormatException ex) {
            return 1;
        }
        
        try {
            group = InetAddress.getByName(g);
        }
        catch (UnknownHostException ex) {
            return 2;
        }
        
        return 0;
    }
    
    public int Connect() {
        try {
            socket = new MulticastSocket(port);
            socket.setTimeToLive(10);
            socket.setSoTimeout(100);
        } 
        catch (IOException ex) {
            return 3;
        }
        
        try {
           sAddress = new InetSocketAddress(group, port);
           netIf = NetworkInterface.getByInetAddress(group);
           socket.joinGroup(sAddress, netIf);
        }
        catch (IOException ex) {
            return 4;
        }
        
        refreshTimer.start();
        connected = true;
        
        return 0;
    }
    
    public void Disconnect() {
        try {
            socket.leaveGroup(sAddress, netIf);
        } 
        catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        socket.close();
        
        connected = false;
        refreshTimer.stop();
        
        user_model.removeAllElements();
    }
    
    public void Send(String b) {
        buffSend = b.getBytes();
        pack = new DatagramPacket(buffSend, buffSend.length, group, port);
        
        try {
            socket.send(pack);
        } 
        catch (IOException ex) {
        }
    }
    
    public void Refresh() {
        pack = new DatagramPacket(buffReceive, buffReceive.length);
        
        try {
            socket.receive(pack);
            String st = new String(pack.getData(),0,pack.getLength());
            
            if (!user_model.contains(pack.getAddress().getHostName())) {
                user_model.add(user_model.size(), pack.getAddress().getHostName());
            }
            
            gui.Update(pack.getAddress().getHostName()+" : "+st+"\n");
        } 
        catch (IOException ex) {
        }
    }
    
    private class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Refresh();
        }
    }
    
    public void SetTimer(int rt) {
        refreshTime = rt;
        refreshTimer.setDelay(refreshTime);
    }

    public boolean IsConnected() {
        return connected;
    }
    
    public void Scan() {
        ip_model.removeAllElements();
        
        t = new Thread(this, "Scan");
        t.start();
    }
    
    @Override
    public void run() {
        running.set(false);
        try {
            TimeUnit.SECONDS.sleep(1);
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        running.set(true);
        
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            byte[] ip = localhost.getAddress();
        
            for (int i = 1; i <= 254; i++) {
                if(running.get()) {
                    try {
                        ip[3] = (byte)i; 
                        InetAddress address = InetAddress.getByAddress(ip);

                        if (address.isReachable(500)) {
                            ip_model.add( ip_model.size(), address.toString().substring(1) + ": " + address.getHostName() );
                        }
                        /*else {
                            ip_model.add( ip_model.size(), "offline" );
                        }*/
                    }
                    catch (IOException ioex) {

                    }
                }
                else {
                    break;
                }
            }
        }
        catch (UnknownHostException ex) {
        }
        
        gui.Update("Scan finished\n");
    }
    
    public String GetGroup()
    {
        return group.toString().substring(1);
    }
    
    public String GetPort()
    {
        return "" + port;
    }
    
    public DefaultListModel GetUserList()
    {
        return user_model;
    }
    
    public DefaultListModel GetIPList()
    {
        return ip_model;
    }
    
}
