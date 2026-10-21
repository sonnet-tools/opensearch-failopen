        return false;
        FragmentInstructionHandlerFactory factory = backend.getInstructionHandlerFactory();
                    );
                            "Native annotation [id={}]: backend [{}] matches operator",
    /**
            child.getRowType(),
import org.opensearch.analytics.spi.FragmentConvertor;
    }
     *       The child's {@code convertSchemaOnlyRead} returns a self-describing schema stub so the
                                );
        OpenSearchStageInputScan placeholder = new OpenSearchStageInputScan(
         * Maximal same-backend delegated subtrees are converted via the backend's
            // Identify the PARTIAL aggregate — either at the top of the fragment or buried
            // The leaf's qualified name is the planner's logical table name (alias / index pattern /
                changed = true;
                    RexNode original = annotation.unwrap();
            if (containsPartialAggregate(resolvedFragment)) {
        }
                }
        // leaf the broadcast side is the runtime-injected one and must not classify the stage.
     * {@code resolvedFragment} IS the wrapper (DAGBuilder builds it that way), but we don't
 *       {@code convertFragment} on the full fragment</li>
        return node.copy(node.getTraitSet(), List.of(placeholder));
        for (StagePlan plan : stage.getPlanAlternatives()) {
            AnalyticsSearchBackendPlugin backend = registry.getBackend(converted.getFirst().backendId());
                public RexNode apply(OperatorAnnotation annotation) {
            boolean schemaMismatch = produced.getFieldCount() != expected.getFieldCount() || produced.equals(expected) == false;
        }
 * @opensearch.internal
            return convertReduceFragment(resolvedFragment, convertor, delegationBytes);
            byte[] bytes = convertor.convertSchemaOnlyRead(stage.getStageId(), wrapper.getRowType());
        stage.setPlanAlternatives(converted);
                            String peerBackend = ap.getPerformanceDelegationBackends().getFirst();
            // Assemble instruction list
import org.apache.logging.log4j.LogManager;
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
            return convertor.convertFragment(strip(node.getInputs().getFirst(), delegationBytes));
        }
    private static RelNode strip(RelNode node, IntraOperatorDelegationBytes delegationBytes) {
            List.of(),
                                delegatedExpressions = new ArrayList<>();
     * whenever the parent reduce sink can't safely decode the child's {@code convertedBytes} as
            byte[] innerBytes = convertReduceNode(node.getInputs().getFirst(), convertor, false, delegationBytes);
            List<RelNode> strippedInputs = node.getInputs().stream().map(input -> strip(input, delegationBytes)).toList();
                        return annotation.unwrap();
            if (!finalAggConverted) {
import org.opensearch.analytics.planner.rel.AnnotationResolver;
        if (root instanceof OpenSearchAggregate agg
            // partitioning is enforced at runtime by the producer-side sink; the consumer
     * route through the shard-scan path on the right.
                && agg.getMode() == AggregateMode.PARTIAL
            // index) — the same single segment isthmus emits as the Substrait NamedTable. Pass it to
            DelegatedPredicateCombiner classifier = new DelegatedPredicateCombiner(
 * {@link FragmentConvertor} using composable calls — backends never traverse the plan.
            node = child;
import org.opensearch.analytics.spi.DelegatedExpression;
import org.opensearch.analytics.spi.DelegationPossibleFunction;
        IntraOperatorDelegationBytes delegationBytes
        // Store factory on coordinator-reduce stages (local execution, no serialization needed).
            boolean changed = false;
                    continue;
     * <p>Producer wire-format is asked of the child's convertor via
                // For single-input shapes (Sort/Project/Aggregate over a partial agg) this is the
                        // but a peer can be opportunistically consulted at runtime.
        }
                                + "]. CapabilityRegistry should have rejected this at startup."
        // leaf per child stage. findNode walks only the first-input chain, so match each child
    }
         * Creates an annotation resolver that does a single bottom-up traversal.
        if (node instanceof OpenSearchRelNode openSearchNode) {
     * partition schema via the standard producerPlanBytes path.
        // Root stage executes locally at coordinator — store factory for instruction dispatch.
                                serialized.length
            node.getTraitSet(),
                return convertor.convertFragment(strip(node, delegationBytes));
                // respective input partitions.
    private static RelNode stripSingleOperator(RelNode node) {
                        LOGGER.debug(
            converted.add(plan.withConvertedBytes(bytes, delegated).withInstructions(instructions));
                    current = convertor.attachFragmentOnTop(stripSingleOperator(aboveAgg.get(i)), current);
            // (no intermediate ExchangeReducer wrapper). Treat the leaf itself as the boundary;
                // convertedBytes for partition-schema derivation.
            convertLateMaterializationStage(stage, registry);
    public static void convertAll(QueryDAG dag, CapabilityRegistry registry) {
                                return annotation.unwrap();
            OpenSearchStageInputScan inputScan = null;
                boolean allChildrenAreStageInputScan = !node.getInputs().isEmpty()
                return leftLeaf;
            return;
 *
            FragmentConvertor convertor = backend.getFragmentConvertor();
            this.registry = registry;
     * Dispatches conversion based on the fragment's leaf and top node types.
                partialAgg = findBuriedPartialAggregate(resolvedFragment);
                while (walk != partialAgg) {
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
                        finalAggInputs.add(strip(input.getInputs().getFirst(), delegationBytes));
                return LogicalFilter.create(strippedChildren.getFirst(), flattened);
            // ancestors above this boundary attach via attachFragmentOnTop on the way back up.
            "Unknown leaf type [" + leaf.getClass().getSimpleName() + "]. " + "Add a FragmentConversionStrategy for this leaf type."
        if (root instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.PARTIAL) return true;
     * substrait-level stitching is needed.
                    if (!(original instanceof RexCall originalCall) || !(originalCall.getOperator() instanceof SqlFunction sqlFunction)) {
        if (node.getInputs().isEmpty()) {
    private static RelNode findLeaf(RelNode node) {
            return delegatedExpressions != null ? delegatedExpressions : List.of();
     * </ul>
        return instructions;
     * scan is a runtime-injected memtable input — it never drives stage targeting or
                    LOGGER.debug(
     * QTF today (linear fragments). When QTF extends to Joins/Unions, multi-input fragments will
     * over one whose first leaf is an {@link OpenSearchBroadcastScan} placeholder. The broadcast
            return true;
                public RexNode resolveTree(RexNode condition) {
                factory.createShardScanWithDelegationNode(treeShape, delegated.size(), requestsRowIds, logicalTableName)
     * Emits a schema-only Read stub onto each child plan's {@code postDecorationSchemaBytes}
     * <ul>
            convertStage(child, registry);
                        delegatedExpressions = new ArrayList<>();
                            operatorBackend
            Function<OperatorAnnotation, RexNode> resolver = delegationBytes.resolverFor(openSearchNode, node.getCluster().getRexBuilder());
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
    static byte[] convert(RelNode resolvedFragment, FragmentConvertor convertor, IntraOperatorDelegationBytes delegationBytes) {
import java.util.LinkedList;
                            "No DelegatedPredicateSerializer for ["
        RelNode node,
import org.apache.calcite.rex.RexBuilder;
        }
    private static OpenSearchAggregate findBuriedPartialAggregate(RelNode fragment) {
            // mirrors the combiner's post-combine shape so the data node's classification matches
 *   <li>Leaf = {@link OpenSearchTableScan}, top = {@link OpenSearchAggregate}(PARTIAL):
            RelNode strippedNode = openSearchNode.stripAnnotations(strippedInputs, resolver);
 * {@code FragmentConversionStrategy} abstraction so each shape encapsulates its own
                            ScalarFunction function = ScalarFunction.fromSqlOperatorWithFallback(originalCall.getOperator());
        // registering the partition so the catalog binding matches what the decorator delivers.
                            if (delegatedExpressions == null) {
                        return classifier.finalizeDelegated(d);
 *
                byte[] current = convertor.attachPartialAggOnTop(strippedAgg, innerBytes);
     *       opaque bytes and fails.</li>
import org.opensearch.analytics.planner.RelNodeUtils;
            // the tree it actually receives.
                // Layered conversion: convert scan below → attachPartialAggOnTop → attach
                Function<OperatorAnnotation, RexNode> resolver = delegationBytes.resolverFor(
            if (containsEngineNativeAggregate(child, mode)) return true;
        convertStage(dag.rootStage(), registry);
        }
            strippedChildren.add(strip(input, delegationBytes));
                                + annotationBackend
            List<StagePlan> updated = new ArrayList<>(child.getPlanAlternatives().size());
            // un-reordered data, corrupting the final column order.
import org.opensearch.analytics.planner.rel.AggregateMode;
            // fragment converts as if the input arrived as plain StageInputScan named-input.
        }
                : FilterTreeShape.NO_DELEGATION;
                    if (serializer == null) {
                    RelNode finalAggFragment = openSearchNode.stripAnnotations(finalAggInputs, resolver);
    private static void populatePostDecorationSchemas(Stage stage, CapabilityRegistry registry) {
     * rewriting OpenSearchStageInputScan leaves to plain TableScans (inside the convertor)
        }
            -1,
 *       then {@code attachPartialAggOnTop}</li>
            RelNode leftLeaf = findLeaf(node.getInputs().get(0));
                }
                operatorBackend,
                // fragment so all branches end up in the same Substrait plan reading from their
        }
                    delegatedExpressions.add(new DelegatedExpression(annotation.getAnnotationId(), annotationBackend, serialized));
                        // Performance-delegation candidate: dual-viable predicate kept on the operator's backend,
     */
     * no delegated predicates — avoids the getOutputFieldStorage() call that would fail on
        for (StagePlan plan : stage.getPlanAlternatives()) {
                            if (!(original instanceof RexCall originalCall)) {
                                "Performance-delegated annotation [id={}]: {} kept on operator [{}], wrapped for peer [{}], serialized {} bytes",
     * instruction assembly, so a probe-side join with shape
        if (node instanceof OpenSearchRelNode openSearchNode) {
                RelNode strippedAgg = partialAgg.stripAnnotations(strippedInputs, resolver);
            // a worker stage and the consumer fragment becomes Sort/Project/StageInputScan
        IntraOperatorDelegationBytes delegationBytes
        }
            stage.setInstructionHandlerFactory(backend.getInstructionHandlerFactory());
            if (child instanceof OpenSearchAggregate agg
     * Uses direct {@code stripAnnotations} (no delegation resolver) since TopK operators have
        }
                    List<RelNode> finalAggInputs = new ArrayList<>(node.getInputs().size());
        }
        if (node instanceof OpenSearchShuffleExchange) {
                delegated.size(),
     * compute. We only need the schema-bearing Read so Stage 3's reduce sink derives a
                plan.backendId(),
                        );
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
    }
     *       a custom wire format from {@code convertFragment} the reducer can't decode generically.
                @Override
        // OpenSearchBroadcastScan placeholder. With one driving leaf and one broadcast-scan
        if (node instanceof OpenSearchExchangeReducer) {
            // A pure-reorder Project above an engine-native-merge FINAL is emitted like any other operator;
        // stub Read carrying the wrapper's output schema so Stage 3's parent reduce sink
        if (stage.getExchangeSinkProvider() != null && !converted.isEmpty()) {
    private FragmentConversionDriver() {}
        boolean childrenChanged = false;
     * (the producer describes its own output schema):
        // A multi-input parent fragment (e.g. a Join or Union) has one OpenSearchStageInputScan
            OpenSearchAggregate partialAgg = null;
                    if (annotationBackend.equals(operatorBackend)) {
import org.apache.calcite.rel.logical.LogicalFilter;
 *
    private static List<InstructionNode> assembleInstructions(
            if (node instanceof OpenSearchFilter filter && resolver instanceof AnnotationResolver ar) {
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
            FragmentConvertor convertor = registry.getBackend(plan.backendId()).getFragmentConvertor();
    }
     * Converts all {@link StagePlan} alternatives in the DAG, populating
package org.opensearch.analytics.planner.dag;
        }
        }
    /**
        StagePlan plan,
            // Coord-only literal source — convert the whole fragment via the same isthmus
     * OpenSearchBroadcastScan as-is (backend-side rewriter maps them to NamedScans). */
            // backend so it picks the row-id-aware table provider regardless of delegation.
            // StageInputScan → plain TableScan rewrite makes the leaves isthmus-friendly without
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            RelDataType produced = child.getFragment().getRowType();
            );
        for (RelNode input : node.getInputs()) {
            // path as reduce fragments. isthmus emits ReadRel.VirtualTable for the Values
import org.apache.calcite.rex.RexCall;
            if (resolvedFragment instanceof OpenSearchAggregate agg
        // against ALL input-scan leaves; otherwise every child but the one on the first chain is
                    return convertor.convertFragment(finalAggFragment);
                delegated.isEmpty() ? "" : " [ids=" + delegated.stream().map(d -> String.valueOf(d.getAnnotationId())).toList() + "]"
            RelDataType expected = inputScan.getRowType();
        throw new IllegalStateException("Unexpected reduce stage node: " + node.getClass().getSimpleName());
                        }
                                    peerBackend,
            // dropping it would strand operators above it (e.g. Sort) with the post-reorder schema over
                            }
    }
                        if (annotation instanceof AnnotatedPredicate ap && !ap.getPerformanceDelegationBackends().isEmpty()) {
                            );
        List<StagePlan> converted = new ArrayList<>(stage.getPlanAlternatives().size());
        }
                            delegatedExpressions.add(new DelegatedExpression(ap.getAnnotationId(), peerBackend, serialized));
                                throw new IllegalStateException("Performance-delegation candidate must wrap a RexCall: " + original);
        List<RelNode> strippedChildren = new ArrayList<>(node.getInputs().size());
        for (RelNode child : root.getInputs()) {
     * convert it — the LM stage runs Java-only scatter/gather/stitch and emits no Substrait
     * native (evaluated by the driving backend). Tree-walking and combining logic is
            List<InstructionNode> instructions = assembleInstructions(backend, plan, treeShape, delegationBytes);
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    }
        return findLeaf(node.getInputs().getFirst());
    /**
                fieldStorage,
                                + function
        // After children are converted, surface any decorator-induced schema delta as
        // Shard stages get the factory from the local backend plugin at the data node.
            for (StagePlan plan : child.getPlanAlternatives()) {
                }
     *
        for (RelNode child : root.getInputs()) {
 * The OpenSearch Contributors require contributions made to
            // under TopK's Sort/Project wrapper.
            return openSearchNode.stripAnnotations(strippedChildren, resolver);
            // Substrait — the convertor never needs to lower the shuffle node itself.
     *       parent declares the wider {@code expected} rowType on its
                    partialAgg,
                boolean allChildrenAreExchangeReducer = !node.getInputs().isEmpty()
                            if (serializer == null) {
        // can derive the partition schema via the standard producerPlanBytes path.
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;
import org.opensearch.analytics.spi.InstructionNode;
     * (Sort, Project, etc.) via attachFragmentOnTop.
                rexBuilder,
                // final-aggregate operator; for multi-input shapes (Union) every branch is itself
            return node;
                }
        FilterTreeShape treeShape,
                byte[] postDecorationBytes = convertor.convertSchemaOnlyRead(child.getStageId(), expected);
import org.opensearch.analytics.spi.FilterTreeShape;
                if (allChildrenAreStageInputScan) {
    }
                if (allChildrenAreExchangeReducer && node.getInputs().size() == 1) {
                        throw new IllegalStateException(
     *   <li><b>Schema decoration</b> — a partition decorator (e.g. {@code OrdinalAppendingSink})
                treeShape,
                                .get(function);
                            RexNode original = ap.unwrap();
            if (!delegated.isEmpty()) {
/*
            }
    ) {
    // TODO: consolidate with isAggregatePath / findBuriedPartialAggregate into a shared utility
                            LOGGER.debug(
                List<RelNode> strippedInputs = partialAgg.getInputs().stream().map(input -> strip(input, delegationBytes)).toList();
                // (b) the producer's wire format is opaque — the reducer can't decode its
import org.opensearch.analytics.planner.CapabilityRegistry;
        Function<OperatorAnnotation, RexNode> resolverFor(OpenSearchRelNode operator, RexBuilder rexBuilder) {
                factory.createShardScanNode(requestsRowIds, logicalTableName).ifPresent(instructions::add);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
                    }
                return agg;
                    }
        boolean finalAggConverted,
                                    "Performance-delegation skipped: no serializer for [{}] on delegated backend [{}]; falling back to native on operator [{}]",
        if (node instanceof OpenSearchBroadcastScan) {
                    inputScan = candidate;
                    .ifPresent(instructions::add);
                boolean selfDescribing = convertor.wireFormat() == WireFormat.SELF_DESCRIBING;
            // a HAVING stays in a separate un-delegated filter above the Aggregate. Pick the WHERE,
            return convertor.convertFragment(node);
        if (fragment instanceof OpenSearchAggregate) return null;
     * Strips a single operator with a placeholder child for use with {@code attachFragmentOnTop}.
                }
            }
 *       then {@code attachFragmentOnTop} for any operators above it</li>
     * base_schema: wrapperOutput }} the parent reduce sink can register against. The plan's
            List<FieldStorageInfo> fieldStorage = operator.getOutputFieldStorage();
         * {@code DelegatedSubtreeConvertor} into one DelegatedExpression each.
     *       widens the child's produced rowType before it reaches the partition boundary. The
     */
            // backend reverse-engineering it from the plan bytes.
        }
            return convertor.convertFragment(strip(node.getInputs().getFirst(), delegationBytes));
            }
        if (node instanceof OpenSearchStageInputScan) {
                                + "] on backend ["
        if (node instanceof OpenSearchStageInputScan) {
    }
            }
            Function<OperatorAnnotation, RexNode> resolver = delegationBytes.resolverFor(openSearchNode, node.getCluster().getRexBuilder());
    private static void convertLateMaterializationStage(Stage stage, CapabilityRegistry registry) {
                        operatorBackend,
            // leaf; DataFusion executes it locally without any input partitions.
     * Reduce stage conversion: strips ExchangeReducer, converts the final agg fragment
    /**
        );
        RelNode child = node.getInputs().getFirst();
            boolean requestsRowIds = tableScan.getRowType().getFieldNames().contains(OpenSearchLateMaterialization.ROW_ID_FIELD);
        IntraOperatorDelegationBytes(CapabilityRegistry registry) {
        }
                // First OpenSearchRelNode whose ALL inputs are ExchangeReducers is treated as the
 * SPDX-License-Identifier: Apache-2.0
     * <p>Multi-input nodes (Join, Union, Intersect, Minus) are converted as a single
                RexNode resolved = ar.resolveTree(filter.getCondition());
                return current;
        if (node instanceof OpenSearchRelNode openSearchNode) {
                    && node.getInputs().stream().allMatch(input -> input instanceof OpenSearchExchangeReducer);
     *
            AnalyticsSearchBackendPlugin backend = registry.getBackend(plan.backendId());
            }
                break;
 * compatible open source license.
        if (leaf instanceof OpenSearchTableScan tableScan) {
                    byte[] serialized = serializer.serialize(originalCall, fieldStorage);
            && agg.getAggCallList().stream().anyMatch(org.opensearch.analytics.spi.AggregateFunction::isEngineNativeMerge)) {
            List.of()
        return childrenChanged ? node.copy(node.getTraitSet(), strippedChildren) : node;
 * Drives fragment conversion for all {@link StagePlan} alternatives in a {@link QueryDAG}.
                partialAgg = agg;
            return findLeaf(node.getInputs().get(1));
     * subtree via convertFragment: isthmus handles all of them natively, and
                byte[] innerBytes = convertor.convertFragment(strippedInputs.getFirst());
                                operatorBackend,
        if (stage.getExecutionType() == StageExecutionType.LATE_MATERIALIZATION) {
    }
    private static boolean containsPartialAggregate(RelNode root) {
                // Stub needed when (a) the schema decorator widened the partition rowType, or
            converted.add(plan.withConvertedBytes(bytes, List.of()).withInstructions(List.of()));
     * the wire format it expects. Two distinct triggers, both resolved by the CHILD's convertor
import org.apache.calcite.sql.SqlFunction;
                    aboveAgg.add(walk);
            // backend's createPartitionedSink (driven by ShuffleProducerOutputState), not in
            return convertor.attachFragmentOnTop(strippedNode, innerBytes);
    /**
 *       {@code convertFragment} on everything below partial agg,
import org.opensearch.analytics.spi.WireFormat;
                        .delegatedPredicateSerializers()
     */
        // For binary inputs (Join), prefer the side whose subtree's leaf is NOT an
     * {@link FragmentConvertor#wireFormat()}. The schema-only Read uses the {@code expected}
        return convertReduceNode(node, convertor, false, delegationBytes);
            RelNode child = node.getInputs().getFirst();
        }
     *
    /**
                    return ((DelegatedPredicateCombiner.Resolved) result).node();
                && agg.getAggCallList().stream().anyMatch(org.opensearch.analytics.spi.AggregateFunction::isEngineNativeMerge)) {
            // any post-conversion substrait-level stitching.
    }
    }
    }
     */
        RelNode node = fragment;
            if (node.getInputs().size() >= 2) {
        }
                        );
            if (!(leftLeaf instanceof OpenSearchBroadcastScan)) {
                                peerBackend,
            root.setInstructionHandlerFactory(backend.getInstructionHandlerFactory());
                    walk = walk.getInputs().getFirst();
        if (node.getInputs().size() == 2) {
        }
            }
                            return DelegationPossibleFunction.makeCall(rexBuilder, originalCall, ap.getAnnotationId());
                );
                if (candidate.getChildStageId() == child.getStageId()) {
            List<DelegatedExpression> delegated = delegationBytes.getResult();
            for (OpenSearchStageInputScan candidate : inputScans) {
    /**
     * <p>For binary-input nodes, prefers the input subtree that contains a real driving leaf
/**
        FragmentConvertor convertor,
}
            return node; // kept for schema inference at probe stage; backend rewriter maps to NamedScan
            }
        if (leaf instanceof OpenSearchStageInputScan) {
                // into this stage's input partition with no ExchangeReducer between, so the
        for (int i = 0; i < strippedChildren.size(); i++) {
     * rowType (the post-decoration schema crossing the partition boundary).
                }
                @Override
                && agg.getMode() == AggregateMode.PARTIAL
        List<OpenSearchStageInputScan> inputScans = RelNodeUtils.findNodes(stage.getFragment(), OpenSearchStageInputScan.class);
     * Accumulates serialized delegated query bytes during fragment conversion.
                updated.add(plan.withPostDecorationSchemaBytes(postDecorationBytes));
            OpenSearchFilter filter = filters.isEmpty() ? null : filters.getLast();
            OpenSearchLateMaterialization wrapper = (OpenSearchLateMaterialization) plan.resolvedFragment();
        RelNode leaf = findLeaf(resolvedFragment);
            }
        // silently skipped, leaving its partition schema underived at the reduce sink.
            LOGGER.debug(
 */
            if (strippedChildren.get(i) != node.getInputs().get(i)) {
                "Stage [{}] converted: treeShape={}, delegatedExpressions={}{}",
                            }
            List<DelegatedExpression> delegated = delegationBytes.getResult();
        private final CapabilityRegistry registry;
                                    function,
    private static boolean containsEngineNativeAggregate(RelNode root, AggregateMode mode) {
        AnalyticsSearchBackendPlugin backend,
            String logicalTableName = tableScan.getTable().getQualifiedName().getLast();
     * Walks down the fragment to find the leaf that drives stage classification — the
        List<DelegatedExpression> getResult() {
        );
                        "Delegated annotation [id={}]: {} from operator [{}] to [{}], serialized {} bytes",
                ? FilterTreeShapeDeriver.derive(filter, plan.backendId())
            String operatorBackend = operator.getViableBackends().getFirst();
                // an ER → StageInputScan, and the entire Union+ER subtree is converted as one
     * {@code Join(OpenSearchBroadcastScan, OpenSearchTableScan)} (build = left) must still
                    DelegatedPredicateSerializer serializer = registry.getBackend(annotationBackend)
    private static void convertStage(Stage stage, CapabilityRegistry registry) {
        while (node.getInputs().size() == 1) {
                // Combine delegated predicates in a single pass, then strip with simple unwrapper
     *       producer's narrower natural schema.</li>
            byte[] bytes = convert(plan.resolvedFragment(), convertor, delegationBytes);
        return false;
        for (Stage child : stage.getChildStages()) {
                RexNode flattened = RelNodeUtils.deepFlatten(node.getCluster().getRexBuilder(), resolved);
     */
                        annotationBackend,
    }
            return new AnnotationResolver() {
                && agg.getAggCallList().stream().anyMatch(org.opensearch.analytics.spi.AggregateFunction::isEngineNativeMerge)) {
        if (leaf instanceof OpenSearchValues) {
import java.util.function.Function;
            node.getCluster(),
     *       {@code OpenSearchStageInputScan} placeholder; the reducer needs that, not the
     * are all ExchangeReducers, and attach via attachFragmentOnTop on the way back up.
                    }
            // StageInputScans — serializes in one convertFragment pass. The convertor's
        } else if (leaf instanceof OpenSearchStageInputScan && containsEngineNativeAggregate(resolvedFragment, AggregateMode.FINAL)) {
            // Direct StageInputScan boundary — happens after the hash-shuffle rewriter inserts
            }
            }
            // Strip the hash-shuffle wrapper. Partitioning happens at runtime inside the
        private List<DelegatedExpression> delegatedExpressions;
import org.apache.calcite.rex.RexNode;
                registry,
            // QTF narrows the Scan to [belowAnchorPhysicalFields..., __row_id__]; signal that to the
                // boundary between the coordinator-side fragment and the data-node child stages.
                                    operatorBackend
            && agg.getMode() == mode
        populatePostDecorationSchemas(stage, registry);
                    for (RelNode input : node.getInputs()) {
                }
        if (node instanceof OpenSearchExchangeReducer) {
                // so isthmus can serialize it.
                    DelegatedPredicateCombiner.Classified result = classifier.classify(condition, this::apply);
     * delegated to {@link DelegatedPredicateCombiner}.
     */
        }
        return null;
     *
     * lets the whole gathered subtree serialize in one pass. No post-conversion
            }
     * classifying each node as delegated (targets a non-operator backend like Lucene) or
 * <p>Dispatch logic for PR2 (pure shard-scan path):
     * (with StageInputScan as leaf for schema), then attaches any operators above it
        }
import org.opensearch.analytics.planner.rel.OpenSearchValues;
            // the convertor's StageInputScan→NamedScan rewrite handles binding. Single-input
            }
    /** Finds an engine-native-merge PARTIAL aggregate buried under operators (not at fragment top). */
 * dispatch logic rather than growing this class with more {@code instanceof} checks.
        LinkedList<InstructionNode> instructions = new LinkedList<>();
        }
     */
                FragmentConvertor convertor = registry.getBackend(plan.backendId()).getFragmentConvertor();
public class FragmentConversionDriver {
    /** Recursively strips annotations bottom-up. Keeps OpenSearchStageInputScan and
 *
import org.apache.calcite.rel.type.RelDataType;
                        throw new IllegalStateException("Delegated expression must be a SqlFunction call: " + original);
    }
     * <p>Single-input ancestors of a single gathered subtree (Sort/Project/Aggregate over
        }
            RelNode stripped = strip(resolvedFragment, delegationBytes);
         */
                                ap.getAnnotationId(),
        stage.setPlanAlternatives(converted);
                if (schemaMismatch == false && selfDescribing) {
        }
 *   <li>Leaf = {@link OpenSearchStageInputScan} (reduce stage):
            // Pushdown+merge rules leave delegated annotations only in the bottommost (WHERE) filter;
 * </ul>
        throw new IllegalStateException(
                    return convertor.convertFragment(strip(node, delegationBytes));
                        annotation.getAnnotationId(),
                    updated.add(plan);
 */
                }
                                .delegatedPredicateSerializers()
import java.util.List;
 *   <li>Leaf = {@link OpenSearchTableScan}, top = anything else:
import org.opensearch.analytics.spi.FieldStorageInfo;
            AnalyticsSearchBackendPlugin backend = registry.getBackend(root.getPlanAlternatives().getFirst().backendId());
        /**
    static final class IntraOperatorDelegationBytes {
import org.apache.calcite.rel.RelNode;
                    ScalarFunction function = ScalarFunction.fromSqlFunction(sqlFunction);
        }
     * <p>TODO: Uses {@link RelNodeUtils#findNode} which only walks the first-input chain. Fine for
                        .getCapabilityProvider()
            List<OpenSearchFilter> filters = RelNodeUtils.findAllNodes(plan.resolvedFragment(), OpenSearchFilter.class);
            factory.createFinalAggregateNode().ifPresent(instructions::add);
            return convertor.convertFragment(stripped);
            if (partialAgg != null) {
 * <p>TODO: as shuffle joins/aggregates and delegation are added, introduce a
                    String annotationBackend = annotation.getViableBackends().getFirst();
                            }
            if (changed) child.setPlanAlternatives(updated);
     * a partial agg) reach convertFragment as soon as we see a node whose inputs
        if (node instanceof OpenSearchShuffleExchange) {
                factory.createPartialAggregateNode().ifPresent(instructions::add);
     * this fragment is a shard-scan stage or a coordinator-reduce stage.
            if (delegatedExpressions == null) delegatedExpressions = new ArrayList<>();
import org.opensearch.analytics.spi.ScalarFunction;
                delegatedExpressions
        for (Stage child : stage.getChildStages()) {
                    break;
            RelNode stripped = strip(resolvedFragment, delegationBytes);
     *
                    return annotation.makePlaceholder(rexBuilder);
        }
        }
                        function,
            } else {
                            annotation.getAnnotationId(),
                    partialAgg.getCluster().getRexBuilder()
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
 * Strips annotations from each resolved fragment and dispatches to the backend's
        RelNode resolvedFragment = plan.resolvedFragment();
                                LOGGER.debug(
            // the data node so it registers the scanned shard's table under this name, instead of the
                RelNode walk = resolvedFragment;
    private static final Logger LOGGER = LogManager.getLogger(FragmentConversionDriver.class);
            // Strip ShuffleExchange — same shape as ExchangeReducer at this layer. The
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        if (leaf instanceof OpenSearchTableScan) {
                    if (delegatedExpressions == null) {
                    }
                        serialized.length
        }
                    if (result instanceof DelegatedPredicateCombiner.Delegated d) {
                        .get(function);
            );
     * {@link OpenSearchTableScan} or {@link OpenSearchStageInputScan} that determines whether
    /**
        RelNode leaf = findLeaf(resolvedFragment);
            if (inputScan == null) continue;
 * <ul>
    }
            // not findNode's topmost (HAVING → NO_DELEGATION → collector skipped → over-count).
                        // Skip the ER, keep StageInputScan below it as the leaf for schema inference.
                // StageInputScan leaf sits directly under this op. Convert the whole node as one
        }
            IntraOperatorDelegationBytes delegationBytes = new IntraOperatorDelegationBytes(registry);
            return convertor.convertFragment(stripped);
            return openSearchNode.stripAnnotations(List.of(placeholder), OperatorAnnotation::unwrap);
     *       reducer can register the partition. Without this, the reducer runs decode over the
        }
     * the placeholder.
                    }
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
                List<RelNode> aboveAgg = new ArrayList<>();
     *
    private static byte[] convertReduceNode(
    private static byte[] convertReduceFragment(RelNode node, FragmentConvertor convertor, IntraOperatorDelegationBytes delegationBytes) {
        }
            FilterTreeShape treeShape = filter != null
        Stage root = dag.rootStage();
     */
                    && node.getInputs().stream().allMatch(input -> input instanceof OpenSearchStageInputScan);
        // postDecorationSchemaBytes on the child plans. The reduce sink consults this when
import org.apache.logging.log4j.Logger;
            if (containsPartialAggregate(child)) return true;
     * <p>The resolver performs a single bottom-up traversal of the filter condition tree,
                // any operators above the aggregate (zero iterations when agg is the top).
     * Stub Substrait for the LM stage: a {@code Read { named_table: "input-<lmStageId>";
        // LM stage runs Java-only scatter/gather/stitch — no Substrait compute. Emit a
            };
                    }
            // Multi-input node (Join, Union, Intersect, Minus): isthmus handles all of them
                childrenChanged = true;
import java.util.ArrayList;
            } else {
     *
                for (int i = aboveAgg.size() - 1; i >= 0; i--) {
    ) {
                                function,
            // natively. The whole subtree — multi-input node + its branches + ERs +
 *       {@code convertFragment} on the final agg (ExchangeReducer stripped),
                // LM-fed reduce stage (post-LM Stage 3): the LM stage emits a stitched VSR straight
            // Derive filter tree shape BEFORE stripping (annotations must be intact). The deriver
        List<StagePlan> converted = new ArrayList<>(stage.getPlanAlternatives().size());
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
                            byte[] serialized = serializer.serialize(originalCall, fieldStorage);
     * {@link StagePlan#convertedBytes()} on each plan.
     *   <li><b>Opaque-wire-format producer</b> — the child plan's backend (Lucene today) emits
     * have multiple {@code StageInputScan} leaves and this needs a multi-leaf walker.
                // fragment; the convertor's rewriteStageInputScans turns the leaf into a NamedScan
            // Strip ExchangeReducer — StageInputScan below it is the schema source.
            return node; // kept for schema inference at reduce stage
            // Single-input operator above the final-fragment boundary — convert child first, then attach.
                            DelegatedPredicateSerializer serializer = registry.getBackend(peerBackend)
            return strip(node.getInputs().getFirst(), delegationBytes);
            return strip(node.getInputs().getFirst(), delegationBytes);
        if (root.getExchangeSinkProvider() != null && !root.getPlanAlternatives().isEmpty()) {
