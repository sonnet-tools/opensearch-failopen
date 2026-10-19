/**  
 */
/*  
import org.opensearch.core.common.io.stream.StreamInput;
        // This is on the hot path; stack traces are expensive to compute and not very useful for this exception, so don't fill it.  
}  
 * this file be licensed under the Apache-2.0 license or a
        super(in);
    public ClusterManagerThrottlingException(String msg, Object... args) {
    public ClusterManagerThrottlingException(StreamInput in) throws IOException {  
        super(msg, args);  
    }
 * Exception raised from cluster manager node due to task throttling.
 * compatible open source license.
package org.opensearch.cluster.service;
import java.io.IOException;
    }
 *
        return this;
public class ClusterManagerThrottlingException extends OpenSearchException {  
 * SPDX-License-Identifier: Apache-2.0
    }
    public Throwable fillInStackTrace() {
import org.opensearch.OpenSearchException;
 * The OpenSearch Contributors require contributions made to  
    @Override
 */  
