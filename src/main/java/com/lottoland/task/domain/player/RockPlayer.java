package com.lottoland.task.domain.player;

import com.lottoland.task.domain.Choice;
import org.springframework.stereotype.Component;

@Component
public class RockPlayer implements Player {

    @Override
    public Choice selectChoice() {
        return Choice.ROCK;
    }
}