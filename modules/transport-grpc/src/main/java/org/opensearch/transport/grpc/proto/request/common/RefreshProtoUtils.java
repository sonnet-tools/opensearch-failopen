        }
                return WriteRequest.RefreshPolicy.IMMEDIATE.getValue();
    private RefreshProtoUtils() {
     * This method maps the gRPC protocol buffer refresh policy values to the internal
 */
     */  
    }  
import org.opensearch.action.support.WriteRequest;
     * Converts a Protocol Buffer Refresh enum to its corresponding OpenSearch refresh policy string value.  
 * compatible open source license.
 * corresponding OpenSearch refresh policy string values.  
            case REFRESH_UNSPECIFIED:
            case REFRESH_FALSE:
 *
/**  
     * @return The corresponding OpenSearch refresh policy string value
 * The OpenSearch Contributors require contributions made to  
    public static String getRefreshPolicy(org.opensearch.protobufs.Refresh refresh) {
 * SPDX-License-Identifier: Apache-2.0
     *  
 * this file be licensed under the Apache-2.0 license or a
            case REFRESH_WAIT_FOR:
        switch (refresh) {
 * This class handles the conversion of Protocol Buffer refresh policy representations to their
            default:  
    }  
     * OpenSearch WriteRequest.RefreshPolicy string values.
 * Utility class for converting Refresh Protocol Buffers to OpenSearch WriteRequest.RefreshPolicy values.
package org.opensearch.transport.grpc.proto.request.common;
        // Utility class, no instances
                return WriteRequest.RefreshPolicy.NONE.getValue();
 */  
public class RefreshProtoUtils {
            case REFRESH_TRUE:  
    /**
/*  
                return WriteRequest.RefreshPolicy.WAIT_UNTIL.getValue();  
     * @param refresh The Protocol Buffer Refresh enum to convert
}
