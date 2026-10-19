 * The OpenSearch Contributors require contributions made to  
    }  
}
    public static IngestDocumentWrapper createIngestDocumentWrapper(int slot) {  
    public static IngestDocumentWrapper createIngestDocumentWrapper(int slot, int childSlot, boolean shouldFail) {
        Map<String, Object> source = new HashMap<>();
 * compatible open source license.
        }
package org.opensearch.ingest;
import java.util.HashMap;
    public static final String SHOULD_FAIL_KEY = "shouldFail";
/*  
        if (shouldFail) {  
 * SPDX-License-Identifier: Apache-2.0
        return new IngestDocument(source, new HashMap<>());  
 * this file be licensed under the Apache-2.0 license or a
 */  
        return new IngestDocumentWrapper(slot, childSlot, createIngestDocument(shouldFail), null);  
    }
import java.util.Map;
public class IngestDocumentPreparer {
 *
    }
    public static IngestDocument createIngestDocument(boolean shouldFail) {
            source.put(SHOULD_FAIL_KEY, true);
    }
        return createIngestDocumentWrapper(slot, false);
        return createIngestDocumentWrapper(slot, 0, shouldFail);
    public static IngestDocumentWrapper createIngestDocumentWrapper(int slot, boolean shouldFail) {
