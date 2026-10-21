package org.opensearch.analytics.planner.rules;
            offset = RexLiteral.intValue(lit);
                sort.getCluster(),
                    );
        RelNode newER = er.copy(er.getTraitSet(), List.of(topKSubtree));
        long shardSize = (long) Math.ceil(coordLimit * factor) + coordLimit;
import java.util.Optional;
        if (node instanceof OpenSearchSort sort && !sort.getCollation().getFieldCollations().isEmpty()) {
                stripProjects.add(rb.makeInputRef(sortOutputType.getFieldList().get(i).getType(), i));
        RexBuilder rb = sort.getCluster().getRexBuilder();
            (int) shardSize,
            );
        // If the Project contains computed expressions (literals, casts, arithmetic) rather than
import org.opensearch.analytics.planner.rel.AggregateMode;
    private static RelNode replaceInTree(RelNode root, RelNode oldNode, RelNode newNode) {
     * size cap — or every shard over-fetches {@code ceil(querySizeLimit * factor) + querySizeLimit}
            for (int i = 0; i < originalFieldCount; i++) {
                partial.getTraitSet(),
            }
            return Optional.empty();
                RexNode expr = match.intermediateProject.getProjects().get(fc.getFieldIndex());
                reduceEvalRowType,
 * Post-CBO rewriter that inserts a per-partition Sort+Limit between PARTIAL and ER
        if (node instanceof OpenSearchAggregate) return null;                        // nested stats
                partial,
            if (newChildren[i] != children.get(i)) changed = true;
        if (match == null) return Optional.empty();
        if (sortInput != partial) {
            );
            offset = 0L;
        // `head N from M` it skips M then takes N, so the merged stream needs the global top-(M+N).
        long coordLimit = offset + fetch;
                    newCollations.add(fc);
        if (!(partialNode instanceof OpenSearchAggregate partial) || partial.getMode() != AggregateMode.PARTIAL) {
            newChildren[i] = replaceInTree(children.get(i), oldNode, newNode);
 */
    /** Replaces oldNode with newNode in the tree (single occurrence). */
            RelDataType reduceEvalRowType = sort.getCluster()
    private static boolean hasEngineNativeMergeMeasure(OpenSearchAggregate agg, RelCollation collation) {
        // Anything between the Sort and the FINAL that consumes its full grouped output makes
        if (hasEngineNativeMergeMeasure(partial, adjustedCollation)) {
    }
        // PPL emits measures-first output via a column-swapping Project (e.g. Project(c=$1, key=$0)).
            partial.getViableBackends(),
                    int newIdx = projects.size();
            // Capture the first Project for sort-key remapping; pass through subsequent Projects.
        // TODO: nested stats — re-enable once TopK oversampling factor is an execution hint
            PathToFinal path = findFinalAgg(sort.getInput());
        }
        // output and TopK cannot be safely applied.
        );
            sortInput,
import org.opensearch.analytics.planner.PlannerContext;
        RelNode result = replaceInTree(root, finalAgg, newFinal);
        if (node.getInputs().size() == 1) return findFinalAgg(node.getInputs().get(0), seenProject);
            // etc.) cause rewrite() to bail, so they are safely rejected even if passed through here.
    }
                partial.getRowType(),
        RexNode shardSizeLiteral = rb.makeLiteral(
                        partial.getAggCallList().get(sortIdx - groupCount).getAggregation()
            if (found != null) return found;
     * appear and this method will skip the second one (returning null for the project field),
                int sortIdx = fc.getFieldIndex();
                }
import org.apache.calcite.rex.RexInputRef;
     * The {@code seenProject == null} guard assumes CoreRules.PROJECT_MERGE has collapsed
                if (sortIdx >= groupCount && AggregateFunction.isEngineNativeMerge(partial.getAggCallList().get(sortIdx - groupCount))) {
                .createStructType(projects.stream().map(RexNode::getType).toList(), names);
            for (RelFieldCollation fc : adjustedCollation.getFieldCollations()) {
            shardSizeLiteral,
            topKSubtree = new OpenSearchProject(
        long fetch = (sort.fetch instanceof RexLiteral lit) ? RexLiteral.intValue(lit) : 10_000L;
        // The outer Sort's indices reference the Project's output; the shard Sort must reference
     * <p>Multi-input nodes (joins, unions) terminate the walk — TopK only applies to
        if (finalAgg.getGroupSet().isEmpty()) return Optional.empty();
        // the pushdown unsafe — refuse to match at all.
            }
            List<RelFieldCollation> newCollations = new ArrayList<>();
        // Remap collation through the intermediate Project (if any) between Sort and FINAL Aggregate.
                partial.getViableBackends()
        );
                    RexNode aggNameLiteral = rb.makeLiteral(aggFunc.reduceEvalName());
    }
        double factor = resolveOversamplingFactor(context);
    private record PathToFinal(OpenSearchProject project, OpenSearchAggregate finalAgg) {
     * which safely disables the collation remapping (TopK still fires with the raw collation,
            // field maps through seenProject as a RexInputRef; computed expressions (AVG division,
    }
            sort.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER),
                    RexNode stateRef = rb.makeInputRef(partialRowType.getFieldList().get(sortIdx).getType(), sortIdx);
                stripProjects,
 *
            adjustedCollation = RelCollations.of(newCollations);
     * before matching is deliberate: PPL {@code ... | sort c | head N} arrives as a collated outer
            partial.getTraitSet(),
    }
        if (factor <= 0.0) return Optional.empty();
        return null;
                return true;
                    newCollations.add(new RelFieldCollation(newIdx, fc.getDirection(), fc.nullDirection));
        if (!changed) return root;
import org.apache.calcite.rel.type.RelDataType;
            int fieldCount = partialRowType.getFieldCount();
            adjustedCollation = RelCollations.of(remapped);
        // so the inner agg can over-fetch enough groups for outer-agg correctness.
            SortAboveFinal found = findSortAboveFinal(child);
     *
                    AggregateFunction aggFunc = AggregateFunction.fromSqlAggFunction(
import org.apache.calcite.rex.RexOver;
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
        RelNode topKSubtree = shardSort;
    private OpenSearchTopKRewriter() {}
        return root.copy(root.getTraitSet(), List.of(newChildren));
/*
        if (!(erNode instanceof OpenSearchExchangeReducer er)) return Optional.empty();
                partial.getViableBackends()
            if (path != null) return new SortAboveFinal(sort, path.project, path.finalAgg);
    private record SortAboveFinal(OpenSearchSort sort, OpenSearchProject intermediateProject, OpenSearchAggregate finalAgg) {
                projects.add(rb.makeInputRef(partialRowType.getFieldList().get(i).getType(), i));
 * for TopK aggregation queries. Runs before DAGBuilder splits stages.
            List<String> stripNames = new ArrayList<>();
        if (er.getInputs().isEmpty()) return Optional.empty();
            true
import org.apache.calcite.sql.type.SqlTypeName;
        } else {
                }
        RelCollation adjustedCollation = sort.getCollation();
                projects,
            List<RelFieldCollation> remapped = new ArrayList<>();
    private static double resolveOversamplingFactor(PlannerContext context) {
            if (idx >= groupCount && AggregateFunction.isEngineNativeMerge(agg.getAggCallList().get(idx - groupCount))) {
import org.opensearch.analytics.planner.rel.OpenSearchSort;
                shardSort,
            RelDataType sortOutputType = shardSort.getRowType();
            }
import org.opensearch.analytics.spi.AggregateFunction;
            null,
import org.apache.calcite.rel.RelNode;
        RelNode sortInput = partial;
     * correct when no reordering exists between the two).
    /**
        }
        OpenSearchSort shardSort = new OpenSearchSort(
import org.apache.calcite.rex.RexNode;
     * single-path Sort → Aggregate chains.
            int idx = fc.getFieldIndex();
            for (RelFieldCollation fc : sort.getCollation().getFieldCollations()) {
        if (root == oldNode) return newNode;
 *
        // Non-literal offsets bail to no-pushdown (PPL only emits literal offsets).
        return Optional.of(result);
            return new PathToFinal(seenProject, agg);
                stripNames.add(partial.getRowType().getFieldNames().get(i));
    public static Optional<RelNode> rewrite(RelNode root, PlannerContext context) {
            true
        if (match.intermediateProject != null) {
        RelNode[] newChildren = new RelNode[children.size()];
import org.apache.calcite.rel.RelFieldCollation;
        for (RelNode child : node.getInputs()) {
/**
import org.apache.calcite.rex.RexBuilder;
        if (node instanceof OpenSearchProject proj) {
     * Walks toward the FINAL aggregate, capturing at most one intermediate Project.
        if (shardSize > Integer.MAX_VALUE) return Optional.empty();
    }
        }
}
            sort.getCluster(),
     */
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        List<RelNode> children = root.getInputs();
        OpenSearchSort sort = match.sort;
            // subsequent plain-column Projects are transparent. rewrite() then validates each sort
 * The OpenSearch Contributors require contributions made to
            sortInput = new OpenSearchProject(
                    names.add("__reduce_eval_" + sortIdx);
                    return Optional.empty();
        if (node instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.FINAL) {
        long offset;
public final class OpenSearchTopKRewriter {
            int originalFieldCount = partial.getRowType().getFieldCount();
import org.apache.calcite.rel.RelCollations;
                .getTypeFactory()
                sort.getCluster(),
        }
     * Walks the tree to find the <em>deepest</em> collated Sort above a FINAL aggregate. Recursing
        boolean changed = false;
import org.apache.calcite.rel.RelCollation;
        }
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        RelNode newFinal = finalAgg.copy(finalAgg.getTraitSet(), List.of(newER));
        // TODO: Consider applying TopK even for single-shard topologies in a fast-followup.
     * {@code LogicalSystemLimit(fetch=querySizeLimit)} over the user's collated {@code Sort(fetch=N)},
        // the PARTIAL Aggregate's output (group-keys first, measures second).
 * compatible open source license.
            List<RexNode> projects = new ArrayList<>();
     * and the oversampling must derive the shard fetch from the inner (tighter) N — not the outer
            List<RexNode> stripProjects = new ArrayList<>();
            return findFinalAgg(proj.getInput(), seenProject == null ? proj : seenProject);
        }
    private static SortAboveFinal findSortAboveFinal(RelNode node) {
                } else {
     */
        for (int i = 0; i < children.size(); i++) {
            if (proj.getProjects().stream().anyMatch(RexOver::containsOver)) return null; // window fn
    }
    }
        return findFinalAgg(node, null);
        } else if (sort.offset instanceof RexLiteral lit) {
        if (sort.offset == null) {
            }
        }
     * rows. Preferring the deepest match honors the innermost limit.
        for (RelFieldCollation fc : collation.getFieldCollations()) {
 * <p>Pattern: Sort(collation) → [Project] → Aggregate(FINAL) → ER → Aggregate(PARTIAL) → Scan
            }
        return false;
        RelNode erNode = finalAgg.getInput();
                    projects.add(reduceCall);
        return context.getOversamplingFactor();
        }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rex.RexLiteral;
 */
            for (int i = 0; i < fieldCount; i++) {
    }
            int groupCount = partial.getGroupSet().cardinality();
        }
        OpenSearchAggregate finalAgg = match.finalAgg;
        // coordLimit is the rank the coordinator must satisfy after merging shard streams: for
        int groupCount = agg.getGroupSet().cardinality();
        return null;
import org.opensearch.analytics.planner.rel.OpenSearchProject;
        // simple column references, we bail — the sort key has no direct mapping to the aggregate
            RelDataType partialRowType = partial.getRowType();
                    remapped.add(new RelFieldCollation(ref.getIndex(), fc.getDirection(), fc.nullDirection));
                    RexNode reduceCall = rb.makeCall(AggregateFunction.REDUCE_EVAL_OP, aggNameLiteral, stateRef);
    private static PathToFinal findFinalAgg(RelNode node) {
import java.util.List;
        RelNode partialNode = er.getInputs().get(0);
    private static PathToFinal findFinalAgg(RelNode node, OpenSearchProject seenProject) {
            adjustedCollation,
        }
        }
        SortAboveFinal match = findSortAboveFinal(root);
    /**
            // Only the first Project (seenProject) is used for collation remapping in rewrite() —
                } else {
                names.add(partialRowType.getFieldNames().get(i));
                if (expr instanceof RexInputRef ref) {
            List<String> names = new ArrayList<>();
     * adjacent Projects during RBO — if that rule is ever removed, multiple Projects may
                partial.getTraitSet(),
            return Optional.empty();
