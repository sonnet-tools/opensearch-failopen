    public static final String NAME = "cluster:admin/remotestore/restore";
 */  
        super(NAME, RestoreRemoteStoreResponse::new);
 * @opensearch.internal  
package org.opensearch.action.admin.cluster.remotestore.restore;
}
/*  
 *
 * compatible open source license.
 */
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionType;
 * Restore remote store action
/**  
public final class RestoreRemoteStoreAction extends ActionType<RestoreRemoteStoreResponse> {
    }  
 * The OpenSearch Contributors require contributions made to  
 *
    public static final RestoreRemoteStoreAction INSTANCE = new RestoreRemoteStoreAction();
    private RestoreRemoteStoreAction() {
