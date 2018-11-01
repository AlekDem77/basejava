package exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("У нас уже имеется подобное", uuid);
    }

}
