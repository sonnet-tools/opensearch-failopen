    private SettingsComboRegistry(LinkedHashMap<String, SettingsCombo> byName, List<String> defaults) {  
            List<String> defaults = (List<String>) root.get("defaults");  
    /** Look up a combo by name, failing loudly if a golden references an undefined combo. */
        SettingsCombo combo = byName.get(name);
                String comboName = entry.getKey();
        }  
        return combo;
            return new SettingsComboRegistry(byName, defaults);  
    public List<String> defaults() {
                );
/*  
        try (InputStream is = SettingsComboRegistry.class.getClassLoader().getResourceAsStream(resourcePath)) {
 * SPDX-License-Identifier: Apache-2.0
                    String.format(Locale.ROOT, "combos.yaml has no 'combos' block: %s", resourcePath)
 * Loads and provides the named {@link SettingsCombo}s from the global {@code planshape/combos.yaml}
            }  
            for (Map.Entry<String, Object> entry : combos.entrySet()) {  
    /** Insertion-ordered (file order) so {@link #allNames()} reflects the combos.yaml order. */
                Map<String, Object> cluster = (Map<String, Object>) comboBody.getOrDefault("cluster", Map.of());
            Map<String, Object> root = parseYaml(is);
        this.byName = byName;
 * Goldens reference combos only by name.
                String.format(Locale.ROOT, "Unknown combo '%s' — defined combos: %s", name, byName.keySet())
                DeprecationHandler.IGNORE_DEPRECATIONS,
            )
import java.util.Map;
            if (defaults == null || defaults.isEmpty()) {
                    String.format(Locale.ROOT, "combos.yaml has no 'defaults' list: %s", resourcePath)  
            throw new IllegalArgumentException(  
import java.util.List;
    public List<String> allNames() {
import org.opensearch.common.xcontent.yaml.YamlXContent;
    /** Load and parse a {@code combos.yaml} classpath resource into named {@link SettingsCombo}s. */
public final class SettingsComboRegistry {  
import org.opensearch.core.xcontent.DeprecationHandler;
}  
        ) {
            return parser.map();  
                }
                        String.format(Locale.ROOT, "combo '%s' must declare index.%s", comboName, SettingsCombo.NUMBER_OF_SHARDS)
                is  
package org.opensearch.analytics.qa.planshape;
        }
        try (
    }
    private final List<String> defaults;
                    String.format(Locale.ROOT, "combos resource not found: %s", resourcePath)
        return List.copyOf(byName.keySet());
            if (combos == null || combos.isEmpty()) {
/**
                NamedXContentRegistry.EMPTY,
            }
 * compatible open source license.
                Map<String, Object> comboBody = (Map<String, Object>) entry.getValue();
    }  
            LinkedHashMap<String, SettingsCombo> byName = new LinkedHashMap<>();
import java.util.LinkedHashMap;  
            }
import org.opensearch.core.xcontent.XContentParser;
    }  
            XContentParser parser = YamlXContent.yamlXContent.createParser(  
import java.util.Locale;
    private final LinkedHashMap<String, SettingsCombo> byName;  
import java.io.IOException;  
 * — the single source of truth mapping each combo name to its plan-shape-affecting settings.  
            }
            if (is == null) {  
 */  
        this.defaults = defaults;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                throw new IllegalStateException(
    private static Map<String, Object> parseYaml(InputStream is) throws IOException {
                if (!index.containsKey(SettingsCombo.NUMBER_OF_SHARDS)) {  
    }
        }
                Map<String, Object> index = (Map<String, Object>) comboBody.getOrDefault("index", Map.of());
    public SettingsCombo byName(String name) {  
 *
    /** Every defined combo name, in file order. */  
                    );  
                byName.put(comboName, new SettingsCombo(comboName, cluster, index));  
            Map<String, Object> combos = (Map<String, Object>) root.get("combos");
        return defaults;  
                );  
            );
    public static SettingsComboRegistry load(String resourcePath) throws IOException {
        if (combo == null) {
 */
                );
import java.io.InputStream;
    @SuppressWarnings("unchecked")  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    }
    /** Combo names CI runs by default (the file's {@code defaults} list). */
                    throw new IllegalStateException(
    }
                throw new IllegalStateException(  
                throw new IllegalStateException(
