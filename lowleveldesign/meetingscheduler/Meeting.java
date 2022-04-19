package code.lowleveldesign.meetingscheduler;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
    String id;
    MeetingRoom room;
    LocalDateTime startTime;
    LocalDateTime endTme;
    List<Attendee> invited;
    MailService mailService;

    public Meeting(MeetingRoom room, LocalDateTime startTime, LocalDateTime endTme, List<Attendee> invited) {
        this.id = "123";
        this.room = room;
        this.startTime = startTime;
        this.endTme = endTme;
        this.invited = invited;
        mailService = new MailService();
    }

    public void sendNotification(){
        mailService.sendMailInBulk("Default fomate", invited);
    }
}
