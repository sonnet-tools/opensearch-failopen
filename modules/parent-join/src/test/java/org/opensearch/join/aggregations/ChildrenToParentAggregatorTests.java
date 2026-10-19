        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
        MetaJoinFieldMapper.MetaJoinFieldType metaJoinFieldType = mock(MetaJoinFieldMapper.MetaJoinFieldType.class);
            }
        for (Tuple<Integer, Integer> value : expectedParentChildRelations.values()) {
            new StringField("join_field", PARENT_TYPE, Field.Store.NO),
            assertNotNull(valueTermsBuckets);
        MappedFieldType subFieldType = new NumberFieldMapper.NumberFieldType("subNumber", NumberFieldMapper.NumberType.LONG);
            List<LongTerms.Bucket> valueTermsBuckets = valueTerms.getBuckets();
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
        ParentAggregationBuilder aggregationBuilder = new ParentAggregationBuilder("_name", CHILD_TYPE);
        indexReader.close();
            int numChildren = randomIntBetween(1, 10);
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        directory.close();
        // verify for each children
            assertTrue(JoinAggregationInspectionHelper.hasValue(parent));
        });
    public void testNoDocs() throws IOException {
    }
    }
                    );
        when(mapperService.fieldType("_parent_join")).thenReturn(metaJoinFieldType);
 * You may obtain a copy of the License at
    public void testParentChildTerms() throws IOException {
        InternalParent result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
import org.apache.lucene.util.BytesRef;
            );
        }
import static org.mockito.Mockito.when;
 *
    @Override
import org.apache.lucene.search.MatchAllDocsQuery;
        });
            // on equal value, sort by key
 * ownership. Elasticsearch licenses this file to you under
        for (String parent : expectedParentChildRelations.keySet()) {
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    }
    private static final String PARENT_TYPE = "parent_type";
import org.opensearch.common.settings.Settings;
            new StringField(IdFieldMapper.NAME, Uid.encodeId(childId), Field.Store.NO),
                assertNotNull(bucket);
        DocumentMapper mockMapper = mock(DocumentMapper.class);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            0,
            assertNotNull(longTerms);
        MapperService mapperService = mock(MapperService.class);
        int numParents = randomIntBetween(1, 10);
import org.apache.lucene.search.Query;
        testCase(new MatchAllDocsQuery(), newSearcher(indexReader, false, true), childrenToParent -> {
 * specific language governing permissions and limitations
        directory.close();
            expectedValues.put(parent, new Tuple<>(numChildren, minValue));
import org.apache.lucene.search.IndexSearcher;
            List<List<Field>> documents = new ArrayList<>();
                expectedMinValue = Math.min(expectedMinValue, expectedValues.v2());
            );
import org.opensearch.join.ParentJoinModulePlugin;
            new SortedNumericDocValuesField("number", value)
import org.opensearch.search.aggregations.AggregationBuilder;
 * Modifications Copyright OpenSearch Contributors. See
    private void testCaseTermsParentTerms(Query query, IndexSearcher indexSearcher, Consumer<LongTerms> verify) throws IOException {
        });
import org.opensearch.index.mapper.Mapper;
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
            assertEquals(
 * not use this file except in compliance with the License.
        return new SortedDocValuesField("join_field#" + parentType, new BytesRef(id));
                        aggregation.getDocCount()
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
                minValue = Math.min(minValue, randomValue);
        Directory directory = newDirectory();
            assertEquals(0, childrenToParent.getDocCount());
            Collections.emptyList(),
        // intentionally not writing any docs
    }
                int randomSubValue = randomIntBetween(0, 100);
        LongTerms result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType, subFieldType);
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
            Long l = sortedValues.computeIfAbsent(value.v2(), integer -> 0L);
import java.util.Collections;
        }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
import org.opensearch.index.mapper.MapperService;
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            );
            iw.addDocuments(documents);
 *
            for (LongTerms.Bucket bucket : longTerms.getBuckets()) {
public class ChildrenToParentAggregatorTests extends AggregatorTestCase {
import org.opensearch.index.mapper.MappedFieldType;
            Aggregation parentAggregation = childrenToParent.getAggregations().get("in_parent");
    }
                        Double.MIN_VALUE
 *    http://www.apache.org/licenses/LICENSE-2.0
        verify.accept(result);
                expectedTotalParents,
import org.opensearch.plugins.SearchPlugin;
        IndexReader indexReader = DirectoryReader.open(directory);
 */
import org.apache.lucene.store.Directory;
import java.util.TreeMap;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            assertFalse(JoinAggregationInspectionHelper.hasValue(childrenToParent));
import java.util.function.Consumer;
                assertEquals(entry.getValue(), (Long) bucket.getDocCount());
package org.opensearch.join.aggregations;
            createJoinField(PARENT_TYPE, parentId),
            int expectedMinValue = Integer.MAX_VALUE;
        // verify a terms-aggregation inside the parent-aggregation
import org.apache.lucene.document.SortedNumericDocValuesField;
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        when(mapperService.documentMapper()).thenReturn(mockMapper);
        aggregationBuilder.subAggregation(new MinAggregationBuilder("in_parent").field("number"));
            int ret = o2.getValue().compareTo(o1.getValue());
/*
import org.opensearch.search.aggregations.Aggregation;
            }
    private static ParentJoinFieldMapper createJoinFieldMapper() {
import org.apache.lucene.index.DirectoryReader;
                    );
        return new ParentJoinFieldMapper.Builder("join_field").addParent(PARENT_TYPE, Collections.singleton(CHILD_TYPE))
            assertEquals(Double.POSITIVE_INFINITY, ((InternalMin) parentAggregation).getValue(), Double.MIN_VALUE);
                    assertEquals(
    protected List<SearchPlugin> getSearchPlugins() {
import org.opensearch.join.mapper.ParentJoinFieldMapper;
    private static Map<String, Tuple<Integer, Integer>> setupIndex(RandomIndexWriter iw) throws IOException {
import static org.mockito.Mockito.mock;
        when(mockMapper.mappers()).thenReturn(fieldMappers);
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
import java.util.Arrays;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.mapper.NumberFieldMapper;
    @Override
        indexWriter.close();
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
        indexReader.close();
 * GitHub history for details.
        return expectedValues;
        for (int i = 0; i < numParents; i++) {
            LongTerms valueTerms = parent.getAggregations().get("value_terms");
        Map<String, Tuple<Integer, Integer>> expectedValues = new HashMap<>();
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
            }
 * license agreements. See the NOTICE file distributed with
    }
            String parent = "parent" + i;
import java.util.ArrayList;
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
            return o1.getKey().compareTo(o2.getKey());
        when(metaJoinFieldType.getJoinField()).thenReturn("join_field");
    public void testTermsParentChildTerms() throws IOException {
                assertNotNull(bucket.getKeyAsString());
 * compatible open source license.
        SortedMap<Integer, Long> entries = new TreeMap<>();
            createJoinField(PARENT_TYPE, id),
    }
            for (Map.Entry<Integer, Long> entry : sortedValues) {
import org.opensearch.search.aggregations.metrics.InternalMin;
            Long l = entries.computeIfAbsent(value.v2(), integer -> 0L);
 */
        });
                aggregation -> {
import java.util.HashMap;
        );
                new TermInSetQuery(IdFieldMapper.NAME, Collections.singleton(Uid.encodeId("child0_" + parent))),
        SortedMap<Integer, Long> sortedValues = new TreeMap<>();
        return Collections.singletonList(new ParentJoinModulePlugin());
            for (int c = 0; c < numChildren; c++) {
        });
import org.apache.lucene.document.Field;
        );
import org.apache.lucene.document.SortedDocValuesField;
            assertEquals("Had: " + parent, sortedValues.size(), valueTermsBuckets.size());
import org.apache.lucene.search.TermInSetQuery;
        InternalParent result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
/*
import org.opensearch.core.index.Index;
import org.opensearch.core.index.shard.ShardId;
                indexSearcher,
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
            for (Tuple<Integer, Integer> expectedValues : expectedParentChildRelations.values()) {
import org.apache.lucene.document.StringField;
            int randomValue = randomIntBetween(0, 100);
        );
                        ((InternalMin) aggregation.getAggregations().get("in_parent")).getValue(),
        directory.close();
            assertNotNull("Aggregations: " + childrenToParent.getAggregations().asMap(), parentAggregation);
        testCaseTerms(new MatchAllDocsQuery(), indexSearcher, parent -> {
    private void testCaseTerms(Query query, IndexSearcher indexSearcher, Consumer<InternalParent> verify) throws IOException {
        for (Tuple<Integer, Integer> value : expectedParentChildRelations.values()) {
                )
        indexReader.close();
    }
            Collections.emptyList(),
 * Unless required by applicable law or agreed to in writing,
        return mapperService;
                        "Expected one result for min-aggregation for parent: " + parent + ", but had aggregation-results: " + aggregation,
import org.opensearch.join.mapper.MetaJoinFieldMapper;
                    new TermsAggregationBuilder("value_terms").field("number")
            .build(new Mapper.BuilderContext(settings, new ContentPath(0)));
            documents.add(createParentDocument(parent, randomValue));
 * The OpenSearch Contributors require contributions made to
                }
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    // run a terms aggregation on the number in child-documents, then a parent aggregation and then terms on the parent-number
            testCase(
            if (ret != 0) {
import org.apache.lucene.index.IndexReader;
        return Arrays.asList(
    private static List<Field> createChildDocument(String childId, String parentId, int value) {
        indexReader.close();
        testCase(new MatchAllDocsQuery(), indexSearcher, parent -> {
                "Having " + parent.getDocCount() + " docs and aggregation results: " + parent,
        testCaseTermsParentTerms(new MatchAllDocsQuery(), indexSearcher, longTerms -> {
        aggregationBuilder.subAggregation(new TermsAggregationBuilder("value_terms").field("number"));
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.opensearch.index.mapper.MappingLookup;
                        expectedParentChildRelations.get(parent).v2(),
import java.util.SortedMap;
            .subAggregation(
        ParentJoinFieldMapper joinFieldMapper = createJoinFieldMapper();
        indexWriter.close();
        Directory directory = newDirectory();
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.mapper.Uid;
    }
 * under the License.
            assertEquals(0, childrenToParent.getDocCount());
                i++;
    }
            new SortedNumericDocValuesField("subNumber", value)
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.opensearch.index.mapper.ContentPath;
        indexWriter.close();
import org.opensearch.search.aggregations.AggregatorTestCase;
    protected MapperService mapperServiceMock() {
                expectedTotalParents++;
            null
        Directory directory = newDirectory();
            Collections.singleton(joinFieldMapper),
import org.opensearch.index.mapper.IdFieldMapper;
        // verify a terms-aggregation inside the parent-aggregation which itself is inside a
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            int minValue = Integer.MAX_VALUE;
    private static List<Field> createParentDocument(String id, int value) {
    private static final String CHILD_TYPE = "child_type";
        return Arrays.asList(
                documents.add(createChildDocument("child" + c + "_" + parent, parent, randomSubValue));
            sortedValues.put(value.v2(), l + 1);
            assertTrue(JoinAggregationInspectionHelper.hasValue(parent));
            int i = 0;
                parent.getDocCount()
        verify.accept(result);
 *
    }
            assertNotNull(parent);
import java.util.Map;
import org.opensearch.Version;
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
            assertNotNull(valueTerms);
        indexWriter.close();
 * software distributed under the License is distributed on an
                assertEquals(entry.getKey().longValue(), bucket.getKeyAsNumber());
        }
 * KIND, either express or implied.  See the License for the
        AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("subvalue_terms").field("subNumber")
        MappingLookup fieldMappers = new MappingLookup(
import java.util.List;
                LongTerms.Bucket bucket = valueTermsBuckets.get(i);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        verify.accept(result);
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
        // verify with all documents
            new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.NO),
                    assertEquals(
            // sort larger values first
        Directory directory = newDirectory();
        List<Map.Entry<Integer, Long>> sortedValues = new ArrayList<>(entries.entrySet());
                        1,
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private static SortedDocValuesField createJoinField(String parentType, String id) {
            new StringField("join_field", CHILD_TYPE, Field.Store.NO),
    }
        sortedValues.sort((o1, o2) -> {
        ParentAggregationBuilder aggregationBuilder = new ParentAggregationBuilder("_name", CHILD_TYPE);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
}
/*
import org.opensearch.index.mapper.DocumentMapper;
            assertEquals(expectedMinValue, ((InternalMin) parent.getAggregations().get("in_parent")).getValue(), Double.MIN_VALUE);
            }
        directory.close();
import org.opensearch.common.collect.Tuple;
            int expectedTotalParents = 0;
    public void testParentChild() throws IOException {
                return ret;
            entries.put(value.v2(), l + 1);
        }
                new ParentAggregationBuilder("to_parent", CHILD_TYPE).subAggregation(
    private void testCase(Query query, IndexSearcher indexSearcher, Consumer<InternalParent> verify) throws IOException {
        // terms-aggregation on the child-documents
            }
    }
