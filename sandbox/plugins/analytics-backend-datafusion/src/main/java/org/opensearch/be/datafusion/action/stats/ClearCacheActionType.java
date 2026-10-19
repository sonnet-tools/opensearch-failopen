    private ClearCacheActionType() {
 */
 * The OpenSearch Contributors require contributions made to  
    public static final String NAME = "cluster:admin/_analytics_backend_datafusion/cache/clear";
 *
/*  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    }
 *  
public class ClearCacheActionType extends ActionType<ClearCacheNodesResponse> {  
import org.opensearch.action.ActionType;
package org.opensearch.be.datafusion.action.stats;
 * them must fan out to every node so a single-node REST handler doesn't leave
    public static final ClearCacheActionType INSTANCE = new ClearCacheActionType();  
 * <p>The datafusion caches are process-global singletons, one per node. Clearing  
 * other nodes' caches populated.
/**  
 * Action type for the broadcast "clear datafusion caches" transport action.
        super(NAME, ClearCacheNodesResponse::new);  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 */  
 *
}
