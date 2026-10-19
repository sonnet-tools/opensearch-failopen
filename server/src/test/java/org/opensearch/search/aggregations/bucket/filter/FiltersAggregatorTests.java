            builder.otherBucket(true);  
        for (int i = 0; i < numDocs; i++) {
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        document.add(new Field("field", "else", KeywordFieldMapper.Defaults.FIELD_TYPE));
        assertEquals(filters.getBuckets().size(), 7);  
            }  
 * software distributed under the License is distributed on an
        Directory directory = newDirectory();  
                    int index = Integer.parseInt(bucket.getKey());
 * You may obtain a copy of the License at  
            document.clear();
            indexWriter.addDocument(document);
        Directory directory = newDirectory();
/*  
                // make sure we have more than one segment to test the merge
            }
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        int maxTerm = randomIntBetween(10, 50);
        }  
        document.add(new Field("field", "foo", KeywordFieldMapper.Defaults.FIELD_TYPE));
        QueryBuilder[] filters = new QueryBuilder[numFilters];  
                    filterSet.add(value);
import org.opensearch.index.mapper.KeywordFieldMapper;
        FiltersAggregationBuilder builder = new FiltersAggregationBuilder("test", filters);
        document.clear();
    @Before
        builder.otherBucketKey("other");
            document.add(new Field("field", Integer.toString(value), KeywordFieldMapper.Defaults.FIELD_TYPE));  
        assertEquals(filters.getBucketByKey("foo2").getDocCount(), 2);  
        FiltersAggregationBuilder builder = new FiltersAggregationBuilder("test", keys);
        document.add(new Field("field", "foobar", KeywordFieldMapper.Defaults.FIELD_TYPE));
            assertEquals(buckets.size(), filters.length + 1);
        try {
        indexWriter.close();
 *
        indexWriter.close();
        indexWriter.addDocument(document);  
            QueryBuilder[] filters = new QueryBuilder[numFilters];
                    assertEquals(bucket.getDocCount(), (long) expectedBucketCount[filterTerms[index]]);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int numFilters = randomIntBetween(1, 10);
import org.opensearch.index.query.QueryBuilders;
        keys[3] = new FiltersAggregator.KeyedFilter("foo2", QueryBuilders.termQuery("field", "foo"));
        super.setUp();
        fieldType = new KeywordFieldMapper.KeywordFieldType("field");
 * Modifications Copyright OpenSearch Contributors. See  
        indexWriter.commit();
        indexWriter.addDocument(document);  
        indexWriter.addDocument(document);
                if ("other".equals(bucket.getKey())) {
        for (int i = 0; i < filters.length; i++) {
    public void testEmpty() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
            filters[i] = QueryBuilders.termQuery("field", randomAlphaOfLength(5));
        document.clear();
            for (InternalFilters.InternalBucket bucket : buckets) {
            for (int i = 0; i < filters.length; i++) {
        Document document = new Document();
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(AggregationInspectionHelper.hasValue(response));
 * under the License.  
        document.clear();
            int value = randomInt(maxTerm - 1);
                indexWriter.commit();
        indexWriter.commit();  
import java.util.HashSet;
        }  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(filters.getBucketByKey("other").getDocCount(), 2);  
        IndexReader indexReader = DirectoryReader.open(directory);  
                if (filterSet.contains(value) == false) {  
            FiltersAggregationBuilder builder = new FiltersAggregationBuilder("test", filters);
    }  
            // Always true because we include 'other' in the agg
import java.util.Set;  
import java.util.List;
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import org.opensearch.search.aggregations.AggregatorTestCase;  
        keys[0] = new FiltersAggregator.KeyedFilter("foobar", QueryBuilders.termQuery("field", "foobar"));
 * this work for additional information regarding copyright
/*
        assertEquals(response.getBuckets().size(), numFilters);
    public void setUpTest() throws Exception {  
                }
 *  
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import org.apache.lucene.document.Field;
            if (frequently()) {  
    private MappedFieldType fieldType;  
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.document.Document;  
                } else {
        indexReader.close();  
                    expectedOtherCount -= expectedBucketCount[value];
import org.apache.lucene.store.Directory;  
        IndexReader indexReader = DirectoryReader.open(directory);  
 */
        Document document = new Document();
}
 * KIND, either express or implied.  See the License for the
        directory.close();
 * Unless required by applicable law or agreed to in writing,
        builder.otherBucket(true);  
 * this file be licensed under the Apache-2.0 license or a
            indexReader.close();
        }  
    }
                    assertEquals(bucket.getDocCount(), expectedOtherCount);  
        keys[2] = new FiltersAggregator.KeyedFilter("foo", QueryBuilders.termQuery("field", "foo"));  
import org.apache.lucene.index.DirectoryReader;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.IndexReader;  
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.index.query.QueryBuilder;
            directory.close();
        indexWriter.addDocument(document);
            assertEquals(filter.getDocCount(), 0);  
        indexReader.close();  
        final InternalFilters filters = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);
    }
        document.add(new Field("field", "foo", KeywordFieldMapper.Defaults.FIELD_TYPE));  
        assertTrue(AggregationInspectionHelper.hasValue(filters));
/*
        // make sure we have more than one segment to test the merge
        int numDocs = randomIntBetween(100, 200);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        indexWriter.close();
        }
import org.apache.lucene.tests.index.RandomIndexWriter;
 */  
        assertFalse(AggregationInspectionHelper.hasValue(response));
public class FiltersAggregatorTests extends AggregatorTestCase {
 *
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        keys[4] = new FiltersAggregator.KeyedFilter("same", QueryBuilders.termQuery("field", "foo"));
package org.opensearch.search.aggregations.bucket.filter;
 * GitHub history for details.
        } finally {  
 */
            final InternalFilters response = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);  
        indexWriter.addDocument(document);
    }
    public void testRandom() throws Exception {
        FiltersAggregator.KeyedFilter[] keys = new FiltersAggregator.KeyedFilter[6];  
            int expectedOtherCount = numDocs;  
            Set<Integer> filterSet = new HashSet<>();
                int value = randomInt(maxTerm - 1);  
        document.add(new Field("field", "bar", KeywordFieldMapper.Defaults.FIELD_TYPE));  
        indexWriter.addDocument(document);
import org.junit.Before;
 * not use this file except in compliance with the License.
            List<InternalFilters.InternalBucket> buckets = response.getBuckets();
 * compatible open source license.
        keys[5] = new FiltersAggregator.KeyedFilter("same", QueryBuilders.termQuery("field", "bar"));
        keys[1] = new FiltersAggregator.KeyedFilter("bar", QueryBuilders.termQuery("field", "bar"));
            int numFilters = randomIntBetween(1, 10);  
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        document.add(new Field("field", "something", KeywordFieldMapper.Defaults.FIELD_TYPE));
        builder.otherBucketKey("other");
        int[] expectedBucketCount = new int[maxTerm];  
                }  
            int[] filterTerms = new int[numFilters];
        document.clear();
        IndexReader indexReader = DirectoryReader.open(directory);  
            builder.otherBucketKey("other");
        indexWriter.commit();
                filters[i] = QueryBuilders.termQuery("field", Integer.toString(value));
        assertEquals(filters.getBucketByKey("foo").getDocCount(), 2);
        InternalFilters response = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);  
        indexWriter.addDocument(document);  
 * SPDX-License-Identifier: Apache-2.0
        // filter name already present so it should be merge with the previous one ?  
    public void testKeyedFilter() throws Exception {
import org.apache.lucene.search.IndexSearcher;
        Directory directory = newDirectory();
        directory.close();
            }
        document.add(new Field("field", "foobar", KeywordFieldMapper.Defaults.FIELD_TYPE));  
        assertEquals(filters.getBucketByKey("bar").getDocCount(), 1);
 * Licensed to Elasticsearch under one or more contributor  
                filterTerms[i] = value;
 * license agreements. See the NOTICE file distributed with
        assertEquals(filters.getBucketByKey("foobar").getDocCount(), 2);
            expectedBucketCount[value] += 1;
        document.clear();  
        assertEquals(filters.getBucketByKey("same").getDocCount(), 1);
        for (InternalFilters.InternalBucket filter : response.getBuckets()) {
