/**
 * @Description Wechat monitor script
 * @author Charles Chen
 * @date 14-4-27
 * @version 1.0
 */

$(window).ready(function () {
    $("#switch-btn").click(switchButton);
    $("#send-btn").click(sendMessage);
    $("#input_text").keydown(function (e) {
        if (e.which == 13) {
            sendMessage();
        }
    });
});

function switchButton() {
    var title = $(this).attr("title");
    if (title == "menu") {
        $(this).attr("title", "keyboard");
        $(this).css("background", "url(/images/wechat-keyboard.png)");
        $("#text-area").slideUp();
        $("#menu-area").slideDown();
    } else {
        $(this).attr("title", "menu");
        $(this).css("background", "url(/images/wechat-menu.png)");
        $("#text-area").slideDown();
        $("#menu-area").slideUp();
    }
}

function sendMessage() {
    var text = $("#input_text").val().replace(/(^\s)|(\s$)/, "");
    if (text != "") {
        var message = $("<div class='right-chat-history'></div>");
        message.html("<div class='chat-pic'></div><div class='chat-content'>" + text + "</div>");
        $("#chat-history").append(message);

        var data = "<xml>" +
            "   <ToUserName><![CDATA[toUser]]></ToUserName>" +
            "   <FromUserName><![CDATA[fromUser]]></FromUserName>" +
            "   <CreateTime>1348831860</CreateTime>" +
            "   <MsgType><![CDATA[text]]></MsgType>" +
            "   <Content><![CDATA[" + text + "]]></Content>" +
            "   <MsgId>1234567890123456</MsgId>" +
            "</xml>";
        $.ajax({
            url: "/wechat_handler.shtml",
            data: data,
            type: "post",
            contentType: "text/html",
            success: function (data) {
                var content = $(data).find("Content").html().replace("<!--[CDATA[", "").replace("]]-->", "");
                message = $("<div class='left-chat-history'></div>");
                message.html("<div class='chat-pic'></div><div class='chat-content'>" + content + "</div>");
                $("#chat-history").append(message);
                $("#chat-history").scrollTop($("#chat-history").height());
            },
            error: function () {
                alert("Ajax Error");
            }
        });


        $("#input_text").val("");
    }
}

function sendEvent(key) {
    var data = "<xml>" +
        "   <ToUserName><![CDATA[toUser]]></ToUserName>" +
        "   <FromUserName><![CDATA[fromUser]]></FromUserName>" +
        "   <CreateTime>1348831860</CreateTime>" +
        "   <MsgType><![CDATA[event]]></MsgType>" +
        "   <Event><![CDATA[CLICK]]></Event>" +
        "   <EventKey><![CDATA[" + key + "]]></EventKey>" +
        "</xml>";
    $.ajax({
            url: "/wechat_handler.shtml",
            data: data,
            type: "post",
            contentType: "text/html",
            success: function (data) {
                var content = $(data).find("Content").html();
                if (content != "") {
                    var content = content.replace("<!--[CDATA[", "").replace("]]-->", "");
                    message = $("<div class='left-chat-history'></div>");
                    message.html("<div class='chat-pic'></div><div class='chat-content'>" + content + "</div>");
                    $("#chat-history").append(message);
                    $("#chat-history").scrollTop($("#chat-history").height());
                }
            },
            error: function () {
                alert("Ajax Error");
            }
        }
    )
    ;
}