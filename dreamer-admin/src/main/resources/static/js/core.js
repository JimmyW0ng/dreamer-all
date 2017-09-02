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

function formToJson(arr) {
    var obj = {};
    for (index in arr) {
        var data = arr[index];
        obj[data.name] = data.value;
    }
    return obj;
}

function resetForm(formName) {
    $(':input', formName)
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
}