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

/**
 * 删除多数据
 */
function confirmDeleteChecked(serverPath) {
    bootbox.confirm("确定要删除此条数据?删除此条数据将不可以再找回.", "取消", "确定", function(result) {
        if (!result) {
            return;
        }

        var ids = new Array();
        $('tr > td:first-child input:checkbox').each(function(index, obj) {
            if (obj.checked === true) {
                ids.push(obj.value);
            }
        });

        if (ids.length == 0) {
            var unique_id = $.gritter.add({
                title: '提示信息',
                text: '你没有勾选任何一行数据，此操作将不被允许!<span class="red">点击每行数据前方的CheckBox然后再点击此按钮</span>',
                image: serverPath + '/resources/images/info.png',
                sticky: true,
                time: '',
                class_name: 'gritter-info'
            });

            window.setTimeout(function() {
                $.gritter.remove(unique_id, {
                    fade: true,
                    speed: 'slow'
                });
            }, 3000);
        } else {
            $.ajax({
                method: 'POST',
                url: serverPath + '/artery/deleteList',
                data: {ids: ids.toString()},
                success: function(data) {
                    if (data.operateSuccess == true) {
                        var operateSuccessId = $.gritter.add({
                            title: '提示信息',
                            text: data.operateMessage,
                            image: serverPath + '/resources/images/tick.png',
                            sticky: true,
                            time: ''
                        });

                        if (data.operateSuccessUrl) {
                            console.log(data.operateSuccessUrl);
                            window.setTimeout(function() {
                                window.location.href = serverPath + data.operateSuccessUrl;
                            }, 1000);
                        }
                    } else {
                        var operateError = $.gritter.add({
                            title: '提示信息',
                            text: data.operateMessage,
                            image: serverPath + '/resources/images/error.png',
                            sticky: true,
                            time: '',
                            class_name: 'gritter-error'
                        });

                        window.setTimeout(function() {
                            $.gritter.remove(operateError, {
                                fade: true,
                                speed: 'slow'
                            })
                        }, 3000);
                    }
                }
            });
        }
    });

}