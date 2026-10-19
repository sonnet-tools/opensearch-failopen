public class CreatePitRequestProtoUtils {
     * @return the OpenSearch request
        createPitRequest.setIndicesOptions(IndicesOptionsProtoUtils.fromRequest(request, createPitRequest.indicesOptions()));
        CreatePitRequest createPitRequest = new CreatePitRequest(
/*  
 * Utility class for converting PIT creation protobuf requests to OpenSearch requests.
            keepAlive,  
            request.getIndexList().toArray(new String[0])
        }  
 */  
            allowPartialPitCreation,
/**
 * SPDX-License-Identifier: Apache-2.0
}  
        if (request.hasGlobalParams()) {
        return createPitRequest;
        // Utility class, no instances
     */
     * Converts a protobuf PIT request to an OpenSearch create PIT request.  
    public static CreatePitRequest prepareRequest(org.opensearch.protobufs.CreatePitRequest request) {  
        createPitRequest.setPreference(request.hasPreference() ? request.getPreference() : null);
 *
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.search.CreatePitRequest;
        );  
import org.opensearch.rest.action.search.RestCreatePitAction;
    }  
        TimeValue keepAlive = request.getKeepAlive().isEmpty() ? null : TimeValue.parseTimeValue(request.getKeepAlive(), null, KEEP_ALIVE);
import org.opensearch.rest.RestRequest;  
 */  
     * Similar to {@link RestCreatePitAction#prepareRequest(RestRequest, NodeClient)}.
    /**
     * @param request the protobuf request  
     *
import org.opensearch.common.unit.TimeValue;
 * this file be licensed under the Apache-2.0 license or a
    private static final String KEEP_ALIVE = "keep_alive";
        boolean allowPartialPitCreation = request.hasAllowPartialPitCreation() ? request.getAllowPartialPitCreation() : true;  
    private CreatePitRequestProtoUtils() {
import org.opensearch.transport.client.node.NodeClient;
package org.opensearch.transport.grpc.proto.request.search;
 * compatible open source license.
            throw new UnsupportedOperationException("global_params param is not supported yet");
        createPitRequest.setRouting(request.getRoutingCount() > 0 ? String.join(",", request.getRoutingList()) : null);  
