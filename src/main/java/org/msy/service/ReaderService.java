package org.msy.service;

import org.msy.bean.Book;
import org.msy.bean.Reader;

import java.util.List;

/**
 * @author Msy
 * @date 2023/2/9  14:38
 */
public interface ReaderService {

    List<Book> queryCourse();

    int insertReader(Reader reader, String[] cids);

    int insertReader(Reader reader);

    Reader queryById(int id);

    int update(Reader reader, String[] cids);

    int delete(String id);

    List<Reader> queryAll(String mohu_name, String mohu_hobby);
}
