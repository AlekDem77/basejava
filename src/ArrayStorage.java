import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    int size = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            } else {
                storage[i] = null;
                size--;
            }
        }
    }

    void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Мест больше нет");
        } else if (PoiskResumeVMassive(r.uuid) != 01) {
            System.out.println("Есть такое уже");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r, Resume s) {
        if (PoiskResumeVMassive(r.uuid) == 01) {
            System.out.println("Нет такого че апдейтить то?");
        } else if (PoiskResumeVMassive(r.uuid) != 01) {
            storage[PoiskResumeVMassive(r.uuid)] = s;
        }
    }

    private int PoiskResumeVMassive(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return 01;
    }

    Resume get(String uuid) {
        if (PoiskResumeVMassive(uuid) == 01) {
            System.out.println("Такого резюме в базе нет");
            return null;
        } else if (PoiskResumeVMassive(uuid) != 01) {
            System.out.println("Место в массиве: " + PoiskResumeVMassive(uuid));
            return storage[PoiskResumeVMassive(uuid)];
        }
        return null;
    }

    void delete(String uuid) {
        if (PoiskResumeVMassive(uuid) == 01) {
            System.out.println("Такого резюме в базе нет");
        } else {
            size--;
            storage[PoiskResumeVMassive(uuid)] = storage[size];
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
}
