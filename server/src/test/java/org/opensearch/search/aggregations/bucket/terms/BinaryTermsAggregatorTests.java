                dataset,
        testSearchCase(
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            for (int j = 0; j < i; j++) {
        AggregationExecutionException e = expectThrows(
    }
            () -> testSearchCase(
            AggregationExecutionException.class,
                    + "they can only be applied to string fields. Use an array of values for include/exclude clauses"
                aggregation -> aggregation.field(BINARY_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
        List<Long> dataset,
 * You may obtain a copy of the License at
            for (int i = 0; i < 9; i++) {
        testSearchCase(query, dataset, aggregation -> aggregation.field(BINARY_FIELD), agg -> {
                StringTerms.Bucket bucket = (StringTerms.Bucket) agg.getBuckets().get(i);
import org.apache.lucene.store.Directory;
            }
 */
 * specific language governing permissions and limitations
            agg -> assertEquals(0, agg.getBuckets().size()),
 * under the License.
import org.opensearch.common.Numbers;
            equalTo(
/*
                ValueType.NUMERIC // numeric type hint
            new MatchNoDocsQuery(),
    private static final List<Long> dataset;
            () -> testSearchCase(
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    private void testSearchCase(
                MappedFieldType binaryFieldType = new BinaryFieldMapper.BinaryFieldType(BINARY_FIELD);
import static org.hamcrest.Matchers.equalTo;
            assertEquals(9, agg.getBuckets().size());
        );
                aggregation -> aggregation.field(BINARY_FIELD),
                    document.clear();
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.DirectoryReader;
 * not use this file except in compliance with the License.
                    aggregationBuilder.userValueTypeHint(valueType);
        Consumer<InternalMappedTerms> verify,
 * this work for additional information regarding copyright
        }
        );
            dataset,
    static {
import java.util.function.Consumer;
            IllegalArgumentException.class,
                assertThat(bucket.getKey(), equalTo(bytesAsString));
            () -> testSearchCase(
            aggregation -> aggregation.field(BINARY_FIELD),
    }
 * Licensed to Elasticsearch under one or more contributor
            )
                "Aggregation [_name] cannot support regular expression style include/exclude settings as "
                    configure.accept(aggregationBuilder);
    ) throws IOException {
            )
import org.apache.lucene.search.Query;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
        IllegalArgumentException e = expectThrows(
        assertThat(
 */
            ValueType.STRING
import org.apache.lucene.search.MatchAllDocsQuery;
                }
    }
                if (valueType != null) {
import org.opensearch.search.aggregations.AggregatorTestCase;
            equalTo(
        List<Long> d = new ArrayList<>(45);
        dataset = d;
                    indexWriter.addDocument(document);
        );
                new MatchNoDocsQuery(),
                    document.add(new BinaryFieldMapper.CustomBinaryDocValuesField(BINARY_FIELD, Numbers.longToBytes(value)));
                agg -> fail("test should have failed with exception"),
        );
import org.opensearch.search.aggregations.AggregationExecutionException;
        try (Directory directory = newDirectory()) {
                agg -> fail("test should have failed with exception"),
        for (int i = 0; i < 10; i++) {
import org.opensearch.index.mapper.BinaryFieldMapper;
        }, null);
        // Make sure the include/exclude fails regardless of how the user tries to type hint the agg
import java.util.ArrayList;
import org.apache.lucene.document.Document;
                TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name");
                String bytesAsString = (String) DocValueFormat.BINARY.format(new BytesRef(bytes));
                null // default, no hint
            )
        assertThat(e.getMessage(), equalTo("Expected numeric type on field [binary], but got [binary]"));
import org.apache.lucene.util.BytesRef;
        assertThat(
                agg -> fail("test should have failed with exception"),
                dataset,
                }
                verify.accept(rareTerms);
package org.opensearch.search.aggregations.bucket.terms;
                InternalMappedTerms rareTerms = searchAndReduce(indexSearcher, query, aggregationBuilder, binaryFieldType);
 */
    public void testBadIncludeExclude() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
public class BinaryTermsAggregatorTests extends AggregatorTestCase {
    public void testBadUserValueTypeHint() throws IOException {
import org.opensearch.search.DocValueFormat;
 *
        );
        );
import org.apache.lucene.tests.index.RandomIndexWriter;
                ValueType.STRING // string type hint
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
                new MatchNoDocsQuery(),
                Document document = new Document();
import java.io.IOException;
    private static final String BINARY_FIELD = "binary";
            e.getMessage(),
                d.add((long) i);
            }
                "Aggregation [_name] cannot support regular expression style include/exclude settings as "
                for (Long value : dataset) {
/*
                    + "they can only be applied to string fields. Use an array of values for include/exclude clauses"
 * Unless required by applicable law or agreed to in writing,
            AggregationExecutionException.class,
                if (configure != null) {
        e = expectThrows(
                }
 * The OpenSearch Contributors require contributions made to
    public void testMatchAllDocs() throws IOException {
    }
import org.apache.lucene.index.IndexReader;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            e.getMessage(),
import org.opensearch.search.aggregations.support.ValueType;
            )
                byte[] bytes = Numbers.longToBytes(9L - i);
                aggregation -> aggregation.field(BINARY_FIELD).includeExclude(includeExclude).format("yyyy-MM-dd"),
}
import org.apache.lucene.search.IndexSearcher;
 * software distributed under the License is distributed on an
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.index.mapper.MappedFieldType;
    }
        IncludeExclude includeExclude = new IncludeExclude("foo", null);
            }
        Query query,
                assertThat(bucket.getDocCount(), equalTo(9L - i));
        Query query = new MatchAllDocsQuery();
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under
 *
import org.apache.lucene.search.MatchNoDocsQuery;
 *
            }
            )
        Consumer<TermsAggregationBuilder> configure,
                dataset,
        ValueType valueType
/*
                new MatchNoDocsQuery(),
    public void testMatchNoDocs() throws IOException {
