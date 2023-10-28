package com.mgoportfolio2022api.mgoportfolio2022api.error;

public class AlbumPostErrorException extends RuntimeException{
    public AlbumPostErrorException(String message) {
        super(message);
    }

    public AlbumPostErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlbumPostErrorException(Throwable cause) {
        super(cause);
    }
}
