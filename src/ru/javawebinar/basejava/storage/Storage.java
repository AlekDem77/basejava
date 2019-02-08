package src.ru.javawebinar.basejava.storage;

import src.ru.javawebinar.basejava.model.Resume;

/**
 * Array based src.ru.javawebinar.basejava.storage for Resumes
 */
public interface Storage {
    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in src.ru.javawebinar.basejava.storage (without null)
     */
    Resume[] getAll();

    int size();

    int getStorageLimit();
}