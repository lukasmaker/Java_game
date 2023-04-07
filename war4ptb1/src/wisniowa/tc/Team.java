package wisniowa.tc;

import wisniowa.tc.players.Player;

public class Team {
    private Player[] teamMembers;

    public Team(Player... teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Player[] getTeamMembers() {
        return teamMembers;
    }
}
