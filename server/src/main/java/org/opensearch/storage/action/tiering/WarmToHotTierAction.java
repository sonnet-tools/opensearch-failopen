    public static final String NAME = "indices:admin/_tier/warm_to_hot";
package org.opensearch.storage.action.tiering;
}  
    }
     * Action name for warm to hot tier operations.
    /**
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    /**  
 *
    public static final WarmToHotTierAction INSTANCE = new WarmToHotTierAction();  
 */  
 * SPDX-License-Identifier: Apache-2.0
     */
public class WarmToHotTierAction extends ActionType<AcknowledgedResponse> {
        super(NAME, AcknowledgedResponse::new);
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */  
    private WarmToHotTierAction() {  
     */  
     * Singleton instance of the WarmToHotTierAction.
/*  
/**
import org.opensearch.action.ActionType;
 * Action type for moving indices from warm to hot tier in OpenSearch's tiered storage.
 * The OpenSearch Contributors require contributions made to  
