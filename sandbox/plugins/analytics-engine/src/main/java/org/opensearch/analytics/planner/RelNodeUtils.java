        if (node instanceof OpenSearchTableScan scan) {
            }
                newCluster,
    }
    /** Maximum recursion depth when walking a RelNode tree to extract indices. */  
                        "RexInputRef["
                    + ") for index extraction. Simplify the query by reducing nested joins or subqueries."  
    private static boolean collectIndices(RelNode node, Set<String> indices, int depth) {  
            return new OpenSearchShuffleExchange(  
    /**  
                uncollect.withOrdinality,
     */  
        } else if (node instanceof OpenSearchSort sort) {
    }
        node.accept(new RexShuttle() {  
                newCluster,  
     * nodes in the plan. Walks the tree up to {@link #MAX_EXTRACT_INDICES_DEPTH} levels to
        return traits;  
        }
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;  
        collectNodes(node, type, out);  
    }  
                }  
            );
            }
        RelTraitSet traits = newCluster.traitSet().replace(OpenSearchConvention.INSTANCE);
     * sees every match — e.g. a WHERE filter below an Aggregate AND a HAVING filter above it, which
        public IndexRemapShuttle(int[] remap, RelDataType newRowType) {
        }
                if (!idx.isEmpty()) {
    @SuppressWarnings("unchecked")  
            return new OpenSearchSort(
     */
    }
                int idx = ref.getIndex();
 * @opensearch.internal  
public class RelNodeUtils {
            logger.debug("{}:\n{}", label, RelOptUtil.toString(plan));
     *  
        RelTraitSet newTraits = rebuildTraits(node, newCluster, distTraitDef);
import java.util.List;
        return null;
    /**
        private final RelDataType newRowType;  
            out.addAll(findAllNodes(input, type));
        }  
    }
 * with the new cluster's planner (Volcano).
            out.add((T) node);
     * Extracts all index names referenced by {@link org.apache.calcite.rel.core.TableScan}
        return builder.build();
    }  
        }
        if (type.isInstance(node)) {
            for (String idx : Strings.splitStringByCommaToArray(tableName)) {
                    );
     * Finds the first node of the given type in the fragment's single-input chain.
     * that read better with this name (e.g. {@code FragmentConversionDriver}'s filter collection).
        for (RelNode input : node.getInputs()) {
                project.getRowType(),
            out.add((T) node);  
        LinkedHashSet<String> deps = new LinkedHashSet<>();  
            }
                newTraits,
     * </ul>  
            );
        if (node == null) return null;
                            + "] has no matching FieldStorageInfo entry "  
                    + MAX_EXTRACT_INDICES_DEPTH
        return out;
                sort.fetch,
            return new OpenSearchUncollect(
import org.apache.calcite.rex.RexNode;
                if (src.isDerived()) {
 * <p>TODO: eliminate this by having frontends create RelNodes with the Volcano  
                shuffle.getPartitionCount(),
                aggregate.getCallAnnotations(),  
                return ref;
     * flatten: {@code flatten} splices same-op children only, with no de-duplication or
    }  
            // PPL multi-source queries (source=a,b) produce a single TableScan with a
 * SPDX-License-Identifier: Apache-2.0
            // comma-delimited table name. Split so each index is evaluated independently
                newInputs.getFirst(),  
import java.util.HashSet;  
                            + " columns) — "  
                correlate.getCorrelationId(),
    }
                newInputs.get(0),
 *
 * compatible open source license.
            );
            );  
import org.apache.calcite.rex.RexInputRef;  
    /**  
     * @return array of distinct index names in encounter order  
        List<T> out = new ArrayList<>();
        } else if (node instanceof OpenSearchJoin join) {
            return new OpenSearchProject(  
    public static RelNode copyToCluster(RelNode node, RelOptCluster newCluster, OpenSearchDistributionTraitDef distTraitDef) {
     * do not merge (FILTER_MERGE does not cross the Aggregate). Order is pre-order (topmost first).
     *   <li>If the input FSI at that index is non-derived, add its field name.</li>  
     * @param plan the root of the RelNode tree
                join.getViableBackends()
        if (logger.isDebugEnabled()) {  
                correlate.getJoinType(),  
                out.add(ref.getIndex());  
        return node;
                newInputs.getFirst(),  
                    indices.add(idx);  
     * searching all inputs. Returns {@code null} if none is present.
     */
     */
            return new OpenSearchUnion(newCluster, newTraits, newInputs, union.all, union.getViableBackends());
     *       {@code dependsOnPhysicalCols} (already resolved by the upstream operator).</li>
        } else if (node instanceof OpenSearchExchangeReducer reducer) {  
        for (RelNode input : node.getInputs()) {
        });  
            org.apache.calcite.plan.RelTrait trait = node.getTraitSet().getTrait(index);
    public static <T extends RelNode> T findNode(RelNode node, Class<T> type) {
     * node is flattened after its children — making one pass fully recursive. Pure structural
     *   <li>If the input FSI at that index is derived, recurse into its
                newTraits,
        }
     * call's direct operands; wrapping it in a {@link RexShuttle} applies it bottom-up, so each  
            if (trait instanceof OpenSearchDistribution oldDist) {  
        if (depth >= MAX_EXTRACT_INDICES_DEPTH) {
            return findNode(node.getInputs().getFirst(), type);  
    }
                sort.getCollation(),  
     * @throws IllegalArgumentException if the plan exceeds the maximum depth
import org.opensearch.analytics.planner.rel.OpenSearchJoin;  
    public static Set<Integer> collectInputRefs(RexNode node) {
     * Returns {@code null} if not found.
                newCluster,
     * Throws when {@code remap[oldIdx] < 0} (referenced column was dropped). Output ref's
        if (!node.getInputs().isEmpty()) {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
                shuffle.getViableBackends()  
            }  
        });  
                newTraits,
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
                traits = traits.replace(distTraitDef.from(oldDist));
                    deps.add(src.getFieldName());
        for (RelNode input : node.getInputs()) {
import org.apache.calcite.plan.RelTraitSet;  
    /**
    }
                newInputs.get(1),  
 * The OpenSearch Contributors require contributions made to  
        private final int[] remap;
                    throw new IllegalStateException(  
     * {@link OpenSearchAggregate#getOutputFieldStorage} to populate
    /**
    public static <T extends RelNode> List<T> findAllNodes(RelNode node, Class<T> type) {
     */
 *
        public RexNode visitInputRef(RexInputRef ref) {
                    deps.addAll(src.getDependsOnPhysicalCols());  
            public RexNode visitInputRef(RexInputRef ref) {
     * Resolves a derived expression to the ordered list of physical-field names it depends on,
 * Copies an OpenSearch RelNode tree to a new cluster so all nodes register  
     */
 *
    /** Collects every {@link RexInputRef} index appearing inside a {@link RexNode} tree. */  
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        if (!collectIndices(plan, indices, 0)) {
     * (unlike {@link #findNode}, which only walks the first-input chain). Needed for multi-input
        return node.accept(new RexShuttle() {  
     * {@link FieldStorageInfo#getDependsOnPhysicalCols} per Invariant 1 of the QTF v2 algorithm.
import org.opensearch.analytics.planner.rel.OpenSearchSort;  
     */  
        } else if (node instanceof OpenSearchFilter filter) {  
        if (node instanceof TableScan scan) {
    /** Unwraps HepRelVertex to get the actual RelNode inside. */  
        } else if (node instanceof OpenSearchProject project) {
    public static void logPlan(Logger logger, String label, RelNode plan) {
     * constructor). Calcite's {@code RexUtil.flatten(RexBuilder, RexNode)} only flattens the root
     * Used by rewrites that augment a rowType with synthetic helper columns.  
        return deps;
import org.apache.calcite.rel.type.RelDataTypeField;  
        } else if (node instanceof OpenSearchShuffleExchange shuffle) {
import org.opensearch.analytics.planner.rel.OpenSearchProject;
                            + inputStorage.size()
            );
                aggregate.getFinalExtraLiteralArgs(),
        });
}
        }
     * <p>TODO: migrate existing findLeaf/findFilter usages in FragmentConversionDriver to use this.
import org.apache.calcite.plan.RelOptUtil;
                newCluster,
    }
        }
            );
                join.getJoinType(),  
            List<String> names = scan.getTable().getQualifiedName();
        return null;  
                reducer.getExchangeInfo()  
     * leaves, where each child stage corresponds to a distinct leaf and the first-input-only walk  
    /**
            return new OpenSearchJoin(  
                aggregate.getAggCallList(),  
import org.apache.calcite.rex.RexUtil;  
            );
import org.apache.calcite.rex.RexBuilder;
import org.opensearch.analytics.planner.rel.OpenSearchUncollect;
            @Override
package org.opensearch.analytics.planner;
    public static String[] extractIndices(RelNode plan) {  
            if (name != null) return name;
                uncollect.getItemAliases(),  
     * simplification.  
 *
        RelDataTypeFactory.Builder builder = typeFactory.builder();  
                            + "the upstream operator did not record storage for every output column"
                aggregate.getGroupSets(),
     * <p>Functionally equivalent to {@link #findNodes}; retained as a distinct entry point for callers
        node.accept(new RexShuttle() {
        }  
 * cluster from the start.
                            + "(input only declares "
        }
import org.opensearch.analytics.spi.FieldStorageInfo;
                newTraits,  
        }  
                correlate.getRequiredColumns(),
            return new OpenSearchValues(newCluster, newTraits, values.getRowType(), values.getTuples(), values.getViableBackends());  
 */  
        Set<Integer> out = new HashSet<>();
                newTraits,
import org.apache.logging.log4j.Logger;
import org.opensearch.analytics.planner.rel.OpenSearchCorrelate;
                return false;  
        }  
        }
        } else if (node instanceof OpenSearchAggregate aggregate) {
     */
 * this file be licensed under the Apache-2.0 license or a
     * Finds all nodes of the given type reachable from {@code node} (walks the full tree, all inputs).
     * <p>For each {@code RexInputRef} encountered (depth-first order):
            throw new IllegalArgumentException(  
            }
 */
                aggregate.getViableBackends(),
                if (idx >= inputStorage.size()) {
                } else {
     * Recursively flattens nested same-operator AND/OR calls so the condition satisfies  
     */
        }
    public static final class IndexRemapShuttle extends RexShuttle {
        } else if (node instanceof OpenSearchValues values) {
 * so Calcite's identity-based trait matching works.
import org.opensearch.analytics.planner.rel.OpenSearchValues;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
    }
                project.getViableBackends()  
            }
                newCluster,
                newInputs.getFirst(),
    /**
                newTraits,  
        if (type.isInstance(node)) {
        if (type.isInstance(node)) {
import org.opensearch.analytics.planner.rel.OpenSearchUnion;  
    public static String findTableName(RelNode node) {  
            return (T) node;  
     *  
     * deduped by first-appearance. Used by {@link OpenSearchProject#getOutputFieldStorage} and  
    public static RelDataType appendField(RelDataTypeFactory typeFactory, RelDataType base, String name, RelDataType type) {
                newCluster,
    /**
 * <p>Rebuilds distribution traits using the per-query {@link OpenSearchDistributionTraitDef}  
     * {@link RexUtil#isFlat(RexNode)} (the invariant asserted by {@link org.apache.calcite.rel.core.Filter}'s
            int newIdx = remap[ref.getIndex()];  
     * Collects every node of {@code type} reachable from {@code node}, searching ALL inputs  
        List<RelNode> newInputs = node.getInputs().stream().map(input -> copyToCluster(input, newCluster, distTraitDef)).toList();  
    public static <T extends RelNode> List<T> findNodes(RelNode node, Class<T> type) {
            @Override
                reducer.getViableBackends(),
import java.util.ArrayList;
            @Override
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
    /**
import org.apache.calcite.rel.type.RelDataTypeFactory;
                newInputs.getFirst(),
     * fragments — e.g. a {@code Join} or {@code Union} over two {@code OpenSearchStageInputScan}
    }  
            );
import org.opensearch.core.common.Strings;  
            public RexNode visitInputRef(RexInputRef ref) {  
        }
                newTraits,
    @SuppressWarnings("unchecked")  
     * Qualified name of the first {@link OpenSearchTableScan} reachable from {@code node},  
                uncollect.getViableBackends()
     * type is sourced from {@code newRowType}.
     *  
import java.util.Set;  
        if (node instanceof TableScan scan) {
            this.newRowType = newRowType;
        }  
                correlate.getViableBackends()
        } else if (node instanceof OpenSearchUncollect uncollect) {  
/**
    private RelNodeUtils() {}
                shuffle.getHashKeys(),
            return false;
                aggregate.getMode(),
    public static LinkedHashSet<String> resolvePhysicalDeps(RexNode node, List<FieldStorageInfo> inputStorage) {
            return new OpenSearchCorrelate(
                aggregate.getGroupSet(),
/*  
     * Debug-dumps a labelled plan via {@code logger}, guarding the expensive
        throw new UnsupportedOperationException("Cannot copy node type: " + node.getClass().getSimpleName());
        }
            builder.add(f.getName(), f.getType());
                newCluster,
            String tableName = names.get(names.size() - 1);  
                throw new IllegalStateException("RexInputRef references dropped column at original idx " + ref.getIndex());
                }  
                newInputs.getFirst(),
import org.apache.calcite.rel.core.TableScan;  
     * <ul>
            );
        builder.add(name, type);
    private static <T extends RelNode> void collectNodes(RelNode node, Class<T> type, List<T> out) {
     * {@link RelOptUtil#toString} behind the level check so it is skipped when debug is off.  
        for (RelNode input : node.getInputs()) {
                newInputs.getFirst(),  
            return new RexInputRef(newIdx, newRowType.getFieldList().get(newIdx).getType());
     *
                "Query plan exceeds maximum depth ("
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
        }
    private static RelTraitSet rebuildTraits(RelNode node, RelOptCluster newCluster, OpenSearchDistributionTraitDef distTraitDef) {
        return true;  
        @Override
        }
        for (int index = 0; index < node.getTraitSet().size(); index++) {
                newInputs.get(0),  
        } else if (node instanceof OpenSearchCorrelate correlate) {
            return scan.getTable().getQualifiedName().getLast();  
            String name = findTableName(input);  
    }  
import org.apache.calcite.rex.RexCall;
     * {@link RexShuttle} that rewrites every {@link RexInputRef} via {@code remap[oldIdx]}.  
     * guard against pathologically deep plans constructed from complex user queries.  
     */
            return new OpenSearchExchangeReducer(
            if (newIdx < 0) {
    public static RexNode deepFlatten(RexBuilder rexBuilder, RexNode node) {
                join.getCondition(),
                aggregate.getIntermediateFields()
import org.apache.calcite.plan.hep.HepRelVertex;
import org.apache.calcite.plan.RelOptCluster;
        List<T> out = new ArrayList<>();  
import org.apache.calcite.rel.RelNode;
                sort.getViableBackends()  
            return new OpenSearchTableScan(newCluster, newTraits, scan.getTable(), scan.getViableBackends(), scan.getOutputFieldStorage());
            return new OpenSearchAggregate(  
                newInputs.get(1),
                            + idx
        if (node instanceof HepRelVertex vertex) {
                FieldStorageInfo src = inputStorage.get(idx);
                newCluster,  
            if (!collectIndices(input, indices, depth + 1)) {
                sort.offset,
        for (RelDataTypeField f : base.getFieldList()) {
            // by the security filter — same logic as IndexResolution.  
        return out;
    }  
                project.getProjects(),
            }  
    /**
import org.opensearch.analytics.planner.rel.OpenSearchConvention;  
     * Returns a copy of {@code base} with one extra field {@code (name, type)} appended.
import org.apache.calcite.rex.RexShuttle;
    public static RelNode unwrapHep(RelNode node) {
    }
        }
            this.remap = remap;  
        } else if (node instanceof OpenSearchUnion union) {  
                return ref;
                return RexUtil.flatten(rexBuilder, super.visitCall(call));  
        return out;
     * Unlike {@link #findNode} (which returns only the topmost match via the first-input chain), this  
                // Preserve the full distribution (kind, type, keys, tableId).
                }
            return new OpenSearchFilter(newCluster, newTraits, newInputs.getFirst(), filter.getCondition(), filter.getViableBackends());
import org.apache.calcite.rel.type.RelDataType;
     * would miss every leaf but the first. Returns an empty list if none are present.
                newTraits,
        Set<String> indices = new LinkedHashSet<>();
            return vertex.getCurrentRel();  
            collectNodes(input, type, out);  
        return indices.toArray(String[]::new);  
            public RexNode visitCall(RexCall call) {
import java.util.LinkedHashSet;
    @SuppressWarnings("unchecked")
    static final int MAX_EXTRACT_INDICES_DEPTH = 15;
