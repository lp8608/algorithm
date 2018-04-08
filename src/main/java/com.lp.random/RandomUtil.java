package com.lp.random;
import java.util.Arrays;
import java.util.Random;
public class RandomUtil {

    private static Random random =  new Random();
    /**
     * 定义一个上下限，请在上下限范围内随机生成n个数组，总和为total
     * @param min
     * @param max
     * @param number
     * @param total
     * @return
     */
    public static int[]  generalIntArray(int min ,int max, int number, int total) throws Exception {
        int []  arr =  new int[number];
        if(validate(min,max,number,total)){
            //先将总数均分
            int[]  avrArr = avgArr(number, total);
            System.out.println("avrArr:" + Arrays.toString(avrArr));
            //按照上下限设置随机数的范围
            int[] temp = new int[number];
            int avgNumber = (max - min)/2;
            for (int i = 0; i < number; i++) {
                temp[i]= random(avrArr[i] - avgNumber, avrArr[i] + avgNumber);
                if( i == 0) {
                    arr[i] = temp[i];
                }else if(i == number -1){
                    arr[i] = total - temp[i-1];
                }else{
                    arr[i] = temp[i] - temp[i -1];
                }
            }
            System.out.println("temp:" + Arrays.toString(temp));

        }else{
            throw new Exception("输入参数无效，请输入有效参数");
        }
        return arr;
    }

    /**
     * 校验参数是否有效
     * @param min
     * @param max
     * @param number
     * @param total
     * @return
     */
    private static boolean validate(int min, int max , int number, int total){
        if(min * number <= total && max * number >= total){
            return true;
        }
        return false;
    }

    /**
     * 根据上下限生成一个随机数
     * @param min
     * @param max
     * @return
     */
    private static int random(int min ,int max){
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 将total均分为number个数字
     * 例如： total= 100  number = 4
     * 则返回: [25,50,75,100]
     * @param number
     * @param total
     * @return
     */
    private static int[]  avgArr(int number , int total){
        int[] arr = new int[number];
        int everyData = total/number;
        for (int i = 0; i < number; i++) {
            arr[i] = everyData * (i+1);
        }
        if(total % number != 0){
            arr[number - 1] = total - arr[number - 2];
        }
        return arr;
    }

    public static void main(String[] args)throws  Exception {
        int[]  arr = generalIntArray(80,120,10 , 1000);
        System.out.println(Arrays.toString(arr));
    }
}
