    /** Replaces oldNode with newNode in the tree (single occurrence), rebuilding ancestors. */
    private static RelNode pushBelow(OpenSearchExchangeReducer er, OpenSearchSort collated, RexNode fetch) {
 *
        }
     * Eligible to push a Sort below: not the aggregate path, not already pushed, and not gathering a
        if (m == null) return Optional.empty();
public final class OpenSearchSortPushdownRewriter {
        }
import org.opensearch.analytics.planner.rel.OpenSearchSort;
            OpenSearchSort carry = (collated == false && sort.fetch != null) ? sort : null;
        return node.getInputs().size() == 1 ? find(node.getInputs().get(0), null) : null;
    /**
 *
                arms.add(pushBelow(er, collated, fetch));
        for (RelNode arm : union.getInputs()) {
        return bound.getCluster()
        return false;
    private static RelNode replaceInTree(RelNode root, RelNode oldNode, RelNode newNode) {
}
    /** A node we can push a Sort below: an eligible ER, or a UNION ALL with at least one eligible ER arm. */
        RelNode[] newChildren = new RelNode[children.size()];
/**
        return pushed ? union.copy(union.getTraitSet(), arms, union.all) : null;
                pushed = true;
 * <p>Handles {@code Sort(collation,[offset,]fetch)} (SQL) and {@code Sort(fetch) → Sort(collation)}
    }
 *
                RelNode below = sort.getInput();
        }
    private static boolean isAggregatePath(OpenSearchExchangeReducer er) {
 * (scan case) or an {@code UNION ALL} {@link OpenSearchUnion} whose arms are each gathered by an
        RelNode erInput = er.getInput();
    /**
        boolean changed = false;
     */
    private static boolean canComputeShardFetch(OpenSearchSort bound) {
 * path (ER feeding a PARTIAL aggregate, owned by {@link OpenSearchTopKRewriter}).
            null,
        RelNode replacement = rewriteTarget(m.below, m.collated, shardFetch(m.bound));
    }
        int sum = RexLiteral.intValue(bound.offset) + RexLiteral.intValue(bound.fetch);
                OpenSearchSort bound = sort.fetch != null ? sort : (sort.offset == null ? fetchSortAbove : null);
            if (collated) {
 * @opensearch.internal
 * ER — in which case the Sort is pushed below <em>every</em> arm's ER (arm row types match the
        return replacement == null ? Optional.empty() : Optional.of(replaceInTree(root, m.below, replacement));
 * (no oversampling): a row in the global window is within its own shard's top-{@code (offset+fetch)}.
                if (arm instanceof OpenSearchExchangeReducer er && eligibleChildBelowER(er)) return true;
import org.apache.calcite.rel.RelNode;
            } else {
    }
                // only when this Sort has no offset of its own (which the enclosing one can't honor).
            return find(sort.getInput(), carry);
 * this file be licensed under the Apache-2.0 license or a
            collated.getCollation(),
import org.apache.calcite.rex.RexLiteral;
    private static RewriteContext find(RelNode node, OpenSearchSort fetchSortAbove) {
 * compatible open source license.
            newChildren[i] = replaceInTree(children.get(i), oldNode, newNode);
            boolean collated = sort.getCollation().getFieldCollations().isEmpty() == false;
        // Follow only the single-input coordinator spine. Multi-input ops (Join) are intentionally
                // shard caps at N instead of streaming its whole scan. Safe with no order — the
import java.util.List;
 * <p>TODO: this is a temporary workaround. The correct approach is proper trait propagation in
        }
     * True when the shard fetch is computable: no offset, or offset and fetch are both literals to sum.
            if (arm instanceof OpenSearchExchangeReducer er && eligibleChildBelowER(er)) {
     *
 * union output, so the collation maps 1:1). Offset is not pushed: the shard fetch widens to
        boolean pushed = false;
                return new RewriteContext(sort, sort, sort.getInput());
                arms.add(arm);
package org.opensearch.analytics.planner.rules;
     * TODO: support non-literal (complex expression) offset/fetch by summing as a RexNode — out of scope for now.
 * (PPL {@code sort | head}). Walks only the single-input coordinator spine and skips the aggregate
            erInput.getTraitSet(),
        // directly as a push target above (see isPushTarget).
    private static RexNode shardFetch(OpenSearchSort bound) {
     */
     */
            } else if (sort.fetch != null && canComputeShardFetch(sort) && isPushTarget(sort.getInput())) {
        if (below instanceof OpenSearchUnion union && union.all) {
     * <p>The shard Sort is marked {@code perPartition} — it runs per-shard BELOW the gather, so it must
    private static boolean isPushTarget(RelNode below) {
    private record RewriteContext(OpenSearchSort collated, OpenSearchSort bound, RelNode below) {
    }
                if (bound != null && canComputeShardFetch(bound) && isPushTarget(below)) {
    }
        return bound.offset == null || (bound.offset instanceof RexLiteral && bound.fetch instanceof RexLiteral);
     * Sort as a coordinator op and re-gathers its input, hoisting this Sort above the ER and leaving the
        return er.copy(er.getTraitSet(), List.of(shardSort));
                // coordinator just needs some N rows, and each shard's local N supplies them.
     * multi-input ops (other than a matched UNION ALL) and leaves.
 *
    }
                    return new RewriteContext(sort, bound, below);
            .getRexBuilder()
import java.util.Optional;
        return changed ? root.copy(root.getTraitSet(), List.of(newChildren)) : root;
 * Post-CBO rewriter for non-aggregate TopK. Copies the bottom-most collated
 * sorted rows; the coordinator Sort still merges and applies the final offset/limit. Exact
            for (RelNode arm : union.getInputs()) {
     * Join — joins are explicitly out of scope (a LIMIT cannot be safely pushed below a join).
     * immediately-enclosing pure-fetch Sort (carries the limit for the two-node PPL shape). Stops at
    }
    /**
     * 51ms → 5391ms with mpp on). {@link OpenSearchTopKRewriter} already marks its aggregate-path shard
        return er.getInput() instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.PARTIAL;
     * Walks the single-input coordinator spine for the bottom-most collated Sort directly above a
        // not traversed — pushing a sort into one join branch is unsafe; UNION ALL is instead matched
            erInput,
            collated.getCluster(),
                // Bound = this Sort if it carries a fetch; else the enclosing pure-fetch Sort, but
        }
 */
            fetch,
    /**
        );
            }
        OpenSearchUnion union = (OpenSearchUnion) below;
        OpenSearchSort shardSort = new OpenSearchSort(
    public static Optional<RelNode> rewrite(RelNode root) {
        List<RelNode> children = root.getInputs();
            collated.getViableBackends(),
    /** Rebuilds the target with the shard Sort pushed below the ER (scan case) or below each arm's ER (union). */
                // Bare LIMIT, no ORDER BY (`head N`): push a fetch-only Sort below the ER so each
    }
        if (below instanceof OpenSearchExchangeReducer er) {
        return isAggregatePath(er) == false && (input instanceof OpenSearchSort) == false && (input instanceof OpenSearchJoin) == false;
import org.opensearch.analytics.planner.rel.OpenSearchUnion;
     * ER with the shard Sort inserted between it and its input.
 */
     */
    }
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
 *
            return pushBelow(er, collated, fetch);
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
    private static boolean eligibleChildBelowER(OpenSearchExchangeReducer er) {
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
 * {@code offset+fetch} and the offset stays on the coordinator.
    /** Shard fetch = fetch when there's no offset, else offset + fetch (offset stays on the coordinator). */
        if (root == oldNode) return newNode;
            if (newChildren[i] != children.get(i)) changed = true;
 * Calcite's Volcano planner (collation/limit pushdown through the exchange); replace this rewrite
            }
    private OpenSearchSortPushdownRewriter() {}
            }
                }
     * stay there. {@code DistributionEnforcementPass} otherwise treats a non-{@code DistributionAware}
 * {@link OpenSearchSort} to just below the exchange so each shard ships only its local top-N
    }
        if (below instanceof OpenSearchExchangeReducer er) return eligibleChildBelowER(er);
            /* perPartition */ true
     * Sort the same way.
     * push target (an ER or UNION ALL), bounded by a fetch. {@code fetchSortAbove} is an
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
    }
        if (node instanceof OpenSearchSort sort) {
    /** Carries the matched collated Sort, the fetch-bounding Sort, and the target node to rewrite. */
 * once that is in place.
/*
        List<RelNode> arms = new ArrayList<>(union.getInputs().size());
        if (bound.offset == null) return bound.fetch;
import org.apache.calcite.sql.type.SqlTypeName;
 * <p>Targets a collated Sort sitting directly above either an {@link OpenSearchExchangeReducer}
        for (int i = 0; i < children.size(); i++) {
import org.opensearch.analytics.planner.rel.AggregateMode;
import org.apache.calcite.rex.RexNode;
            .makeLiteral(sum, bound.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER), true);
 * The OpenSearch Contributors require contributions made to
        RewriteContext m = find(root, null);
        RelNode input = er.getInput();
     * shard fragment a bare scan that ships every row (measured: `sort … | head 10` over 10M rows went
    private static RelNode rewriteTarget(RelNode below, OpenSearchSort collated, RexNode fetch) {
