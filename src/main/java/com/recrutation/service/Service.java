package com.recrutation.service;

import com.recrutation.display.View;
import com.recrutation.fileChecker.DefaultFileExtensionDifferentiate;
import com.recrutation.fileChecker.FileExtensionDifferentiate;
import com.recrutation.fileChecker.FileExtensionIsNotSupported;
import com.recrutation.model.FileModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private String[] filePaths;
    private View view = new View();
    List<FileModel> files = new ArrayList<>();

    public Service(String[] filePaths) {
        this.filePaths = filePaths;
        getDataOfAllFiles();
        checkFileExtension();
        showFileInformation();
    }

    public void getDataOfAllFiles() {
        Path path;
        for (String filePath : filePaths) {
            try {
                path = Paths.get(filePath);
                String fileModelName = path.getFileName().toString();
                String extension = fileModelName.substring(fileModelName.indexOf('.')+1);
                byte[] bytes = Files.readAllBytes(path);
                files.add(new FileModel(fileModelName, bytes, extension));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkFileExtension() {
        FileExtensionDifferentiate extensionDifferentiate = new DefaultFileExtensionDifferentiate();
        for (FileModel fileModel: files) {
            boolean isFileExtensionCorrect = false;
            try {
                isFileExtensionCorrect = extensionDifferentiate.isFileExtensionValid(fileModel);
            } catch (FileExtensionIsNotSupported fileExtensionIsNotSupported) {
                fileExtensionIsNotSupported.printStackTrace();
            }
            fileModel.setExtensionValid(isFileExtensionCorrect);
        }
    }

    public void showFileInformation() {
        files.forEach(fileModel -> view.showFileInfo(fileModel));
    }

}
