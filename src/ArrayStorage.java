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
        } else if (look(r) == true) {
            System.out.println("Есть такое уже");
        } else {
            storage[size] = r;
            size = size + 1;
        }
    }

    public void update (Resume r, Resume s) {
        if (look(r) == false){
            System.out.println("Нет такого че апдейтить то?");
        }else if (look(r)== true){
            for(int i=0; i<size;i++){
                if (storage[i].uuid==r.uuid){
                    storage[i] = s;
                }
            }
        }
    }

    boolean look(Resume r) {
        for (int i = 0; i < size; i++) {
            if (size == 0) {
                return false;
            } else if (r.uuid == storage[i].uuid) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }


    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                System.out.println("Такого резюме в базе нет");
                return null;
            } else if (uuid.equals(storage[i].toString())) {
                System.out.println("место в массиве: " + i);
                System.out.print("Значение: ");
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                System.out.println("Такого резюме в базе нет");
                break;
            } else if (uuid.equals(storage[i].toString())) {
                size = size - 1;
                storage[i]= storage[size];
                break;
            }
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
