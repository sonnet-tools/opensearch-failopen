        return bound.getCluster()
import java.util.List;
        return changed ? root.copy(root.getTraitSet(), List.of(newChildren)) : root;
    private static boolean eligibleChildBelowER(OpenSearchExchangeReducer er) {
 *  
    private static RelNode pushBelow(OpenSearchExchangeReducer er, OpenSearchSort collated, RexNode fetch) {
    }
    }
        }
                return new RewriteContext(sort, sort, sort.getInput());
        return pushed ? union.copy(union.getTraitSet(), arms, union.all) : null;  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
            } else if (sort.fetch != null && canComputeShardFetch(sort) && isPushTarget(sort.getInput())) {  
        }
        for (int i = 0; i < children.size(); i++) {
            collated.getCluster(),
 * (PPL {@code sort | head}). Walks only the single-input coordinator spine and skips the aggregate
        // directly as a push target above (see isPushTarget).
     * TODO: support non-literal (complex expression) offset/fetch by summing as a RexNode — out of scope for now.  
    private static boolean isAggregatePath(OpenSearchExchangeReducer er) {  
     * True when the shard fetch is computable: no offset, or offset and fetch are both literals to sum.
 * once that is in place.
                // Bound = this Sort if it carries a fetch; else the enclosing pure-fetch Sort, but
        OpenSearchSort shardSort = new OpenSearchSort(  
        if (node instanceof OpenSearchSort sort) {
     */  
 * compatible open source license.
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
 * <p>TODO: this is a temporary workaround. The correct approach is proper trait propagation in
     */  
        RelNode erInput = er.getInput();
                // only when this Sort has no offset of its own (which the enclosing one can't honor).  
 * (no oversampling): a row in the global window is within its own shard's top-{@code (offset+fetch)}.
        int sum = RexLiteral.intValue(bound.offset) + RexLiteral.intValue(bound.fetch);  
    }  
            }
        for (RelNode arm : union.getInputs()) {
        }  
import org.opensearch.analytics.planner.rel.OpenSearchSort;  
     *
 * {@code offset+fetch} and the offset stays on the coordinator.
        );  
 * SPDX-License-Identifier: Apache-2.0
        return isAggregatePath(er) == false && (input instanceof OpenSearchSort) == false && (input instanceof OpenSearchJoin) == false;
 * (scan case) or an {@code UNION ALL} {@link OpenSearchUnion} whose arms are each gathered by an
                RelNode below = sort.getInput();
                arms.add(arm);  
        if (m == null) return Optional.empty();
            }  
        if (below instanceof OpenSearchExchangeReducer er) {
    }
 * Post-CBO rewriter for non-aggregate TopK. Copies the bottom-most collated
            erInput,  
 *
/*  
        List<RelNode> children = root.getInputs();
                // shard caps at N instead of streaming its whole scan. Safe with no order — the
            if (collated) {
}
     * ER with the shard Sort inserted between it and its input.
            fetch,  
    private static RewriteContext find(RelNode node, OpenSearchSort fetchSortAbove) {
import org.opensearch.analytics.planner.rel.OpenSearchUnion;
    private OpenSearchSortPushdownRewriter() {}
        }
        if (below instanceof OpenSearchUnion union && union.all) {  
        RewriteContext m = find(root, null);
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
    }  
                    return new RewriteContext(sort, bound, below);
        boolean changed = false;  
     * shard fragment a bare scan that ships every row (measured: `sort … | head 10` over 10M rows went  
import org.apache.calcite.sql.type.SqlTypeName;
    }
 * The OpenSearch Contributors require contributions made to  
    private static RexNode shardFetch(OpenSearchSort bound) {
    /**
 * {@link OpenSearchSort} to just below the exchange so each shard ships only its local top-N  
        return replacement == null ? Optional.empty() : Optional.of(replaceInTree(root, m.below, replacement));
            for (RelNode arm : union.getInputs()) {
    }
 *
 * @opensearch.internal  
 * <p>Handles {@code Sort(collation,[offset,]fetch)} (SQL) and {@code Sort(fetch) → Sort(collation)}
            .makeLiteral(sum, bound.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER), true);  
                }
        RelNode input = er.getInput();  
            collated.getCollation(),
        List<RelNode> arms = new ArrayList<>(union.getInputs().size());
 */  
            null,
    private static boolean canComputeShardFetch(OpenSearchSort bound) {
            if (arm instanceof OpenSearchExchangeReducer er && eligibleChildBelowER(er)) {
                // coordinator just needs some N rows, and each shard's local N supplies them.  
 *  
     * Eligible to push a Sort below: not the aggregate path, not already pushed, and not gathering a
import org.apache.calcite.rex.RexLiteral;
        return er.getInput() instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.PARTIAL;
    /** Shard fetch = fetch when there's no offset, else offset + fetch (offset stays on the coordinator). */  
            boolean collated = sort.getCollation().getFieldCollations().isEmpty() == false;  
        return node.getInputs().size() == 1 ? find(node.getInputs().get(0), null) : null;  
        // Follow only the single-input coordinator spine. Multi-input ops (Join) are intentionally  
/**
                OpenSearchSort bound = sort.fetch != null ? sort : (sort.offset == null ? fetchSortAbove : null);
    private record RewriteContext(OpenSearchSort collated, OpenSearchSort bound, RelNode below) {  
 * Calcite's Volcano planner (collation/limit pushdown through the exchange); replace this rewrite  
            OpenSearchSort carry = (collated == false && sort.fetch != null) ? sort : null;  
        return false;
     * push target (an ER or UNION ALL), bounded by a fetch. {@code fetchSortAbove} is an  
    /**
        if (root == oldNode) return newNode;  
        OpenSearchUnion union = (OpenSearchUnion) below;
import org.apache.calcite.rex.RexNode;  
    private static RelNode replaceInTree(RelNode root, RelNode oldNode, RelNode newNode) {
     */
            }
    /**  
            newChildren[i] = replaceInTree(children.get(i), oldNode, newNode);
     * stay there. {@code DistributionEnforcementPass} otherwise treats a non-{@code DistributionAware}
                arms.add(pushBelow(er, collated, fetch));  
public final class OpenSearchSortPushdownRewriter {
     * 51ms → 5391ms with mpp on). {@link OpenSearchTopKRewriter} already marks its aggregate-path shard
     * multi-input ops (other than a matched UNION ALL) and leaves.
            return find(sort.getInput(), carry);
    public static Optional<RelNode> rewrite(RelNode root) {  
     * Join — joins are explicitly out of scope (a LIMIT cannot be safely pushed below a join).  
     * Sort the same way.
 * ER — in which case the Sort is pushed below <em>every</em> arm's ER (arm row types match the  
                pushed = true;
    }
        RelNode replacement = rewriteTarget(m.below, m.collated, shardFetch(m.bound));  
    /** Replaces oldNode with newNode in the tree (single occurrence), rebuilding ancestors. */
        RelNode[] newChildren = new RelNode[children.size()];
     */
    /** Carries the matched collated Sort, the fetch-bounding Sort, and the target node to rewrite. */
package org.opensearch.analytics.planner.rules;
    }
                if (arm instanceof OpenSearchExchangeReducer er && eligibleChildBelowER(er)) return true;
        return bound.offset == null || (bound.offset instanceof RexLiteral && bound.fetch instanceof RexLiteral);  
        if (bound.offset == null) return bound.fetch;
 * <p>Targets a collated Sort sitting directly above either an {@link OpenSearchExchangeReducer}
    }
 *
 */
            return pushBelow(er, collated, fetch);
 * sorted rows; the coordinator Sort still merges and applies the final offset/limit. Exact
            /* perPartition */ true
     * <p>The shard Sort is marked {@code perPartition} — it runs per-shard BELOW the gather, so it must  
        // not traversed — pushing a sort into one join branch is unsafe; UNION ALL is instead matched
            .getRexBuilder()
            } else {
            if (newChildren[i] != children.get(i)) changed = true;  
    /** A node we can push a Sort below: an eligible ER, or a UNION ALL with at least one eligible ER arm. */  
import org.apache.calcite.rel.RelNode;
    /**
        return er.copy(er.getTraitSet(), List.of(shardSort));
        if (below instanceof OpenSearchExchangeReducer er) return eligibleChildBelowER(er);
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;
            collated.getViableBackends(),
                if (bound != null && canComputeShardFetch(bound) && isPushTarget(below)) {  
 * union output, so the collation maps 1:1). Offset is not pushed: the shard fetch widens to
import java.util.ArrayList;  
import org.opensearch.analytics.planner.rel.AggregateMode;
            erInput.getTraitSet(),
        boolean pushed = false;  
    }
                // Bare LIMIT, no ORDER BY (`head N`): push a fetch-only Sort below the ER so each
    /** Rebuilds the target with the shard Sort pushed below the ER (scan case) or below each arm's ER (union). */
    private static boolean isPushTarget(RelNode below) {
     * Walks the single-input coordinator spine for the bottom-most collated Sort directly above a
     * Sort as a coordinator op and re-gathers its input, hoisting this Sort above the ER and leaving the
    private static RelNode rewriteTarget(RelNode below, OpenSearchSort collated, RexNode fetch) {  
 * path (ER feeding a PARTIAL aggregate, owned by {@link OpenSearchTopKRewriter}).  
        }
     * immediately-enclosing pure-fetch Sort (carries the limit for the two-node PPL shape). Stops at
