import exception.ExistStorageException;
import exception.NotExistStorageException;

public abstract class AbstractStorage implements Storage {


    public void save(Resume r) {
        Object findIndex = getFindIndex(r.getUuid());
        if (isExist(findIndex)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            doSaveResume (r, findIndex);
            //storage[size] = r
        }
    }


    public void delete(String uuid) {
        Object findIndex = getFindIndex(uuid);
        if (!isExist(findIndex)) {
            throw new NotExistStorageException(uuid); //System.out.println("Нет такого че апдейтить то?");
        } else {
            doDeleteResume(findIndex);
            //storage[index] = storage[size-1];

        }
    }

    public void update(Resume r) {
        Object findIndex = getFindIndex(r.getUuid());
        if (!isExist(findIndex)) {
            throw new NotExistStorageException(r.getUuid()); //System.out.println("Нет такого че апдейтить то?");
        } else {
            doUpdate(r, findIndex);
        }
    }


    public Resume get(String uuid) {
        Object findIndex = getFindIndex(uuid);
        if (!isExist(findIndex)) {
            throw new NotExistStorageException(uuid); //System.out.println("Нет такого че апдейтить то?");
        } else {
            //System.out.println(index);
             return  doGet (findIndex);
        }

    }

    protected abstract Resume doGet(Object findIndex);

    protected abstract Integer getFindIndex(String uuid);

    protected abstract boolean isExist(Object findIndex);

    protected abstract void doUpdate(Resume r, Object findIndex);

    protected abstract void doSaveResume(Resume r, Object findIndex);

    protected abstract void doDeleteResume(Object findIndex);
}



