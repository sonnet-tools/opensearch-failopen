 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    private HotToWarmTierAction() {  
 */  
    public static final String NAME = "indices:admin/_tier/hot_to_warm";
 * Action type for moving indices from hot to warm tier in OpenSearch's tiered storage.
    * Singleton instance of the HotToWarmTierAction.
    /**  
        super(NAME, AcknowledgedResponse::new);
}  
     */  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.storage.action.tiering;
     * Action name for hot to warm tier operations.
public class HotToWarmTierAction extends ActionType<AcknowledgedResponse> {
 *
    public static final HotToWarmTierAction INSTANCE = new HotToWarmTierAction();  
    /**
    */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.action.ActionType;
/*  
 * compatible open source license.
 */  
/**
    }
