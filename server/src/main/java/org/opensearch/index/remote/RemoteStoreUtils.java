            && blobStoreMetadataEnabled;
            : CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.get(clusterSettings);
        Map<String, String> remoteCustomData = new HashMap<>();  
        return Long.MAX_VALUE - num;
     * Filters out indices which does not have remote store based  
    }
                continue;  
     * of 0s to the string.
     *
     * For the second part, the rest of the bits (of length {@code len}-6) will be used as is in string form.
            Tuple<String, String> nodeIdByPrimaryTermAndGen = fn.apply(mdFile);
            return implicitLockedFiles;  
        String invertedLong = String.valueOf(Long.MAX_VALUE - num);
    public static void verifyNoMultipleWriters(List<String> mdFiles, Function<String, Tuple<String, String>> fn) {
     * @param getTimestampFunction A function that extracts the timestamp from a metadata file name.  
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;  
            long metadataTimestamp = getTimestampFunction.apply(metadataFileName);
        return metadataFilesWithMinAge;
        Function<String, Tuple<String, String>> prefixFunction,
        boolean translogMetadata = Version.V_2_15_0.compareTo(minNodeVersion) <= 0  
 * The OpenSearch Contributors require contributions made to  
     * @return A set of metadata file names that are implicitly locked based on the pinned timestamps.  
        if (isCompatibilityModeChanging && isSwitchToStrictCompatibilityMode(request)) {  
        Set<String> implicitLockedFiles = new HashSet<>();
        Function<String, Long> getTimestampFunction,
        // Segment file names follow patterns like "_0.cfe" or "_0_1_Lucene90_0.dvm".  
            throw new IllegalArgumentException("Strings representing negative long values are not allowed");  
     * on indices that are missing them. No-Op if all indices already have the settings applied through
        }  
        return getPinnedTimestampLockedFiles(  
        Collection<IndexMetadata> allIndicesMetadata = clusterState.metadata().indices().values();
    ) {  
            .getPinnedTimestampsLookbackInterval()
                .collect(Collectors.toList());  
            prevMdTimestamp = currentMdTimestamp;
            prefixFunction,  
        if (remoteCustomData != null && remoteCustomData.containsKey(RemoteStoreEnums.PathType.NAME)) {  
        Long currentPinnedTimestamp = timestampIterator.next();  
import java.util.function.Function;
     * @return Name of the segment that the segment file belongs to  
            incomingSettings  
            }
        // ToDo: Do we really need this? Files fetched from remote store are already lexicographically sorted.
     */
                currentPinnedTimestamp = timestampIterator.next();
        remoteCustomData.put(RemoteStoreEnums.PathType.NAME, pathType.name());  
     * This converts the byte array to base 64 string. `/` is replaced with `_`, `+` is replaced with `-` and `=`  
import java.util.TreeSet;  
        return remoteCustomData != null && "true".equalsIgnoreCase(remoteCustomData.get(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY));  
    public static Set<String> getPinnedTimestampLockedFiles(
            remoteCustomData.put(RemoteStoreEnums.PathHashAlgorithm.NAME, pathHashAlgorithm.name());
            if (cachedFile != null) {  
     * @param num number to get the inverted long string for
import java.util.Locale;
        metadataFiles.sort(String::compareTo);
            String cachedFile = metadataFilePinnedTimestampMap.get(pinnedTimestamp);
            ? CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.get(clusterSettings)
                implicitLockedFiles.add(metadataFileName);  
    }  
        if (discoveryNodeMap.isEmpty() == false) {
    /**
        Function<String, Tuple<String, String>> prefixFunction
     *  
                            + "having same primary term and generations "
        }
        }  
        boolean ignorePinnedTimestampEnabledSetting
            if (remoteStoreEnabledNodePresent == true) {
        DiscoveryNodes currentDiscoveryNodes = clusterState.getNodes();
     */
            RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.parseString(
     * Determines if translog file object metadata can be used to store checkpoint file data.
     * @return {@link Map} to be added as custom data in index metadata  
                        "Multiple metadata files from different nodes"
            // We always prefer md file with higher values of prefix like primary term, generation etc.
        return metadataBuilder.build();
     * Applies remote store index settings through {@link RemoteMigrationIndexMetadataUpdater}
     *  
                    logger.info("All indices in the cluster has remote store based index settings");
     * than a certain threshold determined by the last successful fetch of pinned timestamps
            );  
        }  
            .getPinnedTimestampsLookbackInterval()
                currentClusterSettings,
import java.util.Map;
     * plus the lookback interval.
     */  
                if (nodesByPrimaryTermAndGen.containsKey(nodeIdByPrimaryTermAndGen.v1())
                if (timestampIterator.hasNext() == false) {
     * @param currentState cluster state generated after changing cluster settings were applied
        return new RemoteStorePathStrategy(RemoteStoreEnums.PathType.FIXED);
     *           5. Updates the cache with newly processed timestamps and their corresponding metadata files.
     * @param filename Segment file name to parse
    }
            // At this point, we have already validated that all nodes in the cluster are of uniform type.
        return incomingState;
        if (num < 0) {
    /**
     * @param getTimestampFunction A function that extracts a timestamp from a metadata file name.  
        Function<String, Long> getTimestampFunction,
    public static String invertLong(long num) {
     * @param fn      Function to extract PrimaryTerm_Generation and Node Id from metadata file name .
            .findFirst();
    static String longToCompositeBase64AndBinaryEncoding(long value, int len) {  
        }
    ) {
    /**
            metadataBuilder.put(indexMetadataBuilder);
     * @param logger Logger reference  
     * This has been intentionally done after the cluster settings update
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
        }  
     * @param isCompatibilityModeChanging flag passed from cluster settings update call to denote if a compatibility mode change has been done  
import org.opensearch.cluster.metadata.IndexMetadata;  
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdater.indexHasRemoteStoreSettings;
     * matching or being the closest preceding timestamp to the pinned timestamps. It uses a caching mechanism  
    }
    ) {
     * Checks if the incoming cluster settings payload is attempting to switch
                currentRoutingTable,
/*  
        String base64Str = Base64.getUrlEncoder().encodeToString(hashBytes);
     * IndexMetadataUpdater  
            : RemoteStoreEnums.PathType.FIXED;
    public static final int LONG_MAX_LENGTH = String.valueOf(Long.MAX_VALUE).length();
     * be changed as it is used for creating path for storing remote store data on the remote store.
    }
     * @param discoveryNodes Current set of {@link DiscoveryNodes} in the cluster  
            }
            metadataFiles,
        long staleBufferInMillis = (RemoteStoreSettings.getPinnedTimestampsSchedulerInterval().millis() * 3) + RemoteStoreSettings  
     * URL safe base 64 character set. This must not be changed as this is used in deriving the base64 equivalent of binary.
        if (endIdx == -1) {
    }  
     *
        // Add cached entries and collect new timestamps
     * index settings applied even after all shard copies have
     * @return true if the pinned timestamp state is stale, false otherwise.
            } else {  
     */
        byte[] hashBytes = ByteBuffer.allocate(Long.BYTES).putLong(value).array();  
     * @param request request payload passed from cluster settings update
     * @param clusterSettings Current Cluster settings from {@link ClusterState}
package org.opensearch.index.remote;
        return Collections.emptyList();
     * Invoked after a cluster settings update.
                            + nodeIdByPrimaryTermAndGen.v1()  
        Settings clusterSettings,  
        }
     * The state is considered stale if the last successful fetch occurred before  
        DiscoveryNodes discoveryNodes
     *
            return implicitLockedFiles;
        RemoteStoreEnums.PathHashAlgorithm pathHashAlgorithm = pathType == RemoteStoreEnums.PathType.FIXED  
                : null;
                    return ClusterState.builder(incomingState).metadata(mutatedMetadata).build();
     */  
     */  
     *           3. Processes cached entries and identifies new timestamps to process.  
     * This method identifies metadata files that are considered implicitly locked due to their timestamps
        boolean ignorePinnedTimestampEnabledSetting
     * a certain threshold, which is calculated as three times the scheduler interval
    }
        return lastSuccessfulFetchTimestamp < (System.currentTimeMillis() - staleBufferInMillis);  
        assert remoteCustomData == null || remoteCustomData.containsKey(IndexMetadata.TRANSLOG_METADATA_KEY);  
        return ByteBuffer.wrap(hashBytes).getLong();
    public static List<String> filterOutMetadataFilesBasedOnAge(
            false
     *
     * flow. That way we are not interfering with the usual settings update  
        List<String> metadataFiles,
     * Fetches segment and translog repository names from remote store node attributes.
     */
        return getPinnedTimestampLockedFiles(
                List<IndexMetadata> indicesWithoutRemoteStoreSettings = getIndicesWithoutRemoteStoreSettings(incomingState, logger);  
     *           1. Validates input parameters.
     * If so, checks and applies appropriate index settings depending on the current set  
        );
     * Determines and returns a set of metadata files that match provided pinned timestamps.
     * @param prefixFunction A function that extracts a tuple of prefix information from a metadata file name.
     * This method is an overloaded version of getPinnedTimestampLockedFiles and do not use cached entries to find
     *  
     * @param mdFiles List of segment/translog metadata files
        if (Objects.nonNull(pathHashAlgorithm)) {
                indicesWithoutRemoteSettings.size()  
     */  
                metadataFilesWithMinAge.add(metadataFileName);
        // This means the pinned timestamp can be available for read after at most (2 * loopback interval)
        remoteCustomData.put(IndexMetadata.TRANSLOG_METADATA_KEY, Boolean.toString(translogMetadata));
                "Attempting to switch to strict mode. Count of indices without remote store settings {}",
        List<String> metadataFiles,  
     * Determines and returns a set of metadata files that match provided pinned timestamps. If pinned timestamp
     * @param incomingState mutated cluster state after cluster settings were applied
        // translog blobstore supports custom metadata or not.
    }
     */
        List<String> metadataFiles,  
        }
            // Either all of them are remote store enabled, or all of them are docrep enabled  
     * The method performs the following steps:  
            }
    public static boolean isServerSideEncryptionEnabledIndex(IndexMetadata indexMetadata) {
     */
     *
        // Currently, the blobStoreMetadataEnabled flag is set to false because the integration tests run on the local file system, which
     * Visible only for tests
        int base64DecimalValue = Integer.valueOf(base64Part, 2);
            if (currentMdTimestamp > prevMdTimestamp) {
        long num = Long.parseLong(str);
            .filter(DiscoveryNode::isRemoteStoreNode)
        long lastSuccessfulFetchTimestamp = RemoteStorePinnedTimestampService.getPinnedTimestamps().v1();
                currentDiscoveryNodes,
                if (prevMdTimestamp != Long.MAX_VALUE) {
            getTimestampFunction,
            throw new IllegalArgumentException("Negative long values are not allowed");  
    }
        byte[] hashBytes = Base64.getUrlDecoder().decode(base64Str);  
import java.util.HashMap;  
        return false;
            return indicesWithoutRemoteSettings;
                    && (!nodesByPrimaryTermAndGen.get(nodeIdByPrimaryTermAndGen.v1()).equals(nodeIdByPrimaryTermAndGen.v2()))) {
     * Checks if the applied cluster settings has switched the cluster to STRICT mode.
import java.util.Arrays;
                }
    /**
import org.apache.logging.log4j.LogManager;
        Map<String, DiscoveryNode> discoveryNodeMap = incomingState.nodes().getNodes();  
        Set<Long> pinnedTimestampSet,
     * requiring special handling in some vendors. The characters present in this base64 version are [A-Za-z0-9_-].
        if (metadataFiles == null || metadataFiles.isEmpty() || pinnedTimestampSet == null) {
     * feature is not enabled, this function is a no-op.  
        }  
        if (RemoteStoreSettings.isPinnedTimestampsEnabled() == false) {
    /**  
        Set<Long> newPinnedTimestamps = new TreeSet<>(Collections.reverseOrder());  
     * This method filters a list of metadata files, keeping only those that are older
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            }
            logger.debug(
import java.util.stream.Collectors;
import java.util.ArrayList;
        ClusterState clusterState,
        return base64Str.substring(0, base64Str.length() - 1);
            .getMillis());
 * this file be licensed under the Apache-2.0 license or a
     */
 * Utils for remote store
        Iterator<Long> timestampIterator = newPinnedTimestamps.iterator();
     * @return Mutated cluster state with remote store index settings applied, no-op if the cluster is not switching to `STRICT` compatibility mode
    /**
     *  
    }
                remoteCustomData.get(RemoteStoreEnums.PathType.NAME)
                    return implicitLockedFiles;  
    }
                logger.debug("All nodes in the cluster are not remote nodes. Skipping.");
    public static ClusterState checkAndFinalizeRemoteStoreMigration(  
     *
        for (Long pinnedTimestamp : pinnedTimestampSet) {
        // We allow now() - loopback interval to be pinned. Also, the actual pinning can take at most loopback interval
     * @return A new list containing only the metadata files that meet the age criteria.
        assert base64DecimalValue >= 0 && base64DecimalValue < 64;
        Function<String, Tuple<String, String>> prefixFunction,  
        List<IndexMetadata> indicesWithoutRemoteStoreSettings,  
        Optional<DiscoveryNode> remoteNode = discoveryNodes.getNodes()
import org.opensearch.cluster.node.DiscoveryNodes;  
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA;
     * Caller need to handle null checks if {@link DiscoveryNodes} object does not have any remote nodes
            boolean remoteStoreEnabledNodePresent = discoveryNodeMap.values().stream().findFirst().get().isRemoteStoreNode();
    /**  
    }  
        Arrays.fill(characterArray, '0');
        }  
     */
        if (num < 0) {
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING;
     * This method checks whether the last successful fetch of pinned timestamps
     * @param metadataFilePinnedTimestampMap A map used for caching processed timestamps and their corresponding metadata files.  
 */
     */
        // Sort metadata files in descending order of timestamp  
     * to improve performance for previously processed timestamps.
        Version minNodeVersion = discoveryNodes.getMinNodeVersion();
    public static String getSegmentName(String filename) {
     */  
     * migrated to remote store enabled nodes
     * Determines if the pinned timestamp state is stale.
     * Extracts the segment name from the provided segment file name  
            } else {
            if (metadataTimestamp < maximumAllowedTimestamp) {  
    public static long invertLong(String str) {  
    private static Set<String> getPinnedTimestampLockedFiles(
        if (newPinnedTimestamps.isEmpty()) {
    ) {  
            prefixFunction,
            && CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.get(clusterSettings)
     * which is padded at the last is also removed. These characters are either used as delimiter or special character
     * the metadata file
            }  
        String base64Part = binaryEncoding.substring(0, 6);
        }
 *
     *  
                nodesByPrimaryTermAndGen.put(nodeIdByPrimaryTermAndGen.v1(), nodeIdByPrimaryTermAndGen.v2());
    }
import java.nio.ByteBuffer;  
     *  
            ignorePinnedTimestampEnabledSetting  
    ) {
    public static RemoteStorePathStrategy determineRemoteStorePathStrategy(IndexMetadata indexMetadata) {  
        }  
     */
    public static boolean isSwitchToStrictCompatibilityMode(ClusterUpdateSettingsRequest request) {  
                }
        RemoteStoreEnums.PathType pathType = Version.V_2_15_0.compareTo(minNodeVersion) <= 0  
        }  
     * 1. Base 64 string and 2. Binary String. We will use the first 6 bits for creating the base 64 string.  
        if (RemoteStoreSettings.isPinnedTimestampsEnabled() == false) {
     *                fn returns null if node id is not part of the file name  
        Map<Long, String> metadataFilePinnedTimestampMap,
        // https://github.com/opensearch-project/OpenSearch/issues/13745
        return new String(characterArray) + invertedLong;  
        assert remoteCustomData == null || remoteCustomData.containsKey(RemoteStoreEnums.PathType.NAME);
    /**  
     * @param metadataFiles A list of metadata file names. Expected to be sorted in descending order of timestamp.
        }
            throw new IllegalArgumentException("Unable to infer segment name for segment file " + filename);  
    static final char[] URL_BASE64_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();  
     * Returns a blank {@link HashMap} if the cluster does not contain any remote nodes.
        }  
    private static final Logger logger = LogManager.getLogger(RemoteStoreUtils.class);  
import org.opensearch.cluster.metadata.Metadata;
        RoutingTable currentRoutingTable = clusterState.getRoutingTable();
import org.opensearch.cluster.routing.RoutingTable;
    /**
     * and the cluster state mutation that comes along with it
    }
            indexMetadataUpdater.maybeAddRemoteIndexSettings(indexMetadataBuilder, indexMetadata.getIndex().getName());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;  
     * Converts an input hash which occupies 64 bits of space into Base64 (6 bits per character) String. This must not
     *  
        long prevMdTimestamp = Long.MAX_VALUE;
    static String longToUrlBase64(long value) {
            long currentMdTimestamp = getTimestampFunction.apply(metadataFileName);  
        // Remove entries for timestamps that are no longer pinned
 * @opensearch.internal  
            .values()
        }
                ? RemoteStoreEnums.PathHashAlgorithm.parseString(hashAlgoStr)  
        // If we have metadata files from multiple writers, it can result in picking file generated by stale primary.
        mdFiles.forEach(mdFile -> {
            metadataFilePinnedTimestampMap,
     * @return A set of metadata file names that are implicitly locked based on the pinned timestamps.  
            ? null
     * @param metadataFiles A list of metadata file names. Expected to be sorted in descending order of timestamp.
        Set<Long> pinnedTimestampSet,
            new HashMap<>(),  
        Map<Long, String> metadataFilePinnedTimestampMap,  
        long maximumAllowedTimestamp = lastSuccessfulFetchOfPinnedTimestamps - (2 * RemoteStoreSettings  
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata);
     * This method subtracts given numbers from Long.MAX_VALUE and returns a string representation of the result.  
import org.opensearch.Version;  
    /**  
    ) {
        if (allIndicesMetadata.isEmpty() == false) {  
        RemoteStoreUtils.verifyNoMultipleWriters(metadataFiles, prefixFunction);  
        );
     *         If pinned timestamps are not enabled, returns a copy of the input list.  
        long lastSuccessfulFetchOfPinnedTimestamps
                newPinnedTimestamps.add(pinnedTimestamp);
        List<String> metadataFilesWithMinAge = new ArrayList<>();  
        String binaryEncoding = String.format(Locale.ROOT, "%64s", Long.toBinaryString(value)).replace(' ', '0');
        return RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(
     * @param getTimestampFunction A function that extracts the timestamp from a metadata file name.
                }  
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());  
    public static ClusterState finalizeMigration(ClusterState incomingState, Logger logger) {
    /**  
     */
            pinnedTimestampSet,
            return new ArrayList<>(metadataFiles);
    /**
        // does not support custom metadata.  
        });  
        return remoteCustomData;
     */
     * the cluster to `STRICT` compatibility mode  
        // To avoid this, we fail fast.
    public static Set<String> getPinnedTimestampLockedFiles(  
                implicitLockedFiles.add(cachedFile);
            .stream()  
    }
     * Filters out metadata files based on their age and pinned timestamps settings.
        ClusterUpdateSettingsRequest request,
        Set<Long> pinnedTimestampSet,
            endIdx = filename.indexOf('.');
        }
            while (currentMdTimestamp <= currentPinnedTimestamp && prevMdTimestamp > currentPinnedTimestamp) {
        // TODO: During the document replication to a remote store migration, there should be a check to determine if the registered  
        Map<String, String> remoteCustomData = indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
     * @param str long in string format to be inverted  
                assert metadataFiles.contains(cachedFile) : "Metadata files should contain [" + cachedFile + "]";
        for (IndexMetadata indexMetadata : indicesWithoutRemoteStoreSettings) {
import org.opensearch.common.collect.Tuple;
    /**  
    public static Map<String, String> determineRemoteStoreCustomMetadataDuringMigration(
 *
        }  
    }
     * @param ignorePinnedTimestampEnabledSetting A flag to ignore pinned timestamp enabled setting
import java.util.HashSet;
                .filter(idxMd -> indexHasRemoteStoreSettings(idxMd.getSettings()) == false)
    /**  
    }
     * @param pinnedTimestampSet A set of timestamps representing pinned points in time.
    public static Map<String, String> getRemoteStoreRepoName(DiscoveryNodes discoveryNodes) {  
        return URL_BASE64_CHARSET[base64DecimalValue] + binaryPart;  
import org.opensearch.cluster.ClusterState;
import org.opensearch.indices.RemoteStoreSettings;
     *
import java.util.Collections;
import java.util.Objects;  
     * This method converts the given string into long and subtracts it from Long.MAX_VALUE
import org.apache.logging.log4j.Logger;
                indexMetadata,  
        // starting with "_" until the next "_" or first ".".
     * <br>  
                            + " detected "
        Map<String, String> remoteCustomData = indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            String hashAlgoStr = remoteCustomData.get(RemoteStoreEnums.PathHashAlgorithm.NAME);
        if (remoteCustomData != null && remoteCustomData.containsKey(IndexMetadata.TRANSLOG_METADATA_KEY)) {
        Settings incomingSettings = Settings.builder().put(request.persistentSettings()).put(request.transientSettings()).build();
        metadataFilePinnedTimestampMap.keySet().retainAll(pinnedTimestampSet);  
     * Determines the remote store path strategy by reading the custom data map in IndexMetadata class.
     *
     * of node types in the cluster
    private static Metadata applyRemoteStoreSettings(
import java.util.Set;
                }  
            }  
     * @return new cluster state with index settings updated  
     * @param prefixFunction A function that extracts a tuple of prefix information from a metadata file name.
    }
            throw new IllegalArgumentException("In longToCompositeBase64AndBinaryEncoding, len must be between 7 and 64 (both inclusive)");
     * @return {@link Map} of data repository node attributes keys and their values
            );
            if (nodeIdByPrimaryTermAndGen != null) {  
            return Boolean.parseBoolean(remoteCustomData.get(IndexMetadata.TRANSLOG_METADATA_KEY));
     * @param discoveryNodes  Current {@link DiscoveryNodes} from the cluster state
        if (endIdx == -1) {
    }  
     * This must not be changed as it is used for creating path for storing remote store data on the remote store.  
        for (String metadataFileName : metadataFiles) {
     *         Always returns false if pinned timestamps are not enabled.
        Function<String, Long> getTimestampFunction,
                // Do not cache entry for latest metadata file as the next metadata can also match the same pinned timestamp
        return filename.substring(0, endIdx);  
import java.util.Base64;  
     *
        char[] characterArray = new char[LONG_MAX_LENGTH - invertedLong.length()];  
     * @param metadataFiles A list of metadata file names to be filtered.
/**  
                    throw new IllegalStateException(  
                    );
        }
     */
     */
            return new RemoteStorePathStrategy(pathType, hashAlgorithm);
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        for (String metadataFileName : metadataFiles) {
        boolean isCompatibilityModeChanging,
     *           4. For new timestamps, iterates through metadata files to find matching or closest preceding files.
import java.util.List;  
    private static List<IndexMetadata> getIndicesWithoutRemoteStoreSettings(ClusterState clusterState, Logger logger) {
 * compatible open source license.
    public static boolean isPinnedTimestampStateStale() {
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
     * @return String value of Long.MAX_VALUE - num
        }  
     * @return long value of the invert result
     */
            RemoteStoreEnums.PathHashAlgorithm hashAlgorithm = Objects.nonNull(hashAlgoStr)
     * is considered stale based on the current time and configured intervals.
            metadataFiles,
                    Metadata mutatedMetadata = applyRemoteStoreSettings(incomingState, indicesWithoutRemoteStoreSettings, logger);
import java.util.Collection;
    static long urlBase64ToLong(String base64Str) {
    }
            List<IndexMetadata> indicesWithoutRemoteSettings = allIndicesMetadata.stream()
import org.opensearch.cluster.node.DiscoveryNode;
     * @param pinnedTimestampSet A set of timestamps representing pinned points in time.
    /**
    /**
}
        Logger logger
        // Here, the segment name is "_0", which is the set of characters
import java.util.Iterator;
    }
    /**
        if (ignorePinnedTimestampEnabledSetting == false && RemoteStoreSettings.isPinnedTimestampsEnabled() == false) {  
        Settings currentClusterSettings = clusterState.metadata().settings();  
            getTimestampFunction,
     * The resultant string is guaranteed to be of the same length that of Long.MAX_VALUE. If shorter, we add left padding
    /**
        int endIdx = filename.indexOf('_', 1);  
     * Converts an input hash which occupies 64 bits of memory into a composite encoded string. The string will have 2 parts -
        List<String> metadataFiles,  
 */  
        return remoteNode.map(RemoteStoreNodeAttribute::getDataRepoNames).orElseGet(HashMap::new);  
    }
        ) == RemoteStoreNodeService.CompatibilityMode.STRICT;
            RemoteMigrationIndexMetadataUpdater indexMetadataUpdater = new RemoteMigrationIndexMetadataUpdater(  
     *           2. Updates the cache (metadataFilePinnedTimestampMap) to remove outdated entries.
        Map<String, String> nodesByPrimaryTermAndGen = new HashMap<>();  
                    metadataFilePinnedTimestampMap.put(currentPinnedTimestamp, metadataFileName);  
    ) {  
            );  
        String binaryPart = binaryEncoding.substring(6, len);  
        Function<String, Long> getTimestampFunction,  
     * Generates the remote store path type information to be added to custom data of index metadata during migration
    /**
        ClusterState currentState,  
    /**  
            return false;  
        Map<String, String> remoteCustomData = indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
     * Finalizes the docrep to remote-store migration process by applying remote store based index settings
        if (len < 7 || len > 64) {
     * @param lastSuccessfulFetchOfPinnedTimestamps The timestamp of the last successful fetch of pinned timestamps.
     * and a configured lookback interval.  
            pinnedTimestampSet,  
        boolean blobStoreMetadataEnabled = false;
                } else {  
        return currentState;  
                logger
public class RemoteStoreUtils {
        return implicitLockedFiles;
            return finalizeMigration(currentState, logger);
        Logger logger
            .millis();
            return implicitLockedFiles;
                if (indicesWithoutRemoteStoreSettings.isEmpty() == true) {
     *  
import java.util.Optional;
    public static boolean determineTranslogMetadataEnabled(IndexMetadata indexMetadata) {
