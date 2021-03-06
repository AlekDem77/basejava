package ru.javawebinar.basejava.storage;

import src.ru.javawebinar.basejava.exception.ExistStorageException;
import src.ru.javawebinar.basejava.exception.NotExistStorageException;
import src.ru.javawebinar.basejava.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.ru.javawebinar.basejava.storage.Storage;

public abstract class AbstractStorageTest {
    protected Storage storage;


    private static final String UUID_1 = "Первое";
    private static final String UUID_2 = "Второе";
    private static final String UUID_3 = "Третье";
    private static final String UUID_4 = "Четвертое";

    private static final Resume RESUME_1 = new Resume(UUID_1, "Первое");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Второе");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Третье");
    private static final Resume RESUME_4 = new Resume(UUID_4, "Четвертое");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @After
    public void setDown() throws Exception {
        storage.clear();
    }

    @Test(expected = ExistStorageException.class)
    public void existStorage() {
        storage.save(RESUME_1);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(RESUME_4, storage.get(UUID_4));

    }

    @Test
    public void delete() {
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void update() {
        Resume testResume = new Resume(UUID_2);
        storage.update(testResume);
        Assert.assertEquals(testResume, storage.get(UUID_2));
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] resume = storage.getAll();
        Assert.assertEquals(RESUME_1, resume[0]);
        Assert.assertEquals(RESUME_2, resume[1]);
        Assert.assertEquals(RESUME_3, resume[2]);
    }

    @Test
    public void get() {
        Assert.assertEquals(RESUME_2, storage.get(UUID_2));
    }


    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("beam");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume("beam"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("beam");
    }

}