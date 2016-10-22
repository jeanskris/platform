/**
 * Created by ZJDX on 2016/10/15.
 */
function selectAPP(e)
{
    var AppName=e;
    $.ajax("getAPPID", {
        type: "GET",
        dataType:"text",
        data:{"AppName": AppName},
        success: function (data) {
            console.log(data);
            $('#getAPPIDDiv').show();
            $('#ShowAPPID').val(data);
            $('#APPID').val(data);
        },
        error: function () {
            console.log("error2");
        },

    });

}
function completeAPIData( ){
    var newInterf=new Object();
    newInterf.interfaceid=null;
    newInterf.dataaddr=$('#DataAddr').val();
    newInterf.method=$('#method').val();
    newInterf.parameters=$('#textarea').val();
    newInterf.appid=$('#APPID').val();
    var sendData=JSON.stringify(newInterf);
    $.ajax("createAPI", {
        type: "POST",
        dataType:"json",
        contentType: "application/json",
        data:JSON.stringify(newInterf),
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
