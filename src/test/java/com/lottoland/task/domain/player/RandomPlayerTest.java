package com.lottoland.task.domain.player;

import com.lottoland.task.domain.Choice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class RandomPlayerTest {

    @InjectMocks
    private RandomPlayer randomPlayer;

    @Test
    public void selectChoice() {
        Choice result = randomPlayer.selectChoice();
        assertThat(result).isNotNull();
    }

}