package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class CodeGeneration {

    /**
     * 代码生成器
     * @param args
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
 
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E://2work");//输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("yifenrui");// 作者
 
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);
 
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/pay_region_db?autoReconnect=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC");
        mpg.setDataSource(dsc);
 
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
       // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);
 
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.demo");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setEntity("model");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);
 
        // 执行生成
        mpg.execute();
 
    }


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入444" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
 
}