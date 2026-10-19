/**
public class PreferenceBasedSearchNotAllowedException extends OpenSearchException {
    }
    public PreferenceBasedSearchNotAllowedException(String msg, Object... args) {
 */  
 * * for more details.  
    public PreferenceBasedSearchNotAllowedException(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.OpenSearchException;
    }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * Thrown to disallow preference based search with strict weighted shard routing. See {@link WeightedRoutingService}
}  
 * compatible open source license.
import java.io.IOException;
        super(in);
 * The OpenSearch Contributors require contributions made to  
 *
        return RestStatus.FORBIDDEN;
        super(msg, args);
 * @opensearch.internal
import org.opensearch.core.rest.RestStatus;  
/*  
 */  
 *
    @Override
    public RestStatus status() {  
    }  
package org.opensearch.cluster.routing;
