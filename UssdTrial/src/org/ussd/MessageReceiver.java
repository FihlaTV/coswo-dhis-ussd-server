package org.ussd;

import hms.sdp.ussd.MchoiceUssdMessage;
import hms.sdp.ussd.MchoiceUssdResponse;
import hms.sdp.ussd.MchoiceUssdTerminateMessage;
import hms.sdp.ussd.client.MchoiceUssdReceiver;
import hms.sdp.ussd.client.MchoiceUssdSender;

public class MessageReceiver extends MchoiceUssdReceiver {


    @Override
    public void onMessage(MchoiceUssdMessage ussdMessage){
        System.out.println("============REQUEST=============");
        System.out.println(ussdMessage);
        System.out.println("================================");
        try {
            MchoiceUssdSender ussdSender = new MchoiceUssdSender("http://127.0.0.1:8000/ussd/", "appid", "pass");
            final MchoiceUssdResponse mchoiceUssdResponse =
                    ussdSender.sendMessage("Test Message", ussdMessage.getAddress(), ussdMessage.getConversationId(), false);
            System.out.println("=============RESPONSE===============");
            System.out.println(mchoiceUssdResponse);
            System.out.println("====================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSessionTerminate(MchoiceUssdTerminateMessage terminateMessage) {
        System.out.println("========terminate");
        System.out.println(terminateMessage);
    }
}