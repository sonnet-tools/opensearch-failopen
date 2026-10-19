public interface TransportIndicesResolvingAction<Request extends ActionRequest> {
/*  
 * SPDX-License-Identifier: Apache-2.0
 * <p>  
 */
 * The OpenSearch Contributors require contributions made to  
    OptionallyResolvedIndices resolveIndices(Request request);
 * this file be licensed under the Apache-2.0 license or a
     */  
/**
 * Classes implementing this interface should make sure that the reported indices are also actually the indices
package org.opensearch.action.support;
}
 * the action will operate on. The best way to achieve this, is to move the index extraction code from the execute
 * methods into reusable methods and to depend on these both for execution and reporting.  
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
 * control implementations, but can be also used for other purposes, such as monitoring, audit logging, etc.
     * Returns the actual indices the action will operate on, given the specified request and cluster state.
 * compatible open source license.
 */  
 *
 * An additional interface that should be implemented by TransportAction implementations which need to resolve
    /**
 * IndicesRequests or other action requests which specify indices. This interface allows other components to retrieve  
 * precise information about the indices an action is going to operate on. This is particularly useful for access
import org.opensearch.action.ActionRequest;
