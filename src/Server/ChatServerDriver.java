package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ChatServerDriver {



    public static void main(String[] args)throws RemoteException, MalformedURLException {


        //System.setProperty("java.rmi.server.hostname","127.0.0.1");
        Naming.rebind("RMIChatServer", new ChatServer());

    }



}
