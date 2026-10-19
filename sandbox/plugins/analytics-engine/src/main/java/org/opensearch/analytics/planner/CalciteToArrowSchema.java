            case DATE:
 * compatible open source license.
            case REAL:
    private CalciteToArrowSchema() {}  
        // — see class javadoc. Override callers that care about non-null can do their own check.
 * this file be licensed under the Apache-2.0 license or a
                return new ArrowType.Int(8, true);
                return new ArrowType.Int(16, true);
        }  
 * That can mismatch the probe-side join's expected column type and will surface as a plan  
import org.apache.arrow.vector.types.FloatingPointPrecision;
        List<Field> fields = new ArrayList<>(rowType.getFieldCount());  
import org.apache.arrow.vector.types.TimeUnit;  
import org.apache.arrow.vector.types.pojo.FieldType;  
 *
                int precision = type.getPrecision();  
import org.apache.arrow.vector.types.pojo.ArrowType;
            case TIMESTAMP:
        switch (sql) {  
                // See class javadoc — last-resort coercion for the fallback-only path.
            case BINARY:
                int safeScale = scale < 0 ? 0 : Math.min(scale, safePrecision);
        }
                return new ArrowType.Timestamp(TimeUnit.MILLISECOND, null);
import java.util.List;
import org.apache.calcite.sql.type.SqlTypeName;
            case INTEGER:
                return new ArrowType.Binary();  
                return new ArrowType.Utf8();  
 * <p>If a future query needs a richer type (e.g. struct, list, map) on a broadcast build, the
 *
                int scale = type.getScale();
 * error from DataFusion — at which point the solution is to add the missing case here, not to
import org.apache.arrow.vector.types.pojo.Field;
            case VARBINARY:
}  
 * broadcast dispatcher to build a fallback schema for the build-side capture sink so an
    private static ArrowType toArrowType(RelDataType type) {
package org.opensearch.analytics.planner;
 * type-system contract.  
        boolean nullable = type.isNullable();
            case FLOAT:  
            default:
            case VARCHAR:
 * Minimal Calcite {@link RelDataType} → Arrow {@link Schema} converter. Used by the M1
                return new ArrowType.Int(64, true);
import org.apache.calcite.rel.type.RelDataTypeField;  
import org.apache.arrow.vector.types.pojo.Schema;
 * timestamp). Anything outside the whitelist falls back to nullable {@code Utf8}, which is  
/**  
        return new Schema(fields);
                return new ArrowType.Date(DateUnit.DAY);
                int safePrecision = precision <= 0 ? 38 : Math.min(precision, 38);  
/*  
            case CHAR:
    public static Schema convert(RelDataType rowType) {
import java.util.ArrayList;  
                return ArrowType.Bool.INSTANCE;  
 * silently coerce. The catch-all is a deliberate no-row-correctness floor, not a
            case DECIMAL: {
 * @opensearch.internal
 * no rows — the join produces zero matches and the column's storage type doesn't matter.
            case TINYINT:
    }
    private static FieldType toFieldType(RelDataType type) {
                return new ArrowType.Utf8();  
 * acceptable because the fallback schema is only used when the actual broadcast payload has
    }
import org.apache.calcite.rel.type.RelDataType;
 */  
import org.apache.arrow.vector.types.DateUnit;
                return new ArrowType.Time(TimeUnit.MILLISECOND, 32);
 *
 * The OpenSearch Contributors require contributions made to  
            case TIMESTAMP_WITH_LOCAL_TIME_ZONE:  
                return new ArrowType.Int(32, true);  
    }
 *  
 * fallback path will register a memtable with a coerced {@code Utf8} column for that field.
            case BIGINT:
                return new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE);
 */  
            case SMALLINT:  
 * SPDX-License-Identifier: Apache-2.0
                return new ArrowType.Decimal(safePrecision, safeScale, 128);
        SqlTypeName sql = type.getSqlTypeName();
            fields.add(new Field(field.getName(), toFieldType(field.getType()), null));
            case DOUBLE:  
 * all-empty build side still registers a memtable with the right row type on the probe.  
        return FieldType.nullable(toArrowType(type)); // nullable=true is safe; it's a fallback  
            }  
            case TIME:  
public final class CalciteToArrowSchema {
        }
                return new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE);
            return new ArrowType.Utf8();
                // Arrow's Decimal128 supports up to precision 38; cap conservatively for the fallback path.
            case BOOLEAN:
        if (sql == null) {  
 * <p>Covers the common types analytics-engine emits today (numerics, varchar, boolean, date,
        for (RelDataTypeField field : rowType.getFieldList()) {
