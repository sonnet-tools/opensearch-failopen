import java.util.List;
        }  
        CapabilityRegistry registry = context.getCapabilityRegistry();  
 *
/*  
                callViable = new ArrayList<>(perFieldBackends);
import java.util.Set;  
        CapabilityRegistry registry = context.getCapabilityRegistry();
                if (!registry.canHandle(candidateName, annotation.getViableBackends(), DelegationType.AGGREGATE)) {
import java.util.Map;
import org.opensearch.analytics.spi.FieldType;
    private List<String> resolveViableBackendsForCall(AggregateCall aggCall, List<FieldStorageInfo> childFieldStorageInfos) {
import org.opensearch.analytics.spi.DelegationType;  
 *  
 * {@code getOperandType(0)} (PPL's {@code ARG0_ARRAY} double-wraps).
        List<String> callViable = null;
                FieldStorageInfo peek = childFieldStorageInfos.get(fieldIndex);
 * {@link OpenSearchAggregateSplitRule} which fires when Volcano detects
            }  
 * <p>Records each {@link AggregateCall}'s viable backends as an
            Set<String> perFieldBackends = new HashSet<>();
            // backend viability check.  
 * this file be licensed under the Apache-2.0 license or a
            List<String> funcNames = aggCalls.stream().map(aggCall -> aggCall.getAggregation().getName()).toList();  
import java.util.LinkedHashMap;  
        RelTraitSet aggregateTraits = child.getTraitSet();  
            }
                aggCalls,  
            return new ArrayList<>(childViableBackends);  
            // Skip metadata-only literal arg columns whose FieldType is null (e.g. SYMBOL —
import org.opensearch.analytics.planner.RelNodeUtils;
 */
            List<String> callViable = resolveViableBackendsForCall(aggCall, childFieldStorage);
                aggregateTraits,
        super(operand(Aggregate.class, operand(RelNode.class, any())), "OpenSearchAggregateRule");
        this.context = context;
import org.apache.calcite.rel.core.AggregateCall;  
        }  
    public void onMatch(RelOptRuleCall call) {  
        if (aggregate instanceof OpenSearchAggregate) {
                viable.add(candidateName);
import java.util.HashSet;
        }  
 * avoids contaminating Calcite's {@code AggCallBinding.preOperands}, which would
            }
 * {@link AggregateCallAnnotation} in {@link OpenSearchAggregate}'s side-map keyed  
 */  
        // Compute operator-level viable backends: must be viable for child AND handle agg calls
        List<String> viableBackends = computeAggregateViableBackends(callAnnotations, childViableBackends);  
            func = AggregateFunction.fromNameOrError(aggCall.getAggregation().getName());
            for (AggregateCallAnnotation annotation : callAnnotations.values()) {  
import org.apache.calcite.plan.RelOptRule;
            AggregateCall aggCall = aggCalls.get(i);  
                aggregate.getGroupSet(),
    ) {
                callAnnotations  
        List<String> childViableBackends = openSearchChild.getViableBackends();  
 * The OpenSearch Contributors require contributions made to  
            if (fieldIndex < childFieldStorageInfos.size()) {
        return callViable;
                callViable.retainAll(perFieldBackends);  
import org.opensearch.analytics.planner.PlannerContext;
        Map<Integer, AggregateCallAnnotation> callAnnotations = new LinkedHashMap<>(aggCalls.size());
                // restrict this to ARROW_BATCH delegation acceptors only.
    }
import org.apache.calcite.rel.core.Aggregate;
                perFieldBackends.addAll(registry.aggregateBackendsAnyFormat(func, fieldType));  
                // TODO: once DelegationType split (NATIVE_INDEX vs ARROW_BATCH) is designed,  
                    continue;
 * a distribution trait mismatch (RANDOM input needing SINGLETON output).
                perFieldBackends.addAll(registry.aggregateBackendsForField(func, storageInfo));  
            // PPL's percentile_approx / median type-flag). Only data-field args need a
import org.opensearch.analytics.spi.AggregateFunction;
public class OpenSearchAggregateRule extends RelOptRule {  
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchAggregateRule.class);
 *
            throw new UnsupportedFunctionException(funcNames.toString(), "as aggregate functions in combination");
        if (func == null) {
            if (!registry.aggregateCapableBackends().contains(candidateName)) {
    }  
                throw new UnsupportedFunctionException(aggCall.getAggregation().getName(), "as an aggregate function");  
import org.opensearch.analytics.planner.rel.AggregateMode;
        AggregateFunction func = AggregateFunction.fromSqlKind(aggCall.getAggregation().getKind());  
    public OpenSearchAggregateRule(PlannerContext context) {  
                    }
        List<String> viable = new ArrayList<>();
        }
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
import org.opensearch.analytics.planner.CapabilityRegistry;  
 * compatible open source license.
            callAnnotations.put(i, new AggregateCallAnnotation(callViable, context.nextAnnotationId()));
                aggregate.getCluster(),
import org.opensearch.analytics.planner.UnsupportedFunctionException;  
                        perFieldBackends.add(name);
        for (int fieldIndex : aggCall.getArgList()) {  
/**
                continue;
        call.transformTo(
            } else {
                // Delegation targets: backends that declared acceptedDelegations(AGGREGATE) and
            return;
            }
            if (canHandleAll) {  
    @Override
                    if (registry.delegationAcceptors(DelegationType.AGGREGATE).contains(name)) {  
        if (callAnnotations.isEmpty()) {
        return viable;
import org.apache.calcite.plan.RelOptRuleCall;
                    canHandleAll = false;
        List<AggregateCall> aggCalls = aggregate.getAggCallList();  
import org.apache.logging.log4j.LogManager;
                viableBackends,
            }  
                aggregate.getGroupSets(),
        RelNode child = call.rel(1);
            return new ArrayList<>(registry.aggregateCapableBackends());
                if (peek.isDerived() && peek.getFieldType() == null) {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
        for (int i = 0; i < aggCalls.size(); i++) {
import org.apache.logging.log4j.Logger;
 * <p>Computes operator-level viable backends as the intersection of per-call viable  
        );
            boolean canHandleAll = true;
import org.apache.calcite.rel.RelNode;
            new OpenSearchAggregate(  
                AggregateMode.SINGLE,
 * @opensearch.internal
        if (aggCall.getArgList().isEmpty()) {
            )
        Map<Integer, AggregateCallAnnotation> callAnnotations,
import java.util.ArrayList;
            if (storageInfo.isDerived()) {
 * Converts {@link Aggregate} → {@link OpenSearchAggregate}.  
            }
    }
            FieldType fieldType = storageInfo.getFieldType();
            if (callViable == null) {  
                for (String name : registry.aggregateBackendsAnyFormat(func, fieldType)) {
package org.opensearch.analytics.planner.rules;
        }  
                // Format-aware: backends that can read this field's doc values and aggregate
                }
 * by call index — NOT in {@code aggCall.rexList}. Storing annotations out-of-band
        List<String> childViableBackends  
import org.apache.calcite.plan.RelTraitSet;  
            } else {
                RelNodeUtils.unwrapHep(aggregate.getInput()),  
            FieldStorageInfo storageInfo = FieldStorageInfo.resolve(childFieldStorageInfos, fieldIndex);
 * <p>The split into PARTIAL + FINAL is NOT done here. It happens via  
            }
import org.opensearch.analytics.planner.rel.AggregateCallAnnotation;
                }
                // can aggregate this function — they receive data via Arrow batch, not field storage.
    private List<String> computeAggregateViableBackends(
 * backends.
    }  
        List<FieldStorageInfo> childFieldStorage = openSearchChild.getOutputFieldStorage();
 *
        }  
                    break;  
        }
 *
 * corrupt {@code inferReturnType} for functions whose return type depends on  
        }
            throw new IllegalStateException("Aggregate rule encountered unmarked child [" + child.getClass().getSimpleName() + "]");  
        }
            if (callViable.isEmpty()) {
                }  
        Aggregate aggregate = call.rel(0);
}  
        LOGGER.debug("Aggregate viable backends: {} (child viable: {})", viableBackends, childViableBackends);
import org.opensearch.analytics.spi.FieldStorageInfo;
        for (String candidateName : childViableBackends) {  
    private final PlannerContext context;
        if (!(child instanceof OpenSearchRelNode openSearchChild)) {
        if (viableBackends.isEmpty()) {
