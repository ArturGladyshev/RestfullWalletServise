package org.example.walletRESTapi.exception;

import lombok.Getter;

@Getter
public enum InputErrorType {

    ID_NOT_EXISTS("There is no wallet with this ID"),
    DATABASE_EMPTY("There are no wallets in the database"),
    BALANCE_ENOUGH("Insufficient funds"),
    ID_NOT_FOUND("The wallet was not found with this ID");

    private String message;

    InputErrorType(String message) {
        this.message = message;
    }
}

