package blackjack.domain.entry;

import blackjack.domain.PlayerOutcome;
import blackjack.domain.card.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameParticipants {
    private final Dealer dealer;
    private final Players players;

    public GameParticipants(Dealer dealer, Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public boolean isDealerHit(Deck deck) {
        if (dealer.shouldHaveMoreCard()) {
            dealer.putCard(deck.draw());
            return true;
        }
        return false;
    }

    public Map<PlayerOutcome, List<Player>> getGameResult() {
        return players.match(dealer);
    }

    public List<Participant> getParticipant() {
        List<Participant> participants = new ArrayList<>();
        participants.add(dealer);
        participants.addAll(players.getPlayers());
        return participants;
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }
}
