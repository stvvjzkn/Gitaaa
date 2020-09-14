package service;

import entity.Userinfo;
import util.JdbcUtil;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public UserService() {

        conn = JdbcUtil.getConn();
    }

    public boolean login(String user_id,String user_psw){
     String sql="select * from user where user_id=? and user_psw=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ps.setString(2,user_psw);
            rs=ps.executeQuery();
            if(rs.next()){
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  false;
    }
    public boolean login1(String admin_id,String admin_psw){
     String sql="select * from admin where admin_id=? and admin_psw=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,admin_id);
            ps.setString(2,admin_psw);
            rs=ps.executeQuery();
            if(rs.next()){
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  false;
    }
    public List<Userinfo> getUsers(){
     String selectall="select * from user"  ;
     List<Userinfo>userinfos=new ArrayList<>();
        try {
            ps=conn.prepareStatement(selectall);
            rs=ps.executeQuery();
            while(rs.next()){
                Userinfo user=new Userinfo();
//                user.setId(rs.getInt("id"));
//                user.setUsername(rs.getString("name"));
//                user.setEmail(rs.getString("email"));
//                user.setSex(rs.getString("sex"));
//                user.setArea(rs.getString("area"));
//                user.setInfo(rs.getString("info"));
                user.setId(rs.getInt("user_id"));
                user.setId(rs.getInt("user_psw"));
                userinfos.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

      return  userinfos;
    }
    public Userinfo findById(String user_id){
        String select="select * from user where user_id=?";
        Userinfo userinfo=null;
        try {
            ps=conn.prepareStatement(select);
            ps.setString(1,user_id);
            rs= ps.executeQuery();
           if(rs.next()){
               userinfo=new Userinfo();
               userinfo.setUser_id(rs.getString("user_id"));
               userinfo.setUser_psw(rs.getString("user_psw"));
               //需要显示的数据，全部要设置

           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return  userinfo;
    }

    public int update(){
        return 0;
    }

    public int register(Userinfo userinfo) {
        int result = 0;
        //完成注册
        String insert = "insert into user(name,email,sex,area,info,password) values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(insert);
            //设置参数
            ps.setString(1, userinfo.getUsername());
            ps.setString(2, userinfo.getEmail());
            ps.setString(3, userinfo.getSex());
            ps.setString(4, userinfo.getArea());
            ps.setString(5, userinfo.getInfo());
            ps.setString(6,userinfo.getPassword());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
