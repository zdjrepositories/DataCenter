package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;

public class SQLSession {
    static InputStream is;
    static SqlSessionFactory factory;
    private  SqlSession session;
    public SqlSession getSqlsession() throws IOException {
        if (is==null||factory==null || session==null) {
            is = Resources.getResourceAsStream("mybatis");
            factory = new SqlSessionFactoryBuilder().build(is);
            session = factory.openSession();
        }
        return session;
    }
}
