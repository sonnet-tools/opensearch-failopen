import org.apache.calcite.rex.RexNode;
    }
    private static boolean isVarbinary(RexNode node) {  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *
 * {@link org.apache.calcite.sql.SqlKind} but is <em>not</em> the canonical {@code SqlStdOperatorTable}
        }
 * recursion in {@code BackendPlanAdapter} runs operands bottom-up, so the literal is already
    IpComparisonNormalizationAdapter(ScalarFunctionAdapter delegate) {
 * VARBINARY operand). {@code EQUALS_IP} is an SQL-plugin Enumerable-only UDF with no Substrait binding  
 * {@link BinaryFunctionAdapter} has resolved the string literal into matching on-disk bytes (adapter
 * DataFusion run its byte-wise VARBINARY comparison — the same path a plain {@code =} takes — after  
 * singleton for that kind, and both operands are VARBINARY. Plain numeric/string/temporal comparisons  
 * SPDX-License-Identifier: Apache-2.0
    private static RexCall normalizeIpComparison(RexCall original, RelOptCluster cluster) {
import org.apache.calcite.rex.RexBuilder;
 * {@link ComparisonTemporalCoercionAdapter}, so it delegates every call (rewritten or not) to a
        SqlOperator nativeOp = nativeComparator(original.getOperator());
 * the delegation is a no-op for the rewritten calls.  
    @Override  
import org.apache.calcite.sql.SqlOperator;
 * Calcite comparators ({@link SqlStdOperatorTable#EQUALS} etc.) before Substrait conversion.
 *
 */  
/**
 *
            case GREATER_THAN -> SqlStdOperatorTable.GREATER_THAN;  
        this.delegate = delegate;  
import org.apache.calcite.rex.RexCall;  
    /** Rewrite an IP-comparison UDF call to its native comparator; return {@code original} otherwise. */  
import java.util.List;
package org.opensearch.be.datafusion;
            default -> null;
            case GREATER_THAN_OR_EQUAL -> SqlStdOperatorTable.GREATER_THAN_OR_EQUAL;
    }
 * @opensearch.internal
        if (!isVarbinary(original.getOperands().get(0)) || !isVarbinary(original.getOperands().get(1))) {  
        }
    private final ScalarFunctionAdapter delegate;  
            case LESS_THAN_OR_EQUAL -> SqlStdOperatorTable.LESS_THAN_OR_EQUAL;
            case NOT_EQUALS -> SqlStdOperatorTable.NOT_EQUALS;  
        return (RexCall) rexBuilder.makeCall(original.getType(), nativeOp, original.getOperands());
        return switch (operator.getKind()) {
 */  
        }
 * <p>This adapter occupies the six comparison-operator slots that would otherwise hold  
            case EQUALS -> SqlStdOperatorTable.EQUALS;
 * compatible open source license.
            return original;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 * VARBINARY, so PPL {@code where ip_field = '1.2.3.4'} resolves to the {@code EQUALS_IP} user-defined
 * <p>Why this is needed: {@code ip} (and {@code binary}) fields reach the analytics route typed as  
 * {@code Unable to convert call EQUALS_IP(binary?, binary?)}. Swapping in the native comparator lets
}  
 * wrapped temporal-coercion instance to preserve that behavior. IP operands are never temporal, so
 *
        return node.getType().getSqlTypeName() == SqlTypeName.VARBINARY;
 * analytics backend classpath). A call qualifies when its operator carries a comparison
        RexCall normalized = normalizeIpComparison(original, cluster);
            case LESS_THAN -> SqlStdOperatorTable.LESS_THAN;
    }
 * {@code PPLBuiltinOperators.EQUALS_IP} (it lives in the SQL plugin's {@code core} module, off the  
 * function rather than a plain {@code =} (the UDF's {@code (IP_UDT, IP_UDT)} signature accepts a
        if (original.getOperands().size() != 2) {
        if (nativeOp == null || original.getOperator() == nativeOp) {  
import org.apache.calcite.plan.RelOptCluster;
 * already use the standard operator, so they pass through untouched.
class IpComparisonNormalizationAdapter implements ScalarFunctionAdapter {
 * The OpenSearch Contributors require contributions made to  
    }
        // Preserve the original (BOOLEAN) result type so the plan schema is unchanged.
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.spi.FieldStorageInfo;
/*  
            return original;  
 * and no backend classpath presence, so isthmus rejects the call with
 * Normalizes the SQL plugin's PPL IP-comparison UDFs — {@code EQUALS_IP}, {@code NOT_EQUALS_IP},
    private static SqlOperator nativeComparator(SqlOperator operator) {  
 *
 * this file be licensed under the Apache-2.0 license or a
 * {@code LESS_IP}, {@code GREATER_IP}, {@code LTE_IP}, {@code GTE_IP} — back to their native  
    }  
        return delegate.adapt(normalized, fieldStorage, cluster);  
 * VARBINARY by the time this parent adapter runs).  
    /** The canonical {@code SqlStdOperatorTable} comparator for a comparison {@link org.apache.calcite.sql.SqlKind}, or null. */
        RexBuilder rexBuilder = cluster.getRexBuilder();  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
        };  
            return original;
 * <p>Detection is structural, not by operator identity: the backend cannot reference
