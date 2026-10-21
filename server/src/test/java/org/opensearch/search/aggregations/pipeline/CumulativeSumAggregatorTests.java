    private static final List<Integer> datasetValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Query query = new MatchNoDocsQuery();
                InternalSimpleValue cumulativeSumValue = bucket.getAggregations().get("cusum");
                    sum += 1.0;
 * GitHub history for details.
import org.opensearch.common.time.DateFormatters;
import org.apache.lucene.store.Directory;
        executeTestCase(query, aggBuilder, histogram -> {
            }
import org.opensearch.search.aggregations.metrics.Sum;
            for (String date : datasetTimes) {
/*
    }
        "2017-01-07T13:47:43",
        int minRandomValue = 0;
        int maxRandomValue = 20;
import org.apache.lucene.document.NumericDocValuesField;
        });
                indexWriter.addDocument(document);
        Query query = new MatchAllDocsQuery();
                InternalSimpleValue sumBucketValue = bucket.getAggregations().get("cusum");
                        AggregationInspectionHelper.hasValue(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))))
import org.opensearch.common.CheckedConsumer;
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");
                document.clear();
            for (int i = 0; i < numDocs; i++) {
                assertTrue(AggregationInspectionHelper.hasValue(((InternalAvg) (bucket.getAggregations().get("the_avg")))));
        executeTestCase(query, aggBuilder, histogram -> {
                assertThat(sumBucketValue.getName(), equalTo("cusum"));
    public void testCount() throws IOException {
                    );
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "the_deriv"));
            assertEquals(10, ((Histogram) histogram).getBuckets().size());
            }
                bucketSum += sum.value();
            double sum = 0;
        "2017-01-04T05:11:31",
                if (frequently()) {
        }, indexWriter -> {
                if (i == 0) {
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "the_avg"));
    private static long asLong(String dateTime) {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                counter += 1;
 * license agreements. See the NOTICE file distributed with
        assertWarnings("[interval] on [date_histogram] is deprecated, use [fixed_interval] or [calendar_interval] in the future.");
    }
/*
     */
        }, indexWriter -> {
            Document document = new Document();
import org.opensearch.index.mapper.NumberFieldMapper;
 * not use this file except in compliance with the License.
                sum += 1.0;
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        long[] valueCounts = new long[numValueBuckets];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(cumulativeSumValue.getName(), equalTo("cusum"));
                assertThat(bucket, notNullValue());
    ) throws IOException {
        "2017-01-03T04:11:00",
            .extendedBounds(minRandomValue, maxRandomValue);
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value_field", NumberFieldMapper.NumberType.LONG);
        int numDocs = randomIntBetween(6, 20);
    }
import org.apache.lucene.search.IndexSearcher;
        "2017-01-05T08:24:05",
    /**
                assertTrue(AggregationInspectionHelper.hasValue(((InternalSimpleValue) (bucket.getAggregations().get("cusum")))));
            }
 *
                    assertThat(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))).value(), equalTo(0.0));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            assertThat(buckets.size(), equalTo(numValueBuckets));
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.mapper.DateFieldMapper;
 * under the License.
import org.apache.lucene.index.IndexReader;
                }
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
            }
                assertThat(sumBucketValue, notNullValue());
        int maxRandomValue = 20;
                assertThat(bucket, notNullValue());
 */
                Histogram.Bucket bucket = buckets.get(i);
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(VALUE_FIELD));
        CheckedConsumer<RandomIndexWriter, IOException> setup
/*
                    assertTrue(
                document.add(new NumericDocValuesField(VALUE_FIELD, fieldValue));
            double sum = 0.0;
            for (int i = 0; i < numValueBuckets; ++i) {
                int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
                final int bucket = (fieldValue / interval);
                int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
                        AggregationInspectionHelper.hasValue(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))))
        Query query = new MatchAllDocsQuery();
            double bucketSum = 0;
        aggBuilder.subAggregation(new AvgAggregationBuilder("the_avg").field(VALUE_FIELD));
    public void testMetric() throws IOException {
import org.opensearch.search.aggregations.metrics.InternalAvg;
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(HISTO_FIELD);
                sum += bucket.getDocCount();
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(VALUE_FIELD));
            Document document = new Document();
    }
                indexWriter.addDocument(document);
                document.clear();
import static org.hamcrest.Matchers.equalTo;
    }
                document.clear();
                setup.accept(indexWriter);
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        executeTestCase(query, aggBuilder, histogram -> {
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    private void executeTestCase(Query query, AggregationBuilder aggBuilder, Consumer<InternalAggregation> verify) throws IOException {
                assertThat(((InternalSimpleValue) (bucket.getAggregations().get("cusum"))).value(), equalTo(sum));
                valueCounts[bucket]++;
 */
                    );
                } else {
        AggregationBuilder aggBuilder,
        executeTestCase(query, aggBuilder, histogram -> {
 *
                assertThat(sum, notNullValue());
        });
        int minRandomValue = 0;
            for (int i = 0; i < numDocs; i++) {
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "sum"));
        Query query = new MatchAllDocsQuery();
            .interval(interval)
import java.util.function.Consumer;
        try (Directory directory = newDirectory()) {
}
                    assertThat(((InternalSimpleValue) (buckets.get(i).getAggregations().get("cusum"))).value(), equalTo(sum));
        "2017-01-09T17:09:50",
    public void testNoBuckets() throws IOException {
        "2017-01-10T22:55:46"
import org.apache.lucene.document.SortedNumericDocValuesField;
 */
import org.opensearch.search.aggregations.AggregatorTestCase;
    public void testDerivative() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        int numDocs = randomIntBetween(6, 20);
                valueCounts[bucket]++;
                assertThat(((InternalSimpleValue) (bucket.getAggregations().get("cusum"))).value(), equalTo(sum));
            int counter = 0;
import org.opensearch.search.aggregations.InternalAggregation;
    }
    private static final String HISTO_FIELD = "histo";
                }
                assertThat(cumulativeSumValue.value(), equalTo(sum));
            for (int i = 0; i < buckets.size(); i++) {
            }
        int minRandomValue = 0;
                InternalAggregation histogram;
 * software distributed under the License is distributed on an
        int maxRandomValue = 20;
        }
        int numDocs = randomIntBetween(6, 20);
        int interval = randomIntBetween(2, 5);
import org.apache.lucene.search.MatchNoDocsQuery;
            Document document = new Document();
 * You may obtain a copy of the License at
            Document document = new Document();
            for (Histogram.Bucket bucket : buckets) {
            assertEquals(10, ((Histogram) histogram).getBuckets().size());
 * KIND, either express or implied.  See the License for the
        Consumer<InternalAggregation> verify,
        }, indexWriter -> {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            }
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        Query query = new MatchAllDocsQuery();
                indexWriter.addDocument(document);
        });
            assertThat(buckets.size(), equalTo(numValueBuckets));
                document.add(new SortedNumericDocValuesField(HISTO_FIELD, instant));
        "2017-01-01T01:07:45",
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");
import java.io.IOException;
        int numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
                assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
                document.add(new NumericDocValuesField(VALUE_FIELD, fieldValue));
    );
        long[] valueCounts = new long[numValueBuckets];
        });
                indexWriter.addDocument(document);
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
                    indexWriter.commit();
                valueCounts[bucket]++;
                Histogram.Bucket bucket = buckets.get(i);
        int interval = randomIntBetween(2, 5);
public class CumulativeSumAggregatorTests extends AggregatorTestCase {
 *
                Sum sum = bucket.getAggregations().get("sum");
        Query query,
    }
 * SPDX-License-Identifier: Apache-2.0
        DateHistogramAggregationBuilder aggBuilder = new DateHistogramAggregationBuilder("histo");
        });
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "sum"));
                final int bucket = (fieldValue / interval);
    }
    public void testSimple() throws IOException {
            .extendedBounds(minRandomValue, maxRandomValue);
import org.opensearch.search.aggregations.AggregationBuilder;
        executeTestCase(query, aggBuilder, verify, indexWriter -> {
    private static final String VALUE_FIELD = "value_field";
            }
 * Licensed to Elasticsearch under one or more contributor
            double sum = 0.0;
        executeTestCase(query, aggBuilder, histogram -> {
                histogram = searchAndReduce(indexSearcher, query, aggBuilder, new MappedFieldType[] { fieldType, valueFieldType });
    private void executeTestCase(
                assertThat(cumulativeSumValue, notNullValue());
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "_count"));
            assertThat(buckets.size(), equalTo(0));
                final int bucket = (fieldValue / interval);
                assertThat(sumBucketValue.value(), equalTo(bucketSum));
 * specific language governing permissions and limitations
        aggBuilder.subAggregation(new CumulativeSumPipelineAggregationBuilder("cusum", "_count"));
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    public void testDocCount() throws IOException {
            assertEquals(10, ((Histogram) histogram).getBuckets().size());
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(VALUE_FIELD)
        "2017-01-02T03:43:34",
    }
                document.add(new NumericDocValuesField(VALUE_FIELD, datasetValues.get(counter)));
            }
    private static final List<String> datasetTimes = Arrays.asList(
            }
            }
                int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
        "2017-01-06T13:09:32",
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(VALUE_FIELD)
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(VALUE_FIELD).interval(interval);
                document.clear();
                sum += ((InternalAvg) (bucket.getAggregations().get("the_avg"))).value();
 * compatible open source license.
            .interval(interval)
        Query query = new MatchAllDocsQuery();
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(dateTime)).toInstant().toEpochMilli();
        "2017-01-08T16:14:34",
                document.add(new NumericDocValuesField(VALUE_FIELD, fieldValue));
        long[] valueCounts = new long[numValueBuckets];
 * this file be licensed under the Apache-2.0 license or a
        executeTestCase(query, aggBuilder, histogram -> {
        aggBuilder.calendarInterval(DateHistogramInterval.DAY).field(HISTO_FIELD);
import static org.hamcrest.core.IsNull.notNullValue;
package org.opensearch.search.aggregations.pipeline;
                long instant = asLong(date);
        int numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
        int numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
import java.util.Arrays;
                    assertTrue(
        int interval = randomIntBetween(2, 5);
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("the_deriv", "the_avg"));
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        });
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
import org.apache.lucene.index.DirectoryReader;
        aggBuilder.subAggregation(new AvgAggregationBuilder("the_avg").field(VALUE_FIELD));
            for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.document.Document;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.tests.index.RandomIndexWriter;
import java.util.List;
        });
     * First value from a derivative is null, so this makes sure the cusum can handle that
                verify.accept(histogram);
 * Unless required by applicable law or agreed to in writing,
            double sum = 1.0;
 * The OpenSearch Contributors require contributions made to
        aggBuilder.calendarInterval(DateHistogramInterval.DAY).field(HISTO_FIELD);
            for (int i = 0; i < numValueBuckets; ++i) {
            for (Histogram.Bucket bucket : buckets) {
            }
import org.apache.lucene.search.Query;
        aggBuilder.dateHistogramInterval(DateHistogramInterval.DAY).field(HISTO_FIELD);
