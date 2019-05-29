package com.example.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * jso up工具类
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
public class JsoupUtil {

    private static final Whitelist whitelist = Whitelist.simpleText();

    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);

    static {
        whitelist.addAttributes(":all", "style").addTags("p").addTags("strong");
        whitelist.preserveRelativeLinks(true);
    }

    public static String clean(String content) {
        return Jsoup.clean(content, "", whitelist, outputSettings);
    }

    public static void main(String[] args) {
        String text = "<a href=\"http://www.baidu.com/a\" onclick=\"alert(1);\"><strong><p>sss</p></strong></a><script>alert(0);</script>sss";
        System.out.println(clean(text));
    }
}
