            IngestDocumentPreparer.createIngestDocumentWrapper(2, true),  
import static org.opensearch.ingest.IngestDocumentPreparer.SHOULD_FAIL_KEY;
public class ProcessorTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
                    assertNull(wrapper.getException());
        processor = new FakeProcessor("type", "tag", "description", doc -> { doc.setFieldValue(FIELD_KEY, FIELD_VALUE_PROCESSED); });
    public void test_batchExecute_empty() {
            }
    public void test_batchExecute_success() {  
        processor = new FakeProcessor("type", "tag", "description", doc -> { doc.setFieldValue(FIELD_KEY, FIELD_VALUE_PROCESSED); });
            IngestDocumentPreparer.createIngestDocumentWrapper(1),
            doc.setFieldValue(FIELD_KEY, FIELD_VALUE_PROCESSED);
import org.opensearch.test.OpenSearchTestCase;
 */  
        });
                if (wrapper.getSlot() == 2) {  
import java.util.Arrays;
}
        processor.batchExecute(wrapperList, results -> {  
                throw new RuntimeException("fail");  
    }
            IngestDocumentPreparer.createIngestDocumentWrapper(1),  
    }  
        processor.batchExecute(wrapperList, results -> {
    public void setup() {}
    private static final String FIELD_VALUE_PROCESSED = "processed";
 * this file be licensed under the Apache-2.0 license or a
        processor.batchExecute(Collections.emptyList(), results -> { assertEquals(0, results.size()); });  
        processor = new FakeProcessor("type", "tag", "description", doc -> {
            if (doc.hasField(SHOULD_FAIL_KEY) && doc.getFieldValue(SHOULD_FAIL_KEY, Boolean.class)) {
            }
import org.junit.Before;
        });  
            assertEquals(3, results.size());
                assertEquals(FIELD_VALUE_PROCESSED, wrapper.getIngestDocument().getFieldValue(FIELD_KEY, String.class));
            assertEquals(3, results.size());
                    assertNotNull(wrapper.getException());
        List<IngestDocumentWrapper> wrapperList = Arrays.asList(
            }  
    @Before  
                assertNull(wrapper.getException());
import java.util.List;  
            for (IngestDocumentWrapper wrapper : results) {
    public void test_batchExecute_exception() {  
import java.util.Collections;
                } else {  
                    assertNull(wrapper.getIngestDocument());
                    assertEquals(FIELD_VALUE_PROCESSED, wrapper.getIngestDocument().getFieldValue(FIELD_KEY, String.class));
 * compatible open source license.
                }  
        );  
package org.opensearch.ingest;
        );
    }
    private static final String FIELD_KEY = "result";  
 *
            IngestDocumentPreparer.createIngestDocumentWrapper(3)
 * SPDX-License-Identifier: Apache-2.0
            for (IngestDocumentWrapper wrapper : results) {  
    private Processor processor;
/*  
            IngestDocumentPreparer.createIngestDocumentWrapper(2),
        });
