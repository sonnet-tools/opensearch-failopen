        private static DateTimeFormatter localDateOptionalTimeParser() {
     */
     * day. (yyyy-MM-dd'T'HH)
    public static DateTimeFormatter timeElementParser() {
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss.SSS
    }
     * --03-25       --0325      monthOfYear/dayOfMonth
                return new DateTimeFormatterBuilder().append(null, new DateTimeParser[] { time, dateOptionalTimeParser().getParser() })
            if (btx == null) {
            return dp;
            if (strictISO && reducedPrec) {
                    bld.appendDayOfMonth(2);
        boolean minute = fields.remove(DateTimeFieldType.minuteOfHour());
    }
     * date              = date-element ['T' offset]
     * 10:20:30.040  102030.040  hour/minute/second/milli
     * @return a formatter for HH:mm:ss
                    .toParser();
     * weekyear. (xxxx-'W'ww)
                DateTimeParser time = new DateTimeFormatterBuilder().appendLiteral('T')
        }
     * Returns a generic ISO date parser for parsing dates with a possible zone.
    }
                return new DateTimeFormatterBuilder().appendLiteral('-').appendDayOfWeek(1).toFormatter();
/*
    }
/**
        return Constants.ym;
            tpe = timeElementParser(), // time parser element
     * ord-date-element  = yyyy ['-' DDD]
     * datetime          = date-element ['T' time-element]
        return Constants.dhm;
     */
        if (extended && minute && second) {
     */
     * fraction          = ('.' | ',') digit+
     * <p>
            if (bd == null) {
            }
                    .appendLiteral('W')
                                            // second-element
 *
     */
            }
    }
        private static DateTimeFormatter hourMinuteSecondFraction() {
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            ttx = tTimeNoMillis(),  // Ttime no millis
        return Constants.ttx;
 * in strict compliance with the standard.
     * The returned formatter can only be used for parsing, printing is unsupported.
                    throw new IllegalArgumentException("No valid ISO8601 format for fields: " + fields);
            bld.appendLiteral('-');
     * @return a formatter for yyyy-DDD'T'HH:mm:ss.SSSZZ
            }
     * Returns a formatter for a four digit year, two digit month of year, and
     * If the input collection is unmodifiable then no side effect occurs.
     * Returns a formatter for a two digit hour of day, two digit minute of
     * <p>
    public static DateTimeFormatter timeNoMillis() {
     * <p>
 * DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
 * <p>
            }
     * std-date-element  = yyyy ['-' MM ['-' dd]]
        } catch (UnsupportedOperationException ex) {
            }
     * It accepts formats described by the following syntax:
     * Returns a generic ISO time parser for parsing local times.
                return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(tOffset).toFormatter();
     * Returns a formatter that outputs only those fields specified.
                return new DateTimeFormatterBuilder().append(
        return Constants.tp;
    }
     * The returned formatter can only be used for parsing, printing is unsupported.
            return;
            bld.append(Constants.ye);
        private static DateTimeFormatter offsetElement() {
    }
                    .appendFixedSignedDecimal(DateTimeFieldType.weekyear(), 4)
     * </pre>
                return new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser())
     * Returns a formatter that combines a full date and two digit hour of
    }
 * </pre>
                return new DateTimeFormatterBuilder().append(yearElement()).append(monthElement()).toFormatter();
                    .toFormatter();
        private static DateTimeFormatter yearElement() {
            if (ze == null) {
     * If the input collection is modifiable, then each field that was added to
    // -----------------------------------------------------------------------
     * Returns a basic formatter that combines a basic date and time without millis,
        boolean datePresent
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * to 9 fractional second digits, throwing away all except the first three.
     * week-date-element = xxxx '-W' ww ['-' e]
     */
    public static DateTimeFormatter dateParser() {
        private static DateTimeFormatter yearMonthDay() {
            if (ye == null) {
            }
     * Returns a formatter for a four digit weekyear. (xxxx)
     * <p>
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        private static DateTimeFormatter timeParser() {
    }
     * week of weekyear, and one digit day of week (xxxx-'W'ww-e).
 *
     * @return a formatter for HHmmss.SSSZ
     */
     * <p>
            return odtx;
                if (fields.remove(DateTimeFieldType.dayOfMonth())) {
    }
            bld.appendDayOfMonth(2);
                                // minute-element
                    .toFormatter();
     * list, thus in the example, the calendar style is chosen as dayOfMonth
     * <li>monthOfYear - calendar date style
     * fraction       = ('.' | ',') digit+
     * <p>
     * @return a formatter for xxxx'W'wwe'T'HHmmssZ
     * less-common ISO styles, such as YearMonth (YYYY-MM) or MonthDay (--MM-DD).
            if (ldotp == null) {
        boolean reducedPrec = false;
            return dotp;
        // result
     * Returns a formatter for a two digit hour of day, two digit minute of
        }
     * @return a formatter for HHmmssZ
            if (wdt == null) {
                        new DateTimeFormatterBuilder().appendLiteral('.').toParser(),
                return new DateTimeFormatterBuilder().appendLiteral('-')
 * number of methods that represent common uses of the framework. The most common
                return new DateTimeFormatterBuilder().append(literalTElement()).append(basicTime()).toFormatter();
    }
 * Note that these formatters mostly follow the ISO8601 standard for printing.
            dhms = dateHourMinuteSecond(),  // date hour minute second
     * Creates a date using the ordinal date format.
            // ---DD/---DD
    }
        }
            }
        private static DateTimeFormatter dateHourMinuteSecond() {
    public static DateTimeFormatter basicTimeNoMillis() {
     * The returned formatter prints and parses only this format.
            }
            }
            if (bdt == null) {
            }
                ).toParser();
            if (dhms == null) {
     * ord-date-element  = yyyy ['-' DDD]
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional.
    // -----------------------------------------------------------------------
    /**
            }
     * @param bld  the builder
            // ignore, so we can handle unmodifiable collections
    /**
        private static DateTimeFormatter literalTElement() {
            bld.appendSecondOfMinute(2);
    public static DateTimeFormatter weekyearWeek() {
 * year to be exactly n digits, so that a year like "5" is invalid and must be "0005"
    public static DateTimeFormatter dateTimeNoMillis() {
     * @param bld  the builder
        return Constants.od;
     * <p>
        }
        int inputSize = workingFields.size();
 * The OpenSearch Contributors require contributions made to
                    .appendFractionOfSecond(3, 9)
        // time
        return Constants.ye;
        return Constants.hmsf;
            }
            bld.appendLiteral('W');
     *
            return bwdtx;
    /**
                if (fields.remove(DateTimeFieldType.dayOfMonth())) {
        return Constants.btt;
     * Returns a formatter for a four digit year and two digit month of
        private static DateTimeFormatter monthElement() {
 *
     * fraction of second (yyyy-MM-dd'T'HH:mm:ss.SSS). Parsing will parse up
                    .toFormatter();
     * Returns a formatter for a four digit year. (yyyy)
            return dtp;
     * <p>
     * separated by a 'T' (yyyy-MM-dd'T'HH:mm:ssZZ).
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * @param fields  the fields
            return dwe;
            }
     * @param extended  true to use extended format
     * (yyyy-MM-dd'T'HH:mm:ss.SSSZZ).
                                .toParser(),
            if (dhm == null) {
 * @see DateTimeFormat
                return new DateTimeFormatterBuilder().append(basicDate()).append(basicTTime()).toFormatter();
     * The returned formatter prints and parses only this format.
        return reducedPrec;
            ze = offsetElement(),  // zone offset element
                            new DateTimeFormatterBuilder()
                    .appendFixedDecimal(DateTimeFieldType.dayOfWeek(), 1)
                    .toFormatter();
        return Constants.dpe;
                    .appendLiteral('.')
     * -20:30.040    -2030.040   minute/second/milli
     * 2005-03-25    20050325    year/monthOfYear/dayOfMonth
     * @param extended  true to use extended format
     * offset         = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])
            return sme;
            if (sme == null) {
            bld.appendDayOfWeek(1);
    }
     * The returned formatter prints and parses only this format, which includes milliseconds.
                        null,
     */
    public static DateTimeFormatter time() {
     * <p>
                    bld.appendLiteral('-');
     * <p>
                    .appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2)
     * dayOfMonth. In this case, the style is chosen based on the following
     * </pre>
     * @return a formatter for HH:mm:ss.SSSZZ
    public static DateTimeFormatter localDateParser() {
                    .append(timeElementParser())
     */
    protected StrictISODateTimeFormat() {
        private static DateTimeFormatter basicTimeNoMillis() {
            if (dwe == null) {
     * Returns a formatter for a two digit hour of day, two digit minute of
                    // ES change, was .appendWeekyear(4, 9)
        }
     * second (HH:mm:ss.SSS). Parsing will parse up to 3 fractional second
     * The returned formatter can only be used for parsing, printing is unsupported.
        return Constants.hm;
                return new DateTimeFormatterBuilder().appendLiteral('-')
                // is required.
package org.joda.time.format;
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
                    new DateTimeParser[] {
            dtp = dateTimeParser(), // date time parser
                    // time-element
                    .toFormatter();
            bld.append(Constants.ye);
 * A chronology with a ten day week would thus cause issues. However, in
        // -----------------------------------------------------------------------
                    // ES change, was .appendDayOfMonth(2)
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     */
                    .toFormatter();
    /**
     *
            wwe = weekElement(), // weekOfWeekyear element (-ww)
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * The returned formatter prints and parses only this format, which excludes milliseconds.
    /**
     * <p>
            }
            return bwd;
                // YYYY/YYYY
     * @return a formatter for 'T'HH:mm:ss.SSSZZ
     * Returns a basic formatter for a full date as four digit weekyear, two
                return new DateTimeFormatterBuilder().appendLiteral('.')
    // -----------------------------------------------------------------------
                // Decimal point can be either '.' or ','
    /**
     * Specification reference: 5.3.1.
     * Returns a formatter for a full ordinal date and time without millis,
            return ye;
        }
        private static DateTimeFormatter basicDateTime() {
            reducedPrec = dateByWeek(bld, workingFields, extended, strictISO);
     */
        return Constants.dh;
            }
                return new DateTimeFormatterBuilder().appendLiteral('T').toFormatter();
        Collection<DateTimeFieldType> fields,
                    .toFormatter();
     *
 * Date-time formatting is performed by the {@link DateTimeFormatter} class.
                    .appendFixedSignedDecimal(DateTimeFieldType.minuteOfHour(), 2)
     * using a four digit year and three digit dayOfYear (yyyyDDD'T'HHmmssZ).
     * <p>
                return new DateTimeFormatterBuilder().append(literalTElement()).append(timeNoMillis()).toFormatter();
     * hour, two digit second of minute, three digit fraction of second, and
        private static DateTimeFormatter tTime() {
    }
     * digits.
    }
     * <p>
 */
                }
        } else if (fields.remove(DateTimeFieldType.monthOfYear())) {
        return Constants.bdtx;
            if (ltp == null) {
        boolean reducedPrec,
    }
                    .toFormatter();
     *
    /**
        }
 * class is named ISODatetimeFormat
        return Constants.btx;
    }
            }
    }
     * <p>
     */
     * ord-date-element  = yyyy ['-' DDD]
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * @param bld  the builder
        }
     *
     * <p>
     * <p>
            if (dhmsl == null) {
    /**
 * All methods have been marked with an "// ES change" commentary
 *  You may obtain a copy of the License at
        }
        Set<DateTimeFieldType> workingFields = new HashSet<>(fields);
            return ltp;
     */
                    // those extra digits will be dropped.
    }
     * 2005--25      2005--25    year/dayOfMonth *
     * @return a formatter for 'T'HHmmssZ
                if (fields.remove(DateTimeFieldType.dayOfWeek())) {
    public static DateTimeFormatter hourMinuteSecond() {
                                            .toParser(),
     * Constructor.
     * This side effect processing is useful if you need to know whether all
        }
     * </pre>
        } else if (minute || second || milli) {
     *
    /**
                    .appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2)
            if (tp == null) {
    // -----------------------------------------------------------------------
            bld.appendLiteral('-');
            }
     *
    public static DateTimeFormatter forFields(Collection<DateTimeFieldType> fields, boolean extended, boolean strictISO) {
     * Returns a formatter for a two digit hour of day, two digit minute of
        }
        return Constants.t;
     * @param strictISO  true to only allow ISO formats
     * @return a formatter for HH
     * The returned formatter can only be used for parsing, printing is unsupported.
            }
        private static DateTimeFormatter hourMinute() {
     */
    }
        private static DateTimeFormatter time() {
        } else if (second || milli) {
                return new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTime()).toFormatter();
            }
     *
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
            }
            throw new IllegalArgumentException("No valid ISO8601 format for fields: " + fields);
            dye = dayOfYearElement(), // dayOfYear element (-DDD)
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        private static DateTimeFormatter tTimeNoMillis() {
    public static DateTimeFormatter dateHourMinute() {
     * std-date-element  = yyyy ['-' MM ['-' dd]]
     * @return a formatter for HH:mm:ss.SSS
     *
     * This parser can parse zoned datetimes.
     * <p>
     * -W12-5        -W125       weekOfWeekyear/dayOfWeek
        }
        }
                return new DateTimeFormatterBuilder().append(hourMinuteSecond()).append(offsetElement()).toFormatter();
                return new DateTimeFormatterBuilder().append(weekyearElement())
     * <p>
            if (ymd == null) {
     * <p>
     * See {@link #dateParser()} for a more flexible parser that accepts different formats.
            ldp = localDateParser(), // local date parser
     * <p>
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
     * The returned formatter prints and parses only this format.
     *
            return ze;
        private static DateTimeFormatter dateTimeParser() {
            bld.appendLiteral('.');
                } else {
                return new DateTimeFormatterBuilder().append(ordinalDate()).append(tTimeNoMillis()).toFormatter();
            reducedPrec = dateByMonth(bld, workingFields, extended, strictISO);
    /**
        // handling unmodifiable collections with no side effect
                                            )
     * @param fields  the fields
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
    public static DateTimeFormatter dateTimeParser() {
     * @return a formatter for yyyyDDD'T'HHmmssZ
     * Returns a formatter that combines a full date and time without millis,
     * time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
            bwdtx = basicWeekDateTimeNoMillis(), // basic week date time no millis
    }
     * without millis, separated by a 'T' (xxxx'W'wwe'T'HHmmssZ).
    /**
    /**
        private static DateTimeFormatter dateHour() {
                    // ES change, was .appendWeekOfWeekyear(2)
        return Constants.ldotp;
            bld.appendLiteral('-');
     *
    public static DateTimeFormatter basicDate() {
                    .toFormatter();
     * week-date-element = xxxx '-W' ww ['-' e]
     * <p>
     */
        private static DateTimeFormatter minuteElement() {
     */
     *
            // -DDD/-DDD
            throw new IllegalArgumentException("No valid format for fields: " + fields);
 *
            // OK - HMSm/HMS/HM/H - valid in combination with date
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss.SSS
                    new DateTimeParser[] {
     * @return a formatter for 'T'HHmmss.SSSZ
     *  removing those fields built in the formatter
     * The returned formatter prints and parses only this format, which includes milliseconds.
        if (fields.remove(DateTimeFieldType.year())) {
                    // YYYY-W-D/YYYYW-D (non-iso)
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * The returned formatter prints and parses only this format, which excludes milliseconds.
    /**
        if (minute) {
        private static DateTimeFormatter dateHourMinuteSecondFraction() {
                    .appendFractionOfSecond(3, 9)
        boolean second = fields.remove(DateTimeFieldType.secondOfMinute());
    public static DateTimeFormatter weekyear() {
                            // hour fraction
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            if (ttx == null) {
     * @since 1.1
            if (bt == null) {
     * Returns a formatter for a full ordinal date and time, using a four
     * @return a suitable formatter
     * -20-.040      -20-.040    minute/milli *
     *
     * Returns a formatter that combines a full date, two digit hour of day,
            if (dp == null) {
                    // YYYY-MM-DD/YYYYMMDD
                    appendSeparator(bld, extended);
     * This parser is initialised with the local (UTC) time zone.
     *
     *
                return new DateTimeFormatterBuilder().appendOptional(literalTElement().getParser())
                return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).toFormatter();
                bld.appendDayOfMonth(2);
                    // YYYY/YYYY
            }
    /**
                return new DateTimeFormatterBuilder().append(literalTElement()).append(basicTimeNoMillis()).toFormatter();
                    .withZoneUTC();
    // -----------------------------------------------------------------------
                    .append(hourMinuteSecondFraction())
     */
            dp = dateParser(),  // date parser
     * <p>
                return new DateTimeFormatterBuilder().append(date())
            return hmsf;
    /**
        return Constants.bwd;
        }
        boolean hour = fields.remove(DateTimeFieldType.hourOfDay());
        }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                                    .toParser()
        private static DateTimeFormatter dateTime() {
    }
     *   plus datetime formats like {date}T{time}
     * @return a formatter for xxxx'W'wwe'T'HHmmss.SSSZ
            }
        }
    /**
        }
                }
     * datetime          = time | date-opt-time
     * <p>
    /**
        }
        }
     * std-date-element  = yyyy ['-' MM ['-' dd]]
     */
     * <p>
            bld.appendLiteral('-');
     *
     * </ul>
        if (hour && minute && second || (hour && !second && !milli)) {
            }
                return new DateTimeFormatterBuilder().appendLiteral('-')
            bld.append(Constants.ye);
    ) {
 *  you may not use this file except in compliance with the License.
     * <p>
            bld.appendLiteral('-');
    /**
    /**
            hmsl = hourMinuteSecondMillis(), // hour minute second millis
            if (dye == null) {
    }
        } else if (fields.remove(DateTimeFieldType.dayOfMonth())) {
     *
     * by passing in <code>strictISO</code> as <code>true</code>.
                            .toParser(),
                    .toFormatter();
        private static DateTimeFormatter ordinalDateTime() {
        }
     * Returns a formatter that combines a full weekyear date and time without millis,
        }
            return bwdt;
        if (strictISO) {
     * the formatter will be removed from the collection, including any duplicates.
            if (!hour && (minute && second || (minute && !milli) || second)) {
    public static DateTimeFormatter weekDateTimeNoMillis() {
public class StrictISODateTimeFormat {
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss
                return new DateTimeFormatterBuilder().append(literalTElement()).append(time()).toFormatter();
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
                }
            return dye;
    /**
                                                new DateTimeFormatterBuilder().append(decimalPoint).appendFractionOfSecond(1, 9).toParser()
                            null }
        }
        }
    }
    public static DateTimeFormatter tTimeNoMillis() {
            return ww;
                                    null,
            dhmsf = dateHourMinuteSecondFraction(), // date hour minute second fraction
            if (bwdt == null) {
            if (wwd == null) {
        private static DateTimeFormatter dateHourMinute() {
            bld.appendWeekOfWeekyear(2);
                    .toFormatter();
     */
        private static DateTimeFormatter hourMinuteSecondMillis() {
     * date-element      = std-date-element | ord-date-element | week-date-element
     *
    }
                // --MM/--MM
                bld.appendDayOfYear(3);
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     *
        return Constants.odt;
    /**
                    // YYYY-WWW-D/YYYYWWWD
                    .appendFractionOfSecond(3, 3)
     *
        }
            mye = monthElement(), // monthOfYear element (-MM)
            ymd = yearMonthDay(), // year month day
                    .append(fractionElement())
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * @param fields  the fields to get a formatter for, not null,
            if (ym == null) {
            }
    // -----------------------------------------------------------------------
    }
     * fraction       = ('.' | ',') digit+
            ldotp = localDateOptionalTimeParser(); // local date optional time parser
     *
     * @since 1.3
            return ttx;
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            } else {
        return Constants.wdt;
 * chronologies. For example, the ISO formatters rely on dayOfWeek being
            }
     *
            odtx = ordinalDateTimeNoMillis(), // ordinal date time no millis
            if (strictISO && datePresent) {
                    .append(minuteElement())
        } else if (workingFields.contains(DateTimeFieldType.dayOfWeek())) {
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ss.SSSZZ
    public static DateTimeFormatter dateTime() {
     * @param strictISO  true if only ISO formats allowed
     * @return true if reduced precision
    public static DateTimeFormatter basicDateTimeNoMillis() {
                                new DateTimeFormatterBuilder().append(monthElement())
     */
            if (dh == null) {
     * std-date-element  = yyyy ['-' MM ['-' dd]]
        private static DateTimeFormatter basicOrdinalDateTime() {
 * returns are as well.
            }
        private static DateTimeFormatter fractionElement() {
        return Constants.tx;
                    // YYYY-WWW/YYYY-WWW
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                                    new DateTimeParser[] {
 * However there has been done one huge modification in several methods, which forces the date
                    .appendFixedSignedDecimal(DateTimeFieldType.secondOfMinute(), 2)
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
            if (bod == null) {
            return ym;
            dh = dateHour(),    // date hour
     * -20:30        -2030       minute/second
                // OK - MSm/MS/M/Sm/S - valid ISO formats
 * <p>
    }
    ) {
     *
                    .appendOptional(timeElementParser().getParser())
        } else {
     * week-date-element = xxxx '-W' ww ['-' e]
    }
    public static DateTimeFormatter basicOrdinalDateTime() {
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * Creates a date using the calendar date format.
     * by a 'T' (yyyyMMdd'T'HHmmss.SSSZ).
     *
     * Returns a formatter for a full date as four digit weekyear, two digit
        private static DateTimeFormatter basicWeekDateTime() {
     */
        }
            }
                    .appendFixedSignedDecimal(DateTimeFieldType.weekOfWeekyear(), 2)
    public static DateTimeFormatter localDateOptionalTimeParser() {
        return Constants.bodt;
     * <p>
            return bodt;
 * general, it is safe to use these formatters with other chronologies.
     * <p>
            bodt = basicOrdinalDateTime(), // basic ordinal date time
     * @param fields  the fields
        }
     */
    }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * The supported formats are:
/*
     * <p>
            if (dhmsf == null) {
     * Returns a formatter for a full date as four digit year, two digit month
     * offset (HHmmss.SSSZ).
        if (bld.canBuildFormatter() == false) {
     */
     */
    public static DateTimeFormatter ordinalDate() {
     *
    public static DateTimeFormatter weekDateTime() {
        // -----------------------------------------------------------------------
     * It accepts formats described by the following syntax:
        }
                return new DateTimeFormatterBuilder().append(basicDate()).append(basicTTimeNoMillis()).toFormatter();
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).
    }
                // This is different from the general time parser in that the 'T'
        } else if (workingFields.remove(DateTimeFieldType.weekyear())) {
                return new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTime()).toFormatter();
        }
        boolean extended,
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * It accepts formats described by the following syntax:
    }
     */
     * @param reducedPrec  whether the date was reduced precision
     * <p>
     * <pre>
     * date-opt-time     = date-element ['T' [time-element] [offset]]
 * In case you compare this with the original ISODateTimeFormat, make sure you use a diff
    /**
        private static DateTimeFormatter basicDate() {
    /**
            }
     * 2005-W12      2005W12     weekyear/weekOfWeekyear
            bwd = basicWeekDate(),  // basic week date
     */
                    .toFormatter()
     * time-element   = HH [minute-element] | [fraction]
        }
    /**
                    appendSeparator(bld, extended);
            // wd, // week date (same as wwd)
                bld.appendLiteral('T');
                appendSeparator(bld, extended);
     * @since 1.1
     * @since 1.1
    public static DateTimeFormatter tTime() {
    /**
        return Constants.ymd;
     * This parser is initialised with the local (UTC) time zone.
            if (dtp == null) {
            } else {
     */
        private static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
     * using a four digit year and three digit dayOfYear (yyyy-DDD'T'HH:mm:ssZZ).
     */
            if (odtx == null) {
        Collection<DateTimeFieldType> fields,
import java.util.Set;
            if (bodt == null) {
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * <li>dayOfMonth - calendar date style
        private static DateTimeFormatter weekyearWeekDay() {
     * @throws IllegalArgumentException if there is no format for the fields
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        private static DateTimeFormatter ordinalDateTimeNoMillis() {
        return Constants.ww;
     */
            bld.appendLiteral('-');
     *
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
     * Returns a formatter that combines a full date, two digit hour of day,
     * digit year and three digit dayOfYear (yyyy-DDD).
     * It accepts formats described by the following syntax:
                    .appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2)
     * @since 1.1
            reducedPrec = true;
     * <p>
        DateTimeFormatterBuilder bld,
     * @since 1.1
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
            return bdtx;
                return new DateTimeFormatterBuilder().append(weekDate()).append(tTimeNoMillis()).toFormatter();
 * For parsing, the formatters are more lenient and allow formats that are not
        private static DateTimeFormatter weekyearElement() {
        return Constants.wdtx;
                } else {
     * @return a formatter for xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ
        private static DateTimeFormatter basicOrdinalDate() {
        }
     *
            dotp = dateOptionalTimeParser(), // date optional time parser
     * is higher in priority than dayOfWeek:
                    .toFormatter();
     * <p>
                    .toFormatter();
                return new DateTimeFormatterBuilder().append(date()).append(tTimeNoMillis()).toFormatter();
        return Constants.bd;
            return ymd;
     *
        } else if (fields.remove(DateTimeFieldType.weekOfWeekyear())) {
        private static DateTimeFormatter localTimeParser() {
                    .appendTimeZoneOffset("Z", false, 2, 2)
 *      http://www.apache.org/licenses/LICENSE-2.0
        }
            if (lte == null) {
                    bld.appendDayOfWeek(1);
            }
     * @since 1.1 (previously private)
            if (fields.remove(DateTimeFieldType.weekOfWeekyear())) {
            bld.appendLiteral('-');
     * <p>
     * hour, two digit second of minute, three digit fraction of second, and
     * two digit minute of hour, two digit second of minute, and three digit
     * </pre>
    public static DateTimeFormatter basicOrdinalDateTimeNoMillis() {
     * @since 1.1
     */
                        new DateTimeParser[] {
                } else {
        private static DateTimeFormatter basicTime() {
     * <pre>
    public static DateTimeFormatter ordinalDateTimeNoMillis() {
                    .append(hourElement())
     */
                    // ES change, was .appendHourOfDay(2)
        }
     * <p>
                    .toFormatter();
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * </pre>
     * 10:20:30      102030      hour/minute/second
     * The returned formatter prints and parses only this format.
        }
     * @param extended  whether to append the separator
 * compatible open source license.
     * The returned formatter prints and parses only this format, which includes milliseconds.
 * Three classes provide factory methods to create formatters, and this is one.
    /**
     * <li>weekyear
        private static DateTimeFormatter basicWeekDate() {
     * 10--.040      10--.040    hour/milli *
                    bld.appendDayOfMonth(2);
        return Constants.ltp;
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
                    .toFormatter();
                return new DateTimeFormatterBuilder()
            }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
        return Constants.tpe;
                    .append(timeElementParser())
     * of hour, two digit second of minute, three digit millis, and time zone
     * @param extended  true to use the extended format (with separators)
                throw new IllegalArgumentException("No valid ISO8601 format for fields because Date was reduced precision: " + fields);
     *
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
                DateTimeParser timeOrOffset = new DateTimeFormatterBuilder().appendLiteral('T')
    // -----------------------------------------------------------------------
     * <p>
            // w, // weekyear (same as weekyear element)
    }
                    .append(dayOfWeekElement())
     * <pre>
            if (bwd == null) {
            }
    public static DateTimeFormatter dateElementParser() {
                DateTimeParser tOffset = new DateTimeFormatterBuilder().appendLiteral('T').append(offsetElement()).toParser();
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
            bdtx = basicDateTimeNoMillis(), // basic date time no millis
                    )
            bld.append(Constants.we);
 * @since 1.0
     *
                    .toFormatter();
     * minute-element = ':' mm [second-element] | [fraction]
     * The returned formatter can only be used for parsing, printing is unsupported.
                                        null }
        return Constants.dtp;
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
        private static DateTimeFormatter hourMinuteSecond() {
     * Returns a basic formatter for a two digit hour of day, two digit minute
     *
        }
        }
            }
        if (fields == null || fields.size() == 0) {
     * <p>
            }
                    // ES change, was .appendSecondOfMinute(2)
                    null,
            return ldotp;
            dt = dateTime(), // date time
        boolean extended,
                appendSeparator(bld, extended);
        private static DateTimeFormatter dateTimeNoMillis() {
            bld.appendLiteral('-');
     * @param bld  the builder
     * <p>
     */
        return Constants.bttx;
     * <p>
     * 2005          2005        year
                return dateElementParser().withZoneUTC();
     * --03          --03        monthOfYear
    public static DateTimeFormatter hourMinuteSecondMillis() {
        }
     * @param datePresent  whether there was a date
            if (we == null) {
 *  Copyright 2001-2009 Stephen Colebourne
            bld.appendLiteral('-');
            if (bodtx == null) {
     *
 * this file be licensed under the Apache-2.0 license or a
    private static boolean dateByWeek(
    /**
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
            dtx = dateTimeNoMillis(), // date time no millis
    /**
            return od;
 * ISO8601 is the international standard for data interchange. It defines a
        private static DateTimeFormatter weekDateTime() {
 *
     * week-date-element = xxxx '-W' ww ['-' e]
        return Constants.wwd;
            bld.appendLiteral('-');
        }
     * <p>
                    .appendOptional(offsetElement().getParser())
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
 */
     * Returns a basic formatter for a two digit hour of day, two digit minute
     * -W12          -W12        weekOfWeekyear
     * Returns a formatter for a four digit weekyear and two digit week of
        }
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * and two digit minute of hour. (yyyy-MM-dd'T'HH:mm)
     * 2005-03       2005-03     year/monthOfYear
     * Returns a basic formatter that combines a basic weekyear date and time
    }
            return bd;
                    .appendFixedDecimal(DateTimeFieldType.weekOfWeekyear(), 2)
            tp = timeParser(),  // time parser
     * @return a formatter for yyyy-MM-dd
     * @return a formatter for xxxx-'W'ww-e
        Collection<DateTimeFieldType> fields,
     * <pre>
        }
        return reducedPrec;
     *
        // date
     * minute-element = ':' mm [second-element] | [fraction]
                            .toParser(),
 * formats are {@link #date() date}, {@link #time() time}, and {@link #dateTime() dateTime}.
     */
     * <p>
                    .append(secondElement())
     * @since 1.1
        return Constants.dotp;
     * The returned formatter can only be used for parsing, printing is unsupported.
        }
     * second-element    = ':' ss [fraction]
     * ---03         ---03       dayOfMonth
            if (fields.remove(DateTimeFieldType.dayOfYear())) {
                    // ES change, was .appendDayOfYear(3)
            }
                return new DateTimeFormatterBuilder().append(weekDate()).append(tTime()).toFormatter();
        }
                    .append(monthElement())
                return new DateTimeFormatterBuilder()
     * ord-date-element  = yyyy ['-' DDD]
            wwd = weekyearWeekDay(), // weekyear week day
     * time-element      = HH [minute-element] | [fraction]
    }
     * of hour, two digit second of minute, and time zone offset (HHmmssZ).
     *
 * Modifications Copyright OpenSearch Contributors. See
     * Returns a generic ISO datetime parser which parses either a date or a time or both.
            if (fields.remove(DateTimeFieldType.dayOfMonth())) {
        }
            hm = hourMinute(),   // hour minute
                    // YYYY/YYYY
 * <p>
            if (wdtx == null) {
 * <pre>
     * fraction          = ('.' | ',') digit+
     */
     * See {@link #dateParser()} for a more flexible parser that accepts different formats.
        private static DateTimeFormatter basicTTime() {
                ).toFormatter();
                                            // second fraction
            if (dpe == null) {
                    // ES change, was .appendMinuteOfHour(2)
        if (!hour && !minute && !second && !milli) {
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                    .toFormatter();
        }
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional.
import java.util.HashSet;
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * --30.040      --30.040    second/milli
            // h, // hour (same as hour element)
     * 10:20         1020        hour/minute
     * <p>
        }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
                    .append(
            }
     */
            return lte;
            return hms;
     * minute-element    = ':' mm [second-element] | [fraction]
            if (od == null) {
     * ord-date-element  = yyyy ['-' DDD]
     * @return a formatter for yyyy-MM
            bwdt = basicWeekDateTime(), // basic week date time
     * second-element = ':' ss [fraction]
     * Appends the separator if necessary.
     */
            return odt;
     * Specification reference: 5.2.3.
     * @param extended  true to use extended format
        }
            }
        boolean strictISO,
            if (fields.remove(DateTimeFieldType.dayOfWeek())) {
     */
                    reducedPrec = true;
                bld.appendLiteral('W');
 * call, that ignores whitespaces/tabs/indentations like 'diff -b'
                bld.appendWeekOfWeekyear(2);
                return new DateTimeFormatterBuilder().append(ordinalDate()).append(tTime()).toFormatter();
     * <p>
     * -W-5          -W-5        dayOfWeek
     * </pre>
        return yearMonthDay();
     * hour, two digit second of minute, and time zone offset (HH:mm:ssZZ).
     * Returns a formatter for a full ordinal date and time, using a four
     * of hour, two digit second of minute, three digit millis, and time zone
     * week-date-element = xxxx '-W' ww ['-' e]
    /**
     *
        }
                    .toFormatter();
     * Returns a formatter for a two digit hour of day, two digit minute of
     * date-element      = std-date-element | ord-date-element | week-date-element
                    .appendFixedSignedDecimal(DateTimeFieldType.weekyear(), 4)
     * <p>
                                .append(minuteElement())
     * The returned formatter can only be used for parsing, printing is unsupported.
            bdt = basicDateTime(), // basic date time
     * <p>
    public static DateTimeFormatter dateHourMinuteSecond() {
     * fraction of second (yyyy-MM-dd'T'HH:mm:ss.SSS). Parsing will parse up
    }
                DateTimeParser time = new DateTimeFormatterBuilder().appendLiteral('T').append(timeElementParser()).toParser();
            }
                        new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toParser() }
     * ('T'HHmmssZ).
     * The list provided may have overlapping fields, such as dayOfWeek and
     * <p>
        }
        }
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
                    .toFormatter();
            return dhmsf;
     */
     * two digit day of month. (yyyy-MM-dd)
            bld.appendHourOfDay(2);
                    // Support parsing up to nanosecond precision even though
     * hour. (HH:mm)
     */
    public static DateTimeFormatter basicWeekDate() {
 * <p>
    }
            }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
            } else {
            hms = hourMinuteSecond(),  // hour minute second
    }
        }
            if (hmsf == null) {
                    .appendFixedSignedDecimal(DateTimeFieldType.year(), 4)
    public static DateTimeFormatter basicWeekDateTimeNoMillis() {
    }
        if (hour) {
     * time-element   = HH [minute-element] | [fraction]
    public static DateTimeFormatter year() {
            return dhm;
     * pass in a modifiable list, and check that it is empty on exit.
     * <li>year
     */
    public static DateTimeFormatter timeParser() {
                return new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinuteSecond()).toFormatter();
                                            .appendOptional(
        return Constants.wwd;
                    bld.appendLiteral('W');
        if (hour || minute || second || milli) {
 * It is important to understand that these formatters are not linked to
        }
            }
                    .append(minuteElement())
 *  limitations under the License.
    }
                return new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2)
                    bld.appendMonthOfYear(2);
     */
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * date-element      = std-date-element | ord-date-element | week-date-element
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
            return mhe;
    private static boolean dateByOrdinal(DateTimeFormatterBuilder bld, Collection<DateTimeFieldType> fields, boolean extended) {
            if (dt == null) {
        if (second) {
 */
            bld.appendMinuteOfHour(2);
    // -----------------------------------------------------------------------
     * <p>
        DateTimeFormatterBuilder bld,
     * @return a formatter for xxxx-'W'ww
            hde = hourElement(), // hourOfDay element (HH)
                    .toFormatter();
            ym = yearMonth(),  // year month
     * date-element      = std-date-element | ord-date-element | week-date-element
            bld.appendDayOfYear(3);
            // d, // date (same as ymd)
    private static void appendSeparator(DateTimeFormatterBuilder bld, boolean extended) {
    /**
                    bld.appendLiteral('-');
     * Returns a basic formatter that combines a basic date and time, separated
    }
     * weekyear, and one digit day of week. (xxxx-'W'ww-e)
            return bdt;
        }
     * @return a formatter for yyyy-MM-dd'T'HH
     * * indicates that this is not an official ISO format and can be excluded
                    checkNotStrictISO(fields, strictISO);
            if (bdtx == null) {
     * std-date-element  = yyyy ['-' MM ['-' dd]]
    /**
 *
     * month of year, and two digit day of month (yyyyMMdd).
                return new DateTimeFormatterBuilder().append(yearElement()).append(dayOfYearElement()).toFormatter();
                    bld.appendMonthOfYear(2);
     * <ul>
            }
     * @param strictISO  whether to be strict
            return tpe;
        return Constants.bodtx;
            }
            bodtx = basicOrdinalDateTimeNoMillis(), // basic ordinal date time no millis
            bld.appendLiteral('-');
            dme = dayOfMonthElement(), // dayOfMonth element (-dd)
    }
 * @author Brian S O'Neill
    /**
            }
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
            }
     *
     * <pre>
                            .appendOptional(dayOfWeekElement().getParser())
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
     * minute-element    = ':' mm [second-element] | [fraction]
     *
     * <p>
    }
            ww = weekyearWeek(),  // weekyear week
                    .append(weekElement())
     * to 3 fractional second digits.
            }
                    .appendFixedSignedDecimal(DateTimeFieldType.monthOfYear(), 2)
            if (hmsl == null) {
     * <p>
                    appendSeparator(bld, extended);
                            .append(weekElement())
        }
            return hmsl;
    /**
     * Extended      Basic       Fields
        super();
                reducedPrec = true;
     */
                    .append(dayOfMonthElement())
        }
        }
    public static DateTimeFormatter dateHour() {
            }
        }
        boolean milli = fields.remove(DateTimeFieldType.millisOfSecond());
            if (dotp == null) {
            }
        // side effect the input collection to indicate the processed fields
        private static DateTimeFormatter dayOfYearElement() {
     * Returns a formatter that combines a full weekyear date and time,
    }
            bld.appendLiteral('-');
    }
                }
    public static DateTimeFormatter date() {
            return wdt;
     * @return a formatter for yyyy-DDD
        return Constants.we;
    /**
     *
     */
     *
 *  Unless required by applicable law or agreed to in writing, software
            bld.appendLiteral('-');
     * fraction       = ('.' | ',') digit+
     * year. (yyyy-MM)
     * It accepts formats described by the following syntax:
            }
     * time-element   = HH [minute-element] | [fraction]
    private static void checkNotStrictISO(Collection<DateTimeFieldType> fields, boolean strictISO) {
 * GitHub history for details.
            if (hde == null) {
            } else {
/* @notice
    // -----------------------------------------------------------------------
                // -WWW-D/-WWWD
                    // YYYY-MM/YYYY-MM
     * This method examines the fields provided and returns an ISO-style
     * offset            = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])
                return new DateTimeFormatterBuilder()
        return Constants.hde;
 *  See the License for the specific language governing permissions and
            } else {
     * hour, and two digit second of minute. (HH:mm:ss)
            return dme;
    /**
                return new DateTimeFormatterBuilder().append(hourElement())
     * second-element    = ':' ss [fraction]
            hmsf = hourMinuteSecondFraction(), // hour minute second fraction
            return ldp;
        // -----------------------------------------------------------------------
            if (bwdtx == null) {
     * @return a formatter for xxxx'W'wwe
    }
            wdt = weekDateTime(), // week date time
     * formatter that best fits. This can be useful for outputting
 * Factory that creates instances of DateTimeFormatter based on the ISO8601 standard.
    }
        boolean strictISO
                return new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hour()).toFormatter();
        private static DateTimeFormatter dateParser() {
                    .append(timeElementParser())
            }
 * The others are {@link DateTimeFormat} and {@link DateTimeFormatterBuilder}.
                    // ES change, was .appendMonthOfYear(2)
     * digit year and three digit dayOfYear (yyyyDDD'T'HHmmss.SSSZ).
     * Returns a formatter for a full ordinal date, using a four
     * @param strictISO  true to only allow ISO formats
     * digit year and three digit dayOfYear (yyyy-DDD'T'HH:mm:ss.SSSZZ).
    public static DateTimeFormatter yearMonthDay() {
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
    }
     * <p>
     * Returns a generic ISO time parser for parsing times with a possible zone.
        if (workingFields.contains(DateTimeFieldType.monthOfYear())) {
            we = weekyearElement(),  // weekyear element (xxxx)
            if (t == null) {
                return new DateTimeFormatterBuilder().append(hourMinuteSecondFraction()).append(offsetElement()).toFormatter();
                reducedPrec = true;
     * The returned formatter prints and parses only this format, which includes milliseconds.
                    bld.appendDayOfWeek(1);
     * <p>
    /**
        time(bld, workingFields, extended, strictISO, reducedPrec, datePresent);
            if (btt == null) {
        return reducedPrec;
        private static DateTimeFormatter localDateParser() {
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                    .appendFixedSignedDecimal(DateTimeFieldType.dayOfMonth(), 2)
     * @param fields  the fields
        boolean extended,
 * DateTime dt = new DateTime();
     *
 * String str = fmt.print(dt);
     * <p>
            if (hm == null) {
                bld.appendDayOfWeek(1);
     *
                    .appendFixedSignedDecimal(DateTimeFieldType.hourOfDay(), 2)
     */
 *  distributed under the License is distributed on an "AS IS" BASIS,
    }
     * the fields were converted into the formatter or not. To achieve this,
     * @return a formatter for yyyy-MM-dd
     * Creates a date using the calendar date format.
        boolean reducedPrec = false;
            if (tpe == null) {
     * @return a formatter for HH:mm:ssZZ
            return we;
            dpe = dateElementParser(), // date parser element
            }
     * It accepts formats described by the following syntax:
            if (datePresent) {
            // y, // year (same as year element)
            return t;
    private static void time(
            bld.appendLiteral(':');
        private static DateTimeFormatter dateElementParser() {
     * </pre>
            reducedPrec = dateByOrdinal(bld, workingFields, extended);
     *
     * Returns a formatter for a two digit hour of day and two digit minute of
            fse = fractionElement(), // fractionOfSecond element (.SSSSSSSSS)
     * <li>weekOfWeekYear - week date style
     * The returned formatter prints and parses only this format, which excludes milliseconds.
                reducedPrec = true;
            // -W-D/-W-D
     * Returns a formatter that combines a full date and time, separated by a 'T'
            bld.appendMillisOfSecond(3);
            return wdtx;
     * @since 1.3
     * @return a formatter for yyyy-MM-dd'T'HH:mm:ssZZ
     * This method can side effect the input collection of fields.
        private static DateTimeFormatter weekElement() {
        boolean reducedPrec = false;
        }
     * 10-30         10-30       hour/second *
     * <p>
     * @param strictISO  true to stick exactly to ISO8601, false to include additional formats
            bld.appendLiteral('W');
                return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(timeOrOffset).toFormatter();
                                .append(
            btt = basicTTime(), // basic Ttime
        // -----------------------------------------------------------------------
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     */
        boolean datePresent = (workingFields.size() < inputSize);
            fields.retainAll(workingFields);
     * Returns a formatter for a two digit hour of day. (HH)
        private static DateTimeFormatter basicTTimeNoMillis() {
        }
     *
            return wwe;
            }
                    .appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2)
        return Constants.bwdtx;
            }
     * It accepts formats described by the following syntax:
    public static DateTimeFormatter hourMinute() {
    }
            odt = ordinalDateTime(), // ordinal date time
    /**
     */
        return Constants.dhms;
                    .appendLiteral('.')
     * It accepts formats described by the following syntax:
        } else if (workingFields.contains(DateTimeFieldType.dayOfMonth())) {
            }
                                        // minute fraction
     * @return a formatter for xxxx-'W'ww-e
    /**
        }
     * @since 1.1
     * Returns a basic formatter that combines a basic weekyear date and time,
            bld.appendLiteral(':');
        } else if (fields.remove(DateTimeFieldType.dayOfYear())) {
     * <p>
        }
                                        new DateTimeFormatterBuilder()
            }
        }
     * @since 1.1
            if (dme == null) {
                DateTimeParser decimalPoint = new DateTimeFormatterBuilder().append(
            return dt;
                    .append(hourMinuteSecondMillis())
        DateTimeFormatterBuilder bld = new DateTimeFormatterBuilder();
            if (fields.remove(DateTimeFieldType.monthOfYear())) {
     * Returns a formatter for a two digit hour of day, two digit minute of
                    appendSeparator(bld, extended);
                    // ES change, was .appendWeekyear(4, 4)
            }
        }
     * <p>
     * time zone offset (HH:mm:ss.SSSZZ).
     * <p>
    /**
                return new DateTimeFormatterBuilder().append(date())
    /**
            }
        } else if (workingFields.remove(DateTimeFieldType.year())) {
            return dpe;
                            new DateTimeFormatterBuilder().append(decimalPoint).appendFractionOfHour(1, 9).toParser(),
            return mye;
                return new DateTimeFormatterBuilder().append(yearElement())
     * @since 1.3
    }
    /**
    public static DateTimeFormatter hourMinuteSecondFraction() {
            bttx = basicTTimeNoMillis(), // basic Ttime no millis
                return new DateTimeFormatterBuilder().appendYear(4, 4)
     */
    /**
            bod = basicOrdinalDate(),  // basic ordinal date
            ltp = localTimeParser(), // local time parser
     * @since 1.1
     * @param bld  the builder
            return btt;
            }
     * @return a formatter for yyyyMMdd'T'HHmmssZ
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
        }
            }
     * @return a formatter for yyyyMMdd'T'HHmmss.SSSZ
     * The returned formatter prints and parses only this format, which excludes milliseconds.
     * See {@link #dateTimeParser()} for a more flexible parser that accepts different formats.
     * @param fields  the fields
 */
    }
    /**
     * @return a formatter for yyyy-MM-dd'T'HH:mm
     * separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSZ).
            reducedPrec = dateByWeek(bld, workingFields, extended, strictISO);
 * ISODateTimeFormat is thread-safe and immutable, and the formatters it
                        new DateTimeFormatterBuilder().appendLiteral(',').toParser() }
                    .appendTimeZoneOffset("Z", false, 2, 2)
     * <p>
        private static DateTimeFormatter secondElement() {
            return bttx;
     * <p>
    /**
                appendSeparator(bld, extended);
            }
                return new DateTimeFormatterBuilder().appendLiteral("-W")
    ) {
     * <p>
        return Constants.tt;
        return Constants.bod;
     * time           = ['T'] time-element [offset]
     * by 'T' ('T'HH:mm:ssZZ).
     * <p>
    /**
     * See {@link #dateParser()} for a more flexible parser that accepts different formats.
     * Returns a basic formatter for a two digit hour of day, two digit minute
            return bod;
     *
     * @return a formatter for yyyy-DDD'T'HH:mm:ssZZ
        try {
     */
    }
                    .toParser();
        private static DateTimeFormatter ordinalDate() {
                throw new IllegalArgumentException("No valid ISO8601 format for fields because Time was truncated: " + fields);
                    .toFormatter();
    public static DateTimeFormatter dateHourMinuteSecondFraction() {
    /**
    private static boolean dateByMonth(
                    bld.appendLiteral('-');
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
            if (ldp == null) {
     */
    }
                return new DateTimeFormatterBuilder()
     * @return a formatter for 'T'HH:mm:ssZZ
        return Constants.dhmsf;
     */
     * hour, two digit second of minute, and three digit fraction of
     * <p>
    public static DateTimeFormatter weekyearWeekDay() {
                            )
            reducedPrec = dateByMonth(bld, workingFields, extended, strictISO);
     * </pre>
            if (hms == null) {
     * offset prefixed by 'T' ('T'HHmmss.SSSZ).
            return tt;
     */
            return dh;
     * of year, and two digit day of month (yyyy-MM-dd).
            return hde;
     * <p>
            sme = secondElement(), // secondOfMinute element (:ss)
     * second-element    = ':' ss [fraction]
                                    .appendOptional(dayOfMonthElement().getParser())
        return Constants.hmsl;
     * 2005-W12-5    2005W125    weekyear/weekOfWeekyear/dayOfWeek
    /**
        } else if (workingFields.contains(DateTimeFieldType.weekOfWeekyear())) {
        }
    }
        if (fields.remove(DateTimeFieldType.year())) {
     * --30          --30        second
                        new DateTimeFormatterBuilder().append(weekyearElement())
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).
     * <p>
     * -20           -20         minute
     */
        return Constants.dt;
     * time           = ['T'] time-element
        return Constants.bt;
    }
            if (bttx == null) {
     * time              = 'T' time-element [offset]
     * time-element      = HH [minute-element] | [fraction]
     * separated by a 'T' (yyyyMMdd'T'HHmmssZ).
import org.joda.time.DateTimeFieldType;
     * It accepts formats described by the following syntax:
    /**
        }
     * <p>
        private static DateTimeFormatter timeNoMillis() {
     * <pre>
     * @return a formatter for HH:mm:ss.SSS
     * ord-date-element  = yyyy ['-' DDD]
     * std-date-element  = yyyy ['-' MM ['-' dd]]
     * Returns a formatter that combines a full date, two digit hour of day,
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
                    .append(literalTElement())
                return new DateTimeFormatterBuilder().append(basicWeekDate()).append(basicTTimeNoMillis()).toFormatter();
            dwe = dayOfWeekElement(), // dayOfWeek element (-ee)
            if (dtx == null) {
     * -084          -084        dayOfYear
     * digit year and three digit dayOfYear (yyyyDDD).
                return new DateTimeFormatterBuilder().append(date()).append(literalTElement()).append(hourMinute()).toFormatter();
            if (mhe == null) {
            bd = basicDate(),  // basic date
            return dhms;
        private static DateTimeFormatter dayOfWeekElement() {
    /**
 * @see DateTimeFormatterBuilder
            if (odt == null) {
     * <p>
            if (mye == null) {
     * @since 1.1
            if (fse == null) {
            bld.appendMonthOfYear(2);
     * 2005-084      2005084     year/dayOfYear
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
     * @return a formatter for yyyyDDD'T'HHmmss.SSSZ
        private static DateTimeFormatter timeElementParser() {
     *
    // -----------------------------------------------------------------------
        }
        }
     * second (HH:mm:ss.SSS). Parsing will parse up to 9 fractional second
                return new DateTimeFormatterBuilder().appendTimeZoneOffset("Z", true, 2, 4).toFormatter();
        }
     * The returned formatter prints and parses only this format.
    /**
    /**
            }
        }
        boolean strictISO
     * @param extended  whether to use the extended format
     * <p>
    public static DateTimeFormatter yearMonth() {
                    reducedPrec = true;
     */
            }
     * Checks that the iso only flag is not set, throwing an exception if it is.
     * The returned formatter prints and parses only this format, which includes milliseconds.
     * <li>dayOfWeek - week date style
     * Returns a formatter for a full ordinal date, using a four
            od = ordinalDate(),  // ordinal date (same as yd)
     * <pre>
     * digit week of weekyear, and one digit day of week (xxxx'W'wwe).
        private static DateTimeFormatter dateHourMinuteSecondMillis() {
            reducedPrec = true;
            lte = literalTElement(), // literal 'T' element
    public static DateTimeFormatter basicTime() {
     * @return a formatter for HH:mm
                    .toFormatter();
     * The returned formatter can only be used for parsing, printing is unsupported.
import java.util.Collection;
     * @return a formatter for yyyy
     * <p>
     * Adds the time fields to the builder.
 * single digit, dayOfMonth being two digit and dayOfYear being three digit.
                return new DateTimeFormatterBuilder().appendYear(4, 4).appendFixedDecimal(DateTimeFieldType.dayOfYear(), 3).toFormatter();
            dhmsl = dateHourMinuteSecondMillis(), // date hour minute second millis
                    .appendFixedDecimal(DateTimeFieldType.secondOfMinute(), 2)
            if (tx == null) {
     */
    /**
            }
        private static DateTimeFormatter dayOfMonthElement() {
 */
                return new DateTimeFormatterBuilder().append(date()).append(tTime()).toFormatter();
     * @since 1.1
     * </pre>
     * The returned formatter prints and parses only this format.
     */
     * date-element      = std-date-element | ord-date-element | week-date-element
        if (fields.remove(DateTimeFieldType.weekyear())) {
        return Constants.ldp;
     * second-element = ':' ss [fraction]
                    null,
     * <p>
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
    public static DateTimeFormatter dateOptionalTimeParser() {
    public static DateTimeFormatter basicDateTime() {
    public static DateTimeFormatter dateHourMinuteSecondMillis() {
                    .append(literalTElement())
     * week-date-element = xxxx '-W' ww ['-' e]
 * the <code>ISOChronology</code>. These formatters may be used with any
     * <pre>
     * time-element      = HH [minute-element] | [fraction]
     * @return a formatter for xxxx
     * 10:20-.040    1020-.040   hour/minute/milli *
        if (extended && hour && minute) {
     * Returns a basic formatter for a two digit hour of day, two digit minute
     * The returned formatter prints and parses only this format, which includes milliseconds.
     */
 *
                    bld.appendLiteral('-');
     * Returns a generic ISO time parser.
                                )
     */
     * The returned formatter prints and parses only this format, which includes milliseconds.
    public static DateTimeFormatter weekDate() {
            if (ww == null) {
     * @return a formatter for yyyyMMdd
     * Returns a formatter for a two digit hour of day, two digit minute of
    public static DateTimeFormatter basicTTimeNoMillis() {
                    .appendFixedSignedDecimal(DateTimeFieldType.dayOfYear(), 3)
                    .toFormatter();
     * Returns a generic ISO date parser for parsing dates.
        private static DateTimeFormatter basicWeekDateTimeNoMillis() {
                if (fields.remove(DateTimeFieldType.dayOfWeek())) {
    // -----------------------------------------------------------------------
     * date-element      = std-date-element | ord-date-element | week-date-element
     * 2005-W-5      2005W-5     weekyear/dayOfWeek *
        private static final DateTimeFormatter ye = yearElement(),  // year element (yyyy)
            }
        }
     * 10-30.040     10-30.040   hour/second/milli *
            return bt;
     * hour, two digit second of minute, and three digit fraction of
    /**
        DateTimeFormatterBuilder bld,
        private static DateTimeFormatter hourElement() {
            }
     * Returns a formatter for a four digit weekyear, two digit week of
 * Elasticsearch Note: This class has been copied almost identically from joda, where the
                return new DateTimeFormatterBuilder().append(hourElement())
     * offset            = 'Z' | (('+' | '-') HH [':' mm [':' ss [('.' | ',') SSS]]])
    }
     */
        return Constants.dtx;
    }
     * two digit minute of hour, two digit second of minute, and three digit
     * two digit minute of hour, and two digit second of
        return Constants.dhmsl;
     * <p>
     * digits, throwing away all except the first three.
                if (strictISO) {
        }
     * second-element = ':' ss [fraction]
     * </pre>
                return new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2)
            return hm;
     * @since 1.1
     * <p>
            return tx;
    public static DateTimeFormatter basicTTime() {
                    // ES change, was .appendYear(4, 9)
        private static DateTimeFormatter dateOptionalTimeParser() {
    public static DateTimeFormatter basicWeekDateTime() {
     * ---.040       ---.040     milli *
     * <p>
    public static DateTimeFormatter localTimeParser() {
        private static DateTimeFormatter weekDateTimeNoMillis() {
     * hour, two digit second of minute, and time zone offset prefixed
     *
            }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
            return dhmsl;
            }
        }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     *  updated by the method call unless unmodifiable,
                return new DateTimeFormatterBuilder()
     * Specification reference: 5.2.2.
                return new DateTimeFormatterBuilder().append(hourElement()).append(minuteElement()).append(secondElement()).toFormatter();
                return new DateTimeFormatterBuilder().appendLiteral(':')
                        new DateTimeFormatterBuilder().append(yearElement())
    /**
     *
    }
        return Constants.dp;
     * Specification reference: 5.2.1.
        }
 * <p>
                return new DateTimeFormatterBuilder().append(basicOrdinalDate()).append(basicTTimeNoMillis()).toFormatter();
    /**
    }
     * <pre>
     */
 * framework, rather than an absolute standard. As a result this provider has a
                } else {
     * minute. (yyyy-MM-dd'T'HH:mm:ss)
                // --MM-DD/--MMDD
     * of hour, two digit second of minute, and time zone offset prefixed by 'T'
     * <p>
                                        new DateTimeFormatterBuilder().append(decimalPoint).appendFractionOfMinute(1, 9).toParser(),
            if (wwe == null) {
     * Returns a formatter for a full ordinal date and time without millis,
            btx = basicTimeNoMillis(),  // basic time no millis
        return Constants.bdt;
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * Returns a basic formatter for a full date as four digit year, two digit
        return Constants.bwdt;
}
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
     * Returns a generic ISO date parser for parsing local dates.
            }
        } else if (fields.remove(DateTimeFieldType.dayOfWeek())) {
     * minute-element    = ':' mm [second-element] | [fraction]
            t = time(),  // time
    }
                    checkNotStrictISO(fields, strictISO);
     * minute-element = ':' mm [second-element] | [fraction]
     * <pre>
    public static DateTimeFormatter ordinalDateTime() {
                    .appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2)
    public static DateTimeFormatter basicOrdinalDate() {
            return btx;
            return bodtx;
 *  Licensed under the Apache License, Version 2.0 (the "License");
     * <p>
            return tp;
                }
    static final class Constants {
            if (tt == null) {
        return Constants.hms;
 * SPDX-License-Identifier: Apache-2.0
     * @return a formatter for xxxx-'W'ww-e'T'HH:mm:ssZZ
            bt = basicTime(),  // basic time
        // -----------------------------------------------------------------------
 * chronology, however there may be certain side effects with more unusual
            } else {
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HH:mm' for non-zero.
     *
        if (milli) {
     * <p>
        } else if (milli) {
 *
        }
     * fraction          = ('.' | ',') digit+
     *
    /**
        }
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
        private static DateTimeFormatter yearMonth() {
        return Constants.odtx;
     * Returns a formatter that combines a full date, two digit hour of day,
     * <p>
 * For example, to format a date time in ISO format:
     * The returned formatter can only be used for parsing, printing is unsupported.
     * <li>dayOfYear - ordinal date style
        boolean reducedPrec = false;
    /**
     * <p>
                    .appendOptional(offsetElement().getParser())
        }
            wdtx = weekDateTimeNoMillis(), // week date time no millis
        }
                // -WWW/-WWW
                    .append(secondElement())
                            .appendOptional(
        private static DateTimeFormatter basicDateTimeNoMillis() {
                appendSeparator(bld, extended);
                                            .append(secondElement())
     * This parser only parses local datetimes.
        }
     * This parser is initialised with the local (UTC) time zone.
            }
     * The time zone offset is 'Z' for zero, and of the form '\u00b1HHmm' for non-zero.
                    .appendOptional(offsetElement().getParser())
                return new DateTimeFormatterBuilder().appendLiteral(':')
            tt = tTime(),  // Ttime
                return new DateTimeFormatterBuilder().append(dateElementParser()).appendOptional(time).toFormatter().withZoneUTC();
    /**
     * See {@link #timeParser()} for a more flexible parser that accepts different formats.
 * <p>
            }
            return dtx;
     */
            bld.append(Constants.we);
        private static DateTimeFormatter weekyearWeek() {
                // YYYY-DDD/YYYYDDD
        return bld.toFormatter();
                return new DateTimeFormatterBuilder().append(weekyearElement()).append(weekElement()).toFormatter();
        if (extended) {
     * @since 1.3
            return fse;
            tx = timeNoMillis(),  // time no millis
     * 10            10          hour
    /**
        } else if (workingFields.contains(DateTimeFieldType.dayOfYear())) {
                    reducedPrec = true;
            return wwd;
     * The parser is strict by default, thus time string {@code 24:00} cannot be parsed.
            mhe = minuteElement(), // minuteOfHour element (:mm)
     * date-opt-time     = date-element ['T' [time-element] [offset]]
                    // YYYY--DD/YYYY--DD (non-iso)
     *
    public static DateTimeFormatter hour() {
            throw new IllegalArgumentException("The fields must not be null or empty");
     * <p>
/*
            dhm = dateHourMinute(),   // date hour minute
     * @return a formatter for yyyyDDD
                    reducedPrec = true;
