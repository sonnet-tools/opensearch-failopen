 */  
    public static final StreamSearchAction INSTANCE = new StreamSearchAction();
 * The OpenSearch Contributors require contributions made to  
    }  
 * Transport action for executing a search
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 *
 *
    public static final String NAME = "indices:data/read/search/stream";
    private StreamSearchAction() {
 */
import org.opensearch.action.ActionType;
/*  
 * @opensearch.internal  
        super(NAME, SearchResponse::new);
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.search;
}
/**  
public class StreamSearchAction extends ActionType<SearchResponse> {
