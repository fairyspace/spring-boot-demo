package io.github.fairyspace.springbootdemo.beans.common;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.*;

public class MySqlGenerator {
    public static final String DATABASE_URL = "jdbc:mysql://192.168.5.44:3306/device_test?characterEncoding=utf8&useSSL=false&serverTimeZone=Asia/Shanghai";

    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "Root@2020";

    //Java 实体位置
    public static final String OUT_PUT_PATH = "\\src\\main\\java";
    public static final String TEMPLATES_MAPPER_XML_PATH = "/templates/mapper.xml.ftl";
    public static final String XML_PATH = "\\src\\main\\resources\\mapper\\";
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

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        //Java 实体位置
        gc.setOutputDir(projectPath + OUT_PUT_PATH);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATABASE_URL);
        dsc.setDriverName(DATABASE_DRIVER);
        dsc.setUsername(DATABASE_USERNAME);
        dsc.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dsc);


        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent(PARENT_PACKAGE);
        mpg.setPackageInfo(pc);


        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("parent", PARENT_PACKAGE);
                setMap(map);
            }
        };


        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(TEMPLATES_MAPPER_XML_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输入文件名称
                String s = projectPath + XML_PATH + tableInfo.getEntityName() + XML_POSTFIX + StringPool.DOT_XML;
                System.err.println(s);

                return s;
            }

        });

        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        strategy.setEntityLombokModel(true);
        strategy.setChainModel(true);
        strategy.setInclude(scaner("表名，多个用逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }
}
