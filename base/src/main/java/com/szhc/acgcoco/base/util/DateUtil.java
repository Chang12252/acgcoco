package com.szhc.acgcoco.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static Date getEndTime(Date startTime,int num){
        Calendar instance = Calendar.getInstance();
        instance.setTime(startTime);
        instance.add(Calendar.DATE,num);
        return instance.getTime();
    }

    public static String simpDateStr(String text,Date time){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(text);
       return  simpleDateFormat.format(time);
    }

    public static void main(String[] args){
        /*Date endTime = getEndTime(new Date(), 2);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(endTime));

        strToDate("1999-04-23 16:00:00","yyyy-MM-dd HH:mm:ss");

        System.out.println("getTime-----------"+getTime());
        System.out.println("simpDateStr-----------"+simpDateStr("yyyy-MM-dd",getTime()));
        dateToStamp("1999-04-23 16:00:00");*/

        /*String currDateStr= DateUtil.simpDateStr("yyyy-MM-dd",DateUtil.getTime());
        System.out.println("当前时间:--"+currDateStr);
        System.out.println(strToDate(currDateStr,"yyyy-MM-dd"));
        */
        /*System.out.println("当前日期的下一天------"+nextDay("2020/5/31"));
        System.out.println("strToDate------"+strToDate("2020/5/26 00:00:00","yyyy/MM/dd HH:mm:ss"));
        System.out.println("------"+nextDay("2020/2/4"));
        System.out.println("aaaa------"+getTime());*/
        /*for (int i=0;i<12;i++){
            System.out.println("aaaa------"+getDateYearMonth(i));
        }*/
        System.out.println(getFormatDate(new Date()));
    }

    //获取当前日期的年份
    public static String getCurrentYear(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        return sdf.format(date);
    }
    //String转换为Date
    public static Date strToDate(String dateStr,String format){
        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        DateFormat sf = new SimpleDateFormat(format);
        Date date=new Date();
        try {
            //使用SimpleDateFormat的parse()方法生成Date
            date = sf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    //获取系统当前时间
    public static Date getTime(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //Date day=new Date();
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris")); //注意这行下面的代码要取消注释
        TimeZone time = TimeZone.getDefault();// 这个是国际化所用的
        //System.out.println("---------------------"+time);
        Calendar calendar = Calendar.getInstance();// 获取实例
        DateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 构造格式化模板
        Date date = calendar.getTime(); // 获取Date对象
        System.out.println("date------"+date);
        String str = new String();
        str = format1.format(date);// 对象进行格式化，获取字符串格式的输出
        System.out.println(str);
        return date;
    }

    //将时间转换为时间戳
    public static String dateToStamp(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date =new Date();
        try {
            date = simpleDateFormat.parse(s);
        }catch (Exception e){
            e.printStackTrace();
        }

        long ts = date.getTime();
        res = String.valueOf(ts);
        System.out.println(res);
        return res;
    }

    //获取当前日期的下一天
    public static String nextDay(String day){
        DateFormat dft = new SimpleDateFormat("yyyy/MM/dd");
        Date temp=new Date();
        String nextDay="";
        try {
            temp = dft.parse(day);
            Calendar cld = Calendar.getInstance();
            cld.setTime(temp);
            cld.add(Calendar.DATE, 1);
            temp = cld.getTime();
            //获得下一天日期字符串
            nextDay = dft.format(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nextDay;
    }


    public static int getAgeFromBirthdayTime(Date birthDay) {
        //获取当前系统时间
        Calendar cal = Calendar.getInstance();
        //如果出生日期大于当前时间，则抛出异常
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        //取出系统当前时间的年、月、日部分
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        //将日期设置为出生日期
        cal.setTime(birthDay);
        //取出出生日期的年、月、日部分
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        //当前年份与出生年份相减，初步计算年龄
        int age = yearNow - yearBirth;
        //当前月份与出生日期的月份相比，如果月份小于出生月份，则年龄上减1，表示不满多少周岁
        if (monthNow <= monthBirth) {
            //如果月份相等，在比较日期，如果当前日，小于出生日，也减1，表示不满多少周岁
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        System.out.println("age:"+age);
        return age;
    }

    //循环获取年月  自定义的
    public static String getDateYearMonth(int i){
        String year = getCurrentYear();
        String yearMonth=null;
        if (i<9){
            yearMonth=year+"/0"+String.valueOf(++i);
        }else{
            yearMonth=year+"/"+String.valueOf(++i);
        }
        return yearMonth;
    }
    //date转换为 格式 5月8号 星期三
    public static  String getFormatDate(Date date){
        //获取当前系统时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month=cal.get(Calendar.MONTH)+1;
        int day=cal.get(Calendar.DATE);
        int week=cal.get(Calendar.DAY_OF_WEEK);
        Map<Integer,String> result=new HashMap<>();
        result.put(7,"星期六");
        result.put(6,"星期五");
        result.put(5,"星期四");
        result.put(4,"星期三");
        result.put(3,"星期二");
        result.put(2,"星期一");
        result.put(1,"星期日");
        return month+"月"+day+"日"+" "+result.get(week);
    }


    public static String getNow() {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
