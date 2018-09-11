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
        File file = new File(path);    //��ȡ�ļ�
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING);
        try {
            if (file.isFile() && file.exists()) {      //�ļ����Ƿ����
                set = new HashSet<String>();
                BufferedReader bufferedReader = new BufferedReader(read);
                String txt = null;
                while ((txt = bufferedReader.readLine()) != null) {    //��ȡ�ļ������ļ����ݷ��뵽set��
                    set.add(txt);
                }
            } else {         //�������׳��쳣��Ϣ
                throw new Exception("���дʿ��ļ�������");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            read.close();     //�ر��ļ���
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
