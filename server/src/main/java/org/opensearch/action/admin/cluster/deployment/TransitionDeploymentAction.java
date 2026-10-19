 * @opensearch.internal
    public static final String NAME = "cluster:admin/deployment/transition";  
 */
 * compatible open source license.
    }
}
/**
    public static final TransitionDeploymentAction INSTANCE = new TransitionDeploymentAction();
 * this file be licensed under the Apache-2.0 license or a
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
        super(NAME, AcknowledgedResponse::new);  
 *  
/*  
    private TransitionDeploymentAction() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 */  
public class TransitionDeploymentAction extends ActionType<AcknowledgedResponse> {  
 * Action type for transitioning a deployment (drain/finish).
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.cluster.deployment;
