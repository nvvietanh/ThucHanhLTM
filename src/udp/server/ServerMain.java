/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp.server;

import udp.server.controller.ServerControl;
import udp.server.view.ServerView;

/**
 *
 * @author admin
 */
public class ServerMain {
    
    public static void main(String[] args) {
        ServerView view = new ServerView();
        ServerControl control = new ServerControl(view);
    }
    
}
