package de.florianstendel.apps.examples.activiti.web.api;

public class StartProcessEntity {


    private String url;

    private String notificalEmailAdress;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotificalEmailAdress() {
        return notificalEmailAdress;
    }

    public void setNotificalEmailAdress(String notificalEmailAdress) {
        this.notificalEmailAdress = notificalEmailAdress;
    }

}
