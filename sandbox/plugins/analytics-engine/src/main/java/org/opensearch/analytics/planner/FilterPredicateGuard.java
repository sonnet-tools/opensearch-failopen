        // Count up to maxCount + 1: that is all we need to decide, and it caps the work the
    public static void validate(RexNode condition, int maxCount) {  
     * ({@code AND}/{@code OR}/{@code NOT}) are not counted themselves — only their operands
                List<RexNode> operands = call.getOperands();
 * compatible open source license.
     */  
    }
            return; // guard disabled
     *
     */
    static int countLeaves(RexNode node) {
        }  
 * before a condition ever reaches this guard:  
import org.apache.calcite.rex.RexCall;
 * @opensearch.internal
 */
     */
 *       nesting depth (default 1000), so a {@code bool} tree deeper than that is rejected at parse  
            if (!(current instanceof RexCall call)) {
        }
    static int countLeavesUpTo(RexNode node, int limit) {
    /**
    /**
 * as 3 leaf predicates regardless of the tree's nesting shape.  
 * upstream parsers' job; count is the gap they leave, and count is what this guard covers.  
        Deque<RexNode> stack = new ArrayDeque<>();
import java.util.Deque;  
 * Guards against excessively complex filter predicates by counting leaf predicates
 * </ul>
 * pathologically deep tree overflows inside Calcite <em>before</em> this guard runs. Depth is the
     * <p>Uses an explicit work stack instead of recursion, so traversal depth is independent of
 * multiplies per-predicate planning and execution cost. That is the shape this guard rejects.
 * as safe as the tree is shallow; even though depth is bounded upstream today, this guard does not
 * {@code maxCount + 1} leaves and never recurses on the JVM call stack, so it cannot itself be made
     * Validates the filter condition against the configured leaf-predicate count limit.
 * rely on that for its own safety. The walk is iterative (an explicit stack, never the call stack)
     * <p>The traversal stops as soon as the limit is known to be exceeded, so it is bounded
import java.util.ArrayDeque;
     * uses the bounded {@link #countLeavesUpTo} variant to avoid doing unbounded work on input
 *   <li>PPL/SQL text queries: the SQL plugin's {@code plugins.query.max_expression_depth}
     * Counts leaf predicates in {@code node}, stopping early once the running total reaches  
/*  
 *
    }  
 * <p>A "leaf predicate" is any {@link RexCall} that is not a boolean connective
     * <p>Traversal is iterative (explicit stack) rather than recursive, so it is safe against
        }
                    stack.push(operand);
 * The OpenSearch Contributors require contributions made to  
     * arbitrarily deep condition trees. This method counts the whole tree; {@link #validate}  
public final class FilterPredicateGuard {  
     * {@code limit}. Returns a value in {@code [0, limit]}: a return value equal to {@code limit}
     *
            }
            if (total >= limit) {
 *
        int leafCount = countLeavesUpTo(condition, maxCount + 1);  
        }  
     * @param condition the filter's RexNode condition tree  
        int total = 0;  
 * ({@code AND}, {@code OR}, {@code NOT}). A flat {@code a=1 OR b=2 OR c=3} counts
            }
                    + " predicates, exceeding the maximum allowed ["
 * ({@code a=1 OR b=2 OR ... OR z=26}) is shallow — it sails through the depth bounds above — yet  
 * in a {@link RexNode} condition tree.
                    + maxCount  
            SqlKind kind = call.getKind();  
        stack.push(node);
package org.opensearch.analytics.planner;
 * SPDX-License-Identifier: Apache-2.0
 *       with HTTP 400.</li>
     * by {@code maxCount} in both work and stack depth — a deeply nested condition cannot make  
 * and short-circuits the moment the leaf count exceeds the limit: it never visits more than  
                return limit;  
                continue;
                // the call stack, so a degenerate chain of a million nested ANDs is just a  
     * contribute.  
            RexNode current = stack.pop();
        return countLeavesUpTo(node, Integer.MAX_VALUE);
     * Returns the number of leaf predicates in the given RexNode tree. Boolean connectives
 *
            throw new IllegalArgumentException(
 *       time before any query builder — or RexNode — is constructed.</li>
     * it is going to reject anyway.
                continue;  
 *
                    + maxCount
     * the guard itself overflow the stack.
import org.apache.calcite.rex.RexNode;
     *  
import java.util.List;
 *  
 * recurses the whole AND/OR/NOT subtree while building/normalizing the condition, so a
     * cost is bounded by {@code limit} regardless of the tree's size or nesting.  
 */  
                // Literal or input ref — not a predicate by itself.  
                }
        if (leafCount > maxCount) {
                for (RexNode operand : operands) {  
     *
 *       (default 1000) bounds AST-visitor recursion at parse time and rejects deeper expressions  
    private FilterPredicateGuard() {}
                // million iterations of this loop, not a million stack frames.
import org.apache.calcite.sql.SqlKind;  
/**  
 * <p>Boolean nesting <b>depth</b> is intentionally out of scope here — it is bounded upstream,
 * <p><b>The count traversal itself is bounded.</b> A guard that walks the tree recursively is only  
            );
                    + "]. Simplify the query by reducing the number of filter conditions."
        while (!stack.isEmpty()) {  
                "Filter condition contains more than "  
}
            if (kind == SqlKind.AND || kind == SqlKind.OR || kind == SqlKind.NOT) {
        if (limit <= 0) {  
 * <ul>
        if (maxCount <= 0) {
 * to overflow by the complexity it is measuring.
    }
     * means "at least {@code limit}" (the walk short-circuited and the true total may be higher).
 * this file be licensed under the Apache-2.0 license or a
 *   <li>DSL {@code _search} queries: the XContent (JSON/CBOR/YAML/SMILE) parser enforces a maximum
            }
     * the JVM call-stack depth and cannot overflow it. Combined with the early exit, the guard's
                // Connective: descend into operands. They only contribute leaves, not depth on
        return total;  
            total++;  
     * Throws {@link IllegalArgumentException} (HTTP 400) if the limit is exceeded.  
        // guard does on a hostile condition tree at one leaf beyond the limit.
            // Leaf predicate (comparison, function call, etc.).
     * @param maxCount  maximum leaf predicates allowed (0 = unlimited)
            return 0;
 * <p>Predicate <b>count</b> is that gap: a flat fan-out of many OR-ed conditions
 *  
                // Already at or beyond what the caller cares about — no need to keep walking.
 * A guard here could not defend depth even if it wanted to: Calcite's own {@code RexUtil.isFlat}  
    /**  
