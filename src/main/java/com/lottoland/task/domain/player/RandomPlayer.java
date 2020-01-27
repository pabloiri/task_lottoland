package com.lottoland.task.domain.player;

import com.lottoland.task.domain.Choice;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomPlayer implements Player {

    @Override
    public Choice selectChoice() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        return Choice.values()[randomNum];
    }


}