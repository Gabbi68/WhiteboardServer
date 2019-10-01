package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientChatInterface extends Remote {

    void getChatmessages(String chatMSG) throws RemoteException;




}
