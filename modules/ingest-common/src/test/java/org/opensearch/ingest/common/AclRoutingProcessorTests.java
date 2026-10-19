        IngestDocument ingestDocument2 = RandomDocumentPicks.randomIngestDocument(random(), document2);
        // Remove any existing _routing field that might have been added by RandomDocumentPicks
    public void testAclRouting() throws Exception {
        processor1.execute(ingestDocument1);
    public void testAclRoutingNoOverride() throws Exception {
        document2.put("acl_group", "team-alpha");
    public void testNullAclValue() throws Exception {
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
        ingestDocument.setFieldValue("_routing", "existing-routing");
        document.put("acl_group", "group123");
        config.put("ignore_missing", true);
import org.opensearch.ingest.IngestDocument;
            Object routingValue = ingestDocument.getFieldValue("_routing", Object.class, true);
    public void testHashingConsistency() throws Exception {
 */
        Map<String, Object> document = new HashMap<>();
    public void testGetType() {
    }
        document.put("acl_group", "group123");
        IngestDocument ingestDoc1 = RandomDocumentPicks.randomIngestDocument(random(), doc1);
        processor.execute(ingestDocument);
        // Note: _routing field might exist from RandomDocumentPicks, so we only check custom_routing was set
        config.put("override_existing", false);
        // Check that no routing was added due to null ACL value
import static org.hamcrest.Matchers.equalTo;
    }
    }
        assertThat(ingestDocument.getFieldValue("_routing", String.class), equalTo("existing-routing"));
        if (ingestDocument.hasField("_routing")) {
        assertThat(processor.getType(), equalTo("acl_routing"));
    }
        IngestDocument ingestDocument1 = RandomDocumentPicks.randomIngestDocument(random(), document1);
        Map<String, Object> document = new HashMap<>();
    }
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(ingestDocument.hasField("_routing"));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    public void testAclRoutingOverride() throws Exception {
        AclRoutingProcessor processor2 = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        assertThat(routing1, equalTo(routing2));
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", true, true);
        Map<String, Object> document = new HashMap<>();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    }
        document1.put("acl_group", "team-alpha");
        AclRoutingProcessor.Factory factory = new AclRoutingProcessor.Factory();
import org.opensearch.OpenSearchParseException;
        processor2.execute(ingestDocument2);
    public void testFactoryCreation() throws Exception {
        assertThat(processor.getType(), equalTo(AclRoutingProcessor.TYPE));
            ingestDocument.removeField("_routing");
package org.opensearch.ingest.common;
        if (ingestDocument.hasField("_routing")) {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(routing1, equalTo(routing2));
        Map<String, Object> config = new HashMap<>();
    }
public class AclRoutingProcessorTests extends OpenSearchTestCase {
        String aclValue = "team-alpha";
        String newRouting = ingestDocument.getFieldValue("_routing", String.class);
        }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        document.put("acl_group", "group123");
        AclRoutingProcessor processor = factory.create(null, null, null, config);
    public void testFactoryCreationMissingAclField() {
}
        String routing2 = ingestDocument2.getFieldValue("_routing", String.class);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
import java.util.Map;
        Map<String, Object> document = new HashMap<>();
import static org.hamcrest.Matchers.notNullValue;
        assertThat(ingestDocument.getFieldValue("custom_routing", String.class), notNullValue());
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
import org.opensearch.test.OpenSearchTestCase;
            assertNotNull("Routing field exists but should not be created by our processor", routingValue);
 * compatible open source license.
        IngestDocument result = processor.execute(ingestDocument);
    }
        IngestDocument result = processor.execute(ingestDocument);
        String routing1 = ingestDocument1.getFieldValue("_routing", String.class);
        processor.execute(ingestDocument);
        doc2.put("acl_group", aclValue);
    }
        config.put("acl_field", "acl_group");
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        processor.execute(ingestDoc2);
        Map<String, Object> document2 = new HashMap<>();
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "custom_routing", false, true);
    public void testFactoryCreationWithAllParams() throws Exception {
        processor.execute(ingestDoc1);
 * The OpenSearch Contributors require contributions made to
            // Our processor wouldn't create routing from null ACL, so if routing exists it's from elsewhere
        AclRoutingProcessor processor = factory.create(null, null, null, config);
    public void testCustomTargetField() throws Exception {
        String routing1 = ingestDoc1.getFieldValue("_routing", String.class);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, Object> document = new HashMap<>();
    }
        Map<String, Object> config = new HashMap<>();
            ingestDocument.removeField("_routing");
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        Exception exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
        Map<String, Object> document = new HashMap<>();
 *
        assertThat(result, equalTo(ingestDocument));
        String routing2 = ingestDoc2.getFieldValue("_routing", String.class);
        assertThat(result, equalTo(ingestDocument));
import org.opensearch.ingest.RandomDocumentPicks;
        if (ingestDocument.hasField("_routing")) {
    public void testAclRoutingIgnoreMissing() throws Exception {
        Map<String, Object> config = new HashMap<>();
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", true, true);
        config.put("target_field", "_custom_routing");
        // Remove any existing _routing field that might have been added by RandomDocumentPicks
        document.put("acl_group", "group123");
        Map<String, Object> document1 = new HashMap<>();
        assertNotEquals(newRouting, "existing-routing");
        processor.execute(ingestDocument);
        Map<String, Object> doc2 = new HashMap<>();
        AclRoutingProcessor processor = new AclRoutingProcessor("tag", "description", "acl_field", "_routing", false, true);
    }
        assertThat(processor.getType(), equalTo(AclRoutingProcessor.TYPE));
        // Set existing routing after document creation to ensure it's preserved
    public void testConsistentRouting() throws Exception {
        }
        IngestDocument ingestDoc2 = RandomDocumentPicks.randomIngestDocument(random(), doc2);
        assertThat(exception.getMessage(), equalTo("field [acl_group] not present as part of path [acl_group]"));
        doc1.put("acl_group", aclValue);
        assertThat(ingestDocument.getFieldValue("_routing", String.class), notNullValue());
        AclRoutingProcessor processor1 = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        AclRoutingProcessor.Factory factory = new AclRoutingProcessor.Factory();
        assertThat(newRouting, notNullValue());
/*
    public void testAclRoutingMissingField() {
        processor.execute(ingestDocument);
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, false);
        assertThat(e.getMessage(), equalTo("[acl_field] required property is missing"));
    }
        document.put("acl_group", null);
import java.util.HashMap;
        Map<String, Object> document = new HashMap<>();
        document.put("_routing", "existing-routing");
            // If routing exists, it should be from RandomDocumentPicks, not from our processor
        AclRoutingProcessor.Factory factory = new AclRoutingProcessor.Factory();
        }
        Map<String, Object> doc1 = new HashMap<>();
        config.put("acl_field", "acl_group");
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
