package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandBustedTest {

    @Test
    public void handWithCardsValuedAt20IsNotBusted() throws Exception {
        Hand hand = createHandWithRanksOf("Q", "J");

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithCardsValuedAt21IsNotBusted() throws Exception {
        Hand hand = createHandWithRanksOf("Q", "9", "2");

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithCardsValuedAt22IsBusted() throws Exception {
        Hand hand = createHandWithRanksOf("Q", "8", "4");

        assertThat(hand.isBusted())
                .isTrue();
    }

    private Hand createHandWithRanksOf(String... ranks) {
        List<Card> cards = new ArrayList<>();
        for (String rank : ranks) {
            cards.add(new Card(Suit.CLUBS, rank));
        }
        return new Hand(cards);
    }
}
