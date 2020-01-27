package com.lottoland.task.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccumulatorTest {

    Accumulator accumulator = new Accumulator();

    @Test
    public void add_shouldAccumulate_whenDraw() {
        var before = accumulator.getTotals();
        accumulator.add(Result.DRAW);
        var after = accumulator.getTotals();
        assertThat(after.getTotalRounds()).isEqualTo(before.getTotalRounds() + 1);
        assertThat(after.getTotalDraws()).isEqualTo(before.getTotalDraws() + 1);
        assertThat(after.getTotalWinsFirstPlayer()).isEqualTo(before.getTotalWinsFirstPlayer());
        assertThat(after.getTotalWinsSecondPlayer()).isEqualTo(before.getTotalWinsSecondPlayer());
    }

    @Test
    public void add_shouldAccumulate_whenFirstWins() {
        var before = accumulator.getTotals();
        accumulator.add(Result.PLAYER_1_WINS);
        var after = accumulator.getTotals();
        assertThat(after.getTotalRounds()).isEqualTo(before.getTotalRounds() + 1);
        assertThat(after.getTotalDraws()).isEqualTo(before.getTotalDraws());
        assertThat(after.getTotalWinsFirstPlayer()).isEqualTo(before.getTotalWinsFirstPlayer() + 1);
        assertThat(after.getTotalWinsSecondPlayer()).isEqualTo(before.getTotalWinsSecondPlayer());
    }

    @Test
    public void add_shouldAccumulate_whenSecondWins() {
        var before = accumulator.getTotals();
        accumulator.add(Result.PLAYER_2_WINS);
        var after = accumulator.getTotals();
        assertThat(after.getTotalRounds()).isEqualTo(before.getTotalRounds() + 1);
        assertThat(after.getTotalDraws()).isEqualTo(before.getTotalDraws());
        assertThat(after.getTotalWinsFirstPlayer()).isEqualTo(before.getTotalWinsFirstPlayer());
        assertThat(after.getTotalWinsSecondPlayer()).isEqualTo(before.getTotalWinsSecondPlayer() + 1);
    }

}