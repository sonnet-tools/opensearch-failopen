        clusterSettings.addSettingsUpdateConsumer(CAT_INDICES_RESPONSE_LIMIT_SETTING, this::setCatIndicesResponseLimit);
                if (indicesCount > limit) return true;
 * The OpenSearch Contributors require contributions made to
        "cat.segments.response.limit.number_of_indices",
        if (limitEntity == LimitEntity.INDICES) {
    public ResponseLimitSettings(ClusterSettings clusterSettings, Settings settings) {
        Setting.Property.NodeScope,
     */
     *
    private void setCatIndicesResponseLimit(final int catIndicesResponseLimit) {
     * Method to check if the response limit has reached for an action.
public class ResponseLimitSettings {
        -1,
    }
     * @param limit        Integer limit on block entity
import java.util.Objects;
    }
    }
    public enum LimitEntity {
    private volatile int catSegmentsResponseLimit;
 */
 *
    };
import java.util.function.Function;
        return this.catShardsResponseLimit;
    public int getCatIndicesResponseLimit() {
                // Fail fast if limit value is breached and avoid unnecessary computation.
        return false;
     * @param routingTable {@link RoutingTable}
import org.opensearch.cluster.routing.IndexShardRoutingTable;
     * @return True/False
                break;
     * @param limitEntity  {@link LimitEntity}
import org.opensearch.rest.action.cat.RestShardsAction;
    public static final Setting<Integer> CAT_SEGMENTS_RESPONSE_LIMIT_SETTING = Setting.intSetting(
    /**
        "cat.indices.response.limit.number_of_indices",
    /**
        if (Objects.isNull(metadata) || limit <= 0) return false;
import org.opensearch.rest.action.cat.RestIndicesAction;
            throw new IllegalArgumentException("Unsupported limit entity [" + limitEntity + "]");
    private static boolean isShardsLimitBreached(final RoutingTable routingTable, final int limit) {
        if (Objects.isNull(routingTable) || limit <= 0) return false;
        -1,
    }
    }
            return routingTable.getIndicesRouting().size();
    public static boolean isResponseLimitBreached(final Metadata metadata, final LimitEntity limitEntity, final int limit) {
    private volatile int catIndicesResponseLimit;
        return this.catIndicesResponseLimit;
     */
/**
     *
 * compatible open source license.
        if (Objects.nonNull(routingTable) && Objects.nonNull(routingTable.getIndicesRouting())) {
package org.opensearch.common.breaker;
import org.opensearch.common.settings.ClusterSettings;
        Setting.Property.Dynamic
                int indicesCount = getTotalIndicesFromRoutingTable.apply(routingTable);
 */
    private void setCatSegmentsResponseLimit(final int catSegmentsResponseLimit) {
    );
    }
    private volatile int catShardsResponseLimit;
            }
    };
        this.catIndicesResponseLimit = catIndicesResponseLimit;
    );
                totalShards += indexShardRoutingTableEntry.getValue().getShards().size();
     */
     * @return True/False
}
        INDICES,
     * The limits are controlled via dynamic settings.
    static Function<Metadata, Integer> getTotalIndicesFromMetadata = (metadata) -> {
    public int getCatSegmentsResponseLimit() {
        "cat.shards.response.limit.number_of_shards",
    /**
        Setting.Property.NodeScope,
        Setting.Property.NodeScope,
import org.opensearch.common.settings.Settings;
        }
    private void setCatShardsResponseLimit(final int catShardsResponseLimit) {
    static Function<RoutingTable, Integer> getTotalIndicesFromRoutingTable = (routingTable) -> {
            return indicesCount > limit;
 * SPDX-License-Identifier: Apache-2.0
    }
            case SHARDS:
        setCatSegmentsResponseLimit(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.get(settings));
     * Enum to represent entity against which we need to perform limit checks.
            default:
        for (final Map.Entry<String, IndexRoutingTable> entry : indexRoutingTableMap.entrySet()) {
     * Setting to enable response limit on {@link RestIndicesAction}. The limit will be applied on number of indices.
        final Map<String, IndexRoutingTable> indexRoutingTableMap = routingTable.getIndicesRouting();
        Setting.Property.Dynamic
    }
        clusterSettings.addSettingsUpdateConsumer(CAT_SHARDS_RESPONSE_LIMIT_SETTING, this::setCatShardsResponseLimit);
     * Setting to enable response limit on {@link RestShardsAction}. The limit will be applied on number of shards.
        return 0;
        -1,
    /**
        if (Objects.isNull(limitEntity)) {
    public static boolean isResponseLimitBreached(final RoutingTable routingTable, final LimitEntity limitEntity, final int limit) {
     */
     * @param metadata     {@link Metadata}
    );
            throw new IllegalArgumentException("Limit entity cannot be null");
        if (Objects.nonNull(metadata) && Objects.nonNull(metadata.getIndices())) {
                if (isShardsLimitBreached(routingTable, limit)) return true;
 * this file be licensed under the Apache-2.0 license or a
        clusterSettings.addSettingsUpdateConsumer(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING, this::setCatSegmentsResponseLimit);
            return metadata.getIndices().size();
            for (final Map.Entry<Integer, IndexShardRoutingTable> indexShardRoutingTableEntry : entry.getValue().getShards().entrySet()) {
        return this.catSegmentsResponseLimit;
            case INDICES:
    }
        }
        }
     * @param limitEntity  {@link LimitEntity}
     * @param limit        Integer limit on block entity
     */
            int indicesCount = getTotalIndicesFromMetadata.apply(metadata);
import org.opensearch.rest.action.cat.RestSegmentsAction;
     * Setting to enable response limit on {@link RestSegmentsAction}. The limit will be applied on number of indices.
        Setting.Property.Dynamic
     */
    public int getCatShardsResponseLimit() {
        this.catShardsResponseLimit = catShardsResponseLimit;
                if (totalShards > limit) return true;
import java.util.Map;
    }
                throw new IllegalArgumentException("Unsupported limit entity [" + limitEntity + "]");
        }
        int totalShards = 0;
     * Method to check if the response limit has reached for an action.
 * Class to define dynamic settings for putting response limits on the actions and methods to evaluate if block is required.
import org.opensearch.common.settings.Setting;
    public static final Setting<Integer> CAT_SHARDS_RESPONSE_LIMIT_SETTING = Setting.intSetting(
        }
        } else {
import org.opensearch.cluster.routing.RoutingTable;
        setCatIndicesResponseLimit(CAT_INDICES_RESPONSE_LIMIT_SETTING.get(settings));
    /**
        SHARDS
     * The limits are controlled via dynamic settings.
import org.opensearch.cluster.routing.IndexRoutingTable;
        return false;
        switch (limitEntity) {
        setCatShardsResponseLimit(CAT_SHARDS_RESPONSE_LIMIT_SETTING.get(settings));
        return 0;
    /**
                break;
        this.catSegmentsResponseLimit = catSegmentsResponseLimit;
        }
    }
/*
import org.opensearch.cluster.metadata.Metadata;
    public static final Setting<Integer> CAT_INDICES_RESPONSE_LIMIT_SETTING = Setting.intSetting(
