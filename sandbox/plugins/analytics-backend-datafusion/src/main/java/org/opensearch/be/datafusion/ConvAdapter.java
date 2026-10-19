 */
 * 16)}), but the Rust UDF takes a string; on the Substrait/pushdown path there is no implicit
 * @opensearch.internal
        if (operands.size() != 3) {
import org.apache.calcite.rex.RexBuilder;
        null,  
import java.util.List;  
import org.apache.calcite.sql.type.ReturnTypes;  
        }
        "conv",  
        List<RexNode> operands = original.getOperands();
 * (registered upstream under the name {@code "CONVERT"} by {@code ConvFunction.toUDF}) to a
 *  
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.type.OperandTypes;
    private static RexNode castToVarchar(RexNode operand, RelOptCluster cluster) {
/*  
import org.opensearch.analytics.spi.FieldStorageInfo;  
import org.apache.calcite.rel.type.RelDataType;
        RelDataType varchar = factory.createTypeWithNullability(factory.createSqlType(SqlTypeName.VARCHAR), operand.getType().isNullable());  
        RexBuilder rexBuilder = cluster.getRexBuilder();
class ConvAdapter implements ScalarFunctionAdapter {  
        SqlKind.OTHER_FUNCTION,
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        ReturnTypes.VARCHAR_2000_NULLABLE,
    );  
import org.apache.calcite.plan.RelOptCluster;
    }
    @Override
}
 */  
import org.apache.calcite.sql.SqlKind;  
        return cluster.getRexBuilder().makeCall(original.getType(), LOCAL_CONV_OP, List.of(converted, operands.get(1), operands.get(2)));
        RelDataTypeFactory factory = cluster.getTypeFactory();
 * The OpenSearch Contributors require contributions made to  
 * {@code ConvFunction.conv}. PPL accepts a string OR a numeric first arg ({@code conv(intCol, 10,
import org.apache.calcite.sql.SqlFunctionCategory;
/**
    }  
 * Int32"). Cast a numeric {@code n} to VARCHAR here so the Rust UDF always receives a string —
            return cluster.getRexBuilder().makeCall(original.getType(), LOCAL_CONV_OP, operands);  
 * <p>Semantics mirror {@code Long.toString(Long.parseLong(n, fromBase), toBase)} — same as PPL's  
 * mirroring how {@code StrftimeFunctionAdapter} folds numeric inputs onto its canonical type.
 *
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.SqlOperator;
 * locally-declared {@link SqlFunction} whose substrait sig is mapped to the {@code conv} Rust UDF
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexNode;  
        RexNode converted = SqlTypeName.NUMERIC_TYPES.contains(n.getType().getSqlTypeName()) ? castToVarchar(n, cluster) : n;  
        RexNode n = operands.get(0);
 * {@code src/main/resources/opensearch_scalar_functions.yaml}).
import org.apache.calcite.sql.type.SqlTypeFamily;
        return rexBuilder.makeCast(varchar, operand, true, false);
    static final SqlOperator LOCAL_CONV_OP = new SqlFunction(
 * cast, so a numeric {@code n} fails signature resolution ("conv: arg 0 expected string, got  
 * this file be licensed under the Apache-2.0 license or a
 * (see {@code rust/src/udf/conv.rs} and the YAML signature in  
        OperandTypes.family(SqlTypeFamily.ANY, SqlTypeFamily.INTEGER, SqlTypeFamily.INTEGER),
package org.opensearch.be.datafusion;
 *
 * compatible open source license.
 * Adapter for PPL's {@code conv(n, fromBase, toBase)} — base conversion. Rewrites the PPL UDF  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
