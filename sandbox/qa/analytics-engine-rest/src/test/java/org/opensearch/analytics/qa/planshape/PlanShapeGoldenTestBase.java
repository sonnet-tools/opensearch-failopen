            Files.createDirectories(out.getParent());
                continue;
            // also appears elsewhere in the query.
                    header.append(line).append('\n');
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
        request.setJsonEntity(settingsJson.toString());
    /** Emit the shard physical plan(s): one deduped key if the layouts match, else both. */
            // name; relies on it being a distinctive token (the source name), not a substring that
                continue;
            }
            Map<String, Object> response = executePplWithProfile(ppl);
import java.util.Optional;
    private Map<String, Object> executePplWithProfile(String ppl) throws IOException {
            String ppl = queryText.replace(testCase.workload.dataset().name, indexName);
    }
        try {
            return "";
/*
    /**
        if (resourcesDir == null) {
            Files.writeString(out, doc.toString());
            }
     * Read leading {@code #} comment lines from an existing golden file to preserve hand-authored
        if (prop == null || prop.isBlank()) {
        for (PlanShapeLayer layer : PlanShapeLayer.values()) {
        // Capture under both segment layouts. The non-shard layers come from the single-segment
                logger.info("plan-shape generated for {}:\n{}", testCase, comboYaml);
    private void assertPlanShapeLayer(Optional<String> expected, Optional<String> actual, String layerLabel) {
            actual.get().stripTrailing()
                expected = golden.expectedTextForLayerKey(testCase.comboName, SHARD_KEY); // deduped
            this.comboName = comboName;
                        .appliesCombos().stream().filter(runCombos::contains).toList();
            }
    }
            for (String line : Files.readAllLines(goldenFile)) {
            : ExpectedQueryPlanLoader.loadGolden(testCase.workload.goldenResourcePath(testCase.queryId), testCase.workload.queryDir());
    /** The {@link SettingsCombo} names this run should exercise: {@code -Dplan.combos=a,b} or {@code all}, else the file defaults. */
        doc.append("ppl_file: ").append(testCase.queryId).append(".ppl\n");
        DatasetProvisioner.provision(client(), index, numberOfShards, layout);
        assertShardPhysical(golden, captured);
        doc.append("query: ").append(testCase.queryId).append('\n');
        // query text straight from the workload's query file.
    private static final String COMBOS_RESOURCE = "planshape/combos.yaml";
    /** One unit of YAML indentation; golden nesting is whole multiples of this. */
        try {
    public void testPlanShape() throws Exception {
    }
            return combos.allNames();
            return;
        ProfilePlanExtractor singleSegment = captured.get(SegmentLayout.SINGLE_SEGMENT);
            } else {
    /**
        // Validate up front: an unknown name in assert mode would otherwise just filter to zero cases
            return workload.name() + "/" + queryId + "[" + comboName + "]";
import java.util.concurrent.ConcurrentHashMap;
    }
            );
        // Diverge: pin each layout under its own key. This also covers the asymmetric case where
package org.opensearch.analytics.qa.planshape;
        final String comboName;
    }
    private static void appendBlock(StringBuilder yaml, String yamlKey, String text) {
     * / {@code shard_physical_nseg} (when they diverge). Resolve per layout: prefer the
            assertPlanShapeLayer(expected, actual, PlanShapeLayer.SHARD_PHYSICAL + "[" + layout.suffix + "]");
        assertOkAndParse(client().performRequest(request), "PUT settings: " + settingsJson);
                List<String> queryCombos = generating
            singleSegment.layer(layer).ifPresent(text -> appendBlock(yaml, layer.yamlKey(), text));
        return v instanceof String ? "\"" + v + "\"" : String.valueOf(v);
        }
        settingsJson.append("}}");
                writeGolden(comboYaml);
import org.opensearch.analytics.qa.AnalyticsRestTestCase;
            return cases;
     * One index per (shard count, segment layout) cell, so all variants coexist on one cluster,
        assertEquals(
    private static List<String> getSettingCombosToRun(SettingsComboRegistry combos) {
     */
import org.opensearch.analytics.qa.DatasetProvisioner;
     * Assert the shard physical plan for both segment layouts. A golden stores either a single
    protected static List<Object[]> buildQueryAndSettingCombinationsToRun(WorkloadSpec spec) {
            this.queryId = queryId;
        // one layout has a shard plan and the other doesn't (Optional.empty) — the present side
            List<String> runCombos = getSettingCombosToRun(combos);
    private void writeGolden(String comboYaml) {
            provisionOnce(testCase.workload, combo.numberOfShards(), layout);
            List<Object[]> cases = new ArrayList<>();
 * against the query's golden. The non-shard layers are segment-independent (asserted once); the
     */
        // the source tree; print -> log the block. Absent -> assertion mode.
        }
        String label = testCase + " " + layerLabel;
    }
            return;
        }
            return;
     */
            if (!first) {
            if ("print".equals(generate)) {
        // gets its key, the absent side is simply omitted (asserted absent for that layout).
            throw new UncheckedIOException("failed writing golden " + out, e);
    /**
 *
 * that calls {@link #buildQueryAndSettingCombinationsToRun(WorkloadSpec)} (the factory must be
        StringBuilder settingsJson = new StringBuilder("{\"transient\":{");
            }
            : golden.queryText();
        doc.append("applies: [").append(String.join(", ", yamlByCombo.keySet())).append("]\n");
     * each time, so the file always reflects every combo generated so far.
        StringBuilder doc = new StringBuilder();
    public static final class GoldenCase {
 * Shared harness for plan-shape golden ITs. One JUnit case per (query, combo): each applies the
        );
 * shard physical plan is asserted per segment layout.
import org.opensearch.analytics.qa.Dataset;
        return yaml.toString();
    }
            return;
 * combo's cluster settings, captures the {@code /_plugins/_ppl?profile=true} plan under both segment
        }
            StringBuilder header = new StringBuilder();
            for (String queryId : spec.queryIds()) {
        GoldenCase(WorkloadSpec workload, String queryId, String comboName) {
            actual.isPresent()
    private static String preserveExistingHeader(Path goldenFile) {
import java.util.LinkedHashMap;
import org.opensearch.analytics.qa.DatasetProvisioner.SegmentLayout;
        final String queryId;
        Optional<String> oneSeg = captured.get(SegmentLayout.SINGLE_SEGMENT).layer(PlanShapeLayer.SHARD_PHYSICAL);
     * {@code input_partitions}). The non-shard layers (post_cbo / fragment / coord) are NOT
        SettingsComboRegistry combos = SettingsComboRegistry.load(COMBOS_RESOURCE);
import java.nio.file.Path;
     * layout-specific key, else fall back to the deduped key.
 * static, so it cannot read an instance field).
import java.util.List;
    /** Assert one captured plan-shape layer against its expected text (present text, or empty = expected absent). */
        }
        Request request = new Request("PUT", "/_cluster/settings");
 */
        } catch (IOException e) {
            appendBlock(yaml, SHARD_KEY, oneSeg.get()); // identical across layouts -> dedup
     * annotations across regeneration. Returns empty string if no file or no comments exist.
        for (SegmentLayout layout : SEGMENT_LAYOUTS) {
    private void applyClusterSettings(SettingsCombo combo) throws IOException {
            return; // no shard physical (Lucene fast-path): omit, asserted absent for both
                settingsJson.append(',');
    private static final String INDENT = "  ";
        if (generate != null) {
    /** Indices already provisioned this JVM — each (shard count, segment layout) index is provisioned once. */
        if (oneSeg.equals(multiSeg)) {
    }
    }
        }
            Optional<String> expected = golden.expectedTextForLayerKey(testCase.comboName, shardKey(layout));
     * the shard physical plan can legitimately differ with segment count (e.g. the scan's
        this.testCase = testCase;
 */
        String prop = System.getProperty("plan.combos");
        }
        String indexName = indexNameFor(spec, numberOfShards, layout);
                if (line.startsWith("#")) {
            if (expected.isEmpty()) {
        boolean first = true;
        try {
            assertPlanShapeLayer(golden.expected(testCase.comboName, layer), singleSegment.layer(layer), layer.toString());
        public String toString() {
        assertTrue(
            String.format(Locale.ROOT, "%s — expected a plan but layer was ABSENT in the response", label),
            throw new IllegalStateException("plan.generate=write needs -Dplan.resourcesDir (set by build.gradle)");
        String resourcesDir = System.getProperty("plan.resourcesDir");
    private String renderComboYaml(Map<SegmentLayout, ProfilePlanExtractor> captured) {
            first = false;
        String queryText = generating
            captured.put(layout, ProfilePlanExtractor.extractFrom(response, indexName));
    private static final Map<String, Map<String, String>> GENERATED_YAML_BY_QUERY = new ConcurrentHashMap<>();
    }
            assertTrue(
            // When generating, a golden may not exist yet — use every run-combo per query.
    }
                actual.isEmpty()
        }
     * Non-shard layers come from the single-segment capture (segment-independent). The shard physical
        ExpectedQueryPlan golden = generating
    /** "workload/queryId" -> (comboName -> that combo's rendered YAML), accumulated across a generate run. */
                    : ExpectedQueryPlanLoader.loadGolden(spec.goldenResourcePath(queryId), spec.queryDir())
     * segment-derived and are captured once (from the single-segment index).
}
        List<String> requested = List.of(prop.trim().split("\\s*,\\s*"));
    /**
import java.util.Set;
    }
    private static final Set<String> PROVISIONED_INDICES = ConcurrentHashMap.newKeySet();
    /** YAML key for the deduped shard physical plan (single-segment == multi-segment). */
    private void provisionOnce(WorkloadSpec spec, int numberOfShards, SegmentLayout layout) throws IOException {
     */
import java.io.IOException;
        doc.append("plans:\n");
        for (SegmentLayout layout : SEGMENT_LAYOUTS) {
    protected PlanShapeGoldenTestBase(GoldenCase testCase) {
        return SHARD_KEY + "_" + layout.suffix;
        if (Files.exists(goldenFile) == false) {
        Path out = Path.of(resourcesDir, testCase.workload.goldenResourcePath(testCase.queryId));
     * {@code -Dplan.resourcesDir}). Since a golden holds all combos but each JUnit case is one
            return; // already provisioned this JVM
    /**
        yamlByCombo.values().forEach(doc::append);
 * this file be licensed under the Apache-2.0 license or a
        return spec.dataset().indexName + "_" + numberOfShards + "s_" + layout.suffix;
        return assertOkAndParse(client().performRequest(request), "PPL(profile): " + ppl);
        }
 * The OpenSearch Contributors require contributions made to
                    break;
 * <p>Per-workload subclasses supply a {@link WorkloadSpec} via a static {@code @ParametersFactory}
        final WorkloadSpec workload;
import java.util.ArrayList;
     * deduped {@code shard_physical} (when the two are identical) or both {@code shard_physical_1seg}
            settingsJson.append('"').append(setting.getKey()).append("\":").append(toJsonValue(setting.getValue()));
        yamlByCombo.put(testCase.comboName, comboYaml);
                }
     * {@code shard_physical}; if they diverge, emit both {@code shard_physical_1seg} and
        }
     * {@code shard_physical_nseg}.
                }
                for (String comboName : queryCombos) {
        }
            boolean generating = System.getProperty("plan.generate") != null;
    }
        boolean generating = System.getProperty("plan.generate") != null;
        if (prop.trim().equals("all")) {
    private final GoldenCase testCase;
            // Point the query at the per-layout index. Replaces every occurrence of the dataset
        SettingsCombo combo = combos.byName(testCase.comboName);
    }
                    ? runCombos
    /** One (query, combo) pair — the unit a JUnit case asserts. {@code toString()} names the case. */
            ? null
        if (!PROVISIONED_INDICES.add(indexName)) {
        // Non-shard layers: assert once (from the single-segment capture — segment-independent).
            this.workload = workload;
        StringBuilder yaml = new StringBuilder();
        Optional<String> multiSeg = captured.get(SegmentLayout.MULTI_SEGMENT).layer(PlanShapeLayer.SHARD_PHYSICAL);
                appendShardPhysical(yaml, captured);
        } catch (IOException e) {
     */
        return requested;
    private static String toJsonValue(Object v) {
        );
        for (PlanShapeLayer layer : PlanShapeLayer.values()) {
 * layouts ({@link SegmentLayout}), renders it into the {@link PlanShapeLayer}s, and asserts each
    /** Classpath path of the global combos registry. */
        if (combo.clusterSettings().isEmpty()) {
     * it can't read an instance field.
    }
    /**
            String.format(Locale.ROOT, "%s — plan shape mismatch.\n=== ACTUAL (paste into golden) ===\n%s\n=== END ===", label, actual.get()),
            return header.toString();
        }
import org.opensearch.client.Request;
    private static String indexNameFor(WorkloadSpec spec, int numberOfShards, SegmentLayout layout) {
                } else {
            logger.info("plan-shape wrote golden {} -> {}", testCase, out);
     */
        if (expected.isEmpty()) {
    private void assertShardPhysical(ExpectedQueryPlan golden, Map<SegmentLayout, ProfilePlanExtractor> captured) {
import java.util.Locale;
    private static final String SHARD_KEY = PlanShapeLayer.SHARD_PHYSICAL.yamlKey();
        yaml.append(INDENT.repeat(2)).append(yamlKey).append(": |\n");
        // Compare trailing-whitespace-insensitively: a YAML block scalar (|) keeps one trailing
        applyClusterSettings(combo);
        Dataset index = new Dataset(spec.dataset().name, indexName);
            throw new RuntimeException("failed building plan-shape cases for workload " + spec.name(), e);
     * Write this (query, combo)'s YAML into the query's golden file in the source tree (path from
        if (oneSeg.isEmpty() && multiSeg.isEmpty()) {
import java.io.UncheckedIOException;
     * Build the JUnit parameter rows — one per (query, setting-combo) — for a workload, the source for
            }
            SettingsComboRegistry combos = SettingsComboRegistry.load(COMBOS_RESOURCE);
        // and silently run nothing. byName throws with the list of defined combos.
        Request request = new Request("POST", "/_plugins/_ppl");
        yaml.append(INDENT).append(testCase.comboName).append(":\n");
        // -Dplan.generate=write|print : capture instead of assert. write -> the q{N}.plan.yaml in
    }
        } catch (IOException e) {
            if (layer == PlanShapeLayer.SHARD_PHYSICAL) {
     * the subclass {@code @ParametersFactory}. Each query's golden declares which combos it applies
        Map<SegmentLayout, ProfilePlanExtractor> captured = new LinkedHashMap<>();
        }
    }
        }
/**
            yaml.append(INDENT.repeat(3)).append(line).append('\n');
        }
        @Override
            testCase.workload.name() + "/" + testCase.queryId, k -> new LinkedHashMap<>());
    private static final SegmentLayout[] SEGMENT_LAYOUTS = { SegmentLayout.SINGLE_SEGMENT, SegmentLayout.MULTI_SEGMENT };
        multiSeg.ifPresent(text -> appendBlock(yaml, shardKey(SegmentLayout.MULTI_SEGMENT), text));
     */
        requested.forEach(combos::byName);
 * compatible open source license.
            // When asserting, only the combos the golden declares it applies to (intersected).
import java.nio.file.Files;
        // newline the captured plan string doesn't have. Plan shape is what matters, not edge newlines.
     * to, intersected with the combos this run exercises ({@link #getSettingCombosToRun}). Static, so
        // index (they are not segment-derived); the shard physical plan is captured per layout.
     * plan is deduped: if the single- and multi-segment plans are identical, emit one
        doc.append(header);
            }
        }
        oneSeg.ifPresent(text -> appendBlock(yaml, shardKey(SegmentLayout.SINGLE_SEGMENT), text));
                    cases.add(new Object[] { new GoldenCase(spec, queryId, comboName) });
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}");
    private void appendShardPhysical(StringBuilder yaml, Map<SegmentLayout, ProfilePlanExtractor> captured) {
            ? loadResource(testCase.workload.queryDir() + "/" + testCase.queryId + ".ppl").strip()
     * The two segment layouts every combo is captured under — a controlled axis (see core-axioms):
        Map<String, String> yamlByCombo = GENERATED_YAML_BY_QUERY.computeIfAbsent(
        // Assertion mode needs the golden; generate mode does not (it's creating it) and reads the
        }
public abstract class PlanShapeGoldenTestBase extends AnalyticsRestTestCase {
    private static String shardKey(SegmentLayout layout) {
            String comboYaml = renderComboYaml(captured);
        ProfilePlanExtractor singleSegment = captured.get(SegmentLayout.SINGLE_SEGMENT);
            if (layer == PlanShapeLayer.SHARD_PHYSICAL) {
            expected.get().stripTrailing(),
        String header = preserveExistingHeader(out);
        for (Map.Entry<String, Object> setting : combo.clusterSettings().entrySet()) {
    /** YAML keys for the per-segment-layout shard physical plans (used only when they diverge). */
 *
        }
        String generate = System.getProperty("plan.generate");
            Optional<String> actual = captured.get(layout).layer(PlanShapeLayer.SHARD_PHYSICAL);
            return combos.defaults();
import java.util.Map;
        }
            return "";
                String.format(Locale.ROOT, "%s — expected layer ABSENT but plan was produced:\n%s", label, actual.orElse("")),
import org.opensearch.analytics.qa.planshape.ExpectedQueryPlan.PlanShapeLayer;
     * combo, accumulate combos per query (single-fork sequential run) and rewrite the whole file
        for (String line : text.split("\n")) {
        }
     * Render this (query, combo)'s captured layers as the YAML body that sits under {@code plans:}.
     * e.g. {@code parquet_hits_2s_1seg} / {@code parquet_hits_2s_nseg}.
        }
            String indexName = indexNameFor(testCase.workload, combo.numberOfShards(), layout);
            }
