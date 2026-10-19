        }
    private static RexNode unwrapAnnotations(RexNode node) {
import org.apache.calcite.plan.RelOptCluster;
        RexNode binsLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(bins));
        if (!(lhs instanceof RexOver maxOver) || !isAggKind(maxOver, SqlKind.MAX)) {
 * {@code bucket_start = origin + floor((ts − origin) / stride) × stride}.  
        }
        return adaptNumeric(original, cluster);
        "width_bucket",
            return Optional.empty();
        RexNode tsMinusMin = rexBuilder.makeCall(bigint, SqlStdOperatorTable.MINUS, List.of(tsSeconds, minSeconds));
            return adaptTimeBased(original, cluster);
import org.apache.calcite.rex.RexCall;
            return Optional.empty();  
        }
        RexNode tsSeconds = rexBuilder.makeCall(bigint, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, List.of(tsCol));
        OptionalInt binsOpt = extractBinsLiteral(original);
}  
import org.apache.calcite.rex.RexOver;
        }
        RexNode strideSeconds = rexBuilder.makeCall(bigint, SqlStdOperatorTable.DIVIDE, List.of(rangeSeconds, binsLit));
    private static boolean isTimeBased(SqlTypeName tn) {
    /** Holder for the pattern-matched {@code MAX OVER ()} / {@code MIN OVER ()} pair. */  
        if (call.getOperands().size() > 1
        RexNode minSeconds = rexBuilder.makeCall(bigint, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, List.of(pair.minOver()));  
        }  
        return cluster.getRexBuilder().makeCall(original.getType(), LOCAL_WIDTH_BUCKET_OP, original.getOperands());
 */  
        }
import org.apache.calcite.rex.RexBuilder;
import java.math.BigDecimal;
    private static RexNode adaptNumeric(RexCall original, RelOptCluster cluster) {
        if (minusCall.getOperands().size() != 2) {  
        RexNode lhs = unwrapAnnotations(minusCall.getOperands().get(0));  
/*  
        return Optional.of(new MaxMinOverPair(maxOver, minOver));  
        }
import org.opensearch.analytics.spi.FieldStorageInfo;
    }
 */  
    /** Binds to the {@code width_bucket} Rust UDF via {@code ADDITIONAL_SCALAR_SIGS}. */  
package org.opensearch.be.datafusion;
    private static RexNode adaptTimeBased(RexCall original, RelOptCluster cluster) {
import org.apache.calcite.sql.SqlFunction;
        // bucket_start = floor((ts - min) / stride) * stride + min — integer division floors.
        return OptionalInt.empty();
        OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC),  
    }
 * epoch-seconds space, anchored at {@code MIN(ts) OVER ()}:
import org.apache.calcite.sql.SqlOperator;
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();
import java.util.List;  
        Optional<MaxMinOverPair> rangePair = decomposeMinusOverRange(original);  
        if (original.getOperands().isEmpty()) {  
import org.apache.calcite.sql.SqlAggFunction;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
        }
        return rexBuilder.makeCast(original.getType(), bucketStartTimestamp, true);
import org.apache.calcite.sql.type.SqlTypeName;  
    /** Match operand 2 against {@code MINUS(MAX OVER (), MIN OVER ())}. */
        ReturnTypes.VARCHAR_2000_NULLABLE,
        if (!(rhs instanceof RexOver minOver) || !isAggKind(minOver, SqlKind.MIN)) {
        RexNode bucketIndex = rexBuilder.makeCall(bigint, SqlStdOperatorTable.DIVIDE, List.of(tsMinusMin, strideSeconds));  
        RexNode bucketStartTimestamp = rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, List.of(bucketStartDouble));  
        RexNode rhs = unwrapAnnotations(minusCall.getOperands().get(1));
    }
 * subtract two {@code precision_timestamp}s. Rewrite to bucket arithmetic in
/**
 * this file be licensed under the Apache-2.0 license or a
        RexNode tsCol = original.getOperands().get(0);
        return current;  
    }
        RelDataType fp64 = typeFactory.createSqlType(SqlTypeName.DOUBLE);
 *
 *  
            return Optional.empty();
    }  
        // Convert all three timestamps to i64 epoch seconds.
            return Optional.empty();
 * <p>Timestamp values: the UDF doesn't accept timestamps and substrait can't  
import org.apache.calcite.sql.SqlFunctionCategory;
    private static Optional<MaxMinOverPair> decomposeMinusOverRange(RexCall call) {
        if (rangePair.isPresent() && binsOpt.isPresent() && binsOpt.getAsInt() > 0) {
        if (maxOver.getOperands().size() != 1 || minOver.getOperands().size() != 1) {  
        if (call.getOperands().size() < 3) {  
        RexNode bucketOffset = rexBuilder.makeCall(bigint, SqlStdOperatorTable.MULTIPLY, List.of(bucketIndex, strideSeconds));
        null,
    }
            && call.getOperands().get(1) instanceof RexLiteral binsLit  
    static final SqlOperator LOCAL_WIDTH_BUCKET_OP = new SqlFunction(
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    }
        RexNode bucketStartDouble = rexBuilder.makeCast(fp64, bucketStartSeconds, true);
        RexNode rangeSeconds = rexBuilder.makeCall(bigint, SqlStdOperatorTable.MINUS, List.of(maxSeconds, minSeconds));
 * @opensearch.internal
    private static boolean isAggKind(RexOver over, SqlKind kind) {  
            return Optional.empty();  
            return original;
    private static OptionalInt extractBinsLiteral(RexCall call) {
        RexBuilder rexBuilder = cluster.getRexBuilder();  
        RexNode op2 = unwrapAnnotations(call.getOperands().get(2));
        RexNode maxSeconds = rexBuilder.makeCall(bigint, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, List.of(pair.maxOver()));
import org.apache.calcite.sql.SqlKind;  
        // analytics-engine wraps operands in OperatorAnnotation before the adapter runs;  
 * Adapter for PPL's {@code WIDTH_BUCKET}, the lowering target for {@code bin <field> bins=N}.
            current = annotation.unwrap();
    private record MaxMinOverPair(RexOver maxOver, RexOver minOver) {
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            && binsLit.getValue() instanceof Number num) {
        RexNode bucketStartSeconds = rexBuilder.makeCall(bigint, SqlStdOperatorTable.PLUS, List.of(bucketOffset, minSeconds));
import org.apache.calcite.rel.type.RelDataType;
        }
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
        if (!(op2 instanceof RexCall minusCall) || minusCall.getKind() != SqlKind.MINUS) {  
import java.util.OptionalInt;
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);  
        // stride = (max - min) / N  
    }
    }  
import java.util.Optional;
        SqlAggFunction agg = over.getAggOperator();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 *
    private static RexNode adaptTimeBasedDataAware(RexCall original, RelOptCluster cluster, MaxMinOverPair pair, int bins) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    );
        return original;
        if (isTimeBased(firstOperandType)) {
 * SPDX-License-Identifier: Apache-2.0
            return Optional.empty();
 * <p>Numeric values: rename to the {@code width_bucket} Rust UDF.
        // peel so the pattern match sees the underlying call shape.
class WidthBucketAdapter implements ScalarFunctionAdapter {
    @Override
        // Conservative: require single-operand window aggs (lowered shape is OVER ()).
import org.apache.calcite.sql.type.OperandTypes;  
 *
        RexNode current = node;
        return tn == SqlTypeName.TIMESTAMP || tn == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE || tn == SqlTypeName.DATE;  
import org.apache.calcite.rex.RexNode;
    }  
        // from_unixtime takes fp64; outer cast restores the original return type.
        return agg != null && agg.getKind() == kind;
import org.apache.calcite.sql.type.SqlTypeFamily;
    /** Peel {@link OperatorAnnotation} wrappers so pattern-matching sees the underlying call. */  
import org.apache.calcite.rex.RexLiteral;  
import org.apache.calcite.sql.type.ReturnTypes;
            return adaptTimeBasedDataAware(original, cluster, rangePair.get(), binsOpt.getAsInt());  
        while (current instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {  
            return OptionalInt.of(num.intValue());
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }  
        }
        SqlKind.OTHER_FUNCTION,  
        SqlTypeName firstOperandType = original.getOperands().get(0).getType().getSqlTypeName();  
