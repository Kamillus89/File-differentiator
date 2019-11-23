package com.recrutation.service;

import com.recrutation.fileChecker.DefaultFileExtensionDifferentiate;
import com.recrutation.fileChecker.FileExtensionDifferentiate;

public class Service {

    private String[] filePaths;
    private FileExtensionDifferentiate extensionDifferentiate = new DefaultFileExtensionDifferentiate();

    public Service(String[] filePaths) {
        this.filePaths = filePaths;
    }


}
