package org.article.dal;

public class DalException extends Exception{

    public DalException() {
    }

    public DalException(String message, Throwable cause) {
        super("Erreur DAL" + message, cause);
    }

    public DalException(String message) {
        super("Erreur DAL" + message);
    }


}
