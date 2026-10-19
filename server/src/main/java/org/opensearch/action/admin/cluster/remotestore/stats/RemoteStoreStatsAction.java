    private RemoteStoreStatsAction() {
 * @opensearch.internal  
 * compatible open source license.
    }  
public class RemoteStoreStatsAction extends ActionType<RemoteStoreStatsResponse> {
 * The OpenSearch Contributors require contributions made to  
    public static final RemoteStoreStatsAction INSTANCE = new RemoteStoreStatsAction();
import org.opensearch.action.ActionType;
 * Remote store stats action
 */
 * this file be licensed under the Apache-2.0 license or a
        super(NAME, RemoteStoreStatsResponse::new);
 *
 * SPDX-License-Identifier: Apache-2.0
}
 *
/**  
 */  
package org.opensearch.action.admin.cluster.remotestore.stats;
    public static final String NAME = "cluster:monitor/_remotestore/stats";
/*  
