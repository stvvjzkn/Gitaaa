package test;

import org.junit.Test;
import util.DBUtil;
import util.JdbcUtil;

public class TestDbutil{

    @Test
    public void test(){
        System.out.println(JdbcUtil.getConn());
    }
}
