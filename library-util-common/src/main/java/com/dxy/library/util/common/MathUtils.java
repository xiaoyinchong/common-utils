package com.dxy.library.util.common;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 数字工具类
 * 提供精确的浮点数运算，包括加减乘除和四舍五入。
 * @author duanxinyuan
 * 2016/6/14 14:44
 */
public interface MathUtils {

    /**
     * 判断Integer是否不为空和0
     * @return true-不为空和0
     */
    static boolean isNNZ(Integer i) {
        return null != i && i != 0;
    }

    /**
     * 判断Double是否为0
     * @return true-不为空和0
     */
    static boolean isNNZ(Double d) {
        return null != d && d != 0;
    }

    /**
     * 判断Long是否为0
     * @return true-不为空和0
     */
    static boolean isNNZ(Long l) {
        return null != l && l != 0;
    }

    /**
     * 判断Long是否为0
     * @return true-不为空和0
     */
    static boolean isNNZ(BigDecimal b) {
        return null != b && b.doubleValue() != 0;
    }

    /**
     * 判断Integer是否大于0
     * @return true-大于0
     */
    static boolean isGTZ(Integer i) {
        return null != i && i > 0;
    }

    /**
     * 判断Double是否大于0
     * @return true-大于0
     */
    static boolean isGTZ(Double d) {
        return null != d && d > 0;
    }

    /**
     * 判断Long是否大于0
     * @return true-大于0
     */
    static boolean isGTZ(Long l) {
        return null != l && l > 0;
    }

    /**
     * 判断Long是否大于0
     * @return true-大于0
     */
    static boolean isGTZ(BigDecimal b) {
        return null != b && b.doubleValue() > 0;
    }

    /**
     * 判断Integer是否小于0
     * @return true-大于0
     */
    static boolean isLTZ(Integer i) {
        return null != i && i < 0;
    }

    /**
     * 判断Double是否小于0
     * @return true-大于0
     */
    static boolean isLTZ(Double d) {
        return null != d && d < 0;
    }

    /**
     * 判断Long是否小于0
     * @return true-大于0
     */
    static boolean isLTZ(Long l) {
        return null != l && l < 0;
    }

    /**
     * 判断Long是否小于0
     * @return true-大于0
     */
    static boolean isLTZ(BigDecimal b) {
        return null != b && b.doubleValue() < 0;
    }

    /**
     * 比较大小
     * @return 返回l1是否比l2大, l1>l2返回true,l1<l2返回false
     */
    static boolean isGT(Long l1, Long l2) {
        return l1 != null && (l2 == null || l1 > l2);
    }

    /**
     * 比较大小
     * @return i1, l1>i2返回true,i1<i2返回false
     */
    static boolean isGT(Integer i1, Integer i2) {
        return i1 != null && (i2 == null || i1 > i2);
    }

    /**
     * 比较大小
     * @return 返回b1是否比b2大, b1>b2返回true,b1<b2返回false
     */
    static boolean isGT(BigDecimal b1, BigDecimal b2) {
        return b1 != null && b2 != null && b1.compareTo(b2) > 0;
    }

    /**
     * 比较大小
     * @return 返回b1是否比b2大, b1>b2返回true,b1<b2返回false
     */
    static boolean isGT(Double b1, Double b2) {
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(NumberUtils.toDouble(String.valueOf(b1))));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(NumberUtils.toDouble(String.valueOf(b2))));
        return isGT(bigDecimal1, bigDecimal2);
    }

    /**
     * 加法运算
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    static double add(Number v1, Number v2) {
        v1 = v1 == null ? 0 : v1;
        v2 = v2 == null ? 0 : v2;
        return round(new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2))).doubleValue());
    }

    /**
     * 加法运算
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的和
     */
    static double add(Number v1, Number... v2) {
        return round(addNoRound(v1, v2));
    }

    /**
     * 加法运算
     * @param v1 被减数
     * @param v2 减数
     * @param scale 保留的小数点位数
     * @return 两个参数的和
     */
    static double add(Number v1, int scale, Number... v2) {
        return round(addNoRound(v1, v2), scale);
    }

    /**
     * 加法运算
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的和
     */
    static double addNoRound(Number v1, Number... v2) {
        v1 = v1 == null ? 0 : v1;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(v1));
        for (Number number : v2) {
            if (number != null) {
                bigDecimal = bigDecimal.add(new BigDecimal(String.valueOf(number)));
            }
        }
        return bigDecimal.doubleValue();
    }

    /**
     * 减法运算
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    static double subtract(Number v1, Number v2) {
        v1 = v1 == null ? 0 : v1;
        v2 = v2 == null ? 0 : v2;
        return round(new BigDecimal(String.valueOf(v1)).subtract(new BigDecimal(String.valueOf(v2))).doubleValue());
    }

    /**
     * 减法运算
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    static double subtract(Number v1, Number... v2) {
        return round(subtractNoRound(v1, v2));
    }

    /**
     * 减法运算
     * @param v1 被减数
     * @param v2 减数
     * @param scale 保留的小数点位数
     * @return 两个参数的差
     */
    static double subtract(Number v1, int scale, Number... v2) {
        return round(subtractNoRound(v1, v2), scale);
    }

    /**
     * 减法运算
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    static double subtractNoRound(Number v1, Number... v2) {
        v1 = v1 == null ? 0 : v1;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(v1));
        for (Number number : v2) {
            if (number != null) {
                bigDecimal = bigDecimal.subtract(new BigDecimal(String.valueOf(number)));
            }
        }
        return bigDecimal.doubleValue();
    }

    /**
     * 乘法运算
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    static double multiply(Number v1, Number v2) {
        if (null == v1 || null == v2) {
            return 0;
        }
        return round(new BigDecimal(String.valueOf(v1)).multiply(new BigDecimal(String.valueOf(v2))).doubleValue());
    }

    /**
     * 乘法运算
     * @param v1 被乘数
     * @param v2 乘数
     * @param scale 保留的小数点位数
     * @return 两个参数的积
     */
    static double multiply(Number v1, Number v2, int scale) {
        if (null == v1 || null == v2) {
            return 0;
        }
        return round(new BigDecimal(String.valueOf(v1)).multiply(new BigDecimal(String.valueOf(v2))).doubleValue(), scale);
    }

    /**
     * 乘法运算
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    static double multiply(Number v1, Number... v2) {
        return round(multiplyNoRound(v1, v2));
    }

    /**
     * 乘法运算
     * @param v1 被乘数
     * @param v2 乘数
     * @param scale 保留的小数点位数
     * @return 两个参数的积
     */
    static double multiply(Number v1, int scale, Number... v2) {
        double multiply = multiplyNoRound(v1, v2);
        return multiply(multiply, scale);
    }

    /**
     * 乘法运算
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    static double multiplyNoRound(Number v1, Number... v2) {
        v1 = v1 == null ? 0 : v1;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(v1));
        for (Number number : v2) {
            if (number != null) {
                bigDecimal = bigDecimal.multiply(new BigDecimal(String.valueOf(number)));
            }
        }
        return bigDecimal.doubleValue();
    }

    /**
     * 除法运算
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    static double divide(Number v1, Number v2) {
        return divide(v1, v2, 2);
    }

    /**
     * 除法运算
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    static double divide(Number v1, Number... v2) {
        return round(divideNoRound(v1, v2));
    }

    /**
     * 除法运算
     * @param v1 被除数
     * @param v2 除数
     * @param scale 保留的小数点位数
     * @return 两个参数的商
     */
    static double divide(Number v1, int scale, Number... v2) {
        return round(divideNoRound(v1, v2), scale);
    }

    /**
     * 除法运算
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    static double divideNoRound(Number v1, Number... v2) {
        v1 = v1 == null ? 0 : v1;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(v1));
        for (Number number : v2) {
            if (number != null) {
                bigDecimal = bigDecimal.divide(new BigDecimal(String.valueOf(number)), BigDecimal.ROUND_HALF_UP);
            }
        }
        return bigDecimal.doubleValue();
    }

    /**
     * 除法运算
     * @param v1 被除数
     * @param v2 除数
     * @param scale 保留的小数点位数
     * @return 两个参数的商
     */
    static double divide(Number v1, Number v2, int scale) {
        if (null == v1 || null == v2) {
            return 0;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("保留小数位数不能小于0");
        }
        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(v1));
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(v2));
        return bigDecimal1.divide(bigDecimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留两位小数，四舍五入
     */
    static double round(String v) {
        return round(v, 2);
    }

    /**
     * 保留两位小数，四舍五入
     */
    static double round(Number v) {
        return round(v, 2);
    }

    /**
     * 四舍五入
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    static double round(Number v, int scale) {
        if (null == v) {
            return 0;
        }
        return round(String.valueOf(v), scale);
    }

    /**
     * 四舍五入
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    static double round(String v, int scale) {
        if (StringUtils.isEmpty(v)) {
            return 0;
        }
        if (scale < 0) {
            throw new IllegalArgumentException("保留小数位数不能小于0");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 四舍五入取整
     */
    static int roundInt(String v) {
        if (StringUtils.isEmpty(v)) {
            return 0;
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 四舍五入取整
     */
    static int roundInt(Number v) {
        return roundInt(String.valueOf(v));
    }

    /**
     * 得到一个在指定范围内的随机数
     * @param start 开始数
     * @param end 结束数（范围内不包含本数）
     * @return 随机数
     */
    static int getRandomInt(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("随机数范围错误");
        }
        Random random = new Random();
        int fraction = random.nextInt(end - start);
        return start + fraction;
    }

}
