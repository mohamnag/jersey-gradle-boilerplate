package com.example.data_transfer_objects;

/**
 * Another sample POJO as a data transfer object.
 *
 * Created by mohamnag on 18/02/16.
 */
public class HelloUser extends Hello {

    private String userName;

    public HelloUser(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return getTheWord() + getUserName() + "!";
    }
}
