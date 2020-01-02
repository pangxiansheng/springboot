package com.example.springboot.demo.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 字符串工具类
 * 
 * @author Summit
 */
public class StringUtil {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static boolean isEmpty(Object obj) {
        if (obj instanceof Map<?, ?>) {
            return isEmpty((Map<?, ?>) obj);
        }
        if (obj instanceof Set<?>) {
            return isEmpty((Set<?>) obj);
        }
        if (obj instanceof List<?>) {
            return isEmpty((List<?>) obj);
        }
        if (obj instanceof Collection<?>) {
            return isEmpty((Collection<?>) obj);
        }

        return obj == null || safeToString(obj).isEmpty();
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isTrimEmpty(Object obj) {
        return isTrimEmpty(safeTrim(obj));
    }

    public static boolean isNotTrimEmpty(Object obj) {
        return !isTrimEmpty(obj);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isTrimEmpty(String str) {
        return isEmpty(safeTrim(str));
    }

    public static boolean isNotTrimEmpty(String str) {
        return !isTrimEmpty(str);
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty() || list.size() == 0;
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static boolean isEmpty(Collection<?> colet) {
        return colet == null || colet.isEmpty() || colet.size() == 0;
    }

    public static boolean isNotEmpty(Collection<?> colet) {
        return !isEmpty(colet);
    }

    public static boolean isEmpty(Set<?> set) {
        return set == null || set.isEmpty() || set.size() == 0;
    }

    public static boolean isNotEmpty(Set<?> set) {
        return !isEmpty(set);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty() || map.size() == 0;
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Object[] objs) {
        return objs == null || objs.length == 0;
    }

    public static boolean isNotEmpty(Object[] objs) {
        return !isEmpty(objs);
    }

    /**
     * 安全的toString方法。 用于在有null风险的情况下获得对象的字符串表达。
     * 
     * @param obj
     *            对象
     * @return 如果参数为null，返回空串，否则返回参数自身的toString()方法结果
     */
    public static String safeToString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 安全的equals方法
     * 
     * @param obj1
     * @param obj2
     * @param ignoreCase
     * @return
     */
    public static boolean safeEquals(Object obj1, Object obj2, boolean ignoreCase) {
        if (!ignoreCase) {
            return safeToString(obj1).equals(safeToString(obj2));
        } else {
            return safeToString(obj1).equalsIgnoreCase(safeToString(obj2));
        }
    }

    /**
     * 安全的equals方法
     * 
     * @param obj1
     * @param obj2
     * @param ignoreCase
     * @return
     */
    public static boolean safeContains(Object obj1, Object obj2, boolean ignoreCase) {
        if (!ignoreCase) {
            return safeToString(obj1).contains(safeToString(obj2));
        } else {
            return safeToString(obj1).toLowerCase().contains(safeToString(obj2).toLowerCase());
        }
    }

    /**
     * 安全的sndsWidth方法
     * 
     * @param obj1
     * @param obj2
     * @param ignoreCase
     * @return
     */
    public static boolean safeStartsWith(String obj1, String obj2, boolean ignoreCase) {
        if (!ignoreCase) {
            return safeToString(obj1).startsWith(safeToString(obj2));
        } else {
            return safeToString(obj1).toLowerCase().startsWith(safeToString(obj2).toLowerCase());
        }
    }

    /**
     * 安全的endsWidth方法
     * 
     * @param obj1
     * @param obj2
     * @param ignoreCase
     * @return
     */
    public static boolean safeEndsWidth(String obj1, String obj2, boolean ignoreCase) {
        if (!ignoreCase) {
            return safeToString(obj1).endsWith(safeToString(obj2));
        } else {
            return safeToString(obj1).toLowerCase().endsWith(safeToString(obj2).toLowerCase());
        }
    }

    /**
     * 安全的indexOf方法
     * 
     * @param obj1
     * @param obj2
     * @param ignoreCase
     * @return
     */
    public static int safeIndexOf(String obj1, String obj2, boolean ignoreCase) {
        if (!ignoreCase) {
            return safeToString(obj1).indexOf(safeToString(obj2));
        } else {
            return safeToString(obj1).toLowerCase().indexOf(safeToString(obj2).toLowerCase());
        }
    }

    /**
     * 安全的LowerCase方法
     * 
     * @param obj
     * @param locale
     * @return
     */
    public static String safeLowerCase(Object obj, Locale locale) {
        if (locale == null) {
            return safeToString(obj).toLowerCase();
        } else {
            return safeToString(obj).toLowerCase(locale);
        }
    }

    /**
     * 安全的UpperCase方法
     * 
     * @param obj
     * @return
     */
    public static String safeUpperCase(Object obj, Locale locale) {
        if (locale == null) {
            return safeToString(obj).toUpperCase();
        } else {
            return safeToString(obj).toUpperCase(locale);
        }
    }

    /**
     * 安全的length方法
     * 
     * @param obj
     * @return
     */
    public static int safeLength(Object obj) {
        return safeToString(obj).length();
    }

    /**
     * 安全的去除所有空格方法
     * 
     * @param obj
     * @return
     */
    public static String safeTrimAll(Object obj) {
        return safeToString(obj).replaceAll("\\s*", "");
    }

    /**
     * 安全的trim方法。 用于在有null风险的情况下获得{@link String#trim()}相同的效果，但不会抛出异常。
     * 如果对象不为空则将对象转换成字符串并去除空格返回,否则返回空串
     * 
     * @param obj
     *            对象
     * @return 返回非空字符串
     */
    public static String safeTrim(Object obj) {
        char[] charArr = safeToString(obj).toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] > ' ' && charArr[i] != '　') {
                break;
            } else {
                if (charArr[i] == '　') {
                    charArr[i] = ' ';
                }
            }
        }
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] > ' ' && charArr[i] != '　') {
                break;
            } else {
                if (charArr[i] == '　') {
                    charArr[i] = ' ';
                }
            }
        }
        return new String(charArr).trim();
    }

    /**
     * 安全的做字符串替换 将源字符串中的目标字符串全部替换成替换字符串 规则如下： 若source为null,则结果亦 为null
     * 若target为null,则结果为source 若replacement为null,则结果为source中的target全部被剔除后的新字符串
     * 
     * @param source
     *            源字符串
     * @param target
     *            目标字符串
     * @param replacement
     *            替换字符串
     * @return 替换过的字符串
     */
    public static String safeReplace(String source, String target, String replacement) {
        if (source == null || source.isEmpty() || target == null || target.isEmpty()
                || target.equals(replacement)) {
            return source;
        }

        List<Integer> offsets = new ArrayList<>();
        int targetLen = target.length();
        int offset = 0;
        while (true) {
            offset = source.indexOf(target, offset);
            if (offset == -1) {
                break;
            }

            offsets.add(offset);
            offset += targetLen;
        }

        String result = source;
        if (!offsets.isEmpty()) {
            // 计算结果字符串数组长度
            int sourceLen = source.length();
            if (replacement == null) {
                replacement = "";
            }

            int replacementLen = replacement.length();

            int offsetsSize = offsets.size();
            int resultLen = sourceLen + (replacementLen - targetLen) * offsetsSize;

            // 源/目标字符数组
            char[] sourceCharArr = source.toCharArray();
            char[] replacementCharArr = replacement.toCharArray();
            char[] destCharArr = new char[resultLen];

            // 做第一轮替换
            int firstOffset = offsets.get(0);
            System.arraycopy(sourceCharArr, 0, destCharArr, 0, firstOffset);
            if (replacementLen > 0) {
                System.arraycopy(replacementCharArr, 0, destCharArr, firstOffset, replacementCharArr.length);
            }

            // 中间替换
            int preOffset = firstOffset; // 前一个偏移量
            int destPos = firstOffset + replacementCharArr.length; // 目标char数组目前的有效长度(即已经填入的字符数量)
            for (int i = 1; i < offsetsSize; i++) {
                offset = offsets.get(i); // 当前偏移量
                int fragmentLen = offset - preOffset - targetLen;
                System.arraycopy(sourceCharArr, preOffset + targetLen, destCharArr, destPos, fragmentLen);
                destPos += fragmentLen;
                if (replacementLen > 0) {
                    System.arraycopy(replacementCharArr, 0, destCharArr, destPos, replacementCharArr.length);
                }
                preOffset = offset;
                destPos += replacementCharArr.length;
            }

            // 做末轮替换
            int lastFragmentLen = sourceLen - preOffset - targetLen;
            System.arraycopy(sourceCharArr, preOffset + targetLen, destCharArr, destPos, lastFragmentLen);

            result = new String(destCharArr);
        }

        return result;
    }

    /**
     * 检查字符串中是否包含某个字符
     * 
     * @param str
     *            需要检查的字符
     * @param compare
     *            字符串
     * @return true 包含改字符 false 不包含改字符
     */
    public static boolean contains(String str, String compare) {
        boolean bool = true;
        if (isEmpty(str)) {
            bool = false;
        } else {
            if (str.indexOf(compare) < 0) {
                bool = false;
            }
        }
        return bool;
    }

    /**
     * 检查字符串中是否包含某个字符
     * 
     * @param str
     *            需要检查的字符
     * @param compare
     *            字符串
     * @return true 不包含改字符 false 包含改字符
     */
    public static boolean notContains(String str, String compare) {
        return !contains(str, compare);
    }

    /**
     * 将首字符大写
     * 
     * @param str
     *            字符串
     * @return 首字符大写的字符串
     */
    public static String toFirstLetterUpperCase(String str) {
        if (StringUtil.isNotEmpty(str)) {
            String firstLetter = str.substring(0, 1).toUpperCase();
            return firstLetter + str.substring(1, str.length());
        } else {
            return str;
        }
    }

    /**
     * 转换字符串为Short
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return 转换后的Short，失败是返回0
     */
    public static Short toShort(Object value) throws NumberFormatException {
        String val = safeToString(value);
        try {
            if (isNotEmpty(val)) {
                return Short.valueOf(safeTrim(val));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 转换字符串为Integer
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return 转换后的Integer，失败是返回0
     */
    public static Integer toInteger(Object value) throws NumberFormatException {
        String val = safeToString(value);
        try {
            if (isNotEmpty(val)) {
                return Integer.valueOf(safeTrim(val));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 转换字符串为Integer
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return 转换后的Integer，失败是返回0
     */
    public static Integer toIntegerWithZero(Object value) throws NumberFormatException {
        String val = safeToString(value);
        try {
            if (isEmpty(val)) {
                return 0;
            } else {
                return Integer.valueOf(safeTrim(val));
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 转换字符串为Long
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return 转换后的Long，失败是返回0
     */
    public static Long toLong(Object value) throws NumberFormatException {
        String val = safeToString(value);
        try {
            if (isNotEmpty(val)) {
                return Long.valueOf(safeTrim(val));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 转换字符串为Float
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return 转换后的Float，失败是返回0
     */
    public static Float toFloat(Object value) throws NumberFormatException {
        String val = safeToString(value);
        try {
            if (isNotEmpty(val)) {
                return Float.valueOf(safeTrim(val));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 转换字符串为Double
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return 转换后的Double，失败是返回0
     */
    public static Double toDouble(Object value) throws Exception {
        String val = safeToString(value);
        try {
            if (isNotEmpty(val)) {
                return Double.valueOf(safeTrim(val));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    /**
     * 转换字符串为BigDecimal
     * 
     * @param value
     *            String
     * @throws NumberFormatException
     *             异常
     * @return BigDecimal 转换后的BigDecimal，失败是返回0
     */
    public static BigDecimal toBigDecimal(Object value) throws Exception {
        String val = safeToString(value);
        try {
            if (isNotEmpty(val)) {
                return new BigDecimal(safeTrim(val));
            } else {
                return null;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 4舍5入,返回不含科学计数法的字符
     * 
     * @param value
     *            值
     * @param nScal
     *            精度
     * @return String 4舍5入后的值
     */
    public static String toDoubleNoE(double value, int nScal) {
        DecimalFormat numberForm = (DecimalFormat) NumberFormat.getNumberInstance(Locale.CHINA);
        numberForm.setGroupingUsed(false);
        numberForm.setMaximumFractionDigits(nScal);
        return numberForm.format(value);
    }

    /**
     * 转换字符串为Boolean
     * 
     * @param value
     *            (1/ok/yes/true)
     * @return Boolean
     */
    public static Boolean toBoolean(String value) {
        if (isNotEmpty(value) && ("1".equals(value) || "ok".equalsIgnoreCase(value)
                || "yes".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value))) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 将字符串集合转化JSONObject
     * 
     * @param str
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T toJson(String str, Class<T> clazz) {
        if (isNotEmpty(str)) {
            try {
                if (clazz.getName().endsWith("Object") && str.startsWith("{") && str.endsWith("}")) {
                    return (T) JSONObject.fromObject(str);
                }
                if (clazz.getName().endsWith("Array") && str.startsWith("[") && str.endsWith("]")) {
                    return (T) JSONArray.fromObject(str);
                }
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage(), e);
            }
        }
        return null;
    }

    /**
     * 功能：验证字符串长度是否符合要求，一个汉字等于两个字符
     * 
     * @param strParameter
     *            要验证的字符串
     * @return
     */
    public static int validateStrByLength(String strParameter) {
        int temp_int = 0;
        if (isNotEmpty(strParameter)) {
            byte[] b = strParameter.getBytes();
            for (int i = 0; i < b.length; i++) {
                if (b[i] >= 0) {
                    temp_int = temp_int + 1;
                } else {
                    temp_int = temp_int + 2;
                    i++;
                }
            }
        }
        return temp_int;
    }

    /**
     * 字符串快速分割。
     * 
     * 提供更高效简洁的分割算法，在相同情况下，分割效率约为 {@link String#split(String)}的4倍
     * 但仅支持单个字符作为分割符。
     * 
     * 当待分割字符串为null或者空串时，返回长度为0的数组 该方法不会抛出任何异常
     * 
     * @param source
     *            待分割字符串
     * @param splitChar
     *            分隔符
     * @return 分割完毕的字符串数组
     */
    public static String[] split(String source, char splitChar) {
        String[] strArr = null;
        List<String> strList = new LinkedList<String>();
        if (null == source || source.isEmpty()) {
            strArr = new String[0];
        } else {
            char[] charArr = source.toCharArray();
            int start = 0;
            int end = 0;
            while (end < source.length()) {
                char c = charArr[end];
                if (c == splitChar) {
                    if (start != end) {
                        String fragment = source.substring(start, end);
                        strList.add(fragment);
                    }
                    start = end + 1;
                }
                ++end;
            }
            if (start < source.length()) {
                strList.add(source.substring(start));
            }

            strArr = new String[strList.size()];
            strList.toArray(strArr);
        }

        return strArr;
    }

    /**
     * 字符串快速分割。
     * 
     * 提供更高效简洁的分割算法，在相同情况下，分割效率约为 {@link String#split(String)}的4倍
     * 支持字符串作为分割符。
     * 
     * 当待分割字符串为null或者空串时，返回长度为0的数组 该方法不会抛出任何异常 如果传入的字符串中仅含有1个字符，那么该方法会被转交给
     * {@link #split(String, char)}处理
     * 
     * @param source
     *            待分割字符串
     * @param splitStr
     *            分隔符字符串
     * @return 分割完毕的字符串数组
     * 
     * @see #split(String, char)
     */
    public static String[] split(String source, String splitStr) {
        String[] strArr = null;
        if (null == source || source.isEmpty()) {
            strArr = new String[0];
        } else {
            if (splitStr.length() == 1) {
                strArr = split(source, splitStr.charAt(0));
            } else {
                int strLen = source.length();
                int splitStrLen = splitStr.length();
                List<String> strList = new LinkedList<String>();
                int start = 0;
                int end = 0;
                while (start < strLen) {
                    end = source.indexOf(splitStr, start);
                    if (end == -1) {
                        String fregment = source.substring(start);
                        strList.add(fregment);
                        break;
                    }
                    if (start != end) {
                        String fregment = source.substring(start, end);
                        strList.add(fregment);
                    }
                    start = end + splitStrLen;
                }

                strArr = new String[strList.size()];
                strList.toArray(strArr);
            }
        }

        return strArr;
    }

    /**
     * 字节转16进制
     * 
     * @param b
     *            需要进行转换的byte字节
     * @return 转换后的Hex字符串
     */
    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

    /**
     * 字节数组转16进制
     * 
     * @param bytes
     *            需要转换的byte数组
     * @return 转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * hex字符串转hexToLong
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的long
     */
    public static long hexToLong(String inHex) {
        return Long.parseLong(inHex, 16);
    }

    /**
     * hex字符串转long String
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的long String
     */
    public static String hexToLongString(String inHex) {
        return String.valueOf(hexToLong(inHex));
    }

    /**
     * hex字符串转int
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的int
     */
    public static int hexToInt(String inHex) {
        return Integer.parseInt(inHex, 16);
    }

    /**
     * hex字符串转int String
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的int String
     */
    public static String hexToIntString(String inHex) {
        return String.valueOf(hexToInt(inHex));
    }

    /**
     * Hex字符串转byte
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的byte
     */
    public static byte hexToByte(String inHex) {
        return (byte) hexToInt(inHex);
    }

    /**
     * Hex字符串转byte String
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的byte
     */
    public static String hexToByteString(String inHex) {
        return String.valueOf((byte) hexToInt(inHex));
    }

    /**
     * hex字符串转byte数组
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的byte数组结果
     */
    public static byte[] hexToBytes(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            // 奇数
            hexlen++;
            result = new byte[(hexlen / 2)];
            inHex = "0" + inHex;
        } else {
            // 偶数
            result = new byte[(hexlen / 2)];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            j++;
        }
        return result;
    }

    /**
     * hex字符串转String
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @return 转换后的String
     */
    public static String hexToString(String inHex) {
        return new String(hexToBytes(inHex));
    }

    /**
     * hex字符串转String
     * 
     * @param inHex
     *            待转换的Hex字符串
     * @param charset
     *            (not need)
     * @return 转换后的String
     */
    public static String hexToString(String inHex, Charset charset) {
        if (charset != null) {
            return new String(hexToBytes(inHex), charset);
        } else {
            return hexToString(inHex);
        }
    }

    /**
     * @param text
     * @return
     */
    public static String subTwentyChar(String text) {
        String resultStr = "";
        int i = 0;
        while (validateStrByLength(resultStr) != 20 && validateStrByLength(resultStr) != 21
                && validateStrByLength(resultStr) != 22) {
            i++;
            resultStr = text.substring(0, i);
        }
        return resultStr;
    }

    /**
     * 拼接制定的值【例如：名称为：123456.xls，拼接值为：yyyy,拼接点为"." 拼接结果为：1234.56yyyy.xlsx】
     * 
     * @param content
     *            内容
     * @param spliceContent
     *            需要拼接的内容
     * @param sign
     *            拼接分割点-使用lastIndexOf
     * @return 拼接后的值
     */
    public static String spliceContent(String content, String spliceContent, String sign) {
        StringBuilder sbStr = new StringBuilder();
        int lastIndexOf = content.lastIndexOf(sign);
        sbStr.append(content.substring(0, lastIndexOf));
        sbStr.append(spliceContent);
        sbStr.append(content.substring(lastIndexOf, content.length()));

        return sbStr.toString();
    }

    /**
     * 拼接制定的值【例如：名称为：123456.xls，拼接值为：yyyy,拼接点为"." 拼接结果为：1234.56yyyy.xlsx】
     *
     * @param content
     *            内容
     * @return 拼接后的值
     */
    public static String spliceContent(String content) {
        return spliceContent(content, DateUtil.getCurCOMPAT_FULL(), ".");
    }

    /**
     * 按字节数截取字符串
     * 
     * @param str
     * @param subSLength
     * @param charsetName
     *            (GBK汉字占2、UTF-8汉字占3)
     * @return
     */
    public static String subStr(String str, int subSLength, String charsetName) {
        if (str == null) {
            return null;
        } else {
            String subStr = str.substring(0, str.length() < subSLength ? str.length() : subSLength);// 截取的子串
            try {
                int subStrByetsL;
                if (isNotEmpty(charsetName)) {
                    subStrByetsL = subStr.getBytes(charsetName).length;// 截取子串的字节长度
                } else {
                    subStrByetsL = subStr.getBytes().length;// 截取子串的字节长度
                }
                int tempSubLength = subSLength;// 截取字节数
                while (subStrByetsL > tempSubLength) {
                    int subSLengthTemp = --subSLength;
                    subStr = str.substring(0, subSLengthTemp > str.length() ? str.length() : subSLengthTemp);// 截取的子串
                    if (isNotEmpty(charsetName)) {
                        subStrByetsL = subStr.getBytes(charsetName).length;// 截取子串的字节长度
                    } else {
                        subStrByetsL = subStr.getBytes().length;// 截取子串的字节长度
                    }
                }
            } catch (UnsupportedEncodingException e) {
                logger.error("获取子串的字节长度失败", e);
            }
            return subStr;
        }
    }

    /**
     * 倒序字符串
     * 
     * @param str
     * @return
     */
    public static String reverseStr(String str) {
        if (isNotEmpty(str)) {
            return new StringBuffer(str).reverse().toString();
        } else {
            return str;
        }
    }

    /**
     * 替换字符串里最后出现的元素
     * 
     * @param text
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
    }

}
