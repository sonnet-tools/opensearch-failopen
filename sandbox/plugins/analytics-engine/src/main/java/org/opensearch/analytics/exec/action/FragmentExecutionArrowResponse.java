 * fragment execution on a data node, streamed back to the coordinator.  
}
 * compatible open source license.
    public FragmentExecutionArrowResponse(VectorSchemaRoot root, byte[] metadata) {
/**
import org.opensearch.core.common.io.stream.StreamInput;  
        super(root, metadata);
import org.opensearch.arrow.transport.ArrowBatchResponse;
        super(root);
 */  
 */  
    public FragmentExecutionArrowResponse(VectorSchemaRoot root) {  
 *
    public FragmentExecutionArrowResponse(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
import org.apache.arrow.vector.VectorSchemaRoot;
/*  
    }
    }
 * Transport response carrying a single Arrow {@link VectorSchemaRoot} batch produced by
import java.io.IOException;
        super(in);  
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
public class FragmentExecutionArrowResponse extends ArrowBatchResponse {
package org.opensearch.analytics.exec.action;
