import org.opensearch.common.settings.Settings;
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;  
import static org.opensearch.storage.common.tiering.TieringServiceValidator.validateHotToWarmTiering;  
            this.diskThresholdSettings,  
    protected IndexModule.TieringState getTargetTieringState() {  
import org.opensearch.cluster.routing.allocation.DiskThresholdEvaluator;
     * The threshold percentage for file cache active usage when tiering from hot to warm.
    @Override
        // For DFA: H2W write block is set by TransportHotToWarmTierAction.addWriteBlockAndPrepare()
     * Constructs a new HotToWarmTieringService.
 * The OpenSearch Contributors require contributions made to  
            .put(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), TIERED_COMPOSITE_INDEX_TYPE)
     * @param nodeEnvironment the node environment
import org.opensearch.index.IndexModule;
        return blocksBuilder;
        this.diskThresholdEvaluator = new WarmNodeDiskThresholdEvaluator(
        final NodeEnvironment nodeEnvironment,
import org.opensearch.cluster.service.ClusterService;  
            tieringEntries,
    }  
    @Override  
import static org.opensearch.storage.common.tiering.TieringUtils.FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT;
import org.opensearch.env.NodeEnvironment;  
    protected Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata) {
        // The write block is deferred to removeWriteBlockForCancelledDfaIndices(), which  
            clusterService,
            .put(INDEX_TIERING_STATE.getKey(), HOT_TO_WARM)
            .build();
    ) {  
        return H2W_MAX_CONCURRENT_TIERING_REQUESTS;  
    }
    ) {
import org.opensearch.cluster.ClusterState;
     * @param shardLimitValidator the shard limit validator
            .put(IS_WARM_INDEX_SETTING.getKey(), false)
    }
            .put(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "default")  
import org.opensearch.indices.ShardLimitValidator;
    protected Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata) {
public class HotToWarmTieringService extends TieringService {  
    /**
        final ClusterService clusterService,
        );  
            nodeEnvironment,
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS;
    /**
import org.opensearch.cluster.routing.allocation.WarmNodeDiskThresholdEvaluator;
import org.opensearch.cluster.routing.allocation.AllocationService;  
            allocationService,
    public HotToWarmTieringService(
            index,
    }
 */
import java.util.Set;
import org.opensearch.cluster.ClusterInfoService;
        ClusterInfoService clusterInfoService,
     */
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
            settings,  
 * SPDX-License-Identifier: Apache-2.0
            jvmActiveUsageThresholdPercent,  
/*  
        IndexMetadata indexMetadata
     * @param clusterService the cluster service  
     *
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Index index  
     * Sets the file cache active usage threshold for tiering validations.
        final IndexNameExpressionResolver indexNameExpressionResolver,  
    }
        final ShardLimitValidator shardLimitValidator  
        return HOT_TO_WARM;  
import org.opensearch.common.inject.Inject;
        final ClusterInfoService clusterInfoService,
import org.opensearch.common.settings.ClusterSettings;
            diskThresholdEvaluator,
        return WARM;
    @Override  
            .put(INDEX_TIERING_STATE.getKey(), HOT)
import static org.opensearch.storage.common.tiering.TieringUtils.TIERED_COMPOSITE_INDEX_TYPE;
import static org.opensearch.index.IndexModule.TieringState.WARM;
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
        // Removing it here would allow writes to reach warm-node shards.
            maxConcurrentTieringRequests,  
        validateHotToWarmTiering(
import static org.opensearch.index.IndexModule.TieringState.HOT;  
    }
    @Override
import org.opensearch.core.index.Index;
     * @param indexNameExpressionResolver the index name expression resolver
package org.opensearch.storage.tiering;
     * @param allocationService the allocation service  
        clusterSettings.addSettingsUpdateConsumer(FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT, this::setFileCacheActiveUsageThreshold);
    /**  
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
    }  
    protected IndexModule.TieringState getTieringType() {
        );
    @Override  
     * @param settings the settings
        ClusterBlocks.Builder blocksBuilder,  
    protected String getTieringStartTimeKey() {
        String indexName,
    protected ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(
    protected Setting<Integer> getMaxConcurrentTieringRequestsSetting() {
        setFileCacheActiveUsageThreshold(clusterSettings.get(FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT));
        super(
        final Settings settings,  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
        // before tier() is called
    }
            .build();  
import static org.opensearch.storage.common.tiering.TieringUtils.H2W_TIERING_START_TIME_KEY;  
    }
        this.fileCacheActiveUsageThresholdPercent = fileCacheActiveUsageThreshold;  
        Set<Index> tieringEntries,  
/**  
     * Disk Threshold Evaluator  
     * @param clusterInfoService the cluster info service
        // Non-DFA - Write block is not required  
            fileCacheActiveUsageThresholdPercent,
        final AllocationService allocationService,
 * this file be licensed under the Apache-2.0 license or a
    private void setFileCacheActiveUsageThreshold(Integer fileCacheActiveUsageThreshold) {
        Integer jvmActiveUsageThresholdPercent,
     * @param fileCacheActiveUsageThreshold the threshold value to set  
}  
            this.fileCacheSettings::getRemoteDataRatio
    private Integer fileCacheActiveUsageThresholdPercent;
            shardLimitValidator  
 * compatible open source license.
            clusterInfoService,
     */  
        Integer maxConcurrentTieringRequests,
 * Service responsible for tiering indices from hot to warm.
import org.opensearch.cluster.block.ClusterBlocks;  
        // only lifts it once every shard is confirmed started on a hot node (writable engine).
    @Override
            .put(IS_WARM_INDEX_SETTING.getKey(), true)  
    /**  
    @Override
 */  
        ClusterSettings clusterSettings = clusterService.getClusterSettings();  
    private final DiskThresholdEvaluator diskThresholdEvaluator;
        // For DFA indices we intentionally do NOT remove INDEX_BLOCKS_WRITE here.
        ClusterState clusterState,
    protected void validateTieringRequest(  
        return Settings.builder()
    }
        return H2W_TIERING_START_TIME_KEY;
        return Settings.builder()  
    ) {
        );
    @Inject
            indexNameExpressionResolver,  
            shardLimitValidator
            clusterInfoService.getClusterInfo(),
import org.opensearch.common.settings.Setting;  
 *
            clusterState,  
     */
     */  
