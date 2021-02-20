
function setCookie(name, value, day) {
    var d = new Date();
    d.setTime(d.getTime() + (day * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toGMTString();
    document.cookie = name + "=" + value + "; " + expires;
}

function getCookie(getName) {
    var name = getName + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function clearCookieXSession() {
    setCookie("grade","",0);
    setCookie("acc","",0);
    sessionStorage.removeItem('acc');
}

function checkLoginCookie() {
    var grade = getCookie("grade");
    var acc = getCookie("acc");
    if(acc != ""||acc.length!=0){
        if(grade==0)
            window.location.href="admin";
        else if(grade==1)
            window.location.href="teacher";
        else if(grade.length==4)
            window.location.href="student";
    }
}
function checkAdminCookie() {
    var acc = getCookie("acc");
    var grade = getCookie("grade");
    if(acc==""||acc.length==0){
        window.location.href = "/";
    }else if(grade!=0){
        window.location.href = "/";
    }
}
function checkTeacherCookie() {
    var acc = getCookie("acc");
    var grade = getCookie("grade");
    if(acc==""||acc.length==0){
        window.location.href = "/";
    }else if(grade!=1){
        window.location.href = "/";
    }
}
function checkStudentCookie() {
    var stu = getCookie("acc");
    if (stu != "" || stu.length != 0) {
        document.getElementById("user-login").value = "欢迎~ " + stu;
        document.getElementById("user-center").href = "stuCenter";
    } else {
        window.location.href = "/";
    }
}
function checkStuCenterCookie() {
    var stu = getCookie("acc");
    if (stu != "" || stu.length != 0) {
        document.getElementById("user-login").value = "个人中心~ " + stu;
        document.getElementById("user-back").href = "student";
    } else {
        window.location.href = "/";
    }
}

