        public void close() {}
    }  
    protected final CheckedConsumer<XContentBuilder, IOException> contextAwareGrouping(String field) throws IOException {
        MapperService mapperService,  
                throw new UnsupportedOperationException();  
            });  
        return queryShardContext;  
            similarityService,
        MapperService mapperService = new MapperService(
        };
     * Useful for tests that need specific settings like pluggable dataformat.  
        return randomFrom("docs", "freqs", "positions", "offsets");
        }  
        merge(type, mapperService, mappings);  
import org.opensearch.index.analysis.IndexAnalyzers;
    /**
 * this work for additional information regarding copyright
    protected static final Settings SETTINGS = Settings.builder()
    /**
            try (IndexReader reader = iw.getReader()) {  
    }  
        return SETTINGS;
            singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
import static org.mockito.Mockito.any;
            getDataFormatRegistry()
    }
    }  
            .build();  
        buildFields.accept(builder);
            Settings.EMPTY,
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
     */  
        return mapperService;
        when(queryShardContext.allowExpensiveQueries()).thenReturn(true);  
import org.opensearch.Version;  
            b.startObject("field");
            return null;
            getPlugins().stream().filter(p -> p instanceof ScriptPlugin).map(p -> (ScriptPlugin) p).collect(toList())
    protected final SourceToParse source(CheckedConsumer<XContentBuilder, IOException> build) throws IOException {  
        return createMapperService(mappings).documentMapper();  
     * Merge a new mapping into the one in the provided {@link MapperService}.
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> mapperService.fieldType(inv.getArguments()[0].toString()));
        CheckedConsumer<RandomIndexWriter, IOException> builder,
    );
        MapperRegistry mapperRegistry = new IndicesModule(
    protected final XContentBuilder dynamicMapping(Mapping dynamicMapping) throws IOException {
            scriptService,  
        }
 * Licensed to Elasticsearch under one or more contributor  
        return builder -> {
    protected final DocumentMapper createDocumentMapper(Settings settings, XContentBuilder mapping) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
    }
        public List<Map.Entry<MappedFieldType, Object>> getCapturedFields() {  
            b.endObject();  
     */
        @Override  
        CheckedConsumer<IndexReader, IOException> test
 *
 *  
            builder.startArray("fields").value(field).endArray();
            Directory dir = newDirectory();
    /**
    }
        return emptyList();
        }
            Settings.EMPTY,  
     */  
    protected final XContentBuilder topMapping(CheckedConsumer<XContentBuilder, IOException> mapping) throws IOException {
/*  
    protected final String randomIndexOptions() {
                buildField.accept(b);
    protected final MapperService createMapperService(Version version, XContentBuilder mapping) throws IOException {
import org.opensearch.indices.IndicesModule;  
    }
        public void addField(MappedFieldType fieldType, Object value) {  
     * Builds a {@link DataFormatRegistry} from any {@link DataFormatPlugin}s returned by {@link #getPlugins()},
 * compatible open source license.
     */
            builder.endObject();  
     * A simple capturing {@link DocumentInput} that records addField calls for assertion in pluggable dataformat tests.
            xContentRegistry(),
            throw new UnsupportedOperationException("search lookup not available");
        when(queryShardContext.getIndexSettings()).thenReturn(mapperService.getIndexSettings());
        List<DataFormatPlugin> dataFormatPlugins = getPlugins().stream()
            mapperRegistry,
import org.opensearch.common.xcontent.XContentFactory;
            similarityService,  
        SimilarityService similarityService = new SimilarityService(indexSettings, scriptService, emptyMap());
            .numberOfShards(1)
    protected MapperService createMapperService(XContentBuilder mappings) throws IOException {  
import java.util.List;  
        when(queryShardContext.simpleMatchToIndexNames(any())).thenAnswer(  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        public long getFieldCount(String fieldName) {
        merge(type, mapperService, mappings);  
import static org.mockito.Mockito.when;
 * SPDX-License-Identifier: Apache-2.0
    /**
import java.io.IOException;
            builder.endObject();
    }  
        Collections.singletonMap("include_defaults", "true")  
        when(queryShardContext.getSearchAnalyzer(any())).thenCallRealMethod();
        }, SearchLookup.UNKNOWN_SHARD_ID));  
            getDataFormatRegistry()
import org.opensearch.core.common.bytes.BytesReference;
    /**
            .build();
        return builder.endObject().endObject().endObject();
import org.opensearch.search.lookup.SearchLookup;
            },
            capturedFields.add(Map.entry(fieldType, value));
import static java.util.stream.Collectors.toList;  
import org.opensearch.index.analysis.AnalyzerScope;
        mapping.accept(builder);
import org.opensearch.common.settings.Settings;
import org.opensearch.core.common.bytes.BytesArray;
            () -> true,  
import org.opensearch.index.engine.dataformat.DocumentInput;  
}
     */
    }
            () -> {  
    }  
    }
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 * Unless required by applicable law or agreed to in writing,
    protected final XContentBuilder derivedMapping(CheckedConsumer<XContentBuilder, IOException> buildFields) throws IOException {
    }
    public static class CapturingDocumentInput implements DocumentInput<Object> {  
        return createMapperService(version, mappings).documentMapper();
    protected final DocumentMapper createDocumentMapper(String type, String mappings) throws IOException {
import java.util.Collections;
            indexSettings,
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(dataFormatPlugins);  
        try (
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.plugins.PluginsService;
        IndexMetadata meta = IndexMetadata.builder("index")  
        return builder -> {  
import java.util.Map;
        @Override
        throws IOException {  
        );
        throws IOException {  
        );  
        IndexSettings indexSettings = new IndexSettings(meta, getIndexSettings());
/*
            scriptService,
            () -> {
    protected QueryShardContext createQueryShardContext(MapperService mapperService) {
        });
     */
        );
        return new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON);
import org.apache.lucene.index.IndexReader;
            .filter(p -> p instanceof DataFormatPlugin)
            .collect(toList());
        );
import org.opensearch.plugins.MapperPlugin;
import org.opensearch.script.ScriptModule;  
import java.util.ArrayList;  
import static java.util.Collections.emptyMap;
        .build();  
        }
            .settings(Settings.builder().put("index.version.created", version))  
            .numberOfReplicas(0)
     */
        ScriptService scriptService = new ScriptService(getIndexSettings(), scriptModule.engines, scriptModule.contexts);  
        ).getMapperRegistry();
            .map(p -> (DataFormatPlugin) p)  
    protected Collection<? extends Plugin> getPlugins() {  
 * You may obtain a copy of the License at  
        when(queryShardContext.getObjectMapper(anyString())).thenAnswer(  
    protected static final ToXContent.Params INCLUDE_DEFAULTS = new ToXContent.MapParams(
    /**  
import org.opensearch.test.OpenSearchTestCase;  
            return null;  
        when(queryShardContext.lookup()).thenReturn(new SearchLookup(mapperService, (ft, s) -> {
        private final List<Map.Entry<MappedFieldType, Object>> capturedFields = new ArrayList<>();
import org.opensearch.common.CheckedConsumer;
            .numberOfShards(1)  
            buildFields.accept(builder);  
    protected Settings getIndexSettings() {
            inv -> mapperService.simpleMatchToFullName(inv.getArguments()[0].toString())
        merge(mapperService, mapping);
import static java.util.Collections.singletonMap;
            return capturedFields.stream().filter(e -> e.getKey().name().equals(fieldName)).count();  
        MapperService mapperService = createMapperService(mapping(b -> {}));
     * Create a {@link DocumentMapper} with custom index settings.
            getPlugins().stream().filter(p -> p instanceof ScriptPlugin).map(p -> (ScriptPlugin) p).collect(toList())
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
            xContentRegistry(),  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc").startObject("properties");  
import org.opensearch.index.similarity.SimilarityService;
            createIndexAnalyzers(indexSettings),
        when(queryShardContext.getMapperService()).thenReturn(mapperService);  
     * {@code null} when no data-format plugin is registered (the default), preserving existing behavior.
import org.opensearch.cluster.metadata.IndexMetadata;
        @Override  
    }
    }
            indexSettings,  
    }  
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
    protected final XContentBuilder mapping(CheckedConsumer<XContentBuilder, IOException> buildFields) throws IOException {
        return mapperService;
import org.opensearch.common.compress.CompressedXContent;  
    protected XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField) throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;  
 * this file be licensed under the Apache-2.0 license or a
        return mapperService;
        @Override
import org.opensearch.script.ScriptService;
    }
            .settings(Settings.builder().put("index.version.created", Version.CURRENT).put(settings))
        MapperRegistry mapperRegistry = new IndicesModule(  
        dynamicMapping.toXContent(builder, ToXContent.EMPTY_PARAMS);  
     * Useful for tests that need specific settings like pluggable dataformat.  
            return capturedFields;
    protected final MapperService createMapperService(String type, String mappings) throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        return createMapperService(Version.CURRENT, mappings);
        merge(mapperService, MapperService.MergeReason.MAPPING_UPDATE, mapping);  
        public void setRowId(String rowIdFieldName, long rowId) {}
        MapperService mapperService = createMapperService(mapping(b -> {}));
    protected final void merge(MapperService mapperService, MapperService.MergeReason reason, XContentBuilder mapping) throws IOException {
        public Object getFinalInput() {
        buildFields.accept(builder);  
    /**
     */
        ) {
     * Create a {@link MapperService} with custom index settings.
        when(queryShardContext.documentMapper(anyString())).thenReturn(mapperService.documentMapper());
import org.opensearch.index.IndexSettings;  
        return mapperService.documentMapper();
            inv -> mapperService.getObjectMapper(inv.getArguments()[0].toString())
                b.endObject();
    }  
public abstract class MapperServiceTestCase extends OpenSearchTestCase {  
        }  
    protected final MapperService createMapperService(Settings settings, XContentBuilder mapping) throws IOException {
    }  
            emptyMap(),
import org.opensearch.index.analysis.NamedAnalyzer;  
    }  
            return derivedMapping(b -> {
        IndexMetadata meta = IndexMetadata.builder("index")
 * license agreements. See the NOTICE file distributed with
        }
     * Merge a new mapping into the one in the provided {@link MapperService}.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        SimilarityService similarityService = new SimilarityService(indexSettings, scriptService, emptyMap());
            emptyMap()  
        return fieldMapping(buildField, false);
 * software distributed under the License is distributed on an
    ) throws IOException {  
 */
import org.opensearch.indices.mapper.MapperRegistry;
     * so tests exercising a pluggable data format get capability assignment during mapping build. Returns  
import java.util.Collection;
    }
    }
        return builder.endObject().endObject().endObject();
        return builder.endObject().endObject();
    protected final CheckedConsumer<XContentBuilder, IOException> properties(CheckedConsumer<XContentBuilder, IOException> buildFields)
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.Plugin;  
            }
        if (isDerived) {
        @Override
        build.accept(builder);
    }
            createIndexAnalyzers(indexSettings),
            () -> true,
        when(queryShardContext.getFieldType(any())).thenAnswer(inv -> mapperService.fieldType(inv.getArguments()[0].toString()));
 * specific language governing permissions and limitations
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc").startObject("derived");
import org.opensearch.core.xcontent.ToXContent;
            builder.startObject("context_aware_grouping");
import static org.mockito.Mockito.mock;  
 * not use this file except in compliance with the License.
    protected DataFormatRegistry getDataFormatRegistry() {  
    }
                test.accept(reader);
            .numberOfReplicas(0)
        return createMapperService(settings, mapping).documentMapper();  
import org.apache.lucene.store.Directory;
 * KIND, either express or implied.  See the License for the
            },
        .put("index.version.created", Version.CURRENT)  
/*  
        ScriptModule scriptModule = new ScriptModule(  
                b.startObject("field");  
     * Merge a new mapping into the one in the provided {@link MapperService} with a specific {@code MergeReason}
                throw new UnsupportedOperationException();
        }
            getPlugins().stream().filter(p -> p instanceof MapperPlugin).map(p -> (MapperPlugin) p).collect(toList())
        merge(mapperService, mapping);  
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, new IndexWriterConfig(mapperService.indexAnalyzer()))  
        ).getMapperRegistry();
    protected final DocumentMapper createDocumentMapper(Version version, XContentBuilder mappings) throws IOException {  
        ScriptService scriptService = new ScriptService(settings, scriptModule.engines, scriptModule.contexts);
 */  
    protected final void withLuceneIndex(
        when(queryShardContext.getIndexAnalyzers()).thenReturn(mapperService.getIndexAnalyzers());
        );  
        when(queryShardContext.getSearchQuoteAnalyzer(any())).thenCallRealMethod();  
import static java.util.Collections.emptyList;  
            getPlugins().stream().filter(p -> p instanceof MapperPlugin).map(p -> (MapperPlugin) p).collect(toList())  
    }
 * ownership. Elasticsearch licenses this file to you under  
        return builder.endObject();
        return new DataFormatRegistry(pluginsService);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc");  
 * under the License.  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        return mapping(b -> {  
    protected final XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField, Boolean isDerived)
            builder.accept(iw);
            builder.startObject("properties");
        if (dataFormatPlugins.isEmpty()) {
    protected final DocumentMapper createDocumentMapper(XContentBuilder mappings) throws IOException {
    /**  
        );
        mapperService.merge("_doc", new CompressedXContent(BytesReference.bytes(mapping)), reason);
            buildField.accept(b);
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
        mapperService.merge(type, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        return new IndexAnalyzers(  
        builder.endObject();  
 */  
        MapperService mapperService = new MapperService(  
    }
    protected final SourceToParse source(String source) {
        ScriptModule scriptModule = new ScriptModule(
 * GitHub history for details.
        );
import org.opensearch.plugins.ScriptPlugin;
import static org.mockito.Mockito.anyString;
    protected final void merge(MapperService mapperService, XContentBuilder mapping) throws IOException {
    }
    }
    protected final void merge(String type, MapperService mapperService, String mapping) throws IOException {  
        return new SourceToParse("test", "1", new BytesArray(source), MediaTypeRegistry.JSON);
        IndexSettings indexSettings = new IndexSettings(meta, settings);
            mapperRegistry,
    }
    }  
import org.apache.lucene.index.IndexWriterConfig;  
        };
     * Create a {@link MapperService} like we would for an index.
package org.opensearch.index.mapper;
 *     http://www.apache.org/licenses/LICENSE-2.0
        PluginsService pluginsService = mock(PluginsService.class);
