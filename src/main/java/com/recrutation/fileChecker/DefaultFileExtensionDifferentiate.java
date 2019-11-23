package com.recrutation.fileChecker;

import com.recrutation.model.FileModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultFileExtensionDifferentiate implements FileExtensionDifferentiate {

    private Map<String, String[]> magicNumbers;

    public DefaultFileExtensionDifferentiate() {
        this.magicNumbers = new HashMap<>();
        this.magicNumbers.put("jpg", FileExtensionDifferentiate.JPGMAGICNUMBER);
        this.magicNumbers.put("gif", FileExtensionDifferentiate.GIFMAGICNUMBER);
    }

    @Override
    public boolean isFileExtensionValid(FileModel fileModel) {
        String extension = fileModel.getExtension();
        String hexValuesString = getHexValuesStringToCompare(fileModel, extension);
        for (String magicNumber : magicNumbers.get(extension)) {
            if (magicNumber.equals(hexValuesString)) {
                return true;
            }
        }

        return false;
    }

    private String getHexValuesStringToCompare(FileModel fileModel, String extension) {
        List<String> hexValues = new ArrayList<>();
        int bytesAmountLimit = getBytesAmountLimit(extension);
        int i = 0;
        while (hexValues.size() < bytesAmountLimit) {
            hexValues.add(Integer.toHexString(fileModel.getBytes()[i]));
            i++;
        }
        return hexValues.toString();
    }

    private int getBytesAmountLimit(String extension) {
        int bytesAmountLimit = 0;
        if (extension.equals("jpg")) {
            bytesAmountLimit = 3;
        }
        if (extension.equals("gif")) {
            bytesAmountLimit = 6;
        }
        return bytesAmountLimit;
    }


}
