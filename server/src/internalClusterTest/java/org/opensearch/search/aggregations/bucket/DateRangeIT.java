        Mar 15, Apr 16,     3
        List<Bucket> buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        assertThat((String) bucket.getKey(), equalTo("r3"));
        assertThat(bucket.getToAsString(), nullValue());
        assertBucket(buckets.get(1), 1L, "00:50:00-01:06:40", 3000000L, 4000000L);
        assertThat(bucket.getDocCount(), equalTo(2L));
@OpenSearchIntegTestCase.SuiteScopeTestCase
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        );
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat(range, notNullValue());
            )
                        ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
                    .addRange("2012-02-15", "2012-03-15")
        assertSearchResponse(response);
import org.opensearch.script.Script;
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));
        assertBucket(buckets.get(0), 2L, "00.16.40-00.50.00", 1000000L, 3000000L);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    }
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
/*
                .getHitCount(),
        assertThat(bucket.getDocCount(), equalTo(2L));
        for (int i = docs.size(); i < numDocs; ++i) {
                dateRange("range").field("date")
                    .addRange(date(2, 15), date(3, 15))
                    .addRange(
        Feb 15, Mar 16,     3
                .getTotal()
        Jan 2,  Feb 3,      1
        assertThat(sum, notNullValue());
        Mar 2,  Apr 3,      4
        bucket = buckets.get(2);
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
            client().prepareIndex(indexName).setId("2").setSource(jsonBuilder().startObject().field("date", "00:33:20").endObject()),
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
            )
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
                    .addUnboundedFrom("2012-02-15||+1M")
        // providing different numeric input with format should work, but bucket
        assertThat(bucket, notNullValue());
                .getTotal()
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        sum = bucket.getAggregations().get("sum");
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
     * values specified as Strings
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(((InternalAggregation) range).getProperty("_bucket_count"), equalTo(3));
            )
        assertThat(((ZonedDateTime) bucket.getFrom()).toInstant().toEpochMilli(), equalTo(expectedFrom));
    }
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        assertThat((String) bucket.getKey(), equalTo("a long time ago"));
                .indices()
        assertSearchResponse(r);
        assertThat(bucket.getDocCount(), equalTo(0L));
        Mar 2,  Apr 3,      4
                dateRange("date_range").field("date").addRange(1000000, 3000000).addRange(3000000, 4000000).format("epoch_millis")
        assertThat(buckets.size(), equalTo(3));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .addRange(date(2, 15), date(3, 15))
        indexRandom(true, docs);
                rangeBuilder.addUnboundedTo("a long time ago", "now-50y")
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 1)).endObject()),
        assertAcked(prepareCreate(indexName).setMapping("date", "type=date,format=strict_hour_minute_second"));
            .get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        // using different format should work when to/from is compatible with
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));
        SearchResponse response = client().prepareSearch("idx")
        assertBucket(buckets.get(0), 2L, "00:16:40-00:50:00", 1000000L, 3000000L);
        Range.Bucket bucket = buckets.get(0);
                    .addUnboundedTo("2012-02-15")
                .getTotal()
import org.opensearch.plugins.Plugin;
    /*
        assertThat(bucket, notNullValue());
                    .addUnboundedTo(date(2, 15))
        assertThat(bucket, notNullValue());
                .get()
        assertSearchResponse(response);
            .setSize(0)
        SearchResponse r = client().prepareSearch("cache_test_idx")
import org.opensearch.action.search.SearchPhaseExecutionException;
            .get();
                .prepareStats("cache_test_idx")
            .addAggregation(dateRange("date_range").field("date").addRange("1000", "3000").addRange("3000", "4000"))
        // mapping
            .addAggregation(
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
                    .addUnboundedFrom(date(3, 15))
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
     * values specified as numeric value
                    .addRange("r2", date(2, 15), date(3, 15))
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
                .getMissCount(),
                .getTotal()
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
                    .addUnboundedTo("2012-02-15")
                .prepareStats("cache_test_idx")
    /*
                dateRange("range").field("date")
        assertThat(e.getDetailedMessage(), containsString("failed to parse date field [1000000] with format [strict_hour_minute_second]"));
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        Histogram.Bucket bucket = histo.getBuckets().get(1);
    public void testRangeWithFormatNumericValue() throws Exception {
        assertThat(bucket.getToAsString(), nullValue());
            )
                    .addUnboundedTo(date(2, 15))
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
            client().prepareIndex(indexName).setId("1").setSource(jsonBuilder().startObject().field("date", "00:16:40").endObject()),
        assertThat(buckets.size(), is(2));
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        try {
                    .addUnboundedFrom("2012-03-15")
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
     */
        indexRandom(
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket, notNullValue());
import static org.hamcrest.Matchers.containsString;
                    .subAggregation(dateRange("date_range").field("value").addRange("0-1", 0, 1))
    }
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        // Ensure that non-scripted requests are cached as normal
        assertThat(range.getName(), equalTo("range"));
                dateRange("foo").field("date")
        assertThat(dateRange.getName(), equalTo("date_range"));
import org.opensearch.action.index.IndexRequestBuilder;
    }
     */
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
                    .addRange(date(2, 15), date(3, 15))
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
                    .interval(1L)
        Apr 2,  May 3,      4
import java.util.HashMap;
        assertThat(((ZonedDateTime) buckets.get(0).getTo()).toInstant().toEpochMilli(), equalTo(1L));
            .addAggregation(
        );
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
                dateRange("range").field("date")
        bucket = buckets.get(2);
                .indices()
        // different now
        assertThat(bucket, notNullValue());
        Mar 15, Apr 16,     3
        assertSearchResponse(response);
    private static IndexRequestBuilder indexDoc(int month, int day, int value) throws Exception {
        assertThat(bucket.getToAsString(), equalTo("2012-03-15"));
            equalTo(1L)
            .get();
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket.getKeyAsString(), equalTo("last year"));
        assertThat(bucket.getToAsString(), nullValue());
     * Ensure requests using nondeterministic scripts do not get cached.
            equalTo(0L)
        String indexName = "dateformat_numeric_test_idx";
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat((String) bucket.getKey(), equalTo("r1"));
     * Test querying ranges on date mapping specifying a format with to/from
                dateRange("foo").field("date")
        assertThat(bucket, notNullValue());
    public void testPartiallyUnmapped() throws Exception {
        Range.Bucket bucket = buckets.get(0);
                    .addUnboundedFrom(date(3, 15))
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.DOUBLE_PLUS_ONE_MONTH, params))
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        Mar 15, Apr 16      5
        assertAcked(prepareCreate("empty_bucket_idx").setMapping("value", "type=integer"));
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
    public void testScriptCaching() throws Exception {
        assertThat(bucket, notNullValue());
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) range).getProperty("_count");
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000" + mar15Suffix));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
    }
    }
        SearchResponse response = client().prepareSearch("idx_unmapped")
        assertThat(bucket, notNullValue());
                    .addUnboundedFrom("r3", date(3, 15))
        // mapping
        SearchResponse response = client().prepareSearch("idx")
        }
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
            .get();
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        assertThat(buckets.size(), equalTo(3));
                    )
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(range.getName(), equalTo("range"));
        List<? extends Bucket> buckets = range.getBuckets();
    /*
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.DOUBLE_PLUS_ONE_MONTH, params))
        assertSearchResponse(response);
        assertThat(bucket.getDocCount(), equalTo(2L));
     */
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        assertThat(range.getBuckets().size(), equalTo(3));
    }
        Range.Bucket bucket = buckets.get(0);
    public void testSingleValueField() throws Exception {
                .setRequestCache(true)
        createIndex("idx");
        assertThat((String) bucket.getKey(), equalTo("last year"));
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat((String) propertiesKeys[2], equalTo("r3"));
            prepareCreate("cache_test_idx").setMapping("date", "type=date")
            )
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private static ZonedDateTime date(int month, int day, ZoneId timezone) {
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15"));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        bucket = buckets.get(2);
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        client().admin().cluster().prepareHealth("idx_unmapped").setWaitForYellowStatus().get();
import org.opensearch.script.ScriptType;
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(sum.getValue(), equalTo((double) 3 + 4));
        // Test that a request using a deterministic script gets cached
                    .addRange("2012-02-15", "2012-03-15")
                    .addUnboundedTo(date(2, 15))
                    .addRange(date(2, 15), date(3, 15))
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
        Range range = response.getAggregations().get("range");
            .addAggregation(
                .setSize(0)
            equalTo(0L)
        assertThat(dateRange, Matchers.notNullValue());
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
            equalTo(0L)
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        bucket = buckets.get(1);
            .addAggregation(
    }
                .getTotal()
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        bucket = buckets.get(2);
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));
            .get();
                        ZonedDateTime.of(2013, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
                    .timeZone(timezone)
            .get();
        assertThat(range, notNullValue());
        }
        assertThat(bucket.getDocCount(), equalTo(2L));
            .get();
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        assertThat(sum.getValue(), equalTo((double) 1 + 2));
        Range range = response.getAggregations().get("range");
                    .addUnboundedFrom("2012-03-15")
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getToAsString(), nullValue());
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        bucket = buckets.get(1);
        } catch (SearchPhaseExecutionException spee) {
                indexDoc(1, 2, 1),  // Jan 2
    }
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        long expectedFirstBucketCount = timeZoneOffset < 0 ? 3L : 2L;
        }
                .addAggregation(dateRange("date_range").field("date").addRange(1000000, 3000000).addRange(3000000, 4000000))
    public void testScriptMultiValued() throws Exception {
            .setSize(0)
            );
        List<Range.Bucket> buckets = new ArrayList<>(range.getBuckets());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        // using no format should work when to/from is compatible with format in
    public void testSingleValueFieldWithStringDates() throws Exception {
                .getRequestCache()
        );
 * this file be licensed under the Apache-2.0 license or a
        assertThat((String) propertiesKeys[1], equalTo("r2"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L));
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        Feb 2,  Mar 3,      1
        assertThat((String) bucket.getKey(), equalTo(expectedKey));
        internalCluster().wipeIndices(indexName);
        assertThat(bucket.getDocCount(), equalTo(expectedFirstBucketCount));
            docs.add(indexDoc(randomIntBetween(6, 10), randomIntBetween(1, 20), randomInt(100)));
        assertThat(bucket.getKeyAsString(), equalTo("recently"));
                    .timeValue(date(month + 1, day + 1))
    /**
                    .addUnboundedTo(date(2, 15))
                .get()
                indexDoc(2, 15, 3), // Feb 15
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
            client().admin()
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) range).getProperty("sum.value");
        assertThat(((ZonedDateTime) buckets.get(0).getFrom()).toInstant().toEpochMilli(), equalTo(0L));
                    .addUnboundedTo("r1", date(2, 15))
        SearchResponse response = client().prepareSearch("idx")
 * The OpenSearch Contributors require contributions made to
        assertThat(buckets.size(), equalTo(3));
        assertThat(bucket, notNullValue());
                    .addUnboundedFrom("last year", "now-1y")
        params.put("fieldname", "date");
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
 * under the License.
            equalTo(0L)
            )
     * Test querying ranges on date mapping specifying a format with to/from
                    .addUnboundedFrom(date(3, 15))
                indexDoc(3, 23, 6)  // Mar 23
            .setSize(0)
                indexDoc(3, 15, 5), // Mar 15
        Jan 2,  Feb 3,      1
 * specific language governing permissions and limitations
        params.put("fieldname", "date");
        List<Range.Bucket> buckets = new ArrayList<>(dateRange.getBuckets());
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
                    .timeField("date", date(month, day))
        assertThat(buckets.get(0).getDocCount(), equalTo(0L));
        assertThat(buckets.size(), equalTo(3));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
                    .startArray("dates")
        List<IndexRequestBuilder> docs = new ArrayList<>();
            .get();
        Feb 2,  Mar 3,      1
    }
 *
            .setSource(
    public void testSingleValueFieldWithStringDatesWithCustomFormat() throws Exception {
import java.time.ZoneOffset;
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
                .indices()
            client().admin()
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
     */
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
                .getMissCount(),
        assertThat(
        );
    }
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(bucket, notNullValue());
    /*
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [my_date_range_agg] aggregation");
        assertThat(bucket.getDocCount(), equalTo(0L));
                .prepareStats("cache_test_idx")
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(range.getName(), equalTo("range"));
    }
        assertThat(bucket, notNullValue());
import static org.hamcrest.core.IsNull.notNullValue;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertAcked(
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));
            .get();
        assertBucket(buckets.get(1), 1L, "3000000-4000000", 3000000L, 4000000L);
        );
            .addAggregation(
        bucket = buckets.get(1);
import java.time.ZonedDateTime;
            equalTo(2L)
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
            client().prepareIndex(indexName).setId("3").setSource(jsonBuilder().startObject().field("date", "00:50:00").endObject())
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertSearchResponse(response);
        indexRandom(
                .prepareStats("cache_test_idx")
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L));
            client().admin()
        }
        assertThat(range.getName(), equalTo("range"));
                    .addRange(date(2, 15), date(3, 15))
        assertThat(bucket.getKeyAsString(), equalTo("a long time ago"));
        Range.Bucket bucket = buckets.get(0);
 * Licensed to Elasticsearch under one or more contributor
        assertThat(range, notNullValue());
        Apr 15, May 16      5
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
                dateRange("range").field("dates")
        assertThat(
        bucket = buckets.get(1);
        assertThat(
                    .addRange("2012-02-15", "2012-03-15")
                .getRequestCache()
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket, notNullValue());
        assertBucket(buckets.get(1), 1L, "00.50.00-01.06.40", 3000000L, 4000000L);
            )
        assertThat(range, notNullValue());
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat(bucket.getFromAsString(), nullValue());
 * this work for additional information regarding copyright
        // Make sure we are starting with a clear cache
        assertThat((double) propertiesCounts[0], equalTo((double) 1 + 2));
                .prepareStats("cache_test_idx")
            .setSize(0)
            )
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat(dateRange.getName(), equalTo(expectedAggName));
            client().admin()
        assertBucket(buckets.get(0), 2L, "1000000-3000000", 1000000L, 3000000L);
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        Range range = response.getAggregations().get("range");
     */
        assertThat(bucket.getToAsString(), nullValue());
                    .addUnboundedTo("2012-02-15")
    }
            )
            .addAggregation(dateRange("date_range").field("date").addRange("00:16:40", "00:50:00").addRange("00:50:00", "01:06:40"))
    }
                    .addUnboundedFrom("2012-03-15")
        assertThat(bucket, notNullValue());
        assertThat(
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat((long) propertiesDocCounts[0], equalTo(2L));
            docs.add(
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
import static org.hamcrest.Matchers.instanceOf;
        Mar 2,  Apr 3,      2
    public void testSingleValueFieldWithCustomKey() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .addRange(
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                .getRequestCache()
            .addAggregation(
        assertThat(buckets.size(), equalTo(3));
        );
        return buckets;
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getToAsString(), nullValue());
import java.util.Arrays;
        Apr 15, May 16      5
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
                .getRequestCache()
        DateRangeAggregationBuilder rangeBuilder = dateRange("range");
        assertThat(range, notNullValue());
                dateRange("date_range").field("date").addRange(1000000, 3000000).addRange(3000000, 4000000).format("epoch_millis")
        assertThat(bucket, notNullValue());
                .get()
}
            .get();
            true,
        assertBucket(buckets.get(1), 1L, "3000-4000", 3000000L, 4000000L);
            .get();
        assertThat(bucket.getToAsString(), nullValue());
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(bucket.getDocCount(), equalTo(2L));
                .get()
/*
                    .timeZone(ZoneId.of("Etc/GMT+5"))
        searchResponse = client().prepareSearch(indexName)
        params.put("fieldname", "dates");
        assertThat(range.getName(), equalTo("range"));
        sum = bucket.getAggregations().get("sum");
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
            equalTo(0L)
            .setSize(0)
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(range.getName(), equalTo("range"));
        bucket = buckets.get(1);
        assertSearchResponse(response);
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000" + feb15Suffix));
    private static ZonedDateTime date(int month, int day) {
        searchResponse = client().prepareSearch(indexName)
            )
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;
            )
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L - expectedFirstBucketCount));
        );
        super(staticSettings);
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("2012-02-15-2012-03-15"));
    }
    }
            .get();
        Apr 23, May 24      6
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
                dateRange("range").field("date")
    }
        assertThat(bucket, notNullValue());
        );
            client().prepareIndex(indexName).setId("1").setSource(jsonBuilder().startObject().field("date", 1002).endObject()),
            .get();
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < 2; i++) {
        Range.Bucket bucket = buckets.get(0);
        SearchResponse response = client().prepareSearch("idx")
        assertBucket(buckets.get(1), 1L, "3000-4000", 3000000L, 4000000L);
                .indices()
        if (randomBoolean()) {
     */
            OpenSearchException.class,
        // format in aggregation
        Feb 15, Mar 16,     3
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            .setSize(0)
        assertThat(bucket.getDocCount(), equalTo(0L));
                    .addUnboundedTo(date(2, 15))
    /**
                .getRequestCache()
            )
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        bucket = buckets.get(1);
                    .addUnboundedFrom(date(3, 15))
        bucket = buckets.get(2);
            fail();
                        ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
        Apr 2,  May 3,      4
        Mar 23,     6
        assertThat(bucket.getAggregations().asList().isEmpty(), is(true));
    public void testUnmapped() throws Exception {
        bucket = buckets.get(1);
        assertThat(range, notNullValue());
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
            .addAggregation(
        assertThat(sum, notNullValue());
        assertBucket(buckets.get(0), 2L, "1000-3000", 1000000L, 3000000L);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;
        assertSearchResponse(response);
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(
        assertThat(buckets.size(), equalTo(3));
        bucket = buckets.get(1);
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(buckets.size(), equalTo(3));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        );
                dateRange("foo").field("date")
                    .addRange("r2", date(2, 15), date(3, 15))
        SearchResponse response = client().prepareSearch("idx")
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        assertThat(bucket.getDocCount(), equalTo(2L));
    public void testDateMath() throws Exception {
 *
            .addAggregation(
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(range, notNullValue());
    }
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        searchResponse = client().prepareSearch(indexName)
        Range dateRange = bucket.getAggregations().get("date_range");
        bucket = buckets.get(1);
            .get();
        assertThat(bucket.getFromAsString(), nullValue());
                .getHitCount(),
                histogram("histo").field("value")
        assertThat(dateRange, Matchers.notNullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
    }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        // using no format should also work when and to/from are string values
    /**
            .addAggregation(
                .setRequestCache(true)
        bucket = buckets.get(2);
                .getMissCount(),
        Mar 23, Apr 24      6
                .setRequestCache(true)
        Histogram histo = searchResponse.getAggregations().get("histo");
        // using no format should work when to/from is compatible with format in
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            .addAggregation(
                        ZonedDateTime.of(2013, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
        assertThat((long) propertiesDocCounts[1], equalTo(2L));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import java.util.Collection;
            .addAggregation(
            .setSize(0)
                    .addRange(date(2, 15), date(3, 15))
            .addAggregation(
        return date(month, day, ZoneOffset.UTC);
    private static int numDocs;
            )
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        List<? extends Bucket> buckets = range.getBuckets();
        return Arrays.asList(
        Apr 23, May 24      6
        assertThat(bucket.getDocCount(), equalTo(numDocs - 1L));
                dateRange("range").field("date")
        String indexName = "dateformat_test_idx";
 */
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
            client().prepareIndex(indexName).setId("3").setSource(jsonBuilder().startObject().field("date", 3008).endObject())
        assertThat(bucket.getDocCount(), equalTo(2L));
            client().prepareIndex("cache_test_idx")
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
            .get();
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(buckets.size(), equalTo(3));
public class DateRangeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat((String) bucket.getKey(), equalTo("r2"));
        assertThat(bucket.getFromAsString(), nullValue());
                dateRange("range").field("date")
            .get();
            client().admin()
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        SearchResponse response = client().prepareSearch("idx")
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        // Test that a request using a nondeterministic script does not get cached
                .setRequestCache(true)
                dateRange("date_range").field("date").addRange("00.16.40", "00.50.00").addRange("00.50.00", "01.06.40").format("HH.mm.ss")
                .setId("2")
                .get()
        List<? extends Bucket> buckets = range.getBuckets();
 * KIND, either express or implied.  See the License for the
        Feb 2,  Mar 3,      2
                .get()
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
            )
                dateRange("range").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))
        );
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
        assertThat((String) bucket.getKey(), equalTo("r2"));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15-*"));
                .indices()
        assertThat(buckets.get(0).getAggregations().asList().isEmpty(), is(true));
        assertThat((String) bucket.getKey(), equalTo("r3"));
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
 */
            true,
        Range.Bucket bucket = buckets.get(0);
        searchResponse = client().prepareSearch(indexName)
            .addAggregation(
        assertThat(((ZonedDateTime) bucket.getTo()).toInstant().toEpochMilli(), equalTo(expectedTo));
        );
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(bucket.getToAsString(), nullValue());
                    .addRange(date(2, 15), date(3, 15))
        docs.addAll(
                .getHitCount(),
        Jan 2,      1
    }
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("r1"));
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));
            )
    @ParametersFactory
        bucket = buckets.get(2);
            client().prepareIndex(indexName).setId("2").setSource(jsonBuilder().startObject().field("date", 2000).endObject()),
    public void testNoRangesInQuery() {
        assertThat(bucket, notNullValue());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
    @Override
        Range.Bucket bucket = buckets.get(0);
        bucket = buckets.get(1);
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat(range, notNullValue());
            )
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        // format in aggregation
     */
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        bucket = buckets.get(2);
                dateRange("range").field("dates")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(bucket, notNullValue());
        Mar 2,      4
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(range, notNullValue());
            .setQuery(matchAllQuery())
        assertThat(bucket, notNullValue());
        SearchResponse searchResponse = client().prepareSearch(indexName)
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
                    .addUnboundedFrom(date(3, 15))
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
            .get();
        assertThat(
        int timeZoneOffset = timezone.getRules().getOffset(date(2, 15).toInstant()).getTotalSeconds();
        // providing numeric input with format should work, but bucket keys are
                    .addRange(
        // also e-notation should work, fractional parts should be truncated
            true,
    public void testRangeWithFormatStringValue() throws Exception {
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
        assertThat(buckets.size(), equalTo(3));
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(bucket.getDocCount(), equalTo(2L));
        Range range = response.getAggregations().get("range");
        assertSearchResponse(r);
                    .addRange("recently", "now-50y", "now-1y")
        assertSearchResponse(response);
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) range).getProperty("_key");
        assertThat((String) bucket.getKey(), equalTo("recently"));
    }
        String mar15Suffix = timeZoneOffset == 0 ? "Z" : date(3, 15, timezone).format(DateTimeFormatter.ofPattern("xxx", Locale.ROOT));
                .indices()
            .addAggregation(
        assertThat(range.getName(), equalTo("range"));
        // there is a daylight saving time change on 11th March so suffix will be different
 * the Apache License, Version 2.0 (the "License"); you may
        // using different format should work when to/from is compatible with
        Feb 15,     3
            .setSize(0)
        SearchResponse response = client().prepareSearch("idx")
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                .getRequestCache()
            .addAggregation(
            rangeBuilder.script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params));
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
 * SPDX-License-Identifier: Apache-2.0
                        ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
        assertThat(bucket.getDocCount(), equalTo(2L));
                .prepareStats("cache_test_idx")
    /*
 *
            .addAggregation(
 * You may obtain a copy of the License at
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000" + feb15Suffix + "-2012-03-15T00:00:00.000" + mar15Suffix));
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(bucket.getFromAsString(), nullValue());
        Map<String, Object> params = new HashMap<>();
    }
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
    private static List<Range.Bucket> checkBuckets(Range dateRange, String expectedAggName, long expectedBucketsSize) {
            Throwable rootCause = spee.getCause().getCause();
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
    public void setupSuiteScopeCluster() throws Exception {
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
            .get();
        ensureSearchable();
        assertThat((String) propertiesKeys[0], equalTo("r1"));
            )
            )
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertSearchResponse(response);
            )
import org.opensearch.OpenSearchException;
 * not use this file except in compliance with the License.
        assertThat(
import org.opensearch.search.aggregations.metrics.Sum;
        Map<String, Object> params = new HashMap<>();
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
                .setId("1")
import java.time.ZoneId;
                .getHitCount(),
        assertThat(
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
    public void testEmptyAggregation() throws Exception {
        bucket = buckets.get(1);
        internalCluster().wipeIndices(indexName);
        Map<String, Object> params = new HashMap<>();
            .get();
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        SearchResponse searchResponse = client().prepareSearch(indexName)
        // keys are different now
        assertThat(buckets.size(), equalTo(3));
        params.put("fieldname", "dates");
    public void testMultiValuedFieldWithValueScript() throws Exception {
                .getRequestCache()
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        List<? extends Bucket> buckets = range.getBuckets();
    public void testMultiValuedField() throws Exception {
        assertThat(buckets.size(), equalTo(3));
                .getTotal()
    public static Collection<Object[]> parameters() {
        Range.Bucket bucket = buckets.get(0);
                    .addUnboundedTo("2012-02-15")
        assertThat(range, notNullValue());
                .setRequestCache(true)
 * compatible open source license.
            .get();
        searchResponse = client().prepareSearch(indexName)
import org.opensearch.common.settings.Settings;
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        indexRandom(
        assertThat(sum, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertAcked(prepareCreate(indexName).setMapping("date", "type=date,format=epoch_second"));
        assertThat(bucket, notNullValue());
import static org.hamcrest.Matchers.is;
        assertBucket(buckets.get(1), 1L, "3000000-4000000", 3000000L, 4000000L);
        assertThat(range.getName(), equalTo("range"));
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        List<Range.Bucket> buckets = new ArrayList<>(dateRange.getBuckets());
                .setSource(jsonBuilder().startObject().timeField("date", date(2, 1)).endObject())
        assertSearchResponse(response);
        assertThat(bucket, Matchers.notNullValue());
 * license agreements. See the NOTICE file distributed with
                    )
        assertThat(range, notNullValue());
package org.opensearch.search.aggregations.bucket;
        numDocs = randomIntBetween(7, 20);
                .getTotal()
    public DateRangeIT(Settings staticSettings) {
        assertThat(bucket.getFromAsString(), nullValue());
import static org.hamcrest.core.IsNull.nullValue;
            .addAggregation(
        createIndex("idx_unmapped");
        assertThat(bucket, notNullValue());
    private static void assertBucket(Bucket bucket, long bucketSize, String expectedKey, long expectedFrom, long expectedTo) {
        } else {
                dateRange("range").field("date")
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        assertThat(bucket, notNullValue());
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        assertThat(bucket, notNullValue());
import static org.hamcrest.Matchers.equalTo;
        Feb 2,  Mar 3,      2
            .addAggregation(
        assertThat(bucket.getFromAsString(), nullValue());
        assertSearchResponse(response);
            )
 */
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
                .getRequestCache()
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertBucket(buckets.get(1), 1L, "3000-4000", 3000000L, 4000000L);
        Mar 15, Apr 16      5
                    .addUnboundedTo("r1", date(2, 15))
        Sum sum = bucket.getAggregations().get("sum");
        assertThat(range.getName(), equalTo("range"));
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
                .setRequestCache(true)
            )
        assertThat(bucket.getToAsString(), equalTo("2012-02-15"));
                    .timeValue(date(month, day))
        List<? extends Bucket> buckets = range.getBuckets();
                dateRange("range").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))
            );
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        List<? extends Bucket> buckets = range.getBuckets();
        ZoneId timezone = randomZone();
        r = client().prepareSearch("cache_test_idx")
        assertThat(bucket, notNullValue());
        Range.Bucket bucket = buckets.get(0);
        internalCluster().wipeIndices("cache_test_idx");
        assertThat(buckets.size(), equalTo(3));
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
import java.util.Map;
                    .format("yyyy-MM-dd")
        bucket = buckets.get(2);
                .get()
                dateRange("range").field("date")
        assertThat(range.getName(), equalTo("range"));
                .indices()
     */
        SearchResponse response = client().prepareSearch("idx_unmapped")
                    .addUnboundedFrom(date(3, 15))
        // dummy docs
        assertThat(histo, Matchers.notNullValue());
        assertThat(bucket.getDocCount(), equalTo((long) numDocs));
import java.util.List;
        assertThat((long) propertiesDocCounts[2], equalTo(numDocs - 4L));
        assertThat(bucket.getDocCount(), equalTo(1L));
        Range range = response.getAggregations().get("range");
            .addAggregation(
        assertThat(bucket.getFromAsString(), nullValue());
        return ZonedDateTime.of(2012, month, day, 0, 0, 0, 0, timezone);
    }
            )
import org.hamcrest.Matchers;
            .addAggregation(
        assertSearchResponse(response);
        Mar 2,  Apr 3,      2
        assertSearchResponse(response);
                    .minDocCount(0)
            .get();
        assertThat(range, notNullValue());
/*
        assertBucket(buckets.get(1), 1L, "00.50.00-01.06.40", 3000000L, 4000000L);
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(buckets.size(), is(1));
import java.time.format.DateTimeFormatter;
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000" + feb15Suffix));
        Range range = response.getAggregations().get("range");
        Range.Bucket bucket = buckets.get(0);
        assertSearchResponse(response);
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(bucket.getFromAsString(), nullValue());
                    )
        Map<String, Object> params = new HashMap<>();
        assertThat((String) buckets.get(0).getKey(), equalTo("0-1"));
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        assertThat(bucket.getDocCount(), equalTo(2L));
            .setSize(0)
        assertThat(bucket, notNullValue());
        Range range = response.getAggregations().get("range");
            client().admin()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public void testScriptSingleValue() throws Exception {
                .getTotal()
                .getMissCount(),
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
            .get();
 * GitHub history for details.
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000" + feb15Suffix));
        assertThat(bucket.getDocCount(), equalTo(2L));
        Range range = response.getAggregations().get("range");
    }
            .addAggregation(dateRange("date_range").field("date").addRange(1.0e3, 3000.8123).addRange(3000.8123, 4.0e3))
            client().admin()
            .setSize(0)
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        bucket = buckets.get(2);
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
    public void testUnmappedWithStringDates() throws Exception {
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(buckets.size(), equalTo(3));
                    .field("value", value)
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        List<Range.Bucket> buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        Mar 23, Apr 24      6
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        bucket = buckets.get(1);
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
                    .endArray()
        bucket = buckets.get(2);
            .get();
        assertThat(range.getName(), equalTo("range"));
        return Collections.singleton(DateScriptMocksPlugin.class);
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat(bucket.getFromAsString(), nullValue());
            )
        bucket = buckets.get(2);
            client().prepareIndex("cache_test_idx")
        assertThat(range.getName(), equalTo("range"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
                .get()
    @Override
                dateRange("range").field("date")
        );
        assertBucket(buckets.get(0), 2L, "1000-3000", 1000000L, 3000000L);
                .prepareStats("cache_test_idx")
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
import java.util.Collections;
        assertThat(range, notNullValue());
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
                .setRequestCache(true)
     * Make sure that a request using a deterministic script or not using a script get cached.
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000" + mar15Suffix + "-*"));
                    .addUnboundedFrom("r3", date(3, 15))
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15"));
        assertThat((double) propertiesCounts[1], equalTo((double) 3 + 4));
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        assertBucket(buckets.get(0), 2L, "1000-3000", 1000000L, 3000000L);
        );
            client().prepareSearch("idx").addAggregation(dateRange("my_date_range_agg").field("value")).get();
            Arrays.asList(
        assertThat(bucket, notNullValue());
                    .addUnboundedFrom(date(3, 15))
    }
import java.util.Locale;
            .get();
        assertSearchResponse(r);
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
            equalTo(0L)
                    .setId("" + i)
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(bucket.getToAsString(), nullValue());
        bucket = buckets.get(2);
    }
                .prepareStats("cache_test_idx")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(bucket.getToAsString(), nullValue());
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.CURRENT_DATE, params))
        assertBucket(buckets.get(0), 2L, "1000000-3000000", 1000000L, 3000000L);
        Map<String, Object> params = new HashMap<>();
        assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        assertThat(bucket, notNullValue());
        Range.Bucket bucket = buckets.get(0);
        params.put("fieldname", "date");
                    .addRange("2012-02-15", "2012-02-15||+1M")
                    .endObject()
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
    }
        assertThat(range, notNullValue());
    }
            .addAggregation(
 * ownership. Elasticsearch licenses this file to you under
        );
        Range range = response.getAggregations().get("range");
            .get();
                .indices()
        bucket = buckets.get(1);
        // providing numeric input without format should throw an exception
        r = client().prepareSearch("cache_test_idx")
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        );
        assertThat(bucket.getDocCount(), equalTo(bucketSize));
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
            .addAggregation(dateRange("date_range").field("date").addRange(1000, 3000).addRange(3000, 4000))
            .get();
                indexDoc(3, 2, 4),  // Mar 2
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
                dateRange("date_range").field("date").addRange("00.16.40", "00.50.00").addRange("00.50.00", "01.06.40").format("HH.mm.ss")
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertBucket(buckets.get(0), 2L, "00.16.40-00.50.00", 1000000L, 3000000L);
                    .subAggregation(sum("sum").field("value"))
        bucket = buckets.get(2);
        Range range = response.getAggregations().get("range");
                        ZonedDateTime.of(2013, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
            client().admin()
        SearchResponse response = client().prepareSearch("idx")
        OpenSearchException e = expectThrows(
        assertThat(range.getName(), equalTo("range"));
                indexDoc(2, 2, 2),  // Feb 2
                jsonBuilder().startObject()
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
 * software distributed under the License is distributed on an
        searchResponse = client().prepareSearch(indexName)
import java.util.ArrayList;
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000" + mar15Suffix));
                client().prepareIndex("empty_bucket_idx")
                    .addUnboundedTo(date(2, 15))
            .setSize(0)
            rangeBuilder.field("date");
                    .addUnboundedTo(date(2, 15))
import org.opensearch.search.aggregations.bucket.range.Range;
        List<? extends Bucket> buckets = range.getBuckets();
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            () -> client().prepareSearch(indexName)
        return client().prepareIndex("idx")
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
                .get()
        bucket = buckets.get(1);
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15"));
        String feb15Suffix = timeZoneOffset == 0 ? "Z" : date(2, 15, timezone).format(DateTimeFormatter.ofPattern("xxx", Locale.ROOT));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
    public void testSingleValueFieldWithDateMath() throws Exception {
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        Range range = response.getAggregations().get("range");
import org.opensearch.action.search.SearchResponse;
        Mar 15,     5
        Feb 2,      2
                .get()
                .setRequestCache(true)
