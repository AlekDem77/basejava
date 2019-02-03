package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {


    public void save(Resume r) {
        Object findIndex = getFindIndex(r.getUuid());
        if (isExist(findIndex)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            doSaveResume(r, findIndex);
        }
    }


    public void delete(String uuid) {
        Object findIndex = getFindIndex(uuid);
        if (!isExist(findIndex)) {
            throw new NotExistStorageException(uuid);
        } else {
            doDeleteResume(findIndex);
        }
    }

    public void update(Resume r) {
        Object findIndex = getFindIndex(r.getUuid());
        if (!isExist(findIndex)) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            doUpdate(r, findIndex);
        }
    }


    public Resume get(String uuid) {
        Object findIndex = getFindIndex(uuid);
        if (!isExist(findIndex)) {
            throw new NotExistStorageException(uuid);
        } else {
            return doGet(findIndex);
        }

    }

    protected abstract Resume doGet(Object findIndex);

    protected abstract Object getFindIndex(String uuid);

    protected abstract boolean isExist(Object findIndex);

    protected abstract void doUpdate(Resume r, Object findIndex);

    protected abstract void doSaveResume(Resume r, Object findIndex);

    protected abstract void doDeleteResume(Object findIndex);
}



