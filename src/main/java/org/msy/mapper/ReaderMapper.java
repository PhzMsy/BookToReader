package org.msy.mapper;

import org.apache.ibatis.annotations.Param;
import org.msy.bean.Book;
import org.msy.bean.Reader;

import java.util.List;

/**
 * @author Msy
 * @date 2023/2/9  14:27
 */
public interface ReaderMapper {
    List<Reader> queryAll();

    List<Book> queryCourse();


    void insertReader(Reader reader);

    void insertBkRr(@Param("sid") Integer id, @Param("cid") String cids);

    Reader queryById(int id);

    void deleteBkRrById(String s);

    void updateReader(Reader reader);

    void delete(String id);
}
