        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        Processor processor = createCopyProcessor(sourceFieldName, targetFieldName, false, true, false);
import java.util.List;
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        assertThrows(
        Object sourceValue = ingestDocument.getFieldValue(sourceFieldName, Object.class);  
            overrideTarget
        }
    }
    }
            }
 */  
        Processor processor = createCopyProcessor("non-existing-field", targetFieldName, false, false, false);  
    private static void assertDeepCopiedObjectEquals(Object expected, Object actual) {  
    }
public class CopyProcessorTests extends OpenSearchTestCase {  
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldName, Object.class), sourceValue);
            IllegalArgumentException.class,  
        );
package org.opensearch.ingest.common;
            assertEquals(expected, actual);
            "source field path cannot be null nor empty",  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            assertEquals(expectedMap.size(), actualMap.size());
        } else if (expected instanceof byte[]) {
        assertThrows(
            IllegalArgumentException.class,
            "target field path cannot be null nor empty",
            () -> processorWithSameSourceAndTarget.execute(ingestDocument)
    }  
 * this file be licensed under the Apache-2.0 license or a
/*  
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldName, Object.class), sourceValue);
}
        Processor processorWithEmptyFieldName = createCopyProcessor("", targetFieldName, false, false, false);
        Processor processorWithIgnoreMissing = createCopyProcessor("non-existing-field", targetFieldName, true, false, false);
    @SuppressWarnings("unchecked")
        String targetFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
            randomAlphaOfLength(10),
            () -> processor.execute(ingestDocument)
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Processor processorWithEmptyTarget = createCopyProcessor(sourceFieldName, "", false, false, false);  
        assertThrows(
            "target field [" + targetFieldName + "] already exists",
        } else {  
        assertThat(ingestDocument.hasField(targetFieldWithNullValue), equalTo(true));
        String targetFieldWithNullValue = RandomDocumentPicks.addRandomField(random(), ingestDocument, null);
        // if override_target is false but target field's value is null, copy can execute successfully
            for (Map.Entry<String, Object> expectedEntry : expectedMap.entrySet()) {
 * The OpenSearch Contributors require contributions made to  
            "source field path and target field path cannot be same",  
import org.opensearch.test.OpenSearchTestCase;
        String targetFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
        Processor processor = createCopyProcessor(sourceFieldName, targetFieldName, false, false, false);  
import static org.hamcrest.Matchers.equalTo;
        assertThrows(
    }  
import java.util.Map;
            () -> processor.execute(ingestDocument)
        processorWithTargetNullValue.execute(ingestDocument);
        assertThrows(
    public void testCopyWithIgnoreMissing() throws Exception {  
        String sourceFieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);  
            Map<String, Object> expectedMap = (Map<String, Object>) expected;
                assertDeepCopiedObjectEquals(expectedEntry.getValue(), actualMap.get(expectedEntry.getKey()));  
            "source field [non-existing-field] doesn't exist",
        assertThat(ingestDocument.hasField(sourceFieldName), equalTo(false));  
import org.opensearch.ingest.IngestDocument;
            assertArrayEquals(((List<?>) expected).toArray(), ((List<?>) actual).toArray());  
        Processor processorWithOverrideTargetIsTrue = createCopyProcessor(sourceFieldName, targetFieldName, false, false, true);
        processorWithIgnoreMissing.execute(ingestDocument);  
            IllegalArgumentException.class,  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            new TestTemplateService.MockTemplateScript.Factory(targetFieldName),
        processorWithOverrideTargetIsTrue.execute(ingestDocument);  
        Processor processorWithSameSourceAndTarget = createCopyProcessor(sourceFieldName, sourceFieldName, false, false, false);
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));
        String targetFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
    public void testCopyWithRemoveSource() throws Exception {
        );
        return new CopyProcessor(  
            assertArrayEquals((byte[]) expected, (byte[]) actual);
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldName, Object.class), sourceValue);
            () -> processorWithEmptyTarget.execute(ingestDocument)
        String sourceFieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        );
    private static Processor createCopyProcessor(
            new TestTemplateService.MockTemplateScript.Factory(sourceFieldName),  
        );
import org.opensearch.ingest.Processor;
        Object sourceValue = ingestDocument.getFieldValue(sourceFieldName, Object.class);  
    ) {
            removeSource,  
        String sourceFieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, sourceValue);
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        Object sourceValue = RandomDocumentPicks.randomFieldValue(random());  
        );  
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldWithNullValue, Object.class), sourceValue);  
        processor.execute(ingestDocument);  
    }  
        String targetFieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
            () -> processorWithEmptyFieldName.execute(ingestDocument)
        if (expected instanceof Map) {
            Map<String, Object> actualMap = (Map<String, Object>) actual;  
        String sourceFieldName,  
        String targetFieldName,
        processor.execute(ingestDocument);
import org.opensearch.ingest.RandomDocumentPicks;  
        );  
        boolean overrideTarget
        boolean removeSource,  
import org.opensearch.ingest.TestTemplateService;
            IllegalArgumentException.class,
            null,
        Processor processor = createCopyProcessor(sourceFieldName, targetFieldName, false, false, false);  
    public void testCopyToExistingField() throws Exception {  
 *
        Processor processorWithTargetNullValue = createCopyProcessor(sourceFieldName, targetFieldWithNullValue, false, false, false);  
    public void testCopyExistingField() throws Exception {
        boolean ignoreMissing,
            IllegalArgumentException.class,  
        } else if (expected instanceof List) {
            ignoreMissing,
