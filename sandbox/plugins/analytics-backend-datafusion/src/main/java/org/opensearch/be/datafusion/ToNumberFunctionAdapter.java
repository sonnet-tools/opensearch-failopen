        // SqlKind.SAFE_CAST call instead of a plain CAST.  
        // 1-arg — implied base 10. DataFusion's built-in CAST(str AS DOUBLE) returns NULL on  
class ToNumberFunctionAdapter implements ScalarFunctionAdapter {
 *
        if (operands.isEmpty()) {
/**
        }  
import java.util.List;  
        RelDataTypeFactory factory = cluster.getTypeFactory();
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 * this file be licensed under the Apache-2.0 license or a
        OperandTypes.family(),  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        // 2-arg — rebuild as tonumber(CAST(value AS VARCHAR), CAST(base AS INTEGER))  
    );
 *   {@code tonumber(string[, base])} — converts the string value to a number. If the
    private static RexNode castTo(RexNode operand, SqlTypeName target, RelOptCluster cluster) {  
 * <blockquote>  
 */
            RexNode normalizedBase = castTo(base, SqlTypeName.INTEGER, cluster);
import org.apache.calcite.rex.RexNode;
     */
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import org.apache.calcite.rex.RexCall;
 *
            RexNode base = operands.get(1);
    }  
package org.opensearch.be.datafusion;
}  
        SqlKind.OTHER_FUNCTION,  
 * compatible open source license.
     * {@code try_cast} — so parse failures yield NULL instead of raising.  
 *
            return makeSafeDoubleCast(value, cluster);  
     * operand unchanged when it's already the target type so we don't layer redundant CASTs.
    private static RexNode makeSafeDoubleCast(RexNode value, RelOptCluster cluster) {
 *
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.SqlFunction;  
        }  
/*  
     * Casts {@code operand} to {@code target} while preserving its nullability. Returns the  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.sql.type.OperandTypes;  
        // parse failure.
    }
 * </blockquote>
import org.apache.calcite.sql.type.ReturnTypes;
            RexNode normalizedValue = castTo(value, SqlTypeName.VARCHAR, cluster);  
     * Wraps the single operand in a SAFE_CAST to DOUBLE. SAFE_CAST serialises as a substrait
        }
        "tonumber",
 * <p>Per the
        if (operands.size() == 2) {
 *   {@code base} parameter is omitted, base 10 is assumed. Returns NULL when the string
     * cast with {@code FAILURE_BEHAVIOR_RETURN_NULL}, which DataFusion maps to
            return operand;
    }
        return cluster.getRexBuilder().makeCast(doubleType, value, true, true);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.FieldStorageInfo;  
    /**
 *   cannot be parsed.  
        RelDataType doubleType = factory.createTypeWithNullability(factory.createSqlType(SqlTypeName.DOUBLE), true);
        // RexBuilder.makeCast(type, exp, matchNullability, safe) — the `safe` flag produces a
            return original;
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
     */
        if (operands.size() == 1) {
 */  
        null,
import org.apache.calcite.plan.RelOptCluster;
        ReturnTypes.DOUBLE,
        return original;
        RelDataTypeFactory factory = cluster.getTypeFactory();  
        RexNode value = operands.get(0);
 * Rewrites PPL {@code tonumber(string[, base])} into a DataFusion-compatible expression.  
import org.apache.calcite.rel.type.RelDataType;
        if (operand.getType().getSqlTypeName() == target) {
        RelDataType targetType = factory.createTypeWithNullability(factory.createSqlType(target), operand.getType().isNullable());
 * <a href="https://docs.opensearch.org/latest/sql-and-ppl/ppl/functions/conversion/#tonumber">  
        List<RexNode> operands = original.getOperands();  
        return cluster.getRexBuilder().makeCast(targetType, operand);  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
import org.apache.calcite.sql.SqlKind;
    @Override
            return cluster.getRexBuilder().makeCall(original.getType(), TONUMBER, List.of(normalizedValue, normalizedBase));
 * PPL {@code tonumber} docs</a>:
    static final SqlFunction TONUMBER = new SqlFunction(
        }  
    /**  
