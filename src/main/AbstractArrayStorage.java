import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void save(Resume r) {
        int index = getIndexResume(r.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Мест больше нет", r.getUuid());
        } else if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r, index);
            //storage[size] = r;
            size++;
        }
    }


    public void delete(String uuid) {
        int index = getIndexResume(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(index);
            //storage[index] = storage[size-1];
            size--;
            storage[size] = null;
        }
    }


    public void update(Resume r) {
        int index = getIndexResume(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid()); //System.out.println("Нет такого че апдейтить то?");
        } else {
            storage[index] = r;
        }
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


    public Resume get(String uuid) {
        int index = getIndexResume(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            //System.out.println(index);
            return storage[index];
        }

    }

    protected abstract void saveResume(Resume r, int index);

    protected abstract void deleteResume(int index);

    protected abstract int getIndexResume(String uuid);
}
