                    assertThat(docCountDeriv, nullValue());
            aggBuilder.subAggregation(
                }
        setupValueCounts();
            lastValueCount = thisValue;
                    assertThat(docCount2ndDeriv.value(), closeTo((secondDerivValueCounts[i - 2]), 0.00001));
        });
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("2nd_deriv", "deriv").unit("10ms"));
        });
                }
        try {
                    assertThat(docCountDeriv, nullValue());
                    if (Double.isNaN(expectedDerivative)) {
                Derivative docCountDeriv = bucket.getAggregations().get("deriv");
        }
        for (int i = 0; i < numValueBuckets; i++) {
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            assertThat(histogram, notNullValue());
    private static Long[] valueCounts_empty;
        }
                if (i == 0) {
                assertThat(propertiesKeys[i], equalTo((double) i * interval));
                }
                assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count"));
        });
                double thisSumValue = sum.value();
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
import org.opensearch.index.mapper.NumberFieldMapper;
        secondDerivValueCounts = new long[numSecondDerivValueBuckets];
        Query query = new MatchAllDocsQuery();
    }
 * Licensed to Elasticsearch under one or more contributor
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            }
            for (int i = 0; i < numValueBuckets; ++i) {
                } else {
                if (i == 0) {
                expectedSumPreviousBucket = expectedSum;
            Document document = new Document();
            .interval(1)
            }
                indexWriter.commit();
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count").unit("1ms"));
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
            }
    public void testSingleValueAggDerivativeWithGaps_random() throws IOException {
        Query query = new MatchAllDocsQuery();
            assertThat(buckets.size(), equalTo(numValueBuckets));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.search.aggregations.metrics.Sum;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
                    document.clear();
        BucketHelpers.GapPolicy gapPolicy = randomFrom(GapPolicy.values());
        numDocsEmptyIdx_rnd = 0L;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            assertThat(histogram.getName(), equalTo("histo"));
                Histogram.Bucket bucket = buckets.get(i);
                Histogram.Bucket bucket = buckets.get(i);
        }
        }
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
 * ownership. Elasticsearch licenses this file to you under
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
            .interval(interval)
        // setup for index with empty buckets
            assertThat(histogram.getName(), equalTo("histo"));
            assertThat(histogram.getName(), equalTo("histo"));
                if (frequently()) {
    private static int interval = 5;
                }
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
    public void testSingleValuedField_normalised() throws IOException {
            indexWriter.commit();
        });
    }
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
import org.opensearch.search.aggregations.support.AggregationPath;
            }
                        assertThat(sumDeriv.value(), equalTo(expectedDerivative));
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            assertThat(buckets.size(), equalTo(valueCounts_empty_rnd.length));
import org.opensearch.common.CheckedConsumer;
                if (i == 0) {
                    document.clear();
                assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
                if (i > 0) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(histogram, notNullValue());
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
    public void testDocCountDerivativeWithGaps() throws IOException {
                    numDocsEmptyIdx_rnd++;
            new DerivativePipelineAggregationBuilder("deriv", "_count").gapPolicy(randomFrom(BucketHelpers.GapPolicy.values()))
                } else {
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histogram).getProperty("_count");
                    indexWriter.addDocument(document);
                        indexWriter.commit();
                }
            assertThat(buckets.size(), equalTo(numValueBuckets));
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) histogram).getProperty("_key");
    }
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
                    assertThat(docCountDeriv, notNullValue());
    private void executeTestCase(Query query, AggregationBuilder aggBuilder, Consumer<InternalAggregation> verify) throws IOException {
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                    throw e;
            .interval(interval);
        aggBuilder.subAggregation(new StatsAggregationBuilder("stats").field(SINGLE_VALUED_FIELD_NAME));
        });
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histogram).getProperty("_count");
        Query query = new MatchAllDocsQuery();
 */
        }, indexWriter -> {
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            Document document = new Document();
                    assertThat(docCountDeriv, notNullValue());
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
        aggBuilder.subAggregation(
        interval = 5;
            indexWriter.commit();
        }
                InternalAggregation histogram = searchAndReduce(indexSearcher, query, aggBuilder, fieldType, valueFieldType);
            .interval(interval);
    }
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
                    long sumDerivValue = expectedSum - expectedSumPreviousBucket;
            aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
package org.opensearch.search.aggregations.pipeline;
                Sum sum = bucket.getAggregations().get("sum");
                    if (Double.isNaN(expectedDerivative)) {
            }
                valueCounts_empty_rnd[i] = (long) randomIntBetween(1, 10);
    private static long[] valueCounts;
        });
                    firstDerivValueCounts_empty_rnd[i] = (double) valueCounts_empty_rnd[i] - valueCounts_empty_rnd[i - 1];
                long expectedSum = valueCounts[i] * (i * interval);
                    document.clear();
                if (bucket.getDocCount() == 0) {
                }
    public void testSingleValueAggDerivativeWithGaps_insertZeros() throws IOException {
                if (firstDerivValueCounts_empty[i] == null) {
                    assertThat(sumDeriv, notNullValue());
                } else {
        setupValueCounts();
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        executeTestCase(query, aggBuilder, histogram -> {
                for (int docs = 0; docs < valueCounts_empty_rnd[i]; docs++) {
                    assertThat(sumDeriv, nullValue());
        setupValueCounts();
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
                    }
                    assertThat(docCount2ndDeriv, nullValue());
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum").gapPolicy(gapPolicy));
            assertThat(buckets.size(), equalTo(0));
        Query query = new MatchAllDocsQuery();
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                )
     * test first and second derivative on the sing
        firstDerivValueCounts = new long[numFirstDerivValueBuckets];
            }
            .extendedBounds(0L, numBuckets_empty_rnd - 1);
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "movavg"));
                    assertThat(docCount2ndDeriv.normalizedValue(), closeTo((double) (secondDerivValueCounts[i - 2]) * 2, 0.00001));
            assertThat(histogram.getName(), equalTo("histo"));
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(SINGLE_VALUED_FIELD_NAME);
        valueCounts_empty_rnd = new Long[numBuckets_empty_rnd];
            assertThat(buckets.size(), equalTo(numValueBuckets));
            double lastSumValue = Double.NaN;
            assertThat(histogram.getName(), equalTo("histo"));
                Derivative docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");
            }
                long diff = thisValue - lastValueCount;
                }
            for (int i = 0; i < valueCounts_empty.length; i++) {
import static org.hamcrest.core.IsNull.nullValue;
            assertThat(histogram, notNullValue());
        });
                    }
            Throwable cause = ExceptionsHelper.unwrapCause(e);
                    assertThat(sumDeriv, notNullValue());
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
                Sum sum = bucket.getAggregations().get("sum");
                    indexWriter.addDocument(document);
            indexWriter.addDocument(document);
     */
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum").gapPolicy(GapPolicy.INSERT_ZEROS));
                    indexWriter.addDocument(document);
    public void testMultiValueAggDerivative() throws IOException {
                assertThat(sum, notNullValue());
                }
    private void setupValueCounts() {
 * the Apache License, Version 2.0 (the "License"); you may
        setupValueCounts();
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value_field", NumberFieldMapper.NumberType.LONG);
    private static Double[] firstDerivValueCounts_empty_rnd;
            } else if (!(cause instanceof IllegalArgumentException)) {
                    );
                    if (frequently()) {
 *
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
                }
                    thisSumValue = Double.NaN;
    }
        });
                    assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
                } else {
 */
                    indexWriter.addDocument(document);
                }
        Query query = new MatchAllDocsQuery();
            assertThat(histogram, notNullValue());
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
import org.opensearch.search.aggregations.AggregationBuilder;
                if (firstDerivValueCounts_empty[i] == null) {
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
                        ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
import org.apache.lucene.tests.index.RandomIndexWriter;
                            AggregationPath.parse("deriv.value").getPathElementsAsStringList()
                } else {
                if (i > 0) {
            Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) histogram).getProperty("stats.sum");
                }
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx_rnd));
                }
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
            indexWriter.commit();
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
            }
            if (cause == null) {
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count"));
                Histogram.Bucket bucket = buckets.get(i);
            assertThat(histogram.getName(), equalTo("histo"));
                throw e;
            for (int i = 0; i < valueCounts_empty.length; i++) {
    private static int numFirstDerivValueBuckets;
import org.opensearch.index.mapper.DateFieldMapper;
        firstDerivValueCounts_empty_rnd = new Double[numBuckets_empty_rnd];
                    indexWriter.commit();
import org.opensearch.index.mapper.MappedFieldType;
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "stats.sum"));
        });
            Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
            .extendedBounds(0L, (long) numBuckets_empty_rnd - 1);
                if (bucket.getDocCount() == 0) {
                double thisSumValue = sum.value();
import static org.hamcrest.number.IsCloseTo.closeTo;
 *
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            Document document = new Document();
                lastSumValue = thisSumValue;
                } else {
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));
                        assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
            }
                    document.clear();
            fail("Expected an Exception but didn't get one");
                Sum sum = bucket.getAggregations().get("sum");
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
        executeTestCase(query, aggBuilder, histogram -> {
                indexWriter.commit();
            }
import org.apache.lucene.store.Directory;
            assertThat(histogram, notNullValue());
            if (lastValueCount != null) {
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count"));
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(histogram, notNullValue());
        setupValueCounts();
                if (randomBoolean()) valueCounts_empty_rnd[i] = 0L;
                } else {
                    assertThat(docCountDeriv, nullValue());
        }, indexWriter -> {
                    assertThat(docCount2ndDeriv, notNullValue());
            for (int i = 0; i < numValueBuckets; i++) {
                if (i > 0) {
                }
 * this work for additional information regarding copyright
                }
            }
                }
                    assertThat(docCount2ndDeriv.value(), equalTo((double) secondDerivValueCounts[i - 2]));
        }, indexWriter -> {
        });
    }
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
                Histogram.Bucket bucket = buckets.get(i);
            } else if (cause instanceof SearchPhaseExecutionException) {
            for (int i = 0; i < valueCounts_empty.length; i++) {
                    } else {
                assertThat(stats, notNullValue());
                    numDocsEmptyIdx++;
    }
                indexWriter.commit();
/*
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                if (i > 1) {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        numValueBuckets = randomIntBetween(6, 80);
                Histogram.Bucket bucket = buckets.get(i);
                            "histo",
/*
                    firstDerivValueCounts_empty_rnd[i] = (double) valueCounts_empty_rnd[i] - valueCounts_empty_rnd[i - 1];
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
                    new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME)
        Consumer<InternalAggregation> verify,
            }
            // overwritten
                    if (i != 1 || i != 3) {
        Query query = new MatchAllDocsQuery();
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx_rnd));
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        for (int i = 0; i < numFirstDerivValueBuckets; i++) {
import java.io.IOException;
        executeTestCase(query, aggBuilder, histogram -> {
    private static long[] secondDerivValueCounts;
                if (randomBoolean()) valueCounts_empty_rnd[i] = 0L;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                        assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
        executeTestCase(query, aggBuilder, histogram -> {
                for (int docs = 0; docs < valueCounts[i]; docs++) {
            aggBuilder.subAggregation(new AvgAggregationBuilder("avg").field("value"));
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("2nd_deriv", "deriv"));
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
            for (int i = 0; i < numValueBuckets; ++i) {
                }
    public void testUnmapped() throws IOException {
        assertThat(msg, bucket, notNullValue());
    private static long numDocsEmptyIdx_rnd;
            count += bucket.getDocCount();
            double lastSumValue = Double.NaN;
            for (int i = 0; i < numValueBuckets; ++i) {
                    assertThat(docCountDeriv, nullValue());
 * not use this file except in compliance with the License.
    private static int numSecondDerivValueBuckets;
    private void checkBucketKeyAndDocCount(
            for (int i = 0; i < valueCounts_empty.length; i++) {
 * KIND, either express or implied.  See the License for the
        }
        });
        setupValueCounts();
                }
            }
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
    ) throws IOException {
        }
        setupValueCounts();
            aggBuilder.subAggregation(
                } else {
            Document document = new Document();
            lastFirstDerivativeValueCount = thisFirstDerivativeValue;
            }
        setupValueCounts();
                    assertThat(
                    indexWriter.addDocument(document);
                assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
            assertThat(histogram.getName(), equalTo("histo"));
    private static int numValueBuckets;
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        executeTestCase(query, aggBuilder, histogram -> {
    private void executeTestCase(
                }
            );
            executeTestCase(query, aggBuilder, history -> {});
            Document document = new Document();
 */
                    assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty_rnd[i]));
                if (!(rootCause instanceof IllegalArgumentException)) {
    private static long numDocsEmptyIdx;
    ) {
                lastSumValue = thisSumValue;
        firstDerivValueCounts_empty = new Double[] { null, 0d, 1d, -2d, 2d, 0d, -2d, 0d, 0d, 3d, -1d, -1d };
            .interval(1)
                Histogram.Bucket bucket = buckets.get(i);
    }
        numDocsEmptyIdx = 0L;
 * under the License.
                    );
            .interval(interval);
                            AggregationPath.parse("deriv.value").getPathElementsAsStringList()
                    thisSumValue = 0;
                throw e;
        numBuckets_empty_rnd = randomIntBetween(20, 100);
        setupValueCounts();
            assertThat(histogram.getName(), equalTo("histo"));
                }
                secondDerivValueCounts[i - 1] = diff;
                    indexWriter.addDocument(document);
        }, indexWriter -> {
        for (Histogram.Bucket bucket : buckets) {
                        equalTo((double) sumDerivValue)
        executeTestCase(query, aggBuilder, verify, indexWriter -> {
        return count;
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));
                    assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));
    }
            assertThat(histogram, notNullValue());
                    document.add(new NumericDocValuesField("tick", i));
 * SPDX-License-Identifier: Apache-2.0
        Long lastValueCount = null;
                        equalTo((double) sumDerivValue)
                if (firstDerivValueCounts_empty_rnd[i] == null) {
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));
    private static Double[] firstDerivValueCounts_empty;
            }
                        document.add(new NumericDocValuesField("value", i));
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));
        }, indexWriter -> {
    }
                }
            for (int i = 0; i < valueCounts_empty_rnd.length; i++) {
                }
                    assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
                    document.clear();
        Query query = new MatchAllDocsQuery();
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
                Histogram.Bucket bucket = buckets.get(i);
                    assertThat(docCountDeriv, nullValue());
            if (lastFirstDerivativeValueCount != null) {
                assertThat(stats.getSum(), equalTo((double) expectedSum));
        executeTestCase(query, aggBuilder, histogram -> {
            for (int i = 0; i < valueCounts_empty.length; i++) {
        firstDerivValueCounts_empty_rnd[0] = null;
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
                    assertThat(sumDeriv, nullValue());
 * specific language governing permissions and limitations
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
        }, indexWriter -> {
 * Unless required by applicable law or agreed to in writing,
                    }
import org.apache.lucene.document.NumericDocValuesField;
                    } else {
            }
import org.apache.lucene.search.Query;
    private static long[] firstDerivValueCounts;
        Long lastFirstDerivativeValueCount = null;
            .interval(interval);
import static org.hamcrest.core.IsNull.notNullValue;
                assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
            long thisValue = valueCounts[i];
        numSecondDerivValueBuckets = numFirstDerivValueBuckets - 1;
                    assertThat(docCountDeriv.value(), equalTo((double) firstDerivValueCounts[i - 1]));
            indexWriter.commit();
            Document document = new Document();
                lastSumValue = thisSumValue;
        final String msg,
public class DerivativeAggregatorTests extends AggregatorTestCase {
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field("tick").interval(1);
                }
                } else {
                } else {
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
 * Modifications Copyright OpenSearch Contributors. See
                long expectedSum = valueCounts[i] * (i * interval);
                setup.accept(indexWriter);
                        ),
            Document document = new Document();
}
                expectedSumPreviousBucket = expectedSum;
    public void testDocCountDerivative() throws IOException {
    }
            Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
                Throwable rootCause = spee.getRootCause();
import org.apache.lucene.document.Document;
        final Histogram.Bucket bucket,
            assertThat(histogram.getName(), equalTo("histo"));
            for (int i = 0; i < valueCounts_empty.length; i++) {
 * You may obtain a copy of the License at
                }
                if (i > 0) {
        numFirstDerivValueBuckets = numValueBuckets - 1;
        setupValueCounts();
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
        Query query = new MatchAllDocsQuery();
                    assertThat(docCount2ndDeriv, nullValue());
        CheckedConsumer<RandomIndexWriter, IOException> setup
                    assertThat(sumDeriv, nullValue());
            for (int i = 0; i < valueCounts_empty.length; i++) {
                Histogram.Bucket bucket = buckets.get(i);
import org.opensearch.search.aggregations.AggregatorTestCase;
                firstDerivValueCounts[i - 1] = diff;
        final long expectedKey,
            double lastSumValue = Double.NaN;
            for (int i = 0; i < numBuckets_empty_rnd; i++) {
            for (int i = 0; i < numValueBuckets; ++i) {
        try (Directory directory = newDirectory()) {
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum"));
import java.util.List;
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));
                    assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
            .minDocCount(0);
            }
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
            }
            Query query = new MatchAllDocsQuery();
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
                    assertThat(sumDeriv, nullValue());
        Query query = new MatchAllDocsQuery();
            assertThat(histogram, notNullValue());
                }
    private static Long[] valueCounts_empty_rnd;
                } else {
            assertThat(buckets.size(), equalTo(numValueBuckets));
                }
                valueCounts_empty_rnd[i] = (long) randomIntBetween(1, 10);
    private Long getTotalDocCountAcrossBuckets(List<? extends Histogram.Bucket> buckets) {
     * test first and second derivative on the sing
            Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) histogram).getProperty("sum.value");
                }
        );
        Long count = 0L;
    }
 * The OpenSearch Contributors require contributions made to
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum"));
                Histogram.Bucket bucket = buckets.get(i);
                for (int i = 0; i < 10; i++) {
        try (Directory directory = newDirectory()) {
                if (i > 1) {
                    numDocsEmptyIdx++;
    }
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            }
                    document.clear();
    public void testSingleValueAggDerivative_invalidPath() throws IOException {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
                    assertThat(sumDeriv, nullValue());
                    assertThat(
        valueCounts = new long[numValueBuckets];
        AggregationBuilder aggBuilder,
            for (int i = 0; i < valueCounts_empty_rnd.length; i++) {
            );
                checkBucketKeyAndDocCount("InternalBucket " + i + ": ", bucket, i, valueCounts_empty[i]);
                    document.clear();
                            "histo",
    public void testSingleValueAggDerivativeWithGaps() throws Exception {
                        assertThat(sumDeriv.value(), equalTo(expectedDerivative));
                long diff = thisFirstDerivativeValue - lastFirstDerivativeValueCount;
    private static int numBuckets_empty_rnd;
                SimpleValue docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");
/*
import org.apache.lucene.search.IndexSearcher;
                    }
import static org.hamcrest.core.IsEqual.equalTo;
            }
import org.opensearch.search.aggregations.metrics.Stats;
                    numDocsEmptyIdx++;
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        for (int i = 0; i < numValueBuckets; i++) {
        aggBuilder.subAggregation(
    }
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            assertThat(histogram.getName(), equalTo("histo"));
import org.apache.lucene.index.DirectoryReader;
        executeTestCase(query, aggBuilder, histogram -> {
        setupValueCounts();
     */
        assertThat(msg + " key", ((Number) bucket.getKey()).longValue(), equalTo(expectedKey));
                    double expectedDerivative = thisSumValue - lastSumValue;
                        ),
            indexWriter.commit();
                    thisSumValue = gapPolicy == GapPolicy.INSERT_ZEROS ? 0 : Double.NaN;
                // make approximately half of the buckets empty
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
    // expected bucket values for random setup with gaps
            assertThat(histogram, notNullValue());
        // randomized setup for index with empty buckets
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
            new DerivativePipelineAggregationBuilder("deriv", "_count").gapPolicy(BucketHelpers.GapPolicy.INSERT_ZEROS)
                Histogram.Bucket bucket = buckets.get(i);
                if (i > 0) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        executeTestCase(query, aggBuilder, histogram -> {
 * software distributed under the License is distributed on an
        } catch (Exception e) {
            assertThat(histogram.getName(), equalTo("histo"));
        executeTestCase(query, aggBuilder, histogram -> {
            aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "filters>get>sum"));
        executeTestCase(query, aggBuilder, histogram -> {
            }
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                    assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));
            for (int i = 0; i < numBuckets_empty_rnd; i++) {
                assertThat(sum.getValue(), equalTo((double) expectedSum));
                } else {
            assertThat(histogram, notNullValue());
 * compatible open source license.
                new FiltersAggregationBuilder("filters", QueryBuilders.termQuery("tag", "foo")).subAggregation(
        }, indexWriter -> {
                        ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
    public void testDocCountDerivativeWithGaps_random() throws IOException {
                new MovAvgPipelineAggregationBuilder("movavg", "avg").modelBuilder(new SimpleModel.SimpleModelBuilder()).window(3)
            assertThat(histogram, notNullValue());
                    document.clear();
                assertThat(propertiesKeys[i], equalTo((double) i * interval));
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                    indexWriter.addDocument(document);
            for (int i = 0; i < valueCounts_empty.length; i++) {
import org.apache.lucene.index.IndexReader;
    }
                // make approximately half of the buckets empty
                    double expectedDerivative = thisSumValue - lastSumValue;
        });
                for (int docs = 0; docs < valueCounts_empty_rnd[i]; docs++) {
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) histogram).getProperty("_key");
    public void testSingleValueAggDerivative() throws IOException {
                    assertThat(docCount2ndDeriv, notNullValue());
            long thisFirstDerivativeValue = firstDerivValueCounts[i];
                    indexWriter.addDocument(document);
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
                if (i > 0) {
            valueCounts[i] = randomIntBetween(1, 20);
                double thisSumValue = sum.value();
            }
import org.opensearch.action.search.SearchPhaseExecutionException;
 * GitHub history for details.
                }
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));
                Stats stats = bucket.getAggregations().get("stats");
 *
            Query query = new MatchAllDocsQuery();
                    numDocsEmptyIdx_rnd++;
    /**
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i * interval));
import org.opensearch.index.query.QueryBuilders;
        );
            assertThat(buckets.size(), equalTo(numBuckets_empty_rnd));
    public void testDocCountDerivativeWithGaps_insertZeros() throws IOException {
            assertThat(histogram.getName(), equalTo("histo"));
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            assertThat(histogram, notNullValue());
            // overwritten
                    long sumDerivValue = expectedSum - expectedSumPreviousBucket;
            Document document = new Document();
        Query query = new MatchAllDocsQuery();
    }
                Document document = new Document();
                    double expectedDerivative = thisSumValue - lastSumValue;
                    assertThat(docCountDeriv.normalizedValue(), closeTo((double) (firstDerivValueCounts[i - 1]) / 5, 0.00001));
        executeTestCase(query, aggBuilder, histogram -> {
                if (bucket.getDocCount() == 0) {
                    assertThat(docCountDeriv.value(), closeTo((firstDerivValueCounts[i - 1]), 0.00001));
                searchAndReduce(indexSearcher, query, aggBuilder);
                verify.accept(histogram);
        setupValueCounts();
                    numDocsEmptyIdx++;
        Query query = new MatchAllDocsQuery();
import org.opensearch.ExceptionsHelper;
            }
                Sum sum = bucket.getAggregations().get("sum");
        valueCounts_empty = new Long[] { 1L, 1L, 2L, 0L, 2L, 2L, 0L, 0L, 0L, 3L, 2L, 1L };
import java.util.function.Consumer;
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
        Query query,
import org.opensearch.search.aggregations.InternalAggregation;
        final long expectedDocCount
    /**
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
    public void testAvgMovavgDerivNPE() throws IOException {
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
            }
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
import org.apache.lucene.search.MatchAllDocsQuery;
        assertThat(msg + " docCount", bucket.getDocCount(), equalTo(expectedDocCount));
