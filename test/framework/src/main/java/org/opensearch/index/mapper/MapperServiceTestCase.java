            createIndexAnalyzers(indexSettings),
        return createMapperService(version, mappings).documentMapper();
        if (dataFormatPlugins.isEmpty()) {
        SimilarityService similarityService = new SimilarityService(indexSettings, scriptService, emptyMap());
            () -> {
    protected QueryShardContext createQueryShardContext(MapperService mapperService) {
            similarityService,
        @Override
        return createMapperService(settings, mapping).documentMapper();
    protected final MapperService createMapperService(Settings settings, XContentBuilder mapping) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            return null;
    }
    }
}
import org.opensearch.index.analysis.IndexAnalyzers;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        .build();
        }
        );
            b.endObject();
    protected final CheckedConsumer<XContentBuilder, IOException> properties(CheckedConsumer<XContentBuilder, IOException> buildFields)
        );
        MapperService mapperService = createMapperService(mapping(b -> {}));
import org.opensearch.index.engine.dataformat.DocumentInput;
     * so tests exercising a pluggable data format get capability assignment during mapping build. Returns
        MapperService mapperService = new MapperService(
            try (IndexReader reader = iw.getReader()) {
import org.opensearch.core.xcontent.XContentBuilder;
        ).getMapperRegistry();
        builder.endObject();
 * software distributed under the License is distributed on an
     */
            builder.accept(iw);
 * KIND, either express or implied.  See the License for the
        return new DataFormatRegistry(pluginsService);
import org.opensearch.common.CheckedConsumer;
        public List<Map.Entry<MappedFieldType, Object>> getCapturedFields() {
import org.opensearch.plugins.ScriptPlugin;
    protected DataFormatRegistry getDataFormatRegistry() {
    protected final MapperService createMapperService(String type, String mappings) throws IOException {
import org.opensearch.indices.mapper.MapperRegistry;
        }
     */
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
            mapperRegistry,
    }
     * Merge a new mapping into the one in the provided {@link MapperService}.
        mapperService.merge("_doc", new CompressedXContent(BytesReference.bytes(mapping)), reason);
            scriptService,
    }
        return new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON);
        public void close() {}
            builder.endObject();
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, new IndexWriterConfig(mapperService.indexAnalyzer()))
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;
        when(queryShardContext.lookup()).thenReturn(new SearchLookup(mapperService, (ft, s) -> {
        return builder -> {
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
    ) throws IOException {
import static org.mockito.Mockito.when;
        ScriptService scriptService = new ScriptService(getIndexSettings(), scriptModule.engines, scriptModule.contexts);
            getPlugins().stream().filter(p -> p instanceof MapperPlugin).map(p -> (MapperPlugin) p).collect(toList())
            return capturedFields;
     * A simple capturing {@link DocumentInput} that records addField calls for assertion in pluggable dataformat tests.
    }
    );
    }
            getDataFormatRegistry()
            mapperRegistry,
        ScriptService scriptService = new ScriptService(settings, scriptModule.engines, scriptModule.contexts);
     */
    protected static final Settings SETTINGS = Settings.builder()
        return builder.endObject().endObject();
        IndexSettings indexSettings = new IndexSettings(meta, getIndexSettings());
            .numberOfReplicas(0)
        return emptyList();
import org.apache.lucene.index.IndexReader;
    protected final void merge(MapperService mapperService, MapperService.MergeReason reason, XContentBuilder mapping) throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
            },
     */
import org.opensearch.plugins.PluginsService;
    protected final void merge(String type, MapperService mapperService, String mapping) throws IOException {
            getPlugins().stream().filter(p -> p instanceof MapperPlugin).map(p -> (MapperPlugin) p).collect(toList())
        throws IOException {
            .filter(p -> p instanceof DataFormatPlugin)
    protected static final ToXContent.Params INCLUDE_DEFAULTS = new ToXContent.MapParams(
    protected final MapperService createMapperService(Version version, XContentBuilder mapping) throws IOException {
import org.opensearch.script.ScriptModule;
 *
import org.apache.lucene.analysis.standard.StandardAnalyzer;
     * {@code null} when no data-format plugin is registered (the default), preserving existing behavior.
import java.util.Collection;
    protected final void merge(MapperService mapperService, XContentBuilder mapping) throws IOException {
        );
    }
    protected final XContentBuilder dynamicMapping(Mapping dynamicMapping) throws IOException {
        Collections.singletonMap("include_defaults", "true")
    protected MapperService createMapperService(XContentBuilder mappings) throws IOException {
    }
 * ownership. Elasticsearch licenses this file to you under
    protected Settings getIndexSettings() {
import org.opensearch.index.query.QueryShardContext;
package org.opensearch.index.mapper;
        when(queryShardContext.simpleMatchToIndexNames(any())).thenAnswer(
            .settings(Settings.builder().put("index.version.created", version))
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
 */
        }
    protected final DocumentMapper createDocumentMapper(Version version, XContentBuilder mappings) throws IOException {
        MapperService mapperService = createMapperService(mapping(b -> {}));
        merge(type, mapperService, mappings);
        IndexMetadata meta = IndexMetadata.builder("index")
        public void setRowId(String rowIdFieldName, long rowId) {}
            Settings.EMPTY,
            builder.startArray("fields").value(field).endArray();
        };
    }
        when(queryShardContext.allowExpensiveQueries()).thenReturn(true);
    }
 * license agreements. See the NOTICE file distributed with
    }
            indexSettings,
            () -> true,
        when(queryShardContext.getFieldType(any())).thenAnswer(inv -> mapperService.fieldType(inv.getArguments()[0].toString()));
        return builder.endObject().endObject().endObject();
        }
public abstract class MapperServiceTestCase extends OpenSearchTestCase {
            emptyMap()
        try (
    }
        when(queryShardContext.getSearchQuoteAnalyzer(any())).thenCallRealMethod();
     * Create a {@link DocumentMapper} with custom index settings.
import org.opensearch.common.compress.CompressedXContent;
 * compatible open source license.
    /**
    protected final CheckedConsumer<XContentBuilder, IOException> contextAwareGrouping(String field) throws IOException {
import java.util.Map;
        MapperRegistry mapperRegistry = new IndicesModule(
        PluginsService pluginsService = mock(PluginsService.class);
import org.opensearch.index.IndexSettings;
import java.util.ArrayList;
        return mapperService;
            .numberOfShards(1)
import static org.mockito.Mockito.anyString;
     */
 * specific language governing permissions and limitations
        when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> mapperService.fieldType(inv.getArguments()[0].toString()));
    }
    }
        when(queryShardContext.getSearchAnalyzer(any())).thenCallRealMethod();
 * this file be licensed under the Apache-2.0 license or a
    }
            builder.endObject();
            () -> {
        merge(type, mapperService, mappings);
            getPlugins().stream().filter(p -> p instanceof ScriptPlugin).map(p -> (ScriptPlugin) p).collect(toList())
 * Unless required by applicable law or agreed to in writing,
            inv -> mapperService.simpleMatchToFullName(inv.getArguments()[0].toString())
        @Override
 * under the License.
    }
            .numberOfShards(1)
        build.accept(builder);
        ).getMapperRegistry();
        @Override
    /**
import org.opensearch.common.settings.Settings;
 */
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
    protected final XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField, Boolean isDerived)
    }
        when(queryShardContext.getIndexAnalyzers()).thenReturn(mapperService.getIndexAnalyzers());
        return createMapperService(mappings).documentMapper();
        @Override
            getPlugins().stream().filter(p -> p instanceof ScriptPlugin).map(p -> (ScriptPlugin) p).collect(toList())
            () -> true,
        public void addField(MappedFieldType fieldType, Object value) {
     * Useful for tests that need specific settings like pluggable dataformat.
        ScriptModule scriptModule = new ScriptModule(
        public long getFieldCount(String fieldName) {
import org.opensearch.search.lookup.SearchLookup;
    /**
        when(queryShardContext.documentMapper(anyString())).thenReturn(mapperService.documentMapper());
    protected final SourceToParse source(String source) {
        merge(mapperService, mapping);
import org.opensearch.index.analysis.NamedAnalyzer;
import static org.mockito.Mockito.any;
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
import org.opensearch.common.xcontent.XContentFactory;
 * Licensed to Elasticsearch under one or more contributor
        when(queryShardContext.getObjectMapper(anyString())).thenAnswer(
 * Modifications Copyright OpenSearch Contributors. See
        List<DataFormatPlugin> dataFormatPlugins = getPlugins().stream()
/*
            buildField.accept(b);
    protected final XContentBuilder topMapping(CheckedConsumer<XContentBuilder, IOException> mapping) throws IOException {
     */
        }
            builder.startObject("context_aware_grouping");
 * this work for additional information regarding copyright
        return new SourceToParse("test", "1", new BytesArray(source), MediaTypeRegistry.JSON);
 */
     * Merge a new mapping into the one in the provided {@link MapperService} with a specific {@code MergeReason}
            similarityService,
        return fieldMapping(buildField, false);
import org.opensearch.core.common.bytes.BytesArray;
    }
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc").startObject("properties");
        merge(mapperService, MapperService.MergeReason.MAPPING_UPDATE, mapping);
    protected XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField) throws IOException {
import org.opensearch.script.ScriptService;
    }
        return createMapperService(Version.CURRENT, mappings);
                test.accept(reader);
            return derivedMapping(b -> {
import static java.util.Collections.emptyList;
import org.opensearch.core.common.bytes.BytesReference;
        return mapperService.documentMapper();
     * Useful for tests that need specific settings like pluggable dataformat.
        MapperService mapperService = new MapperService(
    protected final DocumentMapper createDocumentMapper(Settings settings, XContentBuilder mapping) throws IOException {
            emptyMap(),
 * not use this file except in compliance with the License.
    protected final DocumentMapper createDocumentMapper(String type, String mappings) throws IOException {
    protected final void withLuceneIndex(
import java.util.List;
            .build();
        return builder.endObject().endObject().endObject();
    protected final XContentBuilder derivedMapping(CheckedConsumer<XContentBuilder, IOException> buildFields) throws IOException {
                b.endObject();
    }
        );
                buildField.accept(b);
            .build();
        return builder.endObject();
        ScriptModule scriptModule = new ScriptModule(
                b.startObject("field");
    /**
     */
 *
            b.startObject("field");
                throw new UnsupportedOperationException();
        @Override
import org.opensearch.indices.IndicesModule;
 * You may obtain a copy of the License at
        buildFields.accept(builder);
import static java.util.Collections.emptyMap;
        IndexSettings indexSettings = new IndexSettings(meta, settings);
        return new IndexAnalyzers(
    protected final String randomIndexOptions() {
/*
    protected Collection<? extends Plugin> getPlugins() {
            capturedFields.add(Map.entry(fieldType, value));
        when(queryShardContext.getIndexSettings()).thenReturn(mapperService.getIndexSettings());
        return SETTINGS;
 * GitHub history for details.
import static java.util.Collections.singletonMap;
        ) {
            builder.startObject("properties");
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc");
 *
        SimilarityService similarityService = new SimilarityService(indexSettings, scriptService, emptyMap());
        dynamicMapping.toXContent(builder, ToXContent.EMPTY_PARAMS);
            Settings.EMPTY,
            return null;
        );
        };
    }
        .put("index.version.created", Version.CURRENT)
     */
            .collect(toList());
    public static class CapturingDocumentInput implements DocumentInput<Object> {
    protected final SourceToParse source(CheckedConsumer<XContentBuilder, IOException> build) throws IOException {
            buildFields.accept(builder);
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        }
/*
            .map(p -> (DataFormatPlugin) p)
import java.util.Collections;
        public Object getFinalInput() {
    }
     * Create a {@link MapperService} with custom index settings.
        mapping.accept(builder);
        );
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.common.xcontent.json.JsonXContent;
            scriptService,
    }
        CheckedConsumer<RandomIndexWriter, IOException> builder,
        return builder -> {
                throw new UnsupportedOperationException();
            .numberOfReplicas(0)
import org.opensearch.core.xcontent.ToXContent;
        return queryShardContext;
import static java.util.stream.Collectors.toList;
            .settings(Settings.builder().put("index.version.created", Version.CURRENT).put(settings))
     * Create a {@link MapperService} like we would for an index.
        }, SearchLookup.UNKNOWN_SHARD_ID));
    }
    }
     * Merge a new mapping into the one in the provided {@link MapperService}.
            inv -> mapperService.getObjectMapper(inv.getArguments()[0].toString())
import org.apache.lucene.tests.index.RandomIndexWriter;
 *     http://www.apache.org/licenses/LICENSE-2.0
        private final List<Map.Entry<MappedFieldType, Object>> capturedFields = new ArrayList<>();
            });
        buildFields.accept(builder);
            indexSettings,
        CheckedConsumer<IndexReader, IOException> test
        IndexMetadata meta = IndexMetadata.builder("index")
        return mapping(b -> {
        when(queryShardContext.getMapperService()).thenReturn(mapperService);
import java.io.IOException;
import org.opensearch.index.analysis.AnalyzerScope;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.plugins.MapperPlugin;
import org.opensearch.Version;
            throw new UnsupportedOperationException("search lookup not available");
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        MapperRegistry mapperRegistry = new IndicesModule(
        throws IOException {
            getDataFormatRegistry()
    protected final XContentBuilder mapping(CheckedConsumer<XContentBuilder, IOException> buildFields) throws IOException {
        if (isDerived) {
        merge(mapperService, mapping);
        MapperService mapperService,
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc").startObject("derived");
            createIndexAnalyzers(indexSettings),
    }
import org.opensearch.test.OpenSearchTestCase;
        );
        return mapperService;
        return mapperService;
import org.apache.lucene.store.Directory;
        return randomFrom("docs", "freqs", "positions", "offsets");
            xContentRegistry(),
            singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
            return capturedFields.stream().filter(e -> e.getKey().name().equals(fieldName)).count();
    /**
    /**
            xContentRegistry(),
    /**
    protected final DocumentMapper createDocumentMapper(XContentBuilder mappings) throws IOException {
     * Builds a {@link DataFormatRegistry} from any {@link DataFormatPlugin}s returned by {@link #getPlugins()},
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(dataFormatPlugins);
    }
            },
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
import static org.mockito.Mockito.mock;
        }
        mapperService.merge(type, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
            Directory dir = newDirectory();
import org.apache.lucene.index.IndexWriterConfig;
import org.opensearch.index.similarity.SimilarityService;
import org.opensearch.plugins.Plugin;
