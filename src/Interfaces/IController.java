/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import javax.swing.DefaultListModel;

/**
 * @author Felix Dreiling
 * Version 1.5
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
