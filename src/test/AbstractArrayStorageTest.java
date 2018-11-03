import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);


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
    public void saveOverFull() {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        try {
            storage.save(new Resume());
            Assert.fail();
        } catch (StorageException e) {
        }
    }

    @Test
    public void delete() {
        //Assert.assertEquals(3, storage.size());
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void update() {
        storage.update(RESUME_2);
        Assert.assertEquals(RESUME_2, storage.get(UUID_2));
        Assert.assertEquals(3, storage.size());
        //неуверен, по моему фигня получилась,
        //вообще как проверить класс который пока ничего толкового не делает
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
        Assert.assertEquals(new Resume(UUID_2), storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("beam");
        //storage.delete(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        //storage.get(UUID_1);
        storage.delete("beam");
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        //storage.get(UUID_1);
        storage.update(new Resume("beam"));
    }
}