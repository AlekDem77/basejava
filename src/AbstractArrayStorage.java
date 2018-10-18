import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 5;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void save(Resume r) {
        int index = getIndexResume(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("Мест больше нет");
        } else if (index > 0) {
            System.out.println("Есть такое уже");
        } else {
            saveResume(r, index);
            //storage[size] = r;
            //size++;
        }
    }


    public void delete(String uuid) {
        int index = getIndexResume(uuid);
        if (index == -1) {
            System.out.println("Такого резюме в базе нет");
        } else {
            DeleteResume(index);
            //storage[index] = storage[size-1];
            //size--;
            //storage[size] = null;
        }
    }


    public void update(Resume r) {
        int index = getIndexResume(r.getUuid());
        if (index == -1) {
            System.out.println("Нет такого че апдейтить то?");
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
        System.out.println("Все обнулили");
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    public Resume get(String uuid) {
        int index = getIndexResume(uuid);
        if (index == -1) {
            System.out.println("Такого резюме в базе нет");
            return null;
        } else {
            System.out.println("Место в массиве: " + index);
            return storage[index];
        }

    }

    protected abstract void saveResume(Resume r, int index);

    protected abstract void DeleteResume(int index);

    protected abstract int getIndexResume(String uuid);
}
