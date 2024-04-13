package com.web.springbootweb.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ywz
 * @time: 2024/4/10 23:46
 */
@Slf4j
public class ExcelUtils {

    /**
     * 读取 excel 表格获取表格中文件信息
     * @param file excel 文件
     * @param clazz 表格中数据对应类的类型
     * @return list 集合
     * @param <T> 泛型
     */
    public static <T> List<T> readData(File file, Class<T> clazz) {
        long startTime = System.currentTimeMillis();
        List<T> rs = new ArrayList<>();
        try {
            EasyExcel.read(Files.newInputStream(file.toPath()), clazz, new ReadListener<T>() {
                @Override
                public void invoke(T t, AnalysisContext analysisContext) {
                    rs.add(t);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    log.debug("读取{}导入{}条耗时:{}", clazz.getSimpleName(), rs.size(), System.currentTimeMillis() - startTime);
                }
            }).sheet().doRead();
        } catch (IOException e) {
            log.error("Easy-excel读取数据失败，原因如下：");
            log.error(e.getMessage(), e);
        }
        return rs;
    }

    /**
     * 将要导出的数据导出到响应里，前端下载使用
     * @param dataList 需要导出数据列表
     * @param clazz 需要导出的数据所属的类
     * @param response httpServletResponse
     * @param fileName 要导出的文件名称
     * @param <T> 泛型
     */
    public static <T> void exportDataToResponse(List<T> dataList, Class<T> clazz, HttpServletResponse response, String fileName) {
        httpResponseSet(response, fileName);
        try {
            EasyExcel.write(response.getOutputStream(), clazz).sheet("Sheet1").doWrite(dataList);
        } catch (IOException e) {
            log.error("Easy-excel读取数据失败，原因如下：");
            log.error(e.getMessage(), e);

        }
    }

    /**
     * 将要导出的数据导出到指定文件里，
     * @param dataList 需要导出数据列表
     * @param clazz 需要导出的数据所属的类
     * @param filePath 数据文件所在路径
     * @param fileName 要导出的文件名称
     * @param <T> 泛型
     */
    public static <T> void exportDataToFile(List<T> dataList, Class<T> clazz, File filePath, String fileName) {

        try {
            EasyExcel.write(Files.newOutputStream(filePath.toPath()), clazz).sheet("Sheet1").doWrite(dataList);
        } catch (IOException e) {
            log.error("Easy-excel读取数据失败，原因如下：");
            log.error(e.getMessage(), e);
        }
    }




    public static void httpResponseSet(HttpServletResponse response, String fileName) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileNameEncoded = null;
        try {
            fileNameEncoded = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            log.error("unsupportedEncodingException");
        }
        response.setHeader("Content-disposition", "attachment;filename=" + fileNameEncoded + ".xlsx");
    }
}
