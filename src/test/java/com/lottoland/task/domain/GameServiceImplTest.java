package com.lottoland.task.domain;

import com.lottoland.task.domain.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.lottoland.task.domain.Choice.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceImplTest {

    private GameServiceImpl gameService;
    @Mock
    private Player firstPlayer;
    @Mock
    private Player secondPlayer;
    @Mock
    private Accumulator accumulator;

    @Before
    public void before() {
        gameService = new GameServiceImpl(firstPlayer, secondPlayer, accumulator);
    }

    @Test
    public void playRound_shouldDraw_whenRockRock() {
        when(firstPlayer.selectChoice()).thenReturn(ROCK);
        when(secondPlayer.selectChoice()).thenReturn(ROCK);
        checkRoundResult(gameService.playRound(), ROCK, ROCK, Result.DRAW);
    }

    @Test
    public void playRound_shouldDraw_whenPaperPaper() {
        when(firstPlayer.selectChoice()).thenReturn(PAPER);
        when(secondPlayer.selectChoice()).thenReturn(PAPER);
        checkRoundResult(gameService.playRound(), PAPER, PAPER, Result.DRAW);
    }

    @Test
    public void playRound_shouldDraw_whenScissorsScissors() {
        when(firstPlayer.selectChoice()).thenReturn(SCISSORS);
        when(secondPlayer.selectChoice()).thenReturn(SCISSORS);
        checkRoundResult(gameService.playRound(), SCISSORS, SCISSORS, Result.DRAW);
    }

    @Test
    public void playRound_shouldWinFirst_whenPaperRock() {
        when(firstPlayer.selectChoice()).thenReturn(PAPER);
        when(secondPlayer.selectChoice()).thenReturn(ROCK);
        checkRoundResult(gameService.playRound(), PAPER, ROCK, Result.PLAYER_1_WINS);
    }

    @Test
    public void playRound_shouldWinFirst_whenRockScissors() {
        when(firstPlayer.selectChoice()).thenReturn(ROCK);
        when(secondPlayer.selectChoice()).thenReturn(SCISSORS);
        checkRoundResult(gameService.playRound(), ROCK, SCISSORS, Result.PLAYER_1_WINS);
    }

    @Test
    public void playRound_shouldWinFirst_whenScissorsPaper() {
        when(firstPlayer.selectChoice()).thenReturn(SCISSORS);
        when(secondPlayer.selectChoice()).thenReturn(PAPER);
        checkRoundResult(gameService.playRound(), SCISSORS, PAPER, Result.PLAYER_1_WINS);
    }

    @Test
    public void playRound_shouldWinSecond_whenRockPaper() {
        when(firstPlayer.selectChoice()).thenReturn(ROCK);
        when(secondPlayer.selectChoice()).thenReturn(PAPER);
        checkRoundResult(gameService.playRound(), ROCK, PAPER, Result.PLAYER_2_WINS);
    }

    @Test
    public void playRound_shouldWinSecond_whenPaperScissors() {
        when(firstPlayer.selectChoice()).thenReturn(PAPER);
        when(secondPlayer.selectChoice()).thenReturn(SCISSORS);
        checkRoundResult(gameService.playRound(), PAPER, SCISSORS, Result.PLAYER_2_WINS);
    }

    @Test
    public void playRound_shouldWinSecond_whenScissorsRock() {
        when(firstPlayer.selectChoice()).thenReturn(SCISSORS);
        when(secondPlayer.selectChoice()).thenReturn(ROCK);
        checkRoundResult(gameService.playRound(), SCISSORS, ROCK, Result.PLAYER_2_WINS);
    }

    private void checkRoundResult(RoundResult roundResult, Choice choiceP1, Choice choiceP2, Result result) {
        assertThat(roundResult.getFirstPlayer()).isEqualTo(choiceP1);
        assertThat(roundResult.getSecondPlayer()).isEqualTo(choiceP2);
        assertThat(roundResult.getResult()).isEqualTo(result);
        verify(accumulator).add(result);
    }

}