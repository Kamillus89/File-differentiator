package com.recrutation.model;

public class FileModel {

    private String name;
    private byte[] bytes;
    private String extension;
    private boolean isExtensionValid = true;

    public FileModel(String name, byte[] bytes, String extension) {
        this.name = name;
        this.bytes = bytes;
        this.extension = extension;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getExtension() {
        return extension;
    }

    public boolean isExtensionValid() {
        return isExtensionValid;
    }

    public void setExtensionValid(boolean extensionValid) {
        isExtensionValid = extensionValid;
    }

    @Override
    public String toString() {
        if (isExtensionValid) {
            return "File name='" + name + '\'' +
                    ", extension='" + extension + '\'' +
                    " and this extension is correct ";
        }
        return "File name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                " and this extension is wrong or not supported! ";
    }
}
