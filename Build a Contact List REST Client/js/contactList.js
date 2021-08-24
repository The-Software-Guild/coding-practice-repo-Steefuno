function setupLoadContactsListener() {
    clearContactTable();
    let contentRows = $("#contentRows");

    $.ajax(
        {
            type: "GET",
            url: "https://tsg-contactlist.herokuapp.com/contacts",
            success: function(contactArray) {
                $.each(
                    contactArray,
                    function(index, contact) {
                        let name = contact.firstName + " " + contact.lastName;
                        let company = contact.company;
                        
                        let row = 
                            `
                                <tr>
                                    <td>${name}</td>
                                    <td>${company}</td>
                                    <td><button type="button" class="btn btn-info">Edit</button></td>
                                    <td><button type="button" class="btn btn-danger">Delete</button></td>
                                </tr>
                            `
                        ;
                        
                        contentRows.append(row);
                    }
                );
            
            },
            error: function() {
                $("#errorMessages")
                    .append(
                        $("<li>")
                            .attr({class: "list-group-item list-group-item-danger"})
                            .text("Error calling web service. Please try again later.")
                    )
                ;
            }
        }
    );
}

function setupAddContactListener() {
    $("#addButton").click(
        function (event) {
            let hasValidationErrors = checkAndDisplayValidationErrors(
                $("#addForm").find("input")
            );
            if (hasValidationErrors) {
                return false;
            }

            $.ajax(
                {
                    type: "POST",
                    url: "https://tsg-contactlist.herokuapp.com/contact",
                    data: JSON.stringify(
                        {
                            firstName: $("#addFirstName").val(),
                            lastName: $("#addLastName").val(),
                            company: $("#addCompany").val(),
                            phone: $("#addPhone").val(),
                            email: $("#addEmail").val()
                        }
                    ),
                    headers: {
                        "Accept": "application/json",
                        "Content-Type": "application/json"
                    },
                    "dataType": "json",
                    success: function() {
                        $("#errorMessages").empty();
                        $("#addFirstName").val("");
                        $("#addLastName").val("");
                        $("#addCompany").val("");
                        $("#addEmail").val("");
                        $("#addPhone").val("");

                        loadContacts();
                    },
                    error: function () {
                        $("#errorMessages")
                            .append(
                                $("<li>")
                                    .attr({class: "list-group-item list-group-item-danger"})
                                    .text("Error calling web service. Please try again later.")
                            )
                        ; 
                    }
                }
            )
        }
    );
}

function clearContactTable() {
    $("#contentRows").empty();
}

function checkAndDisplayValidationErrors(input) {
    $("#errorMessages").empty();
    
    let errorMessages = [];
    
    input.each(
        function() {
            if (!this.validity.valid) {
                let errorField = $("label[for=" + this.id + "]").text();
                errorMessages.push(errorField + " " + this.validationMessage);
            }  
        }
    );
    
    if (errorMessages.length > 0) {
        $.each(errorMessages,function(index,message) {
            $("#errorMessages").append($("<li>").attr({class: "list-group-item list-group-item-danger"}).text(message));
        });
        // return true, indicating that there were errors
        return true;
    } else {
        // return false, indicating that there were no errors
        return false;
    }
}

$(document).ready(function () {
    setupLoadContactsListener();
    setupAddContactListener();
});