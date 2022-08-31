package com.lady.lady;

import com.lady.lady.entry.MessageEntry;
import com.lady.lady.entry.UserEntry;
import com.lady.lady.util.SqlUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LadyApplication {

	public static Map<String, String> configMap;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LadyApplication.class, args);
		initConfig();
	}

	private static void initConfig() {
		configMap = new HashMap<>();
		configMap.put("versionCode", "1");
		configMap.put("downloadLink", "http://www.baidu.com");
		configMap.put("groupKey", "w2Tx75T8wlq9VipLsoE-JCkt8J8UVm_0");
	}

}
