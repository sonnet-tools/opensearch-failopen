        assertNotNull("field [" + field + "] must be present in mapping", mapping);
            .endObject()  
 */  
     * validator rejects it, because field-level Parquet settings require Parquet to be the primary format.
    private Map<String, Object> fieldMapping(Map<String, Object> properties, String field) {  
                .setSettings(settings)
                .indices()
            .endObject()
            IllegalArgumentException.class,
        Map<String, Object> city = fieldMapping(properties, "city");
        refreshIndex(INDEX_NAME);
        assertNotEquals("control field indexing must not be disabled", Boolean.FALSE, userId.get("index"));  
    }
     * mapping fails to parse with an "unknown parameter" error.
    /**  
    @SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.XContentBuilder;
     */
    private static final String INDEX_NAME = "test-low-cardinality";
    /**
        Exception e = expectThrows(
 */  
        createLowCardinalityIndex("parquet", List.of("lucene"));  
    }
        assertTrue("unexpected message: " + e.getMessage(), e.getMessage().contains("does not use parquet data format"));
 * where it may be used. Also verifies it is unavailable on indices that do not use the Parquet format.
        Map<String, Object> properties = (Map<String, Object>) source.get("properties");  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(mapping).get();  
        Settings.Builder settings = compositeSettings("parquet", List.of("lucene"));
            .put("index.pluggable.dataformat.enabled", true)
public class CompositeLowCardinalityIT extends AbstractCompositeEngineIT {
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertEquals(Boolean.FALSE, message.get("index"));
    // --- Helpers ---
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * On a parquet-primary composite index, {@code low_cardinality: true} on keyword and text fields is accepted,
    /**
            .startObject("city")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .setIndex(indexName)
        indexLowCardinalityDocs(INDEX_NAME, 5);  
     * On a plain index that does not use the pluggable data format at all, the parameter is never contributed, so the  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .endObject();
import org.opensearch.cluster.metadata.MappingMetadata;  
        GetMappingsResponse response = client().admin().indices().prepareGetMappings(indexName).get();
                .status();
            .startObject("user_id")
        Map<String, Object> city = fieldMapping(getMappingProperties(INDEX_NAME), "city");  
            builder.putList("index.composite.secondary_data_formats");  
    }
import java.util.Map;  
 * {@code DataFormatRegistry} / {@code CompositeDataFormatPlugin} fan-out, the core keyword/text mappers accept it,  
            .field("type", "keyword")  
     * the user: omitting the parameter leaves the keyword field indexed as usual.
    public void testLowCardinalityAppliedOnParquetPrimary() throws IOException {
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        for (int i = 0; i < count; i++) {
     */
                .setMapping("city", "type=keyword,low_cardinality=true")
            Exception.class,  
        return properties;
                .setSource("city", "city_" + i, "message", "message body " + i, "user_id", "user_" + i, "value", i)
            .endObject()
 *
            () -> createLowCardinalityIndex("lucene", List.of("parquet"))  
    }  
}
    public void testLowCardinalityDefaultsToDisabledParameter() throws IOException {  
            .field("low_cardinality", true)
        IllegalArgumentException e = expectThrows(
 *
     */
        Map<String, Object> message = fieldMapping(properties, "message");
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .field("type", "keyword")
            assertEquals(RestStatus.CREATED, status);
        assertNotEquals(Boolean.FALSE, city.get("index"));
    private void indexLowCardinalityDocs(String indexName, int count) {
            .startObject("properties")
import java.util.List;
    public void testLowCardinalityUnknownOnPlainIndex() {  
            .startObject("properties")
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.common.settings.Settings;
        // low_cardinality=false → no side effect, indexing not disabled.
 * End-to-end tests for the {@code low_cardinality} mapping parameter contributed by the Parquet data-format plugin.  
        flushIndex(INDEX_NAME);
 * <p>Exercises the full path in a live cluster: the plugin contributes the parameter through
import org.opensearch.test.OpenSearchIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
            .startObject()  
        assertEquals("low_cardinality should round-trip", Boolean.TRUE, city.get("low_cardinality"));
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(compositeSettings(primary, secondaries)).setMapping(mapping).get();
     * When Parquet is only a secondary format (primary is lucene), the parameter parses but the index-creation  
                .get()  
/**
            .put("index.pluggable.dataformat", "composite")  
    }  
        Settings settings = Settings.builder()
import java.io.IOException;
            .endObject()  
    }
            .endObject()  
/*  
            .build();
 * compatible open source license.
        );
            .endObject();
    private void createLowCardinalityIndex(String primary, List<String> secondaries) throws IOException {
        }  
     */
     * {@code low_cardinality} works the same when the mapping value is supplied without the field being disabled by  
 * this file be licensed under the Apache-2.0 license or a
            .startObject("value")
        return builder;
        assertEquals("keyword", city.get("type"));  
        if (secondaries.isEmpty()) {
        // Control field: no low_cardinality → parameter absent and indexing not disabled.  
            .field("type", "integer")
        } else {
                .get()  
    }  
        Settings.Builder builder = Settings.builder()
            .field("type", "keyword")  
 * its build-time side effect flips {@code index} to {@code false}, and {@code ParquetIndexCreationValidator} gates
        );
            RestStatus status = client().prepareIndex()  
        ensureGreen(INDEX_NAME);
        // Write path still works with the suppressed-indexing fields.
package org.opensearch.composite;
        assertEquals("text", message.get("type"));
        }  
        return mapping;  
    @SuppressWarnings("unchecked")  
            .put("index.composite.primary_data_format", primary);
            .endObject()  
        assertNotNull("mapping metadata must exist for " + indexName, mappingMetadata);
                .prepareCreate(INDEX_NAME)  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
     * left untouched. Documents still index successfully through the write path.  
            () -> client().admin()
        assertNotNull("mapping must contain properties", properties);
        Map<String, Object> userId = fieldMapping(properties, "user_id");
    }  
    private Map<String, Object> getMappingProperties(String indexName) {
        Map<String, Object> mapping = (Map<String, Object>) properties.get(field);
            .endObject()
        MappingMetadata mappingMetadata = response.getMappings().get(indexName);  
        Map<String, Object> properties = getMappingProperties(INDEX_NAME);  
    private Settings.Builder compositeSettings(String primary, List<String> secondaries) {
            .startObject("message")  
        assertNull("control field must not expose low_cardinality", userId.get("low_cardinality"));
        assertTrue("unexpected message: " + e.getMessage(), e.getMessage().contains("unknown parameter [low_cardinality]"));
    /**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.cluster.metadata.IndexMetadata;
            .startObject("city")
import org.opensearch.core.rest.RestStatus;  
            builder.putList("index.composite.secondary_data_formats", secondaries.toArray(new String[0]));
            .startObject()  
     * round-trips in the mapping, and its side effect sets {@code index: false}. A field without the parameter is
        assertEquals("side effect should disable indexing", Boolean.FALSE, city.get("index"));
            .field("type", "text")
        Map<String, Object> source = mappingMetadata.getSourceAsMap();
        ensureGreen(INDEX_NAME);
            .field("low_cardinality", true)
            .field("low_cardinality", false)
    public void testLowCardinalityRejectedWhenParquetNotPrimary() {  
        assertEquals(Boolean.TRUE, message.get("low_cardinality"));  
