 * @opensearch.experimental
    private HotToWarmTieringAction() {  
import org.opensearch.action.ActionType;
        super(NAME, HotToWarmTieringResponse::new);
 *  
/*  
import org.opensearch.common.annotation.ExperimentalApi;
}  
package org.opensearch.action.admin.indices.tiering;
    public static final HotToWarmTieringAction INSTANCE = new HotToWarmTieringAction();  
 */
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 */  
/**
 * compatible open source license.
public class HotToWarmTieringAction extends ActionType<HotToWarmTieringResponse> {
@ExperimentalApi  
    public static final String NAME = "indices:admin/tier/hot_to_warm";
    }
 *
 * Tiering action to move indices from hot to warm
