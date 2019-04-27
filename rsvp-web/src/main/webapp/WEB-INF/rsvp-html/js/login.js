function login() {
    var accountName = $("#accountName").val();
    var userPassWord = $("#password").val();

    commonApi.serverApi.username = accountName;
    commonApi.serverApi.password = userPassWord;
    commonApi.serverApi.login({
        success: function (res) {
            console.log(JSON.stringify(res))
            if (res.access_token !=null) {
                window.location.href = "index.html";
            }else{
                commonApi.alertMsg("登录失败，请联系管理员");
            }
        },
        fail: function (res) {
            commonApi.alertMsg("登录失败，请联系管理员");
        }
    });
    //测试
}