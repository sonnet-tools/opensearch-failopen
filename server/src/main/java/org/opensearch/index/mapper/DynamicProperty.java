        this.pattern = pattern;
    }  
 * <p><b>Mapping merge (PUT mapping / templates):</b> For {@link MapperService.MergeReason#MAPPING_UPDATE}  
 * entire mapping document). {@link MapperService.MergeReason#MAPPING_RECOVERY} applies the persisted
 * lists one pattern therefore does <em>not</em> remove other patterns (unlike a full replacement of the
import org.opensearch.core.xcontent.ToXContentObject;  
        return result;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
        return processMap(mapping, fieldName);  
 * the same pattern string as an existing entry replaces that entry’s mapping. A partial body that only  
    private Map<String, Object> processMap(Map<String, Object> map, String fieldName) {
import java.util.Map;
                        );
                value = processMap(nested, fieldName);
 * mapping as a whole. Implementation: {@link RootObjectMapper#doMerge}.  
    public Map<String, Object> mappingForName(String fieldName) {
        this.mapping = mapping;  
     * Nested maps are processed recursively so keys at every level get the same substitution.
/*  
import org.opensearch.core.xcontent.XContentBuilder;
     */
 * compatible open source license.
            }
                    }
     * Returns a copy of the mapping suitable for parsing a concrete field. {@code fieldName} is the  
import org.opensearch.common.annotation.PublicApi;
        return mapping;
 * <strong>merged by pattern key</strong> with the existing root mapping: new pattern keys are added;
                    if ((e.getKey() instanceof String) == false) {
    /** Returns the mapping configuration for matching fields (e.g. type and options). */
 * The OpenSearch Contributors require contributions made to  
     * (e.g. {@code parent.count_i}), not only the leaf segment, so patterns may include {@code .} in
     * the matched text. Uses the same simple wildcard matching as dynamic_templates.
 * new field definitions into the cluster state mapping (no mapping-update round trip for that
                }
    /**
    @Override
 * <p>The pattern key {@code *} alone is not allowed in {@code dynamic_properties}; each pattern must
    public String getPattern() {
import java.util.TreeMap;
 * field name with one rule, use {@code dynamic_templates} on the root mapping instead.
}
        return pattern;
    }  
        return Regex.simpleMatch(pattern, fieldName);
 *
        return builder;
        }
 *
 */  
    }  
 *
            result.put(key, value);  
 * the pattern is mapped using the same configuration without updating the index mapping.  
    public DynamicProperty(String pattern, Map<String, Object> mapping) {
 * <p><b>Operational note:</b> When a document field matches a dynamic property, ingest builds  
 *
 * {@link FieldMapper} instances and indexes using that configuration <em>without</em> persisting
    }
 * @opensearch.api
    private final String pattern;
        Map<String, Object> result = new TreeMap<>();  
    }  
    /**  
 * field). That is intentional for performance and matches Solr-style dynamic fields.  
     * Returns whether the given name matches this dynamic property's pattern.
/**
                for (Map.Entry<?, ?> e : rawNested.entrySet()) {  
                Map<String, Object> nested = new TreeMap<>();
public class DynamicProperty implements ToXContentObject {
     * Non-map, non-string values (numbers, booleans, lists, etc.) are left unchanged.  
            Object value = entry.getValue();  
        builder.field(pattern, new TreeMap<>(mapping));
package org.opensearch.index.mapper;
 * Similar to Solr dynamic fields; avoids cluster state updates for high-throughput ingestion.
 * this file be licensed under the Apache-2.0 license or a
                value = value.toString().replace("{name}", fieldName);
    }
@PublicApi(since = "3.0.0")
            if (value instanceof Map<?, ?> rawNested) {
 * SPDX-License-Identifier: Apache-2.0
    public boolean matches(String fieldName) {
                            "dynamic_property nested mapping must use string keys; got [" + e.getKey() + "]"  
 * A dynamic property defines a pattern-based mapping: any field whose name matches
import org.opensearch.common.regex.Regex;
     * <strong>leaf</strong> segment (e.g. {@code count_i} when the full path is {@code parent.count_i});
     * Deep-copies mapping options, substituting {@code {name}} in each map key and in string values.
                    nested.put((String) e.getKey(), e.getValue());  
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 */  
 * and {@link MapperService.MergeReason#INDEX_TEMPLATE}, incoming {@code dynamic_properties} are
     * {@code {name}} placeholders substitute that leaf. Pattern matching uses the full dotted path
                        throw new IllegalArgumentException(
     */
    }
 *
            } else if (value instanceof String) {  
    /** Returns the wildcard pattern (e.g. {@code *_i}, {@code *}). */  
 * contain {@code *} as part of a more specific glob (e.g. {@code *_i}). To default-type every unknown  
    public Map<String, Object> getMapping() {  
     * (see {@link #matches}).  
    private final Map<String, Object> mapping;
            String key = entry.getKey().replace("{name}", fieldName);
import java.io.IOException;  
     * At ingest and query, the name is the <strong>full dotted path</strong> from the mapping root  
     */  
