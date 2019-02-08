package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import src.ru.javawebinar.basejava.exception.StorageException;
import src.ru.javawebinar.basejava.model.Resume;
import src.ru.javawebinar.basejava.storage.ArrayStorage;

public class SortedStorageTest extends ru.javawebinar.basejava.storage.AbstractStorageTest {

    public SortedStorageTest() {
        super(new ArrayStorage());
    }
    @Test
    public void saveOverFull() {
        for (int i = storage.size(); i < storage.getStorageLimit(); i++) {
            storage.save(new Resume(i + "Name"));
        }
        try {
            storage.save(new Resume("OverFull"));
            Assert.fail();
        } catch (StorageException e) {
        }
    }

    public static class MapStorageTest extends ru.javawebinar.basejava.storage.AbstractStorageTest {

        public MapStorageTest() {
            super(new src.ru.javawebinar.basejava.storage.MapStorage());
        }
    }
}