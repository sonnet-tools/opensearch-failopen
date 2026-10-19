            final SearchResponse response = client().prepareSearch("fr_intra_agg")  
        for (Map.Entry<String, Long> entry : expected.entrySet()) {
import org.opensearch.search.aggregations.metrics.Avg;  
    protected void setupSuiteScopeCluster() throws Exception {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
            new Object[] {
import org.opensearch.index.query.QueryBuilders;  
        expected.clear();  
package org.opensearch.search.aggregations.bucket;
    public void testFilterRewriteWithIntraSegmentPartitioning() throws Exception {
            assertThat(innerTotal, equalTo(expectedTotal));
            // inner sub-agg value: every doc in a day-bucket has that same day's timestamp, so avg(date)
            // to the same value, but combined with the exact doc count above this pins the sub-agg down.
            .cluster()  
            .get();
     * min_segment_size=1000, so it is split; {@code force}: every segment split — all on top of the
        long total = 0;
import java.util.HashSet;
import static org.hamcrest.Matchers.equalTo;
            expected.put(dateTerm + "T00:00:00.000Z", (long) frequency);
            internalCluster().wipeIndices("fr_intra_agg");  
            List<IndexRequestBuilder> builders = new ArrayList<>(days * perDay);
            )
                String dateTerm = DateFormatter.forPattern("yyyy-MM-dd").format(time);
            total += bucket.getDocCount();
                total += bucket.getDocCount();
    }
        final Histogram allHisto1 = response.getAggregations().get("histo");
        assertThat(histo.getBuckets().size(), equalTo(expected.size()));
                assertNotNull("unexpected inner bucket " + dayBucket.getKeyAsString(), expectedCount);
    @ParametersFactory  
        final long expectedTotal = expected.values().stream().mapToLong(Long::longValue).sum();
import java.time.ZoneOffset;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            final Long expectedCount = expected.get(bucket.getKeyAsString());
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            .addAggregation(  
            assertEquals(expectedCount, (Long) bucket.getDocCount());  
            do {  
        return ((ZonedDateTime) bucket.getKey()).toInstant().toEpochMilli();
        return Arrays.asList(
            }  
            final List<IndexRequestBuilder> indexRequests = new ArrayList<>();  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
            for (Histogram.Bucket bucket : histo.getBuckets()) {
import java.util.Map;  
        final Histogram histo = response.getAggregations().get("histo");
        }
    /**
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            for (int j = 0; j < frequency; j++) {
/*  
 * compatible open source license.
                Settings.builder()
        assertEquals(updateSettingResponse.getTransientSettings().get(MAX_AGGREGATION_REWRITE_FILTERS.getKey()), "0");  
            .setSize(0)  
    }
            .setTransientSettings(Settings.builder().putNull(MAX_AGGREGATION_REWRITE_FILTERS.getKey()))
        allHisto.getBuckets().forEach(bucket -> results.put(bucket.getKeyAsString(), bucket.getDocCount()));  
import org.opensearch.common.time.DateFormatter;
        try {
            final Avg avg = bucket.getAggregations().get("avg_ts");
            // parent bucket doc count matches the indexed per-day frequency exactly (no per-partition duplication)  
            // the balanced strategy deterministically splits it (not just distributes whole segments).
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")  
                    .calendarInterval(DateHistogramInterval.MONTH)
     * (~2500 docs). Each strategy exercises a distinct path over the same data — {@code segment}: no  
        }
            assertThat(monthBucket.getDocCount(), equalTo(expectedTotal));
            total += monthBucket.getDocCount();  
    /** Epoch-millis of a date_histogram bucket key (the bucket's start instant). */
        }
            final Histogram histo = response.getAggregations().get("histo");
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment")
        SearchResponse response = client().prepareSearch("idx")
        final SearchResponse response = client().prepareSearch("idx")
        final SearchResponse allResponse = client().prepareSearch("idx")
                        .subAggregation(avg("avg_ts").field("date"))
                    .subAggregation(dateHistogram("inner").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(1))  
            new Object[] {
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
            .prepareUpdateSettings()
import java.util.HashMap;  
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
                dateHistogram("histo").field("date")
                assertNotNull(bucket.getAggregations().get("avg_ts"));
        final int repeat = randomIntBetween(2, 10);
                longTerm = randomInt(repeat * 2);
            .get();
    public void testDateHistogramWithSubAggMatchesExpected() throws Exception {
        client().admin()
        final Histogram allHisto = allResponse.getAggregations().get("histo");
            .setQuery(QUERY)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                        .calendarInterval(DateHistogramInterval.DAY)
    /** date_histogram + sub-agg: per-bucket doc counts must match the indexed per-day frequencies exactly. */  
        assertThat(histo.getBuckets().size(), equalTo(1));  
            // inner buckets cover every indexed day and sum to the parent bucket count  
                    .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)  
        for (int i = 0; i < repeat; i++) {
import org.opensearch.index.query.QueryBuilder;
                    client().prepareIndex("idx")  
            // one segment per shard (~2500 docs) so a single segment exceeds the per-shard fair share and
    public void testNestedRangeDateHistogram() throws Exception {
            .addAggregation(
                innerTotal += dayBucket.getDocCount();
                    .build() },
                .setSize(0)
import java.util.ArrayList;  
        }  
            // equals the bucket key's epoch-millis. A per-partition-duplicated collection would still average  
        }  
            .prepareUpdateSettings()
    // simulate segment level match all
        assertAcked(client().admin().indices().prepareCreate("idx").get());
            assertThat(histo.getBuckets().size(), equalTo(days));  
                )
            new Object[] {  
            long innerTotal = 0;
            // inner sub-agg: per-day bucket doc counts must match the indexed per-day frequencies exactly
            assertThat(total, equalTo((long) days * perDay));
                            .setSource(jsonBuilder().startObject().field("date", dateTerm).field("match", true).endObject())  
        long total = 0;
public class FilterRewriteIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
            long longTerm;
            for (Histogram.Bucket dayBucket : inner.getBuckets()) {  
        super(dynamicSettings);  
        response = client().prepareSearch("idx")
            .cluster()
            indexRandomForConcurrentSearch("fr_intra_agg");
    }
            assertNotNull("unexpected bucket " + bucket.getKeyAsString(), expectedCount);
                    .build() }
        assertThat(total, equalTo(expectedTotal));
            .get();
            final Histogram inner = monthBucket.getAggregations().get("inner");  
            assertNotNull(inner);
            .setSize(0)  
            final int frequency = randomBoolean() ? 1 : randomIntBetween(2, 20);  
                Settings.builder()  
        assertEquals(allHisto1, allHisto2);  
        );  
    }
                }
}  
        final Histogram allHisto2 = response.getAggregations().get("histo");
                .get();  
 * SPDX-License-Identifier: Apache-2.0
                    );
import static org.opensearch.search.SearchService.MAX_AGGREGATION_REWRITE_FILTERS;
import java.util.Arrays;
     * cross-shard reduce. Asserts date_histogram + sub-agg counts stay exact under every strategy.  
                    .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
        } finally {
            }
     * Multi-shard intra-segment coverage: 5000 docs / 50 days across 2 shards, one large segment per shard
    public void testDisableOptimizationGivesSameResults() throws Exception {
            .addAggregation(dateHistogram("histo").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(0))
                    dateHistogram("histo").field("date")
    public FilterRewriteIT(Settings dynamicSettings) {
                        client().prepareIndex("fr_intra_agg")
        ensureSearchable();  
    /** Nested date_histogram (month -> day): per-bucket counts match indexed totals under every strategy. */
            } while (!longTerms.add(longTerm));
        final ClusterUpdateSettingsResponse updateSettingResponse = client().admin()  
            .setSize(0)  
            .addAggregation(dateHistogram("histo").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(0))
            )
                );
                    .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true)
            for (int d = 0; d < days; d++) {  
     */
                assertThat(bucket.getDocCount(), equalTo((long) perDay));  
        // doc count is the full total, and the inner DAY histogram's buckets map 1:1 to the per-day frequencies.
            .setSize(0)
import java.util.Collection;
            .setQuery(QUERY)  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                ZonedDateTime time = base.plusDays(d);
            .setQuery(QUERY)
 * this file be licensed under the Apache-2.0 license or a
        final SearchResponse response = client().prepareSearch("idx")  
                    .calendarInterval(DateHistogramInterval.DAY)
    public void testMinDocCountOnDateHistogram() throws Exception {  
                indexRequests.add(
                final Long expectedCount = expected.get(dayBucket.getKeyAsString());
            assertThat(avg.getValue(), equalTo(bucketEpochMillis(bucket)));
            .addAggregation(dateHistogram("histo").field("date").calendarInterval(DateHistogramInterval.DAY).minDocCount(0))
    }  
import org.opensearch.action.index.IndexRequestBuilder;
                        .minDocCount(1)  
    @Override  
import org.opensearch.action.search.SearchResponse;
                Settings.builder()
 *
            indexBulkWithSegments(builders, 1);  
                        .setSource(jsonBuilder().startObject().field("date", dateTerm).field("match", true).endObject())
        final long expectedTotal = expected.values().stream().mapToLong(Long::longValue).sum();
    }
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force")
            ZonedDateTime time = ZonedDateTime.of(2024, 1, ((int) longTerm) + 1, 0, 0, 0, 0, ZoneOffset.UTC);  
    private static final Map<String, Long> expected = new HashMap<>();  
import org.opensearch.common.settings.Settings;  
    private static final QueryBuilder QUERY = QueryBuilders.termQuery("match", true);
    }
        final Histogram histo = response.getAggregations().get("histo");
@OpenSearchIntegTestCase.SuiteScopeTestCase
        Map<String, Long> results = new HashMap<>();
            assertNotNull(avg);  
    }
                .addAggregation(  
        // All indexed dates fall in January 2024, so the outer MONTH histogram has exactly one bucket whose  
import java.time.ZonedDateTime;
                    .subAggregation(avg("avg_ts").field("date"))  
            .get();
            .get();  
        createIndex("fr_intra_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 0).build());  
                    builders.add(
import java.util.List;
                dateHistogram("histo").field("date")  
                for (int j = 0; j < perDay; j++) {  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;  
            int days = 50;
            }  
            long total = 0;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setSize(0)
 */  
            ZonedDateTime base = ZonedDateTime.of(2024, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    .minDocCount(1)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            }  
            indexRandom(true, false, indexRequests);  
            // Concurrent search across the three partition strategies
            assertThat(inner.getBuckets().size(), equalTo(expected.size()));
                assertEquals(expectedCount, (Long) dayBucket.getDocCount());  
        assertThat(total, equalTo(expectedTotal));
            .get();
            .get();
            .setTransientSettings(Settings.builder().put(MAX_AGGREGATION_REWRITE_FILTERS.getKey(), 0))  
                    .build() },  
import java.util.Set;
                .setQuery(QUERY)
            assertEquals(entry.getValue(), results.get(entry.getKey()));  
            // parent bucket doc count
     * intra-partitioning; {@code balanced}: the segment exceeds the per-shard fair share and
            String dateTerm = DateFormatter.forPattern("yyyy-MM-dd").format(time);
        final Set<Long> longTerms = new HashSet<>();  
    public static Collection<Object[]> parameters() {
        for (Histogram.Bucket monthBucket : histo.getBuckets()) {  
    private static double bucketEpochMillis(Histogram.Bucket bucket) {  
 * The OpenSearch Contributors require contributions made to  
            int perDay = 100; // 50 * 100 = 5000 docs  
