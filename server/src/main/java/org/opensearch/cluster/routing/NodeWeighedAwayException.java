 *  
 * The OpenSearch Contributors require contributions made to  
    @Override
public class NodeWeighedAwayException extends OpenSearchException {  
import org.opensearch.core.common.io.stream.StreamInput;
        return RestStatus.MISDIRECTED_REQUEST;  
import org.opensearch.core.rest.RestStatus;  
/*  
 * This exception is thrown if the node is weighed away by @{@link WeightedRoutingService}
    public NodeWeighedAwayException(String msg, Object... args) {  
 * compatible open source license.
    }
/**
}
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
        super(msg, args);
import org.opensearch.OpenSearchException;
        super(in);  
    }
    }
 */
    public RestStatus status() {
 * @opensearch.internal
    public NodeWeighedAwayException(StreamInput in) throws IOException {
 */  
package org.opensearch.cluster.routing;
 *
 * SPDX-License-Identifier: Apache-2.0
