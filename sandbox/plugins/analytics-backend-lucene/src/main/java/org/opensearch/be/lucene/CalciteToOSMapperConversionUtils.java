    /**
 *       {@code "can not write type [class ...]"}.</li>  
 * range), or {@link Double} (otherwise). Fractional values become {@link Double}.
 * field type, not just by literal type. Needs revisiting.
            // Fallback: stringify whatever Calcite stored. Better than passing through a
 *
        };  
import org.apache.calcite.util.DateString;  
                    // Falls through to Double — out of long range.
                yield ts == null ? null : ts.toString();  
            }
     * <ul>
 *   <li>INTEGER / BIGINT / DECIMAL / interval types → {@link BigDecimal}</li>
                    return value.longValueExact();
    }
    }  
     */
 * <p>Calcite stores literals in a small set of canonical Java types regardless of
 * what makes them wire-writable.
 * this file be licensed under the Apache-2.0 license or a
 * Utility for converting Calcite-internal literal values into Java types that the
 * <ol>  
/*  
 *       aren't handled — the mapper expects {@link String}.</li>  
            case BOOLEAN -> (endpoint instanceof Boolean b) ? b : Boolean.parseBoolean(endpoint.toString());
            }  
 * OpenSearch Mapper can parse against a field's declared type.  
 * which most OpenSearch date mappers accept by default but isn't guaranteed for
            return null;
     * fall over on raw BigDecimal.  
 *
                NlsString nls = literal.getValueAs(NlsString.class);
        }
 * </ul>  
            case TIMESTAMP, TIMESTAMP_WITH_LOCAL_TIME_ZONE -> {
 * @opensearch.internal
 * {@link BigDecimal} (see {@code RexLiteral.valueMatchesType}); narrowing is
        }
            default -> {
 * </ol>
                TimestampString ts = literal.getValueAs(TimestampString.class);
        if (value.scale() <= 0 || value.stripTrailingZeros().scale() <= 0) {  
 * The OpenSearch Contributors require contributions made to  
public final class CalciteToOSMapperConversionUtils {  
        return switch (literal.getType().getSqlTypeName()) {  
 *   <li>DOUBLE / FLOAT / REAL → {@link Double}</li>  
            // than a type-cast NPE downstream.
            } catch (ArithmeticException notInIntRange) {  
                }
     * Calcite normalizes {@code 200} (an INTEGER literal) into {@code BigDecimal(200)}
/**
 *       {@code StreamOutput.writeGenericValue}, which has a fixed allowlist of types  
 *  
        }
     * with scale 0; OpenSearch mappers parse {@link Integer}/{@link Long} natively and
 */  
            default -> endpoint.toString();
                yield raw == null ? null : raw.toString();
     *   <li>otherwise → {@link Double}</li>
     *   <li>integer-shaped value within {@code int} range → {@link Integer}</li>  
import java.math.BigDecimal;
        };  
    public static Object sargEndpointToOpenSearchValue(Comparable<?> endpoint, RelDataType type) {
 *
     */
                yield date == null ? null : date.toString();
    /**  
            // type the mapper can't parse; surfaces as a "can't parse value" error rather  
 *   <li><b>Mapper parsing.</b> {@code FieldMapper#parse} on the data node accepts
     *   <li>integer-shaped value within {@code long} range → {@link Long}</li>
 * <p>Numeric narrowing for {@link BigDecimal}: integer-shaped values become  
                Object raw = literal.getValueAs(Object.class);  
import org.apache.calcite.rel.type.RelDataType;
 * {@link org.opensearch.analytics.spi.FieldStorageInfo} to dispatch by declared
    private static Number narrowBigDecimal(BigDecimal value) {
            return null;
                yield nls == null ? null : nls.getValue();  
        return value.doubleValue();
 *   <li><b>Wire compatibility.</b> {@code QueryBuilder} subclasses (e.g.
     * Convert a {@link RexLiteral}'s underlying value into a Java type the OpenSearch
            case TINYINT, SMALLINT, INTEGER, BIGINT, DECIMAL -> narrowBigDecimal((java.math.BigDecimal) endpoint);
 *  
            case CHAR, VARCHAR -> {
    /**
            case BOOLEAN -> literal.getValueAs(Boolean.class);
            case TIME, TIME_WITH_LOCAL_TIME_ZONE -> {  
 *   <li>CHAR / VARCHAR → {@link NlsString} (carries charset + collation)</li>
 *       {@link BigDecimal}, {@link NlsString}, etc. with
                yield time == null ? null : time.toString();
            }  
            try {
     * Narrow a {@link BigDecimal} to the smallest exact Java numeric type:
import org.apache.calcite.util.TimeString;
 *   <li>DATE → {@link DateString}</li>
 *       {@link org.opensearch.index.query.TermQueryBuilder}) serialize the value via
 * <p>NOTE: temp workaround — date/time conversion currently uses ISO-8601 strings,
        if (endpoint == null) {  
            case TINYINT, SMALLINT, INTEGER, BIGINT, DECIMAL -> narrowBigDecimal(literal.getValueAs(BigDecimal.class));
 * Calcite stores TINYINT/SMALLINT/INTEGER/BIGINT/DECIMAL/intervals all as  
 * SPDX-License-Identifier: Apache-2.0
            case FLOAT, REAL, DOUBLE -> ((Number) endpoint).doubleValue();  
import org.apache.calcite.util.NlsString;
            }
import org.apache.calcite.util.TimestampString;  
 * <ul>
        if (literal.isNull()) {  
    public static Object literalToOpenSearchValue(RexLiteral literal) {
        if (value == null) {  
        }
        return switch (type.getSqlTypeName()) {  
 * custom formats. Cleaner long-term shape is to consult the column's  
package org.opensearch.be.lucene;
                DateString date = literal.getValueAs(DateString.class);  
            return null;
                return value.intValueExact();
 * <p>Two reasons to convert here:
 * compatible open source license.
 *   <li>BOOLEAN → {@link Boolean}</li>
            case CHAR, VARCHAR -> (endpoint instanceof NlsString nls) ? nls.getValue() : endpoint.toString();
            case DATE -> {
 *
     * Mapper accepts. Returns {@code null} for SQL NULL literals.  
 * the SQL type the literal was written as (see {@code RexLiteral#valueMatchesType}):  
 *   <li>TIME → {@link TimeString}</li>  
     * Convert a Calcite Sarg endpoint into a Java type the OpenSearch Mapper accepts.  
    }
     */
}
 *   <li>TIMESTAMP → {@link TimestampString}</li>
 *       {@link Number} subclasses but Calcite's String types like {@link NlsString}
 * {@link Integer} (within {@code int} range), {@link Long} (within {@code long}
     * </ul>  
                TimeString time = literal.getValueAs(TimeString.class);
    private CalciteToOSMapperConversionUtils() {}
            }
import org.apache.calcite.rex.RexLiteral;
            case FLOAT, REAL, DOUBLE -> literal.getValueAs(Double.class);  
                } catch (ArithmeticException notInLongRange) {  
                try {
            }
 */
 *       (Long/Integer/Double/Float/String/Boolean/byte[]/...). It rejects
