            }
import org.apache.calcite.rel.RelNode;
        List<String> parentBackends = node instanceof OpenSearchRelNode osNode
        // TODO: delegation will change this — when annotations have viable backends that differ
 * <p>Walks each stage's marked fragment bottom-up. For each operator, generates
            if (annotation.getViableBackends().contains(targetBackend)) {
    }
        if (childAlternativeSets.size() == 1) {
            return results;
    ) {
        String backend,
    private static List<Resolved> resolveOperator(RelNode node, List<RelNode> children, String childBackend) {
    }
        return resolved;
                results.add(new Resolved(backend, openSearchNode.copyResolved(backend, children, List.of())));
        }
        OpenSearchRelNode node,
    }
import java.util.ArrayList;
        List<List<Resolved>> childAlternativeSets = new ArrayList<>();
        List<RelNode> children,
 * compatible open source license.
 *
    private static List<Resolved> resolve(RelNode node, CapabilityRegistry registry) {
        for (String backend : openSearchNode.getViableBackends()) {
            for (Resolved childAlt : childAlternativeSets.getFirst()) {
                resolved.add(annotation.narrowTo(targetBackend));
        // child's first alt — which could be a backend the parent can't run (e.g. lucene under a
        for (RelNode input : node.getInputs()) {
/**
            return List.of(new Resolved(childBackend != null ? childBackend : "", result));
 * <p>TODO: gate plan forking based on index stats (size, shard count, doc count).
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
                continue;
 * SPDX-License-Identifier: Apache-2.0
        List<OperatorAnnotation> annotations
    private static void forkStage(Stage stage, CapabilityRegistry registry) {
        }
    }
            // Non-OpenSearch node (e.g. StageInputScan infrastructure) — pass through.
        }
        }
 * The OpenSearch Contributors require contributions made to
            List<RelNode> picked = new ArrayList<>(childAlternativeSets.size());
 *
    private static Resolved altOnBackend(List<Resolved> alts, String backend) {
            }
package org.opensearch.analytics.planner.dag;
/*
        List<String> backendsToConsider = new ArrayList<>();
    }
        // Multi-input within one exchange-free stage: arms run on the same backend, so emit one
 * this file be licensed under the Apache-2.0 license or a
            }
            return resolveOperator(node, List.of(), null);
 * this naturally produces one alternative per stage.
            for (List<Resolved> childAlts : childAlternativeSets) {
        }
        if (!(node instanceof OpenSearchRelNode openSearchNode)) {
                resolved.add(annotation.narrowTo(operatorBackend));
        // Filter viable backends: only consider backends that match the child's chosen backend.
 * Generates plan alternatives for each {@link Stage} in a {@link QueryDAG}.
        String targetBackend,
        return List.of(new Resolved(backend, node.copyResolved(backend, children, resolved)));
        }
            }
        for (Stage child : stage.getChildStages()) {
        return results;
 *
            if (backend.equals(a.chosenBackend) || a.chosenBackend == null || a.chosenBackend.isEmpty()) {
            }
    private static List<Resolved> resolveWithBranching(
        List<OperatorAnnotation> resolved = new ArrayList<>();
        }
public class PlanForker {
 *
            } else {
        // For PR2 (no delegation), always resolve annotations to the operator's own backend.
        stage.setPlanAlternatives(alternatives.stream().map(resolved -> new StagePlan(resolved.node, resolved.chosenBackend)).toList());
    /** A child alternative runnable on {@code backend} — its own, or a backend-agnostic
                }
        // exchange upstream; TODO: fan out the Cartesian product when multi-backend pipelines land.
 * are viable for the same stage.
        // from the operator's backend, generate one plan per distinct annotation target backend
 * @opensearch.internal
    }
                resolved.add(annotation.narrowTo(annotation.getViableBackends().getFirst()));
 */
    public static void forkAll(QueryDAG dag, CapabilityRegistry registry) {
            forkStage(child, registry);
        if (stage.getFragment() == null) {
                return a;
            // With a single backend, this produces exactly one alternative naturally.
 */
            if (picked.size() == childAlternativeSets.size()) {
        // alternative per backend EVERY child offers (picking each child's alt on it), not each
        for (OperatorAnnotation annotation : annotations) {
        List<Resolved> results = new ArrayList<>();
            } else if (annotation.getViableBackends().contains(operatorBackend)) {
        // how the child backend propagates upward through the operator chain.
            RelNode result = children.isEmpty() ? node : node.copy(node.getTraitSet(), children);
 *
 * one {@link StagePlan} per viable backend. Annotations are grouped by target
            ? osNode.getViableBackends()
                    picked.add(on.node);
                Resolved on = altOnBackend(childAlts, backend);
    }
        for (String backend : backendsToConsider) {
        }
            // Group annotations by target backend — one plan per distinct annotation backend group.
import java.util.List;
}
    }
            childAlternativeSets.add(resolve(input, registry));
        return results;
            }
            if (annotations.isEmpty()) {
    ) {
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
        List<Resolved> results = new ArrayList<>();
    private static List<OperatorAnnotation> resolveAnnotationsToTarget(
        }
     *  (blank-backend) one (e.g. an infrastructure pass-through node); null if neither exists. */
        return null;
        List<Resolved> alternatives = resolve(stage.getFragment(), registry);
        }
 * backend to avoid combinatorial explosion — with a single backend (pure DF),
            }
    private record Resolved(String chosenBackend, RelNode node) {
        forkStage(dag.rootStage(), registry);
 * <p>TODO: add pruning via BackendPriority and cost functions when multiple backends
        }
            results.addAll(resolveWithBranching(openSearchNode, backend, children, annotations));
        // (e.g. DF operator with Lucene annotation for filter delegation).
        for (String backend : parentBackends) {
            List<Resolved> results = new ArrayList<>();
        List<OperatorAnnotation> annotations = openSearchNode.getAnnotations();
        if (childAlternativeSets.isEmpty()) {
                results.addAll(resolveOperator(node, List.of(childAlt.node), childAlt.chosenBackend));
                // Fallback: narrow to first viable backend.
            if (childBackend == null || backend.equals(childBackend)) {
    private PlanForker() {}
            : childAlternativeSets.getFirst().stream().map(Resolved::chosenBackend).distinct().toList();
        String operatorBackend
        // TODO: delegation will change this — cross-backend pipelines require revisiting
                backendsToConsider.add(backend);
        List<OperatorAnnotation> annotations,
                results.addAll(resolveOperator(node, picked, backend));
import org.opensearch.analytics.planner.CapabilityRegistry;
        List<OperatorAnnotation> resolved = resolveAnnotationsToTarget(annotations, backend, backend);
            return;
        for (Resolved a : alts) {
    /** Resolved node paired with the backend chosen at this operator level. */
        // DataFusion-only Union), leaving zero alternatives. Cross-backend arms are split by an
                if (on != null) {
 * For small indices, generating multiple alternatives adds overhead with minimal benefit.
