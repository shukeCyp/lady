package com.lady.lady.message;

import com.lady.lady.entry.MessageEntry;
import com.lady.lady.entry.UserEntry;
import com.lady.lady.util.SqlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@Api(tags = "用户系统")
public class User implements IUser{

    @Override
    @ApiOperation("注册")
    public String register(String username, String password) {
        try(Connection conn = SqlUtil.makeConnection()) {
            String sql = "select * from user where username=" + username ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "0";
            } else {
                char[] chars = String.valueOf(new Date().getTime()).toCharArray();
                StringBuffer sb = new StringBuffer();
                for (int i = 5; i <= 12; i++) {
                    sb.append(chars[i]);
                }
                String insertSql = String.format("INSERT INTO `user` (`id`, `username`, `password`) VALUES ('%s', '%s', '%s');", sb.toString(), username
                        , password);
                PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
                boolean execute = preparedStatement.execute(insertSql);
                return sb.toString();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @ApiOperation("登录")
    public String login(String username, String password) {
        try(Connection conn = SqlUtil.makeConnection()) {
            String sql = "select * from user where username=" + username ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                    return rs.getString("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "0";
    }

}
