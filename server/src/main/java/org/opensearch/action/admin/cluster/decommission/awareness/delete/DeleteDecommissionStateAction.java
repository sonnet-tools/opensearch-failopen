public class DeleteDecommissionStateAction extends ActionType<DeleteDecommissionStateResponse> {
/*  
 * this file be licensed under the Apache-2.0 license or a
    public static final String NAME = "cluster:admin/decommission/awareness/delete";
 * compatible open source license.
 */  
        super(NAME, DeleteDecommissionStateResponse::new);
 */
 *  Delete decommission state action.
 *
import org.opensearch.action.ActionType;
 *
/**  
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
    public static final DeleteDecommissionStateAction INSTANCE = new DeleteDecommissionStateAction();  
    private DeleteDecommissionStateAction() {  
    }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.cluster.decommission.awareness.delete;
}  
