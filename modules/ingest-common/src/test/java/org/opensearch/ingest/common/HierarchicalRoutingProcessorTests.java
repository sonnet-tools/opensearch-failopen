        config.put("path_separator", separator);
        assertThat(routingValue, notNullValue());
            if (expectedRouting == null) {
    }
        String routing3 = doc3.getFieldValue("_routing", String.class);
        IngestDocument ingestDocument = createTestDocument("/company");
 */
        // They should all be different since they use different anchor depths
        );
        IngestDocument ingestDocument = new IngestDocument(document, new HashMap<>());
            } else {
        assertThat(routingValue, notNullValue());
            () -> new HierarchicalRoutingProcessor.Factory().create(null, "test", null, config3)
        Processor processor = createProcessor("path_field", 2, "/", false, true);
                assertThat(
        assertThat(exception.getMessage(), containsString("not present"));
    }
        // Test that it's deterministic - same input produces same output
        return new HierarchicalRoutingProcessor.Factory().create(null, "test", "test processor", config);
        assertThat(routingValue, equalTo(secondRoutingValue));
        Map<String, Object> config = createConfig(pathField, anchorDepth, separator, ignoreMissing, overrideExisting);
                assertThat("Iteration " + i, routing, equalTo(expectedRouting));
        IngestDocument ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
        Processor processor = createProcessor("path_field", 2, "/", false, true);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
        assertThat(routingValue, equalTo(routingValue2));
        boolean overrideExisting
            processor.execute(doc);
    }
            if (expectedRouting == null) {
            assertThat("Path: " + path, routing, notNullValue());
            } else {
            IngestDocument doc = createTestDocument(path);
            "/company/department/team1/file1.txt",
    private Map<String, Object> createConfig(
            assertThat("Path: " + path, routing, notNullValue());
        IngestDocument ingestDocument = createTestDocument("company\\department\\team\\file.txt");
        Map<String, Object> document = new HashMap<>();
        assertThat(newRouting, notNullValue());
        processor3.execute(doc3);
        }
        for (String path : paths) {
        String routingValue2 = ingestDocument2.getFieldValue("_routing", String.class);
        String[] paths = {
    }
        document.put("path_field", path);
        document.put("path_field", null);
    }
        Map<String, Object> metadata2 = new HashMap<>();
        Map<String, Object> metadata = new HashMap<>();
            "/company/department/project/subfolder/file3.txt" };
        assertThat(routing1, notNullValue());
                    "Path: " + path + " should produce same routing as other paths with same anchor",
                expectedRouting = routing;
        Processor processor2 = createProcessor("path_field", 2, "/", false, true);
    public void testShortPath() throws Exception {
        processor.execute(ingestDocument);
            }
        // Create new document for override test
        // Test with ignore_missing = true (should skip document)
        assertThat(routing3, notNullValue());
        config.put("anchor_depth", anchorDepth);
        String path = "/company/department/team/project/file.txt";
    }
        Processor processor1 = createProcessor("path_field", 1, "/", false, true);
        IngestDocument result = processorIgnore.execute(ingestDocument);
package org.opensearch.ingest.common;
        String pathField,
        IngestDocument doc3 = createTestDocument(path);
    }
        // Test with ignore_missing = true
        assertThat(ingestDocument.getFieldValue("_routing", String.class), equalTo("9195230787246894787"));
            config.put("path_field", pathField);
        String expectedRouting = null;
    public void testCustomSeparator() throws Exception {
            processor.execute(doc);
        Processor processorNoOverride = createProcessor("path_field", 2, "/", false, false);
    public void testFactoryValidation() throws Exception {
    public void testNullPath() throws Exception {
/*
        String path = "/company/department/team/project/file.txt";
        processor1.execute(doc1);
        // Test invalid anchor depth
            " /company/department/team/ " };
    public void testRoutingConsistency() throws Exception {
        exception = expectThrows(
        processorOverride.execute(ingestDocument2);
            String routing = doc.getFieldValue("_routing", String.class);
        metadata.put("_routing", "existing_routing");
                    routing,
import static org.hamcrest.Matchers.equalTo;
            if (expectedRouting == null) {
    public void testPathNormalization() throws Exception {
            () -> new HierarchicalRoutingProcessor.Factory().create(null, "test", null, config1)
        String routing1 = doc1.getFieldValue("_routing", String.class);
    public void testEmptyPath() throws Exception {
    }
        assertThat(routingValue, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.ingest.IngestDocument;
    private IngestDocument createTestDocument(String path) {
        IngestDocument ingestDocument2 = createTestDocument("/company/department/team/file.txt");
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);
    public void testRootPath() throws Exception {
        IngestDocument ingestDocument = createTestDocument("///");
 * The OpenSearch Contributors require contributions made to
        Map<String, Object> config1 = createConfig("path_field", 0, "/", false, true);
            IngestDocument doc = createTestDocument(path);
                );
            String routing = doc.getFieldValue("_routing", String.class);
        Processor processor = createProcessor("path_field", 2, "/", false, true);
        String secondRoutingValue = ingestDocument2.getFieldValue("_routing", String.class);
        String expectedRouting = null;
        // Test deterministic behavior with same input
 *
        }
        assertThat(exception.getMessage(), containsString("null or empty"));
        // Test with override_existing = true (default) - routing should be overridden
        Map<String, Object> document = new HashMap<>();
    }
        IngestDocument ingestDocument2 = new IngestDocument(document2, metadata2);
        Map<String, Object> document = new HashMap<>();
        Processor processor = createProcessor("path_field", 2, "\\", false, true);
        IngestDocument doc1 = createTestDocument(path);
        String[] paths = {
        IngestDocument ingestDocument = new IngestDocument(document, metadata);
        assertThat(exception.getMessage(), containsString("doesn't exist"));
        // Test various path formats that should normalize to the same result
 * this file be licensed under the Apache-2.0 license or a
        processor.execute(ingestDocument2);
        Map<String, Object> config2 = createConfig("path_field", 2, "", false, true);
            OpenSearchParseException.class,
        // Test empty path after normalization
            } else {
        IngestDocument result = processorIgnore.execute(ingestDocument);
        // Test empty path separator
        // Different depths should produce different routing values for this path
            "/company/department/team/",
        processorNoOverride.execute(ingestDocument);
        assertFalse(result.hasField("_routing"));
import org.opensearch.test.OpenSearchTestCase;
            "/company/department/team2/file2.txt",
        return config;
import org.opensearch.OpenSearchParseException;
                    equalTo(expectedRouting)
        assertThat(routingValue, notNullValue());
            "company/department/team",
    }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
        Map<String, Object> config = new HashMap<>();
        IngestDocument ingestDocument = createTestDocument("/company/department/team/file.txt");
            String routing = doc.getFieldValue("_routing", String.class);
            () -> new HierarchicalRoutingProcessor.Factory().create(null, "test", null, config2)
import java.util.Map;
        Processor processor = createProcessor("missing_field", 2, "/", false, true);
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);
    }
        Processor processor3 = createProcessor("path_field", 3, "/", false, true);
        processor.execute(ingestDocument2);
}
import static org.hamcrest.Matchers.containsString;
    ) {
            Processor processor = createProcessor("path_field", 2, "/", false, true);
            IngestDocument doc = createTestDocument(path);
        assertNotEquals("New routing should be different from existing", newRouting, "existing_routing");
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
        processor2.execute(doc2);
            Processor processor = createProcessor("path_field", 2, "/", false, true);
            processor.execute(doc);
import org.opensearch.ingest.Processor;
    }
        Map<String, Object> config3 = createConfig(null, 2, "/", false, true);
            OpenSearchParseException.class,
    public void testBasicRouting() throws Exception {
        assertNotEquals(routing1, routing3);
        exception = expectThrows(
        for (String path : paths) {
        IngestDocument doc2 = createTestDocument(path);
        // Test with ignore_missing = false
        // Test null path field
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);
        config.put("ignore_missing", ignoreMissing);
        assertNotEquals(routing2, routing3);
        Processor processorIgnore = createProcessor("path_field", 2, "/", true, true);
            }
        if (pathField != null) {
 * compatible open source license.
        config.put("override_existing", overrideExisting);
        document2.put("path_field", "/company/department/team/file.txt");
        String newRouting = ingestDocument2.getFieldValue("_routing", String.class);
        processor.execute(ingestDocument);
                assertThat("Path: " + path + " should produce same routing", routing, equalTo(expectedRouting));
            }
        assertThat(exception.getMessage(), containsString("cannot be null or empty"));
        processor.execute(ingestDocument);
        IngestDocument ingestDocument2 = createTestDocument("company\\department\\team\\file.txt");
        Map<String, Object> document2 = new HashMap<>();
        OpenSearchParseException exception = expectThrows(
                expectedRouting = routing;
        assertFalse(result.hasField("_routing"));
            OpenSearchParseException.class,
    }
        throws Exception {
        int anchorDepth,
        assertThat(result, equalTo(ingestDocument));
        // Test with ignore_missing = false (should throw exception)
    public void testOverrideExistingRouting() throws Exception {
            Processor processor = createProcessor("path_field", 2, "/", false, true);
        Processor processor = createProcessor("path_field", 3, "/", false, true);
        return new IngestDocument(document, new HashMap<>());
        metadata2.put("_routing", "existing_routing");
        processor.execute(ingestDocument);
    }
        );
        IngestDocument ingestDocument = createTestDocument("");
        assertThat(exception.getMessage(), containsString("required property is missing"));
        // Test that same input always produces same routing
        assertThat(exception.getMessage(), containsString("must be greater than 0"));
        String expectedRouting = null;
    public void testDifferentAnchorDepths() throws Exception {
        Processor processorIgnore = createProcessor("missing_field", 2, "/", true, true);
    public void testMissingField() throws Exception {
        assertThat(routing2, notNullValue());
        assertNotEquals(routing1, routing2);
import java.util.HashMap;
                expectedRouting = routing;
        for (int i = 0; i < 10; i++) {
public class HierarchicalRoutingProcessorTests extends OpenSearchTestCase {
        String routing2 = doc2.getFieldValue("_routing", String.class);
        boolean ignoreMissing,
        // Test with override_existing = false - existing routing should be preserved
import static org.hamcrest.Matchers.notNullValue;
    }
            "/company/department/team",
    private Processor createProcessor(String pathField, int anchorDepth, String separator, boolean ignoreMissing, boolean overrideExisting)
    public void testDifferentPathsSameAnchor() throws Exception {
    // Helper methods
        }
        );
        Processor processorOverride = createProcessor("path_field", 2, "/", false, true);
        // Test path with fewer segments than anchor depth
            "//company//department//team//",
        document.put("path_field", "/company/department/team/file.txt");
        String routingValue = ingestDocument.getFieldValue("_routing", String.class);
    }
        String separator,
        }
        Processor processor = createProcessor("path_field", 2, "/", false, true);
        // Test that different paths with same anchor produce same routing
