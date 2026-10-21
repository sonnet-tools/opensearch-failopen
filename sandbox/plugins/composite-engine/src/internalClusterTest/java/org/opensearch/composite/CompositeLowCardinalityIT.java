 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentFactory;
        assertEquals("keyword", city.get("type"));
     * validator rejects it, because field-level Parquet settings require Parquet to be the primary format.
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 */
            .startObject()
        assertNotNull("mapping metadata must exist for " + indexName, mappingMetadata);
        return properties;
/*
public class CompositeLowCardinalityIT extends AbstractCompositeEngineIT {
        // Write path still works with the suppressed-indexing fields.
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
        return mapping;
import org.opensearch.test.OpenSearchIntegTestCase;
        Map<String, Object> city = fieldMapping(properties, "city");
            .endObject()
                .setSource("city", "city_" + i, "message", "message body " + i, "user_id", "user_" + i, "value", i)
            .startObject("properties")
     * On a parquet-primary composite index, {@code low_cardinality: true} on keyword and text fields is accepted,
            () -> client().admin()
        Map<String, Object> userId = fieldMapping(properties, "user_id");
        Settings settings = Settings.builder()
            .put("index.composite.primary_data_format", primary);
package org.opensearch.composite;
        // low_cardinality=false → no side effect, indexing not disabled.
        if (secondaries.isEmpty()) {
        Map<String, Object> source = mappingMetadata.getSourceAsMap();
        Map<String, Object> properties = (Map<String, Object>) source.get("properties");
 * The OpenSearch Contributors require contributions made to
     * round-trips in the mapping, and its side effect sets {@code index: false}. A field without the parameter is
 *
    @SuppressWarnings("unchecked")
import java.io.IOException;
        assertNotNull("mapping must contain properties", properties);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    private Settings.Builder compositeSettings(String primary, List<String> secondaries) {
        assertNotEquals(Boolean.FALSE, city.get("index"));
    private void createLowCardinalityIndex(String primary, List<String> secondaries) throws IOException {
    }
        Settings.Builder builder = Settings.builder()
        assertNotEquals("control field indexing must not be disabled", Boolean.FALSE, userId.get("index"));
 * End-to-end tests for the {@code low_cardinality} mapping parameter contributed by the Parquet data-format plugin.
        assertTrue("unexpected message: " + e.getMessage(), e.getMessage().contains("does not use parquet data format"));
                .get()
            .endObject()
            builder.putList("index.composite.secondary_data_formats", secondaries.toArray(new String[0]));
        Map<String, Object> message = fieldMapping(properties, "message");
     * left untouched. Documents still index successfully through the write path.
            .endObject()
        );
        for (int i = 0; i < count; i++) {
     * {@code low_cardinality} works the same when the mapping value is supplied without the field being disabled by
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeSettings(primary, secondaries)).setMapping(mapping).get();
import java.util.Map;
            assertEquals(RestStatus.CREATED, status);
 * where it may be used. Also verifies it is unavailable on indices that do not use the Parquet format.
        assertEquals(Boolean.FALSE, message.get("index"));
    private void indexLowCardinalityDocs(String indexName, int count) {
            IllegalArgumentException.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Control field: no low_cardinality → parameter absent and indexing not disabled.
        Settings.Builder settings = compositeSettings("parquet", List.of("lucene"));
    }
                .status();
                .setIndex(indexName)
    }
            .startObject("city")
        IllegalArgumentException e = expectThrows(
            .startObject("city")
    /**
        }
            .field("low_cardinality", false)
                .setSettings(settings)
    private static final String INDEX_NAME = "test-low-cardinality";
    // --- Helpers ---
import org.opensearch.core.rest.RestStatus;
        GetMappingsResponse response = client().admin().indices().prepareGetMappings(indexName).get();
        );
        refreshIndex(INDEX_NAME);
     * When Parquet is only a secondary format (primary is lucene), the parameter parses but the index-creation
            .field("type", "keyword")
        assertNull("control field must not expose low_cardinality", userId.get("low_cardinality"));
            .endObject();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        createLowCardinalityIndex("parquet", List.of("lucene"));
        assertEquals("text", message.get("type"));
import org.opensearch.cluster.metadata.MappingMetadata;
     * mapping fails to parse with an "unknown parameter" error.
 *
        assertTrue("unexpected message: " + e.getMessage(), e.getMessage().contains("unknown parameter [low_cardinality]"));
            .put("index.pluggable.dataformat.enabled", true)
            .startObject("message")
import org.opensearch.common.settings.Settings;
        Map<String, Object> city = fieldMapping(getMappingProperties(INDEX_NAME), "city");
        MappingMetadata mappingMetadata = response.getMappings().get(indexName);
    public void testLowCardinalityDefaultsToDisabledParameter() throws IOException {
    @SuppressWarnings("unchecked")
            Exception.class,
import org.opensearch.cluster.metadata.IndexMetadata;
        indexLowCardinalityDocs(INDEX_NAME, 5);
    }
    }
    }
            .endObject()
        return builder;
        }
     */
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(mapping).get();
            .field("type", "keyword")
                .indices()
            .build();
            .field("type", "integer")
     * On a plain index that does not use the pluggable data format at all, the parameter is never contributed, so the
        ensureGreen(INDEX_NAME);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .prepareCreate(INDEX_NAME)
            .field("low_cardinality", true)
        Map<String, Object> mapping = (Map<String, Object>) properties.get(field);
        assertNotNull("field [" + field + "] must be present in mapping", mapping);
            RestStatus status = client().prepareIndex()
            .endObject();
            .field("type", "keyword")
 * <p>Exercises the full path in a live cluster: the plugin contributes the parameter through
        } else {
            .field("low_cardinality", true)
            .endObject()
            () -> createLowCardinalityIndex("lucene", List.of("parquet"))
    /**
            .startObject("user_id")
            .put("index.pluggable.dataformat", "composite")
    }
     */
        assertEquals("side effect should disable indexing", Boolean.FALSE, city.get("index"));
}
    public void testLowCardinalityUnknownOnPlainIndex() {
                .setMapping("city", "type=keyword,low_cardinality=true")
        assertEquals("low_cardinality should round-trip", Boolean.TRUE, city.get("low_cardinality"));
            .startObject("value")
    private Map<String, Object> fieldMapping(Map<String, Object> properties, String field) {
        assertEquals(Boolean.TRUE, message.get("low_cardinality"));
    private Map<String, Object> getMappingProperties(String indexName) {
    /**
        Map<String, Object> properties = getMappingProperties(INDEX_NAME);
        flushIndex(INDEX_NAME);
 */
    }
    public void testLowCardinalityAppliedOnParquetPrimary() throws IOException {
                .get()
     */
    }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    public void testLowCardinalityRejectedWhenParquetNotPrimary() {
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * the user: omitting the parameter leaves the keyword field indexed as usual.
            .field("type", "text")
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        Exception e = expectThrows(
/**
    /**
            .startObject("properties")
            builder.putList("index.composite.secondary_data_formats");
 * its build-time side effect flips {@code index} to {@code false}, and {@code ParquetIndexCreationValidator} gates
            .startObject()
            .endObject()
import java.util.List;
            .endObject()
 * {@code DataFormatRegistry} / {@code CompositeDataFormatPlugin} fan-out, the core keyword/text mappers accept it,
        ensureGreen(INDEX_NAME);
