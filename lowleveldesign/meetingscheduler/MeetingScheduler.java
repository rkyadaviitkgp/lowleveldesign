package code.lowleveldesign.meetingscheduler;

import code.lowleveldesign.meetingscheduler.exceptions.NoRoomAvailable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class MeetingScheduler {
    private List<MeetingRoom> rooms;
    private static final int MAX_MEETING_RECORD = 20;
    Meeting[] meetingHistory;
    int index = 0;
    int size = 0;
    public MeetingScheduler(List<MeetingRoom> rooms){
        this.rooms = rooms;
        meetingHistory = new Meeting[MAX_MEETING_RECORD];
    }

    public Meeting bookRoom(LocalDateTime startTime, LocalDateTime endTime, List<Attendee> invitedUserList) throws NoRoomAvailable {
        // create a meeting as per room availbility and return it
        for(MeetingRoom meetingRoom : rooms){
            if(meetingRoom.isRoomAvailable(startTime, endTime)){
                Meeting meeting = new Meeting(meetingRoom, startTime, endTime, invitedUserList);
                meetingRoom.scheduleNewMeeting(meeting);
                sendNotification(meeting);
                saveToHistory(meeting);
                return meeting;
            }
        }
        throw new NoRoomAvailable();
    }

    private void saveToHistory(Meeting meeting){
        if(size < MAX_MEETING_RECORD)
            size++;
        meetingHistory[index] = meeting;
        index++;
        index = index%MAX_MEETING_RECORD;
    }

    public void sendNotification(Meeting meeting){
        meeting.sendNotification();
    }

}
