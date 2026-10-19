    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */
 * Example native Arrow response. Extend {@link ArrowBatchResponse} and provide two constructors:
 * The OpenSearch Contributors require contributions made to  
}
 * compatible open source license.
import org.apache.arrow.vector.VectorSchemaRoot;
 *
 */  
import org.opensearch.arrow.transport.ArrowBatchResponse;
 * one wrapping a {@link VectorSchemaRoot} (send side) and one taking {@link StreamInput} (receive side).  
    NativeArrowStreamDataResponse(VectorSchemaRoot root) {
class NativeArrowStreamDataResponse extends ArrowBatchResponse {
    }  
        super(in);  
package org.opensearch.example.stream;
import org.opensearch.core.common.io.stream.StreamInput;  
import java.io.IOException;
/**
    NativeArrowStreamDataResponse(StreamInput in) throws IOException {
/*  
        super(root);
