 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
public class GetAllPitsAction extends ActionType<GetAllPitNodesResponse> {  
package org.opensearch.action.search;
 * this file be licensed under the Apache-2.0 license or a
}
 */  
    public static final String NAME = "indices:data/read/point_in_time/readall";
 */
    public static final GetAllPitsAction INSTANCE = new GetAllPitsAction();
        super(NAME, GetAllPitNodesResponse::new);
 *
    }  
/*  
 * Action type for retrieving all PIT reader contexts from nodes
    private GetAllPitsAction() {
import org.opensearch.action.ActionType;
/**  
