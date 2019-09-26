package ch04.mapper;

import ch04.pojo.TestFile;

public interface FileMapper {

    TestFile getFile(long id);
    void insertFile(TestFile content);

}
