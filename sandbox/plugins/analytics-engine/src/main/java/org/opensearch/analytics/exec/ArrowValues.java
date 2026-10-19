        if (value instanceof LocalTime t) {
public final class ArrowValues {
    private static Instant toInstant(long v, TimeUnit unit) {
    private static final DateTimeFormatter TIMESTAMP_NO_NANO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        return normalize(value);
        if (s == null) return null;  
            for (Map.Entry<?, ?> entry : m.entrySet()) {  
        ArrowType.ArrowTypeID id = type.getTypeID();
    /** Timestamp -> yyyy-MM-dd HH:mm:ss[.frac]. */
    }  
        List<Object> out = new ArrayList<>(raw.size());
            ldt = t;
        }  
    }
                return Instant.ofEpochSecond(v);
        if (vec == null || vec.isNull(idx)) return null;  
    public static Map<String, Object> toSourceMap(VectorSchemaRoot root, int rowId) {  
        }  
        }
                return raw;  
import java.util.Locale;
import org.apache.arrow.vector.complex.MapVector;
            return temporal;
            long nanoOfDay = switch (type.getUnit()) {
    /**
 * SPDX-License-Identifier: Apache-2.0
            case SECOND:  
    }
            lt = t;  
            };  
                    return ISO_FORMATTER.format(toInstant(((Number) raw).longValue(), ts.getUnit()));
            long raw = ((Number) value).longValue();  
            return spaceSeparator(t.toString());
                break;
                out.put(k instanceof Text t ? t.toString() : String.valueOf(k), normalize(entry.getValue()));
                case MILLISECOND -> Instant.ofEpochMilli(raw);  
            case Timestamp:
                Object v = e.get(MapVector.VALUE_NAME);
        LocalTime lt;
            return map;
            };
        }  
                return raw == null ? null : raw.toString();  
        Object value = vector.getObject(index);
        return null;
                return null;  
import org.apache.arrow.vector.types.pojo.Field;
    }
}  
        LocalDate ld;
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    /** ISO-T temporal → space separator; other strings unchanged. */
            // child Arrow type drives temporal element formatting  
import java.util.LinkedHashMap;  
            case NANOSECOND:  
        } else if (value instanceof LocalDateTime ldt) {
 */  
import java.time.temporal.ChronoField;
    }
        }
                }
        // MapVector extends ListVector — must come first.
                return Instant.ofEpochSecond(v / 1_000_000_000L, v % 1_000_000_000L);
                case NANOSECOND -> Instant.ofEpochSecond(Math.floorDiv(raw, 1_000_000_000L), Math.floorMod(raw, 1_000_000_000L));
                return Instant.ofEpochSecond(v / 1_000_000L, (v % 1_000_000L) * 1_000L);
        if (value instanceof LocalDateTime t) {
        for (Object element : raw) {  
    // DataFusion CAST(temporal AS VARCHAR) — date and time joined by 'T', optional fraction.
    private static String formatTimestamp(ArrowType.Timestamp type, Object value) {
        } else {
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);  
import org.apache.arrow.vector.complex.ListVector;
        return out;
        switch (id) {  
/*  
        } else {
            case BinaryView:
import java.time.format.DateTimeFormatter;
        } else {  
import java.time.Instant;  
            default:
import java.time.LocalDate;
                Object k = e.get(MapVector.KEY_NAME);
        } else if (value instanceof LocalDate ld) {  
    }  
            ld = ldt.toLocalDate();  
            case FloatingPoint:  
                Object k = entry.getKey();
import org.apache.arrow.vector.VectorSchemaRoot;  
    }
        }
            case MILLISECOND:
                if (!(entry instanceof Map<?, ?> e)) continue;  
        if (value instanceof Text t) {
    private static List<Object> normalizeList(List<?> raw, Field childField) {  
     */
        if (value == null) return null;  
            return normalizeList(list, null);
     * {@code List} of converted elements. Binary and remaining complex (struct/decimal) types are
            case LargeBinary:
        .toFormatter(Locale.ROOT);  
    // Variable-fraction (1..9 digits, trailing zeros stripped) matches DATE_TIME_FORMATTER_VARIABLE_NANOS.
    private ArrowValues() {}
        if (vec instanceof ListVector listVector && vec instanceof MapVector == false) {  
            case Bool:
    public static Object toJavaValue(FieldVector vector, int index) {  
import org.apache.arrow.vector.types.TimeUnit;  
import org.apache.arrow.vector.VarCharVector;
                if (raw instanceof Number) {
            out.add(formatted != null ? formatted : normalize(element));
        switch (unit) {
import java.time.ZoneOffset;
     * {@code long}/{@code double}, timestamps rendered as ISO-8601 UTC strings, list columns as a
        }
 * compatible open source license.
                case MILLISECOND -> LocalDate.ofEpochDay(Math.floorDiv(raw, 86_400_000L));
            case Utf8:  
        } else if (value instanceof LocalDateTime ldt) {
        .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
    }
        }
import java.nio.charset.StandardCharsets;
        }  
            lt = ldt.toLocalTime();
    public static Object toSourceValue(FieldVector vec, int idx) {
            ldt = ld.atStartOfDay();
            case Utf8View, Date:
        }
        for (Field field : root.getSchema().getFields()) {
                values.add(toSourceValue(data, i));  
            for (int i = start; i < end; i++) {
import org.apache.arrow.vector.FieldVector;
            ld = d;
                return Instant.ofEpochMilli(v);  
            }  
            for (Object entry : entries) {
        if (vector.isNull(index)) return null;
                    ArrowType.Timestamp ts = (ArrowType.Timestamp) type;  
            case LargeUtf8:
    /** Converts row {@code rowId} of a {@link VectorSchemaRoot} into a JSON-friendly field map. */
     * not yet supported and return {@code null}.  
            ld = switch (type.getUnit()) {  
    private static final DateTimeFormatter TIMESTAMP_WITH_NANO = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss")  
            }
            Object converted = toSourceValue(root.getVector(field.getName()), rowId);  
                // TODO type coverage (list, struct, decimal)
                map.put(k instanceof Text t ? t.toString() : String.valueOf(k), normalize(v));  
                out.put(field.getName(), converted);
import java.time.format.DateTimeFormatterBuilder;  
    }
    private static String spaceSeparator(String s) {
        return out;
        if (type instanceof ArrowType.Date date) {
            return values;
/** Reads Arrow vector cells as plain Java values, unwrapping Arrow {@link Text} recursively. */  
            return formatDate(date, value);
            Instant instant = switch (type.getUnit()) {
            return spaceSeparator(new String(v.get(index), StandardCharsets.UTF_8));  
            List<Object> values = new ArrayList<>(Math.max(0, end - start));
                case NANOSECOND -> raw;  
        Object raw = vec.getObject(idx);
        return lt.getNano() == 0 ? lt.format(TIME_NO_NANO) : lt.format(TIME_WITH_NANO);
            lt = LocalTime.ofNanoOfDay(nanoOfDay);
            FieldVector data = listVector.getDataVector();
        // field from every get-by-id response. MapVector extends ListVector, so exclude maps.
        return ld.format(DateTimeFormatter.ISO_LOCAL_DATE);
        if (vector instanceof ListVector lv && value instanceof List<?> raw) {
        ArrowType childType = childField == null ? null : childField.getType();
            if (converted != null) {
        var m = ISO_TIMESTAMP_T.matcher(s);
                case SECOND -> Instant.ofEpochSecond(raw);
    private static String formatDate(ArrowType.Date type, Object value) {
        }  
        if (vector instanceof VarCharVector v) {
        }  
        if (type instanceof ArrowType.Time time) {
 * this file be licensed under the Apache-2.0 license or a
            default:
            return formatTime(time, value);
    }
import java.time.LocalTime;  
            return out;
        if (value instanceof LocalDate d) {  
        Object temporal = formatTemporal(vector.getField().getType(), value);  
                case MILLISECOND -> raw * 1_000_000L;
import org.apache.arrow.vector.types.pojo.ArrowType;
        .toFormatter(Locale.ROOT);
        // are no Lucene stored fields on this path), so dropping them would silently lose the
        LocalDateTime ldt;  
                return raw == null ? null : raw.toString();  
    /** Time -> HH:mm:ss[.frac]; never prefixes with the 1970 epoch date. */
    }  
 * The OpenSearch Contributors require contributions made to  
                case MICROSECOND -> raw * 1_000L;
    private static String formatTime(ArrowType.Time type, Object value) {  
        if (type instanceof ArrowType.Timestamp ts) {
                case DAY -> LocalDate.ofEpochDay(raw);
            Object formatted = childType == null ? null : formatTemporal(childType, element);
            case Int:
import org.apache.arrow.vector.util.Text;  
            default:  
        switch (id) {
            case MICROSECOND:
import java.time.LocalDateTime;
        .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
        ArrowType type = vec.getField().getType();
            int start = listVector.getOffsetBuffer().getInt((long) idx * ListVector.OFFSET_WIDTH);
            return normalizeList(raw, lv.getDataVector().getField());
            long raw = ((Number) value).longValue();
        }  
        }  
        if (value instanceof Map<?, ?> m) {
            long raw = ((Number) value).longValue();
        }  
        if (value instanceof String s) {
                case SECOND -> raw * 1_000_000_000L;  
        Map<String, Object> out = new LinkedHashMap<>();
            };  
        }  
    private static final Pattern ISO_TIMESTAMP_T = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2})T(\\d{2}:\\d{2}:\\d{2}(?:\\.\\d+)?)$");
            }  
package org.opensearch.analytics.exec;
            LinkedHashMap<String, Object> out = new LinkedHashMap<>(m.size());
            return formatTimestamp(ts, value);
    private static Object formatTemporal(ArrowType type, Object value) {
        return m.matches() ? m.group(1) + " " + m.group(2) : s;
            return spaceSeparator(s);
                return raw instanceof Number ? ((Number) raw).longValue() : raw;
            ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
import java.util.List;
        }
        }
import java.util.Map;  
        return ldt.getNano() == 0 ? ldt.format(TIMESTAMP_NO_NANO) : ldt.format(TIMESTAMP_WITH_NANO);  
import java.util.regex.Pattern;
        return value;  
                return raw instanceof Number ? ((Number) raw).doubleValue() : raw;
import java.util.ArrayList;
        }  
                return null;
                case MICROSECOND -> Instant.ofEpochSecond(Math.floorDiv(raw, 1_000_000L), Math.floorMod(raw, 1_000_000L) * 1_000L);
        if (value instanceof List<?> list) {
    private static final DateTimeFormatter TIME_WITH_NANO = new DateTimeFormatterBuilder().appendPattern("HH:mm:ss")
            int end = listVector.getOffsetBuffer().getInt((long) (idx + 1) * ListVector.OFFSET_WIDTH);  
        if (temporal != null) {
    private static Object normalize(Object value) {  
        // Multi-valued fields are LIST columns; _source is reconstructed from these columns (there  
        }  
    private static final DateTimeFormatter TIME_NO_NANO = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ROOT);  
            }
    // Space-separator output matches the SQL plugin's ExprTimestampValue.  
            case Binary:
 *
     * Reads an Arrow cell as a JSON-friendly scalar: numerics coerced to  
            case FixedSizeBinary:  
        if (vector instanceof MapVector && vector.getObject(index) instanceof List<?> entries) {  
