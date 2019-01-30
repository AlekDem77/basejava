import exception.StorageException;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 3;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected void doSaveResume(Resume r, Object findIndex) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Мест больше нет", r.getUuid());
        } else
            saveResume(r, (Integer) findIndex);
        //storage[size] = r;
        size++;
    }


    @Override
    protected void doDeleteResume(Object findIndex) {
        deleteResume((Integer) findIndex);
        //storage[index] = storage[size-1];
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
        //System.out.println("Все обнулили");
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

}
