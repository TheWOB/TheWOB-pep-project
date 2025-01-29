package Service;

import DAO.MessageDAO;
import Model.Message;

import java.util.List;

public class MessageService {
    public MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message message){
        if(message.getMessage_text().equals("")){
            return null;
        }
        return messageDAO.createMessage(message);
    }

    public List<Message> getAllMessages(){
        return messageDAO.getMessages();
    }

    public Message getMessageByID(int id){
        return messageDAO.getMessageByID(id);
    }

    public Message deleteMessage(int id){
        if(messageDAO.getMessageByID(id) != null){
            System.out.println("Message Service returning message");
            Message message = messageDAO.getMessageByID(id);
            messageDAO.deleteMessageByID(id);
            return message;
        }
        else{
            return null;
        }
    }

    public Message updateMessage(int id, Message message){
        if(message.getMessage_text().length() > 255 || messageDAO.getMessageByID(id) == null){
            return null;
        }
        messageDAO.updateMessage(id, message);
        message.setMessage_id(id);
        return messageDAO.getMessageByID(id);
    }

    public List<Message> getMessagesByUser(int user){
        return messageDAO.getMessagesByUser(user);
    }
}
