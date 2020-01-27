package com.lottoland.task.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lottoland.task.GameApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration Test that tests the entire application from the controller.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GameApplication.class)
@AutoConfigureMockMvc
public class GameControllerTest {

    private static final String PLAY_URL = "/play";
    private static final String TOTALS_URL = "/totals";

    private static final String SECOND_PLAYER_ROCK = "\"secondPlayer\":\"ROCK\"";
    private static final String TOTAL_ROUNDS_0 = "\"totalRounds\":0";
    private static final String TOTAL_ROUNDS_11 = "\"totalRounds\":11";
    private static final String FIRST_PLAYER_ROCK = "\"firstPlayer\":\"ROCK\"";
    private static final String FIRST_PLAYER_PAPER = "\"firstPlayer\":\"PAPER\"";
    private static final String FIRST_PLAYER_SCISSORS = "\"firstPlayer\":\"SCISSORS\"";
    private static final String RESULT_DRAW = "\"result\":\"draw\"";
    private static final String RESULT_PLAYER_1_WINS = "\"result\":\"player 1 wins\"";
    private static final String RESULT_PLAYER_2_WINS = "\"result\":\"player 2 wins\"";

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Before
    public void init() {
    }

    @Test
    public void accumulateStake_1st() throws Exception {
        // At the beginning the totals are in 0
        mvc.perform(MockMvcRequestBuilders.get(TOTALS_URL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(TOTAL_ROUNDS_0)));

        for (int i=0; i< 10; i++) {
            mvc.perform(MockMvcRequestBuilders.post(PLAY_URL)).andExpect(status().isOk());
        }

        mvc.perform(MockMvcRequestBuilders.post(PLAY_URL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(SECOND_PLAYER_ROCK)))
                .andExpect(content().string(anyOf(
                        containsString(FIRST_PLAYER_ROCK),
                        containsString(FIRST_PLAYER_PAPER),
                        containsString(FIRST_PLAYER_SCISSORS))))
                .andExpect(content().string(anyOf(
                        containsString(RESULT_DRAW),
                        containsString(RESULT_PLAYER_1_WINS),
                        containsString(RESULT_PLAYER_2_WINS))));

        mvc.perform(MockMvcRequestBuilders.get(TOTALS_URL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(TOTAL_ROUNDS_11)));
    }

}