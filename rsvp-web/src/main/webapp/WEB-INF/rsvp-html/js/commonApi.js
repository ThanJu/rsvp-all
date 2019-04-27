var domain = "http://20.1.1.239:8080";
// domain = "http://htwl.vaiwan.com";
var commonApi = {
    serverApi: {
        url: domain,
        username: "manager0001",
        password: "123456",
        authType: "password",
        client_id: "rsvp_web_manage",
        grant_type: "password",
        loginToken: {},
        freeSkip: function () {
            var tokenData = commonApi.serverApi.loginToken;
            if (typeof (tokenData) != undefined) {
                var tokenTime = tokenData.timestamp;
                var curTimestamp = new Date().getTime();
                if (typeof (tokenTime) == undefined && (curTimestamp - tokenData.timestamp) > 7000000) {
                    window.location.href = 'login.html';
                }
            } else {
                window.location.href = 'login.html';
            }
        },
        getAuthorization: function () {
            var authorization = "";
            //获取 logintoken的值
            var tokenData = commonApi.serverApi.loginToken;
            var curTimestamp = new Date().getTime();
            if ((curTimestamp - tokenData.timestamp) < 7000000) {
                authorization = tokenData.token_type + " " + tokenData.access_token;
            } else {
                //重新获取token
                this.login({
                    success: function (res) {
                        if (res.access_token != null) {
                            authorization = this.getAuthorization();
                        } else {
                            commonApi.alertMsg("连接失败，请重新登录");
                            window.location.href = 'index.html';
                        }
                    },
                    fail: function (res) {
                        commonApi.alertMsg("连接失败，请重新登录");
                    }
                });
            }
            return authorization;
        },
        login: function (paramObj) {
            $.ajax({
                url: this.url + "/oauth/token",
                method: 'POST',
                contentType: 'application/x-www-form-urlencoded',
                data: {
                    username: this.username,
                    password: this.password,
                    authType: this.authType,
                    client_id: this.client_id,
                    grant_type: this.grant_type,
                },
                dataType: 'json',
                success: function (res) {
                    if (res.access_token != null) {
                        res.timestamp = new Date().getTime();
                        commonApi.serverApi.loginToken = res;
                        window.localStorage.setItem('commonApi', JSON.stringify(commonApi));
                    }
                    paramObj.success(res);
                },
                fail: function (res) {
                    console.log("fail:", res)
                    paramObj.fail(res);
                }

            });
        },
        requestApi: function (paramObj) {
            console.log("==="+JSON.stringify(paramObj.data))

            $.ajax({
                data: JSON.stringify(paramObj.data),
                url: this.url + '/abs/business',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': this.getAuthorization()
                },// 设置请求的 header
                dataType: 'json',
                success: function (res) {
                    if (typeof paramObj.success === "function") {
                        paramObj.success(res);
                    }
                },
                fail: function (res) {
                    if (typeof paramObj.fail === "function") {
                        paramObj.fail(res);
                    }
                },
                complete: function (res) {
                    if (typeof paramObj.complete === "function") {
                        paramObj.complete(res);
                    }
                }
            });
        }
    },
    alertMsg: function (msg) {
        //不同平台时，替换不同弹出框控件
        alert(msg)
    },
    newCommonApi:function () {
        var commonApiObj = JSON.parse(window.localStorage.getItem('commonApi'))
        if( commonApiObj !=null){
            for (var key in commonApiObj.serverApi){
                commonApi.serverApi[key] = commonApiObj.serverApi[key];
            }
        }
        return commonApi;
    }
}
if (window.location.pathname.indexOf("login.html") < 0) {
    var commonApiFun = commonApi.newCommonApi();
    commonApiFun.serverApi.freeSkip();
}
