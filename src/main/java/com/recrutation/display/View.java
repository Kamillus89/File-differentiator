package com.recrutation.display;

import com.recrutation.model.FileModel;

public class View {

    public void showProvideFilePathMessage() {
        System.out.println("Please provide correct file path to app parameters");
    }

    public void showFileInfo(FileModel fileModel) {
        System.out.println(fileModel);
    }

    public void showSuggestedExtension(String suggestionOfExtension) {
        System.out.println("Actual extension should be: " + suggestionOfExtension);
    }
}
