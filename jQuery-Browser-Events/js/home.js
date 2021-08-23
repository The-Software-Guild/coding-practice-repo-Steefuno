let cityButtons = {
    "akronButton": "akron",
    "minneapolisButton": "minneapolis",
    "louisvilleButton": "louisville"
};

function display(id) {
    $("#pageContent")
        .children()
        .hide()
    ;
    $(id).show()
}

function onDocumentReady() {
    // initialize
    display("#mainInfoDiv");

    // when the main button is clicked, display the main menu
    $("#mainButton").on(
        "click",
        function() {
            display("#mainInfoDiv");
        }
    );

    // when a <tr> is hovered over, highlight
    $("tr").hover(
        function() {
            $(this).css(
                {"background-color": "WhiteSmoke"}
            );
        },
        function() {
            $(this).css(
                {"background-color": "white"}
            )
        }
    );
    
    // setup each city tab
    for(let key in cityButtons) {
        let weatherDiv = "#" + cityButtons[key] + "Weather";
        let button = "#" + key;
        let infoDiv = "#" + cityButtons[key] + "InfoDiv";
        let weatherButton = "#" + cityButtons[key] + "WeatherButton";

        // initially hide the weather info
        $(weatherDiv).hide();

        // when a city button is clicked, display the respective city and hide the weather
        $(button).on(
            "click",
            function() {
                $(weatherDiv).hide(0);
                display(infoDiv);
            }
        );

        // toggle weather info on weather button clicked
        $(weatherButton).on(
            "click",
            function() {
                $(weatherDiv).toggle(400);
            }
        );
    }
}
$(document).ready(onDocumentReady);