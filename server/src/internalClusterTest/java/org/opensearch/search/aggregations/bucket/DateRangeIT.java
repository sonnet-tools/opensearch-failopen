        List<? extends Bucket> buckets = range.getBuckets();
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        bucket = buckets.get(2);
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
                dateRange("range").field("dates")
    }
        assertThat(bucket, notNullValue());
                dateRange("range").field("date")  
        SearchResponse response = client().prepareSearch("idx_unmapped")
        internalCluster().wipeIndices(indexName);  
        Range.Bucket bucket = buckets.get(0);  
     */
    @Override  
        assertThat(bucket.getKeyAsString(), equalTo("recently"));
        assertThat(bucket.getToAsString(), nullValue());  
                .setRequestCache(true)
        assertThat((String) bucket.getKey(), equalTo("r1"));
        SearchResponse searchResponse = client().prepareSearch(indexName)
            .get();
            .setSize(0)
            .get();
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        Range.Bucket bucket = buckets.get(0);
                    .addUnboundedTo("2012-02-15")
        assertThat(range, notNullValue());  
                .indices()
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
                    .addRange("recently", "now-50y", "now-1y")
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        assertThat(range.getName(), equalTo("range"));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
                .prepareStats("cache_test_idx")
        assertThat(((ZonedDateTime) bucket.getTo()).toInstant().toEpochMilli(), equalTo(expectedTo));
        ensureSearchable();
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15"));
                    .addUnboundedTo("r1", date(2, 15))
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
 * not use this file except in compliance with the License.
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        assertThat(bucket, notNullValue());  
    }
            )
import org.opensearch.search.aggregations.metrics.Sum;  
import org.opensearch.action.search.SearchResponse;
    /*
                .getMissCount(),  
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat((double) propertiesCounts[0], equalTo((double) 1 + 2));
    /*  
    private static ZonedDateTime date(int month, int day) {
            equalTo(1L)
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            client().admin()
                    .addUnboundedFrom("r3", date(3, 15))  
        assertThat(range.getName(), equalTo("range"));
        assertBucket(buckets.get(1), 1L, "3000-4000", 3000000L, 4000000L);
        Range.Bucket bucket = buckets.get(0);
        bucket = buckets.get(2);  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                dateRange("foo").field("date")
    private static List<Range.Bucket> checkBuckets(Range dateRange, String expectedAggName, long expectedBucketsSize) {
        assertThat((String) bucket.getKey(), equalTo("2012-02-15-2012-03-15"));
        );  
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
        internalCluster().wipeIndices(indexName);
        params.put("fieldname", "date");
                    .subAggregation(sum("sum").field("value"))
        DateRangeAggregationBuilder rangeBuilder = dateRange("range");
        Apr 15, May 16      5
        assertThat(
            client().prepareIndex(indexName).setId("3").setSource(jsonBuilder().startObject().field("date", "00:50:00").endObject())
                    .addUnboundedFrom("2012-03-15")  
        assertThat(bucket.getToAsString(), nullValue());  
        assertThat((String) bucket.getKey(), equalTo(expectedKey));
        bucket = buckets.get(1);  
                .prepareStats("cache_test_idx")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
                dateRange("range").field("dates")
                    )  
            .setSize(0)
        Range.Bucket bucket = buckets.get(0);  
 * SPDX-License-Identifier: Apache-2.0
        assertThat((String) bucket.getKey(), equalTo("r3"));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(bucket.getDocCount(), equalTo(2L));
     * Make sure that a request using a deterministic script or not using a script get cached.
            () -> client().prepareSearch(indexName)  
 * software distributed under the License is distributed on an
                .prepareStats("cache_test_idx")
        assertThat((String) propertiesKeys[2], equalTo("r3"));
                    .subAggregation(dateRange("date_range").field("value").addRange("0-1", 0, 1))
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        Range range = response.getAggregations().get("range");
        // using different format should work when to/from is compatible with
        Apr 2,  May 3,      4
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
 * license agreements. See the NOTICE file distributed with
        assertThat(histo, Matchers.notNullValue());
        } catch (SearchPhaseExecutionException spee) {  
     * Test querying ranges on date mapping specifying a format with to/from
        assertThat(bucket, notNullValue());
            )
                .indices()  
        assertThat(bucket.getDocCount(), equalTo((long) numDocs));  
        assertThat(
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
            client().prepareIndex(indexName).setId("3").setSource(jsonBuilder().startObject().field("date", 3008).endObject())
        assertThat(dateRange.getName(), equalTo(expectedAggName));  
                .get()  
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat((double) propertiesCounts[1], equalTo((double) 3 + 4));
        SearchResponse response = client().prepareSearch("idx")  
                    .addRange("2012-02-15", "2012-03-15")
        long expectedFirstBucketCount = timeZoneOffset < 0 ? 3L : 2L;  
                dateRange("range").field("date")
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
            .addAggregation(
                    .timeField("date", date(month, day))
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket, notNullValue());
        assertThat(buckets.size(), equalTo(3));
        assertBucket(buckets.get(0), 2L, "00.16.40-00.50.00", 1000000L, 3000000L);
 * compatible open source license.
            .addAggregation(
    public void testUnmappedWithStringDates() throws Exception {
        params.put("fieldname", "dates");  
    public void testNoRangesInQuery() {
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(  
        );  
        assertBucket(buckets.get(1), 1L, "3000000-4000000", 3000000L, 4000000L);  
        List<? extends Bucket> buckets = range.getBuckets();
        searchResponse = client().prepareSearch(indexName)  
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
                        ZonedDateTime.of(2013, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
        Feb 15, Mar 16,     3
    /**  
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        Range dateRange = bucket.getAggregations().get("date_range");
        assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx_unmapped")
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));  
            )  
            client().prepareIndex(indexName).setId("1").setSource(jsonBuilder().startObject().field("date", 1002).endObject()),  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));  
        SearchResponse response = client().prepareSearch("idx")  
            .setSize(0)
            .get();
import static org.hamcrest.Matchers.instanceOf;
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
            .addAggregation(
        assertThat(range.getName(), equalTo("range"));
                dateRange("date_range").field("date").addRange("00.16.40", "00.50.00").addRange("00.50.00", "01.06.40").format("HH.mm.ss")
    }
        assertThat(bucket.getDocCount(), equalTo(2L));
        bucket = buckets.get(2);
        assertThat(bucket.getDocCount(), equalTo(0L));
    }
        // format in aggregation
 */
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        assertThat(dateRange.getName(), equalTo("date_range"));
        Mar 15,     5  
            )
        Map<String, Object> params = new HashMap<>();
            .get();
}
                indexDoc(1, 2, 1),  // Jan 2
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
        assertThat((long) propertiesDocCounts[0], equalTo(2L));  
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
            .addAggregation(
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000" + mar15Suffix + "-*"));
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertThat(range, notNullValue());  
                .setRequestCache(true)  
    /**  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        bucket = buckets.get(2);  
                .getMissCount(),  
        searchResponse = client().prepareSearch(indexName)  
                .getRequestCache()  
 * Unless required by applicable law or agreed to in writing,
                .setId("2")
    }
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));  
                    .addUnboundedTo(date(2, 15))
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
/*
        assertThat(bucket.getToAsString(), nullValue());  
                indexDoc(2, 2, 2),  // Feb 2
        String indexName = "dateformat_test_idx";
            rangeBuilder.script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params));
        assertThat(bucket, notNullValue());  
        createIndex("idx");
            client().admin()
            .addAggregation(dateRange("date_range").field("date").addRange("00:16:40", "00:50:00").addRange("00:50:00", "01:06:40"))  
 */  
            )
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
        Mar 2,      4
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        assertThat(range.getName(), equalTo("range"));
        Map<String, Object> params = new HashMap<>();
                .getHitCount(),
                    .addUnboundedFrom("2012-03-15")
            .get();
            true,
        Mar 2,  Apr 3,      4
        List<? extends Bucket> buckets = range.getBuckets();
    }
                    .addRange(  
        assertThat(buckets.size(), equalTo(3));  
        assertSearchResponse(response);
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        List<? extends Bucket> buckets = range.getBuckets();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        // dummy docs
        SearchResponse response = client().prepareSearch("idx")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
                    .addRange(date(2, 15), date(3, 15))
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
        assertSearchResponse(response);
            true,
     * values specified as Strings
                    .setId("" + i)  
                indexDoc(3, 15, 5), // Mar 15
        assertThat(range, notNullValue());  
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        assertThat(bucket.getDocCount(), equalTo(1L));
                        ZonedDateTime.of(2013, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
        assertThat(bucket, notNullValue());  
        assertBucket(buckets.get(0), 2L, "1000000-3000000", 1000000L, 3000000L);
                .indices()  
                dateRange("range").field("date")  
                    .addUnboundedTo(date(2, 15))  
    }  
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
                .getTotal()
                    .addRange(date(2, 15), date(3, 15))
    public void testRangeWithFormatNumericValue() throws Exception {
                .prepareStats("cache_test_idx")
        List<? extends Bucket> buckets = range.getBuckets();  
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
                jsonBuilder().startObject()  
                dateRange("range").field("date")
        assertThat(bucket.getToAsString(), nullValue());  
        searchResponse = client().prepareSearch(indexName)
                .getMissCount(),
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getToAsString(), nullValue());
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")  
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
            .addAggregation(  
        indexRandom(true, docs);
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        assertThat(range.getName(), equalTo("range"));
                        ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
 *    http://www.apache.org/licenses/LICENSE-2.0
            docs.add(
        super(staticSettings);
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        bucket = buckets.get(1);  
        assertThat(buckets.size(), equalTo(3));  
        // Test that a request using a deterministic script gets cached  
    private static void assertBucket(Bucket bucket, long bucketSize, String expectedKey, long expectedFrom, long expectedTo) {  
        assertBucket(buckets.get(1), 1L, "3000000-4000000", 3000000L, 4000000L);
            equalTo(0L)  
            .setSize(0)  
        // using different format should work when to/from is compatible with  
                dateRange("date_range").field("date").addRange("00.16.40", "00.50.00").addRange("00.50.00", "01.06.40").format("HH.mm.ss")  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
                    .addUnboundedTo("2012-02-15")
        assertThat(bucket.getToAsString(), nullValue());
    }
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(range, notNullValue());
        Mar 23, Apr 24      6
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertThat(buckets.size(), equalTo(3));
                    .timeZone(timezone)
        Mar 23,     6
        assertThat(range.getName(), equalTo("range"));
        assertAcked(prepareCreate(indexName).setMapping("date", "type=date,format=epoch_second"));  
        assertThat((String) bucket.getKey(), equalTo("r1"));
        assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));
import org.opensearch.plugins.Plugin;
            Throwable rootCause = spee.getCause().getCause();
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
                    .addUnboundedTo(date(2, 15))  
     */  
        Feb 2,  Mar 3,      2
                    .startArray("dates")  
        // also e-notation should work, fractional parts should be truncated
                .getRequestCache()
        assertThat(range, notNullValue());  
import java.time.ZonedDateTime;
        assertThat(  
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        searchResponse = client().prepareSearch(indexName)
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000" + mar15Suffix));
 *
        params.put("fieldname", "date");  
        r = client().prepareSearch("cache_test_idx")
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
                .setSize(0)
                .get()
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
        Histogram histo = searchResponse.getAggregations().get("histo");  
        assertThat(bucket.getToAsString(), nullValue());
    }
        assertThat(buckets.size(), equalTo(3));  
                .setId("1")
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        bucket = buckets.get(2);  
                .getTotal()
        );  
                dateRange("date_range").field("date").addRange(1000000, 3000000).addRange(3000000, 4000000).format("epoch_millis")
                    .addUnboundedFrom("r3", date(3, 15))
            Arrays.asList(  
        r = client().prepareSearch("cache_test_idx")
                .addAggregation(dateRange("date_range").field("date").addRange(1000000, 3000000).addRange(3000000, 4000000))
                .prepareStats("cache_test_idx")
            .addAggregation(
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                .getHitCount(),  
        assertThat(bucket.getDocCount(), equalTo(2L));
        Feb 15, Mar 16,     3
        }  
        assertThat(bucket.getDocCount(), equalTo(2L));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        assertAcked(prepareCreate(indexName).setMapping("date", "type=date,format=strict_hour_minute_second"));  
    public void testRangeWithFormatStringValue() throws Exception {
                .get()  
        Range range = response.getAggregations().get("range");  
        assertThat(bucket, notNullValue());  
                .indices()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        Apr 23, May 24      6
            .get();
        assertThat(bucket.getDocCount(), equalTo(expectedFirstBucketCount));  
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        docs.addAll(
        int timeZoneOffset = timezone.getRules().getOffset(date(2, 15).toInstant()).getTotalSeconds();
                .setRequestCache(true)
        SearchResponse response = client().prepareSearch("idx")
        assertThat(((ZonedDateTime) buckets.get(0).getTo()).toInstant().toEpochMilli(), equalTo(1L));  
            .addAggregation(
        );  
        );
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
        assertThat(range.getName(), equalTo("range"));
        assertThat(bucket.getDocCount(), equalTo(numDocs - 1L));
package org.opensearch.search.aggregations.bucket;
    public void testMultiValuedFieldWithValueScript() throws Exception {  
        assertThat(((ZonedDateTime) buckets.get(0).getFrom()).toInstant().toEpochMilli(), equalTo(0L));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));  
        sum = bucket.getAggregations().get("sum");
        );
                .get()  
            )
        assertBucket(buckets.get(1), 1L, "00.50.00-01.06.40", 3000000L, 4000000L);  
        assertThat(bucket, notNullValue());  
                dateRange("foo").field("date")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                .getRequestCache()  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L));  
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000" + feb15Suffix));
                dateRange("range").field("date")
        // using no format should work when to/from is compatible with format in
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L));
        Map<String, Object> params = new HashMap<>();
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
                    .addUnboundedTo("2012-02-15")  
        assertThat(bucket, notNullValue());
import static org.hamcrest.core.IsNull.nullValue;
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        assertSearchResponse(response);  
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);  
        assertThat(  
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
            )
        assertSearchResponse(response);
        assertThat(range.getName(), equalTo("range"));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));  
        assertThat(range, notNullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        Mar 15, Apr 16,     3  
    }
        Range.Bucket bucket = buckets.get(0);  
import org.opensearch.search.aggregations.bucket.range.Range.Bucket;
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));  
        String feb15Suffix = timeZoneOffset == 0 ? "Z" : date(2, 15, timezone).format(DateTimeFormatter.ofPattern("xxx", Locale.ROOT));
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000" + mar15Suffix));
                .getRequestCache()
        assertThat(bucket.getToAsString(), nullValue());  
            .addAggregation(
        assertThat(range, notNullValue());
                    .addUnboundedFrom("2012-03-15")
        bucket = buckets.get(2);
        // there is a daylight saving time change on 11th March so suffix will be different  
        assertThat(bucket.getDocCount(), equalTo(2L));
            client().prepareIndex(indexName).setId("2").setSource(jsonBuilder().startObject().field("date", 2000).endObject()),
                .getTotal()
                        ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
import org.opensearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;  
        );
        List<Range.Bucket> buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);  
            .get();
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        return Collections.singleton(DateScriptMocksPlugin.class);
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
            .get();
        bucket = buckets.get(2);
    }
        assertSearchResponse(response);
            .addAggregation(
                    )
    /*
        assertThat((String) bucket.getKey(), equalTo("recently"));
            .get();
                .prepareStats("cache_test_idx")  
                .setRequestCache(true)
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));
        assertThat(
        bucket = buckets.get(1);  
        assertThat(bucket, notNullValue());
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
    public void testSingleValueFieldWithStringDates() throws Exception {  
            .get();
        SearchResponse r = client().prepareSearch("cache_test_idx")  
        assertBucket(buckets.get(1), 1L, "3000-4000", 3000000L, 4000000L);
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));  
        SearchResponse response = client().prepareSearch("idx")
        Mar 2,  Apr 3,      4  
        }
        );
                    .addRange("r2", date(2, 15), date(3, 15))  
        // mapping  
        assertSearchResponse(r);
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.DOUBLE_PLUS_ONE_MONTH, params))
 * GitHub history for details.
        assertBucket(buckets.get(0), 2L, "00:16:40-00:50:00", 1000000L, 3000000L);
            .get();
            .setSize(0)
import java.util.Arrays;
            )  
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));  
            )
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());  
        assertThat((String) bucket.getKey(), equalTo("r3"));
    }
import org.opensearch.action.index.IndexRequestBuilder;  
                .setRequestCache(true)  
        searchResponse = client().prepareSearch(indexName)  
        assertThat((String) bucket.getKey(), equalTo("r2"));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
    }
            )
        // format in aggregation
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [my_date_range_agg] aggregation");  
            .addAggregation(
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
 */
            );
    /*
        for (int i = 0; i < 2; i++) {  
            )  
        searchResponse = client().prepareSearch(indexName)
        assertThat((String) bucket.getKey(), equalTo("a long time ago"));
            equalTo(0L)
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
    }
                .indices()  
        assertThat(bucket.getFromAsString(), nullValue());
                    .addUnboundedFrom(date(3, 15))
        return Arrays.asList(  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.CURRENT_DATE, params))
        assertThat(range, notNullValue());
        assertThat(range.getName(), equalTo("range"));  
    private static IndexRequestBuilder indexDoc(int month, int day, int value) throws Exception {  
     */  
        assertBucket(buckets.get(1), 1L, "00.50.00-01.06.40", 3000000L, 4000000L);
        bucket = buckets.get(2);  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 2L - expectedFirstBucketCount));  
        Range range = response.getAggregations().get("range");  
                .getTotal()
        );  
        assertThat(dateRange, Matchers.notNullValue());
import java.util.Collection;
    }  
                indexDoc(3, 2, 4),  // Mar 2
        Range.Bucket bucket = buckets.get(0);  
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        Range.Bucket bucket = buckets.get(0);
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(bucket, notNullValue());
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
    private static int numDocs;
        assertThat(bucket.getFromAsString(), nullValue());
            client().admin()
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        // providing numeric input without format should throw an exception  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
            client().admin()  
            .setSize(0)
            .addAggregation(
        assertThat(bucket.getToAsString(), nullValue());  
        String mar15Suffix = timeZoneOffset == 0 ? "Z" : date(3, 15, timezone).format(DateTimeFormatter.ofPattern("xxx", Locale.ROOT));
        createIndex("idx_unmapped");  
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .timeZone(ZoneId.of("Etc/GMT+5"))  
        return client().prepareIndex("idx")
        bucket = buckets.get(2);  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
    public DateRangeIT(Settings staticSettings) {  
        assertThat(((InternalAggregation) range).getProperty("_bucket_count"), equalTo(3));
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
 *  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
        assertThat(bucket, Matchers.notNullValue());  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(buckets.size(), equalTo(3));
    private static ZonedDateTime date(int month, int day, ZoneId timezone) {  
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        Range.Bucket bucket = buckets.get(0);  
        assertThat(range.getName(), equalTo("range"));
        bucket = buckets.get(1);  
        assertSearchResponse(r);  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        assertThat(bucket.getToAsString(), nullValue());
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(bucket.getDocCount(), equalTo(0L));
        assertThat(bucket, notNullValue());  
            client().prepareIndex(indexName).setId("2").setSource(jsonBuilder().startObject().field("date", "00:33:20").endObject()),
        Map<String, Object> params = new HashMap<>();
    }  
            client().admin()
        assertThat(bucket.getToAsString(), nullValue());  
                .indices()  
        bucket = buckets.get(1);
        // Ensure that non-scripted requests are cached as normal
        // Make sure we are starting with a clear cache  
        assertThat(
    public void testSingleValueFieldWithCustomKey() throws Exception {  
                indexDoc(2, 15, 3), // Feb 15  
        assertSearchResponse(response);
                    .format("yyyy-MM-dd")
                    .addUnboundedTo(date(2, 15))
        indexRandom(
        assertThat((String) bucket.getKey(), equalTo("r2"));
        Range.Bucket bucket = buckets.get(0);  
        Jan 2,  Feb 3,      1  
    public static Collection<Object[]> parameters() {
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
        assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket, notNullValue());
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());  
        assertThat(bucket.getAggregations().asList().isEmpty(), is(true));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
            .get();
        bucket = buckets.get(2);
                    .addUnboundedFrom(date(3, 15))
        assertThat(bucket, notNullValue());
        assertThat(bucket.getToAsString(), nullValue());
            .get();
        assertThat(sum.getValue(), equalTo((double) 1 + 2));
                    .addUnboundedFrom(date(3, 15))  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        assertThat(buckets.size(), equalTo(3));  
                .setSource(jsonBuilder().startObject().timeField("date", date(1, 1)).endObject()),  
        assertThat(buckets.size(), equalTo(3));  
            .setSize(0)  
        assertThat(bucket.getDocCount(), equalTo(0L));
                .getRequestCache()
            )
        );
            .get();
        assertThat(bucket, notNullValue());
            )
        assertThat(range.getName(), equalTo("range"));
        // Test that a request using a nondeterministic script does not get cached  
        ZoneId timezone = randomZone();
        assertThat(e.getDetailedMessage(), containsString("failed to parse date field [1000000] with format [strict_hour_minute_second]"));
                .prepareStats("cache_test_idx")
    public void testDateMath() throws Exception {
        }  
            .get();  
                histogram("histo").field("value")
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
                .getTotal()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
                dateRange("range").field("date")
        List<Range.Bucket> buckets = new ArrayList<>(dateRange.getBuckets());  
        sum = bucket.getAggregations().get("sum");
        Jan 2,  Feb 3,      1
        bucket = buckets.get(1);  
import org.opensearch.search.aggregations.bucket.range.Range;
                .getTotal()
        assertThat(bucket.getDocCount(), equalTo(2L));
                .setSource(jsonBuilder().startObject().timeField("date", date(2, 1)).endObject())  
        assertThat(bucket, notNullValue());
        assertThat(bucket.getFromAsString(), nullValue());
        List<? extends Bucket> buckets = range.getBuckets();  
        assertThat(range, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(0L));
import java.time.ZoneOffset;  
                .getTotal()  
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    }  
            .addAggregation(  
                dateRange("range").field("date")  
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertThat(buckets.size(), equalTo(3));
            .get();  
import org.opensearch.common.settings.Settings;  
        assertThat(buckets.size(), equalTo(3));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertSearchResponse(response);  
                    .addRange("2012-02-15", "2012-02-15||+1M")  
                    .timeValue(date(month, day))
        assertThat(((ZonedDateTime) bucket.getFrom()).toInstant().toEpochMilli(), equalTo(expectedFrom));  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
        assertThat(bucket.getFromAsString(), nullValue());
            docs.add(indexDoc(randomIntBetween(6, 10), randomIntBetween(1, 20), randomInt(100)));  
        Range.Bucket bucket = buckets.get(0);
        client().admin().cluster().prepareHealth("idx_unmapped").setWaitForYellowStatus().get();
    }  
import java.util.HashMap;
        assertSearchResponse(response);  
            client().prepareSearch("idx").addAggregation(dateRange("my_date_range_agg").field("value")).get();
            .get();  
        assertBucket(buckets.get(1), 1L, "3000-4000", 3000000L, 4000000L);  
            .addAggregation(  
            )  
            fail();
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
        assertSearchResponse(response);  
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(0L));
                .get()  
            equalTo(0L)
        Apr 23, May 24      6  
        bucket = buckets.get(1);  
     */
                    .addUnboundedTo(date(2, 15))  
            .setSize(0)
                dateRange("foo").field("date")  
            .get();
            client().prepareIndex("cache_test_idx")
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
            client().prepareIndex(indexName).setId("1").setSource(jsonBuilder().startObject().field("date", "00:16:40").endObject()),  
        assertThat((long) propertiesDocCounts[2], equalTo(numDocs - 4L));
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        Feb 15,     3
        assertThat((String) bucket.getKey(), equalTo("2012-03-15-*"));
        assertThat(bucket.getDocCount(), equalTo(0L));
            )
        // providing different numeric input with format should work, but bucket
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat(buckets.size(), is(1));  
            .get();
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000" + feb15Suffix));
        SearchResponse response = client().prepareSearch("idx")  
                .indices()
        Map<String, Object> params = new HashMap<>();
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        for (int i = docs.size(); i < numDocs; ++i) {
        assertThat(bucket.getDocCount(), equalTo(2L));
        Apr 2,  May 3,      4
            )  
    public void testSingleValueFieldWithDateMath() throws Exception {  
        bucket = buckets.get(1);
        List<Range.Bucket> buckets = new ArrayList<>(range.getBuckets());
            equalTo(2L)
    public void testSingleValuedFieldWithSubAggregation() throws Exception {
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        Range.Bucket bucket = buckets.get(0);
    }
            )
        assertThat(bucket, notNullValue());  
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
/*  
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));  
        assertThat(
        List<? extends Bucket> buckets = range.getBuckets();  
    public void testSingleValueField() throws Exception {
        // keys are different now
        assertThat(bucket, notNullValue());
                    )  
     * Ensure requests using nondeterministic scripts do not get cached.  
            prepareCreate("cache_test_idx").setMapping("date", "type=date")
                    .field("value", value)
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        assertThat(bucket.getDocCount(), equalTo(3L));
        params.put("fieldname", "date");  
            .setSource(
        assertThat((String) bucket.getKey(), equalTo("last year"));  
            client().admin()
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));
    public void testPartiallyUnmapped() throws Exception {
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000" + feb15Suffix));
                    .addUnboundedFrom(date(3, 15))  
        // using no format should also work when and to/from are string values
        bucket = buckets.get(1);
        assertThat(bucket.getDocCount(), equalTo(0L));
 *
            .addAggregation(  
                        ZonedDateTime.of(2013, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC)
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
                .getHitCount(),
import java.util.Collections;  
                .getHitCount(),  
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
import org.opensearch.test.OpenSearchIntegTestCase;
            client().admin()
                dateRange("range").field("date")
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
    public void testScriptCaching() throws Exception {
        List<? extends Bucket> buckets = range.getBuckets();  
 * KIND, either express or implied.  See the License for the
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());  
        bucket = buckets.get(1);  
                .get()
        assertThat(bucket.getFromAsString(), nullValue());  
        assertThat(bucket.getDocCount(), equalTo(3L));  
        assertThat(bucket.getKeyAsString(), equalTo("last year"));
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
        return buckets;  
        assertThat(sum, notNullValue());  
                    .script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.DOUBLE_PLUS_ONE_MONTH, params))  
        assertThat(bucket, notNullValue());  
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        Feb 2,  Mar 3,      1
            .addAggregation(
        bucket = buckets.get(1);  
        assertBucket(buckets.get(0), 2L, "1000-3000", 1000000L, 3000000L);  
                    .addUnboundedFrom(date(3, 15))  
        assertThat((String) buckets.get(0).getKey(), equalTo("0-1"));
            .get();
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        Mar 15, Apr 16,     3
    @Override
        );
            )  
        Range range = response.getAggregations().get("range");  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());  
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));  
            .addAggregation(dateRange("date_range").field("date").addRange(1.0e3, 3000.8123).addRange(3000.8123, 4.0e3))
        SearchResponse response = client().prepareSearch("idx")
     */
            )  
        bucket = buckets.get(2);  
        assertThat(bucket.getDocCount(), equalTo(2L));  
                    .addUnboundedTo(date(2, 15))
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());  
            .addAggregation(
        assertThat((long) propertiesDocCounts[1], equalTo(2L));  
        assertThat(bucket.getFromAsString(), nullValue());
        // providing numeric input with format should work, but bucket keys are
        assertThat(bucket, notNullValue());
                    .addRange(date(2, 15), date(3, 15))
        Range range = response.getAggregations().get("range");
     */  
                .get()
                    .addUnboundedFrom("last year", "now-1y")
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
                    .minDocCount(0)  
                .get()  
            .get();
        params.put("fieldname", "dates");
        assertSearchResponse(response);
        Range range = response.getAggregations().get("range");  
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        Range range = response.getAggregations().get("range");
        Range range = response.getAggregations().get("range");
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        assertThat(buckets.size(), equalTo(3));
        assertThat(
import org.hamcrest.Matchers;  
        assertThat((String) propertiesKeys[1], equalTo("r2"));
        buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
        assertThat(sum, notNullValue());  
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        assertSearchResponse(response);  
        indexRandom(
                    .addRange(date(2, 15), date(3, 15))
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());  
            .addAggregation(
 * specific language governing permissions and limitations
        assertThat(buckets.size(), equalTo(3));
        List<? extends Bucket> buckets = range.getBuckets();
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        assertThat(range, notNullValue());
        Mar 15, Apr 16      5
            equalTo(0L)
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));  
 * this work for additional information regarding copyright
            .addAggregation(dateRange("date_range").field("date").addRange(1000, 3000).addRange(3000, 4000))  
        assertThat((String) propertiesKeys[0], equalTo("r1"));
        internalCluster().wipeIndices("cache_test_idx");  
import java.time.ZoneId;
                .getMissCount(),
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        assertThat(sum, notNullValue());  
            true,  
                        ZonedDateTime.of(2012, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),  
                dateRange("range").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))  
        assertBucket(buckets.get(0), 2L, "1000-3000", 1000000L, 3000000L);
        Mar 15, Apr 16      5  
    }
        assertBucket(buckets.get(1), 1L, "00:50:00-01:06:40", 3000000L, 4000000L);
        bucket = buckets.get(1);
                .getTotal()  
            equalTo(0L)  
        Apr 15, May 16      5  
        // using no format should work when to/from is compatible with format in
        Feb 2,  Mar 3,      1
        assertThat((String) bucket.getKey(), equalTo("*-2012-02-15T00:00:00.000Z"));
                .setRequestCache(true)
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        assertThat(range.getName(), equalTo("range"));
            client().admin()  
        );
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));
        SearchResponse searchResponse = client().prepareSearch(indexName)
        assertBucket(buckets.get(0), 2L, "1000-3000", 1000000L, 3000000L);
                rangeBuilder.addUnboundedTo("a long time ago", "now-50y")  
                    .addRange(date(2, 15), date(3, 15))
import java.util.ArrayList;  
        assertThat(bucket, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSingleValueFieldWithStringDatesWithCustomFormat() throws Exception {
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        assertThat(bucket, notNullValue());
                    .endArray()  
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
                    .addRange("r2", date(2, 15), date(3, 15))
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) range).getProperty("_key");
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;  
            equalTo(0L)
        // different now  
        assertThat(bucket, notNullValue());
            .addAggregation(dateRange("date_range").field("date").addRange("1000", "3000").addRange("3000", "4000"))
            .setQuery(matchAllQuery())
        return date(month, day, ZoneOffset.UTC);  
            .setSize(0)
                .get()
        assertThat(bucket, notNullValue());  
                .prepareStats("cache_test_idx")  
        Mar 23, Apr 24      6
                .indices()
public class DateRangeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * under the License.  
        } else {
        assertThat(bucket.getKeyAsString(), equalTo("a long time ago"));  
                dateRange("range").field("date")
        Range range = response.getAggregations().get("range");
        assertThat(bucket.getToAsString(), equalTo("2012-02-15"));
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
            )
        Feb 2,  Mar 3,      2  
import java.util.List;
                    .addRange("2012-02-15", "2012-03-15")
        assertThat(bucket, notNullValue());
            OpenSearchException.class,
            )
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        if (randomBoolean()) {
            .addAggregation(
        assertThat(buckets.size(), is(2));
        List<? extends Bucket> buckets = range.getBuckets();
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) range).getProperty("_count");  
        return ZonedDateTime.of(2012, month, day, 0, 0, 0, 0, timezone);
                .getRequestCache()
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        Range.Bucket bucket = buckets.get(0);
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
                .getRequestCache()
        assertSearchResponse(response);  
        bucket = buckets.get(2);  
        Object[] propertiesCounts = (Object[]) ((InternalAggregation) range).getProperty("sum.value");
import org.opensearch.script.Script;
        indexRandom(
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15T00:00:00.000Z"));
        );
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertThat(buckets.get(0).getDocCount(), equalTo(0L));
            .get();  
    }
    /**
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
                .getRequestCache()
                .setRequestCache(true)
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        );
        assertThat(range.getBuckets().size(), equalTo(3));  
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));  
            rangeBuilder.field("date");  
        assertThat(buckets.get(0).getAggregations().asList().isEmpty(), is(true));
        Sum sum = bucket.getAggregations().get("sum");
            .addAggregation(  
        Mar 2,  Apr 3,      2  
        assertThat(range, notNullValue());
                    .addUnboundedFrom(date(3, 15))
        assertThat(bucket.getFromAsString(), nullValue());
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
    public void testUnmapped() throws Exception {
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
                    .interval(1L)
        assertThat(range.getName(), equalTo("range"));
     */
        );
        assertSearchResponse(r);  
     * values specified as numeric value
        Range range = response.getAggregations().get("range");  
                client().prepareIndex("empty_bucket_idx")
        List<IndexRequestBuilder> docs = new ArrayList<>();
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        List<? extends Bucket> buckets = range.getBuckets();  
        String indexName = "dateformat_numeric_test_idx";
import org.opensearch.script.ScriptType;  
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
import java.util.Map;
        assertThat(bucket.getDocCount(), equalTo(bucketSize));
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
    }  
        assertThat(bucket.getFromAsString(), nullValue());
    }
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        assertThat(bucket, notNullValue());  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));
        assertThat(range, notNullValue());
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000Z-2012-03-15T00:00:00.000Z"));
        assertThat(dateRange, Matchers.notNullValue());
import static org.hamcrest.Matchers.containsString;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping("value", "type=integer"));
        assertThat(range, notNullValue());  
    public void testScriptSingleValue() throws Exception {
import java.util.Locale;  
    }
            )
        assertThat(bucket.getToAsString(), nullValue());
        assertThat(bucket.getToAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
            .get();
                .setRequestCache(true)
                    .addUnboundedTo("2012-02-15")
                    .addUnboundedTo(date(2, 15))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(3L));  
import static org.hamcrest.core.IsNull.notNullValue;  
        assertThat(range, notNullValue());  
                dateRange("range").script(new Script(ScriptType.INLINE, "mockscript", DateScriptMocksPlugin.EXTRACT_FIELD, params))  
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertThat(((ZonedDateTime) bucket.getTo()), nullValue());
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15"));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));  
            .addAggregation(  
        assertThat(range.getName(), equalTo("range"));
        bucket = buckets.get(2);
import java.time.format.DateTimeFormatter;
                    .addRange("2012-02-15", "2012-03-15")  
        assertBucket(buckets.get(0), 2L, "00.16.40-00.50.00", 1000000L, 3000000L);
        assertThat(bucket, notNullValue());
    @ParametersFactory
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));  
        bucket = buckets.get(1);
                    .addUnboundedFrom("2012-02-15||+1M")
            );
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
                    .addUnboundedTo("r1", date(2, 15))
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
        numDocs = randomIntBetween(7, 20);
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));  
                .get()  
     */
        assertThat(bucket.getDocCount(), equalTo(2L));
                    .addRange(date(2, 15), date(3, 15))
        assertThat((String) bucket.getKey(), equalTo("2012-02-15T00:00:00.000" + feb15Suffix + "-2012-03-15T00:00:00.000" + mar15Suffix));
    }
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        Feb 2,      2  
        assertThat(bucket.getFromAsString(), equalTo("2012-03-15T00:00:00.000Z"));
    public void testScriptMultiValued() throws Exception {
                indexDoc(3, 23, 6)  // Mar 23  
            .get();
            client().prepareIndex("cache_test_idx")
        assertThat(bucket.getToAsString(), equalTo("2012-02-15T00:00:00.000Z"));  
            .get();
        assertThat(((ZonedDateTime) bucket.getFrom()), nullValue());
        Mar 2,  Apr 3,      2
        assertThat(bucket, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));  
        assertAcked(  
        assertThat(bucket, notNullValue());  
                    .addRange(date(2, 15), date(3, 15))
        Range range = response.getAggregations().get("range");
        assertThat(bucket, notNullValue());  
    public void testMultiValuedField() throws Exception {
        assertThat(bucket, notNullValue());
    }
        assertThat(sum.getValue(), equalTo((double) 3 + 4));
 * Licensed to Elasticsearch under one or more contributor  
                    .addUnboundedFrom(date(3, 15))  
        Range.Bucket bucket = buckets.get(0);  
import static org.hamcrest.Matchers.is;
     * Test querying ranges on date mapping specifying a format with to/from
        try {  
        List<Range.Bucket> buckets = new ArrayList<>(dateRange.getBuckets());
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        }
                    .timeValue(date(month + 1, day + 1))
        assertBucket(buckets.get(0), 2L, "1000000-3000000", 1000000L, 3000000L);  
import org.opensearch.OpenSearchException;
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(2, 15)));
            )  
/*
                dateRange("date_range").field("date").addRange(1000000, 3000000).addRange(3000000, 4000000).format("epoch_millis")  
        Range range = response.getAggregations().get("range");  
        assertThat(bucket.getFromAsString(), equalTo("2012-02-15"));
        assertThat((String) bucket.getKey(), equalTo("2012-03-15T00:00:00.000Z-*"));
        Jan 2,      1
        OpenSearchException e = expectThrows(
    }
    /*
    public void testEmptyAggregation() throws Exception {  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            .setSize(0)
        // mapping  
                    .endObject()
            .setSize(0)  
        assertThat(bucket.getFromAsString(), nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(bucket, notNullValue());  
                    .addRange(
        assertThat(buckets.size(), equalTo(3));  
                    .addRange(  
        assertThat(bucket, notNullValue());  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        bucket = buckets.get(2);
        assertThat(((ZonedDateTime) bucket.getFrom()), equalTo(date(3, 15)));  
        assertThat(bucket, notNullValue());  
        assertSearchResponse(response);
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(2, 15)));
        assertThat(bucket.getToAsString(), equalTo("2012-03-15"));
        List<Bucket> buckets = checkBuckets(searchResponse.getAggregations().get("date_range"), "date_range", 2);  
        Range range = response.getAggregations().get("range");  
import static org.hamcrest.Matchers.equalTo;  
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15)));
        assertThat(((ZonedDateTime) bucket.getTo()), equalTo(date(3, 15, timezone).withZoneSameInstant(ZoneOffset.UTC)));  
    }  
        assertSearchResponse(response);
        assertThat(bucket.getDocCount(), equalTo(numDocs - 4L));
