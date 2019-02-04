import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;
import storage.ArrayStorage;

public class SortedStorageTest extends AbstractStorageTest {

    public SortedStorageTest() {
        super(new ArrayStorage());
    }
    @Test
    public void saveOverFull() {
        for (int i = storage.size(); i < storage.getStorageLimit(); i++) {
            storage.save(new Resume());
        }
        try {
            storage.save(new Resume());
            Assert.fail();
        } catch (StorageException e) {
        }
    }
}