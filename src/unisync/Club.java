package unisync;


import java.util.ArrayList;
import java.util.List;

public class Club {
    private String clubId;
    private String name;
    private String description;
    private List<Member> members;
    private List<Event> events;

    public Club(String clubId, String name, String description) {
        this.clubId = clubId;
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    // This method does BOTH updates, so Member.joinClub just calls it.
    public void addMember(Member m) {
        if (m == null || members.contains(m)) {
            return; // already a member, so do nothing
        }
        members.add(m);
        m.getClubs().add(this);
    }

    // This method also does BOTH updates, so Member.leaveClub just calls it.
    public boolean removeMember(Member m) {
        if (m == null || !members.contains(m)) {
            return false;
        }
        members.remove(m);
        m.getClubs().remove(this);
        return true;
    }

    public void addEvent(Event e) {
        if (e != null && !events.contains(e)) {
            events.add(e);
        }
    }

    public String getClubId() { return clubId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Member> getMembers() { return members; }
    public List<Event> getEvents() { return events; }
}

