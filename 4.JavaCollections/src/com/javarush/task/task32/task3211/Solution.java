package com.javarush.task.task32.task3211;


import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        md.reset();
        //md.digest(byteArrayOutputStream.toByteArray());

        BigInteger bigInteger = new BigInteger(1, md.digest(byteArrayOutputStream.toByteArray()));
        String result = bigInteger.toString(16);
        while( result.length() < 32 ){
            result = "0" + result;
        }
        return result.equals(md5);
    }
}
