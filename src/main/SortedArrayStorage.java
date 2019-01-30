import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    protected void saveResume(Resume r, int index) {
        int indexInsert = -index - 1;
        System.arraycopy(storage, indexInsert, storage, indexInsert + 1, size - indexInsert);
        storage[indexInsert] = r;
    }

    @Override
    protected void deleteResume(int index) {

        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected Integer getFindIndex(String uuid) {
        Resume serchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, serchKey);
    }


}
