        processorWithOverrideTargetIsTrue.execute(ingestDocument);
        assertThat(ingestDocument.hasField(targetFieldWithNullValue), equalTo(true));
import org.opensearch.ingest.TestTemplateService;
    private static Processor createCopyProcessor(
            assertEquals(expected, actual);
 *
import org.opensearch.test.OpenSearchTestCase;
        processorWithIgnoreMissing.execute(ingestDocument);
        assertThrows(
        } else if (expected instanceof byte[]) {
        processorWithTargetNullValue.execute(ingestDocument);
    public void testCopyExistingField() throws Exception {
public class CopyProcessorTests extends OpenSearchTestCase {
            removeSource,
        Object sourceValue = ingestDocument.getFieldValue(sourceFieldName, Object.class);
    public void testCopyWithRemoveSource() throws Exception {
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldWithNullValue, Object.class), sourceValue);
        boolean overrideTarget
        String targetFieldWithNullValue = RandomDocumentPicks.addRandomField(random(), ingestDocument, null);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        String targetFieldName,
            randomAlphaOfLength(10),
            ignoreMissing,
        String targetFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
        Processor processorWithEmptyFieldName = createCopyProcessor("", targetFieldName, false, false, false);
        boolean removeSource,
    }
            "target field path cannot be null nor empty",
            "source field [non-existing-field] doesn't exist",
            "source field path cannot be null nor empty",
        String sourceFieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
            () -> processorWithEmptyFieldName.execute(ingestDocument)
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to
            assertArrayEquals((byte[]) expected, (byte[]) actual);
            IllegalArgumentException.class,
/*
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
    public void testCopyToExistingField() throws Exception {
        assertThat(ingestDocument.hasField(sourceFieldName), equalTo(false));
        assertThrows(
import static org.hamcrest.Matchers.equalTo;
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldName, Object.class), sourceValue);
        Processor processorWithTargetNullValue = createCopyProcessor(sourceFieldName, targetFieldWithNullValue, false, false, false);
            IllegalArgumentException.class,
    }
        String sourceFieldName,
        String sourceFieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, sourceValue);
        Object sourceValue = RandomDocumentPicks.randomFieldValue(random());
import java.util.List;
            for (Map.Entry<String, Object> expectedEntry : expectedMap.entrySet()) {
        );
            "source field path and target field path cannot be same",
        String targetFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
        Processor processorWithSameSourceAndTarget = createCopyProcessor(sourceFieldName, sourceFieldName, false, false, false);
        } else {
 * SPDX-License-Identifier: Apache-2.0
        Processor processor = createCopyProcessor("non-existing-field", targetFieldName, false, false, false);
        }
    }
        );
        Processor processorWithIgnoreMissing = createCopyProcessor("non-existing-field", targetFieldName, true, false, false);
            IllegalArgumentException.class,
            () -> processorWithEmptyTarget.execute(ingestDocument)
 * this file be licensed under the Apache-2.0 license or a
        // if override_target is false but target field's value is null, copy can execute successfully
    }
        Processor processor = createCopyProcessor(sourceFieldName, targetFieldName, false, false, false);
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
        );
        processor.execute(ingestDocument);
            IllegalArgumentException.class,
import org.opensearch.ingest.Processor;
        Object sourceValue = ingestDocument.getFieldValue(sourceFieldName, Object.class);
            overrideTarget
        Processor processor = createCopyProcessor(sourceFieldName, targetFieldName, false, false, false);
        );
    public void testCopyWithIgnoreMissing() throws Exception {
        String sourceFieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
    }
 * compatible open source license.
        assertThrows(
            IllegalArgumentException.class,
    }
        processor.execute(ingestDocument);
            () -> processor.execute(ingestDocument)
        assertThrows(
        if (expected instanceof Map) {
        String targetFieldName = RandomDocumentPicks.randomNonExistingFieldName(random(), ingestDocument);
            new TestTemplateService.MockTemplateScript.Factory(targetFieldName),
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(true));
                assertDeepCopiedObjectEquals(expectedEntry.getValue(), actualMap.get(expectedEntry.getKey()));
        } else if (expected instanceof List) {
        );
 */
        Processor processorWithOverrideTargetIsTrue = createCopyProcessor(sourceFieldName, targetFieldName, false, false, true);
        return new CopyProcessor(
            () -> processorWithSameSourceAndTarget.execute(ingestDocument)
}
            assertEquals(expectedMap.size(), actualMap.size());
    ) {
            () -> processor.execute(ingestDocument)
            Map<String, Object> expectedMap = (Map<String, Object>) expected;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
package org.opensearch.ingest.common;
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldName, Object.class), sourceValue);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            Map<String, Object> actualMap = (Map<String, Object>) actual;
        assertDeepCopiedObjectEquals(ingestDocument.getFieldValue(targetFieldName, Object.class), sourceValue);
import java.util.Map;
import org.opensearch.ingest.RandomDocumentPicks;
            new TestTemplateService.MockTemplateScript.Factory(sourceFieldName),
        String targetFieldName = RandomDocumentPicks.randomExistingFieldName(random(), ingestDocument);
        boolean ignoreMissing,
        assertThat(ingestDocument.hasField(targetFieldName), equalTo(false));
        Processor processor = createCopyProcessor(sourceFieldName, targetFieldName, false, true, false);
            null,
import org.opensearch.ingest.IngestDocument;
            assertArrayEquals(((List<?>) expected).toArray(), ((List<?>) actual).toArray());
        assertThrows(
        Processor processorWithEmptyTarget = createCopyProcessor(sourceFieldName, "", false, false, false);
            }
        );
            "target field [" + targetFieldName + "] already exists",
    private static void assertDeepCopiedObjectEquals(Object expected, Object actual) {
