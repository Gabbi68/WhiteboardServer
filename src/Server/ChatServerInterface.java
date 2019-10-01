package Server;

import Client.ClientChatInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInterface extends Remote {

    void registerChatClient(ClientChatInterface chatclient) throws RemoteException;
    void broadcastChatMessage(String msg) throws RemoteException;

}
