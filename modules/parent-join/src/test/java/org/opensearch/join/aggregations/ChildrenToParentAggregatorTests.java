        List<Map.Entry<Integer, Long>> sortedValues = new ArrayList<>(entries.entrySet());
            testCase(  
 * ownership. Elasticsearch licenses this file to you under  
            for (Tuple<Integer, Integer> expectedValues : expectedParentChildRelations.values()) {  
 * not use this file except in compliance with the License.
    public void testNoDocs() throws IOException {
        aggregationBuilder.subAggregation(new TermsAggregationBuilder("value_terms").field("number"));
            }  
    private static final String PARENT_TYPE = "parent_type";
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.index.mapper.IdFieldMapper;
 *
        }  
            int numChildren = randomIntBetween(1, 10);  
        indexReader.close();  
        int numParents = randomIntBetween(1, 10);  
        for (int i = 0; i < numParents; i++) {
        // verify with all documents
import org.apache.lucene.document.SortedNumericDocValuesField;  
 */  
        ParentAggregationBuilder aggregationBuilder = new ParentAggregationBuilder("_name", CHILD_TYPE);
        IndexReader indexReader = DirectoryReader.open(directory);
            new SortedNumericDocValuesField("number", value)  
    public void testTermsParentChildTerms() throws IOException {
 * this work for additional information regarding copyright
        indexWriter.close();
    // run a terms aggregation on the number in child-documents, then a parent aggregation and then terms on the parent-number  
import org.apache.lucene.store.Directory;
import java.util.List;
            int i = 0;  
 * Unless required by applicable law or agreed to in writing,
/*  
    private void testCase(Query query, IndexSearcher indexSearcher, Consumer<InternalParent> verify) throws IOException {
    private void testCaseTermsParentTerms(Query query, IndexSearcher indexSearcher, Consumer<LongTerms> verify) throws IOException {
import static org.mockito.Mockito.mock;
        indexWriter.close();  
 * You may obtain a copy of the License at  
                expectedTotalParents,  
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);  
    private static final String CHILD_TYPE = "child_type";
            iw.addDocuments(documents);
            assertTrue(JoinAggregationInspectionHelper.hasValue(parent));
                }
            return o1.getKey().compareTo(o2.getKey());
                    );
    private static List<Field> createChildDocument(String childId, String parentId, int value) {
            assertNotNull(valueTerms);
            assertEquals(0, childrenToParent.getDocCount());  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.join.ParentJoinModulePlugin;  
import org.opensearch.index.mapper.Mapper;
        testCase(new MatchAllDocsQuery(), newSearcher(indexReader, false, true), childrenToParent -> {  
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
            if (ret != 0) {
import org.opensearch.index.mapper.Uid;
import org.opensearch.index.mapper.NumberFieldMapper;
        verify.accept(result);  
        return Collections.singletonList(new ParentJoinModulePlugin());
        when(mapperService.fieldType("_parent_join")).thenReturn(metaJoinFieldType);
    }
            sortedValues.put(value.v2(), l + 1);  
        AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("subvalue_terms").field("subNumber")
    }
            List<List<Field>> documents = new ArrayList<>();
        Map<String, Tuple<Integer, Integer>> expectedValues = new HashMap<>();
            for (Map.Entry<Integer, Long> entry : sortedValues) {
                new ParentAggregationBuilder("to_parent", CHILD_TYPE).subAggregation(
import org.opensearch.join.mapper.MetaJoinFieldMapper;
    @Override
            new SortedNumericDocValuesField("subNumber", value)  
            null
                        1,  
    }
    private static SortedDocValuesField createJoinField(String parentType, String id) {
        InternalParent result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
            );
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
                )  
        // verify a terms-aggregation inside the parent-aggregation
    protected List<SearchPlugin> getSearchPlugins() {
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
                assertNotNull(bucket.getKeyAsString());
    }
import java.util.Collections;  
import org.opensearch.index.mapper.MappedFieldType;  
            Aggregation parentAggregation = childrenToParent.getAggregations().get("in_parent");
import java.util.ArrayList;
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
public class ChildrenToParentAggregatorTests extends AggregatorTestCase {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashMap;
    }  
        indexWriter.close();
        // intentionally not writing any docs
import java.util.SortedMap;
            assertTrue(JoinAggregationInspectionHelper.hasValue(parent));
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
        return expectedValues;
import org.opensearch.search.aggregations.AggregatorTestCase;  
            for (int c = 0; c < numChildren; c++) {
        directory.close();
            assertEquals(
}
            entries.put(value.v2(), l + 1);
        }  
        MappedFieldType subFieldType = new NumberFieldMapper.NumberFieldType("subNumber", NumberFieldMapper.NumberType.LONG);
            0,
        }
 * compatible open source license.
        directory.close();  
package org.opensearch.join.aggregations;
        Directory directory = newDirectory();
        });
 * license agreements. See the NOTICE file distributed with
            assertEquals("Had: " + parent, sortedValues.size(), valueTermsBuckets.size());
        InternalParent result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
        SortedMap<Integer, Long> sortedValues = new TreeMap<>();  
import org.opensearch.index.mapper.DocumentMapper;
        // verify a terms-aggregation inside the parent-aggregation which itself is inside a
    @Override  
                        Double.MIN_VALUE  
import org.opensearch.index.mapper.MapperService;
        return Arrays.asList(
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        testCaseTerms(new MatchAllDocsQuery(), indexSearcher, parent -> {  
                assertEquals(entry.getKey().longValue(), bucket.getKeyAsNumber());  
                        aggregation.getDocCount()
            assertFalse(JoinAggregationInspectionHelper.hasValue(childrenToParent));  
        when(mockMapper.mappers()).thenReturn(fieldMappers);
    private static Map<String, Tuple<Integer, Integer>> setupIndex(RandomIndexWriter iw) throws IOException {
            int ret = o2.getValue().compareTo(o1.getValue());
import org.opensearch.search.aggregations.AggregationBuilder;
        }
            Long l = entries.computeIfAbsent(value.v2(), integer -> 0L);
 */
    private static List<Field> createParentDocument(String id, int value) {
            );  
        MappingLookup fieldMappers = new MappingLookup(  
import org.apache.lucene.document.SortedDocValuesField;
        SortedMap<Integer, Long> entries = new TreeMap<>();
import org.apache.lucene.search.MatchAllDocsQuery;
                indexSearcher,
        MapperService mapperService = mock(MapperService.class);
    }  
                    assertEquals(  
        return mapperService;
        indexWriter.close();  
    }
    }
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
 * SPDX-License-Identifier: Apache-2.0
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
        });
        indexReader.close();  
            }
                expectedMinValue = Math.min(expectedMinValue, expectedValues.v2());
import org.apache.lucene.document.StringField;
    public void testParentChildTerms() throws IOException {
            new StringField(IdFieldMapper.NAME, Uid.encodeId(childId), Field.Store.NO),  
    }
        indexReader.close();
    }  
import org.opensearch.join.mapper.ParentJoinFieldMapper;
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
                    assertEquals(
                parent.getDocCount()
            LongTerms valueTerms = parent.getAggregations().get("value_terms");  
                LongTerms.Bucket bucket = valueTermsBuckets.get(i);
import org.apache.lucene.document.Field;
    protected MapperService mapperServiceMock() {  
        for (String parent : expectedParentChildRelations.keySet()) {
        Directory directory = newDirectory();  
                assertNotNull(bucket);
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
                assertEquals(entry.getValue(), (Long) bucket.getDocCount());
    }
            for (LongTerms.Bucket bucket : longTerms.getBuckets()) {  
            .subAggregation(  
        return new ParentJoinFieldMapper.Builder("join_field").addParent(PARENT_TYPE, Collections.singleton(CHILD_TYPE))  
            assertEquals(0, childrenToParent.getDocCount());
        for (Tuple<Integer, Integer> value : expectedParentChildRelations.values()) {
import org.apache.lucene.tests.index.RandomIndexWriter;  
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
        // verify for each children
        verify.accept(result);
            documents.add(createParentDocument(parent, randomValue));
            Collections.singleton(joinFieldMapper),
    public void testParentChild() throws IOException {  
        );
 * software distributed under the License is distributed on an
            // on equal value, sort by key  
 * the Apache License, Version 2.0 (the "License"); you may
        );  
            .build(new Mapper.BuilderContext(settings, new ContentPath(0)));
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
            Collections.emptyList(),  
        indexReader.close();
                    );
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            expectedValues.put(parent, new Tuple<>(numChildren, minValue));
import org.opensearch.plugins.SearchPlugin;  
                i++;  
import org.opensearch.Version;
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
            assertEquals(Double.POSITIVE_INFINITY, ((InternalMin) parentAggregation).getValue(), Double.MIN_VALUE);
        return new SortedDocValuesField("join_field#" + parentType, new BytesRef(id));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void testCaseTerms(Query query, IndexSearcher indexSearcher, Consumer<InternalParent> verify) throws IOException {
            createJoinField(PARENT_TYPE, id),
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
import org.opensearch.search.aggregations.Aggregation;
            assertNotNull("Aggregations: " + childrenToParent.getAggregations().asMap(), parentAggregation);
/*  
        MetaJoinFieldMapper.MetaJoinFieldType metaJoinFieldType = mock(MetaJoinFieldMapper.MetaJoinFieldType.class);  
                    new TermsAggregationBuilder("value_terms").field("number")
        for (Tuple<Integer, Integer> value : expectedParentChildRelations.values()) {  
 *
 *  
    }
            int expectedMinValue = Integer.MAX_VALUE;
        when(metaJoinFieldType.getJoinField()).thenReturn("join_field");
        return Arrays.asList(
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));  
        testCase(new MatchAllDocsQuery(), indexSearcher, parent -> {  
    }
            );
        Directory directory = newDirectory();
            int minValue = Integer.MAX_VALUE;
 * specific language governing permissions and limitations
                return ret;  
                expectedTotalParents++;
            new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.NO),  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            int randomValue = randomIntBetween(0, 100);
        aggregationBuilder.subAggregation(new MinAggregationBuilder("in_parent").field("number"));
        directory.close();
    private static ParentJoinFieldMapper createJoinFieldMapper() {
import java.util.Arrays;
        Directory directory = newDirectory();
                int randomSubValue = randomIntBetween(0, 100);
                aggregation -> {  
import org.opensearch.common.collect.Tuple;
            int expectedTotalParents = 0;
                minValue = Math.min(minValue, randomValue);  
            new StringField("join_field", CHILD_TYPE, Field.Store.NO),
            assertNotNull(longTerms);
        ParentJoinFieldMapper joinFieldMapper = createJoinFieldMapper();
                new TermInSetQuery(IdFieldMapper.NAME, Collections.singleton(Uid.encodeId("child0_" + parent))),
        testCaseTermsParentTerms(new MatchAllDocsQuery(), indexSearcher, longTerms -> {  
            assertNotNull(parent);
            createJoinField(PARENT_TYPE, parentId),
import org.opensearch.index.mapper.ContentPath;  
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
            assertEquals(expectedMinValue, ((InternalMin) parent.getAggregations().get("in_parent")).getValue(), Double.MIN_VALUE);  
            new StringField("join_field", PARENT_TYPE, Field.Store.NO),
        );
 * The OpenSearch Contributors require contributions made to  
        // terms-aggregation on the child-documents
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.cluster.metadata.IndexMetadata;  
                documents.add(createChildDocument("child" + c + "_" + parent, parent, randomSubValue));
            List<LongTerms.Bucket> valueTermsBuckets = valueTerms.getBuckets();  
 */  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                        "Expected one result for min-aggregation for parent: " + parent + ", but had aggregation-results: " + aggregation,
import org.apache.lucene.search.TermInSetQuery;
            assertNotNull(valueTermsBuckets);
import org.opensearch.search.aggregations.metrics.InternalMin;  
        sortedValues.sort((o1, o2) -> {
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);  
import org.apache.lucene.search.Query;  
        directory.close();
import org.opensearch.core.index.Index;
            Long l = sortedValues.computeIfAbsent(value.v2(), integer -> 0L);
import org.opensearch.index.mapper.MappingLookup;  
        LongTerms result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType, subFieldType);
        verify.accept(result);  
import org.opensearch.common.settings.Settings;  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        when(mapperService.documentMapper()).thenReturn(mockMapper);  
/*
        DocumentMapper mockMapper = mock(DocumentMapper.class);
import java.util.function.Consumer;  
            }
import org.apache.lucene.index.IndexReader;  
        });
    }  
import java.util.Map;  
 * GitHub history for details.
            String parent = "parent" + i;  
            }  
import org.apache.lucene.index.DirectoryReader;
                        ((InternalMin) aggregation.getAggregations().get("in_parent")).getValue(),
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        });
                "Having " + parent.getDocCount() + " docs and aggregation results: " + parent,
import org.apache.lucene.util.BytesRef;
            // sort larger values first  
        ParentAggregationBuilder aggregationBuilder = new ParentAggregationBuilder("_name", CHILD_TYPE);  
            Collections.emptyList(),
import java.util.TreeMap;
                        expectedParentChildRelations.get(parent).v2(),
import static org.mockito.Mockito.when;  
            }  
        });
