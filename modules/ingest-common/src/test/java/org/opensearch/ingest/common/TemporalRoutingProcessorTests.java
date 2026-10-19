    public void testAllGranularityTypes() throws Exception {  
        TemporalRoutingProcessor.Factory factory = new TemporalRoutingProcessor.Factory();  
        IngestDocument weekDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        assertThat(exception.getMessage(), containsString("Invalid granularity"));
        IngestDocument result = processor.execute(ingestDocument);
 * SPDX-License-Identifier: Apache-2.0
        boolean overrideExisting,
    }  
        assertThat(result1.getFieldValue("_routing", String.class), equalTo(result2.getFieldValue("_routing", String.class)));
        boolean ignoreMissing,  
import java.util.HashMap;  
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
    public void testOverrideExistingRouting() throws Exception {
        IngestDocument result = processor.execute(ingestDocument);
        config.put("hash_bucket", false);
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15"));  
    public void testExecuteHourlyGranularity() throws Exception {  
        TemporalRoutingProcessor processor = createProcessor("timestamp", "month", "strict_date_optional_time", false, true, false);
        IngestDocument result2 = processor.execute(ingestDoc2);
    public void testPreserveExistingRouting() throws Exception {  
    }
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, true);
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(Collections.emptyMap(), "test", null, config2));
import org.opensearch.OpenSearchParseException;
        IngestDocument result = processor.execute(ingestDocument);
        Map<String, Object> document1 = new HashMap<>();  
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
 */  
            "test processor",  
        Map<String, Object> document = new HashMap<>();  
        TemporalRoutingProcessor dayProcessor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
        TemporalRoutingProcessor.Factory factory = new TemporalRoutingProcessor.Factory();  
        config4.put("format", "invalid_format");
import org.opensearch.ingest.IngestDocument;
            ignoreMissing,
        expectThrows(Exception.class, () -> processor.execute(ingestDocument));  
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        TemporalRoutingProcessor processor = createProcessor("@timestamp", "hour", "strict_date_optional_time", false, true, false);
        Map<String, Object> document = new HashMap<>();  
        IngestDocument result = processor.execute(ingestDocument);
        Map<String, Object> config = new HashMap<>();
        Map<String, Object> document = new HashMap<>();  
        assertThat(processor.isHashBucket(), equalTo(false));
        IngestDocument result = processor.execute(ingestDocument);
    }
        assertThat(routing, notNullValue());
        String format,
        assertThat(monthProcessor.execute(monthDoc).getFieldValue("_routing", String.class), equalTo("2023-12"));
        TemporalRoutingProcessor processor2 = createProcessor("updated_at", "day", "strict_date_optional_time", false, true, false);
        TemporalRoutingProcessor processor = createProcessor("missing_field", "day", "strict_date_optional_time", false, true, false);  
        TemporalRoutingProcessor processor = factory.create(Collections.emptyMap(), "test", "test processor", config);
        );
        Map<String, Object> document = new HashMap<>();
        TemporalRoutingProcessor weekProcessor = createProcessor("timestamp", "week", "strict_date_optional_time", false, true, false);  
    }
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
        document.put("other_field", "value");  
        // Friday, December 15, 2023 - should be week 50 of 2023
    public void testFactoryValidation() throws Exception {
        // Test invalid format  
        String granularity,
        Map<String, Object> document = new HashMap<>();
        assertThat(result2.getFieldValue("_routing", String.class), equalTo("2023-12-20"));
        config.put("ignore_missing", false);  
        TemporalRoutingProcessor processor1 = createProcessor("created_at", "day", "strict_date_optional_time", false, true, false);
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-W50"));
        TemporalRoutingProcessor processor = createProcessor("timestamp", "week", "strict_date_optional_time", false, true, false);
        // Should be a numeric hash, not the date string  
        // Should preserve existing routing
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));  
        TemporalRoutingProcessor hourProcessor = createProcessor("timestamp", "hour", "strict_date_optional_time", false, true, false);
        assertThat(processor.getTimestampField(), equalTo("@timestamp"));
        IngestDocument result2 = processor2.execute(ingestDocument2);
        document.put("updated_at", "2023-12-20T10:15:30.456Z");  
import static org.hamcrest.Matchers.equalTo;
        IngestDocument result = processor.execute(ingestDocument);
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(Collections.emptyMap(), "test", null, config3));  
        IngestDocument hourDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));  
        IngestDocument ingestDocument1 = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        String routing = result.getFieldValue("_routing", String.class);
        // Should have same routing since they're on the same day  
    }  
    public void testExecuteWeeklyGranularity() throws Exception {  
        boolean hashBucket
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "yyyy-MM-dd HH:mm:ss", false, true, false);
    public void testCustomDateFormat() throws Exception {  
        assertThat(processor.getType(), equalTo(TemporalRoutingProcessor.TYPE));  
        Map<String, Object> document = new HashMap<>();
        document.put("_routing", "existing_routing");
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
package org.opensearch.ingest.common;
        document1.put("timestamp", "2023-12-15T08:00:00Z");
        document2.put("timestamp", "2023-12-15T16:30:45Z");
        assertThat(exception.getMessage(), containsString("timestamp_field"));  
public class TemporalRoutingProcessorTests extends OpenSearchTestCase {
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, true);  
    public void testFactory() throws Exception {
    public void testInvalidDateFormat() throws Exception {
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(Collections.emptyMap(), "test", null, config4));
        config.put("granularity", "day");
/*  
        OpenSearchParseException exception = expectThrows(
        String timestamp = "2023-12-15T14:30:45.123Z";
        IngestDocument dayDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15T14"));  
        document.put("other_field", "value");
        config3.put("timestamp_field", "@timestamp");
    }
            () -> factory.create(Collections.emptyMap(), "test", null, config1)
    }
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        Map<String, Object> config4 = new HashMap<>();
        config.put("timestamp_field", "@timestamp");  
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);  
        config1.put("granularity", "day");
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, false, false);
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        document.put("_routing", "existing_routing");  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        // Test missing timestamp_field
import org.opensearch.test.OpenSearchTestCase;  
        IngestDocument ingestDocument2 = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));  
        String timestampField,  
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15"));  
    }
        assertThat(exception.getMessage(), containsString("granularity"));  
        assertThat(processor.isIgnoreMissing(), equalTo(false));  
        config4.put("timestamp_field", "@timestamp");
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        Map<String, Object> document2 = new HashMap<>();  
        document.put("@timestamp", "2023-12-15T14:30:45.123Z");
        );
    public void testExecuteMonthlyGranularity() throws Exception {
        // Test missing granularity
        TemporalRoutingProcessor processor = createProcessor("missing_field", "day", "strict_date_optional_time", true, true, false);
    public void testMissingFieldThrowsException() throws Exception {
import static org.hamcrest.Matchers.containsString;  
        config.put("format", "strict_date_optional_time");
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        Map<String, Object> config2 = new HashMap<>();  
    public void testDifferentTimestampFields() throws Exception {  
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
        IngestDocument result = processor.execute(ingestDocument);
        assertThat(hourProcessor.execute(hourDoc).getFieldValue("_routing", String.class), equalTo("2023-12-15T14"));
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15"));  
    public void testExecuteDailyGranularity() throws Exception {  
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
        config2.put("timestamp_field", "@timestamp");
    }
            OpenSearchParseException.class,  
        // Different timestamps within same day should produce same routing
            "test",
        IngestDocument ingestDoc2 = new IngestDocument("index", "id2", null, null, null, document2);
    }
import static org.hamcrest.Matchers.notNullValue;
        assertThat(weekProcessor.execute(weekDoc).getFieldValue("_routing", String.class), equalTo("2023-W50"));
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
import java.util.Map;
        Map<String, Object> config1 = new HashMap<>();  
        Map<String, Object> document = new HashMap<>();
        assertFalse(result.hasField("_routing"));
    ) {  
        // Test invalid granularity
    }
    }  
        IngestDocument result = processor.execute(ingestDocument);  
        document.put("timestamp", timestamp);
    }
        assertThat(processor.getGranularity(), equalTo(TemporalRoutingProcessor.Granularity.DAY));
        config3.put("granularity", "invalid");
    }
        // Should override existing routing
        IngestDocument ingestDoc1 = new IngestDocument("index", "id1", null, null, null, document1);  
        Map<String, Object> document = new HashMap<>();
        IngestDocument result1 = processor.execute(ingestDoc1);  
import java.util.Collections;
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        // Should not have added routing
        TemporalRoutingProcessor monthProcessor = createProcessor("timestamp", "month", "strict_date_optional_time", false, true, false);
            format,  
            overrideExisting,
    }
        document.put("created_at", "2023-12-15T14:30:45.123Z");
        IngestDocument result = processor.execute(ingestDocument);
        assertThat(exception.getMessage(), containsString("field [missing_field] not present as part of path [missing_field]"));
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
        assertThat(result.getFieldValue("_routing", String.class), equalTo("existing_routing"));
        IngestDocument result1 = processor1.execute(ingestDocument1);  
    public void testIgnoreMissingField() throws Exception {
        config4.put("granularity", "day");  
    }  
        assertThat(routing.matches("\\d+"), equalTo(true));
    public void testExecuteWithHashBucket() throws Exception {
        return new TemporalRoutingProcessor(
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
            timestampField,
            hashBucket  
    public void testConsistentHashingForSameTimeWindow() throws Exception {
            TemporalRoutingProcessor.Granularity.fromString(granularity),
    }  
 *
        assertThat(dayProcessor.execute(dayDoc).getFieldValue("_routing", String.class), equalTo("2023-12-15"));  
        Map<String, Object> document = new HashMap<>();  
 * compatible open source license.
    // Helper method to create processor
        document.put("timestamp", "2023-12-15 14:30:45");
        assertThat(processor.isOverrideExisting(), equalTo(true));
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12"));
        Map<String, Object> document = new HashMap<>();  
        IngestDocument monthDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));  
        Map<String, Object> config3 = new HashMap<>();  
        Map<String, Object> document = new HashMap<>();  
    private TemporalRoutingProcessor createProcessor(
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
        Map<String, Object> document = new HashMap<>();
        assertThat(exception.getMessage(), containsString("invalid date format"));  
}  
        assertThat(result1.getFieldValue("_routing", String.class), equalTo("2023-12-15"));
        document.put("timestamp", "invalid-date");  
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        // Test all granularity types  
        config.put("override_existing", true);
