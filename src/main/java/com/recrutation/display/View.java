package com.recrutation.display;

import com.recrutation.model.FileModel;

public class View {

    public void showProvideFilePathMessage() {
        System.out.println("Please provide file path");
    }

    public void showFileInfo(FileModel fileModel) {
        System.out.println(fileModel);
    }
}
