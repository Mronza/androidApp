package com.example.academy_intern.myfirstapplication;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
public class DataSource {
    static ArrayList<User> listuser = new ArrayList<User>();

    public DataSource()
    {

    }

    public void addUser(User user) {

        listuser.add(user);

    }

    public ArrayList<User> getAllUsers(){

        if(!listuser.isEmpty()) {
            return(listuser);
        }
        return(null);
    }
    public static boolean check(String username, String pass)
    {
        for(User user:listuser)
        {
            if(username.equalsIgnoreCase(user.getUsername()) && pass.equals(user.getPassword()))
            {
                return true;
            }
        }
        return  false;
    }
    String  displ = "";
    public String dis()
    {
        for(User user : listuser)
        {
            displ += String.format("Name : " + user.getName() + " \n" +
                    "Surname : " + user.getSurname() + "\n" +
                    "Age : " + user.getAge() + "\n");
        }
        return displ;
    }

    public boolean search(String search)
    {
        for(User user : listuser)
        {
            if(search.equals(user.getUsername()))
            {
                return true;
            }
        }
        return false;
    }

    public String dis(String userNa)
    {
        String disp = "";

        for(User user : listuser)
        {
            if(userNa.equals(user.getUsername()))
            {
                disp += String.format("Name      : " + user.getName() + " \n" +
                                      "Surname : " + user.getSurname() + "\n" +
                                      "Age        : " + user.getAge() + "\n" +
                        "============== \n");
            }
        }
        return disp;

    }



}
