package com.example.util;

import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.jodconverter.office.OfficeUtils;

import java.io.File;

/**
 * word转pdf的demo
 *
 * @author lazy cat
 * @since 2019-12-27
 **/
public class WordToPdf {

    public static void main(String[] args) {

        //app路径
        final String appPath = "/Applications/LibreOffice.app/Contents";

        //文件路径
        final String source = "/Users/zhangzhenyan/work/zzy.doc";
        final String target = "/Users/zhangzhenyan/work/zzy.pdf";

        //文件对象
        File inputFile = new File(source);
        File outputFile = new File(target);

        //从本地建立连接
        OfficeManager officeManager = LocalOfficeManager.builder().officeHome(appPath).build();
        try {
            officeManager.start();
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
