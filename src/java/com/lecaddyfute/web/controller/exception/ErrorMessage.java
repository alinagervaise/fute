/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecaddyfute.web.controller.exception;

/**
 *
 * @author Nono Guy
 */
public class ErrorMessage {
    String errorId;
    String errorLabel;
    String errorMessage;

    public ErrorMessage(String errorId, String errorLabel, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.errorLabel = errorLabel;
    }

    
    
    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel = errorLabel;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
