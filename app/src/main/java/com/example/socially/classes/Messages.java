package com.example.socially.classes;

public class Messages
{
    private String personImage;
    private String personName;
    private String message;

    public Messages() {
    }

    public Messages(String personImage, String personName, String message) {
        this.personImage = personImage;
        this.personName = personName;
        this.message = message;
    }

    public String getPersonImage() {
        return personImage;
    }

    public void setPersonImage(String personImage) {
        this.personImage = personImage;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
