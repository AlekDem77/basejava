import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
        System.out.println("Все обнулили");
    }

    void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Мест больше нет");
        } else if (getIndexResume(r.uuid) != 999999) {
            System.out.println("Есть такое уже");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r) {
        if (getIndexResume(r.uuid) == 999999) {
            System.out.println("Нет такого че апдейтить то?");
        } else {
            storage[getIndexResume(r.uuid)] = r;
        }
    }

    Resume get(String uuid) {
        if (getIndexResume(uuid) == 999999) {
            System.out.println("Такого резюме в базе нет");
            return null;
        } else {
            System.out.println("Место в массиве: " + getIndexResume(uuid));
            return storage[getIndexResume(uuid)];
        }
    }

    void delete(String uuid) {
        if (getIndexResume(uuid) == 999999) {
            System.out.println("Такого резюме в базе нет");
        } else {
            storage[getIndexResume(uuid)] = storage[size-1];
            size--;
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    private int getIndexResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return 999999;
    }
}
