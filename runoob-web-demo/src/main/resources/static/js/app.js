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
        var defaults = {
            debug: false,//默认非debugger模式
            suffix: ".html",
            baseUrl: "../tpl",
            name: "demo"//模版名称
        };
        var opts = $.extend(defaults, options);
        var me = this;
        var fullName = opts.name + opts.suffix;
        var url = opts.baseUrl + "/" + fullName + "?v=" + Math.random().valueOf();
        if (opts.debug) {
            $.get(url, function (obj) {
                me.html(Handlebars.compile($(obj).html())(data));
                sessionStorage.removeItem(fullName)
            });
        } else {
            if (sessionStorage.getItem(fullName)) {
                me.html(Handlebars.compile(sessionStorage.getItem(fullName))(data))
            } else {
                $.get(url, function (obj) {
                    sessionStorage.setItem(fullName, $(obj).html());
                    me.html(Handlebars.compile($(obj).html())(data));
                });
            }
        }
    };
})(jQuery);
//方法扩展
$.extend({
    testName: function (o) {
        console.info(o)
    }
});
(function () {
    $(".navbar").hbs({/*debug: true, */name: "navbar"},
        {
            brand: {name: "Runoob Template"},
            nav: [
                {active: true, name: "菜单一", href: "#"},
                {name: "菜单二"},
                {name: "百度", href: "http://www.baidu.com"}
            ]
        }
    );
})();
