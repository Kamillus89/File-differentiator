package com.recrutation.fileChecker;

import com.recrutation.model.FileModel;

public interface FileExtensionDifferentiate {

    String[] GIFMAGICNUMBER = new String[]{"[47, 49, 46, 38, 37, 61]","[47, 49, 46, 38, 39, 61]"};
    String[] JPGMAGICNUMBER = new String[]{"[ffffffff, ffffffd8, ffffffff]"};
    String[] PDFMAGICNUMBER = new String[]{"[25, 50, 44, 46, 2d]"};

    boolean isFileExtensionValid(FileModel fileModel) throws FileExtensionIsNotSupported;

    String findSuggestionOfExtension(FileModel fileModel);
}
