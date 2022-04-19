package code.lowleveldesign.meetingscheduler;

import java.time.LocalDateTime;

public class MeetingRoom {

    Calendar calendar;

    public boolean isRoomAvailable(LocalDateTime startTime, LocalDateTime endTime){
        boolean isAvailable = calendar.isAvaialble(startTime, endTime);
        return  isAvailable;
    }

    public void scheduleNewMeeting(Meeting m){
        calendar.reserveRoom(m);
    }
}
