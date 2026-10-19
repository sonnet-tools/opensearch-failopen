import org.opensearch.action.ActionType;
    public static final CreateWorkloadGroupAction INSTANCE = new CreateWorkloadGroupAction();
package org.opensearch.plugin.wlm.action;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
     */
     */
    }
 *
 */
 * compatible open source license.
        super(NAME, CreateWorkloadGroupResponse::new);  
}
 *
     */  
    /**
/**  
    public static final String NAME = "cluster:admin/opensearch/wlm/workload_group/_create";  
/*  
public class CreateWorkloadGroupAction extends ActionType<CreateWorkloadGroupResponse> {
     * Default constructor  
 * this file be licensed under the Apache-2.0 license or a
    /**
    private CreateWorkloadGroupAction() {
     * Name for CreateWorkloadGroupAction
     * An instance of CreateWorkloadGroupAction
 * @opensearch.experimental  
 * Transport action to create WorkloadGroup
    /**  
 */  
