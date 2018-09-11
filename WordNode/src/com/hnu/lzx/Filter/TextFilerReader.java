package com.hnu.lzx.Filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TextFilerReader {
    private String ENCODING = "GBK";

    public StringBuilder textReader(String path) throws Exception {
        Set<String> set = null;
        File file = new File(path);    //读取文件
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING);
        try {
            if (file.isFile() && file.exists()) {      //文件流是否存在
                set = new HashSet<String>();
                BufferedReader bufferedReader = new BufferedReader(read);
                String txt = null;
                while ((txt = bufferedReader.readLine()) != null) {    //读取文件，将文件内容放入到set中
                    set.add(txt);
                }
            } else {         //不存在抛出异常信息
                throw new Exception("敏感词库文件不存在");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            read.close();     //关闭文件流
        }
        Iterator<String> iterator = set.iterator();
        StringBuilder txt1 = new StringBuilder();
        while (iterator.hasNext()) {
            String s=iterator.next();
            txt1.append(s + "/r/n");
        }
        return txt1;
    }
}
