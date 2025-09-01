package com.swaglabs.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {
    private FileUtils() {
        super();
    }

    //Retrieving the latest (most recently modified) file from a specified folder.
    public static File get_latest_file(String folderpath) {
        File folder = new File(folderpath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtils.warn("no files found in directory:" + folderpath);
            return null;

        }
        //Finding the latest modified file

        File latestfile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestfile.lastModified()) {
                latestfile = file;
            }
        }
        //Returning the latest modified file
        return latestfile;
    }

    //Calling the method and passing the folder path as file
    public static void deletefiles(File dirPath) {
        //Checking if the path exists or not if not the method finishes
        if (dirPath == null || !dirPath.exists()) {
            LogsUtils.warn("Directory doesn't exist" + dirPath);
            return;
        }

        File[] filesList = dirPath.listFiles();
        if (filesList == null) {
            LogsUtils.warn("failed to list filed in :" + dirPath);
            return;

        }
        for (File file : filesList) {
            if (file.isDirectory()) {
                deletefiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtils.warn("filed to delete file:" + file);
                }
            }
        }


    }

    public static void cleanDirectory(File file) {
        try {
            org.apache.commons.io.FileUtils.cleanDirectory(file);
        } catch (Exception e) {
            LogsUtils.error(e.getMessage());

        }

    }
}
