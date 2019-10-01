package Client;


import Server.ChatServerInterface;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChatClient extends UnicastRemoteObject implements ClientChatInterface, Runnable{

    private static final long serialVersionUID = 1L;
    private ChatServerInterface chatserver;
    private String name = null;



    protected ChatClient(String name, ChatServerInterface chatserver) throws RemoteException{
        this.name = name;
        this.chatserver = chatserver;

        chatserver.registerChatClient(this);
    }


    //Gets the message
    //TODO Change here to adapt to GUI

    public void getChatmessages(String chatMSG) throws RemoteException {
            System.out.println(chatMSG);
    }


    //Secondery thread to handle input

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true){
            input = scanner.nextLine();
            try {
                chatserver.broadcastChatMessage(name + " : "  + input);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }


    }
}
