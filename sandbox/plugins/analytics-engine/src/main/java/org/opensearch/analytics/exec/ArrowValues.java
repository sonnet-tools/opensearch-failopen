        }
            }
                return Instant.ofEpochMilli(v);
import java.util.Locale;
    private static Object normalize(Object value) {
        if (vector instanceof MapVector && vector.getObject(index) instanceof List<?> entries) {
    }
            }
     * {@code long}/{@code double}, timestamps rendered as ISO-8601 UTC strings, list columns as a
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            lt = LocalTime.ofNanoOfDay(nanoOfDay);
                return raw;
import java.time.temporal.ChronoField;
        // MapVector extends ListVector — must come first.
                case DAY -> LocalDate.ofEpochDay(raw);
            default:
import org.apache.arrow.vector.complex.ListVector;
            long raw = ((Number) value).longValue();
                return null;
            };
    private static final Pattern ISO_TIMESTAMP_T = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2})T(\\d{2}:\\d{2}:\\d{2}(?:\\.\\d+)?)$");
 *
        }
        if (type instanceof ArrowType.Time time) {
        }
    private static Object formatTemporal(ArrowType type, Object value) {
                return Instant.ofEpochSecond(v / 1_000_000_000L, v % 1_000_000_000L);
        if (vector instanceof ListVector lv && value instanceof List<?> raw) {
        Object temporal = formatTemporal(vector.getField().getType(), value);
                out.put(k instanceof Text t ? t.toString() : String.valueOf(k), normalize(entry.getValue()));
        return out;
                case MICROSECOND -> Instant.ofEpochSecond(Math.floorDiv(raw, 1_000_000L), Math.floorMod(raw, 1_000_000L) * 1_000L);
            return values;
                Object k = e.get(MapVector.KEY_NAME);
            return normalizeList(list, null);
                return null;
     * not yet supported and return {@code null}.
    private static final DateTimeFormatter TIME_WITH_NANO = new DateTimeFormatterBuilder().appendPattern("HH:mm:ss")
        LocalDate ld;
        return ldt.getNano() == 0 ? ldt.format(TIMESTAMP_NO_NANO) : ldt.format(TIMESTAMP_WITH_NANO);
            case LargeBinary:
     * {@code List} of converted elements. Binary and remaining complex (struct/decimal) types are
        }
        Map<String, Object> out = new LinkedHashMap<>();
import org.apache.arrow.vector.util.Text;
    }
        // field from every get-by-id response. MapVector extends ListVector, so exclude maps.
            List<Object> values = new ArrayList<>(Math.max(0, end - start));
        }
    }
    public static Map<String, Object> toSourceMap(VectorSchemaRoot root, int rowId) {
                return raw == null ? null : raw.toString();
                return raw instanceof Number ? ((Number) raw).doubleValue() : raw;
                return raw == null ? null : raw.toString();
            Instant instant = switch (type.getUnit()) {
    private static Instant toInstant(long v, TimeUnit unit) {
        }
    private static String formatDate(ArrowType.Date type, Object value) {
        ArrowType.ArrowTypeID id = type.getTypeID();
        .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
    }
/** Reads Arrow vector cells as plain Java values, unwrapping Arrow {@link Text} recursively. */
        // are no Lucene stored fields on this path), so dropping them would silently lose the
        }
 */
    public static Object toSourceValue(FieldVector vec, int idx) {
        }
            };
        }
            case Binary:
            return spaceSeparator(new String(v.get(index), StandardCharsets.UTF_8));
    private static String formatTimestamp(ArrowType.Timestamp type, Object value) {
        if (vec instanceof ListVector listVector && vec instanceof MapVector == false) {
            case Timestamp:
                case MILLISECOND -> raw * 1_000_000L;
import java.util.LinkedHashMap;
            if (converted != null) {
import java.time.ZoneOffset;
            ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        }
            LinkedHashMap<String, Object> out = new LinkedHashMap<>(m.size());
                map.put(k instanceof Text t ? t.toString() : String.valueOf(k), normalize(v));
        } else {
                return raw instanceof Number ? ((Number) raw).longValue() : raw;
                Object v = e.get(MapVector.VALUE_NAME);
    private static String spaceSeparator(String s) {
            ld = ldt.toLocalDate();
        LocalTime lt;
            case FixedSizeBinary:
        }
        }
        } else if (value instanceof LocalDateTime ldt) {
        LocalDateTime ldt;
public final class ArrowValues {
        ArrowType type = vec.getField().getType();
            return normalizeList(raw, lv.getDataVector().getField());
    private static String formatTime(ArrowType.Time type, Object value) {
        switch (id) {
        if (value instanceof String s) {
    /**
                case MILLISECOND -> LocalDate.ofEpochDay(Math.floorDiv(raw, 86_400_000L));
        return normalize(value);
 * The OpenSearch Contributors require contributions made to
    private static List<Object> normalizeList(List<?> raw, Field childField) {
                case NANOSECOND -> raw;
        if (vec == null || vec.isNull(idx)) return null;
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC);
        // Multi-valued fields are LIST columns; _source is reconstructed from these columns (there
                }
            ldt = t;
            case Utf8:
            return formatDate(date, value);
    /** ISO-T temporal → space separator; other strings unchanged. */
import java.time.format.DateTimeFormatterBuilder;
 * compatible open source license.
        if (value instanceof List<?> list) {
import org.apache.arrow.vector.types.pojo.Field;
        return out;
            long nanoOfDay = switch (type.getUnit()) {
        switch (id) {
            return formatTime(time, value);
import java.time.LocalDate;
        } else {
        if (vector instanceof VarCharVector v) {
        for (Field field : root.getSchema().getFields()) {
        Object raw = vec.getObject(idx);
                if (!(entry instanceof Map<?, ?> e)) continue;
            // child Arrow type drives temporal element formatting
    // Space-separator output matches the SQL plugin's ExprTimestampValue.
                case NANOSECOND -> Instant.ofEpochSecond(Math.floorDiv(raw, 1_000_000_000L), Math.floorMod(raw, 1_000_000_000L));
        }
        var m = ISO_TIMESTAMP_T.matcher(s);
    public static Object toJavaValue(FieldVector vector, int index) {
            lt = t;
     * Reads an Arrow cell as a JSON-friendly scalar: numerics coerced to
    // Variable-fraction (1..9 digits, trailing zeros stripped) matches DATE_TIME_FORMATTER_VARIABLE_NANOS.
        .toFormatter(Locale.ROOT);
            };
        if (s == null) return null;
 * SPDX-License-Identifier: Apache-2.0
        if (vector.isNull(index)) return null;
                case SECOND -> Instant.ofEpochSecond(raw);
            case MILLISECOND:
            long raw = ((Number) value).longValue();
    }
            return formatTimestamp(ts, value);
        if (type instanceof ArrowType.Timestamp ts) {
            default:
                out.put(field.getName(), converted);
                values.add(toSourceValue(data, i));
        if (type instanceof ArrowType.Date date) {
            case Utf8View, Date:
            return spaceSeparator(s);
            }
        return ld.format(DateTimeFormatter.ISO_LOCAL_DATE);
            FieldVector data = listVector.getDataVector();
        } else {
                    return ISO_FORMATTER.format(toInstant(((Number) raw).longValue(), ts.getUnit()));
    /** Timestamp -> yyyy-MM-dd HH:mm:ss[.frac]. */
import java.util.ArrayList;
    // DataFusion CAST(temporal AS VARCHAR) — date and time joined by 'T', optional fraction.
            return map;
                return Instant.ofEpochSecond(v / 1_000_000L, (v % 1_000_000L) * 1_000L);
        }
    private static final DateTimeFormatter TIMESTAMP_NO_NANO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        }
        if (value instanceof LocalTime t) {
                // TODO type coverage (list, struct, decimal)
/*
        }
import org.apache.arrow.vector.VectorSchemaRoot;
        return null;
import org.apache.arrow.vector.types.TimeUnit;
        }
        if (value instanceof LocalDate d) {
            case BinaryView:
            long raw = ((Number) value).longValue();
    }
            for (Object entry : entries) {
        .toFormatter(Locale.ROOT);
            return spaceSeparator(t.toString());
}
        .appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true)
        if (value == null) return null;
    }
import org.apache.arrow.vector.VarCharVector;
import java.time.LocalDateTime;
    }
            ld = switch (type.getUnit()) {
package org.opensearch.analytics.exec;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
        if (value instanceof LocalDateTime t) {
 * this file be licensed under the Apache-2.0 license or a
            lt = ldt.toLocalTime();
    /** Time -> HH:mm:ss[.frac]; never prefixes with the 1970 epoch date. */
    private static final DateTimeFormatter TIMESTAMP_WITH_NANO = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss")
    }
    }
        return value;
    private static final DateTimeFormatter TIME_NO_NANO = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ROOT);
            case Int:
        return lt.getNano() == 0 ? lt.format(TIME_NO_NANO) : lt.format(TIME_WITH_NANO);
import java.nio.charset.StandardCharsets;
        Object value = vector.getObject(index);
                break;
            case Bool:
import java.util.Map;
            return temporal;
        ArrowType childType = childField == null ? null : childField.getType();
import java.util.regex.Pattern;
import java.util.List;
            case MICROSECOND:
            return out;
            case FloatingPoint:
        if (value instanceof Map<?, ?> m) {
            for (Map.Entry<?, ?> entry : m.entrySet()) {
            ld = d;
        return m.matches() ? m.group(1) + " " + m.group(2) : s;
            out.add(formatted != null ? formatted : normalize(element));
                    ArrowType.Timestamp ts = (ArrowType.Timestamp) type;
            for (int i = start; i < end; i++) {
        for (Object element : raw) {
            default:
import org.apache.arrow.vector.complex.MapVector;
            Object formatted = childType == null ? null : formatTemporal(childType, element);
    private ArrowValues() {}
     */
                return Instant.ofEpochSecond(v);
        if (temporal != null) {
        List<Object> out = new ArrayList<>(raw.size());
import org.apache.arrow.vector.FieldVector;
        }
    /** Converts row {@code rowId} of a {@link VectorSchemaRoot} into a JSON-friendly field map. */
            int end = listVector.getOffsetBuffer().getInt((long) (idx + 1) * ListVector.OFFSET_WIDTH);
            Object converted = toSourceValue(root.getVector(field.getName()), rowId);
            case SECOND:
                case MICROSECOND -> raw * 1_000L;
                case MILLISECOND -> Instant.ofEpochMilli(raw);
    }
        }
            }
                if (raw instanceof Number) {
import org.apache.arrow.vector.types.pojo.ArrowType;
        } else if (value instanceof LocalDate ld) {
        switch (unit) {
            int start = listVector.getOffsetBuffer().getInt((long) idx * ListVector.OFFSET_WIDTH);
import java.time.Instant;
        } else if (value instanceof LocalDateTime ldt) {
            case NANOSECOND:
        }
            case LargeUtf8:
                case SECOND -> raw * 1_000_000_000L;
                Object k = entry.getKey();
        if (value instanceof Text t) {
            ldt = ld.atStartOfDay();
