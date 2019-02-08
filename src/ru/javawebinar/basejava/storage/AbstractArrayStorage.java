package src.ru.javawebinar.basejava.storage;

import src.ru.javawebinar.basejava.exception.StorageException;
import src.ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based src.ru.javawebinar.basejava.storage for Resumes
 */
public abstract class AbstractArrayStorage extends src.ru.javawebinar.basejava.storage.AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    @Override
    protected void doSaveResume(Resume r, Object findIndex) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Мест больше нет", r.getUuid());
        } else
            saveResume(r, (Integer) findIndex);
        size++;
    }


    @Override
    protected void doDeleteResume(Object findIndex) {
        deleteResume((Integer) findIndex);
        size--;
        storage[size] = null;
    }

    @Override
    protected void doUpdate(Resume r, Object getFindIndextoINT) {
        storage[(Integer) getFindIndextoINT] = r;
    }


    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    @Override
    protected Resume doGet(Object findIndex) {
        return storage[(Integer) findIndex];
    }

    protected abstract void saveResume(Resume r, int index);

    protected abstract void deleteResume(int index);


    @Override
    protected boolean isExist(Object findIndex) {
        return (Integer) findIndex >= 0;
    }

    public int getStorageLimit() {
        return STORAGE_LIMIT;
    }

}
