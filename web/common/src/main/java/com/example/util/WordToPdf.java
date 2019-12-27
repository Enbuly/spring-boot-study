package com.example.util;

import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.jodconverter.office.OfficeUtils;

import java.io.File;

/**
 * word转pdf工具类
 *
 * @author lazy cat
 * @since 2019-12-27
 **/
public class WordToPdf {

    public static void main(String[] args) {

        //app路径
        String appPath = "/Applications/LibreOffice.app/Contents";

        String source = "/Users/zhangzhenyan/work/zzy.doc";
        String target = "/Users/zhangzhenyan/work/zzy.pdf";
        File inputFile = new File(source);
        File outputFile = new File(target);

        //从本地建立连接
        OfficeManager officeManager = LocalOfficeManager.builder().officeHome(appPath).build();
        try {
            officeManager.start();
            //转换
            LocalConverter.builder()
                    .officeManager(officeManager)
                    .build()
                    .convert(inputFile)
                    .to(outputFile)
                    .execute();
        } catch (OfficeException e) {
            System.out.println(e.getMessage());
        } finally {
            OfficeUtils.stopQuietly(officeManager);
        }
    }
}
