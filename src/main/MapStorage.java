import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

        Map <String, Resume> resumeMap = new HashMap<>();

    protected Resume doGet(Object findIndex) {

        return resumeMap.get(findIndex);
    }

    @Override
    protected Integer getFindIndex(String uuid) {

       return  null;
    }

    @Override
    protected boolean isExist(Object findIndex) {

        return findIndex != null;
    }

    @Override
    protected void doUpdate(Resume r, Object findIndex) {
            resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doSaveResume(Resume r, Object findIndex) {
        resumeMap.put(r.getUuid(),r);
    }

    @Override
    protected void doDeleteResume(Object findIndex) {
        resumeMap.remove(findIndex);
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {

        return 0;
    }
}
