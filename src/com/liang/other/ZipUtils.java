package com.liang.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName ZipUtils
 * @description
 * @Author LiaNg
 * @Date 2019/9/19
 */
public class ZipUtils {

    private static String FILE_PATH = "D:/ziptest/4/aaa.png";

    private final static Integer TEMP_SIZE = 2048;

    public static void main(String[] args) {
        zipFileNoBuffer();
        zipFileBuffer();
        zipFileChannel();
    }

    public static void zipFileNoBuffer() {
        //开始时间
        long beginTime = System.currentTimeMillis();

        String ZIP_FILE = "D:/ziptest/TestNoBuffer.zip";

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (int i = 0; i < 5; i++) {
                try (InputStream input = new FileInputStream(FILE_PATH)) {
                    zipOut.putNextEntry(new ZipEntry("aaa" + i));
                    int temp = 0;
                    while ((temp = input.read()) != -1) {
                        zipOut.write(temp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("============ zipFileNoBuffer ==============");
            printTime(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipFileBuffer() {
        //开始时间
        long beginTime = System.currentTimeMillis();

        String ZIP_FILE = "D:/ziptest/TestBuffer.zip";

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOut)) {
            for (int i = 0; i < 5; i++) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                        new FileInputStream(FILE_PATH))) {
                    zipOut.putNextEntry(new ZipEntry("aaa" + i));
                    int temp = 0;
                    while ((temp = bufferedInputStream.read()) != -1) {
                        bufferedOutputStream.write(temp);
                    }
                }
            }
            System.out.println("============ zipFileBuffer ==============");
            printTime(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipFileChannel() {
        //开始时间
        long beginTime = System.currentTimeMillis();

        String ZIP_FILE = "D:/ziptest/TestChannel.zip";

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
                WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 5; i++) {
                try (FileChannel fileChannel = new FileInputStream(FILE_PATH).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry("aaa" + i));
                    fileChannel.transferTo(0, fileChannel.size(), writableByteChannel);
                }
            }
            System.out.println("============ zipFileChannel ==============");
            printTime(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipFileMap() {
        //开始时间
        long beginTime = System.currentTimeMillis();

        String ZIP_FILE = "D:/ziptest/TestMap.zip";

        File zipFile = new File(ZIP_FILE);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
                WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            for (int i = 0; i < 5; i++) {
                zipOut.putNextEntry(new ZipEntry("aaa"+i));

                //内存中的映射文件
                MappedByteBuffer mappedByteBuffer = new RandomAccessFile(FILE_PATH, "r").getChannel()
                        .map(FileChannel.MapMode.READ_ONLY, 0, new File(FILE_PATH).length());

                writableByteChannel.write(mappedByteBuffer);
            }
            System.out.println("============ zipFileMap ==============");
            printTime(beginTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printTime(long beginTime ){
        System.out.println("耗时："+(System.currentTimeMillis() - beginTime));
    }
}
