package com.ttk.cese;

import com.google.common.collect.Lists;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;


public class BeOverdueTime {

    // 定义节假日
    final static List<LocalDate> holidays = Lists.newArrayList();

    // 定义补班日
    final static List<LocalDate> coverShiftDay = Lists.newArrayList();

    // 一天工作9小时
    static long nineHourSecond = 9 * 60 * 60;

    // 一天的结束时间
    private final static LocalTime endTime = LocalTime.MAX;

    // 一天的开始时间
    private final static LocalTime startTime = LocalTime.MIN;

    // 9点
    private final static LocalTime nineTime = LocalTime.of(9, 0);

    // 18点
    private final static LocalTime eighteenTime = LocalTime.of(18, 0);

    static {

        // 从2023年6月开始
        // 端午节
        holidays.add(LocalDate.of(2023, 6, 22));
        holidays.add(LocalDate.of(2023, 6, 23));
        holidays.add(LocalDate.of(2023, 6, 24));

        // 中秋节
        holidays.add(LocalDate.of(2023, 9, 29));
        holidays.add(LocalDate.of(2023, 9, 30));

        // 国庆节
        holidays.add(LocalDate.of(2023, 10, 1));
        holidays.add(LocalDate.of(2023, 10, 2));
        holidays.add(LocalDate.of(2023, 10, 3));
        holidays.add(LocalDate.of(2023, 10, 4));
        holidays.add(LocalDate.of(2023, 10, 5));
        holidays.add(LocalDate.of(2023, 10, 6));

        // 补班日（从2023年6月开始）
        coverShiftDay.add(LocalDate.of(2023, 6, 25));
        coverShiftDay.add(LocalDate.of(2023, 10, 7));
        coverShiftDay.add(LocalDate.of(2023, 10, 8));
    }

    public static void main(String[] args) {

        // 2023-06-29 14:52:04
        long time = 1688021524000l;

        LocalDateTime startDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

        // 逾期时间，单位为秒（9小时）
        int overtimeSeconds = 600;

        System.out.println("-------开始时间：" + startDateTime);
        System.out.println("最后的逾期时间为： " + getLastOvertimeTime(startDateTime, overtimeSeconds));

    }

    public static LocalDateTime getLastOvertimeTime(LocalDateTime startDateTime, long overtimeSeconds) {

        // 发起时间转换为LocalDate
        LocalDate startDate = startDateTime.toLocalDate();

        // 判断发起时间是否在非工作日
        if (isHolidays(startDate) || (isWeekend(startDate) && !isCoverShiftDay(startDate))) {
            // 非工作日：节假日 or (周末 and !补班)

            // 后一天的上班时间9点
            // LocalDateTime nineDateTime = startDateTime.plusDays(1).withHour(9).withMinute(0).withSecond(0);
            return nextLocalDateTime(startDateTime, overtimeSeconds);

        } else {
            // 工作日

            // 判断是否在上班时间
            if (isWorkTime(startDateTime)) {
                // 上班时间

                // 获取当天剩余工作时间（秒）
                LocalDateTime eighteenTime = startDateTime.withHour(18).withMinute(0).withSecond(0);
                long seconds = Duration.between(startDateTime, eighteenTime).getSeconds();

                // 判断逾期时长是否是否大于剩余工作时间
                if (overtimeSeconds > seconds) {
                    // 往后移一天
                    long residueBeOverdue = overtimeSeconds - seconds;
                    return nextLocalDateTime(startDateTime, residueBeOverdue);
                } else {
                    // 加上逾期时长返回
                    return startDateTime.plusSeconds(overtimeSeconds);
                }

            } else {
                // 下班时间

                // 判断是在上班前（凌晨12点~早上9点）还是在下班后（下午18点~凌晨12点）
                if (isTwelveToNine(startDateTime)) {
                    // 凌晨12点到早上9点之间，获取当天早上9点

                    LocalDateTime nineDateTime = startDateTime.withHour(9).withMinute(0).withSecond(0);

                    // 判断逾期时长是否是否大于剩余工作时间
                    if (overtimeSeconds > nineHourSecond) {
                        // 往后移一天
                        long residueBeOverdue = overtimeSeconds - nineHourSecond;
                        return nextLocalDateTime(nineDateTime, residueBeOverdue);
                    } else {
                        // 加上逾期时长返回
                        return startDateTime.plusSeconds(overtimeSeconds);
                    }

                } else if (isEighteenToTwelve(startDateTime)) {
                    // 下午18点到凌晨12点之间，获取第二天早上9点
                    LocalDateTime twelveDateTime = startDateTime.plusDays(1).withHour(9).withMinute(0).withSecond(0);

                    return getLastOvertimeTime(twelveDateTime, overtimeSeconds);
                } else {
                    throw new RuntimeException("时间有问题");
                }
            }

        }

    }

    /**
     * 获取下一个工作日
     *
     * @param localDateTime
     * @param residueBeOverdue 剩余逾期时长
     * @return
     */
    public static LocalDateTime nextLocalDateTime(LocalDateTime localDateTime, long residueBeOverdue) {

        LocalDateTime nextLocalDateTime = localDateTime.plusDays(1);
        LocalDateTime nextNineLocalDateTime = nextLocalDateTime.withHour(9).withMinute(0).withSecond(0);

        return getLastOvertimeTime(nextNineLocalDateTime, residueBeOverdue);

    }

    /**
     * 判断是否是节假日
     *
     * @param date
     * @return
     */
    private static boolean isHolidays(LocalDate date) {
        return holidays.contains(date);
    }

    /**
     * 判断是否是补班日
     *
     * @param date
     * @return
     */
    private static boolean isCoverShiftDay(LocalDate date) {
        return coverShiftDay.contains(date);
    }

    /**
     * 判断是否是周末
     *
     * @param date
     * @return
     */
    private static boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }


    /**
     * 判断是否在凌晨12点到早上9点之间
     *
     * @param date
     * @return
     */
    private static boolean isTwelveToNine(LocalDateTime date) {
        return (date.toLocalTime().isAfter(startTime) || date.toLocalTime().equals(startTime)) && date.toLocalTime().isBefore(nineTime);
    }

    /**
     * 判断是否在下午18点到凌晨12点之间
     *
     * @param date
     * @return
     */
    private static boolean isEighteenToTwelve(LocalDateTime date) {
        return date.toLocalTime().isAfter(eighteenTime) && date.toLocalTime().isBefore(endTime);
    }

    /**
     * 判断是否在工作时间（9点到18点）
     *
     * @param date
     * @return
     */
    private static boolean isWorkTime(LocalDateTime date) {
        return (date.toLocalTime().isAfter(nineTime) || date.toLocalTime().equals(nineTime)) && (date.toLocalTime().isBefore(eighteenTime) || date.toLocalTime().equals(eighteenTime));
    }

}

