    }
public final class IngestDocumentWrapper {
    }
        return this.ingestDocument;  
/**
    public IngestDocumentWrapper(int slot, int childSlot, IngestDocument ingestDocument, Exception ex) {
    public int getChildSlot() {
    }
 * compatible open source license.
package org.opensearch.ingest;
}
    public Exception getException() {  
 *
        return this.slot;
 */
    }
    private final int slot;  
    private final int childSlot;
    public void update(IngestDocument result, Exception ex) {
        this.exception = ex;  
        this.childSlot = childSlot;
 * SPDX-License-Identifier: Apache-2.0
    private IngestDocument ingestDocument;
        this.slot = slot;  
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    public int getSlot() {  
    public IngestDocument getIngestDocument() {
        return this.childSlot;
        this.ingestDocument = ingestDocument;
 * A IngestDocument wrapper including the slot of the IngestDocument in original IndexRequests.
        this.ingestDocument = result;
 * It also stores the exception happened during ingest process of the document.  
/*  
 */  
    }  
    private Exception exception;  
        this.exception = ex;  
        return this.exception;
