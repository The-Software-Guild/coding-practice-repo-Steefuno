function onReady() {
    // Center all H1 Elements
    $("H1").css(
        {"text-align": "center"}
    );

    // Center all H2 Elements
    $("H2").css(
        {"text-align": "center"}
    );

    // Whatever has the text, "Team Up!," replace class with "page-header"
    var teamUpElement = $(":contains('Team Up!')").eq(-1);
    teamUpElement.removeClass();
    teamUpElement.addClass("page-header");

    // Change text, "The Squad," to "Yellow Team"
    $(":contains('The Squad')")
        .eq(-1)
        .text("Yellow Team")
    ;

    // Change the background of each team list to match the team name
    $("#orangeTeamList")
        .css(
            {"background-color": "orange"}
        )
    ;
    $("#blueTeamList")
        .css(
            {"background-color": "blue"}
        )
    ;
    $("#redTeamList")
        .css(
            {"background-color": "red"}
        )
    ;
    $("#yellowTeamList")
        .css(
            {"background-color": "yellow"}
        )
    ;
    
    // Add Joseph Banks and Simon Jones to yellowTeamList
    var yellowTeamList = $("#yellowTeamList");
    yellowTeamList.append("<li>Joseph Banks</li>");
    yellowTeamList.append("<li>Simon Jones</li>");

    // Hide the element with the text, "HIDE ME!!!"
    $(":contains('HIDE ME!!!')")
        .eq(-1)
        .hide()
    ;

    // Hide the element with the text, "Bogus Contact Info"
    $(":contains('Bogus Contact Info')")
        .eq(-1)
        .hide()
    ;

    // Add paragraph element with name and email to footer
    // Courier font, 24px height
    $("#footer").append(
        `
            <p style="font-family:courier; font-size:24px;">
                Steven Nguyen - steven.686295@gmail.com
            </p>
        `
    )
}

$(document).ready(onReady);