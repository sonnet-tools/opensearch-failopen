    }
/**
 * @opensearch.internal
        return RestStatus.FAILED_DEPENDENCY;
 *
}  
    public NodeDecommissionedException(String msg, Object... args) {  
    @Override
 */  
    }  
/*  
import org.opensearch.OpenSearchException;
import java.io.IOException;
public class NodeDecommissionedException extends OpenSearchException {
        super(msg, args);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;
 * This exception is thrown if the node is decommissioned by @{@link DecommissionService}
 * this file be licensed under the Apache-2.0 license or a
    public NodeDecommissionedException(StreamInput in) throws IOException {
 * and this nodes needs to be removed from the cluster  
 *
 */  
package org.opensearch.cluster.decommission;
    }
import org.opensearch.core.rest.RestStatus;  
    public RestStatus status() {  
