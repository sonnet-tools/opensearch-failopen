        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        assertThat(result1.routing(), equalTo(result2.routing()));
        boolean hashBucket  
    }  
        SearchRequest request = new SearchRequest().source(source);
        assertThat(transformedRequest.routing(), notNullValue());
            new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z")  
        );
        SearchSourceBuilder source = new SearchSourceBuilder().query(boolQuery);
        // Test missing granularity
    ) {
    }
        config3.put("timestamp_field", "@timestamp");
        Map<String, Object> config2 = new HashMap<>();  
        // Different ranges within same day should produce same routing  
        SearchRequest request2 = new SearchRequest().source(source2);
import org.opensearch.search.builder.SearchSourceBuilder;
        assertThat(transformedRequest.routing(), notNullValue());  
        assertThat(exception.getMessage(), containsString("Invalid granularity"));
        assertThat(transformedRequest.routing(), notNullValue());
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, true);
        SearchRequest request = new SearchRequest().source(source);
        QueryBuilder query = new BoolQueryBuilder().should(
    }  
        QueryBuilder queryTo = new RangeQueryBuilder("timestamp").to("2023-12-15T23:59:59Z");
import static org.hamcrest.Matchers.containsString;
    }  
        SearchSourceBuilder sourceTo = new SearchSourceBuilder().query(queryTo);
        SearchSourceBuilder source2 = new SearchSourceBuilder().query(query2);  
            format,
        SearchRequest transformedRequestTo = processor.processRequest(requestTo);
        SearchRequest request = new SearchRequest().source(source);
            OpenSearchParseException.class,
        config4.put("timestamp_field", "@timestamp");
            hashBucket
import org.opensearch.OpenSearchParseException;
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "yyyy-MM-dd HH:mm:ss", true, false);
        exception = expectThrows(
        // Query with range only in should clause
            "test",  
    }
        );  
 * The OpenSearch Contributors require contributions made to  
        SearchRequest request = new SearchRequest().source(source);
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
            TemporalRoutingSearchProcessor.Granularity.fromString(granularity),
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T14:30:00Z").to("2023-12-15T16:45:00Z");  
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        // No routing should be added for empty request
package org.opensearch.search.pipeline.common;
    }
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z")  // Week 50
    // Helper method to create processor  
    public void testBoolQueryWithRangeFilter() throws Exception {  
        config2.put("timestamp_field", "@timestamp");
}
        TemporalRoutingSearchProcessor.Factory factory = new TemporalRoutingSearchProcessor.Factory();  
        SearchRequest transformedRequest = processor.processRequest(request);
        assertTrue("Should contain monthly buckets", routing.contains("2023-11"));
            () -> factory.create(Collections.emptyMap(), "test", null, false, config3, null)
        assertTrue("Should contain hourly buckets", routing.contains("2023-12-15T14"));
        SearchRequest request = new SearchRequest().source(source);
        config1.put("granularity", "day");
        SearchRequest request = new SearchRequest().source(source);
        assertThat(transformedRequestFrom.routing(), equalTo("2023-12-15"));
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        // Test invalid granularity
    }
        assertTrue("Should contain 2023-12-15", routing.contains("2023-12-15"));
        assertThat(exception.getMessage(), containsString("granularity"));  
        assertThat(processor.getType(), equalTo(TemporalRoutingSearchProcessor.TYPE));
import java.util.HashMap;
        // Should not throw exception, should fallback to no routing
            () -> factory.create(Collections.emptyMap(), "test", null, false, config4, null)
    public void testInvalidDateFormatIgnored() throws Exception {  
        Map<String, Object> config1 = new HashMap<>();  
    }  
        // Test range with only lower bound
        SearchRequest request = new SearchRequest();
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);  
    public void testConsistentRoutingForSameTimeWindow() throws Exception {  
    public void testNonTimestampFieldIgnored() throws Exception {  
        assertTrue("Should contain 2023-12-17", routing.contains("2023-12-17"));  
 *
        config.put("format", "strict_date_optional_time");
        assertThat(transformedRequest.routing(), notNullValue());  
    public void testOpenEndedRanges() throws Exception {
import org.opensearch.index.query.RangeQueryBuilder;
        String routing = transformedRequest.routing();  
            enableAutoDetection,  
        // Existing routing should be preserved
        TemporalRoutingSearchProcessor processor = createProcessor("@timestamp", "day", "strict_date_optional_time", true, false);
        assertThat(transformedRequest.routing(), equalTo("2023-12-15"));
        );
import java.util.Map;  
public class TemporalRoutingSearchProcessorTests extends AbstractBuilderTestCase {
        // Test invalid format  
        // Should have same routing since they're on the same day
        SearchRequest transformedRequest = processor.processRequest(request);
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-17T23:59:59Z");
        SearchRequest result1 = processor.processRequest(request1);
        QueryBuilder query = new RangeQueryBuilder("@timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");  
        String routing = transformedRequest.routing();
        String timestampField,
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
        SearchRequest transformedRequest = processor.processRequest(request);
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");  
            () -> factory.create(Collections.emptyMap(), "test", null, false, config1, null)
        assertThat(exception.getMessage(), containsString("timestamp_field"));  
    public void testHourlyGranularityRouting() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
    public void testRangeQueryRouting() throws Exception {  
        // Test missing timestamp_field
        config4.put("format", "invalid_format");
        SearchRequest transformedRequest = processor.processRequest(request);  
        assertThat(transformedRequest.routing(), equalTo("2023-12-15"));
        assertThat(transformedRequestTo.routing(), equalTo("2023-12-15"));  
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, true);
    }
        Map<String, Object> config3 = new HashMap<>();  
        OpenSearchParseException exception = expectThrows(
        SearchRequest request = new SearchRequest().source(source);
        SearchRequest transformedRequest = processor.processRequest(request);  
import org.opensearch.test.AbstractBuilderTestCase;
        String format,
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchRequest transformedRequest = processor.processRequest(request);  
        QueryBuilder query = new RangeQueryBuilder("other_field").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");  
    public void testHashBucketRouting() throws Exception {  
        );
        TemporalRoutingSearchProcessor.Factory factory = new TemporalRoutingSearchProcessor.Factory();  
        exception = expectThrows(  
        SearchSourceBuilder source1 = new SearchSourceBuilder().query(query1);
    }
    }  
        config.put("granularity", "day");
 * this file be licensed under the Apache-2.0 license or a
    public void testFactoryValidation() throws Exception {
        assertTrue("Should contain multiple routing values", routing.contains(","));  
        SearchRequest request = new SearchRequest().source(source);
        QueryBuilder boolQuery = new BoolQueryBuilder().must(textQuery).filter(rangeFilter);
        config.put("timestamp_field", "@timestamp");  
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "month", "strict_date_optional_time", true, false);  
        assertThat(transformedRequest.routing(), nullValue());
    private TemporalRoutingSearchProcessor createProcessor(
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
        SearchRequest transformedRequest = processor.processRequest(request);
    }
    }
        assertThat(transformedRequest.routing(), notNullValue());  
        assertTrue("Should contain 2023-12-16", routing.contains("2023-12-16"));
        return new TemporalRoutingSearchProcessor(
        // Test range with only upper bound  
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("invalid-date").to("another-invalid-date");  
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15 00:00:00").to("2023-12-15 23:59:59");  
        String routing = transformedRequest.routing();  
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        assertTrue("Should contain hourly buckets", routing.contains("2023-12-15T15"));  
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
    }
        assertThat(transformedRequest.routing(), notNullValue());
import static org.hamcrest.Matchers.notNullValue;
    }
        );
        assertThat(transformedRequest.routing(), equalTo("existing_routing"));
            "test processor",
    }
        SearchRequest transformedRequest = processor.processRequest(request);
import static org.hamcrest.Matchers.nullValue;
        SearchRequest request = new SearchRequest().source(source);
        assertTrue("Should contain weekly buckets", routing.contains("2023-W50"));
        String granularity,  
        QueryBuilder query2 = new RangeQueryBuilder("timestamp").from("2023-12-15T14:00:00Z").to("2023-12-15T18:00:00Z");  
 * compatible open source license.
        assertNull("Should not add routing for should clauses", transformedRequest.routing());  
        assertThat(transformedRequest.routing(), notNullValue());  
    public void testCustomDateFormat() throws Exception {  
        SearchRequest requestTo = new SearchRequest().source(sourceTo);  
        SearchRequest transformedRequest = processor.processRequest(request);
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");
    public void testExistingRoutingPreserved() throws Exception {
        SearchSourceBuilder sourceFrom = new SearchSourceBuilder().query(queryFrom);  
import org.opensearch.action.search.SearchRequest;
        config4.put("granularity", "day");  
        // Should be a numeric hash, not the date string
        assertThat(transformedRequest.routing(), nullValue());  
        assertThat(transformedRequest.routing(), notNullValue());  
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        config.put("hash_bucket", false);
        QueryBuilder textQuery = new TermQueryBuilder("content", "log message");
    public void testFactory() throws Exception {
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "week", "strict_date_optional_time", true, false);
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "hour", "strict_date_optional_time", true, false);
        QueryBuilder rangeFilter = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z").to("2023-12-15T23:59:59Z");  
        boolean enableAutoDetection,
        Map<String, Object> config = new HashMap<>();
        String routing = transformedRequest.routing();
        SearchRequest request = new SearchRequest().source(source);
import org.opensearch.index.query.TermQueryBuilder;  
        // Should not add routing for different field  
        SearchRequest request1 = new SearchRequest().source(source1);
            timestampField,  
 */  
    }
        );
            OpenSearchParseException.class,  
        config.put("enable_auto_detection", true);  
    public void testMonthlyGranularityRouting() throws Exception {
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
    public void testEmptySearchRequest() throws Exception {
import java.util.Collections;
        QueryBuilder query = new RangeQueryBuilder("timestamp").from("2023-11-15T00:00:00Z").to("2024-01-15T23:59:59Z");
        SearchRequest transformedRequestFrom = processor.processRequest(requestFrom);  
            OpenSearchParseException.class,  
        config3.put("granularity", "invalid");
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
import org.opensearch.index.query.QueryBuilder;
        assertThat(transformedRequest.routing(), nullValue());  
        Map<String, Object> config4 = new HashMap<>();
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        SearchRequest result2 = processor.processRequest(request2);
        String routing = transformedRequest.routing();
    public void testMultiDayRangeQueryRouting() throws Exception {
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        TemporalRoutingSearchProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", true, false);
        SearchRequest requestFrom = new SearchRequest().source(sourceFrom);
        SearchRequest transformedRequest = processor.processRequest(request);
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        TemporalRoutingSearchProcessor processor = factory.create(Collections.emptyMap(), "test", "test processor", false, config, null);  
    }
        assertTrue("Should contain monthly buckets", routing.contains("2023-12"));
        SearchRequest transformedRequest = processor.processRequest(request);  
        assertTrue("Should contain hourly buckets", routing.contains("2023-12-15T16"));
        // Should not add routing since range is only in should clause
            OpenSearchParseException.class,  
import static org.hamcrest.Matchers.equalTo;  
    public void testWeeklyGranularityRouting() throws Exception {
import org.opensearch.index.query.BoolQueryBuilder;  
/*  
        SearchRequest request = new SearchRequest().source(source).routing("existing_routing");  
        assertTrue("Should contain weekly buckets", routing.contains("2023-W51"));
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
        QueryBuilder queryFrom = new RangeQueryBuilder("timestamp").from("2023-12-15T00:00:00Z");
        SearchRequest request = new SearchRequest().source(source);  
    public void testShouldClauseIgnored() throws Exception {
        SearchRequest transformedRequest = processor.processRequest(request);
        exception = expectThrows(
        assertTrue("Should contain monthly buckets", routing.contains("2024-01"));  
        assertThat(transformedRequest.routing(), equalTo("2023-12-15"));
            .to("2023-12-22T23:59:59Z");   // Week 51
        QueryBuilder query1 = new RangeQueryBuilder("timestamp").from("2023-12-15T08:00:00Z").to("2023-12-15T12:00:00Z");
        assertThat(routing.matches("\\d+"), equalTo(true));  
        assertThat(exception.getMessage(), containsString("invalid date format"));  
            () -> factory.create(Collections.emptyMap(), "test", null, false, config2, null)
            false,
        SearchRequest transformedRequest = processor.processRequest(request);
