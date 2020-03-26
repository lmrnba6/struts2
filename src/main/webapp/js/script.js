var idToDelete;
function show() {
    $("#loader").show();
}

function hide() {
    $("#loader").hide();
}

function showDialog() {
    $("#dialog").show();
}


function hideDialog() {
    $("#dialog").hide();
}

function deleteTweet(id){
    idToDelete = id;
    showDialog();
}

$(document).ready(function () {
    hide();
    hideDialog();

    $("#langSelect").change(function (lang) {
        location.href = '?request_locale=' + lang.target.value;
    });

    $("#login").click(function () {
        $("#dialog").show();

        show();
        //Login
        // $("#loginForm").submit(function (e) {
        //     e.preventDefault();
        //     show();
        //     var data = $("#loginForm").serialize();
        //     $.ajax({
        //         type: 'POST',
        //         url: 'signin.action',
        //         dataType: 'application/json',
        //         data: data,
        //         success: function (e) {
        //             hide();
        //         }, error: function (e) {
        //             hide();
        //         }
        //     });
        // });
        $("#loginForm").submit();
    });

    $("#yes").click(function () {
        hideDialog();
        location.href = 'deleteTweet.action?id=' + idToDelete;
    });

    $("#cancel").click(function () {
        hideDialog()
    })
});