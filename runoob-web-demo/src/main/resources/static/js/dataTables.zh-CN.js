//dataTable
$.extend($.fn.dataTable.defaults, {
    searching: true,//不允许搜索
    lengthChange: false,//不允许改变每页显示数量
    processing: true,
    serverSide: true,//服务器交互
    // ordering: false,//排序
    autoWidth: true,//自动宽度
    deferRender: true,
    scrollX: true,//水平滚动条
    language: {
        // lengthMenu: '<select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录',//左上角的分页大小显示。
        // search: '<span class="label label-success">搜索:</span>',//右上角的搜索文本，可以写html标签
        sSearch: "查询:",
        lengthMenu: "每页 _MENU_ 条记录",
        zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
        sEmptyTable: "没有找到记录",
        info: "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
        infoEmpty: "没有找到记录",
        infoFiltered: "(从 _MAX_ 条记录过滤)",
        sProcessing: "加载中... ...",
        paginate: {
            previous: "上一页",
            next: "下一页",
            first: "第一页",
            last: "最后"
        }
    }
});

(function ($) {
    $.fn.initDT = function (url, columns) {
        var table = init(this, url, columns);
        tbr();//工具栏
        search(table);//搜索
        return table;
    };
    function init(selector, url, columns) {
        return $(selector).DataTable({
            ajax: url,
            columns: columns
        });
    }

    function tbr() {
        var strVar = "";
        strVar += "<div class=\"col-xs-6 col-xs-offset-6 col-sm-5 col-sm-offset-7 col-md-4 col-md-offset-8 col-lg-3 col-lg-offset-9\" style=\"text-align: right\">\n";
        strVar += "    <div class=\"form-group\">\n";
        strVar += "        <div class=\"input-group\">\n";
        strVar += "            <input id=\"dt_search\" type=\"text\" class=\"form-control input-sm\"\n";
        strVar += "                   placeholder=\"Search...\"\n";
        strVar += "                   autocomplete=\"off\">\n";
        strVar += "            <div class=\"input-group-addon\">查询<\/div>\n";
        strVar += "        <\/div>\n";
        strVar += "    <\/div>\n";
        strVar += "<\/div>\n";
        $("#myTable_wrapper>:first").html(strVar)
    }

    function search(table) {
        $('#dt_search').keydown(function (e) {
            var key = e.which; //e.which是按键的值
            if (key == 13) {
                console.info($(this).val());
                console.info(key);
                table.search($(this).val()).draw();
            }

        });

    }

})(jQuery);