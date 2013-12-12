/**
 * 在页面的方法加载之前进行的JS操作，主要有两个目的，一个就是使用
 * 普通页面展示的TABLE的列表前的CheckBox的勾选事件
 */
$(function() {

    $('table th input:checkbox').on('click' , function(){
        var that = this;
        $(this).closest('table').find('tr > td:first-child input:checkbox')
            .each(function(){
                this.checked = that.checked;
                $(this).closest('tr').toggleClass('selected');
            });

    });

    $('[data-rel=tooltip]').tooltip();


    // 当操作完成之后，将显示的提示信息给自动隐藏掉
    var alertInfo = $('#alertInfo');
    if (alertInfo.length > 0) {

        function deleteAlertInfo() {
            alertInfo.toggle('slow');
        }

        // 3秒之后信息框将消失
        window.setTimeout(deleteAlertInfo, 3000);
    }

    var timeLineInfo = $('#timeLine');
    function timeLineFunction() {
        if (timeLineInfo.length > 0) {
            var second = document.getElementById('timeLine');
            second.innerText = second.innerText - 1;
        }
    }
    window.setInterval(timeLineFunction, 1000);
});


/**
 * 页面的数据进行删除操作之前的提示信息，如果同意则会执行删除操作
 * 如果不同意则不会进行删除操作
 *
 * @param obj
 */
function confirmDelete(obj) {
    bootbox.confirm("确定要删除此条数据?删除此条数据将不可以再找回.", "取消", "确定", function(result) {
        if (!result) {
            return;
        }
        window.location.href = obj.getAttribute("href");
    });
}