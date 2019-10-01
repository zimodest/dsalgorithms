package com.modest.tools;

import java.math.BigDecimal;

/**
 * 提供精确的浮点数运算，包括加减乘除和四舍五入
 *
 * @author modest
 * @date 2019/09/27
 */
public class Arith {
    /**
     * 默认除法运算精度
     */
    private static final int DEF_DIV_SCALE = 2;

    private Arith(){}

    /**
     * 提供精确的加法运算
     * @param v1 加数
     * @param v2 被加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        System.out.println(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        System.out.println(b1.add(b2).doubleValue());
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算
     * @param v1 被减数
     * @param v2 减数
     * @return  两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供相对精确的除法运算，当发生除不尽的情况下，有scale参数指定精度，以后的数字四舍五入
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示需要精确到小数点后几位
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if(scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //BigDecimal.ROUND_HALF_UP 向最接近的数字舍入，如果与两个相邻数字的距离相等，则向上舍入的舍入模式
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理
     * @param v1 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入的结果
     */
    public static double round(double v1, int scale) {
        if(scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal one = new BigDecimal("1");
        //BigDecimal.ROUND_HALF_UP 向最接近的数字舍入，如果与两个相邻数字的距离相等，则向上舍入的舍入模式
        return b1.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}






























































