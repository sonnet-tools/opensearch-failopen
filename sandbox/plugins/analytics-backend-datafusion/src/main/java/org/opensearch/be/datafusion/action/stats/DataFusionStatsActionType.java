 * Action type for the DataFusion cluster stats transport action.
 * @opensearch.internal  
 *
 * DataFusion runtime statistics from all (or specific) nodes in the cluster.
    }  
package org.opensearch.be.datafusion.action.stats;
 */  
 * compatible open source license.
 *
public class DataFusionStatsActionType extends ActionType<DataFusionStatsNodesResponse> {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    private DataFusionStatsActionType() {
    public static final DataFusionStatsActionType INSTANCE = new DataFusionStatsActionType();
import org.opensearch.action.ActionType;
 */
/*  
    public static final String NAME = "cluster:monitor/_analytics_backend_datafusion/stats";
/**  
}
 * <p>Singleton constant identifying the transport action that collects  
        super(NAME, DataFusionStatsNodesResponse::new);
 *
