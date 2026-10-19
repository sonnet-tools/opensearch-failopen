     * Singleton instance of the PrepareTieringAction.
 * This action flushes, refreshes, and waits for remote store sync on primary shards  
 */  
    private PrepareTieringAction() {
    /**  
    }
 * this file be licensed under the Apache-2.0 license or a
    /**
public class PrepareTieringAction extends ActionType<BroadcastResponse> {
 * @opensearch.internal  
    public static final PrepareTieringAction INSTANCE = new PrepareTieringAction();
    public static final String NAME = "internal:admin/indices/prepare_tiering";  
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.action.ActionType;
     * Internal action name for pre-tiering sync operations.
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.broadcast.BroadcastResponse;
     */  
/*  
 * Action type for pre-tiering sync operations on DFA indices.
 */
 *
/**
 * before tiering can proceed.
package org.opensearch.storage.action.tiering;
 *
 * compatible open source license.
        super(NAME, BroadcastResponse::new);  
