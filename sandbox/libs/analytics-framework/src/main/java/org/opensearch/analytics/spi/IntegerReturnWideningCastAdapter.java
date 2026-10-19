        // Rebuild with BIGINT return so isthmus binds DataFusion's i64 impl; operands unchanged.
 *
/*  
import org.apache.calcite.sql.type.SqlTypeName;  
        );
import org.apache.calcite.plan.RelOptCluster;
 * compatible open source license.
    }
 *   <li>The inner call's declared return type is forced to {@code BIGINT}, so it matches
 *
 *
        return cluster.getRexBuilder().makeCast(original.getType(), widenedCall);
        if (originalReturn != SqlTypeName.INTEGER && originalReturn != SqlTypeName.SMALLINT && originalReturn != SqlTypeName.TINYINT) {  
 */  
        }
import java.util.List;
            factory.createSqlType(SqlTypeName.BIGINT),  
public class IntegerReturnWideningCastAdapter implements ScalarFunctionAdapter {  
import org.apache.calcite.rex.RexNode;
 * this file be licensed under the Apache-2.0 license or a
        RelDataTypeFactory factory = cluster.getTypeFactory();
 * the cross-fragment schema check sees {@code Int32 ≠ Int64} and fails the query.
 * SPDX-License-Identifier: Apache-2.0
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 *
            return original;
package org.opensearch.analytics.spi;
 * </ul>  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexCall;
 * {@code BIGINT} and non-integer returns pass through unchanged (re-running on the inner widened call is a safe no-op).  
}  
 *       what DataFusion actually produces.</li>  
import org.apache.calcite.rel.type.RelDataType;
 *   <li>The outer cast narrows the i64 result back to i32, so every operator above this
        SqlTypeName originalReturn = original.getType().getSqlTypeName();
 * <p><b>Why:</b> Calcite types {@code array_length} as {@code INTEGER} (i32). DataFusion's
import org.apache.calcite.rel.type.RelDataTypeFactory;  
/**
        RelDataType bigintType = factory.createTypeWithNullability(
 */
 * @opensearch.internal
 * <p><b>What:</b> rewrite {@code fn(...)} → {@code CAST(fn(...) AS INTEGER)}.  
        RexNode widenedCall = cluster.getRexBuilder().makeCall(bigintType, original.getOperator(), original.getOperands());
        // Only widen integer returns narrower than BIGINT; BIGINT/non-integer returns don't exhibit the i32/i64 mismatch.
 * UDF actually returns {@code BIGINT} (i64). On 1 shard nobody cross-checks; on 2 shards  
 * <ul>
 *       call in the plan still sees the {@code INTEGER}</li>
 * <p>Applies to {@code INTEGER}/{@code SMALLINT}/{@code TINYINT} returns;
 * Reconciles the i32-vs-i64 return-type disagreement between Calcite and DataFusion for
 * functions like {@code ARRAY_LENGTH}.  
    @Override
            original.getType().isNullable()
        // Outer CAST restores the original return type so parent stages see the same schema; inner call produces i64 internally.  
