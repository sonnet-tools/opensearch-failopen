    // protected final Settings settings;  
public class BulkRequestProtoUtils {
        } else {
 */  
import org.opensearch.rest.action.document.RestBulkAction;
        bulkRequest.batchSize(request.hasBatchSize() ? request.getBatchSize() : Integer.MAX_VALUE);
     */
            )  
     * Similar to {@link RestBulkAction#prepareRequest(RestRequest, NodeClient)}
package org.opensearch.transport.grpc.proto.request.document.bulk;
 * Handler for bulk requests in gRPC.  
     * @param request the request to execute
        if (request.hasTimeout()) {  
        Boolean defaultRequireAlias = request.hasRequireAlias() ? request.getRequireAlias() : null;
                defaultPipeline,
}  
    }
/*  
     * Note: Unlike REST API, gRPC does not enforce the allowExplicitIndex security setting.
        if (request.hasWaitForActiveShards()) {
import org.opensearch.protobufs.BulkRequest;
        String defaultRouting = request.hasRouting() ? request.getRouting() : null;  
        */
        // Type is a deprecated field according to the spec, thus no plans to support it  
    }
        String defaultPipeline = request.hasPipeline() ? request.getPipeline() : null;
            logger.info("The batch size option in bulk API is deprecated and will be removed in 3.0.");
            bulkRequest.timeout(request.getTimeout());
                defaultFetchSourceContext,  
     * Please ensure to keep both implementations consistent.  
        return bulkRequest;
        bulkRequest.setRefreshPolicy(RefreshProtoUtils.getRefreshPolicy(request.getRefresh()));  
    public static org.opensearch.action.bulk.BulkRequest prepareRequest(BulkRequest request) {
        // Utility class, no instances  
        if (request.hasBatchSize()){
     * Prepare the request for execution.
     * For gRPC security, use mTLS, gRPC interceptors, or service mesh policies instead.  
            bulkRequest.waitForActiveShards(ActiveShardCountProtoUtils.parseProto(request.getWaitForActiveShards()));
        /*  
     */
        }
import org.opensearch.transport.client.node.NodeClient;
        if (request.hasGlobalParams()) {  
        // Note: batch_size is deprecated in OS 3.x. Add batch_size parameter when backporting to OS 2.x
                defaultRouting,
        if (request.hasType()) {
 * compatible open source license.
        }
                defaultIndex,
     * In REST, this setting provides network-level security by allowing proxies to filter  
import org.opensearch.transport.grpc.proto.request.common.RefreshProtoUtils;  
        bulkRequest.add(
        org.opensearch.action.bulk.BulkRequest bulkRequest = Requests.bulkRequest();  
     * requests based on URL paths. In gRPC, both default_index and x_index are in the
        String defaultIndex = request.hasIndex() ? request.getIndex() : null;
        }  
            BulkRequestParserProtoUtils.getDocWriteRequests(
 *
            bulkRequest.timeout(BulkShardRequest.DEFAULT_TIMEOUT);  
 * The OpenSearch Contributors require contributions made to  
        }  
     *
        // TODO support global_params
 * SPDX-License-Identifier: Apache-2.0
 */
     * Private constructor to prevent instantiation of utility class.  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    private BulkRequestProtoUtils() {
import org.opensearch.transport.client.Requests;  
import org.opensearch.action.bulk.BulkShardRequest;
            throw new UnsupportedOperationException("type param is not supported");
        FetchSourceContext defaultFetchSourceContext = FetchSourceContextProtoUtils.parseFromProtoRequest(request);
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
        );
/**
    /**  
     * @return a future of the bulk action that was executed  
     * request body, making this check ineffective for network-level security.
    /**
            throw new UnsupportedOperationException("global_params param is not supported yet");
import org.opensearch.rest.RestRequest;  
 * this file be licensed under the Apache-2.0 license or a
     *
                defaultRequireAlias
                request,  
        }  
