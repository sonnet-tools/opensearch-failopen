    /** Singleton instance. */
 * This action can be used to cancel both hot-to-warm and warm-to-hot migrations  
/*  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }  
 * when shards get stuck in RUNNING_SHARD_RELOCATION state.
 *
public class CancelTieringAction extends ActionType<AcknowledgedResponse> {  
    /** Action name for cancel tiering. */
    public static final CancelTieringAction INSTANCE = new CancelTieringAction();  
/**
 * compatible open source license.
 */  
    public static final String NAME = "indices:admin/_tier/cancel";
 * this file be licensed under the Apache-2.0 license or a
 */
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.action.ActionType;
    private CancelTieringAction() {
package org.opensearch.storage.action.tiering;
        super(NAME, AcknowledgedResponse::new);
 * SPDX-License-Identifier: Apache-2.0
 * Action for cancelling ongoing tiering operations.
