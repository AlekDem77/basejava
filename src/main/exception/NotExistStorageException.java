package exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("такого резюме в базе нет", uuid);
    }
}
