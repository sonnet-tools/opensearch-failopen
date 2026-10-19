            reducedAggs.add(histogramResult);
            // Finally, reduce the pipeline agg  
            InternalAggregation pipelineResult = ((AvgBucketPipelineAggregator) avgBucketAgg).doReduce(aggregations, null);
            // Histo has to go first to exercise the bug
        "2016-03-04T17:09:50",
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                Document document = new Document();
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
     * Note: we have this test inside of the `avg_bucket` package so that we can get access to the package-private
 * software distributed under the License is distributed on an
     * D. Finally, a pipeline agg with the path down to B
            InternalDateHistogram histogramResult;  
                    }
import java.util.Collections;  
    private static final List<String> dataset = Arrays.asList(
 * Unless required by applicable law or agreed to in writing,
        }
     * A. Multi-bucket agg in the first entry of our internal list
            .field(DATE_FIELD)  
import org.opensearch.search.aggregations.Aggregation;
 * Licensed to Elasticsearch under one or more contributor  
    }
 * specific language governing permissions and limitations
     * B. Regular agg as the immediate child of the multi-bucket in A  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.Aggregations;  
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD, NumberFieldMapper.NumberType.LONG);  
 * not use this file except in compliance with the License.
                }
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
import org.apache.lucene.search.MatchAllDocsQuery;  
 *  
        "2015-11-13T16:14:34",  
import java.util.Arrays;
                histogramResult = searchAndReduce(indexSearcher, query, histo, 10000, new MappedFieldType[] { fieldType, valueFieldType });  
import java.io.IOException;  
        "2015-02-13T13:09:32",
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
     * <p>  
                    document.clear();
public class AvgBucketAggregatorTests extends AggregatorTestCase {  
 * this file be licensed under the Apache-2.0 license or a
     * it is fixed.
        "2010-03-12T01:07:45",
                    if (frequently()) {  
            }
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(DATE_FIELD);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AvgBucketPipelineAggregationBuilder avgBucketBuilder = new AvgBucketPipelineAggregationBuilder("the_avg_bucket", "histo>foo");  
 *
     * C. Regular agg with the same name as B at the top level, listed as the second entry in our internal list
 * license agreements. See the NOTICE file distributed with
    /**
        "2013-05-29T05:11:31",
 * this work for additional information regarding copyright
            .subAggregation(new AvgAggregationBuilder("foo").field(VALUE_FIELD));
        "2017-12-12T22:55:46"
        Query query = new MatchAllDocsQuery();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.IndexReader;
     * <p>  
    private static final String VALUE_FIELD = "value";
    private static long asLong(String dateTime) {
import org.apache.lucene.store.Directory;
 */  
package org.opensearch.search.aggregations.pipeline;
import java.util.ArrayList;
        "2015-06-24T13:47:43",
            }  
import org.apache.lucene.tests.index.RandomIndexWriter;  
     * `reduce()` needed for testing this
 */
     * BucketMetrics reduction would throw a class cast exception due to bad subpathing.  This test ensures
            List<Aggregation> reducedAggs = new ArrayList<>(2);
 * Modifications Copyright OpenSearch Contributors. See
    }  
        AvgAggregationBuilder avgBuilder = new AvgAggregationBuilder("foo").field(VALUE_FIELD);
/*  
            InternalAvg avgResult;
     * Test for issue #30608.  Under the following circumstances:  
import org.apache.lucene.document.SortedNumericDocValuesField;
                    indexWriter.addDocument(document);  
        "2010-04-27T03:43:34",  
import org.opensearch.common.time.DateFormatters;
    );  
 * KIND, either express or implied.  See the License for the
 * under the License.  
    private static final String DATE_FIELD = "date";
import org.opensearch.search.aggregations.InternalAggregation;
 * compatible open source license.
            Aggregations aggregations = new Aggregations(reducedAggs);
                avgResult = searchAndReduce(indexSearcher, query, avgBuilder, 10000, new MappedFieldType[] { fieldType, valueFieldType });
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import org.apache.lucene.search.IndexSearcher;
            assertNotNull(pipelineResult);  
import org.opensearch.index.mapper.MappedFieldType;  
            reducedAggs.add(avgResult);  
import org.apache.lucene.search.Query;
                    document.add(new SortedNumericDocValuesField(DATE_FIELD, asLong(date)));
 * GitHub history for details.
     * <p>
import org.opensearch.index.mapper.DateFieldMapper;
        "2012-05-18T04:11:00",
                    document.add(new SortedNumericDocValuesField(VALUE_FIELD, randomInt()));
}
 *
        DateHistogramAggregationBuilder histo = new DateHistogramAggregationBuilder("histo").calendarInterval(DateHistogramInterval.YEAR)
    public void testSameAggNames() throws IOException {
/*
import org.opensearch.index.mapper.NumberFieldMapper;
     */  
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
            PipelineAggregator avgBucketAgg = avgBucketBuilder.createInternal(Collections.emptyMap());
import org.opensearch.search.aggregations.metrics.InternalAvg;
 * You may obtain a copy of the License at  
import org.apache.lucene.document.Document;
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
        "2013-10-31T08:24:05",  
                for (String date : dataset) {
 * SPDX-License-Identifier: Apache-2.0
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.DirectoryReader;  
        try (Directory directory = newDirectory()) {
                        indexWriter.commit();
 */  
