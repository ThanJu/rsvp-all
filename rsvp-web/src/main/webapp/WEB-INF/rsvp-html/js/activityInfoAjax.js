
var activityInfoAjax = {
    commonApi:null,
    newCommonApi:function(commonApi){
        //使用前确认页面引用了commonApi.js
        this.commonApi = commonApi;
    },
    /**
     *添加活动
     * @param {*} paramObj
     */
    addActivityInfo: function (paramObj) {

        this.commonApi.serverApi.requestApi({
            data: {
                businessParam: "activityInfo-activityInfo-addActivityInfo",
                model: paramObj.model,
                chargeType:paramObj.model.chargeType
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
                    this.commonApi.alertMsg('提交项目失败');
                }
            },
            complete: function (res) {
                if (typeof paramObj.complete === "function") {
                    paramObj.complete(res);
                } else {

                }
            }
        })
    },
    /**
     *查询活动列表
     * @param {*} paramObj
     */
    fetchActivityInfoPageList: function (paramObj) {
        this.commonApi.serverApi.requestApi({
            data: {
                "businessParam": "activityInfo-activityInfo-fetchActivityInfoPageList",
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
                    this.commonApi.alertMsg('获取活动列表失败');
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
     *根据Id获取项目详细
     * @param {*} paramObj
     */
    fetchActivityInfoById: function (paramObj) {
        this.commonApi.serverApi.requestApi({
            data: {
                "businessParam": "activityInfo-activityInfo-fetchActivityInfoById",
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
                    this.commonApi.alertMsg('获取项目信息失败');
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