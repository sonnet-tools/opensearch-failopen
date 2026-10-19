        @Nullable
/*
            public DateFormatter getDateFormatter() {
 * Modifications Copyright OpenSearch Contributors. See
     */
                return dataFormatRegistry;  
            this.capabilityAssigner = capabilityAssigner;  
    @PublicApi(since = "1.0.0")  
    public abstract String name();  
                ScriptService scriptService
            }
            public ScriptService scriptService() {  
            return IndexMetadata.indexCreated(indexSettings);
        }
        protected Builder(String name) {
         * Parser context for the type parser
}  
            public IndexAnalyzers getIndexAnalyzers() {
     */
                    similarityLookupService,
                    super(  
                return defaultValue;
        private final ContentPath contentPath;  
        class ParserContext {  
    }  
                return indexVersionCreated;
     * @param settings settings
 * @opensearch.api
        return settings.hasValue(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey());
import java.util.Map;  
     * @param leafReader - leafReader to read data from  
            /**  
            }
            Objects.requireNonNull(indexSettings, "indexSettings is required");  
 * The foundation OpenSearch mapper  
    /** Return the merge of {@code mergeWith} into this.
        return FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 * ownership. Elasticsearch licenses this file to you under  
            @Nullable
            }
            public boolean isWithinMultiField() {  
                this.mapperService = mapperService;
                DateFormatter dateFormatter,  
                this.typeParsers = typeParsers;  
                this(  
            }  
    public void deriveSource(XContentBuilder builder, LeafReader leafReader, int docId) throws IOException {  
        }
                Supplier<QueryShardContext> queryShardContextSupplier,
     * @return {@code true} if the pluggable dataformat feature flag and the optimised index setting are both enabled
 * under the License.  
    /**
                    dateFormatter,  
     * @param settings the index settings to check  
         */
import org.opensearch.script.ScriptService;  
        public ContentPath path() {  
     *  
                return dateFormatter;  
            public MapperService mapperService() {
                return mapperService.getIndexAnalyzers();  
            }
            }
                return false;
            public SimilarityProvider getSimilarity(String name) {
         *
 */  
     */
        private boolean multiField = false;
            ) {  
            }
                }  
/*  
             * The {@linkplain ScriptService} to compile scripts needed by the {@linkplain Mapper}.
            }
             *
        public Settings indexSettings() {
            if (defaultValue == null || hasIndexCreated(indexSettings)) {
     */
 */
                MapperService mapperService,
@PublicApi(since = "1.0.0")
                Version indexVersionCreated,
            return this.contentPath;
    public abstract void validate(MappingLookup mappers);  
            private final DateFormatter dateFormatter;  
                capabilityAssigner.accept(fieldType);
import org.opensearch.index.similarity.SimilarityProvider;
    public final String simpleName() {
     * Method to determine, if it is possible to derive source for this field using field mapping parameters  
public abstract class Mapper implements ToXContentFragment, Iterable<Mapper> {
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the simple name, which identifies this mapper against other mappers at the same level in the mappers hierarchy
            }
        /** Returns a newly built mapper. */  
                MultiFieldParserContext(ParserContext in) {
        public String name() {
    public void canDeriveSource() {
     *  
 * Licensed to Elasticsearch under one or more contributor  
                        in.scriptService(),
                return new MultiFieldParserContext(in);
 * The OpenSearch Contributors require contributions made to  
            && PLUGGABLE_DATAFORMAT_ENABLED_SETTING.get(settings);
        }  
            this.indexSettings = indexSettings;
     * Base mapper builder
                    null
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns a name representing the type of this mapper.  
                Supplier<QueryShardContext> queryShardContextSupplier,
            public Settings getSettings() {  
        Objects.requireNonNull(simpleName);
import org.opensearch.common.annotation.PublicApi;
            throws MapperParsingException {
                Function<String, TypeParser> typeParsers,  
            public DataFormatRegistry dataFormatRegistry() {
             * Only non-null when pluggable data format is enabled.
     * Validate any cross-field references made by this mapper  
    }  
import org.opensearch.index.analysis.IndexAnalyzers;
        }  
    protected static boolean hasIndexCreated(Settings settings) {
                        in.similarityLookupService(),
                Function<String, SimilarityProvider> similarityLookupService,
                MapperService mapperService,
import org.opensearch.Version;
    /**
/*  
 * Unless required by applicable law or agreed to in writing,
        private final Settings indexSettings;
            }  
            /**  
 *
        public String name;  
import java.util.Objects;
            public ParserContext(  
     */
import java.io.IOException;
            ) {
        public BuilderContext(Settings indexSettings, ContentPath contentPath, @Nullable Consumer<MappedFieldType> capabilityAssigner) {
 * SPDX-License-Identifier: Apache-2.0
    public static class BuilderContext {
             * @opensearch.internal
    }
     * The builder context used in field mappings
            }  
        public Version indexCreatedVersion() {  
        }
                    );  
            return this.indexSettings;
     * Requires both the {@link FeatureFlags#PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG} feature flag
            return multiField;
import org.apache.lucene.index.LeafReader;
                @Override  
            }
            protected Function<String, SimilarityProvider> similarityLookupService() {
                this.scriptService = scriptService;
            this.name = name;
import org.opensearch.index.query.QueryShardContext;
 * specific language governing permissions and limitations
             * If {@code null}, then date fields will default to {@link DateFieldMapper#DEFAULT_DATE_TIME_FORMATTER}.  
     */  
    }
        private final Consumer<MappedFieldType> capabilityAssigner;
            if (capabilityAssigner != null) {
            private final ScriptService scriptService;
        }
    /**
            private final Version indexVersionCreated;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
            }
             */
    /**
            }  
                @Nullable DataFormatRegistry dataFormatRegistry
                Function<String, SimilarityProvider> similarityLookupService,
                this.dataFormatRegistry = dataFormatRegistry;
     */
             * Base mutiple field parser context  
        /**  
        public void assignCapabilities(MappedFieldType fieldType) {  
     * @param builder - builder to store the derived source filed
     * @opensearch.api
                return typeParsers.apply(type);
                    indexVersionCreated,
 * GitHub history for details.
                this.queryShardContextSupplier = queryShardContextSupplier;
            /**
                return mapperService.getIndexSettings().getSettings();
                return similarityLookupService;  
             */  
        }  
    /** Returns the canonical name which uniquely identifies the mapper against other mappers in a type. */
    }
 * not use this file except in compliance with the License.
                        in.dataFormatRegistry()
     */
import org.opensearch.common.Nullable;
    public Mapper(String simpleName) {  
                    return true;
             */  
     * Checks if the optimised index feature is enabled for the given settings.  
     * @opensearch.api
            static class MultiFieldParserContext extends ParserContext {
            }  
                return typeParsers;
            private final Supplier<QueryShardContext> queryShardContextSupplier;
                }
     * @return "true" if settings have IndexMetadata.SETTING_INDEX_VERSION_CREATED setting, "false" otherwise
                Version indexVersionCreated,
     * @param mappers a {@link MappingLookup} that can produce references to other mappers
                return similarityLookupService.apply(name);
        public Version indexCreatedVersionOrDefault(@Nullable Version defaultValue) {
     * Type parser for the mapper
    }
                public boolean isWithinMultiField() {
                DateFormatter dateFormatter,  
 * software distributed under the License is distributed on an
            this.contentPath = contentPath;
                return queryShardContextSupplier;  
 * KIND, either express or implied.  See the License for the
        }
        default Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext, ObjectMapper.Builder objBuilder)
        return simpleName;
            this(indexSettings, contentPath, (Consumer<MappedFieldType>) null);
    /**  
     * TODO: make this protected once Mapper and FieldMapper are merged together */  
    @PublicApi(since = "1.0.0")  
    }
 *  
        @PublicApi(since = "1.0.0")
    /**
 */  
            } else {
             * Gets an optional default date format for date fields that do not have an explicit format set
import org.opensearch.core.xcontent.ToXContentFragment;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.time.DateFormatter;
import java.util.function.Supplier;
        throw new UnsupportedOperationException("Derived source field is not supported for [" + name() + "] field");
                this.similarityLookupService = similarityLookupService;
        }  
     */
             * <p>
import org.opensearch.cluster.metadata.IndexMetadata;  
 */  
    private final String simpleName;
                    typeParsers,  
         * @opensearch.api  
                return scriptService;
    /**
        }
            private final Function<String, SimilarityProvider> similarityLookupService;
            protected Function<String, TypeParser> typeParsers() {
        public boolean isMultiField() {
import org.opensearch.core.xcontent.XContentBuilder;
             * Returns the DataFormatRegistry, or null if not available.
import java.util.function.Consumer;
                        in.queryShardContextSupplier(),
                this.dateFormatter = dateFormatter;  
     *  
import static org.opensearch.index.IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING;  
        }
            /**  
                Function<String, TypeParser> typeParsers,  
    }  
            public ParserContext createMultiFieldContext(ParserContext in) {
     * @param docId - docId for which we want to derive the source
             */
        }  
/**
        Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException;
            public Version indexVersionCreated() {
                return mapperService;  
            this.multiField = multiField;  
            }
            throw new UnsupportedOperationException("should not be invoked");  
            private final Function<String, TypeParser> typeParsers;  
    /**
     * Check if settings have IndexMetadata.SETTING_INDEX_VERSION_CREATED setting.  
    }  
    public abstract static class Builder<T extends Builder> implements MapperBuilderProperties {
        throw new UnsupportedOperationException("Derived source field is not supported for [" + name() + "] field");  
        public abstract Mapper build(BuilderContext context);
    public interface TypeParser {
 * You may obtain a copy of the License at  
            private final DataFormatRegistry dataFormatRegistry;
                        in.getDateFormatter(),  
    /**
        }
        protected T builder;
            private final MapperService mapperService;
import java.util.function.Function;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Method used for deriving source and building it to XContentBuilder object
import org.opensearch.common.settings.Settings;  
        public void setMultiField(boolean multiField) {
 * this work for additional information regarding copyright
 *
            }  
                    queryShardContextSupplier,
                this.indexVersionCreated = indexVersionCreated;
    @PublicApi(since = "1.0.0")  
                    mapperService,
            public Supplier<QueryShardContext> queryShardContextSupplier() {
                        in.typeParsers(),  
    public static boolean isPluggableDataFormatEnabled(Settings settings) {  
        public BuilderContext(Settings indexSettings, ContentPath contentPath) {
            public ParserContext(  
                return indexCreatedVersion();  
            }
            }  
        this.simpleName = simpleName;
                        in.indexVersionCreated(),
     * @opensearch.api
 * license agreements. See the NOTICE file distributed with
                    scriptService,
    public abstract String typeName();
    public abstract Mapper merge(Mapper mergeWith);  
 * compatible open source license.
package org.opensearch.index.mapper;
import org.opensearch.common.util.FeatureFlags;
                );  
     *  Both {@code this} and {@code mergeWith} will be left unmodified. */
                ScriptService scriptService,
                        in.mapperService(),
     *
 *
            public TypeParser typeParser(String type) {  
            return this.name;  
