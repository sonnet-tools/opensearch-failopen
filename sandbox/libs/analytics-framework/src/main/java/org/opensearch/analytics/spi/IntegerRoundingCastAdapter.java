import org.apache.calcite.rex.RexNode;
    }  
            return original;
import org.apache.calcite.rel.type.RelDataType;
        rebuiltOperands.add(widenedFirst);  
        }  
/*  
    public IntegerRoundingCastAdapter(SqlOperator target) {  
 */  
import org.apache.calcite.plan.RelOptCluster;
 * wire/physical disagreement. Adjusting Calcite's return type would break the user-facing  
        boolean operatorRename = original.getOperator() != target;  
 *  
        if (original.getOperands().isEmpty()) {  
}
import org.apache.calcite.sql.SqlOperator;  
            return original;
        // with the renamed operator; no widening/cast needed.
import org.apache.calcite.sql.type.SqlTypeName;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *
            rebuiltOperands.add(original.getOperands().get(i));
 * {@code Float64}. On multi-shard plans the substrait schema check rejects the resulting
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        if (!firstIsInteger && !operatorRename) {  
/**
 * The OpenSearch Contributors require contributions made to  
public class IntegerRoundingCastAdapter implements ScalarFunctionAdapter {
    @Override
        // be a rename), and restore the original return type via the outer CAST.
 * and physical output agree without changing the outer-visible type.
            factory.createSqlType(SqlTypeName.DOUBLE),
 */
package org.opensearch.analytics.spi;
        // Already-wide operand but operator needs renaming (e.g. SIGN → signum). Rebuild  
            firstOperand.getType().isNullable()
 * Calcite types {@code FLOOR(int_col)}, {@code CEIL}, {@code SIGN}, {@code TRUNCATE} as  
    }
        RexNode innerCall = cluster.getRexBuilder().makeCall(doubleType, target, rebuiltOperands);
 * are rebuilt only when {@code target} renames the operator (e.g. SIGN → signum).
            return cluster.getRexBuilder().makeCall(original.getType(), target, original.getOperands());  
 * {@code CAST(fn(CAST(int_col AS DOUBLE) [, ...]) AS <original_type>)}. Trailing operands
 * this file be licensed under the Apache-2.0 license or a
        return cluster.getRexBuilder().makeCast(original.getType(), innerCall);
import org.apache.calcite.rex.RexCall;
        }
        SqlTypeName firstType = firstOperand.getType().getSqlTypeName();
        }
 * SPDX-License-Identifier: Apache-2.0
 * {@code int} (ARG0 inference), but DataFusion's UDFs only accept fp32/fp64 and produce
 * <p>Rewrites {@code fn(int_col [, ...])} as
        java.util.List<RexNode> rebuiltOperands = new java.util.ArrayList<>(original.getOperands().size());
 * (e.g. {@code TRUNCATE}'s {@code scale}) pass through untouched; non-integer first operands  
 * compatible open source license.
        }
        RexNode widenedFirst = cluster.getRexBuilder().makeCast(doubleType, firstOperand);
 * @opensearch.internal  
        // Already-wide operand and same operator — nothing to do.
 *
        if (!firstIsInteger) {
        boolean firstIsInteger = SqlTypeName.INT_TYPES.contains(firstType);
    private final SqlOperator target;
        );  
import java.util.List;  
        this.target = target;
        // Integer first operand: widen to DOUBLE, rebuild the call (using `target`, which may  
 * "same type as input" PPL contract; instead this adapter wraps the call in casts so wire
        RelDataTypeFactory factory = cluster.getTypeFactory();
        RelDataType doubleType = factory.createTypeWithNullability(  
        for (int i = 1; i < original.getOperands().size(); i++) {
        RexNode firstOperand = original.getOperands().get(0);  
