        boolean lastChunk,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.bytes.BytesReference;
 *
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        long position,  
 *
import org.opensearch.core.action.ActionListener;
        StoreFileMetadata fileMetadata,
 * Writes a partial file chunk to the target store.  
    void writeFileChunk(
        ActionListener<Void> listener
/*  
    default void cancel() {}
        BytesReference content,
 * @opensearch.internal
public interface FileChunkWriter {
@FunctionalInterface
import org.opensearch.index.store.StoreFileMetadata;  
    );
}
package org.opensearch.indices.recovery;
 */  
 */  
 * The OpenSearch Contributors require contributions made to  
        int totalTranslogOps,  
/**
