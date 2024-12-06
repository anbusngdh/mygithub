package com.example.week10_lab9_10_javafx.controller.form;


import com.example.week10_lab9_10_javafx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserControllerForm implements Initializable {

    @FXML
    private ListView<String> lstUsers;

    private ObservableList<String> msgData;

    private List<User> listprofile = new ArrayList<>();
    private List<User> readprofile = new ArrayList<>();


    @FXML
    protected void listUsers(ActionEvent event) {
        msgData.clear();
        for (User user : readprofile) {
            msgData.add(user.toString());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //serialize_user_profile();
        deserialize_user_profile();
        msgData = FXCollections.observableArrayList();
        lstUsers.setItems(msgData);


    }

    public void serialize_user_profile()
    {
        User up1 = new User(1,"sam", "sam@gmail.com", 23, "male");
        User up2 = new User(2,"robert", "robert@gmail.com", 33, "male");
        User up3 = new User(3,"nancy", "nancy@gmail.com", 43, "female");

        listprofile.add(up1);
        listprofile.add(up2);
        listprofile.add(up3);

        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("user.dat",false));

                ) {

            for(int i = 0; i<listprofile.size();i++)
                output.writeObject(listprofile.get(i));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void deserialize_user_profile()
    {
        try {

            ObjectInputStream input = new ObjectInputStream(new FileInputStream("user.dat"));

            User s;

            while(true)
            {
                try{
                    s = (User)input.readObject();
                    readprofile.add(s);
                } catch (Exception e) {
                    break;
                }
            }

            input.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(readprofile.toString());
    }

}

