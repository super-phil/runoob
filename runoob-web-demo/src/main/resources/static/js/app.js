(function ($) {
    /***
     * 获取模版html
     * var myTemplate = Handlebars.compile($("#table-template").html());
     * 将json对象用刚刚注册的Handlebars模版封装，得到最终的html，插入到基础table中。
     * $('#tableList').html(myTemplate(data));
     * 调用:
     * $("#contact").hbs({path: "../tpl/demo.html", data: {name: "Alan", author: true}})
     */
    //方法扩展
    $.fn.hbs = function (options, data) {
        //TODO 这里是默认路径
        //整个项目结构
        //webapp
        //  html
        //  js
        //  tpl
        var defaults = {
            debug: false,//默认非debugger模式
            baseUrl: "../tpl",
            name: "demo.html"//模版名称
        };
        var opts = $.extend(defaults, options);
        var me = this;
        var url = opts.baseUrl + "/" + opts.name + "?v=" + Math.random().valueOf();
        if (opts.debug) {
            $.get(url, function (obj) {
                me.html(Handlebars.compile($(obj).html())(data));
                sessionStorage.removeItem(opts.name)
            });
        } else {
            if (sessionStorage.getItem(opts.name)) {
                me.html(Handlebars.compile(sessionStorage.getItem(opts.name))(data))
            } else {
                $.get(url, function (obj) {
                    sessionStorage.setItem(opts.name, $(obj).html());
                    me.html(Handlebars.compile($(obj).html())(data));
                });
            }
        }
    }
})(jQuery);
//方法扩展
$.extend({
    testName: function (o) {
        console.info(o)
    }
});