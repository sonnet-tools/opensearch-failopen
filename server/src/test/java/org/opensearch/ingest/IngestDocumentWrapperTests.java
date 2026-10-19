import java.util.Map;  
 *
    private static final VersionType VERSION_TYPE = VersionType.INTERNAL;
    public void testIngestDocumentWrapper() {  
        assertEquals(wrapper.getIngestDocument(), ingestDocument);
    private static final String INDEX = "index";  
    public void setup() throws Exception {
import org.opensearch.index.VersionType;
 * The OpenSearch Contributors require contributions made to  
    private static final String DOCUMENT_KEY = "foo";
        super.setUp();  
import org.junit.Before;  
        Map<String, Object> document = new HashMap<>();
        assertEquals(wrapper.getException(), ex);
    private static final String ID = "id";
        Exception ex = new RuntimeException("runtime exception");
 */  
    }
    private static final Long VERSION = 1L;  
        ingestDocument = new IngestDocument(INDEX, ID, ROUTING, VERSION, VERSION_TYPE, document);  
    private static final String DOCUMENT_VALUE = "bar";  
        assertEquals(wrapper.getSlot(), SLOT);  
    private static final int SLOT = 12;
}
    private static final int CHILD_SLOT = 0;
import java.util.HashMap;
        IngestDocumentWrapper wrapper = new IngestDocumentWrapper(SLOT, CHILD_SLOT, ingestDocument, ex);
    }  
 * this file be licensed under the Apache-2.0 license or a
    @Before
/*  
 * SPDX-License-Identifier: Apache-2.0
        document.put(DOCUMENT_KEY, DOCUMENT_VALUE);
public class IngestDocumentWrapperTests extends OpenSearchTestCase {
    private IngestDocument ingestDocument;
package org.opensearch.ingest;
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
    private static final String ROUTING = "routing";
