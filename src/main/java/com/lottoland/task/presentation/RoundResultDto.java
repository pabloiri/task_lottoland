package com.lottoland.task.presentation;

public class RoundResultDto {

    private final String firstPlayer;
    private final String secondPlayer;
    private final String result;

    public RoundResultDto(String firstPlayer, String secondPlayer, String result) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.result = result;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public String getResult() {
        return result;
    }
}
