                throw new IllegalStateException(
                    is
                    String.format(Locale.ROOT, "golden '%s' applies to combo '%s' but has no plans for it", goldenResourcePath, combo)  
import org.opensearch.core.xcontent.DeprecationHandler;
            throw new IllegalStateException(  
 * resolved here. An omitted layer means the layer is expected absent.  
    ) {  
        String queryId = requiredString(root, "query", goldenResourcePath);
            );  
        if (plans == null) {  
        }  
                }  
import java.util.Map;
import org.opensearch.common.xcontent.yaml.YamlXContent;
        }
    @SuppressWarnings("unchecked")  
 * A layer value is either literal plan text or a {@code {same_as: <combo>}} reference (one hop),
    }
                    throw new IllegalStateException(  
        Map<String, Object> plans = (Map<String, Object>) root.get("plans");
            );  
    private static InputStream resourceStream(String resourcePath, String kind) {
                            "golden '%s' combo '%s' layer '%s' references same_as '%s', which is not an applied combo",
            try (
        if (applies == null || applies.isEmpty()) {
        InputStream is = ExpectedQueryPlanLoader.class.getClassLoader().getResourceAsStream(resourcePath);  
                        String.format(Locale.ROOT,
            );
    @SuppressWarnings("unchecked")
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;  
    /** Read a required top-level string field from the parsed golden, failing if absent or non-string. */  
/**
    private static Map<String, Object> parseYaml(String resourcePath) throws IOException {
                String.format(Locale.ROOT, "golden '%s' must declare exactly one of 'ppl' or 'ppl_file'", goldenResourcePath)  
        }
 * this file be licensed under the Apache-2.0 license or a
        }
    public static ExpectedQueryPlan loadGolden(String goldenResourcePath, String queryDir) throws IOException {
    private static String resolveLayerText(  
                        )
                String.format(Locale.ROOT, "golden '%s' missing required string field '%s'", goldenResourcePath, key)
    }
    private ExpectedQueryPlanLoader() {}
        Map<String, Map<String, Object>> rawByCombo = new LinkedHashMap<>();
        String goldenResourcePath
        if (rawLayerValue instanceof Map) {
/*  
import java.util.LinkedHashMap;  
    private static String loadResource(String resourcePath) throws IOException {
import java.util.List;
                XContentParser parser = YamlXContent.yamlXContent.createParser(
            );
 * {@code applies} to, and under {@code plans} gives, per combo, the expected text for each layer.
        ) {
        Map<String, Map<String, Object>> rawByCombo,
    }
    private static String resolveQueryText(Map<String, Object> root, String queryDir, String goldenResourcePath) throws IOException {
            ) {
            throw new IllegalStateException(
        }
}  
        for (String combo : applies) {
            }
        return loadResource(queryDir + "/" + file).strip();  
        }  
                if (!(referencedText instanceof String literalText)) {
                Map<String, Object> referencedLayers = rawByCombo.get(referencedCombo);
        try (
        throw new IllegalStateException(
     * literal plan text, or a {@code {same_as: <otherCombo>}} map that reuses that other combo's text
    }
                        )
        return s;
        }
                    DeprecationHandler.IGNORE_DEPRECATIONS,
            }
import org.opensearch.core.xcontent.XContentParser;
 */
        }
        }  
                return parser.map();
            Map<String, String> textByLayerKey = new LinkedHashMap<>();
import java.io.InputStreamReader;
 * SPDX-License-Identifier: Apache-2.0
     * Load one query's {@code q{N}.plan.yaml} golden (at {@code goldenResourcePath} on the
            throw new IllegalStateException(String.format(Locale.ROOT, "%s resource not found: %s", kind, resourcePath));
                            goldenResourcePath, combo, layerKey, referencedCombo  
                    );
     * The expected plan text for one layer of one combo. A layer value in the golden is either the  
                        String.format(Locale.ROOT,
 * compatible open source license.
            Map<String, Object> rawLayers = rawByCombo.get(combo);  
        String layerKey,
            return literalText;
                )  
        Object file = root.get("ppl_file");  
import java.io.InputStream;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 *
        Map<String, Object> root = parseYaml(goldenResourcePath);
    /** Resolve query text from inline {@code ppl:} XOR referenced {@code ppl_file:}. */  
 * {@code ppl_file:} (path relative to the workload's query dir). It lists the combos it  
        // First pass: collect each combo's raw layer map (text or same_as ref) without resolving.  
                }  
        String queryText = resolveQueryText(root, queryDir, goldenResourcePath);
        if ((inline == null) == (file == null)) {
            InputStream is = resourceStream(resourcePath, "query");  
        );  
                );
            for (Map.Entry<String, Object> layer : rawLayers.entrySet()) {
        }
    /**  
     */
        Object rawLayerValue,
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
        String combo,  
            String.format(Locale.ROOT, "golden '%s' combo '%s' layer '%s' is neither text nor a same_as map", goldenResourcePath, combo, layerKey)
     * {@code ppl_file} under {@code queryDir}) and the per-combo, per-layer expected plan text,  
            throw new IllegalStateException(
                    NamedXContentRegistry.EMPTY,  
            if (sameAs instanceof String referencedCombo) {  
    }
                Object referencedText = referencedLayers.get(layerKey);
                            "golden '%s' combo '%s' layer '%s' same_as '%s' must point at literal text (no chained same_as / missing layer)",
     * resolving any {@code same_as} references.
        try (InputStream is = resourceStream(resourcePath, "golden")) {  
            }
    private static String requiredString(Map<String, Object> root, String key, String goldenResourcePath) {
import java.util.Locale;
                    );
    }  
import java.util.stream.Collectors;  
     */
    /** Open a classpath resource (from this class's loader), failing with a {@code kind}-tagged message. */
        Object inline = root.get("ppl");
        Object value = root.get(key);
import java.io.IOException;
                            goldenResourcePath, combo, layerKey, referencedCombo  
        if (inline != null) {  
 *
        return new ExpectedQueryPlan(queryId, queryText, applies, resolvedByCombo);
        return is;
                return literalText;
 */  
 * <p>The golden declares the query EXACTLY ONE way: inline {@code ppl:} or a referenced
            if (comboPlans == null) {
                textByLayerKey.put(layer.getKey(), resolveLayerText(layer.getValue(), rawByCombo, combo, layer.getKey(), goldenResourcePath));  
     * latter — one hop only; the target must itself be literal text.  
        if (!(value instanceof String s)) {  
            resolvedByCombo.put(combo, textByLayerKey);
        List<String> applies = (List<String>) root.get("applies");
package org.opensearch.analytics.qa.planshape;
        // Second pass: resolve same_as (one hop) into concrete layer text.  
            throw new IllegalStateException(
 * Loads one query's {@code q{N}.plan.yaml} golden into an {@link ExpectedQueryPlan}.  
        if (is == null) {
     * for the same layer verbatim (so identical plans aren't duplicated across combos). Resolves the
            rawByCombo.put(combo, (Map<String, Object>) comboPlans);  
                String.format(Locale.ROOT, "golden '%s' has no 'plans' block", goldenResourcePath)
                    throw new IllegalStateException(  
 * The OpenSearch Contributors require contributions made to  
        for (String combo : applies) {
     * classpath) into an {@link ExpectedQueryPlan}: resolves the query text (inline {@code ppl} or a
        if (rawLayerValue instanceof String literalText) {
            return reader.lines().collect(Collectors.joining("\n"));  
    }  
    /**
public final class ExpectedQueryPlanLoader {
            Object sameAs = ((Map<String, Object>) rawLayerValue).get("same_as");
            return ((String) inline).strip();
            }  
            Object comboPlans = plans.get(combo);  
        }  
                String.format(Locale.ROOT, "golden '%s' has no 'applies' combos", goldenResourcePath)
        Map<String, Map<String, String>> resolvedByCombo = new LinkedHashMap<>();
        }  
                if (referencedLayers == null) {
