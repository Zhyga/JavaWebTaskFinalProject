timer();

function timer(){
    var now = new Date();
    var eventDateArray = document.getElementsByClassName('raceDate');
    for (var i = 0; i < eventDateArray.length; i++){
        var eventDate = eventDateArray[i].getAttribute('data-browse').valueOf();
        var date = new Date(eventDate);
        var Days = Math.floor((date.getTime() - now.getTime())/(1000*60*60*24));
        var hours = Math.floor((date.getTime() - now.getTime())/(1000*60*60));
        hours = hours%24;
        var minutes = Math.floor((date.getTime() - now.getTime())/(1000*60));
        minutes = minutes%60;
        var seconds = Math.floor((date.getTime() - now.getTime())/(1000));
        seconds = seconds%60;
        var daysLeft = Days + ' days';
        var hoursLeft = [hours,
            (minutes < 10 ? "0" + minutes : minutes),
            (seconds < 10 ? "0" + seconds : seconds)].join(':');
        var t_str = [daysLeft,hoursLeft];
        eventDateArray[i].innerHTML = t_str;
    }
    setTimeout(timer,1000);
}

$(document).ready(function() {
    $(".clickable-row").click(function() {
        var race = this.getAttribute('data-browse');
        $.ajax({
            url: '/controller',
            method: 'post',
            data: {command: 'to_bet_page', raceId: race},
            success: function (data){
                document.location.href = "http://localhost:8080/controller?command=to_bet_page&raceId=" + race;
                //document.open
                //document.write(data)
            }
        });
    });
});

function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabContent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tabLink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
}
