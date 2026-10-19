            } else if (annotation.getViableBackends().contains(operatorBackend)) {  
public class PlanForker {
                results.addAll(resolveOperator(node, picked, backend));  
 * <p>Walks each stage's marked fragment bottom-up. For each operator, generates  
        }  
        forkStage(dag.rootStage(), registry);  
 * are viable for the same stage.  
        List<Resolved> results = new ArrayList<>();  
        List<OperatorAnnotation> resolved = new ArrayList<>();
    }  
            return List.of(new Resolved(childBackend != null ? childBackend : "", result));  
        for (OperatorAnnotation annotation : annotations) {  
        for (Stage child : stage.getChildStages()) {
import org.opensearch.analytics.planner.CapabilityRegistry;
 *
        for (String backend : parentBackends) {  
        }
    }
     *  (blank-backend) one (e.g. an infrastructure pass-through node); null if neither exists. */
    }
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;  
        for (String backend : backendsToConsider) {
                continue;
    /** A child alternative runnable on {@code backend} — its own, or a backend-agnostic  
        }  
        String operatorBackend  
 * @opensearch.internal
import java.util.List;
        // child's first alt — which could be a backend the parent can't run (e.g. lucene under a
        for (Resolved a : alts) {  
 * one {@link StagePlan} per viable backend. Annotations are grouped by target
        if (stage.getFragment() == null) {
    ) {  
                return a;
            }
 */  
    private static List<Resolved> resolveOperator(RelNode node, List<RelNode> children, String childBackend) {
        // Filter viable backends: only consider backends that match the child's chosen backend.
 */  
 * <p>TODO: add pruning via BackendPriority and cost functions when multiple backends
        if (childAlternativeSets.size() == 1) {
        List<OperatorAnnotation> annotations
 * The OpenSearch Contributors require contributions made to  
    }
                resolved.add(annotation.narrowTo(targetBackend));
        if (!(node instanceof OpenSearchRelNode openSearchNode)) {  
            if (annotation.getViableBackends().contains(targetBackend)) {
    }  
        // For PR2 (no delegation), always resolve annotations to the operator's own backend.
        }
                if (on != null) {
        }
        }
            } else {
            List<RelNode> picked = new ArrayList<>(childAlternativeSets.size());
        return results;
            ? osNode.getViableBackends()  
        // from the operator's backend, generate one plan per distinct annotation target backend
            return results;  
        return null;
        String backend,  
            if (annotations.isEmpty()) {
package org.opensearch.analytics.planner.dag;
            if (picked.size() == childAlternativeSets.size()) {
        List<RelNode> children,
 * SPDX-License-Identifier: Apache-2.0
            : childAlternativeSets.getFirst().stream().map(Resolved::chosenBackend).distinct().toList();
 *
    }
            }  
import org.apache.calcite.rel.RelNode;
        // alternative per backend EVERY child offers (picking each child's alt on it), not each
            RelNode result = children.isEmpty() ? node : node.copy(node.getTraitSet(), children);
        }  
        List<List<Resolved>> childAlternativeSets = new ArrayList<>();
        List<String> parentBackends = node instanceof OpenSearchRelNode osNode
        return resolved;
            if (backend.equals(a.chosenBackend) || a.chosenBackend == null || a.chosenBackend.isEmpty()) {
        List<OperatorAnnotation> annotations,
 * For small indices, generating multiple alternatives adds overhead with minimal benefit.  
        }
    private static Resolved altOnBackend(List<Resolved> alts, String backend) {
        }
    private static List<OperatorAnnotation> resolveAnnotationsToTarget(  
            forkStage(child, registry);
import org.opensearch.analytics.planner.rel.OperatorAnnotation;
            }
        List<OperatorAnnotation> annotations = openSearchNode.getAnnotations();  
        // Multi-input within one exchange-free stage: arms run on the same backend, so emit one  
        List<OperatorAnnotation> resolved = resolveAnnotationsToTarget(annotations, backend, backend);
 *
    private static void forkStage(Stage stage, CapabilityRegistry registry) {  
        List<Resolved> alternatives = resolve(stage.getFragment(), registry);
            }
                backendsToConsider.add(backend);
 * backend to avoid combinatorial explosion — with a single backend (pure DF),
 * Generates plan alternatives for each {@link Stage} in a {@link QueryDAG}.
            for (List<Resolved> childAlts : childAlternativeSets) {
/**  
        OpenSearchRelNode node,
        if (childAlternativeSets.isEmpty()) {  
    /** Resolved node paired with the backend chosen at this operator level. */
    public static void forkAll(QueryDAG dag, CapabilityRegistry registry) {
/*  
 * this file be licensed under the Apache-2.0 license or a
        // DataFusion-only Union), leaving zero alternatives. Cross-backend arms are split by an  
                }  
    private record Resolved(String chosenBackend, RelNode node) {  
    private static List<Resolved> resolve(RelNode node, CapabilityRegistry registry) {  
            return;
            return resolveOperator(node, List.of(), null);
            }
    ) {
        stage.setPlanAlternatives(alternatives.stream().map(resolved -> new StagePlan(resolved.node, resolved.chosenBackend)).toList());
import java.util.ArrayList;  
        List<Resolved> results = new ArrayList<>();
        List<String> backendsToConsider = new ArrayList<>();
            results.addAll(resolveWithBranching(openSearchNode, backend, children, annotations));
 * compatible open source license.
 *
 *
        // TODO: delegation will change this — cross-backend pipelines require revisiting  
        // exchange upstream; TODO: fan out the Cartesian product when multi-backend pipelines land.
                resolved.add(annotation.narrowTo(operatorBackend));
                results.addAll(resolveOperator(node, List.of(childAlt.node), childAlt.chosenBackend));
            for (Resolved childAlt : childAlternativeSets.getFirst()) {  
        return List.of(new Resolved(backend, node.copyResolved(backend, children, resolved)));  
            // Group annotations by target backend — one plan per distinct annotation backend group.  
                // Fallback: narrow to first viable backend.  
 * this naturally produces one alternative per stage.  
        for (String backend : openSearchNode.getViableBackends()) {  
            // With a single backend, this produces exactly one alternative naturally.
                Resolved on = altOnBackend(childAlts, backend);  
 * <p>TODO: gate plan forking based on index stats (size, shard count, doc count).
            childAlternativeSets.add(resolve(input, registry));  
        }  
        }
}  
        return results;  
            }
        // how the child backend propagates upward through the operator chain.
    private PlanForker() {}  
        // (e.g. DF operator with Lucene annotation for filter delegation).  
                    picked.add(on.node);
    }
            List<Resolved> results = new ArrayList<>();
                results.add(new Resolved(backend, openSearchNode.copyResolved(backend, children, List.of())));  
        // TODO: delegation will change this — when annotations have viable backends that differ
    private static List<Resolved> resolveWithBranching(
            // Non-OpenSearch node (e.g. StageInputScan infrastructure) — pass through.
                resolved.add(annotation.narrowTo(annotation.getViableBackends().getFirst()));
        String targetBackend,
        for (RelNode input : node.getInputs()) {
            }  
    }
            if (childBackend == null || backend.equals(childBackend)) {
