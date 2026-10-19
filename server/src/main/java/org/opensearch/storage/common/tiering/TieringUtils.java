        }
     * @return true if the shard is valid for the target tier  
        1000,
import org.opensearch.cluster.routing.ShardRouting;
    private static final Set<String> ALLOWLISTED_INDEX_PREFIXES = Set.of(".ds-");
        JVM_USAGE_TIERING_THRESHOLD_PERCENT_KEY,  
     * @param index The index for which to retrieve the tiering start time  
         * Converts a string to a Tier enum value.
     * Resolves the concrete index from a request index name.
        /** Returns the lowercase string value of this tier. */  
            return isShardStartedOnWarmNode == false;
     * Returns the tiering source type string for a given request.
        return (request.tier() == Tier.WARM) ? H2W_TIERING_TYPE_KEY : W2H_TIERING_TYPE_KEY;
                        "Tiering type [" + name + "] is not supported. Supported types are " + HOT + " and " + WARM
    }  
        return !ccrLeaderIndexSettingValue.isEmpty();
    public static final String TIERING_CUSTOM_KEY = "tiering";  
            && indexMetadata.getSettings().getAsBoolean(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), false);
        final ShardRouting shard,
     * transport channel timeout so the per-shard timeout fires first with diagnostic detail.
    private TieringUtils() {}  
        1000,  
        } else {
                return WARM_TO_HOT;
    /**
    /**  
import static org.opensearch.index.IndexModule.TieringState.HOT;
        Setting.Property.NodeScope,
     * Returns the tiering source type string for a given target tiering state.
     * @throws IllegalArgumentException if targetTier is neither HOT nor WARM
        /**
     */  
        }
    private static final String CCR_LEADER_INDEX_SETTING_KEY = "index.plugins.replication.follower.leader_index";  
    public static final String PREPARE_TIERING_TIMEOUT_KEY = "cluster.tiering.prepare_timeout";  
     */
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;  
     * @param clusterState the cluster state
     * Checks if a shard is in the correct state for the target tier.
        0,  
    public static final String FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_KEY = "cluster.tiering.filecache_active_threshold_percent";
        final ClusterState clusterState,
     * @param tieringState The target tiering state of the index
    /**
            case WARM -> HOT_TO_WARM;  
    public static final String REPLICA_SYNC_TIMEOUT_KEY = "tiering.prepare.replica_sync_timeout";
            switch (upperCase) {  
    /** Setting key for JVM usage tiering threshold percentage. */
            throw new IllegalArgumentException("Tiering request cannot be null");
         * @throws IllegalArgumentException if the name is invalid
        return (targetTieringState.equals(WARM)) ? H2W_TIERING_TYPE_KEY : W2H_TIERING_TYPE_KEY;
        final boolean isShardStartedOnWarmNode = shard.started() && clusterState.getNodes().get(shard.currentNodeId()).isWarmNode();  
    /**
        Setting.Property.NodeScope
        0,
        }
     */
            }  
        Setting.Property.Dynamic,
}
        /** Warm tier for infrequently accessed data. */
    private static final int DEFAULT_JVM_USAGE_TIERING_THRESHOLD_PERCENT = 95;
        Setting.Property.Dynamic,
        Setting.Property.NodeScope
     * Timeout for the prepare tiering action (merge drain + flush + sync + remote upload).  
        }  
import org.opensearch.index.IndexSettings;
        }
     *
        String requestIndex,
     * @throws IllegalArgumentException if the tiering state is not recognized
        };
    public static final Setting<TimeValue> PREPARE_TIERING_TIMEOUT = Setting.timeSetting(
            if (requestIndices.length != 1) {  
    public static final String H2W_TIERING_TYPE_KEY = "hot to warm tiering";
     * @param indexNameExpressionResolver resolver for index names  
import org.opensearch.cluster.metadata.IndexMetadata;
     */
 * SPDX-License-Identifier: Apache-2.0
     */
        }  
    }  
     * Checks if the index has pluggable data format enabled (is a DFA index).
     *
    private static final int DEFAULT_W2H_MAX_CONCURRENT_TIERING_REQUESTS = 10;  
     * @return the tiering source type key
    }
    }  
                case "WARM":  
    public static IndexModule.TieringState getTieringStatefromTargetTier(String tieringState) {  
    /** Custom metadata key for warm-to-hot tiering start time. */  
            throw new IllegalArgumentException("Target tier must be either HOT or WARM, but was: " + targetTier);  
        TimeValue.timeValueSeconds(90),
            return isShardStartedOnWarmNode;
     * Checks if the index is a CCR follower index.
     * @return the tiering source type key
     */
        // This will also resolve aliases, if any.
import org.opensearch.core.index.Index;
    static final int DEFAULT_H2W_MAX_CONCURRENT_TIERING_REQUESTS = 200;
        TimeValue.timeValueSeconds(30),
     * We reject requests once the fileCache active usage has more than this percent.  
     */
    );  
     * The maximum number of in-flight warm to hot tiering requests.  
    /** Setting for file cache active usage tiering threshold percentage. */
        return indexMetadata != null
     * @param tieringStartTimeKey The key used to store the tiering start time in custom metadata
    /**
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            case WARM_TO_HOT:  
     * @throws IllegalArgumentException if the tiering state is not recognized
     * @return String array containing source and target tier names in order [source, target]  
import org.opensearch.cluster.ClusterState;
    );
    }
    private static final int DEFAULT_FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT = 90;
     */
            throw new IllegalArgumentException("Failed to resolve index: " + requestIndex, e);  
     * We reject requests if the JVM Usage of all target tier nodes has more than this percent.
     * @param clusterState The current state of the cluster
     * @return The corresponding TieringState enum value  
     * @return The timestamp when the tiering operation started (in milliseconds since epoch)
     * @param targetTier The tier to check
                throw new IllegalArgumentException("Unsupported index migration state: " + tieringState);  
            String upperCase = name.trim().toUpperCase(Locale.ROOT);
     * for the remote store upload after flush. The default is kept just under the coordinator's  
    public static boolean isCCRFollowerIndex(final Settings settings) {  
    /** Tiering type identifier for warm-to-hot tiering. */  
        }
    /**
     *
        DEFAULT_JVM_USAGE_TIERING_THRESHOLD_PERCENT,
                requestIndex
     * @param tieringState String representation of the target tier state
    public enum Tier {
            }
                );  
    /** Setting for maximum concurrent hot-to-warm tiering requests. */
    public static final Setting<TimeValue> REPLICA_SYNC_TIMEOUT_SETTING = Setting.timeSetting(  
            case WARM -> new String[] { HOT.toString(), WARM.toString() };
        if (indexName.isBlank()) {
    }
                throw new IllegalArgumentException(
import org.opensearch.storage.action.tiering.IndexTieringRequest;
     * CCR index settings.
        final String ccrLeaderIndexSettingValue = settings.get(CCR_LEADER_INDEX_SETTING_KEY, "");
    ) {  
import java.util.Arrays;
     */  
        }
        Setting.Property.Dynamic,  
     */
        try {  
     * @param currentState                current cluster state
    public static final String H2W_TIERING_START_TIME_KEY = "h2w_start_time";
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("index name cannot be null");
         */  
        Setting.Property.Dynamic,
    /**
    /**  
            );
        DEFAULT_H2W_MAX_CONCURRENT_TIERING_REQUESTS,
    }
        Setting.Property.NodeScope  
import org.opensearch.index.IndexModule;  
     *
            throw new IllegalArgumentException("Index name cannot be empty");
        100,
    public static final Setting<Integer> H2W_MAX_CONCURRENT_TIERING_REQUESTS = Setting.intSetting(
     * Default is 90 seconds — large indices with many segments may need significant time
    );  
            return name().toLowerCase(Locale.ROOT);
     * @throws NumberFormatException if the stored start time value cannot be parsed as a long
        if (request == null) {
     * @return true if the index is a CCR follower
     * @param requestIndex                the requested index name
     * Retrieves the start time of a tiering operation for a specific index.
     */
    /** Custom metadata key for hot-to-warm tiering start time. */
     *
     * @param shard the shard routing  
    }  
     */
            }
     * @param settings the index settings  
     * Setting this to 0 allows us to block customers from making any migrations.
        return Long.parseLong(customData.get(tieringStartTimeKey));
    );
                    throw new IllegalArgumentException(  
     *
    public static final String TIERED_COMPOSITE_INDEX_TYPE = "tiered-storage";  
     * The threshold of active usage to avoid fileCacheUsage overload while accepting tiering requests.
        Setting.Property.Dynamic  
        } else if (targetTier.equals(HOT)) {  
/*  
            return shard.primary() == false;
        IndexNameExpressionResolver indexNameExpressionResolver,  
     * Returns an array of tier names representing the source and target tiers for a given tiering state.  
            case HOT_TO_WARM:
     * @param targetTier the target tier
 * compatible open source license.
     * @param indexName the name of the index to check
    /** Setting key for maximum concurrent hot-to-warm tiering requests. */
import org.opensearch.common.settings.Setting;
    public static boolean isMigrationAllowed(String indexName) {  
            BLOCKLISTED_INDEX_PREFIXES.stream().noneMatch(indexName::startsWith);  // it is not block-listed.  
        if (targetTier.equals(WARM)) {
    public static boolean isTerminalTier(String targetTier) {
 * Utility class for handling tiering operations in OpenSearch Warm.
    /** Setting key for file cache active usage tiering threshold percentage. */  
            if (name == null) {
     * @param targetTieringState the target tiering state  
            logger.error(() -> String.format(Locale.ROOT, "Failed to resolve index: [%s]", requestIndex), e);
    );
    /** Private constructor to prevent instantiation of utility class. */
                currentState,
        public static Tier fromString(final String name) {
        PREPARE_TIERING_TIMEOUT_KEY,  
            default -> throw new IllegalArgumentException("Unknown state: " + tieringState);
    public static final String W2H_TIERING_TYPE_KEY = "warm to hot tiering";
    /** Setting for how long to wait for replicas to sync during tiering preparation. Dynamically updatable. */
         * @param name the string name  
    /**
    /**  
        // This will throw an exception if the index doesn't exist or if it maps to multiple indices.
            default:
        switch (tieringState) {
    public static Index resolveRequestIndex(
        }  
    /**  
            case HOT:
     */  
     * Checks if migration is allowed for the given index name.  
        HOT,  
    public static String[] getTierPairForTargetTier(IndexModule.TieringState tieringState) {  
     * @return true if migration is allowed, false otherwise  
    /**
    public static final String H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY = "cluster.tiering.max_concurrent_hot_to_warm_requests";  
     * @throws IllegalArgumentException if indexName is null
     */
                case "HOT":
            final Index[] requestIndices = indexNameExpressionResolver.concreteIndices(
    }
    /** Setting for maximum concurrent warm-to-hot tiering requests. */  
    public static final String W2H_TIERING_START_TIME_KEY = "w2h_start_time";
        final IndexModule.TieringState tieringState = IndexModule.TieringState.valueOf(
     */
        W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY,
        DEFAULT_W2H_MAX_CONCURRENT_TIERING_REQUESTS,  
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
            case HOT -> new String[] { WARM.toString(), HOT.toString() };  
    private static final Logger logger = LogManager.getLogger(TieringUtils.class);
                    return HOT;
     * Checks if the given tier is a terminal tier (HOT or WARM).  
    public static IndexModule.TieringState getTieringStatefromIndexSettings(Settings indexSettings) {  
     * Controls how long each shard waits for in-flight merges to complete before timing out.
     * Determines the tiering state based on the target tier.  
import org.opensearch.action.support.IndicesOptions;  
import org.apache.logging.log4j.LogManager;
            indexSettings.get(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name())
     */
     * @throws NullPointerException if the tiering metadata or start time is not found  
package org.opensearch.storage.common.tiering;
            case HOT -> WARM_TO_HOT;
            return requestIndices[0];  
        TimeValue.timeValueSeconds(5),  
    public static final String JVM_USAGE_TIERING_THRESHOLD_PERCENT_KEY = "cluster.tiering.jvm_usage_threshold_percent";  
            case WARM:  
import org.apache.logging.log4j.Logger;
        if (shard.unassigned()) {
     * Represents the target tiers available for tiering requests via REST API.  
     * Returns the TieringState based on the index settings.
     * The time is stored as a custom metadata field in the cluster state.  
    /**
     */  
     * @return the TieringState
        return ALLOWLISTED_INDEX_PREFIXES.stream().anyMatch(indexName::startsWith) ||  // either the index is explicitly allow-listed, or
     */
                    return WARM;
 */  
        return Arrays.asList(IndexModule.TieringState.HOT.toString(), IndexModule.TieringState.WARM.toString())  
     */
        if (indexName == null) {
        Setting.Property.Dynamic,  
     * @param indexSettings the index settings  
                    );
        return switch (tieringState) {
        0,
        };
            throw new IllegalStateException("Tiering metadata not found for index [" + index.getName() + "]");  
    private static final Set<String> BLOCKLISTED_INDEX_PREFIXES = Set.of(".");
    /** Custom metadata key for tiering information. */
        TimeValue.timeValueSeconds(30),
    public static boolean isShardStateValidForTier(  
    /** Setting for JVM usage tiering threshold percentage. */
     * List of index name prefixes that should not be allowed to be migrated. We chose the prefix as "." since that covers most
    /**
        return switch (IndexModule.TieringState.valueOf(tieringState)) {
        if (customData == null || customData.get(tieringStartTimeKey) == null) {
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;
        public String value() {
import org.opensearch.common.unit.TimeValue;
    /**  
     * @return true if the tier is terminal (HOT or WARM), false otherwise  
    }
/**  
            // Ignore unassigned replica shard status - only primary shard placement determines migration completion  
    );
        );  
    /**
    }
        Setting.Property.NodeScope
import java.util.Map;  
        ClusterState currentState
public class TieringUtils {  
    ) {
            .contains(targetTier.toUpperCase(Locale.ROOT));
        TimeValue.timeValueMinutes(5),
    }  
                return HOT_TO_WARM;
     * Setting this to 0 allows us to block customers from making any migrations.
     * The threshold of the JVM Usage Percent to avoid cluster overload while accepting index tiering requests.
    /**
        Map<String, String> customData = clusterState.getMetadata().getIndexSafe(index).getCustomData(TIERING_CUSTOM_KEY);
 */
        100,  
    /** Setting for prepare tiering timeout. Dynamically updatable via cluster settings API. */
    public static String getTieringSourceType(IndexTieringRequest request) {  
        Setting.Property.NodeScope
     * @param request the tiering request  
        0,
    public static final Setting<Integer> W2H_MAX_CONCURRENT_TIERING_REQUESTS = Setting.intSetting(
     * @return resolved Index object  
     * metadata indices like the ones created by kibana, search guard etc.
 *
    /** Composite index type for tiered storage. */
        H2W_MAX_CONCURRENT_TIERING_REQUESTS_KEY,  
    public static final Setting<Integer> JVM_USAGE_TIERING_THRESHOLD_PERCENT = Setting.intSetting(
    /**
    public static String getTieringSourceType(IndexModule.TieringState targetTieringState) {  
    /** Setting key for maximum concurrent warm-to-hot tiering requests. */
        FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_KEY,
    public static boolean isDfaIndex(IndexMetadata indexMetadata) {  
    }
        /** Hot tier for frequently accessed data. */
     */
        }  
                IndicesOptions.STRICT_SINGLE_INDEX_NO_EXPAND_FORBID_CLOSED,  
    public static long getTieringStartTime(ClusterState clusterState, Index index, String tieringStartTimeKey) {  
    /**  
import org.opensearch.common.settings.Settings;  
    public static final Setting<Integer> FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT = Setting.intSetting(  
                default:
                    String.format(Locale.ROOT, "Expected single index but got %d indices", requestIndices.length)
     * This enum is specifically used during request handling to validate and process
            default -> throw new IllegalArgumentException("Unknown state: " + tieringState);
        final IndexModule.TieringState targetTier  
    public static final String W2H_MAX_CONCURRENT_TIERING_REQUESTS_KEY = "cluster.tiering.max_concurrent_warm_to_hot_requests";
        } catch (Exception e) {
     * The maximum number of in-flight hot to warm tiering requests.
import java.util.Locale;
     * This takes precedence over the 'block-listed' index prefixes.
        DEFAULT_FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT,
import static org.opensearch.index.IndexModule.TieringState.WARM;  
    /**  
        WARM;
                throw new IllegalArgumentException("Tiering type cannot be null");  
         * @return the corresponding Tier enum value
        REPLICA_SYNC_TIMEOUT_KEY,
import java.util.Set;
    /**
     * List of index name prefixes that should be allowed to be migrated.
     * the tier parameter in REST endpoints.
     */  
 * The OpenSearch Contributors require contributions made to  
    /** Tiering type identifier for hot-to-warm tiering. */
            logger.info(() -> String.format(Locale.ROOT, "Resolved index [%s] to [%s]", requestIndex, requestIndices[0].getName()));
