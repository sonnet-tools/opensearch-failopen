        }
     * <pre><code>
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
            templateSettingsBuilder.put(Settings.fromXContent(p));  
        Integer version,
        if (patterns == null || patterns.isEmpty()) {
            aliases = new HashMap<>();
        }
    public String name() {
        this.name = name;
            return new IndexTemplateMetadata(name, order, version, indexPatterns, settings, mappings, aliases);
     * PUT /_template/my_template
 * not use this file except in compliance with the License.
     * Then, some process from the user can occasionally verify that the template exists with the appropriate version without having to  
        }
            if (mapping.isEmpty()) {  
/*
    public int order() {  
    public Integer version() {
            aliases.put(aliasMetadata.alias(), aliasMetadata);
     * GET /_template/my_template?filter_path=*.version  
 * Unless required by applicable law or agreed to in writing,
    private static final ConstructingObjectParser<IndexTemplateMetadata, String> PARSER = new ConstructingObjectParser<>(  
    public boolean equals(Object o) {  
            version(indexTemplateMetadata.version());
            }
 * the Apache License, Version 2.0 (the "License"); you may
        public Builder(String name) {
    static {  
    private final Integer version;
        IndexTemplateMetadata that = (IndexTemplateMetadata) o;  
 * Modifications Copyright OpenSearch Contributors. See  
     */
        public Builder version(Integer version) {
            Settings.Builder templateSettingsBuilder = Settings.builder();
 *
    }
        public Builder(IndexTemplateMetadata indexTemplateMetadata) {
            optionalConstructorArg(),  
    public static class Builder {  
            return this;
                return null;
 */
    private final String name;  
    private final int order;
            this.mappings = mappings;
/*
            return PARSER.parse(parser, templateName);  
    }
        this.mappings = mappings;
        }  
        }
            && Objects.equals(patterns, that.patterns)
        public static IndexTemplateMetadata fromXContent(XContentParser parser, String templateName) throws IOException {
 * this work for additional information regarding copyright
            List<Map.Entry<String, AliasMetadata>> alias = (List<Map.Entry<String, AliasMetadata>>) a[5];
        "IndexTemplateMetadata",
    @Nullable  
        }  
        Settings settings,
        PARSER.declareNamedObjects(
    }  
            templateSettingsBuilder.normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
        private int order;
        private final Map<String, AliasMetadata> aliases;
import java.util.Collections;  
        private Settings settings = Settings.Builder.EMPTY_SETTINGS;
        }
        this.order = order;  
            return this;
import java.io.IOException;
        int order,
     * </code></pre>
        public Builder order(int order) {  
            aliases = new HashMap<>(indexTemplateMetadata.aliases());  
            settings(indexTemplateMetadata.settings());  
        if (o == null || getClass() != o.getClass()) return false;
        return new Builder(name);
 *    http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareInt(optionalConstructorArg(), new ParseField("version"));
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> {
    public Map<String, AliasMetadata> aliases() {  
    private final List<String> patterns;  
                (List<String>) a[2],
        }
            new ParseField("aliases")
    @Override
 * under the License.  
        this.aliases = Collections.unmodifiableMap(aliases);
        }, new ParseField("mappings"));
     * }
        true,
        private List<String> indexPatterns;
        }  
    public List<String> patterns() {  
     *   "version": 1  
        public Builder patterns(List<String> indexPatterns) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.aliases;
        public Builder settings(Settings.Builder settings) {  
        private Integer version;  
            Map<String, Object> mapping = p.map();
import org.opensearch.cluster.metadata.MappingMetadata;
        public Builder putAlias(AliasMetadata.Builder aliasMetadata) {
    @SuppressWarnings("unchecked")
        return version;  
     * check the template's content:
        }
    ) {
 * GitHub history for details.
            && Objects.equals(version, that.version)  
    /**
            && Objects.equals(name, that.name)
        }, new ParseField("settings"));  
        public Builder putAlias(AliasMetadata aliasMetadata) {  
            throw new IllegalArgumentException("Index patterns must not be null or empty; got " + patterns);  
/*  
 * software distributed under the License is distributed on an
            order(indexTemplateMetadata.order());  
 */  
import java.util.stream.Collectors;
        PARSER.declareStringArray(optionalConstructorArg(), new ParseField("index_patterns"));  
import java.util.Objects;
            mappings = indexTemplateMetadata.mappings();
        final Map<String, AliasMetadata> aliases  
            return new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, mapping);  
    public static Builder builder(String name) {
     * </code></pre>
     * <pre><code>
        }
     *   "index_patterns": ["my_index-*"],
import java.util.List;
    @Nullable
    }
package org.opensearch.client.indices;
        MappingMetadata mappings,
import org.opensearch.core.xcontent.ConstructingObjectParser;  
import org.opensearch.cluster.metadata.AliasMetadata;  
                (Settings) a[3],
 * specific language governing permissions and limitations
        PARSER.declareInt(optionalConstructorArg(), new ParseField("order"));
    }
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> {
                (MappingMetadata) a[4],  
        }
 * ownership. Elasticsearch licenses this file to you under  
            return new IndexTemplateMetadata(  
        public IndexTemplateMetadata build() {
 * SPDX-License-Identifier: Apache-2.0
    }  
    public IndexTemplateMetadata(
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            return this;  
            && Objects.equals(aliases, that.aliases);
        (a, name) -> {  
 *  
            && Objects.equals(settings, that.settings)
            );
     * Expected usage:  
    );
        return this.patterns;
        );  
 */
        this.settings = settings;  
import org.opensearch.common.Nullable;  
 * compatible open source license.
}  
        }  
        String name,  
            return this;
        this.version = version;
            this.settings = settings;  
    }
    }  
            this.version = version;  
            && Objects.equals(mappings, that.mappings)  
                (Integer) a[1],  
            this.indexPatterns = indexPatterns;
     * {  
import java.util.AbstractMap;
            final Map<String, AliasMetadata> aliasMap = alias.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    private final MappingMetadata mappings;
            mappings = null;  
        List<String> patterns,  
    private final Map<String, AliasMetadata> aliases;  
 * KIND, either express or implied.  See the License for the
        return Objects.hash(name, order, version, patterns, settings, mappings, aliases);  
    }
    }
import org.opensearch.core.ParseField;
            aliases.put(aliasMetadata.alias(), aliasMetadata.build());  
    @Override
 * The OpenSearch Contributors require contributions made to  
    private final Settings settings;
                aliasMap
            (p, c, name) -> new AbstractMap.SimpleEntry<>(name, AliasMetadata.Builder.fromXContent(p)),
            return this;
            return templateSettingsBuilder.build();
        return this.name;  
        if (this == o) return true;
    public MappingMetadata mappings() {
 * Licensed to Elasticsearch under one or more contributor  
                (Integer) a[0],
import org.opensearch.cluster.metadata.IndexMetadata;
            this.name = name;
     * The version is an arbitrary number managed by the user so that they can easily and quickly verify the existence of a given template.
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
public class IndexTemplateMetadata {  
        return this.order;
            return this;  
 *
            this.settings = settings.build();
        public Builder mapping(MappingMetadata mappings) {
        return this.settings;
        public Builder settings(Settings settings) {
        }  
    }
                name,
        private MappingMetadata mappings;  
    public Settings settings() {
import java.util.HashMap;
        return order == that.order
        return this.mappings;  
     *   "mappings": { ... },
 * You may obtain a copy of the License at  
            return this;
            patterns(indexTemplateMetadata.patterns());
    public int hashCode() {
import org.opensearch.common.settings.Settings;
        this.patterns = patterns;
            this.order = order;
        private String name;
import org.opensearch.index.mapper.MapperService;
    }
            return this;
    }
            this.name = indexTemplateMetadata.name();
