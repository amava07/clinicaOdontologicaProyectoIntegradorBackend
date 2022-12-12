package com.DH.demo.controller.exception;

public class Error {

    //Attributes

    private String errorClass;
    private String errorFeatures;

    //Constructor
    public Error( String errorClass, String errorFeatures){
        this.errorClass = errorClass;
        this.errorFeatures = errorFeatures;
    }

    //Setters - Getters


    public String getErrorClass() {
        return errorClass;
    }

    public void setErrorClass(String errorClass) {
        this.errorClass = errorClass;
    }

    public String getErrorFeatures() {
        return errorFeatures;
    }

    public void setErrorFeatures(String errorFeatures) {
        this.errorFeatures = errorFeatures;
    }
}
