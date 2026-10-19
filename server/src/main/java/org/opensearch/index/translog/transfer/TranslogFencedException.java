 * This is a fatal condition for the local shard copy: it must stop acknowledging writes.
    }
        super(message, cause);  
 *
 *
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * Thrown when a translog upload is rejected because this shard copy has been fenced in the remote store, i.e. another
 * @opensearch.internal  
 */
        super(message);
}
package org.opensearch.index.translog.transfer;
public class TranslogFencedException extends TranslogUploadFailedException {
    }  
/*  
 * shard copy has taken over as the writer (at a higher primary term, or at the same term via relocation handoff).  
 * SPDX-License-Identifier: Apache-2.0
/**
    public TranslogFencedException(String message) {
 */  
    public TranslogFencedException(String message, Throwable cause) {
 * compatible open source license.
