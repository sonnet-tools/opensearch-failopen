import java.util.Objects;
        private MappingMetadata mappings;
     * GET /_template/my_template?filter_path=*.version
        private int order;
                (Integer) a[0],
        List<String> patterns,
/*
public class IndexTemplateMetadata {
        public static IndexTemplateMetadata fromXContent(XContentParser parser, String templateName) throws IOException {
            Settings.Builder templateSettingsBuilder = Settings.builder();
    private static final ConstructingObjectParser<IndexTemplateMetadata, String> PARSER = new ConstructingObjectParser<>(
            this.indexPatterns = indexPatterns;
 */
            optionalConstructorArg(),
    }
 */
        (a, name) -> {
/*
            return new IndexTemplateMetadata(
 *
        public Builder putAlias(AliasMetadata aliasMetadata) {
            return this;
            }
 * ownership. Elasticsearch licenses this file to you under
        private final Map<String, AliasMetadata> aliases;
    }
        this.settings = settings;
                (List<String>) a[2],
    static {
import java.util.HashMap;
    }
            this.settings = settings.build();
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import java.util.stream.Collectors;
 *
            this.settings = settings;
/*
     * check the template's content:
    }
            patterns(indexTemplateMetadata.patterns());
        return this.name;
import org.opensearch.cluster.metadata.AliasMetadata;
     * The version is an arbitrary number managed by the user so that they can easily and quickly verify the existence of a given template.
    public boolean equals(Object o) {
            templateSettingsBuilder.put(Settings.fromXContent(p));
        if (patterns == null || patterns.isEmpty()) {
        true,
    @Override
                (MappingMetadata) a[4],
            aliases.put(aliasMetadata.alias(), aliasMetadata);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                aliasMap
 * software distributed under the License is distributed on an
     * <pre><code>
            return this;
        return this.order;
import java.util.Map;
            order(indexTemplateMetadata.order());
    }
    }
     * PUT /_template/my_template
        );
 * Licensed to Elasticsearch under one or more contributor
    public MappingMetadata mappings() {
        Integer version,
 * compatible open source license.
        this.order = order;
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
    }
 * under the License.
        return new Builder(name);
        private Settings settings = Settings.Builder.EMPTY_SETTINGS;
     *   "index_patterns": ["my_index-*"],
    ) {
            version(indexTemplateMetadata.version());
 */
    }
            && Objects.equals(name, that.name)
import org.opensearch.common.settings.Settings;
            && Objects.equals(version, that.version)
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> {
     */
     *   "version": 1
        this.version = version;
     * Then, some process from the user can occasionally verify that the template exists with the appropriate version without having to
            aliases.put(aliasMetadata.alias(), aliasMetadata.build());
 * not use this file except in compliance with the License.
    @Nullable
 * this file be licensed under the Apache-2.0 license or a
        }
        public Builder(IndexTemplateMetadata indexTemplateMetadata) {
import org.opensearch.cluster.metadata.MappingMetadata;
    private final List<String> patterns;
            && Objects.equals(settings, that.settings)
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public String name() {
    @Nullable
 * The OpenSearch Contributors require contributions made to
        return this.aliases;
            aliases = new HashMap<>(indexTemplateMetadata.aliases());
        PARSER.declareInt(optionalConstructorArg(), new ParseField("version"));
    private final Map<String, AliasMetadata> aliases;
            (p, c, name) -> new AbstractMap.SimpleEntry<>(name, AliasMetadata.Builder.fromXContent(p)),
            settings(indexTemplateMetadata.settings());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return this;
            Map<String, Object> mapping = p.map();
     * Expected usage:
import org.opensearch.core.ParseField;
    );
 * You may obtain a copy of the License at
        "IndexTemplateMetadata",
            return this;
                (Integer) a[1],
}
        String name,
        int order,
import java.util.List;
        if (o == null || getClass() != o.getClass()) return false;
        return this.settings;
            return new IndexTemplateMetadata(name, order, version, indexPatterns, settings, mappings, aliases);
        this.mappings = mappings;
    public List<String> patterns() {
    public Settings settings() {
    private final Integer version;
            mappings = null;
            this.order = order;
        MappingMetadata mappings,
import org.opensearch.cluster.metadata.IndexMetadata;
    }
 * Unless required by applicable law or agreed to in writing,
    public IndexTemplateMetadata(
    @SuppressWarnings("unchecked")
import java.util.Collections;
 * specific language governing permissions and limitations
        private String name;
        final Map<String, AliasMetadata> aliases
        }
            && Objects.equals(patterns, that.patterns)
        PARSER.declareNamedObjects(
    public static Builder builder(String name) {
        public Builder putAlias(AliasMetadata.Builder aliasMetadata) {
            && Objects.equals(mappings, that.mappings)
        public Builder mapping(MappingMetadata mappings) {
        }
    }
        }
    }
            aliases = new HashMap<>();
            return this;
        }
    }
    private final int order;
            final Map<String, AliasMetadata> aliasMap = alias.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    private final Settings settings;
 * SPDX-License-Identifier: Apache-2.0
        return order == that.order
            return this;
        private Integer version;
        return version;
import org.opensearch.index.mapper.MapperService;
            this.name = indexTemplateMetadata.name();
            );
            new ParseField("aliases")
 * the Apache License, Version 2.0 (the "License"); you may
            return this;
        public Builder version(Integer version) {
        public Builder settings(Settings settings) {
        }
        public Builder settings(Settings.Builder settings) {
 *
        return this.patterns;
import org.opensearch.common.Nullable;
        this.name = name;
        }, new ParseField("settings"));
        private List<String> indexPatterns;
     * </code></pre>
import java.io.IOException;
                return null;
    private final String name;
    public int order() {
        }
        PARSER.declareInt(optionalConstructorArg(), new ParseField("order"));
 * this work for additional information regarding copyright
            this.name = name;
        this.aliases = Collections.unmodifiableMap(aliases);
        public Builder order(int order) {
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException("Index patterns must not be null or empty; got " + patterns);
        public Builder(String name) {
import java.util.AbstractMap;
            return PARSER.parse(parser, templateName);
        if (this == o) return true;
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> {
        }, new ParseField("mappings"));
        PARSER.declareStringArray(optionalConstructorArg(), new ParseField("index_patterns"));
            templateSettingsBuilder.normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
     * </code></pre>
    }
     * <pre><code>
        IndexTemplateMetadata that = (IndexTemplateMetadata) o;
            if (mapping.isEmpty()) {
        }
 * license agreements. See the NOTICE file distributed with
package org.opensearch.client.indices;
    public Integer version() {
        }
    @Override
        }
            this.mappings = mappings;
            && Objects.equals(aliases, that.aliases);
    public int hashCode() {
        return this.mappings;
        Settings settings,
            this.version = version;
     *   "mappings": { ... },
    /**
            return new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, mapping);
        public Builder patterns(List<String> indexPatterns) {
        }
     * {
                (Settings) a[3],
            List<Map.Entry<String, AliasMetadata>> alias = (List<Map.Entry<String, AliasMetadata>>) a[5];
    public static class Builder {
            return templateSettingsBuilder.build();
        }
                name,
 * GitHub history for details.
        public IndexTemplateMetadata build() {
    public Map<String, AliasMetadata> aliases() {
        return Objects.hash(name, order, version, patterns, settings, mappings, aliases);
        this.patterns = patterns;
        }
    private final MappingMetadata mappings;
     * }
            return this;
            mappings = indexTemplateMetadata.mappings();
