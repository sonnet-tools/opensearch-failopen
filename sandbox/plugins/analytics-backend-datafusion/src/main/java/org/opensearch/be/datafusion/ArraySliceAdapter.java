 *
 *       signature accepts only integer indexes and refuses to coerce decimal
 *       with 0-based start and a length-of-elements third arg. DataFusion's  
 * only the 3-arg form.  
 * </ol>
 * <p>The 2-arg form {@code ARRAY_SLICE(arr, start)} (single-element extract)  
import org.apache.calcite.plan.RelOptCluster;
        RexNode array = coerced.get(0);
        RexNode length = coerced.get(2);  
        RexNode one = rexBuilder.makeExactLiteral(BigDecimal.ONE, bigint);
 *       arithmetic above applies uniformly.  
        }
import java.util.List;  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */  
import org.apache.calcite.rex.RexBuilder;
                coerced.add(rexBuilder.makeCast(nullableBigint, operand, true, false));
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 *         <li>{@code start' = start + 1}
                RelDataType nullableBigint = typeFactory.createTypeWithNullability(bigint, operand.getType().isNullable());
        for (int i = 0; i < operands.size(); i++) {
    ) {  
 *       and argument types 'array_slice(List(Int32), Decimal128(20, 0),  
        RelDataTypeFactory typeFactory,  
import org.apache.calcite.sql.type.SqlTypeName;  
 *   <li><b>Semantic conversion: 0-based {@code (start, length)} →
        RexNode oneBasedStart = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, start, one);
 *       <p>The conversion is purely arithmetic on the operands:  
import org.apache.calcite.rex.RexNode;  
            }  
 * this file be licensed under the Apache-2.0 license or a
 *       </ul>
    private static List<RexNode> coerceIndexes(
 * is not produced by PPL's {@code MVIndexFunctionImp} (single-element access
 *       1-based {@code (start, end)} inclusive.</b> Calcite's  
                coerced.add(operand);
 *       integer literals as {@code DECIMAL(20,0)} (precision wide enough to
        List<RexNode> coerced = coerceIndexes(rexBuilder, typeFactory, bigint, operands);  
        RexNode endInclusive = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, start, length);  
    @Override  
        RexBuilder rexBuilder = cluster.getRexBuilder();
 *
 *       {@code [1, 2, 3]}, but the PPL expectation is {@code [2, 3, 4]}
 *       {@code MVIndexFunctionImp.resolveRange}) is the Spark / Hive flavor
 *   <li><b>Index coercion to {@code BIGINT}.</b> PPL's parser types positive
        List<RexNode> coerced = new ArrayList<>(operands.size());
            );
 */  
        RexNode start = coerced.get(1);
 * Adapter for Calcite's {@link SqlLibraryOperators#ARRAY_SLICE}. Two transforms  
 * lowers through {@code INTERNAL_ITEM} instead), so this adapter handles
                original.getType(),
 *       <ul>
import java.util.ArrayList;
 *       third arg. Without this conversion, {@code mvindex(arr=[1..5], 1, 3)}
 *       Decimal128(22, 0))'"}.
                original.getOperator(),
 *         <li>{@code end'   = start + length} (which is {@code start + 1 +  
class ArraySliceAdapter implements ScalarFunctionAdapter {
 *       (0-based positions 1..3 inclusive).
import org.apache.calcite.rex.RexCall;
            } else {  
        if (operands.size() != 3) {  
    }
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();  
/*  
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.apache.calcite.rel.type.RelDataType;
                coerceIndexes(rexBuilder, typeFactory, bigint, operands)  
 * are needed before substrait emission:
            return rexBuilder.makeCall(  
        List<RexNode> operands
            if (i == 0 || operand.getType().getSqlTypeName() == SqlTypeName.BIGINT) {
        }
 * The OpenSearch Contributors require contributions made to  
 *       hold any 64-bit unsigned value), but DataFusion's {@code array_slice}  
import java.math.BigDecimal;
 *             (length - 1)} = the 1-based inclusive end)
 *
        List<RexNode> operands = original.getOperands();
 *       native {@code array_slice} is 1-based with an inclusive end-index
package org.opensearch.be.datafusion;
            // Defensive: unexpected arity. Fall through with BIGINT coercion only — the substrait
 *       runs (it uses {@code arrayLen + idx} for both start and end), so the
        RelDataType bigint,
            RexNode operand = operands.get(i);  
 *       0-based positions by {@code MVIndexFunctionImp} before this adapter
        return coerced;
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
 * compatible open source license.
 *
 *       would emit {@code ARRAY_SLICE(arr, 1, 3)} → DataFusion returns  
 * <ol>  
            // converter will surface a missing-signature error with a clear message.
 * @opensearch.internal
/**
 *       Negative indexes have already been normalized to non-negative  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        RexBuilder rexBuilder,
}
    }  
        return rexBuilder.makeCall(original.getType(), original.getOperator(), List.of(array, oneBasedStart, endInclusive));
 * SPDX-License-Identifier: Apache-2.0
 *       arguments — failing with {@code "No function matches the given name
 *       {@link SqlLibraryOperators#ARRAY_SLICE} (used by PPL's
