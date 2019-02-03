import model.Resume;
import storage.AbstractStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStorage extends AbstractStorage {

    Map<String, Resume> resumeMap = new HashMap<>();

    protected Resume doGet(Object findIndex) {

        return resumeMap.get(findIndex);
    }

    @Override
    protected String getFindIndex(String uuid) {
        Set<Map.Entry<String, Resume>> entrySet = resumeMap.entrySet();
        for (Map.Entry<String, Resume> setnotes : entrySet) {
            if (uuid.equals(setnotes.getValue().getUuid())) {
                return setnotes.getKey();
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object findIndex) {

        return resumeMap.containsKey(findIndex);
    }

    @Override
    protected void doUpdate(Resume r, Object findIndex) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doSaveResume(Resume r, Object findIndex) {
        resumeMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDeleteResume(Object findIndex) {
        resumeMap.remove(findIndex);
    }

    @Override
    public void clear() {
        resumeMap.clear();

    }

    @Override
    public Resume[] getAll() {

        return resumeMap.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return resumeMap.size();
    }

    @Override
    public int getStorageLimit() {
        return 0;
    }
}
