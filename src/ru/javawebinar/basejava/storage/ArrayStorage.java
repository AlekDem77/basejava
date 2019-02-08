package src.ru.javawebinar.basejava.storage;

import src.ru.javawebinar.basejava.model.Resume;

/**
 * Array based src.ru.javawebinar.basejava.storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    @Override
    protected void saveResume(Resume r, int index) {
        storage[size] = r;
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = storage[size - 1];
    }

    protected Integer getFindIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}
