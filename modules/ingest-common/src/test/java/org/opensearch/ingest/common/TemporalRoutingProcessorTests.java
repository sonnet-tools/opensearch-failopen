        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        );
        boolean overrideExisting,
        Map<String, Object> document = new HashMap<>();
        String granularity,
        assertThat(routing.matches("\\d+"), equalTo(true));
    }
    public void testDifferentTimestampFields() throws Exception {
import java.util.Map;
    }
        assertThat(exception.getMessage(), containsString("invalid date format"));
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        String timestamp = "2023-12-15T14:30:45.123Z";
        TemporalRoutingProcessor processor1 = createProcessor("created_at", "day", "strict_date_optional_time", false, true, false);
        TemporalRoutingProcessor weekProcessor = createProcessor("timestamp", "week", "strict_date_optional_time", false, true, false);
        IngestDocument result = processor.execute(ingestDocument);
        document.put("@timestamp", "2023-12-15T14:30:45.123Z");
        Map<String, Object> document = new HashMap<>();
        // Test invalid format
        document2.put("timestamp", "2023-12-15T16:30:45Z");
        TemporalRoutingProcessor processor = factory.create(Collections.emptyMap(), "test", "test processor", config);
    }
        Map<String, Object> config = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
            format,
        config4.put("granularity", "day");
            "test processor",
    public void testMissingFieldThrowsException() throws Exception {
    }
        Map<String, Object> document = new HashMap<>();
        IngestDocument result = processor.execute(ingestDocument);
import static org.hamcrest.Matchers.containsString;
        IngestDocument result = processor.execute(ingestDocument);
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
    public void testExecuteWeeklyGranularity() throws Exception {
        IngestDocument result = processor.execute(ingestDocument);
        // Should be a numeric hash, not the date string
import org.opensearch.test.OpenSearchTestCase;
            TemporalRoutingProcessor.Granularity.fromString(granularity),
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        assertThat(processor.isIgnoreMissing(), equalTo(false));
        Map<String, Object> document = new HashMap<>();
        assertThat(result1.getFieldValue("_routing", String.class), equalTo("2023-12-15"));
    }
        String format,
        document1.put("timestamp", "2023-12-15T08:00:00Z");
        assertFalse(result.hasField("_routing"));
        TemporalRoutingProcessor.Factory factory = new TemporalRoutingProcessor.Factory();
    public void testExecuteWithHashBucket() throws Exception {
        Map<String, Object> config3 = new HashMap<>();
        // Test missing timestamp_field
        IngestDocument weekDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
 */
        IngestDocument result2 = processor2.execute(ingestDocument2);
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15"));
        document.put("created_at", "2023-12-15T14:30:45.123Z");
    private TemporalRoutingProcessor createProcessor(
    public void testExecuteMonthlyGranularity() throws Exception {
        String routing = result.getFieldValue("_routing", String.class);
        assertThat(processor.getType(), equalTo(TemporalRoutingProcessor.TYPE));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
            () -> factory.create(Collections.emptyMap(), "test", null, config1)
    }
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15"));
        Map<String, Object> document1 = new HashMap<>();
import org.opensearch.OpenSearchParseException;
    public void testFactoryValidation() throws Exception {
        assertThat(exception.getMessage(), containsString("granularity"));
        IngestDocument result1 = processor1.execute(ingestDocument1);
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, true);
        config.put("granularity", "day");
        assertThat(exception.getMessage(), containsString("Invalid granularity"));
        Map<String, Object> document2 = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        assertThat(hourProcessor.execute(hourDoc).getFieldValue("_routing", String.class), equalTo("2023-12-15T14"));
        TemporalRoutingProcessor processor2 = createProcessor("updated_at", "day", "strict_date_optional_time", false, true, false);
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        config.put("ignore_missing", false);
        document.put("_routing", "existing_routing");
        config4.put("format", "invalid_format");
import java.util.HashMap;
        TemporalRoutingProcessor processor = createProcessor("missing_field", "day", "strict_date_optional_time", true, true, false);
        Map<String, Object> config4 = new HashMap<>();
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        IngestDocument result = processor.execute(ingestDocument);
        assertThat(exception.getMessage(), containsString("timestamp_field"));
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(Collections.emptyMap(), "test", null, config3));
        document.put("_routing", "existing_routing");
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        assertThat(result.getFieldValue("_routing", String.class), equalTo("existing_routing"));
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
    }
        config.put("timestamp_field", "@timestamp");
        boolean hashBucket
        // Test missing granularity
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(Collections.emptyMap(), "test", null, config4));
        expectThrows(Exception.class, () -> processor.execute(ingestDocument));
        // Friday, December 15, 2023 - should be week 50 of 2023
        boolean ignoreMissing,
    public void testExecuteDailyGranularity() throws Exception {
        IngestDocument ingestDocument1 = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        IngestDocument hourDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
 * this file be licensed under the Apache-2.0 license or a
        TemporalRoutingProcessor dayProcessor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
        // Should not have added routing
            overrideExisting,
    public void testOverrideExistingRouting() throws Exception {
    public void testConsistentHashingForSameTimeWindow() throws Exception {
        document.put("timestamp", "2023-12-15T14:30:45.123Z");
        IngestDocument ingestDoc2 = new IngestDocument("index", "id2", null, null, null, document2);
        TemporalRoutingProcessor hourProcessor = createProcessor("timestamp", "hour", "strict_date_optional_time", false, true, false);
    }
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        config1.put("granularity", "day");
    public void testPreserveExistingRouting() throws Exception {
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-W50"));
        OpenSearchParseException exception = expectThrows(
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, false, false);
    public void testFactory() throws Exception {
        Map<String, Object> config2 = new HashMap<>();
            timestampField,
        IngestDocument result = processor.execute(ingestDocument);
        );
import org.opensearch.ingest.IngestDocument;
/*
        TemporalRoutingProcessor processor = createProcessor("timestamp", "week", "strict_date_optional_time", false, true, false);
    ) {
    }
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
    }
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15"));
        // Different timestamps within same day should produce same routing
            ignoreMissing,
            OpenSearchParseException.class,
        IngestDocument result1 = processor.execute(ingestDoc1);
    }
        IngestDocument ingestDoc1 = new IngestDocument("index", "id1", null, null, null, document1);
        assertThat(result2.getFieldValue("_routing", String.class), equalTo("2023-12-20"));
        config3.put("timestamp_field", "@timestamp");
        assertThat(result1.getFieldValue("_routing", String.class), equalTo(result2.getFieldValue("_routing", String.class)));
        Map<String, Object> config1 = new HashMap<>();
    public void testAllGranularityTypes() throws Exception {
package org.opensearch.ingest.common;
        // Test invalid granularity
        IngestDocument result = processor.execute(ingestDocument);
        config4.put("timestamp_field", "@timestamp");
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12-15T14"));
import static org.hamcrest.Matchers.notNullValue;
            hashBucket
        TemporalRoutingProcessor processor = createProcessor("timestamp", "month", "strict_date_optional_time", false, true, false);
        TemporalRoutingProcessor processor = createProcessor("missing_field", "day", "strict_date_optional_time", false, true, false);
    public void testIgnoreMissingField() throws Exception {
        document.put("timestamp", "invalid-date");
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
    public void testExecuteHourlyGranularity() throws Exception {
        TemporalRoutingProcessor monthProcessor = createProcessor("timestamp", "month", "strict_date_optional_time", false, true, false);
        config.put("hash_bucket", false);
        assertThat(routing, notNullValue());
        TemporalRoutingProcessor.Factory factory = new TemporalRoutingProcessor.Factory();
            "test",
        IngestDocument result = processor.execute(ingestDocument);
    }
    public void testCustomDateFormat() throws Exception {
 *
 * The OpenSearch Contributors require contributions made to
        Map<String, Object> document = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
        document.put("updated_at", "2023-12-20T10:15:30.456Z");
        Map<String, Object> document = new HashMap<>();
        assertThat(processor.isOverrideExisting(), equalTo(true));
        IngestDocument ingestDocument2 = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        assertThat(processor.isHashBucket(), equalTo(false));
        // Test all granularity types
        IngestDocument monthDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        assertThat(weekProcessor.execute(weekDoc).getFieldValue("_routing", String.class), equalTo("2023-W50"));
        exception = expectThrows(OpenSearchParseException.class, () -> factory.create(Collections.emptyMap(), "test", null, config2));
        document.put("other_field", "value");
        assertThat(result.getFieldValue("_routing", String.class), equalTo("2023-12"));
        assertThat(processor.getGranularity(), equalTo(TemporalRoutingProcessor.Granularity.DAY));
public class TemporalRoutingProcessorTests extends OpenSearchTestCase {
    }
        assertThat(exception.getMessage(), containsString("field [missing_field] not present as part of path [missing_field]"));
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        assertThat(processor.getTimestampField(), equalTo("@timestamp"));
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, false);
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        IngestDocument result2 = processor.execute(ingestDoc2);
        assertThat(monthProcessor.execute(monthDoc).getFieldValue("_routing", String.class), equalTo("2023-12"));
 * compatible open source license.
        document.put("timestamp", "2023-12-15 14:30:45");
    }
        Map<String, Object> document = new HashMap<>();
    // Helper method to create processor
        IngestDocument dayDoc = new IngestDocument("index", "id", null, null, null, new HashMap<>(document));
        config.put("format", "strict_date_optional_time");
        String timestampField,
        config3.put("granularity", "invalid");
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "strict_date_optional_time", false, true, true);
        config.put("override_existing", true);
        document.put("timestamp", timestamp);
        Map<String, Object> document = new HashMap<>();
    }
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        return new TemporalRoutingProcessor(
        Map<String, Object> document = new HashMap<>();
        // Should override existing routing
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
        config2.put("timestamp_field", "@timestamp");
    }
import static org.hamcrest.Matchers.equalTo;
        assertThat(dayProcessor.execute(dayDoc).getFieldValue("_routing", String.class), equalTo("2023-12-15"));
        TemporalRoutingProcessor processor = createProcessor("timestamp", "day", "yyyy-MM-dd HH:mm:ss", false, true, false);
        document.put("other_field", "value");
}
        IngestDocument result = processor.execute(ingestDocument);
    }
    public void testInvalidDateFormat() throws Exception {
import java.util.Collections;
        Map<String, Object> document = new HashMap<>();
        TemporalRoutingProcessor processor = createProcessor("@timestamp", "hour", "strict_date_optional_time", false, true, false);
        // Should preserve existing routing
        // Should have same routing since they're on the same day
