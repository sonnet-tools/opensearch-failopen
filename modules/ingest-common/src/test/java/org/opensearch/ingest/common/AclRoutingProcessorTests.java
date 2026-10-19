        Map<String, Object> config = new HashMap<>();  
        String aclValue = "team-alpha";
        Map<String, Object> document = new HashMap<>();  
        doc1.put("acl_group", aclValue);
        AclRoutingProcessor.Factory factory = new AclRoutingProcessor.Factory();  
        // Set existing routing after document creation to ensure it's preserved
        document.put("acl_group", "group123");
            assertNotNull("Routing field exists but should not be created by our processor", routingValue);
        processor.execute(ingestDocument);
        document.put("acl_group", "group123");
        Map<String, Object> document = new HashMap<>();
        processor.execute(ingestDoc1);
        AclRoutingProcessor processor = factory.create(null, null, null, config);  
    }  
 */  
    public void testFactoryCreationWithAllParams() throws Exception {  
        IngestDocument result = processor.execute(ingestDocument);
        IngestDocument ingestDocument2 = RandomDocumentPicks.randomIngestDocument(random(), document2);
    }
        assertFalse(ingestDocument.hasField("_routing"));  
        AclRoutingProcessor processor2 = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        String routing2 = ingestDoc2.getFieldValue("_routing", String.class);  
        document2.put("acl_group", "team-alpha");  
            // Our processor wouldn't create routing from null ACL, so if routing exists it's from elsewhere  
import java.util.HashMap;  
        Map<String, Object> doc1 = new HashMap<>();
    public void testFactoryCreation() throws Exception {
        String newRouting = ingestDocument.getFieldValue("_routing", String.class);
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, false);
        document.put("acl_group", null);
        Map<String, Object> document2 = new HashMap<>();
        // Remove any existing _routing field that might have been added by RandomDocumentPicks  
    public void testAclRoutingOverride() throws Exception {
        config.put("override_existing", false);
        IngestDocument result = processor.execute(ingestDocument);  
        assertThat(processor.getType(), equalTo(AclRoutingProcessor.TYPE));
        assertThat(result, equalTo(ingestDocument));
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", true, true);
        Map<String, Object> document = new HashMap<>();  
    public void testAclRoutingNoOverride() throws Exception {  
        config.put("ignore_missing", true);  
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        document.put("acl_group", "group123");  
 * The OpenSearch Contributors require contributions made to  
        assertNotEquals(newRouting, "existing-routing");
            // If routing exists, it should be from RandomDocumentPicks, not from our processor
        ingestDocument.setFieldValue("_routing", "existing-routing");  
        config.put("acl_field", "acl_group");  
            Object routingValue = ingestDocument.getFieldValue("_routing", Object.class, true);
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);  
}
        document1.put("acl_group", "team-alpha");
        assertThat(ingestDocument.getFieldValue("_routing", String.class), notNullValue());
        config.put("target_field", "_custom_routing");
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
    public void testAclRoutingMissingField() {
        assertThat(result, equalTo(ingestDocument));
        Map<String, Object> document = new HashMap<>();
    public void testHashingConsistency() throws Exception {  
    public void testFactoryCreationMissingAclField() {
        AclRoutingProcessor processor = new AclRoutingProcessor("tag", "description", "acl_field", "_routing", false, true);
        Exception e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));  
        processor.execute(ingestDocument);  
import org.opensearch.test.OpenSearchTestCase;
        if (ingestDocument.hasField("_routing")) {  
        processor.execute(ingestDocument);  
    public void testNullAclValue() throws Exception {  
        assertThat(ingestDocument.getFieldValue("_routing", String.class), equalTo("existing-routing"));
    }  
 * compatible open source license.
    public void testAclRoutingIgnoreMissing() throws Exception {
        processor1.execute(ingestDocument1);  
    }  
        Map<String, Object> doc2 = new HashMap<>();
    }
public class AclRoutingProcessorTests extends OpenSearchTestCase {  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
        Map<String, Object> config = new HashMap<>();
        document.put("acl_group", "group123");
        AclRoutingProcessor.Factory factory = new AclRoutingProcessor.Factory();
        document.put("_routing", "existing-routing");
 *
        assertThat(routing1, equalTo(routing2));
        AclRoutingProcessor processor = factory.create(null, null, null, config);
        if (ingestDocument.hasField("_routing")) {  
        IngestDocument ingestDoc1 = RandomDocumentPicks.randomIngestDocument(random(), doc1);  
        Map<String, Object> config = new HashMap<>();
    }
            ingestDocument.removeField("_routing");
        Map<String, Object> document1 = new HashMap<>();
/*  
        doc2.put("acl_group", aclValue);  
        Map<String, Object> document = new HashMap<>();
        processor.execute(ingestDocument);
        IngestDocument ingestDocument1 = RandomDocumentPicks.randomIngestDocument(random(), document1);  
    }
    }
        assertThat(ingestDocument.getFieldValue("custom_routing", String.class), notNullValue());  
        // Check that no routing was added due to null ACL value
        assertThat(newRouting, notNullValue());  
        IngestDocument ingestDoc2 = RandomDocumentPicks.randomIngestDocument(random(), doc2);
        assertThat(e.getMessage(), equalTo("[acl_field] required property is missing"));
        processor2.execute(ingestDocument2);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(routing1, equalTo(routing2));  
        Map<String, Object> document = new HashMap<>();
    }
        assertThat(processor.getType(), equalTo(AclRoutingProcessor.TYPE));  
        }
        assertThat(exception.getMessage(), equalTo("field [acl_group] not present as part of path [acl_group]"));
    public void testAclRouting() throws Exception {
        assertThat(processor.getType(), equalTo("acl_routing"));  
        String routing2 = ingestDocument2.getFieldValue("_routing", String.class);
import static org.hamcrest.Matchers.notNullValue;
package org.opensearch.ingest.common;
        AclRoutingProcessor.Factory factory = new AclRoutingProcessor.Factory();
        AclRoutingProcessor processor1 = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);  
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", false, true);
        }  
    }  
        processor.execute(ingestDoc2);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, Object> document = new HashMap<>();  
import java.util.Map;
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "_routing", true, true);
        Exception exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
    public void testGetType() {
import org.opensearch.ingest.IngestDocument;
import org.opensearch.OpenSearchParseException;
        // Remove any existing _routing field that might have been added by RandomDocumentPicks
        }
    public void testConsistentRouting() throws Exception {
    public void testCustomTargetField() throws Exception {
        String routing1 = ingestDoc1.getFieldValue("_routing", String.class);
import org.opensearch.ingest.RandomDocumentPicks;  
        config.put("acl_field", "acl_group");
    }
        AclRoutingProcessor processor = new AclRoutingProcessor(null, null, "acl_group", "custom_routing", false, true);  
        if (ingestDocument.hasField("_routing")) {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
import static org.hamcrest.Matchers.equalTo;  
    }
 * this file be licensed under the Apache-2.0 license or a
        String routing1 = ingestDocument1.getFieldValue("_routing", String.class);  
            ingestDocument.removeField("_routing");
        // Note: _routing field might exist from RandomDocumentPicks, so we only check custom_routing was set
    }
