package com.lady.lady.message;

import com.lady.lady.LadyApplication;
import com.lady.lady.entry.MessageEntry;
import com.lady.lady.util.SqlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
@Api(tags = "短信接口操作接口系列")
public class MessageController implements IMessageController{

    @Override
    @ApiOperation("获取短信接口列表")
    public String getMessageList() {
        ArrayList<MessageEntry> messageEntries = new ArrayList<>();
        try(Connection conn = SqlUtil.makeConnection()) {
            String sql = "select * from message";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MessageEntry messageEntry = new MessageEntry();
                messageEntry.setId(rs.getInt("id"));
                messageEntry.setUrl(rs.getString("url"));
                messageEntry.setEnable(rs.getInt("enable"));
                messageEntries.add(messageEntry);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String getVersionCode() {
        return LadyApplication.configMap.get("versionCode");
    }

    @Override
    public String getDownloadLink() {
        return LadyApplication.configMap.get("downloadLink");
    }

    @Override
    public String getGroupKey() {
        return LadyApplication.configMap.get("groupKey");
    }
}
