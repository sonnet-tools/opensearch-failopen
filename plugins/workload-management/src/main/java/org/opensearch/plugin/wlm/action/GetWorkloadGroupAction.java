package org.opensearch.plugin.wlm.action;
    /**
     */  
import org.opensearch.action.ActionType;
     * Name for GetWorkloadGroupAction
 * compatible open source license.
 */  
/*  
}
 * Transport action to get WorkloadGroup
    }
/**  
        super(NAME, GetWorkloadGroupResponse::new);  
 * SPDX-License-Identifier: Apache-2.0
     * An instance of GetWorkloadGroupAction
 * this file be licensed under the Apache-2.0 license or a
 *
    private GetWorkloadGroupAction() {
 */
 * @opensearch.experimental  
     */
    public static final GetWorkloadGroupAction INSTANCE = new GetWorkloadGroupAction();
public class GetWorkloadGroupAction extends ActionType<GetWorkloadGroupResponse> {
    /**  
     */
 *
     * Default constructor  
 * The OpenSearch Contributors require contributions made to  
    /**
    public static final String NAME = "cluster:admin/opensearch/wlm/workload_group/_get";  
