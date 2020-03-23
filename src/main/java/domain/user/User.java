package domain.user;

import domain.card.CardDeck;
import domain.game.Rule;

import java.util.Objects;

public abstract class User {
    protected final HandCard handCard;
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
        handCard = new HandCard();
    }

    private void validate(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void draw(CardDeck cardDeck) {
        handCard.add(cardDeck.draw());
    }

    public void firstDraw(CardDeck cardDeck) {
        if (!handCard.isEmpty()) {
            throw new IllegalStateException("잘못된 메서드 호출입니다.");
        }
        for (int i = 0; i < Rule.getFirstDrawNumber(); i++) {
            draw(cardDeck);
        }
    }

    public abstract boolean isDrawable();

    public String getStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name)
                .append(": ")
                .append(handCard.getNames());
        return stringBuilder.toString();
    }

    public boolean isBlackJack() {
        return handCard.isBlackJack();
    }

    public int getScore() {
        return handCard.getScore();
    }

    public boolean isOver() {
        return handCard.isOver();
    }
}