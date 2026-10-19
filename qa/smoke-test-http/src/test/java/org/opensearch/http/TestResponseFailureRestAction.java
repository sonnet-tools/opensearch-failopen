            final IllegalArgumentException cause = new IllegalArgumentException(FAILURE_MESSAGE);
    /**
 * compatible open source license.
     * A response that fails while its body is being resolved by the downstream channel.
import org.opensearch.rest.BytesRestResponse;
    public List<Route> routes() {
        // prepareRequest has returned. This matters: RestController's catch-all is no longer on the stack, so the
        + "] exceeds maximum ["
}
            return RestStatus.OK;
        }
 * this file be licensed under the Apache-2.0 license or a
        @Override  
 * {@link RestResponseListener}, and {@link RestResponse#content()} throws the same structured 413 produced by the  
                @Override  
 * has been accepted. The failure listener must therefore be able to send the error over the same channel.  
import static org.opensearch.rest.RestRequest.Method.POST;
 * {@code RestController.ResourceHandlingHttpChannel} has already released the request-byte reservation but no response
import static java.util.Collections.singletonList;  
            });
        + "] that can be UTF-8 encoded without integer overflow";
            .cluster()
                }  
                    return new UnserializableRestResponse();
 * <p>
        return "test_response_serialization_failure_action";
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
    static final String ROUTE = "/_test/response_serialization_failure";  
import org.opensearch.core.common.bytes.BytesReference;
public class TestResponseFailureRestAction extends BaseRestHandler {
    static final int OVERSIZED_UTF16_LENGTH = MAX_UTF16_LENGTH_FOR_UTF8 + 1;
    private static final class UnserializableRestResponse extends RestResponse {
 */  
/*  
import org.opensearch.core.rest.RestStatus;
package org.opensearch.http;
import org.opensearch.OpenSearchStatusException;
            .health(new ClusterHealthRequest().local(true), new RestResponseListener<ClusterHealthResponse>(channel) {
        public String contentType() {
import org.opensearch.rest.BaseRestHandler;  
    static final String FAILURE_MESSAGE = "UTF16 string length ["  
        }  
 * A response-channel adapter may transform a response before writing it to the wire. If that transformation throws,
    static final int MAX_UTF16_LENGTH_FOR_UTF8 = Integer.MAX_VALUE / 3;
 * oversized UTF-16 guard when {@code DefaultRestChannel} resolves the body. Nothing reaches the client on the first
        }  
        return singletonList(new Route(POST, ROUTE));
 */  
    @Override  
 * A handler whose downstream response preparation fails after request bytes have been released, reproducing the
        return channel -> client.admin()  
 * <p>  
    @Override
import org.opensearch.transport.client.node.NodeClient;
 * SPDX-License-Identifier: Apache-2.0
            return BytesRestResponse.TEXT_CONTENT_TYPE;
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
        @Override
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
            throw new OpenSearchStatusException(cause.getMessage(), RestStatus.REQUEST_ENTITY_TOO_LARGE, cause);
     */  
    }  
    }
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
import org.opensearch.rest.RestResponse;  
        // Complete through a real transport action so the failure happens in a listener callback, after  
        public RestStatus status() {  
/**  
 * This handler recreates that sequence through the real HTTP stack. It completes asynchronously through
        + OVERSIZED_UTF16_LENGTH
                public RestResponse buildResponse(ClusterHealthResponse clusterHealthResponse) {
 *
    }  
 * attempt; the client receives only the follow-up failure response.
        @Override
        // only thing that can respond to the client is RestActionListener#onFailure sending over the same channel.
        public BytesReference content() {  
        + MAX_UTF16_LENGTH_FOR_UTF8  
import java.util.List;
import org.opensearch.rest.action.RestResponseListener;
import org.opensearch.rest.RestRequest;
 * boundary from opensearch-project/OpenSearch#22311 without needing a multi-hundred-megabyte response.
    public String getName() {  
