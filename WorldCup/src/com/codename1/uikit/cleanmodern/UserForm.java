/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.facebook.FaceBookAccess;
import com.codename1.facebook.User;
import com.codename1.io.Storage;
import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.social.LoginCallback;
import com.codename1.ui.Button;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author Tiburcio
 */
public class UserForm extends com.codename1.ui.Form {

    public UserForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public UserForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        showFormElements();
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("UserForm");
        setName("UserForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    private void showFormElements() {
        this.setScrollable(false);
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        showData(this);
    }

    private void showData(UserForm form) {
        String token = "EAAc8oUsIsy8BAA0731EWq6ajb5VGAzsZAvEJGbDGg9CLUAMgZAOszEnWCFpTLUc4PJJFjxx4jk5Wj9m84mU1SxCDMoCFUrbm94OUQ2fzX4244lO8kPsj13i75ksZCXJV2uFohQpOs5qIJkOKrCEZBFgSDbsUFAxqDEd3HSCsTQZDZD";
        if(token == null || token.equals("")){
            showIfNotLoggedIn(form);
            System.out.println("no token");
        } else {
            showIfLoggedIn(form);
                        System.out.println("token");

        }
    }

    private void showIfNotLoggedIn(UserForm form) {
        
            form.getContentPane().removeAll();
            Storage.getInstance().writeObject("token", "");
            
            
            
            form.add(new Label("User not connected"));
            
            Button buttonLogin = new Button("Login");
            buttonLogin.addActionListener((e) -> {
                facebookLogin(form);
            });
            form.add(buttonLogin);
            
            form.revalidate();
            form.show();

    }

    private void showIfLoggedIn(UserForm form) {
        String token = "EAAc8oUsIsy8BAA0731EWq6ajb5VGAzsZAvEJGbDGg9CLUAMgZAOszEnWCFpTLUc4PJJFjxx4jk5Wj9m84mU1SxCDMoCFUrbm94OUQ2fzX4244lO8kPsj13i75ksZCXJV2uFohQpOs5qIJkOKrCEZBFgSDbsUFAxqDEd3HSCsTQZDZD";
        FaceBookAccess.setToken(token);
            final User me = new User();
            try {
                FaceBookAccess.getInstance().getUser("me", me, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String miNombre = me.getName();
                        
                        form.getContentPane().removeAll();
                        
                        form.add(new Label(miNombre));
                        
                        Button buttonLogout = new Button("Logout");
                        buttonLogout.addActionListener((e) -> {
                            facebookLogout(form);
                            showIfNotLoggedIn(form);
                        });


                        
                        form.add(buttonLogout);
                        
                        form.revalidate();
                        form.show();
                    }

                    
                });
            } catch (IOException ex) {
                ex.printStackTrace();
                showIfNotLoggedIn(form);
            }
    }

    private void facebookLogout(UserForm form) {
        String clientId = "2036988283237167";
        String redirectURI = "http://localhost/"; //Una URI cualquiera. Si la pones en tu equipo debes crear un Servidor Web. Yo usé XAMPP
        String clientSecret = "4365b47129885af478b45e52610be92e";
        Login fb = FacebookConnect.getInstance();
        fb.setClientId(clientId);
        fb.setRedirectURI(redirectURI);
        fb.setClientSecret(clientSecret);

        //trigger the login if not already logged in
        fb.doLogout();
        Storage.getInstance().writeObject("token", "");
        showIfNotLoggedIn(form);
    }
    
    private void facebookLogin(UserForm form) {
        //use your own facebook app identifiers here   
        //These are used for the Oauth2 web login process on the Simulator.
        String clientId = "2036988283237167";
        String redirectURI = "http://www.codenameone.com/"; //Una URI cualquiera. Si la pones en tu equipo debes crear un Servidor Web. Yo usé XAMPP
        String clientSecret = "4365b47129885af478b45e52610be92e";
        Login fb = FacebookConnect.getInstance();
        fb.setClientId(clientId);
        fb.setRedirectURI(redirectURI);
        fb.setClientSecret(clientSecret);
        //Sets a LoginCallback listener
        fb.setCallback(new LoginCallback() {
            @Override
            public void loginFailed(String errorMessage) {
                System.out.println("Falló el login");
                Storage.getInstance().writeObject("token", "");
                showIfNotLoggedIn(form);
            }

            @Override
            public void loginSuccessful() {
                System.out.println("Funcionó el login");
                String token = fb.getAccessToken().getToken();
                Storage.getInstance().writeObject("token", token);
                showIfLoggedIn(form);
            }
            
        });
        //trigger the login if not already logged in
        if(!fb.isUserLoggedIn()){
            fb.doLogin();
        }else{
            //get the token and now you can query the facebook API
            String token = fb.getAccessToken().getToken();
            Storage.getInstance().writeObject("token", token);
            showIfLoggedIn(form);
        }
    }
}
