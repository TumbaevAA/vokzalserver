package com.example.vokzalserver.models;

import com.example.vokzalserver.entities.ItemEntity;
import com.example.vokzalserver.entities.PlaylistEntity;

import java.time.format.DateTimeFormatter;
import java.util.List;


public class EmailSMSItem {
    private long id;
    private String name;
    private Date date;
    private String group;
    private String recipient;
    private String content;
    private int status;

    public static EmailSMSItem toModel(ItemEntity itemEntity, int recipientListIndex){
        EmailSMSItem model = new EmailSMSItem();

        model.id = itemEntity.getId();
        model.name = itemEntity.getContent().getName();
        model.date = new Date(String.valueOf(itemEntity.getDateTimePlayback().getYear()),
                                String.valueOf(itemEntity.getDateTimePlayback().getMonthValue()),
                                String.valueOf(itemEntity.getDateTimePlayback().getDayOfMonth()),
                                itemEntity.getDateTimePlayback().format(DateTimeFormatter.ofPattern("HHmm")));

        /*Достаем список плейлистов, в которых есть контент из item.
         * Если список не равен null, то достаем имя 0-го плейлиста из списка.
         * Можно взять имя только одного плейлиста, потому что так требует фронтенд.
         * Делать одинаковые item, в которых отличается только имя плейлиста не стал, так как
         * то же самое сделано ниже с получателем, из-за этого повторяется много строчек.
         * */
        List<PlaylistEntity> list = itemEntity.getContent().getPlaylistsThatContentBelongsTo();
        if(list.size() != 0){
            model.group = list.get(0).getPlaylist().getName();
        }
        else{
            model.group = "-";
        }


        /*Находим получателя под номером recipientListIndex
         * и присваиваем полю recipient поле address этого получателя.
         * Так как во фронтенде в item может быть только один получатель
         */
        model.recipient = itemEntity.getRecipients().get(recipientListIndex).getAddress();

        model.content = itemEntity.getContent().getContent();
        model.status = itemEntity.getStatus();

        return model;
    }


    public EmailSMSItem() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getGroup() {
        return group;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public int getStatus() {
        return status;
    }
}
