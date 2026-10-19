package org.opensearch.action.admin.cluster.blockcache;
/**  
public class PruneBlockCacheAction extends ActionType<PruneBlockCacheResponse> {
/*  
}
 * @opensearch.internal  
 * Transport action to prune a named block cache.
    public static final PruneBlockCacheAction INSTANCE = new PruneBlockCacheAction();
 */  
 *
        super(NAME, PruneBlockCacheResponse::new);
 * The OpenSearch Contributors require contributions made to  
 */
    }  
 * compatible open source license.
    public static final String NAME = "cluster:admin/blockcache/prune";
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionType;
 *
    private PruneBlockCacheAction() {
