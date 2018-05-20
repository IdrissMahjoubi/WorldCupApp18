/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.cleanmodern.BaseForm;
import com.esprit.Entities.Game;
import com.esprit.Entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sana
 */

public class ServiceUser {

    public void addUser(User user)
    {
        System.out.println("hummmm"+user.toString());
                ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/IdrissProject/web/app_dev.php/api/signup/?email="+ user.getUser_email()+"&name="+ user.getUser_name()+"&password="+ user.getUser_password();
        con.setUrl(Url);

        System.out.println("User set");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }


}
