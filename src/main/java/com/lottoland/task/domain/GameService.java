package com.lottoland.task.domain;

public interface GameService {

    Totals getTotals();

    RoundResult playRound();
}
