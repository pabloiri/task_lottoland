$(document).ready(function() {
    var gameId;
    var roundNumber = 0;
    var baseUrl = 'http://localhost:8080/';
    var gameUrl = baseUrl + 'game';
    var totalsUrl = baseUrl + 'totals';

    var restart = function() {
        roundNumber = 0;
        setRoundsCounter(roundNumber);
        $('#roundsTableBody tr').remove();
        totals();
        $('#roundsTable').hide();
        $("#restart").prop("disabled",true);
    }

    var totals = function() {
        $.get(totalsUrl, function(data, status) {
            $('#totalRounds').text("Total rounds: " + data.totalRounds);
            $('#totalWins1st').text("Total wins first player: " + data.totalWinsFirstPlayer);
            $('#totalWins2nd').text("Total wins second player: " + data.totalWinsSecondPlayer);
            $('#totalDraws').text("Total draws: " + data.totalDraws);
        }, "json");
    }

    var play = function() {
       var playUrl = baseUrl + '/play';
       $.post(playUrl, function(data, status) {
           setRoundsCounter(++roundNumber);
           var row = '<tr>' +
               '<td>' + data.firstPlayer + '</td>' +
               '<td>' + data.secondPlayer + '</td>' +
               '<td>' + data.result + '</td>' +
               '</tr>';
           $('#roundsTable').find('tbody:last').append(row);
           totals();
       }, "json");
       $('#roundsTable').show();
       $("#restart").prop("disabled",false);
   };

    var setRoundsCounter = function(count) {
        $('#roundsCounter').text("Rounds played: " + count);
    };

    restart();  // page loading

    $("#play").click(play);
    $("#restart").click(restart);
});
