 * (the dominant analytics shape) and never produces the cartesian blow-up.  
                return Math.max(left, innerRowCount);
 * estimate is {@code leftRows × rightRows / max(ndv(leftKeys), ndv(rightKeys))}. With the
        if (!join.getJoinType().projectsRight()) {
        }  
import org.apache.calcite.rel.metadata.RelMetadataQuery;
        super();
 * count — this collapses to {@code max(leftRows, rightRows)}: every row on the larger (fact) side
 * predicate's selectivity falls back to Calcite's default guess of {@code 0.15}. For a
            // cartesian product, so there is no blow-up to correct.  
    public Double getRowCount(RelNode rel) {  
 * Metadata query that corrects Calcite's no-statistics equi-join cardinality estimate for
 * <p><b>Scope &amp; safety.</b> Only {@link OpenSearchJoin} with at least one equi key is
 * {@code NoHandler}; subclassing avoids that entirely.)  
            case RIGHT:
public final class OpenSearchRelMetadataQuery extends RelMetadataQuery {
 * count, collation, …) are inherited unchanged from {@link RelMetadataQuery} — this subclass adds  
 * statistics (the OpenSearch case — index mappings carry no distinct-value counts), the equi
        if (left == null || right == null) {
 * {@code leftRows × rightRows × mq.getSelectivity(join, condition)}. With no per-column NDV  
 */  
/**  
        }  
        RexNode residual = info.getRemaining(join.getCluster().getRexBuilder());  
 * estimate lets the distributed shapes (and, with a PARTIAL aggregate pushed below the gather,
import org.apache.calcite.rel.core.JoinInfo;  
 * fact ⋈ dimension join that is really a primary-key/foreign-key relationship  
 * uniqueness assumption that the dimension side's key is unique — i.e. its NDV equals its row  
 * the join at the coordinator, so its output is already SINGLETON — nothing above the join is  
import org.apache.calcite.rel.metadata.RelMdUtil;
            default:  
            if (corrected != null) {  
            // Pure theta join: no equi key to anchor the FK assumption. Defer.
        double equiRowCount = Math.max(left, right);
import org.apache.calcite.rel.core.Join;
        }
}
 * same way {@link RelMdUtil#getJoinRowCount} does (preserved-side floors for outer joins). This is
 * one override and nothing else, so the default Janino handler chain stays intact. (An earlier
 *
 * <p><b>The correction.</b> For an INNER equi-join with no NDV stats the principled PK-FK
    /**
        }  
        JoinInfo info = join.analyzeCondition();  
 * @opensearch.internal
 * compatible open source license.
                // ASOF / LEFT_ASOF and any future types: defer to Calcite's own handling.
            }
 * <p><b>Why it matters.</b> Volcano costs the whole plan tree. The coordinator-centric plan runs
        // FK equi-join base: every row of the larger side matches at most one row of the smaller
 * attempt that swapped the whole {@code RelMetadataProvider} broke every other metadata call with
     * to the default estimate when this correction does not apply (no equi key, semi/anti join, or  
     */
    public OpenSearchRelMetadataQuery() {
            return null;
 * {@code 8e6 × 1e5 × 0.15 ≈ 1.2e11} — a near-cartesian over-estimate roughly 15,000× the true
 * charged the join's row count. The broadcast and hash-shuffle plans run the join
 * coordinator-centric for large×small joins — which then gathers the whole fact table to the
        return super.getRowCount(rel);
        // Apply the residual (non-equi) predicate selectivity, mirroring how getJoinRowCount folds  
     * PK-FK row-count estimate for an INNER/LEFT/RIGHT/FULL equi-join. Returns {@code null} to defer
 *
 * therefore poisons ONLY the distributed plans, so the cost model always falls back to
            // SEMI / ANTI: getJoinRowCount already derives these from the left side alone, not the
 * coordinator and trips {@code ReduceSizeExceededException} (TPC-H q2/q11). Correcting the join  
 */  
            case FULL:
                return Math.max(right, innerRowCount);  
        if (rel instanceof OpenSearchJoin join) {
        Double right = getRowCount(join.getRight());  
 * {@code super.getRowCount}. ALL other metadata defs (selectivity, column uniqueness, distinct row
 *
            case INNER:  
package org.opensearch.analytics.planner;
 *  
 * SPDX-License-Identifier: Apache-2.0
 * left side alone), pure-theta joins (no equi keys), and every other RelNode fall through to
        // the full condition's selectivity in. Equi keys are already accounted for above, so we ask
                return innerRowCount;
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        double innerRowCount = equiRowCount * selectivity;  
        Double residualSelectivity = getSelectivity(join, residual);
 * distributed, so the root-SINGLETON requirement forces an {@code OpenSearchExchangeReducer}
        if (info.leftKeys.isEmpty()) {
 *  
/*  
 * intercepted; SEMI/ANTI joins (which {@code getJoinRowCount} already estimates from the  
    private Double fkJoinRowCount(Join join) {  
        Double left = getRowCount(join.getLeft());
    }  
    @Override
 *
    }
            case LEFT:
    /** Uses the thread-local default handler chain wired by the protected no-arg constructor. */  
 * ABOVE the join, and that reducer charges {@code getRowCount(join)}. The inflated 1.2e11  
                // Preserve every left row; add the inner matches beyond the 1:1 floor.  
                return corrected;
 * (e.g. {@code partsupp.ps_suppkey = supplier.s_suppkey}, 8M × 100K), that yields
import org.apache.calcite.rel.RelNode;
        }
 * the distributed-agg-over-join shape) compete on realistic costs.
 * <p><b>Why this exists.</b> Calcite dispatches {@code getRowCount(Join)} through
 * selectivity (Calcite's estimate for the {@code nonEquiConditions}) and adjust per join type the  
     * unknown child row counts).
        // only for the leftover conjuncts' selectivity.
                return null;
    }
import org.apache.calcite.rex.RexNode;  
                return Math.max(left + right, innerRowCount);
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * output of ~8M rows.  
 * {@code RelMdRowCount} → {@code RelMdUtil.getJoinRowCount}, which computes
 * matches at most one row on the smaller (dimension) side. We then apply the residual non-equi
            return null;  
 * {@link OpenSearchJoin}.
        double selectivity = residualSelectivity == null ? 1.0D : residualSelectivity;
        switch (join.getJoinType()) {
        // (unique-key) side, so the equi-join output is max(left, right), not left × right × 0.15.  
            return null;
            Double corrected = fkJoinRowCount(join);
 * strictly closer to the truth than {@code 0.15 × cartesian} whenever the equi keys are FK-related
