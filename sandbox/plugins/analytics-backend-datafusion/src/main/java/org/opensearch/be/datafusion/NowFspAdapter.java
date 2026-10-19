 *
        // niladic local now(). Any higher arity is not a shape this adapter should normalize — leave
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.apache.calcite.rex.RexCall;  
 * specifically "to avoid bug where {@code now()}, {@code now(x)} and {@code now(y)} return  
        // valid one.
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
import org.apache.calcite.rex.RexNode;
 * {@link DateTimeAdapters#LOCAL_NOW_OP}, dropping the optional {@code fsp} argument.  
package org.opensearch.be.datafusion;
class NowFspAdapter implements ScalarFunctionAdapter {
 * = millisecond precision). Maps to DataFusion's niladic {@code now()} via
        if (operands.size() > 1) {
 * {@link DateTimeAdapters.NowAdapter}; this adapter only differs by stripping the operand,
 * The OpenSearch Contributors require contributions made to  
 * {@code LOCALTIMESTAMP} synonyms), where {@code fsp} is the MySQL "fractional seconds precision":  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
 * intentionally ignored to match the SQL-plugin reference, which removed {@code fsp} support
        }
 * different values" (see {@code DateTimeFunctions.now}). So {@code now(3)} ≡ {@code now()} —
 */  
}
 */  
 * an integer 0..6 selecting how many sub-second digits the timestamp carries (e.g. {@code now(3)}
        // it untouched so the converter surfaces the real (invalid) call rather than inventing a  
 * {@code IllegalArgumentException: Unable to convert call now(i32)}. The {@code fsp} argument is
 * dropping the precision operand is the correct, reference-matching semantics.
 * this file be licensed under the Apache-2.0 license or a
        return rexBuilder.makeCall(original.getType(), DateTimeAdapters.LOCAL_NOW_OP, List.of());  
 * compatible open source license.
 * Adapter for PPL/MySQL-style {@code NOW([fsp])} (and its {@code CURRENT_TIMESTAMP} /
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * <p>The 0-arg {@code now()} form already routes correctly through
            return original;  
 * so it subsumes that case (a no-op when there are no operands).  
/**
        List<RexNode> operands = original.getOperands();
import java.util.List;
    }
        // (intentionally ignored, matching the SQL-plugin reference) and emit the substrait-mapped
        // Only now() and now(fsp) are valid PPL shapes. For both, drop the optional fsp operand  
 * {@code now(i32)} call has no Substrait mapping and fails fragment conversion with  
 *
 *  
import org.apache.calcite.plan.RelOptCluster;
    @Override  
        RexBuilder rexBuilder = cluster.getRexBuilder();
 *
import org.apache.calcite.rex.RexBuilder;
 * <p><b>Why drop the {@code fsp} arg.</b> DataFusion's {@code now()} takes no arguments, so a
/*  
