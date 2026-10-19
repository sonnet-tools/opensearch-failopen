}
 * @opensearch.internal  
 * Action type for getting deployment status.
/*  
    public static final GetDeploymentAction INSTANCE = new GetDeploymentAction();
 * this file be licensed under the Apache-2.0 license or a
 *
    private GetDeploymentAction() {
/**  
    public static final String NAME = "cluster:monitor/deployment/get";
 */
 * The OpenSearch Contributors require contributions made to  
        super(NAME, GetDeploymentResponse::new);
import org.opensearch.action.ActionType;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }  
package org.opensearch.action.admin.cluster.deployment;
public class GetDeploymentAction extends ActionType<GetDeploymentResponse> {
 */  
 *
