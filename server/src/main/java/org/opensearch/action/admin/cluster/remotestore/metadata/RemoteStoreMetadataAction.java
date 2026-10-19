    public static final RemoteStoreMetadataAction INSTANCE = new RemoteStoreMetadataAction();  
    private RemoteStoreMetadataAction() {  
 * SPDX-License-Identifier: Apache-2.0
    public static final String NAME = "cluster:admin/remote_store/metadata";
}  
 * @opensearch.internal  
        super(NAME, RemoteStoreMetadataResponse::new);
/*  
 *
package org.opensearch.action.admin.cluster.remotestore.metadata;
import org.opensearch.action.ActionType;
    }
/**  
 * Action to fetch metadata from remote store
 */  
 * this file be licensed under the Apache-2.0 license or a
 */
 * The OpenSearch Contributors require contributions made to  
public class RemoteStoreMetadataAction extends ActionType<RemoteStoreMetadataResponse> {
 * compatible open source license.
 *
