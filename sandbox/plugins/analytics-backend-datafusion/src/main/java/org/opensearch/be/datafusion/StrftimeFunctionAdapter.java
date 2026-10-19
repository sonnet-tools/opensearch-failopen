import org.apache.calcite.plan.RelOptCluster;
        if (isIntegralNumeric(valueType)
        RexNode normalizedValue;  
        null,  
 * UDF's {@code coerce_types} canonicalizes them to {@code Timestamp(Microsecond, None)}).
import org.apache.calcite.sql.SqlFunctionCategory;
        OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.CHARACTER),
    }  
import org.apache.calcite.sql.type.OperandTypes;  
 */
            return operand;
 * compatible open source license.
        } else {
        }  
    private static boolean isIntegralNumeric(SqlTypeName type) {
        // a single Float64 signature; DOUBLE preserves fractional-seconds precision. Timestamp /
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.sql.SqlFunction;  
}
        SqlKind.OTHER_FUNCTION,
        SqlFunctionCategory.USER_DEFINED_FUNCTION
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * serializes under Substrait extension name {@code "strftime"} (matched by the Rust UDF
/*  
            normalizedValue = castTo(value, SqlTypeName.DOUBLE, cluster);  
 * this file be licensed under the Apache-2.0 license or a
        RexNode value = operands.get(0);
        }
        RexNode format = operands.get(1);  
import org.apache.calcite.sql.type.SqlTypeName;  
        List<RexNode> operands = original.getOperands();
/**  
    }
            || valueType == SqlTypeName.FLOAT
 * The OpenSearch Contributors require contributions made to  
        RelDataTypeFactory factory = cluster.getTypeFactory();
import org.opensearch.analytics.spi.FieldStorageInfo;
        "strftime",  
            || valueType == SqlTypeName.DECIMAL
        return cluster.getRexBuilder().makeCast(targetType, operand);  
import org.apache.calcite.rex.RexCall;
    static final SqlFunction STRFTIME = new SqlFunction(
        }  
 * SPDX-License-Identifier: Apache-2.0
    }
 *
        if (operands.size() != 2) {
        if (operand.getType().getSqlTypeName() == target) {
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.SqlKind;
import java.util.List;
 *  
            || valueType == SqlTypeName.REAL  
    @Override
        return cluster.getRexBuilder().makeCall(original.getType(), STRFTIME, List.of(normalizedValue, format));
            normalizedValue = value;
        SqlTypeName valueType = value.getType().getSqlTypeName();
 * signature via {@code CAST AS DOUBLE}; timestamp/date inputs forward verbatim (the Rust
    );  
        RelDataType targetType = factory.createTypeWithNullability(factory.createSqlType(target), operand.getType().isNullable());
    private static RexNode castTo(RexNode operand, SqlTypeName target, RelOptCluster cluster) {  
import org.apache.calcite.sql.type.ReturnTypes;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 */  
            || SqlTypeName.CHAR_TYPES.contains(valueType)) {
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.sql.type.SqlTypeFamily;
        return type == SqlTypeName.TINYINT || type == SqlTypeName.SMALLINT || type == SqlTypeName.INTEGER || type == SqlTypeName.BIGINT;  
class StrftimeFunctionAdapter implements ScalarFunctionAdapter {  
        // Fold every numeric (and string — IT covers the Calcite auto-coerce path) source onto  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 * Rewrites PPL {@code strftime(value, format)} → local {@link #STRFTIME}, which Isthmus
 * @opensearch.internal
            return original;  
        // date / time inputs forward verbatim — the Rust coerce_types canonicalizes them.
 * in {@code rust/src/udf/strftime.rs}). Folds every numeric source onto a single Float64  
        ReturnTypes.VARCHAR,
