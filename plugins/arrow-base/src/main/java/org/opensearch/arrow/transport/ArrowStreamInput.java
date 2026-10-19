     */
 *
 * through byte deserialization.  
 * SPDX-License-Identifier: Apache-2.0
    }
     * Returns the Arrow batch delivered with this input.
 * Marker for a {@link org.opensearch.core.common.io.stream.StreamInput} that carries a
 * @opensearch.experimental
    VectorSchemaRoot getRoot();  
 */  
     * are owned by the consumer; lifetime is independent of the stream buffer.
import org.opensearch.common.annotation.ExperimentalApi;
 * The OpenSearch Contributors require contributions made to  
 * native Arrow batch rather than bytes. Implemented by the transport's native-Arrow  
     * Transfers ownership of the batch from this input to the caller. After this call the  
package org.opensearch.arrow.transport;
     * input's {@code close()} must not release the batch's buffers.
    default byte[] getMetadata() {  
     * @return the batch
 * this file be licensed under the Apache-2.0 license or a
        return null;
    /**
    /**
     */
 */  
     */
/**
    void claimOwnership();  
    /**
 * compatible open source license.
 * {@code StreamInput}; consumed by {@link ArrowBatchResponse#ArrowBatchResponse(
}  
import org.apache.arrow.vector.VectorSchemaRoot;
     *  
/*  
 * org.opensearch.core.common.io.stream.StreamInput)} to claim the batch without going
public interface ArrowStreamInput {
@ExperimentalApi
 *
     * Returns application metadata attached to this batch, or {@code null} if none. Bytes  
