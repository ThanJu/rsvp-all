
var dataRegisterApi = {
    commonApi:null,
    newCommonApi:function(commonApi){
        this.commonApi = commonApi;
    },
    /**
     *查询活动人数信息
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
                    this.commonApi.alertMsg('获取活动人数信息失败');
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