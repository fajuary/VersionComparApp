package com.fajuary.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int num1=strToNumber("123a");

        Log.e("MainActivity","num1-->"+num1);
        //2.1 >1.1.1
       int comparNum= compareNumber("1.2.3a.1","1.2.4b");
        Log.e("MainActivity","comparNum-->"+comparNum);

    }

    /**
     *
     * @param numstr1
     * @param numstr2
     * @return
     *
     * 0表示numstr1=numstr2;
     * 1：表示numstr1>numstr2;
     * -:表示numstr1<numstr2;
     */
    private int compareNumber(String numstr1,String numstr2){
        if (numstr1.equals(numstr2)){
            return 0;
        }
        String[] numArray1=numstr1.split("\\.");
        String []numArray2=numstr2.split("\\.");


        int totalNum1=getTotalStrNum(numArray1);
        int totalNum2=getTotalStrNum(numArray2);
        if (totalNum1>totalNum2){
            return 1;
        }else {
            return -1;
        }
    }

    /**
     * 获取字符转换为大于48及以上的ASCII数总和
     * @param numArray
     * @return
     */
    private int getTotalStrNum(String[] numArray){
        int totalNum=0;
        int numlength=numArray.length;
        if (numlength==0){
            return totalNum;
        }

        for (int i=0;i<numlength;i++){
            String numStr=numArray[i];
            int numInt=strToNumber(numStr);
            totalNum+=numInt;
        }
        return totalNum;
    }

    /**
     * 将字符串ASCII转换成为10进制数字
     * 默认只处理48以及以上的ASCII表示的字母
     */
    private int strToNumber(String numStr){
        if (TextUtils.isEmpty(numStr)){
            //0
            return 0;
        }
        char []array=numStr.toCharArray();

        int arrayLength=array.length;
        int num=0;
        for (int i=0;i<arrayLength;i++){
            char itemchar=array[i];
            int charnum=0;
            if (itemchar>=48){
                /**
                 * 数字ASCII转换为正常数字
                 */
                charnum=array[i]-48;
            }
            num+=charnum*Math.pow(10,arrayLength-1-i);
        }
        return num;
    }

}
