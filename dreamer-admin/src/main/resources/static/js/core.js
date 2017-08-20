$(function () {

    // 查询相关
    $("#resetBtn").click(function () {
        $(':input', '#query-form')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    });


    $("#showsimple").click(function () {
        toastr.success("Without any options", "Simple notification!")
    });
});

function toUrl(url) {
    self.location = url;
}