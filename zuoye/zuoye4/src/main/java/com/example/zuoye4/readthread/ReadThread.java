package com.example.zuoye4.readthread;
/*
 *@auther:谷建龙
 *@Date: 2020/1/22
 *@Time:17:26
 *@Description:
 * */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            FileInputStream fileInputStream=new FileInputStream("aa.txt");
            fileInputStream.read();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
