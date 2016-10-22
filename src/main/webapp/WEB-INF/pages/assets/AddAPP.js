/**
 * Created by ZJDX on 2016/10/11.
 */
    function onAddTag(tag) {
        alert("Added a tag: " + tag);
    }

function onRemoveTag(tag) {
    alert("Removed a tag: " + tag);
}

function onChangeTag(input, tag) {
    alert("Changed a tag: " + tag);
}

$(function() {

    $('#tags_1').tagsInput({
        width: 'auto'
    });
    $('#tags_2').tagsInput({
        width: 'auto',
        onChange: function(elem, elem_tags) {
            var languages = ['php', 'ruby', 'javascript'];
            $('.tag', elem_tags).each(function() {
                if ($(this).text().search(new RegExp('//b(' + languages.join('|') + ')//b')) >= 0)
                    $(this).css('background-color', '#FBB44C');
            });
        }
    });
    $('#tags_3').tagsInput({
        width: 'auto',

        //autocomplete_url:'test/fake_plaintext_endpoint.html' //jquery.autocomplete (not jquery ui)
        autocomplete_url: 'test/fake_json_endpoint.html' // jquery ui autocomplete requires a json endpoint
    });


    // Uncomment this line to see the callback functions in action
    //          $('input.tags').tagsInput({onAddTag:onAddTag,onRemoveTag:onRemoveTag,onChange: onChangeTag});

    // Uncomment this line to see an input with no interface for adding new tags.
    //          $('input.tags').tagsInput({interactive:false});
});

// ++++++++++++++++++++++++

function createAPP() {
    var APPName = $("#inputAPPName").val();
    $.ajax("createAPP", {
        type: "POST",
        dataType:"json",
        data: {"APPName": APPName},
        success: function (data) {
            var result = eval(data);//parse json to object  ==val 解析json==
            var json = JSON.stringify(data);
            console.log(json);

            if(result.result==1){
                var app=eval(result.message);
                console.log(app.appid);
                $('#getAPPIDDiv').show();
                $('#getAPPID').val(app.appid);
                $('#APPName').val(app.appname);
                $('#APPID').val(app.appid);
            }

        },
        error: function () {
            console.log("createAPP error!");
        },

    });
    return false;

}


function completeAPPData(){
    var application=new Object();
    var appid=$("#getAPPID").val();
    application.appid= $("#getAPPID").val();
    application.appname= $('#APPName').val();
    application.developerid=" ";
    application.url=$("#URL").val();
    application.categary=$("#category").val();
    application.description=$("#textarea").val();
    application.logo=" ";
    application.tags=$("#tags_1").val();

    var json = JSON.stringify(application);
    console.log(json);
    var formData = new FormData();
    formData.append("file", $("#exampleInputFile")[0].files[0]);
    formData.append("application",JSON.stringify(application));
    $.ajax("updateAPP", {
        type: "POST",
        dataType:"json",
        data: formData,
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        success: function (data) {
            var result = eval(data);//parse json to object  ==val 解析json==
            var json = JSON.stringify(data);
            console.log(json);

            if(result.result==1){

            }

        },
        error: function () {
            console.log("createAPP error!");
        },

    });
}