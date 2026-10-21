        int aliasesSize = in.readVInt();
     * GET /_template/my_template?filter_path=*.version
        public Builder(IndexTemplateMetadata indexTemplateMetadata) {
            toInnerXContent(indexTemplateMetadata, builder, params, false);
        }
        public Builder settings(Settings settings) {
            settings(indexTemplateMetadata.settings());
         * <p>
                builder.field("version", indexTemplateMetadata.version());
        this.name = name;
 * the Apache License, Version 2.0 (the "License"); you may
         * and not when directly updating stored templates. Index templates are still stored
         * nested under the type name.
            builder.field("index_patterns", indexTemplateMetadata.patterns());
            mappings.put(mappingType, new CompressedXContent(mappingSource));
        }
                    if ("order".equals(currentFieldName)) {
import org.opensearch.common.xcontent.XContentFactory;
        this.settings = settings;
            return builder.build();
        }
            aliases.put(aliasMetadata.alias(), aliasMetadata);
    @Override
            XContentBuilder builder = JsonXContent.contentBuilder();
     *   "index_patterns": ["my_index-*"],
                            }
        result = 31 * result + patterns.hashCode();
/*
    }
        return version();
    }
        if (!name.equals(that.name)) return false;
        }
                        builder.version(parser.intValue());
     * Expected usage:
                    } else if ("version".equals(currentFieldName)) {
            builder.startObject("aliases");
        private static void toInnerXContent(
import org.opensearch.OpenSearchParseException;
            }
    @Override
        out.writeInt(order);
                                if (mappingSource == null) {
        out.writeInt(order);
        return version;
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.core.xcontent.XContentParser;
    @Override
        public Builder putAlias(AliasMetadata.Builder aliasMetadata) {
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        result = 31 * result + mappings.hashCode();
 * license agreements. See the NOTICE file distributed with
        }
        out.writeOptionalVInt(version);
                                }
         * type name.
                    } else if ("index_patterns".equals(currentFieldName)) {
        int order,
            return this;
                        }
 */
                    currentFieldName = parser.currentName();
import java.io.IOException;
        builder.patterns(in.readStringList());
        }
 *
    private final Integer version;
    ) {
        builder.settings(Settings.readSettingsFromStream(in));
            assert mapping.keySet().size() == 1 : mapping.keySet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            } else {
 * GitHub history for details.
     * The version is an arbitrary number managed by the user so that they can easily and quickly verify the existence of a given template.
                        templateSettingsBuilder.normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
 * KIND, either express or implied.  See the License for the
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            IndexTemplateMetadata indexTemplateMetadata,
     * </code></pre>
     * <pre><code>
        try {
        }
     * @opensearch.api
         * Serializes the template to xContent, making sure not to nest mappings under the
                builder.map(documentMapping);
        }
        final Map<String, CompressedXContent> mappings,
        private List<String> indexPatterns;
    private final Map<String, AliasMetadata> aliases;
 * The OpenSearch Contributors require contributions made to
    private final int order;
    }
        int mappingsSize = in.readVInt();
            this.settings = settings;
            builder.putAlias(aliasMd);
 * this file be licensed under the Apache-2.0 license or a
        return this.settings;
    }
import java.util.Collections;
    public String toString() {
        IndexTemplateMetadata that = (IndexTemplateMetadata) o;
                    } else if ("mappings".equals(currentFieldName)) {
import org.opensearch.common.xcontent.json.JsonXContent;
            builder.endObject();
        );
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                if (token == XContentParser.Token.FIELD_NAME) {
     * Builder of index template metadata.
                builder.startObject("mappings").endObject();
        if (!patterns.equals(that.patterns)) return false;
    private final String name;
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    /**
                                    .map();
                        throw new OpenSearchParseException("unknown key [{}] for index template", currentFieldName);
            "aliases",
        public Builder(String name) {
                                String mappingType = currentFieldName;
        if (this == o) return true;
    @Nullable
        if (!settings.equals(that.settings)) return false;
                            builder.putAlias(AliasMetadata.Builder.fromXContent(parser));
        public Builder order(int order) {
    }
 * under the License.
            return null;
     * <pre><code>
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
        public Builder patterns(List<String> indexPatterns) {
        Settings settings,
        return this.name;
         */
        this.aliases = Collections.unmodifiableMap(aliases);
        private static String skipTemplateName(XContentParser parser) throws IOException {
import org.opensearch.core.common.io.stream.VerifiableWriteable;
                            } else if (token == XContentParser.Token.START_OBJECT) {
                "index-templates",
            AliasMetadata aliasMd = new AliasMetadata(in);
        @SuppressWarnings("unchecked")
        this.patterns = patterns;
            ToXContent.Params params
 * software distributed under the License is distributed on an
/*
            builder.startObject("settings");
        }
        @SuppressWarnings("unchecked")
            return this;
    public CompressedXContent mappings() {
            builder.endObject();
 * @opensearch.api
    public int getOrder() {
import java.util.Set;
        return readDiffFrom(IndexTemplateMetadata::readFrom, in);
            String currentFieldName = skipTemplateName(parser);
            } else {
            for (final AliasMetadata cursor : indexTemplateMetadata.aliases().values()) {
    public List<String> patterns() {
        }
         * and also in the REST layer when returning a deprecated typed response.
        }
    @Nullable
         * in the old, typed format, and have yet to be migrated to be typeless.
        out.writeMapValues(aliases, (stream, val) -> val.writeTo(stream));
        ) throws IOException {
        result = 31 * result + order;
    }
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeVInt(aliases.size());
            aliases = new HashMap<>();
                                String mappingType = mapping.keySet().iterator().next();
        final Map<String, AliasMetadata> aliases
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    @Nullable
                return mapping;
        List<String> patterns,
    public Settings settings() {
        for (int i = 0; i < aliasesSize; i++) {
                        parser.nextToken();
     * {
                            index_patterns.add(parser.text());
            CompressedXContent m = indexTemplateMetadata.mappings();
     *   "version": 1
 */
    public Integer getVersion() {
            builder.startObject(indexTemplateMetadata.name());
            patterns(indexTemplateMetadata.patterns());
            throw new IllegalArgumentException("Index patterns must not be null or empty; got " + patterns);
                                    // crap, no mapping source, warn?
 *
                if (token == XContentParser.Token.FIELD_NAME) {
            builder.endObject();
                    }
@PublicApi(since = "1.0.0")
 * Licensed to Elasticsearch under one or more contributor
                "Index template {} contains multiple typed mappings; templates in 8x will only support a single mapping",
import org.opensearch.core.common.io.stream.StreamInput;
                        }
                        List<String> index_patterns = new ArrayList<>();
import org.opensearch.common.annotation.PublicApi;
            builder.putMapping(in.readString(), CompressedXContent.readCompressedString(in));
                    }
    public Integer version() {
        this.order = order;
    public int order() {
        out.writeStringCollection(patterns);
        /**
import org.opensearch.common.settings.Settings;
        public static void toXContent(IndexTemplateMetadata indexTemplateMetadata, XContentBuilder builder, ToXContent.Params params)
                    } else {
        return this.name;
            cursor.writeTo(out);
            XContentParser.Token token;
        private static final Set<String> VALID_FIELDS = Sets.newHashSet(
            this.order = order;
        ) throws IOException {
public class IndexTemplateMetadata extends AbstractDiffable<IndexTemplateMetadata> implements VerifiableWriteable {
                        builder.order(parser.intValue());
                                builder.putMapping(mappingType, XContentFactory.jsonBuilder().map(mappingSource).toString());
     * check the template's content:
        out.writeStringCollection(patterns);
        private Integer version;
        }
        public Builder version(Integer version) {
        }
    // the mapping source should always include the type as top level
import java.util.List;
        }
            if (mapping.keySet().size() == 1
    private final Settings settings;
        if (order != that.order) return false;
     * Then, some process from the user can occasionally verify that the template exists with the appropriate version without having to
        }
                AliasMetadata.Builder.toXContent(cursor, builder, params);
                        }
import org.opensearch.common.collect.MapBuilder;
    private final Map<String, CompressedXContent> mappings;
    public String name() {
        public static IndexTemplateMetadata fromXContent(XContentParser parser, String templateName) throws IOException {
    }
            includeTypeName &= (params.paramAsBoolean("reduce_mappings", false) == false);
                        }
        public Builder settings(Settings.Builder settings) {
import java.io.UncheckedIOException;
        return this.aliases;
    public static Builder builder(String name) {
            return this;
            XContentParser.Token token = parser.nextToken();
            cursor.getValue().writeTo(out);
        }
     */
    public Map<String, AliasMetadata> aliases() {
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
        builder.version(in.readOptionalVInt());
import org.opensearch.cluster.Diff;
            );
            builder.endObject();
            "mappings",
        }
            "order",
        }
    }
         * This method is used for serializing templates before storing them in the cluster metadata,
    public CompressedXContent getMappings() {
 * Metadata for Index Templates
        for (int i = 0; i < mappingsSize; i++) {
            "index_patterns",
        return this.aliases;
            mappings = new HashMap<>(indexTemplateMetadata.mappings);
                }
        this.mappings = Collections.unmodifiableMap(mappings);
                    } else {
    }
                }
        out.writeString(name);
 * Unless required by applicable law or agreed to in writing,
        }
    }
                    String currentFieldName = parser.currentName();
    }
        return builder.build();
    }
                token = parser.nextToken();
        for (final Map.Entry<String, CompressedXContent> cursor : mappings.entrySet()) {
import org.opensearch.common.Nullable;
            mappings = new HashMap<>();
    }
     *   "mappings": { ... },
        return this.mappings.values().iterator().next();
 * this work for additional information regarding copyright
                    } else if ("aliases".equals(currentFieldName)) {
        private static Map<String, Object> reduceEmptyMapping(Map<String, Object> mapping) {
    }
        }
                builder.field("mappings");
import org.opensearch.core.common.io.stream.StreamOutput;
        static void toInnerXContentWithTypes(IndexTemplateMetadata indexTemplateMetadata, XContentBuilder builder, ToXContent.Params params)
            mappings.put(mappingType, mappingSource);
    }
        if (patterns == null || patterns.isEmpty()) {
                Map<String, Object> documentMapping = XContentHelper.convertToMap(m.uncompressed(), true).v2();
         * Serializes the template to xContent, using the legacy format where the mappings are
import org.opensearch.core.xcontent.ToXContent;
            return this;
        } catch (IOException e) {
    }
            out.writeString(cursor.getKey());
                            Map<String, Object> mapping = parser.mapOrdered();
            return this;
                            if (token == XContentParser.Token.FIELD_NAME) {
    }
        private Settings settings = Settings.Builder.EMPTY_SETTINGS;
        if (this.mappings.isEmpty()) {
     *
     * PUT /_template/my_template
            version(indexTemplateMetadata.version());
        public IndexTemplateMetadata build() {
            indexTemplateMetadata.settings().toXContent(builder, params);
            if (m != null) {
            aliases.put(aliasMetadata.alias(), aliasMetadata.build());
}
            throw new UncheckedIOException(e);
    private final List<String> patterns;
                                    .put(mappingType, parser.mapOrdered())
/*
        if (!mappings.equals(that.mappings)) return false;
        int result = name.hashCode();
                        Settings.Builder templateSettingsBuilder = Settings.builder();
        return Objects.equals(aliases, that.aliases) && Objects.equals(version, that.version);
                        builder.settings(templateSettingsBuilder.build());
            ToXContent.Params params,
 *
            this.name = indexTemplateMetadata.name();
         * Note that this method should currently only be used for creating REST responses,
                && mapping.containsKey(MapperService.SINGLE_MAPPING_NAME)
                return (Map<String, Object>) mapping.values().iterator().next();
        }
                        return currentFieldName;
            return null;
            return builder.toString();
                    if (VALID_FIELDS.contains(currentFieldName)) {
    public boolean equals(Object o) {
 * ownership. Elasticsearch licenses this file to you under
            "settings",
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
        out.writeOptionalVInt(version);
        if (o == null || getClass() != o.getClass()) return false;
    @Override
        private static Map<String, Object> reduceMapping(Map<String, Object> mapping) {
        private final Map<String, CompressedXContent> mappings;
            Builder builder = new Builder(templateName);
                } else if (token.isValue()) {
                    if ("settings".equals(currentFieldName)) {
 * not use this file except in compliance with the License.
            builder.startObject();
            builder.endObject();
                                currentFieldName = parser.currentName();
                } else if (token == XContentParser.Token.START_OBJECT) {
    }
    @PublicApi(since = "1.0.0")
        private final Map<String, AliasMetadata> aliases;
    @Override
        private int order;
                } else if (token == XContentParser.Token.START_ARRAY) {
            builder.startObject(indexTemplateMetadata.name());
import java.util.Objects;
            order(indexTemplateMetadata.order());
     * }
            XContentBuilder builder,
            toInnerXContent(indexTemplateMetadata, builder, params, true);
    public IndexTemplateMetadata(
        Integer version,
            this.indexPatterns = indexPatterns;
        public Builder putAlias(AliasMetadata aliasMetadata) {
                            }
        }
        String name,
                    documentMapping = reduceMapping(documentMapping);
            if (indexTemplateMetadata.version() != null) {
            builder.field("order", indexTemplateMetadata.order());
    public static IndexTemplateMetadata readFrom(StreamInput in) throws IOException {
        result = 31 * result + aliases.hashCode();
import org.opensearch.common.util.set.Sets;
    }
     */
            return this;
            }
        }
            toInnerXContent(indexTemplateMetadata, builder, params, true);
            throws IOException {
import org.opensearch.index.mapper.MapperService;
        return result;
                }
                } else {
                                    builder.putMapping(mappingType, mappingSource);
            return (Map<String, Object>) mapping.values().iterator().next();
    public String getName() {
        Settings.writeSettingsToStream(settings, out);
            deprecationLogger.deprecate(
                    documentMapping = reduceEmptyMapping(documentMapping);
            }
import org.opensearch.cluster.AbstractDiffable;
import java.util.ArrayList;
        Settings.writeSettingsToStream(settings, out);
            boolean includeTypeName
    }
                        templateSettingsBuilder.put(Settings.fromXContent(parser));
        if (this.mappings.size() > 1) {
            this.version = version;
                            if (mapping.size() == 1) {
import java.util.HashMap;
            "version"
                name
            }
    }
        for (final AliasMetadata cursor : aliases.values()) {
        this.version = version;
            Builder.toXContentWithTypes(this, builder, ToXContent.EMPTY_PARAMS);
import java.util.Map;
        out.writeString(name);
 */
        return this.order;
import org.opensearch.common.compress.CompressedXContent;
        }
                && ((Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME)).size() == 0) {
    public static class Builder {
        public Builder putMapping(String mappingType, String mappingSource) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 */
         * <p>
import org.opensearch.common.logging.DeprecationLogger;
            return new IndexTemplateMetadata(name, order, version, indexPatterns, settings, mappings, aliases);
            return this;
    }
            this.name = name;
 *
        return new Builder(name);
            return this;
            throws IOException {
        out.writeMap(mappings, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IndexTemplateMetadata.class);
        result = 31 * result + Objects.hashCode(version);
                                Map<String, Object> mappingSource = MapBuilder.<String, Object>newMapBuilder()
            }
        }
                    if ("mappings".equals(currentFieldName)) {
                if (includeTypeName == false) {
        }
                        // we just hit the template name, which should be ignored and we move on
    public Map<String, AliasMetadata> getAliases() {
            IndexTemplateMetadata indexTemplateMetadata,
        out.writeVInt(mappings.size());
                                String mappingSource = XContentFactory.jsonBuilder().map(mapping).toString();
        return order();
    /**
        result = 31 * result + settings.hashCode();
         */
        builder.order(in.readInt());
            }
                                } else {
            this.settings = settings.build();
        Builder builder = new Builder(in.readString());
        return this.patterns;
            XContentBuilder builder,
        /**
        }
 * specific language governing permissions and limitations
/**
        public Builder putMapping(String mappingType, CompressedXContent mappingSource) {
package org.opensearch.cluster.metadata;
        }
            aliases = new HashMap<>(indexTemplateMetadata.aliases());
                    }
        public static void toXContentWithTypes(
        private String name;
                    }
    public int hashCode() {
    public static Diff<IndexTemplateMetadata> readDiffFrom(StreamInput in) throws IOException {
        return this.mappings();
            if (token == XContentParser.Token.START_OBJECT) {
                        builder.patterns(index_patterns);
            return this;
     * </code></pre>
