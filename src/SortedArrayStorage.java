import java.lang.reflect.Array;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    protected void saveResume(Resume r, int index) {
        int indexInsert = -index-1;
        System.arraycopy(storage, indexInsert, storage, indexInsert + 1, size-indexInsert);
        storage[indexInsert] = r;
        size++;
    }

    @Override
    protected void DeleteResume(int index) {
        System.arraycopy(storage,index+1, storage, index, size- index-1);
        size--;
        storage[size] = null;
    }

    @Override
    protected int getIndexResume(String uuid) {
        Resume serchKey = new Resume();
        serchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, serchKey );
    }


}
