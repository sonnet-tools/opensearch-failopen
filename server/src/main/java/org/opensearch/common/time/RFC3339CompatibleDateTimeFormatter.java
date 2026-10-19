                return fractions * 100_000;
        return readInt(chars, pos, 2);
 *    Complete date plus hours, minutes and seconds:
            case ZULU_UPPER:
 *    Complete date plus hours and minutes:  
        int start = pos.getIndex(), end = start + n;  
        if (offset >= chars.length) {
        }
        }
        for (int i = start; i < end; i++) {
            }  
        return readInt(chars, pos, 2);
                consumeChar(chars, pos, TIME_SEPARATOR);  
 *      TZD  = time zone designator (Z or z or +hh:mm or -hh:mm)
    }  
    public RFC3339CompatibleDateTimeFormatter(java.time.format.DateTimeFormatter formatter) {
 *      s    = one or more(max 9) digits representing a decimal fraction of a second  
            int digit = digit(c);
        int result = 0;
 * compatible open source license.
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);
 * It accepts formats described by the following syntax:
            // We have fractional seconds;
                offset  
        this.zone = zone;
                return fractions;  
            return null;
        }
        if (end > strNum.length) {
        consumeNextChar(chars, pos);
            consumeNextChar(chars, pos);  
        }
 *
    }
        return -1;
    }
    public OffsetDateTime parse(String date, ParsePosition pos) {  
                "Expected character " + Arrays.toString(expected) + " at position " + offset,
            throw new DateTimeParseException("out of bound parse position", date, pos.getIndex());
    }  
        final char sign = chars[offset];  
                pos.setIndex(offset + 1);
    private static OffsetDateTime handleTime(char[] chars, ParsePosition pos, int year, int month, int day, int hour, int minute) {  
 *      mm   = two digits of minute (00 through 59)
        return result;
        if (idx == -1) {  
 *       YYYY (eg 1997)
        consumeChar(chars, pos, DATE_SEPARATOR);  
            hours = -hours;  
    private static boolean isValidOffset(char[] chars, int offset) {
        if (checkPositionContains(chars, pos, ZULU_LOWER, ZULU_UPPER)) {
        // MINUTES
        switch (len) {
                break;
        final int remaining = chars.length - currPos;
 * <p>
 *
            );
 * Based on code from the Internet Time Utility project (https://github.com/ethlo/itu) under the Apache License, version 2.0.  
        }
                found = true;  
    public static final char TIME_SEPARATOR = ':';  
        ZoneOffset offset = null;
        }
        } else {
        for (char e : expected) {
        int hours = getHour(chars, pos);
            case 6:
        // YEAR
    }  
 *       YYYY-MM (eg 1997-07)  
        final int left = chars.length - offset;
                found = true;
        for (int i = start; i < end; i++) {
        switch (chars[pos.getIndex()]) {
                throw new DateTimeParseException("Character " + c + " is not a digit", new String(strNum), i);
    @Override
    }
                break;  
        // SECONDS or TIMEZONE
    }
    private static int getHour(final char[] chars, ParsePosition pos) {
        }  
        }  
        int start = pos.getIndex(), end = start + n;  
        int minutes = getMinute(chars, pos);
import java.time.ZoneId;
        return new RFC3339CompatibleDateTimeFormatter(getFormatter().withLocale(locale));  
    private static final char SEPARATOR_LOWER = 't';
            offset = parseTimezone(chars, pos);  
            // No fractional sections
            }
        int offset = pos.getIndex();
                return fractions * 10;
    }
import java.util.Arrays;
    }  
 *      ss   = two digits of second (00 through 59)
            } else {
    }
        if (!found) {
        for (int i = offset; i < text.length; i++) {
    private static final char MINUS = '-';  
        int offset = pos.getIndex();  
            if (isDigit(text[i]) == false) {  
 *      hh   = two digits of hour (00 through 23) (am/pm NOT allowed)  
            final char c = strNum[i];
                // We have an end of fractions  
            case ZULU_LOWER:  
package org.opensearch.common.time;
final class RFC3339CompatibleDateTimeFormatter extends OpenSearchDateTimeFormatter {
import java.text.ParsePosition;
    @Override
            pos.setIndex(idx);  
            case 3:
            case 7:
 * <pre>
                return fractions * 100_000_000;
    }  
    }
        // HOURS  
        }  
 * SPDX-License-Identifier: Apache-2.0
        if (10 == len) {
                final ZoneOffset zoneOffset = parseTimezone(chars, pos);
        if (len <= 0) {  
                return i;
        int fractions = 0;  
            case TIME_SEPARATOR:
        super(pattern);
        final char[] chars = date.substring(pos.getIndex()).toCharArray();  
        fractions = readIntUnchecked(chars, pos, len);  
        }  
        }
        super(formatter);
 */  
    public static final char DATE_SEPARATOR = '-';
        throw new DateTimeParseException("Unexpected character " + " at position " + pos.getIndex(), new String(chars), pos.getIndex());
 *      YYYY = four-digit year  
        if (chars.length > pos.getIndex()) {  
import java.util.Locale;  
            throw new DateTimeParseException("Unexpected character at position " + (pos.getIndex()), new String(chars), pos.getIndex());
        // MONTH
            return ZoneOffset.UTC;
                throw new DateTimeParseException("No timezone offset information", new String(chars), pos.getIndex());
    public Object parseObject(String text, ParsePosition pos) {
        pos.setIndex(end);
            case 1:
            return OffsetDateTime.of(years, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            }
            final char c = strNum[i];  
            throw new DateTimeParseException("No timezone offset information", new String(chars), pos.getIndex());
        if (4 == len) {  
        int offset = pos.getIndex();
        final int days = getDay(chars, pos);
 * Defines a close profile of RFC3339 datetime format where the date is mandatory and the time is optional.  
        // DAY
            if (hours == 0 && minutes == 0) {  
    private static int readInt(final char[] strNum, ParsePosition pos, int n) {
    private static int getDay(final char[] chars, ParsePosition pos) {
            return OffsetDateTime.of(years, months, days, 0, 0, 0, 0, ZoneOffset.UTC);  
        }
        }
        }
    private static int readIntUnchecked(final char[] strNum, ParsePosition pos, int n) {
        return new RFC3339CompatibleDateTimeFormatter(getFormatter().withZone(zoneId), zoneId);
                return fractions * 100;
            throw new DateTimeParseException(  
            case 5:  
    private static int getSeconds(final char[] chars, ParsePosition pos) {  
    private static OffsetDateTime handleSeconds(int year, int month, int day, int hour, int minute, char[] chars, ParsePosition pos) {
        return ZoneOffset.ofHoursMinutes(hours, minutes);  
        consumeChar(chars, pos, TIME_SEPARATOR);
        final int idx = indexOfNonDigit(text, pos.getIndex());
                new String(chars),
 *    Year and month:
    public TemporalAccessor parse(final String dateTime) {
            int digit = digit(c);
/**
        boolean found = false;  
            pos.setErrorIndex(text.length);
import java.time.format.DateTimeParseException;  
        }
            if (pos.getErrorIndex() == -1) {
            pos.setErrorIndex(end);
    public static int indexOfNonDigit(final char[] text, int offset) {
        }
            result = result * 10 + digit;
            case 2:  
                return fractions * 1_000_000;  
            assertNoMoreChars(chars, pos);
    private static final char PLUS = '+';
 * The OpenSearch Contributors require contributions made to  
            assertNoMoreChars(chars, pos);
            }  
 * </pre>
    private static final char ZULU_LOWER = 'z';  
 *       YYYY-MM-DDThh:mmTZD (eg 1997-07-16T19:20+01:00)
/*  
            return parse(text);  
        return readInt(chars, pos, 4);  
 */  
                pos.setErrorIndex(i);
        // From here the specification is more lenient
                fractions = getFractions(chars, initPosition, len);
    }
            // Do nothing we are done  
    public OpenSearchDateTimeFormatter withZone(ZoneId zoneId) {  
            result = result * 10 + digit;
    private static final char ZULU_UPPER = 'Z';
        return c - '0';
        pos.setIndex(offset + 1);
 * Modifications (C) OpenSearch Contributors. All Rights Reserved.
 *       YYYY-MM-DDThh:mm:ss.sTZD (eg 1997-07-16T19:20:30.45+01:00)
import java.time.DateTimeException;
        return result;
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);  
                return handleSeconds(year, month, day, hour, minute, chars, pos);
    private static void consumeNextChar(char[] chars, ParsePosition pos) {  
        return (c >= '0' && c <= '9');
            consumeNextChar(chars, pos);
 */  
        int result = 0;  
                return OffsetDateTime.of(year, month, day, hour, minute, 0, 0, zoneOffset);
    }  
        // Date portion
import java.time.ZoneOffset;
            if (chars[offset] == e) {
        }  
        }  
/*
    private static boolean checkPositionContains(char[] chars, ParsePosition pos, char... expected) {
    public static void consumeDigits(final char[] text, ParsePosition pos) {
    }
    }
    }
        return found;  
    }
            // No offset
        if (chars[offset] != expected) {  
            case 0:
        final int months = getMonth(chars, pos);  
            throw new DateTimeParseException("Trailing junk data after position " + pos.getIndex(), new String(chars), pos.getIndex());
    private static int getMonth(final char[] chars, ParsePosition pos) {
        consumeChar(chars, pos, SEPARATOR_UPPER, SEPARATOR_LOWER, SEPARATOR_SPACE);
            case PLUS:  
    @Override  
            minutes = -minutes;
            throw new DateTimeParseException("Invalid timezone offset", new String(chars, offset, left), offset);  
        if (remaining == 0) {  
    private static ZoneOffset parseTimezone(char[] chars, ParsePosition pos) {
        }  
        OffsetDateTime parsedDatetime = parse(dateTime, new ParsePosition(0));
    private static void assertNoMoreChars(char[] chars, ParsePosition pos) {
        if (isValidOffset(chars, offset) == false) {
    }
        consumeChar(chars, pos, TIME_SEPARATOR);  
            }
 * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        consumeChar(chars, pos, DATE_SEPARATOR);
        if (remaining == 1 && checkPositionContains(chars, pos, ZULU_LOWER, ZULU_UPPER)) {
                return fractions * 10_000;
            throw new DateTimeParseException("Expected character " + expected + " at position " + offset, new String(chars), offset);
        final int fractions;
        if (sign == MINUS) {
            throw new DateTimeParseException("Invalid character starting at position " + offset, new String(chars), offset);  
    }
        }  
        int offset = pos.getIndex();  
        return handleTime(chars, pos, years, months, days, hours, minutes);  
            if (isDigit(c) == false) {  
    private static final char FRACTION_SEPARATOR_2 = ',';
        super(formatter);  
 * The returned formatter can only be used for parsing, printing is unsupported.
        if (16 == len) {
 * where:
    public RFC3339CompatibleDateTimeFormatter(String pattern) {
    }  
 *       YYYY-MM-DDThh:mm:ssTZD (eg 1997-07-16T19:20:30+01:00)  
 * <p>  
        int currPos = pos.getIndex();
        }
    }
            case 8:  
        int offset = pos.getIndex();
        }
        pos.setIndex(offset + 1);  
        }  
                offset = parseTimezone(chars, pos);  
        final int minutes = getMinute(chars, pos);  
 * This parser can parse zoned datetimes.
        } else if (remaining >= 1 && checkPositionContains(chars, pos, PLUS, MINUS)) {
                return fractions * 10_000_000;
        }
        if (isValidOffset(chars, offset) == false) {
    public OpenSearchDateTimeFormatter withLocale(Locale locale) {
        } else if (remaining >= 1 && checkPositionContains(chars, pos, FRACTION_SEPARATOR_1, FRACTION_SEPARATOR_2)) {  
            }  
    private static boolean isDigit(char c) {  
import java.time.OffsetDateTime;  
            if (chars[offset] == e) {
            throw new DateTimeParseException("No timezone offset information", new String(chars), pos.getIndex());
            case 4:
            return OffsetDateTime.of(years, months, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        }  
        try {
        if (offset >= chars.length) {
        boolean found = false;
    private static final char SEPARATOR_SPACE = ' ';
    }
    public static final char SEPARATOR_UPPER = 'T';
        pos.setIndex(end);
        final int years = getYear(chars, pos);
        return readInt(chars, pos, 2);
        if (left != 6) {
 * Copyright (C) 2017 Morten Haraldsen (ethlo)
    private static int getMinute(final char[] chars, ParsePosition pos) {  
 *      DD   = two-digit day of month (01 through 31)
    }  
    private static void consumeChar(char[] chars, ParsePosition pos, char expected) {  
        } else if (sign != PLUS) {
import java.time.temporal.TemporalAccessor;
            throw new IllegalArgumentException("date cannot be null");
 * Year:  
                throw new DateTimeParseException("Must have at least 1 fraction digit", new String(chars), pos.getIndex());  
            ParsePosition initPosition = new ParsePosition(pos.getIndex());  
        final int hours = getHour(chars, pos);
        } else {
            throw new DateTimeParseException("Unexpected end of expression at position " + strNum.length, new String(strNum), end);  
 *      MM   = two-digit month (01=January, etc.)
        }
    }
    @Override  
        return offset < chars.length;  
 *    Complete date plus hours, minutes, seconds and a decimal fraction of a second
    private static final char FRACTION_SEPARATOR_1 = '.';  
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);  
    private static int digit(char c) {
        return OffsetDateTime.of(year, month, day, hour, minute, seconds, fractions, offset);
        if (7 == len) {
        }  
        }  
        return readInt(chars, pos, 2);  
                final int len = pos.getIndex() - initPosition.getIndex();
        return readInt(chars, pos, 2);
    private static int getYear(final char[] chars, ParsePosition pos) {
        final int seconds = getSeconds(chars, pos);  
 *    Complete date:
}
 * <p>  
        return zone == null ? parsedDatetime : parsedDatetime.atZoneSameInstant(zone);  
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);  
 * this file be licensed under the Apache-2.0 license or a
                throw new DateTimeParseException("Unknown 'Local Offset Convention' date-time not allowed", new String(chars), offset);
    }
            default:
    }  
    }
        for (char e : expected) {  
    private static void consumeChar(char[] chars, ParsePosition pos, char... expected) {  
            case MINUS:
                return fractions * 1_000;  
            offset = ZoneOffset.UTC;
            consumeDigits(chars, pos);
            consumeNextChar(chars, pos);
    private ZoneId zone;
        if (date == null) {
    }  
    private static int getFractions(final char[] chars, final ParsePosition pos, final int len) {
 *       YYYY-MM-DDThh:mm:ss,sTZD (eg 1997-07-16T19:20:30,45+01:00)  
        } catch (DateTimeException e) {
        final int len = date.length() - pos.getIndex();
 *       YYYY-MM-DD (eg 1997-07-16)
    public RFC3339CompatibleDateTimeFormatter(java.time.format.DateTimeFormatter formatter, ZoneId zone) {  
    }  
