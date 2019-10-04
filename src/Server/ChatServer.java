package Server;



//Drive CLASS

import Client.ClientChatInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {


    private static final long serialVersionUID = 1L;
    private ArrayList<ClientChatInterface> chatclients;
    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");


    protected ChatServer() throws RemoteException{
        chatclients = new ArrayList<ClientChatInterface>();
    }


    public synchronized void registerChatClient(ClientChatInterface chatclient) throws RemoteException {
        this.chatclients.add(chatclient);
    }

    public synchronized void broadcastChatMessage(String msg) throws RemoteException {
        int i = 0;
        Date date = new Date();
        while (i < chatclients.size()){
            chatclients.get(i++).getChatmessages(formatter.format(date)  + " - " + msg);
        }


    }
}
