package io;

import java.io.*;

public class BufferedReaderWriterTest {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\readChinese.txt"), "GB2312"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\writeChinese.txt"), "GB2312"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
            bufferedWriter.write(str);
        }

    }

}
