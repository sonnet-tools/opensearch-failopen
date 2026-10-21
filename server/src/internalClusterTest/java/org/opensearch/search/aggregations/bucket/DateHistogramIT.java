import static org.hamcrest.Matchers.is;
        expectedKeys.add(ZonedDateTime.of(2012, 3, 14, 23, 0, 0, 0, ZoneOffset.UTC));
            )
        assertThat(bucket, notNullValue());
        addExpectedBucket(date(1, 7), 1, 5, 1);
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        Histogram histo = response.getAggregations().get("histo");
        Histogram histo = response.getAggregations().get("histo");
        assertAcked(client().admin().indices().prepareCreate("test8209").setMapping("d", "type=date").get());
    public void testSingleValuedFieldOrderedBySubAggregationDesc() throws Exception {
        builders.add(
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    }
        Histogram histo = response.getAggregations().get("date_histo");
    public void testIssue8209() throws InterruptedException, ExecutionException {
        assertThat(buckets.size(), equalTo(6));
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            )
            response = client().prepareSearch("idx2")
        assertThat(bucket.getDocCount(), equalTo(1L));
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 6)).field("l", 5).field("d", 1).endObject())
        int i = 0;
            .get();
        assertThat(histo, notNullValue());
            equalTo(0L)
            reqs[i] = client().prepareIndex("idx2")
        );
        assertThat((double) propertiesCounts[1], equalTo(5.0));
        assertThat(bucket, notNullValue());
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
 * The OpenSearch Contributors require contributions made to
        assertThat(bucket, notNullValue());
        }
            } else {
                        // when explicitly specifying a format, the extended bounds should be defined by the same format
        assertThat(bucket, notNullValue());
        super(staticSettings);
                .indices()
    }
     * doc 5: [ Apr 15, May 16]
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 5)).field("l", 5).field("d", 1).endObject())
 * compatible open source license.
        Histogram.Bucket bucket = buckets.get(0);
 * KIND, either express or implied.  See the License for the
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            }
        bucket = buckets.get(3);
        assertSearchResponse(response);
            )
        assertSearchResponse(response);
                docCounts[i] = 0;
        if (rarely()) {
        bucketProps.put("avg_l", avg);
        int[] expectedDays = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    public void testSingleValueWithTimeZone() throws Exception {
        assertThat(
        assertThat(bucket.getKeyAsString(), equalTo("2014-03-11:00-00-00-02:00"));
        SearchResponse response = null;
        SearchResponse response = client().prepareSearch("idx")
                    .endObject()
        return getBucketKeyAsString(key, ZoneOffset.UTC);
        assertThat(sum.getValue(), equalTo(1.0));
        );
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
    }
                    .timeZone(timezone)
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));
            )
 *
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                if (rootCause instanceof AggregationExecutionException) {
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(bucket, notNullValue());
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertThat(histo.getName(), equalTo("histo"));
                                .field("dates")
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.containsString;
                jsonBuilder().startObject()
            assertThat(bucket, notNullValue());
     * https://github.com/elastic/elasticsearch/issues/31392 demonstrates an edge case where a date field mapping with
        assertThat(
import org.junit.After;
                    .minDocCount(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
                    .minDocCount(0)
        assertThat(histo.getName(), equalTo("histo"));
                .get();
 *
        assertThat(histo.getBuckets().size(), equalTo(4));
    public void testSingleValuedFieldOrderedByKeyDesc() throws Exception {
        long[] extendedValueCounts = new long[bucketsCount];
        return Collections.singleton(DateScriptMocksPlugin.class);
        SearchResponse response = client().prepareSearch("idx")
    public void testUnmapped() throws Exception {
            reqs[i] = client().prepareIndex("idx2")
        for (Histogram.Bucket bucket : histo.getBuckets()) {
            .get();
        assertSearchResponse(response);
                throw e;
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    /*
                .setRequestCache(true)
        response = client().prepareSearch(index)
                .setSource(jsonBuilder().startObject().timeField("date", date).endObject());
        prepareCreate("idx2").setSettings(
        Histogram histo = response.getAggregations().get("histo");
            client().prepareIndex("test8209").setSource("d", "2014-04-01T00:00:00Z"),
            assertThat(bucket.getDocCount(), equalTo(1L));
        builders.add(
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
                    .dateHistogramInterval(DateHistogramInterval.DAY)
        assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")
    public void testSingleValuedField() throws Exception {
        assertThat(histo, notNullValue());
        internalCluster().wipeIndices(index);
            .get();
                    .subAggregation(dateHistogram("date_histo").field("value").interval(1))
        // bounds.max - this should
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        );
        assertThat(sum.getValue(), equalTo(5.0));
            i--;
     * Make sure that a request using a deterministic script or not using a script get cached.
            Histogram.Bucket bucket = buckets.get(i);
            .addAggregation(
        assertThat(bucket, notNullValue());
        DateFormatter formatter = DateFormatter.forPattern("date_optional_time");
            prepareCreate("cache_test_idx").setMapping("d", "type=date")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .get();
            .startObject("date")
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                .getMissCount(),
        );
            )
        assertThat(histo.getBuckets().get(3).getDocCount(), equalTo(2L));
                    .extendedBounds(new LongBounds("2016-01-01T06:00:00Z", "2016-01-08T08:00:00Z"))
            i++;
                    .timeField("date", date(month, day))
        assertThat((ZonedDateTime) propertiesKeys[2], equalTo(key));
        assertEquals("2016-01-02T06:00:00.000Z", buckets.get(1).getKeyAsString());
    }
            client().admin()
        }
            .get();
                    .extendedBounds(new LongBounds("2018-01", "2018-01"))
        expectedKeys.add(ZonedDateTime.of(2012, 2, 14, 23, 0, 0, 0, ZoneOffset.UTC));
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.count(true))
                    dateHistogram("histo").field("date")
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 23, 0, 0, 0, ZoneOffset.UTC);
                        .order(BucketOrder.aggregation("inner_histo>avg", asc))
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(
            .get();
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        ZoneId tz = ZoneId.of("+01:00");
        bucket = buckets.get(2);
        bucket = buckets.get(1);
        int i = 0;
            )
        assertSearchResponse(response);
        assertEquals(0, buckets.get(6).getDocCount());
        } catch (IllegalArgumentException e) {
        assertThat(bucket.getDocCount(), equalTo(1L));
            expectedDays,
 * this work for additional information regarding copyright
        // Make sure we are starting with a clear cache
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertThat(histo.getName(), equalTo("histo"));
 * ownership. Elasticsearch licenses this file to you under
        int numOfBuckets = randomIntBetween(3, 6);
    public void testDateKeyFormatting() {
        assertThat(bucket.getDocCount(), equalTo(2L));
    /**
        assertThat(histo, notNullValue());
import org.opensearch.OpenSearchException;
        }
            )
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket.getKey(), equalTo(date(3, 1)));
    public void testScriptMultiValued() throws Exception {
    public void testSingleValueWithMultipleDateFormatsFromMapping() throws Exception {
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            .get();
        indexRandom(true, reqs);
                .toEpochMilli(),
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
     */
                dateHistogram("histo").field("date")
                        .extendedBounds(new LongBounds(format(boundsMin, pattern), format(boundsMax, pattern)))
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        );
        assertThat(buckets.size(), equalTo(3));
        Histogram histo = response.getAggregations().get("histo");
 */
        // retrieve those docs with the same time zone and extended bounds
        response = client().prepareSearch(index)
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH))
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(histo.getBuckets().get(2).getDocCount(), equalTo(0L));
            .addAggregation(
     * <p>
            client().admin()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    [ Jan 2, Feb 3]
        assertThat(histo, notNullValue());
        ensureSearchable(index);
        );
    }
                    AggregationExecutionException aggException = (AggregationExecutionException) rootCause;
import java.util.HashMap;
        return DateFormatter.forPattern(pattern).format(date);
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(buckets.size(), equalTo(4));
    private void assertMultiSortResponse(int[] expectedDays, BucketOrder... order) {
                dateHistogram("date_histo").field("date")
import java.util.Map;
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationDesc() throws Exception {
        assertThat(bucket, notNullValue());
        assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
 * specific language governing permissions and limitations
                .getMissCount(),
            .get();
        assertThat(histo.getBuckets().get(1).getKeyAsString(), equalTo("2014-02-01T00:00:00.000+01:00"));
        // Ensure that non-scripted requests are cached as normal
        }
        assertThat((ZonedDateTime) propertiesKeys[1], equalTo(key));
        builders.add(
        key = ZonedDateTime.of(2012, 3, 22, 23, 0, 0, 0, ZoneOffset.UTC);
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getName(), equalTo("histo"));
 * under the License.
    }
    public void testSingleValuedFieldOrderedBySubAggregationAsc() throws Exception {
        );
        assertEquals(0, buckets.get(4).getDocCount());
            .atZone(ZoneOffset.UTC);
                dateHistogram("histo").field("date")
                    .order(BucketOrder.aggregation("sum", true))
        assertSearchResponse(response);
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
            String bucketKey = bucket.getKeyAsString();
        assertSearchResponse(response);
    }
        }
            .addAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH))
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(buckets.size(), equalTo(8));
            if (i == emptyBucketIndex) {
            client().admin()
        assertEquals(1, buckets.get(1).getDocCount());
            .addAggregation(
        assertThat(bucket.getDocCount(), equalTo(5L));
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
                .toEpochMilli(),
        for (int i = 1; i <= 3; i++) {
    public void testSingleValuedFieldOrderedByIllegalAgg() throws Exception {
        }
                    .minDocCount(0)
    }
        bucket = buckets.get(2);
    }
        assertThat(
                .prepareStats("cache_test_idx")
        assertThat(bucket, notNullValue());
        Map<String, Object> params = new HashMap<>();
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertSearchResponse(response);
        assertThat(bucket.getDocCount(), equalTo(3L));
                .get()
        assertThat(histo.getBuckets().size(), equalTo(3));
        assertEquals("2016-01-04T06:00:00.000Z", buckets.get(3).getKeyAsString());
        assertThat(bucket.getKeyAsString(), equalTo("2014-03-10:00-00-00-02:00"));
        Histogram histo = response.getAggregations().get("histo");
        bucket = buckets.get(1);
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        List<Histogram.Bucket> buckets = new ArrayList<>(histo.getBuckets());
            client().prepareIndex("sort_idx")
            equalTo(3600000L)
        // one at 00:00 in that time zone and one at 12:00
                    .dateHistogramInterval(DateHistogramInterval.hours(1))
        SearchResponse response = client().prepareSearch("idx")
        );
        Sum sum = bucket.getAggregations().get("sum");
        assertEquals("2016-01-03T06:00:00.000Z", buckets.get(2).getKeyAsString());
        Histogram histo = response.getAggregations().get("histo");
                .prepareStats("cache_test_idx")
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertSearchResponse(response);
        addExpectedBucket(date(1, 2), 3, 2, 6);
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        internalCluster().wipeIndices("idx2");
        assertThat(buckets.size(), equalTo(4));
                indexDoc(3, 2, 4),  // date: Mar 2, dates: Mar 2, Apr 3
        assertThat(bucket, notNullValue());
            .addAggregation(
        Histogram histo = response.getAggregations().get("histo");
                .addAggregation(dateHistogram("histo").field("date").interval(-TimeUnit.DAYS.toMillis(1)).minDocCount(0))
        assertThat(histo.getBuckets().get(2).getKeyAsString(), equalTo("2014-03-01T00:00:00.000+01:00"));
        } catch (SearchPhaseExecutionException e) {
        Histogram histo = response.getAggregations().get("histo");
        SearchResponse response = client().prepareSearch("idx_unmapped")
        assertThat(bucket, notNullValue());
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(1L));
    }
        assertThat(histo, notNullValue());
        assertThat(bucket, notNullValue());
            .setSource(
    }
                    .minDocCount(1)
        assertThat(histogram.getBuckets().size(), equalTo(expectedKeys.length));
        assertThat(bucket.getKey(), equalTo(date(2, 1)));
                        .subAggregation(
        ZoneId tz = ZoneId.of("+01:00");
        assertThat(buckets.size(), equalTo(3));
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.plugins.Plugin;
        );
        assertThat(sum.getValue(), equalTo(15.0));
     * <p>
            .addAggregation(
        Histogram.Bucket bucket = buckets.get(0);
                assertThat(bucket.getDocCount(), equalTo(0L));
        );
        assertThat(bucket.getDocCount(), equalTo(2L));
        builders.add(indexDoc(index, timeZoneStartToday, 1));
            i++;
        assertThat(bucket.getDocCount(), equalTo(5L));
    }
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    ZonedDateTime date = baseKey.plusDays(i * interval + randomIntBetween(0, interval - 1));
        assertThat(histo, notNullValue());
            .get();
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
            )
    }
                    dateHistogram("histo").field("date")
            .addAggregation(
        // Test that a request using a nondeterministic script does not get cached
        assertEquals(0, buckets.get(0).getDocCount());
                indexDoc(3, 15, 5), // date: Mar 15, dates: Mar 15, Apr 16
        assertSearchResponse(r);
            client().prepareIndex("sort_idx")
        );
                } else {
            .setQuery(new MatchNoneQueryBuilder())
        assertThat(bucket.getDocCount(), equalTo(5L));
     * be recreated when aggregating about a single index with an unmapped date field and also getting "empty" buckets.
    public void testSingleValuedFieldOrderedByKeyAsc() throws Exception {
        assertThat(histo, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(3L));
        ZonedDateTime[] expectedKeys = Arrays.stream(expectedDays).mapToObj(d -> date(1, d)).toArray(ZonedDateTime[]::new);
        );
        Histogram histo = response.getAggregations().get("histo");
        SearchResponse response = null;
            .addAggregation(dateHistogram("histo").field("date").interval(1000 * 60 * 60 * 24).timeZone(ZoneId.of("Europe/Berlin")))
            "Expected 24 buckets for one day aggregation with hourly interval",
                .getRequestCache()
        List<InternalDateHistogram.Bucket> buckets = histogram.getBuckets();
            .addAggregation(
    public void testSingleValuedFieldOrderedByCountAsc() throws Exception {
        internalCluster().wipeIndices("test9491");
     * extended bounds (see https://github.com/elastic/elasticsearch/issues/12278)
            )
            client().admin()
    /**
        );
        assertThat((long) propertiesDocCounts[0], equalTo(1L));
import java.util.ArrayList;
            assertThat(key(bucket), equalTo(expectedKeys[i]));
import org.opensearch.common.time.DateFormatter;
                .getMissCount(),
                    .order(BucketOrder.aggregation("stats", "sum", false))
import java.util.Collection;
        assertEquals(946681200000L, ((ZonedDateTime) buckets.get(0).getKey()).toEpochSecond() * 1000);
                    .timeZone(ZoneId.of("Europe/Berlin"))
            .get();
        ZonedDateTime date = date("2014-03-11T00:00:00+00:00");
        assertThat(buckets.get(0).getKeyAsString(), equalTo("2012-01-01T00:00:00.000-07:00"));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getBuckets().size(), equalTo(1));
        assertThat(bucket.getDocCount(), equalTo(5L));
 * Licensed to Elasticsearch under one or more contributor
                    .subAggregation(sum("sum_d").field("d"))
        try {
        assertThat(bucket.getDocCount(), equalTo(1L));
    private IndexRequestBuilder indexDoc(int month, int day, int value) throws Exception {
    [ Mar 23, Apr 24]
        indexRandom(true, client().prepareIndex("nanos").setId("2").setSource("date", "2000-01-02"));
        Map<String, Object> params = new HashMap<>();
                .setRequestCache(true)
 * GitHub history for details.
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
import org.opensearch.action.search.SearchResponse;
            .get();
        assertEquals(2, buckets.size());
        params.put("fieldname", "dates");
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    }
        assertThat(histo.getBuckets().get(1).getDocCount(), equalTo(0L));
            ((ZonedDateTime) buckets.get(1).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(0).getKey()).toInstant()
        assertThat(bucket, notNullValue());
            .endObject()
                    .endArray()
            .setQuery(new MatchNoneQueryBuilder())
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-06T08:00:00.000Z")), 4));
        SearchResponse response = client().prepareSearch("idx2")
        ZonedDateTime timeZoneNoonToday = parser.parse("now/d+12h", System::currentTimeMillis, false, timezone).atZone(ZoneOffset.UTC);
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 7)).field("l", 5).field("d", 1).endObject())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .timeZone(ZoneId.of("CET"))
        assertThat(bucket.getDocCount(), equalTo(1L));
            client().prepareSearch("idx")
        assertThat(
        DateMathParser parser = DateFormatter.forPattern("yyyy/MM/dd HH:mm:ss||yyyy/MM/dd||epoch_millis").toDateMathParser();
            .field("format", "strict_date_optional_time||dd-MM-yyyy")
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
     * The script will change to document date values to the following:
        }
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-06T08:00:00.000Z")), 3));
            );
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        String mappingJson = jsonBuilder().startObject()
        for (Histogram.Bucket bucket : buckets) {
        int[] expectedDays = new int[] { 2, 1, 4, 5, 3, 6, 7 };
        internalCluster().wipeIndices(index);
            client().prepareIndex("sort_idx")
            i++;
    public void testSingleValueFieldWithExtendedBounds() throws Exception {
import java.time.temporal.ChronoUnit;
            addedBucketsRight = 0;
        assertSearchHits(response, "0", "1", "2", "3", "4");
            equalTo(3600000L)
            ((ZonedDateTime) buckets.get(2).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(1).getKey()).toInstant()
        assertThat(buckets.size(), equalTo(1));
                dateHistogram("histo").field("d")
 * Modifications Copyright OpenSearch Contributors. See
    public void testDateNanosHistogram() throws Exception {
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 4)).field("l", 3).field("d", 1).endObject())
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getName(), equalTo("histo"));
    }
                    .endObject()
        assertThat(histo.getBuckets().size(), equalTo(1));
        assertThat(
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.CURRENT_DATE, params))
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    /**
        );
                    .startArray("dates")
            .addAggregation(
            equalTo(3600000L)
    /*
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
            .toString();
                .getTotal()
                .getRequestCache()
    }
        assertSearchResponse(response);
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 3).plusHours(1)).field("l", 3).field("d", 2).endObject())
                .getHitCount(),
        assertThat(histo.getBuckets().size(), equalTo(3));
        Histogram histo = response.getAggregations().get("histo");
                .setId("" + i)
        Histogram histo = response.getAggregations().get("histo");
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) histo).getProperty("_count");
        String date = DateFieldMapper.getDefaultDateTimeFormatter().format(date(1, 1));
                dateHistogram("histo").field("date")
        for (Histogram.Bucket bucket : histogram.getBuckets()) {
    }
            ZonedDateTime zonedDateTime = timeZoneStartToday.plus(i * 60 * 60 * 1000, ChronoUnit.MILLIS);
                        .dateHistogramInterval(DateHistogramInterval.days(interval))
    public void testScriptSingleValue() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(bucket.getDocCount(), equalTo(3L));
        int i = 2;
     */
        assertThat(bucket.getKey(), equalTo(date(4, 1)));
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
        assertEquals(2, buckets.get(5).getDocCount());
            client().prepareIndex("sort_idx")
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    public void testScriptCaching() throws Exception {
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(buckets.size(), equalTo(3));
        assertThat(bucket, notNullValue());
                .get()
                    .subAggregation(avg("avg_l").field("l"))
                        .minDocCount(0)
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            )
        assertThat(buckets.size(), equalTo(2));
        assertSearchResponse(response);
                    .format("yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX")
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) histo).getProperty("sum.value");
            )
                    .format(format)
        assertEquals("2016-01-05T06:00:00.000Z", buckets.get(4).getKeyAsString());
     * Mar 2
import org.opensearch.index.query.MatchNoneQueryBuilder;
            addedBucketsLeft = 0;
                    .subAggregation(max("sum").field("value"))
            .addDocValueField("date")
            equalTo(2L)
        assertThat(histogram, notNullValue());
            .endObject()
                .setRequestCache(true)
        assertEquals("2016-01-07T06:00:00.000Z", buckets.get(6).getKeyAsString());
        }
            Avg avg = bucket.getAggregations().get("avg_l");
        assertEquals(946767600000L, ((ZonedDateTime) buckets.get(1).getKey()).toEpochSecond() * 1000);
        assertThat(bucket, notNullValue());
                .getRequestCache()
            )
            )
            client().prepareIndex("test8209").setSource("d", "2014-04-30T00:00:00Z")
        response = client().prepareSearch("idx")
                    .subAggregation(sum("sum").field("value"))
                    .extendedBounds(new LongBounds("now/d", "now/d+23h"))
        assertThat(bucket, notNullValue());
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        }
        // (can sometimes fall within the data range, but more frequently will fall before the data range)
        assertSearchResponse(response);
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        }
                    .order(BucketOrder.aggregation("max_constant", randomBoolean()))
                // expected
                    builders.add(indexDoc("idx2", date, j));
/*
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        assertThat(bucket.getDocCount(), equalTo(1L));
     * When DST ends, local time turns back one hour, so between 2am and 4am wall time we should have four buckets:
        );
@OpenSearchIntegTestCase.SuiteScopeTestCase
                dateHistogram("histo").field("dates")
        assertThat((double) propertiesCounts[0], equalTo(1.0));
    }
                .setRequestCache(true)
        assertThat(histogram.getName(), equalTo("histo"));
        bucketProps.put("_count", docCount);
import java.io.IOException;
            true,
        Histogram.Bucket bucket = buckets.get(0);
        int timeZoneHourOffset = randomIntBetween(-12, 12);
        }
            .get();
                .getRequestCache()
            client().admin()
                dateHistogram("histo").field("d")
        assertEquals(946771200000L, ((ZonedDateTime) buckets.get(1).getKey()).toEpochSecond() * 1000);
        assertThat(bucket, notNullValue());
        assertThat(histo.getName(), equalTo("histo"));
        } catch (Exception e) {
            Sum sum = bucket.getAggregations().get("sum_d");
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
}
            Arrays.asList(
                dateHistogram("histo").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        SearchResponse response = client().prepareSearch("idx")
            ((ZonedDateTime) buckets.get(1).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(0).getKey()).toInstant()
            ZonedDateTime expectedKey = keyIterator.next();
        int[] expectedDays = new int[] { 5, 6, 7, 3, 4, 2, 1 };
        assertThat(bucket, notNullValue());
            )
        assertThat(histo.getName(), equalTo("histo"));
        assertSearchResponse(response);
    }
            client().prepareIndex("cache_test_idx").setId("2").setSource("d", date2)
        SearchResponse response = client().prepareSearch("idx")
    }
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        }
            client().admin()
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        Map<String, Object> params = new HashMap<>();
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        IndexRequestBuilder[] reqs = new IndexRequestBuilder[5];
    }
        // it could be that the random bounds.min we chose ended up greater than
        assertThat(buckets.size(), equalTo(3));
        assertMultiSortResponse(expectedDays, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
    public void testEmptyAggregation() throws Exception {
        );
                    .interval(1L)
        key = ZonedDateTime.of(2012, 5, 1, 0, 0, 0, 0, ZoneOffset.UTC);
     * extended bounds (see https://github.com/elastic/elasticsearch/issues/23776)
            i++;
     * doc 2: [ Mar 2, Apr 3]
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(bucket.getKey(), equalTo(date(1, 1)));
            )
            .get();
                .indices()
        assertAcked(prepareCreate("nanos").setMapping("date", "type=date_nanos").get());
     * Ensure requests using nondeterministic scripts do not get cached.
                    .format("yyyy-MM")
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertEquals("2016-01-06T06:00:00.000Z", buckets.get(5).getKeyAsString());
                dateHistogram("histo").field("date")
                .getTotal()
    }
        r = client().prepareSearch("nanos")
                return;
import org.opensearch.search.aggregations.bucket.histogram.LongBounds;
                .prepareStats("cache_test_idx")
                dateHistogram("histo").field("date")
            .setQuery(matchAllQuery())
    }
import org.opensearch.action.index.IndexRequestBuilder;
        bucket = buckets.get(2);
                    .subAggregation(max("max_constant").field("constant"))
     * https://github.com/elastic/elasticsearch/issues/31760 shows an edge case where an unmapped "date" field in two indices
     * The error happens when the bucket from the "unmapped" index is received first in the reduce phase, however the case can
        createIndex("idx", "idx_unmapped");
    public void testRewriteTimeZone_EpochMillisFormat() throws InterruptedException, ExecutionException {
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        bucket = buckets.get(1);
     * Feb 2
            .addAggregation(
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) histo).getProperty("_key");
        assertEquals(0, buckets.get(1).getDocCount());
        SearchResponse response = client().prepareSearch("test9491")
        int i = 0;
        try {
        prepareCreate(index).setSettings(
     */
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndKeyAsc() throws Exception {
     */
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
     */
            i++;
        ZonedDateTime boundsMax = boundsMaxKey.plusDays(randomIntBetween(0, interval - 1));
            .setSize(0)
        assertThat(buckets.get(1).getKeyAsString(), equalTo("2012-02-03T00:00:00.000Z"));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        boolean asc = true;
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
        assertThat(bucket.getDocCount(), equalTo(3L));
            boundsMinKey = baseKey.minusDays(addedBucketsLeft * interval);
            }
    public void testSingleValuedFieldOrderedByTieBreaker() throws Exception {
        assertThat(buckets.size(), equalTo(4));
    public DateHistogramIT(Settings staticSettings) {
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                    .minDocCount(0)
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
    }
     * timeZones.
import org.opensearch.search.aggregations.metrics.Avg;
     * see issue #9634, negative dateHistogramInterval in date_histogram should raise exception
        assertThat(histo.getName(), equalTo("histo"));
        }
            .addAggregation(dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH))
import org.opensearch.search.aggregations.BucketOrder;
                dateHistogram("histo").field("date")
    /**
        );
        bucket = buckets.get(2);
        return (ZonedDateTime) bucket.getKey();
            )
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        response = client().prepareSearch(index)
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            equalTo(3600000L)
                .get()
        assertSearchResponse(response);
        int i = 0;
            .addAggregation(
        assertThat(bucket, notNullValue());
        assertSearchResponse(response);
        indexRandom(
                    throw e;
        List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(bucket, notNullValue());
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyDesc() throws Exception {
        SearchResponse response = client().prepareSearch(index)
            assertThat(bucket.getKey(), equalTo(date(i, 1)));
            )
        List<? extends Bucket> buckets = histo.getBuckets();
import java.util.Arrays;
            )
        return ZonedDateTime.of(2012, month, day, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(buckets.size(), equalTo(6));
            response.getHits().getTotalHits().value(),
        Histogram histo = response.getAggregations().get("histo");
                jsonBuilder().startObject()
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        ).get();
        assertThat(bucket, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        Histogram histo = response.getAggregations().get("histo");
                .getTotal()
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", true));
            true,
        assertThat(bucket.getDocCount(), equalTo(2L));
        bucket = buckets.get(1);
        bucket = buckets.get(3);
        long[] docCounts = new long[numOfBuckets];
                .get()
        }
            Settings.builder().put(indexSettings()).put("index.number_of_shards", 1).put("index.number_of_replicas", 0)
                .indices()
                    .hardBounds(new LongBounds("2012-02-01T00:00:00.000", "2012-03-03T00:00:00.000"))
            client().prepareIndex("sort_idx")
 * software distributed under the License is distributed on an
            boundsMinKey = baseKey.plusDays(addedBucketsLeft * interval);
        assertThat(bucket, notNullValue());
    }
        assertEquals(2, buckets.size());
    /**
        assertAcked(client().admin().indices().prepareCreate("test9491").setMapping("d", "type=date").get());
        Map<String, Object> params = new HashMap<>();
                    .extendedBounds(new LongBounds("2015-10-25T02:00:00.000+02:00", "2015-10-25T04:00:00.000+01:00"))
                    .startArray("dates")
        List<? extends Bucket> buckets = histo.getBuckets();
                .addAggregation(
                .getTotal()
        Iterator<ZonedDateTime> keyIterator = expectedKeys.iterator();
            fail("Expected an exception");
    }
            .get();
        assertSearchResponse(response);
     * "2015-10-25T04:00:00.000+01:00".
    static Map<ZonedDateTime, Map<String, Object>> expectedMultiSortBuckets;
        ensureSearchable("test8209");
        Histogram histo = response.getAggregations().get("date_histo");
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-03T08:00:00.000Z")), 1));
        for (int i = 0; i < reqs.length; i++) {
            Settings.builder().put(indexSettings()).put("index.number_of_shards", 1).put("index.number_of_replicas", 0)
        assertThat(histo.getName(), equalTo("histo"));
 *
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        );
                .getHitCount(),
        assertSearchResponse(response);
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2016-11-01"));
        bucket = buckets.get(1);
                    .subAggregation(max("sum").field("value"))
            .addAggregation(
        assertThat(buckets.get(1).getKeyAsString(), equalTo("2012-02-01T00:00:00.000-07:00"));
            equalTo(0L)
        assertThat(bucket, notNullValue());
                .setId("" + i)
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.key(false))
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        assertSearchResponse(response);
            )
        assertEquals(946684800000L, ((ZonedDateTime) buckets.get(0).getKey()).toEpochSecond() * 1000);
                dateHistogram("histo").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))
        assertSearchResponse(r);
        if (randomBoolean()) {
            .get();
    public void testMultiValuedFieldWithValueScript() throws Exception {
    }
                .get();
    }
        );
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            .field("type", "date")
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
                dateHistogram("histo").field("date")
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
import org.opensearch.common.settings.Settings;
        assertThat((double) propertiesCounts[2], equalTo(15.0));
        // we're testing on days, so the base must be rounded to a day
        } else {
import static org.hamcrest.Matchers.equalTo;
        ensureSearchable(index);
            );
     * Feb 15
        Histogram histogram = response.getAggregations().get("histo");
        // constructing the newly expected bucket list
                .getTotal()
        assertMultiSortResponse(
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(sum, notNullValue());
            client().prepareIndex("sort_idx")
        SearchResponse response = client().prepareSearch("idx")
                    .dateHistogramInterval(DateHistogramInterval.HOUR)
        SearchResponse response = client().prepareSearch("test8209")
        long intervalMillis = interval * 24 * 60 * 60 * 1000;
                .get();
            .get();
        List<IndexRequestBuilder> builders = new ArrayList<>();
        List<? extends Bucket> buckets = histo.getBuckets();
    }
        // Search interval 24 hours
        assertThat(bucket, notNullValue());
    [ Feb 2, Mar 3]
        String index = "test23776";
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .addAggregation(
        // (can sometimes fall within the data range, but more frequently will fall after the data range)
    public void testSingleValuedFieldOrderedByCountDesc() throws Exception {
        assertThat(dateHisto, Matchers.notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        bucket = buckets.get(2);
            client().admin()
        assertThat(dateHisto.getBuckets().isEmpty(), is(true));
        assertEquals(1, buckets.get(0).getDocCount());
        builders.add(
            .addAggregation(
        assertThat(bucket, Matchers.notNullValue());
        assertThat(
        assertThat(buckets.size(), equalTo(3));
        // randomizing the number of buckets on the max bound
            );
        assertThat(sum, notNullValue());
        List<? extends Bucket> buckets = histo.getBuckets();
        Histogram.Bucket bucket = buckets.get(0);
                    .minDocCount(1)
        );
            equalTo(0L)
        assertEquals(0, buckets.get(7).getDocCount());
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            .get();
    private IndexRequestBuilder indexDoc(String idx, ZonedDateTime date, int value) throws Exception {
                dateHistogram("histo").field("d")
            )
            .addAggregation(
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(bucket, notNullValue());
                .getHitCount(),
        );
                    .dateHistogramInterval(DateHistogramInterval.days(1))
        cluster().wipeIndices("nanos");
                return;
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 3)).field("l", 3).field("d", 1).endObject())
        assertThat(histo.getName(), equalTo("histo"));
    }
        bucket = buckets.get(1);
        assertThat(histo.getBuckets().size(), equalTo(0));
                    .minDocCount(0)
        ensureSearchable("idx2");
    public void setupSuiteScopeCluster() throws Exception {
            format = format + "||date_optional_time";
    }
        ZoneId timezone = ZoneOffset.ofHours(timeZoneHourOffset);
            assertThat(sum, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(3L));
            .get();
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
            equalTo(1L)
        for (int i = 0; i < numOfBuckets; i++) {
        Histogram histo = response.getAggregations().get("histo");
    [ Jan 2, Feb 3]
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        SearchResponse response = client().prepareSearch("idx")
        key = ZonedDateTime.of(2012, 3, 1, 23, 0, 0, 0, ZoneOffset.UTC);
import org.opensearch.script.ScriptType;
        assertThat(buckets.size(), equalTo(4));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        Histogram histo = response.getAggregations().get("histo");
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
        SearchResponse response = client().prepareSearch("idx")
        bucket = buckets.get(2);
            equalTo(0L)
        }
     * Test date histogram aggregation with day interval, offset and
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
    [ Mar 2, Apr 3]
                    .timeValue(date)
    private static String getBucketKeyAsString(ZonedDateTime key, ZoneId tz) {
        for (Histogram.Bucket bucket : buckets) {
        int millisDivider = format.equals("epoch_millis") ? 1 : 1000;
            client().prepareIndex("sort_idx")
            )
        sum = bucket.getAggregations().get("sum");
        );
        int addedBucketsLeft = randomIntBetween(0, numOfBuckets);
                    .calendarInterval(DateHistogramInterval.DAY)
                .indices()
                .get()
        for (Histogram.Bucket bucket : histo.getBuckets()) {
                dateHistogram("histo").field("date")
            if (rootCauses.length == 1) {
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            assertThat(bucketKey, equalTo(expectedBucketName));
            .addAggregation(dateHistogram("histo").field("dates").dateHistogramInterval(DateHistogramInterval.MONTH))
                )
        assertSearchResponse(response);
                dateHistogram("histo").field("d")
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                .setRequestCache(true)
            .get();
    }
     */
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket.getDocCount(), equalTo(1L));
                .indices()
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(
        int[] expectedDays = new int[] { 6, 7, 3, 4, 5, 1, 2 };
     * doc 6: [ Apr 23, May 24]
        assertThat(histo.getBuckets().size(), equalTo(3));
        ).get();
        Histogram dateHisto = bucket.getAggregations().get("date_histo");
            ((ZonedDateTime) buckets.get(3).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(2).getKey()).toInstant()
                    .timeZone(ZoneId.of("Europe/Oslo"))
                    .dateHistogramInterval(DateHistogramInterval.DAY)
            if (invalidBoundsError) {
        // retrieve those docs with the same time zone and extended bounds
        assertThat(histo, notNullValue());
            .addAggregation(
            .setQuery(matchAllQuery())
        assertThat(histo.getName(), equalTo("histo"));
                    .timeZone(ZoneId.of("+01:00"))
        assertThat(histo, notNullValue());
        buckets = histo.getBuckets();
        assertThat(bucket, notNullValue());
            i--;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        if (frequently()) {
     * Mar 15
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("1477954800000"));
        ensureSearchable("test9491");
                .prepareStats("cache_test_idx")
import org.opensearch.search.aggregations.AggregationExecutionException;
            equalTo(0L)
                .toEpochMilli(),
        IndexRequestBuilder[] reqs = new IndexRequestBuilder[5];
            .get();
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            client().prepareIndex("test8209").setSource("d", "2014-01-01T00:00:00Z"),
 * You may obtain a copy of the License at
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        SearchResponse response = client().prepareSearch("idx")
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo, notNullValue());
            String expectedBucketName = Long.toString(expectedKey.toInstant().toEpochMilli() / millisDivider);
import java.util.Collections;
        boolean invalidBoundsError = boundsMin.isAfter(boundsMax);
            true,
        assertThat(histo.getName(), equalTo("histo"));
    /**
     * doc 1: [ Feb 2, Mar 3]
        Histogram.Bucket bucket = buckets.get(0);
        SearchResponse response = null;
    private static String format(ZonedDateTime date, String pattern) {
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            .get();
    public void testDSTBoundaryIssue9491() throws InterruptedException, ExecutionException {
                .getRequestCache()
        assertSearchResponse(response);
                .indices()
        assertThat(histo.getBuckets().get(3).getKeyAsString(), equalTo("2014-04-01T00:00:00.000+02:00"));
            builders.add(
        return client().prepareIndex("idx")
        assertThat(histo, notNullValue());
        assertThat(((InternalAggregation) histo).getProperty("_bucket_count"), equalTo(3));
        for (int i = 0; i < 2; i++) {
                            dateHistogram("inner_histo").dateHistogramInterval(DateHistogramInterval.MONTH)
                    .order(BucketOrder.aggregation("sum", false))
    }
            )
        int boundsMaxKeyDelta = addedBucketsRight * interval;
        assertThat(response.getHits().getTotalHits().value(), equalTo(5L));
            assertThat(bucket, notNullValue());
                    .calendarInterval(DateHistogramInterval.HOUR)
    public void testIssue6965() {
                dateHistogram("histo").field("d").dateHistogramInterval(DateHistogramInterval.MONTH).timeZone(ZoneId.of("Europe/Berlin"))
                    .timeZone(ZoneId.of("Europe/Oslo"))
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
                    .timeValue(date.plusMonths(1).plusDays(1))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        addExpectedBucket(date(1, 6), 1, 5, 1);
        Histogram histo = response.getAggregations().get("histo");
            .addAggregation(
            }
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2018-01"));
                    .minDocCount(0)
        bucket = buckets.get(1);
            OpenSearchException[] rootCauses = e.guessRootCauses();
    private static String getBucketKeyAsString(ZonedDateTime key) {
        assertSearchResponse(response);
        assertThat(bucket, notNullValue());
                indexDoc(2, 2, 2),  // date: Feb 2, dates: Feb 2, Mar 3
        bucket = buckets.get(1);
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.key(true))
        assertThat(
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertThat(histo, notNullValue());
/*
            client().prepareIndex("cache_test_idx").setId("1").setSource("d", date),
        internalCluster().wipeIndices("test8209");
            .get();
        InternalDateHistogram histogram = response.getAggregations().get("histo");
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        ZonedDateTime boundsMin = boundsMinKey.plusDays(randomIntBetween(0, interval - 1));
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 4).plusHours(2)).field("l", 3).field("d", 3).endObject())
        assertThat(histo.getBuckets().size(), equalTo(1));
        String indexDateUnmapped = "test31760";
        for (Histogram.Bucket bucket : histo.getBuckets()) {
        for (int i = 0; i < buckets.size(); i++) {
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo, notNullValue());
                    .minDocCount(0)
    [ Feb 2, Mar 3]
 * not use this file except in compliance with the License.
     */
    public void afterEachTest() throws IOException {
        );
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            if (invalidBoundsError) {
        assertThat(histo, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(3L));
            .addAggregation(
        expectedKeys.add(ZonedDateTime.of(2012, 1, 1, 23, 0, 0, 0, ZoneOffset.UTC));
                    .timeValue(date(month, day))
            .get();
        Histogram histo = response.getAggregations().get("histo");
import org.opensearch.common.time.DateFormatters;
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(histo.getName(), equalTo("histo"));
        assertSearchResponse(response);
            .get();
        buckets = histogram.getBuckets();
            )
                .get()
        List<ZonedDateTime> expectedKeys = new ArrayList<>();
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            )
        assertThat(bucket.getDocCount(), equalTo(1L));
    }
                dateHistogram("histo").field("dates").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.count(false))
        histogram = r.getAggregations().get("histo");
            )
        SearchResponse response = client().prepareSearch(indexDateUnmapped)
        assertEquals(1, buckets.get(0).getDocCount());
        }
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                    .minDocCount(0)
        bucket = buckets.get(2);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
     */
        assertAcked(client().admin().indices().prepareCreate(index).setMapping("d", "type=date,format=epoch_millis").get());
                .getRequestCache()
    }
        assertThat(histo.getName(), equalTo("histo"));
            .get();
        assertThat(histo, notNullValue());
        assertThat(buckets.size(), equalTo(30));
    }
        assertThat(histo.getName(), equalTo("histo"));
        assertAcked(
        }
                dateHistogram("histo").field("date")
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        builders.add(indexDoc(index, timeZoneNoonToday, 2));
        builders.addAll(
                    .format("yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX")
                }
        Histogram histogram = r.getAggregations().get("histo");
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
        List<? extends Bucket> buckets = histo.getBuckets();
        params.put("fieldname", "date");
        SearchResponse response = client().prepareSearch("idx")
                indexDoc(3, 23, 6)  // date: Mar 23, dates: Mar 23, Apr 24
        assertThat(bucket, notNullValue());
            .get();
        assertThat(bucket, notNullValue());
            )
        assertThat(histo.getBuckets().size(), equalTo(3));
            .get();
        assertSearchResponse(response);
            );
        key = ZonedDateTime.of(2012, 2, 1, 23, 0, 0, 0, ZoneOffset.UTC);
                    .field("value", value)
        bucket = buckets.get(3);
            .addAggregation(
        ensureSearchable(index);
        SearchResponse response = client().prepareSearch("sort_idx")
    private ZonedDateTime key(Histogram.Bucket bucket) {
        List<? extends Bucket> buckets = histo.getBuckets();
                    .timeZone(tz)
            boundsMaxKeyDelta = -boundsMaxKeyDelta;
        expectedKeys.add(ZonedDateTime.of(2012, 2, 1, 23, 0, 0, 0, ZoneOffset.UTC));
            ((ZonedDateTime) buckets.get(2).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(1).getKey()).toInstant()
        ZonedDateTime boundsMinKey;
        assertThat(histo.getBuckets().size(), equalTo(1));
        assertThat(histo, notNullValue());
import java.time.ZoneOffset;
        assertEquals(0, buckets.get(3).getDocCount());
            equalTo(0L)
    /**
import org.opensearch.search.aggregations.metrics.Sum;
            ((ZonedDateTime) buckets.get(3).getKey()).toInstant().toEpochMilli() - ((ZonedDateTime) buckets.get(2).getKey()).toInstant()
        addExpectedBucket(date(1, 5), 2, 5, 3);
        assertThat(
        // randomizing the number of buckets on the min bound
                for (int j = 0; j < docCount; j++) {
        Histogram.Bucket bucket = buckets.get(0);
            .addDocValueField("date")
        assertThat(histo.getName(), equalTo("histo"));
                    .order(BucketOrder.compound(order))
        assertSearchResponse(response);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        builders.add(
            )
        // trigger an error
    }
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.LONG_PLUS_ONE_MONTH, params))
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
 */
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    .timeZone(ZoneId.of("America/Edmonton"))
        return client().prepareIndex(idx)
        List<? extends Bucket> buckets = histo.getBuckets();
        addExpectedBucket(date(1, 4), 2, 3, 4);
    [ Feb 15, Mar 16]
        for (int i = 0; i < reqs.length; i++) {
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
                .getTotal()
                )
        String index = "test31392";
                .toEpochMilli(),
        return Arrays.asList(
                .getHitCount(),
        ZonedDateTime boundsMaxKey = lastDataBucketKey.plusDays(boundsMaxKeyDelta);
                fail("Expected an exception to be thrown when bounds.min is greater than bounds.max");
        String index = "test12278";
        Histogram.Bucket bucket = buckets.get(0);
        assertThat(bucket.getDocCount(), equalTo(1L));
            .addAggregation(dateHistogram("date_histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY))
            .addAggregation(
        // Test that a request using a deterministic script gets cached
        bucket = buckets.get(1);
        );
            .setQuery(
        assertThat(bucket, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        List<InternalDateHistogram.Bucket> buckets = histogram.getBuckets();
        assertThat(histo, notNullValue());
        assertThat(histo, Matchers.notNullValue());
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
                histogram("histo").field("value")
            .setSize(0)
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                QueryBuilders.rangeQuery("date").from("now/d").to("now/d").includeLower(true).includeUpper(true).timeZone(timezone.getId())
            }
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
            )
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.LONG_PLUS_ONE_MONTH, params))
        int i = 2;
        Histogram histo = response.getAggregations().get("histo");
        ZonedDateTime key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                    assertThat(aggException.getMessage(), Matchers.startsWith("Invalid aggregation order path"));
            client().prepareSearch("idx")
            .get();
        Histogram.Bucket bucket = buckets.get(0);
        List<? extends Histogram.Bucket> buckets = histo.getBuckets();
        ZonedDateTime key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(bucket, notNullValue());
            .get();
        assertThat(histo.getName(), equalTo("histo"));
                    .dateHistogramInterval(DateHistogramInterval.DAY)
            key = key.plusDays(interval);
        histo = response.getAggregations().get("histo");
        assertThat(buckets.size(), equalTo(4));
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        builders.add(indexDoc(index, DateFormatters.from(formatter.parse("2016-01-03T08:00:00.000Z")), 2));
        bucket = buckets.get(1);
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
                dateHistogram("histo").field("date")
        assertSearchResponse(r);
            .get();
import java.time.ZonedDateTime;
        String pattern = "yyyy-MM-dd";
        );
     * that are queried simultaneously can lead to the "format" parameter in the aggregation not being preserved correctly.
        String date2 = DateFieldMapper.getDefaultDateTimeFormatter().format(date(2, 1));
    }
        indexRandom(true, builders);
            assertThat("InternalBucket " + i + " had wrong key", (ZonedDateTime) bucket.getKey(), equalTo(zonedDateTime));
        List<? extends Bucket> buckets = histo.getBuckets();
                .prepareStats("cache_test_idx")
    [ Mar 15, Apr 16]
        Histogram histo = searchResponse.getAggregations().get("histo");
    }
                dateHistogram("histo").field("date")
 * this file be licensed under the Apache-2.0 license or a
    /**
        assertThat(dateHisto.getName(), equalTo("date_histo"));
                    .field("constant", 1)
    }
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(expectedKey));
        assertSearchResponse(r);
                    .setSource(jsonBuilder().startObject().timeField("date", date(1, 1)).field("l", 1).field("d", i).endObject())
        assertThat(bucket, notNullValue());
                    .extendedBounds(new LongBounds("2015-10-25T02:00:00.000+02:00", "2015-10-25T04:00:00.000+01:00"))
        assertThat(histo.getName(), equalTo("histo"));
        ).get();
            assertThat(bucket, notNullValue());
                    .setId("" + i)
    @Override
            }
            .endObject()
        ZonedDateTime key = ZonedDateTime.of(2014, 3, 10, 0, 0, 0, 0, ZoneOffset.UTC);
        bucket = buckets.get(4);
            client().prepareIndex("test9491").setSource("d", "2014-11-08T13:00:00Z")
                    .format("yyyy-MM-dd")
        assertEquals("2016-01-08T06:00:00.000Z", buckets.get(7).getKeyAsString());
        assertSearchResponse(response);
            .setSize(0)
            )
        List<? extends Bucket> buckets = histo.getBuckets();
            } else {
        bucket = buckets.get(3);
        assertThat(bucket, notNullValue());
        assertThat((long) propertiesDocCounts[1], equalTo(2L));
                        )
        }
        assertThat(bucket.getDocCount(), equalTo(1L));
import java.util.concurrent.TimeUnit;
                .getMissCount(),
     * doc 4: [ Apr 2, May 3]
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
                indexDoc(2, 15, 3), // date: Feb 15, dates: Feb 15, Mar 16
            if (i == 0 || i == 12) {
        assertThat(bucket, notNullValue());
import java.util.List;
        assertThat(buckets.size(), equalTo(3));
    [ Mar 23, Apr 24]
        assertThat(bucket.getDocCount(), equalTo(3L));
                .prepareStats("cache_test_idx")
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
                .indices()
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        }
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(bucket.getDocCount(), equalTo(2L));
                .getRequestCache()
        Map<String, Object> bucketProps = new HashMap<>();
                .toEpochMilli(),
        List<? extends Bucket> buckets = histo.getBuckets();
    public void testSingleValuedFieldWithTimeZone() throws Exception {
            fail();
        System.arraycopy(docCounts, 0, extendedValueCounts, addedBucketsLeft, docCounts.length);
        key = ZonedDateTime.of(2012, 3, 14, 23, 0, 0, 0, ZoneOffset.UTC);
        bucket = buckets.get(2);
        assertThat(bucket.getDocCount(), equalTo(3L));
        ZonedDateTime baseKey = Instant.ofEpochMilli(intervalMillis * (base.toInstant().toEpochMilli() / intervalMillis))
            .addAggregation(
        assertThat(
        assertSearchResponse(response);
            );
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket.getDocCount(), equalTo(1L));
import java.util.Iterator;
                    .dateHistogramInterval(DateHistogramInterval.YEAR)
            .execute()
                .get()
        int addedBucketsRight = randomIntBetween(0, numOfBuckets);
        r = client().prepareSearch("cache_test_idx")
    public static Collection<Object[]> parameters() {
        assertThat(buckets.size(), equalTo(3));
        assertThat(histo, notNullValue());
        ZonedDateTime key = baseKey.isBefore(boundsMinKey) ? baseKey : boundsMinKey;
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.LONG_PLUS_ONE_MONTH, params))
    @Override
        params.put("fieldname", "date");
            .addAggregation(
        int bucketsCount = numOfBuckets + addedBucketsLeft + addedBucketsRight;
        assertSearchResponse(response);
        assertSearchResponse(response);
import static org.hamcrest.core.IsNull.notNullValue;
    /**
    @ParametersFactory
     */
        SearchResponse r = client().prepareSearch("cache_test_idx")
                dateHistogram("histo").field("date")
        SearchResponse response = client().prepareSearch("idx")
        histo = response.getAggregations().get("histo");
        assertThat(bucket.getDocCount(), equalTo(3L));
        expectedMultiSortBuckets.put(key, bucketProps);
        assertThat(histo.getName(), equalTo("histo"));
        ensureSearchable(indexDateUnmapped);
        bucket = buckets.get(2);
    }
        internalCluster().wipeIndices(index);
            .addAggregation(
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        }
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
    public void testFormatIndexUnmapped() throws InterruptedException, ExecutionException {
        );
        bucket = buckets.get(1);
        SearchResponse r = client().prepareSearch("nanos")
    [ Mar 2, Apr 3]
     * "2015-10-25T02:00:00.000+02:00",
                    .subAggregation(stats("stats").field("value"))
     * "2015-10-25T02:00:00.000+01:00",
        ZonedDateTime base = ZonedDateTime.now(ZoneOffset.UTC).withDayOfMonth(1);
    }
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
        int interval = randomIntBetween(1, 2); // in days
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
    }
            } else {
                .getRequestCache()
    /**
            } else {
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertThat(histo.getBuckets().size(), equalTo(4));
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
        assertMultiSortResponse(expectedDays, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
        Histogram histo = response.getAggregations().get("histo");
                dateHistogram("histo").field("date")
        }
                    .timeZone(ZoneId.of("Asia/Jerusalem"))
            .setSource(
        r = client().prepareSearch("cache_test_idx")
        ZonedDateTime lastDataBucketKey = baseKey.plusDays((numOfBuckets - 1) * interval);
        Histogram histo = response.getAggregations().get("histo");
        assertSearchResponse(r);
    public void testMultiValuedField() throws Exception {
        assertThat(
        SearchResponse response = client().prepareSearch("idx")
        ZonedDateTime timeZoneStartToday = parser.parse("now/d", System::currentTimeMillis, false, timezone).atZone(ZoneOffset.UTC);
/*
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
            .addAggregation(
        assertEquals(2, buckets.get(2).getDocCount());
                dateHistogram("histo").field("d")
 */
        key = ZonedDateTime.of(2012, 1, 31, 23, 0, 0, 0, ZoneOffset.UTC);
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        int[] expectedDays = new int[] { 6, 7, 3, 5, 4, 1, 2 };
    }
                .get()
    }
        ZonedDateTime key = ZonedDateTime.of(2011, 12, 31, 23, 0, 0, 0, ZoneOffset.UTC);
        indexRandom(true, builders);
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(1L));
        assertThat((long) propertiesDocCounts[2], equalTo(3L));
        assertSearchResponse(response);
    public void testSingleValued_timeZone_epoch() throws Exception {
        Histogram.Bucket bucket = buckets.get(1);
            date = date.plusHours(1);
        int i = 2;
        assertThat(
            equalTo(3600000L)
            .get();
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        assertThat(sum, notNullValue());
                .setRequestCache(true)
import org.opensearch.index.query.QueryBuilders;
                .prepareStats("cache_test_idx")
        assertThat(histo.getBuckets().size(), equalTo(3));
        ensureSearchable();
                OpenSearchException rootCause = rootCauses[0];
        assertThat(histo.getName(), equalTo("histo"));
            .addAggregation(dateHistogram("histo").field("date").interval(1000 * 60 * 60 * 24).timeZone(ZoneId.of("UTC")))
    public void testMultiValuedFieldOrderedByCountDesc() throws Exception {
import java.time.ZoneId;
        assertThat(buckets.size(), equalTo(24));
        assertThat(histo, notNullValue());
    public void testSingleValueFieldWithExtendedBoundsOffset() throws Exception {
            i--;
        builders.add(
        Histogram histo = response.getAggregations().get("histo");
            .addAggregation(
        List<? extends Bucket> buckets = histo.getBuckets();
        key = ZonedDateTime.of(2012, 2, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        Histogram histo = response.getAggregations().get("histo");
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 5).plusHours(12)).field("l", 5).field("d", 2).endObject())
            assertThat(e.toString(), containsString("[interval] must be 1 or greater for aggregation [date_histogram]"));
        Histogram.Bucket bucket = buckets.get(0);
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        builders.add(
    }
                client().prepareIndex("sort_idx")
                .setSource(jsonBuilder().startObject().field("date", "10-03-2014").endObject());
                client().prepareIndex("empty_bucket_idx")
        return DateFormatter.forPattern("strict_date_optional_time").withZone(tz).format(key);
        List<? extends Bucket> buckets = histo.getBuckets();
        bucketProps.put("sum_d", sum);
            )
        SearchResponse response = client().prepareSearch("idx")
                .get()
        indexRandom(true, client().prepareIndex(index).setSource("d", "1477954800000"));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        assertEquals(1, buckets.get(1).getDocCount());
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
    public void testSingleValuedFieldWithValueScript() throws Exception {
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        int i = 1;
                .indices()
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        List<? extends Bucket> buckets = histogram.getBuckets();
        assertThat(histo.getBuckets().size(), equalTo(3));
        assertThat(
            Histogram.Bucket bucket = buckets.get(i);
        );
        addExpectedBucket(date(1, 1), 3, 1, 6);
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        indexRandom(
        indexRandom(true, builders);
        assertThat(bucket, notNullValue());
            assertThat(bucket.getKeyAsString(), equalTo(format(key, pattern)));
        assertThat(bucket.getDocCount(), equalTo(1L));
            .get();
    }
                        .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(0L));
     * See https://github.com/elastic/elasticsearch/issues/39107. Make sure we handle properly different
                    .timeField("date", date)
        assertThat(bucket.getDocCount(), equalTo(1L));
            builders.add(
    public void testPartiallyUnmapped() throws Exception {
                .addAggregation(
        assertThat(bucket.getDocCount(), equalTo(3L));
     * with daylight savings time is used. This test was added to check this is working now
        assertThat(histo.getBuckets().get(0).getDocCount(), equalTo(1L));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertAcked(prepareCreate("empty_bucket_idx").setMapping("value", "type=integer"));
        try {
            .addAggregation(dateHistogram("histo").field("d").dateHistogramInterval(DateHistogramInterval.MONTH))
import java.util.concurrent.ExecutionException;
        ZoneId tz = ZoneId.of("+01:00");
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndKeyAsc() throws Exception {
            .get();
            .addAggregation(
        );
            equalTo(2L)
        assertThat(histo, notNullValue());
        assertThat(bucket, notNullValue());
            BucketOrder.aggregation("sum_d", false),
            .addAggregation(
     * "2015-10-25T03:00:00.000+01:00",
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.MONTH).order(BucketOrder.count(false))
public class DateHistogramIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
                                .subAggregation(avg("avg").field("value"))
            assertThat(avg, notNullValue());
        prepareCreate("idx2").setMapping("date", "type=date").get();
            .setQuery(matchAllQuery())
        List<? extends Bucket> buckets = histo.getBuckets();
import org.opensearch.common.time.DateMathParser;
        assertThat(buckets.size(), equalTo(3));
        );
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
     * doc 3: [ Mar 15, Apr 16]
                throw e;
        prepareCreate(index).setSettings(
        assertThat(buckets.get(29).getKeyAsString(), equalTo("2012-03-02T00:00:00.000Z"));
    }
    }
        Histogram.Bucket bucket = buckets.get(0);
                docCounts[i] = docCount;
        assertThat(buckets.get(2).getKeyAsString(), equalTo("2012-03-01T00:00:00.000-07:00"));
                client().prepareIndex("sort_idx")
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key)));
        String format = randomBoolean() ? "epoch_millis" : "epoch_second";
        assertThat(bucket.getDocCount(), equalTo(3L));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                dateHistogram("histo").field("date")
        }
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        params.put("fieldname", "d");
        SearchResponse response = client().prepareSearch("idx2")
        SearchResponse response = client().prepareSearch("idx")
                dateHistogram("histo").field("date")
import org.opensearch.search.aggregations.InternalAggregation;
        expectedKeys.add(ZonedDateTime.of(2012, 3, 22, 23, 0, 0, 0, ZoneOffset.UTC));
            client().admin()
        assertAcked(client().admin().indices().prepareCreate("sort_idx").setMapping("date", "type=date").get());
        ZonedDateTime key = ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
            .get();
                .setRequestCache(true)
        bucket = buckets.get(5);
            .actionGet();
     */
     */
            )
        bucket = buckets.get(2);
        assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(histo, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
                    .timeValue(date(month + 1, day + 1))
        bucket = buckets.get(1);
            .addAggregation(
        key = ZonedDateTime.of(2012, 3, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        indexRandom(true, client().prepareIndex(indexDateUnmapped).setSource("foo", "bar"));
        assertThat(bucket.getDocCount(), equalTo(2L));
    }
            .addAggregation(
                .toEpochMilli(),
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(bucket.getDocCount(), equalTo(5L));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
     * Mar 23
            .startObject("properties")
        int emptyBucketIndex = randomIntBetween(1, numOfBuckets - 2); // should be in the middle
        Histogram histo = response.getAggregations().get("histo");
        }
    [ Mar 15, Apr 16]
        sum = bucket.getAggregations().get("sum");
            .addAggregation(
            assertThat(((ZonedDateTime) bucket.getKey()), equalTo(ZonedDateTime.of(2012, i + 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)));
                .getTotal()
            client().prepareIndex("sort_idx")
                }
        addExpectedBucket(date(1, 3), 2, 3, 3);
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(bucket.getDocCount(), equalTo(extendedValueCounts[i]));
            .get();
        bucket = buckets.get(3);
        assertThat(bucket.getKeyAsString(), equalTo("1.0"));
        builders.add(
        // we pick a random timezone offset of +12/-12 hours and insert two documents
        assertSearchResponse(response);
        bucket = buckets.get(2);
        assertThat((ZonedDateTime) propertiesKeys[0], equalTo(key));
                .getTotal()
            BucketOrder.count(false),
    }
                dateHistogram("histo").field("dateField")
    }
    @After
                assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
        assertEquals("2016-01-01T06:00:00.000Z", buckets.get(0).getKeyAsString());
                    .timeZone(ZoneId.of("+01:00"))
        return DateFormatters.from(DateFieldMapper.getDefaultDateTimeFormatter().parse(date));
            .addAggregation(
        internalCluster().wipeIndices(indexDateUnmapped);
            Settings.builder().put(indexSettings()).put("index.number_of_shards", 1).put("index.number_of_replicas", 0)
        indexRandom(true, client().prepareIndex("nanos").setId("1").setSource("date", "2000-01-01"));
                .setRequestCache(true)
        prepareCreate("idx2").setMapping(mappingJson).get();
    public void testHardBoundsOnDates() {
    }
        assertThat(histo, notNullValue());
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2014-01-01T00:00:00.000+01:00"));
    */
        List<? extends Bucket> buckets = histo.getBuckets();
        Histogram.Bucket bucket = buckets.get(0);
        List<IndexRequestBuilder> builders = new ArrayList<>();
            .get();
            .get();
                    .dateHistogramInterval(DateHistogramInterval.DAY)
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        key = ZonedDateTime.of(2012, 4, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    private ZonedDateTime date(int month, int day) {
        List<IndexRequestBuilder> builders = new ArrayList<>();
        // TODO: would be nice to have more random data here
            equalTo(3600000L)
    public void testSingleValueFieldWithExtendedBoundsTimezone() throws Exception {
                        .format(pattern)
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        key = ZonedDateTime.of(2012, 2, 14, 23, 0, 0, 0, ZoneOffset.UTC);
        indexRandom(
                    .format("yyyy-MM-dd:HH-mm-ssZZZZZ")
        int i = 2;
        InternalDateHistogram histogram = response.getAggregations().get("histo");
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertThat(histo.getName(), equalTo("histo"));
     * "format" = "epoch_millis" can lead for the date histogram aggregation to throw an error if a non-UTC time zone
            )
        assertThat(bucket, notNullValue());
        key = ZonedDateTime.of(2012, 2, 29, 23, 0, 0, 0, ZoneOffset.UTC);
                    .offset("+6h")
                indexDoc(1, 2, 1),  // date: Jan 2, dates: Jan 2, Feb 3
import org.opensearch.script.Script;
    public void testExceptionOnNegativeInterval() {
            )
    private void addExpectedBucket(ZonedDateTime key, long docCount, double avg, double sum) {
                    .endArray()
        assertSearchResponse(response);
        assertThat(bucket, notNullValue());
        Map<String, Object> params = new HashMap<>();
        assertThat(histo, notNullValue());
package org.opensearch.search.aggregations.bucket;
            .get();
        cluster().wipeIndices("cache_test_idx");
        for (int i = 0; i < bucketsCount; i++) {
        int[] expectedDays = new int[] { 1, 2, 3, 4, 5, 6, 7 };
            .get();
    private ZonedDateTime date(String date) {
        params.put("fieldname", "dates");
        assertThat(histo, notNullValue());
    public void testDSTEndTransition() throws Exception {
        expectedKeys.add(ZonedDateTime.of(2012, 3, 1, 23, 0, 0, 0, ZoneOffset.UTC));
    }
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
        indexRandom(true, reqs);
            BucketOrder.aggregation("avg_l", false)
     * Jan 2
        indexRandom(true, builders);
                int docCount = randomIntBetween(1, 3);
                dateHistogram("histo").field("date")
        int[] expectedDays = new int[] { 1, 2, 4, 3, 7, 6, 5 };
            )
    }
                .prepareStats("cache_test_idx")
            .addAggregation(
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        expectedMultiSortBuckets = new HashMap<>();
    [ Feb 15, Mar 16]
                    .timeZone(ZoneId.of("-02:00"))
                    .setSource(jsonBuilder().startObject().timeField("date", date(1, 2)).field("l", 2).field("d", i).endObject())
        );
            client().prepareIndex("test9491").setSource("d", "2014-10-08T13:00:00Z"),
import org.hamcrest.Matchers;
            builders.add(
            i--;
import org.opensearch.index.mapper.DateFieldMapper;
        getMultiSortDocs(builders);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
            .addAggregation(
    }
        assertThat(histo.getBuckets().get(0).getKeyAsString(), equalTo("2014-01-01T00:00:00.000+02:00"));
    }
        assertThat(bucket, notNullValue());
            .get();
     * Test date histogram aggregation with hour interval, timezone shift and
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            )
            assertThat(bucket, notNullValue());
        assertThat(histo.getBuckets().size(), equalTo(3));
                    .field("value", value)
        for (Histogram.Bucket bucket : histo.getBuckets()) {
import java.time.Instant;
    }
        assertThat(buckets.size(), equalTo(bucketsCount));
        assertThat(((ZonedDateTime) bucket.getKey()), equalTo(key));
        assertThat(bucket, notNullValue());
        assertThat(bucket.getKeyAsString(), equalTo(getBucketKeyAsString(key, tz)));
