/*
        executeTestCase(query, aggBuilder, histogram -> {
        aggBuilder.subAggregation(
        CheckedConsumer<RandomIndexWriter, IOException> setup
                    if (Double.isNaN(expectedDerivative)) {
                }  
            } else if (cause instanceof SearchPhaseExecutionException) {
                new FiltersAggregationBuilder("filters", QueryBuilders.termQuery("tag", "foo")).subAggregation(
            Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
                assertThat(propertiesKeys[i], equalTo((double) i * interval));  
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
            assertThat(histogram.getName(), equalTo("histo"));  
                // make approximately half of the buckets empty
                    numDocsEmptyIdx++;
    public void testAvgMovavgDerivNPE() throws IOException {
        );  
                    assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
            aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                Histogram.Bucket bucket = buckets.get(i);
    }
                if (i == 0) {  
                    assertThat(
            Document document = new Document();
            Document document = new Document();
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
                for (int docs = 0; docs < valueCounts_empty_rnd[i]; docs++) {  
import org.apache.lucene.index.DirectoryReader;  
                        ),
    }
            Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) histogram).getProperty("stats.sum");  
import org.apache.lucene.search.Query;
                DateFieldMapper.DateFieldType fieldType = new DateFieldMapper.DateFieldType(SINGLE_VALUED_FIELD_NAME);  
                    indexWriter.addDocument(document);
                    assertThat(docCountDeriv, nullValue());
                    assertThat(docCountDeriv, nullValue());
    }
            for (int i = 0; i < valueCounts_empty.length; i++) {  
        Query query = new MatchAllDocsQuery();
                        assertThat(sumDeriv.value(), equalTo(expectedDerivative));
            assertThat(histogram, notNullValue());  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        final String msg,
            indexWriter.commit();
                }
                    new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME)
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
            .minDocCount(0);
 * The OpenSearch Contributors require contributions made to  
    public void testSingleValueAggDerivative_invalidPath() throws IOException {
    }
            }  
            assertThat(histogram.getName(), equalTo("histo"));  
    }
        final long expectedDocCount
                    document.clear();
/*  
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)  
        }
                searchAndReduce(indexSearcher, query, aggBuilder);
                }
    public void testDocCountDerivative() throws IOException {  
            Query query = new MatchAllDocsQuery();
                    numDocsEmptyIdx++;
    private void setupValueCounts() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    indexWriter.addDocument(document);  
     * test first and second derivative on the sing  
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
import org.opensearch.index.mapper.MappedFieldType;
        try {  
        for (int i = 0; i < numFirstDerivValueBuckets; i++) {
    private static Long[] valueCounts_empty;
            assertThat(buckets.size(), equalTo(numValueBuckets));  
            aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "movavg"));  
        valueCounts_empty = new Long[] { 1L, 1L, 2L, 0L, 2L, 2L, 0L, 0L, 0L, 3L, 2L, 1L };
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));  
            Throwable cause = ExceptionsHelper.unwrapCause(e);
                }
            }
 * license agreements. See the NOTICE file distributed with
                if (i > 1) {
    private static long[] firstDerivValueCounts;
            }
        Query query = new MatchAllDocsQuery();
        setupValueCounts();  
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
            executeTestCase(query, aggBuilder, history -> {});
    }  
            assertThat(histogram.getName(), equalTo("histo"));
    // expected bucket values for random setup with gaps
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            count += bucket.getDocCount();
 */
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
        numValueBuckets = randomIntBetween(6, 80);  
 */  
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i * interval));
            indexWriter.commit();  
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {  
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");  
            }  
                }
        aggBuilder.subAggregation(
                Document document = new Document();
                    document.clear();  
            .extendedBounds(0L, (long) numBuckets_empty_rnd - 1);
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            for (int i = 0; i < valueCounts_empty_rnd.length; i++) {  
        executeTestCase(query, aggBuilder, histogram -> {
/*  
    public void testSingleValueAggDerivativeWithGaps_insertZeros() throws IOException {  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                    firstDerivValueCounts_empty_rnd[i] = (double) valueCounts_empty_rnd[i] - valueCounts_empty_rnd[i - 1];
            }
                // make approximately half of the buckets empty
        valueCounts_empty_rnd = new Long[numBuckets_empty_rnd];
            for (int i = 0; i < numBuckets_empty_rnd; i++) {  
                    document.clear();
                Histogram.Bucket bucket = buckets.get(i);
            for (int i = 0; i < valueCounts_empty.length; i++) {  
                    document.clear();
                }  
                secondDerivValueCounts[i - 1] = diff;
 * software distributed under the License is distributed on an
            );
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum"));
        return count;  
            valueCounts[i] = randomIntBetween(1, 20);
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("2nd_deriv", "deriv"));  
                    assertThat(docCount2ndDeriv.value(), closeTo((secondDerivValueCounts[i - 2]), 0.00001));
            assertThat(histogram, notNullValue());
                lastSumValue = thisSumValue;
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                    document.clear();
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field("tick").interval(1);
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) histogram).getProperty("_key");  
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
        final long expectedKey,  
            long thisFirstDerivativeValue = firstDerivValueCounts[i];
        }, indexWriter -> {
        // setup for index with empty buckets
                Sum sum = bucket.getAggregations().get("sum");  
            }
        for (Histogram.Bucket bucket : buckets) {  
            assertThat(histogram, notNullValue());  
                assertThat(propertiesKeys[i], equalTo((double) i * interval));
import org.apache.lucene.document.NumericDocValuesField;
        Long count = 0L;
                throw e;
                assertThat(stats.getSum(), equalTo((double) expectedSum));
                    assertThat(docCountDeriv.normalizedValue(), closeTo((double) (firstDerivValueCounts[i - 1]) / 5, 0.00001));  
     * test first and second derivative on the sing
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
 * this work for additional information regarding copyright
        setupValueCounts();
                    throw e;
 */  
                        assertThat(sumDeriv.value(), equalTo(expectedDerivative));
                    } else {  
                    indexWriter.commit();  
                }
        numFirstDerivValueBuckets = numValueBuckets - 1;
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);  
            }  
                if (i > 0) {  
                    assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
                lastSumValue = thisSumValue;
            Object[] propertiesKeys = (Object[]) ((InternalAggregation) histogram).getProperty("_key");
                assertThat(stats, notNullValue());
    public void testSingleValueAggDerivativeWithGaps() throws Exception {  
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");  
        }, indexWriter -> {  
 *
    private static Double[] firstDerivValueCounts_empty;  
                    assertThat(sumDeriv, nullValue());
                MappedFieldType valueFieldType = new NumberFieldMapper.NumberFieldType("value_field", NumberFieldMapper.NumberType.LONG);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
 * KIND, either express or implied.  See the License for the
                }  
        }
    private static int numValueBuckets;  
                    assertThat(sumDeriv, nullValue());
                    thisSumValue = gapPolicy == GapPolicy.INSERT_ZEROS ? 0 : Double.NaN;  
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("2nd_deriv", "deriv").unit("10ms"));  
        Query query = new MatchAllDocsQuery();
                    }
                    indexWriter.addDocument(document);
        });
            assertThat(histogram, notNullValue());  
                double thisSumValue = sum.value();
        assertThat(msg + " key", ((Number) bucket.getKey()).longValue(), equalTo(expectedKey));
                } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Histogram.Bucket bucket = buckets.get(i);  
        Long lastValueCount = null;  
        }
        AggregationBuilder aggBuilder,  
        executeTestCase(query, aggBuilder, histogram -> {
                            "histo",  
            indexWriter.commit();
                    assertThat(docCountDeriv.value(), closeTo((firstDerivValueCounts[i - 1]), 0.00001));
            assertThat(histogram.getName(), equalTo("histo"));  
        numDocsEmptyIdx_rnd = 0L;
            assertThat(histogram, notNullValue());
        executeTestCase(query, aggBuilder, histogram -> {
            }
                    }  
    ) throws IOException {  
                if (!(rootCause instanceof IllegalArgumentException)) {
    private static long numDocsEmptyIdx_rnd;  
                if (i > 0) {  
            assertThat(histogram.getName(), equalTo("histo"));
        }, indexWriter -> {
                if (i > 1) {
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histogram).getProperty("_count");
            assertThat(histogram, notNullValue());  
            }  
            assertThat(histogram.getName(), equalTo("histo"));
                            "histo",
                    if (i != 1 || i != 3) {
                }
                }  
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)  
    public void testMultiValueAggDerivative() throws IOException {  
import org.opensearch.search.aggregations.metrics.Sum;  
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
    private static Long[] valueCounts_empty_rnd;
        setupValueCounts();  
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            indexWriter.commit();
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
                    document.clear();  
        setupValueCounts();  
        executeTestCase(query, aggBuilder, histogram -> {
            .interval(1)
                    double expectedDerivative = thisSumValue - lastSumValue;  
        Query query = new MatchAllDocsQuery();
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
            }  
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
import org.opensearch.search.aggregations.metrics.Stats;
    private static int interval = 5;
    /**
            double lastSumValue = Double.NaN;
        executeTestCase(query, aggBuilder, histogram -> {
        }
                    numDocsEmptyIdx_rnd++;
        Query query = new MatchAllDocsQuery();
                } else {
            lastValueCount = thisValue;
    public void testDocCountDerivativeWithGaps_insertZeros() throws IOException {  
                verify.accept(histogram);
                for (int docs = 0; docs < valueCounts[i]; docs++) {
        final Histogram.Bucket bucket,
    private static long numDocsEmptyIdx;
                        ),
        Query query = new MatchAllDocsQuery();
    private static Double[] firstDerivValueCounts_empty_rnd;
                Histogram.Bucket bucket = buckets.get(i);
        }, indexWriter -> {
                    assertThat(docCount2ndDeriv, nullValue());
                indexWriter.commit();  
        });  
            .interval(interval);
        numSecondDerivValueBuckets = numFirstDerivValueBuckets - 1;
 *  
            for (int i = 0; i < valueCounts_empty.length; i++) {  
import org.opensearch.search.aggregations.support.AggregationPath;  
            aggBuilder.subAggregation(  
                if (frequently()) {
        interval = 5;
                double thisSumValue = sum.value();
            assertThat(histogram, notNullValue());
                indexWriter.commit();
        numDocsEmptyIdx = 0L;  
    public void testSingleValueAggDerivativeWithGaps_random() throws IOException {
    }
}
        executeTestCase(query, aggBuilder, histogram -> {
                for (int i = 0; i < 10; i++) {  
        });
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
                    assertThat(docCountDeriv, nullValue());
                            AggregationPath.parse("deriv.value").getPathElementsAsStringList()
    private void checkBucketKeyAndDocCount(  
            .interval(1)  
        try (Directory directory = newDirectory()) {
            } else if (!(cause instanceof IllegalArgumentException)) {
        BucketHelpers.GapPolicy gapPolicy = randomFrom(GapPolicy.values());  
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
                Histogram.Bucket bucket = buckets.get(i);
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
            }
        for (int i = 0; i < numValueBuckets; i++) {
    private void executeTestCase(
                assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
        });
                    indexWriter.addDocument(document);  
        executeTestCase(query, aggBuilder, verify, indexWriter -> {
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();  
            for (int i = 0; i < valueCounts_empty.length; i++) {
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
            }
                    long sumDerivValue = expectedSum - expectedSumPreviousBucket;
                long diff = thisFirstDerivativeValue - lastFirstDerivativeValueCount;
                SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");  
public class DerivativeAggregatorTests extends AggregatorTestCase {
            assertThat(histogram.getName(), equalTo("histo"));
        setupValueCounts();
        }, indexWriter -> {  
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(histogram.getName(), equalTo("histo"));
            assertThat(buckets.size(), equalTo(numValueBuckets));
                }
        });
                        indexWriter.commit();
                firstDerivValueCounts[i - 1] = diff;
                assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
            assertThat(buckets.size(), equalTo(valueCounts_empty_rnd.length));
            .interval(interval);
                        ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
                expectedSumPreviousBucket = expectedSum;
            }  
                    );
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
                }
                }
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));  
                    indexWriter.addDocument(document);  
                            AggregationPath.parse("deriv.value").getPathElementsAsStringList()  
import org.opensearch.search.aggregations.AggregationBuilder;
    }  
        executeTestCase(query, aggBuilder, histogram -> {
                    assertThat(  
                    assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
                } else {
            }  
                if (i > 0) {
    private static long[] valueCounts;  
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);  
                indexWriter.commit();  
            for (int i = 0; i < valueCounts_empty.length; i++) {
                    numDocsEmptyIdx++;
        Consumer<InternalAggregation> verify,
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
                }
 * SPDX-License-Identifier: Apache-2.0
        });
                Histogram.Bucket bucket = buckets.get(i);  
                if (bucket.getDocCount() == 0) {
                lastSumValue = thisSumValue;  
            if (cause == null) {
 * specific language governing permissions and limitations
                throw e;  
                for (int docs = 0; docs < valueCounts_empty_rnd[i]; docs++) {
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
        Query query = new MatchAllDocsQuery();  
                Derivative docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");
        });  
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
                    document.clear();
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "stats.sum"));  
                Histogram.Bucket bucket = buckets.get(i);
                checkBucketKeyAndDocCount("InternalBucket " + i + ": ", bucket, i, valueCounts_empty[i]);
                if (i == 0) {  
                    assertThat(docCountDeriv, notNullValue());
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    assertThat(docCount2ndDeriv, notNullValue());  
                new MovAvgPipelineAggregationBuilder("movavg", "avg").modelBuilder(new SimpleModel.SimpleModelBuilder()).window(3)
        Long lastFirstDerivativeValueCount = null;  
    }
            Document document = new Document();
 * Unless required by applicable law or agreed to in writing,
        // randomized setup for index with empty buckets
                    assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));  
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            assertThat(histogram, notNullValue());
                }  
                if (randomBoolean()) valueCounts_empty_rnd[i] = 0L;  
                    );  
                Histogram.Bucket bucket = buckets.get(i);
                        assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
            new DerivativePipelineAggregationBuilder("deriv", "_count").gapPolicy(randomFrom(BucketHelpers.GapPolicy.values()))
        aggBuilder.subAggregation(new SumAggregationBuilder("sum").field(SINGLE_VALUED_FIELD_NAME));
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));
import java.util.List;  
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum").gapPolicy(GapPolicy.INSERT_ZEROS));
                    numDocsEmptyIdx_rnd++;
import org.apache.lucene.store.Directory;
    }
                assertThat(sum.getValue(), equalTo((double) expectedSum));  
package org.opensearch.search.aggregations.pipeline;
                    assertThat(docCountDeriv.value(), equalTo((double) firstDerivValueCounts[i - 1]));
import static org.hamcrest.core.IsEqual.equalTo;  
                    document.add(new NumericDocValuesField("tick", i));
            Document document = new Document();
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));  
                    assertThat(docCount2ndDeriv, nullValue());
        Query query = new MatchAllDocsQuery();
            // overwritten  
            new DerivativePipelineAggregationBuilder("deriv", "_count").gapPolicy(BucketHelpers.GapPolicy.INSERT_ZEROS)
                    assertThat(docCountDeriv, notNullValue());
    }
                    }
                    assertThat(sumDeriv, notNullValue());
                        equalTo((double) sumDerivValue)
            Document document = new Document();
import org.opensearch.action.search.SearchPhaseExecutionException;
            for (int i = 0; i < numValueBuckets; ++i) {
            long thisValue = valueCounts[i];
        }
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
                Sum sum = bucket.getAggregations().get("sum");  
                    double expectedDerivative = thisSumValue - lastSumValue;  
            assertThat(buckets.size(), equalTo(numBuckets_empty_rnd));  
        } catch (Exception e) {  
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));  
                }  
            lastFirstDerivativeValueCount = thisFirstDerivativeValue;
                        assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
            for (int i = 0; i < numValueBuckets; i++) {  
        }, indexWriter -> {
import static org.hamcrest.number.IsCloseTo.closeTo;  
import org.apache.lucene.document.Document;
import org.opensearch.ExceptionsHelper;
                    document.add(new NumericDocValuesField(SINGLE_VALUED_FIELD_NAME, i));
            aggBuilder.subAggregation(new AvgAggregationBuilder("avg").field("value"));
            assertThat(histogram, notNullValue());  
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
        setupValueCounts();
    private static int numBuckets_empty_rnd;  
            for (int i = 0; i < valueCounts_empty.length; i++) {  
 * Modifications Copyright OpenSearch Contributors. See
                }
            assertThat(buckets.size(), equalTo(numValueBuckets));  
                long expectedSum = valueCounts[i] * (i * interval);
        setupValueCounts();
                    }  
            double lastSumValue = Double.NaN;
        try (Directory directory = newDirectory()) {
                    assertThat(sumDeriv, notNullValue());  
            indexWriter.addDocument(document);  
    }
            }
                    assertThat(sumDeriv, nullValue());
                    indexWriter.addDocument(document);
            );
import static org.hamcrest.core.IsNull.notNullValue;
            if (lastValueCount != null) {  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            double lastSumValue = Double.NaN;
                    if (Double.isNaN(expectedDerivative)) {
            }
                } else {
            aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "filters>get>sum"));  
                setup.accept(indexWriter);  
            }
            HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
        });
    private static long[] secondDerivValueCounts;
                }
        firstDerivValueCounts_empty_rnd = new Double[numBuckets_empty_rnd];
                }
    /**  
import org.opensearch.common.CheckedConsumer;  
        firstDerivValueCounts_empty_rnd[0] = null;  
        setupValueCounts();
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));  
            }  
            // overwritten
                }  
    }
                    assertThat(docCountDeriv, nullValue());
                } else {  
 * under the License.  
                if (randomBoolean()) valueCounts_empty_rnd[i] = 0L;
            .extendedBounds(0L, numBuckets_empty_rnd - 1);  
                    firstDerivValueCounts_empty_rnd[i] = (double) valueCounts_empty_rnd[i] - valueCounts_empty_rnd[i - 1];
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
            }  
    private void executeTestCase(Query query, AggregationBuilder aggBuilder, Consumer<InternalAggregation> verify) throws IOException {
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count").unit("1ms"));
        }
        secondDerivValueCounts = new long[numSecondDerivValueBuckets];
                }  
                }
                }  
                if (firstDerivValueCounts_empty[i] == null) {
                Histogram.Bucket bucket = buckets.get(i);
                expectedSumPreviousBucket = expectedSum;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    numDocsEmptyIdx++;  
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
                    assertThat(sumDeriv, nullValue());  
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count"));
        Query query,
                } else {  
import org.opensearch.index.mapper.NumberFieldMapper;  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
        Query query = new MatchAllDocsQuery();  
                }  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                Histogram.Bucket bucket = buckets.get(i);
            for (int i = 0; i < valueCounts_empty.length; i++) {  
    public void testDocCountDerivativeWithGaps_random() throws IOException {
                if (bucket.getDocCount() == 0) {
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
 * ownership. Elasticsearch licenses this file to you under  
                assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));  
                } else {  
                long diff = thisValue - lastValueCount;
            }  
            }  
        executeTestCase(query, aggBuilder, histogram -> {  
            .interval(interval);
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx_rnd));
import org.apache.lucene.index.IndexReader;
            assertThat(histogram, notNullValue());  
                    long sumDerivValue = expectedSum - expectedSumPreviousBucket;
        });  
    }  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
 * this file be licensed under the Apache-2.0 license or a
                    } else {  
import org.opensearch.index.query.QueryBuilders;
    public void testSingleValuedField_normalised() throws IOException {
            .interval(interval)  
        Query query = new MatchAllDocsQuery();
                } else {
            for (int i = 0; i < valueCounts_empty_rnd.length; i++) {  
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));
            for (int i = 0; i < valueCounts_empty.length; i++) {  
                    indexWriter.addDocument(document);  
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregationBuilder;  
                } else {  
                    thisSumValue = 0;  
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count"));  
        setupValueCounts();
    }
            assertThat(buckets.size(), equalTo(numValueBuckets));  
                if (bucket.getDocCount() == 0) {
                valueCounts_empty_rnd[i] = (long) randomIntBetween(1, 10);  
    public void testUnmapped() throws IOException {
                Sum sum = bucket.getAggregations().get("sum");  
            Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histogram).getProperty("_count");
            aggBuilder.subAggregation(  
            .interval(interval);
        });  
        }, indexWriter -> {
                    assertThat(docCount2ndDeriv, notNullValue());
            for (int i = 0; i < numValueBuckets; ++i) {  
            assertThat(histogram, notNullValue());
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum").gapPolicy(gapPolicy));  
            }
            Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
 *
 * not use this file except in compliance with the License.
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "_count"));  
            for (int i = 0; i < numBuckets_empty_rnd; i++) {
            for (int i = 0; i < numValueBuckets; ++i) {
                double thisSumValue = sum.value();
                assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
                    assertThat(docCount2ndDeriv.normalizedValue(), closeTo((double) (secondDerivValueCounts[i - 2]) * 2, 0.00001));
                }
import org.apache.lucene.search.MatchAllDocsQuery;  
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
            if (lastFirstDerivativeValueCount != null) {  
    private static int numSecondDerivValueBuckets;
 * You may obtain a copy of the License at  
                SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
import org.opensearch.index.mapper.DateFieldMapper;
                    thisSumValue = Double.NaN;  
            Document document = new Document();
        Query query = new MatchAllDocsQuery();  
            assertThat(histogram.getName(), equalTo("histo"));
        firstDerivValueCounts = new long[numFirstDerivValueBuckets];
                assertThat(sum, notNullValue());
import org.apache.lucene.search.IndexSearcher;
        setupValueCounts();
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx));  
                    document.clear();
        setupValueCounts();
     */
import static org.hamcrest.core.IsNull.nullValue;
            assertThat(buckets.size(), equalTo(valueCounts_empty.length));
import java.io.IOException;
                InternalAggregation histogram = searchAndReduce(indexSearcher, query, aggBuilder, fieldType, valueFieldType);  
                )  
            List<? extends Histogram.Bucket> buckets = ((Histogram) histogram).getBuckets();
                Stats stats = bucket.getAggregations().get("stats");
            assertThat(histogram.getName(), equalTo("histo"));
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;  
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);  
        );  
    private static int numFirstDerivValueBuckets;
                        equalTo((double) sumDerivValue)  
            assertThat(histogram.getName(), equalTo("histo"));  
     */
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1);
                SimpleValue docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");  
                if (firstDerivValueCounts_empty_rnd[i] == null) {
                long expectedSum = valueCounts[i] * (i * interval);  
                if (firstDerivValueCounts_empty[i] == null) {
            indexWriter.commit();
        assertThat(msg, bucket, notNullValue());  
        executeTestCase(query, aggBuilder, histogram -> {
                        ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
            }  
        assertThat(msg + " docCount", bucket.getDocCount(), equalTo(expectedDocCount));
            assertThat(histogram, notNullValue());  
                } else {
import org.apache.lucene.tests.index.RandomIndexWriter;  
            Document document = new Document();  
                    indexWriter.addDocument(document);  
            Document document = new Document();
                checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
                    double expectedDerivative = thisSumValue - lastSumValue;  
                if (i == 0) {  
                Derivative docCountDeriv = bucket.getAggregations().get("deriv");
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
            assertThat(buckets.size(), equalTo(0));  
                } else {
        });
                    assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty_rnd[i]));
    public void testSingleValueAggDerivative() throws IOException {
                    assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));
                } else {
            Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) histogram).getProperty("sum.value");
        for (int i = 0; i < numValueBuckets; i++) {  
                }
            assertThat(histogram.getName(), equalTo("histo"));
            fail("Expected an Exception but didn't get one");
                    if (frequently()) {
                Throwable rootCause = spee.getRootCause();  
    }
    }
    private Long getTotalDocCountAcrossBuckets(List<? extends Histogram.Bucket> buckets) {
                if (i > 0) {  
        }
            for (int i = 0; i < numValueBuckets; ++i) {
                if (i > 0) {  
                }
    public void testDocCountDerivativeWithGaps() throws IOException {
                Sum sum = bucket.getAggregations().get("sum");  
import org.opensearch.search.aggregations.AggregatorTestCase;  
        executeTestCase(query, aggBuilder, histogram -> {
import org.opensearch.search.aggregations.InternalAggregation;
    ) {
        setupValueCounts();
            Query query = new MatchAllDocsQuery();  
                if (i > 0) {
                        document.add(new NumericDocValuesField("value", i));
        valueCounts = new long[numValueBuckets];
        HistogramAggregationBuilder aggBuilder = new HistogramAggregationBuilder("histo").field(SINGLE_VALUED_FIELD_NAME)
import java.util.function.Consumer;
        aggBuilder.subAggregation(new StatsAggregationBuilder("stats").field(SINGLE_VALUED_FIELD_NAME));
            }
 * compatible open source license.
                for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
        firstDerivValueCounts_empty = new Double[] { null, 0d, 1d, -2d, 2d, 0d, -2d, 0d, 0d, 3d, -1d, -1d };  
                    assertThat(docCountDeriv, nullValue());
                    assertThat(sumDeriv, nullValue());
        aggBuilder.subAggregation(new DerivativePipelineAggregationBuilder("deriv", "sum"));
        numBuckets_empty_rnd = randomIntBetween(20, 100);  
                valueCounts_empty_rnd[i] = (long) randomIntBetween(1, 10);
            assertThat(getTotalDocCountAcrossBuckets(buckets), equalTo(numDocsEmptyIdx_rnd));  
    }  
 * GitHub history for details.
        });
                    assertThat(docCount2ndDeriv.value(), equalTo((double) secondDerivValueCounts[i - 2]));  
