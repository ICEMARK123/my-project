package com.wifi.test;

import com.wifi.comm.EnumType;

/**
 * @Author: lihl01
 * @Date: 2019/9/17 2:30 PM
 * @Describe:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        /*SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date fromDate1 = simpleFormat.parse("2018-03-01 12:00");
        Date toDate1 = simpleFormat.parse("2018-03-12 12:00");
        long from1 = fromDate1.getTime();
        long to1 = toDate1.getTime();
        int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
        System.out.println("两个时间之间的天数差为：" + days);
        String str = "2019-08-01 审核通过：图片不清晰";
        if(str.contains("审核不通过")){
            System.out.println("审核不通过");
        }
        else{
            System.out.println("审核通过");;
        }*/

        System.out.println(EnumType.type1.getType());
        System.out.println(EnumType.type1.getName());
    }
}
