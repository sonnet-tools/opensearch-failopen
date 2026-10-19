            // Capture the first Project for sort-key remapping; pass through subsequent Projects.
        if (sortInput != partial) {
import org.opensearch.analytics.planner.rel.AggregateMode;
                RexNode expr = match.intermediateProject.getProjects().get(fc.getFieldIndex());
        for (int i = 0; i < children.size(); i++) {  
import org.apache.calcite.rex.RexBuilder;  
        boolean changed = false;
            List<RexNode> projects = new ArrayList<>();
        // the pushdown unsafe — refuse to match at all.
        if (factor <= 0.0) return Optional.empty();
    private record PathToFinal(OpenSearchProject project, OpenSearchAggregate finalAgg) {  
            for (int i = 0; i < fieldCount; i++) {  
            if (path != null) return new SortAboveFinal(sort, path.project, path.finalAgg);
    private OpenSearchTopKRewriter() {}
        if (match == null) return Optional.empty();  
     * single-path Sort → Aggregate chains.
        if (node.getInputs().size() == 1) return findFinalAgg(node.getInputs().get(0), seenProject);  
 * this file be licensed under the Apache-2.0 license or a
                reduceEvalRowType,
            return Optional.empty();
            sortInput = new OpenSearchProject(  
        }
                projects.add(rb.makeInputRef(partialRowType.getFieldList().get(i).getType(), i));
        );
            RelDataType partialRowType = partial.getRowType();  
    }
        if (!changed) return root;
        if (shardSize > Integer.MAX_VALUE) return Optional.empty();  
        // simple column references, we bail — the sort key has no direct mapping to the aggregate
                    int newIdx = projects.size();  
                names.add(partialRowType.getFieldNames().get(i));
    }  
     * rows. Preferring the deepest match honors the innermost limit.
                    projects.add(reduceCall);
            sort.getCluster(),  
 *
 * for TopK aggregation queries. Runs before DAGBuilder splits stages.
        if (node instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.FINAL) {
 */  
        } else if (sort.offset instanceof RexLiteral lit) {
                partial.getViableBackends()  
            shardSizeLiteral,
                stripNames.add(partial.getRowType().getFieldNames().get(i));  
import org.opensearch.analytics.planner.rel.OpenSearchSort;
    }
            );  
            return new PathToFinal(seenProject, agg);
        RelNode sortInput = partial;  
                partial.getRowType(),
                int sortIdx = fc.getFieldIndex();
        }
            topKSubtree = new OpenSearchProject(
import org.apache.calcite.rel.RelCollations;
     * Walks toward the FINAL aggregate, capturing at most one intermediate Project.
                    names.add("__reduce_eval_" + sortIdx);
package org.opensearch.analytics.planner.rules;
            offset = RexLiteral.intValue(lit);  
    }
        if (match.intermediateProject != null) {
        int groupCount = agg.getGroupSet().cardinality();
                sort.getCluster(),  
     * Walks the tree to find the <em>deepest</em> collated Sort above a FINAL aggregate. Recursing
        // `head N from M` it skips M then takes N, so the merged stream needs the global top-(M+N).
            sort.getCluster().getTypeFactory().createSqlType(SqlTypeName.INTEGER),
            }
import org.apache.calcite.rex.RexNode;  
    private static double resolveOversamplingFactor(PlannerContext context) {
                    newCollations.add(fc);
            adjustedCollation = RelCollations.of(newCollations);
                } else {
            SortAboveFinal found = findSortAboveFinal(child);
        );
        // TODO: Consider applying TopK even for single-shard topologies in a fast-followup.  
        RelNode result = replaceInTree(root, finalAgg, newFinal);  
        return Optional.of(result);
        return findFinalAgg(node, null);
 * The OpenSearch Contributors require contributions made to  
                projects,
import org.apache.calcite.rex.RexOver;
            offset = 0L;
        long shardSize = (long) Math.ceil(coordLimit * factor) + coordLimit;
            int originalFieldCount = partial.getRowType().getFieldCount();
    /**
    /**
        return context.getOversamplingFactor();  
        if (hasEngineNativeMergeMeasure(partial, adjustedCollation)) {
            for (int i = 0; i < originalFieldCount; i++) {
            // Only the first Project (seenProject) is used for collation remapping in rewrite() —  
        for (RelFieldCollation fc : collation.getFieldCollations()) {  
import org.apache.calcite.rel.RelNode;
        // PPL emits measures-first output via a column-swapping Project (e.g. Project(c=$1, key=$0)).
        OpenSearchSort shardSort = new OpenSearchSort(
    }
 */
            null,
        long fetch = (sort.fetch instanceof RexLiteral lit) ? RexLiteral.intValue(lit) : 10_000L;
            }
                stripProjects.add(rb.makeInputRef(sortOutputType.getFieldList().get(i).getType(), i));
}
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            RelDataType reduceEvalRowType = sort.getCluster()  
public final class OpenSearchTopKRewriter {  
                partial.getTraitSet(),
    }
        return root.copy(root.getTraitSet(), List.of(newChildren));
            int idx = fc.getFieldIndex();
            List<String> names = new ArrayList<>();
        long coordLimit = offset + fetch;
    private static SortAboveFinal findSortAboveFinal(RelNode node) {  
     * adjacent Projects during RBO — if that rule is ever removed, multiple Projects may
    private static boolean hasEngineNativeMergeMeasure(OpenSearchAggregate agg, RelCollation collation) {
            );
                    return Optional.empty();  
    }
        }  
        return null;
            if (proj.getProjects().stream().anyMatch(RexOver::containsOver)) return null; // window fn
            RelDataType sortOutputType = shardSort.getRowType();  
import org.opensearch.analytics.planner.rel.OpenSearchProject;
/*  
            }
                    RexNode stateRef = rb.makeInputRef(partialRowType.getFieldList().get(sortIdx).getType(), sortIdx);
        RelNode newFinal = finalAgg.copy(finalAgg.getTraitSet(), List.of(newER));
     */
        }
    private static RelNode replaceInTree(RelNode root, RelNode oldNode, RelNode newNode) {
            List<RexNode> stripProjects = new ArrayList<>();
     * before matching is deliberate: PPL {@code ... | sort c | head N} arrives as a collated outer  
                    RexNode aggNameLiteral = rb.makeLiteral(aggFunc.reduceEvalName());  
        if (node instanceof OpenSearchSort sort && !sort.getCollation().getFieldCollations().isEmpty()) {
import org.apache.calcite.rel.RelFieldCollation;  
        }
            newChildren[i] = replaceInTree(children.get(i), oldNode, newNode);
        RelNode partialNode = er.getInputs().get(0);
            }
import java.util.List;  
            // etc.) cause rewrite() to bail, so they are safely rejected even if passed through here.  
            }  
    /** Replaces oldNode with newNode in the tree (single occurrence). */  
            return Optional.empty();
        RexBuilder rb = sort.getCluster().getRexBuilder();
        RelNode topKSubtree = shardSort;
    }
                .getTypeFactory()
            partial.getTraitSet(),
            true
        }  
            if (newChildren[i] != children.get(i)) changed = true;
     * appear and this method will skip the second one (returning null for the project field),
        } else {
import org.opensearch.analytics.planner.PlannerContext;  
    private static PathToFinal findFinalAgg(RelNode node, OpenSearchProject seenProject) {  
import org.apache.calcite.rel.RelCollation;
        double factor = resolveOversamplingFactor(context);
                sort.getCluster(),
            // subsequent plain-column Projects are transparent. rewrite() then validates each sort
     * <p>Multi-input nodes (joins, unions) terminate the walk — TopK only applies to  
        // output and TopK cannot be safely applied.  
                .createStructType(projects.stream().map(RexNode::getType).toList(), names);
                }
        List<RelNode> children = root.getInputs();  
            List<RelFieldCollation> newCollations = new ArrayList<>();
     * {@code LogicalSystemLimit(fetch=querySizeLimit)} over the user's collated {@code Sort(fetch=N)},
        }
                partial,  
        OpenSearchAggregate finalAgg = match.finalAgg;  
                if (sortIdx >= groupCount && AggregateFunction.isEngineNativeMerge(partial.getAggCallList().get(sortIdx - groupCount))) {
            adjustedCollation,  
                    RexNode reduceCall = rb.makeCall(AggregateFunction.REDUCE_EVAL_OP, aggNameLiteral, stateRef);
        // Remap collation through the intermediate Project (if any) between Sort and FINAL Aggregate.  
import org.apache.calcite.rex.RexInputRef;
 * Post-CBO rewriter that inserts a per-partition Sort+Limit between PARTIAL and ER
            if (idx >= groupCount && AggregateFunction.isEngineNativeMerge(agg.getAggCallList().get(idx - groupCount))) {
     * correct when no reordering exists between the two).
 * <p>Pattern: Sort(collation) → [Project] → Aggregate(FINAL) → ER → Aggregate(PARTIAL) → Scan
            sortInput,
    }
            partial.getViableBackends(),  
 * SPDX-License-Identifier: Apache-2.0
    private static PathToFinal findFinalAgg(RelNode node) {  
        RelNode[] newChildren = new RelNode[children.size()];
            int fieldCount = partialRowType.getFieldCount();
                    );
    public static Optional<RelNode> rewrite(RelNode root, PlannerContext context) {
        if (root == oldNode) return newNode;
        return false;  
        // so the inner agg can over-fetch enough groups for outer-agg correctness.
            PathToFinal path = findFinalAgg(sort.getInput());  
        // The outer Sort's indices reference the Project's output; the shard Sort must reference
        RelNode erNode = finalAgg.getInput();
        return null;  
     * size cap — or every shard over-fetches {@code ceil(querySizeLimit * factor) + querySizeLimit}  
                partial.getTraitSet(),
        RexNode shardSizeLiteral = rb.makeLiteral(  
        if (finalAgg.getGroupSet().isEmpty()) return Optional.empty();
                } else {
                    newCollations.add(new RelFieldCollation(newIdx, fc.getDirection(), fc.nullDirection));  
        }
        // TODO: nested stats — re-enable once TopK oversampling factor is an execution hint  
        // If the Project contains computed expressions (literals, casts, arithmetic) rather than
        if (node instanceof OpenSearchAggregate) return null;                        // nested stats
            adjustedCollation = RelCollations.of(remapped);  
                stripProjects,  
                    AggregateFunction aggFunc = AggregateFunction.fromSqlAggFunction(  
                    remapped.add(new RelFieldCollation(ref.getIndex(), fc.getDirection(), fc.nullDirection));
            // field maps through seenProject as a RexInputRef; computed expressions (AVG division,
        }  
                        partial.getAggCallList().get(sortIdx - groupCount).getAggregation()
        if (er.getInputs().isEmpty()) return Optional.empty();
        SortAboveFinal match = findSortAboveFinal(root);
import org.apache.calcite.rel.type.RelDataType;
                partial.getViableBackends()
    private record SortAboveFinal(OpenSearchSort sort, OpenSearchProject intermediateProject, OpenSearchAggregate finalAgg) {  
import java.util.ArrayList;
        if (!(partialNode instanceof OpenSearchAggregate partial) || partial.getMode() != AggregateMode.PARTIAL) {  
     */
        if (sort.offset == null) {  
import java.util.Optional;
            int groupCount = partial.getGroupSet().cardinality();
            (int) shardSize,
        }
        OpenSearchSort sort = match.sort;
        // Anything between the Sort and the FINAL that consumes its full grouped output makes
        if (node instanceof OpenSearchProject proj) {  
/**  
                }  
 * compatible open source license.
            List<String> stripNames = new ArrayList<>();  
            List<RelFieldCollation> remapped = new ArrayList<>();  
            for (RelFieldCollation fc : adjustedCollation.getFieldCollations()) {  
                shardSort,
                return true;  
import org.opensearch.analytics.spi.AggregateFunction;  
import org.apache.calcite.sql.type.SqlTypeName;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;  
        for (RelNode child : node.getInputs()) {
     * which safely disables the collation remapping (TopK still fires with the raw collation,  
     *
        }  
        RelCollation adjustedCollation = sort.getCollation();
        // coordLimit is the rank the coordinator must satisfy after merging shard streams: for
        if (!(erNode instanceof OpenSearchExchangeReducer er)) return Optional.empty();
                if (expr instanceof RexInputRef ref) {  
        RelNode newER = er.copy(er.getTraitSet(), List.of(topKSubtree));  
            if (found != null) return found;  
     * and the oversampling must derive the shard fetch from the inner (tighter) N — not the outer
            for (RelFieldCollation fc : sort.getCollation().getFieldCollations()) {
 *  
        long offset;
        // Non-literal offsets bail to no-pushdown (PPL only emits literal offsets).  
            true  
import org.apache.calcite.rex.RexLiteral;
     * The {@code seenProject == null} guard assumes CoreRules.PROJECT_MERGE has collapsed  
        // the PARTIAL Aggregate's output (group-keys first, measures second).  
            return findFinalAgg(proj.getInput(), seenProject == null ? proj : seenProject);
