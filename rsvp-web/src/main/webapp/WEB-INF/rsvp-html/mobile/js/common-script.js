$(function() {
    $(".skip a").click(function () {
        var url = $(this).attr("data");
        $('body').load(url);
    })
});
function assignSkip(url) {
    $('body').load(url);
}