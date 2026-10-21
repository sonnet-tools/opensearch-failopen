        SearchRequest transformedRequestTo = processor.processRequest(requestTo);
        boolean hashBucket
            hashBucket
    public void testNonTimestampFieldIgnored() throws Exception {
        // Test missing timestamp_field
    // Helper method to create processor
import org.opensearch.index.query.BoolQueryBuilder;
    }
        return new TemporalRoutingSearchProcessor(
import java.util.HashMap;
        SearchRequest transformedRequest = processor.processRequest(request);
        config1.put("granularity", "day");
        SearchRequest transformedRequest = processor.processRequest(request);
            .to("2023-12-22T23:59:59Z");   // Week 51
        SearchRequest transformedRequest = processor.processRequest(request);
        SearchRequest request = new SearchRequest().source(source);
    public void testWeeklyGranularityRouting() throws Exception {
        assertThat(routing.matches("\\d+"), equalTo(true));
import org.opensearch.OpenSearchParseException;
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "week", "strict_date_optional_time", true, false);
    public void testBoolQueryWithRangeFilter() throws Exception {
        SearchRequest transformedRequest = processor.processRequest(request);
import static org.hamcrest.Matchers.equalTo;
}
    public void testMonthlyGranularityRouting() throws Exception {
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchSourceBuilder sourceTo = new SearchSourceBuilder().query(queryTo);
            () -> factory.create(Collections.emptyMap(), "test", null, false, config1, null)
        TemporalRoutingSearchProcessor processor = factory.create(Collections.emptyMap(), "test", "test processor", false, config, null);
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        QueryBuilder queryFrom = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z");
        // Should not add routing since range is only in should clause
        config4.put("timestamp_field", "@timestamp");
        config.put("granularity", "day");
    }
        QueryBuilder query = new RangeQueryBuilder("@timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");
            OpenSearchParseException.class,
        SearchRequest transformedRequest = processor.processRequest(request);
        assertTrue("Should contain multiple routing values", routing.contains(","));
        assertThat(exception.getMessage(), containsString("timestamp_field"));
        assertNull("Should not add routing for should clauses", transformedRequest.routing());
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "hour", "strict_date_optional_time", true, false);
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "month", "strict_date_optional_time", true, false);
        assertThat(processor.getType(), equalTo(TemporalRoutingSearchProcessor.TYPE));
        config.put("format", "strict_date_optional_time");
        );
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchRequest request = new SearchRequest().source(source).routing("existing_routing");
        SearchRequest request1 = new SearchRequest().source(source1);
        String timestampField,
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        config2.put("timestamp_field", "@timestamp");
        SearchRequest request = new SearchRequest().source(source);
import org.opensearch.test.AbstractBuilderTestCase;
        OpenSearchParseException exception = expectThrows(
        // Test range with only upper bound
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
    }
        SearchRequest transformedRequest = processor.processRequest(request);
            OpenSearchParseException.class,
 */
        SearchRequest request = new SearchRequest().source(source);
    }
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        boolean enableAutoDetection,
import org.opensearch.action.search.SearchRequest;
            TemporalRoutingSearchProcessor.Granularity.fromString(granularity),
            false,
        // Different ranges within same day should produce same routing
        assertThat(transformedRequestTo.routing(), equalTo("2023-12-15"));
        Map<String, Object> config4 = new HashMap<>();
package org.opensearch.search.pipeline.common;
import org.opensearch.search.builder.SearchSourceBuilder;
        assertThat(exception.getMessage(), containsString("granularity"));
        // Should be a numeric hash, not the date string
        SearchRequest request = new SearchRequest().source(source);
        SearchSourceBuilder sourceFrom = new SearchSourceBuilder().query(queryFrom);
        SearchRequest request = new SearchRequest().source(source);
        assertTrue("Should contain monthly buckets", routing.contains("2024-01"));
    }
        exception = expectThrows(
import java.util.Collections;
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        assertThat(transformedRequest.routing(), nullValue());
        assertThat(transformedRequest.routing(), notNullValue());
        SearchRequest request = new SearchRequest();
            new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z")
        );
        // Existing routing should be preserved
 * SPDX-License-Identifier: Apache-2.0
        SearchRequest transformedRequest = processor.processRequest(request);
            "test",
    public void testOpenEndedRanges() throws Exception {
        SearchRequest requestTo = new SearchRequest().source(sourceTo);
    public void testMultiDayRangeQueryRouting() throws Exception {
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, true);
        Map<String, Object> config3 = new HashMap<>();
/*
    public void testRangeQueryRouting() throws Exception {
    }
        config3.put("timestamp_field", "@timestamp");
        assertThat(result1.routing(), equalTo(result2.routing()));
        QueryBuilder queryTo = new RangeQueryBuilder("timestamp").to("2023-12-15T23:59:59Z");
        );
import org.opensearch.index.query.QueryBuilder;
            enableAutoDetection,
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z")  // Week 50
        String granularity,
        assertTrue("Should contain hourly buckets", routing.contains("2023-12-15T14"));
    }
        SearchRequest transformedRequestFrom = processor.processRequest(requestFrom);
        SearchRequest transformedRequest = processor.processRequest(request);
        SearchRequest request2 = new SearchRequest().source(source2);
        SearchRequest request = new SearchRequest().source(source);
        QueryBuilder query2 = new RangeQueryBuilder("timestamp").from("2023-12-15T14:00:00Z").to("2023-12-15T18:00:00Z");
        String routing = transformedRequest.routing();
        assertTrue("Should contain 2023-12-15", routing.contains("2023-12-15"));
        // Should not add routing for different field
    public void testInvalidDateFormatIgnored() throws Exception {
        SearchRequest requestFrom = new SearchRequest().source(sourceFrom);
        // Test invalid granularity
import static org.hamcrest.Matchers.notNullValue;
    }
    public void testHourlyGranularityRouting() throws Exception {
        // No routing should be added for empty request
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchRequest request = new SearchRequest().source(source);
        SearchRequest request = new SearchRequest().source(source);
        assertTrue("Should contain hourly buckets", routing.contains("2023-12-15T15"));
        assertThat(transformedRequest.routing(), notNullValue());
        String routing = transformedRequest.routing();
        String routing = transformedRequest.routing();
    }
 * this file be licensed under the Apache-2.0 license or a
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
import static org.hamcrest.Matchers.nullValue;
        SearchRequest request = new SearchRequest().source(source);
        assertThat(transformedRequest.routing(), nullValue());
        assertThat(transformedRequest.routing(), equalTo("2023-12-15"));
    public void testEmptySearchRequest() throws Exception {
        SearchRequest result1 = processor.processRequest(request1);
        // Should have same routing since they're on the same day
        QueryBuilder boolQuery = new BoolQueryBuilder().must(textQuery).filter(rangeFilter);
        );
    public void testShouldClauseIgnored() throws Exception {
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        // Should not throw exception, should fallback to no routing
        assertThat(transformedRequest.routing(), notNullValue());
            timestampField,
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
    }
        Map<String, Object> config1 = new HashMap<>();
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        assertThat(transformedRequest.routing(), notNullValue());
        assertTrue("Should contain weekly buckets", routing.contains("2023-W51"));
        SearchRequest transformedRequest = processor.processRequest(request);
        SearchRequest transformedRequest = processor.processRequest(request);
    }
        assertThat(exception.getMessage(), containsString("Invalid granularity"));
    }
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        config4.put("granularity", "day");
        SearchRequest request = new SearchRequest().source(source);
        config.put("hash_bucket", false);
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");
        QueryBuilder rangeFilter = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");
        TemporalRoutingSearchProcessor processor = createProcessor("@timestamp", "day", "strict_date_optional_time", true, false);
 * The OpenSearch Contributors require contributions made to
            format,
        assertTrue("Should contain monthly buckets", routing.contains("2023-11"));
        // Test invalid format
        SearchRequest transformedRequest = processor.processRequest(request);
    public void testFactoryValidation() throws Exception {
    public void testHashBucketRouting() throws Exception {
public class TemporalRoutingSearchProcessorTests extends AbstractBuilderTestCase {
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-11-15T00:00:00Z").to("2024-01-15T23:59:59Z");
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-17T23:59:59Z");
        assertTrue("Should contain 2023-12-17", routing.contains("2023-12-17"));
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, true);
 * compatible open source license.
        assertThat(transformedRequest.routing(), notNullValue());
    ) {
        assertThat(transformedRequest.routing(), notNullValue());
import static org.hamcrest.Matchers.containsString;
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "yyyy-MM-dd HH:mm:ss", true, false);
        TemporalRoutingSearchProcessor.Factory factory = new TemporalRoutingSearchProcessor.Factory();
import java.util.Map;
            OpenSearchParseException.class,
        assertThat(transformedRequest.routing(), equalTo("2023-12-15"));
        QueryBuilder query = new BoolQueryBuilder().should(
 *
        String format,
        assertThat(transformedRequest.routing(), notNullValue());
    }
        assertThat(transformedRequestFrom.routing(), equalTo("2023-12-15"));
        String routing = transformedRequest.routing();
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchSourceBuilder source = new SearchSourceBuilder().query(boolQuery);
        config.put("enable_auto_detection", true);
    }
        SearchRequest request = new SearchRequest().source(source);
            () -> factory.create(Collections.emptyMap(), "test", null, false, config4, null)
        assertThat(transformedRequest.routing(), equalTo("2023-12-15"));
    }
        QueryBuilder query1 = new RangeQueryBuilder("timestamp").from("2023-12-15T08:00:00Z").to("2023-12-15T12:00:00Z");
        exception = expectThrows(
        assertThat(transformedRequest.routing(), nullValue());
        Map<String, Object> config2 = new HashMap<>();
        TemporalRoutingSearchProcessor.Factory factory = new TemporalRoutingSearchProcessor.Factory();
    public void testConsistentRoutingForSameTimeWindow() throws Exception {
        assertThat(transformedRequest.routing(), equalTo("existing_routing"));
        QueryBuilder textQuery = new TermQueryBuilder("content", "log message");
        );
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
    public void testCustomDateFormat() throws Exception {
    }
        SearchRequest result2 = processor.processRequest(request2);
        // Query with range only in should clause
    }
        SearchSourceBuilder source1 = new SearchSourceBuilder().query(query1);
        assertTrue("Should contain monthly buckets", routing.contains("2023-12"));
            OpenSearchParseException.class,
        SearchRequest transformedRequest = processor.processRequest(request);
            () -> factory.create(Collections.emptyMap(), "test", null, false, config2, null)
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15 00:00:00").to("2023-12-15 23:59:59");
    private TemporalRoutingSearchProcessor createProcessor(
    public void testExistingRoutingPreserved() throws Exception {
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        Map<String, Object> config = new HashMap<>();
import org.opensearch.index.query.TermQueryBuilder;
        config3.put("granularity", "invalid");
    }
        assertThat(exception.getMessage(), containsString("invalid date format"));
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        exception = expectThrows(
        config4.put("format", "invalid_format");
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("invalid-date").to("another-invalid-date");
        );
        String routing = transformedRequest.routing();
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T14:30:00Z").to("2023-12-15T16:45:00Z");
            "test processor",
        QueryBuilder query = new RangeQueryBuilder("other_field").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");
        SearchRequest transformedRequest = processor.processRequest(request);
    public void testFactory() throws Exception {
        // Test missing granularity
import org.opensearch.index.query.RangeQueryBuilder;
        // Test range with only lower bound
        assertTrue("Should contain hourly buckets", routing.contains("2023-12-15T16"));
        assertTrue("Should contain 2023-12-16", routing.contains("2023-12-16"));
        SearchSourceBuilder source2 = new SearchSourceBuilder().query(query2);
            () -> factory.create(Collections.emptyMap(), "test", null, false, config3, null)
        assertThat(transformedRequest.routing(), notNullValue());
        assertTrue("Should contain weekly buckets", routing.contains("2023-W50"));
        config.put("timestamp_field", "@timestamp");
