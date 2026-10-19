    @Override
    protected ActionType<AcknowledgedResponse> getTierAction() {
    @Override  
 */
    }
}
import org.opensearch.action.ActionType;
/*  
        return WarmToHotTierAction.INSTANCE;  
 * REST handler for moving indices to the hot tier.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_TIERING_TYPE_KEY;
    }
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
        super(TARGET_TIER);  
    private static final String TARGET_TIER = "hot";
/**  
        return "hot_tier_action";
        return W2H_TIERING_TYPE_KEY;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
public class RestWarmToHotTierAction extends RestBaseTierAction {  
 *
 */  
    @Override
package org.opensearch.storage.action.tiering;
 * compatible open source license.
    public RestWarmToHotTierAction() {
    }  
    }
    protected String getMigrationType() {  
    /** Constructs a new RestWarmToHotTierAction. */
