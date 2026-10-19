                byte[] innerBytes = convertor.convertFragment(strippedInputs.getFirst());  
                fieldStorage,  
                    byte[] serialized = serializer.serialize(originalCall, fieldStorage);  
                && agg.getMode() == AggregateMode.PARTIAL
     * base_schema: wrapperOutput }} the parent reduce sink can register against. The plan's
        /**
     * rowType (the post-decoration schema crossing the partition boundary).
            return openSearchNode.stripAnnotations(List.of(placeholder), OperatorAnnotation::unwrap);  
            }
                        .getCapabilityProvider()  
            // Strip ExchangeReducer — StageInputScan below it is the schema source.  
     *  
                        delegatedExpressions = new ArrayList<>();
            AnalyticsSearchBackendPlugin backend = registry.getBackend(plan.backendId());
                // For single-input shapes (Sort/Project/Aggregate over a partial agg) this is the
            RelNode leftLeaf = findLeaf(node.getInputs().get(0));  
        }
         * Creates an annotation resolver that does a single bottom-up traversal.
                // into this stage's input partition with no ExchangeReducer between, so the
     * Converts all {@link StagePlan} alternatives in the DAG, populating
                        throw new IllegalStateException(
import org.opensearch.analytics.spi.DelegationPossibleFunction;
                    current = convertor.attachFragmentOnTop(stripSingleOperator(aboveAgg.get(i)), current);
        return node.copy(node.getTraitSet(), List.of(placeholder));
            // StageInputScan → plain TableScan rewrite makes the leaves isthmus-friendly without  
     * rewriting OpenSearchStageInputScan leaves to plain TableScans (inside the convertor)  
            return node;  
                ? FilterTreeShapeDeriver.derive(filter, plan.backendId())
                                    "Performance-delegation skipped: no serializer for [{}] on delegated backend [{}]; falling back to native on operator [{}]",
        if (node instanceof OpenSearchBroadcastScan) {
                // LM-fed reduce stage (post-LM Stage 3): the LM stage emits a stitched VSR straight  
        if (node instanceof OpenSearchRelNode openSearchNode) {
            // the convertor's StageInputScan→NamedScan rewrite handles binding. Single-input
     * (with StageInputScan as leaf for schema), then attaches any operators above it  
        List<StagePlan> converted = new ArrayList<>(stage.getPlanAlternatives().size());
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;  
                partialAgg = findBuriedPartialAggregate(resolvedFragment);
    static byte[] convert(RelNode resolvedFragment, FragmentConvertor convertor, IntraOperatorDelegationBytes delegationBytes) {
        }
            List<InstructionNode> instructions = assembleInstructions(backend, plan, treeShape, delegationBytes);  
        }
                        return classifier.finalizeDelegated(d);
                // an ER → StageInputScan, and the entire Union+ER subtree is converted as one  
     * are all ExchangeReducers, and attach via attachFragmentOnTop on the way back up.
                                .get(function);
 * {@code FragmentConversionStrategy} abstraction so each shape encapsulates its own
            }
        } else if (leaf instanceof OpenSearchStageInputScan && containsEngineNativeAggregate(resolvedFragment, AggregateMode.FINAL)) {  
        if (node instanceof OpenSearchRelNode openSearchNode) {
            List<DelegatedExpression> delegated = delegationBytes.getResult();
 * this file be licensed under the Apache-2.0 license or a
                factory.createPartialAggregateNode().ifPresent(instructions::add);
            }  
 *   <li>Leaf = {@link OpenSearchTableScan}, top = {@link OpenSearchAggregate}(PARTIAL):
                }  
                    if (annotationBackend.equals(operatorBackend)) {
    private static OpenSearchAggregate findBuriedPartialAggregate(RelNode fragment) {
     * (the producer describes its own output schema):  
                            "Native annotation [id={}]: backend [{}] matches operator",  
                            "No DelegatedPredicateSerializer for ["
            if (child instanceof OpenSearchAggregate agg  
        for (RelNode child : root.getInputs()) {  
            );
        if (node.getInputs().size() == 2) {
            return convertor.convertFragment(stripped);
        List<RelNode> strippedChildren = new ArrayList<>(node.getInputs().size());
            root.setInstructionHandlerFactory(backend.getInstructionHandlerFactory());
                    }
    /**
        return childrenChanged ? node.copy(node.getTraitSet(), strippedChildren) : node;
                changed = true;
            // backend's createPartitionedSink (driven by ShuffleProducerOutputState), not in  
            byte[] bytes = convertor.convertSchemaOnlyRead(stage.getStageId(), wrapper.getRowType());  
        // Store factory on coordinator-reduce stages (local execution, no serialization needed).  
            if (!(leftLeaf instanceof OpenSearchBroadcastScan)) {
                                function,  
                                return annotation.unwrap();  
import org.opensearch.analytics.spi.FieldStorageInfo;  
                    }
                RelNode walk = resolvedFragment;
        boolean childrenChanged = false;  
    }
import org.apache.calcite.rex.RexCall;
 *   <li>Leaf = {@link OpenSearchStageInputScan} (reduce stage):
    static final class IntraOperatorDelegationBytes {
     *       reducer can register the partition. Without this, the reducer runs decode over the
            convertStage(child, registry);
        }
     * <ul>
                        throw new IllegalStateException("Delegated expression must be a SqlFunction call: " + original);
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
                factory.createShardScanWithDelegationNode(treeShape, delegated.size(), requestsRowIds, logicalTableName)
    }  
     */  
                    String annotationBackend = annotation.getViableBackends().getFirst();  
        private List<DelegatedExpression> delegatedExpressions;
            child.getRowType(),
        }
            return strip(node.getInputs().getFirst(), delegationBytes);
                                delegatedExpressions = new ArrayList<>();  
            byte[] innerBytes = convertReduceNode(node.getInputs().getFirst(), convertor, false, delegationBytes);
import org.opensearch.analytics.planner.CapabilityRegistry;
    ) {
         */
            List<RelNode> strippedInputs = node.getInputs().stream().map(input -> strip(input, delegationBytes)).toList();  
            String logicalTableName = tableScan.getTable().getQualifiedName().getLast();
        // For binary inputs (Join), prefer the side whose subtree's leaf is NOT an
        if (node instanceof OpenSearchStageInputScan) {
                            }
 * <p>TODO: as shuffle joins/aggregates and delegation are added, introduce a  
                    return convertor.convertFragment(strip(node, delegationBytes));
    private static boolean containsPartialAggregate(RelNode root) {
                : FilterTreeShape.NO_DELEGATION;
        populatePostDecorationSchemas(stage, registry);  
        if (node instanceof OpenSearchExchangeReducer) {
        AnalyticsSearchBackendPlugin backend,
    }
                            LOGGER.debug(  
                            String peerBackend = ap.getPerformanceDelegationBackends().getFirst();
        // LM stage runs Java-only scatter/gather/stitch — no Substrait compute. Emit a
                boolean allChildrenAreExchangeReducer = !node.getInputs().isEmpty()  
            FragmentConvertor convertor = backend.getFragmentConvertor();
     * Walks down the fragment to find the leaf that drives stage classification — the
                // (b) the producer's wire format is opaque — the reducer can't decode its  
                byte[] current = convertor.attachPartialAggOnTop(strippedAgg, innerBytes);  
            // natively. The whole subtree — multi-input node + its branches + ERs +
                // boundary between the coordinator-side fragment and the data-node child stages.  
            List.of()  
                return LogicalFilter.create(strippedChildren.getFirst(), flattened);
                                throw new IllegalStateException("Performance-delegation candidate must wrap a RexCall: " + original);
            return;  
                for (int i = aboveAgg.size() - 1; i >= 0; i--) {
         * Maximal same-backend delegated subtrees are converted via the backend's  
                );
            // the tree it actually receives.  
     *       The child's {@code convertSchemaOnlyRead} returns a self-describing schema stub so the
            // path as reduce fragments. isthmus emits ReadRel.VirtualTable for the Values
import org.opensearch.analytics.planner.rel.OpenSearchShuffleExchange;  
                        );
        FilterTreeShape treeShape,  
                        finalAggInputs.add(strip(input.getInputs().getFirst(), delegationBytes));  
            return new AnnotationResolver() {
            node.getTraitSet(),
     * substrait-level stitching is needed.
        if (root instanceof OpenSearchAggregate agg
            return openSearchNode.stripAnnotations(strippedChildren, resolver);
            }
        }  
        LinkedList<InstructionNode> instructions = new LinkedList<>();
            // QTF narrows the Scan to [belowAnchorPhysicalFields..., __row_id__]; signal that to the
        // silently skipped, leaving its partition schema underived at the reduce sink.  
            RelDataType expected = inputScan.getRowType();  
            OpenSearchStageInputScan inputScan = null;  
     * a partial agg) reach convertFragment as soon as we see a node whose inputs
        if (node instanceof OpenSearchShuffleExchange) {  
            boolean requestsRowIds = tableScan.getRowType().getFieldNames().contains(OpenSearchLateMaterialization.ROW_ID_FIELD);
     * route through the shard-scan path on the right.
import org.apache.calcite.sql.SqlFunction;
        if (node instanceof OpenSearchRelNode openSearchNode) {
                    walk = walk.getInputs().getFirst();
        // postDecorationSchemaBytes on the child plans. The reduce sink consults this when
import org.apache.logging.log4j.Logger;  
     * this fragment is a shard-scan stage or a coordinator-reduce stage.
                return convertor.convertFragment(strip(node, delegationBytes));  
        IntraOperatorDelegationBytes delegationBytes  
            if (inputScan == null) continue;
            stage.setInstructionHandlerFactory(backend.getInstructionHandlerFactory());
     * <p>Multi-input nodes (Join, Union, Intersect, Minus) are converted as a single
            // Coord-only literal source — convert the whole fragment via the same isthmus
                    DelegatedPredicateSerializer serializer = registry.getBackend(annotationBackend)
     *
import org.opensearch.analytics.planner.rel.OpenSearchStageInputScan;
                operatorBackend,
                            ScalarFunction function = ScalarFunction.fromSqlOperatorWithFallback(originalCall.getOperator());
            converted.add(plan.withConvertedBytes(bytes, List.of()).withInstructions(List.of()));
        }
            String operatorBackend = operator.getViableBackends().getFirst();
                            delegatedExpressions.add(new DelegatedExpression(ap.getAnnotationId(), peerBackend, serialized));
    /**  
        for (StagePlan plan : stage.getPlanAlternatives()) {  
            // under TopK's Sort/Project wrapper.
    private static RelNode stripSingleOperator(RelNode node) {
        return findLeaf(node.getInputs().getFirst());  
/**
            return convertReduceFragment(resolvedFragment, convertor, delegationBytes);  
        for (Stage child : stage.getChildStages()) {
     */  
                    partialAgg.getCluster().getRexBuilder()  
        // Shard stages get the factory from the local backend plugin at the data node.
     * Stub Substrait for the LM stage: a {@code Read { named_table: "input-<lmStageId>";  
    }
                }
        );
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
                RexNode flattened = RelNodeUtils.deepFlatten(node.getCluster().getRexBuilder(), resolved);
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
    private static final Logger LOGGER = LogManager.getLogger(FragmentConversionDriver.class);
            Function<OperatorAnnotation, RexNode> resolver = delegationBytes.resolverFor(openSearchNode, node.getCluster().getRexBuilder());
            }
    }  
        RelNode leaf = findLeaf(resolvedFragment);  
     * delegated to {@link DelegatedPredicateCombiner}.  
        convertStage(dag.rootStage(), registry);
            // Derive filter tree shape BEFORE stripping (annotations must be intact). The deriver
                if (allChildrenAreExchangeReducer && node.getInputs().size() == 1) {
                public RexNode resolveTree(RexNode condition) {
                    continue;
        FragmentConvertor convertor,
        if (root.getExchangeSinkProvider() != null && !root.getPlanAlternatives().isEmpty()) {
            RelNode stripped = strip(resolvedFragment, delegationBytes);
                    RexNode original = annotation.unwrap();  
            // index) — the same single segment isthmus emits as the Substrait NamedTable. Pass it to
     * compute. We only need the schema-bearing Read so Stage 3's reduce sink derives a
            }  
 *  
 * The OpenSearch Contributors require contributions made to  
     * Reduce stage conversion: strips ExchangeReducer, converts the final agg fragment
            List<FieldStorageInfo> fieldStorage = operator.getOutputFieldStorage();
            LOGGER.debug(  
    }  
                // fragment so all branches end up in the same Substrait plan reading from their
                                peerBackend,
                            byte[] serialized = serializer.serialize(originalCall, fieldStorage);
            FragmentConvertor convertor = registry.getBackend(plan.backendId()).getFragmentConvertor();
                // final-aggregate operator; for multi-input shapes (Union) every branch is itself
            IntraOperatorDelegationBytes delegationBytes = new IntraOperatorDelegationBytes(registry);
    }
        List<DelegatedExpression> getResult() {  
                                ap.getAnnotationId(),
        // Root stage executes locally at coordinator — store factory for instruction dispatch.  
    ) {
    private static RelNode strip(RelNode node, IntraOperatorDelegationBytes delegationBytes) {  
                // Stub needed when (a) the schema decorator widened the partition rowType, or
import org.opensearch.analytics.spi.ScalarFunction;
    /** Finds an engine-native-merge PARTIAL aggregate buried under operators (not at fragment top). */  
        }  
                && agg.getAggCallList().stream().anyMatch(org.opensearch.analytics.spi.AggregateFunction::isEngineNativeMerge)) {
            }
                    }
        if (leaf instanceof OpenSearchValues) {  
            }  
    /**  
 *       then {@code attachFragmentOnTop} for any operators above it</li>  
            OpenSearchLateMaterialization wrapper = (OpenSearchLateMaterialization) plan.resolvedFragment();
            // leaf; DataFusion executes it locally without any input partitions.  
                        operatorBackend,
                    LOGGER.debug(
 *       {@code convertFragment} on the final agg (ExchangeReducer stripped),
        for (int i = 0; i < strippedChildren.size(); i++) {
import java.util.List;
                            if (!(original instanceof RexCall originalCall)) {
            if (!delegated.isEmpty()) {  
                            operatorBackend
                    aboveAgg.add(walk);
                    }  
        boolean finalAggConverted,
                }
        if (node.getInputs().isEmpty()) {
            && agg.getMode() == mode
                        .get(function);
        // OpenSearchBroadcastScan placeholder. With one driving leaf and one broadcast-scan  
     * instruction assembly, so a probe-side join with shape  
                        .delegatedPredicateSerializers()
import org.opensearch.analytics.planner.rel.OpenSearchValues;  
import org.opensearch.analytics.spi.WireFormat;  
            // Strip the hash-shuffle wrapper. Partitioning happens at runtime inside the
                    if (serializer == null) {  
            if (containsEngineNativeAggregate(child, mode)) return true;
     * {@code Join(OpenSearchBroadcastScan, OpenSearchTableScan)} (build = left) must still
                delegated.size(),
            // Identify the PARTIAL aggregate — either at the top of the fragment or buried  
                // convertedBytes for partition-schema derivation.
        stage.setPlanAlternatives(converted);  
                            annotation.getAnnotationId(),
                    return convertor.convertFragment(finalAggFragment);  
            return convertor.convertFragment(strip(node.getInputs().getFirst(), delegationBytes));
     * {@link FragmentConvertor#wireFormat()}. The schema-only Read uses the {@code expected}
            node = child;
            // A pure-reorder Project above an engine-native-merge FINAL is emitted like any other operator;
        }
            for (StagePlan plan : child.getPlanAlternatives()) {
     *       {@code OpenSearchStageInputScan} placeholder; the reducer needs that, not the  
        }
        }  
     * <p>Producer wire-format is asked of the child's convertor via  
                if (schemaMismatch == false && selfDescribing) {
        }
                boolean allChildrenAreStageInputScan = !node.getInputs().isEmpty()
            converted.add(plan.withConvertedBytes(bytes, delegated).withInstructions(instructions));
                        "Delegated annotation [id={}]: {} from operator [{}] to [{}], serialized {} bytes",
 * <p>Dispatch logic for PR2 (pure shard-scan path):  
        }
                    List<RelNode> finalAggInputs = new ArrayList<>(node.getInputs().size());  
        if (leaf instanceof OpenSearchTableScan) {
        throw new IllegalStateException(
     * convert it — the LM stage runs Java-only scatter/gather/stitch and emits no Substrait  
 *       then {@code attachPartialAggOnTop}</li>
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
        // leaf per child stage. findNode walks only the first-input chain, so match each child
                    }
        IntraOperatorDelegationBytes delegationBytes
     * have multiple {@code StageInputScan} leaves and this needs a multi-leaf walker.  
    /**
            convertLateMaterializationStage(stage, registry);
                        return annotation.unwrap();
            // Direct StageInputScan boundary — happens after the hash-shuffle rewriter inserts
        if (leaf instanceof OpenSearchTableScan tableScan) {
                                + "]. CapabilityRegistry should have rejected this at startup."  
                            }  
                FragmentConvertor convertor = registry.getBackend(plan.backendId()).getFragmentConvertor();  
            byte[] bytes = convert(plan.resolvedFragment(), convertor, delegationBytes);
            return node; // kept for schema inference at probe stage; backend rewriter maps to NamedScan
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
     * {@code resolvedFragment} IS the wrapper (DAGBuilder builds it that way), but we don't
                                .delegatedPredicateSerializers()  
                }
            RelNode child = node.getInputs().getFirst();
     */
            List<OpenSearchFilter> filters = RelNodeUtils.findAllNodes(plan.resolvedFragment(), OpenSearchFilter.class);
    }  
                // respective input partitions.
     */  
 *
import org.apache.calcite.rel.logical.LogicalFilter;
                return agg;  
                            DelegatedPredicateSerializer serializer = registry.getBackend(peerBackend)
     */  
            }
                @Override
import org.opensearch.analytics.spi.FilterTreeShape;
            return node; // kept for schema inference at reduce stage
     *
                        // Skip the ER, keep StageInputScan below it as the leaf for schema inference.
    private static boolean containsEngineNativeAggregate(RelNode root, AggregateMode mode) {  
            return strip(node.getInputs().getFirst(), delegationBytes);
     *   <li><b>Schema decoration</b> — a partition decorator (e.g. {@code OrdinalAppendingSink})  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        }
        // against ALL input-scan leaves; otherwise every child but the one on the first chain is
                @Override
        if (fragment instanceof OpenSearchAggregate) return null;
                                + annotationBackend
     * subtree via convertFragment: isthmus handles all of them natively, and
            // StageInputScans — serializes in one convertFragment pass. The convertor's
                registry,
        if (stage.getExecutionType() == StageExecutionType.LATE_MATERIALIZATION) {
                            );
    }  
     * (Sort, Project, etc.) via attachFragmentOnTop.
        if (node instanceof OpenSearchExchangeReducer) {
        throw new IllegalStateException("Unexpected reduce stage node: " + node.getClass().getSimpleName());
     * whenever the parent reduce sink can't safely decode the child's {@code convertedBytes} as
     * <p>For binary-input nodes, prefers the input subtree that contains a real driving leaf  
            // Substrait — the convertor never needs to lower the shuffle node itself.
 * dispatch logic rather than growing this class with more {@code instanceof} checks.
            List.of(),
            // backend so it picks the row-id-aware table provider regardless of delegation.  
import org.apache.calcite.rex.RexBuilder;
        }
            "Unknown leaf type [" + leaf.getClass().getSimpleName() + "]. " + "Add a FragmentConversionStrategy for this leaf type."  
                            RexNode original = ap.unwrap();  
        }
     * Strips a single operator with a placeholder child for use with {@code attachFragmentOnTop}.
     * Dispatches conversion based on the fragment's leaf and top node types.  
            // mirrors the combiner's post-combine shape so the data node's classification matches
    /**
                if (allChildrenAreStageInputScan) {
     * lets the whole gathered subtree serialize in one pass. No post-conversion
    }
            // a worker stage and the consumer fragment becomes Sort/Project/StageInputScan
            FilterTreeShape treeShape = filter != null  
                factory.createShardScanNode(requestsRowIds, logicalTableName).ifPresent(instructions::add);
     * no delegated predicates — avoids the getOutputFieldStorage() call that would fail on
     * partition schema via the standard producerPlanBytes path.
import org.opensearch.analytics.spi.DelegatedExpression;  
            return delegatedExpressions != null ? delegatedExpressions : List.of();
                boolean selfDescribing = convertor.wireFormat() == WireFormat.SELF_DESCRIBING;
        if (root instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.PARTIAL) return true;
 * SPDX-License-Identifier: Apache-2.0
        StagePlan plan,
                        serialized.length
        }
    /**
     *       producer's narrower natural schema.</li>
        RelNode child = node.getInputs().getFirst();
 * Strips annotations from each resolved fragment and dispatches to the backend's  
        // After children are converted, surface any decorator-induced schema delta as  
                }
     * Accumulates serialized delegated query bytes during fragment conversion.
            return findLeaf(node.getInputs().get(1));
                    break;
                plan.backendId(),
     */
        RelNode node = fragment;  
     * the wire format it expects. Two distinct triggers, both resolved by the CHILD's convertor
                    RelNode finalAggFragment = openSearchNode.stripAnnotations(finalAggInputs, resolver);
                "Stage [{}] converted: treeShape={}, delegatedExpressions={}{}",
                rexBuilder,
 *
                                LOGGER.debug(  
    private static void convertLateMaterializationStage(Stage stage, CapabilityRegistry registry) {
            }  
        Stage root = dag.rootStage();
     * {@link StagePlan#convertedBytes()} on each plan.
            -1,  
            if (partialAgg != null) {
import org.apache.calcite.rel.type.RelDataType;  
     */  
        // leaf the broadcast side is the runtime-injected one and must not classify the stage.
 */  
import org.opensearch.analytics.planner.rel.AnnotationResolver;
            }  
                                serialized.length  
        return instructions;  
    private static RelNode findLeaf(RelNode node) {
            // Pushdown+merge rules leave delegated annotations only in the bottommost (WHERE) filter;
            AnalyticsSearchBackendPlugin backend = registry.getBackend(converted.getFirst().backendId());  
                while (walk != partialAgg) {  
            return convertor.convertFragment(strip(node.getInputs().getFirst(), delegationBytes));
                delegated.isEmpty() ? "" : " [ids=" + delegated.stream().map(d -> String.valueOf(d.getAnnotationId())).toList() + "]"
                            if (delegatedExpressions == null) {
 * compatible open source license.
        List<OpenSearchStageInputScan> inputScans = RelNodeUtils.findNodes(stage.getFragment(), OpenSearchStageInputScan.class);
        while (node.getInputs().size() == 1) {
        }  
     * classifying each node as delegated (targets a non-operator backend like Lucene) or
                // so isthmus can serialize it.
        }  
            List<DelegatedExpression> delegated = delegationBytes.getResult();
                // Layered conversion: convert scan below → attachPartialAggOnTop → attach  
        }
            Function<OperatorAnnotation, RexNode> resolver = delegationBytes.resolverFor(openSearchNode, node.getCluster().getRexBuilder());  
            // partitioning is enforced at runtime by the producer-side sink; the consumer
        // A multi-input parent fragment (e.g. a Join or Union) has one OpenSearchStageInputScan  
                // StageInputScan leaf sits directly under this op. Convert the whole node as one
        // registering the partition so the catalog binding matches what the decorator delivers.
    /** Recursively strips annotations bottom-up. Keeps OpenSearchStageInputScan and
                        );  
            return true;
 *       {@code convertFragment} on everything below partial agg,  
            AnalyticsSearchBackendPlugin backend = registry.getBackend(root.getPlanAlternatives().getFirst().backendId());  
            boolean schemaMismatch = produced.getFieldCount() != expected.getFieldCount() || produced.equals(expected) == false;
     *
            // not findNode's topmost (HAVING → NO_DELEGATION → collector skipped → over-count).  
     * QTF today (linear fragments). When QTF extends to Joins/Unions, multi-input fragments will
            }
        RelNode resolvedFragment = plan.resolvedFragment();
}
            if (resolvedFragment instanceof OpenSearchAggregate agg  
     *
    private static void populatePostDecorationSchemas(Stage stage, CapabilityRegistry registry) {
            factory.createFinalAggregateNode().ifPresent(instructions::add);
    }
    public static void convertAll(QueryDAG dag, CapabilityRegistry registry) {
            for (OpenSearchStageInputScan candidate : inputScans) {
import org.opensearch.analytics.spi.FragmentConvertor;
    }  
                    ScalarFunction function = ScalarFunction.fromSqlFunction(sqlFunction);
         * {@code DelegatedSubtreeConvertor} into one DelegatedExpression each.
                    if (!(original instanceof RexCall originalCall) || !(originalCall.getOperator() instanceof SqlFunction sqlFunction)) {
    private static List<InstructionNode> assembleInstructions(  
        for (RelNode child : root.getInputs()) {  
            if (delegatedExpressions == null) delegatedExpressions = new ArrayList<>();  
            OpenSearchFilter filter = filters.isEmpty() ? null : filters.getLast();
                        function,
                && agg.getAggCallList().stream().anyMatch(org.opensearch.analytics.spi.AggregateFunction::isEngineNativeMerge)) {
import org.apache.calcite.rex.RexNode;  
     * over one whose first leaf is an {@link OpenSearchBroadcastScan} placeholder. The broadcast
     * the placeholder.
            // Assemble instruction list
            // Strip ShuffleExchange — same shape as ExchangeReducer at this layer. The
    private static byte[] convertReduceNode(
        FragmentInstructionHandlerFactory factory = backend.getInstructionHandlerFactory();  
                                + "] on backend ["
                return leftLeaf;
            // (no intermediate ExchangeReducer wrapper). Treat the leaf itself as the boundary;  
        }  
    private static byte[] convertReduceFragment(RelNode node, FragmentConvertor convertor, IntraOperatorDelegationBytes delegationBytes) {
            DelegatedPredicateCombiner classifier = new DelegatedPredicateCombiner(
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
                // fragment; the convertor's rewriteStageInputScans turns the leaf into a NamedScan  
        for (StagePlan plan : stage.getPlanAlternatives()) {  
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
                partialAgg = agg;  
            // backend reverse-engineering it from the plan bytes.  
            // Multi-input node (Join, Union, Intersect, Minus): isthmus handles all of them  
                byte[] postDecorationBytes = convertor.convertSchemaOnlyRead(child.getStageId(), expected);  
                        // but a peer can be opportunistically consulted at runtime.  
     *       opaque bytes and fails.</li>  
            if (changed) child.setPlanAlternatives(updated);
                    return ((DelegatedPredicateCombiner.Resolved) result).node();
                }  
            // a HAVING stays in a separate un-delegated filter above the Aggregate. Pick the WHERE,
                }  
                    && node.getInputs().stream().allMatch(input -> input instanceof OpenSearchExchangeReducer);
/*  
    }
import java.util.LinkedList;  
            );  
     * OpenSearchBroadcastScan as-is (backend-side rewriter maps them to NamedScans). */
                // any operators above the aggregate (zero iterations when agg is the top).
                RexNode resolved = ar.resolveTree(filter.getCondition());  
                    delegatedExpressions.add(new DelegatedExpression(annotation.getAnnotationId(), annotationBackend, serialized));  
            if (strippedChildren.get(i) != node.getInputs().get(i)) {
                if (candidate.getChildStageId() == child.getStageId()) {
 * @opensearch.internal
public class FragmentConversionDriver {  
 *       {@code convertFragment} on the full fragment</li>  
                    if (result instanceof DelegatedPredicateCombiner.Delegated d) {
    private FragmentConversionDriver() {}
                        // Performance-delegation candidate: dual-viable predicate kept on the operator's backend,
     */
            // fragment converts as if the input arrived as plain StageInputScan named-input.  
    // TODO: consolidate with isAggregatePath / findBuriedPartialAggregate into a shared utility  
            };  
        }
                            }
                }
        return false;  
                break;
            // Single-input operator above the final-fragment boundary — convert child first, then attach.  
        );
                // Combine delegated predicates in a single pass, then strip with simple unwrapper
import org.opensearch.analytics.spi.InstructionNode;
                treeShape,  
        if (stage.getExchangeSinkProvider() != null && !converted.isEmpty()) {
        List<StagePlan> converted = new ArrayList<>(stage.getPlanAlternatives().size());
            // un-reordered data, corrupting the final column order.  
        }
                && agg.getMode() == AggregateMode.PARTIAL
            } else {  
        if (node instanceof OpenSearchStageInputScan) {  
 * </ul>
import java.util.function.Function;
                                    peerBackend,  
            strippedChildren.add(strip(input, delegationBytes));  
import org.apache.calcite.rel.RelNode;
        }
                RelNode strippedAgg = partialAgg.stripAnnotations(strippedInputs, resolver);
     * </ul>
        }
            OpenSearchAggregate partialAgg = null;
    private static void convertStage(Stage stage, CapabilityRegistry registry) {
            if (node.getInputs().size() >= 2) {
        RelNode leaf = findLeaf(resolvedFragment);  
 * {@link FragmentConvertor} using composable calls — backends never traverse the plan.
            // dropping it would strand operators above it (e.g. Sort) with the post-reorder schema over
 * <ul>
                            return DelegationPossibleFunction.makeCall(rexBuilder, originalCall, ap.getAnnotationId());  
        if (leaf instanceof OpenSearchStageInputScan) {
            } else {
            node.getCluster(),
                                + function  
     * {@link OpenSearchTableScan} or {@link OpenSearchStageInputScan} that determines whether  
        // can derive the partition schema via the standard producerPlanBytes path.  
                                    operatorBackend
            RelDataType produced = child.getFragment().getRowType();
                        LOGGER.debug(
     * <p>TODO: Uses {@link RelNodeUtils#findNode} which only walks the first-input chain. Fine for
            return convertor.convertFragment(stripped);
        return null;
 *   <li>Leaf = {@link OpenSearchTableScan}, top = anything else:
                        annotationBackend,  
     * Emits a schema-only Read stub onto each child plan's {@code postDecorationSchemaBytes}  
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
 *
                    }  
        private final CapabilityRegistry registry;  
        for (RelNode input : node.getInputs()) {
        for (Stage child : stage.getChildStages()) {  
                List<RelNode> aboveAgg = new ArrayList<>();
            RelNode strippedNode = openSearchNode.stripAnnotations(strippedInputs, resolver);
 * Drives fragment conversion for all {@link StagePlan} alternatives in a {@link QueryDAG}.
    /**
            return convertor.attachFragmentOnTop(strippedNode, innerBytes);
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
                                );
        Function<OperatorAnnotation, RexNode> resolverFor(OpenSearchRelNode operator, RexBuilder rexBuilder) {  
package org.opensearch.analytics.planner.dag;
import java.util.ArrayList;
import org.opensearch.analytics.planner.rel.AggregateMode;  
     *  
            this.registry = registry;
            if (containsPartialAggregate(resolvedFragment)) {  
import org.apache.logging.log4j.LogManager;
        }
     * scan is a runtime-injected memtable input — it never drives stage targeting or
                    );
            // ancestors above this boundary attach via attachFragmentOnTop on the way back up.
            RelNode stripped = strip(resolvedFragment, delegationBytes);
            if (node instanceof OpenSearchFilter filter && resolver instanceof AnnotationResolver ar) {
     *
                        }
        IntraOperatorDelegationBytes(CapabilityRegistry registry) {  
        RelNode node,  
            // any post-conversion substrait-level stitching.
                        annotation.getAnnotationId(),  
            && agg.getAggCallList().stream().anyMatch(org.opensearch.analytics.spi.AggregateFunction::isEngineNativeMerge)) {  
            // The leaf's qualified name is the planner's logical table name (alias / index pattern /  
                        if (annotation instanceof AnnotatedPredicate ap && !ap.getPerformanceDelegationBackends().isEmpty()) {
                    return annotation.makePlaceholder(rexBuilder);
                    if (delegatedExpressions == null) {  
            // the data node so it registers the scanned shard's table under this name, instead of the
        }
                updated.add(plan.withPostDecorationSchemaBytes(postDecorationBytes));
                List<RelNode> strippedInputs = partialAgg.getInputs().stream().map(input -> strip(input, delegationBytes)).toList();
            boolean changed = false;
                                operatorBackend,
                    && node.getInputs().stream().allMatch(input -> input instanceof OpenSearchStageInputScan);  
 */
        return convertReduceNode(node, convertor, false, delegationBytes);
     * <p>Single-input ancestors of a single gathered subtree (Sort/Project/Aggregate over  
                    updated.add(plan);  
        // stub Read carrying the wrapper's output schema so Stage 3's parent reduce sink
     *       widens the child's produced rowType before it reaches the partition boundary. The
                    DelegatedPredicateCombiner.Classified result = classifier.classify(condition, this::apply);  
    }
                                    function,
                public RexNode apply(OperatorAnnotation annotation) {
                            if (serializer == null) {
import org.opensearch.analytics.planner.RelNodeUtils;
        OpenSearchStageInputScan placeholder = new OpenSearchStageInputScan(  
            if (containsPartialAggregate(child)) return true;
        }
                    .ifPresent(instructions::add);
     *       a custom wire format from {@code convertFragment} the reducer can't decode generically.  
                    for (RelNode input : node.getInputs()) {
        stage.setPlanAlternatives(converted);
        if (node instanceof OpenSearchShuffleExchange) {
                return current;
     *   <li><b>Opaque-wire-format producer</b> — the child plan's backend (Lucene today) emits
                    inputScan = candidate;  
            if (!finalAggConverted) {
    }
        }
                childrenChanged = true;  
     * Uses direct {@code stripAnnotations} (no delegation resolver) since TopK operators have  
                                "Performance-delegated annotation [id={}]: {} kept on operator [{}], wrapped for peer [{}], serialized {} bytes",
                Function<OperatorAnnotation, RexNode> resolver = delegationBytes.resolverFor(
            return convertor.convertFragment(node);  
        }  
                    partialAgg,
        }  
                // First OpenSearchRelNode whose ALL inputs are ExchangeReducers is treated as the
        return false;  
    /**
     * <p>The resolver performs a single bottom-up traversal of the filter condition tree,  
            List<StagePlan> updated = new ArrayList<>(child.getPlanAlternatives().size());  
     *       parent declares the wider {@code expected} rowType on its
        }  
     * native (evaluated by the driving backend). Tree-walking and combining logic is
                delegatedExpressions  
