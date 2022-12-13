package org.java.labs.lab8;

public class IndexNotExistsException extends RuntimeException {
    public IndexNotExistsException() {
        super();
    }
    public IndexNotExistsException(int index, int size) {
        super(String.format("Index %d not exist, list size is %d", index, size));
    }
    public IndexNotExistsException(Throwable cause) {
        super(cause);
    }
}
