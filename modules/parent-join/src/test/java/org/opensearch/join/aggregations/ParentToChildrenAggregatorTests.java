import org.apache.lucene.index.IndexReader;
            createJoinField(PARENT_TYPE, parentId),
            new SortedNumericDocValuesField("number", value)
        }
                StringTerms.Bucket evenBucket = result.getBucketByKey("even");
        // intentionally not writing any docs
        indexWriter.close();
        testCase(new MatchAllDocsQuery(), indexSearcher, child -> {
    @Override
 */
            Collections.emptyList(),
import org.apache.lucene.search.TermInSetQuery;
            final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            });
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.metrics.InternalMin;
            assertTrue(JoinAggregationInspectionHelper.hasValue(child));
import org.opensearch.join.mapper.MetaJoinFieldMapper;
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        DocumentMapper mockMapper = mock(DocumentMapper.class);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.tests.index.RandomIndexWriter;
    private static ParentJoinFieldMapper createJoinFieldMapper() {
            expectedValues.put(parent, new Tuple<>(numChildren, minValue));
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.SortedDocValuesField;
 * KIND, either express or implied.  See the License for the
                double expectedEvenMin = Double.MAX_VALUE;
import org.opensearch.index.mapper.DocumentMapper;
        when(mapperService.documentMapper()).thenReturn(mockMapper);
import org.opensearch.core.index.shard.ShardId;
                            new MinAggregationBuilder("min").field("number")
            }
        return new SortedDocValuesField("join_field#" + parentType, new BytesRef(id));
        return Collections.singletonList(new ParentJoinModulePlugin());
    private static SortedDocValuesField createJoinField(String parentType, String id) {
                StringTerms result = searchAndReduce(
                    InternalMin oddMin = oddChildren.getAggregations().get("min");
    }
            new StringField("join_field", PARENT_TYPE, Field.Store.NO),
                } else {
import org.opensearch.index.mapper.Mapper;
import java.util.List;
        ChildrenAggregationBuilder aggregationBuilder = new ChildrenAggregationBuilder("_name", CHILD_TYPE);
 * Licensed to Elasticsearch under one or more contributor
        when(mockMapper.mappers()).thenReturn(fieldMappers);
public class ParentToChildrenAggregatorTests extends AggregatorTestCase {
import org.opensearch.index.mapper.NumberFieldMapper;
                    StringTerms.Bucket oddBucket = result.getBucketByKey("odd");
                    .subAggregation(
import java.io.IOException;
            int minValue = Integer.MAX_VALUE;
import org.apache.lucene.document.SortedSetDocValuesField;
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import java.util.HashMap;
 *
import org.apache.lucene.index.DirectoryReader;
        return mapperService;
    private static final String PARENT_TYPE = "parent_type";
        return Arrays.asList(
    }
        InternalChildren result = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
        int numParents = randomIntBetween(1, 10);
            new StringField(IdFieldMapper.NAME, Uid.encodeId(childId), Field.Store.NO),
                InternalMin evenMin = evenChildren.getAggregations().get("min");
 * specific language governing permissions and limitations
                iw.addDocument(createChildDocument("child" + c + "_" + parent, parent, randomValue));
            iw.addDocument(createParentDocument(parent, i % 2 == 0 ? "even" : "odd"));
 * GitHub history for details.
            assertEquals(0L, parentToChild.getDocCount());
import org.opensearch.Version;
        // TODO set "maybeWrap" to true for IndexSearcher once #23338 is resolved
                ((InternalMin) parentToChild.getAggregations().get("in_child")).getValue(),
import java.util.Collections;
            0,
                    keywordField("kwd")
}
import org.opensearch.index.mapper.Uid;
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        final Map<String, Tuple<Integer, Integer>> expectedParentChildRelations = setupIndex(indexWriter);
            .build(new Mapper.BuilderContext(settings, new ContentPath(0)));
            assertEquals(expectedMinValue, ((InternalMin) child.getAggregations().get("in_child")).getValue(), Double.MIN_VALUE);
 * license agreements. See the NOTICE file distributed with
                    indexSearcher,
            String parent = "parent" + i;
        }
            int expectedTotalChildren = 0;
                    longField("number"),
        directory.close();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    protected List<SearchPlugin> getSearchPlugins() {
                minValue = Math.min(minValue, randomValue);
    protected MapperService mapperServiceMock() {
                AggregationBuilder request = new TermsAggregationBuilder("t").field("kwd")
            for (int c = 0; c < numChildren; c++) {
/*
                for (Map.Entry<String, Tuple<Integer, Integer>> e : expectedParentChildRelations.entrySet()) {
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.MatchAllDocsQuery;
 */
        MetaJoinFieldMapper.MetaJoinFieldType metaJoinFieldType = mock(MetaJoinFieldMapper.MetaJoinFieldType.class);
        try (Directory directory = newDirectory()) {
import org.opensearch.common.collect.Tuple;
                )
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            testCase(new TermInSetQuery(IdFieldMapper.NAME, Collections.singleton(Uid.encodeId(parent))), indexSearcher, child -> {
import org.opensearch.index.mapper.MappingLookup;
        );
        );
                    } else {
        ParentJoinFieldMapper joinFieldMapper = createJoinFieldMapper();
            indexWriter.close();
            int numChildren = randomIntBetween(1, 10);
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
        );
                    ((InternalMin) child.getAggregations().get("in_child")).getValue(),
import org.opensearch.index.mapper.MapperService;
                IndexReader indexReader = OpenSearchDirectoryReader.wrap(
            for (Tuple<Integer, Integer> expectedValues : expectedParentChildRelations.values()) {
    }
        Directory directory = newDirectory();
import org.opensearch.index.mapper.ContentPath;
        Map<String, Tuple<Integer, Integer>> expectedValues = new HashMap<>();
 * this work for additional information regarding copyright
        MappingLookup fieldMappers = new MappingLookup(
        indexWriter.close();
    }
import static org.mockito.Mockito.mock;
import org.opensearch.core.index.Index;
                if (expectedOddChildCount > 0) {
        return expectedValues;
                    assertNull(result.getBucketByKey("odd"));
        IndexReader indexReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(directory), new ShardId(new Index("foo", "_na_"), 1));
            Collections.singleton(joinFieldMapper),
                IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
                        expectedEvenMin = Math.min(expectedEvenMin, e.getValue().v2());
                assertEquals((long) expectedParentChildRelations.get(parent).v1(), child.getDocCount());
/*
    private static Map<String, Tuple<Integer, Integer>> setupIndex(RandomIndexWriter iw) throws IOException {
                    if (Integer.valueOf(e.getKey().substring("parent".length())) % 2 == 0) {
            );
                    }
                    );
            assertEquals(expectedTotalChildren, child.getDocCount());
        indexReader.close();
 *
            new SortedSetDocValuesField("kwd", new BytesRef(kwd)),
    }
import java.util.Map;
        for (int i = 0; i < numParents; i++) {
        IndexReader indexReader = DirectoryReader.open(directory);
import org.opensearch.search.aggregations.AggregatorTestCase;
                expectedTotalChildren += expectedValues.v1();
    }
                assertEquals(
 * ownership. Elasticsearch licenses this file to you under
                        )
/*
package org.opensearch.join.aggregations;
                assertThat(evenChildren.getDocCount(), equalTo(expectedEvenChildCount));
import org.opensearch.plugins.SearchPlugin;
import org.opensearch.search.aggregations.AggregationBuilder;
        });
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.IndexSearcher;
                );
                expectedMinValue = Math.min(expectedMinValue, expectedValues.v2());
            createJoinField(PARENT_TYPE, id)
            int expectedMinValue = Integer.MAX_VALUE;
                int randomValue = randomIntBetween(0, 100);
import org.apache.lucene.store.Directory;
    }
                    InternalChildren oddChildren = oddBucket.getAggregations().get("children");
import java.util.Arrays;
import org.apache.lucene.util.BytesRef;
        testCase(new MatchAllDocsQuery(), newSearcher(indexReader, false, true), parentToChild -> {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
import static org.mockito.Mockito.when;
            null
import org.opensearch.join.ParentJoinModulePlugin;
    }
            new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.NO),
                        expectedOddChildCount += e.getValue().v1();
 * You may obtain a copy of the License at
    private void testCase(Query query, IndexSearcher indexSearcher, Consumer<InternalChildren> verify) throws IOException {
        verify.accept(result);
            try (
import org.opensearch.join.mapper.ParentJoinFieldMapper;
            }
    public void testNoDocs() throws IOException {
import org.opensearch.index.mapper.IdFieldMapper;
        indexReader.close();
                    assertThat(oddChildren.getDocCount(), equalTo(expectedOddChildCount));
        IndexSearcher indexSearcher = newSearcher(indexReader, false, true);
            }
                }
                assertThat(evenMin.getValue(), equalTo(expectedEvenMin));
                    expectedParentChildRelations.get(parent).v2(),
 */
                    DirectoryReader.open(directory),
        Directory directory = newDirectory();
        directory.close();
import org.apache.lucene.document.Field;
        when(metaJoinFieldType.getJoinField()).thenReturn("join_field");
        aggregationBuilder.subAggregation(new MinAggregationBuilder("in_child").field("number"));
 * compatible open source license.
                        new ChildrenAggregationBuilder("children", CHILD_TYPE).subAggregation(
                }
    }
        MapperService mapperService = mock(MapperService.class);
                double expectedOddMin = Double.MAX_VALUE;
                Double.MIN_VALUE
    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
    private static List<Field> createParentDocument(String id, String kwd) {
                    new ShardId(new Index("foo", "_na_"), 1)
                        expectedOddMin = Math.min(expectedOddMin, e.getValue().v2());
            assertEquals(
                    new MatchAllDocsQuery(),
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.document.StringField;
                    request,
    }
                    assertThat(oddMin.getValue(), equalTo(expectedOddMin));
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Consumer;
            ) {
        for (String parent : expectedParentChildRelations.keySet()) {
    private static final String CHILD_TYPE = "child_type";
                InternalChildren evenChildren = evenBucket.getAggregations().get("children");
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.apache.lucene.search.Query;
                long expectedOddChildCount = 0;
    public void testParentChildAsSubAgg() throws IOException {
    private static List<Field> createChildDocument(String childId, String parentId, int value) {
            new StringField("join_field", CHILD_TYPE, Field.Store.NO),
        return new ParentJoinFieldMapper.Builder("join_field").addParent(PARENT_TYPE, Collections.singleton(CHILD_TYPE))
import org.opensearch.index.mapper.MappedFieldType;
                        expectedEvenChildCount += e.getValue().v1();
        });
        return Arrays.asList(
        when(mapperService.fieldType("_parent_join")).thenReturn(metaJoinFieldType);
                long expectedEvenChildCount = 0;
            Collections.emptyList(),
    public void testParentChild() throws IOException {
                    Double.MIN_VALUE
                Double.POSITIVE_INFINITY,
                );
 * under the License.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
