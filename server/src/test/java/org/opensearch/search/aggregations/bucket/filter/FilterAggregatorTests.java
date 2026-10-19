 *  
    public void testBucketComparator() throws IOException {
    public void testRandom() throws Exception {  
import java.io.IOException;
import org.opensearch.index.mapper.MappedFieldType;  
        int maxTerm = randomIntBetween(10, 50);
                    e.getMessage(),  
                );
            }
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
 * compatible open source license.
                assertThat(c.compare(1, 0), lessThan(0));  
            if (expectedBucketCount[value] > 0) {  
                FilterAggregationBuilder builder = new FilterAggregationBuilder("test", new MatchAllQueryBuilder());  
/*
                // make sure we have more than one segment to test the merge  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class FilterAggregatorTests extends AggregatorTestCase {  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.query.QueryBuilders;  
 *
import org.apache.lucene.document.Document;  
    public void testEmpty() throws Exception {  
import org.apache.lucene.tests.index.RandomIndexWriter;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        assertEquals(response.getDocCount(), 0);  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
 * KIND, either express or implied.  See the License for the
    }
                    equalTo(
                assertTrue(AggregationInspectionHelper.hasValue(response));
 *
        }
        InternalFilter response = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);
                FilterAggregator agg = createAggregator(builder, indexSearcher, fieldType);
        }
 * You may obtain a copy of the License at  
                c = agg.bucketComparator("doc_count", SortOrder.ASC);
    private MappedFieldType fieldType;
        QueryBuilder filter = QueryBuilders.termQuery("field", randomAlphaOfLength(5));  
package org.opensearch.search.aggregations.bucket.filter;
 * license agreements. See the NOTICE file distributed with
        super.setUp();
import org.apache.lucene.index.IndexReader;  
                collector.collect(0, 0);
                Exception e = expectThrows(
            } else {
        int[] expectedBucketCount = new int[maxTerm];
import org.opensearch.index.query.QueryBuilder;
                collector.collect(0, 1);  
            indexWriter.addDocument(document);  
            }  
            document.add(new Field("field", Integer.toString(value), KeywordFieldMapper.Defaults.FIELD_TYPE));
        assertFalse(AggregationInspectionHelper.hasValue(response));
 * this file be licensed under the Apache-2.0 license or a
        int numDocs = randomIntBetween(100, 200);  
                    IllegalArgumentException.class,
        indexWriter.close();  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                assertThat(c.compare(1, 0), lessThan(0));  
        Document document = new Document();  
                assertFalse(AggregationInspectionHelper.hasValue(response));  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.Matchers.lessThan;
import org.opensearch.search.aggregations.LeafBucketCollector;  
import org.opensearch.search.aggregations.Aggregator.BucketComparator;
                assertThat(c.compare(0, 1), greaterThan(0));
            expectedBucketCount[value] += 1;
 */  
import org.apache.lucene.store.Directory;  
import org.opensearch.search.aggregations.AggregatorTestCase;
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import static java.util.Collections.singleton;
import org.opensearch.index.query.MatchAllQueryBuilder;
        IndexReader indexReader = DirectoryReader.open(directory);
    }
}  
 * Licensed to Elasticsearch under one or more contributor  
                BucketComparator c = agg.bucketComparator(null, SortOrder.ASC);
            }  
            directory.close();
                LeafBucketCollector collector = agg.getLeafCollector(indexReader.leaves().get(0));  
                assertThat(c.compare(0, 1), greaterThan(0));
    }
import static org.hamcrest.Matchers.greaterThan;  
/*  
            indexReader.close();  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.document.Field;
import org.junit.Before;  
    public void setUpTest() throws Exception {
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 */
        fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
        FilterAggregationBuilder builder = new FilterAggregationBuilder("test", filter);
        IndexReader indexReader = DirectoryReader.open(directory);
        indexReader.close();
            assertEquals(response.getDocCount(), (long) expectedBucketCount[value]);
                assertThat(
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.index.mapper.KeywordFieldMapper;
            }
            QueryBuilder filter = QueryBuilders.termQuery("field", Integer.toString(value));
            int value = randomInt(maxTerm - 1);  
 * not use this file except in compliance with the License.
import org.apache.lucene.index.DirectoryReader;
        try (Directory directory = newDirectory()) {  
 * under the License.  
                        "Ordering on a single-bucket aggregation can only be done on its doc_count. "
 * the Apache License, Version 2.0 (the "License"); you may
                agg.preCollection();
                    () -> agg.bucketComparator("garbage", randomFrom(SortOrder.values()))  
        for (int i = 0; i < numDocs; i++) {
 * ownership. Elasticsearch licenses this file to you under  
                );
            int value = randomInt(maxTerm - 1);  
        Directory directory = newDirectory();
 *    http://www.apache.org/licenses/LICENSE-2.0
        indexWriter.close();  
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
                indexWriter.commit();
 * The OpenSearch Contributors require contributions made to  
                    )
import org.apache.lucene.search.IndexSearcher;
/*
import org.opensearch.search.sort.SortOrder;
            final InternalFilter response = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);
                collector.collect(0, 0);
            FilterAggregationBuilder builder = new FilterAggregationBuilder("test", filter);
        }
            if (frequently()) {
                            + "Either drop the key (a la \"test\") or change it to \"doc_count\" (a la \"test.doc_count\") or \"key\"."  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    }  
        directory.close();  
        try {
            document.clear();
    @Before  
 */
                indexWriter.addDocument(singleton(new Field("field", "1", KeywordFieldMapper.Defaults.FIELD_TYPE)));
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        Directory directory = newDirectory();
 * this work for additional information regarding copyright
        } finally {
