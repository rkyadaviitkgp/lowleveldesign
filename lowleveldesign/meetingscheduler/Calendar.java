package code.lowleveldesign.meetingscheduler;
import java.time.LocalDateTime;
import java.util.List;

public class Calendar {

    List<Meeting> meetingList;
    public boolean isAvaialble(LocalDateTime start, LocalDateTime end){
        for(Meeting meeting : meetingList){
            if((meeting.startTime.isBefore(start) && meeting.endTme.isBefore(end)) || (meeting.startTime.isAfter(start) && meeting.endTme.isAfter(end)))
                continue;
            else
                return false;
        }
        return true;
    }

    public void reserveRoom(Meeting m){
        meetingList.add(m);
    }
}
