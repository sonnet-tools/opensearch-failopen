        }
    @Override
        return builder.build();
}  
        if (TieringUtils.isDfaIndex(indexMetadata) == false) {
public class WarmToHotTieringService extends TieringService {  
        if (TieringUtils.isDfaIndex(indexMetadata)) {
        Index index
        final ClusterInfoService clusterInfoService,
            return blocksBuilder;  
    @Override
 * Service responsible for tiering indices from warm to hot.
    @Override
            .put(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "default");
            maxConcurrentTieringRequests,
import org.opensearch.index.IndexModule;
     * @param indexNameExpressionResolver the index name expression resolver
        return blocksBuilder.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        );  
import org.opensearch.core.index.Index;
    protected Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata) {  
        final NodeEnvironment nodeEnvironment,
            .put(INDEX_TIERING_STATE.getKey(), WARM)  
import static org.opensearch.index.IndexModule.TieringState.WARM;
        ClusterBlocks.Builder blocksBuilder,
    }
 * this file be licensed under the Apache-2.0 license or a
/**  
 * The OpenSearch Contributors require contributions made to  
        ClusterInfoService clusterInfoService,  
 *
    protected Setting<Integer> getMaxConcurrentTieringRequestsSetting() {
    }  
            shardLimitValidator
        IndexMetadata indexMetadata  
import java.util.Set;
     * @param clusterService the cluster service
    @Override
    protected IndexModule.TieringState getTieringType() {  
        return WARM_TO_HOT;
        }
            clusterService,  
import org.opensearch.cluster.ClusterInfoService;
        Settings.Builder builder = Settings.builder()
/*  
    ) {
        if (TieringUtils.isDfaIndex(indexMetadata)) {
import org.opensearch.cluster.block.ClusterBlocks;  
        ClusterState clusterState,
        final Settings settings,
            return blocksBuilder;  
import org.opensearch.cluster.metadata.IndexMetadata;
    protected ClusterBlocks.Builder getIndexTierClusterBlocksToRestoreAfterCancellation(  
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
        }
import org.opensearch.common.settings.Settings;
import org.opensearch.env.NodeEnvironment;  
     * @param shardLimitValidator the shard limit validator
     * @param clusterInfoService the cluster info service  
    public WarmToHotTieringService(
    }
        return builder.build();
import org.opensearch.indices.ShardLimitValidator;
            .put(IS_WARM_INDEX_SETTING.getKey(), true)
     * @param allocationService the allocation service
    @Override  
            indexNameExpressionResolver,
    protected void validateTieringRequest(
            builder.put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false);  
import org.opensearch.cluster.service.ClusterService;
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS;  
        return W2H_MAX_CONCURRENT_TIERING_REQUESTS;  
     */
        return W2H_TIERING_START_TIME_KEY;
        validateWarmToHotTiering(  
        IndexMetadata indexMetadata  
import static org.opensearch.storage.common.tiering.TieringUtils.TIERED_COMPOSITE_INDEX_TYPE;
import static org.opensearch.storage.common.tiering.TieringUtils.W2H_TIERING_START_TIME_KEY;
            clusterInfoService.getClusterInfo(),
        String indexName,
        final IndexNameExpressionResolver indexNameExpressionResolver,
    protected String getTieringStartTimeKey() {  
            clusterState,
    protected IndexModule.TieringState getTargetTieringState() {
    }  
            .put(IS_WARM_INDEX_SETTING.getKey(), false)
 */
        final ClusterService clusterService,  
            .put(INDEX_TIERING_STATE.getKey(), WARM_TO_HOT)  
    ) {
        return HOT;
     * Constructs a new WarmToHotTieringService.  
    protected Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata) {  
import org.opensearch.common.inject.Inject;
 * SPDX-License-Identifier: Apache-2.0
        ClusterBlocks.Builder blocksBuilder,
    ) {
    @Override  
    /**
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;  
            allocationService,  
            settings,
            .put(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), TIERED_COMPOSITE_INDEX_TYPE);
        Set<Index> tieringEntries,
            jvmActiveUsageThresholdPercent,
package org.opensearch.storage.tiering;
        Integer maxConcurrentTieringRequests,
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;  
     * @param settings the settings
    }  
import org.opensearch.storage.common.tiering.TieringUtils;  
        Settings.Builder builder = Settings.builder()
import org.opensearch.cluster.routing.allocation.AllocationService;  
import static org.opensearch.storage.common.tiering.TieringServiceValidator.validateWarmToHotTiering;
    @Override
        final ShardLimitValidator shardLimitValidator
            shardLimitValidator
            nodeEnvironment,
    }  
    }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        return blocksBuilder.addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
        String indexName,
    }
        );
            builder.put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), true);  
        super(
        }
import org.opensearch.common.settings.Setting;  
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;
    }
        final AllocationService allocationService,  
     * @param nodeEnvironment the node environment  
    ) {  
            index,  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
    protected ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(  
import static org.opensearch.index.IndexModule.TieringState.HOT;
        if (TieringUtils.isDfaIndex(indexMetadata) == false) {
            clusterInfoService,
    @Override
    }  
            tieringEntries,  
    @Override
 */  
        Integer jvmActiveUsageThresholdPercent,  
    @Inject  
