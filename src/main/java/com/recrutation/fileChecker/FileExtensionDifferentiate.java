package com.recrutation.fileChecker;

import com.recrutation.model.FileModel;

public interface FileExtensionDifferentiate {

    String[] GIFMAGICNUMBER = new String[]{"[47, 49, 46, 38, 37, 61]","[47, 49, 46, 38, 39, 61]"};
    String[] JPGMAGICNUMBER = new String[]{"[ffffffff, ffffffd8, ffffffff]"};

    boolean isFileExtensionValid(FileModel fileModel) throws FileExtensionIsNotSupported;
}
