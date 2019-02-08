package src.ru.javawebinar.basejava.storage;

import src.ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Resume doGet(Object findIndex) {
        return list.get((Integer) findIndex);
    }

    @Override
    protected Integer getFindIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object findIndex) {
        return findIndex != null;
    }

    @Override
    protected void doUpdate(Resume r, Object findIndex) {
        list.set((Integer) findIndex, r);
    }

    @Override
    protected void doSaveResume(Resume r, Object findIndex) {
        list.add(r);
    }

    @Override
    protected void doDeleteResume(Object findIndex) {
        list.remove(((Integer) findIndex).intValue());
    }

    @Override
    public void clear() {
        list.clear();

    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public int getStorageLimit() {
        return 0;
    }
}
