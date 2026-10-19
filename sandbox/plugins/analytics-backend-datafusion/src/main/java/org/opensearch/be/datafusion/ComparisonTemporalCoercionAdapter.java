        SqlTypeName name = type.getSqlTypeName();
        // TIME vs DATE/TIMESTAMP — rewrite the TIME side to today-anchored TIMESTAMP
        if (isDateOrTimestamp(stripped)) {  
    @Override
            return isDateOrTimestamp(stripAnnotation(call.getOperands().get(0)))
        coerced.add(newLeft);
        SqlTypeName name = node.getType().getSqlTypeName();
            return original;  
    }
            || name == SqlTypeName.TIME
        boolean leftChar = isCharacter(left);  
        RexNode rewritten = DatePartAdapters.coerceCharacterOperandToTimestamp(timeInner, cluster);
            || name == SqlTypeName.DATE
    }
    // locally.
    private static RexNode stripAnnotation(RexNode node) {  
            if (isTime(inner) && (call.getOperator() == DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP || call.isA(SqlKind.CAST))) {  
import java.util.ArrayList;
 * Coerces a comparison operand to {@code TIMESTAMP} when isthmus has no Substrait sig for the call:
        return name == SqlTypeName.TIMESTAMP
 * TIME-vs-{DATE,TIMESTAMP} (Calcite wraps TIME with {@code to_timestamp(precision_time<P>)} which
    }  
        if (unwrapToTime(other) != null || !isDateOrTimestampOrWrapped(other)) {
            return true;
        }
        return rebuild(original, newLeft, newRight, cluster);
        RexNode newLeft = coerceTimeIfApplicable(left, right, cluster);  
        }  
        if (stripped instanceof RexCall call && call.getOperands().size() == 1) {
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import java.util.List;
import org.apache.calcite.rex.RexCall;
        }
        }
    private static RexNode coerceTimeIfApplicable(RexNode self, RexNode other, RelOptCluster cluster) {  
            return rebuild(original, newLeft, newRight, cluster);  
    private static boolean isTemporal(RexNode node) {
 */  
            return original;  
    /** True for a raw DATE/TIMESTAMP, or a {@code to_timestamp(date)}/{@code CAST(date AS TIMESTAMP)} wrapper. */  
    private static RexNode unwrapToTime(RexNode node) {
    private static boolean isCharacter(RexNode node) {  
        RexNode stripped = stripAnnotation(node);
        }
 */
    private static boolean isDateOrTimestamp(RexNode node) {  
        RexBuilder rexBuilder = cluster.getRexBuilder();
            || name == SqlTypeName.TIME_WITH_LOCAL_TIME_ZONE;  
    }
            RexNode inner = stripAnnotation(call.getOperands().get(0));
        } else {
        if (self instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {  
        if (isTime(stripped)) {
        }
import org.apache.calcite.sql.type.SqlTypeFamily;
    }
package org.opensearch.be.datafusion;
        return rexBuilder.makeCall(original.getType(), original.getOperator(), coerced);  
        RexNode right = operands.get(1);  
        }
import org.apache.calcite.sql.type.SqlTypeName;
 * char-vs-temporal (decorrelation folded the PPL {@code TIMESTAMP} UDF to a bare string), or  
    /** TIME (or wrapped TIME) compared with DATE/TIMESTAMP — rewrite to today-anchored TIMESTAMP, preserving any outer annotation. */
            newRight = DatePartAdapters.coerceCharacterOperandToTimestamp(right, cluster);
        RexNode left = operands.get(0);
            newLeft = DatePartAdapters.coerceCharacterOperandToTimestamp(left, cluster);
        if (timeInner == null) {
/*  
class ComparisonTemporalCoercionAdapter implements ScalarFunctionAdapter {  
            node = annotation.unwrap();
            || name == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE  
        RexNode stripped = stripAnnotation(node);  
import org.apache.calcite.rel.type.RelDataType;
        if (leftChar && rightTemporal) {
        while (node instanceof OperatorAnnotation annotation && annotation.unwrap() != null) {
import org.apache.calcite.sql.SqlKind;  
 * has no yaml impl). Both shapes route through {@link DatePartAdapters#coerceCharacterOperandToTimestamp}.
    // TODO: annotation stripping should be centralised in FragmentConversionDriver; revisit alongside the other adapters that strip
    /** Returns the TIME-typed inner if node is raw TIME or a single-operand to_timestamp/CAST around TIME; else null. Strips OperatorAnnotation at every level — recursion threads annotations through intermediate nodes. */
            }
 * @opensearch.internal
    }
        return false;
}
        List<RexNode> coerced = new ArrayList<>(2);  
                && (call.getOperator() == DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP || call.isA(SqlKind.CAST));
 *
        return SqlTypeFamily.CHARACTER.contains(node.getType());
    }
        coerced.add(newRight);
    }
        List<RexNode> operands = original.getOperands();
        boolean rightTemporal = isTemporal(right);  
        boolean rightChar = isCharacter(right);
import org.apache.calcite.rex.RexBuilder;  
    }  
import org.apache.calcite.rex.RexNode;
        RexNode newRight = coerceTimeIfApplicable(right, left, cluster);
        RelDataType type = node.getType();  
        return rewritten;  
    }
            return self;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.plan.RelOptCluster;
    private static RexNode rebuild(RexCall original, RexNode newLeft, RexNode newRight, RelOptCluster cluster) {
        RexNode timeInner = unwrapToTime(self);
        SqlTypeName name = node.getType().getSqlTypeName();
        } else if (rightChar && leftTemporal) {  
        }  
 * compatible open source license.
import org.opensearch.analytics.planner.rel.OperatorAnnotation;  
        return name == SqlTypeName.DATE || name == SqlTypeName.TIMESTAMP || name == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE;
        if (operands.size() != 2) {
 * SPDX-License-Identifier: Apache-2.0
        boolean leftTemporal = isTemporal(left);
        }  
        return node;
        if (newLeft != left || newRight != right) {
import org.opensearch.analytics.spi.FieldStorageInfo;
        if (newLeft == left && newRight == right) {
            return original;  
            return self;  
 *  
        if (stripped instanceof RexCall call && call.getOperands().size() == 1) {  
        }
    private static boolean isTime(RexNode node) {
        return null;
            return annotation.withAdaptedOriginal(rewritten);
            return stripped;
                return inner;
        }  
        return name == SqlTypeName.TIME || name == SqlTypeName.TIME_WITH_LOCAL_TIME_ZONE;  
    private static boolean isDateOrTimestampOrWrapped(RexNode node) {
        }
/**
