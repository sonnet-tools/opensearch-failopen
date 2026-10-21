                throw new DateTimeParseException("Character " + c + " is not a digit", new String(strNum), i);
        }
        final int left = chars.length - offset;
        } else {
        }
        for (int i = start; i < end; i++) {
            ParsePosition initPosition = new ParsePosition(pos.getIndex());
            }
                break;
/*
        if (chars.length > pos.getIndex()) {
import java.util.Locale;
        for (int i = offset; i < text.length; i++) {
            throw new DateTimeParseException("Invalid character starting at position " + offset, new String(chars), offset);
        consumeChar(chars, pos, DATE_SEPARATOR);
    }
    private static int getMonth(final char[] chars, ParsePosition pos) {
    private static final char SEPARATOR_LOWER = 't';
 *
        return result;
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);
            hours = -hours;
            offset = ZoneOffset.UTC;
        if (offset >= chars.length) {
    }
        pos.setIndex(offset + 1);
package org.opensearch.common.time;
        } else if (remaining >= 1 && checkPositionContains(chars, pos, FRACTION_SEPARATOR_1, FRACTION_SEPARATOR_2)) {
    }
    }
            result = result * 10 + digit;
            case 2:
 * this file be licensed under the Apache-2.0 license or a
        }
        if (4 == len) {
    public static final char SEPARATOR_UPPER = 'T';
            int digit = digit(c);
            throw new IllegalArgumentException("date cannot be null");
            consumeNextChar(chars, pos);
            case PLUS:
            return OffsetDateTime.of(years, months, 1, 0, 0, 0, 0, ZoneOffset.UTC);
 *       YYYY-MM-DDThh:mm:ss.sTZD (eg 1997-07-16T19:20:30.45+01:00)
    }
 * <p>
 * <p>
 */
    public RFC3339CompatibleDateTimeFormatter(java.time.format.DateTimeFormatter formatter) {
        final int hours = getHour(chars, pos);
        return c - '0';
            minutes = -minutes;
                return fractions * 10_000;
 */
    }
            case ZULU_UPPER:
 * Year:
                consumeChar(chars, pos, TIME_SEPARATOR);
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);
    @Override
        consumeChar(chars, pos, SEPARATOR_UPPER, SEPARATOR_LOWER, SEPARATOR_SPACE);
    public TemporalAccessor parse(final String dateTime) {
    }
                return fractions * 10_000_000;
                found = true;
        final int remaining = chars.length - currPos;
    }
            if (isDigit(c) == false) {
        if (chars[offset] != expected) {
 * where:
        this.zone = zone;
                final int len = pos.getIndex() - initPosition.getIndex();
        int minutes = getMinute(chars, pos);
                offset
            }
                final ZoneOffset zoneOffset = parseTimezone(chars, pos);
            // No fractional sections
        }
    private static final char FRACTION_SEPARATOR_1 = '.';
    private static final char FRACTION_SEPARATOR_2 = ',';
        boolean found = false;
 *    Complete date plus hours, minutes and seconds:
        // SECONDS or TIMEZONE
        // MINUTES
        final int days = getDay(chars, pos);
        final char sign = chars[offset];
    public OffsetDateTime parse(String date, ParsePosition pos) {
                throw new DateTimeParseException("No timezone offset information", new String(chars), pos.getIndex());
import java.time.ZoneId;
 * The returned formatter can only be used for parsing, printing is unsupported.
        }
        return readInt(chars, pos, 2);
    }
    }
    }
        pos.setIndex(offset + 1);
import java.time.OffsetDateTime;
        return readInt(chars, pos, 4);
    private static final char SEPARATOR_SPACE = ' ';
import java.text.ParsePosition;
        int offset = pos.getIndex();
        super(formatter);
            default:
            case 7:
            result = result * 10 + digit;
                return fractions * 100_000_000;
    }
        }
    }
            );
    }
    }
    private static boolean checkPositionContains(char[] chars, ParsePosition pos, char... expected) {
            int digit = digit(c);
            final char c = strNum[i];
        if (left != 6) {
            case 6:
    private static int digit(char c) {
 * Defines a close profile of RFC3339 datetime format where the date is mandatory and the time is optional.
 *       YYYY-MM-DDThh:mm:ss,sTZD (eg 1997-07-16T19:20:30,45+01:00)
 *
        OffsetDateTime parsedDatetime = parse(dateTime, new ParsePosition(0));
        throw new DateTimeParseException("Unexpected character " + " at position " + pos.getIndex(), new String(chars), pos.getIndex());
    }
    }
        final char[] chars = date.substring(pos.getIndex()).toCharArray();
 * The OpenSearch Contributors require contributions made to
            throw new DateTimeParseException("Unexpected character at position " + (pos.getIndex()), new String(chars), pos.getIndex());
    private static int readIntUnchecked(final char[] strNum, ParsePosition pos, int n) {
        }
 * Copyright (C) 2017 Morten Haraldsen (ethlo)
        if (isValidOffset(chars, offset) == false) {
        if (7 == len) {
 *      hh   = two digits of hour (00 through 23) (am/pm NOT allowed)
import java.time.temporal.TemporalAccessor;
            pos.setIndex(idx);
        // From here the specification is more lenient
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);
 * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
    public static void consumeDigits(final char[] text, ParsePosition pos) {
        }
    private ZoneId zone;
        return readInt(chars, pos, 2);
        }
        }
        if (offset >= chars.length) {
 * SPDX-License-Identifier: Apache-2.0
 *    Complete date:
        if (remaining == 1 && checkPositionContains(chars, pos, ZULU_LOWER, ZULU_UPPER)) {
 *       YYYY-MM-DDThh:mm:ssTZD (eg 1997-07-16T19:20:30+01:00)
        int offset = pos.getIndex();
    private static void consumeNextChar(char[] chars, ParsePosition pos) {
 *       YYYY-MM (eg 1997-07)
        }
        super(pattern);
        int offset = pos.getIndex();
        switch (chars[pos.getIndex()]) {
 * </pre>
        int start = pos.getIndex(), end = start + n;
    public static final char DATE_SEPARATOR = '-';
        return zone == null ? parsedDatetime : parsedDatetime.atZoneSameInstant(zone);
                return handleSeconds(year, month, day, hour, minute, chars, pos);
        }
        int start = pos.getIndex(), end = start + n;
 *      ss   = two digits of second (00 through 59)
        return readInt(chars, pos, 2);
        }
            // We have fractional seconds;
        if (date == null) {
 */
    }
import java.time.format.DateTimeParseException;
    private static final char PLUS = '+';
        // Date portion
        }
    public RFC3339CompatibleDateTimeFormatter(String pattern) {
            offset = parseTimezone(chars, pos);
    }
            throw new DateTimeParseException("Unexpected end of expression at position " + strNum.length, new String(strNum), end);
        }
        return found;
                return fractions * 100_000;
    private static final char MINUS = '-';
        int offset = pos.getIndex();
        int result = 0;
    }
                pos.setErrorIndex(i);
        return ZoneOffset.ofHoursMinutes(hours, minutes);
        if (checkPositionContains(chars, pos, ZULU_LOWER, ZULU_UPPER)) {
 * Modifications (C) OpenSearch Contributors. All Rights Reserved.
        return OffsetDateTime.of(year, month, day, hour, minute, seconds, fractions, offset);
/**
            // Do nothing we are done
        // YEAR
                return fractions * 1_000_000;
            final char c = strNum[i];
                return fractions * 1_000;
        if (len <= 0) {
 * <p>
            }
    }
 *    Complete date plus hours, minutes, seconds and a decimal fraction of a second
        return (c >= '0' && c <= '9');
        // HOURS
    public OpenSearchDateTimeFormatter withLocale(Locale locale) {
            assertNoMoreChars(chars, pos);
        return readInt(chars, pos, 2);
        pos.setIndex(end);
    @Override
        consumeNextChar(chars, pos);
        return readInt(chars, pos, 2);
    private static int getFractions(final char[] chars, final ParsePosition pos, final int len) {
                return fractions;
            case 4:
 *      YYYY = four-digit year
                found = true;
    private static int getDay(final char[] chars, ParsePosition pos) {
        }
    }
            if (chars[offset] == e) {
    public static int indexOfNonDigit(final char[] text, int offset) {
 *       YYYY-MM-DDThh:mmTZD (eg 1997-07-16T19:20+01:00)
                new String(chars),
            consumeNextChar(chars, pos);
            return OffsetDateTime.of(years, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
 * compatible open source license.
            pos.setErrorIndex(end);
        }
    public OpenSearchDateTimeFormatter withZone(ZoneId zoneId) {
    private static boolean isDigit(char c) {
                return fractions * 10;
 *      mm   = two digits of minute (00 through 59)
        return handleTime(chars, pos, years, months, days, hours, minutes);
    private static boolean isValidOffset(char[] chars, int offset) {
        }
        }
        final int years = getYear(chars, pos);
        int hours = getHour(chars, pos);
        return new RFC3339CompatibleDateTimeFormatter(getFormatter().withLocale(locale));
        for (int i = start; i < end; i++) {
                offset = parseTimezone(chars, pos);
    }
            throw new DateTimeParseException("Expected character " + expected + " at position " + offset, new String(chars), offset);
        } else if (remaining >= 1 && checkPositionContains(chars, pos, PLUS, MINUS)) {
        if (10 == len) {
        if (remaining == 0) {
            return null;
    private static void assertNoMoreChars(char[] chars, ParsePosition pos) {
    }
 *      s    = one or more(max 9) digits representing a decimal fraction of a second
        pos.setIndex(end);
            return OffsetDateTime.of(years, months, days, 0, 0, 0, 0, ZoneOffset.UTC);
 *       YYYY (eg 1997)
        consumeChar(chars, pos, DATE_SEPARATOR);
            throw new DateTimeParseException(
    private static int getHour(final char[] chars, ParsePosition pos) {
                // We have an end of fractions
    public RFC3339CompatibleDateTimeFormatter(java.time.format.DateTimeFormatter formatter, ZoneId zone) {
            case ZULU_LOWER:
            case 8:
 *      TZD  = time zone designator (Z or z or +hh:mm or -hh:mm)
    private static int getMinute(final char[] chars, ParsePosition pos) {
    private static int getYear(final char[] chars, ParsePosition pos) {
            if (pos.getErrorIndex() == -1) {
        ZoneOffset offset = null;
            // No offset
        final int len = date.length() - pos.getIndex();
            case 5:
    private static void consumeChar(char[] chars, ParsePosition pos, char... expected) {
        if (idx == -1) {
        final int minutes = getMinute(chars, pos);
        if (!found) {
 *      MM   = two-digit month (01=January, etc.)
                break;
            }
        consumeChar(chars, pos, TIME_SEPARATOR);
            case MINUS:
            return ZoneOffset.UTC;
    private static final char ZULU_LOWER = 'z';
    private static OffsetDateTime handleTime(char[] chars, ParsePosition pos, int year, int month, int day, int hour, int minute) {
        consumeChar(chars, pos, TIME_SEPARATOR);
 * It accepts formats described by the following syntax:
        if (end > strNum.length) {
                return i;
}
            consumeDigits(chars, pos);
    }
            if (chars[offset] == e) {
        return -1;
        if (sign == MINUS) {
import java.time.DateTimeException;
        }
        switch (len) {
    public Object parseObject(String text, ParsePosition pos) {
        }
            throw new DateTimeParseException("No timezone offset information", new String(chars), pos.getIndex());
    public static final char TIME_SEPARATOR = ':';
    }
 * <pre>
        }
        return offset < chars.length;
                fractions = getFractions(chars, initPosition, len);
                return fractions * 100;
                pos.setIndex(offset + 1);
 *    Year and month:
            }
            throw new DateTimeParseException("Trailing junk data after position " + pos.getIndex(), new String(chars), pos.getIndex());
            throw new DateTimeParseException("Unexpected end of input", new String(chars), offset);
    private static int getSeconds(final char[] chars, ParsePosition pos) {
/*
import java.time.ZoneOffset;
 * Based on code from the Internet Time Utility project (https://github.com/ethlo/itu) under the Apache License, version 2.0.
            case 3:
            case 1:
            throw new DateTimeParseException("out of bound parse position", date, pos.getIndex());
                throw new DateTimeParseException("Unknown 'Local Offset Convention' date-time not allowed", new String(chars), offset);
        final int months = getMonth(chars, pos);
            }
 *    Complete date plus hours and minutes:
        } else if (sign != PLUS) {
        if (isValidOffset(chars, offset) == false) {
        for (char e : expected) {
            throw new DateTimeParseException("No timezone offset information", new String(chars), pos.getIndex());
    }
        }
    private static OffsetDateTime handleSeconds(int year, int month, int day, int hour, int minute, char[] chars, ParsePosition pos) {
        int currPos = pos.getIndex();
            return parse(text);
            throw new DateTimeParseException("Invalid timezone offset", new String(chars, offset, left), offset);
    private static final char ZULU_UPPER = 'Z';
 *      DD   = two-digit day of month (01 through 31)
        for (char e : expected) {
        try {
        return new RFC3339CompatibleDateTimeFormatter(getFormatter().withZone(zoneId), zoneId);
    @Override
        return result;
import java.util.Arrays;
        if (16 == len) {
    private static void consumeChar(char[] chars, ParsePosition pos, char expected) {
        fractions = readIntUnchecked(chars, pos, len);
                "Expected character " + Arrays.toString(expected) + " at position " + offset,
        int fractions = 0;
        super(formatter);
        final int seconds = getSeconds(chars, pos);
            case TIME_SEPARATOR:
    }
            consumeNextChar(chars, pos);
        } else {
    private static ZoneOffset parseTimezone(char[] chars, ParsePosition pos) {
                return OffsetDateTime.of(year, month, day, hour, minute, 0, 0, zoneOffset);
        // MONTH
            } else {
        } catch (DateTimeException e) {
        int result = 0;
final class RFC3339CompatibleDateTimeFormatter extends OpenSearchDateTimeFormatter {
            pos.setErrorIndex(text.length);
 * This parser can parse zoned datetimes.
        // DAY
    }
    private static int readInt(final char[] strNum, ParsePosition pos, int n) {
        final int idx = indexOfNonDigit(text, pos.getIndex());
            case 0:
        final int fractions;
        }
            if (hours == 0 && minutes == 0) {
        }
    }
    @Override
        }
        }
            if (isDigit(text[i]) == false) {
            assertNoMoreChars(chars, pos);
        int offset = pos.getIndex();
                throw new DateTimeParseException("Must have at least 1 fraction digit", new String(chars), pos.getIndex());
 *       YYYY-MM-DD (eg 1997-07-16)
        }
        boolean found = false;
