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
            ChatServerInterface chatServer = (ChatServerInterface) Naming.lookup(chatserverURL);

            //Need to take user name as input
            //Used when identifying different users

            new Thread(new ChatClient("Martin",chatServer)).start();




        }


}
