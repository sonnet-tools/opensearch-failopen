import org.apache.lucene.store.Directory;
            assertEquals(9, agg.getBuckets().size());
    public void testMatchNoDocs() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
            equalTo(
import org.opensearch.search.DocValueFormat;
    private void testSearchCase(
        // Make sure the include/exclude fails regardless of how the user tries to type hint the agg
import org.apache.lucene.search.Query;  
            IllegalArgumentException.class,
 * this file be licensed under the Apache-2.0 license or a
    private static final List<Long> dataset;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.mapper.BinaryFieldMapper;
            for (int i = 0; i < 9; i++) {  
                    + "they can only be applied to string fields. Use an array of values for include/exclude clauses"
                MappedFieldType binaryFieldType = new BinaryFieldMapper.BinaryFieldType(BINARY_FIELD);  
 *
    ) throws IOException {
 * specific language governing permissions and limitations
                d.add((long) i);  
 * The OpenSearch Contributors require contributions made to  
            }
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations.bucket.terms;
                "Aggregation [_name] cannot support regular expression style include/exclude settings as "  
                assertThat(bucket.getKey(), equalTo(bytesAsString));
/*
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            e.getMessage(),
 * license agreements. See the NOTICE file distributed with
                if (configure != null) {
                for (Long value : dataset) {  
import org.opensearch.search.aggregations.AggregatorTestCase;  
            }
        Query query = new MatchAllDocsQuery();
import java.util.List;
            )  
        for (int i = 0; i < 10; i++) {
 * Licensed to Elasticsearch under one or more contributor  
                    + "they can only be applied to string fields. Use an array of values for include/exclude clauses"
import org.opensearch.common.Numbers;
    }
 */  
        );
import org.apache.lucene.index.IndexReader;
    }  
    public void testBadIncludeExclude() throws IOException {
            () -> testSearchCase(
                agg -> fail("test should have failed with exception"),
            new MatchNoDocsQuery(),
                StringTerms.Bucket bucket = (StringTerms.Bucket) agg.getBuckets().get(i);
 * under the License.  
        IncludeExclude includeExclude = new IncludeExclude("foo", null);
                    indexWriter.addDocument(document);
            equalTo(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        Consumer<TermsAggregationBuilder> configure,
import org.apache.lucene.index.DirectoryReader;
        List<Long> d = new ArrayList<>(45);  
import org.apache.lucene.document.Document;  
        );
            agg -> assertEquals(0, agg.getBuckets().size()),
                    document.add(new BinaryFieldMapper.CustomBinaryDocValuesField(BINARY_FIELD, Numbers.longToBytes(value)));
            )
 * not use this file except in compliance with the License.
                ValueType.STRING // string type hint  
import org.opensearch.index.mapper.MappedFieldType;  
    }
                    configure.accept(aggregationBuilder);  
 * You may obtain a copy of the License at  
                aggregation -> aggregation.field(BINARY_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
 * SPDX-License-Identifier: Apache-2.0
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name");
 */
            for (int j = 0; j < i; j++) {
                aggregation -> aggregation.field(BINARY_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
            AggregationExecutionException.class,  
import java.io.IOException;  
                byte[] bytes = Numbers.longToBytes(9L - i);
        e = expectThrows(
                dataset,
            }  
            aggregation -> aggregation.field(BINARY_FIELD),
        List<Long> dataset,
import org.apache.lucene.search.IndexSearcher;  
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
 *
            ValueType.STRING  
    private static final String BINARY_FIELD = "binary";
import org.apache.lucene.util.BytesRef;  
                dataset,  
    public void testBadUserValueTypeHint() throws IOException {  
            )
import org.apache.lucene.search.MatchAllDocsQuery;
 * software distributed under the License is distributed on an
    static {
import org.opensearch.search.aggregations.support.ValueType;
        );
/*  
                ValueType.NUMERIC // numeric type hint
    }
                dataset,  
        ValueType valueType
import static org.hamcrest.Matchers.equalTo;
                verify.accept(rareTerms);  
import org.apache.lucene.tests.index.RandomIndexWriter;
                new MatchNoDocsQuery(),
                "Aggregation [_name] cannot support regular expression style include/exclude settings as "  
                }
            }
        Query query,  
                agg -> fail("test should have failed with exception"),
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (valueType != null) {
import java.util.ArrayList;
                }
public class BinaryTermsAggregatorTests extends AggregatorTestCase {
                    aggregationBuilder.userValueTypeHint(valueType);  
        );  
        dataset = d;  
                InternalMappedTerms rareTerms = searchAndReduce(indexSearcher, query, aggregationBuilder, binaryFieldType);
            dataset,  
    }
        );
            )
                new MatchNoDocsQuery(),
        }
        assertThat(e.getMessage(), equalTo("Expected numeric type on field [binary], but got [binary]"));
        testSearchCase(query, dataset, aggregation -> aggregation.field(BINARY_FIELD), agg -> {
        }
 *  
 * ownership. Elasticsearch licenses this file to you under  
            AggregationExecutionException.class,  
        testSearchCase(
 * Modifications Copyright OpenSearch Contributors. See  
                String bytesAsString = (String) DocValueFormat.BINARY.format(new BytesRef(bytes));  
        }, null);
                    document.clear();  
    }  
            () -> testSearchCase(
}
import java.util.function.Consumer;  
                assertThat(bucket.getDocCount(), equalTo(9L - i));
    public void testMatchAllDocs() throws IOException {
 * GitHub history for details.
                new MatchNoDocsQuery(),
 * this work for additional information regarding copyright
                null // default, no hint  
            e.getMessage(),
        assertThat(  
                }
            )
                agg -> fail("test should have failed with exception"),
/*
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 */
        AggregationExecutionException e = expectThrows(
        IllegalArgumentException e = expectThrows(
        Consumer<InternalMappedTerms> verify,  
import org.opensearch.search.aggregations.AggregationExecutionException;
                aggregation -> aggregation.field(BINARY_FIELD),  
        );  
            () -> testSearchCase(  
import org.apache.lucene.search.MatchNoDocsQuery;
        assertThat(  
                Document document = new Document();
        try (Directory directory = newDirectory()) {  
