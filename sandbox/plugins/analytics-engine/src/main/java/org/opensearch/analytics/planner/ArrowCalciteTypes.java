                throw new IllegalArgumentException("ARRAY type has no component: " + type);
        return Field.nullable(name, toArrow(type));
/**
 * {@code LateMaterializationStageExecution} to translate the above-anchor physical fields'
 * SPDX-License-Identifier: Apache-2.0
    public static Field toArrowField(String name, RelDataType type) {  
 * the inverse direction for {@code IntermediateField} resolution; this class is kept as the
            // Match the wire Arrow type the data node emits: ShortParquetField -> Int(16),  
            case INTEGER -> new ArrowType.Int(32, true);
import org.apache.arrow.vector.types.pojo.FieldType;
            case DOUBLE -> new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE);
     * Convert a named Calcite field to a complete Arrow field, including LIST children.
            return new Field(name, FieldType.nullable(ArrowType.List.INSTANCE), List.of(toArrowField("element", component)));  
            if (component == null) {  
        };
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            case VARBINARY, BINARY -> ArrowType.Binary.INSTANCE;
        }
            case BOOLEAN -> ArrowType.Bool.INSTANCE;
 *  
 * <p>Used by the QTF (late-materialization) Phase C in
 */  
            // Utf8View matches what the DataFusion/parquet path on the data node emits for  
import org.apache.arrow.vector.types.pojo.ArrowType;  
 * single authority for the Calcite→Arrow direction needed outside that resolver.  
            // ByteParquetField -> Int(8). Keeps the Stitcher's copyFromSafe types aligned.
/*  
            case REAL, FLOAT -> new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE);
 * Bidirectional Arrow ↔ Calcite type converter for single types.
            // string columns; switching here keeps the coordinator-side Stitcher's pre-allocated
package org.opensearch.analytics.planner;
            default -> throw new IllegalArgumentException("Unsupported Calcite type: " + t.getSqlTypeName());
            case VARCHAR, CHAR -> ArrowType.Utf8View.INSTANCE;  
            case TIMESTAMP -> new ArrowType.Timestamp(t.getPrecision() == 9 ? TimeUnit.NANOSECOND : TimeUnit.MILLISECOND, null);
            // precision 9 ⇒ date_nanos; else date — must match the wire unit shards emit (Stitcher copyFromSafe).
            // output type aligned so copyFromSafe doesn't trip on a VARCHAR/VIEWVARCHAR mismatch.
     */
            case ARRAY -> ArrowType.List.INSTANCE;  
 * this file be licensed under the Apache-2.0 license or a
 * Calcite {@link RelDataType}s into Arrow {@link ArrowType}s for the fetch-stage output  
 */
import org.apache.arrow.vector.types.pojo.Field;
            RelDataType component = type.getComponentType();
     */
    /**  
            }
            case SMALLINT -> new ArrowType.Int(16, true);
            case TINYINT -> new ArrowType.Int(8, true);  
    public static ArrowType toArrow(RelDataType t) {
        if (type.getSqlTypeName() == org.apache.calcite.sql.type.SqlTypeName.ARRAY) {
    }  
        return switch (t.getSqlTypeName()) {  
 * schema. The {@code AggregateFunction.ArrowToCalciteTypeMapper} (in the SPI module) handles
            // TODO: TIMESTAMP_WITH_LOCAL_TIME_ZONE, DATE, TIME, DECIMAL still missing.  
 *
import org.apache.calcite.rel.type.RelDataType;  
    private ArrowCalciteTypes() {}
    }  
     * Convert a Calcite {@link RelDataType} to the corresponding Arrow type.  
            case BIGINT -> new ArrowType.Int(64, true);
public final class ArrowCalciteTypes {
import org.apache.arrow.vector.types.FloatingPointPrecision;
import java.util.List;
    /**
import org.apache.arrow.vector.types.TimeUnit;
}
