package com.hanyi.daily.load;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;

/**
 * @PackAge: middleground com.hanyi.daily.load
 * @Author: weiwenchang
 * @Description: java类作用描述
 * @CreateDate: 2020-03-01 10:55
 * @Version: 1.0
 */
public class LoaderTest {

    /**
     * 读取本地json文件，Linux环境会报错，找不到文件路径
     */
    @Test
    public void readJSONFile(){

        Object o = System.getProperties().get("os.name");
        System.out.println(o);

        String pathname = this.getClass().getClassLoader().getResource("static/json/appType.json").getPath();
        System.out.println(pathname);
        File file = new File(pathname);
        JSONObject jsonObject = JSONUtil.readJSONObject(file, Charset.defaultCharset());
        System.out.println(jsonObject);

    }

    /**
     * 获取所有的系统属性
     */
    @Test
    public void systemPropertiesTest() {
        System.getProperties().list(System.out);
    }

}