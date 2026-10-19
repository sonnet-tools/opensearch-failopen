    public ExpectedQueryPlan(  
    }
 *
        return appliesCombos;
        return Optional.ofNullable(textByLayerKey.get(layerKey));  
 * compatible open source license.
    public String queryText() {
 * The OpenSearch Contributors require contributions made to  
     * The plan layers asserted per (query, combo), and their YAML keys under a combo's plans block.
    /**
    private final String queryId;  
        COORD_PHYSICAL("coord_physical");
        FRAGMENT("fragment"),
    private final String queryText;
 * {@link PlanShapeLayer layer}.  
        POST_CBO("post_cbo"),
        Map<String, String> textByLayerKey = plansByCombo.get(comboName);  
 * text, empty = the layer is expected ABSENT under that combo (e.g. single-shard has no coordinator
        private final String yamlKey;
        }  
     * ({@code shard_physical_1seg} / {@code shard_physical_nseg}) that exists only when the single-
     * Expected plan text for a (combo, layer key), or {@link Optional#empty()} if absent. The layer
        List<String> appliesCombos,  
     */
        this.queryText = queryText;
     * in the {@link #FRAGMENT} layer's per-stage text.
        /** Whole post-CBO Calcite plan, before the DAG cut: {@code profile.full_plan}. */
    public List<String> appliesCombos() {
    public enum PlanShapeLayer {  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Map<String, String>> plansByCombo
 * stage, or a Lucene fast-path stage produces no DataFusion physical plan).
        return queryId;
     * {@code shard_physical} / {@code coord_physical}), or a shard segment-layout sub-key
        this.appliesCombos = appliesCombos;
        }
}
 */  
import java.util.Locale;
        public String yamlKey() {
    public Optional<String> expected(String comboName, PlanShapeLayer layer) {  
import java.util.Map;  
            throw new IllegalArgumentException(
        if (textByLayerKey == null) {
public final class ExpectedQueryPlan {
     */
package org.opensearch.analytics.qa.planshape;
 * recursion), resolved at load time. A layer is uniformly an {@link Optional}: present = expected  
 * <p>A layer entry is either literal plan text or a {@code same_as: <combo>} reference (one hop, no
        return expectedTextForLayerKey(comboName, layer.yamlKey());
        SHARD_PHYSICAL("shard_physical"),  
    public Optional<String> expectedTextForLayerKey(String comboName, String layerKey) {
     */
/*  
        return queryText;  
/**  
    ) {
 * The expected plans for ONE query, parsed from its {@code q{N}.plan.yaml} golden. Holds the query
        PlanShapeLayer(String yamlKey) {  
        }
        String queryId,
    }  
    }
 *
 * text and, per applicable {@link SettingsCombo combo}, the expected plan text for each
        /** Per-stage Calcite slice from the DAG cut + chosen_backend + tree_shape: {@code profile.stages[*]}. */  
    private final Map<String, Map<String, String>> plansByCombo;
     * layer (no DF plan). {@code chosen_backend} / {@code tree_shape} are stage properties carried  
     * absent under that combo. {@code same_as} references are already resolved at load time.
        String queryText,
    }
            this.yamlKey = yamlKey;
 * SPDX-License-Identifier: Apache-2.0
     * Expected plan text for a (combo, layer), or {@link Optional#empty()} if the layer is expected  
     * and multi-segment shard plans diverge.  
        this.queryId = queryId;  
            );
    /** The PPL/SQL query text (resolved from inline {@code ppl} or referenced {@code ppl_file}). */
import java.util.List;
        /** Coordinator physical plan: {@code stages[COORDINATOR_REDUCE].tasks[*].physical_plan}; empty if no coord stage. */
     * key is the golden's YAML key for a {@link PlanShapeLayer} ({@code post_cbo} / {@code fragment} /  
    }
    private final List<String> appliesCombos;
     * Physical layers are backend-agnostic: a stage answered by Lucene yields an empty physical
    /**  
    }
import java.util.Optional;
    /**
    // comboName -> (layer yamlKey -> resolved plan text). A missing key means the layer is absent.  
    public String queryId() {  
    }
        this.plansByCombo = plansByCombo;  
        /** Shard physical plan: {@code stages[SHARD_FRAGMENT].tasks[*].physical_plan}; empty for a Lucene stage. */
            return yamlKey;
 */  
                String.format(Locale.ROOT, "query '%s' has no plans for combo '%s'", queryId, comboName)  
    /** Combo names this query is asserted under. */  
