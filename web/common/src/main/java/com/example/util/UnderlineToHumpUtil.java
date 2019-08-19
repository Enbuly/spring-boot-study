package com.example.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 下划线转驼峰工具
 *
 * @author lazy cat
 * @since 2019-08-20
 * <p>
 * 使用说明：运行程序，复制黏贴需要转换的字符串至控制台，可多次复制黏贴。
 * 完成输入后做如下操作。1、回车。2、输出ok。3、回车 4、转换后的字符串已经打印到
 * 控制台，程序结束。
 **/
public class UnderlineToHumpUtil {
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static void main(String[] args) {
        StringBuilder total = new StringBuilder();
        boolean firstLine = true;
        System.out.println("请输出需要下划线转驼峰的字符串：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            if (firstLine) {
                total.append("\n");
                firstLine = false;
            }
            String line = scanner.nextLine();
            total.append(lineToHump(line));
            total.append("\n");
            if (line.equals("ok")) {
                total.delete(total.length() - 3, total.length() - 1);
                break;
            }
        }
        System.out.println(total);
    }

    private static String lineToHump(String str) {
        Matcher matcher = linePattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
