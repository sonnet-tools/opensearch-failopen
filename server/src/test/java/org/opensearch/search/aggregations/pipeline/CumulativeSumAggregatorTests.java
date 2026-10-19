                int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
        "2017-01-02T03:43:34",  
                histogram = searchAndReduce(indexSearcher, query, aggBuilder, new MappedFieldType[] { fieldType, valueFieldType });  
                assertThat(((InternalSimpleValue) (bucket.getAggregations().get("cusum"))).value(), equalTo(sum));  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;  
import org.opensearch.index.mapper.DateFieldMapper;
            assertEquals(10, ((Histogram) histogram).getBuckets().size());
    }
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(VALUE_FIELD));  
            Document document = new Document();  
 */  
                setup.accept(indexWriter);
        Query query = new MatchNoDocsQuery();
            for (int i = 0; i < buckets.size(); i++) {
                assertThat(bucket, notNullValue());
        int numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
        });
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
        int minRandomValue = 0;  
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(HISTO_FIELD);
                Sum sum = bucket.getAggregations().get("sum");
        int interval = randomIntBetween(2, 5);
import org.opensearch.search.aggregations.metrics.InternalAvg;
        int numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
            .interval(interval)  
        executeTestCase(query, aggBuilder, histogram -> {  
                indexWriter.addDocument(document);
import org.apache.lucene.search.MatchAllDocsQuery;
            double sum = 0.0;  
    }
                valueCounts[bucket]++;
                document.clear();
        AggregationBuilder aggBuilder,
 * specific language governing permissions and limitations
                valueCounts[bucket]++;
        "2017-01-05T08:24:05",  
 *
import org.apache.lucene.document.Document;
            }  
        int minRandomValue = 0;
            double sum = 0;  
            assertThat(buckets.size(), equalTo(numValueBuckets));  
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");  
        "2017-01-07T13:47:43",
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
    public void testSimple() throws IOException {
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");  
                document.add(new SortedNumericDocValuesField(HISTO_FIELD, instant));
                document.clear();
import org.opensearch.index.mapper.NumberFieldMapper;
    private void executeTestCase(Query query, AggregationBuilder aggBuilder, Consumer<InternalAggregation> verify) throws IOException {
        "2017-01-03T04:11:00",
                assertThat(((InternalSimpleValue) (bucket.getAggregations().get("cusum"))).value(), equalTo(sum));  
        int maxRandomValue = 20;  
        Query query,  
                final int bucket = (fieldValue / interval);
     * First value from a derivative is null, so this makes sure the cusum can handle that
        int minRandomValue = 0;
                sum += bucket.getDocCount();  
                InternalSimpleValue cumulativeSumValue = bucket.getAggregations().get("cusum");
import org.apache.lucene.index.DirectoryReader;
        long[] valueCounts = new long[numValueBuckets];  
            for (Histogram.Bucket bucket : buckets) {
                final int bucket = (fieldValue / interval);
                assertThat(bucket, notNullValue());  
                if (frequently()) {  
 * under the License.  
import org.apache.lucene.search.IndexSearcher;  
                }
        executeTestCase(query, aggBuilder, histogram -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
        executeTestCase(query, aggBuilder, histogram -> {  
            for (int i = 0; i < numValueBuckets; ++i) {
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
import org.apache.lucene.index.IndexReader;
        });  
                    );  
        Query query = new MatchAllDocsQuery();
        }, indexWriter -> {
        long[] valueCounts = new long[numValueBuckets];  
import org.apache.lucene.search.MatchNoDocsQuery;
import java.io.IOException;  
            assertThat(buckets.size(), equalTo(numValueBuckets));
        int interval = randomIntBetween(2, 5);  
import org.opensearch.search.aggregations.metrics.Sum;
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            for (int i = 0; i < numDocs; i++) {  
            }
        aggBuilder.subAggregation(new AvgAggregationBuilder("the_avg").field(VALUE_FIELD));
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();  
                final int bucket = (fieldValue / interval);  
        executeTestCase(query, aggBuilder, verify, indexWriter -> {
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
        int maxRandomValue = 20;  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();  
                document.add(new NumericDocValuesField(VALUE_FIELD, fieldValue));  
                        AggregationInspectionHelper.hasValue(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))))
        executeTestCase(query, aggBuilder, histogram -> {  
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
 * The OpenSearch Contributors require contributions made to  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            }
    }
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
    public void testNoBuckets() throws IOException {
    }
        "2017-01-04T05:11:31",
public class CumulativeSumAggregatorTests extends AggregatorTestCase {
            double sum = 1.0;
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        int numDocs = randomIntBetween(6, 20);
        aggBuilder.calendarInterval(DateHistogramInterval.DAY).field(HISTO_FIELD);
        }, indexWriter -> {
                InternalSimpleValue sumBucketValue = bucket.getAggregations().get("cusum");
            double bucketSum = 0;
        "2017-01-09T17:09:50",
            for (int i = 0; i < numValueBuckets; ++i) {  
 * GitHub history for details.
                Histogram.Bucket bucket = buckets.get(i);
    ) throws IOException {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            Document document = new Document();
            .extendedBounds(minRandomValue, maxRandomValue);
        });
                assertThat(cumulativeSumValue.getName(), equalTo("cusum"));  
 *
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "sum"));
import java.util.List;
                    assertThat(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))).value(), equalTo(sum));  
                Histogram.Bucket bucket = buckets.get(i);
        "2017-01-01T01:07:45",
            for (Histogram.Bucket bucket : buckets) {
                } else {
    }  
                document.add(new NumericDocValuesField(VALUE_FIELD, fieldValue));
    public void testMetric() throws IOException {  
        }, indexWriter -> {  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import org.apache.lucene.document.SortedNumericDocValuesField;  
    private static long asLong(String dateTime) {  
                assertTrue(AggregationInspectionHelper.hasValue(((InternalSimpleValue) (bucket.getAggregations().get("cusum")))));
                int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
/*  
        });  
        try (Directory directory = newDirectory()) {  
                indexWriter.addDocument(document);  
     */
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            }
            for (String date : datasetTimes) {
        "2017-01-06T13:09:32",
                int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
        Query query = new MatchAllDocsQuery();
    }
    public void testDocCount() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    private static final List<Integer> datasetValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                    );  
        });
            for (int i = 0; i < numDocs; i++) {
        int interval = randomIntBetween(2, 5);  
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "_count"));
        Query query = new MatchAllDocsQuery();
 * KIND, either express or implied.  See the License for the
        "2017-01-08T16:14:34",  
    public void testCount() throws IOException {  
                indexWriter.addDocument(document);
import org.apache.lucene.store.Directory;
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        });  
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("the_deriv", "the_avg"));  
                }
                assertTrue(AggregationInspectionHelper.hasValue(((InternalAvg) (bucket.getAggregations().get("the_avg")))));
    private static final String HISTO_FIELD = "histo";
import org.opensearch.index.mapper.MappedFieldType;  
            }  
    /**  
                assertThat(cumulativeSumValue.value(), equalTo(sum));
                assertThat(sumBucketValue.getName(), equalTo("cusum"));
import static org.hamcrest.core.IsNull.notNullValue;  
        int maxRandomValue = 20;
 */
                indexWriter.addDocument(document);
    private static final String VALUE_FIELD = "value_field";
    );  
package org.opensearch.search.aggregations.pipeline;
        Consumer<InternalAggregation> verify,
            .interval(interval)
            Document document = new Document();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
                InternalAggregation histogram;
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "sum"));  
                document.clear();
 * this file be licensed under the Apache-2.0 license or a
                document.add(new NumericDocValuesField(VALUE_FIELD, fieldValue));  
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "the_avg"));
                assertThat(sumBucketValue.value(), equalTo(bucketSum));
                if (i == 0) {
import org.apache.lucene.document.NumericDocValuesField;
/*  
    }  
        Query query = new MatchAllDocsQuery();  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));  
import java.util.Arrays;
import java.util.function.Consumer;  
            assertEquals(10, ((Histogram) histogram).getBuckets().size());
    private static final List<String> datasetTimes = Arrays.asList(
        int numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;  
            Document document = new Document();
                bucketSum += sum.value();  
 * You may obtain a copy of the License at  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        }  
 * compatible open source license.
        int numDocs = randomIntBetween(6, 20);
import org.opensearch.common.time.DateFormatters;
            int counter = 0;
                        AggregationInspectionHelper.hasValue(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))))
import org.opensearch.common.CheckedConsumer;  
    private void executeTestCase(
        int numDocs = randomIntBetween(6, 20);  
                counter += 1;  
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(VALUE_FIELD)  
                sum += ((InternalAvg) (bucket.getAggregations().get("the_avg"))).value();
                document.add(new NumericDocValuesField(VALUE_FIELD, datasetValues.get(counter)));  
        aggBuilder.subAggregation(new AvgAggregationBuilder("the_avg").field(VALUE_FIELD));  
        Query query = new MatchAllDocsQuery();
            for (int i = 0; i < numDocs; i++) {
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "_count"));
                sum += 1.0;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            assertEquals(10, ((Histogram) histogram).getBuckets().size());
                assertThat(cumulativeSumValue, notNullValue());
                long instant = asLong(date);
/*
import org.opensearch.search.aggregations.InternalAggregation;
                    indexWriter.commit();
import static org.hamcrest.Matchers.equalTo;
                assertThat(sumBucketValue, notNullValue());  
 * this work for additional information regarding copyright
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(VALUE_FIELD)
        executeTestCase(query, aggBuilder, histogram -> {
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(VALUE_FIELD));
            }  
import org.apache.lucene.search.Query;  
        aggBuilder.calendarInterval(DateHistogramInterval.DAY).field(HISTO_FIELD);
                    sum += 1.0;
            }  
            double sum = 0.0;  
        CheckedConsumer<RandomIndexWriter, IOException> setup  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;  
import org.opensearch.search.aggregations.AggregatorTestCase;  
                    assertTrue(
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");
    public void testDerivative() throws IOException {  
            }  
 * license agreements. See the NOTICE file distributed with
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value_field", NumberFieldMapper.NumberType.LONG);  
 *  
    }
        "2017-01-10T22:55:46"
                verify.accept(histogram);
            }
                    assertTrue(
                document.clear();
        executeTestCase(query, aggBuilder, histogram -> {
            .extendedBounds(minRandomValue, maxRandomValue);
            }
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "the_deriv"));
 * the Apache License, Version 2.0 (the "License"); you may
}  
 */  
                    assertThat(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))).value(), equalTo(0.0));  
        long[] valueCounts = new long[numValueBuckets];
        aggBuilder.dateHistogramInterval(DateHistogramInterval.DAY).field(HISTO_FIELD);
                valueCounts[bucket]++;
import org.apache.lucene.tests.index.RandomIndexWriter;
    }
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(VALUE_FIELD).interval(interval);
            assertThat(buckets.size(), equalTo(0));
                assertThat(sum, notNullValue());
