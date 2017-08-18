$(function () {

    // 查询相关
    $("#resetBtn").click(function () {
        $(':input', '#query-form')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    });

});