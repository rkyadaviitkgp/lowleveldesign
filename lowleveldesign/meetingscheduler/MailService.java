package code.lowleveldesign.meetingscheduler;

import java.util.List;

public class MailService {

    public void sendMailInBulk(String defaultFormate, List<Attendee> attendeeList){
        for(Attendee attendee : attendeeList)
            sendMail(defaultFormate, attendee);
    }

    public void sendMail(String defaultFormate, Attendee attendee){
        //send mail
    }
}
