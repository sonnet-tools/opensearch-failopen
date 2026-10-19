        assertThat(bucket.getDocCount(), equalTo(5L));  
        assertThat(bucket.getDocCount(), equalTo(1L));  
                indexDoc(3, 2, 4),  // date: Mar 2, dates: Mar 2, Apr 3  
        assertThat(buckets.get(1).getKeyAsString(), equalTo("2012-02-03T00:00:00.000Z"));
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));  
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(1L));  
        SearchResponse response = client().prepareSearch("idx")  
                    .subAggregation(avg("avg_l").field("l"))
        assertAcked(client().admin().indices().prepareCreate("test9491").setMapping("d", "type=date").get());
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));  
        internalCluster().wipeIndices(indexDateUnmapped);  
 *
            equalTo(3600000L)
    private ZonedDateTime date(String date) {
    /**  
        builders.add(  
        assertThat(bucket, notNullValue());
        }
    }
                .getRequestCache()
        // randomizing the number of buckets on the min bound
                    dateHistogram("histo").field("date")
import org.opensearch.common.settings.Settings;  
        int[] expectedDays = new int[] { 6, 7, 3, 4, 5, 1, 2 };  
        assertSearchResponse(r);
            )  
        assertEquals(0, buckets.get(4).getDocCount());  
                    .timeField("date", date)
                .setRequestCache(true)
    public void testSingleValuedField() throws Exception {  
    public void testScriptCaching() throws Exception {  
        } catch (Exception e) {
        int i = 2;  
     */
    public void testHardBoundsOnDates() {  
            equalTo(3600000L)  
        assertThat(bucket.getDocCount(), equalTo(1L));
            assertThat(bucket.getKey(), equalTo(date(i, 1)));  
    [ Jan 2, Feb 3]
        createIndex("idx", "idx_unmapped");
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
    }  
        Histogram histo = response.getAggregations().get("histo");
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        assertThat(histo, notNullValue());
            .addAggregation(  
import org.hamcrest.Matchers;
        assertSearchResponse(response);  
     */
            )  
        assertThat(
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) histo).getProperty("sum.value");
    private IndexRequestBuilder indexDoc(int month, int day, int value) throws Exception {  
        assertThat(bucket.getDocCount(), equalTo(5L));
        List<? extends Bucket> buckets = histo.getBuckets();  
            .get();  
    public void testEmptyAggregation() throws Exception {
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            assertThat(bucketKey, equalTo(expectedBucketName));  
        r = client().prepareSearch("nanos")
        addExpectedBucket(date(1, 7), 1, 5, 1);
            } else {
        bucket = buckets.get(2);
        List<? extends Bucket> buckets = histo.getBuckets();  
        assertEquals(946681200000L, ((ZonedDateTime) buckets.get(0).getKey()).toEpochSecond() * 1000);  
     * Jan 2
        expectedKeys.add(ZonedDateTime.of(2012, 2, 14, 23, 0, 0, 0, ZoneOffset.UTC));
        assertSearchResponse(response);  
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(histo, notNullValue());
    }
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
    }  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
        assertEquals(1, buckets.get(0).getDocCount());
        assertEquals(2, buckets.get(2).getDocCount());
                .get()
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 5).plusHours(12)).field("l", 5).field("d", 2).endObject())  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
            .addAggregation(dateHistogram("histo").field("d").dateHistogramInterval(DateHistogramInterval.MONTH))  
        int i = 0;  
        indexRandom(true, reqs);
            )  
                    .order(BucketOrder.aggregation("sum", false))
    /**
        sum = bucket.getAggregations().get("sum");
        assertThat(histo.getName(), equalTo("histo"));  
        Histogram.Bucket bucket = buckets.get(0);  
        List<InternalDateHistogram.Bucket> buckets = histogram.getBuckets();  
        List<? extends Bucket> buckets = histo.getBuckets();
            .startObject("date")
        assertSearchResponse(response);  
        assertSearchResponse(response);
            )
            }
            .get();
            .addAggregation(  
                    .dateHistogramInterval(DateHistogramInterval.days(1))
        }
        Map<String, Object> params = new HashMap<>();
            )  
                .setRequestCache(true)  
        SearchResponse response = client().prepareSearch("idx")
        return ZonedDateTime.of(2012, month, day, 0, 0, 0, 0, ZoneOffset.UTC);
            )
     * doc 2: [ Mar 2, Apr 3]  
        assertSearchResponse(response);  
import org.junit.After;
        assertThat(bucket.getDocCount(), equalTo(1L));
            client().admin()
        assertSearchResponse(response);
        assertThat(buckets.size(), equalTo(4));
                    .timeZone(ZoneId.of("-02:00"))
            if (i == emptyBucketIndex) {  
        indexRandom(true, client().prepareIndex(index).setSource("d", "1477954800000"));
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
            reqs[i] = client().prepareIndex("idx2")  
        Histogram.Bucket bucket = buckets.get(1);
                    .field("value", value)
            client().prepareIndex("sort_idx")
                .getRequestCache()
                .getTotal()
        assertThat(bucket, Matchers.notNullValue());
        ZonedDateTime boundsMax = boundsMaxKey.plusDays(randomIntBetween(0, interval - 1));
    private ZonedDateTime date(int month, int day) {
        ZonedDateTime boundsMinKey;
                .prepareStats("cache_test_idx")  
            client().admin()
            i++;  
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                indexDoc(2, 2, 2),  // date: Feb 2, dates: Feb 2, Mar 3
        int[] expectedDays = new int[] { 5, 6, 7, 3, 4, 2, 1 };
        }
            assertThat(e.toString(), containsString("[interval] must be 1 or greater for aggregation [date_histogram]"));  
        bucket = buckets.get(2);  
        assertEquals(0, buckets.get(1).getDocCount());  
        assertThat(bucket.getDocCount(), equalTo(1L));  
        ZoneId tz = ZoneId.of("+01:00");
                .setRequestCache(true)
        assertThat(buckets.size(), equalTo(3));
        assertEquals("2016-01-06T06:00:00.000Z", buckets.get(5).getKeyAsString());
        // Search interval 24 hours
        SearchResponse response = client().prepareSearch("idx")
                    .order(BucketOrder.aggregation("sum", true))
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
                histogram("histo").field("value")  
        // Ensure that non-scripted requests are cached as normal  
        Map<String, Object> bucketProps = new HashMap<>();
        prepareCreate("idx2").setMapping(mappingJson).get();  
        assertThat(histo.getBuckets().size(), equalTo(1));
    public void testSingleValuedFieldOrderedByIllegalAgg() throws Exception {
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
@OpenSearchIntegTestCase.SuiteScopeTestCase
        List<? extends Bucket> buckets = histo.getBuckets();
    [ Mar 15, Apr 16]  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
        bucket = buckets.get(1);
     * "2015-10-25T03:00:00.000+01:00",  
        for (int i = 0; i < 2; i++) {  
        assertThat(bucket, notNullValue());  
import org.opensearch.script.ScriptType;  
                    AggregationExecutionException aggException = (AggregationExecutionException) rootCause;
            } else {
        getMultiSortDocs(builders);
        // Test that a request using a nondeterministic script does not get cached
        SearchResponse response = client().prepareSearch("test9491")  
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-06T08:00:00.000Z")), 3));  
    [ Feb 15, Mar 16]
        // retrieve those docs with the same time zone and extended bounds
        assertThat(bucket.getDocCount(), equalTo(3L));
        indexRandom(true, builders);
    }
    public void afterEachTest() throws IOException {  
            .addAggregation(  
        assertThat(bucket.getKey(), equalTo(date(3, 1)));
        assertThat(histo.getName(), equalTo("histo"));
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
    }
            .endObject()  
            .setSize(0)
                    .extendedBounds(new LongBounds("2015-10-25T02:00:00.000+02:00", "2015-10-25T04:00:00.000+01:00"))
    private void assertMultiSortResponse(int[] expectedDays, BucketOrder... order) {  
        assertThat(histo.getBuckets().size(), equalTo(3));
        assertAcked(
        ZonedDateTime baseKey = Instant.ofEpochMilli(intervalMillis * (base.toInstant().toEpochMilli() / intervalMillis))  
        assertThat(histo.getName(), equalTo("histo"));  
        List<? extends Bucket> buckets = histo.getBuckets();
            )
                dateHistogram("histo").field("date")
            .setQuery(matchAllQuery())
        int emptyBucketIndex = randomIntBetween(1, numOfBuckets - 2); // should be in the middle
            builders.add(  
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
    }  
        System.arraycopy(docCounts, 0, extendedValueCounts, addedBucketsLeft, docCounts.length);
            builders.add(
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        Histogram histo = response.getAggregations().get("histo");  
                    .minDocCount(0)
        IndexRequestBuilder[] reqs = new IndexRequestBuilder[5];
 */
        ensureSearchable("test9491");
     */
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertSearchResponse(response);  
            assertThat(sum, notNullValue());
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
        Map<String, Object> params = new HashMap<>();
                .setRequestCache(true)
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                        .dateHistogramInterval(DateHistogramInterval.days(interval))  
        ZoneId tz = ZoneId.of("+01:00");  
                .getRequestCache()
        ZonedDateTime boundsMaxKey = lastDataBucketKey.plusDays(boundsMaxKeyDelta);  
    public void testSingleValueFieldWithExtendedBoundsTimezone() throws Exception {
    public void testSingleValueFieldWithExtendedBounds() throws Exception {  
    [ Mar 23, Apr 24]
                    .subAggregation(max("max_constant").field("constant"))
import org.opensearch.common.time.DateFormatters;
        Map<String, Object> params = new HashMap<>();  
                    .format(format)
 * compatible open source license.
            client().prepareSearch("idx")
        boolean asc = true;  
                dateHistogram("histo").field("date")
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 3).plusHours(1)).field("l", 3).field("d", 2).endObject())
    private static String format(ZonedDateTime date, String pattern) {  
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(1L));
        String index = "test23776";  
        assertThat(histo, notNullValue());
     * extended bounds (see https://github.com/elastic/elasticsearch/issues/12278)  
        SearchResponse response = client().prepareSearch("idx")
                .addAggregation(
            date = date.plusHours(1);
            )
        assertThat(bucket.getDocCount(), equalTo(1L));  
        int numOfBuckets = randomIntBetween(3, 6);  
        assertThat(buckets.size(), equalTo(3));
    }  
import org.opensearch.action.search.SearchResponse;
        assertThat(histo.getName(), equalTo("histo"));
        int i = 2;
        assertThat(buckets.size(), equalTo(2));
        assertThat(histo.getName(), equalTo("histo"));
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            )
            .get();
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        expectedKeys.add(ZonedDateTime.of(2012, 3, 1, 23, 0, 0, 0, ZoneOffset.UTC));
package org.opensearch.search.aggregations.bucket;
                .getTotal()  
            fail("Expected an exception");
        builders.add(
                dateHistogram("histo").field("dateField")  
     * be recreated when aggregating about a single index with an unmapped date field and also getting "empty" buckets.  
import static org.hamcrest.core.IsNull.notNullValue;  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        return Arrays.asList(
        assertSearchResponse(response);
    /**
    public void testIssue6965() {
        assertThat(histo, notNullValue());
                jsonBuilder().startObject()
                .indices()
        assertThat(bucket.getDocCount(), equalTo(2L));
    }
        bucket = buckets.get(1);  
                .getHitCount(),  
    public void testMultiValuedField() throws Exception {
        assertThat(bucket, notNullValue());
                client().prepareIndex("empty_bucket_idx")
        addExpectedBucket(date(1, 3), 2, 3, 3);  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
            .addAggregation(  
    public void testDSTBoundaryIssue9491() throws InterruptedException, ExecutionException {
            .get();
            )  
        assertThat(bucket.getDocCount(), equalTo(1L));
                .getTotal()  
            .addAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH))
            .setQuery(matchAllQuery())
        ZonedDateTime date = date("2014-03-11T00:00:00+00:00");  
    }
        Histogram histo = response.getAggregations().get("histo");
                    .minDocCount(1)  
        assertThat(buckets.get(0).getKeyAsString(), equalTo("2012-01-01T00:00:00.000-07:00"));
import java.util.Map;
        prepareCreate("idx2").setMapping("date", "type=date").get();
                indexDoc(3, 15, 5), // date: Mar 15, dates: Mar 15, Apr 16
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertEquals("2016-01-08T06:00:00.000Z", buckets.get(7).getKeyAsString());
        assertEquals(0, buckets.get(3).getDocCount());
        List<IndexRequestBuilder> builders = new ArrayList<>();
        int interval = randomIntBetween(1, 2); // in days  
        assertThat(histo.getName(), equalTo("histo"));
                return;
    }
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date));  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
        assertEquals(0, buckets.get(0).getDocCount());
            assertThat(bucket, notNullValue());
        assertEquals("2016-01-05T06:00:00.000Z", buckets.get(4).getKeyAsString());
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));  
        for (int i = 1; i <= 3; i++) {
                .addAggregation(dateHistogram("histo").field("date").interval(-TimeUnit.DAYS.toMillis(1)).minDocCount(0))
        builders.add(
            }  
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket, notNullValue());
            assertThat(avg, notNullValue());
    */  
            .addAggregation(
                .indices()  
        );
        Histogram dateHisto = bucket.getAggregations().get("date_histo");
        Histogram histo = response.getAggregations().get("histo");
            BucketOrder.aggregation("sum_d", false),
            client().prepareIndex("test9491").setSource("d", "2014-11-08T13:00:00Z")  
import java.util.ArrayList;
        );
     * When DST ends, local time turns back one hour, so between 2am and 4am wall time we should have four buckets:  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            assertThat(bucket.getDocCount(), equalTo(1L));
            }  
        int[] expectedDays = new int[] { 1, 2, 4, 3, 7, 6, 5 };  
            .addAggregation(
            ((ZonedDateTime) buckets.get(1).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(0).getKey()).toInstant()
        assertSearchResponse(response);
            .get();
            key = key.plusDays(interval);  
            String bucketKey = bucket.getKeyAsString();
        Histogram histo = response.getAggregations().get("histo");
 *  
                .getMissCount(),
        assertThat(histo.getBuckets().get(2).getKeyAsString(), equalTo("2014-03-01T00:00:00.000+01:00"));
        int bucketsCount = numOfBuckets + addedBucketsLeft + addedBucketsRight;  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getDocCount(), equalTo(2L));
        response = client().prepareSearch(index)
        assertThat(bucket.getDocCount(), equalTo(3L));  
        ZonedDateTime key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        SearchResponse r = client().prepareSearch("nanos")  
    }
        ensureSearchable(index);
            BucketOrder.aggregation("avg_l", false)  
        assertThat(histo.getBuckets().get(1).getDocCount(), equalTo(0L));  
            )  
    [ Jan 2, Feb 3]  
    }  
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.CURRENT_DATE, params))  
            .get();  
     * "2015-10-25T02:00:00.000+01:00",
        bucket = buckets.get(1);  
            Avg avg = bucket.getAggregations().get("avg_l");  
            equalTo(0L)
        Histogram histo = response.getAggregations().get("histo");
        assertThat(
    @Override  
                    .interval(1L)
        assertThat(buckets.size(), equalTo(bucketsCount));  
        assertThat(histo, notNullValue());  
        assertSearchResponse(response);  
                .setId("" + i)
        Histogram histogram = r.getAggregations().get("histo");  
                    .dateHistogramInterval(DateHistogramInterval.hours(1))  
                    .timeZone(ZoneId.of("America/Edmonton"))
        assertThat(histo, notNullValue());
        int addedBucketsRight = randomIntBetween(0, numOfBuckets);  
        assertThat(  
                    .timeValue(date(month, day))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        long[] docCounts = new long[numOfBuckets];  
import static org.hamcrest.Matchers.equalTo;
        }  
        for (int i = 0; i < bucketsCount; i++) {  
        key = ZonedDateTime.of(2012, 5, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        ZoneId timezone = ZoneOffset.ofHours(timeZoneHourOffset);
            .get();
        }
        assertThat(bucket.getDocCount(), equalTo(1L));
        int i = 1;
        assertThat(buckets.size(), equalTo(4));
        assertThat(histo.getBuckets().size(), equalTo(3));
        SearchResponse response = client().prepareSearch("test8209")  
        internalCluster().wipeIndices(index);
    }
    public void setupSuiteScopeCluster() throws Exception {
                .toEpochMilli(),  
        assertEquals("2016-01-03T06:00:00.000Z", buckets.get(2).getKeyAsString());
            .setSource(  
            client().prepareIndex("sort_idx")  
        key = ZonedDateTime.of(2012, 3, 1, 23, 0, 0, 0, ZoneOffset.UTC);  
        SearchResponse response = client().prepareSearch("idx")  
        ensureSearchable();  
                .prepareStats("cache_test_idx")  
        assertThat(histo.getName(), equalTo("histo"));  
        assertThat(histo, notNullValue());  
                        .order(BucketOrder.aggregation("inner_histo>avg", asc))  
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertSearchResponse(response);  
        assertSearchResponse(response);
/*  
            )
        assertThat(bucket, notNullValue());
     * Mar 23  
 * You may obtain a copy of the License at  
        ).get();  
        indexRandom(true, builders);
        List<InternalDateHistogram.Bucket> buckets = histogram.getBuckets();  
        assertSearchResponse(response);
        for (Histogram.Bucket bucket : histogram.getBuckets()) {
    public void testUnmapped() throws Exception {
                    .format("yyyy-MM")
        super(staticSettings);  
            .setSource(
        bucket = buckets.get(1);  
import java.util.Arrays;
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            boundsMaxKeyDelta = -boundsMaxKeyDelta;
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 4).plusHours(2)).field("l", 3).field("d", 3).endObject())
            .get();  
     * see issue #9634, negative dateHistogramInterval in date_histogram should raise exception  
     */
                .prepareStats("cache_test_idx")  
        assertThat(
        SearchResponse response = client().prepareSearch("idx")  
                    .dateHistogramInterval(DateHistogramInterval.YEAR)  
        assertThat(bucket, notNullValue());  
                dateHistogram("histo").field("date")
        SearchResponse response = client().prepareSearch("idx")
            )  
                .prepareStats("cache_test_idx")
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
import org.opensearch.test.OpenSearchIntegTestCase;
    [ Feb 2, Mar 3]  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertThat(dateHisto.getBuckets().isEmpty(), is(true));
                dateHistogram("histo").field("d")
import org.opensearch.OpenSearchException;
        params.put("fieldname", "d");
import static org.hamcrest.Matchers.containsString;  
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(1L));  
        assertThat(buckets.size(), equalTo(4));  
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
import java.util.Collections;
import org.opensearch.action.index.IndexRequestBuilder;  
            .field("type", "date")  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        Histogram.Bucket bucket = buckets.get(0);
        }
            i--;  
     * https://github.com/elastic/elasticsearch/issues/31760 shows an edge case where an unmapped "date" field in two indices
     * Test date histogram aggregation with day interval, offset and
 * Modifications Copyright OpenSearch Contributors. See  
                docCounts[i] = 0;
        ZonedDateTime timeZoneNoonToday = parser.parse("now/d+12h", System::currentTimeMillis, false, timezone).atZone(ZoneOffset.UTC);
                .setRequestCache(true)
        assertSearchResponse(response);
    }  
        Histogram.Bucket bucket = buckets.get(0);
        return (ZonedDateTime) bucket.getKey();
        assertThat(histo.getName(), equalTo("histo"));
                assertThat(bucket.getDocCount(), equalTo(0L));
     */
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    }
        Histogram histo = response.getAggregations().get("histo");  
                OpenSearchException rootCause = rootCauses[0];  
        assertThat(histogram.getBuckets().size(), equalTo(expectedKeys.length));
            )
            );
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
        SearchResponse response = client().prepareSearch("idx")  
                    assertThat(aggException.getMessage(), Matchers.startsWith("Invalid aggregation order path"));  
import java.util.concurrent.TimeUnit;
        ZonedDateTime lastDataBucketKey = baseKey.plusDays((numOfBuckets - 1) * interval);
                    .extendedBounds(new LongBounds("now/d", "now/d+23h"))  
        assertThat(histo, notNullValue());  
                        .dateHistogramInterval(DateHistogramInterval.MONTH)
                return;
        assertThat(buckets.size(), equalTo(24));  
            .toString();
            .addAggregation(
     * Test date histogram aggregation with hour interval, timezone shift and
        ZonedDateTime key = ZonedDateTime.of(2011, 12, 31, 23, 0, 0, 0, ZoneOffset.UTC);  
        Histogram.Bucket bucket = buckets.get(0);  
        assertEquals(0, buckets.get(6).getDocCount());
            .get();
                    .hardBounds(new LongBounds("2012-02-01T00:00:00.000", "2012-03-03T00:00:00.000"))
        }
    public void testSingleValueWithMultipleDateFormatsFromMapping() throws Exception {
                    .minDocCount(0)  
        assertThat(bucket, notNullValue());
        assertThat(histo, notNullValue());
     * doc 4: [ Apr 2, May 3]
        String format = randomBoolean() ? "epoch_millis" : "epoch_second";
        params.put("fieldname", "date");  
        assertSearchResponse(response);
import java.util.Collection;  
        assertThat(histo.getBuckets().get(2).getDocCount(), equalTo(0L));
        addExpectedBucket(date(1, 2), 3, 2, 6);
    [ Mar 2, Apr 3]  
        int i = 2;  
            .get();
        assertThat(bucket.getDocCount(), equalTo(3L));
        for (Histogram.Bucket bucket : histo.getBuckets()) {
    public void testFormatIndexUnmapped() throws InterruptedException, ExecutionException {
            equalTo(0L)  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
     * doc 6: [ Apr 23, May 24]
        bucket = buckets.get(3);  
 * license agreements. See the NOTICE file distributed with
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
    }  
        // TODO: would be nice to have more random data here  
            .addAggregation(  
        expectedKeys.add(ZonedDateTime.of(2012, 3, 22, 23, 0, 0, 0, ZoneOffset.UTC));
        int i = 2;
    public void testRewriteTimeZone_EpochMillisFormat() throws InterruptedException, ExecutionException {
        assertSearchResponse(response);  
    }
        assertThat(histo, notNullValue());  
        params.put("fieldname", "dates");
        bucket = buckets.get(3);
        Histogram histogram = response.getAggregations().get("histo");
            client().prepareIndex("cache_test_idx").setId("2").setSource("d", date2)
        assertThat(((InternalAggregation) histo).getProperty("_bucket_count"), equalTo(3));
    public void testSingleValuedFieldOrderedBySubAggregationDesc() throws Exception {
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
            )  
                dateHistogram("histo").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))
        // we're testing on days, so the base must be rounded to a day
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
                .get()
import java.time.ZonedDateTime;
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            Settings.builder().put(indexSettings()).put("index.number_of_shards", 1).put("index.number_of_replicas", 0)
    }
            );  
     * Make sure that a request using a deterministic script or not using a script get cached.  
        assertThat(bucket, notNullValue());  
        assertThat(buckets.size(), equalTo(3));
            .get();
        List<? extends Bucket> buckets = histo.getBuckets();
        indexRandom(true, client().prepareIndex("nanos").setId("1").setSource("date", "2000-01-01"));
        assertThat(histo.getName(), equalTo("histo"));
        List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(histo, notNullValue());  
        assertThat(histo, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
            .get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
import java.util.Iterator;  
        SearchResponse response = client().prepareSearch("idx")
                dateHistogram("histo").field("date")  
        List<? extends Bucket> buckets = histo.getBuckets();  
            equalTo(1L)  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertThat((ZonedDateTime) propertiesKeys[0], equalTo(key));
        assertThat(histo.getName(), equalTo("histo"));
        // constructing the newly expected bucket list
                    builders.add(indexDoc("idx2", date, j));  
        SearchResponse response = null;
        assertThat(  
            .endObject()
                            dateHistogram("inner_histo").dateHistogramInterval(DateHistogramInterval.MONTH)
            client().prepareIndex("test8209").setSource("d", "2014-01-01T00:00:00Z"),
            .addAggregation(dateHistogram("histo").field("dates").dateHistogramInterval(DateHistogramInterval.MONTH))  
    public void testSingleValueFieldWithExtendedBoundsOffset() throws Exception {
        );
        assertThat(histo.getBuckets().size(), equalTo(4));
    }  
                dateHistogram("histo").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 5)).field("l", 5).field("d", 1).endObject())
            OpenSearchException[] rootCauses = e.guessRootCauses();
            client().prepareIndex("test9491").setSource("d", "2014-10-08T13:00:00Z"),
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    /**
        key = ZonedDateTime.of(2012, 2, 29, 23, 0, 0, 0, ZoneOffset.UTC);
        );
        // retrieve those docs with the same time zone and extended bounds  
        bucket = buckets.get(2);
        assertThat(histo, notNullValue());
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histo).getProperty("_count");
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    public void testSingleValuedFieldOrderedByCountDesc() throws Exception {
        ZonedDateTime key = baseKey.isBefore(boundsMinKey) ? baseKey : boundsMinKey;
            i++;  
    public void testSingleValuedFieldWithValueScript() throws Exception {
                        .format(pattern)
        assertThat(bucket.getDocCount(), equalTo(3L));
                    .timeZone(ZoneId.of("Europe/Oslo"))
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                    .startArray("dates")
import java.util.List;
        sum = bucket.getAggregations().get("sum");  
        assertThat(bucket.getKey(), equalTo(date(2, 1)));  
        } else {
    [ Mar 15, Apr 16]
     * doc 1: [ Feb 2, Mar 3]
        indexRandom(true, builders);
     * that are queried simultaneously can lead to the "format" parameter in the aggregation not being preserved correctly.  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(histogram.getName(), equalTo("histo"));
            client().prepareIndex("sort_idx")
            client().prepareIndex("sort_idx")
     * The script will change to document date values to the following:  
        key = ZonedDateTime.of(2012, 1, 31, 23, 0, 0, 0, ZoneOffset.UTC);
        }  
                .getTotal()  
                    .setId("" + i)  
            boundsMinKey = baseKey.plusDays(addedBucketsLeft * interval);
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
    }  
                dateHistogram("histo").field("date")
        Histogram histo = response.getAggregations().get("histo");
                    throw e;
        key = ZonedDateTime.of(2012, 3, 14, 23, 0, 0, 0, ZoneOffset.UTC);
                if (rootCause instanceof AggregationExecutionException) {
                .addAggregation(  
     * "2015-10-25T04:00:00.000+01:00".
 * under the License.  
                indexDoc(1, 2, 1),  // date: Jan 2, dates: Jan 2, Feb 3  
        assertThat(
    static Map<ZonedDateTime, Map<String, Object>> expectedMultiSortBuckets;
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(0L));
                .getRequestCache()  
        assertThat(buckets.size(), equalTo(8));
        );
            .addAggregation(
            assertThat(key(bucket), equalTo(expectedKeys[i]));
     * <p>
        internalCluster().wipeIndices(index);
        assertEquals(2, buckets.get(5).getDocCount());
        bucket = buckets.get(4);
                .toEpochMilli(),  
 */  
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(histo.getName(), equalTo("histo"));
        key = ZonedDateTime.of(2012, 2, 14, 23, 0, 0, 0, ZoneOffset.UTC);
        builders.addAll(
            .addAggregation(  
        // (can sometimes fall within the data range, but more frequently will fall before the data range)
            fail();
        ZonedDateTime boundsMin = boundsMinKey.plusDays(randomIntBetween(0, interval - 1));
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.count(true))
            equalTo(0L)  
                    .timeZone(timezone)
        bucket = buckets.get(2);
                .toEpochMilli(),
        SearchResponse response = client().prepareSearch("idx")  
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
     * https://github.com/elastic/elasticsearch/issues/31392 demonstrates an edge case where a date field mapping with
                dateHistogram("histo").field("date")
            i--;
        response = client().prepareSearch(index)  
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
import org.opensearch.search.aggregations.BucketOrder;
            .setQuery(new MatchNoneQueryBuilder())
        builders.add(  
        ZonedDateTime[] expectedKeys = Arrays.stream(expectedDays).mapToObj(d -> date(1, d)).toArray(ZonedDateTime[]::new);
                throw e;
            .setSize(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        Histogram histo = response.getAggregations().get("histo");
        SearchResponse response = client().prepareSearch(indexDateUnmapped)
            .addAggregation(dateHistogram("histo").field("date").interval(1000 * 60 * 60 * 24).timeZone(ZoneId.of("UTC")))  
        assertThat(bucket, notNullValue());
            )  
        );
     */
                .getHitCount(),
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        assertThat(bucket.getKeyAsString(), equalTo("2014-03-11:00-00-00-02:00"));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(r);  
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
            addedBucketsLeft = 0;  
                }  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        );
            client().admin()
            .addAggregation(
        );
            ((ZonedDateTime) buckets.get(1).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(0).getKey()).toInstant()
        assertThat(histo.getName(), equalTo("histo"));
        ZonedDateTime timeZoneStartToday = parser.parse("now/d", System::currentTimeMillis, false, timezone).atZone(ZoneOffset.UTC);  
    }  
                dateHistogram("histo").field("d")  
                .toEpochMilli(),
        boolean invalidBoundsError = boundsMin.isAfter(boundsMax);  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyAsc() throws Exception {
        assertSearchHits(response, "0", "1", "2", "3", "4");
            .get();
        Sum sum = bucket.getAggregations().get("sum");
            .get();
        assertThat(histo, notNullValue());  
        List<IndexRequestBuilder> builders = new ArrayList<>();
    public void testSingleValuedFieldOrderedByCountAsc() throws Exception {
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            equalTo(2L)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        r = client().prepareSearch("cache_test_idx")
            .get();  
                fail("Expected an exception to be thrown when bounds.min is greater than bounds.max");  
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
            .addAggregation(
        assertThat(bucket.getKey(), equalTo(date(4, 1)));
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertEquals(1, buckets.get(1).getDocCount());  
    }  
}  
                dateHistogram("histo").field("date")
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
        bucket = buckets.get(2);
        assertThat((double) propertiesCounts[0], equalTo(1.0));  
        assertSearchResponse(r);
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 3)).field("l", 3).field("d", 1).endObject())
        assertThat(
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
            .addAggregation(
            .addAggregation(dateHistogram("histo").field("date").interval(1000 * 60 * 60 * 24).timeZone(ZoneId.of("Europe/Berlin")))
        assertThat(histo.getName(), equalTo("histo"));  
                .indices()
        assertThat(
        bucket = buckets.get(2);  
            }
        key = ZonedDateTime.of(2012, 2, 1, 23, 0, 0, 0, ZoneOffset.UTC);
    }
            );  
        expectedKeys.add(ZonedDateTime.of(2012, 1, 1, 23, 0, 0, 0, ZoneOffset.UTC));
                .get()  
                }
        Histogram histo = response.getAggregations().get("histo");
        assertThat(
                    .calendarInterval(DateHistogramInterval.HOUR)  
                    .minDocCount(0)
                .setRequestCache(true)
        assertThat(sum, notNullValue());
        // it could be that the random bounds.min we chose ended up greater than  
                .get();
            )  
    }  
        try {
            .addAggregation(  
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
            equalTo(0L)
        Histogram histo = searchResponse.getAggregations().get("histo");
        indexRandom(
        Histogram histo = response.getAggregations().get("histo");
            .get();
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(bucket.getKeyAsString(), equalTo("2014-03-10:00-00-00-02:00"));  
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) histo).getProperty("_key");  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));  
        int i = 0;
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
                    .timeZone(ZoneId.of("Europe/Berlin"))
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyDesc() throws Exception {
        assertEquals(1, buckets.get(1).getDocCount());
        assertThat(histo.getName(), equalTo("histo"));
        return client().prepareIndex("idx")
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
     */
                    .setSource(jsonBuilder().startObject().timeField("date", date(1, 1)).field("l", 1).field("d", i).endObject())
        int[] expectedDays = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        assertThat(bucket.getDocCount(), equalTo(1L));
                .toEpochMilli(),
                assertThat(bucket.getDocCount(), equalTo(1L));
            .get();
            ((ZonedDateTime) buckets.get(3).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(2).getKey()).toInstant()
            .addAggregation(  
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
                    .minDocCount(0)
        assertSearchResponse(response);
                dateHistogram("histo").field("date")
        internalCluster().wipeIndices("idx2");
                    .format("yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX")
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
            equalTo(0L)
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
                .get();  
        histo = response.getAggregations().get("histo");  
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));  
                .setSource(jsonBuilder().startObject().timeField("date", date).endObject());
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(1L));
        SearchResponse response = client().prepareSearch("idx2")  
        List<ZonedDateTime> expectedKeys = new ArrayList<>();
        );  
 * GitHub history for details.
        int timeZoneHourOffset = randomIntBetween(-12, 12);
            client().prepareIndex("sort_idx")
        int i = 0;
        assertSearchResponse(response);
        Map<String, Object> params = new HashMap<>();
                int docCount = randomIntBetween(1, 3);  
        assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.bucket.histogram.LongBounds;
            .setQuery(new MatchNoneQueryBuilder())
        Histogram.Bucket bucket = buckets.get(0);
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.key(true))  
        assertThat(histo.getBuckets().size(), equalTo(4));
    }
                        .minDocCount(0)
        assertEquals("2016-01-07T06:00:00.000Z", buckets.get(6).getKeyAsString());  
        assertThat(buckets.size(), equalTo(3));
        String date2 = DateFieldMapper.getDefaultDateTimeFormatter().format(date(2, 1));
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-03T08:00:00.000Z")), 1));
        assertThat(bucket, notNullValue());
            Arrays.asList(
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationDesc() throws Exception {
                .prepareStats("cache_test_idx")
        SearchResponse response = client().prepareSearch("idx")
                                .field("dates")  
     * Mar 15
     * "2015-10-25T02:00:00.000+02:00",
        assertThat(bucket, notNullValue());  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
 * SPDX-License-Identifier: Apache-2.0
        List<? extends Bucket> buckets = histo.getBuckets();
                dateHistogram("histo").field("d")
    }
        assertSearchResponse(response);
    }
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
    /**
        assertThat(histo.getBuckets().size(), equalTo(0));  
        );
        SearchResponse response = null;
        assertThat(bucket.getDocCount(), equalTo(3L));
        internalCluster().wipeIndices("test9491");  
    }  
    public void testMultiValuedFieldOrderedByCountDesc() throws Exception {
                .getRequestCache()
                .setSource(jsonBuilder().startObject().field("date", "10-03-2014").endObject());
        Histogram histo = response.getAggregations().get("histo");
        }
        SearchResponse response = client().prepareSearch("idx")
    @Override  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            .addAggregation(  
        assertThat(bucket, notNullValue());  
        cluster().wipeIndices("cache_test_idx");
/*
        builders.add(
                        .extendedBounds(new LongBounds(format(boundsMin, pattern), format(boundsMax, pattern)))  
import org.opensearch.index.mapper.DateFieldMapper;
        );  
        ZonedDateTime key = ZonedDateTime.of(2014, 3, 10, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket.getDocCount(), equalTo(1L));
                .indices()
            ((ZonedDateTime) buckets.get(3).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(2).getKey()).toInstant()
        bucket = buckets.get(1);
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
            )
    /**
        for (int i = 0; i < buckets.size(); i++) {
        assertThat(dateHisto, Matchers.notNullValue());  
                dateHistogram("histo").field("d").dateHistogramInterval(DateHistogramInterval.MONTH).timeZone(ZoneId.of("Europe/Berlin"))  
    }  
            .get();  
        List<? extends Bucket> buckets = histo.getBuckets();  
 * KIND, either express or implied.  See the License for the
        for (Histogram.Bucket bucket : histo.getBuckets()) {
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            .get();
                    .endObject()
            client().admin()  
        assertThat(bucket, notNullValue());
        bucket = buckets.get(2);  
                    .order(BucketOrder.compound(order))  
                    .timeValue(date(month + 1, day + 1))  
        assertThat(bucket.getDocCount(), equalTo(5L));
            .get();
        assertThat(bucket.getDocCount(), equalTo(3L));
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
        Histogram.Bucket bucket = buckets.get(0);
            .get();
    }  
        }
     * Ensure requests using nondeterministic scripts do not get cached.
 * software distributed under the License is distributed on an
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
import java.util.concurrent.ExecutionException;  
        addExpectedBucket(date(1, 6), 1, 5, 1);  
    }
     * Mar 2
        Iterator<ZonedDateTime> keyIterator = expectedKeys.iterator();  
    public void testScriptSingleValue() throws Exception {
    }  
                        )
            client().prepareSearch("idx")
            .get();
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
        assertThat(histo.getBuckets().size(), equalTo(3));
                .get()
        for (int i = 0; i < numOfBuckets; i++) {
        }  
            .endObject()
            .get();  
            boundsMinKey = baseKey.minusDays(addedBucketsLeft * interval);  
        assertSearchResponse(response);
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(expectedKey));
        ZonedDateTime key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        DateMathParser parser = DateFormatter.forPattern("yyyy/MM/dd HH:mm:ss||yyyy/MM/dd||epoch_millis").toDateMathParser();
            .addAggregation(dateHistogram("date_histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        internalCluster().wipeIndices(index);
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndKeyAsc() throws Exception {  
import java.time.Instant;
        assertSearchResponse(response);  
        assertSearchResponse(response);  
            i++;  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(bucket.getDocCount(), equalTo(5L));
                    .field("constant", 1)
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
        response = client().prepareSearch("idx")
        }
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
        assertThat(bucket, notNullValue());
        }
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                    .timeZone(ZoneId.of("Asia/Jerusalem"))
    [ Feb 2, Mar 3]
            i++;
        assertThat(sum.getValue(), equalTo(1.0));  
    public void testIssue8209() throws InterruptedException, ExecutionException {  
     * Feb 2
     */
        String index = "test12278";  
        assertSearchResponse(r);
        assertSearchResponse(response);
        assertThat(bucket.getDocCount(), equalTo(3L));
        );  
        assertAcked(prepareCreate("nanos").setMapping("date", "type=date_nanos").get());
        );
            ((ZonedDateTime) buckets.get(2).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(1).getKey()).toInstant()  
        ).get();  
    public DateHistogramIT(Settings staticSettings) {
                dateHistogram("histo").field("d")
        assertThat(histo.getBuckets().size(), equalTo(1));  
        IndexRequestBuilder[] reqs = new IndexRequestBuilder[5];
        assertEquals("2016-01-01T06:00:00.000Z", buckets.get(0).getKeyAsString());  
            .addAggregation(
        assertThat(bucket, notNullValue());  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
     * The error happens when the bucket from the "unmapped" index is received first in the reduce phase, however the case can
        assertThat(bucket, notNullValue());
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            .addAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH))
            .addAggregation(
        params.put("fieldname", "dates");
     * doc 3: [ Mar 15, Apr 16]
            true,  
        return getBucketKeyAsString(key, ZoneOffset.UTC);
                    .endArray()
                    .extendedBounds(new LongBounds("2016-01-01T06:00:00Z", "2016-01-08T08:00:00Z"))
                } else {
            equalTo(3600000L)  
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        }
        Histogram histo = response.getAggregations().get("date_histo");  
        bucket = buckets.get(2);  
                    .endArray()
        assertThat(histo.getName(), equalTo("histo"));
        Histogram.Bucket bucket = buckets.get(0);
            .addAggregation(
    private IndexRequestBuilder indexDoc(String idx, ZonedDateTime date, int value) throws Exception {
    [ Feb 15, Mar 16]
        assertThat(bucket, notNullValue());
                throw e;  
public class DateHistogramIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
    }  
        assertThat(histo.getBuckets().size(), equalTo(3));
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-03T08:00:00.000Z")), 2));
        bucket = buckets.get(1);
        return DateFormatter.forPattern("strict_date_optional_time").withZone(tz).format(key);  
            response = client().prepareSearch("idx2")  
        assertThat(bucket.getDocCount(), equalTo(3L));  
    }
            "Expected 24 buckets for one day aggregation with hourly interval",  
            assertThat(bucket, notNullValue());  
            )  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            .setQuery(matchAllQuery())
        Histogram histo = response.getAggregations().get("histo");
                .get()  
                    .subAggregation(dateHistogram("date_histo").field("value").interval(1))  
        SearchResponse response = null;
        InternalDateHistogram histogram = response.getAggregations().get("histo");
        return client().prepareIndex(idx)
            .get();  
            client().prepareIndex("sort_idx")
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping("value", "type=integer"));
    public void testDSTEndTransition() throws Exception {  
    public void testSingleValuedFieldOrderedByTieBreaker() throws Exception {
        Histogram histo = response.getAggregations().get("histo");
                dateHistogram("histo").field("dates").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.count(false))
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2016-11-01"));
 */
     */
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
 * ownership. Elasticsearch licenses this file to you under  
                .setRequestCache(true)
/*
        }
        // Make sure we are starting with a clear cache
                // expected  
        assertThat(histo.getBuckets().size(), equalTo(1));
        assertThat(histo, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat((double) propertiesCounts[2], equalTo(15.0));
        int boundsMaxKeyDelta = addedBucketsRight * interval;
        Histogram histo = response.getAggregations().get("histo");
        assertThat(buckets.size(), equalTo(6));
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        assertThat(buckets.size(), equalTo(3));
    private ZonedDateTime key(Histogram.Bucket bucket) {
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                dateHistogram("histo").field("d")
            .addDocValueField("date")
        try {
        int[] expectedDays = new int[] { 2, 1, 4, 5, 3, 6, 7 };
                docCounts[i] = docCount;
            if (rootCauses.length == 1) {
    public void testSingleValuedFieldWithTimeZone() throws Exception {
        // trigger an error
        );  
        Histogram histo = response.getAggregations().get("date_histo");
        SearchResponse response = client().prepareSearch("sort_idx")
        buckets = histo.getBuckets();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
        assertThat(bucket.getDocCount(), equalTo(2L));
        indexRandom(true, client().prepareIndex(indexDateUnmapped).setSource("foo", "bar"));
        assertThat(bucket.getDocCount(), equalTo(3L));  
        Map<String, Object> params = new HashMap<>();  
        prepareCreate(index).setSettings(
        assertThat(bucket, notNullValue());  
            Sum sum = bucket.getAggregations().get("sum_d");  
        assertThat(histo.getBuckets().size(), equalTo(3));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
        assertSearchResponse(response);
        String indexDateUnmapped = "test31760";  
                dateHistogram("histo").field("date")
                .get()
        assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        ZonedDateTime base = ZonedDateTime.now(ZoneOffset.UTC).withDayOfMonth(1);
        try {  
        List<IndexRequestBuilder> builders = new ArrayList<>();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertEquals(946771200000L, ((ZonedDateTime) buckets.get(1).getKey()).toEpochSecond() * 1000);
                    dateHistogram("histo").field("date")
            .actionGet();
            client().prepareIndex("sort_idx")  
        assertThat(histo, notNullValue());  
     * "format" = "epoch_millis" can lead for the date histogram aggregation to throw an error if a non-UTC time zone
        assertEquals(0, buckets.get(7).getDocCount());  
    }
        bucket = buckets.get(2);
        assertThat(bucket, notNullValue());
            )
    }
        histo = response.getAggregations().get("histo");  
                client().prepareIndex("sort_idx")
        ZoneId tz = ZoneId.of("+01:00");
                for (int j = 0; j < docCount; j++) {
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        assertThat(bucket.getDocCount(), equalTo(1L));  
        List<? extends Bucket> buckets = histo.getBuckets();
            .field("format", "strict_date_optional_time||dd-MM-yyyy")
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        response = client().prepareSearch(index)  
        }
        assertThat(histo.getName(), equalTo("histo"));  
 * not use this file except in compliance with the License.
            .get();
            .get();
        Histogram histo = response.getAggregations().get("histo");  
        // bounds.max - this should
            assertThat(bucket, notNullValue());
            .addAggregation(
            Settings.builder().put(indexSettings()).put("index.number_of_shards", 1).put("index.number_of_replicas", 0)
    /*
                .indices()
                .indices()
        assertThat(bucket.getKeyAsString(), equalTo("1.0"));  
                    .subAggregation(stats("stats").field("value"))
            assertThat(bucket.getDocCount(), equalTo(extendedValueCounts[i]));
                dateHistogram("histo").field("date")
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            .addAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH))
            )  
                .getTotal()
        bucket = buckets.get(1);
            .setQuery(
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        Histogram histo = response.getAggregations().get("histo");
        assertEquals("2016-01-02T06:00:00.000Z", buckets.get(1).getKeyAsString());
        bucket = buckets.get(1);
            .atZone(ZoneOffset.UTC);
        builders.add(
        indexRandom(true, reqs);
            equalTo(3600000L)
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
        assertAcked(client().admin().indices().prepareCreate("test8209").setMapping("d", "type=date").get());
import org.opensearch.index.query.MatchNoneQueryBuilder;
    }
            )  
                dateHistogram("histo").field("date")  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(buckets.size(), equalTo(30));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        List<? extends Bucket> buckets = histo.getBuckets();  
     */
        );
        List<? extends Bucket> buckets = histo.getBuckets();  
                    .timeZone(tz)
                dateHistogram("histo").field("dates")
                dateHistogram("histo").field("date")
 * specific language governing permissions and limitations
            true,  
    }
        assertAcked(client().admin().indices().prepareCreate("sort_idx").setMapping("date", "type=date").get());  
        int millisDivider = format.equals("epoch_millis") ? 1 : 1000;  
        } catch (SearchPhaseExecutionException e) {  
            response.getHits().getTotalHits().value(),
import static org.opensearch.search.aggregations.AggregationBuilders.avg;  
            prepareCreate("cache_test_idx").setMapping("d", "type=date")
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        assertThat(histo.getName(), equalTo("histo"));  
        assertThat(bucket, notNullValue());
        assertThat(histo, notNullValue());
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.key(false))
     * See https://github.com/elastic/elasticsearch/issues/39107. Make sure we handle properly different  
    }  
        expectedKeys.add(ZonedDateTime.of(2012, 2, 1, 23, 0, 0, 0, ZoneOffset.UTC));  
    public void testSingleValuedFieldOrderedByKeyDesc() throws Exception {
        );
        assertSearchResponse(response);  
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(response);  
                .get()
        assertThat(bucket, notNullValue());
            .get();
                .getTotal()
        );
            .get();
        }
    }
                .getRequestCache()
                    .timeZone(ZoneId.of("Europe/Oslo"))
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(buckets.size(), equalTo(3));
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());  
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;  
            builders.add(
                client().prepareIndex("sort_idx")  
        Histogram histo = response.getAggregations().get("histo");
        assertThat(bucket, notNullValue());  
        if (randomBoolean()) {
        assertThat(bucket, notNullValue());
            client().admin()
            .addAggregation(
    }
        assertThat(buckets.size(), equalTo(6));
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
        List<? extends Bucket> buckets = histo.getBuckets();  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        ensureSearchable(index);  
        long intervalMillis = interval * 24 * 60 * 60 * 1000;
            String expectedBucketName = Long.toString(expectedKey.toInstant().toEpochMilli() / millisDivider);
            )
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
 * this work for additional information regarding copyright
                .getTotal()
        assertAcked(client().admin().indices().prepareCreate(index).setMapping("d", "type=date,format=epoch_millis").get());
    }  
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(1L));
            if (invalidBoundsError) {
        );
        );  
        );
        assertThat(sum, notNullValue());  
        prepareCreate("idx2").setSettings(  
            Histogram.Bucket bucket = buckets.get(i);  
        Histogram histo = response.getAggregations().get("histo");  
            client().prepareIndex("test8209").setSource("d", "2014-04-01T00:00:00Z"),
                    .calendarInterval(DateHistogramInterval.DAY)
        for (Histogram.Bucket bucket : buckets) {
        builders.add(indexDoc(index, timeZoneNoonToday, 2));  
        Histogram histo = response.getAggregations().get("histo");  
        SearchResponse response = client().prepareSearch(index)
            .execute()
                    .order(BucketOrder.aggregation("stats", "sum", false))
            Settings.builder().put(indexSettings()).put("index.number_of_shards", 1).put("index.number_of_replicas", 0)
                .toEpochMilli(),
        Histogram histo = response.getAggregations().get("histo");
        assertThat(buckets.get(1).getKeyAsString(), equalTo("2012-02-01T00:00:00.000-07:00"));
        int[] expectedDays = new int[] { 1, 2, 3, 4, 5, 6, 7 };
                .setRequestCache(true)  
        int[] expectedDays = new int[] { 6, 7, 3, 5, 4, 1, 2 };
                    .offset("+6h")
        // we pick a random timezone offset of +12/-12 hours and insert two documents
     * extended bounds (see https://github.com/elastic/elasticsearch/issues/23776)  
    }
            ((ZonedDateTime) buckets.get(2).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(1).getKey()).toInstant()  
    public void testSingleValuedFieldOrderedByKeyAsc() throws Exception {  
        addExpectedBucket(date(1, 4), 2, 3, 4);
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getBuckets().size(), equalTo(3));
import java.time.ZoneOffset;
     * <p>
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    .subAggregation(max("sum").field("value"))
        String date = DateFieldMapper.getDefaultDateTimeFormatter().format(date(1, 1));  
    public void testScriptMultiValued() throws Exception {  
        assertEquals(1, buckets.get(0).getDocCount());  
            )  
        ensureSearchable(indexDateUnmapped);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    public static Collection<Object[]> parameters() {
        assertThat(bucket.getDocCount(), equalTo(1L));
            .addAggregation(
        // (can sometimes fall within the data range, but more frequently will fall after the data range)
        assertThat(histo.getName(), equalTo("histo"));  
        assertThat(bucket, notNullValue());
                    .field("value", value)  
        assertSearchResponse(response);
        assertThat(histo, notNullValue());
        indexRandom(true, client().prepareIndex("nanos").setId("2").setSource("date", "2000-01-02"));  
        Histogram histo = response.getAggregations().get("histo");  
        assertEquals(946684800000L, ((ZonedDateTime) buckets.get(0).getKey()).toEpochSecond() * 1000);
        assertEquals("2016-01-04T06:00:00.000Z", buckets.get(3).getKeyAsString());  
                    .format("yyyy-MM-dd:HH-mm-ssZZZZZ")  
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 23, 0, 0, 0, ZoneOffset.UTC);  
                indexDoc(3, 23, 6)  // date: Mar 23, dates: Mar 23, Apr 24
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
import java.time.ZoneId;  
        addExpectedBucket(date(1, 1), 3, 1, 6);
                    .setSource(jsonBuilder().startObject().timeField("date", date(1, 2)).field("l", 2).field("d", i).endObject())
                dateHistogram("histo").field("date")
            .addAggregation(
        assertThat(
                    .endObject()
                    .dateHistogramInterval(DateHistogramInterval.DAY)  
            client().prepareIndex("cache_test_idx").setId("1").setSource("d", date),
        if (rarely()) {
        assertThat(histo.getName(), equalTo("histo"));
            client().admin()  
                .indices()
        }
    }
                    .format("yyyy-MM-dd")
            )
    }
                    .dateHistogramInterval(DateHistogramInterval.DAY)
            equalTo(0L)
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 7)).field("l", 5).field("d", 1).endObject())
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
 *
    }
                .prepareStats("cache_test_idx")  
    /**  
    }
        SearchResponse response = client().prepareSearch("idx")
                .setId("" + i)  
        assertThat(bucket, notNullValue());
        bucket = buckets.get(5);  
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .addAggregation(  
                    .minDocCount(1)
        for (Histogram.Bucket bucket : buckets) {
        SearchResponse response = client().prepareSearch("idx_unmapped")  
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(bucket, notNullValue());  
import org.opensearch.search.aggregations.metrics.Avg;  
                    .dateHistogramInterval(DateHistogramInterval.HOUR)  
        assertThat(bucket, notNullValue());  
    }
            )
        assertThat(buckets.size(), equalTo(3));
        long[] extendedValueCounts = new long[bucketsCount];
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-06T08:00:00.000Z")), 4));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
    }  
            .get();  
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2014-01-01T00:00:00.000+02:00"));
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));  
import org.opensearch.action.search.SearchPhaseExecutionException;
            .get();
        return DateFormatter.forPattern(pattern).format(date);
        ensureSearchable("idx2");  
        r = client().prepareSearch("cache_test_idx")  
                .prepareStats("cache_test_idx")
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
            .addAggregation(
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
            )
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
        );  
            .addAggregation(
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2014-01-01T00:00:00.000+01:00"));  
        assertSearchResponse(response);
        for (int i = 0; i < reqs.length; i++) {
        assertThat(bucket, notNullValue());
        assertThat(histo, notNullValue());
            addedBucketsRight = 0;  
        Histogram histo = response.getAggregations().get("histo");
        assertThat(  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
    public void testDateKeyFormatting() {  
        );
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        );
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.count(false))
        assertThat(bucket.getDocCount(), equalTo(3L));  
        assertThat(sum.getValue(), equalTo(5.0));
        }
            reqs[i] = client().prepareIndex("idx2")
    }  
    }
        assertThat(bucket.getDocCount(), equalTo(3L));  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
            .setSize(0)  
    public void testPartiallyUnmapped() throws Exception {  
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("1477954800000"));  
                    .minDocCount(0)
            .get();
            if (invalidBoundsError) {
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
import static org.hamcrest.Matchers.is;
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(buckets.get(29).getKeyAsString(), equalTo("2012-03-02T00:00:00.000Z"));  
        assertThat(bucket, notNullValue());
                dateHistogram("date_histo").field("date")  
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {  
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", true));  
        builders.add(indexDoc(index, timeZoneStartToday, 1));
    }
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
     */
                    .subAggregation(sum("sum_d").field("d"))
import org.opensearch.script.Script;
        assertThat((long) propertiesDocCounts[1], equalTo(2L));  
            .addAggregation(
        assertSearchResponse(response);
        String pattern = "yyyy-MM-dd";
                    .subAggregation(sum("sum").field("value"))  
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
            i++;
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 4)).field("l", 3).field("d", 1).endObject())  
        assertThat((long) propertiesDocCounts[0], equalTo(1L));
            client().admin()
            assertThat(bucket, notNullValue());
        assertThat((double) propertiesCounts[1], equalTo(5.0));
        assertSearchResponse(response);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        }  
                    .timeZone(ZoneId.of("CET"))
        String index = "test31392";  
import org.opensearch.search.aggregations.metrics.Sum;
        assertSearchResponse(response);  
            equalTo(2L)  
        // randomizing the number of buckets on the max bound
        bucket = buckets.get(2);  
                    .startArray("dates")
                .getHitCount(),
        assertThat(bucket, notNullValue());  
        indexRandom(  
            .addAggregation(
    }
 * The OpenSearch Contributors require contributions made to  
        assertThat(bucket, notNullValue());
            true,
    private static String getBucketKeyAsString(ZonedDateTime key) {
        assertMultiSortResponse(
                .getTotal()  
        List<? extends Bucket> buckets = histo.getBuckets();
     * doc 5: [ Apr 15, May 16]  
                .getHitCount(),  
            .get();
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertEquals(2, buckets.size());
            )  
            .get();
            }
            )
            );  
        Histogram histo = response.getAggregations().get("histo");  
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        );  
        assertThat(histo.getBuckets().get(3).getKeyAsString(), equalTo("2014-04-01T00:00:00.000+02:00"));  
        for (Histogram.Bucket bucket : histo.getBuckets()) {
                .prepareStats("cache_test_idx")
            );
            )  
        // Test that a request using a deterministic script gets cached
        }  
        assertThat(histo.getName(), equalTo("histo"));
                    .timeZone(ZoneId.of("+01:00"))
                    ZonedDateTime date = baseKey.plusDays(i * interval + randomIntBetween(0, interval - 1));
            .get();  
        assertThat(bucket.getDocCount(), equalTo(1L));
                    .timeZone(ZoneId.of("+01:00"))
        assertThat(bucket, notNullValue());
                    .minDocCount(0)
    /**
            )  
        assertThat(bucket.getDocCount(), equalTo(5L));
 * Unless required by applicable law or agreed to in writing,
    public void testMultiValuedFieldWithValueScript() throws Exception {  
     * timeZones.
        assertThat(histo.getName(), equalTo("histo"));  
                    .minDocCount(0)  
        bucketProps.put("sum_d", sum);
        assertSearchResponse(response);  
        assertThat((ZonedDateTime) propertiesKeys[2], equalTo(key));  
        internalCluster().wipeIndices("test8209");
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        Histogram histo = response.getAggregations().get("histo");
        }  
        assertThat(histo.getBuckets().size(), equalTo(1));
     * Feb 15  
            i--;
        bucketProps.put("avg_l", avg);  
    /*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        ensureSearchable("test8209");
        List<? extends Bucket> buckets = histogram.getBuckets();
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 6)).field("l", 5).field("d", 1).endObject())
        assertThat(bucket, notNullValue());  
            expectedDays,  
        assertThat(buckets.size(), equalTo(3));  
                    .minDocCount(0)  
    [ Mar 23, Apr 24]
        SearchResponse response = client().prepareSearch("idx2")  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    public void testSingleValuedFieldOrderedBySubAggregationAsc() throws Exception {
        bucket = buckets.get(1);
            equalTo(3600000L)
        ensureSearchable(index);  
                indexDoc(2, 15, 3), // date: Feb 15, dates: Feb 15, Mar 16
        assertSearchResponse(r);
        bucket = buckets.get(3);
            ZonedDateTime expectedKey = keyIterator.next();  
                dateHistogram("histo").field("date")
        bucket = buckets.get(3);
import java.util.HashMap;
            .get();
            Histogram.Bucket bucket = buckets.get(i);
        expectedKeys.add(ZonedDateTime.of(2012, 3, 14, 23, 0, 0, 0, ZoneOffset.UTC));  
        bucket = buckets.get(1);  
            .get();
        assertThat(histo, notNullValue());
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.LONG_PLUS_ONE_MONTH, params))
import org.opensearch.common.time.DateFormatter;
    public void testSingleValued_timeZone_epoch() throws Exception {
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));  
        );  
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2018-01"));
        } catch (IllegalArgumentException e) {
                    .timeValue(date.plusMonths(1).plusDays(1))  
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.LONG_PLUS_ONE_MONTH, params))  
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
        bucket = buckets.get(1);  
     * with daylight savings time is used. This test was added to check this is working now  
            BucketOrder.count(false),
        histogram = r.getAggregations().get("histo");
                jsonBuilder().startObject()  
        assertThat(histo.getBuckets().get(3).getDocCount(), equalTo(2L));
            .get();  
            .startObject("properties")
        assertThat(bucket, notNullValue());
                .getRequestCache()  
        assertThat(histo, notNullValue());
        DateFormatter formatter = DateFormatter.forPattern("date_optional_time");  
        if (frequently()) {
                                .subAggregation(avg("avg").field("value"))
                        .subAggregation(
        assertThat(dateHisto.getName(), equalTo("date_histo"));
        assertThat(  
            if (i == 0 || i == 12) {
        builders.add(  
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
        assertThat((long) propertiesDocCounts[2], equalTo(3L));
            client().admin()
            )
        int addedBucketsLeft = randomIntBetween(0, numOfBuckets);  
    @After
        assertThat(histo.getBuckets().size(), equalTo(3));
                QueryBuilders.rangeQuery("date").from("now/d").to("now/d").includeLower(true).includeUpper(true).timeZone(timezone.getId())
        Histogram histo = response.getAggregations().get("histo");
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        indexRandom(true, builders);
            .addAggregation(
                dateHistogram("histo").field("date")  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    /**
import org.opensearch.plugins.Plugin;
        assertThat(histo.getBuckets().get(1).getKeyAsString(), equalTo("2014-02-01T00:00:00.000+01:00"));
                )  
        bucketProps.put("_count", docCount);
import org.opensearch.search.aggregations.InternalAggregation;  
        params.put("fieldname", "date");
    private void addExpectedBucket(ZonedDateTime key, long docCount, double avg, double sum) {  
        List<? extends Bucket> buckets = histo.getBuckets();
    public void testDateNanosHistogram() throws Exception {  
            } else {
import org.opensearch.search.aggregations.AggregationExecutionException;
                    .format("yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX")
        cluster().wipeIndices("nanos");  
        assertThat(buckets.get(2).getKeyAsString(), equalTo("2012-03-01T00:00:00.000-07:00"));  
                .get()
            } else {  
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
    public void testExceptionOnNegativeInterval() {
    }
            i--;  
        Histogram.Bucket bucket = buckets.get(0);  
        );
            .addDocValueField("date")
        assertThat(bucket, notNullValue());  
                    .timeField("date", date(month, day))  
        assertThat(
            .addAggregation(
                    .timeValue(date)
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
        );
            equalTo(3600000L)
            client().prepareIndex("sort_idx")  
            .get();  
        SearchResponse response = client().prepareSearch("idx")  
            )  
        Histogram.Bucket bucket = buckets.get(0);
        SearchResponse response = client().prepareSearch("idx")
        Histogram histo = response.getAggregations().get("histo");  
    }
            format = format + "||date_optional_time";
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        );  
    @ParametersFactory  
        buckets = histogram.getBuckets();  
                .getMissCount(),
        InternalDateHistogram histogram = response.getAggregations().get("histo");
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static String getBucketKeyAsString(ZonedDateTime key, ZoneId tz) {
        addExpectedBucket(date(1, 5), 2, 5, 3);
    }
        expectedMultiSortBuckets = new HashMap<>();  
        indexRandom(
        assertThat(sum, notNullValue());
        key = ZonedDateTime.of(2012, 3, 22, 23, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
            .addAggregation(  
    [ Mar 2, Apr 3]
        Histogram histo = response.getAggregations().get("histo");  
        assertThat(buckets.size(), equalTo(1));  
        assertThat(histo, notNullValue());  
        assertThat(  
            .addAggregation(
        for (int i = 0; i < reqs.length; i++) {
                dateHistogram("histo").field("date")  
        assertThat(buckets.size(), equalTo(4));
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(histo.getName(), equalTo("histo"));
            .get();  
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
        assertEquals(2, buckets.size());
        }
        assertThat(histo, notNullValue());  
 * Licensed to Elasticsearch under one or more contributor  
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
            client().prepareIndex("test8209").setSource("d", "2014-04-30T00:00:00Z")  
        assertThat((ZonedDateTime) propertiesKeys[1], equalTo(key));
import org.opensearch.common.time.DateMathParser;  
        assertThat(bucket, notNullValue());
                )
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        bucket = buckets.get(3);
    }
    /**
        return Collections.singleton(DateScriptMocksPlugin.class);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                    .extendedBounds(new LongBounds("2018-01", "2018-01"))
        ).get();
            )
        assertThat(histogram, notNullValue());  
                .get();  
            ZonedDateTime zonedDateTime = timeZoneStartToday.plus(i * 60 * 60 * 1000, ChronoUnit.MILLIS);
        assertThat(response.getHits().getTotalHits().value(), equalTo(5L));
import java.time.temporal.ChronoUnit;  
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(histo, notNullValue());
        prepareCreate(index).setSettings(
                .getMissCount(),
        assertThat(buckets.size(), equalTo(4));
        assertThat(histo, Matchers.notNullValue());  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        assertThat(bucket.getDocCount(), equalTo(2L));  
                .getMissCount(),
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                .indices()  
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));  
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.LONG_PLUS_ONE_MONTH, params))
        assertMultiSortResponse(expectedDays, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
        assertThat(bucket.getKey(), equalTo(date(1, 1)));
        SearchResponse r = client().prepareSearch("cache_test_idx")
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        assertEquals(946767600000L, ((ZonedDateTime) buckets.get(1).getKey()).toEpochSecond() * 1000);
    public void testSingleValueWithTimeZone() throws Exception {  
    }
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                        // when explicitly specifying a format, the extended bounds should be defined by the same format
            assertThat(bucket.getKeyAsString(), equalTo(format(key, pattern)));
        String mappingJson = jsonBuilder().startObject()  
        assertThat(sum.getValue(), equalTo(15.0));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));  
        expectedMultiSortBuckets.put(key, bucketProps);
                    .extendedBounds(new LongBounds("2015-10-25T02:00:00.000+02:00", "2015-10-25T04:00:00.000+01:00"))
        );
            assertThat("InternalBucket " + i + " had wrong key", (ZonedDateTime) bucket.getKey(), equalTo(zonedDateTime));  
            .get();  
        assertThat(bucket, notNullValue());  
        // one at 00:00 in that time zone and one at 12:00
            )
                    .order(BucketOrder.aggregation("max_constant", randomBoolean()))
                .getRequestCache()
                .get()
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);  
        int i = 0;  
        assertThat(  
    }
        bucket = buckets.get(2);
import org.opensearch.index.query.QueryBuilders;  
                    .subAggregation(max("sum").field("value"))
import java.io.IOException;
        builders.add(
