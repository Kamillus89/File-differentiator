package com.recrutation.fileChecker;

import com.recrutation.model.FileModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultFileExtensionDifferentiate implements FileExtensionDifferentiate {

    private Map<String, String[]> magicNumbers;
    private Map<String, Integer> bytesAmountLimitMap;

    public DefaultFileExtensionDifferentiate() {
        this.magicNumbers = new HashMap<>();
        this.magicNumbers.put("jpg", FileExtensionDifferentiate.JPGMAGICNUMBER);
        this.magicNumbers.put("gif", FileExtensionDifferentiate.GIFMAGICNUMBER);
        this.magicNumbers.put("pdf", FileExtensionDifferentiate.PDFMAGICNUMBER);

        this.bytesAmountLimitMap = new HashMap<>();
        this.bytesAmountLimitMap.put("jpg", 3);
        this.bytesAmountLimitMap.put("gif", 6);
        this.bytesAmountLimitMap.put("pdf", 5);
    }

    @Override
    public boolean isFileExtensionValid(FileModel fileModel) throws FileExtensionIsNotSupported {
        String extension = fileModel.getExtension();
        if (isExtensionNotTxtAndNotInMagicNumberKeys(extension)) {
            throw new FileExtensionIsNotSupported(extension + " extension is not supported");
        }
        if (extension.equals("txt")) {
            return !checkIfFileIsNotOtherSupportedExtension(fileModel);
        }
        String hexValuesString = getHexValuesStringToCompare(fileModel, extension);
        for (String magicNumber : magicNumbers.get(extension)) {
            if (magicNumber.equals(hexValuesString)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfFileIsNotOtherSupportedExtension(FileModel fileModel) {
        String hexValueString;
        for (String key : magicNumbers.keySet()) {
            hexValueString = getHexValuesStringToCompare(fileModel, key);
            if (searchForAnyMatch(hexValueString)) return true;
        }
        return false;
    }

    private boolean searchForAnyMatch(String hexValueString) {
        for (String[] arr : magicNumbers.values()) {
            for (String magicNumber : arr) {
                if (hexValueString.equals(magicNumber)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isExtensionNotTxtAndNotInMagicNumberKeys(String extension) {
        return !extension.equals("txt") && !magicNumbers.keySet().contains(extension);
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
        return bytesAmountLimitMap.get(extension);

    }


}
