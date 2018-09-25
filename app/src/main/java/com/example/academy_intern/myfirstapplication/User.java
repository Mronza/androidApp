package com.example.academy_intern.myfirstapplication;
import java.util.ArrayList;
import android.app.Person;

public class User extends person{
    //Encupsulation
    private String password;
    private String username;


    //Default constructor
    public User() {
        super();
        this.password = "";
        this.username = "";
    }

    public User(String name, String surname, int age, String password, String username) {
        super(name, surname, age);
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public User isloggedIn(String username, String password) {
//
//        DataSource data = new DataSource();
//        ArrayList<User> userlogIn = data.getAllUsers();
//
//        for(User user : userlogIn ) {
//
//            if(user.password.equals(password) && user.username.equals(username)) {
//                return(user);
//            }
//        }
//        return (null);
//
//    }
}
