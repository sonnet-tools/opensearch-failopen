 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    }  
    @Override
        return H2W_TIERING_TYPE_KEY;
/*  
    protected ActionType<AcknowledgedResponse> getTierAction() {
    public RestHotToWarmTierAction() {
 * this file be licensed under the Apache-2.0 license or a
        return HotToWarmTierAction.INSTANCE;  
    }
 *
        return "warm_tier_action";
/**  
 * REST handler for moving indices to the warm tier.
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_TIERING_TYPE_KEY;
 */
 */  
    @Override  
}
        super(TARGET_TIER);  
public class RestHotToWarmTierAction extends RestBaseTierAction {  
    protected String getMigrationType() {  
    }
    /** Constructs a new RestHotToWarmTierAction. */
    @Override
    public String getName() {
package org.opensearch.storage.action.tiering;
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    private static final String TARGET_TIER = "warm";
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionType;
