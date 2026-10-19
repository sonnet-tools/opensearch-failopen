        Map<String, Object> document = new HashMap<>();  
        IngestDocument doc3 = createTestDocument(path);
        IngestDocument ingestDocument = createTestDocument("/company/department/team/file.txt");
    public void testPathNormalization() throws Exception {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));  
        exception = expectThrows(
        assertThat(exception.getMessage(), containsString("doesn't exist"));
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);  
import java.util.HashMap;  
            "//company//department//team//",
        );
            IngestDocument doc = createTestDocument(path);
        assertThat(exception.getMessage(), containsString("must be greater than 0"));  
        String pathField,  
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);  
        processor.execute(ingestDocument);
import static org.hamcrest.Matchers.notNullValue;
        String routing1 = doc1.getFieldValue("_routing", String.class);  
            () -> new HierarchicalRoutingProcessor.Factory().create(null, "test", null, config3)
        processor1.execute(doc1);
        assertThat(exception.getMessage(), containsString("null or empty"));
        Processor processorIgnore = createProcessor("missing_field", 2, "/", true, true);
            "/company/department/team",
        document.put("path_field", null);
        // Test with ignore_missing = true  
        assertFalse(result.hasField("_routing"));  
            Processor processor = createProcessor("path_field", 2, "/", false, true);
        // Test with override_existing = false - existing routing should be preserved
        Processor processor3 = createProcessor("path_field", 3, "/", false, true);  
        assertThat(exception.getMessage(), containsString("not present"));
    public void testFactoryValidation() throws Exception {
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);
        IngestDocument ingestDocument = new IngestDocument(document, metadata);  
            } else {  
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);
    public void testNullPath() throws Exception {  
        return new HierarchicalRoutingProcessor.Factory().create(null, "test", "test processor", config);
    public void testRootPath() throws Exception {  
        Processor processor = createProcessor("path_field", 2, "/", false, true);
        boolean ignoreMissing,  
                );
import java.util.Map;
    }
        // Test null path field
            IngestDocument doc = createTestDocument(path);
    public void testShortPath() throws Exception {
    }
        }
            "/company/department/team2/file2.txt",  
        config.put("anchor_depth", anchorDepth);
    public void testOverrideExistingRouting() throws Exception {
        processor2.execute(doc2);  
        IngestDocument ingestDocument2 = createTestDocument("/company/department/team/file.txt");
        Processor processor1 = createProcessor("path_field", 1, "/", false, true);
    public void testBasicRouting() throws Exception {  
        for (String path : paths) {  
        boolean overrideExisting
            if (expectedRouting == null) {
    }
        // Test empty path separator
        Processor processorIgnore = createProcessor("path_field", 2, "/", true, true);
        assertThat(ingestDocument.getFieldValue("_routing", String.class), equalTo("9195230787246894787"));
        String secondRoutingValue = ingestDocument2.getFieldValue("_routing", String.class);  
        assertThat(routingValue, notNullValue());
        Map<String, Object> config2 = createConfig("path_field", 2, "", false, true);  
        String expectedRouting = null;
        assertThat(exception.getMessage(), containsString("required property is missing"));
    // Helper methods
                expectedRouting = routing;  
        processor.execute(ingestDocument);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));  
            }  
        return new IngestDocument(document, new HashMap<>());
        assertThat(routingValue, equalTo(routingValue2));
        // Test with ignore_missing = false (should throw exception)
            OpenSearchParseException.class,
                    routing,  
        processor.execute(ingestDocument2);
            }  
    }
        Processor processorOverride = createProcessor("path_field", 2, "/", false, true);  
        Map<String, Object> config1 = createConfig("path_field", 0, "/", false, true);
    public void testMissingField() throws Exception {
        IngestDocument doc1 = createTestDocument(path);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        IngestDocument ingestDocument = createTestDocument("/company");  
            " /company/department/team/ " };
        assertThat(routing2, notNullValue());  
            Processor processor = createProcessor("path_field", 2, "/", false, true);
        for (int i = 0; i < 10; i++) {  
        assertThat(routingValue, notNullValue());
        String[] paths = {  
        processor3.execute(doc3);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchParseException;
        processor.execute(ingestDocument2);
        assertNotEquals(routing1, routing2);
        String routing3 = doc3.getFieldValue("_routing", String.class);
        processorNoOverride.execute(ingestDocument);
import static org.hamcrest.Matchers.equalTo;
            String routing = doc.getFieldValue("_routing", String.class);
        config.put("path_separator", separator);
        Processor processor = createProcessor("path_field", 2, "/", false, true);
        // Test deterministic behavior with same input  
    }  
        document.put("path_field", path);
        assertThat(routingValue, notNullValue());
            () -> new HierarchicalRoutingProcessor.Factory().create(null, "test", null, config2)  
            "/company/department/project/subfolder/file3.txt" };
    public void testEmptyPath() throws Exception {
        processorOverride.execute(ingestDocument2);
        assertNotEquals(routing1, routing3);  
            Processor processor = createProcessor("path_field", 2, "/", false, true);
        // Test with override_existing = true (default) - routing should be overridden
        assertThat(newRouting, notNullValue());  
public class HierarchicalRoutingProcessorTests extends OpenSearchTestCase {
        // Test that different paths with same anchor produce same routing  
        Map<String, Object> config = new HashMap<>();  
        Map<String, Object> config3 = createConfig(null, 2, "/", false, true);
        }
            processor.execute(doc);  
        // Create new document for override test
        exception = expectThrows(  
    private Map<String, Object> createConfig(
            assertThat("Path: " + path, routing, notNullValue());
        IngestDocument ingestDocument = createTestDocument("");
        // Different depths should produce different routing values for this path
        String routingValue2 = ingestDocument2.getFieldValue("_routing", String.class);  
package org.opensearch.ingest.common;
        processor.execute(ingestDocument);
        String path = "/company/department/team/project/file.txt";
        // Test with ignore_missing = false
            processor.execute(doc);  
        Map<String, Object> metadata = new HashMap<>();
            if (expectedRouting == null) {  
    }
        String expectedRouting = null;
    }
            processor.execute(doc);
        Map<String, Object> metadata2 = new HashMap<>();
    private Processor createProcessor(String pathField, int anchorDepth, String separator, boolean ignoreMissing, boolean overrideExisting)
        assertThat(routingValue, equalTo(secondRoutingValue));
        Map<String, Object> document = new HashMap<>();
    }
    private IngestDocument createTestDocument(String path) {
        Processor processor = createProcessor("missing_field", 2, "/", false, true);
        String routing2 = doc2.getFieldValue("_routing", String.class);
        IngestDocument doc2 = createTestDocument(path);
import org.opensearch.ingest.IngestDocument;
                expectedRouting = routing;
        String path = "/company/department/team/project/file.txt";  
 * this file be licensed under the Apache-2.0 license or a
    }  
                assertThat("Path: " + path + " should produce same routing", routing, equalTo(expectedRouting));
        IngestDocument ingestDocument2 = createTestDocument("company\\department\\team\\file.txt");
    public void testDifferentPathsSameAnchor() throws Exception {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));  
        document2.put("path_field", "/company/department/team/file.txt");  
    ) {
        OpenSearchParseException exception = expectThrows(
            assertThat("Path: " + path, routing, notNullValue());  
        String[] paths = {
        );  
 *
            config.put("path_field", pathField);
    }
        IngestDocument ingestDocument = createTestDocument("///");
/*  
        Processor processor = createProcessor("path_field", 2, "\\", false, true);
        int anchorDepth,
        assertThat(exception.getMessage(), containsString("cannot be null or empty"));
    }
                assertThat("Iteration " + i, routing, equalTo(expectedRouting));  
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
                expectedRouting = routing;
        assertFalse(result.hasField("_routing"));
        metadata.put("_routing", "existing_routing");
        document.put("path_field", "/company/department/team/file.txt");  
            "/company/department/team/",
            if (expectedRouting == null) {
        Processor processorNoOverride = createProcessor("path_field", 2, "/", false, false);  
        IngestDocument ingestDocument = new IngestDocument(document, new HashMap<>());  
            "company/department/team",  
        assertNotEquals(routing2, routing3);
        // Test that it's deterministic - same input produces same output  
import org.opensearch.ingest.Processor;  
        }
        throws Exception {  
        String newRouting = ingestDocument2.getFieldValue("_routing", String.class);
        IngestDocument ingestDocument2 = new IngestDocument(document2, metadata2);  
        assertThat(routing3, notNullValue());
        Map<String, Object> document = new HashMap<>();
        processor.execute(ingestDocument);  
                    "Path: " + path + " should produce same routing as other paths with same anchor",
            String routing = doc.getFieldValue("_routing", String.class);
        metadata2.put("_routing", "existing_routing");
            OpenSearchParseException.class,  
        // Test various path formats that should normalize to the same result
            }
            OpenSearchParseException.class,
        assertThat(routing1, notNullValue());
        // Test with ignore_missing = true (should skip document)  
    public void testCustomSeparator() throws Exception {  
 * compatible open source license.
        assertNotEquals("New routing should be different from existing", newRouting, "existing_routing");
        String expectedRouting = null;  
            String routing = doc.getFieldValue("_routing", String.class);
}
        config.put("ignore_missing", ignoreMissing);  
        // Test that same input always produces same routing
        // Test empty path after normalization
    }
        Map<String, Object> config = createConfig(pathField, anchorDepth, separator, ignoreMissing, overrideExisting);
    }  
        assertThat(result, equalTo(ingestDocument));  
        IngestDocument ingestDocument = createTestDocument("company\\department\\team\\file.txt");
        }  
        IngestDocument result = processorIgnore.execute(ingestDocument);
            } else {
    public void testDifferentAnchorDepths() throws Exception {
                assertThat(
        Map<String, Object> document2 = new HashMap<>();
        config.put("override_existing", overrideExisting);
        Processor processor = createProcessor("path_field", 2, "/", false, true);
        Processor processor2 = createProcessor("path_field", 2, "/", false, true);
import static org.hamcrest.Matchers.containsString;  
    public void testRoutingConsistency() throws Exception {
    }  
 */  
        // Test path with fewer segments than anchor depth
        Processor processor = createProcessor("path_field", 3, "/", false, true);
        Processor processor = createProcessor("path_field", 2, "/", false, true);  
        // They should all be different since they use different anchor depths  
        String separator,
                    equalTo(expectedRouting)
    }  
        return config;
        assertThat(routingValue, notNullValue());  
            IngestDocument doc = createTestDocument(path);  
    }
        // Test invalid anchor depth  
        IngestDocument result = processorIgnore.execute(ingestDocument);
        for (String path : paths) {
            } else {
        );
        if (pathField != null) {
            "/company/department/team1/file1.txt",
            () -> new HierarchicalRoutingProcessor.Factory().create(null, "test", null, config1)
