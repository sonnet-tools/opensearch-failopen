        return rexBuilder.makeCast(original.getType(), asTimestamp, true);
        }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        }
    @Override  
/**
    }  
/*  
 * SPDX-License-Identifier: Apache-2.0
        return name == SqlTypeName.TIMESTAMP || name == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE || name == SqlTypeName.DATE;
import org.apache.calcite.rel.type.RelDataType;
        RexNode diffDouble = rexBuilder.makeCast(fp64, diffSeconds, true);  
import org.apache.calcite.rex.RexCall;
}  
            RelDataType bigint = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT);
        }
        }
            return original;
            return original;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 *
        // that exact shape to lower `bin <ts> bins=N` into integer-seconds math.
        // BIGINT seconds back through from_unixtime so Project.isValid type-matches.
        SqlTypeName name = type.getSqlTypeName();  
import org.apache.calcite.rex.RexNode;
import org.opensearch.analytics.spi.FieldStorageInfo;  
    private static boolean isDateOrTimestamp(RelDataType type) {
 * Rewrites PPL {@code t1 - t2} on TIMESTAMP / DATE operands as  
import org.apache.calcite.plan.RelOptCluster;
package org.opensearch.be.datafusion;
 * compatible open source license.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode asTimestamp = rexBuilder.makeCall(RustUdfDateTimeAdapters.LOCAL_FROM_UNIXTIME_OP, diffDouble);
        // as DATE, so returning BIGINT directly prevents ArrowValues from formatting
        RelDataType fp64 = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.DOUBLE);
 * catalog has no {@code subtract(precision_timestamp, ...)} binding. Numeric operands
 * {@code to_unixtime(t1) - to_unixtime(t2)} (seconds), since Substrait's default
        // DATE-DATE → integer day-count (legacy convention). Calcite infers the return type  
import java.util.List;  
        if (left.getType().getSqlTypeName() == SqlTypeName.DATE && right.getType().getSqlTypeName() == SqlTypeName.DATE) {  
        // epoch-day 5 as the date "1970-01-06".
        RexNode rightSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, right);  
    }
            RexNode secsPerDay = rexBuilder.makeLiteral(java.math.BigDecimal.valueOf(86_400L), bigint);
        RexNode leftSeconds = rexBuilder.makeCall(UnixTimestampAdapter.LOCAL_TO_UNIXTIME_OP, left);
 */  
class MinusAdapter implements ScalarFunctionAdapter {
        RexNode diffSeconds = rexBuilder.makeCall(SqlStdOperatorTable.MINUS, leftSeconds, rightSeconds);
        RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.rex.RexBuilder;  
            return original;
 * pass through unchanged.  
        RexNode left = original.getOperands().get(0);
        if (original.getOperator() != SqlStdOperatorTable.MINUS || original.getOperands().size() != 2) {
            return rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, diffSeconds, secsPerDay);  
        RexNode right = original.getOperands().get(1);  
import org.apache.calcite.rex.RexOver;  
import org.apache.calcite.sql.type.SqlTypeName;
 */  
 * @opensearch.internal
        if (!isDateOrTimestamp(left.getType()) || !isDateOrTimestamp(right.getType())) {
        // PPL's MINUS(DATETIME, DATETIME) infers TIMESTAMP at the call site; lift the  
        if (left instanceof RexOver && right instanceof RexOver) {  
        // Leave MINUS(MAX OVER (), MIN OVER ()) for WidthBucketAdapter — it pattern-matches
