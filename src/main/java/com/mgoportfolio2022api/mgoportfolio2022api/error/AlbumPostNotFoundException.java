package com.mgoportfolio2022api.mgoportfolio2022api.error;

public class AlbumPostNotFoundException extends RuntimeException{
    public AlbumPostNotFoundException(String message) {
        super(message);
    }

    public AlbumPostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlbumPostNotFoundException(Throwable cause) {
        super(cause);
    }
}
