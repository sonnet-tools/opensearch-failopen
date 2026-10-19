    }
    public static final String NAME = "cluster:monitor/shards";
        super(NAME, CatShardsResponse::new);
/**  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 *
 */
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
 * compatible open source license.
package org.opensearch.action.admin.cluster.shards;
 */  
    private CatShardsAction() {  
    public static final CatShardsAction INSTANCE = new CatShardsAction();  
}  
 *
/*  
import org.opensearch.action.ActionType;
public class CatShardsAction extends ActionType<CatShardsResponse> {
 * Transport action for cat shards
