                    }  
                        return ScoreMode.COMPLETE_NO_SCORES;
                return null;
import org.opensearch.search.lookup.LeafDocLookup;
                    }
        assertEquals(SHARD_ID, searchLookup.shardId());  
                    indexFieldData = queryShardContext.lookup().doc().getForField(fieldType);
import org.apache.lucene.document.StringField;
                        assert docId >= 0;
                return "test";  
                    return leafLookup.doc().get("field1").toString();
import org.apache.lucene.search.Scorable;
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("field", queryShardContext));  
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("field1", queryShardContext));
import org.apache.lucene.search.ScoreMode;
            int i = Integer.parseInt(field.substring(field.length() - 1));
        assertEquals("No field mapping can be found for the field with name [name]", e.getMessage());
import org.opensearch.index.analysis.IndexAnalyzers;
                    public String get(int index) {  
                    @Override  
                    @Override
            @Override
                return false;  
        );
        assertEquals(Collections.singletonList("field1_0"), values);  
    }  
            .put("index.sort.field", "sort_field")
        }  
        assertThat(result, instanceOf(TextFieldMapper.TextFieldType.class));
import org.apache.lucene.search.TermQuery;  
        }  
import org.opensearch.core.xcontent.XContentBuilder;
                }
 * GitHub history for details.
                                }  
        StringBuilder expectedSecondDoc = new StringBuilder();
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
                int i = Integer.parseInt(field.substring(field.length() - 1));
            "Cyclic dependency detected while resolving runtime fields: field1 -> field2 -> field3 -> field4 -> field1",  
import org.apache.lucene.index.LeafReaderContext;  
import java.util.Arrays;  
            indexSettings,
 * not use this file except in compliance with the License.
    private static MappedFieldType mockFieldType(String fieldName, BiFunction<LeafSearchLookup, Integer, String> runtimeDocValues) {
 * compatible open source license.
            () -> 0L,
import org.opensearch.index.mapper.DerivedFieldType;  
    }  
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.core.common.io.stream.StreamOutput;  
            BigArrays.NON_RECYCLING_INSTANCE,  
                for (int i = 0; i < numFields; i++) {
        QueryShardException e = expectThrows(QueryShardException.class, () -> context.failIfFieldMappingNotFound("name", null));
                IndexSearcher searcher = newSearcher(reader);
        assertEquals(Arrays.asList(expectedFirstDoc.toString(), expectedSecondDoc.toString()), collect("field", queryShardContext));
            }  
            IndexFieldData<?> indexFieldData = mock(IndexFieldData.class);
            @Override
            new NamedWriteableRegistry(Collections.emptyList()),
    public void testFielddataLookupTerminatesInLoop() {
}
import static org.mockito.Mockito.mock;  
/*
            new NamedWriteableRegistry(Collections.emptyList()),  
    }
            } else {
                return leafLookup.doc().get("4").toString();
 * ownership. Elasticsearch licenses this file to you under  
        when(derivedFieldResolver.resolve("derived_field_search_req")).thenReturn(mockDerivedFieldType);
            @Override
        indexMetadataBuilder.settings(
        MappedFieldType fieldType = mock(MappedFieldType.class);  
                });
        Settings settings = Settings.builder()  
import org.apache.lucene.store.Directory;
        });  
    }
            expectedSecondDoc.append("test1");
                    value.append(leafLookup.doc().get("field" + i).get(0));  
            null,
            null,
            clusterAlias,
    }
            protected void doWriteTo(StreamOutput out) throws IOException {
                return 0;
                        leafLookup.setDocument(docId);  
        assertThat(shardContext.getFullyQualifiedIndex().getName(), equalTo(clusterAlias + ":index"));
    public void testFielddataLookupSelfReference() {
            () -> nowInMillis,  
        assertEquals(Arrays.asList("test0000", "test1111"), collect("field1", queryShardContext));  
    public void testIndexSortedOnField() {
            () -> true,
 * under the License.  
            public String getWriteableName() {  
 */
        assertThat(result, sameInstance(fieldType));  
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
        });  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        );
            null,
import static org.hamcrest.Matchers.nullValue;  
                .put("index.version.created", Version.CURRENT)  
import org.opensearch.cluster.metadata.IndexMetadata;
            Collections.singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, null)),
    public void testFailIfFieldMappingNotFound() {
import org.opensearch.index.mapper.MapperService;  
            if (field.equals("field")) {  
        SearchLookup searchLookup = createQueryShardContext("uuid", null, null).lookup();
            });
import org.opensearch.common.TriFunction;
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder("index");  
import java.util.Collections;
import org.opensearch.Version;  
            iae.getMessage()
        });
            @Override  
        when(mapperService.index()).thenReturn(indexMetadata.getIndex());
            when(builder.build(any(), any())).thenAnswer(buildInv -> indexFieldData);
                when(leafFieldData.getScriptValues()).thenAnswer(scriptValuesArgs -> new ScriptDocValues<String>() {  
    public void testFielddataLookupReferencesBelowMaxDepth() throws IOException {
        String indexUuid,
 *
        assertEquals(
        StringBuilder expectedFirstDoc = new StringBuilder();
 */  
                    public ScoreMode scoreMode() {  
            }
package org.opensearch.index.query;
import static org.hamcrest.Matchers.sameInstance;
    public static QueryShardContext createQueryShardContext(String indexUuid, String clusterAlias) {  
import java.util.List;
    }  
            IndexFieldData.Builder builder = mock(IndexFieldData.Builder.class);  
import static org.mockito.Mockito.when;
            null,
                            }
import org.apache.lucene.search.Collector;
                    }
import org.opensearch.index.fielddata.LeafFieldData;
            }  
import org.opensearch.index.mapper.MappedFieldType;
                return "test" + docId;
import org.apache.lucene.search.MatchAllDocsQuery;
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("1", queryShardContext));  
                return field + "_" + docId;
        );  
            }
    public void testFielddataLookupOneFieldManyReferences() throws IOException {  
                        LeafSearchLookup leafLookup = searchLookup.get().getLeafSearchLookup(leafReaderContext);
        assertEquals(mockDerivedFieldType, context.failIfFieldMappingNotFound("derived_field_search_req", null));  
 * Modifications Copyright OpenSearch Contributors. See  
                                scriptDocValues.setNextDocId(doc);  
 */
                String fieldName = (String) fieldTypeInv.getArguments()[0];  
                        return value;
                assert docId == 1;  
                return leafFieldData;
            null,
                                if (randomBoolean()) {
                        };
            ? context.getIndexSettings().getIndexMetadata().getIndex().getName()
                return scriptDocValues.get(0).toString() + docId;  
    public void testFielddataLookupBeyondMaxDepth() {
            when(mapperService.fieldType(any())).thenAnswer(fieldTypeInv -> {
    }  
            null,  
                                    scriptDocValues = scriptValues;
import org.opensearch.common.util.BigArrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();  
            protected Query doToQuery(QueryShardContext context) throws IOException {  
        MapperService mapperService = mock(MapperService.class);  
        int numFields = randomIntBetween(5, 20);
import org.opensearch.search.lookup.SearchLookup;
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, null);
 * software distributed under the License is distributed on an
                StringBuilder value = new StringBuilder();
            }
        });
import org.opensearch.common.settings.Settings;  
            // simulate a runtime field cycle: 1: doc['2'] 2: doc['3'] 3: doc['4'] 4: doc['1']  
import org.opensearch.test.OpenSearchTestCase;
            null,
                    indexFieldData = queryShardContext.getForField(fieldType);  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
import static org.mockito.Mockito.any;
        assertThat(result.name(), equalTo("name"));
            Settings.builder()
            null,
                    @Override
        List<String> result = new ArrayList<>();  
            @Override
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, null);  
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.search.LeafCollector;
                                    result.add(scriptDocValues.get(i).toString());
            @SuppressWarnings("unchecked")  
    }  
            : clusterAlias + ":" + context.getIndexSettings().getIndex().getName();
                                ScriptDocValues<?> scriptDocValues;
            SHARD_ID,  
                    public LeafCollector getLeafCollector(LeafReaderContext context) {
            // simulate a runtime field cycle: 1: doc['2'] 2: doc['3'] 3: doc['4'] 4: doc['4']  
            return leafLookup.doc().get(Integer.toString(Integer.parseInt(field) + 1)).toString();
        MappedFieldType result = context.failIfFieldMappingNotFound("name", fieldType);
                }  
        assertThat(exc.getMessage(), equalTo("failed to create query: boom"));
    }  
            null,
            int i = Integer.parseInt(field);
import org.opensearch.index.fielddata.IndexFieldData;
/*
                .put(IndexMetadata.SETTING_INDEX_UUID, indexUuid)  
                IndexFieldData<?> indexFieldData;
            BigArrays.NON_RECYCLING_INSTANCE,
import java.util.function.Supplier;
        context.setMapUnmappedFieldAsString(true);
    }
            return result;  
    }  
                    @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        assertFalse(context.indexSortedOnField("non_sort_field"));
    private static List<String> collect(String field, QueryShardContext queryShardContext) throws IOException {
        return fieldType;
        assertEquals(expected, ((AbstractLeafOrdinalsFieldData) forField.load(null)).getOrdinalsValues().lookupOrd(0).utf8ToString());  
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("1", queryShardContext));
                .put("index.number_of_shards", 1)
                                for (int i = 0; i < scriptDocValues.size(); i++) {
            if (field.equals("4")) {
        }
            return builder;
        });
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
        IndexFieldData<?> forField = context.getForField(mapper.fieldType());
                LeafFieldData leafFieldData = mock(LeafFieldData.class);
            protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        if (runtimeDocValues != null) {
            null,
                searcher.search(query, new Collector() {
import static org.hamcrest.Matchers.notNullValue;
 *  
            }
            if (i == 5) {
import org.apache.lucene.search.Query;  
                if (randomBoolean()) {
        assertNull(context.failIfFieldMappingNotFound("field_missing", null));
                if (field.equals("field4")) {
import org.opensearch.index.analysis.AnalyzerScope;
        when(derivedFieldResolver.resolve("field_missing")).thenReturn(null);
                return leafLookup.doc().get("1").toString();
            @Override  
            }
        final long nowInMillis = randomNonNegativeLong();
        assertThat(result, sameInstance(fieldType));  
                LeafReaderContext leafReaderContext = (LeafReaderContext) loadArgs.getArguments()[0];
    private static QueryShardContext createQueryShardContext(
                                    scriptDocValues = leafDocLookup.get(field);
    private static List<String> collect(String field, QueryShardContext queryShardContext, Query query) throws IOException {
        String clusterAlias = randomAlphaOfLengthBetween(5, 10);
            when(indexFieldData.load(any())).thenAnswer(loadArgs -> {  
                throw new RuntimeException("boom");
        MappedFieldType fieldType = new TextFieldMapper.TextFieldType("text");
    }  
                            public void collect(int doc) throws IOException {  
import org.opensearch.index.mapper.DerivedFieldResolver;
                            @Override
 * Unless required by applicable law or agreed to in writing,
                    }  
                        return 1;
 *     http://www.apache.org/licenses/LICENSE-2.0
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
            null
        result = context.failIfFieldMappingNotFound("name", fieldType);
                            public void setScorer(Scorable scorer) {}  
                MappedFieldType fieldType = queryShardContext.fieldMapper(field);  
        DerivedFieldType mockDerivedFieldType = mock(DerivedFieldType.class);
        for (int i = 0; i < numFields; i++) {  
                return value.toString();
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, clusterAlias);
                                    leafDocLookup.setDocument(doc);
        assertThat(shardContext.getFullyQualifiedIndex().getUUID(), equalTo(indexUuid));
            Supplier<SearchLookup> searchLookup = ((Supplier<SearchLookup>) builderInv.getArguments()[1]);
    public void testSearchLookupShardId() {
 * specific language governing permissions and limitations
        context.setDerivedFieldResolver(derivedFieldResolver);  
    public void testToQueryFails() {
                } else {
 * this work for additional information regarding copyright
        String clusterAlias,  
        result = context.failIfFieldMappingNotFound("name", null);
        QueryShardContext shardContext = createQueryShardContext(indexUuid, clusterAlias);  
        String indexUuid = randomAlphaOfLengthBetween(3, 10);
 * KIND, either express or implied.  See the License for the
            if (field.equals("4")) {
 *
            null
        assertFalse(context.indexSortedOnField("second_sort_field"));  
        assertEquals("Cyclic dependency detected while resolving runtime fields: field -> field", iae.getMessage());
    }
        final String clusterAlias = randomBoolean() ? null : "remote_cluster";  
            .build();
import static org.hamcrest.Matchers.equalTo;  
            indexSettings,
            return leafLookup.doc().get(Integer.toString(i + 1)).toString();
        QueryShardContext context = new QueryShardContext(  
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, null);  
    private static final int SHARD_ID = 0;
 * license agreements. See the NOTICE file distributed with
    }
        return collect(field, queryShardContext, new MatchAllDocsQuery());
        result = context.failIfFieldMappingNotFound("name", fieldType);  
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {  
            null,  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(result, nullValue());
            }
    public void testClusterAlias() throws IOException {
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            indexWriter.addDocument(Collections.singletonList(new StringField("indexed_field", "second", Field.Store.NO)));  
                        ScriptDocValues<?> scriptValues = indexFieldData.load(context).getScriptValues();  
            protected boolean doEquals(AbstractQueryBuilder other) {
                    public void setNextDocId(int docId) {  
            Collections.emptyMap()
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.Term;
            expectedFirstDoc.append("test0");
                .put("index.number_of_replicas", 1)
        });  
import org.opensearch.index.mapper.IndexFieldMapper;
        context.setAllowUnmappedFields(false);  
        context.setAllowUnmappedFields(true);
/*  
        List<String> values = collect("field1", queryShardContext, new TermQuery(new Term("indexed_field", "first")));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * You may obtain a copy of the License at  
        assertEquals("Cyclic dependency detected while resolving runtime fields: 1 -> 2 -> 3 -> 4 -> 4", iae.getMessage());
        });
        assertThat(result, notNullValue());  
        assertNull(context.failIfFieldMappingNotFound("derived_field_search_req", null));
public class QueryShardContextTests extends OpenSearchTestCase {  
            // simulate a runtime field that depends on itself e.g. field: doc['field']  
 * the Apache License, Version 2.0 (the "License"); you may
                    @Override
        TriFunction<String, LeafSearchLookup, Integer, String> runtimeDocValues
    }
            }  
import java.util.ArrayList;
            }
        );
            mapperService,
            null,  
        String expected = clusterAlias == null  
            } else {  
            null,  
            () -> true,  
        context.setAllowUnmappedFields(false);
        DerivedFieldResolver derivedFieldResolver = mock(DerivedFieldResolver.class);
            NamedXContentRegistry.EMPTY,
    public void testGetFullyQualifiedIndex() {  
import org.opensearch.search.lookup.LeafSearchLookup;  
        );
                        value = runtimeDocValues.apply(leafLookup, docId);
 * The OpenSearch Contributors require contributions made to  
            });
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
                                }
            } else {
import org.opensearch.index.analysis.NamedAnalyzer;  
                        assert index == 0;
import org.opensearch.index.fielddata.ScriptDocValues;  
                    String value;
import static org.hamcrest.Matchers.instanceOf;
        });
    }
        return createQueryShardContext(indexUuid, clusterAlias, null);
        result = context.failIfFieldMappingNotFound("name", null);
    }
import java.util.function.BiFunction;  
import org.apache.lucene.search.IndexSearcher;  
                    }  
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(
import org.opensearch.index.mapper.TextFieldMapper;
            null,  
        assertEquals("Field requires resolving too many dependent fields: 1 -> 2 -> 3 -> 4 -> 5 -> 6", iae.getMessage());
            indexWriter.addDocument(Collections.singletonList(new StringField("indexed_field", "first", Field.Store.NO)));
        when(fieldType.name()).thenReturn(fieldName);
    public void testFielddataLookupLooseLoop() {
        }));
    }
            null,
            if (docId == 0) {  
import java.io.IOException;
                });  
                return leafLookup.doc().get("field" + (i + 1)).toString();
                                    LeafDocLookup leafDocLookup = queryShardContext.lookup().doc().getLeafDocLookup(context);  
            }  
        IndexFieldMapper mapper = new IndexFieldMapper();  
        when(fieldType.fielddataBuilder(any(), any())).thenAnswer(builderInv -> {
        assertTrue(context.indexSortedOnField("sort_field"));
import org.apache.lucene.document.Field;  
            (mappedFieldType, idxName, searchLookup) -> mappedFieldType.fielddataBuilder(idxName, searchLookup).build(null, null),
            NamedXContentRegistry.EMPTY,  
            return leafLookup.doc().get(Integer.toString(Integer.parseInt(field) + 1)).toString();
                }  
            try (DirectoryReader reader = indexWriter.getReader()) {
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
                        return new LeafCollector() {
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
            }  
            return leafLookup.doc().get(field).toString();
                return mockFieldType(fieldName, (leafSearchLookup, docId) -> runtimeDocValues.apply(fieldName, leafSearchLookup, docId));
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {  
                                } else {  
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("1", queryShardContext));  
    public void testFielddataLookupSometimesLoop() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.DirectoryReader;
        when(mapperService.getIndexAnalyzers()).thenReturn(indexAnalyzers);  
import org.opensearch.index.IndexSettings;  
        Exception exc = expectThrows(Exception.class, () -> context.toQuery(new AbstractQueryBuilder() {
                            @Override
    ) {
                ScriptDocValues<?> scriptDocValues = leafLookup.doc().get("field" + (i + 1));
        assertThat(result, sameInstance(fieldType));
        assertEquals("Cyclic dependency detected while resolving runtime fields: 1 -> 2 -> 3 -> 4 -> 1", iae.getMessage());
                    public int size() {
            Collections.emptyMap(),  
            protected int doHashCode() {
            0,
    public void testDerivedFieldMapping() {
        return new QueryShardContext(
