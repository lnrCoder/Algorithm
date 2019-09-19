package com.liang.other;

import com.sun.istack.internal.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ZipTools
 * @description zip 打包工具
 * @Author LiaNg
 * @Date 2019/9/19
 */
public class ZipTools {

    public static void main(String[] args) {
        System.out.println(zipFile("D:/ziptest/1", "D:/ziptest/test1.zip"));
    }

    public static String zipFile(@NotNull String filePath) {
        // 设置需要生成的 zip 包及路径
        String zipPath = "D:/ziptest/" + UUID.randomUUID() + ".zip";
        return zipFile(filePath, zipPath);
    }

    /**
     * 文件或文件夹打包到 zip 包
     *
     * @param filePath 文件路径或文件夹路径
     * @param zipPath 生成的 zip 包路径
     */
    public static String zipFile(@NotNull String filePath, String zipPath) {

        if (zipPath == null || "".equals(zipPath)) {
            zipFile(filePath);
        }

        File zipFile = new File(zipPath);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath));
            WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {

            File fileCheck = new File(filePath);
            if (fileCheck.isDirectory()) {
                for (File file : fileCheck.listFiles()) {
                    if(file.isFile()){
                        try (FileChannel fileChannel = new FileInputStream(file).getChannel()) {
                            zipOut.putNextEntry(new ZipEntry(file.getName()));
                            fileChannel.transferTo(0, fileChannel.size(), writableByteChannel);
                        }
                    }
                }
            } else {
                try (FileChannel fileChannel = new FileInputStream(filePath).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(fileCheck.getName()));
                    fileChannel.transferTo(0, fileChannel.size(), writableByteChannel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zipPath;
    }
}
