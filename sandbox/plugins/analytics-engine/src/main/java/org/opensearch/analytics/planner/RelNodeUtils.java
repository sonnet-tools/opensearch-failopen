                newInputs.getFirst(),
            return findNode(node.getInputs().getFirst(), type);
    }
        if (type.isInstance(node)) {
        return node;
        }
            return new OpenSearchExchangeReducer(
     * </ul>
        if (node instanceof OpenSearchTableScan scan) {
        LinkedHashSet<String> deps = new LinkedHashSet<>();
 *
        node.accept(new RexShuttle() {
 * so Calcite's identity-based trait matching works.
    /**
                join.getCondition(),
            List<String> names = scan.getTable().getQualifiedName();
    }
                aggregate.getMode(),
 * compatible open source license.
     * Throws when {@code remap[oldIdx] < 0} (referenced column was dropped). Output ref's
    @SuppressWarnings("unchecked")
     * do not merge (FILTER_MERGE does not cross the Aggregate). Order is pre-order (topmost first).
                newTraits,
                }
    }
        return null;
            return new OpenSearchTableScan(newCluster, newTraits, scan.getTable(), scan.getViableBackends(), scan.getOutputFieldStorage());
import org.opensearch.analytics.planner.rel.OpenSearchUncollect;
                newCluster,
            }
            return (T) node;
import org.opensearch.core.common.Strings;
                correlate.getRequiredColumns(),
 *
                newTraits,
     */
        return true;
    @SuppressWarnings("unchecked")
     */
                newInputs.getFirst(),
                newInputs.get(1),
     * {@link OpenSearchAggregate#getOutputFieldStorage} to populate
    /** Maximum recursion depth when walking a RelNode tree to extract indices. */
    public static String findTableName(RelNode node) {
                correlate.getJoinType(),
    public static <T extends RelNode> List<T> findAllNodes(RelNode node, Class<T> type) {
                "Query plan exceeds maximum depth ("
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.plan.RelOptCluster;
                if (src.isDerived()) {
            }
/*
        } else if (node instanceof OpenSearchFilter filter) {
                shuffle.getHashKeys(),
            out.addAll(findAllNodes(input, type));
    private static RelTraitSet rebuildTraits(RelNode node, RelOptCluster newCluster, OpenSearchDistributionTraitDef distTraitDef) {
        }
                sort.offset,
     * <p>Functionally equivalent to {@link #findNodes}; retained as a distinct entry point for callers
import java.util.List;
 * with the new cluster's planner (Volcano).
    /**
        if (node instanceof HepRelVertex vertex) {
    }
 * <p>TODO: eliminate this by having frontends create RelNodes with the Volcano
                correlate.getViableBackends()
            @Override
    }
            return new OpenSearchCorrelate(
     */
                reducer.getExchangeInfo()
 * this file be licensed under the Apache-2.0 license or a
     * {@link FieldStorageInfo#getDependsOnPhysicalCols} per Invariant 1 of the QTF v2 algorithm.
            return new OpenSearchValues(newCluster, newTraits, values.getRowType(), values.getTuples(), values.getViableBackends());
     * leaves, where each child stage corresponds to a distinct leaf and the first-input-only walk
     * fragments — e.g. a {@code Join} or {@code Union} over two {@code OpenSearchStageInputScan}
 *
                newInputs.getFirst(),
            return new OpenSearchSort(
    /** Unwraps HepRelVertex to get the actual RelNode inside. */
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        Set<Integer> out = new HashSet<>();
            return new OpenSearchUnion(newCluster, newTraits, newInputs, union.all, union.getViableBackends());
            public RexNode visitInputRef(RexInputRef ref) {
            return false;
    /**
                return false;
     * Qualified name of the first {@link OpenSearchTableScan} reachable from {@code node},
        return deps;
                            + inputStorage.size()
        return traits;
    @SuppressWarnings("unchecked")
     *
                sort.getViableBackends()
        } else if (node instanceof OpenSearchValues values) {
                newTraits,
        RelDataTypeFactory.Builder builder = typeFactory.builder();
        } else if (node instanceof OpenSearchAggregate aggregate) {
     *
                project.getProjects(),
        @Override
            this.newRowType = newRowType;
            int newIdx = remap[ref.getIndex()];
                            + idx
                out.add(ref.getIndex());
                if (idx >= inputStorage.size()) {
            return scan.getTable().getQualifiedName().getLast();
     * <p>For each {@code RexInputRef} encountered (depth-first order):
     * Used by rewrites that augment a rowType with synthetic helper columns.
     *   <li>If the input FSI at that index is derived, recurse into its
        throw new UnsupportedOperationException("Cannot copy node type: " + node.getClass().getSimpleName());
     *       {@code dependsOnPhysicalCols} (already resolved by the upstream operator).</li>
        });
                uncollect.getItemAliases(),
            );
                newInputs.getFirst(),
                newCluster,
        RelTraitSet traits = newCluster.traitSet().replace(OpenSearchConvention.INSTANCE);
        for (RelNode input : node.getInputs()) {
        private final RelDataType newRowType;
                aggregate.getGroupSets(),
        }
     */
    private static boolean collectIndices(RelNode node, Set<String> indices, int depth) {
        for (int index = 0; index < node.getTraitSet().size(); index++) {
            );
            );
    /**
        if (depth >= MAX_EXTRACT_INDICES_DEPTH) {
        }
 * cluster from the start.
            out.add((T) node);
 */
     * simplification.
        public IndexRemapShuttle(int[] remap, RelDataType newRowType) {
            }
        collectNodes(node, type, out);
            return vertex.getCurrentRel();
 * @opensearch.internal
     * @return array of distinct index names in encounter order
    private RelNodeUtils() {}
    public static RelNode unwrapHep(RelNode node) {
        }
            );
        } else if (node instanceof OpenSearchCorrelate correlate) {
        for (RelNode input : node.getInputs()) {
     * would miss every leaf but the first. Returns an empty list if none are present.
                    + ") for index extraction. Simplify the query by reducing nested joins or subqueries."
    }
     * (unlike {@link #findNode}, which only walks the first-input chain). Needed for multi-input
        if (node instanceof TableScan scan) {
    }
import java.util.Set;
    }
                    indices.add(idx);
            // by the security filter — same logic as IndexResolution.
import org.apache.calcite.rex.RexUtil;
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        return out;
     * flatten: {@code flatten} splices same-op children only, with no de-duplication or
            );
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
            }
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
import org.opensearch.analytics.planner.rel.OpenSearchUnion;
        }
                throw new IllegalStateException("RexInputRef references dropped column at original idx " + ref.getIndex());
    /**
import org.opensearch.analytics.planner.rel.OpenSearchConvention;
                newTraits,
        return null;
        } else if (node instanceof OpenSearchUncollect uncollect) {
        public RexNode visitInputRef(RexInputRef ref) {
     * {@link RexUtil#isFlat(RexNode)} (the invariant asserted by {@link org.apache.calcite.rel.core.Filter}'s
        }
                            + "the upstream operator did not record storage for every output column"
                newTraits,
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
            for (String idx : Strings.splitStringByCommaToArray(tableName)) {
        return builder.build();
            String tableName = names.get(names.size() - 1);
     */
        if (type.isInstance(node)) {
                reducer.getViableBackends(),
            String name = findTableName(input);
                project.getRowType(),
            this.remap = remap;
import org.apache.calcite.plan.RelTraitSet;
import org.opensearch.analytics.planner.rel.OpenSearchValues;
                            + "] has no matching FieldStorageInfo entry "
        } else if (node instanceof OpenSearchProject project) {
import org.apache.calcite.plan.RelOptUtil;
                aggregate.getViableBackends(),
                newTraits,
                uncollect.withOrdinality,
        return indices.toArray(String[]::new);
import org.apache.calcite.rex.RexInputRef;
    }
import org.apache.calcite.plan.hep.HepRelVertex;
    private static <T extends RelNode> void collectNodes(RelNode node, Class<T> type, List<T> out) {
    public static Set<Integer> collectInputRefs(RexNode node) {
    /**
     * Returns {@code null} if not found.
    }
                    deps.addAll(src.getDependsOnPhysicalCols());
            out.add((T) node);
        }
     * type is sourced from {@code newRowType}.
            }
     *
     * deduped by first-appearance. Used by {@link OpenSearchProject#getOutputFieldStorage} and
        if (node instanceof TableScan scan) {
                // Preserve the full distribution (kind, type, keys, tableId).
        return out;
    /**
                    deps.add(src.getFieldName());
            public RexNode visitInputRef(RexInputRef ref) {
        builder.add(name, type);
     * node is flattened after its children — making one pass fully recursive. Pure structural
import java.util.ArrayList;
     * that read better with this name (e.g. {@code FragmentConversionDriver}'s filter collection).
            if (trait instanceof OpenSearchDistribution oldDist) {
    public static RexNode deepFlatten(RexBuilder rexBuilder, RexNode node) {
     *
                return ref;
     * Finds all nodes of the given type reachable from {@code node} (walks the full tree, all inputs).
                join.getJoinType(),
            }
                newInputs.get(1),
                sort.getCollation(),
                FieldStorageInfo src = inputStorage.get(idx);
import org.apache.calcite.rel.type.RelDataTypeFactory;
    public static String[] extractIndices(RelNode plan) {
                newCluster,
    }
            return new OpenSearchAggregate(
        } else if (node instanceof OpenSearchExchangeReducer reducer) {
}
            return new OpenSearchFilter(newCluster, newTraits, newInputs.getFirst(), filter.getCondition(), filter.getViableBackends());
    public static <T extends RelNode> List<T> findNodes(RelNode node, Class<T> type) {
                shuffle.getViableBackends()
            collectNodes(input, type, out);
     * @throws IllegalArgumentException if the plan exceeds the maximum depth
            // PPL multi-source queries (source=a,b) produce a single TableScan with a
            @Override
        List<RelNode> newInputs = node.getInputs().stream().map(input -> copyToCluster(input, newCluster, distTraitDef)).toList();
                return ref;
/**
                aggregate.getAggCallList(),
    static final int MAX_EXTRACT_INDICES_DEPTH = 15;
    }
import org.opensearch.analytics.planner.rel.OpenSearchProject;
                newInputs.getFirst(),
                newCluster,
 */
                newCluster,
     */
                }
     * {@link RexShuttle} that rewrites every {@link RexInputRef} via {@code remap[oldIdx]}.
 * <p>Rebuilds distribution traits using the per-query {@link OpenSearchDistributionTraitDef}
        return out;
        }
import org.apache.calcite.rex.RexShuttle;
                project.getViableBackends()
     * {@link RelOptUtil#toString} behind the level check so it is skipped when debug is off.
import org.apache.calcite.rel.type.RelDataType;
     *   <li>If the input FSI at that index is non-derived, add its field name.</li>
            // comma-delimited table name. Split so each index is evaluated independently
            if (name != null) return name;
                newCluster,
                aggregate.getGroupSet(),
     * constructor). Calcite's {@code RexUtil.flatten(RexBuilder, RexNode)} only flattens the root
        for (RelNode input : node.getInputs()) {
public class RelNodeUtils {
            return new OpenSearchProject(
            org.apache.calcite.plan.RelTrait trait = node.getTraitSet().getTrait(index);
            throw new IllegalArgumentException(
                } else {
                newInputs.getFirst(),
    public static LinkedHashSet<String> resolvePhysicalDeps(RexNode node, List<FieldStorageInfo> inputStorage) {
     * Collects every node of {@code type} reachable from {@code node}, searching ALL inputs
        }
     */
        for (RelNode input : node.getInputs()) {
            );
                correlate.getCorrelationId(),
import org.apache.calcite.rex.RexBuilder;
    }
                newCluster,
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("{}:\n{}", label, RelOptUtil.toString(plan));
 *
        Set<String> indices = new LinkedHashSet<>();
import org.apache.logging.log4j.Logger;
 * Copies an OpenSearch RelNode tree to a new cluster so all nodes register
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
    public static RelNode copyToCluster(RelNode node, RelOptCluster newCluster, OpenSearchDistributionTraitDef distTraitDef) {
                newInputs.get(0),
        }
    /**
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
                join.getViableBackends()
            if (!collectIndices(input, indices, depth + 1)) {
        node.accept(new RexShuttle() {
    public static <T extends RelNode> T findNode(RelNode node, Class<T> type) {
     * Unlike {@link #findNode} (which returns only the topmost match via the first-input chain), this
     */
import org.apache.calcite.rex.RexNode;
        if (node == null) return null;
                    throw new IllegalStateException(
        }
            return new OpenSearchShuffleExchange(
            );
package org.opensearch.analytics.planner;
    public static RelDataType appendField(RelDataTypeFactory typeFactory, RelDataType base, String name, RelDataType type) {
        private final int[] remap;
            @Override
            return new OpenSearchJoin(
    }
    /**
     */
     * Returns a copy of {@code base} with one extra field {@code (name, type)} appended.
                sort.fetch,
import org.apache.calcite.rel.core.TableScan;
                int idx = ref.getIndex();
     * call's direct operands; wrapping it in a {@link RexShuttle} applies it bottom-up, so each
    /** Collects every {@link RexInputRef} index appearing inside a {@link RexNode} tree. */
            );
     * Finds the first node of the given type in the fragment's single-input chain.
        List<T> out = new ArrayList<>();
import org.apache.calcite.rel.RelNode;
        }
                traits = traits.replace(distTraitDef.from(oldDist));
            );
import java.util.HashSet;
     * nodes in the plan. Walks the tree up to {@link #MAX_EXTRACT_INDICES_DEPTH} levels to
            }
                aggregate.getCallAnnotations(),
        });
        for (RelDataTypeField f : base.getFieldList()) {
            return new RexInputRef(newIdx, newRowType.getFieldList().get(newIdx).getType());
            if (newIdx < 0) {
import java.util.LinkedHashSet;
                aggregate.getIntermediateFields()
        });
                newTraits,
                            + "(input only declares "
 * SPDX-License-Identifier: Apache-2.0
                    + MAX_EXTRACT_INDICES_DEPTH
                newTraits,
    public static final class IndexRemapShuttle extends RexShuttle {
        }
        }
            public RexNode visitCall(RexCall call) {
            return new OpenSearchUncollect(
        RelTraitSet newTraits = rebuildTraits(node, newCluster, distTraitDef);
                return RexUtil.flatten(rexBuilder, super.visitCall(call));
import org.apache.calcite.rel.type.RelDataTypeField;
                        "RexInputRef["
        } else if (node instanceof OpenSearchShuffleExchange shuffle) {
                shuffle.getPartitionCount(),
        return node.accept(new RexShuttle() {
                newCluster,
                    );
        } else if (node instanceof OpenSearchJoin join) {
        if (!collectIndices(plan, indices, 0)) {
     * Resolves a derived expression to the ordered list of physical-field names it depends on,
        List<T> out = new ArrayList<>();
    public static void logPlan(Logger logger, String label, RelNode plan) {
     * @param plan the root of the RelNode tree
     * sees every match — e.g. a WHERE filter below an Aggregate AND a HAVING filter above it, which
        }
    }
                }
     * searching all inputs. Returns {@code null} if none is present.
        if (!node.getInputs().isEmpty()) {
        }
     * <ul>
    }
                newInputs.get(0),
import org.opensearch.analytics.planner.rel.OpenSearchSort;
     */
        if (type.isInstance(node)) {
     * Extracts all index names referenced by {@link org.apache.calcite.rel.core.TableScan}
import org.opensearch.analytics.planner.rel.OpenSearchCorrelate;
    /**
            builder.add(f.getName(), f.getType());
     * Recursively flattens nested same-operator AND/OR calls so the condition satisfies
        }
        } else if (node instanceof OpenSearchUnion union) {
                if (!idx.isEmpty()) {
     * <p>TODO: migrate existing findLeaf/findFilter usages in FragmentConversionDriver to use this.
        } else if (node instanceof OpenSearchSort sort) {
                uncollect.getViableBackends()
 * The OpenSearch Contributors require contributions made to
                            + " columns) — "
     * guard against pathologically deep plans constructed from complex user queries.
                aggregate.getFinalExtraLiteralArgs(),
     * Debug-dumps a labelled plan via {@code logger}, guarding the expensive
