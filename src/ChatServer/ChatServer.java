package ChatServer;



//Drive CLASS

import TestClient.ClientChatInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements ChatServerInterface {


    private static final long serialVersionUID = 1L;
    private ArrayList<ClientChatInterface> chatclients;




    protected ChatServer() throws RemoteException{
        chatclients = new ArrayList<ClientChatInterface>();
    }


    @Override
    public synchronized void registerChatClient(ClientChatInterface chatclient) throws RemoteException {
        this.chatclients.add(chatclient);
    }

    @Override
    public synchronized void broadcastChatMessage(String msg) throws RemoteException {
        int i = 0;
        while (i < chatclients.size()){
            chatclients.get(i++).getChatmessages(msg);
        }


    }
}
