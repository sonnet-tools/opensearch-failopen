    }
     * @param limit        Integer limit on block entity
package org.opensearch.common.breaker;
    }  
        -1,
     * Setting to enable response limit on {@link RestIndicesAction}. The limit will be applied on number of indices.
        this.catShardsResponseLimit = catShardsResponseLimit;
 * The OpenSearch Contributors require contributions made to  
    private static boolean isShardsLimitBreached(final RoutingTable routingTable, final int limit) {  
    };  
    }  
    public ResponseLimitSettings(ClusterSettings clusterSettings, Settings settings) {  
     */
     */
                if (indicesCount > limit) return true;
    public static final Setting<Integer> CAT_INDICES_RESPONSE_LIMIT_SETTING = Setting.intSetting(  
    public static boolean isResponseLimitBreached(final RoutingTable routingTable, final LimitEntity limitEntity, final int limit) {
            case SHARDS:  
                int indicesCount = getTotalIndicesFromRoutingTable.apply(routingTable);  
        return 0;
    static Function<Metadata, Integer> getTotalIndicesFromMetadata = (metadata) -> {
    /**  
import org.opensearch.rest.action.cat.RestSegmentsAction;  
            throw new IllegalArgumentException("Unsupported limit entity [" + limitEntity + "]");
    }
        return 0;  
import org.opensearch.rest.action.cat.RestIndicesAction;
        setCatShardsResponseLimit(CAT_SHARDS_RESPONSE_LIMIT_SETTING.get(settings));
                break;
/*  
 * this file be licensed under the Apache-2.0 license or a
    private volatile int catShardsResponseLimit;  
                if (isShardsLimitBreached(routingTable, limit)) return true;
        int totalShards = 0;
    static Function<RoutingTable, Integer> getTotalIndicesFromRoutingTable = (routingTable) -> {
    }  
     * Setting to enable response limit on {@link RestSegmentsAction}. The limit will be applied on number of indices.  
     * Enum to represent entity against which we need to perform limit checks.
        }
        this.catSegmentsResponseLimit = catSegmentsResponseLimit;
     */
    public int getCatIndicesResponseLimit() {
    private volatile int catIndicesResponseLimit;
import org.opensearch.cluster.routing.IndexRoutingTable;
    }
    public int getCatShardsResponseLimit() {
        Setting.Property.NodeScope,
            return metadata.getIndices().size();  
        }
import org.opensearch.rest.action.cat.RestShardsAction;
        -1,  
    );
     * @param routingTable {@link RoutingTable}  
import org.opensearch.common.settings.Settings;
            return routingTable.getIndicesRouting().size();
    private void setCatSegmentsResponseLimit(final int catSegmentsResponseLimit) {  
import org.opensearch.common.settings.ClusterSettings;
     *
        Setting.Property.NodeScope,
     * Method to check if the response limit has reached for an action.  
        return false;  
                totalShards += indexShardRoutingTableEntry.getValue().getShards().size();
        return this.catShardsResponseLimit;
     */
    );  
            default:  
 * Class to define dynamic settings for putting response limits on the actions and methods to evaluate if block is required.
            return indicesCount > limit;
        setCatSegmentsResponseLimit(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.get(settings));  
import java.util.Objects;
        setCatIndicesResponseLimit(CAT_INDICES_RESPONSE_LIMIT_SETTING.get(settings));
        }
    private void setCatShardsResponseLimit(final int catShardsResponseLimit) {
import java.util.Map;  
 *
    );
        if (Objects.isNull(routingTable) || limit <= 0) return false;  
        switch (limitEntity) {
    }
            }
    /**
 * SPDX-License-Identifier: Apache-2.0
        }
        return this.catIndicesResponseLimit;  
        return this.catSegmentsResponseLimit;
        this.catIndicesResponseLimit = catIndicesResponseLimit;  
/**
    public static boolean isResponseLimitBreached(final Metadata metadata, final LimitEntity limitEntity, final int limit) {
        }  
                break;
     * @param limitEntity  {@link LimitEntity}
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.common.settings.Setting;  
        return false;
        clusterSettings.addSettingsUpdateConsumer(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING, this::setCatSegmentsResponseLimit);
        final Map<String, IndexRoutingTable> indexRoutingTableMap = routingTable.getIndicesRouting();
            throw new IllegalArgumentException("Limit entity cannot be null");
    /**
     * @return True/False
    public static final Setting<Integer> CAT_SHARDS_RESPONSE_LIMIT_SETTING = Setting.intSetting(
     * The limits are controlled via dynamic settings.
            for (final Map.Entry<Integer, IndexShardRoutingTable> indexShardRoutingTableEntry : entry.getValue().getShards().entrySet()) {
     * Method to check if the response limit has reached for an action.
                if (totalShards > limit) return true;
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        "cat.shards.response.limit.number_of_shards",
 */  
        clusterSettings.addSettingsUpdateConsumer(CAT_INDICES_RESPONSE_LIMIT_SETTING, this::setCatIndicesResponseLimit);  
    private volatile int catSegmentsResponseLimit;
                // Fail fast if limit value is breached and avoid unnecessary computation.  
     * @param metadata     {@link Metadata}
    }  
        Setting.Property.Dynamic  
     * The limits are controlled via dynamic settings.  
        for (final Map.Entry<String, IndexRoutingTable> entry : indexRoutingTableMap.entrySet()) {  
import java.util.function.Function;
     * @param limit        Integer limit on block entity
import org.opensearch.cluster.routing.RoutingTable;
 * compatible open source license.
     *
    public static final Setting<Integer> CAT_SEGMENTS_RESPONSE_LIMIT_SETTING = Setting.intSetting(
     */  
        if (Objects.nonNull(metadata) && Objects.nonNull(metadata.getIndices())) {
    }
                throw new IllegalArgumentException("Unsupported limit entity [" + limitEntity + "]");
        }  
        INDICES,
    private void setCatIndicesResponseLimit(final int catIndicesResponseLimit) {
    /**
        "cat.segments.response.limit.number_of_indices",  
            case INDICES:
    public enum LimitEntity {  
    public int getCatSegmentsResponseLimit() {  
     * Setting to enable response limit on {@link RestShardsAction}. The limit will be applied on number of shards.
}
            int indicesCount = getTotalIndicesFromMetadata.apply(metadata);
        Setting.Property.Dynamic
    }
        } else {  
public class ResponseLimitSettings {
        SHARDS
    /**
        if (Objects.isNull(limitEntity)) {
    /**  
     * @param limitEntity  {@link LimitEntity}  
        Setting.Property.Dynamic
        -1,
        if (limitEntity == LimitEntity.INDICES) {  
     * @return True/False  
        clusterSettings.addSettingsUpdateConsumer(CAT_SHARDS_RESPONSE_LIMIT_SETTING, this::setCatShardsResponseLimit);
    };
     */  
    }
        if (Objects.nonNull(routingTable) && Objects.nonNull(routingTable.getIndicesRouting())) {  
 */  
        if (Objects.isNull(metadata) || limit <= 0) return false;
        Setting.Property.NodeScope,  
        "cat.indices.response.limit.number_of_indices",
