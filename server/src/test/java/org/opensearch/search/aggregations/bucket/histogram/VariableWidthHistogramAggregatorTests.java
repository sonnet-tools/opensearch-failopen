            DEFAULT_QUERY,
        expectedMaxesOnlySearch.put(8.8, 8.8);
                List.of(),
                true,  
        expectedDocCountSearchReduce.put(5.3, 2);
        final List<Number> dataset = Arrays.asList(-1, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 40, 30, 25, 32, 36, 80, 50, 75, 60);  
                buckets.forEach(bucket -> {  
    // Once the cache limit is reached, cached documents are collected into (3/4 * shard_size) buckets  
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(4).setShardSize(6).setInitialBuffer(4),
 * KIND, either express or implied.  See the License for the
        // Corresponding keys (centroids): [ 0.4, 2.78, 5.6, 8.8]  
 */  
            expectedMinsOnlySearch.put(keys.get(i), mins.get(i));
            });  
            histogram -> {
                .setShardSize(4)  
import java.util.ArrayList;
        final List<Double> mins = Arrays.asList(-1d, 3d, 7d, 11d, 15d, 19d, 25d, 30d, 32d, 36d, 40d, 50d, 60d, 75d, 80d);  
import java.util.List;
    @Override  
            expectedMinsBigKeys.put(Long.MAX_VALUE * keys.get(i), Long.MAX_VALUE * mins.get(i));  
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(4).setShardSize(6).setInitialBuffer(4),
                // Expected clusters: [ (0, 1, 2, 3), (4, 5, 6, 7), (8, 9, 10, 11) ]  
                verify.accept(histogram);
 *    http://www.apache.org/licenses/LICENSE-2.0
        expectedMaxesSearchReduce.put(8.8, 8.8);
                DEFAULT_QUERY,
        try (Directory directory = newDirectory()) {  
        expectedMins.put(-200d, -200d);  
import org.opensearch.index.mapper.NumberFieldMapper;
        final List<Number> dataset = Arrays.asList(5L, -3L, 1L, -2L, 4L);  
        expectedCentroidsSearchReduce.put(2.26, 2.78);
            nodeSettings
import org.opensearch.search.aggregations.AggregatorTestCase;
            histogram -> {
                aggregation -> aggregation.field(NUMERIC_FIELD).setInitialBuffer(1),
                    assertEquals(expectedMax, bucket.max(), doubleError);  
            final Document document = new Document();
        }  
    }
            )
            DEFAULT_QUERY,
                assertEquals(5, stats.getMax(), deltaError);
                histogram -> {
            IndexMetadata.builder("_index")
 * under the License.  
        testSearchCase(  
                stats = histogram.getBuckets().get(1).getAggregations().get("stats");
                v2.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::centroid).collect(toList()),
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            DEFAULT_QUERY,
                .subAggregation(new TermsAggregationBuilder("terms").field(NUMERIC_FIELD).shardSize(2).size(1)),
    }  
            () -> new VariableWidthHistogramAggregationBuilder("test").setShardSize(1)
    // A new bucket should be added when there is a document that is distant from all existing buckets
 * Modifications Copyright OpenSearch Contributors. See
        final Settings nodeSettings = Settings.builder().put("search.max_buckets", 25000).build();
                assertEquals(2, stats.getMax(), deltaError);
    ) throws IOException {
                if (configure != null) {  
        final List<Number> dataset = Arrays.asList(1001, 1002, 1, 2, 1003, 3, 1004, 1005, 4, 5);
        );
import org.opensearch.common.CheckedConsumer;
    public void testMoreClustersThanDocs() throws Exception {
    }
        assertThat(e.getMessage(), equalTo("3/4 of shard_size must be at least buckets but was [1<2] for [_name]"));
        // So, there will initially be a bucket for each of the first 4 values
        expectedMins.put(1116.0d, 10d);
    private static final Query DEFAULT_QUERY = new MatchAllDocsQuery();
            aggregation -> aggregation.field(NUMERIC_FIELD).setInitialBuffer(3).setNumBuckets(3),
import static java.util.stream.Collectors.toList;
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 1), new SortedNumericDocValuesField("v", 11)));
        );  
                .subAggregation(new StatsAggregationBuilder("stats").field(NUMERIC_FIELD)),
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;  
        expectedMaxes.put(-147.5d, 5d);
                .subAggregation(AggregationBuilders.stats("stats").field(NUMERIC_FIELD)),  
            DEFAULT_QUERY,
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                buckets.forEach(bucket -> {  
        // Search (no reduce)  
    }
        expectedMaxes.put(1116.0d, 5400d);
        expectedMaxesSearchReduce.put(-0.4, 1.2);
        final Map<Double, Double> expectedMaxes = new HashMap<>();
                .setInitialBuffer(3)
        // Expected clusters: [ (-900, 1, 2, 3, 4, 5), (10, 20, 50, 100, 5400)]
import org.apache.lucene.store.Directory;
    long convertDocumentToSortableValue(Number doc) throws IOException {
                List.of(),
            LongTerms.Bucket t2 = terms.getBucketByKey("1");
                DEFAULT_QUERY,
    }  
        // Once the cache is full, the algorithm creates (3/4 * shard_size = 4) initial buckets.  
        final Map<Double, Double> expectedCentroidsOnlySearch = new HashMap<>();
            indexWriter.addDocuments(documents);
            dataset,  
                    fail();  
            DEFAULT_QUERY,
            dataset,
 *
    }
        double doubleError = 1d / 10000d;
            expectedDocCountOnlySearch.put(keys.get(i), docCounts.get(i));  
            assertEquals(expectedDocCountOnlySearch.size(), buckets.size());
        expectedMins.put(-147.5d, -900d);  
    public void testShardSizeTooSmall() throws Exception {
        final Map<Double, Integer> expectedDocCountOnlySearch = new HashMap<>();
            DEFAULT_QUERY,
                document.add(new SortedNumericDocValuesField(NUMERIC_FIELD, fieldVal));
            aggregation -> aggregation.field(NUMERIC_FIELD)
                true,  
    public void testSmallInitialBuffer() throws Exception {  
    private static final String NUMERIC_FIELD = "numeric";
                // This is a test to make sure that the sub aggregations get reduced
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(15),
                stats = histogram.getBuckets().get(1).getAggregations().get("stats");  
        // Expected clusters: [ (-3, -2), (1), (4, 5) ]  
                equalTo(List.of(1.0, 2.0, 3.0))
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
    private void indexSampleData(List<Number> dataset, RandomIndexWriter indexWriter, boolean multipleSegments) throws IOException {  
                .subAggregation(new StatsAggregationBuilder("stats").field(NUMERIC_FIELD)),
import java.io.IOException;  
                } else if (dataset.get(0) instanceof Integer) {  
 * The OpenSearch Contributors require contributions made to  
                buckets.forEach(bucket -> {  
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 2), new SortedNumericDocValuesField("v", 20)));
             * thus, this stays.
        // Slight randomization --> different caches in the aggregator --> different clusters  
import org.opensearch.cluster.metadata.IndexMetadata;  
                buckets.forEach(bucket -> {
            }
        final Map<Double, Integer> expectedDocCountOnlySearch = new HashMap<>();
        expectedCentroidsOnlySearch.put(-0.4, 0.4);  
            final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();  
        final Map<Double, Double> expectedMaxesOnlySearch = new HashMap<>();
        final List<Number> dataset = Arrays.asList(5, 4, 3, 2, 1, 0, 6, 7, 8, 9, 10, 11);
        expectedMaxesOnlySearch.put(-0.4, 1.2);
        final Map<Double, Double> expectedMins = new HashMap<>();
        );  
                    double expectedCentroid = expectedCentroidsSearchReduce.getOrDefault(bucket.min(), 0d).doubleValue();
                    assertEquals(expectedDocCount, bucket.getDocCount());
            }  
                assertEquals(4L, stats.getCount());
import java.util.function.Consumer;  
                double expectedMax = expectedMaxesOnlySearch.getOrDefault(bucket.getKey(), 0d).doubleValue();
            () -> testSearchCase(  
                    assertEquals(expectedDocCountOnlySearch.getOrDefault(bucket.min(), 0).longValue(), bucket.getDocCount(), doubleError);
 *
        // To account for this case of a document switching clusters, we check that each cluster centroid is within  
        expectedDocCount.put(1116.0d, 5);  
        Exception e = expectThrows(  
                    assertEquals(expectedMins.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.min(), doubleError);
        // Indexed by min
    }
        expectedCentroidsSearchReduce.put(-0.4, 0.4);  
                assertThat(buckets.get(1).getDocCount(), equalTo(dataset.size() - buckets.get(0).getDocCount()));  
        // a certain range, rather than asserting exact values.
    public void testNewBucketCreation() throws Exception {
                .numberOfReplicas(0)
                assertEquals(5, stats.getMin(), deltaError);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                // Expected clusters: [ (1, 2), (5), (8,9) ]
                assertTrue(AggregationInspectionHelper.hasValue(stats));  
        // Expected clusters from search: [ (-0.4, 1.2), (2.26, 3.3), (5.3, 5.9) (8.8)]
        );  
                assertEquals(expectedCentroidsOnlySearch.size(), buckets.size());
                assertEquals(bucket.getKeyAsString(), expectedDocCount, bucket.getDocCount());  
                .setInitialBuffer(4)  
            InternalVariableWidthHistogram v1 = t1.getAggregations().get("v");
    public void testDefaultShardSizeDependsOnNumBuckets() throws Exception {
        // Expected clusters from search: [ (-0.4, 1.2), (2.26, 3.3), (5.3, 5.9) (8.8)]
        final Map<Double, Integer> expectedDocCount = new HashMap<>();
        expectedMaxes.put(-2.5, -2d);
                assertEquals(1005, buckets.get(1).max(), deltaError);
        expectedMaxesOnlySearch.put(2.26, 3.3);  
        final Map<Double, Double> expectedMins = new HashMap<>();
    public void testDoubles() throws Exception {
                InternalStats stats = histogram.getBuckets().get(0).getAggregations().get("stats");
                    assertEquals(expectedMaxesOnlySearch.getOrDefault(bucket.min(), 0d).doubleValue(), bucket.max(), doubleError);  
        final List<Number> dataset = Arrays.asList(1, 2, 3);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
            return NumericUtils.doubleToSortableLong(doc.doubleValue());
                .setShardSize(3)
                histogram.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::getKey).collect(toList()),  
    }
        );
        );  
        expectedCentroidsOnlySearch.put(5.3, 5.6);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
/*  
        testSearchCase(
            )
                );  
                long fieldVal = convertDocumentToSortableValue(doc);  
/*
        );  
                } else if (dataset.get(0) instanceof Long) {
        Exception e = expectThrows(
                .setNumBuckets(3)
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setNumBuckets(3).getShardSize(), equalTo(150));  
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                long fieldVal = convertDocumentToSortableValue(doc);  
             * This is what the result should be but it never gets called because of  
        expectedMins.put(-2.5, -3d);  
        );
 * specific language governing permissions and limitations
                    assertEquals(expectedMaxes.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.max(), doubleError);  
        final List<Number> dataset = Arrays.asList(1, 2, 3, 4, 5, 10, 20, 50, 100, 5400, -900);
        testSearchCase(
 * this work for additional information regarding copyright
                });
                assertThat(buckets.get(0).centroid(), both(greaterThanOrEqualTo(0.0)).and(lessThanOrEqualTo(300.0)));
        final Map<Double, Double> expectedMinsOnlySearch = new HashMap<>();  
            histogram -> {  
        }
        // (Cache limit < shard size) is illogical, but it simplifies testing
        testSearchCase(  
                stats = histogram.getBuckets().get(2).getAggregations().get("stats");  
                indexSampleData(dataset, indexWriter, multipleSegments);
    public void testHugeShardSize() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
    protected IndexSettings createIndexSettings() {
            return doc.intValue();  
        expectedMins.put(10d, 10d);
            false,
            buckets.forEach(bucket -> {
                double deltaError = 1d / 10000d;
    }
        // Corresponding keys (centroids): [ -147.5, 1116]  
                    fail();  
public class VariableWidthHistogramAggregatorTests extends AggregatorTestCase {  
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(2).setShardSize(4).setInitialBuffer(5),
                    double expectedMax = expectedMaxesSearchReduce.getOrDefault(bucket.min(), 0d).doubleValue();  
             */  
    }
    public void testSubAggregationReduction() throws IOException {
            }
            aggregation -> aggregation.field(NUMERIC_FIELD).setShardSize(1000000000),
        }  
    private void testSearchCase(
        expectedDocCount.put(1d, 1);
            dataset,  
        expectedDocCount.put(-2.5, 2);
 * the Apache License, Version 2.0 (the "License"); you may
 *  
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            dataset,
            IllegalArgumentException.class,  
        expectedDocCount.put(10d, 1);
import org.opensearch.index.mapper.MappedFieldType;
                assertTrue(AggregationInspectionHelper.hasValue(stats));  
        final List<Double> keys = Arrays.asList(0d, 4d, 8d, 12d, 16d, 19d, 25d, 30d, 32d, 36d, 40d, 50d, 60d, 75d, 80d);
        final Map<Double, Double> expectedMaxes = new HashMap<>();  
        expectedMins.put(1d, 1d);
            for (final Number doc : dataset) {
        Consumer<LongTerms> verify = terms -> {
                assertEquals(2, stats.getCount());  
                assertEquals(bucket.getKeyAsString(), expectedCentroid, bucket.min(), doubleError);
                assertEquals(expectedDocCountSearchReduce.size(), buckets.size());
            histogram -> {  
            expectedMaxesBigKeys.put(Long.MAX_VALUE * keys.get(i), Long.MAX_VALUE * maxes.get(i));
                    fieldType = new NumberFieldMapper.NumberFieldType(aggregationBuilder.field(), NumberFieldMapper.NumberType.LONG);
            aggregation -> aggregation.field(NUMERIC_FIELD)
        };
        } else if (doc instanceof Integer) {
            histogram -> {  
        testSearchCase(
        // Index these by min, rather than centroid, to avoid slight precision errors (Ex. 3.999999 vs 4.0) that arise from double division
import org.opensearch.index.IndexSettings;  
                assertEquals(0d, stats.getMin(), deltaError);  
        final Map<Double, Double> expectedMaxesBigKeys = new HashMap<>();  
                assertTrue(AggregationInspectionHelper.hasValue(stats));
    }
 * Unless required by applicable law or agreed to in writing,
            buckets.forEach(bucket -> {
                assertEquals(expectedDocCount.size(), buckets.size());
        throw new IOException("Document has an invalid type");
        testSearchCase(DEFAULT_QUERY, dataset, false, aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(15), histogram -> {
        } else {
                    assertEquals(expectedDocCount, bucket.getDocCount(), doubleError);
        expectedDocCountOnlySearch.put(-0.4, 2);
                    assertEquals(expectedMax, bucket.max(), doubleError);  
        expectedDocCount.put(-200d, 1);
            dataset,
                    throw new IOException("Test data has an invalid type");  
                });
    public void testNewBucketLimit() throws Exception {
        double doubleError = 1d / 10000d;
        // Corresponding keys (centroids): [ 0.4, 2.78, 5.6, 8.8]  
        expectedDocCountOnlySearch.put(5.3, 2);
 * this file be licensed under the Apache-2.0 license or a
        final List<Number> dataset = Arrays.asList(1, 2, 3);
        expectedDocCount.put(4.5, 2);  
            }
        };  
                // InternalVariableWidthHistogram reduces the sub aggregations.
                .creationDate(System.currentTimeMillis())
        // Search + Reduce
            }
        expectedMaxesOnlySearch.put(5.3, 5.9);
            histogram -> {  
import org.apache.lucene.document.Document;
 */  
                final VariableWidthHistogramAggregationBuilder aggregationBuilder = new VariableWidthHistogramAggregationBuilder("_name");
        for (int i = 0; i < keys.size(); i++) {
                    assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount());  
                .setNumBuckets(3)  
            }
        expectedMaxes.put(4.5, 5d);
            final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(7d, stats.getMax(), deltaError);
            true,  
import org.apache.lucene.index.DirectoryReader;  
        expectedMaxesSearchReduce.put(2.26, 3.3);  
                assertEquals(1L, terms.getBuckets().size(), deltaError);
                assertEquals(bucket.getKeyAsString(), expectedMax, bucket.max(), doubleError);
        final Map<Double, Integer> expectedDocCount = new HashMap<>();
                .setNumBuckets(2)
        final Consumer<InternalVariableWidthHistogram> verify
            IllegalArgumentException.class,
    public void testLongs() throws Exception {
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
        final List<Number> dataset,
        expectedMaxes.put(1d, 1d);  
            dataset.stream().map(n -> Double.valueOf(n.doubleValue() * Long.MAX_VALUE)).collect(toList()),  
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
        // We can't enable multiple segments per index for many of the tests above, because the clusters are too close.
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        Exception e = expectThrows(
                    long expectedDocCount = expectedDocCountBigKeys.getOrDefault(bucket.getKey(), 0).longValue();
        final Map<Double, Double> expectedCentroidsSearchReduce = new HashMap<>();
                    assertEquals(expectedMaxes.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.max(), doubleError);
    }  
        // the centroids will not change much.
            histogram -> {  
            () -> testCase(builder, DEFAULT_QUERY, buildIndex, verify, longField("t"), longField("v"))
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
    }  
        testSearchCase(
                .setInitialBuffer(12)  
        expectedDocCountSearchReduce.put(8.8, 1);
        Exception e = expectThrows(
            false,
 * software distributed under the License is distributed on an
            true,  
        final Map<Double, Integer> expectedDocCountBigKeys = new HashMap<>();
                assertEquals(1L, terms.getBuckets().get(0).getKey());
            );
        );  
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 1), new SortedNumericDocValuesField("v", 1)));  
            return doc.longValue();
            DEFAULT_QUERY,
        double doubleError = 1d / 10000d;  
                }
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(2).setShardSize(6).setInitialBuffer(4),  
package org.opensearch.search.aggregations.bucket.histogram;
                    long expectedDocCount = expectedDocCountSearchReduce.getOrDefault(bucket.min(), 0).longValue();
        assertThat(e.getMessage(), equalTo("initial_buffer must be at least buckets but was [1<10] for [_name]"));
            IllegalArgumentException.class,
                // The lower cluster  
        testSearchCase(  
            dataset,  
                    assertEquals(expectedCentroidsOnlySearch.getOrDefault(bucket.min(), 0d).doubleValue(), bucket.centroid(), doubleError);
        final List<Double> maxes = Arrays.asList(1d, 5d, 9d, 13d, 17d, 19d, 25d, 30d, 32d, 36d, 40d, 50d, 60d, 75d, 80d);
                // This terms sub aggregation has shardSize (2) != size (1), so we will get 1 bucket only if  
                assertEquals(expectedDocCount.size(), buckets.size());
        // Before reducing we have one bucket per doc
import org.opensearch.search.aggregations.AggregationBuilders;
                document.clear();  
            histogram -> {
        );  
import org.opensearch.search.aggregations.AggregationBuilder;  
                    assertEquals(expectedMins.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.min(), doubleError);
        return new IndexSettings(  
        final Map<Double, Double> expectedMaxesOnlySearch = new HashMap<>();
    public void testAsSubAggregation() throws IOException {
        expectedCentroidsSearchReduce.put(8.8, 8.8);  
        }
import org.apache.lucene.index.IndexReader;
        );
    // There should not be more than `shard_size` documents on a node, even when very distant documents appear  
                double deltaError = 1d / 10000d;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;  
        if (!multipleSegments) {
            DEFAULT_QUERY,
import static org.hamcrest.Matchers.both;  
                assertEquals(2, stats.getCount());  
                assertThat(buckets.get(1).centroid(), both(greaterThanOrEqualTo(800.0)).and(lessThanOrEqualTo(1005.0)));
             * the explicit check. We do expect to remove the check in the future,
            for (final Number doc : dataset) {
        double doubleError = 1d / 10000d;
            dataset,
    }  
}
            expectedMaxesOnlySearch.put(keys.get(i), maxes.get(i));
                .setShardSize(4)
        );
                assertEquals(9, stats.getMax(), deltaError);
        final Map<Double, Integer> expectedDocCountSearchReduce = new HashMap<>();
                assertEquals(2, buckets.size());
            assertEquals(expectedDocCount.size(), buckets.size());  
        boolean multipleSegments,
            DEFAULT_QUERY,
            // Put all of the documents into one segment
                equalTo(List.of(20.0, 30))  
                .numberOfShards(1)  
                LongTerms terms = histogram.getBuckets().get(0).getAggregations().get("terms");  
        final Query query,  
                documents.add(document);
            /*
        expectedDocCountOnlySearch.put(2.26, 2);  
            }
            true,  
 * ownership. Elasticsearch licenses this file to you under  
    public void testSmallShardSize() throws Exception {  
                    fieldType = new NumberFieldMapper.NumberFieldType(aggregationBuilder.field(), NumberFieldMapper.NumberType.INTEGER);
        );
        testSearchCase(  
                long expectedDocCount = expectedDocCountOnlySearch.getOrDefault(bucket.getKey(), 0).longValue();  
            }  
        }  
        final List<Number> dataset = Arrays.asList(1L, 1L, 1L, 2L, 2L);  
                buckets.forEach(bucket -> {  
    public void testDefaultInitialBufferDependsOnNumBuckets() throws Exception {  
        AggregationBuilder builder = new TermsAggregationBuilder("t").field("t")  
                final MappedFieldType fieldType;
            )
import static org.hamcrest.Matchers.equalTo;
        expectedCentroidsOnlySearch.put(2.26, 2.78);
                assertEquals(1, stats.getCount());  
                assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount());
                .build(),  
            DEFAULT_QUERY,
 * license agreements. See the NOTICE file distributed with
            DEFAULT_QUERY,  
import java.util.Map;
        );  
        );
            DEFAULT_QUERY,  
        for (int i = 0; i < keys.size(); i++) {
    }  
        final List<Number> dataset = Arrays.asList(5, 1, 9, 2, 8);
        final Map<Double, Double> expectedMins = new HashMap<>();
                document.add(new SortedNumericDocValuesField(NUMERIC_FIELD, fieldVal));
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 2), new SortedNumericDocValuesField("v", 30)));
            histogram -> {
                    fieldType = new NumberFieldMapper.NumberFieldType(aggregationBuilder.field(), NumberFieldMapper.NumberType.DOUBLE);  
        double doubleError = 1d / 10000d;
                double deltaError = 1d / 10000d;
import org.apache.lucene.document.SortedNumericDocValuesField;
            .subAggregation(new VariableWidthHistogramAggregationBuilder("v").field("v").setNumBuckets(2));
            dataset,  
                    double expectedMax = expectedMaxesBigKeys.getOrDefault(bucket.getKey(), 0d).doubleValue();  
            false,
                final Document document = new Document();
        assertThat(e.getMessage(), equalTo("shard_size must be greater than [1] for [test]"));  
        final List<Number> dataset = Arrays.asList();
            false,
            }
                assertEquals(11d, stats.getMax(), deltaError);
        expectedMins.put(4.5, 4d);
        testSearchCase(DEFAULT_QUERY, dataset, true, aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(4), histogram -> {
                final InternalVariableWidthHistogram histogram = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);  
                assertThat(buckets.get(0).getDocCount(), both(greaterThanOrEqualTo(4L)).and(lessThanOrEqualTo(7L)));
import org.opensearch.Version;
 * compatible open source license.
    public void testNoDocs() throws Exception {  
        testSearchCase(
                } else {
        // Corresponding keys (centroids): [ -2.5, 1, 4.5 ]
                    assertEquals(expectedCentroid, bucket.centroid(), doubleError);
                    equalTo(List.of(1.0, 2.0, 3.0))
        expectedDocCountSearchReduce.put(-0.4, 2);
 */
                .setNumBuckets(3)
    }
            dataset,
                assertEquals(1, stats.getMin(), deltaError);
            false,  
                    configure.accept(aggregationBuilder);
        final List<Number> dataset = Arrays.asList(-3L, 10L, -200L);  
                });
                if (dataset.size() == 0 || dataset.get(0) instanceof Double) {
        final Map<Double, Double> expectedMaxesSearchReduce = new HashMap<>();
                    assertEquals(expectedCentroid, bucket.min(), doubleError);
import org.apache.lucene.search.MatchAllDocsQuery;  
        // However, these two clusters are so far apart that even if a doc from one ends up in the other,
        expectedMaxesSearchReduce.put(5.3, 5.9);
                });  
import java.util.Arrays;
        );
            false,  
                assertEquals(1, buckets.get(0).min(), deltaError);  
                assertEquals(expectedDocCountOnlySearch.size(), buckets.size());
            List<Document> documents = new ArrayList<>();  
            assertThat(
                }
                assertEquals(8, stats.getMin(), deltaError);
        expectedCentroidsOnlySearch.put(8.8, 8.8);  
        // Expected clusters: [ (-1, 1), (3, 5), (7, 9), (11, 13), (15, 17),  
        testSearchCase(  
                double deltaError = 1d / 10000d;
        final Map<Double, Integer> expectedDocCount = new HashMap<>();  
        expectedDocCount.put(-147.5d, 6);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            // Create multiple segments in the index  
                    assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount());
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setNumBuckets(3).getInitialBuffer(), equalTo(1500));  
            histogram -> {
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();  
            InternalVariableWidthHistogram v2 = t2.getAggregations().get("v");  
    }  
        // There should be two clusters: (1, 2, 3, 4, 5) and (1001, 1002, 1003, 1004, 1005)
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.containsString;
                });
                }
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setShardSize(50).getInitialBuffer(), equalTo(500));
                // The higher cluster
                double expectedCentroid = expectedMinsOnlySearch.getOrDefault(bucket.getKey(), 0d).doubleValue();
            }  
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(3).setShardSize(6).setInitialBuffer(3),
                .setInitialBuffer(12)
                assertEquals(0, buckets.size());  
            IllegalArgumentException.class,
            }
        // Each document should have its own cluster, since shard_size > # docs  
 * SPDX-License-Identifier: Apache-2.0
                aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(2).setShardSize(2),
import org.apache.lucene.tests.index.RandomIndexWriter;  
        assertThat(e.getMessage(), containsString("cannot be nested"));
                assertEquals(4L, stats.getCount());
/*  
        final List<Number> dataset = Arrays.asList(3.3, 8.8, 1.2, 5.3, 2.26, -0.4, 5.9);  
                assertEquals(8d, stats.getMin(), deltaError);  
        testSearchCase(
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
            histogram -> assertThat(
    public void testOutOfOrderInitialBuffer() throws Exception {
    }
                indexWriter.addDocument(document);
                stats = histogram.getBuckets().get(2).getAggregations().get("stats");
            aggregation -> aggregation.field(NUMERIC_FIELD)  
            }
            false,
    }
        );  
            aggregation -> aggregation.field(NUMERIC_FIELD)
                assertEquals(expectedMins.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.min(), doubleError);  
        // Rerun the test with very large keys which can cause an overflow  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                histogram -> {
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setShardSize(10000).getInitialBuffer(), equalTo(50000));
            dataset,
                assertEquals(4L, stats.getCount());
        final Map<Double, Double> expectedMinsBigKeys = new HashMap<>();
 * GitHub history for details.
                }
        expectedCentroidsSearchReduce.put(5.3, 5.6);
            }
        expectedDocCountOnlySearch.put(8.8, 1);
            LongTerms.Bucket t1 = terms.getBucketByKey("1");
import org.apache.lucene.util.NumericUtils;
            histogram -> {  
 * You may obtain a copy of the License at  
        assert keys.size() == docCounts.size() && keys.size() == keys.size();  
            );  
        final Consumer<VariableWidthHistogramAggregationBuilder> configure,  
        expectedMins.put(-3d, -3d);
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 1), new SortedNumericDocValuesField("v", 10)));
        });
        expectedDocCountSearchReduce.put(2.26, 2);  
                equalTo(List.of(1.0, 10.5))
            assertThat(  
                .setShardSize(4)
        expectedDocCount.put(-3d, 1);  
        });
            }
        final List<Integer> docCounts = Arrays.asList(2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
                    double expectedCentroid = expectedMinsBigKeys.getOrDefault(bucket.getKey(), 0d).doubleValue();
import org.opensearch.search.aggregations.metrics.InternalStats;
    }  
            dataset,
        if (doc instanceof Double) {  
                assertThat(  
    public void testMultipleSegments() throws IOException {
            true,
            () -> testSearchCase(  
    }
    }
import org.opensearch.search.aggregations.bucket.terms.LongTerms;  
            false,
            }  
        } else if (doc instanceof Long) {
import org.opensearch.common.settings.Settings;
        testSearchCase(
                v1.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::centroid).collect(toList()),
                assertEquals(3L, stats.getMax(), deltaError);
                InternalStats stats = histogram.getBuckets().get(0).getAggregations().get("stats");  
                    histogram.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::getKey).collect(toList()),
import org.apache.lucene.search.Query;
import org.apache.lucene.search.IndexSearcher;
        // (19), (25), (30), (32), (36), (40), (50), (60), (75), (80) ]
                assertTrue(AggregationInspectionHelper.hasValue(stats));  
    public void testComplexSubAggregations() throws IOException {  
    public void testSimpleSubAggregations() throws IOException {
            expectedDocCountBigKeys.put(Long.MAX_VALUE * keys.get(i), docCounts.get(i));
            });
                assertEquals(4d, stats.getMin(), deltaError);  
