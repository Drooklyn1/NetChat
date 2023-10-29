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
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.Timer;

/**
 * @author Felix Dreiling
 * Version 1.4.2 Test
 */

public class Controller implements Runnable {
    
    private GUI netchat;
    private MulticastSocket s = null;
    private NetworkInterface netIf = null;
    private InetSocketAddress sAddress = null;
    private InetAddress group;
    private int port;
    private byte buf[] = new byte[1024];
    private byte buf_s[] = new byte[1024];
    private DatagramPacket pack = null;
    private boolean status = false;
    private int ref_time = 1000;
    private JTextArea txt_output;
    private JList user_list;
    private JList ip_list;
    private DefaultListModel user_model;
    private DefaultListModel ip_model;
    private SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
    private Timer ref;
    private RefreshListener lis;
    private Thread t;
    private final AtomicBoolean running = new AtomicBoolean(false);
    
    public Controller(GUI gui, JTextArea output, JList list1, JList list2) {
        netchat = gui;
        txt_output = output;
        user_list = list1;
        ip_list = list2;
        user_model = new DefaultListModel();
        ip_model = new DefaultListModel();
        user_list.setModel(user_model);
        ip_list.setModel(ip_model);
        lis = new RefreshListener();
        ref = new Timer(ref_time,lis);
    }
    
    public void send(byte[] b) {
        buf_s = b;
            pack = new DatagramPacket(buf_s, buf_s.length, group, port);
        try {
            s.send(pack);
        } 
        catch (IOException ex) {
        }
    }
    
    public void refresh() {
        pack = new DatagramPacket(buf, buf.length);  
        try {
            //s.setSoTimeout(ref_time);
            s.receive(pack);
            String st = new String(pack.getData(),0,pack.getLength());
            txt_output.append(time.format(new Date())+" - "+pack.getAddress().getHostName()+" : "+st+"\n");
            groupRefresh(pack.getAddress().getHostName(), st);
            netchat.toFront();
        } 
        catch (IOException ex) {
        }
    }
    
    public void groupRefresh(String name, String message) {
        if(message.equals("*** Disconnected ***")) {
            user_model.removeElement(name);
        }
        else if (!user_model.contains(name)) {
            user_model.add(user_model.size(), name);
        }
    }
    
    private class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            refresh();
        }
    }
    
    public int connect(String g, int p) {
        port = p;
        try {
            group = InetAddress.getByName(g);
        } 
        catch (UnknownHostException ex) {
            return 1;
        }
        try {
            s = new MulticastSocket(port);
            s.setTimeToLive(10);
            s.setSoTimeout(100);
        } 
        catch (IOException ex) {
            return 2;
        }
        try {
           //s.joinGroup(group);
           sAddress = new InetSocketAddress(group, port);
           netIf = NetworkInterface.getByInetAddress(group);
           s.joinGroup(sAddress, netIf);
        }
        catch (IOException ex) {
            return 3;
        }
        ref.start();
        status = true;
        return 0;
    }
    
    public void disconnect() {
        status = false;
        try {
            //s.leaveGroup(group);
            s.leaveGroup(sAddress, netIf);
        } 
        catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.close();
        ref.stop();
    }
    
    public void timer(int rt) {
        ref_time = rt;
        ref.setDelay(ref_time);
    }

    public boolean isStatus() {
        return status;
    }
    
    public void scan() {
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
        
        txt_output.append(time.format(new Date()) + " : Scan finished\n");
    }
    
}
