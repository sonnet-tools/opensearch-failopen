        this.mappings = Collections.unmodifiableMap(mappings);
            return this;
import org.opensearch.common.util.set.Sets;  
     * PUT /_template/my_template
    /**
    public Map<String, AliasMetadata> getAliases() {
            "version"
        }  
            ToXContent.Params params
                                String mappingType = mapping.keySet().iterator().next();
        this.version = version;
        public Builder putAlias(AliasMetadata.Builder aliasMetadata) {
                        // we just hit the template name, which should be ignored and we move on  
        public Builder putMapping(String mappingType, String mappingSource) throws IOException {  
import org.opensearch.common.Nullable;  
 *
        return this.settings;
        out.writeMap(mappings, StreamOutput::writeString, (stream, val) -> val.writeTo(stream));  
        return order();
        return builder.build();
        public static void toXContentWithTypes(
                        }
        out.writeInt(order);  
 *  
            aliases.put(aliasMetadata.alias(), aliasMetadata.build());
    public Map<String, AliasMetadata> aliases() {
            "settings",
                            if (token == XContentParser.Token.FIELD_NAME) {
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import org.opensearch.common.xcontent.XContentHelper;
                        builder.version(parser.intValue());
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
            this.version = version;  
         */
                                currentFieldName = parser.currentName();
 */  
        for (int i = 0; i < aliasesSize; i++) {  
        if (!mappings.equals(that.mappings)) return false;  
import java.util.Collections;
         * This method is used for serializing templates before storing them in the cluster metadata,
        return this.name;  
            assert mapping.keySet().size() == 1 : mapping.keySet();
            "index_patterns",  
        for (final Map.Entry<String, CompressedXContent> cursor : mappings.entrySet()) {
import org.opensearch.common.logging.DeprecationLogger;
        @SuppressWarnings("unchecked")
    @Nullable
        return result;
            if (token == XContentParser.Token.START_OBJECT) {
 * KIND, either express or implied.  See the License for the
            builder.endObject();
        out.writeMapValues(aliases, (stream, val) -> val.writeTo(stream));
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    private final List<String> patterns;  
        builder.patterns(in.readStringList());
        int aliasesSize = in.readVInt();
        public Builder patterns(List<String> indexPatterns) {
            order(indexTemplateMetadata.order());  
            Builder builder = new Builder(templateName);
        }
 * Unless required by applicable law or agreed to in writing,
                    }
            } else {
        this.patterns = patterns;  
                    if (VALID_FIELDS.contains(currentFieldName)) {  
        builder.settings(Settings.readSettingsFromStream(in));  
            XContentBuilder builder = JsonXContent.contentBuilder();
        private int order;
         * type name.
import org.opensearch.index.mapper.MapperService;
        return this.aliases;
                "index-templates",
            builder.endObject();
        public Builder(IndexTemplateMetadata indexTemplateMetadata) {
            return (Map<String, Object>) mapping.values().iterator().next();  
                Map<String, Object> documentMapping = XContentHelper.convertToMap(m.uncompressed(), true).v2();  
         * and also in the REST layer when returning a deprecated typed response.  
                        parser.nextToken();
            for (final AliasMetadata cursor : indexTemplateMetadata.aliases().values()) {
    public int order() {
import java.io.UncheckedIOException;
    @Override
            "order",  
/*  
        out.writeOptionalVInt(version);
import org.opensearch.core.common.io.stream.StreamInput;
            return this;  
import java.util.Set;  
            patterns(indexTemplateMetadata.patterns());
            deprecationLogger.deprecate(
package org.opensearch.cluster.metadata;
     *   "version": 1  
        private String name;
                    } else {
            );
    public Integer version() {
                                    builder.putMapping(mappingType, mappingSource);
    }  
            out.writeString(cursor.getKey());
        private Integer version;  
                    }  
            builder.startObject("aliases");  
     * <pre><code>
     *   "mappings": { ... },
        );  
        }
         */
    private final int order;
        public Builder order(int order) {  
        }
        }  
         * Serializes the template to xContent, making sure not to nest mappings under the
        Settings.writeSettingsToStream(settings, out);
    private final Map<String, AliasMetadata> aliases;
    }
            builder.putAlias(aliasMd);
        }
                return (Map<String, Object>) mapping.values().iterator().next();  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        public Builder putAlias(AliasMetadata aliasMetadata) {
            cursor.writeTo(out);
         * Serializes the template to xContent, using the legacy format where the mappings are
            XContentParser.Token token;
            includeTypeName &= (params.paramAsBoolean("reduce_mappings", false) == false);  
        return version;
        }
        }
                    documentMapping = reduceMapping(documentMapping);
                                    .map();
                if (token == XContentParser.Token.FIELD_NAME) {
            }  
 * not use this file except in compliance with the License.
import java.util.Objects;
        }  
        this.name = name;  
                            index_patterns.add(parser.text());  
        result = 31 * result + settings.hashCode();
        out.writeStringCollection(patterns);
            this.settings = settings.build();
            if (indexTemplateMetadata.version() != null) {  
        if (!patterns.equals(that.patterns)) return false;  
            toInnerXContent(indexTemplateMetadata, builder, params, true);
        public Builder version(Integer version) {
            return this;  
    @Override
                && ((Map<String, Object>) mapping.get(MapperService.SINGLE_MAPPING_NAME)).size() == 0) {
import org.opensearch.common.compress.CompressedXContent;  
            builder.putMapping(in.readString(), CompressedXContent.readCompressedString(in));  
            throw new UncheckedIOException(e);
        }
 * SPDX-License-Identifier: Apache-2.0
        private static void toInnerXContent(
        builder.version(in.readOptionalVInt());
            this.order = order;
 * You may obtain a copy of the License at  
        String name,
            return this;
            this.indexPatterns = indexPatterns;
                            Map<String, Object> mapping = parser.mapOrdered();  
 * under the License.  
                    if ("settings".equals(currentFieldName)) {  
     * The version is an arbitrary number managed by the user so that they can easily and quickly verify the existence of a given template.
                name
                    } else if ("version".equals(currentFieldName)) {
                                } else {
            throws IOException {
                "Index template {} contains multiple typed mappings; templates in 8x will only support a single mapping",  
 */  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    }
                    } else if ("index_patterns".equals(currentFieldName)) {  
        }  
    }
    public static class Builder {  
    @Nullable  
            throw new IllegalArgumentException("Index patterns must not be null or empty; got " + patterns);
                    documentMapping = reduceEmptyMapping(documentMapping);
            builder.field("index_patterns", indexTemplateMetadata.patterns());  
import org.opensearch.common.settings.Settings;
            if (mapping.keySet().size() == 1  
    private final String name;  
 * the Apache License, Version 2.0 (the "License"); you may
                    } else if ("aliases".equals(currentFieldName)) {
            "mappings",
                            if (mapping.size() == 1) {
        }
    }  
        private final Map<String, AliasMetadata> aliases;
         * nested under the type name.  
        return this.name;
        result = 31 * result + patterns.hashCode();
    }  
        public IndexTemplateMetadata build() {  
                } else {  
            builder.startObject(indexTemplateMetadata.name());
                                    .put(mappingType, parser.mapOrdered())  
 * Modifications Copyright OpenSearch Contributors. See  
    @PublicApi(since = "1.0.0")
        return this.order;  
         * <p>  
    }
            builder.startObject(indexTemplateMetadata.name());
import java.util.HashMap;
        }
    }
    public String toString() {  
        out.writeString(name);
        int result = name.hashCode();
        }
            return this;
        out.writeVInt(aliases.size());
     */
        public Builder(String name) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         * Note that this method should currently only be used for creating REST responses,
            AliasMetadata aliasMd = new AliasMetadata(in);
        return Objects.equals(aliases, that.aliases) && Objects.equals(version, that.version);
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                        builder.order(parser.intValue());  
            boolean includeTypeName  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
                        builder.settings(templateSettingsBuilder.build());
import org.opensearch.core.xcontent.XContentParser;
                builder.map(documentMapping);
        return version();  
        private List<String> indexPatterns;
                if (token == XContentParser.Token.FIELD_NAME) {  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        for (int i = 0; i < mappingsSize; i++) {
    public CompressedXContent getMappings() {  
        static void toInnerXContentWithTypes(IndexTemplateMetadata indexTemplateMetadata, XContentBuilder builder, ToXContent.Params params)  
 * GitHub history for details.
        return this.mappings();
    public Settings settings() {
                            builder.putAlias(AliasMetadata.Builder.fromXContent(parser));
    @Override  
            aliases = new HashMap<>(indexTemplateMetadata.aliases());  
            IndexTemplateMetadata indexTemplateMetadata,  
        return this.aliases;  
                }
        }
    }
/*
}
         * and not when directly updating stored templates. Index templates are still stored
            }
    public Integer getVersion() {
            builder.field("order", indexTemplateMetadata.order());
 * license agreements. See the NOTICE file distributed with
            this.name = indexTemplateMetadata.name();
    public void writeTo(StreamOutput out) throws IOException {
        }
import java.util.List;  
            }
     * Then, some process from the user can occasionally verify that the template exists with the appropriate version without having to  
            cursor.getValue().writeTo(out);  
                    } else {  
        int order,
 * Metadata for Index Templates  
                } else if (token == XContentParser.Token.START_ARRAY) {  
        private static String skipTemplateName(XContentParser parser) throws IOException {  
                            }  
        result = 31 * result + mappings.hashCode();  
import org.opensearch.cluster.Diff;
     * {  
        private static Map<String, Object> reduceEmptyMapping(Map<String, Object> mapping) {
                            }
        }
        @SuppressWarnings("unchecked")  
        public Builder settings(Settings settings) {
        int mappingsSize = in.readVInt();
        if (this == o) return true;  
        try {
                        }
            return null;  
 *
    public static Builder builder(String name) {  
         * <p>
        }  
        }
                                    // crap, no mapping source, warn?  
        Settings settings,
        this.settings = settings;
     * GET /_template/my_template?filter_path=*.version  
            if (m != null) {
                    }
        out.writeString(name);
import java.util.ArrayList;  
        if (order != that.order) return false;
            Builder.toXContentWithTypes(this, builder, ToXContent.EMPTY_PARAMS);
        if (this.mappings.size() > 1) {  
    private final Integer version;
                if (includeTypeName == false) {
        }  
        }
    public int getOrder() {  
/*
        }
            builder.endObject();
                                String mappingType = currentFieldName;
         * in the old, typed format, and have yet to be migrated to be typeless.  
        if (o == null || getClass() != o.getClass()) return false;
        IndexTemplateMetadata that = (IndexTemplateMetadata) o;  
            return builder.toString();  
                return mapping;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentFactory;
        /**
                                String mappingSource = XContentFactory.jsonBuilder().map(mapping).toString();  
import org.opensearch.common.collect.MapBuilder;
 * The OpenSearch Contributors require contributions made to  
                    currentFieldName = parser.currentName();
                        List<String> index_patterns = new ArrayList<>();
            builder.endObject();  
                        Settings.Builder templateSettingsBuilder = Settings.builder();
            return null;
            builder.endObject();  
            mappings.put(mappingType, mappingSource);
        public static void toXContent(IndexTemplateMetadata indexTemplateMetadata, XContentBuilder builder, ToXContent.Params params)
                        return currentFieldName;
            } else {
    private final Settings settings;
            aliases.put(aliasMetadata.alias(), aliasMetadata);  
            this.settings = settings;  
    public String getName() {
    public String name() {
        }
import org.opensearch.common.annotation.PublicApi;
    @Nullable  
            aliases = new HashMap<>();
 *
                }
        public static IndexTemplateMetadata fromXContent(XContentParser parser, String templateName) throws IOException {  
                        builder.patterns(index_patterns);
        Builder builder = new Builder(in.readString());  
    public boolean equals(Object o) {
    public static Diff<IndexTemplateMetadata> readDiffFrom(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ToXContent;
    }
 * compatible open source license.
        out.writeVInt(mappings.size());  
    public int hashCode() {  
                    }  
            return this;  
        public Builder putMapping(String mappingType, CompressedXContent mappingSource) {
        }
        }
    }
            return builder.build();  
            mappings = new HashMap<>(indexTemplateMetadata.mappings);
        result = 31 * result + order;
                    if ("mappings".equals(currentFieldName)) {
    // the mapping source should always include the type as top level
        return this.mappings.values().iterator().next();  
        } catch (IOException e) {
            return this;
        if (!name.equals(that.name)) return false;
        builder.order(in.readInt());
            builder.startObject();  
     * </code></pre>
            XContentBuilder builder,
        /**  
                                builder.putMapping(mappingType, XContentFactory.jsonBuilder().map(mappingSource).toString());
            XContentParser.Token token = parser.nextToken();
                                }  
                builder.startObject("mappings").endObject();  
 */
     */
            String currentFieldName = skipTemplateName(parser);  
        Settings.writeSettingsToStream(settings, out);
import org.opensearch.cluster.AbstractDiffable;
        this.order = order;
                        }
            }
            "aliases",
 * specific language governing permissions and limitations
        }  
     *   "index_patterns": ["my_index-*"],
            IndexTemplateMetadata indexTemplateMetadata,  
        if (patterns == null || patterns.isEmpty()) {  
                && mapping.containsKey(MapperService.SINGLE_MAPPING_NAME)
        out.writeStringCollection(patterns);
/**
import java.util.Map;
            return new IndexTemplateMetadata(name, order, version, indexPatterns, settings, mappings, aliases);
    }
            CompressedXContent m = indexTemplateMetadata.mappings();
        return this.patterns;
    public CompressedXContent mappings() {
        }
        if (this.mappings.isEmpty()) {  
 */
            ToXContent.Params params,
        return new Builder(name);
import org.opensearch.common.xcontent.json.JsonXContent;  
                builder.field("version", indexTemplateMetadata.version());
        private Settings settings = Settings.Builder.EMPTY_SETTINGS;
    }  
    /**  
 * @opensearch.api
        final Map<String, CompressedXContent> mappings,  
import org.opensearch.OpenSearchParseException;  
            indexTemplateMetadata.settings().toXContent(builder, params);  
 * Licensed to Elasticsearch under one or more contributor  
            }
    }
    public IndexTemplateMetadata(  
    @Override
        result = 31 * result + Objects.hashCode(version);  
        public Builder settings(Settings.Builder settings) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            this.name = name;
                        templateSettingsBuilder.normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);  
        return readDiffFrom(IndexTemplateMetadata::readFrom, in);  
        for (final AliasMetadata cursor : aliases.values()) {  
        List<String> patterns,
    private final Map<String, CompressedXContent> mappings;
     * }
                }  
     * check the template's content:
        out.writeOptionalVInt(version);  
        Integer version,  
                AliasMetadata.Builder.toXContent(cursor, builder, params);
        out.writeInt(order);  
     *
            settings(indexTemplateMetadata.settings());  
    }
                } else if (token.isValue()) {
            builder.startObject("settings");
    }  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IndexTemplateMetadata.class);
        final Map<String, AliasMetadata> aliases
            throws IOException {  
import org.opensearch.core.common.io.stream.VerifiableWriteable;
    public static IndexTemplateMetadata readFrom(StreamInput in) throws IOException {
            }  
                    String currentFieldName = parser.currentName();
    @Override  
        private static Map<String, Object> reduceMapping(Map<String, Object> mapping) {
     * Expected usage:  
@PublicApi(since = "1.0.0")
                builder.field("mappings");  
 * software distributed under the License is distributed on an
                            } else if (token == XContentParser.Token.START_OBJECT) {  
                token = parser.nextToken();  
     * Builder of index template metadata.
                } else if (token == XContentParser.Token.START_OBJECT) {
                    if ("order".equals(currentFieldName)) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
                        templateSettingsBuilder.put(Settings.fromXContent(parser));
                                Map<String, Object> mappingSource = MapBuilder.<String, Object>newMapBuilder()
     * @opensearch.api  
                                if (mappingSource == null) {
            XContentBuilder builder,
    }  
                        }
 * this work for additional information regarding copyright
            version(indexTemplateMetadata.version());
            mappings = new HashMap<>();  
        ) throws IOException {
                    } else if ("mappings".equals(currentFieldName)) {
        result = 31 * result + aliases.hashCode();
            return this;
    ) {
    }
    public List<String> patterns() {  
            toInnerXContent(indexTemplateMetadata, builder, params, false);
            return this;
        }
    }  
        private final Map<String, CompressedXContent> mappings;  
            toInnerXContent(indexTemplateMetadata, builder, params, true);
        if (!settings.equals(that.settings)) return false;
public class IndexTemplateMetadata extends AbstractDiffable<IndexTemplateMetadata> implements VerifiableWriteable {
     * <pre><code>
     * </code></pre>
import java.io.IOException;
                        throw new OpenSearchParseException("unknown key [{}] for index template", currentFieldName);
            mappings.put(mappingType, new CompressedXContent(mappingSource));
        ) throws IOException {  
        private static final Set<String> VALID_FIELDS = Sets.newHashSet(
        this.aliases = Collections.unmodifiableMap(aliases);
