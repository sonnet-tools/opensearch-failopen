                    Document document = new Document();  
import org.apache.lucene.document.SortedNumericDocValuesField;  
/*  
                        documents.add(document);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        int numParentDocs = randomIntBetween(1, 20);
import org.opensearch.search.aggregations.metrics.InternalMax;
                assertEquals(expectedNestedDocs, nested.getDocCount());  
                assertEquals(0, reverseNested.getDocCount());  
    }  
        int numProducts = scaledRandomIntBetween(1, 100);  
 * license agreements. See the NOTICE file distributed with
                LongTerms.Bucket bucket = resellers.getBucketByKey(Integer.toString(r));  
                InternalMax max = (InternalMax) ((InternalAggregation) reverseNested).getProperty(MAX_AGG_NAME);  
                        expectedParentDocs++;
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
import static org.opensearch.search.aggregations.AggregationBuilders.reverseNested;
 *  
                    document.add(new SortedNumericDocValuesField(VALUE_FIELD_NAME, value));
     * Nested aggregations need the {@linkplain DirectoryReader} wrapped.
                        new TermsAggregationBuilder("products").field("product_id").size(numProducts)
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
            assertThat(
    }
            );
                InternalReverseNested reverseNested = bucket.getAggregations().get("reverse_nested");
                ReverseNested reverseNested = (ReverseNested) ((InternalAggregation) nested).getProperty(REVERSE_AGG_NAME);
import org.apache.lucene.index.IndexReader;
            }
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                    long value = randomNonNegativeLong() % 10000;  
                for (int i = 0; i < numParentDocs; i++) {  
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
import org.opensearch.search.aggregations.AggregatorTestCase;
                    documents.add(document);
 * ownership. Elasticsearch licenses this file to you under  
        }
                MaxAggregationBuilder aliasMaxAgg = max(MAX_AGG_NAME).field(VALUE_FIELD_NAME + "-alias");
        try (Directory directory = newDirectory()) {  
                assertEquals(MAX_AGG_NAME, max.getName());  
                // intentionally not writing any docs
        int expectedParentDocs = 0;
import org.apache.lucene.tests.index.RandomIndexWriter;
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
                Nested aliasNested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), aliasAgg, fieldType);  
                }
                reverseNestedBuilder.subAggregation(maxAgg);  
                    new ReverseNestedAggregationBuilder("reverse_nested").subAggregation(
                    reverseNested(REVERSE_AGG_NAME).subAggregation(aliasMaxAgg)
                nestedBuilder.subAggregation(reverseNestedBuilder);  
                .subAggregation(  
                    iw.addDocuments(documents);
import static java.util.stream.Collectors.toList;
import org.apache.lucene.search.MatchAllDocsQuery;  
                    iw.addDocuments(documents);
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
public class ReverseNestedAggregatorTests extends AggregatorTestCase {
import org.opensearch.index.mapper.MappedFieldType;
 * the Apache License, Version 2.0 (the "License"); you may
                    }  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;  
            }  
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));  
import org.opensearch.index.mapper.SeqNoFieldMapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.util.function.Function;
                        Document document = new Document();
                    List<Document> documents = new ArrayList<>();
                    }
                reverseNestedBuilder.subAggregation(maxAgg);
                    if (numNestedDocs > 0) {  
                .size(numResellers)
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.document.Document;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                        document.add(  
 */
        testCase(b, new MatchAllDocsQuery(), NestedAggregatorTests.buildResellerData(numProducts, numResellers), result -> {  
                    int numNestedDocs = randomIntBetween(0, 20);
                InternalMax max = (InternalMax) ((InternalAggregation) reverseNested).getProperty(MAX_AGG_NAME);
 * not use this file except in compliance with the License.
/*  
package org.opensearch.search.aggregations.bucket.nested;
 *
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
            }
            InternalNested nested = (InternalNested) result;
    public void testFieldAlias() throws IOException {
    /**  
 * Licensed to Elasticsearch under one or more contributor  
                    reverseNested(REVERSE_AGG_NAME).subAggregation(maxAgg)
import java.io.IOException;
     */  
    @Override  
                ReverseNested reverseNested = (ReverseNested) ((InternalAggregation) nested).getProperty(REVERSE_AGG_NAME);
                MaxAggregationBuilder maxAgg = max(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
                    document.add(new SortedNumericDocValuesField(VALUE_FIELD_NAME, value));
                assertEquals(MAX_AGG_NAME, max.getName());
                NestedAggregationBuilder agg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(
                    List<Document> documents = new ArrayList<>();
                LongTerms products = reverseNested.getAggregations().get("products");
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            }  
                Nested nested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), agg, fieldType);
                );
    private static final String VALUE_FIELD_NAME = "number";
                    for (int nested = 0; nested < numNestedDocs; nested++) {
                            new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE)
                assertEquals(expectedMaxValue, max.getValue(), Double.MIN_VALUE);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
import org.apache.lucene.index.DirectoryReader;
 */  
     */
    }
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {  
        int numParentDocs = randomIntBetween(1, 20);
import org.opensearch.index.mapper.IdFieldMapper;  
        try (Directory directory = newDirectory()) {
                assertEquals(expectedParentDocs, reverseNested.getDocCount());  
                assertThat(
 * under the License.  
            }
    /**
                Nested nested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), nestedBuilder, fieldType);
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
import java.util.Map;  
 * compatible open source license.
    }
                    long value = randomNonNegativeLong() % 10000;  
            LongTerms resellers = nested.getAggregations().get("resellers");  
                    Document document = new Document();
                }  
                    for (int nested = 0; nested < numNestedDocs; nested++) {
        try (Directory directory = newDirectory()) {
                )
                assertEquals(reverseNested, aliasReverseNested);
                        );
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
 * SPDX-License-Identifier: Apache-2.0
                ReverseNestedAggregationBuilder reverseNestedBuilder = new ReverseNestedAggregationBuilder(REVERSE_AGG_NAME);  
    }  
import java.util.List;
                assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), Double.MIN_VALUE);
        AggregationBuilder b = new NestedAggregationBuilder("nested", "nested_reseller").subAggregation(  
            }  
    public void testMaxFromParentDocs() throws IOException {  
                        );
 * You may obtain a copy of the License at  
                        expectedMaxValue = Math.max(expectedMaxValue, value);
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
 */  
                assertEquals(expectedParentDocs, reverseNested.getDocCount());
    private static final String MAX_AGG_NAME = "maxAgg";
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
                Nested nested = searchAndReduce(newSearcher(indexReader, false, true), new MatchAllDocsQuery(), nestedBuilder, fieldType);  
        return wrapInMockESDirectoryReader(reader);
                            new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE)
    private static final String REVERSE_AGG_NAME = "reverseNestedAgg";
        }  
import org.opensearch.index.mapper.NumberFieldMapper;  
    public void testNestedUnderTerms() throws IOException {
                    )  
 * KIND, either express or implied.  See the License for the
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);  
    protected IndexReader wrapDirectoryReader(DirectoryReader reader) throws IOException {
                    int numNestedDocs = randomIntBetween(0, 20);  
                iw.commit();  
                ReverseNested aliasReverseNested = aliasNested.getAggregations().get(REVERSE_AGG_NAME);  
import org.apache.lucene.store.Directory;
            new TermsAggregationBuilder("resellers").field("reseller_id")
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
                        document.add(new Field(NestedPathFieldMapper.NAME, NESTED_OBJECT, NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                ReverseNested reverseNested = nested.getAggregations().get(REVERSE_AGG_NAME);
                        expectedNestedDocs++;
                assertThat(bucket.getDocCount(), equalTo((long) numProducts));
import org.apache.lucene.document.Field;
                    document.add(SeqNoFieldMapper.SequenceIDFields.emptySeqID().primaryTerm);
                assertEquals(REVERSE_AGG_NAME, reverseNested.getName());
import org.opensearch.search.aggregations.AggregationBuilder;  
                resellers.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),
                    products.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),  
                        expectedParentDocs++;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        int expectedNestedDocs = 0;  
}
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
import java.util.Arrays;
                    }
                        document.add(new Field(NestedPathFieldMapper.NAME, NESTED_OBJECT, NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                );  
                        documents.add(document);
import org.opensearch.index.mapper.Uid;
import org.opensearch.search.aggregations.InternalAggregation;
                equalTo(LongStream.range(0, numResellers).mapToObj(Long::valueOf).collect(toList()))  
 *
        }, NestedAggregatorTests.resellersMappedFields());
                    }  
                        document.add(  
        int expectedParentDocs = 0;  
                    document.add(SeqNoFieldMapper.SequenceIDFields.emptySeqID().primaryTerm);
                for (int i = 0; i < numParentDocs; i++) {
                iw.commit();
    public void testNoDocs() throws IOException {
                NestedAggregationBuilder aliasAgg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(
                    equalTo(LongStream.range(0, numProducts).mapToObj(Long::valueOf).collect(toList()))
/*
                assertThat(reverseNested.getDocCount(), equalTo((long) numProducts));  
                ReverseNestedAggregationBuilder reverseNestedBuilder = new ReverseNestedAggregationBuilder(REVERSE_AGG_NAME);
    private static final String NESTED_AGG = "nestedAgg";  
            for (int r = 0; r < numResellers; r++) {
        );
    private static final String NESTED_OBJECT = "nested_object";
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
                nestedBuilder.subAggregation(reverseNestedBuilder);
import java.util.ArrayList;  
                assertEquals(REVERSE_AGG_NAME, reverseNested.getName());  
 * GitHub history for details.
                    if (numNestedDocs > 0) {  
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
        int numResellers = scaledRandomIntBetween(1, 100);
 * Modifications Copyright OpenSearch Contributors. See
                );  
            assertThat(nested.getDocCount(), equalTo((long) numProducts * numResellers));
                    documents.add(document);  
import java.util.stream.LongStream;  
import static org.hamcrest.Matchers.equalTo;  
import java.util.stream.Collectors;
            }
        }
                        Document document = new Document();
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.NestedPathFieldMapper;
