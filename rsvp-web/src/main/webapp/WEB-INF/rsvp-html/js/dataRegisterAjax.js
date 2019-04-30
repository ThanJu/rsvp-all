var dataRegisterAjax = {
    commonApi: null,
    newCommonApi: function (commonApi) {
        //使用前确认页面引用了commonApi.js
        this.commonApi = commonApi;
    },
    /**
     *查询活动注册签到人数
     * @param {*} paramObj
     */
    countDataRegister: function (paramObj) {
        this.commonApi.serverApi.requestApi({
            data: {
                "businessParam": "dataRegister-dataRegister-countDataRegister",
                "model": paramObj.model
            },
            success: function (res) {
                if (typeof paramObj.success === "function") {
                    paramObj.success(res);
                }
            },
            fail: function (res) {
                if (typeof paramObj.fail === "function") {
                    paramObj.fail(res);
                } else {
                    this.commonApi.alertMsg('获取活动注册签到人数失败');
                }
            },
            complete: function (res) {
                if (typeof paramObj.complete === "function") {
                    paramObj.complete(res);
                } else {

                }
            }
        })
        return paramObj;
    },
    /**
     * 根据活动id和（手机号/识别码/姓名）查询用户信息
     * @param activityInfoId
     * @param workPhone
     * @returns {*}
     */
    fetchDataRegisterByRegister: function (paramObj) {
        this.commonApi.serverApi.requestApi({
            data: {
                "businessParam": "dataRegister-dataRegister-fetchRegisterBySearch",
                "model": paramObj.model

            },
            success: function (res) {
                if (typeof paramObj.success === "function") {
                    paramObj.success(res);
                }
            },
            fail: function (res) {
                if (typeof paramObj.fail === "function") {
                    paramObj.fail(res);
                } else {
                    this.commonApi.alertMsg('查询注册信息失败');
                }
            },
            complete: function (res) {
                if (typeof paramObj.complete === "function") {
                    paramObj.complete(res);
                } else {

                }
            }
        })
        return paramObj;
    }
}