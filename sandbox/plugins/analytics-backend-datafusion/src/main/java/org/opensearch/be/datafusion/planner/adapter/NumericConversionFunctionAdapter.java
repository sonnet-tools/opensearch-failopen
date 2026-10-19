    }  
     */
}
        }  
        }
            return original;  
     * Coerces {@code operand} to VARCHAR. Returns the operand unchanged when it's already a
            return operand;
    /** Synthetic operator for {@code dur2sec(x)}. Paired with extension name {@code "dur2sec"}. */  
import org.apache.calcite.plan.RelOptCluster;
    public static final SqlFunction DUR2SEC = unaryDoubleUdf("dur2sec");
        SqlTypeName src = operand.getType().getSqlTypeName();  
import org.apache.calcite.rex.RexNode;
            OperandTypes.family(),  
 * Adapter for numeric-conversion family:  
        return cluster.getRexBuilder().makeCall(original.getType(), target, List.of(normalized));
import org.apache.calcite.sql.SqlFunctionCategory;
    /** Synthetic operator for {@code auto(x)}. Paired with extension name {@code "auto"}. */  
    public static final SqlFunction RMUNIT = unaryDoubleUdf("rmunit");
 * returning a nullable DOUBLE. The adapter normalizes the operand to VARCHAR, then rebuilds
        if (original.getOperands().size() != 1) {
import org.opensearch.analytics.spi.FieldStorageInfo;  
    private final SqlFunction target;  
/*  
 *
    /**  
    public static final SqlFunction AUTO = unaryDoubleUdf("auto");
import org.apache.calcite.sql.type.SqlTypeName;
 *
 */  
            ReturnTypes.DOUBLE_NULLABLE,
    public NumericConversionFunctionAdapter(SqlFunction target) {
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * Each synthetic operator is paired with its Substrait extension name.  
import org.apache.calcite.rel.type.RelDataType;
 * @opensearch.internal
        );
/**
    /** Synthetic operator for {@code memk(x)}. Paired with extension name {@code "memk"}. */  
import java.util.List;  
import org.apache.calcite.sql.SqlFunction;  
    /** Synthetic operator for {@code rmcomma(x)}. Paired with extension name {@code "rmcomma"}. */  
import org.apache.calcite.sql.type.OperandTypes;  
    public static final SqlFunction NUM = unaryDoubleUdf("num");
    }
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 * the call with a per-function synthetic {@link SqlFunction}.
            SqlFunctionCategory.USER_DEFINED_FUNCTION
    }
     * Locally-declared {@code name(varchar) → fp64} operator.
        if (src == SqlTypeName.VARCHAR || src == SqlTypeName.CHAR) {
            name,
    public static final SqlFunction MEMK = unaryDoubleUdf("memk");
 * this file be licensed under the Apache-2.0 license or a
        return cluster.getRexBuilder().makeCast(varcharType, operand);  
    /** Synthetic operator for {@code num(x)}. Paired with extension name {@code "num"}. */  
 * The OpenSearch Contributors require contributions made to  
        return new SqlFunction(
 */  
        this.target = target;  
        RelDataTypeFactory factory = cluster.getTypeFactory();
            factory.createSqlType(SqlTypeName.VARCHAR),  
package org.opensearch.be.datafusion.planner.adapter;
 * <p>All five share the same Calcite shape — unary call whose single operand is of any type,  
 * compatible open source license.
        RexNode value = original.getOperands().get(0);
    public static final SqlFunction MSTIME = unaryDoubleUdf("mstime");
public class NumericConversionFunctionAdapter implements ScalarFunctionAdapter {
    /**
    private static SqlFunction unaryDoubleUdf(String name) {  
 * {@code num} / {@code auto} / {@code memk} / {@code rmcomma} / {@code rmunit}
            operand.getType().isNullable()
import org.apache.calcite.rex.RexCall;
 *
        RelDataType varcharType = factory.createTypeWithNullability(
    public static final SqlFunction RMCOMMA = unaryDoubleUdf("rmcomma");
        RexNode normalized = coerceToVarchar(value, cluster);  
    private static RexNode coerceToVarchar(RexNode operand, RelOptCluster cluster) {
import org.apache.calcite.sql.SqlKind;
        );
 * SPDX-License-Identifier: Apache-2.0
    /** Synthetic operator for {@code mstime(x)}. Paired with extension name {@code "mstime"}. */  
import org.apache.calcite.sql.type.ReturnTypes;
    @Override  
     * character type so we don't apply redundant CAST.  
     */
            SqlKind.OTHER_FUNCTION,  
    }
    /** Synthetic operator for {@code rmunit(x)}. Paired with extension name {@code "rmunit"}. */  
            null,
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
