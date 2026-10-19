    }
        );
        assertThat(exc.getMessage(), equalTo("failed to create query: boom"));
                return "test" + docId;
                .put("index.version.created", Version.CURRENT)
                return null;
        }));
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
                }
            }
        assertThat(result, nullValue());
        int numFields = randomIntBetween(5, 20);
import org.apache.lucene.tests.index.RandomIndexWriter;
            "Cyclic dependency detected while resolving runtime fields: field1 -> field2 -> field3 -> field4 -> field1",
    private static MappedFieldType mockFieldType(String fieldName, BiFunction<LeafSearchLookup, Integer, String> runtimeDocValues) {
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, null);
                                    LeafDocLookup leafDocLookup = queryShardContext.lookup().doc().getLeafDocLookup(context);
 */
        List<String> values = collect("field1", queryShardContext, new TermQuery(new Term("indexed_field", "first")));
 *
        });
        assertTrue(context.indexSortedOnField("sort_field"));
            indexWriter.addDocument(Collections.singletonList(new StringField("indexed_field", "second", Field.Store.NO)));
            (mappedFieldType, idxName, searchLookup) -> mappedFieldType.fielddataBuilder(idxName, searchLookup).build(null, null),
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("1", queryShardContext));
            null,
            iae.getMessage()
import org.apache.lucene.index.Term;
    public void testToQueryFails() {
import java.util.function.Supplier;
            } else {
import org.opensearch.index.analysis.IndexAnalyzers;
            NamedXContentRegistry.EMPTY,
    }
import org.apache.lucene.search.Query;
            clusterAlias,
        context.setAllowUnmappedFields(true);
import org.apache.lucene.search.ScoreMode;
            null,
 * Modifications Copyright OpenSearch Contributors. See
            IndexFieldData.Builder builder = mock(IndexFieldData.Builder.class);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("No field mapping can be found for the field with name [name]", e.getMessage());
            mapperService,
        assertThat(shardContext.getFullyQualifiedIndex().getName(), equalTo(clusterAlias + ":index"));
        });
            } else {
    ) {
        MappedFieldType result = context.failIfFieldMappingNotFound("name", fieldType);
            public String getWriteableName() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            null,
import org.opensearch.search.lookup.SearchLookup;
                return leafFieldData;
                        leafLookup.setDocument(docId);
            @SuppressWarnings("unchecked")
import static org.mockito.Mockito.any;
import org.opensearch.index.fielddata.ScriptDocValues;
        result = context.failIfFieldMappingNotFound("name", fieldType);
        assertEquals(expected, ((AbstractLeafOrdinalsFieldData) forField.load(null)).getOrdinalsValues().lookupOrd(0).utf8ToString());
            null,
            indexWriter.addDocument(Collections.singletonList(new StringField("indexed_field", "first", Field.Store.NO)));
import org.opensearch.index.fielddata.LeafFieldData;
            expectedFirstDoc.append("test0");
            @Override
        when(fieldType.fielddataBuilder(any(), any())).thenAnswer(builderInv -> {
import org.opensearch.index.analysis.NamedAnalyzer;
            return leafLookup.doc().get(Integer.toString(Integer.parseInt(field) + 1)).toString();
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                assert docId == 1;
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("1", queryShardContext));
 */
                    indexFieldData = queryShardContext.lookup().doc().getForField(fieldType);
    }
                }
            null
}
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, null);
        assertFalse(context.indexSortedOnField("non_sort_field"));
                LeafFieldData leafFieldData = mock(LeafFieldData.class);
            if (i == 5) {
            Collections.singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, null)),
            return result;
        assertThat(result, instanceOf(TextFieldMapper.TextFieldType.class));
        when(fieldType.name()).thenReturn(fieldName);
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
                            @Override
        result = context.failIfFieldMappingNotFound("name", null);
import org.apache.lucene.store.Directory;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.common.TriFunction;
import org.apache.lucene.document.StringField;
                }
            }
package org.opensearch.index.query;
    }
                String fieldName = (String) fieldTypeInv.getArguments()[0];
        assertEquals(Arrays.asList(expectedFirstDoc.toString(), expectedSecondDoc.toString()), collect("field", queryShardContext));
                                    scriptDocValues = leafDocLookup.get(field);
        MapperService mapperService = mock(MapperService.class);
import org.opensearch.index.mapper.MappedFieldType;
            if (field.equals("4")) {
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        indexMetadataBuilder.settings(
    }
        context.setAllowUnmappedFields(false);
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
                return value.toString();
        assertNull(context.failIfFieldMappingNotFound("derived_field_search_req", null));
            SHARD_ID,
            when(mapperService.fieldType(any())).thenAnswer(fieldTypeInv -> {
                LeafReaderContext leafReaderContext = (LeafReaderContext) loadArgs.getArguments()[0];
            new NamedWriteableRegistry(Collections.emptyList()),
            }
    }
                if (randomBoolean()) {
        result = context.failIfFieldMappingNotFound("name", null);
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
    }
            return builder;
import org.opensearch.Version;
import static org.hamcrest.Matchers.instanceOf;
            try (DirectoryReader reader = indexWriter.getReader()) {
                    public ScoreMode scoreMode() {
            () -> true,
 * specific language governing permissions and limitations
    }
 */
import org.opensearch.index.fielddata.IndexFieldData;
        result = context.failIfFieldMappingNotFound("name", fieldType);
import org.opensearch.index.mapper.TextFieldMapper;
        assertNull(context.failIfFieldMappingNotFound("field_missing", null));
import static org.mockito.Mockito.mock;
            if (field.equals("4")) {
                                if (randomBoolean()) {
        assertEquals("Field requires resolving too many dependent fields: 1 -> 2 -> 3 -> 4 -> 5 -> 6", iae.getMessage());
                ScriptDocValues<?> scriptDocValues = leafLookup.doc().get("field" + (i + 1));
                return leafLookup.doc().get("4").toString();
        assertEquals(
        assertThat(result, notNullValue());
    }
            () -> nowInMillis,
            }
                                for (int i = 0; i < scriptDocValues.size(); i++) {
                        assert docId >= 0;
                return false;
            null,
            protected Query doToQuery(QueryShardContext context) throws IOException {
    private static List<String> collect(String field, QueryShardContext queryShardContext) throws IOException {
    public void testFielddataLookupLooseLoop() {
                                }
import org.opensearch.index.mapper.DerivedFieldType;
                            public void setScorer(Scorable scorer) {}
                    public int size() {
            return leafLookup.doc().get(Integer.toString(i + 1)).toString();
                                }
        assertFalse(context.indexSortedOnField("second_sort_field"));
        }
import org.apache.lucene.search.LeafCollector;
        return collect(field, queryShardContext, new MatchAllDocsQuery());
                return "test";
        String indexUuid,
        assertThat(result, sameInstance(fieldType));
            null,
        QueryShardContext context = new QueryShardContext(
            });
 * SPDX-License-Identifier: Apache-2.0
        final long nowInMillis = randomNonNegativeLong();
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder("index");
import org.apache.lucene.search.MatchAllDocsQuery;
import java.util.List;
    public void testFailIfFieldMappingNotFound() {
                    }
                    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else {
                    @Override
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("field", queryShardContext));
    }
        context.setMapUnmappedFieldAsString(true);
import org.opensearch.index.mapper.MapperService;
        return fieldType;
import org.opensearch.cluster.metadata.IndexMetadata;
        Settings settings = Settings.builder()
        assertThat(result.name(), equalTo("name"));
            } else {
        context.setAllowUnmappedFields(false);
            // simulate a runtime field that depends on itself e.g. field: doc['field']
                    return leafLookup.doc().get("field1").toString();
                                } else {
            protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, clusterAlias);
                if (field.equals("field4")) {
        MappedFieldType fieldType = new TextFieldMapper.TextFieldType("text");
import java.io.IOException;
            int i = Integer.parseInt(field.substring(field.length() - 1));
        assertEquals("Cyclic dependency detected while resolving runtime fields: 1 -> 2 -> 3 -> 4 -> 4", iae.getMessage());
                return mockFieldType(fieldName, (leafSearchLookup, docId) -> runtimeDocValues.apply(fieldName, leafSearchLookup, docId));
            int i = Integer.parseInt(field);
import org.apache.lucene.search.Scorable;
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            return leafLookup.doc().get(Integer.toString(Integer.parseInt(field) + 1)).toString();
                    indexFieldData = queryShardContext.getForField(fieldType);
        });
    public void testFielddataLookupTerminatesInLoop() {
            }
            () -> true,
            null,
                    }
import org.opensearch.search.lookup.LeafDocLookup;
    public void testSearchLookupShardId() {
        );
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
                    }
import org.opensearch.core.xcontent.XContentBuilder;
                        return value;
    }
                        value = runtimeDocValues.apply(leafLookup, docId);
                when(leafFieldData.getScriptValues()).thenAnswer(scriptValuesArgs -> new ScriptDocValues<String>() {
                return field + "_" + docId;
                            }
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
            indexSettings,
    }
import org.opensearch.index.IndexSettings;
 *
        when(derivedFieldResolver.resolve("derived_field_search_req")).thenReturn(mockDerivedFieldType);
        assertEquals(Collections.singletonList("field1_0"), values);
                        };
                return leafLookup.doc().get("field" + (i + 1)).toString();
                        ScriptDocValues<?> scriptValues = indexFieldData.load(context).getScriptValues();
            @Override
            null,
        DerivedFieldType mockDerivedFieldType = mock(DerivedFieldType.class);
            @Override
                searcher.search(query, new Collector() {
import org.opensearch.common.util.BigArrays;
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
            null,
            // simulate a runtime field cycle: 1: doc['2'] 2: doc['3'] 3: doc['4'] 4: doc['1']
                                    result.add(scriptDocValues.get(i).toString());
        return createQueryShardContext(indexUuid, clusterAlias, null);
                    @Override
        IndexFieldMapper mapper = new IndexFieldMapper();
            }
 *
        }
            @Override
 * under the License.
import org.opensearch.search.lookup.LeafSearchLookup;
            return leafLookup.doc().get(field).toString();
            when(indexFieldData.load(any())).thenAnswer(loadArgs -> {
import static org.hamcrest.Matchers.nullValue;
                                    leafDocLookup.setDocument(doc);
                return 0;
import org.apache.lucene.index.LeafReaderContext;
import java.util.Arrays;
import java.util.function.BiFunction;
            @Override
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
    }
                IndexFieldData<?> indexFieldData;
    public void testClusterAlias() throws IOException {
        IndexFieldData<?> forField = context.getForField(mapper.fieldType());
    public void testFielddataLookupReferencesBelowMaxDepth() throws IOException {
 * KIND, either express or implied.  See the License for the
                    public String get(int index) {
        QueryShardContext shardContext = createQueryShardContext(indexUuid, clusterAlias);
    private static QueryShardContext createQueryShardContext(
            NamedXContentRegistry.EMPTY,
                    }
        when(mapperService.index()).thenReturn(indexMetadata.getIndex());
            Collections.emptyMap(),
    public void testFielddataLookupOneFieldManyReferences() throws IOException {
                int i = Integer.parseInt(field.substring(field.length() - 1));
    public void testFielddataLookupBeyondMaxDepth() {
        final String clusterAlias = randomBoolean() ? null : "remote_cluster";
        });
import static org.hamcrest.Matchers.equalTo;
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
            }
        DerivedFieldResolver derivedFieldResolver = mock(DerivedFieldResolver.class);
    private static final int SHARD_ID = 0;
                                ScriptDocValues<?> scriptDocValues;
                                scriptDocValues.setNextDocId(doc);
        String clusterAlias = randomAlphaOfLengthBetween(5, 10);
import org.apache.lucene.search.Collector;
            .put("index.sort.field", "sort_field")
            null,
    public static QueryShardContext createQueryShardContext(String indexUuid, String clusterAlias) {
            : clusterAlias + ":" + context.getIndexSettings().getIndex().getName();
                    String value;
                MappedFieldType fieldType = queryShardContext.fieldMapper(field);
        TriFunction<String, LeafSearchLookup, Integer, String> runtimeDocValues
            // simulate a runtime field cycle: 1: doc['2'] 2: doc['3'] 3: doc['4'] 4: doc['4']
import java.util.ArrayList;
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
public class QueryShardContextTests extends OpenSearchTestCase {
                            @Override
import static org.hamcrest.Matchers.notNullValue;
            indexSettings,
                .put(IndexMetadata.SETTING_INDEX_UUID, indexUuid)
        assertThat(result, sameInstance(fieldType));
import org.apache.lucene.search.IndexSearcher;
                        return new LeafCollector() {
        assertEquals("Cyclic dependency detected while resolving runtime fields: field -> field", iae.getMessage());
        when(mapperService.getIndexAnalyzers()).thenReturn(indexAnalyzers);
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
        assertEquals(mockDerivedFieldType, context.failIfFieldMappingNotFound("derived_field_search_req", null));
                StringBuilder value = new StringBuilder();
    public void testIndexSortedOnField() {
        String indexUuid = randomAlphaOfLengthBetween(3, 10);
            0,
    }
                .put("index.number_of_shards", 1)
        when(derivedFieldResolver.resolve("field_missing")).thenReturn(null);
            }
                    public void setNextDocId(int docId) {
/*
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import static org.hamcrest.Matchers.sameInstance;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            null,
        assertEquals(Arrays.asList("test0000", "test1111"), collect("field1", queryShardContext));
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("1", queryShardContext));
            IndexFieldData<?> indexFieldData = mock(IndexFieldData.class);
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.index.mapper.DerivedFieldResolver;
import org.opensearch.index.mapper.IndexFieldMapper;
 * this work for additional information regarding copyright
 * GitHub history for details.
            @Override
        QueryShardContext context = createQueryShardContext(IndexMetadata.INDEX_UUID_NA_VALUE, null);
                    public LeafCollector getLeafCollector(LeafReaderContext context) {
    }
            }
        });
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
                .put("index.number_of_replicas", 1)
        return new QueryShardContext(
 * Unless required by applicable law or agreed to in writing,
import static org.mockito.Mockito.when;
    private static List<String> collect(String field, QueryShardContext queryShardContext, Query query) throws IOException {
            expectedSecondDoc.append("test1");
            Supplier<SearchLookup> searchLookup = ((Supplier<SearchLookup>) builderInv.getArguments()[1]);
        IndexAnalyzers indexAnalyzers = new IndexAnalyzers(
                    }
            () -> 0L,
            when(builder.build(any(), any())).thenAnswer(buildInv -> indexFieldData);
 * You may obtain a copy of the License at
        SearchLookup searchLookup = createQueryShardContext("uuid", null, null).lookup();
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> collect("field1", queryShardContext));
                    @Override
    }
        });
import org.opensearch.core.xcontent.NamedXContentRegistry;
        String expected = clusterAlias == null
        Exception exc = expectThrows(Exception.class, () -> context.toQuery(new AbstractQueryBuilder() {
            Collections.emptyMap()
            }
        StringBuilder expectedSecondDoc = new StringBuilder();
        MappedFieldType fieldType = mock(MappedFieldType.class);
            Settings.builder()
                                    scriptDocValues = scriptValues;
                        return 1;
        context.setDerivedFieldResolver(derivedFieldResolver);
import org.opensearch.index.analysis.AnalyzerScope;
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < numFields; i++) {
        assertEquals("Cyclic dependency detected while resolving runtime fields: 1 -> 2 -> 3 -> 4 -> 1", iae.getMessage());
            null
                return scriptDocValues.get(0).toString() + docId;
            protected boolean doEquals(AbstractQueryBuilder other) {
    }
                        return ScoreMode.COMPLETE_NO_SCORES;
        QueryShardException e = expectThrows(QueryShardException.class, () -> context.failIfFieldMappingNotFound("name", null));
                });
            null,
/*
/*
            ? context.getIndexSettings().getIndexMetadata().getIndex().getName()
    }
        List<String> result = new ArrayList<>();
            if (docId == 0) {
            .build();
import org.apache.lucene.search.TermQuery;
            new NamedWriteableRegistry(Collections.emptyList()),
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
            null,
                        assert index == 0;
            null,
        }
                });
import org.apache.lucene.index.DirectoryReader;
        );
        QueryShardContext queryShardContext = createQueryShardContext("uuid", null, (field, leafLookup, docId) -> {
            protected void doWriteTo(StreamOutput out) throws IOException {
                    value.append(leafLookup.doc().get("field" + i).get(0));
            BigArrays.NON_RECYCLING_INSTANCE,
                            public void collect(int doc) throws IOException {
            if (field.equals("field")) {
        assertEquals(SHARD_ID, searchLookup.shardId());
                    @Override
            protected int doHashCode() {
        String clusterAlias,
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(shardContext.getFullyQualifiedIndex().getUUID(), equalTo(indexUuid));
        StringBuilder expectedFirstDoc = new StringBuilder();
        });
        });
            });
            null,
    public void testFielddataLookupSelfReference() {
    public void testFielddataLookupSometimesLoop() throws IOException {
                throw new RuntimeException("boom");
    public void testGetFullyQualifiedIndex() {
    public void testDerivedFieldMapping() {
            BigArrays.NON_RECYCLING_INSTANCE,
import org.apache.lucene.document.Field;
                for (int i = 0; i < numFields; i++) {
            }
        assertThat(result, sameInstance(fieldType));
                IndexSearcher searcher = newSearcher(reader);
        );
                return leafLookup.doc().get("1").toString();
                        LeafSearchLookup leafLookup = searchLookup.get().getLeafSearchLookup(leafReaderContext);
        if (runtimeDocValues != null) {
        );
