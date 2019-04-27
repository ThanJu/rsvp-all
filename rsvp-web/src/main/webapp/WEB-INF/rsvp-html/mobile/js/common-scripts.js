$("#return_btn").click(function () {
    assignSkip();
})
function assignSkip() {
    history.back()
    history.go(-1)
}