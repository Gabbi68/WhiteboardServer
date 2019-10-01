package Client;

import Server.ChatServer;
import Server.ChatServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ChatClientDriver {


        public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

            String chatserverURL = "rmi://localhost/RMIChatServer";
            ChatServerInterface chatServer = (ChatServer) Naming.lookup(chatserverURL);
            new Thread(new ChatClient(args[0],chatServer)).start();




        }


}
