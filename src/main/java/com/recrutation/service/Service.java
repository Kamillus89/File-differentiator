package com.recrutation.service;

import com.recrutation.display.View;
import com.recrutation.fileChecker.DefaultFileExtensionDifferentiate;
import com.recrutation.fileChecker.FileExtensionDifferentiate;
import com.recrutation.model.FileModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Service {

    private String[] filePaths;
    private FileExtensionDifferentiate extensionDifferentiate = new DefaultFileExtensionDifferentiate();
    View view = new View();
    Map<String, FileModel> files = new HashMap<>();

    public Service(String[] filePaths) {
        this.filePaths = filePaths;
    }

    public void readBytesOfAllFiles() {
        Path path;
        for (String filePath : filePaths) {
            try {
                path = Paths.get(filePath);
                String fileModelName = path.getFileName().toString();
                files.put(fileModelName, new FileModel(fileModelName,Files.readAllBytes(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
