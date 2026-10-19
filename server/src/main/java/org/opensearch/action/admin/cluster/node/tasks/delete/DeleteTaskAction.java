 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 *
        super(NAME, AcknowledgedResponse::new);
 *  
public class DeleteTaskAction extends ActionType<AcknowledgedResponse> {  
import org.opensearch.action.ActionType;
    private DeleteTaskAction() {
 * this file be licensed under the Apache-2.0 license or a
    }  
 * compatible open source license.
package org.opensearch.action.admin.cluster.node.tasks.delete;
/**
    public static final DeleteTaskAction INSTANCE = new DeleteTaskAction();
 * SPDX-License-Identifier: Apache-2.0
 */  
    public static final String NAME = "cluster:admin/tasks/delete";
/*  
 * ActionType for deleting a stored completed task result.
 * @opensearch.internal
 */
