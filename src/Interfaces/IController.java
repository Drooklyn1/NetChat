package Interfaces;

import javax.swing.DefaultListModel;

/**
 * @author Felix Dreiling
 * NetChat v1.5
 */

public interface IController {
    
    public int SetConnection(String groupIP, String port);
    
    public int Connect();
    
    public void Disconnect();
    
    public void Send(String s);
    
    public void Refresh();
    
    public void SetTimer(int refreshTime);

    public boolean IsConnected();
    
    public void Scan();
    
    public String GetGroup();
    
    public String GetPort();
    
    public DefaultListModel GetUserList();
    
    public DefaultListModel GetIPList();
    
}
