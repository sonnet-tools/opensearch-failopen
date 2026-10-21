        } else if (targetTier.equals(HOT)) {
            BLOCKLISTED_INDEX_PREFIXES.stream().noneMatch(indexName::startsWith);  // it is not block-listed.
    );
        Setting.Property.Dynamic,
    public static boolean isShardStateValidForTier(
                    );
            throw new IllegalArgumentException("Tiering request cannot be null");
            throw new IllegalStateException("Tiering metadata not found for index [" + index.getName() + "]");
        }
 */
    /**
 * this file be licensed under the Apache-2.0 license or a
    }
     * @return resolved Index object
        // This will throw an exception if the index doesn't exist or if it maps to multiple indices.
        if (targetTier.equals(WARM)) {
     * We reject requests once the fileCache active usage has more than this percent.
import org.opensearch.common.settings.Settings;
    public static final Setting<TimeValue> REPLICA_SYNC_TIMEOUT_SETTING = Setting.timeSetting(
     * List of index name prefixes that should be allowed to be migrated.
 *
     * @return the tiering source type key
    public static final Setting<Integer> H2W_MAX_CONCURRENT_TIERING_REQUESTS = Setting.intSetting(
    /**
     * @throws NumberFormatException if the stored start time value cannot be parsed as a long
         * @param name the string name
    );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    /**
    /**
        DEFAULT_JVM_USAGE_TIERING_THRESHOLD_PERCENT,
     * Returns the tiering source type string for a given target tiering state.
import org.opensearch.cluster.metadata.IndexMetadata;
            final Index[] requestIndices = indexNameExpressionResolver.concreteIndices(
    /**
        /** Hot tier for frequently accessed data. */
        TimeValue.timeValueSeconds(5),
    /**
        DEFAULT_FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT,
    public static final Setting<TimeValue> PREPARE_TIERING_TIMEOUT = Setting.timeSetting(
        Setting.Property.Dynamic,
    private static final Set<String> BLOCKLISTED_INDEX_PREFIXES = Set.of(".");
                requestIndex
        return !ccrLeaderIndexSettingValue.isEmpty();
            case HOT_TO_WARM:
    /** Setting for prepare tiering timeout. Dynamically updatable via cluster settings API. */
    }
    /** Setting for maximum concurrent warm-to-hot tiering requests. */
            String upperCase = name.trim().toUpperCase(Locale.ROOT);
    public static IndexModule.TieringState getTieringStatefromIndexSettings(Settings indexSettings) {
     *
    /**
        return switch (tieringState) {
    public enum Tier {
        );
        if (indexName.isBlank()) {
            default -> throw new IllegalArgumentException("Unknown state: " + tieringState);
            case HOT:
     * @return true if the index is a CCR follower
    public static final String H2W_TIERING_TYPE_KEY = "hot to warm tiering";
            }
                currentState,
        /** Returns the lowercase string value of this tier. */
    public static boolean isCCRFollowerIndex(final Settings settings) {
            logger.error(() -> String.format(Locale.ROOT, "Failed to resolve index: [%s]", requestIndex), e);
    }
        W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY,
import org.opensearch.common.settings.Setting;
    public static final String JVM_USAGE_TIERING_THRESHOLD_PERCENT_KEY = "cluster.tiering.jvm_usage_threshold_percent";
    private static final int DEFAULT_JVM_USAGE_TIERING_THRESHOLD_PERCENT = 95;
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;
            case WARM:
        }
    /** Setting for how long to wait for replicas to sync during tiering preparation. Dynamically updatable. */
    public static boolean isDfaIndex(IndexMetadata indexMetadata) {
     */
    );
import java.util.Set;
     *
     * Resolves the concrete index from a request index name.
                throw new IllegalArgumentException("Unsupported index migration state: " + tieringState);
    /**
        0,
     */
        return switch (IndexModule.TieringState.valueOf(tieringState)) {
    ) {
        Setting.Property.Dynamic,
    );
        DEFAULT_H2W_MAX_CONCURRENT_TIERING_REQUESTS,
     * Setting this to 0 allows us to block customers from making any migrations.
        PREPARE_TIERING_TIMEOUT_KEY,
    /**
    /** Setting key for maximum concurrent hot-to-warm tiering requests. */
    public static final String W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY = "cluster.tiering.max_concurrent_warm_to_hot_requests";
     * @param requestIndex                the requested index name
     * the tier parameter in REST endpoints.
     */
    public static final String H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY = "cluster.tiering.max_concurrent_hot_to_warm_requests";
        0,
        0,
import java.util.Arrays;
import org.opensearch.storage.action.tiering.IndexTieringRequest;
                IndicesOptions.STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED,
     * List of index name prefixes that should not be allowed to be migrated. We chose the prefix as "." since that covers most
        TimeValue.timeValueMinutes(5),
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
        Setting.Property.NodeScope
            case HOT -> WARM_TO_HOT;
                case "WARM":
        IndexNameExpressionResolver indexNameExpressionResolver,
     */
     *
        return Arrays.asList(IndexModule.TieringState.HOT.toString(), IndexModule.TieringState.WARM.toString())
                    return HOT;
     * This enum is specifically used during request handling to validate and process
    public static long getTieringStartTime(ClusterState clusterState, Index index, String tieringStartTimeKey) {
}
            indexSettings.get(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name())
     * @return true if migration is allowed, false otherwise
    static final int DEFAULT_H2W_MAX_CONCURRENT_TIERING_REQUESTS = 200;
     */
        Map<String, String> customData = clusterState.getMetadata().getIndexSafe(index).getCustomData(TIERING_CUSTOM_KEY);
            }
/*
     */
     * The threshold of active usage to avoid fileCacheUsage overload while accepting tiering requests.
     * @throws IllegalArgumentException if the tiering state is not recognized
                    String.format(Locale.ROOT, "Expected single index but got %d indices", requestIndices.length)
     * @return the TieringState
            );
        switch (tieringState) {
        if (customData == null || customData.get(tieringStartTimeKey) == null) {
    /** Setting for maximum concurrent hot-to-warm tiering requests. */
    /** Setting key for maximum concurrent warm-to-hot tiering requests. */
    public static final Setting<Integer> JVM_USAGE_TIERING_THRESHOLD_PERCENT = Setting.intSetting(
        }
        TimeValue.timeValueSeconds(30),
     * @param indexSettings the index settings
import java.util.Map;
     * metadata indices like the ones created by kibana, search guard etc.
import org.opensearch.cluster.ClusterState;
        Setting.Property.NodeScope
     * The time is stored as a custom metadata field in the cluster state.
            && indexMetadata.getSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false);
        return (request.tier() == Tier.WARM) ? H2W_TIERING_TYPE_KEY : W2H_TIERING_TYPE_KEY;
        final IndexModule.TieringState tieringState = IndexModule.TieringState.valueOf(
    public static final String FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_KEY = "cluster.tiering.filecache_active_threshold_percent";
    }
    ) {
import org.opensearch.cluster.routing.ShardRouting;
        }
     * for the remote store upload after flush. The default is kept just under the coordinator's
    /**
        ClusterState currentState
     * Checks if the given tier is a terminal tier (HOT or WARM).
            }
                return WARM_TO_HOT;
     * @throws IllegalArgumentException if the tiering state is not recognized
     * transport channel timeout so the per-shard timeout fires first with diagnostic detail.
        Setting.Property.Dynamic,
        }
     * Default is 90 seconds — large indices with many segments may need significant time
    public static final String W2H_TIERING_TYPE_KEY = "warm to hot tiering";
     * Checks if migration is allowed for the given index name.
import java.util.Locale;
    /**
    /**
    }
        /** Warm tier for infrequently accessed data. */
                    return WARM;
            return name().toLowerCase(Locale.ROOT);
        final boolean isShardStartedOnWarmNode = shard.started() && clusterState.getNodes().get(shard.currentNodeId()).isWarmNode();
     * @param indexNameExpressionResolver resolver for index names
     * @return String array containing source and target tier names in order [source, target]
    public static String getTieringSourceType(IndexModule.TieringState targetTieringState) {
     */
     */
    /** Setting key for file cache active usage tiering threshold percentage. */
         */
        return indexMetadata != null
            .contains(targetTier.toUpperCase(Locale.ROOT));
         * @return the corresponding Tier enum value
    }
        1000,
     * Checks if the index is a CCR follower index.
    }
     * This takes precedence over the 'block-listed' index prefixes.
import org.apache.logging.log4j.LogManager;
        }
     */
    public static final Setting<Integer> W2H_MAX_CONCURRENT_TIERING_REQUESTS = Setting.intSetting(
            return shard.primary() == false;
        } catch (Exception e) {
        H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY,
/**
        if (indexName == null) {
            return isShardStartedOnWarmNode;
    public static final Setting<Integer> FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT = Setting.intSetting(
        return Long.parseLong(customData.get(tieringStartTimeKey));
     */
        public static Tier fromString(final String name) {
     */
        0,
    public static final String TIERING_CUSTOM_KEY = "tiering";
        };
     * The maximum number of in-flight hot to warm tiering requests.
     * @return the tiering source type key
        FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_KEY,
        final IndexModule.TieringState targetTier
    /** Setting for file cache active usage tiering threshold percentage. */
            if (requestIndices.length != 1) {
    public static final String REPLICA_SYNC_TIMEOUT_KEY = "tiering.prepare.replica_sync_timeout";
            case WARM -> new String[] { HOT.toString(), WARM.toString() };
        1000,
     * @param request the tiering request
     * @param tieringState String representation of the target tier state
     * CCR index settings.
 * The OpenSearch Contributors require contributions made to
     * Checks if a shard is in the correct state for the target tier.
     * @return The corresponding TieringState enum value
            case WARM_TO_HOT:
    );
     */
     */
     * @param shard the shard routing
     * Controls how long each shard waits for in-flight merges to complete before timing out.
     * Timeout for the prepare tiering action (merge drain + flush + sync + remote upload).
         * Converts a string to a Tier enum value.
    );
    private static final Set<String> ALLOWLISTED_INDEX_PREFIXES = Set.of(".ds-");
        JVM_USAGE_TIERING_THRESHOLD_PERCENT_KEY,
        }
    public static Index resolveRequestIndex(
     * @param indexName the name of the index to check
     */
     * @throws IllegalArgumentException if targetTier is neither HOT nor WARM
     */
     * Returns an array of tier names representing the source and target tiers for a given tiering state.
 * compatible open source license.
     * @throws NullPointerException if the tiering metadata or start time is not found
    private TieringUtils() {}
        if (shard.unassigned()) {
     *
     */
    /** Custom metadata key for warm-to-hot tiering start time. */
        final ShardRouting shard,
            logger.info(() -> String.format(Locale.ROOT, "Resolved index [%s] to [%s]", requestIndex, requestIndices[0].getName()));
     * @return true if the shard is valid for the target tier
     * @param currentState                current cluster state
    /**
import org.opensearch.core.index.Index;
    /** Custom metadata key for hot-to-warm tiering start time. */
            if (name == null) {
    }
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.NodeScope
     */
        }
    /**
            case WARM -> HOT_TO_WARM;
     */
     * @return true if the tier is terminal (HOT or WARM), false otherwise
    }
    private static final Logger logger = LogManager.getLogger(TieringUtils.class);
     * Setting this to 0 allows us to block customers from making any migrations.
                );
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
     *
    /**
                throw new IllegalArgumentException(
                return HOT_TO_WARM;
        public String value() {
    public static IndexModule.TieringState getTieringStatefromTargetTier(String tieringState) {
     * Returns the TieringState based on the index settings.
     * @return The timestamp when the tiering operation started (in milliseconds since epoch)
     * @throws IllegalArgumentException if indexName is null
import org.opensearch.index.IndexModule;
    public static final String H2W_TIERING_START_TIME_KEY = "h2w_start_time";
            // Ignore unassigned replica shard status - only primary shard placement determines migration completion
        Setting.Property.Dynamic
            default:
     * @param targetTieringState the target tiering state
    /**
     * Represents the target tiers available for tiering requests via REST API.
import static org.opensearch.index.IndexModule.TieringState.HOT;
 * Utility class for handling tiering operations in OpenSearch Warm.
         * @throws IllegalArgumentException if the name is invalid
import static org.opensearch.index.IndexModule.TieringState.WARM;
     */
        };
        Setting.Property.NodeScope
import org.apache.logging.log4j.Logger;
                    throw new IllegalArgumentException(
            throw new IllegalArgumentException("Index name cannot be empty");
        final ClusterState clusterState,
    /** Composite index type for tiered storage. */
        return ALLOWLISTED_INDEX_PREFIXES.stream().anyMatch(indexName::startsWith) ||  // either the index is explicitly allow-listed, or
    public static boolean isMigrationAllowed(String indexName) {
    }
                default:
     * The maximum number of in-flight warm to hot tiering requests.
     * The threshold of the JVM Usage Percent to avoid cluster overload while accepting index tiering requests.
            case HOT -> new String[] { WARM.toString(), HOT.toString() };
     */
        WARM;
        Setting.Property.Dynamic,
     * @param clusterState the cluster state
import org.opensearch.index.IndexSettings;
    private static final int DEFAULT_W2H_MAX_CONCURRENT_TIERING_REQUESTS = 10;
     * @param tieringStartTimeKey The key used to store the tiering start time in custom metadata
    }
    /**
    public static boolean isTerminalTier(String targetTier) {
        100,
     * We reject requests if the JVM Usage of all target tier nodes has more than this percent.
        HOT,
        /**
     * @param tieringState The target tiering state of the index
    }
            return requestIndices[0];
    /** Tiering type identifier for hot-to-warm tiering. */
     * @param index The index for which to retrieve the tiering start time
    }
        }
     * Returns the tiering source type string for a given request.
        DEFAULT_W2H_MAX_CONCURRENT_TIERING_REQUESTS,
        TimeValue.timeValueSeconds(90),
            throw new IllegalArgumentException("index name cannot be null");
    public static final String W2H_TIERING_START_TIME_KEY = "w2h_start_time";
        Setting.Property.NodeScope,
                throw new IllegalArgumentException("Tiering type cannot be null");
    private static final String CCR_LEADER_INDEX_SETTING_KEY = "index.plugins.replication.follower.leader_index";
        }
import org.opensearch.action.support.IndicesOptions;
        100,
    /** Private constructor to prevent instantiation of utility class. */
    /** Tiering type identifier for warm-to-hot tiering. */
        String requestIndex,
    private static final int DEFAULT_FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT = 90;
        REPLICA_SYNC_TIMEOUT_KEY,
import org.opensearch.common.unit.TimeValue;
     * Determines the tiering state based on the target tier.
        } else {
     * @param targetTier The tier to check
                        "Tiering type [" + name + "] is not supported. Supported types are " + HOT + " and " + WARM
     * @param settings the index settings
     *
    public static final String TIERED_COMPOSITE_INDEX_TYPE = "tiered-storage";
            return isShardStartedOnWarmNode == false;
    public static final String PREPARE_TIERING_TIMEOUT_KEY = "cluster.tiering.prepare_timeout";
    /** Custom metadata key for tiering information. */
        try {
     * @param targetTier the target tier
        Setting.Property.NodeScope
        TimeValue.timeValueSeconds(30),
            switch (upperCase) {
            throw new IllegalArgumentException("Target tier must be either HOT or WARM, but was: " + targetTier);
public class TieringUtils {
    public static String[] getTierPairForTargetTier(IndexModule.TieringState tieringState) {
            throw new IllegalArgumentException("Failed to resolve index: " + requestIndex, e);
    /**
        // This will also resolve aliases, if any.
package org.opensearch.storage.common.tiering;
        final String ccrLeaderIndexSettingValue = settings.get(CCR_LEADER_INDEX_SETTING_KEY, "");
    public static String getTieringSourceType(IndexTieringRequest request) {
 */
        return (targetTieringState.equals(WARM)) ? H2W_TIERING_TYPE_KEY : W2H_TIERING_TYPE_KEY;
            default -> throw new IllegalArgumentException("Unknown state: " + tieringState);
    /**
    /** Setting key for JVM usage tiering threshold percentage. */
    /**
    /**
    /** Setting for JVM usage tiering threshold percentage. */
     */
     * @param clusterState The current state of the cluster
     * Retrieves the start time of a tiering operation for a specific index.
        if (request == null) {
                case "HOT":
     * Checks if the index has pluggable data format enabled (is a DFA index).
