package unisync;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private List<Club> clubs;
    private String memberRole;

    public Member(String memberId, String name, String email) {
        this(memberId, name, email, "Member"); // default role
    }

    public Member(String memberId, String name, String email, String memberRole) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.memberRole = memberRole;
        this.clubs = new ArrayList<>();
    }

    
    public void joinClub(Club c) {
        if (c != null) {
            c.addMember(this);
        }
    }

    
    public void leaveClub(Club c) {
        if (c != null) {
            c.removeMember(this);
        }
    }

    
    public boolean registerForEvent(Event e) {
        if (e == null) {
            return false;
        }
        return e.registerMember(this);
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMemberRole() { return memberRole; }
    public List<Club> getClubs() { return clubs; }
}