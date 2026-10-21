                    client().prepareIndex("idx")
                .addAggregation(
        // All indexed dates fall in January 2024, so the outer MONTH histogram has exactly one bucket whose
            // Concurrent search across the three partition strategies
                .setQuery(QUERY)
            // inner buckets cover every indexed day and sum to the parent bucket count
            assertNotNull(inner);
            .addAggregation(dateHistogram("histo").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(0))
            indexRandom(true, false, indexRequests);
            .cluster()
import java.util.Collection;
        assertAcked(client().admin().indices().prepareCreate("idx").get());
import java.util.HashSet;
            assertEquals(entry.getValue(), results.get(entry.getKey()));
    // simulate segment level match all
                Settings.builder()
                    builders.add(
        final long expectedTotal = expected.values().stream().mapToLong(Long::longValue).sum();
            assertNotNull("unexpected bucket " + bucket.getKeyAsString(), expectedCount);
        final SearchResponse allResponse = client().prepareSearch("idx")
            assertNotNull(avg);
                    .subAggregation(dateHistogram("inner").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(1))
            .setSize(0)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
            .prepareUpdateSettings()
            indexBulkWithSegments(builders, 1);
        ensureSearchable();
            .get();
                assertThat(bucket.getDocCount(), equalTo((long) perDay));
import java.util.Arrays;
        } finally {
            .get();
            new Object[] {
        assertThat(histo.getBuckets().size(), equalTo(expected.size()));
                    .build() },
 *
    private static final Map<String, Long> expected = new HashMap<>();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public void testDateHistogramWithSubAggMatchesExpected() throws Exception {
    /** Epoch-millis of a date_histogram bucket key (the bucket's start instant). */
        }
            .addAggregation(dateHistogram("histo").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(0))
                    .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
            total += monthBucket.getDocCount();
            for (int j = 0; j < frequency; j++) {
                    .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
            .setSize(0)
                ZonedDateTime time = base.plusDays(d);
        long total = 0;
            assertThat(innerTotal, equalTo(expectedTotal));
            .addAggregation(
        }
            assertThat(avg.getValue(), equalTo(bucketEpochMillis(bucket)));
                        .subAggregation(avg("avg_ts").field("date"))
    public FilterRewriteIT(Settings dynamicSettings) {
    @ParametersFactory
    /** Nested date_histogram (month -> day): per-bucket counts match indexed totals under every strategy. */
import java.util.List;
        }
                total += bucket.getDocCount();
            .cluster()
    public void testNestedRangeDateHistogram() throws Exception {
                .setSize(0)
            assertThat(histo.getBuckets().size(), equalTo(days));
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            } while (!longTerms.add(longTerm));
            // equals the bucket key's epoch-millis. A per-partition-duplicated collection would still average
    }
        assertThat(total, equalTo(expectedTotal));
            // to the same value, but combined with the exact doc count above this pins the sub-agg down.
                String dateTerm = DateFormatter.forPattern("yyyy-MM-dd").format(time);
import org.opensearch.index.query.QueryBuilders;
            for (int d = 0; d < days; d++) {
                Settings.builder()
        final ClusterUpdateSettingsResponse updateSettingResponse = client().admin()
                    dateHistogram("histo").field("date")
public class FilterRewriteIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
            .get();
                assertNotNull(bucket.getAggregations().get("avg_ts"));
        client().admin()
    public void testDisableOptimizationGivesSameResults() throws Exception {
            final Long expectedCount = expected.get(bucket.getKeyAsString());
            .get();
        for (Histogram.Bucket monthBucket : histo.getBuckets()) {
            final SearchResponse response = client().prepareSearch("fr_intra_agg")
        final Histogram histo = response.getAggregations().get("histo");
            .addAggregation(dateHistogram("histo").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(0))
     * Multi-shard intra-segment coverage: 5000 docs / 50 days across 2 shards, one large segment per shard
                    .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
import static org.opensearch.search.SearchService.MAX_AGGREGATION_REWRITE_FILTERS;
            for (Histogram.Bucket dayBucket : inner.getBuckets()) {
            total += bucket.getDocCount();
                    .calendarInterval(DateHistogramInterval.DAY)
            }
    public static Collection<Object[]> parameters() {
    private static final QueryBuilder QUERY = QueryBuilders.termQuery("match", true);
            }
        return ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli();
                .get();
            indexRandomForConcurrentSearch("fr_intra_agg");
                )
        expected.clear();
import org.opensearch.common.settings.Settings;
        final Set<Long> longTerms = new HashSet<>();
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment")
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        createIndex("fr_intra_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());
            final List<IndexRequestBuilder> indexRequests = new ArrayList<>();
/*
        for (int i = 0; i < repeat; i++) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                }
 * The OpenSearch Contributors require contributions made to
            .setSize(0)
            // parent bucket doc count matches the indexed per-day frequency exactly (no per-partition duplication)
            .addAggregation(
            // inner sub-agg value: every doc in a day-bucket has that same day's timestamp, so avg(date)
        final SearchResponse response = client().prepareSearch("idx")
                        client().prepareIndex("fr_intra_agg")
 * compatible open source license.
import java.util.HashMap;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            .get();
     * min_segment_size=1000, so it is split; {@code force}: every segment split — all on top of the
        super(dynamicSettings);
import java.time.ZoneOffset;
    public void testMinDocCountOnDateHistogram() throws Exception {
    }
                    );
import org.opensearch.common.time.DateFormatter;
     * (~2500 docs). Each strategy exercises a distinct path over the same data — {@code segment}: no
        final long expectedTotal = expected.values().stream().mapToLong(Long::longValue).sum();
            expected.put(dateTerm + "T00:00:00.000Z", (long) frequency);
                        .calendarInterval(DateHistogramInterval.DAY)
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
            int perDay = 100; // 50 * 100 = 5000 docs
    /** date_histogram + sub-agg: per-bucket doc counts must match the indexed per-day frequencies exactly. */
                assertNotNull("unexpected inner bucket " + dayBucket.getKeyAsString(), expectedCount);
import org.opensearch.search.aggregations.metrics.Avg;
@OpenSearchIntegTestCase.SuiteScopeTestCase
    public void testFilterRewriteWithIntraSegmentPartitioning() throws Exception {
        try {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    /**
import java.util.Set;
import java.util.ArrayList;
        response = client().prepareSearch("idx")
            .setTransientSettings(Settings.builder().put(MAX_AGGREGATION_REWRITE_FILTERS.getKey(), 0))
        }
        return Arrays.asList(
    protected void setupSuiteScopeCluster() throws Exception {
            assertEquals(expectedCount, (Long) bucket.getDocCount());
                    .calendarInterval(DateHistogramInterval.MONTH)
            }
                        .setSource(jsonBuilder().startObject().field("date", dateTerm).field("match", true).endObject())
                Settings.builder()
                );
                dateHistogram("histo").field("date")
        final int repeat = randomIntBetween(2, 10);
        assertEquals(updateSettingResponse.getTransientSettings().get(MAX_AGGREGATION_REWRITE_FILTERS.getKey()), "0");
     * intra-partitioning; {@code balanced}: the segment exceeds the per-shard fair share and
            new Object[] {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        final Histogram allHisto2 = response.getAggregations().get("histo");
    }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        // doc count is the full total, and the inner DAY histogram's buckets map 1:1 to the per-day frequencies.
     */
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
        final Histogram histo = response.getAggregations().get("histo");
            .get();
    }
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force")
            .setSize(0)
            .setSize(0)
                longTerm = randomInt(repeat * 2);
                for (int j = 0; j < perDay; j++) {
                        .minDocCount(1)
            assertThat(inner.getBuckets().size(), equalTo(expected.size()));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
                    .subAggregation(avg("avg_ts").field("date"))
import org.opensearch.index.query.QueryBuilder;
            int days = 50;
        allHisto.getBuckets().forEach(bucket -> results.put(bucket.getKeyAsString(), bucket.getDocCount()));
            do {
            .prepareUpdateSettings()
            }
            // inner sub-agg: per-day bucket doc counts must match the indexed per-day frequencies exactly
                indexRequests.add(
        final Histogram allHisto1 = response.getAggregations().get("histo");
import java.util.Map;
        Map<String, Long> results = new HashMap<>();
            .setTransientSettings(Settings.builder().putNull(MAX_AGGREGATION_REWRITE_FILTERS.getKey()))
    }
                innerTotal += dayBucket.getDocCount();
        final Histogram allHisto = allResponse.getAggregations().get("histo");
                final Long expectedCount = expected.get(dayBucket.getKeyAsString());
            ZonedDateTime time = ZonedDateTime.of(2024, 1, ((int) longTerm) + 1, 0, 0, 0, 0, ZoneOffset.UTC);
        }
     * cross-shard reduce. Asserts date_histogram + sub-agg counts stay exact under every strategy.
            // one segment per shard (~2500 docs) so a single segment exceeds the per-shard fair share and
import org.opensearch.action.index.IndexRequestBuilder;
            )
 * SPDX-License-Identifier: Apache-2.0
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
}
        assertThat(histo.getBuckets().size(), equalTo(1));
        final SearchResponse response = client().prepareSearch("idx")
            long innerTotal = 0;
            ZonedDateTime base = ZonedDateTime.of(2024, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            internalCluster().wipeIndices("fr_intra_agg");
                    .build() }
            final Histogram histo = response.getAggregations().get("histo");
            // parent bucket doc count
                dateHistogram("histo").field("date")
        assertThat(total, equalTo(expectedTotal));
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        SearchResponse response = client().prepareSearch("idx")
package org.opensearch.search.aggregations.bucket;
import java.time.ZonedDateTime;
            long total = 0;
        for (Map.Entry<String, Long> entry : expected.entrySet()) {
                    .minDocCount(1)
    private static double bucketEpochMillis(Histogram.Bucket bucket) {
            .setQuery(QUERY)
            new Object[] {
            final Avg avg = bucket.getAggregations().get("avg_ts");
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
            final Histogram inner = monthBucket.getAggregations().get("inner");
            String dateTerm = DateFormatter.forPattern("yyyy-MM-dd").format(time);
            final int frequency = randomBoolean() ? 1 : randomIntBetween(2, 20);
            long longTerm;
            // the balanced strategy deterministically splits it (not just distributes whole segments).
                assertEquals(expectedCount, (Long) dayBucket.getDocCount());
            List<IndexRequestBuilder> builders = new ArrayList<>(days * perDay);
        assertEquals(allHisto1, allHisto2);
import static org.hamcrest.Matchers.equalTo;
            )
            for (Histogram.Bucket bucket : histo.getBuckets()) {
        long total = 0;
    }
    }
                    .build() },
                            .setSource(jsonBuilder().startObject().field("date", dateTerm).field("match", true).endObject())
            .get();
    @Override
import org.opensearch.action.search.SearchResponse;
            .setQuery(QUERY)
            .setQuery(QUERY)
            assertThat(monthBucket.getDocCount(), equalTo(expectedTotal));
            assertThat(total, equalTo((long) days * perDay));
        for (Histogram.Bucket bucket : histo.getBuckets()) {
 */
