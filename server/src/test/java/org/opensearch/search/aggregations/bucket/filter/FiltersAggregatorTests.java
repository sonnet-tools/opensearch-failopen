        document.add(new Field("field", "something", KeywordFieldMapper.Defaults.FIELD_TYPE));
import org.junit.Before;
        directory.close();
import org.opensearch.index.mapper.MappedFieldType;
                int value = randomInt(maxTerm - 1);
        // make sure we have more than one segment to test the merge
 * specific language governing permissions and limitations
        }
            directory.close();
import org.opensearch.index.query.QueryBuilder;
        fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        builder.otherBucket(true);
        indexWriter.addDocument(document);
            if (frequently()) {
        keys[4] = new FiltersAggregator.KeyedFilter("same", QueryBuilders.termQuery("field", "foo"));
                filterTerms[i] = value;
            List<InternalFilters.InternalBucket> buckets = response.getBuckets();
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
        Document document = new Document();
        document.clear();
 * not use this file except in compliance with the License.
        try {
        }
            int expectedOtherCount = numDocs;
        indexWriter.addDocument(document);
        document.add(new Field("field", "else", KeywordFieldMapper.Defaults.FIELD_TYPE));
        } finally {
        builder.otherBucketKey("other");
    public void testKeyedFilter() throws Exception {
            int numFilters = randomIntBetween(1, 10);
            document.add(new Field("field", Integer.toString(value), KeywordFieldMapper.Defaults.FIELD_TYPE));
 *
            indexReader.close();
        indexWriter.addDocument(document);
        IndexReader indexReader = DirectoryReader.open(directory);
        int[] expectedBucketCount = new int[maxTerm];
        document.add(new Field("field", "foobar", KeywordFieldMapper.Defaults.FIELD_TYPE));
/*
 */
        indexWriter.addDocument(document);
        assertEquals(filters.getBucketByKey("other").getDocCount(), 2);
        }
        super.setUp();
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.apache.lucene.document.Document;
 * Unless required by applicable law or agreed to in writing,
        assertFalse(AggregationInspectionHelper.hasValue(response));
        keys[5] = new FiltersAggregator.KeyedFilter("same", QueryBuilders.termQuery("field", "bar"));
            QueryBuilder[] filters = new QueryBuilder[numFilters];
import java.util.List;
        indexWriter.addDocument(document);
                    int index = Integer.parseInt(bucket.getKey());
        indexWriter.commit();
}
        assertEquals(filters.getBuckets().size(), 7);
/*
                    expectedOtherCount -= expectedBucketCount[value];
        int numDocs = randomIntBetween(100, 200);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        indexReader.close();
            assertEquals(filter.getDocCount(), 0);
 * Licensed to Elasticsearch under one or more contributor
    private MappedFieldType fieldType;
        indexWriter.addDocument(document);
import org.apache.lucene.index.DirectoryReader;
    public void setUpTest() throws Exception {
        FiltersAggregationBuilder builder = new FiltersAggregationBuilder("test", keys);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            expectedBucketCount[value] += 1;
                }
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.document.Field;
        assertEquals(filters.getBucketByKey("foobar").getDocCount(), 2);
/*
        IndexReader indexReader = DirectoryReader.open(directory);
        assertTrue(AggregationInspectionHelper.hasValue(filters));
    }
        indexWriter.commit();
            for (int i = 0; i < filters.length; i++) {
        document.add(new Field("field", "foobar", KeywordFieldMapper.Defaults.FIELD_TYPE));
        assertEquals(filters.getBucketByKey("same").getDocCount(), 1);
        indexReader.close();
        keys[1] = new FiltersAggregator.KeyedFilter("bar", QueryBuilders.termQuery("field", "bar"));
        document.clear();
            final InternalFilters response = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);
import org.opensearch.index.query.QueryBuilders;
        assertEquals(response.getBuckets().size(), numFilters);
            int value = randomInt(maxTerm - 1);
            // Always true because we include 'other' in the agg
        document.clear();
        indexWriter.close();
 * Modifications Copyright OpenSearch Contributors. See
            FiltersAggregationBuilder builder = new FiltersAggregationBuilder("test", filters);
import org.apache.lucene.index.IndexReader;
        document.add(new Field("field", "bar", KeywordFieldMapper.Defaults.FIELD_TYPE));
package org.opensearch.search.aggregations.bucket.filter;
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            indexWriter.addDocument(document);
        FiltersAggregator.KeyedFilter[] keys = new FiltersAggregator.KeyedFilter[6];
        keys[0] = new FiltersAggregator.KeyedFilter("foobar", QueryBuilders.termQuery("field", "foobar"));
        Directory directory = newDirectory();
import org.opensearch.search.aggregations.AggregatorTestCase;
                indexWriter.commit();
                filters[i] = QueryBuilders.termQuery("field", Integer.toString(value));
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(buckets.size(), filters.length + 1);
 */
        indexWriter.close();
            document.clear();
        assertEquals(filters.getBucketByKey("foo2").getDocCount(), 2);
        Directory directory = newDirectory();
                    filterSet.add(value);
 * license agreements. See the NOTICE file distributed with
                if (filterSet.contains(value) == false) {
        int numFilters = randomIntBetween(1, 10);
    }
        for (int i = 0; i < numDocs; i++) {
public class FiltersAggregatorTests extends AggregatorTestCase {
            int[] filterTerms = new int[numFilters];
        int maxTerm = randomIntBetween(10, 50);
    }
        indexWriter.close();
        indexWriter.addDocument(document);
        keys[2] = new FiltersAggregator.KeyedFilter("foo", QueryBuilders.termQuery("field", "foo"));
                // make sure we have more than one segment to test the merge
 * compatible open source license.
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        Document document = new Document();
 * GitHub history for details.
        directory.close();
import java.util.Set;
            assertTrue(AggregationInspectionHelper.hasValue(response));
        for (int i = 0; i < filters.length; i++) {
        keys[3] = new FiltersAggregator.KeyedFilter("foo2", QueryBuilders.termQuery("field", "foo"));
            }
 * ownership. Elasticsearch licenses this file to you under
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            filters[i] = QueryBuilders.termQuery("field", randomAlphaOfLength(5));
import org.apache.lucene.search.IndexSearcher;
    @Before
            for (InternalFilters.InternalBucket bucket : buckets) {
                    assertEquals(bucket.getDocCount(), (long) expectedBucketCount[filterTerms[index]]);
        document.clear();
        FiltersAggregationBuilder builder = new FiltersAggregationBuilder("test", filters);
 * under the License.
        builder.otherBucketKey("other");
        document.clear();
            builder.otherBucketKey("other");
                }
 * SPDX-License-Identifier: Apache-2.0
        document.add(new Field("field", "foo", KeywordFieldMapper.Defaults.FIELD_TYPE));
                } else {
        final InternalFilters filters = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);
                if ("other".equals(bucket.getKey())) {
import java.util.HashSet;
 * the Apache License, Version 2.0 (the "License"); you may
        IndexReader indexReader = DirectoryReader.open(directory);
        Directory directory = newDirectory();
 */
        for (InternalFilters.InternalBucket filter : response.getBuckets()) {
    }
 *
        document.add(new Field("field", "foo", KeywordFieldMapper.Defaults.FIELD_TYPE));
        indexWriter.commit();
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 * The OpenSearch Contributors require contributions made to
                    assertEquals(bucket.getDocCount(), expectedOtherCount);
        assertEquals(filters.getBucketByKey("foo").getDocCount(), 2);
        QueryBuilder[] filters = new QueryBuilder[numFilters];
    public void testEmpty() throws Exception {
        InternalFilters response = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), builder, fieldType);
import org.apache.lucene.store.Directory;
 *
    public void testRandom() throws Exception {
        // filter name already present so it should be merge with the previous one ?
            }
            }
            Set<Integer> filterSet = new HashSet<>();
import org.apache.lucene.tests.index.RandomIndexWriter;
 * KIND, either express or implied.  See the License for the
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            builder.otherBucket(true);
        assertEquals(filters.getBucketByKey("bar").getDocCount(), 1);
