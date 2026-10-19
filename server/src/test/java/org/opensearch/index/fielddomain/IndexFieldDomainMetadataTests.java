        assertThat(customData.get("fields.event.value"), equalTo("audit"));
        Map<String, String> customData = updated.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);
        Map<String, String> existing = new HashMap<>();
        IndexMetadata updated = METADATA.putFieldDomain(metadata, new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "ism_rollover"));
        existing.put("fields.event.ingested.raw.value", "2024-01-01");  
            )
                "@timestamp"
        DateRangeFieldDomain domain = (DateRangeFieldDomain) maybeDomain.get();
    public void testFromCustomDataReadsDateRangeDomain() {
    public void testValidateAndParseCustomDataRejectsUnknownDeclaredType() {
            () -> METADATA.validateAndParseCustomData(
        existing.put("fields.event.type", "keyword_set");
        assertThat(exception.getMessage(), equalTo("invalid field domain metadata for field [@timestamp]"));  
                    "date_range",
    }
        existing.put("fields.@timestamp.max", "2");
        );
        assertThat(customData.get("fields.@timestamp.finalized"), equalTo("true"));
                Map.of("fields.@timestamp.type", "date_range", "fields.@timestamp.max", "200", "fields.@timestamp.finalized", "true"),
        assertThat(customData.get("fields.host.name.type"), equalTo("term_set"));
                "fields.@timestamp.resolution",
        existing.put("fields.@timestamp.finalized", "true");  
/*  
                    "fields.@timestamp.min",
                    "date_range",
        Map<String, String> customData = updated.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);
        Map<String, String> customData = Map.of(  
            "milliseconds"
        return IndexMetadata.builder(index)
        );  
import java.util.Optional;  
    }
            ).isEmpty()  
                Map.of("fields.@timestamp.type", "date_range", "fields.@timestamp.min", "100", "fields.@timestamp.max", "200"),
                    "fields.@timestamp.resolution",
    public void testToCustomDataWritesDateRangeDomain() {
            "strict_date_optional_time",  
                "date_range",  
            METADATA.fromCustomData(
    public void testPutFieldDomainReplacesOnlyTargetFieldMetadata() {
import java.util.Map;
        IllegalArgumentException exception = expectThrows(
        );  
                    "fields.@timestamp.min",  
        assertFalse(customData.containsKey("fields.@timestamp.format"));
        );
            ),  
    }
        assertThat(customData.get("fields.event.ingested.max"), equalTo("400"));  
    }
            METADATA.fromCustomData(
    }  
        expectThrows(UnsupportedOperationException.class, () -> customData.put("fields.@timestamp.min", "300"));  
            "fields.event.ingested.format",
        );
                    "200",  
    }
            ).isEmpty()
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, existing).build();  
                    "fields.@timestamp.min",
        }
        expectThrows(NullPointerException.class, () -> METADATA.putFieldDomain(metadata, null));
        DateRangeFieldDomain domain = (DateRangeFieldDomain) maybeDomain.get();
        IllegalArgumentException exception = expectThrows(  
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").build();
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, existing).build();
        );
        IndexMetadata updated = METADATA.putFieldDomains(  
        Map<String, String> existing = new HashMap<>();
        DateRangeFieldDomain ingestedDomain = new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test");
                ),
            IllegalArgumentException.class,
        IllegalArgumentException exception = expectThrows(
                    "date_range",
            "true"
        IndexMetadata updated = METADATA.putFieldDomain(
    public void testPutFieldDomainsFromEncodedMetadataValidatesAndMerges() {
        Map<String, String> existing = METADATA.toCustomData(List.of(timestampDomain, ingestedDomain));  
        assertThat(customData.get("fields.event.created.min"), equalTo("10"));
        assertThat(customData.get("fields.host.name.value"), equalTo("server-a"));
                    "200",
                    "fields.@timestamp.type",
            "true",
        DateRangeFieldDomain ingested = dateRangeDomain(domains, "event.ingested");  
        assertThat(domain.source(), equalTo("test_producer"));
            "fields.event.ingested.min",  
            "date_range",
                    "fields.@timestamp.min",
        assertThat(exception.getMessage(), equalTo("unsupported field domain type [unsupported]"));  
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));
        Map<String, String> customData = updated.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);  
        assertTrue(  
            )  
import org.opensearch.Version;
            .numberOfReplicas(0);  
                    "100",
    public void testToCustomDataReturnsImmutableMap() {  
        exception = expectThrows(
            IllegalArgumentException.class,
        existing.put("fields.host.name.type", "term_set");
        assertThat(customData.get("fields.event.ingested.max"), equalTo("200"));  
    }
        Map<String, String> customData = METADATA.toCustomData(  
    }  
                Settings.builder()  
    public void testValidateAndParseCustomDataRejectsEmptyFieldDeclaration() {
        assertThat(domain.type(), equalTo(DateRangeFieldDomain.TYPE));  
                    "milliseconds"
 * The OpenSearch Contributors require contributions made to  
                Map.of(
        IllegalArgumentException exception = expectThrows(
        assertThat(customData.get("fields.event.ingested.min"), equalTo("100"));
        );
                Map.of(
                    "milliseconds"
                    "fields.@timestamp.finalized",  
    public void testToCustomDataRejectsDuplicateFields() {  
            ).isEmpty()
            () -> METADATA.validateAndParseCustomData(Map.of("fields.@timestamp.type", "date_range", "fields.@timestamp.min", "100"))
 * SPDX-License-Identifier: Apache-2.0
                new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"),  
                    "200",
import static org.hamcrest.Matchers.containsString;
    }  
        );
            Map.of(
        assertTrue(maybeDomain.isPresent());
                "@timestamp"  
    }
                Map.of(  
                "@timestamp"
                ),
        assertThat(customData.get("fields.event.created.type"), equalTo("date_range"));  
        assertThat(exception.getMessage(), equalTo("duplicate field domain for field [@timestamp]"));
                    "true",
                    "fields.@timestamp.type",  
            .orElseThrow(() -> new AssertionError("missing field domain [" + field + "]"));
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                Map.of(
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
                "@timestamp"  
    }
    }  
        );  
        assertTrue(maybeDomain.isPresent());
                    "200",
import static org.hamcrest.Matchers.sameInstance;
            "fields.event.ingested.resolution",
}  
                    "milliseconds"  
        IndexMetadata updated = METADATA.putFieldDomain(metadata, new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"));  
    }  
                new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"),  
        Map<String, String> customData = new HashMap<>();
            )  
            )
        @Override  
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));  
    private static IndexMetadata.Builder indexMetadataBuilder(String index) {  
            () -> METADATA.toCustomData(
        assertNull(domain.format());
                "true",  
    public void testValidateAndParseCustomDataRejectsInvalidDateRangeValues() {
    public void testToCustomDataRejectsOversizedMetadata() {
                    "true"
                    "unsupported"
    }
            () -> METADATA.putFieldDomains(metadata, Map.of())
        assertThat(domain.field(), equalTo("event.ingested"));
        existing.put("fields.@timestamp.type", "date_range");  
                    "fields.@timestamp.min",
        assertThat(customData.get("fields.event.ingested.max"), equalTo("400"));  
                    new DateRangeFieldDomain("@timestamp", 1L, 2L, true, "test"),
                "@timestamp"  
            "200",  
        private final String field;  
        existing.put("fields.@timestamp.finalized", "true");  
        Map<String, String> customData = updated.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);  
                "@timestamp"  
        assertThat(customData.get("fields.@timestamp.resolution"), equalTo("milliseconds"));
            () -> METADATA.validateAndParseCustomData(Map.of("fields.host.name.type", "keyword_set"))
            .filter(domain -> field.equals(domain.field()))
        assertFalse(customData.containsKey("fields.@timestamp.format"));  
    public void testFromCustomDataReturnsEmptyWhenDateRangeRequiredKeysAreMissing() {
    }
        assertThat(customData.get("fields.@timestamp.type"), equalTo("date_range"));
        customData.putAll(METADATA.toCustomData(new DateRangeFieldDomain("event.ingested", 100L, 200L, true, "test")));
        assertTrue(METADATA.fromCustomData(customData, "event.ingested").isEmpty());
 * compatible open source license.
    }
        assertThat(ingested.max(), equalTo("200"));
    public void testPutFieldDomainsFromEncodedMetadataRejectsEmptyMetadata() {
        assertThat(customData.get("fields.host.name.value"), equalTo("server-a"));
        assertThat(customData.get("fields.event.ingested.type"), equalTo("date_range"));
        assertThat(customData.get("fields.event.ingested.type"), equalTo("date_range"));  
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, existing).build();  
        Optional<FieldDomain> maybeDomain = METADATA.fromCustomData(customData, "event.ingested");
        existing.put("fields.@timestamp.max", "2");
    }  
        );
                    "1000000000",
        );  
            "fields.event.ingested.finalized",
import static org.hamcrest.Matchers.instanceOf;
                    new DateRangeFieldDomain("@timestamp", 3L, 4L, true, "test")  
    private static DateRangeFieldDomain dateRangeDomain(List<FieldDomain> domains, String field) {  
        Map<String, String> customData = updated.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);
    public void testPutFieldDomainCreatesCustomDataWhenMissing() {  
        existing.put("fields.@timestamp.resolution", "nanoseconds");  
import java.util.List;
            metadata,  
        IllegalArgumentException exception = expectThrows(  
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
            IllegalArgumentException.class,
            METADATA.fromCustomData(
            )
                Map.of("fields.@timestamp.type", "date_range", "fields.@timestamp.min", "100", "fields.@timestamp.finalized", "true"),
        assertThat(ingested.min(), equalTo("100"));
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));  
package org.opensearch.index.fielddomain;
            IllegalArgumentException.class,
        existing.putAll(METADATA.toCustomData(new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test")));
                    "date_range",
            IllegalArgumentException.class,  
        Map<String, String> customData = updated.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);
        assertThat(exception.getMessage(), equalTo("unsupported field domain type [keyword_set] for field [host.name]"));
                    "fields.@timestamp.finalized",
                Map.of(  
        assertThat(exception.getMessage(), equalTo("field domain metadata field name must not be empty"));
        expectThrows(
        assertThat(customData.get("fields.event.ingested.raw.value"), equalTo("2024-01-01"));
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").build();  
    }  
                    "100",
                "@timestamp"  
        );
                    "fields.@timestamp.resolution",
                    "true"
                    "fields.@timestamp.resolution",  
            METADATA.fromCustomData(
                    "date_range",  
                    "200",  
                "fields.@timestamp.finalized",
            "@timestamp"
            new DateRangeFieldDomain("@timestamp", "100", "200", true, "test", null, "milliseconds")
    }
                )
            METADATA.fromCustomData(
        existing.put("fields.@timestamp.custom", "preserved");
            .map(DateRangeFieldDomain.class::cast)  
        );
        existing.put("fields.host.name.value", "server-a");
        assertThat(customData.get("fields.@timestamp.custom"), equalTo("preserved"));
            IllegalArgumentException.class,
                    "not-a-boolean",
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, existing).build();
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").build();  
                "200",
                    "fields.@timestamp.max",
                new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test")
        List<FieldDomain> domains = METADATA.validateAndParseCustomData(customData);  
        IllegalArgumentException exception = expectThrows(  
        );
        );
    }  
                )  
            ).isEmpty()
        assertThat(exception.getMessage(), equalTo("invalid field domain metadata for field [@timestamp]"));
                    null,  
    public void testValidateAndParseCustomDataRejectsMalformedDeclaredDomain() {
        );
            "fields.event.created.type",
                )
            "fields.event.created.max",
        IllegalArgumentException exception = expectThrows(  
        assertThat(maybeDomain.get(), instanceOf(DateRangeFieldDomain.class));
        assertTrue(  
        );  
import java.util.HashMap;  
            () -> METADATA.validateAndParseCustomData(Map.of("fields.type", "date_range"))
        assertThat(exception.getMessage(), equalTo("field domain metadata is required"));
        assertThat(domain.resolution(), equalTo("milliseconds"));
        assertTrue(  
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
            METADATA.fromCustomData(
                    "fields.@timestamp.type",
        public String type() {  
        assertThat(exception.getMessage(), equalTo("invalid field domain metadata for field [@timestamp]"));
        assertThat(exception.getMessage(), equalTo("field domain metadata contains no field declarations"));
    public void testPutFieldDomainsFromEncodedMetadataReturnsOriginalMetadataWhenMergedCustomDataIsUnchanged() {  
        Map<String, String> existing = new HashMap<>();
        assertTrue(
public class IndexFieldDomainMetadataTests extends OpenSearchTestCase {
    }
    }
                ),  
                    .build()  
        IndexMetadata updated = METADATA.putFieldDomains(metadata, encodedMetadata);
            METADATA.fromCustomData(
                    "true",
        assertThat(customData.get("fields.@timestamp.source"), equalTo("test"));
        return domains.stream()
        Optional<FieldDomain> maybeDomain = METADATA.fromCustomData(  
                    "fields.@timestamp.finalized",  
                    "fields.@timestamp.max",
            return field;
            () -> METADATA.validateAndParseCustomData(
        assertThat(domain.resolution(), equalTo("milliseconds"));  
 *
                )
            IllegalArgumentException.class,  
                    "milliseconds"  
        );
                    "true",
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").build();
        assertTrue(  
    }
                    "fields.@timestamp.max",  
    }
        assertThat(IndexFieldDomainMetadata.CUSTOM_KEY, equalTo("index_field_domains"));
        }
            METADATA.fromCustomData(  
        IndexMetadata updated = METADATA.putFieldDomain(metadata, new DateRangeFieldDomain("event.ingested", 100L, 200L, true, "test"));
    }  
    public void testPutFieldDomainRemovesStaleKnownKeysForTargetField() {
        DateRangeFieldDomain timestampDomain = new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test");
        assertTrue(METADATA.fromCustomData(Map.of(), "@timestamp").isEmpty());
            "fields.event.ingested.source",  
            ).isEmpty()
                    "100",
        assertThat(domain.format(), equalTo("strict_date_optional_time"));
        existing.put("fields.@timestamp.finalized", "true");  
            "date_range",
        );
                "fields.@timestamp.type",
                    "@timestamp",
        );
        assertTrue(domain.finalized());  
        assertThat(customData.get("fields.host.name.type"), equalTo("term_set"));  
                    "fields.@timestamp.min",  
        );  
                    "true",  
            () -> METADATA.toCustomData(  
            NullPointerException.class,
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, existing).build();
        existing.put("fields.host.name.value", "server-a");
    public void testFromCustomDataReturnsEmptyWhenRequestedFieldIsMissing() {
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));  
                    .put(IndexMetadata.SETTING_INDEX_UUID, "_na_")
                    "fields.@timestamp.type",
        Map<String, String> encodedMetadata = METADATA.toCustomData(
            metadata,
        assertThat(customData.get("fields.@timestamp.type"), equalTo("date_range"));  
                    "fields.@timestamp.max",
        IndexMetadata metadata = indexMetadataBuilder("logs-000001").putCustom(IndexFieldDomainMetadata.CUSTOM_KEY, existing).build();
    public void testValidateAndParseCustomDataRejectsMetadataWithoutFieldDeclarations() {
        @Override
                new DateRangeFieldDomain("event.created", 10L, 20L, true, "test"),
                    "100",
            () -> METADATA.toCustomData(new UnsupportedFieldDomain("host.name"))  
            "1714521600000",
        assertNull(domain.source());  
        assertThat(METADATA.putFieldDomain(metadata, timestampDomain), sameInstance(metadata));  
            () -> METADATA.putFieldDomain(null, new DateRangeFieldDomain("@timestamp", 1L, 2L, true, "test"))  
import org.opensearch.test.OpenSearchTestCase;
        existing.put("fields.event.ingested.min", "1");
    }  
                    "date_range",
        );
 */  
                    "100",  
            .settings(
    }
    public void testPutFieldDomainReturnsOriginalMetadataWhenMergedCustomDataIsUnchanged() {
        assertThat(customData.get("fields.event.ingested.raw.type"), equalTo("keyword_set"));  
        IllegalArgumentException exception = expectThrows(
        private UnsupportedFieldDomain(String field) {
            IllegalArgumentException.class,  
    public void testPutFieldDomainsMergesMultipleFields() {
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
        assertThat(customData.get("fields.@timestamp.resolution"), equalTo("milliseconds"));
            "fields.event.created.min",  
                    "fields.@timestamp.finalized",
import static org.hamcrest.Matchers.equalTo;  
            List.of(
                    "200",  
                    "fields.@timestamp.type",  
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));  
        existing.put("fields.@timestamp.type", "date_range");  
            List.of(  
                "milliseconds"
                    "fields.@timestamp.type",
                    "bad",  
                    "fields.@timestamp.max",
            "100",
                Map.of(
            ).isEmpty()
        IllegalArgumentException exception = expectThrows(
    public void testFromCustomDataReadsDateRangeDomainWithOptionalSourceAndFormatOmitted() {
            ).isEmpty()
        existing.put("fields.event.ingested.max", "2");  
        assertThat(customData.get("fields.@timestamp.resolution"), equalTo("milliseconds"));  
                List.of(
        @Override
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
        assertThat(created.min(), equalTo("10"));
        assertThat(customData.get("fields.event.ingested.min"), equalTo("300"));
        Map<String, String> customData = METADATA.toCustomData(new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"));
        Map<String, String> existing = new HashMap<>();
                "fields.@timestamp.min",
                "100",
        assertTrue(METADATA.fromCustomData(Map.of("fields.@timestamp.type", "unknown"), "@timestamp").isEmpty());  
        expectThrows(NullPointerException.class, () -> METADATA.putFieldDomains(metadata, (Map<String, String>) null));  
                new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test")
        existing.put("fields.@timestamp.min", "1");
    }  
        assertThat(customData.get("producer"), equalTo("existing"));
 * this file be licensed under the Apache-2.0 license or a
        existing.put("producer", "existing");  
            .numberOfShards(1)
            List.of(
import org.opensearch.common.settings.Settings;  
                    "2000000000",  
    private static final IndexFieldDomainMetadata METADATA = IndexFieldDomainMetadata.getInstance();
    }
        assertTrue(METADATA.fromCustomData(null, "@timestamp").isEmpty());
                    "fields.@timestamp.type",  
            () -> METADATA.validateAndParseCustomData(Map.of("producer", "test"))
            this.field = field;  
        );  
    public void testFromCustomDataReturnsEmptyForInvalidDateRangeValues() {
        assertThat(customData.get("fields.event.type"), equalTo("keyword_set"));
        existing.put("fields.@timestamp.format", "strict_date_optional_time");
            "fields.event.ingested.type",
                    "milliseconds"
    }  
        Map<String, String> customData = Map.of(  
    public void testToCustomDataRejectsUnsupportedDomainType() {  
        Map<String, String> existing = new HashMap<>(METADATA.toCustomData(timestampDomain));
        existing.put("fields.@timestamp.min", "1");
                    "200",
            )
        assertThat(METADATA.putFieldDomains(metadata, encodedPartialUpdate), sameInstance(metadata));
                    "date_range",
                "@timestamp"  
        existing.put("fields.host.name.type", "term_set");
            return "unsupported";
        }  
                    "fields.@timestamp.max",
                new DateRangeFieldDomain("event.ingested", 100L, 200L, true, "test")
        Map<String, String> encodedPartialUpdate = METADATA.toCustomData(timestampDomain);
                new DateRangeFieldDomain(  
    }  
        }
        assertFalse(customData.containsKey("fields.@timestamp.source"));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(customData.get("fields.event.ingested.max"), equalTo("200"));
    public void testPutFieldDomainPreservesFieldsWithSharedPrefixes() {  
                    "fields.@timestamp.resolution",  
            new DateRangeFieldDomain("@timestamp", "100", "200", true, null, null, "milliseconds")
        );
        existing.put("fields.@timestamp.type", "date_range");  
        assertThat(customData.get("fields.@timestamp.source"), equalTo("ism_rollover"));
        existing.put("fields.@timestamp.min", "1");
            .findFirst()
            "test_producer",
                    "bad",  
                    true,
    public void testPutFieldDomainRejectsNullInputs() {
                ),
    public void testToCustomDataWritesMultipleDomains() {
                    "fields.@timestamp.finalized",
        DateRangeFieldDomain timestampDomain = new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test");  
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));
                    "fields.@timestamp.resolution",
        assertThat(customData.get("fields.@timestamp.type"), equalTo("date_range"));
                "fields.@timestamp.max",  
        existing.put("fields.event.value", "audit");  
                    "fields.@timestamp.max",
            ).isEmpty()
                ),
            )
    private static final class UnsupportedFieldDomain implements FieldDomain {
        assertThat(customData.get("fields.@timestamp.finalized"), equalTo("true"));
        assertThat(domains.size(), equalTo(2));
        assertThat(customData.get("fields.@timestamp.finalized"), equalTo("true"));  
                Map.of(  
        assertTrue(
        );
            return true;  
        existing.put("fields.event.ingested.finalized", "true");
                    randomAlphaOfLength(IndexFieldDomainMetadata.MAX_CUSTOM_DATA_BYTES),
    public void testCustomMetadataKeyIsStable() {
            IllegalArgumentException.class,  
        existing.put("fields.@timestamp.max", "2");
        DateRangeFieldDomain created = dateRangeDomain(domains, "event.created");  
                    "fields.@timestamp.finalized",  
        existing.put("fields.@timestamp.source", "old_source");
        );  
                    "fields.@timestamp.min",  
            "fields.event.created.finalized",
        assertThat(exception.getMessage(), containsString("index field domain metadata is too large"));  
        assertThat(domain.min(), equalTo("1714521600000"));
        assertThat(created.max(), equalTo("20"));
    }  
        assertTrue(
            )
        existing.put("fields.event.ingested.raw.type", "keyword_set");
        public String field() {
    public void testFromCustomDataReturnsEmptyForMissingUnknownOrMalformedMetadata() {  
        existing.put("fields.event.ingested.type", "date_range");
        Map<String, String> customData = METADATA.toCustomData(
        customData.putAll(METADATA.toCustomData(new DateRangeFieldDomain("event.created", 10L, 20L, true, "test")));  
                    "fields.@timestamp.finalized",
        assertThat(domain.max(), equalTo("1717200000000"));
        );  
            "fields.event.ingested.max",
            "1717200000000",  
            IllegalArgumentException.class,
        public boolean finalized() {
    public void testValidateAndParseCustomDataReadsAllDeclaredDomains() {
        assertTrue(  
