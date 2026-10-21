            }
            if (canHandleAll) {
            callAnnotations.put(i, new AggregateCallAnnotation(callViable, context.nextAnnotationId()));
            // Skip metadata-only literal arg columns whose FieldType is null (e.g. SYMBOL —
        // Compute operator-level viable backends: must be viable for child AND handle agg calls
            // backend viability check.
                perFieldBackends.addAll(registry.aggregateBackendsAnyFormat(func, fieldType));
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
        }
 * {@link OpenSearchAggregateSplitRule} which fires when Volcano detects
        }
                aggCalls,
        for (String candidateName : childViableBackends) {
 * this file be licensed under the Apache-2.0 license or a
        if (aggCall.getArgList().isEmpty()) {
            } else {
import org.opensearch.analytics.planner.PlannerContext;
        call.transformTo(
import java.util.LinkedHashMap;
                aggregate.getGroupSet(),
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        List<FieldStorageInfo> childFieldStorage = openSearchChild.getOutputFieldStorage();
        return viable;
    private final PlannerContext context;
        }
                // Delegation targets: backends that declared acceptedDelegations(AGGREGATE) and
                if (!registry.canHandle(candidateName, annotation.getViableBackends(), DelegationType.AGGREGATE)) {
        List<String> childViableBackends
        this.context = context;
                callViable = new ArrayList<>(perFieldBackends);
import org.apache.calcite.plan.RelOptRule;
                }
import org.apache.calcite.rel.core.Aggregate;
                callAnnotations
import java.util.HashSet;
            List<String> funcNames = aggCalls.stream().map(aggCall -> aggCall.getAggregation().getName()).toList();
            )
    }
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
                // TODO: once DelegationType split (NATIVE_INDEX vs ARROW_BATCH) is designed,
            if (callViable == null) {
            } else {
                // restrict this to ARROW_BATCH delegation acceptors only.
                perFieldBackends.addAll(registry.aggregateBackendsForField(func, storageInfo));
            func = AggregateFunction.fromNameOrError(aggCall.getAggregation().getName());
            List<String> callViable = resolveViableBackendsForCall(aggCall, childFieldStorage);
 * <p>Records each {@link AggregateCall}'s viable backends as an
            }
 * corrupt {@code inferReturnType} for functions whose return type depends on
import org.apache.logging.log4j.LogManager;
 *
                FieldStorageInfo peek = childFieldStorageInfos.get(fieldIndex);
        if (callAnnotations.isEmpty()) {
 * {@code getOperandType(0)} (PPL's {@code ARG0_ARRAY} double-wraps).
            Set<String> perFieldBackends = new HashSet<>();
import org.opensearch.analytics.planner.rel.AggregateCallAnnotation;
        if (!(child instanceof OpenSearchRelNode openSearchChild)) {
            throw new UnsupportedFunctionException(funcNames.toString(), "as aggregate functions in combination");
 * {@link AggregateCallAnnotation} in {@link OpenSearchAggregate}'s side-map keyed
import org.opensearch.analytics.planner.UnsupportedFunctionException;
                RelNodeUtils.unwrapHep(aggregate.getInput()),
 */
import org.apache.calcite.rel.core.AggregateCall;
                        perFieldBackends.add(name);
import org.opensearch.analytics.spi.FieldType;
        }
                continue;
        AggregateFunction func = AggregateFunction.fromSqlKind(aggCall.getAggregation().getKind());
/**
 * The OpenSearch Contributors require contributions made to
        RelTraitSet aggregateTraits = child.getTraitSet();
 * Converts {@link Aggregate} → {@link OpenSearchAggregate}.
        LOGGER.debug("Aggregate viable backends: {} (child viable: {})", viableBackends, childViableBackends);
            new OpenSearchAggregate(
        Map<Integer, AggregateCallAnnotation> callAnnotations = new LinkedHashMap<>(aggCalls.size());
        for (int fieldIndex : aggCall.getArgList()) {
 *
        return callViable;
        List<String> callViable = null;
 * @opensearch.internal
package org.opensearch.analytics.planner.rules;
        CapabilityRegistry registry = context.getCapabilityRegistry();
import org.opensearch.analytics.spi.AggregateFunction;
                for (String name : registry.aggregateBackendsAnyFormat(func, fieldType)) {
                throw new UnsupportedFunctionException(aggCall.getAggregation().getName(), "as an aggregate function");
import org.apache.calcite.plan.RelOptRuleCall;
}
                // can aggregate this function — they receive data via Arrow batch, not field storage.
import org.opensearch.analytics.spi.DelegationType;
            FieldType fieldType = storageInfo.getFieldType();
            if (storageInfo.isDerived()) {
            }
        }
 * avoids contaminating Calcite's {@code AggCallBinding.preOperands}, which would
        if (viableBackends.isEmpty()) {
            if (callViable.isEmpty()) {
            return new ArrayList<>(registry.aggregateCapableBackends());
import java.util.ArrayList;
                callViable.retainAll(perFieldBackends);
                    if (registry.delegationAcceptors(DelegationType.AGGREGATE).contains(name)) {
 * <p>The split into PARTIAL + FINAL is NOT done here. It happens via
        );
public class OpenSearchAggregateRule extends RelOptRule {
    }
            }
            FieldStorageInfo storageInfo = FieldStorageInfo.resolve(childFieldStorageInfos, fieldIndex);
 * backends.
            return new ArrayList<>(childViableBackends);
                AggregateMode.SINGLE,
    public void onMatch(RelOptRuleCall call) {
import java.util.List;
 *
            }
    public OpenSearchAggregateRule(PlannerContext context) {
        super(operand(Aggregate.class, operand(RelNode.class, any())), "OpenSearchAggregateRule");
 */
                if (peek.isDerived() && peek.getFieldType() == null) {
        Map<Integer, AggregateCallAnnotation> callAnnotations,
    private List<String> resolveViableBackendsForCall(AggregateCall aggCall, List<FieldStorageInfo> childFieldStorageInfos) {
                }
        }
                    }
    }
                }
                    break;
            AggregateCall aggCall = aggCalls.get(i);
import org.apache.calcite.plan.RelTraitSet;
import org.opensearch.analytics.planner.CapabilityRegistry;
    }
 * <p>Computes operator-level viable backends as the intersection of per-call viable
        List<AggregateCall> aggCalls = aggregate.getAggCallList();
        if (func == null) {
    private List<String> computeAggregateViableBackends(
            }
        List<String> viableBackends = computeAggregateViableBackends(callAnnotations, childViableBackends);
import org.apache.calcite.rel.RelNode;
import org.opensearch.analytics.planner.RelNodeUtils;
    private static final Logger LOGGER = LogManager.getLogger(OpenSearchAggregateRule.class);
                aggregateTraits,
        }
        if (aggregate instanceof OpenSearchAggregate) {
/*
                    canHandleAll = false;
import org.opensearch.analytics.planner.rel.AggregateMode;
            boolean canHandleAll = true;
            if (!registry.aggregateCapableBackends().contains(candidateName)) {
                    continue;
            throw new IllegalStateException("Aggregate rule encountered unmarked child [" + child.getClass().getSimpleName() + "]");
        }
 * compatible open source license.
 * by call index — NOT in {@code aggCall.rexList}. Storing annotations out-of-band
        List<String> viable = new ArrayList<>();
import java.util.Map;
 * a distribution trait mismatch (RANDOM input needing SINGLETON output).
                // Format-aware: backends that can read this field's doc values and aggregate
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
        for (int i = 0; i < aggCalls.size(); i++) {
        Aggregate aggregate = call.rel(0);
            }
        List<String> childViableBackends = openSearchChild.getViableBackends();
            if (fieldIndex < childFieldStorageInfos.size()) {
 *
        RelNode child = call.rel(1);
                aggregate.getCluster(),
import org.apache.logging.log4j.Logger;
        CapabilityRegistry registry = context.getCapabilityRegistry();
    ) {
                aggregate.getGroupSets(),
            for (AggregateCallAnnotation annotation : callAnnotations.values()) {
                viableBackends,
                viable.add(candidateName);
 *
            return;
    @Override
            // PPL's percentile_approx / median type-flag). Only data-field args need a
