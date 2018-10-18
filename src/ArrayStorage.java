import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    //private static final int STORAGE_LIMIT = 3;
    //private Resume[] storage = new Resume[STORAGE_LIMIT];
    //private int size = 0;


    @Override
    protected void saveResume(Resume r, int index) {
        storage[size] = r;
        size++;
    }

    @Override
    protected void DeleteResume(int index) {
        storage[index] = storage[size - 1];
        size--;
        storage[size] = null;
    }

    protected int getIndexResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}
