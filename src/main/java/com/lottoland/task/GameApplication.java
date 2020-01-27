package com.lottoland.task;

import com.lottoland.task.domain.Accumulator;
import com.lottoland.task.domain.GameServiceImpl;
import com.lottoland.task.domain.player.Player;
import com.lottoland.task.domain.player.RandomPlayer;
import com.lottoland.task.domain.player.RockPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan("com.lottoland.task")
@SpringBootApplication
public class GameApplication {

    @Autowired
    private Accumulator accumulator;

    @Bean
    public GameServiceImpl game() {
        Player firstPlayer = new RandomPlayer();
        Player secondPlayer = new RockPlayer();
        return new GameServiceImpl(firstPlayer, secondPlayer, accumulator) ;
    }

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }
}