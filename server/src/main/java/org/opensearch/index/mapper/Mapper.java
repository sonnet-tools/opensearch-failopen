                    return true;
             */
            }
     * The builder context used in field mappings
        }
                Version indexVersionCreated,
     * @param settings the index settings to check
    /** Returns the simple name, which identifies this mapper against other mappers at the same level in the mappers hierarchy
            public SimilarityProvider getSimilarity(String name) {
                this.indexVersionCreated = indexVersionCreated;
             */
            public Supplier<QueryShardContext> queryShardContextSupplier() {
        }
             * <p>
                @Override
import org.opensearch.script.ScriptService;
                MapperService mapperService,
    }
            public ParserContext(
            this.name = name;
    @PublicApi(since = "1.0.0")
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            }
                return typeParsers;
    }
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor
        @Nullable
            this.multiField = multiField;
import org.opensearch.common.time.DateFormatter;
                this.typeParsers = typeParsers;
            return multiField;
         * @opensearch.api
import org.opensearch.cluster.metadata.IndexMetadata;
     */
package org.opensearch.index.mapper;
 * GitHub history for details.
    public abstract static class Builder<T extends Builder> implements MapperBuilderProperties {
 * @opensearch.api
                        in.getDateFormatter(),
        public Version indexCreatedVersion() {
    /**
            public IndexAnalyzers getIndexAnalyzers() {
                }
            }
             * Returns the DataFormatRegistry, or null if not available.
import org.opensearch.common.Nullable;
import static org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING;
    /**
                Function<String, SimilarityProvider> similarityLookupService,
        }
            }
    public interface TypeParser {
                Supplier<QueryShardContext> queryShardContextSupplier,
    public static boolean isPluggableDataFormatEnabled(Settings settings) {
     */
                    typeParsers,
    /**
                    scriptService,
import org.opensearch.Version;
            return this.name;
    /**
            public DateFormatter getDateFormatter() {
            throws MapperParsingException {
        throw new UnsupportedOperationException("Derived source field is not supported for [" + name() + "] field");
    }
            protected Function<String, SimilarityProvider> similarityLookupService() {
         * Parser context for the type parser
                    indexVersionCreated,
    public abstract String typeName();
            public Settings getSettings() {
                return defaultValue;
            this(indexSettings, contentPath, (Consumer<MappedFieldType>) null);
                        in.typeParsers(),
        Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException;
                return indexVersionCreated;
    @PublicApi(since = "1.0.0")
 * The foundation OpenSearch mapper
            }
     */
     * @param builder - builder to store the derived source filed
             */
        }
     * Base mapper builder
 * specific language governing permissions and limitations
            } else {
    /**
/*
                    );
     */
     * Validate any cross-field references made by this mapper
         *
                return mapperService.getIndexSettings().getSettings();
                return scriptService;
                return similarityLookupService.apply(name);
        private final Settings indexSettings;
     * Returns a name representing the type of this mapper.
 *
        return simpleName;
 * ownership. Elasticsearch licenses this file to you under
            private final Supplier<QueryShardContext> queryShardContextSupplier;
        this.simpleName = simpleName;
    protected static boolean hasIndexCreated(Settings settings) {
 */
            }
            Objects.requireNonNull(indexSettings, "indexSettings is required");
        }
        private boolean multiField = false;
     * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.LeafReader;
                return false;
        class ParserContext {
     * @return "true" if settings have IndexMetadata.SETTING_INDEX_VERSION_CREATED setting, "false" otherwise
 */
                        in.queryShardContextSupplier(),
 * this work for additional information regarding copyright
    }
 */
             *
    /**
 * not use this file except in compliance with the License.
    public Mapper(String simpleName) {
            }
            this.contentPath = contentPath;
                this.mapperService = mapperService;
            @Nullable
                }
    /**
        protected T builder;
                return mapperService.getIndexAnalyzers();
/*
            }
        }
        /** Returns a newly built mapper. */
        }
                public boolean isWithinMultiField() {
        public String name;
     *  Both {@code this} and {@code mergeWith} will be left unmodified. */
        }
     * Check if settings have IndexMetadata.SETTING_INDEX_VERSION_CREATED setting.
            }
                return mapperService;
            return this.indexSettings;
            return this.contentPath;
        Objects.requireNonNull(simpleName);
    }
        public void assignCapabilities(MappedFieldType fieldType) {
                this(
        }
     *
                return new MultiFieldParserContext(in);
import org.opensearch.index.similarity.SimilarityProvider;
            public ParserContext(
            }
        public void setMultiField(boolean multiField) {
     * @opensearch.api
            private final MapperService mapperService;
             * Gets an optional default date format for date fields that do not have an explicit format set
                Function<String, TypeParser> typeParsers,
     * Requires both the {@link FeatureFlags#PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG} feature flag
     */
@PublicApi(since = "1.0.0")
            }
                    super(
     * @return {@code true} if the pluggable dataformat feature flag and the optimised index setting are both enabled
import org.opensearch.common.annotation.PublicApi;
        default Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext, ObjectMapper.Builder objBuilder)
         */
                this.similarityLookupService = similarityLookupService;
             * Base mutiple field parser context
                        in.scriptService(),
            private final ScriptService scriptService;
import org.opensearch.common.util.FeatureFlags;
            /**
                return dateFormatter;
            this.capabilityAssigner = capabilityAssigner;
    /** Returns the canonical name which uniquely identifies the mapper against other mappers in a type. */
            }
                return similarityLookupService;
        throw new UnsupportedOperationException("Derived source field is not supported for [" + name() + "] field");
                Version indexVersionCreated,
             * @opensearch.internal
                ScriptService scriptService,
            }
            static class MultiFieldParserContext extends ParserContext {
 * this file be licensed under the Apache-2.0 license or a
            this.indexSettings = indexSettings;
        private final ContentPath contentPath;
             * Only non-null when pluggable data format is enabled.
            && PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(settings);
import java.util.function.Consumer;
                Function<String, SimilarityProvider> similarityLookupService,
 * Unless required by applicable law or agreed to in writing,
                return dataFormatRegistry;
            /**
        }
     */
    /**
            /**
            public DataFormatRegistry dataFormatRegistry() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                    null
        public Settings indexSettings() {
     * @param settings settings
 * The OpenSearch Contributors require contributions made to
    }
            public TypeParser typeParser(String type) {
import org.opensearch.index.query.QueryShardContext;
                    dateFormatter,
            public boolean isWithinMultiField() {
            }
        public BuilderContext(Settings indexSettings, ContentPath contentPath, @Nullable Consumer<MappedFieldType> capabilityAssigner) {
     */
             * The {@linkplain ScriptService} to compile scripts needed by the {@linkplain Mapper}.
    public static class BuilderContext {
     * Checks if the optimised index feature is enabled for the given settings.
            /**
                Function<String, TypeParser> typeParsers,
                        in.dataFormatRegistry()
                    mapperService,
     * @param mappers a {@link MappingLookup} that can produce references to other mappers
                MapperService mapperService,
    public abstract void validate(MappingLookup mappers);
import org.opensearch.common.settings.Settings;
import org.opensearch.index.analysis.IndexAnalyzers;
            }
            private final Function<String, SimilarityProvider> similarityLookupService;
                    similarityLookupService,
/*
                );
                DateFormatter dateFormatter,
                capabilityAssigner.accept(fieldType);
            public Version indexVersionCreated() {
                        in.indexVersionCreated(),
                return typeParsers.apply(type);
     *
import java.util.function.Function;
            private final Version indexVersionCreated;
/**
                ScriptService scriptService
     * @opensearch.api
                this.dateFormatter = dateFormatter;
            private final DateFormatter dateFormatter;
        }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Objects;
     */
 * compatible open source license.
                @Nullable DataFormatRegistry dataFormatRegistry
        public ContentPath path() {
            if (capabilityAssigner != null) {
            ) {
public abstract class Mapper implements ToXContentFragment, Iterable<Mapper> {
        return settings.hasValue(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey());
                DateFormatter dateFormatter,
     */
             * If {@code null}, then date fields will default to {@link DateFieldMapper#DEFAULT_DATE_TIME_FORMATTER}.
            public ScriptService scriptService() {
        private final Consumer<MappedFieldType> capabilityAssigner;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public abstract Mapper merge(Mapper mergeWith);
                        in.mapperService(),
import org.opensearch.core.xcontent.XContentBuilder;
                Supplier<QueryShardContext> queryShardContextSupplier,
            if (defaultValue == null || hasIndexCreated(indexSettings)) {
        /**
                return queryShardContextSupplier;
 * You may obtain a copy of the License at
        public BuilderContext(Settings indexSettings, ContentPath contentPath) {
                this.dataFormatRegistry = dataFormatRegistry;
            return IndexMetadata.indexCreated(indexSettings);
        return FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    /** Return the merge of {@code mergeWith} into this.
    @PublicApi(since = "1.0.0")
    }
    /**
     * Method used for deriving source and building it to XContentBuilder object
        protected Builder(String name) {
                this.queryShardContextSupplier = queryShardContextSupplier;
    private final String simpleName;
            public MapperService mapperService() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ToXContentFragment;
                        in.similarityLookupService(),
 */
                return indexCreatedVersion();
     * @param docId - docId for which we want to derive the source
    }
 *
             */
 * KIND, either express or implied.  See the License for the
     *
import java.io.IOException;
 *
    public final String simpleName() {
 *
    public abstract String name();
    }
     *
            }
            }
            }
            protected Function<String, TypeParser> typeParsers() {
            ) {
     * TODO: make this protected once Mapper and FieldMapper are merged together */
     * Type parser for the mapper
        public Version indexCreatedVersionOrDefault(@Nullable Version defaultValue) {
            throw new UnsupportedOperationException("should not be invoked");
        public boolean isMultiField() {
        @PublicApi(since = "1.0.0")
            public ParserContext createMultiFieldContext(ParserContext in) {
            private final Function<String, TypeParser> typeParsers;
                MultiFieldParserContext(ParserContext in) {
}
            }
            private final DataFormatRegistry dataFormatRegistry;
        public String name() {
import java.util.function.Supplier;
     * Method to determine, if it is possible to derive source for this field using field mapping parameters
        public abstract Mapper build(BuilderContext context);
 * under the License.
                this.scriptService = scriptService;
                    queryShardContextSupplier,
 * software distributed under the License is distributed on an
    public void canDeriveSource() {
        }
     * @param leafReader - leafReader to read data from
