                AggregationBuilder request = new TermsAggregationBuilder("t").field("kwd")
import org.apache.lucene.document.SortedDocValuesField;
import org.opensearch.index.mapper.MappedFieldType;
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        ParentJoinFieldMapper joinFieldMapper = createJoinFieldMapper();
import org.opensearch.search.aggregations.AggregationBuilder;
                    if (Integer.valueOf(e.getKey().substring("parent".length())) % 2 == 0) {
import org.opensearch.join.mapper.MetaJoinFieldMapper;
/*
    }  
    }
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
import org.opensearch.join.ParentJoinModulePlugin;
                for (Map.Entry<String, Tuple<Integer, Integer>> e : expectedParentChildRelations.entrySet()) {
                    InternalMin oddMin = oddChildren.getAggregations().get("min");  
        return mapperService;
import org.apache.lucene.index.IndexReader;
                );
        DocumentMapper mockMapper = mock(DocumentMapper.class);
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
import java.io.IOException;  
            for (Tuple<Integer, Integer> expectedValues : expectedParentChildRelations.values()) {  
                StringTerms.Bucket evenBucket = result.getBucketByKey("even");  
                    new MatchAllDocsQuery(),  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
            indexWriter.close();
    public void testParentChild() throws IOException {
                long expectedOddChildCount = 0;
    private static List<Field> createChildDocument(String childId, String parentId, int value) {
import org.opensearch.common.collect.Tuple;
            expectedValues.put(parent, new Tuple<>(numChildren, minValue));
import static org.mockito.Mockito.mock;  
import static org.mockito.Mockito.when;
 * GitHub history for details.
        return expectedValues;
                long expectedEvenChildCount = 0;  
                    DirectoryReader.open(directory),
                }  
        Directory directory = newDirectory();  
import org.opensearch.search.aggregations.AggregatorTestCase;  
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
 *
import org.opensearch.index.mapper.MappingLookup;
    }
            new StringField(IdFieldMapper.NAME, Uid.encodeId(childId), Field.Store.NO),  
                        expectedEvenMin = Math.min(expectedEvenMin, e.getValue().v2());
        aggregationBuilder.subAggregation(new MinAggregationBuilder("in_child").field("number"));
                expectedTotalChildren += expectedValues.v1();
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.common.settings.Settings;
                } else {  
 * Unless required by applicable law or agreed to in writing,
            int numChildren = randomIntBetween(1, 10);
                    assertThat(oddChildren.getDocCount(), equalTo(expectedOddChildCount));
import org.apache.lucene.search.TermInSetQuery;
        });
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.equalTo;
                )
        }
                if (expectedOddChildCount > 0) {  
                int randomValue = randomIntBetween(0, 100);
 * Licensed to Elasticsearch under one or more contributor  
            new SortedSetDocValuesField("kwd", new BytesRef(kwd)),
    private static final String PARENT_TYPE = "parent_type";  
    protected MapperService mapperServiceMock() {  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                        expectedEvenChildCount += e.getValue().v1();  
                IndexReader indexReader = OpenSearchDirectoryReader.wrap(
                    keywordField("kwd")  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            createJoinField(PARENT_TYPE, id)  
                            new MinAggregationBuilder("min").field("number")
        }  
package org.opensearch.join.aggregations;
                    } else {
 * compatible open source license.
            .build(new Mapper.BuilderContext(settings, new ContentPath(0)));
        Map<String, Tuple<Integer, Integer>> expectedValues = new HashMap<>();
        testCase(new MatchAllDocsQuery(), indexSearcher, child -> {  
        Directory directory = newDirectory();
import java.util.function.Consumer;  
import org.opensearch.index.mapper.MapperService;  
            try (  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.mapper.IdFieldMapper;  
                        )  
            }
                minValue = Math.min(minValue, randomValue);
import org.apache.lucene.util.BytesRef;
        return Arrays.asList(
        );  
import java.util.Arrays;
                    indexSearcher,
 * license agreements. See the NOTICE file distributed with
            for (int c = 0; c < numChildren; c++) {  
            int minValue = Integer.MAX_VALUE;
                        expectedOddChildCount += e.getValue().v1();  
        int numParents = randomIntBetween(1, 10);  
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.join.mapper.ParentJoinFieldMapper;  
 * the Apache License, Version 2.0 (the "License"); you may
            0,
import java.util.Collections;
                        new ChildrenAggregationBuilder("children", CHILD_TYPE).subAggregation(
                    Double.MIN_VALUE  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        testCase(new MatchAllDocsQuery(), newSearcher(indexReader, false, true), parentToChild -> {
import org.opensearch.core.index.Index;
        // intentionally not writing any docs  
        return Collections.singletonList(new ParentJoinModulePlugin());
                IndexSearcher indexSearcher = newSearcher(indexReader, false, true);  
                Double.MIN_VALUE  
    @Override
    }
    }
/*  
 * The OpenSearch Contributors require contributions made to  
    }  
 * not use this file except in compliance with the License.
            }  
import org.apache.lucene.index.DirectoryReader;  
        MapperService mapperService = mock(MapperService.class);
                StringTerms result = searchAndReduce(
    private static ParentJoinFieldMapper createJoinFieldMapper() {
                    longField("number"),
    protected List<SearchPlugin> getSearchPlugins() {  
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
                    assertThat(oddMin.getValue(), equalTo(expectedOddMin));
        try (Directory directory = newDirectory()) {  
        MetaJoinFieldMapper.MetaJoinFieldType metaJoinFieldType = mock(MetaJoinFieldMapper.MetaJoinFieldType.class);  
import org.apache.lucene.document.Field;
            Collections.emptyList(),
                ((InternalMin) parentToChild.getAggregations().get("in_child")).getValue(),
        return new SortedDocValuesField("join_field#" + parentType, new BytesRef(id));
        when(metaJoinFieldType.getJoinField()).thenReturn("join_field");
            }  
import org.opensearch.cluster.metadata.IndexMetadata;
        }  
            assertTrue(JoinAggregationInspectionHelper.hasValue(child));
                assertEquals((long) expectedParentChildRelations.get(parent).v1(), child.getDocCount());
        for (String parent : expectedParentChildRelations.keySet()) {  
        indexReader.close();  
                        expectedOddMin = Math.min(expectedOddMin, e.getValue().v2());
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
                assertThat(evenMin.getValue(), equalTo(expectedEvenMin));
                    );
            new StringField("join_field", CHILD_TYPE, Field.Store.NO),
import org.opensearch.plugins.SearchPlugin;
    private static List<Field> createParentDocument(String id, String kwd) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < numParents; i++) {
/*  
            final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);  
            assertEquals(0L, parentToChild.getDocCount());
                    request,
 *
        InternalChildren result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
                    assertNull(result.getBucketByKey("odd"));
            testCase(new TermInSetQuery(IdFieldMapper.NAME, Collections.singleton(Uid.encodeId(parent))), indexSearcher, child -> {
import org.apache.lucene.search.Query;
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            Collections.emptyList(),  
import java.util.List;
            int expectedMinValue = Integer.MAX_VALUE;
    }
                double expectedOddMin = Double.MAX_VALUE;  
            new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.NO),  
 */  
        directory.close();
        );
 * SPDX-License-Identifier: Apache-2.0
                Double.POSITIVE_INFINITY,
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
            assertEquals(expectedMinValue, ((InternalMin) child.getAggregations().get("in_child")).getValue(), Double.MIN_VALUE);  
import org.apache.lucene.search.MatchAllDocsQuery;  
        IndexReader indexReader = DirectoryReader.open(directory);
        indexReader.close();
            createJoinField(PARENT_TYPE, parentId),
                    ((InternalMin) child.getAggregations().get("in_child")).getValue(),
                }
import org.opensearch.Version;  
            new StringField("join_field", PARENT_TYPE, Field.Store.NO),
public class ParentToChildrenAggregatorTests extends AggregatorTestCase {  
    private void testCase(Query query, IndexSearcher indexSearcher, Consumer<InternalChildren> verify) throws IOException {
            iw.addDocument(createParentDocument(parent, i % 2 == 0 ? "even" : "odd"));  
import org.opensearch.search.aggregations.metrics.InternalMin;  
import org.opensearch.index.mapper.NumberFieldMapper;
                    }
                assertEquals(  
            new SortedNumericDocValuesField("number", value)  
        when(mockMapper.mappers()).thenReturn(fieldMappers);
import org.apache.lucene.document.StringField;
            assertEquals(expectedTotalChildren, child.getDocCount());
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved  
            ) {
}  
        verify.accept(result);
        return Arrays.asList(
 * this work for additional information regarding copyright
    public void testParentChildAsSubAgg() throws IOException {
import org.opensearch.index.mapper.Uid;  
            null
            assertEquals(  
import org.apache.lucene.document.SortedSetDocValuesField;
    }
        ChildrenAggregationBuilder aggregationBuilder = new ChildrenAggregationBuilder("_name", CHILD_TYPE);  
 * under the License.  
                    expectedParentChildRelations.get(parent).v2(),
                iw.addDocument(createChildDocument("child" + c + "_" + parent, parent, randomValue));  
import org.opensearch.index.mapper.ContentPath;
                assertThat(evenChildren.getDocCount(), equalTo(expectedEvenChildCount));  
    @Override
import org.opensearch.index.mapper.Mapper;
                    .subAggregation(  
            Collections.singleton(joinFieldMapper),
import java.util.Map;
    private static final String CHILD_TYPE = "child_type";
                    InternalChildren oddChildren = oddBucket.getAggregations().get("children");
                expectedMinValue = Math.min(expectedMinValue, expectedValues.v2());
        when(mapperService.fieldType("_parent_join")).thenReturn(metaJoinFieldType);
        when(mapperService.documentMapper()).thenReturn(mockMapper);  
import org.opensearch.index.mapper.DocumentMapper;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.tests.index.RandomIndexWriter;
 */
    private static SortedDocValuesField createJoinField(String parentType, String id) {
                    StringTerms.Bucket oddBucket = result.getBucketByKey("odd");
    private static Map<String, Tuple<Integer, Integer>> setupIndex(RandomIndexWriter iw) throws IOException {
    public void testNoDocs() throws IOException {
        MappingLookup fieldMappers = new MappingLookup(  
        directory.close();
import org.apache.lucene.store.Directory;  
        indexWriter.close();  
        });
                    new ShardId(new Index("foo", "_na_"), 1)  
                double expectedEvenMin = Double.MAX_VALUE;
            int expectedTotalChildren = 0;
 * KIND, either express or implied.  See the License for the
    }  
            });
 */  
import org.apache.lucene.document.SortedNumericDocValuesField;  
            );
                );
            String parent = "parent" + i;
        return new ParentJoinFieldMapper.Builder("join_field").addParent(PARENT_TYPE, Collections.singleton(CHILD_TYPE))  
    }
 * You may obtain a copy of the License at  
    }
import java.util.HashMap;  
                InternalChildren evenChildren = evenBucket.getAggregations().get("children");
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
                InternalMin evenMin = evenChildren.getAggregations().get("min");
 *  
        indexWriter.close();
