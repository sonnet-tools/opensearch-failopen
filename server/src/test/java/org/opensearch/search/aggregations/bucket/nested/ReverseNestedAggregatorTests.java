                assertEquals(MAX_AGG_NAME, max.getName());
                    document.add(new SortedNumericDocValuesField(VALUE_FIELD_NAME, value));
                        document.add(new Field(NestedPathFieldMapper.NAME, NESTED_OBJECT, NestedPathFieldMapper.Defaults.FIELD_TYPE));
                reverseNestedBuilder.subAggregation(maxAgg);
import static org.opensearch.search.aggregations.AggregationBuilders.max;
 * You may obtain a copy of the License at
                ReverseNested reverseNested = (ReverseNested) ((InternalAggregation) nested).getProperty(REVERSE_AGG_NAME);
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(expectedNestedDocs, nested.getDocCount());
                    document.add(new SortedNumericDocValuesField(VALUE_FIELD_NAME, value));
        return wrapInMockESDirectoryReader(reader);
 *
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.search.MatchAllDocsQuery;
 * license agreements. See the NOTICE file distributed with
    }
     */
                            new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE)
 * Modifications Copyright OpenSearch Contributors. See
            InternalNested nested = (InternalNested) result;
import java.util.function.Function;
                LongTerms.Bucket bucket = resellers.getBucketByKey(Integer.toString(r));
import static java.util.stream.Collectors.toList;
    }
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
                    products.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),
                ReverseNested aliasReverseNested = aliasNested.getAggregations().get(REVERSE_AGG_NAME);
 * the Apache License, Version 2.0 (the "License"); you may
                    document.add(SeqNoFieldMapper.SequenceIDFields.emptySeqID().primaryTerm);
                    iw.addDocuments(documents);
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
    /**
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
                        document.add(
 * GitHub history for details.
import java.util.ArrayList;
            LongTerms resellers = nested.getAggregations().get("resellers");
public class ReverseNestedAggregatorTests extends AggregatorTestCase {
                // intentionally not writing any docs
import org.opensearch.search.aggregations.AggregationBuilder;
import java.util.stream.LongStream;
        AggregationBuilder b = new NestedAggregationBuilder("nested", "nested_reseller").subAggregation(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
        }
 *
                Nested nested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), agg, fieldType);
import org.apache.lucene.document.SortedNumericDocValuesField;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertEquals(REVERSE_AGG_NAME, reverseNested.getName());
                assertEquals(expectedParentDocs, reverseNested.getDocCount());
    }
import org.apache.lucene.index.DirectoryReader;
                        );
                    }
                    List<Document> documents = new ArrayList<>();
        testCase(b, new MatchAllDocsQuery(), NestedAggregatorTests.buildResellerData(numProducts, numResellers), result -> {
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
     * Nested aggregations need the {@linkplain DirectoryReader} wrapped.
}
                    iw.addDocuments(documents);
                        expectedNestedDocs++;
                    if (numNestedDocs > 0) {
    public void testMaxFromParentDocs() throws IOException {
import org.opensearch.index.mapper.NestedPathFieldMapper;
                .size(numResellers)
                nestedBuilder.subAggregation(reverseNestedBuilder);
            }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
 * not use this file except in compliance with the License.
                    )
                assertEquals(REVERSE_AGG_NAME, reverseNested.getName());
                assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), Double.MIN_VALUE);
import org.opensearch.index.mapper.IdFieldMapper;
                    reverseNested(REVERSE_AGG_NAME).subAggregation(maxAgg)
                ReverseNested reverseNested = nested.getAggregations().get(REVERSE_AGG_NAME);
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
                    documents.add(document);
 * specific language governing permissions and limitations
import org.opensearch.index.mapper.Uid;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                        expectedParentDocs++;
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
                InternalMax max = (InternalMax) ((InternalAggregation) reverseNested).getProperty(MAX_AGG_NAME);
                        documents.add(document);
                assertThat(bucket.getDocCount(), equalTo((long) numProducts));
                assertEquals(MAX_AGG_NAME, max.getName());
        try (Directory directory = newDirectory()) {
import java.util.Arrays;
    @Override
                    int numNestedDocs = randomIntBetween(0, 20);
 * this file be licensed under the Apache-2.0 license or a
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
                reverseNestedBuilder.subAggregation(maxAgg);
                InternalReverseNested reverseNested = bucket.getAggregations().get("reverse_nested");
                            new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE)
            }
            }
                NestedAggregationBuilder agg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
import static org.opensearch.search.aggregations.AggregationBuilders.reverseNested;
        int expectedParentDocs = 0;
                    }
    private static final String MAX_AGG_NAME = "maxAgg";
                }
 * compatible open source license.
                        new TermsAggregationBuilder("products").field("product_id").size(numProducts)
    private static final String REVERSE_AGG_NAME = "reverseNestedAgg";
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
                        Document document = new Document();
                );
    @Override
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.store.Directory;
    public void testFieldAlias() throws IOException {
                    reverseNested(REVERSE_AGG_NAME).subAggregation(aliasMaxAgg)
            }
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.List;
import java.util.Map;
                    long value = randomNonNegativeLong() % 10000;
            }
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
    public void testNoDocs() throws IOException {
        int numParentDocs = randomIntBetween(1, 20);
        int numProducts = scaledRandomIntBetween(1, 100);
                }
 */
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
                        Document document = new Document();
                    new ReverseNestedAggregationBuilder("reverse_nested").subAggregation(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
 * SPDX-License-Identifier: Apache-2.0
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
import org.opensearch.search.aggregations.AggregatorTestCase;
                NestedAggregationBuilder aliasAgg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(
                LongTerms products = reverseNested.getAggregations().get("products");
 * Unless required by applicable law or agreed to in writing,
        try (Directory directory = newDirectory()) {
package org.opensearch.search.aggregations.bucket.nested;
                nestedBuilder.subAggregation(reverseNestedBuilder);
                    }
        int numResellers = scaledRandomIntBetween(1, 100);
    protected IndexReader wrapDirectoryReader(DirectoryReader reader) throws IOException {
        int expectedNestedDocs = 0;
                assertEquals(expectedParentDocs, reverseNested.getDocCount());
                    Document document = new Document();
        try (Directory directory = newDirectory()) {
    }
    }
                );
                    }
                assertThat(reverseNested.getDocCount(), equalTo((long) numProducts));
import org.opensearch.index.mapper.MappedFieldType;
                    document.add(SeqNoFieldMapper.SequenceIDFields.emptySeqID().primaryTerm);
    private static final String VALUE_FIELD_NAME = "number";
 * under the License.
                        expectedParentDocs++;
import org.apache.lucene.document.Field;
                    documents.add(document);
                    Document document = new Document();
                for (int i = 0; i < numParentDocs; i++) {
                MaxAggregationBuilder aliasMaxAgg = max(MAX_AGG_NAME).field(VALUE_FIELD_NAME + "-alias");
        }
                    equalTo(LongStream.range(0, numProducts).mapToObj(Long::valueOf).collect(toList()))
        }
import org.opensearch.index.mapper.SeqNoFieldMapper;
                        documents.add(document);
                MaxAggregationBuilder maxAgg = max(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
                for (int i = 0; i < numParentDocs; i++) {
    public void testNestedUnderTerms() throws IOException {
                equalTo(LongStream.range(0, numResellers).mapToObj(Long::valueOf).collect(toList()))
                iw.commit();
    }
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                InternalMax max = (InternalMax) ((InternalAggregation) reverseNested).getProperty(MAX_AGG_NAME);
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
            assertThat(
                ReverseNestedAggregationBuilder reverseNestedBuilder = new ReverseNestedAggregationBuilder(REVERSE_AGG_NAME);
import java.util.stream.Collectors;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                Nested aliasNested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), aliasAgg, fieldType);
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
                        document.add(new Field(NestedPathFieldMapper.NAME, NESTED_OBJECT, NestedPathFieldMapper.Defaults.FIELD_TYPE));
            }
 */
import org.opensearch.index.mapper.NumberFieldMapper;
    private static final String NESTED_OBJECT = "nested_object";
/*
                    int numNestedDocs = randomIntBetween(0, 20);
    private static final String NESTED_AGG = "nestedAgg";
                        document.add(
                    long value = randomNonNegativeLong() % 10000;
 */
                ReverseNestedAggregationBuilder reverseNestedBuilder = new ReverseNestedAggregationBuilder(REVERSE_AGG_NAME);
                assertEquals(0, reverseNested.getDocCount());
            new TermsAggregationBuilder("resellers").field("reseller_id")
                )
                assertThat(
                assertEquals(reverseNested, aliasReverseNested);
                ReverseNested reverseNested = (ReverseNested) ((InternalAggregation) nested).getProperty(REVERSE_AGG_NAME);
            }
import java.io.IOException;
        }, NestedAggregatorTests.resellersMappedFields());
        int expectedParentDocs = 0;
                    if (numNestedDocs > 0) {
                        expectedMaxValue = Math.max(expectedMaxValue, value);
import org.apache.lucene.index.IndexReader;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.metrics.InternalMax;
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                Nested nested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), nestedBuilder, fieldType);
                Nested nested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), nestedBuilder, fieldType);
                        );
    /**
                    for (int nested = 0; nested < numNestedDocs; nested++) {
import org.apache.lucene.document.Document;
                iw.commit();
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                resellers.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),
/*
 *
        int numParentDocs = randomIntBetween(1, 20);
            assertThat(nested.getDocCount(), equalTo((long) numProducts * numResellers));
                );
                .subAggregation(
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));
            for (int r = 0; r < numResellers; r++) {
            );
                    List<Document> documents = new ArrayList<>();
                assertEquals(expectedMaxValue, max.getValue(), Double.MIN_VALUE);
                    for (int nested = 0; nested < numNestedDocs; nested++) {
     */
        );
/*
