     * <p>  
 * @author Brian S O'Neill  
                if (fields.remove(DateTimeFieldType.dayOfMonth())) {
    ) {
     * @since 1.1
     * ord-date-element  = yyyy ['-' DDD]  
     *
     *  removing those fields built in the formatter
            bld.appendMonthOfYear(2);
            return dt;
     * Returns a formatter that combines a full date and two digit hour of
 * Date-time formatting is performed by the {@link DateTimeFormatter} class.
        } else if (workingFields.contains(DateTimeFieldType.dayOfMonth())) {
        }  
     *
                return new DateTimeFormatterBuilder().append(weekDate()).append(tTimeNoMillis()).toFormatter();  
            }
     *  
    /**
     * std-date-element  = yyyy ['-' MM ['-' dd]]
    // -----------------------------------------------------------------------
     * time-element   = HH [minute-element] | [fraction]  
            bld.appendLiteral('-');
            bld.appendLiteral('-');
            }
                    .append(timeElementParser())
            }
            }  
     * @return a formatter for xxxx-'W'ww
    public static DateTimeFormatter hourMinuteSecondFraction() {  
    }
     * @return a formatter for yyyyMMdd  
            tpe = timeElementParser(), // time parser element
     *
        // -----------------------------------------------------------------------
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
            // d, // date (same as ymd)
                return new DateTimeFormatterBuilder().appendLiteral('-')
    }
                return new DateTimeFormatterBuilder().appendLiteral('-')  
    public static DateTimeFormatter localDateOptionalTimeParser() {
     * @since 1.3  
 */
            tt = tTime(),  // Ttime
        }
            if (strictISO && reducedPrec) {
        return Constants.dtx;
            if (hmsf == null) {
        // -----------------------------------------------------------------------
            } else {
 * The OpenSearch Contributors require contributions made to  
        private static DateTimeFormatter basicWeekDateTime() {  
    public static DateTimeFormatter year() {  
            }  
                                new DateTimeFormatterBuilder().append(monthElement())
            if (ttx == null) {
 */  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
                    .appendOptional(offsetElement().getParser())
                    .toFormatter();  
     *
        }
        private static DateTimeFormatter dateHourMinuteSecondMillis() {
            bwdt = basicWeekDateTime(), // basic week date time
     * 2005-W-5      2005W-5     weekyear/dayOfWeek *
            return dpe;
            return tt;  
            ldotp = localDateOptionalTimeParser(); // local date optional time parser  
     * @since 1.3  
    public static DateTimeFormatter yearMonthDay() {
            bwdtx = basicWeekDateTimeNoMillis(), // basic week date time no millis
        } else if (fields.remove(DateTimeFieldType.dayOfMonth())) {
 *
                    appendSeparator(bld, extended);  
                // --MM/--MM
     * This parser is initialised with the local (UTC) time zone.
     * separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSZ).
     * <pre>
     * Returns a basic formatter for a two digit hour of day, two digit minute
     * <pre>  
            odtx = ordinalDateTimeNoMillis(), // ordinal date time no millis
     */
     */
            }
     * ord-date-element  = yyyy ['-' DDD]  
    public static DateTimeFormatter ordinalDateTime() {
     * @return a formatter for xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ
                    bld.appendDayOfMonth(2);
                    bld.appendLiteral('W');
    /**
                    // those extra digits will be dropped.
        return Constants.tp;
     * The list provided may have overlapping fields, such as dayOfWeek and  
     * second-element = ':' ss [fraction]
     * The returned formatter can only be used for parsing, printing is unsupported.  
    public static DateTimeFormatter basicOrdinalDateTime() {
                                    new DateTimeParser[] {  
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * The returned formatter prints and parses only this format, which includes milliseconds.
        private static DateTimeFormatter dateHourMinuteSecondFraction() {  
                    // ES change, was .appendWeekOfWeekyear(2)  
            bld.append(Constants.we);  
        private static DateTimeFormatter time() {  
                } else {
     * If the input collection is unmodifiable then no side effect occurs.  
    public static DateTimeFormatter yearMonth() {
                        new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toParser() }
            bdtx = basicDateTimeNoMillis(), // basic date time no millis  
                            null }
     *
     * time-element      = HH [minute-element] | [fraction]
     * <li>weekyear
     * See {@link #dateParser()} for a more flexible parser that accepts different formats.
     * Returns a formatter for a full date as four digit weekyear, two digit  
     */  
     * Returns a formatter for a two digit hour of day, two digit minute of
     * --03          --03        monthOfYear  
     * hour, two digit second of minute, and time zone offset prefixed  
        return reducedPrec;  
        return Constants.od;
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * <p>
     * week of weekyear, and one digit day of week (xxxx-'W'ww-e).
 * <p>
                return new DateTimeFormatterBuilder().append(ordinalDate()).append(tTime()).toFormatter();  
    }  
            if (hms == null) {  
        }
                    .append(literalTElement())  
        private static DateTimeFormatter dateHourMinute() {  
                    .append(hourMinuteSecondFraction())
     * week-date-element = xxxx '-W' ww ['-' e]
     * <p>
     * @param fields  the fields
     * Creates a date using the calendar date format.
        private static DateTimeFormatter dateTimeParser() {
 */  
                                .append(minuteElement())  
    }  
     * 2005-W12-5    2005W125    weekyear/weekOfWeekyear/dayOfWeek
     * -084          -084        dayOfYear  
            if (btt == null) {
            }
        private static DateTimeFormatter weekDateTimeNoMillis() {
     * date-element      = std-date-element | ord-date-element | week-date-element
                return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).toFormatter();
     * The returned formatter can only be used for parsing, printing is unsupported.  
                    // YYYY/YYYY  
     * <p>
        } else if (fields.remove(DateTimeFieldType.dayOfWeek())) {
        }  
        private static DateTimeFormatter hourElement() {
     * fraction          = ('.' | ',') digit+
 *  
            if (od == null) {
            return ttx;
    /**  
                    .toFormatter();
     * hour, and two digit second of minute. (HH:mm:ss)
    /**  
     *  
                } else {
                    appendSeparator(bld, extended);  
     * <p>
     * <p>
     */
    /**  
            throw new IllegalArgumentException("No valid ISO8601 format for fields: " + fields);  
     *
     * digit year and three digit dayOfYear (yyyyDDD).
     */
                if (fields.remove(DateTimeFieldType.dayOfWeek())) {  
     * @param strictISO  true if only ISO formats allowed
 */
    /**
                return new DateTimeFormatterBuilder()
            }  
     * <p>  
     * second (HH:mm:ss.SSS). Parsing will parse up to 3 fractional second
     */  
    /**  
    // -----------------------------------------------------------------------
        }
     */
        }  
    public static DateTimeFormatter timeElementParser() {  
    public static DateTimeFormatter dateTime() {  
                return new DateTimeFormatterBuilder().appendLiteral('T').toFormatter();
                    // ES change, was .appendSecondOfMinute(2)  
            }
            return ym;
        return Constants.bdtx;  
                return new DateTimeFormatterBuilder().appendYear(4, 4)
            if (hm == null) {
     * <p>
            if (dhmsf == null) {
            bld.appendLiteral('-');
     * is higher in priority than dayOfWeek:  
     * Returns a formatter for a four digit weekyear, two digit week of
            return wwd;
        if (milli) {
     * fraction       = ('.' | ',') digit+  
            }  
        // -----------------------------------------------------------------------
     * time              = 'T' time-element [offset]
            if (dh == null) {  
     */  
    }
     * Returns a formatter for a four digit year. (yyyy)
            return sme;
     * <p>  
            if (datePresent) {
     * -20:30.040    -2030.040   minute/second/milli
                            .appendOptional(dayOfWeekElement().getParser())
     * Returns a formatter that combines a full weekyear date and time,
            hm = hourMinute(),   // hour minute  
     */
            ym = yearMonth(),  // year month
     * <pre>
            if (dwe == null) {
     * by 'T' ('T'HH:mm:ssZZ).
    /**  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                    .append(secondElement())
        return Constants.hde;
        return Constants.bwdt;  
     */
        return reducedPrec;
    }
     * The returned formatter can only be used for parsing, printing is unsupported.
                return new DateTimeFormatterBuilder().append(hourElement())
     * 2005-03       2005-03     year/monthOfYear
     * @since 1.1
                return new DateTimeFormatterBuilder().appendLiteral('-')
    }  
                    .appendTimeZoneOffset("Z", false, 2, 2)
     *
    public static DateTimeFormatter hour() {
     * The returned formatter prints and parses only this format, which includes milliseconds.
    public static DateTimeFormatter hourMinuteSecond() {  
            return bttx;  
        boolean hour = fields.remove(DateTimeFieldType.hourOfDay());  
     */
 *
 * For example, to format a date time in ISO format:
    /**
                return new DateTimeFormatterBuilder().append(date()).append(tTimeNoMillis()).toFormatter();
        boolean milli = fields.remove(DateTimeFieldType.millisOfSecond());  
        return Constants.dt;
            if (mhe == null) {  
     * of year, and two digit day of month (yyyy-MM-dd).  
        }
            }
            reducedPrec = dateByWeek(bld, workingFields, extended, strictISO);  
    /**
                    // ES change, was .appendYear(4, 9)
 * All methods have been marked with an "// ES change" commentary
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
     * The returned formatter prints and parses only this format, which includes milliseconds.
 * <p>
     * date-element      = std-date-element | ord-date-element | week-date-element
                    .appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2)
        boolean reducedPrec,
            if (we == null) {  
            if (odtx == null) {  
            odt = ordinalDateTime(), // ordinal date time  
            bld.appendLiteral('.');  
 * framework, rather than an absolute standard. As a result this provider has a
 *  Copyright 2001-2009 Stephen Colebourne  
    /**  
        private static DateTimeFormatter hourMinute() {
                return new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTimeNoMillis()).toFormatter();  
                    .toFormatter();
     */
     * @param fields  the fields  
    /**
        private static DateTimeFormatter hourMinuteSecondFraction() {  
        }
     */
     */  
    /**
            return bwd;  
                    .appendFractionOfSecond(3, 3)  
     * Appends the separator if necessary.
                    reducedPrec = true;
     * list, thus in the example, the calendar style is chosen as dayOfMonth
     * <p>  
     *
                    .toFormatter();
     * It accepts formats described by the following syntax:
                return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(tOffset).toFormatter();  
    /**
        }
            return bwdtx;
     * <p>
     * std-date-element  = yyyy ['-' MM ['-' dd]]  
        Collection<DateTimeFieldType> fields,
    /**  
            bdt = basicDateTime(), // basic date time
     */  
     * If the input collection is modifiable, then each field that was added to
     * <p>
    }  
     * Returns a basic formatter that combines a basic weekyear date and time,
     * <p>
     * Returns a basic formatter that combines a basic date and time without millis,
        private static DateTimeFormatter dateTimeNoMillis() {
        }  
        // date  
    // -----------------------------------------------------------------------  
        if (bld.canBuildFormatter() == false) {  
    /**
     * </pre>
     *
 *  distributed under the License is distributed on an "AS IS" BASIS,  
            if (bodtx == null) {
                            .appendOptional(  
        private static DateTimeFormatter dateElementParser() {  
     *  
    // -----------------------------------------------------------------------  
 * ISO8601 is the international standard for data interchange. It defines a  
                return new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinuteSecond()).toFormatter();  
        }  
        return Constants.bd;  
     * </pre>
                                            .toParser(),
                            )
     * <li>monthOfYear - calendar date style
            return ldp;  
     * ord-date-element  = yyyy ['-' DDD]
     * Returns a generic ISO time parser for parsing local times.  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * <p>
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
        boolean strictISO,
            }  
                    .appendFixedSignedDecimal(DateTimeFieldType.weekOfWeekyear(), 2)
                    .appendLiteral('.')
        return Constants.dh;
                    .append(weekElement())  
            if (bod == null) {  
     * @return a formatter for yyyyDDD  
     * </pre>
                                        null }
    }
package org.joda.time.format;
 * Three classes provide factory methods to create formatters, and this is one.  
    /**
     * Returns a formatter that combines a full date, two digit hour of day,  
            if (lte == null) {
                // YYYY/YYYY
            if (dye == null) {  
    public static DateTimeFormatter dateHourMinute() {
            // w, // weekyear (same as weekyear element)
        private static DateTimeFormatter literalTElement() {  
        }
                if (fields.remove(DateTimeFieldType.dayOfWeek())) {  
     * @return a formatter for yyyy-MM-dd'T'HH:mm  
import org.joda.time.DateTimeFieldType;
     * 10:20:30      102030      hour/minute/second
     */
                    .toFormatter();
    /**
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        boolean reducedPrec = false;
     */  
            return bod;  
    }
        }  
                                .toParser(),
     * @return a formatter for HH
     * hour, two digit second of minute, and three digit fraction of  
        boolean extended,
     * <p>
        }  
    /**
     *  
            ttx = tTimeNoMillis(),  // Ttime no millis  
     *  
                                    null,
        }
        }  
                        new DateTimeFormatterBuilder().append(weekyearElement())  
     * @since 1.1  
            if (fields.remove(DateTimeFieldType.weekOfWeekyear())) {
 * returns are as well.
                                    .toParser()  
        boolean datePresent = (workingFields.size() < inputSize);  
 *  Licensed under the Apache License, Version 2.0 (the "License");
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.  
            lte = literalTElement(), // literal 'T' element
                    bld.appendLiteral('-');
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
                    .append(
            bld.appendWeekOfWeekyear(2);
 * formats are {@link #date() date}, {@link #time() time}, and {@link #dateTime() dateTime}.  
        private static DateTimeFormatter dateOptionalTimeParser() {
                        new DateTimeFormatterBuilder().append(yearElement())
            }
        }  
     * @return a formatter for 'T'HH:mm:ss.SSSZZ
    /**
        }  
    /**
            bld.appendLiteral('-');  
     * <p>  
            hmsl = hourMinuteSecondMillis(), // hour minute second millis
        private static DateTimeFormatter fractionElement() {
     *
     * digits, throwing away all except the first three.
            }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
    public static DateTimeFormatter weekyearWeek() {  
     * date              = date-element ['T' offset]
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ssZZ
     * fraction          = ('.' | ',') digit+
            reducedPrec = true;
        return Constants.odt;  
            if (wdt == null) {
    }  
            bld.appendMinuteOfHour(2);
    public static DateTimeFormatter dateTimeNoMillis() {
     * The returned formatter prints and parses only this format, which excludes milliseconds.
            // -DDD/-DDD
 * A chronology with a ten day week would thus cause issues. However, in  
    /**  
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        }
        DateTimeFormatterBuilder bld,  
     * Returns a basic formatter that combines a basic weekyear date and time
     * The returned formatter prints and parses only this format, which includes milliseconds.  
     * @param datePresent  whether there was a date  
            if (ww == null) {  
                }
            if (dtx == null) {  
    /**
                    // ES change, was .appendHourOfDay(2)
     * <p>
    public static DateTimeFormatter dateOptionalTimeParser() {
     * @return a formatter for HH:mm  
            }
            if (ldotp == null) {
     * @param extended  true to use extended format  
        }
            hms = hourMinuteSecond(),  // hour minute second
        private static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
            }
     * <p>  
                    null,  
                    // ES change, was .appendWeekyear(4, 4)
                    new DateTimeParser[] {
     * <p>
     * This method examines the fields provided and returns an ISO-style
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        }
            if (dhm == null) {
        private static DateTimeFormatter timeParser() {
        if (workingFields.contains(DateTimeFieldType.monthOfYear())) {
            if (fields.remove(DateTimeFieldType.dayOfWeek())) {
     * It accepts formats described by the following syntax:
            }  
 *      http://www.apache.org/licenses/LICENSE-2.0  
     * 2005-084      2005084     year/dayOfYear
     * <p>
        return Constants.hm;  
        if (fields == null || fields.size() == 0) {
            return tx;
            if (fse == null) {
     * std-date-element  = yyyy ['-' MM ['-' dd]]
                return new DateTimeFormatterBuilder().appendLiteral("-W")
        if (!hour && !minute && !second && !milli) {
                    .toFormatter();  
            if (dotp == null) {
 *  You may obtain a copy of the License at
     * 2005-03-25    20050325    year/monthOfYear/dayOfMonth
     * <p>
                return new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTime()).toFormatter();
            ze = offsetElement(),  // zone offset element  
    // -----------------------------------------------------------------------
                            new DateTimeFormatterBuilder().append(decimalPoint).appendFractionOfHour(1, 9).toParser(),  
            tx = timeNoMillis(),  // time no millis
            if (dpe == null) {
     *
            dotp = dateOptionalTimeParser(), // date optional time parser
            return;
     * @return a formatter for xxxx-'W'ww-e  
     * weekyear. (xxxx-'W'ww)
     * <p>  
/*  
                return new DateTimeFormatterBuilder().appendLiteral('.')  
    protected StrictISODateTimeFormat() {  
            bodt = basicOrdinalDateTime(), // basic ordinal date time  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        }  
     * Returns a formatter that combines a full date and time without millis,
                // --MM-DD/--MMDD
/*
                        new DateTimeParser[] {  
                bld.appendDayOfYear(3);  
     */  
                return new DateTimeFormatterBuilder().append(literalTElement()).append(timeNoMillis()).toFormatter();
    /**
     * <p>
        }  
    public static DateTimeFormatter hourMinuteSecondMillis() {  
            }  
    }
     * of hour, two digit second of minute, and time zone offset prefixed by 'T'
    /**
        // side effect the input collection to indicate the processed fields
            }
     * @return a formatter for HH:mm:ss.SSS
                return new DateTimeFormatterBuilder().append(hourMinuteSecond()).append(offsetElement()).toFormatter();  
     * 10-30         10-30       hour/second *
     */  
 *  See the License for the specific language governing permissions and
    /**
            if (wwd == null) {
            }
            }
     * date-element      = std-date-element | ord-date-element | week-date-element  
        boolean second = fields.remove(DateTimeFieldType.secondOfMinute());
        private static DateTimeFormatter ordinalDate() {  
                    checkNotStrictISO(fields, strictISO);
     * fraction          = ('.' | ',') digit+
     * @param extended  whether to use the extended format  
     * offset            = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])  
                return new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).toFormatter();
            // -W-D/-W-D
     * @return a formatter for xxxx'W'wwe  
        private static DateTimeFormatter localDateOptionalTimeParser() {  
     * minute-element    = ':' mm [second-element] | [fraction]  
            }  
                                                new DateTimeFormatterBuilder().append(decimalPoint).appendFractionOfSecond(1, 9).toParser()  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
     * @since 1.1
        DateTimeFormatterBuilder bld,
    /**  
                    .appendOptional(timeElementParser().getParser())
            return bodtx;
    }
                    // time-element
 * @since 1.0
     * time-element      = HH [minute-element] | [fraction]
            if (btx == null) {  
     * 10            10          hour
                    .append(minuteElement())  
        return Constants.dhmsl;
        private static DateTimeFormatter timeElementParser() {  
     */
            bld.append(Constants.ye);
                return new DateTimeFormatterBuilder().append(date()).append(tTime()).toFormatter();  
    public static DateTimeFormatter timeNoMillis() {
    /**  
            if (mye == null) {
 * However there has been done one huge modification in several methods, which forces the date
    public static DateTimeFormatter basicDateTimeNoMillis() {
    /**
     */
     * std-date-element  = yyyy ['-' MM ['-' dd]]
            return dhms;
     * to 3 fractional second digits.  
                                .append(
 *  Unless required by applicable law or agreed to in writing, software
     * ord-date-element  = yyyy ['-' DDD]
     *
                ).toFormatter();
        }
                return new DateTimeFormatterBuilder().append(null, new DateTimeParser[] { time, dateOptionalTimeParser().getParser() })
        }
     * Returns a basic formatter for a two digit hour of day, two digit minute
     */  
            if (dt == null) {
        boolean minute = fields.remove(DateTimeFieldType.minuteOfHour());
            if (ye == null) {  
     * <p>
                    .toFormatter();
    public static DateTimeFormatter basicTTime() {
            bod = basicOrdinalDate(),  // basic ordinal date
     * </pre>
                return new DateTimeFormatterBuilder().append(literalTElement()).append(time()).toFormatter();
 *
            } else {
            btt = basicTTime(), // basic Ttime  
     * Returns a formatter for a full ordinal date and time without millis,
                    .append(timeElementParser())
     * second-element    = ':' ss [fraction]
                return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(time).toFormatter().withZoneUTC();  
     * @since 1.3  
    /**  
        }
     * @param extended  whether to append the separator
    /**
    }  
                return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).toFormatter();  
     * Returns a formatter for a full ordinal date and time, using a four
        if (extended && hour && minute) {
            bld.appendLiteral('W');  
            return hms;  
        private static DateTimeFormatter secondElement() {  
                return new DateTimeFormatterBuilder().append(ordinalDate()).append(tTimeNoMillis()).toFormatter();
        Set<DateTimeFieldType> workingFields = new HashSet<>(fields);
        return Constants.dpe;
     */  
     *
     */
            }
                    .appendTimeZoneOffset("Z", false, 2, 2)
                    reducedPrec = true;  
        boolean reducedPrec = false;  
     *
                return new DateTimeFormatterBuilder().appendLiteral(':')
        } else if (workingFields.contains(DateTimeFieldType.weekOfWeekyear())) {
     * digit year and three digit dayOfYear (yyyyDDD'T'HHmmss.SSSZ).  
     * Specification reference: 5.2.1.
    /**
    }
    }  
        if (strictISO) {
    static final class Constants {  
                    .toFormatter();
     * @return a formatter for HHmmssZ
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * week-date-element = xxxx '-W' ww ['-' e]  
     *
     * @return a formatter for yyyy-DDD'T'HH:mm:ss.SSSZZ
                    // YYYY-MM-DD/YYYYMMDD
     * Returns a formatter for a two digit hour of day, two digit minute of
     *
 * year to be exactly n digits, so that a year like "5" is invalid and must be "0005"  
        } else if (milli) {
     * 2005-W12      2005W12     weekyear/weekOfWeekyear  
     */
        private static DateTimeFormatter basicTTime() {
            if (bwdt == null) {
     * @param bld  the builder
     * Returns a generic ISO time parser.
            }  
    }
            return wdt;
            return mhe;  
     * @param fields  the fields  
     * without millis, separated by a 'T' (xxxx'W'wwe'T'HHmmssZ).
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            ymd = yearMonthDay(), // year month day
     * Returns a formatter that outputs only those fields specified.  
     *
            // y, // year (same as year element)  
            }
    /**
 * this file be licensed under the Apache-2.0 license or a
        }
                    )
 */  
     * Returns a formatter for a two digit hour of day, two digit minute of  
     * It accepts formats described by the following syntax:
        }
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
                                        // minute fraction  
 * in strict compliance with the standard.
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
        }
        private static DateTimeFormatter weekyearElement() {
    /**
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * using a four digit year and three digit dayOfYear (yyyy-DDD'T'HH:mm:ssZZ).
     * date-opt-time     = date-element ['T' [time-element] [offset]]
            sme = secondElement(), // secondOfMinute element (:ss)
            bld.appendLiteral('-');
            }
     * The returned formatter prints and parses only this format, which excludes milliseconds.  
        }
     * Returns a formatter for a four digit weekyear. (xxxx)
        }
    /**  
     * @param extended  true to use extended format  
            dt = dateTime(), // date time
            }
     * std-date-element  = yyyy ['-' MM ['-' dd]]
            od = ordinalDate(),  // ordinal date (same as yd)
     * <p>
     * second-element    = ':' ss [fraction]  
     * <p>
                appendSeparator(bld, extended);  
     *
     * date-element      = std-date-element | ord-date-element | week-date-element
     */
     * date-opt-time     = date-element ['T' [time-element] [offset]]  
        return Constants.tt;
        return Constants.ymd;  
     * --30.040      --30.040    second/milli
        }
            if (fields.remove(DateTimeFieldType.dayOfMonth())) {  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
                // YYYY-DDD/YYYYDDD
     * <li>dayOfWeek - week date style  
        return Constants.wwd;
        boolean reducedPrec = false;  
                return new DateTimeFormatterBuilder().append(basicDate()).append(basicTTime()).toFormatter();
        } else if (fields.remove(DateTimeFieldType.monthOfYear())) {
    }
                        null,
            bwd = basicWeekDate(),  // basic week date  
            }  
            mhe = minuteElement(), // minuteOfHour element (:mm)  
     * @return a formatter for xxxx  
     * Returns a formatter for a two digit hour of day, two digit minute of
        // -----------------------------------------------------------------------
                } else {
     *  
     * @return a formatter for yyyy-MM-dd'T'HH
            dhmsl = dateHourMinuteSecondMillis(), // date hour minute second millis
    private static void time(  
     * @return a formatter for yyyy-MM
     * @return a formatter for yyyy
            if (wwe == null) {
     * <p>  
            bld.append(Constants.ye);
 * ISODateTimeFormat is thread-safe and immutable, and the formatters it  
     *
     * digit year and three digit dayOfYear (yyyy-DDD'T'HH:mm:ss.SSSZZ).  
        private static DateTimeFormatter ordinalDateTimeNoMillis() {
                    .appendFixedSignedDecimal(DateTimeFieldType.dayOfMonth(), 2)
     * The returned formatter can only be used for parsing, printing is unsupported.  
    }
     * @param bld  the builder
     * @return a formatter for HH:mm:ss
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
        return Constants.hmsf;
                reducedPrec = true;
     *  
     * It accepts formats described by the following syntax:
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
                    .appendFixedSignedDecimal(DateTimeFieldType.secondOfMinute(), 2)
            bld.appendSecondOfMinute(2);
     * The returned formatter prints and parses only this format.  
        private static DateTimeFormatter timeNoMillis() {
        }  
     * @since 1.1
     * <p>
        }  
     * @return a formatter for 'T'HHmmss.SSSZ
    public static DateTimeFormatter weekDateTimeNoMillis() {
     * Returns a formatter for a full ordinal date, using a four
 *  limitations under the License.  
 * single digit, dayOfMonth being two digit and dayOfYear being three digit.
    }  
     * Returns a generic ISO datetime parser which parses either a date or a time or both.
        private static DateTimeFormatter basicWeekDate() {
            }  
     * The supported formats are:
        return Constants.bttx;  
            return bd;
        }
        }
                    .toFormatter();
     * @return a formatter for yyyyMMdd'T'HHmmssZ  
 * chronology, however there may be certain side effects with more unusual  
 * <p>
     * <p>
        private static DateTimeFormatter localDateParser() {
        if (second) {  
    }  
                                )  
     * <p>  
                    .withZoneUTC();
                DateTimeParser time = new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).toParser();
                // is required.
 * Modifications Copyright OpenSearch Contributors. See
     * time           = ['T'] time-element  
        Collection<DateTimeFieldType> fields,
     * <p>
     * <p>  
import java.util.HashSet;
            }
        }  
        }  
    }  
            wdt = weekDateTime(), // week date time
            // OK - HMSm/HMS/HM/H - valid in combination with date
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * @param extended  true to use the extended format (with separators)  
        }
            }  
     *
        return Constants.bod;
        private static DateTimeFormatter dayOfYearElement() {
    public static DateTimeFormatter dateParser() {  
 * <pre>  
     */
                DateTimeParser tOffset = new DateTimeFormatterBuilder().appendLiteral('T').append(offsetElement()).toParser();
    }  
                    .appendLiteral('W')
                return new DateTimeFormatterBuilder().append(weekyearElement())
        boolean reducedPrec = false;
        return Constants.tx;
     */  
                    .appendFixedSignedDecimal(DateTimeFieldType.dayOfYear(), 3)  
        }
     * <p>  
            bld.append(Constants.ye);  
     * <li>dayOfMonth - calendar date style
            bld.appendLiteral(':');
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        boolean strictISO
     * @param fields  the fields
     * @since 1.1  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
     * <p>  
                    .appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2)
            if (bdt == null) {
            return bodt;
                return new DateTimeFormatterBuilder().appendLiteral(':')
                return new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser())
            return fse;  
     */
 * @see DateTimeFormat
                // Decimal point can be either '.' or ','
     * digit year and three digit dayOfYear (yyyy-DDD).
    }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
                    .append(fractionElement())
                    // YYYY-WWW-D/YYYYWWWD
        if (hour && minute && second || (hour && !second && !milli)) {  
     * The returned formatter prints and parses only this format, which excludes milliseconds.
            if (ymd == null) {
     *
            }
     * @since 1.1 (previously private)
                    .toFormatter();  
     * <p>
 * For parsing, the formatters are more lenient and allow formats that are not
            return dme;
        private static final DateTimeFormatter ye = yearElement(),  // year element (yyyy)
            }
     * <p>  
    public static DateTimeFormatter basicDate() {
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional.
            wdtx = weekDateTimeNoMillis(), // week date time no millis  
                return new DateTimeFormatterBuilder().append(literalTElement()).append(basicTime()).toFormatter();  
            bld.appendDayOfYear(3);  
 *  you may not use this file except in compliance with the License.  
        // -----------------------------------------------------------------------
/**
     * Returns a formatter for a full ordinal date and time, using a four
            bld.appendLiteral('-');
            }
                    bld.appendMonthOfYear(2);
            return mye;
     * Returns a formatter for a full date as four digit year, two digit month
            return dwe;
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        return Constants.bodt;
                                            .appendOptional(
     * of hour, two digit second of minute, and time zone offset (HHmmssZ).  
        } else if (fields.remove(DateTimeFieldType.dayOfYear())) {  
     * <p>  
    public static DateTimeFormatter basicWeekDate() {
     * <pre>
        if (minute) {
     *
     */
        return Constants.ye;
     * 2005          2005        year
     * Creates a date using the ordinal date format.
        time(bld, workingFields, extended, strictISO, reducedPrec, datePresent);  
     * The returned formatter can only be used for parsing, printing is unsupported.
        } else if (workingFields.remove(DateTimeFieldType.year())) {
 * DateTime dt = new DateTime();
    public static DateTimeFormatter weekyear() {
                if (strictISO) {  
     * <ul>
        private static DateTimeFormatter yearElement() {
     * ord-date-element  = yyyy ['-' DDD]  
            fse = fractionElement(), // fractionOfSecond element (.SSSSSSSSS)
        if (extended) {  
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
                appendSeparator(bld, extended);
    }
     */
     * The returned formatter prints and parses only this format.
     * two digit minute of hour, two digit second of minute, and three digit
            return dhmsf;
     *
                    // ES change, was .appendWeekyear(4, 9)
                return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(timeOrOffset).toFormatter();
    }
    // -----------------------------------------------------------------------
     * @param fields  the fields
     * @param extended  true to use extended format
     * <li>dayOfYear - ordinal date style  
     * date-element      = std-date-element | ord-date-element | week-date-element  
                    .toFormatter()  
     * @return true if reduced precision
                    bld.appendLiteral('-');
     * two digit minute of hour, and two digit second of
    public static DateTimeFormatter basicTimeNoMillis() {  
     * to 9 fractional second digits, throwing away all except the first three.  
     * @return a suitable formatter
     * <p>  
 * <p>
     * This method can side effect the input collection of fields.  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
     * The returned formatter prints and parses only this format.
                if (fields.remove(DateTimeFieldType.dayOfMonth())) {
            return ye;  
            }
 * compatible open source license.
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.  
    }  
     * The returned formatter can only be used for parsing, printing is unsupported.  
            dye = dayOfYearElement(), // dayOfYear element (-DDD)
     * fraction of second (yyyy-MM-dd'T'HH:mm:ss.SSS). Parsing will parse up
            bld.append(Constants.we);
     * second (HH:mm:ss.SSS). Parsing will parse up to 9 fractional second
            } else {  
            if (bttx == null) {  
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * @return a formatter for yyyy-MM-dd  
     * two digit minute of hour, two digit second of minute, and three digit
    public static DateTimeFormatter forFields(Collection<DateTimeFieldType> fields, boolean extended, boolean strictISO) {  
        } else if (workingFields.contains(DateTimeFieldType.dayOfYear())) {  
     * <p>
     * day. (yyyy-MM-dd'T'HH)  
        }
     * <p>
            if (tpe == null) {
        private static DateTimeFormatter basicDate() {  
                return new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.dayOfYear(), 3).toFormatter();
        if (fields.remove(DateTimeFieldType.year())) {
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
        }  
    }
            dpe = dateElementParser(), // date parser element
            bttx = basicTTimeNoMillis(), // basic Ttime no millis
        }
        return Constants.wdt;
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss
        return Constants.ww;
     * Returns a formatter for a two digit hour of day and two digit minute of  
            btx = basicTimeNoMillis(),  // basic time no millis
                    .toFormatter();
    }
    public static DateTimeFormatter ordinalDateTimeNoMillis() {
     * The returned formatter prints and parses only this format.
     * pass in a modifiable list, and check that it is empty on exit.
     * 10:20         1020        hour/minute  
     * offset         = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])
     * -W12-5        -W125       weekOfWeekyear/dayOfWeek
            reducedPrec = dateByWeek(bld, workingFields, extended, strictISO);
                    .append(minuteElement())  
            }
     * Returns a formatter for a four digit year, two digit month of year, and  
            }
                    .append(timeElementParser())
     */  
     * Returns a basic formatter that combines a basic date and time, separated
    /**
    public static DateTimeFormatter localDateParser() {
     * @return a formatter for xxxx-'W'ww-e
     * week-date-element = xxxx '-W' ww ['-' e]
     * @return a formatter for yyyy-DDD  
        private static DateTimeFormatter yearMonthDay() {
 * It is important to understand that these formatters are not linked to
        boolean extended,  
     * <p>  
    }  
    public static DateTimeFormatter time() {  
        boolean datePresent  
    }  
        private static DateTimeFormatter dayOfMonthElement() {
     * <p>  
     * hour, two digit second of minute, and three digit fraction of  
        return Constants.hms;
                return new DateTimeFormatterBuilder()
        }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.  
                    null,
            if (bt == null) {
     * Returns a basic formatter for a two digit hour of day, two digit minute  
     * date-element      = std-date-element | ord-date-element | week-date-element
        private static DateTimeFormatter dateParser() {  
     * <p>  
    }  
     * the fields were converted into the formatter or not. To achieve this,  
     */
     * <p>
     * </ul>  
            dhms = dateHourMinuteSecond(),  // date hour minute second
     * time           = ['T'] time-element [offset]
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
     * Checks that the iso only flag is not set, throwing an exception if it is.
    }
                // OK - MSm/MS/M/Sm/S - valid ISO formats
            reducedPrec = dateByOrdinal(bld, workingFields, extended);
    }  
     * It accepts formats described by the following syntax:  
        }
 * Factory that creates instances of DateTimeFormatter based on the ISO8601 standard.  
                return new DateTimeFormatterBuilder().append(weekDate()).append(tTime()).toFormatter();
     * Returns a generic ISO date parser for parsing dates with a possible zone.
        private static DateTimeFormatter dateHourMinuteSecond() {
        return Constants.dhms;
     * The returned formatter can only be used for parsing, printing is unsupported.
            }  
            }
                    .appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2)
            bt = basicTime(),  // basic time
 *
        }
    public static DateTimeFormatter dateElementParser() {
                return new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinute()).toFormatter();
    public static DateTimeFormatter timeParser() {
     *  
                    .toFormatter();
     * * indicates that this is not an official ISO format and can be excluded  
    }
            bld.appendLiteral('-');  
     * This parser can parse zoned datetimes.  
                    .toFormatter();  
                return new DateTimeFormatterBuilder()
     * Returns a generic ISO date parser for parsing local dates.
        private static DateTimeFormatter basicTTimeNoMillis() {
        }
     *   plus datetime formats like {date}T{time}
                return new DateTimeFormatterBuilder().append(literalTElement()).append(basicTimeNoMillis()).toFormatter();
        // time
     * @return a formatter for xxxx'W'wwe'T'HHmmssZ  
                appendSeparator(bld, extended);
                    .toParser();  
     * <li>year
        private static DateTimeFormatter basicOrdinalDateTime() {  
     * This parser is initialised with the local (UTC) time zone.  
    // -----------------------------------------------------------------------  
            if (dhmsl == null) {  
 * <p>
                return new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).toFormatter();
    // -----------------------------------------------------------------------
        private static DateTimeFormatter basicWeekDateTimeNoMillis() {
            return ze;
     *
            }  
                    reducedPrec = true;
            dp = dateParser(),  // date parser  
        private static DateTimeFormatter yearMonth() {  
    /**  
     * </pre>
        return Constants.tpe;
                reducedPrec = true;  
     * <p>
            return bdt;
            }  
    /**  
     */
     * @since 1.1  
                bld.appendDayOfWeek(1);
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     *  
    }
            }
     * datetime          = time | date-opt-time
            return bdtx;
    }
        private static DateTimeFormatter localTimeParser() {
     *
        }  
     * @param bld  the builder
     * Specification reference: 5.2.3.
            }
     * digit week of weekyear, and one digit day of week (xxxx'W'wwe).
                DateTimeParser timeOrOffset = new DateTimeFormatterBuilder().appendLiteral('T')  
     * offset prefixed by 'T' ('T'HHmmss.SSSZ).
            dhm = dateHourMinute(),   // date hour minute  
            if (tx == null) {
        return Constants.ttx;  
     * second-element = ':' ss [fraction]  
     * @return a formatter for yyyyDDD'T'HHmmssZ
     * Returns a generic ISO date parser for parsing dates.
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.  
     * Returns a formatter that combines a full date, two digit hour of day,
     * Creates a date using the calendar date format.
     * @return a formatter for xxxx-'W'ww-e'T'HH:mm:ssZZ
                // This is different from the general time parser in that the 'T'
     */  
     * fraction of second (yyyy-MM-dd'T'HH:mm:ss.SSS). Parsing will parse up
            throw new IllegalArgumentException("The fields must not be null or empty");  
     * by a 'T' (yyyyMMdd'T'HHmmss.SSSZ).
     * offset            = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])  
                    .appendFixedSignedDecimal(DateTimeFieldType.hourOfDay(), 2)
     * This parser is initialised with the local (UTC) time zone.  
                return new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTimeNoMillis()).toFormatter();  
    }
     */
            }  
            if (ltp == null) {  
    public static DateTimeFormatter basicWeekDateTimeNoMillis() {
    private static boolean dateByOrdinal(DateTimeFormatterBuilder bld, Collection<DateTimeFieldType> fields, boolean extended) {
     * The returned formatter prints and parses only this format, which excludes milliseconds.
    // -----------------------------------------------------------------------
                                            // second fraction
                throw new IllegalArgumentException("No valid ISO8601 format for fields because Time was truncated: " + fields);
        }
    private static void appendSeparator(DateTimeFormatterBuilder bld, boolean extended) {
                    .toParser();  
    }
        } else if (minute || second || milli) {
        private static DateTimeFormatter dateHour() {
            if (sme == null) {
                return new DateTimeFormatterBuilder().append(hourMinuteSecondFraction()).append(offsetElement()).toFormatter();
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
     * <p>  
                    .append(hourMinuteSecondMillis())  
     * This side effect processing is useful if you need to know whether all
        private static DateTimeFormatter hourMinuteSecond() {
        }
     * Returns a formatter that combines a full date and time, separated by a 'T'
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
                        new DateTimeFormatterBuilder().appendLiteral('.').toParser(),  
/*  
            wwd = weekyearWeekDay(), // weekyear week day  
    public static DateTimeFormatter hourMinute() {
            wwe = weekElement(), // weekOfWeekyear element (-ww)
     * @since 1.1
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
    /**  
 *
     * <p>
     *
                return new DateTimeFormatterBuilder().append(date())
     * <p>
        }
    public static DateTimeFormatter dateHourMinuteSecondFraction() {
        return Constants.t;
 * In case you compare this with the original ISODateTimeFormat, make sure you use a diff
     * 10--.040      10--.040    hour/milli *
     * <p>
        }
        private static DateTimeFormatter basicTimeNoMillis() {
     * <p>
            return tpe;
     */  
            dtx = dateTimeNoMillis(), // date time no millis
                    // YYYY-WWW/YYYY-WWW
        if (hour) {
                    .append(dayOfWeekElement())
 * String str = fmt.print(dt);  
            return dotp;  
        private static DateTimeFormatter basicTime() {
                    bld.appendMonthOfYear(2);
    }
            // wd, // week date (same as wwd)
    }
                    .append(literalTElement())
     */
                    .appendOptional(offsetElement().getParser())
     * Returns a formatter that combines a full date, two digit hour of day,  
            } else {
        }
        DateTimeFormatterBuilder bld = new DateTimeFormatterBuilder();
     * <p>  
            }
                    throw new IllegalArgumentException("No valid ISO8601 format for fields: " + fields);
            if (wdtx == null) {
     * <pre>
            return bwdt;
            if (!hour && (minute && second || (minute && !milli) || second)) {  
 * </pre>
            if (bwd == null) {  
        return Constants.ym;
        } else if (workingFields.contains(DateTimeFieldType.dayOfWeek())) {  
    /**  
            return ltp;  
     * datetime          = date-element ['T' time-element]
            }
    /**
 * the <code>ISOChronology</code>. These formatters may be used with any
                return new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2)
    }
     * digits.
                reducedPrec = true;  
     * (yyyy-MM-dd'T'HH:mm:ss.SSSZZ).
     */
                    // YYYY/YYYY
 * number of methods that represent common uses of the framework. The most common
     * @since 1.1
     * Specification reference: 5.2.2.  
            return dye;  
        }
 * SPDX-License-Identifier: Apache-2.0
        Collection<DateTimeFieldType> fields,  
            if (bodt == null) {
            return dtx;  
        }
                    .toFormatter();
     */
     * of hour, two digit second of minute, three digit millis, and time zone  
                    bld.appendDayOfWeek(1);  
     * -20:30        -2030       minute/second  
     * hour, two digit second of minute, three digit fraction of second, and
        }
     * Returns a formatter for a two digit hour of day. (HH)  
    }
        int inputSize = workingFields.size();  
        }  
     * It accepts formats described by the following syntax:  
                            // hour fraction
     * @return a formatter for yyyyDDD'T'HHmmss.SSSZ
            } else {
            }
    /**  
     */
     * fraction       = ('.' | ',') digit+  
    public static DateTimeFormatter localTimeParser() {
            return dtp;
     * formatter that best fits. This can be useful for outputting  
     * The returned formatter prints and parses only this format.
        return Constants.ltp;  
     * Returns a formatter that combines a full date, two digit hour of day,  
            dtp = dateTimeParser(), // date time parser
     */  
                bld.appendDayOfMonth(2);  
        return Constants.bwd;  
     * <p>  
    private static boolean dateByWeek(
                    // YYYY-W-D/YYYYW-D (non-iso)
     *  
     *  
                }
                return new DateTimeFormatterBuilder().append(
                                            // second-element
        return Constants.bt;
        return Constants.odtx;
     * @param bld  the builder
                    .toFormatter();
     * Constructor.
import java.util.Set;
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
     * Returns a formatter for a four digit weekyear and two digit week of
                    .toFormatter();
     * @since 1.1
            t = time(),  // time  
                    .appendFractionOfSecond(3, 9)  
            }
     * week-date-element = xxxx '-W' ww ['-' e]  
     * ---.040       ---.040     milli *
     * See {@link #dateParser()} for a more flexible parser that accepts different formats.  
 * The others are {@link DateTimeFormat} and {@link DateTimeFormatterBuilder}.
     * Returns a formatter that combines a full weekyear date and time without millis,
            bld.appendLiteral('W');
            return dp;
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        }
            if (hmsl == null) {
     * <pre>  
        return Constants.ldp;  
     * of hour, two digit second of minute, three digit millis, and time zone
     * --30          --30        second  
     */
        private static DateTimeFormatter basicOrdinalDate() {
            }
        }
                    // ES change, was .appendDayOfYear(3)
            return odtx;  
     * @since 1.3  
            return btt;
            bld.appendLiteral('-');  
        return Constants.ldotp;  
        return Constants.wwd;  
     * <p>  
     * <p>
                return new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toFormatter();
                return dateElementParser().withZoneUTC();
            if (odt == null) {
                                        new DateTimeFormatterBuilder().append(decimalPoint).appendFractionOfMinute(1, 9).toParser(),
     * Returns a formatter for a two digit hour of day, two digit minute of
     * <pre>  
            }
     * <p>
     */
            return ww;  
        return Constants.dhm;  
                }
     * <p>  
    /**  
     * <p>
     * @return a formatter for HH:mm:ssZZ
     * by passing in <code>strictISO</code> as <code>true</code>.
     * </pre>
     * ---03         ---03       dayOfMonth
        }
            return we;  
            bd = basicDate(),  // basic date  
            }  
                    appendSeparator(bld, extended);
     */
 * @see DateTimeFormatterBuilder  
                DateTimeParser decimalPoint = new DateTimeFormatterBuilder().append(  
     * <p>
            }  
            dwe = dayOfWeekElement(), // dayOfWeek element (-ee)  
     * <p>  
 * Note that these formatters mostly follow the ISO8601 standard for printing.  
                    .toFormatter();  
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss.SSS
            if (bdtx == null) {
     * Extended      Basic       Fields  
        }
                    .appendFixedSignedDecimal(DateTimeFieldType.weekyear(), 4)  
        }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
    // -----------------------------------------------------------------------
     * @param strictISO  true to stick exactly to ISO8601, false to include additional formats
                    bld.appendLiteral('-');  
            }
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * @since 1.1  
            if (t == null) {
     */
     * time zone offset (HH:mm:ss.SSSZZ).
        DateTimeFormatterBuilder bld,
     * Adds the time fields to the builder.
     * <p>
     * <pre>  
        private static DateTimeFormatter weekElement() {  
                    .append(secondElement())
    /**  
     * The returned formatter can only be used for parsing, printing is unsupported.
     * -20-.040      -20-.040    minute/milli *  
    /**
    public static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
     */
        }
                return new DateTimeFormatterBuilder().append(date())
        try {  
     * @param bld  the builder
            ltp = localTimeParser(), // local time parser  
 * DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
            if (dtp == null) {  
     * time-element   = HH [minute-element] | [fraction]  
            reducedPrec = true;
    public static DateTimeFormatter basicTTimeNoMillis() {
                                            )
            }
    private static boolean dateByMonth(
                    .toFormatter();  
 * general, it is safe to use these formatters with other chronologies.
            bld.appendDayOfWeek(1);  
                    // YYYY-MM/YYYY-MM
            if (fields.remove(DateTimeFieldType.monthOfYear())) {  
            }
    ) {
            reducedPrec = dateByMonth(bld, workingFields, extended, strictISO);
        }  
    public static DateTimeFormatter ordinalDate() {  
                return new DateTimeFormatterBuilder().append(hourElement())
     * --03-25       --0325      monthOfYear/dayOfMonth
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
    public static DateTimeFormatter date() {
                    new DateTimeParser[] {
            bld.appendMillisOfSecond(3);
     *
     */
            return wdtx;
                    .appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2)  
        } else {
     * <p>
    }  
     * Returns a formatter for a full ordinal date, using a four  
     * Returns a basic formatter for a full date as four digit weekyear, two
     *  
     * ord-date-element  = yyyy ['-' DDD]
     * @return a formatter for 'T'HH:mm:ssZZ  
     * the formatter will be removed from the collection, including any duplicates.
            bld.appendLiteral('-');  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            bld.appendLiteral('-');
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss.SSS
            hde = hourElement(), // hourOfDay element (HH)
     * @param strictISO  whether to be strict
            return hde;
        return Constants.dtp;
        }
            }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
        private static DateTimeFormatter hourMinuteSecondMillis() {  
                    // ES change, was .appendMonthOfYear(2)  
        return Constants.wdtx;
            bld.appendLiteral('-');
            ww = weekyearWeek(),  // weekyear week
     * using a four digit year and three digit dayOfYear (yyyyDDD'T'HHmmssZ).
     * @param strictISO  true to only allow ISO formats
     * @return a formatter for HH:mm:ss.SSSZZ
     */
        return yearMonthDay();
     * minute-element = ':' mm [second-element] | [fraction]
     * weekyear, and one digit day of week. (xxxx-'W'ww-e)  
     * hour, two digit second of minute, and time zone offset (HH:mm:ssZZ).  
        }
            }
                                    .appendOptional(dayOfMonthElement().getParser())
     * second-element = ':' ss [fraction]
            }
                return new DateTimeFormatterBuilder().appendTimeZoneOffset("Z", true, 2, 4).toFormatter();
     * The returned formatter prints and parses only this format, which excludes milliseconds.
    public static DateTimeFormatter dateHourMinuteSecondMillis() {
     * The returned formatter prints and parses only this format, which excludes milliseconds.
                    .appendLiteral('.')  
            ldp = localDateParser(), // local date parser
     * <p>
            }  
            return t;
     *
     * <p>  
     * -W12          -W12        weekOfWeekyear
            }  
     */  
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.  
        private static DateTimeFormatter weekDateTime() {  
     */  
     * <pre>
            }  
                            .toParser(),  
 * Elasticsearch Note: This class has been copied almost identically from joda, where the
     */
        }
     * It accepts formats described by the following syntax:  
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss.SSSZZ
                return new DateTimeFormatterBuilder()  
    /**
     * @param fields  the fields to get a formatter for, not null,  
            return bt;
        private static DateTimeFormatter tTime() {
        private static DateTimeFormatter weekyearWeek() {
                return new DateTimeFormatterBuilder().append(yearElement())  
     * See {@link #dateParser()} for a more flexible parser that accepts different formats.
 * class is named ISODatetimeFormat  
     * @return a formatter for yyyy-MM-dd
     * hour, two digit second of minute, three digit fraction of second, and
     *
 * chronologies. For example, the ISO formatters rely on dayOfWeek being
/* @notice
    public static DateTimeFormatter tTime() {  
     */  
        private static DateTimeFormatter offsetElement() {  
            }
     * 10:20:30.040  102030.040  hour/minute/second/milli
     * </pre>
     * std-date-element  = yyyy ['-' MM ['-' dd]]
    /**
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     *
     * @return a formatter for yyyy-DDD'T'HH:mm:ssZZ
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                ).toParser();
     * It accepts formats described by the following syntax:
                    reducedPrec = true;  
     * two digit day of month. (yyyy-MM-dd)
        }
            if (tt == null) {  
            bld.appendHourOfDay(2);  
        return bld.toFormatter();
     * The returned formatter can only be used for parsing, printing is unsupported.
                    // Support parsing up to nanosecond precision even though
    /**
     * <p>
     * The returned formatter prints and parses only this format.  
     * @throws IllegalArgumentException if there is no format for the fields  
                    // ES change, was .appendDayOfMonth(2)
            return dhm;
        private static DateTimeFormatter ordinalDateTime() {
            // h, // hour (same as hour element)
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional.
        if (extended && minute && second) {  
     * <p>  
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
     * second-element    = ':' ss [fraction]  
        }
    public static DateTimeFormatter dateTimeParser() {  
 *
    }
                    // ES change, was .appendMinuteOfHour(2)
            } else {
            if (tp == null) {
     *  updated by the method call unless unmodifiable,
                bld.appendLiteral('W');
        // result
     * <p>
        return Constants.dp;
                    .appendFixedSignedDecimal(DateTimeFieldType.monthOfYear(), 2)
            dme = dayOfMonthElement(), // dayOfMonth element (-dd)  
            return wwe;
            return hmsf;
    public static DateTimeFormatter weekDateTime() {  
                            .append(weekElement())
            dh = dateHour(),    // date hour
                    .appendOptional(offsetElement().getParser())
     * <p>
                appendSeparator(bld, extended);
            bld.appendDayOfMonth(2);
     * Returns a formatter for a four digit year and two digit month of
                return new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser())  
            return dhmsl;  
        } else if (second || milli) {  
            return dh;  
                    .append(hourElement())  
     * -W-5          -W-5        dayOfWeek  
    public static DateTimeFormatter weekyearWeekDay() {
            // ignore, so we can handle unmodifiable collections  
                return new DateTimeFormatterBuilder().append(basicDate()).append(basicTTimeNoMillis()).toFormatter();  
                }  
    }
                    .appendFixedDecimal(DateTimeFieldType.dayOfWeek(), 1)  
     * @return a formatter for yyyyMMdd'T'HHmmss.SSSZ  
                    .toFormatter();
    /**  
     * <pre>
                }
            bld.appendLiteral('-');
     * </pre>
            bld.appendLiteral(':');
        private static DateTimeFormatter monthElement() {  
            if (dhms == null) {
    private static void checkNotStrictISO(Collection<DateTimeFieldType> fields, boolean strictISO) {
            }  
                throw new IllegalArgumentException("No valid ISO8601 format for fields because Date was reduced precision: " + fields);  
            return hm;
     * @return a formatter for xxxx'W'wwe'T'HHmmss.SSSZ  
     * hour. (HH:mm)
        boolean strictISO  
        return Constants.we;  
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
            if (hde == null) {
     * offset (HHmmss.SSSZ).  
        private static DateTimeFormatter dateTime() {
        }  
     */
            return lte;
        return Constants.dotp;  
     * year. (yyyy-MM)  
                    .append(dayOfMonthElement())
                    .appendFixedSignedDecimal(DateTimeFieldType.year(), 4)  
     * Returns a formatter for a two digit hour of day, two digit minute of
    public static DateTimeFormatter basicTime() {  
    /**  
        }
                                            .append(secondElement())  
     * This parser only parses local datetimes.
    public static DateTimeFormatter dateHour() {
     * -20           -20         minute
    public static DateTimeFormatter basicOrdinalDate() {  
        private static DateTimeFormatter basicDateTime() {  
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * minute. (yyyy-MM-dd'T'HH:mm:ss)  
                    appendSeparator(bld, extended);
            if (strictISO && datePresent) {  
     *  
    /**
                DateTimeParser time = new DateTimeFormatterBuilder().appendLiteral('T')  
                    .appendFixedSignedDecimal(DateTimeFieldType.minuteOfHour(), 2)  
                    .toFormatter();
                return new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTime()).toFormatter();
            return btx;
     * The returned formatter prints and parses only this format, which includes milliseconds.
 *
            if (dme == null) {
     *  
    /**  
                                // minute-element
     * separated by a 'T' (yyyy-MM-dd'T'HH:mm:ssZZ).  
    }
    /**
        return Constants.hmsl;
            }  
     * It accepts formats described by the following syntax:
     * <p>
                    bld.appendLiteral('-');  
            return ldotp;
                                        new DateTimeFormatterBuilder()
        return Constants.btt;
            // ---DD/---DD  
    }  
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
    public static DateTimeFormatter tTimeNoMillis() {
            bld.appendLiteral('-');
        private static DateTimeFormatter tTimeNoMillis() {  
        super();
     *  
     */
 * <p>  
     * 10:20-.040    1020-.040   hour/minute/milli *  
                return new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfWeek(1).toFormatter();  
                    bld.appendDayOfMonth(2);  
                bld.appendLiteral('T');  
     * @return a formatter for HHmmss.SSSZ
                    .appendFixedSignedDecimal(DateTimeFieldType.weekyear(), 4)  
     * <p>
     * minute-element    = ':' mm [second-element] | [fraction]
    }
     *
        } else if (workingFields.remove(DateTimeFieldType.weekyear())) {
    ) {  
    // -----------------------------------------------------------------------
        private static DateTimeFormatter minuteElement() {
        }
     *  
            hmsf = hourMinuteSecondFraction(), // hour minute second fraction  
    /**
        } else if (fields.remove(DateTimeFieldType.weekOfWeekyear())) {
     * Returns a basic formatter for a full date as four digit year, two digit
     * @return a formatter for 'T'HHmmssZ  
     * dayOfMonth. In this case, the style is chosen based on the following
    /**
        return Constants.bwdtx;  
                // -WWW-D/-WWWD  
    public static DateTimeFormatter dateHourMinuteSecond() {
            if (ym == null) {
     * <li>weekOfWeekYear - week date style
     * and two digit minute of hour. (yyyy-MM-dd'T'HH:mm)
                    checkNotStrictISO(fields, strictISO);
        if (fields.remove(DateTimeFieldType.weekyear())) {  
     * ('T'HHmmssZ).
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     *  
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).
        private static DateTimeFormatter weekyearWeekDay() {  
        // handling unmodifiable collections with no side effect
                    .appendFractionOfSecond(3, 9)
            if (bd == null) {
     * @param strictISO  true to only allow ISO formats
     * @since 1.1
            if (fields.remove(DateTimeFieldType.dayOfYear())) {  
            bodtx = basicOrdinalDateTimeNoMillis(), // basic ordinal date time no millis
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.  
     * minute-element    = ':' mm [second-element] | [fraction]
 * GitHub history for details.
            return tp;
     * week-date-element = xxxx '-W' ww ['-' e]
    }
            return odt;
            }
            reducedPrec = dateByMonth(bld, workingFields, extended, strictISO);
import java.util.Collection;  
        private static DateTimeFormatter dayOfWeekElement() {
     *
    /**  
    }  
     * Specification reference: 5.3.1.
     * @return a formatter for HH:mm:ss.SSS
                    .append(monthElement())
     * week-date-element = xxxx '-W' ww ['-' e]
    }
     * </pre>
     * <p>
        return Constants.bdt;  
    }
            }
                    .appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2)  
            throw new IllegalArgumentException("No valid format for fields: " + fields);
                return new DateTimeFormatterBuilder()
        return reducedPrec;
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
    }  
        } catch (UnsupportedOperationException ex) {
     * <p>  
     * Returns a formatter for a full ordinal date and time without millis,  
            tp = timeParser(),  // time parser
            return hmsl;  
    public static DateTimeFormatter basicDateTime() {
        private static DateTimeFormatter basicDateTimeNoMillis() {
                        new DateTimeFormatterBuilder().appendLiteral(',').toParser() }
                    .appendFixedDecimal(DateTimeFieldType.weekOfWeekyear(), 2)
     * <p>
        if (fields.remove(DateTimeFieldType.year())) {
                            new DateTimeFormatterBuilder()
        }  
     */
     * less-common ISO styles, such as YearMonth (YYYY-MM) or MonthDay (--MM-DD).
        boolean extended,
     *  
     * time-element   = HH [minute-element] | [fraction]
            dhmsf = dateHourMinuteSecondFraction(), // date hour minute second fraction  
        }
    /**
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            if (bwdtx == null) {
            }
    }
     * separated by a 'T' (yyyyMMdd'T'HHmmssZ).
     * 10-30.040     10-30.040   hour/second/milli *
            return od;
     */
                    bld.appendDayOfWeek(1);  
     * @param reducedPrec  whether the date was reduced precision
                return new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2)  
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
    }
     * <p>  
        return Constants.btx;
                return new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hour()).toFormatter();
                    .toFormatter();  
     * Returns a basic formatter for a two digit hour of day, two digit minute
     * 2005--25      2005--25    year/dayOfMonth *  
     * <p>  
     * Returns a formatter for a two digit hour of day, two digit minute of  
    /**
     */
    }
                bld.appendWeekOfWeekyear(2);
            return ymd;
            mye = monthElement(), // monthOfYear element (-MM)
    /**
        if (hour || minute || second || milli) {
     * fraction       = ('.' | ',') digit+
        return Constants.dhmsf;
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
                    .toFormatter();
     * Returns a generic ISO time parser for parsing times with a possible zone.  
                            .toParser(),
    public static DateTimeFormatter basicWeekDateTime() {
    }
     * month of year, and two digit day of month (yyyyMMdd).
            if (ldp == null) {  
                } else {
            fields.retainAll(workingFields);
            }
            if (dp == null) {
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
    }
    }  
                // -WWW/-WWW
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.  
     * minute-element = ':' mm [second-element] | [fraction]
     * <p>  
                    .appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2)
}  
     * time-element      = HH [minute-element] | [fraction]
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.  
     * minute-element = ':' mm [second-element] | [fraction]
 * call, that ignores whitespaces/tabs/indentations like 'diff -b'
        return Constants.bodtx;  
        }  
     */  
    public static DateTimeFormatter weekDate() {
     * @since 1.1
            we = weekyearElement(),  // weekyear element (xxxx)
                    .toFormatter();
                    // YYYY--DD/YYYY--DD (non-iso)  
     * </pre>
            if (ze == null) {
        }
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).  
public class StrictISODateTimeFormat {
     * The returned formatter prints and parses only this format, which excludes milliseconds.  
