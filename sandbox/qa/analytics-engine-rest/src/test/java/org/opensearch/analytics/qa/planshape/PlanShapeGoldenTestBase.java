                    header.append(line).append('\n');
            : golden.queryText();
     * deduped {@code shard_physical} (when the two are identical) or both {@code shard_physical_1seg}  
                for (String comboName : queryCombos) {  
                if (line.startsWith("#")) {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        String generate = System.getProperty("plan.generate");  
     * layout-specific key, else fall back to the deduped key.
        }
        }
                actual.isEmpty()
    private static final SegmentLayout[] SEGMENT_LAYOUTS = { SegmentLayout.SINGLE_SEGMENT, SegmentLayout.MULTI_SEGMENT };
        final String queryId;
     * segment-derived and are captured once (from the single-segment index).
    /**  
 * SPDX-License-Identifier: Apache-2.0
     * {@code input_partitions}). The non-shard layers (post_cbo / fragment / coord) are NOT
        // query text straight from the workload's query file.
            SettingsComboRegistry combos = SettingsComboRegistry.load(COMBOS_RESOURCE);  
import org.opensearch.client.Request;  
        // newline the captured plan string doesn't have. Plan shape is what matters, not edge newlines.
        return SHARD_KEY + "_" + layout.suffix;
        }  
        final WorkloadSpec workload;  
            logger.info("plan-shape wrote golden {} -> {}", testCase, out);
            if (!first) {
    /** Emit the shard physical plan(s): one deduped key if the layouts match, else both. */  
     * One index per (shard count, segment layout) cell, so all variants coexist on one cluster,
        SettingsCombo combo = combos.byName(testCase.comboName);
        }
        Dataset index = new Dataset(spec.dataset().name, indexName);
        public String toString() {
        }
 *
            ? null  
        String resourcesDir = System.getProperty("plan.resourcesDir");
     * annotations across regeneration. Returns empty string if no file or no comments exist.
     * Non-shard layers come from the single-segment capture (segment-independent). The shard physical
        DatasetProvisioner.provision(client(), index, numberOfShards, layout);
            return;  
        try {
    }
     * the shard physical plan can legitimately differ with segment count (e.g. the scan's  
            // Point the query at the per-layout index. Replaces every occurrence of the dataset
     * Render this (query, combo)'s captured layers as the YAML body that sits under {@code plans:}.
        // Assertion mode needs the golden; generate mode does not (it's creating it) and reads the  
                    break;
    /** Indices already provisioned this JVM — each (shard count, segment layout) index is provisioned once. */
import org.opensearch.analytics.qa.planshape.ExpectedQueryPlan.PlanShapeLayer;
    private String renderComboYaml(Map<SegmentLayout, ProfilePlanExtractor> captured) {
     * each time, so the file always reflects every combo generated so far.
    /**
        // -Dplan.generate=write|print : capture instead of assert. write -> the q{N}.plan.yaml in
import org.opensearch.analytics.qa.DatasetProvisioner.SegmentLayout;
     * {@code shard_physical_nseg}.
        }
    private static String shardKey(SegmentLayout layout) {  
        }
                writeGolden(comboYaml);  
        if (!PROVISIONED_INDICES.add(indexName)) {
     */  
        if (Files.exists(goldenFile) == false) {
        }  
            settingsJson.append('"').append(setting.getKey()).append("\":").append(toJsonValue(setting.getValue()));  
        String indexName = indexNameFor(spec, numberOfShards, layout);  
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
        } catch (IOException e) {  
            actual.get().stripTrailing()  
    /** Classpath path of the global combos registry. */
        return yaml.toString();  
        }
    private static final Map<String, Map<String, String>> GENERATED_YAML_BY_QUERY = new ConcurrentHashMap<>();  
                        .appliesCombos().stream().filter(runCombos::contains).toList();
/**  
        // Compare trailing-whitespace-insensitively: a YAML block scalar (|) keeps one trailing
            ? loadResource(testCase.workload.queryDir() + "/" + testCase.queryId + ".ppl").strip()  
import java.io.IOException;
        assertShardPhysical(golden, captured);
        // gets its key, the absent side is simply omitted (asserted absent for that layout).
        return requested;
            // When generating, a golden may not exist yet — use every run-combo per query.
     * / {@code shard_physical_nseg} (when they diverge). Resolve per layout: prefer the
        }  
     * {@code shard_physical}; if they diverge, emit both {@code shard_physical_1seg} and
    }  
            String.format(Locale.ROOT, "%s — expected a plan but layer was ABSENT in the response", label),
        Request request = new Request("PUT", "/_cluster/settings");  
        yaml.append(INDENT).append(testCase.comboName).append(":\n");
    private void writeGolden(String comboYaml) {
            Files.createDirectories(out.getParent());  
 * shard physical plan is asserted per segment layout.
            this.workload = workload;
     * Write this (query, combo)'s YAML into the query's golden file in the source tree (path from
    private static final String INDENT = "  ";
     */  
    }  
            Optional<String> actual = captured.get(layout).layer(PlanShapeLayer.SHARD_PHYSICAL);  
        final String comboName;
        ExpectedQueryPlan golden = generating
            Map<String, Object> response = executePplWithProfile(ppl);  
                expected = golden.expectedTextForLayerKey(testCase.comboName, SHARD_KEY); // deduped  
            }  
            return; // no shard physical (Lucene fast-path): omit, asserted absent for both
     */  
        Request request = new Request("POST", "/_plugins/_ppl");
            String ppl = queryText.replace(testCase.workload.dataset().name, indexName);
    /** The {@link SettingsCombo} names this run should exercise: {@code -Dplan.combos=a,b} or {@code all}, else the file defaults. */
        assertEquals(  
        StringBuilder doc = new StringBuilder();
            }  
        requested.forEach(combos::byName);
            throw new RuntimeException("failed building plan-shape cases for workload " + spec.name(), e);  
        if (prop.trim().equals("all")) {
                List<String> queryCombos = generating
            singleSegment.layer(layer).ifPresent(text -> appendBlock(yaml, layer.yamlKey(), text));
        if (prop == null || prop.isBlank()) {
        boolean generating = System.getProperty("plan.generate") != null;
    private void assertShardPhysical(ExpectedQueryPlan golden, Map<SegmentLayout, ProfilePlanExtractor> captured) {
            List<String> runCombos = getSettingCombosToRun(combos);
        this.testCase = testCase;
 * that calls {@link #buildQueryAndSettingCombinationsToRun(WorkloadSpec)} (the factory must be
                    ? runCombos  
        for (PlanShapeLayer layer : PlanShapeLayer.values()) {
     * to, intersected with the combos this run exercises ({@link #getSettingCombosToRun}). Static, so
            }
     * Read leading {@code #} comment lines from an existing golden file to preserve hand-authored  
 * against the query's golden. The non-shard layers are segment-independent (asserted once); the
     * Assert the shard physical plan for both segment layouts. A golden stores either a single
     */  
            );  
/*  
            // also appears elsewhere in the query.
            return combos.defaults();
            assertPlanShapeLayer(golden.expected(testCase.comboName, layer), singleSegment.layer(layer), layer.toString());
            if (expected.isEmpty()) {
     * {@code -Dplan.resourcesDir}). Since a golden holds all combos but each JUnit case is one  
        if (oneSeg.isEmpty() && multiSeg.isEmpty()) {
            return cases;
    private void appendShardPhysical(StringBuilder yaml, Map<SegmentLayout, ProfilePlanExtractor> captured) {
        if (resourcesDir == null) {  
    public void testPlanShape() throws Exception {
            return workload.name() + "/" + queryId + "[" + comboName + "]";  
    }
}
        // Validate up front: an unknown name in assert mode would otherwise just filter to zero cases
            String indexName = indexNameFor(testCase.workload, combo.numberOfShards(), layout);
                continue;  
            throw new UncheckedIOException("failed writing golden " + out, e);
            // name; relies on it being a distinctive token (the source name), not a substring that  
            assertTrue(  
        doc.append("plans:\n");  
    /** One unit of YAML indentation; golden nesting is whole multiples of this. */  
        }  
    private Map<String, Object> executePplWithProfile(String ppl) throws IOException {
            expected.get().stripTrailing(),
        return spec.dataset().indexName + "_" + numberOfShards + "s_" + layout.suffix;
        // Diverge: pin each layout under its own key. This also covers the asymmetric case where
    }
        String label = testCase + " " + layerLabel;  
            actual.isPresent()
        StringBuilder settingsJson = new StringBuilder("{\"transient\":{");
    /**
    private final GoldenCase testCase;
                logger.info("plan-shape generated for {}:\n{}", testCase, comboYaml);
            return "";
 * layouts ({@link SegmentLayout}), renders it into the {@link PlanShapeLayer}s, and asserts each  
            first = false;
        request.setJsonEntity(settingsJson.toString());
import java.util.ArrayList;  
     * e.g. {@code parquet_hits_2s_1seg} / {@code parquet_hits_2s_nseg}.
    /**  
 *  
            StringBuilder header = new StringBuilder();
        doc.append(header);
public abstract class PlanShapeGoldenTestBase extends AnalyticsRestTestCase {
        );
    /** "workload/queryId" -> (comboName -> that combo's rendered YAML), accumulated across a generate run. */
            assertPlanShapeLayer(expected, actual, PlanShapeLayer.SHARD_PHYSICAL + "[" + layout.suffix + "]");
        multiSeg.ifPresent(text -> appendBlock(yaml, shardKey(SegmentLayout.MULTI_SEGMENT), text));  
import java.util.Map;
            }  
        for (SegmentLayout layout : SEGMENT_LAYOUTS) {
        if (oneSeg.equals(multiSeg)) {
        doc.append("ppl_file: ").append(testCase.queryId).append(".ppl\n");
    /**
        yamlByCombo.put(testCase.comboName, comboYaml);
                appendShardPhysical(yaml, captured);
 * static, so it cannot read an instance field).  
    }
            appendBlock(yaml, SHARD_KEY, oneSeg.get()); // identical across layouts -> dedup
    private void applyClusterSettings(SettingsCombo combo) throws IOException {
            throw new IllegalStateException("plan.generate=write needs -Dplan.resourcesDir (set by build.gradle)");
        }
            yaml.append(INDENT.repeat(3)).append(line).append('\n');  
import org.opensearch.analytics.qa.DatasetProvisioner;  
            captured.put(layout, ProfilePlanExtractor.extractFrom(response, indexName));
        List<String> requested = List.of(prop.trim().split("\\s*,\\s*"));
        }  
        // Non-shard layers: assert once (from the single-segment capture — segment-independent).
        String queryText = generating
    }
            // When asserting, only the combos the golden declares it applies to (intersected).  
 */  
        for (String line : text.split("\n")) {
 * <p>Per-workload subclasses supply a {@link WorkloadSpec} via a static {@code @ParametersFactory}
        if (combo.clusterSettings().isEmpty()) {
        Path out = Path.of(resourcesDir, testCase.workload.goldenResourcePath(testCase.queryId));
        doc.append("query: ").append(testCase.queryId).append('\n');  
            Optional<String> expected = golden.expectedTextForLayerKey(testCase.comboName, shardKey(layout));
        } catch (IOException e) {
        for (Map.Entry<String, Object> setting : combo.clusterSettings().entrySet()) {
    }  
        // and silently run nothing. byName throws with the list of defined combos.  
    private static void appendBlock(StringBuilder yaml, String yamlKey, String text) {  
import java.util.Locale;  
            if (layer == PlanShapeLayer.SHARD_PHYSICAL) {  
        for (SegmentLayout layout : SEGMENT_LAYOUTS) {
    private static List<String> getSettingCombosToRun(SettingsComboRegistry combos) {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}");  
    protected PlanShapeGoldenTestBase(GoldenCase testCase) {  
import java.util.LinkedHashMap;
        for (PlanShapeLayer layer : PlanShapeLayer.values()) {
        settingsJson.append("}}");
    private static String toJsonValue(Object v) {
    private void provisionOnce(WorkloadSpec spec, int numberOfShards, SegmentLayout layout) throws IOException {
    /**
        GoldenCase(WorkloadSpec workload, String queryId, String comboName) {
        @Override
            testCase.workload.name() + "/" + testCase.queryId, k -> new LinkedHashMap<>());
    /** YAML keys for the per-segment-layout shard physical plans (used only when they diverge). */
        oneSeg.ifPresent(text -> appendBlock(yaml, shardKey(SegmentLayout.SINGLE_SEGMENT), text));
        Map<SegmentLayout, ProfilePlanExtractor> captured = new LinkedHashMap<>();
        }  
    protected static List<Object[]> buildQueryAndSettingCombinationsToRun(WorkloadSpec spec) {
        Optional<String> oneSeg = captured.get(SegmentLayout.SINGLE_SEGMENT).layer(PlanShapeLayer.SHARD_PHYSICAL);
            provisionOnce(testCase.workload, combo.numberOfShards(), layout);  
        try {
            String comboYaml = renderComboYaml(captured);
            return combos.allNames();
        ProfilePlanExtractor singleSegment = captured.get(SegmentLayout.SINGLE_SEGMENT);
                continue;
        if (expected.isEmpty()) {
    }
        }
                }
            List<Object[]> cases = new ArrayList<>();  
        assertOkAndParse(client().performRequest(request), "PUT settings: " + settingsJson);
            String.format(Locale.ROOT, "%s — plan shape mismatch.\n=== ACTUAL (paste into golden) ===\n%s\n=== END ===", label, actual.get()),
        applyClusterSettings(combo);  
            return; // already provisioned this JVM
            for (String line : Files.readAllLines(goldenFile)) {  
    }
        assertTrue(  
            if (layer == PlanShapeLayer.SHARD_PHYSICAL) {
    }
    /** Assert one captured plan-shape layer against its expected text (present text, or empty = expected absent). */
            }
            for (String queryId : spec.queryIds()) {
        StringBuilder yaml = new StringBuilder();  
            boolean generating = System.getProperty("plan.generate") != null;
import java.io.UncheckedIOException;  
    }
package org.opensearch.analytics.qa.planshape;
    private static String indexNameFor(WorkloadSpec spec, int numberOfShards, SegmentLayout layout) {
import java.nio.file.Path;
    private static final String SHARD_KEY = PlanShapeLayer.SHARD_PHYSICAL.yamlKey();
        return v instanceof String ? "\"" + v + "\"" : String.valueOf(v);  
    /** YAML key for the deduped shard physical plan (single-segment == multi-segment). */  
        boolean first = true;  
    private static String preserveExistingHeader(Path goldenFile) {  
    private static final String COMBOS_RESOURCE = "planshape/combos.yaml";
        }
    }
import java.util.Set;  
        yamlByCombo.values().forEach(doc::append);
        }
        Map<String, String> yamlByCombo = GENERATED_YAML_BY_QUERY.computeIfAbsent(  
 * combo's cluster settings, captures the {@code /_plugins/_ppl?profile=true} plan under both segment
import java.util.Optional;
            return "";  
        // the source tree; print -> log the block. Absent -> assertion mode.
    }  
                settingsJson.append(',');  
import java.nio.file.Files;
            return header.toString();
        doc.append("applies: [").append(String.join(", ", yamlByCombo.keySet())).append("]\n");
     * the subclass {@code @ParametersFactory}. Each query's golden declares which combos it applies  
     * it can't read an instance field.
    }
        yaml.append(INDENT.repeat(2)).append(yamlKey).append(": |\n");
    private static final Set<String> PROVISIONED_INDICES = ConcurrentHashMap.newKeySet();  
        ProfilePlanExtractor singleSegment = captured.get(SegmentLayout.SINGLE_SEGMENT);  
        try {
        String header = preserveExistingHeader(out);
                    : ExpectedQueryPlanLoader.loadGolden(spec.goldenResourcePath(queryId), spec.queryDir())
        String prop = System.getProperty("plan.combos");  
        // Capture under both segment layouts. The non-shard layers come from the single-segment
                }
     */  
            } else {
                    cases.add(new Object[] { new GoldenCase(spec, queryId, comboName) });
     * plan is deduped: if the single- and multi-segment plans are identical, emit one  
            return;
     * Build the JUnit parameter rows — one per (query, setting-combo) — for a workload, the source for
            }
        } catch (IOException e) {
     */  
     * combo, accumulate combos per query (single-fork sequential run) and rewrite the whole file
        Optional<String> multiSeg = captured.get(SegmentLayout.MULTI_SEGMENT).layer(PlanShapeLayer.SHARD_PHYSICAL);  
    public static final class GoldenCase {
    }
 */
            Files.writeString(out, doc.toString());
        SettingsComboRegistry combos = SettingsComboRegistry.load(COMBOS_RESOURCE);  
            return;
    }
                String.format(Locale.ROOT, "%s — expected layer ABSENT but plan was produced:\n%s", label, actual.orElse("")),
                } else {  
        // index (they are not segment-derived); the shard physical plan is captured per layout.  
            if ("print".equals(generate)) {  
        // one layout has a shard plan and the other doesn't (Optional.empty) — the present side  
            this.queryId = queryId;  
    }  
     */
        }  
     * The two segment layouts every combo is captured under — a controlled axis (see core-axioms):
        if (generate != null) {
    private void assertPlanShapeLayer(Optional<String> expected, Optional<String> actual, String layerLabel) {
        }  
 * Shared harness for plan-shape golden ITs. One JUnit case per (query, combo): each applies the
    /** One (query, combo) pair — the unit a JUnit case asserts. {@code toString()} names the case. */
            return;  
        return assertOkAndParse(client().performRequest(request), "PPL(profile): " + ppl);
        }
            this.comboName = comboName;
import org.opensearch.analytics.qa.AnalyticsRestTestCase;
        }
            }
    /**
            : ExpectedQueryPlanLoader.loadGolden(testCase.workload.goldenResourcePath(testCase.queryId), testCase.workload.queryDir());
 * this file be licensed under the Apache-2.0 license or a
        );  
import org.opensearch.analytics.qa.Dataset;
