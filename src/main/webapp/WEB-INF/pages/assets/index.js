
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
$('.toggle').on('click', function() {
    $('.container').stop().addClass('active');
});

$('.close').on('click', function() {
    $('.container').stop().removeClass('active');
});
/*当鼠标离开关联手机号文本框时，提示文本及样式*/
function phoneBlur() {
    var phone=document.getElementById("phone");
    var phoneId=document.getElementById("phoneId");
    var reg=/^(13|15|18)\d{9}$/;
    if(phone.value==""){
        phoneId.innerHTML="账号不能为空，请输入手机号码";
        return false;
    }
    if(reg.test(phone.value)==false){
        phoneId.innerHTML="手机号码输入不正确，请重新输入";
        return false;
    }
    phoneId.innerHTML="手机号码输入正确";
    return true;
}
/*当鼠标放在密码文本框时，提示文本及样式*/
function passwordFocus(){
    var passwordId=document.getElementById("passwordId");
    passwordId.innerHTML="密码长度为6-16";


}

/*当鼠标离开密码文本框时，提示文本及样式*/
function passwordBlur() {
    var password=document.getElementById("password");
    var passwordId=document.getElementById("passwordId");
    if(password.value==""){
        passwordId.innerHTML="密码不能为空，请输入密码";
        return false;
    }
    if(password.value.length<6 || password.value.length>16){
        passwordId.innerHTML="密码长度为6-16";
        return false;
    }
    passwordId.innerHTML="密码输入正确";
    return true;
}
/*当鼠标离开重复密码文本框时，提示文本及样式*/
function repassBlur() {
    var repwd=document.getElementById("repass");
    var pwd=document.getElementById("password");
    var repwdId=document.getElementById("repassId");
    if(repwd.value==""){
        repwdId.innerHTML="重复密码不能为空，请重复输入密码";
        return false;
    }
    if(repwd.value!=pwd.value){
        repwdId.innerHTML="两次输入的密码不一致，请重新输入";
        return false;
    }
    repwdId.innerHTML="两次密码输入正确";
    return true;


}/*当鼠标离开重复密码文本框时，提示文本及样式*/
function repassBlur() {
    var repwd=document.getElementById("repass");
    var pwd=document.getElementById("password");
    var repwdId=document.getElementById("repassId");
    if(repwd.value==""){
        repwdId.innerHTML="重复密码不能为空，请重复输入密码";
        return false;
    }
    if(repwd.value!=pwd.value){
        repwdId.innerHTML="两次输入的密码不一致，请重新输入";
        return false;
    }
    repwdId.innerHTML="两次密码输入正确";
    return true;


}/*当鼠标离开重复密码文本框时，提示文本及样式*/
function repassBlur() {
    var repwd=document.getElementById("repass");
    var pwd=document.getElementById("password");
    var repwdId=document.getElementById("repassId");
    if(repwd.value==""){
        repwdId.innerHTML="重复密码不能为空，请重复输入密码";
        return false;
    }
    if(repwd.value!=pwd.value){
        repwdId.innerHTML="两次输入的密码不一致，请重新输入";
        return false;
    }
    repwdId.innerHTML="两次密码输入正确";
    return true;
}
/*当鼠标放在关联手机号文本框时，提示文本及样式*/
function phoneFocus() {
    var telId=document.getElementById("phoneId");
    telId.innerHTML="1、手机号码以13，15，18开头<br/>2、手机号码由11位数字组成";
}
/*表单提交时验证表单内容输入的有效性*/
function checkForm() {

    var flagPwd=passwordBlur();
    var flagRepwd=repassBlur();
    var flagPhone=phoneBlur();

    passwordBlur();
    repassBlur();
    phoneBlur();
    if(flagPwd==true &&flagRepwd==true &&flagPhone==true){
        return true;
    }
    else{
        return false;
    }

}
$(function(){
    $("form").submit(function() {

        var v=MD5($("#passwordLogin").val());
        $("#passwordLogin").val(v);
        return true;
    });
});

function login() {
    // console.info("点击了登录");
    var userPhone = $("#phoneLogin").val();
    // console.info(userName)
    var userPass = $("#passwordLogin").val();
    // console.info(userPass);
    if (userPhone == "" || userPhone == null) {
        alert("账号不能为空");
        return false;
    } else if (userPass == "" || userPass == null) {
        alert("密码不能为空");
        return false;
    }
    $("#passwordLogin").text(MD5(userPass));
    /*$.ajax("loginDeveloper", {
        type: "POST",
        dataType:"json",
        data: {"phonenum": userPhone,"password":MD5(userPass)}
    });*/
}
function register() {
    // console.info("点击了登录");
    var userPhone = $("#phone").val();
    // console.info(userName)
    var userPass = $("#password").val();
    console.log(MD5("123"));
    //var hash = hex_md5(userPass);
    if (checkForm()==true) {
        $.ajax("registerDeveloper", {
            type: "POST",
            dataType: "json",
            data: {"phonenum": userPhone, "password":MD5(userPass)},
            success: function (data) {
                console.log(data.result);
                if(data.result==0){
                    window.location.href ="index.html";
                }
            },
            error: function () {
                console.log("loginUser error!"+data.message);
            },

        });
    }else{
        console.log("checkForm error");
    }
}

