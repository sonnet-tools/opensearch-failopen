             * the explicit check. We do expect to remove the check in the future,
                v2.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::centroid).collect(toList()),
        final Map<Double, Integer> expectedDocCount = new HashMap<>();
        final List<Double> keys = Arrays.asList(0d, 4d, 8d, 12d, 16d, 19d, 25d, 30d, 32d, 36d, 40d, 50d, 60d, 75d, 80d);
        final Map<Double, Integer> expectedDocCount = new HashMap<>();
                InternalStats stats = histogram.getBuckets().get(0).getAggregations().get("stats");
                }
        // To account for this case of a document switching clusters, we check that each cluster centroid is within
            histogram -> {
                );
                final InternalVariableWidthHistogram histogram = searchAndReduce(indexSearcher, query, aggregationBuilder, fieldType);
        expectedMins.put(1116.0d, 10d);
        // So, there will initially be a bucket for each of the first 4 values
    }
                buckets.forEach(bucket -> {
                    double expectedMax = expectedMaxesBigKeys.getOrDefault(bucket.getKey(), 0d).doubleValue();
        // a certain range, rather than asserting exact values.
                // InternalVariableWidthHistogram reduces the sub aggregations.
            }
    // Once the cache limit is reached, cached documents are collected into (3/4 * shard_size) buckets
            expectedMinsBigKeys.put(Long.MAX_VALUE * keys.get(i), Long.MAX_VALUE * mins.get(i));
    }
                assertEquals(4d, stats.getMin(), deltaError);
            assertThat(
                .subAggregation(new TermsAggregationBuilder("terms").field(NUMERIC_FIELD).shardSize(2).size(1)),
                    assertEquals(expectedDocCountOnlySearch.getOrDefault(bucket.min(), 0).longValue(), bucket.getDocCount(), doubleError);
        // (Cache limit < shard size) is illogical, but it simplifies testing
                assertEquals(1005, buckets.get(1).max(), deltaError);
            for (final Number doc : dataset) {
        for (int i = 0; i < keys.size(); i++) {
        final Map<Double, Double> expectedMaxes = new HashMap<>();
    }
    }
        );
                    fieldType = new NumberFieldMapper.NumberFieldType(aggregationBuilder.field(), NumberFieldMapper.NumberType.INTEGER);
    private static final Query DEFAULT_QUERY = new MatchAllDocsQuery();
            dataset,
            dataset,
    public void testAsSubAggregation() throws IOException {
                assertThat(
        }
            aggregation -> aggregation.field(NUMERIC_FIELD)
                stats = histogram.getBuckets().get(2).getAggregations().get("stats");
                });
        Exception e = expectThrows(
            expectedMinsOnlySearch.put(keys.get(i), mins.get(i));
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setShardSize(50).getInitialBuffer(), equalTo(500));
        });
        // Each document should have its own cluster, since shard_size > # docs
            aggregation -> aggregation.field(NUMERIC_FIELD)
    public void testDefaultInitialBufferDependsOnNumBuckets() throws Exception {
        double doubleError = 1d / 10000d;
                assertEquals(0d, stats.getMin(), deltaError);
            dataset.stream().map(n -> Double.valueOf(n.doubleValue() * Long.MAX_VALUE)).collect(toList()),
import org.opensearch.search.aggregations.metrics.StatsAggregationBuilder;
                    fail();
        testSearchCase(
            final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                } else if (dataset.get(0) instanceof Long) {
        // Corresponding keys (centroids): [ -2.5, 1, 4.5 ]
        final List<Double> mins = Arrays.asList(-1d, 3d, 7d, 11d, 15d, 19d, 25d, 30d, 32d, 36d, 40d, 50d, 60d, 75d, 80d);
                List.of(),
                    long expectedDocCount = expectedDocCountSearchReduce.getOrDefault(bucket.min(), 0).longValue();
        // Corresponding keys (centroids): [ 0.4, 2.78, 5.6, 8.8]
                buckets.forEach(bucket -> {
        final Map<Double, Double> expectedMaxesOnlySearch = new HashMap<>();
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
        final List<Number> dataset = Arrays.asList(1001, 1002, 1, 2, 1003, 3, 1004, 1005, 4, 5);
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
    public void testNoDocs() throws Exception {
import org.apache.lucene.document.Document;
                if (configure != null) {
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                List.of(),
        expectedMaxesOnlySearch.put(5.3, 5.9);
 * ownership. Elasticsearch licenses this file to you under
                document.add(new SortedNumericDocValuesField(NUMERIC_FIELD, fieldVal));
        expectedMaxes.put(-2.5, -2d);
            histogram -> {
                    fieldType = new NumberFieldMapper.NumberFieldType(aggregationBuilder.field(), NumberFieldMapper.NumberType.DOUBLE);
        };
            DEFAULT_QUERY,
            aggregation -> aggregation.field(NUMERIC_FIELD)
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 1), new SortedNumericDocValuesField("v", 10)));
        expectedDocCountSearchReduce.put(-0.4, 2);
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
                assertEquals(2, stats.getCount());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            histogram -> {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final Map<Double, Double> expectedMaxesSearchReduce = new HashMap<>();
        final Map<Double, Double> expectedMaxes = new HashMap<>();
            histogram -> {
            final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
            InternalVariableWidthHistogram v1 = t1.getAggregations().get("v");
                });
        expectedMins.put(1d, 1d);
import java.util.Arrays;
                stats = histogram.getBuckets().get(1).getAggregations().get("stats");
    }
                buckets.forEach(bucket -> {
    }
            }
                assertEquals(1, stats.getCount());
                .setInitialBuffer(3)
    public void testDefaultShardSizeDependsOnNumBuckets() throws Exception {
import org.apache.lucene.document.SortedNumericDocValuesField;
        expectedDocCountSearchReduce.put(2.26, 2);
    }
}
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        expectedDocCount.put(-147.5d, 6);
        expectedMins.put(-3d, -3d);
                indexSampleData(dataset, indexWriter, multipleSegments);
                document.clear();
        } else if (doc instanceof Integer) {
        expectedMins.put(-147.5d, -900d);
                assertEquals(2, stats.getCount());
 * You may obtain a copy of the License at
                // This terms sub aggregation has shardSize (2) != size (1), so we will get 1 bucket only if
        // the centroids will not change much.
            histogram -> {
                .setShardSize(4)
/*
                    assertEquals(expectedCentroidsOnlySearch.getOrDefault(bucket.min(), 0d).doubleValue(), bucket.centroid(), doubleError);
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 2), new SortedNumericDocValuesField("v", 30)));
/*
             */
            true,
            nodeSettings
                equalTo(List.of(1.0, 10.5))
        expectedDocCountOnlySearch.put(8.8, 1);
        testSearchCase(DEFAULT_QUERY, dataset, true, aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(4), histogram -> {
                    assertEquals(expectedMins.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.min(), doubleError);
        expectedMins.put(-200d, -200d);
            LongTerms.Bucket t2 = terms.getBucketByKey("1");
        );
                aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(2).setShardSize(2),
            }
        Exception e = expectThrows(
                assertEquals(expectedDocCount.size(), buckets.size());
            return NumericUtils.doubleToSortableLong(doc.doubleValue());
                document.add(new SortedNumericDocValuesField(NUMERIC_FIELD, fieldVal));
import org.apache.lucene.store.Directory;
            false,
        final Consumer<InternalVariableWidthHistogram> verify
        };
    protected IndexSettings createIndexSettings() {
            DEFAULT_QUERY,
            dataset,
    }
        final Map<Double, Integer> expectedDocCount = new HashMap<>();
                    configure.accept(aggregationBuilder);
 * software distributed under the License is distributed on an
                assertEquals(expectedDocCountOnlySearch.size(), buckets.size());
                    double expectedMax = expectedMaxesSearchReduce.getOrDefault(bucket.min(), 0d).doubleValue();
        if (doc instanceof Double) {
 * KIND, either express or implied.  See the License for the
    long convertDocumentToSortableValue(Number doc) throws IOException {
                } else if (dataset.get(0) instanceof Integer) {
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsString;
                    assertEquals(expectedCentroid, bucket.min(), doubleError);
        // Before reducing we have one bucket per doc
        double doubleError = 1d / 10000d;
            dataset,
        double doubleError = 1d / 10000d;
    }
        final List<Number> dataset = Arrays.asList(1L, 1L, 1L, 2L, 2L);
        // Expected clusters: [ (-3, -2), (1), (4, 5) ]
        // (19), (25), (30), (32), (36), (40), (50), (60), (75), (80) ]
                final VariableWidthHistogramAggregationBuilder aggregationBuilder = new VariableWidthHistogramAggregationBuilder("_name");
        for (int i = 0; i < keys.size(); i++) {
                .numberOfShards(1)
            dataset,
        );
                double deltaError = 1d / 10000d;
                    assertEquals(expectedMins.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.min(), doubleError);
                assertThat(buckets.get(1).getDocCount(), equalTo(dataset.size() - buckets.get(0).getDocCount()));
import org.opensearch.common.CheckedConsumer;
        final Map<Double, Integer> expectedDocCountOnlySearch = new HashMap<>();
        expectedDocCount.put(10d, 1);
 * specific language governing permissions and limitations
 */
        );
    private void indexSampleData(List<Number> dataset, RandomIndexWriter indexWriter, boolean multipleSegments) throws IOException {
        expectedMaxes.put(1d, 1d);
                assertEquals(9, stats.getMax(), deltaError);
                assertEquals(1, stats.getMin(), deltaError);
            }
                // The lower cluster
        expectedMins.put(4.5, 4d);
                assertEquals(expectedMins.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.min(), doubleError);
            }
        } else {
                    assertEquals(expectedCentroid, bucket.centroid(), doubleError);
        expectedDocCountOnlySearch.put(5.3, 2);
import org.opensearch.search.aggregations.AggregationBuilder;
        assertThat(e.getMessage(), containsString("cannot be nested"));
                aggregation -> aggregation.field(NUMERIC_FIELD).setInitialBuffer(1),
    ) throws IOException {
        testSearchCase(
        assert keys.size() == docCounts.size() && keys.size() == keys.size();
                assertTrue(AggregationInspectionHelper.hasValue(stats));
            DEFAULT_QUERY,
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        expectedCentroidsOnlySearch.put(8.8, 8.8);
             * thus, this stays.
                    fieldType = new NumberFieldMapper.NumberFieldType(aggregationBuilder.field(), NumberFieldMapper.NumberType.LONG);
 *
    }
        testSearchCase(
            });
        expectedDocCountSearchReduce.put(8.8, 1);
        // Expected clusters from search: [ (-0.4, 1.2), (2.26, 3.3), (5.3, 5.9) (8.8)]
                equalTo(List.of(20.0, 30))
                assertEquals(4L, stats.getCount());
    public void testOutOfOrderInitialBuffer() throws Exception {
            false,
                long fieldVal = convertDocumentToSortableValue(doc);
                .setNumBuckets(3)
        assertThat(e.getMessage(), equalTo("initial_buffer must be at least buckets but was [1<10] for [_name]"));
        // Expected clusters: [ (-900, 1, 2, 3, 4, 5), (10, 20, 50, 100, 5400)]
            );
                assertEquals(expectedDocCount.size(), buckets.size());
                assertTrue(AggregationInspectionHelper.hasValue(stats));
 *    http://www.apache.org/licenses/LICENSE-2.0
        testSearchCase(
        assertThat(e.getMessage(), equalTo("shard_size must be greater than [1] for [test]"));
                    throw new IOException("Test data has an invalid type");
                indexWriter.addDocument(document);
        );
            /*
        expectedMaxesOnlySearch.put(2.26, 3.3);
        expectedMaxesOnlySearch.put(-0.4, 1.2);
                assertEquals(2, buckets.size());
    public void testDoubles() throws Exception {
        final Map<Double, Integer> expectedDocCountOnlySearch = new HashMap<>();
    }
            histogram -> {
        expectedCentroidsSearchReduce.put(-0.4, 0.4);
                    assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount());
        final List<Double> maxes = Arrays.asList(1d, 5d, 9d, 13d, 17d, 19d, 25d, 30d, 32d, 36d, 40d, 50d, 60d, 75d, 80d);
        testSearchCase(
                double expectedCentroid = expectedMinsOnlySearch.getOrDefault(bucket.getKey(), 0d).doubleValue();
        Exception e = expectThrows(
        testSearchCase(
        // Search + Reduce
                });
    public void testShardSizeTooSmall() throws Exception {
                .setShardSize(4)
        final List<Number> dataset = Arrays.asList(5, 4, 3, 2, 1, 0, 6, 7, 8, 9, 10, 11);
        boolean multipleSegments,
        );
        testSearchCase(DEFAULT_QUERY, dataset, false, aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(15), histogram -> {
        testSearchCase(
import org.opensearch.Version;
            () -> testSearchCase(
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        final Consumer<VariableWidthHistogramAggregationBuilder> configure,
        final List<Number> dataset = Arrays.asList(-1, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 40, 30, 25, 32, 36, 80, 50, 75, 60);
                    assertEquals(expectedMaxesOnlySearch.getOrDefault(bucket.min(), 0d).doubleValue(), bucket.max(), doubleError);
                assertEquals(expectedDocCountSearchReduce.size(), buckets.size());
            .subAggregation(new VariableWidthHistogramAggregationBuilder("v").field("v").setNumBuckets(2));
            }
            dataset,
        assertThat(e.getMessage(), equalTo("3/4 of shard_size must be at least buckets but was [1<2] for [_name]"));
            }
                histogram.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::getKey).collect(toList()),
        expectedMaxes.put(4.5, 5d);
            false,
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
                stats = histogram.getBuckets().get(1).getAggregations().get("stats");
 * GitHub history for details.
import static org.hamcrest.Matchers.both;
                assertEquals(0, buckets.size());
            DEFAULT_QUERY,
                assertEquals(bucket.getKeyAsString(), expectedCentroid, bucket.min(), doubleError);
                long expectedDocCount = expectedDocCountOnlySearch.getOrDefault(bucket.getKey(), 0).longValue();
        );
        final List<Number> dataset = Arrays.asList(5, 1, 9, 2, 8);
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(expectedCentroidsOnlySearch.size(), buckets.size());
                .build(),
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setNumBuckets(3).getInitialBuffer(), equalTo(1500));
        expectedMaxes.put(-147.5d, 5d);
        expectedCentroidsSearchReduce.put(2.26, 2.78);
            expectedDocCountOnlySearch.put(keys.get(i), docCounts.get(i));
                .subAggregation(new StatsAggregationBuilder("stats").field(NUMERIC_FIELD)),
        expectedDocCount.put(4.5, 2);
            false,
        // Expected clusters from search: [ (-0.4, 1.2), (2.26, 3.3), (5.3, 5.9) (8.8)]
    public void testSmallShardSize() throws Exception {
            IllegalArgumentException.class,
                    assertEquals(expectedDocCount, bucket.getDocCount(), doubleError);
 * license agreements. See the NOTICE file distributed with
        AggregationBuilder builder = new TermsAggregationBuilder("t").field("t")
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(15),
        // We can't enable multiple segments per index for many of the tests above, because the clusters are too close.
            }
        final Map<Double, Double> expectedCentroidsOnlySearch = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
                assertThat(buckets.get(1).centroid(), both(greaterThanOrEqualTo(800.0)).and(lessThanOrEqualTo(1005.0)));
                v1.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::centroid).collect(toList()),
    public void testSimpleSubAggregations() throws IOException {
            LongTerms.Bucket t1 = terms.getBucketByKey("1");
        final Map<Double, Integer> expectedDocCountSearchReduce = new HashMap<>();
    }
 * compatible open source license.
            DEFAULT_QUERY,
        // Indexed by min
import org.apache.lucene.search.IndexSearcher;
        expectedDocCountOnlySearch.put(-0.4, 2);
                buckets.forEach(bucket -> {
             * This is what the result should be but it never gets called because of
 * Modifications Copyright OpenSearch Contributors. See
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(2).setShardSize(6).setInitialBuffer(4),
    }
            final Document document = new Document();
            )
 * this file be licensed under the Apache-2.0 license or a
                documents.add(document);
        expectedCentroidsOnlySearch.put(-0.4, 0.4);
        // Rerun the test with very large keys which can cause an overflow
            // Put all of the documents into one segment
                } else {
            dataset,
            }
    public void testComplexSubAggregations() throws IOException {
        final Map<Double, Double> expectedMins = new HashMap<>();
    private static final String NUMERIC_FIELD = "numeric";
                assertEquals(1, buckets.get(0).min(), deltaError);
            aggregation -> aggregation.field(NUMERIC_FIELD)
            histogram -> {
            dataset,
import org.apache.lucene.index.DirectoryReader;
                assertEquals(bucket.getKeyAsString(), expectedDocCount, bucket.getDocCount());
        expectedDocCount.put(-200d, 1);
            expectedDocCountBigKeys.put(Long.MAX_VALUE * keys.get(i), docCounts.get(i));
 * The OpenSearch Contributors require contributions made to
            aggregation -> aggregation.field(NUMERIC_FIELD).setInitialBuffer(3).setNumBuckets(3),
        // Corresponding keys (centroids): [ -147.5, 1116]
                assertEquals(1L, terms.getBuckets().get(0).getKey());
 */
                // Expected clusters: [ (1, 2), (5), (8,9) ]
                assertEquals(8, stats.getMin(), deltaError);
                .setInitialBuffer(12)
        expectedDocCount.put(-2.5, 2);
    // There should not be more than `shard_size` documents on a node, even when very distant documents appear
            IllegalArgumentException.class,
                .creationDate(System.currentTimeMillis())
                true,
                    double expectedCentroid = expectedCentroidsSearchReduce.getOrDefault(bucket.min(), 0d).doubleValue();
                });
import org.opensearch.cluster.metadata.IndexMetadata;
                    assertEquals(expectedMax, bucket.max(), doubleError);
        final List<Number> dataset = Arrays.asList(1, 2, 3);
                double deltaError = 1d / 10000d;
 * not use this file except in compliance with the License.
        final Query query,
import org.apache.lucene.util.NumericUtils;
 */
        expectedMaxes.put(1116.0d, 5400d);
import static java.util.stream.Collectors.toList;
        final List<Number> dataset = Arrays.asList(1, 2, 3);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                }
            dataset,
                assertTrue(AggregationInspectionHelper.hasValue(stats));
    }
        expectedCentroidsSearchReduce.put(8.8, 8.8);
    }
        // Once the cache is full, the algorithm creates (3/4 * shard_size = 4) initial buckets.
            histogram -> {
                assertEquals(bucket.getKeyAsString(), expectedMax, bucket.max(), doubleError);
    public void testMoreClustersThanDocs() throws Exception {
            expectedMaxesBigKeys.put(Long.MAX_VALUE * keys.get(i), Long.MAX_VALUE * maxes.get(i));
import org.apache.lucene.search.Query;
        expectedCentroidsOnlySearch.put(5.3, 5.6);
                DEFAULT_QUERY,
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setShardSize(10000).getInitialBuffer(), equalTo(50000));
import org.apache.lucene.index.IndexReader;
    public void testHugeShardSize() throws Exception {
            false,
            () -> new VariableWidthHistogramAggregationBuilder("test").setShardSize(1)
            buckets.forEach(bucket -> {
import org.opensearch.index.mapper.MappedFieldType;
                final MappedFieldType fieldType;
        }
        final List<Number> dataset = Arrays.asList(1, 2, 3, 4, 5, 10, 20, 50, 100, 5400, -900);
                .setNumBuckets(3)
        // However, these two clusters are so far apart that even if a doc from one ends up in the other,
            buckets.forEach(bucket -> {
                LongTerms terms = histogram.getBuckets().get(0).getAggregations().get("terms");
        return new IndexSettings(
        expectedMaxesSearchReduce.put(5.3, 5.9);
        );
                assertEquals(3L, stats.getMax(), deltaError);
import java.util.ArrayList;
 * this work for additional information regarding copyright
                assertEquals(8d, stats.getMin(), deltaError);
                .setShardSize(4)
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(4).setShardSize(6).setInitialBuffer(4),
        // Index these by min, rather than centroid, to avoid slight precision errors (Ex. 3.999999 vs 4.0) that arise from double division
        try (Directory directory = newDirectory()) {
            assertThat(
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor
            }
        );
                // The higher cluster
    public void testNewBucketLimit() throws Exception {
        expectedDocCountOnlySearch.put(2.26, 2);
                    assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount());
import org.opensearch.search.aggregations.metrics.InternalStats;
    }
        double doubleError = 1d / 10000d;
 * under the License.
            assertEquals(expectedDocCountOnlySearch.size(), buckets.size());
        expectedDocCountSearchReduce.put(5.3, 2);
        );
    }
            return doc.intValue();
import org.apache.lucene.tests.index.RandomIndexWriter;
            aggregation -> aggregation.field(NUMERIC_FIELD).setShardSize(1000000000),
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        testSearchCase(
        );
        // Expected clusters: [ (-1, 1), (3, 5), (7, 9), (11, 13), (15, 17),
    public void testLongs() throws Exception {
            );
                    long expectedDocCount = expectedDocCountBigKeys.getOrDefault(bucket.getKey(), 0).longValue();
                histogram -> {
            () -> testSearchCase(
    }
    }
            }
            }
        );
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 2), new SortedNumericDocValuesField("v", 20)));
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(3).setShardSize(6).setInitialBuffer(3),
            DEFAULT_QUERY,
        // Corresponding keys (centroids): [ 0.4, 2.78, 5.6, 8.8]
public class VariableWidthHistogramAggregatorTests extends AggregatorTestCase {
                assertEquals(11d, stats.getMax(), deltaError);
    }
 *
            indexWriter.addDocuments(documents);
                .setShardSize(3)
        final Map<Double, Double> expectedMins = new HashMap<>();
            dataset,
            DEFAULT_QUERY,
        final Map<Double, Double> expectedMins = new HashMap<>();
                .subAggregation(new StatsAggregationBuilder("stats").field(NUMERIC_FIELD)),
        );
        final List<Number> dataset = Arrays.asList(-3L, 10L, -200L);
                .setInitialBuffer(12)
            DEFAULT_QUERY,
        double doubleError = 1d / 10000d;
            }
        );
    public void testSmallInitialBuffer() throws Exception {
                assertEquals(expectedDocCount.getOrDefault(bucket.getKey(), 0).longValue(), bucket.getDocCount());
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                assertEquals(7d, stats.getMax(), deltaError);
            false,
        // Search (no reduce)
                DEFAULT_QUERY,
        expectedMaxesSearchReduce.put(-0.4, 1.2);
            true,
        expectedDocCount.put(1d, 1);
import org.opensearch.search.aggregations.AggregationBuilders;
                double deltaError = 1d / 10000d;
import org.opensearch.index.IndexSettings;
        }
            }
        // There should be two clusters: (1, 2, 3, 4, 5) and (1001, 1002, 1003, 1004, 1005)
    private void testSearchCase(
                .setInitialBuffer(4)
            DEFAULT_QUERY,
                    assertEquals(expectedDocCount, bucket.getDocCount());
        final List<Number> dataset = Arrays.asList(5L, -3L, 1L, -2L, 4L);
            false,
 *
                    assertEquals(expectedMaxes.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.max(), doubleError);
    public void testMultipleSegments() throws IOException {
        testSearchCase(
        // Slight randomization --> different caches in the aggregator --> different clusters
        expectedMaxesOnlySearch.put(8.8, 8.8);
        final Map<Double, Double> expectedMaxesOnlySearch = new HashMap<>();
import java.util.Map;
        throw new IOException("Document has an invalid type");
                assertTrue(AggregationInspectionHelper.hasValue(stats));
import org.opensearch.search.aggregations.AggregatorTestCase;
                });
        final Map<Double, Double> expectedMinsOnlySearch = new HashMap<>();
                double expectedMax = expectedMaxesOnlySearch.getOrDefault(bucket.getKey(), 0d).doubleValue();
                double deltaError = 1d / 10000d;
        final Map<Double, Double> expectedCentroidsSearchReduce = new HashMap<>();
    // A new bucket should be added when there is a document that is distant from all existing buckets
        expectedMins.put(-2.5, -3d);
        final Settings nodeSettings = Settings.builder().put("search.max_buckets", 25000).build();
                .setNumBuckets(2)
            InternalVariableWidthHistogram v2 = t2.getAggregations().get("v");
        );
                    assertEquals(expectedMaxes.getOrDefault(bucket.getKey(), 0d).doubleValue(), bucket.max(), doubleError);
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                final Document document = new Document();
                assertThat(buckets.get(0).getDocCount(), both(greaterThanOrEqualTo(4L)).and(lessThanOrEqualTo(7L)));
        testSearchCase(
import org.opensearch.common.settings.Settings;
                    histogram.getBuckets().stream().map(InternalVariableWidthHistogram.Bucket::getKey).collect(toList()),
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        testSearchCase(
                // Expected clusters: [ (0, 1, 2, 3), (4, 5, 6, 7), (8, 9, 10, 11) ]
        expectedMins.put(10d, 10d);
            histogram -> {
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                verify.accept(histogram);
import java.util.function.Consumer;
                // This is a test to make sure that the sub aggregations get reduced
                assertEquals(1L, terms.getBuckets().size(), deltaError);
                final List<InternalVariableWidthHistogram.Bucket> buckets = histogram.getBuckets();
                    double expectedCentroid = expectedMinsBigKeys.getOrDefault(bucket.getKey(), 0d).doubleValue();
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 1), new SortedNumericDocValuesField("v", 11)));
    }
            DEFAULT_QUERY,
import java.util.HashMap;
                stats = histogram.getBuckets().get(2).getAggregations().get("stats");
        testSearchCase(
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(4).setShardSize(6).setInitialBuffer(4),
                }
                    assertEquals(expectedMax, bucket.max(), doubleError);
        if (!multipleSegments) {
                histogram -> {
            return doc.longValue();
                assertEquals(4L, stats.getCount());
        expectedCentroidsOnlySearch.put(2.26, 2.78);
            IllegalArgumentException.class,
            DEFAULT_QUERY,
            dataset,
    @Override
                equalTo(List.of(1.0, 2.0, 3.0))
        } else if (doc instanceof Long) {
            false,
import static org.hamcrest.Matchers.equalTo;
        assertThat(new VariableWidthHistogramAggregationBuilder("test").setNumBuckets(3).getShardSize(), equalTo(150));
        Consumer<LongTerms> verify = terms -> {
            assertEquals(expectedDocCount.size(), buckets.size());
        final List<Number> dataset = Arrays.asList();
    }
import org.opensearch.index.mapper.NumberFieldMapper;
            histogram -> assertThat(
            histogram -> {
                true,
        final Map<Double, Double> expectedMaxesBigKeys = new HashMap<>();
        expectedCentroidsSearchReduce.put(5.3, 5.6);
        );
            DEFAULT_QUERY,
            // Create multiple segments in the index
        final List<Number> dataset,
        final List<Number> dataset = Arrays.asList(3.3, 8.8, 1.2, 5.3, 2.26, -0.4, 5.9);
            List<Document> documents = new ArrayList<>();
            aggregation -> aggregation.field(NUMERIC_FIELD).setNumBuckets(2).setShardSize(4).setInitialBuffer(5),
        expectedMaxesSearchReduce.put(8.8, 8.8);
            )
    public void testSubAggregationReduction() throws IOException {
        expectedMaxesSearchReduce.put(2.26, 3.3);
            () -> testCase(builder, DEFAULT_QUERY, buildIndex, verify, longField("t"), longField("v"))
        final Map<Double, Integer> expectedDocCountBigKeys = new HashMap<>();
            true,
                assertEquals(2, stats.getMax(), deltaError);
        expectedDocCount.put(-3d, 1);
                assertEquals(5, stats.getMin(), deltaError);
            IllegalArgumentException.class,
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(5, stats.getMax(), deltaError);
package org.opensearch.search.aggregations.bucket.histogram;
            for (final Number doc : dataset) {
                .numberOfReplicas(0)
                }
                buckets.forEach(bucket -> {
        });
                if (dataset.size() == 0 || dataset.get(0) instanceof Double) {
import java.io.IOException;
            histogram -> {
                .setNumBuckets(3)
            }
            });
            iw.addDocument(List.of(new SortedNumericDocValuesField("t", 1), new SortedNumericDocValuesField("v", 1)));
                long fieldVal = convertDocumentToSortableValue(doc);
        final List<Integer> docCounts = Arrays.asList(2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                .subAggregation(AggregationBuilders.stats("stats").field(NUMERIC_FIELD)),
                InternalStats stats = histogram.getBuckets().get(0).getAggregations().get("stats");
            expectedMaxesOnlySearch.put(keys.get(i), maxes.get(i));
                assertThat(buckets.get(0).centroid(), both(greaterThanOrEqualTo(0.0)).and(lessThanOrEqualTo(300.0)));
    public void testNewBucketCreation() throws Exception {
        expectedDocCount.put(1116.0d, 5);
        );
/*
            true,
        final Map<Double, Double> expectedMinsBigKeys = new HashMap<>();
            )
import org.apache.lucene.search.MatchAllDocsQuery;
        Exception e = expectThrows(
                    fail();
        }
        }
                assertEquals(4L, stats.getCount());
                    equalTo(List.of(1.0, 2.0, 3.0))
            IndexMetadata.builder("_index")
