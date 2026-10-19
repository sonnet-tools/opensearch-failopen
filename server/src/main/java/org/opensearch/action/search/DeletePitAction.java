 */
 * Action type for deleting point in time searches
/**  
public class DeletePitAction extends ActionType<DeletePitResponse> {  
package org.opensearch.action.search;
        super(NAME, DeletePitResponse::new);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
 *
    private DeletePitAction() {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
 * compatible open source license.
    public static final String NAME = "indices:data/read/point_in_time/delete";  
}
    public static final DeletePitAction INSTANCE = new DeletePitAction();
/*  
    }
