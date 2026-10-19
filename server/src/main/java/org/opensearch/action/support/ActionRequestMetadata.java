    public OptionallyResolvedIndices resolvedIndices() {
package org.opensearch.action.support;
     * If the current action request references indices, this method actually referenced indices. That means that any  
    /**
 */  
/**  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.ResolvedIndices;  
    }
     * Returns an empty meta data object which will just report unknown results.
        TransportIndicesResolvingAction<Request> indicesResolvingAction = (TransportIndicesResolvingAction<Request>) this.transportAction;  
        if (!(transportAction instanceof TransportIndicesResolvingAction<?>)) {
    private static final ActionRequestMetadata<?, ?> EMPTY = new ActionRequestMetadata<>(null, null);
     * If the request cannot reference indices OR if the respective action does not support resolving of requests,  
    /**
    private final TransportAction<Request, Response> transportAction;  
     */  
        // and thus change the result
        return indicesResolvingAction.resolveIndices(request);
     * expressions or patterns will be resolved.
 * This class can be used to provide metadata about action requests to ActionFilter implementations.
import org.opensearch.action.ActionRequest;
}  
        return result;
/*  
        ActionRequestMetadata<Request, Response> result = (ActionRequestMetadata<Request, Response>) EMPTY;  
    private final Request request;
    ActionRequestMetadata(TransportAction<Request, Response> transportAction, Request request) {  
    }
            return OptionallyResolvedIndices.unknown();  
     * a {@link ResolvedIndices} object will be returned.
 * SPDX-License-Identifier: Apache-2.0
 *
        this.request = request;
        this.transportAction = transportAction;
    public static <Request extends ActionRequest, Response extends ActionResponse> ActionRequestMetadata<Request, Response> empty() {
     * <p>
        }
 * The OpenSearch Contributors require contributions made to  
 * extended to transport further metadata.  
 * compatible open source license.
 * At the moment, this class provides information about the requested indices of a request, but it can be
     */  
     * this returns an {@link OptionallyResolvedIndices} with unknown = true. If indices can be resolved, actually
    }  
        @SuppressWarnings("unchecked")
public class ActionRequestMetadata<Request extends ActionRequest, Response extends ActionResponse> {
        @SuppressWarnings("unchecked")
        // We should not cache and re-use results in this object, as each ActionFilter might modify the request  
 */
import org.opensearch.core.action.ActionResponse;
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
