import org.apache.calcite.rex.RexLiteral;
        // Conservative: require single-operand window aggs (lowered shape is OVER ()).
    /** Binds to the {@code width_bucket} Rust UDF via {@code ADDITIONAL_SCALAR_SIGS}. */
package org.opensearch.be.datafusion;
        RexNode bucketIndex = rexBuilder.makeCall(bigint, SqlStdOperatorTable.DIVIDE, List.of(tsMinusMin, strideSeconds));
import org.apache.calcite.sql.SqlKind;
 * <p>Timestamp values: the UDF doesn't accept timestamps and substrait can't
        if (!(lhs instanceof RexOver maxOver) || !isAggKind(maxOver, SqlKind.MAX)) {
            return original;
            return Optional.empty();
    private record MaxMinOverPair(RexOver maxOver, RexOver minOver) {
        if (minusCall.getOperands().size() != 2) {
 * The OpenSearch Contributors require contributions made to
            return Optional.empty();
import org.apache.calcite.sql.type.OperandTypes;
        // from_unixtime takes fp64; outer cast restores the original return type.
import org.apache.calcite.rel.type.RelDataType;
    }
    private static Optional<MaxMinOverPair> decomposeMinusOverRange(RexCall call) {
 * SPDX-License-Identifier: Apache-2.0
 * <p>Numeric values: rename to the {@code width_bucket} Rust UDF.
import java.util.List;
        RexNode minSeconds = rexBuilder.makeCall(bigint, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, List.of(pair.minOver()));
        if (!(op2 instanceof RexCall minusCall) || minusCall.getKind() != SqlKind.MINUS) {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        }
        }
import org.apache.calcite.rex.RexBuilder;
        if (rangePair.isPresent() && binsOpt.isPresent() && binsOpt.getAsInt() > 0) {
import org.apache.calcite.sql.type.ReturnTypes;
import org.apache.calcite.sql.SqlFunction;
        }
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();
    private static RexNode adaptTimeBasedDataAware(RexCall original, RelOptCluster cluster, MaxMinOverPair pair, int bins) {
        if (call.getOperands().size() < 3) {
import org.apache.calcite.rel.type.RelDataTypeFactory;
        RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.plan.RelOptCluster;
        return current;
import org.apache.calcite.sql.SqlFunctionCategory;
        return cluster.getRexBuilder().makeCall(original.getType(), LOCAL_WIDTH_BUCKET_OP, original.getOperands());
            return Optional.empty();
    private static RexNode unwrapAnnotations(RexNode node) {
        ReturnTypes.VARCHAR_2000_NULLABLE,
        RexNode op2 = unwrapAnnotations(call.getOperands().get(2));
        return adaptNumeric(original, cluster);
import org.opensearch.analytics.spi.FieldStorageInfo;
 * epoch-seconds space, anchored at {@code MIN(ts) OVER ()}:
import org.apache.calcite.rex.RexOver;
    private static boolean isAggKind(RexOver over, SqlKind kind) {
        return rexBuilder.makeCast(original.getType(), bucketStartTimestamp, true);
        RexNode tsSeconds = rexBuilder.makeCall(bigint, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, List.of(tsCol));
 * subtract two {@code precision_timestamp}s. Rewrite to bucket arithmetic in
    private static RexNode adaptNumeric(RexCall original, RelOptCluster cluster) {
        // analytics-engine wraps operands in OperatorAnnotation before the adapter runs;
    }
        }
/**
 * compatible open source license.
 *
            && binsLit.getValue() instanceof Number num) {
        }
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
/*
    }
        if (!(rhs instanceof RexOver minOver) || !isAggKind(minOver, SqlKind.MIN)) {
        return original;
        if (isTimeBased(firstOperandType)) {
            return adaptTimeBasedDataAware(original, cluster, rangePair.get(), binsOpt.getAsInt());
    }
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rex.RexNode;
}
        RexNode rhs = unwrapAnnotations(minusCall.getOperands().get(1));
        RexNode lhs = unwrapAnnotations(minusCall.getOperands().get(0));
        if (call.getOperands().size() > 1
import org.apache.calcite.sql.type.SqlTypeFamily;
    }
        // peel so the pattern match sees the underlying call shape.
import java.util.Optional;
            current = annotation.unwrap();
import org.apache.calcite.sql.SqlAggFunction;
        }
    /** Peel {@link OperatorAnnotation} wrappers so pattern-matching sees the underlying call. */
        while (current instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
        null,
        RexNode rangeSeconds = rexBuilder.makeCall(bigint, SqlStdOperatorTable.MINUS, List.of(maxSeconds, minSeconds));
        // bucket_start = floor((ts - min) / stride) * stride + min — integer division floors.
 */
            return Optional.empty();
import java.math.BigDecimal;
 * {@code bucket_start = origin + floor((ts − origin) / stride) × stride}.
    @Override
        // stride = (max - min) / N
            return OptionalInt.of(num.intValue());
        RelDataType bigint = typeFactory.createSqlType(SqlTypeName.BIGINT);
        RelDataType fp64 = typeFactory.createSqlType(SqlTypeName.DOUBLE);
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    private static OptionalInt extractBinsLiteral(RexCall call) {
 * @opensearch.internal
        if (maxOver.getOperands().size() != 1 || minOver.getOperands().size() != 1) {
        SqlTypeName firstOperandType = original.getOperands().get(0).getType().getSqlTypeName();
class WidthBucketAdapter implements ScalarFunctionAdapter {
            return adaptTimeBased(original, cluster);
        RexNode tsCol = original.getOperands().get(0);
        SqlAggFunction agg = over.getAggOperator();
    }
        }
        RexNode bucketStartSeconds = rexBuilder.makeCall(bigint, SqlStdOperatorTable.PLUS, List.of(bucketOffset, minSeconds));
    );
            return Optional.empty();
        return tn == SqlTypeName.TIMESTAMP || tn == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE || tn == SqlTypeName.DATE;
            return Optional.empty();
        RexNode tsMinusMin = rexBuilder.makeCall(bigint, SqlStdOperatorTable.MINUS, List.of(tsSeconds, minSeconds));
        RexNode bucketStartDouble = rexBuilder.makeCast(fp64, bucketStartSeconds, true);
 * this file be licensed under the Apache-2.0 license or a
        RexNode maxSeconds = rexBuilder.makeCall(bigint, UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, List.of(pair.maxOver()));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.SqlOperator;
        "width_bucket",
            && call.getOperands().get(1) instanceof RexLiteral binsLit
        return Optional.of(new MaxMinOverPair(maxOver, minOver));
        // Convert all three timestamps to i64 epoch seconds.
import java.util.OptionalInt;
        if (original.getOperands().isEmpty()) {
        return agg != null && agg.getKind() == kind;
 *
    }
        OptionalInt binsOpt = extractBinsLiteral(original);
        RexNode bucketStartTimestamp = rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, List.of(bucketStartDouble));
        SqlKind.OTHER_FUNCTION,
    private static RexNode adaptTimeBased(RexCall original, RelOptCluster cluster) {
        RexNode binsLit = rexBuilder.makeBigintLiteral(BigDecimal.valueOf(bins));
        }
    private static boolean isTimeBased(SqlTypeName tn) {
 * Adapter for PPL's {@code WIDTH_BUCKET}, the lowering target for {@code bin <field> bins=N}.
        RexNode current = node;
 *
        OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC),
        RexNode bucketOffset = rexBuilder.makeCall(bigint, SqlStdOperatorTable.MULTIPLY, List.of(bucketIndex, strideSeconds));
 *
 */
        RexNode strideSeconds = rexBuilder.makeCall(bigint, SqlStdOperatorTable.DIVIDE, List.of(rangeSeconds, binsLit));
        }
    static final SqlOperator LOCAL_WIDTH_BUCKET_OP = new SqlFunction(
    }
    }
        }
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
    /** Match operand 2 against {@code MINUS(MAX OVER (), MIN OVER ())}. */
    }
        return OptionalInt.empty();
        Optional<MaxMinOverPair> rangePair = decomposeMinusOverRange(original);
    /** Holder for the pattern-matched {@code MAX OVER ()} / {@code MIN OVER ()} pair. */
        }
