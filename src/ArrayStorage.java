import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        System.out.println("Все обнулили");
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                continue;
            } else {
                storage[i] = r;
                size = size + 1;
                //System.out.println(storage[i]);
                break;
            }
        }
    }

    Resume get(String uuid) {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                System.out.println("Такого резюме в базе нет");
                break;
            } else if (uuid.equals(storage[i].toString())) {
                System.out.println("место в массиве: " + i);
                System.out.print("Значение: ");
                return storage[i];
            }
        }
        return storage[i];
    }

    void delete(String uuid) {
        int i;
        for (i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                System.out.println("Такого резюме в базе нет");
                break;
            } else if (uuid.equals(storage[i].toString())) {
                storage[i] = null;
                size = size - 1;
                int u = size;
                storage[i] = storage[u];
                break;
            }
        }
       /* for (int j = 0; j < storage.length; j++) {
            if (storage[j] == null) {
                for (int k = j + 1; k < storage.length; k++) {
                    storage[k - 1] = storage[k];
                }
            }
        }*/
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
