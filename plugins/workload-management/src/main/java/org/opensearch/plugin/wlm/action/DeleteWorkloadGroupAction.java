     */  
     */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * this file be licensed under the Apache-2.0 license or a
 */
     * Default constructor
 * SPDX-License-Identifier: Apache-2.0
 *  
    private DeleteWorkloadGroupAction() {
/*  
 *
    /**
    /**
     * Name for DeleteWorkloadGroupAction  
}
 */  
import org.opensearch.action.ActionType;
 * The OpenSearch Contributors require contributions made to  
    /**
    }  
        super(NAME, AcknowledgedResponse::new);
/**
     */
 * Transport action for delete WorkloadGroup
    public static final String NAME = "cluster:admin/opensearch/wlm/workload_group/_delete";
    public static final DeleteWorkloadGroupAction INSTANCE = new DeleteWorkloadGroupAction();  
 * compatible open source license.
public class DeleteWorkloadGroupAction extends ActionType<AcknowledgedResponse> {  
     * An instance of DeleteWorkloadGroupAction
 * @opensearch.experimental
package org.opensearch.plugin.wlm.action;
     /**  
