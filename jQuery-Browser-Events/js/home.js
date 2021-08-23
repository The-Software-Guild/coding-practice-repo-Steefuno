function display(id) {
    $("#pageContent")
        .children()
        .hide()
    ;
    $(id).show()
}

function onDocumentReady() {
    display("#mainInfoDiv");

    // When a button is pressed, display the respective div
    $("#mainButton").on(
        "click",
        function() {
            display("#mainInfoDiv");
        }
    );
    $("#akronButton").on(
        "click",
        function() {
            display("#akronInfoDiv");
        }
    );
    $("#minneapolisButton").on(
        "click",
        function() {
            display("#minneapolisInfoDiv");
        }
    );
    $("#louisvilleButton").on(
        "click",
        function() {
            display("#louisvilleInfoDiv");
        }
    );
}
$(document).ready(onDocumentReady);