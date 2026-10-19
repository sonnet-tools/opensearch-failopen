        );
            name,
        }
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
    public static final SqlFunction MKTIME = binaryUdf("mktime", ReturnTypes.DOUBLE_NULLABLE);
    }  
    }
    public TimeConversionFunctionAdapter(SqlFunction target) {
import org.opensearch.analytics.spi.FieldStorageInfo;
 */
 * </ul>
 * compatible open source license.
            return operand;
        this.target = target;  
        return rexBuilder.makeCall(original.getType(), target, List.of(normalizedValue, format));  
import org.apache.calcite.sql.SqlFunctionCategory;
        List<RexNode> operands = original.getOperands();
 * this file be licensed under the Apache-2.0 license or a
        SqlTypeName src = operand.getType().getSqlTypeName();
     * Coerces {@code operand} to VARCHAR. Returns the operand unchanged when it's already a
/*  
    /** Synthetic operator for {@code ctime(value, format) → varchar} */  
 *       epoch seconds directly; rendering them as strings lets the Rust UDFs share one string
        }
        if (src == SqlTypeName.VARCHAR || src == SqlTypeName.CHAR) {  
}  
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.sql.SqlFunction;
 *       input path with identical null-propagation semantics. Numeric columns become
 * <p>Shape normalization:
            SqlKind.OTHER_FUNCTION,
 */  
    private static SqlFunction binaryUdf(String name, SqlReturnTypeInference returnTypeInference) {
        RexBuilder rexBuilder = cluster.getRexBuilder();  
     */  
    @Override  
import org.apache.calcite.sql.type.OperandTypes;
        );
import org.apache.calcite.sql.type.SqlReturnTypeInference;  
        return new SqlFunction(  
    /**  
 *       incoming call is unary, so the Rust UDF always sees a 2-arg signature.</li>  
 * The OpenSearch Contributors require contributions made to  
        RexNode format = operands.size() == 2 ? operands.get(1) : rexBuilder.makeLiteral(DEFAULT_FORMAT);
 *
            returnTypeInference,  
import org.apache.calcite.rex.RexNode;  
/**
 *   <li>Format operand filled in with default {@code "%m/%d/%Y %H:%M:%S"} when the
        RelDataType varcharType = factory.createTypeWithNullability(
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.SqlKind;  
public class TimeConversionFunctionAdapter implements ScalarFunctionAdapter {
 *  
 * <ul>
        RelDataTypeFactory factory = cluster.getTypeFactory();  
import org.apache.calcite.sql.type.SqlTypeName;
    }
    /** Synthetic operator for {@code mktime(value, format) → fp64} */  
            operand.getType().isNullable()  
 *       representation, which the UDF's {@code toEpochSeconds} parses back to double.</li>
    private static RexNode coerceToVarchar(RexNode operand, RelOptCluster cluster) {
 *
import org.apache.calcite.rel.type.RelDataType;
 * @opensearch.internal  
 *   <li>Value operand coerced to VARCHAR. {@code ctime} / {@code mktime} both accept numeric  
            OperandTypes.family(),
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
        if (operands.isEmpty() || operands.size() > 2) {  
        RexNode normalizedValue = coerceToVarchar(operands.get(0), cluster);
 *       {@code CAST(value AS VARCHAR)} — DataFusion produces the canonical decimal  
            null,
            return original;
    public static final String DEFAULT_FORMAT = "%m/%d/%Y %H:%M:%S";
    private final SqlFunction target;  
            factory.createSqlType(SqlTypeName.VARCHAR),
import org.apache.calcite.plan.RelOptCluster;
    }
 * Adapter for {@code ctime(value[, format])} / {@code mktime(value[, format])}
import org.apache.calcite.sql.type.ReturnTypes;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        return cluster.getRexBuilder().makeCast(varcharType, operand);
 * SPDX-License-Identifier: Apache-2.0
     * character type so we don't layer redundant CASTs.
import java.util.List;
    public static final SqlFunction CTIME = binaryUdf("ctime", ReturnTypes.VARCHAR_NULLABLE);
import org.apache.calcite.rex.RexCall;
package org.opensearch.be.datafusion.planner.adapter;
