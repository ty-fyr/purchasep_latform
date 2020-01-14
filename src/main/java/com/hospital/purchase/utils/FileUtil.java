package com.hospital.purchase.utils;

import lombok.SneakyThrows;
import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 文件工具类
 */
public final class FileUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 输出CSV文件
     *
     * @param response    http响应
     * @param fileName    文件名
     * @param fileContent 文件内容
     * @return 输出结果
     */
    public static boolean outputCsvFile(HttpServletResponse response, String fileName, String fileContent) {
        response.reset();
        response.setCharacterEncoding( CharEncoding.UTF_8);
        response.setContentType("application/csv;charset=UTF-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, CharEncoding.UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(fileContent.getBytes());
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (IOException e) {
            LOG.warn("输出文件异常,文件名:{},expMsg:{}", fileName, e.getMessage(), e);
            return false;
        }
    }

    private FileUtil() {
    }
}
