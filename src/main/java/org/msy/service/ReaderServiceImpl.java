package org.msy.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.msy.bean.Book;
import org.msy.bean.Reader;
import org.msy.mapper.ReaderMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author Msy
 * @date 2023/2/9  14:39
 */
public class ReaderServiceImpl implements ReaderService {
    private SqlSession session;
    private ReaderMapper mapper;

    {
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            session = sessionFactory.openSession();
            mapper = session.getMapper(ReaderMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Book> queryCourse() {
        return mapper.queryCourse();
    }

    @Override
    public int insertReader(Reader reader, String[] cids) {
        int i = 0;
        try {
            // 先修改读者
            mapper.insertReader(reader);
            // 再添加中间表
            for (String cid : cids) {
                mapper.insertBkRr(reader.getId(), cid);
            }
            session.commit();
            i = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 接口实现类可以重写 参数列表不同
     * @param reader
     * @return
     */
    @Override
    public int insertReader(Reader reader) {
        return 0;
    }

    @Override
    public Reader queryById(int id) {
        return mapper.queryById(id);
    }

    @Override
    public int update(Reader reader, String[] cids) {
        int i = 0;
        try {
            // 先修改读者
            mapper.updateReader(reader);
            // 再删除中间表
            deleteBkRrById(reader.getId() + "");
            // 再添加中间表
            for(String cid : cids){
                mapper.insertBkRr(reader.getId(),cid);
            }
            session.commit();
            i = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;

    }

    @Override
    public int delete(String id) {
        int i = 0;
        try {
            deleteBkRrById(id);
            mapper.delete(id);
            session.commit();

            i = 1;
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public List<Reader> queryAll(String mohu_name, String mohu_hobby) {
        return mapper.queryAll(mohu_name,mohu_hobby);
    }

    private void deleteBkRrById(String s) {
            mapper.deleteBkRrById(s);

    }
}
