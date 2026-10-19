import org.opensearch.core.xcontent.DeprecationHandler;
                    DeprecationHandler.IGNORE_DEPRECATIONS,
        ) {
        }
        if (!(value instanceof String s)) {
import java.util.stream.Collectors;
        throw new IllegalStateException(
                    is
    /** Read a required top-level string field from the parsed golden, failing if absent or non-string. */
 * Loads one query's {@code q{N}.plan.yaml} golden into an {@link ExpectedQueryPlan}.
            rawByCombo.put(combo, (Map<String, Object>) comboPlans);
        if (is == null) {
 * {@code ppl_file:} (path relative to the workload's query dir). It lists the combos it
        Map<String, Map<String, Object>> rawByCombo,
        }
        for (String combo : applies) {
    /**
            return ((String) inline).strip();
        }
            if (comboPlans == null) {
        Map<String, Map<String, Object>> rawByCombo = new LinkedHashMap<>();
            Map<String, String> textByLayerKey = new LinkedHashMap<>();
 * SPDX-License-Identifier: Apache-2.0
                String.format(Locale.ROOT, "golden '%s' missing required string field '%s'", goldenResourcePath, key)
    }
            }
            return literalText;
        return loadResource(queryDir + "/" + file).strip();
        String queryId = requiredString(root, "query", goldenResourcePath);
                            goldenResourcePath, combo, layerKey, referencedCombo
                            "golden '%s' combo '%s' layer '%s' references same_as '%s', which is not an applied combo",
     * Load one query's {@code q{N}.plan.yaml} golden (at {@code goldenResourcePath} on the
        if (applies == null || applies.isEmpty()) {
        return new ExpectedQueryPlan(queryId, queryText, applies, resolvedByCombo);
                    String.format(Locale.ROOT, "golden '%s' applies to combo '%s' but has no plans for it", goldenResourcePath, combo)
    @SuppressWarnings("unchecked")
        if (rawLayerValue instanceof Map) {
    }
        Object inline = root.get("ppl");
        Map<String, Object> plans = (Map<String, Object>) root.get("plans");
        String queryText = resolveQueryText(root, queryDir, goldenResourcePath);
            throw new IllegalStateException(
        }
package org.opensearch.analytics.qa.planshape;
    private static String loadResource(String resourcePath) throws IOException {
                    NamedXContentRegistry.EMPTY,
                        )
    /** Resolve query text from inline {@code ppl:} XOR referenced {@code ppl_file:}. */
        }
            InputStream is = resourceStream(resourcePath, "query");
                XContentParser parser = YamlXContent.yamlXContent.createParser(
    @SuppressWarnings("unchecked")
    private static String resolveQueryText(Map<String, Object> root, String queryDir, String goldenResourcePath) throws IOException {
            Map<String, Object> rawLayers = rawByCombo.get(combo);
        String combo,
/*
     * classpath) into an {@link ExpectedQueryPlan}: resolves the query text (inline {@code ppl} or a
 * The OpenSearch Contributors require contributions made to
            }
import java.util.LinkedHashMap;
        }
                        )
 * A layer value is either literal plan text or a {@code {same_as: <combo>}} reference (one hop),
 */
                textByLayerKey.put(layer.getKey(), resolveLayerText(layer.getValue(), rawByCombo, combo, layer.getKey(), goldenResourcePath));
import java.io.InputStream;
        List<String> applies = (List<String>) root.get("applies");
                )
        if ((inline == null) == (file == null)) {
        }
 *
            );
            }
 * {@code applies} to, and under {@code plans} gives, per combo, the expected text for each layer.
                    );
import org.opensearch.core.xcontent.XContentParser;
import java.io.IOException;
        try (InputStream is = resourceStream(resourcePath, "golden")) {
     * The expected plan text for one layer of one combo. A layer value in the golden is either the
                Map<String, Object> referencedLayers = rawByCombo.get(referencedCombo);
     * for the same layer verbatim (so identical plans aren't duplicated across combos). Resolves the
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * {@code ppl_file} under {@code queryDir}) and the per-combo, per-layer expected plan text,
        Map<String, Map<String, String>> resolvedByCombo = new LinkedHashMap<>();
                }
    private static String resolveLayerText(
                }
                    );
    /** Open a classpath resource (from this class's loader), failing with a {@code kind}-tagged message. */
}
        if (inline != null) {
                Object referencedText = referencedLayers.get(layerKey);
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalStateException(String.format(Locale.ROOT, "%s resource not found: %s", kind, resourcePath));
    public static ExpectedQueryPlan loadGolden(String goldenResourcePath, String queryDir) throws IOException {
                    throw new IllegalStateException(
                if (!(referencedText instanceof String literalText)) {
 * resolved here. An omitted layer means the layer is expected absent.
                        String.format(Locale.ROOT,
            Object sameAs = ((Map<String, Object>) rawLayerValue).get("same_as");
        InputStream is = ExpectedQueryPlanLoader.class.getClassLoader().getResourceAsStream(resourcePath);
        try (
        String goldenResourcePath
    }
                return literalText;
    ) {
            throw new IllegalStateException(
import java.util.Locale;
     * latter — one hop only; the target must itself be literal text.
            for (Map.Entry<String, Object> layer : rawLayers.entrySet()) {
import java.util.List;
 *
import java.io.BufferedReader;
     * literal plan text, or a {@code {same_as: <otherCombo>}} map that reuses that other combo's text
        }
            }
import java.nio.charset.StandardCharsets;
        );
    /**
            );
 * <p>The golden declares the query EXACTLY ONE way: inline {@code ppl:} or a referenced
        // Second pass: resolve same_as (one hop) into concrete layer text.
        }
        if (rawLayerValue instanceof String literalText) {
        Object file = root.get("ppl_file");
            throw new IllegalStateException(
     * resolving any {@code same_as} references.
    private ExpectedQueryPlanLoader() {}
                return parser.map();
            throw new IllegalStateException(
                            "golden '%s' combo '%s' layer '%s' same_as '%s' must point at literal text (no chained same_as / missing layer)",
import java.io.InputStreamReader;
            resolvedByCombo.put(combo, textByLayerKey);
            Object comboPlans = plans.get(combo);
    }
        String layerKey,
            return reader.lines().collect(Collectors.joining("\n"));
            );
                String.format(Locale.ROOT, "golden '%s' has no 'plans' block", goldenResourcePath)
public final class ExpectedQueryPlanLoader {
    }
        Object value = root.get(key);
/**
        }
                throw new IllegalStateException(
                String.format(Locale.ROOT, "golden '%s' must declare exactly one of 'ppl' or 'ppl_file'", goldenResourcePath)
            String.format(Locale.ROOT, "golden '%s' combo '%s' layer '%s' is neither text nor a same_as map", goldenResourcePath, combo, layerKey)
        }
 * compatible open source license.
        for (String combo : applies) {
            );
    private static InputStream resourceStream(String resourcePath, String kind) {
        // First pass: collect each combo's raw layer map (text or same_as ref) without resolving.
                );
        Map<String, Object> root = parseYaml(goldenResourcePath);
            ) {
        return is;
     */
 */
        Object rawLayerValue,
    private static Map<String, Object> parseYaml(String resourcePath) throws IOException {
    }
        if (plans == null) {
                if (referencedLayers == null) {
import java.util.Map;
            if (sameAs instanceof String referencedCombo) {
    }
        return s;
                        String.format(Locale.ROOT,
                            goldenResourcePath, combo, layerKey, referencedCombo
                String.format(Locale.ROOT, "golden '%s' has no 'applies' combos", goldenResourcePath)
                    throw new IllegalStateException(
            try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
     */
    private static String requiredString(Map<String, Object> root, String key, String goldenResourcePath) {
        }
import org.opensearch.common.xcontent.yaml.YamlXContent;
