package com.lady.lady.message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
@RestController
@Api(tags = "用户系统")
public class User implements IUser{

    @Override
    @ApiOperation("注册")
    public String register(String username, String password) {
        File file = new File("/home/lighthou/user.txt");
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            for (String string : strings) {
                String[] split = string.split("@");
                if (username.equals(split[0]) && password.equals(split[1])){
                    return "0";
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String time = String.valueOf(new Date().getTime());
        char[] chars = time.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 5; i <= 12; i++) {
            sb.append(chars[i]);
        }
        String txt = username+"@"+password+"@"+sb.toString();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(txt.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    @Override
    @ApiOperation("登录")
    public String login(String username, String password) {
        File file = new File("/home/lighthou/user.txt");
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            for (String string : strings) {
                String[] split = string.split("@");
                if (username.equals(split[0]) && password.equals(split[1])){
                    return split[2];
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "0";
    }

}
