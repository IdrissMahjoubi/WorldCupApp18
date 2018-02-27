/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyTEK
 */
public class ControllerSendSms {

    public static void sendSms(String phone, String pwd) {
        try {
            AuthMethod auth = new TokenAuthMethod("730f2dfe", "l5VJru3H3dKPnOK1");
            NexmoClient client = new NexmoClient(auth);
            SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage("+21621245065", phone, pwd));
            for (SmsSubmissionResult response : responses) {
                System.out.println(response);
            }
        } catch (IOException ex) {
            Logger.getLogger(ControllerSendSms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NexmoClientException ex) {
            Logger.getLogger(ControllerSendSms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
