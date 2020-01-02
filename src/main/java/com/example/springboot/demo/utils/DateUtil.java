package com.example.springboot.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author Summit
 * 
 */
public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private final String formatStr;
    private final SimpleDateFormat format;

    public SimpleDateFormat getFormat() {
        return format != null ? format : new SimpleDateFormat(formatStr);
    }

    public DateUtil(SimpleDateFormat format) {
        this.format = format;
        this.formatStr = null;
    }

    public DateUtil(String formatStr) {
        this.format = null;
        this.formatStr = formatStr;
    }

    /**
     * 常用日期格式，yyyy-MM-dd
     */
    public static final DateUtil COMMON = new DateUtil("yyyy-MM-dd");

    /**
     * 常用日期格式，HH:mm:ss
     */
    public static final DateUtil COMMON_TIME = new DateUtil("HH:mm:ss");

    /**
     * 常用日期格式，HH:mm:ss
     */
    public static final DateUtil COMMON_sTIME = new DateUtil("HH:mm");

    /**
     * 常用日期格式，yyyy-MM-dd HH:mm:ss
     */
    public static final DateUtil COMMON_FULL = new DateUtil("yyyy-MM-dd HH:mm:ss");

    /**
     * 常用日期格式，yyyy-MM-dd HH:mm
     */
    public static final DateUtil COMMON_sFULL = new DateUtil("yyyy-MM-dd HH:mm");

    /**
     * 常用日期格式，yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final DateUtil COMMON_FULLS = new DateUtil("yyyy-MM-dd HH:mm:ss.S");

    /**
     * 紧凑日期格式，yyyyMMdd
     */
    public static final DateUtil COMPAT = new DateUtil("yyyyMMdd");

    /**
     * 紧凑日期格式，yyyyMMdd
     */
    public static final DateUtil COMPAT_TIME = new DateUtil("HHmmss");

    /**
     * 紧凑日期格式，yyyyMMddHHmmss
     */
    public static final DateUtil COMPAT_FULL = new DateUtil("yyyyMMddHHmmss");
    /**
     * 紧凑日期格式，yyyyMMddHHmm
     */
    public static final DateUtil COMPAT_sFULL = new DateUtil("yyyyMMddHHmm");

    /**
     * 紧凑日期格式，yyyyMMddHHmmssSSS
     */
    public static final DateUtil COMPAT_FULLS = new DateUtil("yyyyMMddHHmmssS");

    /**
     * 紧凑日期格式，ddHHmmssSSS
     */
    public static final DateUtil COMPAT_yMFULLS = new DateUtil("ddHHmmssS");

    /**
     * 使用点分隔的，yyyy.MM.dd
     */
    public static final DateUtil POINT = new DateUtil("yyyy.MM.dd");

    /**
     * 使用斜线分隔的，西方多采用，yyyy/MM/dd
     */
    public static final DateUtil SLASH = new DateUtil("yyyy/MM/dd");

    /**
     * 使用斜线分隔的，西方多采用，yyyy/MM
     */
    public static final DateUtil SLASH_MONTH = new DateUtil("yyyy/MM");

    /**
     * 中文日期格式常用，yyyy年MM月dd日
     */
    public static final DateUtil CHINESE = new DateUtil("yyyy年MM月dd日");
    /**
     * 中文日期格式常用，yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final DateUtil CHINESE_FULL = new DateUtil("yyyy年MM月dd日 HH时mm分ss秒");

    /**
     * 日期获取字符串
     */
    public String getDateText(Object date) {
        return date == null ? "" : getFormat().format(date);
    }

    /**
     * 日期获取字符串
     */
    public static String getDateText(Object date, String format) {
        return date == null ? "" : new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串获取日期
     * 
     * @throws ParseException
     */
    public Date getTextDate(String text) throws ParseException {
        return text == null ? null : getFormat().parse(text);
    }

    /**
     * 字符串获取日期
     * 
     * @throws ParseException
     */
    public static Date getTextDate(String text, String format) throws ParseException {
        return text == null ? null : new SimpleDateFormat(format).parse(text);
    }

    /**
     * 获取当前日期
     * 
     * @return
     */
    public String getCurText() {
        return getFormat().format(getCurTime());
    }

    /**
     * 获取当前日期
     * 
     * @return
     */
    public static String getCurText(String format) {
        return getDateText(getCurTime(), format);
    }

    /**
     * 获取当前日期，格式为：yyyy-MM-dd
     * 
     * @return
     */
    public static String getCurCOMMON() {
        return COMMON.getDateText(getCurTime());
    }

    /**
     * 获取当前日期，格式为：HH:mm:ss
     * 
     * @return
     */
    public static String getCurCOMMON_TIME() {
        return COMMON_TIME.getDateText(getCurTime());
    }

    /**
     * 获取当前日期，格式为：yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String getCurCOMMON_FULL() {
        return COMMON_FULL.getDateText(getCurTime());
    }

    /**
     * 获取当前日期，格式为：yyyyMMddHHmmss
     * 
     * @return
     */
    public static String getCurCOMPAT_FULL() {
        return COMPAT_FULL.getDateText(getCurTime());
    }

    /**
     * 获取当前日期，格式为：yyyyMMddHHmmssSSS
     * 
     * @return
     */
    public static String getCurCOMPAT_FULLS() {
        return COMPAT_FULLS.getDateText(getCurTime());
    }

    /**
     * 获取当前日期，格式为：ddHHmmssSSS
     * 
     * @return
     */
    public static String getCurCOMPAT_yMFULLS() {
        return COMPAT_yMFULLS.getDateText(getCurTime());
    }

    /**
     * 获取当前日期，格式为：yyyy/MM
     * 
     * @return
     */
    public static String getCurSLASH_MONTH() {
        return SLASH_MONTH.getDateText(getCurTime());
    }

    /**
     * 字符串转日期
     * 
     * @param dateText
     *            (yyyy-MM-dd OR yyyy/MM/dd OR yyyyMMdd OR yyyy.MM.dd 或
     *            yyyy-MM-dd HH:mm:ss )
     * @return
     */
    public static Date getTextDateAll(String dateText) {
        Date date = getTextDateNoCompat(dateText);
        if (date == null)
            date = getTextDateOthers(dateText);
        if (date == null && dateText.indexOf(":") > -1) {
            dateText = getCurCOMMON() + " " + dateText;
            try {
                if (datePatternTime(dateText))
                    date = COMMON_FULL.getTextDate(dateText);
                else
                    date = COMMON_sFULL.getTextDate(dateText);
            } catch (ParseException e) {
                logger.error(e.getLocalizedMessage(), e);
            }
        }
        return date;
    }

    /**
     * 字符串转日期
     * 
     * @param dateText
     *            yyyy-MM-dd OR yyyy/MM/dd OR yyyy.MM.dd 或 yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static Date getTextDateNoCompat(String dateText) {
        try {
            if (datePatternAll(dateText)) {
                if (dateText.indexOf("-") > -1) {
                    return COMMON.getTextDate(dateText);
                } else if (dateText.indexOf("/") > -1) {
                    return SLASH.getTextDate(dateText);
                } else if (dateText.indexOf(".") > -1) {
                    return POINT.getTextDate(dateText);
                } else {
                    return null;
                }
            } else if (datePatternTime(dateText)) {
                return COMMON_FULL.getTextDate(dateText);
            }
        } catch (ParseException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return null;
    }

    /**
     * 字符串转日期
     * 
     * @param dateText
     * @return
     */
    public static Date getTextDateOthers(String dateText) {
        try {
            String _str = dateText.replaceAll("[0-9]", "");
            String _numStr = dateText.replaceAll("[^0-9]", "");
            if (!_numStr.startsWith("1") && !_numStr.startsWith("2")) {

            } else if (_numStr.length() == 8) {
                return DateUtil.COMPAT.getTextDate(_numStr);
            } else if (_numStr.length() == 7) {
                return new DateUtil(new SimpleDateFormat("yyyyMd")).getTextDate(_numStr);
            } else if (_numStr.length() == 6) {
                if (_str.length() >= 2) {
                    return new DateUtil(new SimpleDateFormat("yyyyMd")).getTextDate(_numStr);
                } else {
                    return new DateUtil(new SimpleDateFormat("yyyyM")).getTextDate(_numStr);
                }
            } else if (_numStr.length() == 5) {
                return new DateUtil(new SimpleDateFormat("yyyyM")).getTextDate(_numStr);
            } else if (_numStr.length() == 4) {
                return new DateUtil(new SimpleDateFormat("yyyy")).getTextDate(_numStr);
            }
        } catch (ParseException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return null;
    }

    /**
     * 判断是否日期(yyyy-MM-dd OR yyyy/MM/dd OR yyyyMMdd OR yyyy.MM.dd)格式
     * 
     * @param date
     * @return
     */
    public static boolean datePatternAll(String date) {
        if (StringUtil.isNotEmpty(date)) {
            return date
                    .matches("^(?:(?!0000)[0-9]{4}([-/.]?)(?:(?:0?[1-9]|1[0-2])\\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\\1(?:29|30)|(?:0?[13578]|1[02])\\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-/.]?)0?2\\2(?:29))$");
        }
        return false;
    }

    /**
     * 判断是否日期时间(yyyy-MM-dd HH:mm:ss)格式
     * 
     * @param dateTime
     * @return
     */
    public static boolean datePatternTime(String dateTime) {
        if (StringUtil.isNotEmpty(dateTime)) {
            return dateTime
                    .matches("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)\\s+([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");
        }
        return false;
    }

    /**
     * 判断是否是正确的日期格式(yyyy-MM-dd)
     * 
     * @param date
     * @return
     */
    public static boolean datePattern(String date) {
        if (StringUtil.isNotEmpty(date)) {
            return date
                    .matches("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$");
        }
        return false;
    }

    /**
     * @return
     */
    public static List<String> getFiveYears() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        List<String> yearList = new ArrayList<>();
        for (int i = year - 3; i <= year + 3; i++) {
            yearList.add(String.valueOf(i));
        }
        return yearList;
    }

    /**
     * @return
     */
    public static List<String> getMonths() {
        List<String> mList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            mList.add(String.valueOf(i));
        }
        return mList;
    }

    /**
     * 判断是否是正确的年份格式
     * 
     * @param date
     * @return
     */
    public static boolean datePatternYear(String date) {
        if (StringUtil.isNotEmpty(date)) {
            return date.matches("^[1-9][0-9]{3}$");
        }
        return false;
    }

    /**
     * 格式化日期
     * 
     * @param date
     *            "yyyy-MM-dd"
     * @return
     */
    public static Date datePatternDate8(String date) {
        try {
            if (StringUtil.isNotEmpty(date)) {
                return COMMON.getTextDate(date);
            }
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return null;
    }

    /**
     * 比较两个日期的大小
     * 
     * @param start
     * @param end
     * @return
     */
    public static boolean compareDate(Date start, Date end) {
        long startMillions = start.getTime();
        long endMillions = end.getTime();
        if (endMillions >= startMillions) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 把数字月份转换为英文缩写
     * 
     * @param month
     * @return
     * @throws ParseException
     */
    public static String getMonthEnAbbr(String month) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        Date date = sdf.parse(month);
        sdf = new SimpleDateFormat("MMM", Locale.US);
        return sdf.format(date);
    }

    /**
     * 把时间类型转换为英文缩写-YY
     * 
     * @param obj
     * @return
     */
    public static String getMonthEnAbbrYY(Object obj) {
        Date date = getTextDateAll(String.valueOf(obj));
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM-yy", Locale.US);
            return sdf.format(date);
        } else {
            return "";
        }
    }

    /**
     * 日期的加减
     * 
     * @param date
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date addDate(Date date, int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        if (year != 0) {
            cal.add(Calendar.YEAR, year);
        }
        if (month != 0) {
            cal.add(Calendar.MONTH, month);
        }
        if (day != 0) {
            cal.add(Calendar.DATE, day);
        }
        return cal.getTime();
    }

    /**
     * 日期的加减
     * 
     * @param dateStr
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String addDate(String dateStr, int year, int month, int day) {
        Date date = getTextDateAll(dateStr);
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if (year != 0) {
                cal.add(Calendar.YEAR, year);
            }
            if (month != 0) {
                cal.add(Calendar.MONTH, month);
            }
            if (day != 0) {
                cal.add(Calendar.DATE, day);
            }
            if (datePatternAll(dateStr)) {
                if (dateStr.indexOf("-") > -1) {
                    return COMMON.getDateText(cal.getTime());
                } else if (dateStr.indexOf("/") > -1) {
                    return SLASH.getDateText(cal.getTime());
                } else if (dateStr.indexOf(".") > -1) {
                    return POINT.getDateText(cal.getTime());
                } else {
                    return COMPAT.getDateText(cal.getTime());
                }
            } else if (datePatternTime(dateStr)) {
                return COMMON_FULL.getDateText(cal.getTime());
            }
        }
        return "";
    }

    /**
     * 时间的加减
     * 
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date addTime(Date date, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        if (hour != 0) {
            cal.add(Calendar.HOUR, hour);
        }
        if (minute != 0) {
            cal.add(Calendar.MINUTE, minute);
        }
        if (second != 0) {
            cal.add(Calendar.SECOND, second);
        }
        return cal.getTime();
    }

    /**
     * 时间的加减
     * 
     * @param dateStr
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static String addTime(String dateStr, int hour, int minute, int second) {
        Date date = getTextDateAll(dateStr);
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if (hour != 0) {
                cal.add(Calendar.HOUR, hour);
            }
            if (minute != 0) {
                cal.add(Calendar.MINUTE, minute);
            }
            if (second != 0) {
                cal.add(Calendar.SECOND, second);
            }
            if (datePatternAll(dateStr)) {
                if (dateStr.indexOf("-") > -1) {
                    return COMMON.getDateText(cal.getTime());
                } else if (dateStr.indexOf("/") > -1) {
                    return SLASH.getDateText(cal.getTime());
                } else if (dateStr.indexOf(".") > -1) {
                    return POINT.getDateText(cal.getTime());
                } else {
                    return COMPAT.getDateText(cal.getTime());
                }
            } else if (datePatternTime(dateStr)) {
                return COMMON_FULL.getDateText(cal.getTime());
            }
        }
        return "";
    }

    public static long getCurLong() {
        return getCurTime().getTime();
    }

    public static Date getCurTime() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public static Date getCurDate() {
        return getCurDate(null);
    }

    /**
     * @param date
     * @return
     */
    public static int getCurDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据日期，返回其星期数，周一为1，周日为7
     * 
     * @param date
     * @return
     */
    public static int getCurWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK);
        int ret;
        if (w == Calendar.SUNDAY)
            ret = 7;
        else
            ret = w - 1;
        return ret;
    }

    /**
     * @param date
     * @return
     */
    public static int getCurMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * @param date
     * @return
     */
    public static int getCurYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * @param date
     * @return
     */
    public static int getCurWeekInYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * @param date
     * @return
     */
    public static Date getCurDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        try {
            return COMMON.getTextDate(COMMON.getDateText(calendar.getTime()));
        } catch (ParseException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return calendar.getTime();
    }

    /**
     * @param timestamp
     * @return
     */
    public static Date timestampToTime(Long timestamp) {
        if (timestamp != null)
            return new Date(timestamp);
        return null;
    }

    /**
     * @param timestamp
     * @return
     */
    public static Date timestampToDate(Long timestamp) {
        if (timestamp != null)
            return getCurDate(new Date(timestamp));
        return null;
    }

    /**
     * 分两种情况，参数为季度月份的话，例如：P8，返回：7 如果参数为空的情况，范围当前的季度月份，当前8月份，返回P9
     * 
     * @param monthStr
     *            季度月份
     * @return
     */
    public static String getFinanceMonth(String monthStr) {
        if (null != monthStr) {
            int month = Integer.parseInt(monthStr.substring(1, monthStr.length()));
            return String.valueOf((month - 1));
        } else {
            return new StringBuilder().append("P").append(getCurMonth(null) + 1).toString();
        }
    }

    /**
     * @param betweenLong
     * @return 00:00:00
     */
    public static String getDistanceStr(long betweenLong) {
        long between = betweenLong / 1000;// 除以1000是为了转换成秒
        String hour = String.valueOf(between / 3600);
        String minute = String.valueOf(between % 3600 / 60);
        String second = String.valueOf(between % 60);
        return (hour.length() == 1 ? "0" + hour : hour) + ":"
                + (minute.length() == 1 ? "0" + minute : minute) + ":"
                + (second.length() == 1 ? "0" + second : second);
    }

    /**
     * @param beginTime
     * @param endTime
     * @return 00:00:00
     */
    public static String getDistanceStr(Date beginTime, Date endTime) {
        return getDistanceStr(endTime.getTime() - beginTime.getTime());
    }

    /**
     * @param date
     * @throws ParseException
     */
    public static Date getStartTime(Object date) throws ParseException {
        if (date == null)
            date = getCurTime();
        else if (date instanceof String)
            date = getTextDateAll((String) date);
        return COMMON_FULL.getTextDate(COMMON.getDateText(date) + " 00:00:00");
    }

    /**
     * @param date
     * @param hasTime
     * @return date+"00:00:00"
     */
    public static String getStartStr(Object date, boolean hasTime) {
        if (date == null)
            date = getCurTime();
        else if (date instanceof String)
            date = getTextDateAll((String) date);
        if (hasTime)
            return COMMON.getDateText(date) + " 00:00:00";
        else
            return COMMON.getDateText(date);
    }

    /**
     * @param date
     * @throws ParseException
     */
    public static Date getEndTime(Object date) throws ParseException {
        if (date == null)
            date = getCurTime();
        else if (date instanceof String)
            date = getTextDateAll((String) date);
        return COMMON_FULL.getTextDate(COMMON.getDateText(date) + " 23:59:59");
    }

    /**
     * @param date
     * @param hasTime
     * @return date+"23:59:59"
     */
    public static String getEndStr(Object date, boolean hasTime) {
        if (date == null)
            date = getCurTime();
        else if (date instanceof String)
            date = getTextDateAll((String) date);
        if (hasTime)
            return COMMON.getDateText(date) + " 23:59:59";
        else
            return COMMON.getDateText(date);
    }

    /**
     * 获取过去第几天的日期
     * 
     * @param past
     * @param date
     * @return
     */
    public static Date getPastTime(int past, Date date) {
        if (date == null)
            date = getCurTime();
        return addDate(date, 0, 0, 0 - past);
    }

    /**
     * 获取过去第几天的日期
     * 
     * @param past
     * @param date
     * @param hasTime
     * @return date+"00:00:00"
     */
    public static String getPastStr(int past, Date date, boolean hasTime) {
        return getStartStr(getPastTime(past, date), hasTime);
    }

    /**
     * 获取未来第几天的日期
     * 
     * @param feture
     * @param date
     * @return data
     */
    public static Date getFetureTime(int feture, Date date) {
        if (date == null)
            date = getCurTime();
        return addDate(date, 0, 0, feture);
    }

    /**
     * 获取未来第几天的日期
     * 
     * @param feture
     * @param date
     * @param hasTime
     * @return date+"23:59:59"
     */
    public static String getFetureStr(int feture, Date date, boolean hasTime) {
        return getEndStr(getFetureTime(feture, date), hasTime);
    }

    /**
     * 获取本周一日期
     * 
     * @param date
     * @return
     */
    public static Date getCurMondayTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
        return calendar.getTime();
    }

    /**
     * 获取本周一日期
     * 
     * @param date
     * @param hasTime
     * @return date+"00:00:00"
     */
    public static String getCurMondayStr(Date date, boolean hasTime) {
        return getStartStr(getCurMondayTime(date), hasTime);
    }

    /**
     * 获取本周日日期
     * 
     * @param date
     * @return
     */
    public static Date getCurSundayTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值 + 6
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day + 6);
        return calendar.getTime();
    }

    /**
     * 获取本周日日期
     * 
     * @param date
     * @param hasTime
     * @return date+"23:59:59"
     */
    public static String getCurSundayStr(Date date, boolean hasTime) {
        return getEndStr(getCurSundayTime(date), hasTime);
    }

    /**
     * 获得上周一日期
     * 
     * @param date
     * @return
     */
    public static Date getPreMondayTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        calendar.add(Calendar.DATE, -6);
        return calendar.getTime();
    }

    /**
     * 获得上周一日期
     * 
     * @param date
     * @param hasTime
     * @return date+"00:00:00"
     */
    public static String getPreMondayStr(Date date, boolean hasTime) {
        return getStartStr(getPreMondayTime(date), hasTime);
    }

    /**
     * 获得上周日日期
     * 
     * @return
     */
    public static Date getPreSundayTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        return calendar.getTime();
    }

    /**
     * 获得上周日日期
     * 
     * @param date
     * @param hasTime
     * @return date+"23:59:59"
     */
    public static String getPreSundayStr(Date date, boolean hasTime) {
        return getEndStr(getPreSundayTime(date), hasTime);
    }

    /**
     * 获取当月第一天日期
     * 
     * @param date
     * @return
     */
    public static Date getCurMonthFirstTime(Date date) {
        // 规定返回日期格式
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        // 设置为第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取当月第一天日期
     * 
     * @param date
     * @param hasTime
     * @return date+"00:00:00"
     */
    public static String getCurMonthFirstStr(Date date, boolean hasTime) {
        return getStartStr(getCurMonthFirstTime(date), hasTime);
    }

    /**
     * 获取当月最后一天日期
     * 
     * @param date
     * @return
     */
    public static Date getCurMonthEndTime(Date date) {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * 获取当月最后一天日期
     * 
     * @param date
     * @param hasTime
     * @return date+"23:59:59"
     */
    public static String getCurMonthEndStr(Date date, boolean hasTime) {
        return getEndStr(getCurMonthEndTime(date), hasTime);
    }

    /**
     * 获得上月第一天
     * 
     * @param date
     * @return
     */
    public static Date getPreMonthFirstTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获得上月第一天
     * 
     * @param date
     * @param hasTime
     * @return date+"00:00:00"
     */
    public static String getPreMonthFirstStr(Date date, boolean hasTime) {
        return getStartStr(getPreMonthFirstTime(date), hasTime);
    }

    /**
     * 获得上月最后一天
     * 
     * @param date
     * @return
     */
    public static Date getPreMonthEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null)
            calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获得上月最后一天
     * 
     * @param date
     * @param hasTime
     * @return date+"23:59:59"
     */
    public static String getPreMonthEndStr(Date date, boolean hasTime) {
        return getEndStr(getPreMonthEndTime(date), hasTime);
    }
}