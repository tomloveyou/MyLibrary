package com.cljz.mylibrary.listacitvityandfragment.util;

import android.Manifest;
import android.os.Environment;

import java.io.File;




/**
 * Created by lrc
 */

public class FileUtil {

    public static String PIC_DIR = "/makepassenger/pic/";

    /**
     * 创建文件夹
     *
     * @param dirName
     */

    public static void MakeDir(String dirName) {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            File destDir = new File(dirName);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
        } else {
            File destDir = new File(dirName);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
        }
    }

    /**
     * @param filePath 要删除文件或目录的路径。
     * @return 当且仅当成功删除文件或目录时，返回 true；否则返回 false。
     */

    public static boolean DeleteFile(String filePath) {
        File file = new File(filePath);
        if (file.listFiles() == null)
            return true;
        else {
            File[] files = file.listFiles();
            for (File deleteFile : files) {
                if (deleteFile.isDirectory())
                    DeleteAllFile(deleteFile);
                else
                    deleteFile.delete();
            }
        }
        return true;
    }

    /**
     * 删除全部文件
     *
     * @param file
     * @return
     */

    private static boolean DeleteAllFile(File file) {
        File[] files = file.listFiles();
        for (File deleteFile : files) {
            if (deleteFile.isDirectory()) {
                // 如果是文件夹，则递归删除下面的文件后再删除该文件夹
                if (!DeleteAllFile(deleteFile)) {
                    // 如果失败则返回
                    return false;
                }
            } else {
                if (!deleteFile.delete()) {
                    // 如果失败则返回
                    return false;
                }
            }
        }
        return file.delete();
    }
}