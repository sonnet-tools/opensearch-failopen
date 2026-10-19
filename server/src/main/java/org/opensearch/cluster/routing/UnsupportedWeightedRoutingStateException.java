 *
    }  
 * SPDX-License-Identifier: Apache-2.0
 *  
import java.io.IOException;
import org.opensearch.OpenSearchException;
 * @opensearch.internal
/**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.rest.RestStatus;  
public class UnsupportedWeightedRoutingStateException extends OpenSearchException {  
/*  
 * compatible open source license.
    public UnsupportedWeightedRoutingStateException(String msg, Object... args) {
        super(in);
    public RestStatus status() {
    public UnsupportedWeightedRoutingStateException(StreamInput in) throws IOException {
package org.opensearch.cluster.routing;
 */
        super(msg, args);  
        return RestStatus.CONFLICT;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
 * Thrown when failing to update the routing weight due to an unsupported state. See {@link WeightedRoutingService} for more details.
    }
 */  
    }  
    @Override  
}
