    FieldType(String mappingType) {
                return fieldType;
    public static Set<FieldType> keyword() {
     * the value-level type by the time the runtime executes them.
 * compatible open source license.
    MAP("map");
    DATE("date"),
 * The OpenSearch Contributors require contributions made to  
    /** Maps an OpenSearch mapping type string to a FieldType. Returns null if not recognized. */  
    /**  
            default -> null;
            case DATE -> FieldType.DATE;
     * for filter / project operators on MAP columns are intentionally minimal: callers (e.g.
 * this file be licensed under the Apache-2.0 license or a
            case BIGINT -> LONG;
    // Date  
     * Map-typed expression result. In-tree producers include PPL {@code spath}'s auto-extract
    }  
    }
import java.util.EnumSet;  
import java.util.Set;
            case MAP -> FieldType.MAP;
        for (FieldType fieldType : values()) {
        }
 * Granular field types for capability matching. Each value maps to an OpenSearch
    /** Maps a Calcite SqlTypeName to a FieldType. Returns null if not recognized. */
    // Keyword  
    BYTE("byte"),
    MATCH_ONLY_TEXT("match_only_text"),
    public static Set<FieldType> date() {
 *
            case FLOAT, REAL -> FieldType.FLOAT;
 */
     * mapping today, so {@link #fromMappingType} never resolves to it through the mapping  
    /** All keyword-like field types. */  
 * mapping type string. Convenience grouping methods for common families.
    SCALED_FLOAT("scaled_float"),  
    UNSIGNED_LONG("unsigned_long"),
    }
    INTEGER("integer"),
    public String getMappingType() {  
        return null;
import org.apache.calcite.sql.type.SqlTypeName;
     * advertises that mapping string.  
    /** All text field types. */
    TEXT("text"),  
            case INTEGER -> FieldType.INTEGER;  
public enum FieldType {  
    NESTED("nested"),  
            case BOOLEAN -> FieldType.BOOLEAN;
        return switch (sqlTypeName) {  
        if (sqlTypeName == null) {  
        return mappingType;
            case DOUBLE, DECIMAL -> FieldType.DOUBLE;  
        }
    IP("ip"),  
    // Singular
            case CHAR, VARCHAR -> KEYWORD;
    BOOLEAN("boolean"),
    /** All date field types. */
    /** All numeric field types. */
     * {@code parse} (named regex groups returned as {@code MAP<VARCHAR, VARCHAR>}). Mapping
package org.opensearch.analytics.spi;
 * @opensearch.internal
        if (type == null) {
        return EnumSet.of(KEYWORD, CONSTANT_KEYWORD, WILDCARD_FIELD);
     * mode ({@code JSON_EXTRACT_ALL} returns {@code MAP<VARCHAR, VARCHAR>}) and PPL  
        return EnumSet.of(INTEGER, LONG, SHORT, BYTE, FLOAT, DOUBLE, HALF_FLOAT, SCALED_FLOAT, UNSIGNED_LONG);  
    // ── Composite ────────────────────────────────────────────────────
    HALF_FLOAT("half_float"),
        return EnumSet.of(TEXT, MATCH_ONLY_TEXT);
     * path; columns reach MAP only through {@link #fromSqlTypeName}. Capability registrations
        }  
 * SPDX-License-Identifier: Apache-2.0
    BINARY("binary"),
    }
    SHORT("short"),
    // Text
     * functions (PPL {@code array(…)}, {@code array_slice}, {@code array_distinct}). Has no
    OBJECT("object"),
        return EnumSet.of(DATE, DATE_NANOS);  
    KEYWORD("keyword"),
     */  
    public static FieldType fromSqlTypeName(SqlTypeName sqlTypeName) {
     */
    public static FieldType fromMappingType(String type) {
            return null;
    COMPLETION("completion"),  
    }
            return null;  
 *  
            case ARRAY -> FieldType.ARRAY;  
    FLOAT("float"),  
    public static Set<FieldType> text() {  
            case TIME, TIMESTAMP, TIMESTAMP_WITH_LOCAL_TIME_ZONE -> FieldType.DATE;  
     * OpenSearch mapping equivalent — arrays in OpenSearch are multi-value fields with the  
    LONG("long"),  
    GEO_SHAPE("geo_shape"),  
    ARRAY("array"),
            case BINARY, VARBINARY -> FieldType.BINARY;
     * PPL {@code where doc.user.name}) always wrap the MAP column in an ITEM lookup whose  
    private final String mappingType;  
        };  
    // Numeric
    GEO_POINT("geo_point"),
        this.mappingType = mappingType;  
    }
/*  
    FLAT_OBJECT("flat_object"),
    public static Set<FieldType> numeric() {
    SHAPE("shape"),
     * placeholder; {@link #fromMappingType} keeps working unchanged because no source
    /**
/**  
    DATE_NANOS("date_nanos"),
    }
    POINT("point"),
            if (fieldType.mappingType.equals(type)) {  
            case SMALLINT -> SHORT;
     * underlying element type, not a separate type. The mapping string is {@code "array"} as a
    CONSTANT_KEYWORD("constant_keyword"),
    }
    WILDCARD_FIELD("wildcard"),  
    DOUBLE("double"),
}
            }
     * string is {@code "map"} as a placeholder — no OpenSearch storage format declares this
            case TINYINT -> BYTE;
 */  
     * Array-typed expression result. Used for the return-type slot of array-producing scalar
     * result type is the map's value type, so the EQUALS / sort / aggregate operators see
