package io.github.fairyspace.springbootdemo.beans.common;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import org.springframework.util.StringUtils;

import java.util.Scanner;

public class MySqlGenerator {
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/fairyspace?characterEncoding=utf8&useSSL=false&serverTimeZone=Asia/Shanghai";

    public static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_USERNAME = "stephenwish";
    public static final String DATABASE_PASSWORD = "stephenwish";
    public static final String OUT_PUT_PATH = "/Users/quanruxu/IdeaProjects/spring-boot-demo/src/main/java";
    public static final String TEMPLATES_MAPPER_XML_PATH = "/templates/mapper.xml.ftl";
    public static final String XML_PATH = "/Users/quanruxu/IdeaProjects/spring-boot-demo/src/main/resources/mapper/";
    public static final String XML_POSTFIX = "Mapper";
    public static final String AUTHOR = "xqr";
    public static final String PARENT_PACKAGE = "io.github.fairyspace.springbootdemo";
    public static final String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "update_time", "creator", "modifier"};


    public static String scaner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + OUT_PUT_PATH);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setServiceName("%sService%");
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);

    }
}
