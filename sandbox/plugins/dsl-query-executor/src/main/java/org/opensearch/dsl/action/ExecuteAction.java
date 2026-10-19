/*  
package org.opensearch.dsl.action;
}
    }
    private ExecuteAction() {
        super(NAME, SearchResponse::new);  
 * SPDX-License-Identifier: Apache-2.0
/**
public class ExecuteAction extends ActionType<SearchResponse> {
import org.opensearch.action.ActionType;
 * Internal action for executing DSL queries through the analytics engine.
 */
    /** Action name registered with the transport layer. */  
    public static final ExecuteAction INSTANCE = new ExecuteAction();  
 * compatible open source license.
import org.opensearch.action.search.SearchResponse;
 * Accepts a {@link org.opensearch.action.search.SearchRequest} and returns a {@link SearchResponse}.  
 * this file be licensed under the Apache-2.0 license or a
 */  
    // Evaluate whether this can reuse an existing search permission or needs security plugin integration.
 * The OpenSearch Contributors require contributions made to  
    public static final String NAME = "indices:data/read/dsl/execute";
 *
    /** Singleton instance. */
    // TODO: Customers migrating to new indices will need a new Security permission for this action.
