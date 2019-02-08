package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.storage.AbstractStorageTest;
import src.ru.javawebinar.basejava.exception.StorageException;
import src.ru.javawebinar.basejava.model.Resume;
import org.junit.Assert;
import org.junit.Test;
import src.ru.javawebinar.basejava.storage.ArrayStorage;

public class ArrayStorageTest extends AbstractStorageTest {

    public ArrayStorageTest() {
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
}
