function carCloud(){
    $.ajax("carCloud", {
        type: "GET",
        data:"json",
        success: function () {
            console.log("forward");
        },
        error: function () {
            console.log("error2");
        }

    });
}
function application(){
    $.ajax("application", {
        type: "GET",
        dataType:"html",
        success: function (data) {
            console.log(data);
            window.location.href =data;
        },
        error: function () {
            console.log("error2");
        },

    });
}
