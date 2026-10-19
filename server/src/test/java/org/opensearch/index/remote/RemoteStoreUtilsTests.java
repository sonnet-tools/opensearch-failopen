        // Pinned timestamps 800, 900, 1000
        1,
        bmList.add(new PlainBlobMetadata(tm3.getFileName(), 1));
        // Primary Term - Timestamp in md file
                pinnedTimetamps,
        1,
        String metadataPrefix = "metadata__1__2__3__4__5__";
            metadataFilePinnedTimestampCache
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;
        }
            )
    public void testInvertToLongInvalid() {
        return String.join(
        1,
            "dummy",
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        String file1 = (System.currentTimeMillis() - 150000) + "_file1.txt";
import static org.opensearch.index.remote.RemoteStoreUtils.determineTranslogMetadataEnabled;
    }
            String metadataPrefix = "metadata__" + primaryTerm + "__2__3__4__5__";
            TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            buildNewFakeTransportAddress(),
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(null);
        );
            assertEquals(expectedCompositeEncoding, actualCompositeEncoding);
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        );
        implicitLockedFiles = metadataAndLocks.v2();
        // Metadata timestamp 6000 <= Pinned Timestamp 7000
    public void testGetPinnedTimestampLockedFilesWithPinnedTimestampsDifferentPrefix() {
        // Metadata timestamp 1001 <= Pinned Timestamp 5000
        int iters = randomInt(100);
            "dummy",
            Version.CURRENT
            (System.currentTimeMillis() - 450000) + "_file3.txt"
            metadataFilePinnedTimestampCache
            List.of(1001L, 1900L, 2300L, 3000L, 3001L, 5500L, 6000L),
        DiscoveryNode docrepNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
    private void setupRemotePinnedTimestampFeature(boolean enabled) {
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        assertEquals(1, metadataFilePinnedTimestampCache.size());
            -5512387536280560513L,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            8422273604115462710L,
    public void testFilterOutMetadataFilesBasedOnAge_AllFilesOldEnough() {
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6998L)));
        assertDocrepSettingsApplied(docrepIdxMetadata.index(docrepIndex));
            Settings.builder()
        for (int i = 0; i < randomIntBetween(5, 10); i++) {
            assertEquals(hashValue, computedHashValue);
        assertThrows(
            metadataFiles,
            assertEquals((long) entry.getKey(), urlBase64ToLong(base64Str));
        );
        metadataFiles = metadataAndLocks.v1();
            () -> RemoteStoreUtils.verifyNoMultipleWriters(
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        }
    Gives segment metadata filename for <2.11 version
            -5147010836697060622L,
            metadataFilePinnedTimestampCache
        Settings mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "strict").build();
            metadataFiles,
    public void testGetPinnedTimestampLockedFilesWithNullPinnedTimestampSet() {
        // Now we cache all the matches except the last one.
            "s11100000000001",
    );
        assertEquals(Long.MAX_VALUE, RemoteStoreUtils.invertLong(RemoteStoreUtils.invertLong(Long.MAX_VALUE)));
        metadataFiles = metadataAndLocks.v1();
        // Now we cache all the matches except the last one.
        "node-1"
            .localNodeId(remoteNode2.getId())
        assertThrows(
        // Metadata timestamp 990 <= Pinned Timestamp 1000
            RemoteStoreUtils.getPinnedTimestampLockedFiles(
    private final String metadataFilenameDup = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            -5749656451579835857L,
        setupRemotePinnedTimestampFeature(false);
        Map<Long, String> longToExpectedBase64String = Map.of(
        for (Map.Entry<Long, String> entry : longToExpectedBase64String.entrySet()) {
    public void testInvertToLongValid() {
            for (int j = 0; j < numberOfReplicas; j++) {
        23,
        assertEquals(metadataFiles, result);
            new HashMap<>(),
            "s00001101010001",
        for (int i = 0; i < URL_BASE64_CHARSET.length; i++) {
                metadataFilePinnedTimestampCache,
        assertEquals(3, implicitLockedFiles.size());
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
            getRemoteStoreNodeAttributes(),
        );
        assertTrue(result.isEmpty());
            List.of(990L, 995L, 1000L, 1001L, 2000L, 2200L, 2500L),
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2300L)));
        String migratedIndex = "migrated-index";
import org.opensearch.cluster.ClusterName;
            .localNodeId(remoteNode1.getId())
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
        );
            Set.of(800L, 900L, 1000L, 2000L),
        for (Map.Entry<Long, Long> metadataFileTimestampPrimaryTerm : metadataFileTimestampsPrimaryTermMap.entrySet()) {
        String file3 = (System.currentTimeMillis() + 450000) + "_file3.txt";
        assertEquals(3, implicitLockedFiles.size());
        RoutingTable.Builder builder = RoutingTable.builder();
import java.util.UUID;
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
        assertEquals(0, metadataFilePinnedTimestampCache.size());
            metadataFilePinnedTimestampCache
        assertTrue(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        String value = (option == 1) ? "true" : "false";
        // Metadata with timestamp 990, 995, 1000, 1001
        int numberOfReplicas,
        // Metadata with timestamp 990, 995, 1000
    public void testFinalizeMigrationWithAllRemoteNodes() {
            .build();
        assertEquals(1, implicitLockedFiles.size());
            metadataFilePinnedTimestampCache
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            assertEquals(num, RemoteStoreUtils.invertLong(RemoteStoreUtils.invertLong(num)));
        setupRemotePinnedTimestampFeature(true);
        assertEquals(9223372036854774573L, RemoteStoreUtils.invertLong("0000000000000001234"));
        for (int i = 0; i < iters; i++) {
        List<String> metadataFiles = null;
            List.of(990L, 995L, 1000L, 1001L, 1900L, 2300L),
            long metadataFileTimestamp = metadataFileTimestampPrimaryTerm.getKey();
        // 5 - 6990
            long value = randomLong();
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        );
        // Metadata timestamp 6000 <= Pinned Timestamp 6000
        implicitLockedFiles = metadataAndLocks.v2();
            List.of(990L, 995L),
    }
        Map<String, String> remoteStoreNodeAttributes = new HashMap<>();
            "dOHtOEZzejY",
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        1,
            937096430362711837L,
import static org.opensearch.index.remote.RemoteStoreUtils.URL_BASE64_CHARSET;
    public void testIsSwitchToStrictCompatibilityMode() {
import java.util.Set;
    }
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.MetadataFilenameUtils.SEPARATOR;
import org.opensearch.cluster.routing.RoutingTable;
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3001L)));
        assertEquals(0, RemoteStoreUtils.invertLong(RemoteStoreUtils.invertLong(0)));
    public void testGetPinnedTimestampLockedFilesWithPinnedTimestamps() {
            -5147010836697060622L,
            "TUtjlYLPvLI",
        // 6 - 7002
            metadataFiles,
    }
import org.opensearch.core.index.Index;
        implicitLockedFiles = metadataAndLocks.v2();
        assertEquals(1, implicitLockedFiles.size());
    }
        String file1 = (System.currentTimeMillis() + 150000) + "_file1.txt";
    }
        assertEquals(0, metadataFilePinnedTimestampCache.size());
            .build();
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
    public void testFilterOutMetadataFilesBasedOnAgeFeatureDisabled() {
                Set.of(3000L, 4000L, 5000L, 6000L),
    public void testGetSegmentNameException() {
        );
        ).putCustom(REMOTE_STORE_CUSTOM_KEY, getCustomDataMap(option)).build();
        metadataFiles = metadataAndLocks.v1();
    public void testInvertToStrValid() {
import org.opensearch.cluster.metadata.Metadata;
        }
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
        assertEquals(2, implicitLockedFiles.size());
            Set.of(800L, 900L),
        );
        // Metadata timestamp 1900 <= Pinned Timestamp 2000
        Metadata mutatedMetadata = finalizeMigration(clusterStateWithDocrepIndexSettings, logger).metadata();
        Map<Long, String> metadataFiles = new HashMap<>();
        // Primary Term - Timestamp in md file
        int iters = randomInt(1000);
            long value = randomLong();
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            "3OgIYbXSXPw",
        List<String> metadataFiles = Arrays.asList();
        // Pinned timestamps 2000, 3000, 4000, 5000
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
            Set.of(800L, 900L, 1000L),
    }
            .routingTable(createRoutingTableAllShardsStarted(migratedIndex, 1, 1, remoteNode1, remoteNode2))
            assertEquals(59, expectedCompositeEncoding.length());
            Set.of(2000L, 3000L, 4000L, 5000L),
            metadataFiles,
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
import java.util.HashSet;
        // Metadata with timestamp 990
        );
    static long compositeUrlBase64BinaryEncodingToLong(String encodedValue) {
        // Metadata with timestamp 1001, 1900, 2300, 3000, 3001, 5500, 6000
        String file2 = (System.currentTimeMillis() + 300000) + "_file2.txt";
        setupRemotePinnedTimestampFeature(false);
            String expectedCompositeEncoding = entry.getValue();
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        // Metadata with timestamp 2300, 3000, 3001, 5500, 6000
        // Metadata timestamp 2300 <= Pinned Timestamp 3000
            -5878421770170594047L,
        // Now we cache all the matches except the last one.
            String actualCompositeEncoding = longToCompositeBase64AndBinaryEncoding(hashValue, 64);
        Set<Long> pinnedTimestampSet = new HashSet<>(Arrays.asList(1L, 2L, 3L));
        // This is still 0 as we don't cache the latest metadata file as it can change
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_2_15_0)
        // Pinned timestamps 800, 900, 1000, 2000
        assertTrue(isSwitchToStrictCompatibilityMode(request));
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            METADATA_SEPARATOR,
        assertEquals(metadataFiles.get(2000L), metadataFilePinnedTimestampCache.get(2000L));
import org.opensearch.indices.RemoteStoreSettings;
        for (Map.Entry<Long, String> entry : longToExpectedBase64String.entrySet()) {
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            .routingTable(createRoutingTableAllShardsStarted(docrepIndex, 1, 1, docrepNode1, docrepNode2))
        List<String> metadataFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1001L)));
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
    public void testinvert() {
            "d00111000011110",
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3001L)));
        );
        assertEquals(1, metadataFilePinnedTimestampCache.size());
    public void testVerifyMultipleWriters_Segment() {
        assertEquals(2, metadataFilePinnedTimestampCache.size());
        metadataFiles = metadataAndLocks.v1();
            List.of(2300L, 3000L, 3001L, 5500L, 6000L),
        assertEquals(1, metadataFilePinnedTimestampCache.size());
            long value = randomLong();
        List<String> metadataFiles = Arrays.asList(file1, file2, file3);
        setupRemotePinnedTimestampFeature(false);
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6990L)));
    public void testVerifyMultipleWriters_Translog() throws InterruptedException {
        metadata.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "true");
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(indexName);
        Set<Long> pinnedTimetamps,
public class RemoteStoreUtilsTests extends OpenSearchTestCase {
    }
        metadataFiles = metadataAndLocks.v1();
    private void assertDocrepSettingsApplied(IndexMetadata indexMetadata) {
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(index, 1);
                pinnedTimetamps,
import org.opensearch.indices.replication.common.ReplicationType;
        setupRemotePinnedTimestampFeature(true);
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1900L)));
import org.opensearch.Version;
        Index index = new Index(indexName, UUID.randomUUID().toString());
        // 5 - 6990
            "s11001001010100",
            long num = randomLongBetween(1, Long.MAX_VALUE);
            "610010010111111"
import org.opensearch.cluster.node.DiscoveryNodeRole;
        assertEquals(0, implicitLockedFiles.size());
            -5537941589147079860L,
        );
        assertEquals(2, metadataFilePinnedTimestampCache.size());
                finalBmList.stream().map(BlobMetadata::name).collect(Collectors.toList()),
/*
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
    public void testGetPinnedTimestampLockedFilesWithEmptyMetadataFiles() {
        assertFalse(RemoteStoreUtils.isPinnedTimestampStateStale());
        // 5 - 6995
            value
        Map<String, String> metadata = new HashMap<>();
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
        assertTrue(result.isEmpty());
            Set.of(4000L, 5000L, 6000L, 7000L),
        );
        request.persistentSettings(mockSettings);
        TranslogTransferMetadata tm2 = new TranslogTransferMetadata(1, 1, 1, 2, "node--1");
            return Map.of();
            metadataFilePinnedTimestampCache
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
            System.currentTimeMillis()
import org.opensearch.test.OpenSearchTestCase;
            Set.of(),
        // This is still 0 as we don't cache the latest metadata file as it can change (explained in the next test case)
            metadataFilePinnedTimestampCache
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(5000L));
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
            List.of(990L, 995L, 1000L, 1001L),
            .nodes(discoveryNodes)
    static {
    }
            RemoteStoreUtils.invertLong(generation),
            "sDUd65cNCi8",
        assertFalse(isSwitchToStrictCompatibilityMode(request));
            RemoteStoreEnums.PathType.NAME,
        assertEquals(2, implicitLockedFiles.size());
        metadataFilePinnedTimestampCache = new HashMap<>();
        23,
    }
        setupRemotePinnedTimestampFeature(true);
        // Validate behaviour when segment name contains delimiters only
    public void testDeterdetermineTranslogMetadataEnabledWhenFalse() {
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        DiscoveryNode replicaHostingNode
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3001L)));
        );
        );
        Settings mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "strict").build();
        // Metadata timestamp 2300 <= Pinned Timestamp 3000
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
        // Metadata with timestamp 990, 995, 1000, 1001, 1900, 2300
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        1,
        Metadata remoteIndexMd = Metadata.builder(docrepIdxMetadata).persistentSettings(mockSettings).build();
                TestShardRouting.newShardRouting(shardId, primaryHostingNode.getId(), true, ShardRoutingState.STARTED)
            metadataFiles,
            assertEquals(value, urlBase64ToLong(base64Str));
import org.opensearch.common.blobstore.BlobMetadata;
    }
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
            -1563884000447039930L,
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(995L)));
        assertTrue(implicitLockedFiles.isEmpty());
        assertFalse(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));
            Map.of(7002L, 6L, 6998L, 6L, 6995L, 5L, 6990L, 5L),
        List<String> metadataFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
     */
        return new Tuple<>(
            -5512387536280560513L,
        implicitLockedFiles = metadataAndLocks.v2();
    private final String metadataFilename2 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            Settings.builder().put(CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), enabled).build(),
        assertEquals(4, metadataFilePinnedTimestampCache.size());
            pinnedTimestampSet,
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
        String mdFilename = tm.getFileName();
        // Pinned timestamps 800, 900, 1000, 2000, 3000, 4000, 5000
        // 5 - 6990
            List.of(990L, 995L, 1000L),
            List.of(990L, 995L, 1000L, 1001L),
    }
    private static Map<Character, Integer> BASE64_CHARSET_IDX_MAP;
            RemoteStoreUtils.invertLong(primaryTerm),
        // 3 - 6999
            charToIndexMap.put(URL_BASE64_CHARSET[i], i);
            -2528761975013221124L,
 */
        assertFalse(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        mdFiles.add(metadataFilename2);
            metadataFilePinnedTimestampCache
            assertEquals(15, entry.getValue().length());
            Set.of(4000L, 5000L, 6000L, 7000L),
        indexMetadata.settings(
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
        assertEquals("_", RemoteStoreUtils.getSegmentName("___.dvm"));
            Set.of(800L, 900L, 1000L, 2000L, 3000L, 4000L, 5000L),
import static org.opensearch.index.remote.RemoteStoreUtils.longToUrlBase64;
            RemoteStoreUtils.getPinnedTimestampLockedFiles(
        bmList = new LinkedList<>();
    }
            metadataFilePinnedTimestampCache
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Primary Term - Timestamp in md file
        assertTrue(RemoteStoreUtils.isPinnedTimestampStateStale());
        // Pinned timestamps 800, 900
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
        Metadata docrepIdxMetadata = createIndexMetadataWithDocrepSettings(migratedIndex);
        metadataFilePinnedTimestampCache = new HashMap<>();
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2500L)));
        Map<String, String> metadata = new HashMap<>();
            assertEquals(RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding(hashValue, 20), actualCompositeEncoding.substring(0, 15));
    );
        }
        // 5 - 6998
        // Metadata with timestamp 990
    }
        );
        implicitLockedFiles = metadataAndLocks.v2();
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            AssertionError.class,
            -5749656451579835857L,
            Set.of(800L, 900L, 1000L, 2000L, 3000L, 4000L, 5000L),
    public void testGetPinnedTimestampLockedFilesForDivergentWrites() {
            Version.CURRENT
        assertEquals(metadataFiles.get(6998L), metadataFilePinnedTimestampCache.get(7000L));
     * term.
            new HashMap<>(),
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
            "300111010000000",
        assertTrue(implicitLockedFiles.isEmpty());
            "T01010010110110",
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        // Metadata timestamp 1900 <= Pinned Timestamp 2000
        );
        IndexMetadata indexMetadata = metadata.index(index);
            file -> Long.valueOf(file.split("_")[0]),
            -5537941589147079860L,
        metadataFilePinnedTimestampCache = new HashMap<>();
}
            Set.of(3000L, 4000L, 5000L, 6000L),
    }
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_STORE_CUSTOM_KEY;
                    TestShardRouting.newShardRouting(shardId, replicaHostingNode.getId(), false, ShardRoutingState.STARTED)
        // Pinned timestamp 7000
    }
            List.of(990L),
            Long hashValue = entry.getKey();
            String primaryTerm = RemoteStoreUtils.invertLong(metadataFileTimestampPrimaryTerm.getValue());
    public void testGetPinnedTimestampLockedFilesWithCache() {
                .put(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.getKey(), "dummy-segment-repo")
        assertEquals(ReplicationType.DOCUMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));
        // Primary Term - Timestamp in md file
    }
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
            -1563884000447039930L,
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(5000L));
        );
        List<BlobMetadata> bmList = new LinkedList<>();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.index.shard.IndexShardTestUtils;
    }
                TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen
            assertEquals(longToUrlBase64(entry.getKey()).charAt(0), base64Str.charAt(0));
        // Metadata timestamp 1001 <= Pinned Timestamp 4000
        assertEquals(1, implicitLockedFiles.size());
    }
            assertEquals(value, compositeUrlBase64BinaryEncodingToLong(compositeEncoding));
        String indexName,
            RemoteStoreEnums.PathHashAlgorithm.NAME,
            "d0011100001111011010011100001000110011100110111101000110110",
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
            metadataFilePinnedTimestampCache
    }
    private Tuple<Map<Long, String>, Set<String>> testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        String docrepIndex = "docrep-index";
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(metadataFiles, result);
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        List<String> metadataFiles = Collections.emptyList();
        );
        }
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
            Set.of(800L, 900L, 1000L, 2000L),
        // Metadata with timestamp 990, 995, 1000, 1001
            .add(docrepNode1)
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1001L)));
        metadataFilePinnedTimestampCache = new HashMap<>();
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(4600L)));
        // 6 - 6999
        assertEquals(metadataFiles.get(2000L), metadataFilePinnedTimestampCache.get(2000L));
    public void testLongToBase64() {
        assertThrows(IllegalArgumentException.class, () -> RemoteStoreUtils.invertLong(-1));
        // 5 - 6990
        return new BigInteger(binaryString, 2).longValue();
            metadataFiles,
        }
            String.valueOf(metadataVersion)
        assertEquals(metadataFiles.get(6998L), metadataFilePinnedTimestampCache.get(7000L));
            .add(remoteNode2)
        assertTrue(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        // Pinned timestamps 800, 900, 1000, 2000, 3000, 4000, 5000
            "s1110000000000100001011110111011011101101001101110001111111",
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(990L)));
            new HashMap<>(),
        );
        // Metadata timestamp 995 <= Pinned Timestamp 1000
        );
    }
        assertEquals(metadataFiles.get(1900L), metadataFilePinnedTimestampCache.get(2000L));
        setupRemotePinnedTimestampFeature(true);
            -5749656451579835857L,
 * compatible open source license.
            metadataFilePinnedTimestampCache
        // Now we cache all the matches except the last one.
        assertDocrepSettingsApplied(mutatedMetadata.index(docrepIndex));
    }
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
    private static Map<String, String> getCustomDataMap(int option) {
        assertEquals(1234, RemoteStoreUtils.invertLong("9223372036854774573"));
            "s0000110101000111011110101110010111000011010000101000101111",
        DiscoveryNode remoteNode2 = new DiscoveryNode(
        );
            metadataFilePinnedTimestampCache
        Map<Long, String> longToExpectedBase64String = Map.of(
        12,
            -5537941589147079860L,
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6998L)));
        Map<String, String> expected = new HashMap<>();
    }
        metadataFilePinnedTimestampCache = new HashMap<>();
            Set.of(4000L, 5000L, 6000L, 7000L),
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeDiscoNode("1")).build();
            metadataFiles,
        assertTrue(RemoteStoreUtils.getRemoteStoreRepoName(discoveryNodes).isEmpty());
                .put(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey(), "dummy-tlog-repo")
            DiscoveryNodeRole.BUILT_IN_ROLES,
import java.util.Map;
            IllegalStateException.class,
            )
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        metadataFilePinnedTimestampCache = new HashMap<>();
    }
        String file2 = (System.currentTimeMillis() - 300000) + "_file2.txt";
            -5147010836697060622L,
        assertFalse(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));
            List.of(990L, 995L, 1000L, 1001L, 1900L, 2300L),
        );
        setupRemotePinnedTimestampFeature(true);
    public void testFilterOutMetadataFilesBasedOnAge_AllFilesTooNew() {
        );
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        setupRemotePinnedTimestampFeature(true);
        return Map.of(
        remoteStoreNodeAttributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
    ) {
        );
        }
        "node-1"
        return new Tuple<>(
            metadataFilePinnedTimestampCache
        Map<Long, Long> metadataFileTimestampsPrimaryTermMap,
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        expected.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_SEGMENT_REPO_NAME);
            Set.of(4000L, 5000L, 6000L, 7000L),
        assertEquals(1, implicitLockedFiles.size());
        // 6 - 7002
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(metadata);
        implicitLockedFiles = metadataAndLocks.v2();
        TranslogTransferMetadata tm = new TranslogTransferMetadata(1, 1, 1, 2, "node--1");
        return builder.add(indexRoutingTableBuilder.build()).build();
            Set.of(4000L, 5000L, 6000L, 7000L),
            String base64Str = RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding(entry.getKey(), 20);
import java.util.List;
    private Tuple<Map<Long, String>, Set<String>> testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        assertEquals(1, implicitLockedFiles.size());
            () -> testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            metadataFiles,
    public void testFilterOutMetadataFilesBasedOnAge_SomeFilesTooNew() {
        assertEquals(docrepIdxMetadata.index(docrepIndex).getVersion(), mutatedMetadata.index(docrepIndex).getVersion());
            buildNewFakeTransportAddress(),
import static org.opensearch.index.remote.RemoteStoreUtils.isSwitchToStrictCompatibilityMode;
            System.currentTimeMillis()
        List<String> expected = Arrays.asList(file1, file2);
 *
            Set.of(800L, 900L, 1000L, 2000L),
        int base64BitsIntValue = BASE64_CHARSET_IDX_MAP.get(ch);
        implicitLockedFiles = metadataAndLocks.v2();
        // Primary Term - Timestamp in md file
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2200L)));
        // 5 - 6990
        assertFalse(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
            .localNodeId(docrepNode2.getId())
                .build()
            assertEquals(longToUrlBase64(entry.getKey()).charAt(0), actualCompositeEncoding.charAt(0));
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
    }
        List<String> metadataFiles = new ArrayList<>();
        assertFalse(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        implicitLockedFiles = metadataAndLocks.v2();
            Map.of(6999L, 6L, 7005L, 5L, 6990L, 5L),
    private RoutingTable createRoutingTableAllShardsStarted(
    }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            List.of(990L, 995L, 1000L, 1001L),
    private static Metadata createIndexMetadataWithRemoteStoreSettings(String indexName, int option) {
        Set<Long> pinnedTimestampSet = new HashSet<>(Arrays.asList(1L, 2L, 3L));
            "rmumi5UPDQE",
            "r10011010111010",
    public void testIsPinnedTimestampStateStaleFeatureDisabled() {
    }
        BASE64_CHARSET_IDX_MAP = Collections.unmodifiableMap(charToIndexMap);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            metadataFilePinnedTimestampCache
        // Now we cache all the matches except the last one.
        metadataFilePinnedTimestampCache = new HashMap<>();
        Map<Long, String> metadataFilePinnedTimestampCache
            metadataFilePinnedTimestampCache
        assertTrue(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));
import static org.opensearch.index.remote.RemoteStoreUtils.finalizeMigration;
            System.currentTimeMillis()
            -5878421770170594047L,
        Map<Long, String> longToExpectedBase64String = Map.of(
    private final String metadataFilename = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            5569654857969679538L,
            List.of(990L),
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
            metadataFiles.add((System.currentTimeMillis() - randomIntBetween(-150000, 150000)) + "_file" + i + ".txt");
import java.util.stream.Collectors;
        long uploadCounter,
            metadataFiles,
        assertFalse(determineTranslogMetadataEnabled(indexMetadata));
import org.opensearch.cluster.routing.ShardRoutingState;
        // Pinned timestamp 7000
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        // Metadata with timestamp 990, 995, 1000, 1001
        int numberOfShards,
        assertEquals(4, implicitLockedFiles.size());
            metadataFilePinnedTimestampCache
            Map.of(7002L, 6L, 6998L, 6L, 7001L, 5L, 6990L, 5L),
        List<String> metadataFiles = Arrays.asList(file1, file2, file3);
        12,
        metadataFiles = metadataAndLocks.v1();
        implicitLockedFiles = metadataAndLocks.v2();
    public void testIsServerSideEncryptionEnabledIndex_when_disabled() {
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdaterTests.createIndexMetadataWithDocrepSettings;
import java.util.Arrays;
        setupRemotePinnedTimestampFeature(true);
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1900L)));
        Set<Long> pinnedTimetamps,
     */
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("1")).build();
            Map.of(7002L, 6L, 6998L, 5L, 6995L, 5L, 6990L, 5L),
        Metadata remoteIndexMd = Metadata.builder(docrepIdxMetadata).persistentSettings(mockSettings).build();
        for (int i = 0; i < iters; i++) {
        String binaryString = base64PartBinary + encodedValue.substring(1);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
import static org.opensearch.index.shard.IndexShardTestUtils.MOCK_TLOG_REPO_NAME;
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(metadata);
            (System.currentTimeMillis() - 150000) + "_file1.txt",
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
        assertEquals(metadataFiles.get(1900L), metadataFilePinnedTimestampCache.get(2000L));
        );
        );
        char ch = encodedValue.charAt(0);
        implicitLockedFiles = metadataAndLocks.v2();
        assertEquals(metadataFiles.get(3000L), metadataFilePinnedTimestampCache.get(3000L));
        assertEquals(2, implicitLockedFiles.size());
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1001L)));
    ) {
        ClusterState clusterStateWithDocrepIndexSettings = ClusterState.builder(ClusterName.DEFAULT)
        String base64PartBinary = Integer.toBinaryString(base64BitsIntValue);
            file -> Long.valueOf(file.split("_")[0]),
    public void testGetRemoteStoreRepoNameWithRemoteNodes() {
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(
        // Metadata timestamp 3001 <= Pinned Timestamp 4000
    public void testLongToCompositeUrlBase64AndBinaryEncodingUsing20Bits() {
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
import static org.opensearch.index.remote.RemoteStoreUtils.verifyNoMultipleWriters;
        for (Long metadataFileTimestamp : metadataFileTimestamps) {
        Metadata docrepIdxMetadata = createIndexMetadataWithDocrepSettings(docrepIndex);
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            .metadata(remoteIndexMd)
        );
        // Metadata timestamp 2300 <= Pinned Timestamp 5000
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
            .nodes(discoveryNodes)
            System.currentTimeMillis()
            file -> Long.valueOf(file.split("_")[0]),
            }
        metadataFiles = metadataAndLocks.v1();
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            List.of(),
        List<BlobMetadata> finalBmList = bmList;
        assertEquals(3, implicitLockedFiles.size());
        IndexMetadata indexMetadata = metadata.index(index);
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
        for (int i = 0; i < iters; i++) {
        assertEquals(1, implicitLockedFiles.size());
            "u00100100100010",
    private void assertRemoteSettingsApplied(IndexMetadata indexMetadata) {
        assertEquals(2, implicitLockedFiles.size());
        bmList.add(new PlainBlobMetadata(getOldTranslogMetadataFilename(1, 1, 1), 1));
            .add(remoteNode1)
        List<Long> metadataFileTimestamps,
        }
            metadataFiles,
    }
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
    }
        // Pinned timestamps 4000, 5000, 6000, 7000
        assertEquals(3, metadataFilePinnedTimestampCache.size());
    public static String getOldTranslogMetadataFilename(long primaryTerm, long generation, int metadataVersion) {
        );
        implicitLockedFiles = metadataAndLocks.v2();
        metadataFilePinnedTimestampCache = new HashMap<>();
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(4000L));
    public void testDeterdetermineTranslogMetadataEnabledWhenKeyNotFound() {
            "D0100000001001111000011110100001100000011100101011100011101",
        // 6 - 7002
import org.opensearch.common.UUIDs;
            Set.of(800L, 900L, 1000L, 2000L, 3000L),
    public void testIsServerSideEncryptionEnabledIndex_when_No_Custom_key() {
import org.opensearch.core.index.shard.ShardId;
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6999L)));
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX;
    public void testGetPinnedTimestampLockedFilesWithNullMetadataFiles() {
        );
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        assertThrows(IllegalArgumentException.class, () -> RemoteStoreUtils.invertLong("-5"));
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
    }
        // Metadata with timestamp 990, 995
            String.valueOf(metadataVersion)
        // No metadata matches the timestamp
            RemoteStoreUtils.invertLong(primaryTerm),
            metadataFiles.put(metadataFileTimestamp, metadataPrefix + RemoteStoreUtils.invertLong(metadataFileTimestamp) + "__1");
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        assertEquals(1, metadataFilePinnedTimestampCache.size());
            )
        // Pinned timestamp 7000
        );
        // Now we cache all the matches except the last one.
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2300L)));
    }
        mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed").build();
        // 6 - 7002
        assertEquals(2, metadataFilePinnedTimestampCache.size());
            bmList.stream().map(BlobMetadata::name).collect(Collectors.toList()),
    public void testIsPinnedTimestampStateStaleFeatureEnabled() {
    }
        remoteStoreNodeAttributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-repo-1");
            file -> Long.valueOf(file.split("_")[0]),
        metadataFiles = metadataAndLocks.v1();
        assertEquals(2, implicitLockedFiles.size());
        // 5 - 7005
        // 6 - 6998
        );
        long primaryTerm,
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
        assertEquals(1, implicitLockedFiles.size());
            "s1100100101010001110111011101001000000001101010101101001100",
        implicitLockedFiles = metadataAndLocks.v2();
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        // 5 - 7005
        );
        // Metadata timestamp 1001 <= Pinned Timestamp 3000
            String base64Str = longToUrlBase64(entry.getKey());
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
            RemoteStoreUtils.invertLong(uploadCounter),
            Set.of(800L, 900L, 1000L),
        // Now we cache all the matches except the last one.
        metadata.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "false");
        // Metadata timestamp 2300 <= Pinned Timestamp 4000
    public void testFilterOutMetadataFilesBasedOnAge_EmptyInputList() {
        );
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
            -1563884000447039930L,
            Set.of(2000L, 3000L),
        metadataFilePinnedTimestampCache = new HashMap<>();
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
        );
            )
        assertThrows(IllegalArgumentException.class, () -> RemoteStoreUtils.getSegmentName("dvd"));
            IndexMetadata.TRANSLOG_METADATA_KEY,
    }
        2,
    private Map<String, String> getRemoteStoreNodeAttributes() {
            pinnedTimestampSet,
            pinnedTimestampSet,
        }
        expected.put(RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_TLOG_REPO_NAME);
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
        setupRemotePinnedTimestampFeature(true);
        );
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(4000L));
        }
        long translogGeneration,
        bmList.add(new PlainBlobMetadata(mdFilename, 1));
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            Set.of(4000L, 5000L, 6000L, 7000L),
        // Now we cache all the matches except the last one.
            new HashMap<>(),
    public void testLongToCompositeUrlBase64AndBinaryEncoding() {
        // Metadata timestamp 3001 <= Pinned Timestamp 4000
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(index, 2);
        // 6 - 6998
        // Now we cache all the matches except the last one.
import java.util.LinkedList;
            937096430362711837L,
        metadataFiles = metadataAndLocks.v1();
        Settings mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "strict").build();
        assertEquals(3, metadataFilePinnedTimestampCache.size());
    }
            -2528761975013221124L,
        assertTrue(implicitLockedFiles.isEmpty());
                List.of(2000L, 2200L, 3001L, 4200L, 4600L, 5010L),
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            System.currentTimeMillis()
    }
    public void testGetSegmentNameForDvmFile() {
        Thread.sleep(1);
        );
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6995L)));
    private static String index = "test-index";
    public void testIsServerSideEncryptionEnabledIndex_when_enabled() {
    }
        // Metadata with timestamp 990, 995, 1000, 1001
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3000L)));
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
    ) {
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
import org.opensearch.cluster.routing.TestShardRouting;
        12,
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
    public void testGetPinnedTimestampLockedFilesWithNoPinnedTimestamps() {
        // Primary Term - Timestamp in md file
        // 5 - 7001
        assertTrue(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        for (Map.Entry<Long, String> entry : longToExpectedBase64String.entrySet()) {
    }
    }
            5569654857969679538L,
    public void testGetSegmentNameWeirdSegmentNameOnlyUnderscore() {
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        metadataFiles = metadataAndLocks.v1();
import org.opensearch.cluster.node.DiscoveryNode;
        implicitLockedFiles = metadataAndLocks.v2();
        }
            "30011101000000010000110000110110101110100100101110011111100",
        metadataFiles = metadataAndLocks.v1();
            metadataFilePinnedTimestampCache
import org.opensearch.common.settings.Settings;
        // Now we cache all the matches except the last one.
            metadataFiles,
    public void testInvertToStrInvalid() {
            UUIDs.base64UUID(),
        assertEquals(metadataFiles.get(1900L), metadataFilePinnedTimestampCache.get(2000L));
            IllegalStateException.class,
 * The OpenSearch Contributors require contributions made to
        metadataFilePinnedTimestampCache = new HashMap<>();
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2000L)));
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
        RemoteStoreUtils.verifyNoMultipleWriters(
            indexShardRoutingTable.addShard(
        assertEquals(metadataFiles.get(2500L), metadataFilePinnedTimestampCache.get(3000L));
        );
        request.persistentSettings(mockSettings);
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
            RemoteStoreUtils.invertLong(generation),
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        // Pinned timestamp 7000
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6998L)));
    private final String oldMetadataFilename = getOldSegmentMetadataFilename(12, 23, 34, 1, 1);
            metadataFilePinnedTimestampCache
            5569654857969679538L,
        return Metadata.builder().put(indexMetadata).build();
        );
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        assertThrows(
    }
        assertEquals(0, metadataFilePinnedTimestampCache.size());
    ) {
            Map.of(7002L, 6L, 7005L, 5L, 6990L, 5L),
        Set<Long> pinnedTimestampSet = null;
            "6kv3yZNv9kY"
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
    public void testFinalizeMigrationWithAllDocrepNodes() {
            SEPARATOR,
    }
            file -> Long.valueOf(file.split("_")[0]),
        );
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
            8422273604115462710L,
                metadataFilePinnedTimestampCache,
            -5512387536280560513L,
                new ArrayList<>(metadataFiles.values()),
        if (option > 1) {
            8422273604115462710L,
        assertEquals("9223372036854774573", RemoteStoreUtils.invertLong(1234));
        DiscoveryNode remoteNode1 = new DiscoveryNode(
 * SPDX-License-Identifier: Apache-2.0
        );
        // Pinned timestamps 800, 900, 1000, 2000
    /*
            "syVHd0gGq0w",
 * this file be licensed under the Apache-2.0 license or a
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
import org.opensearch.cluster.node.DiscoveryNodes;
            Set.of(4000L, 5000L, 6000L, 7000L),
        // 5 - 6995
        assertTrue(implicitLockedFiles.isEmpty());
            UUIDs.base64UUID(),
        assertRemoteSettingsApplied(mutatedMetadata.index(migratedIndex));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(5010L)));
            Long computedHashValue = compositeUrlBase64BinaryEncodingToLong(actualCompositeEncoding);
            Set.of(3000L, 4000L, 5000L, 6000L),
        assertEquals("_foo", RemoteStoreUtils.getSegmentName("_foo.cfe"));
            assertEquals(RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding(value, 20).charAt(0), longToUrlBase64(value).charAt(0));
        // Now we cache all the matches except the last one.
    public void testDeterdetermineTranslogMetadataEnabledWhenTrue() {
        String file3 = (System.currentTimeMillis() + 450000) + "_file3.txt";
            .build();
        // Metadata timestamp 3001 <= Pinned Timestamp 5000
    public void testGetSegmentNameForCfeFile() {
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            "T0101001011011000111001010110000010110011111011110010110010",
            937096430362711837L,
        // Pinned timestamps 800, 900, 1000
        int metadataVersion
            getRemoteStoreNodeAttributes(),
            metadataFilePinnedTimestampCache
        // Metadata timestamp 3000 <= Pinned Timestamp 3000
    }
    }
            metadataFiles.put(metadataFileTimestamp, metadataPrefix + RemoteStoreUtils.invertLong(metadataFileTimestamp) + "__1");
        assertEquals(0, implicitLockedFiles.size());
            Set.of(2000L, 3000L, 4000L, 5000L),
        assertEquals(0, implicitLockedFiles.size());
                metadataFilePinnedTimestampCache
            "D01000000010011",
        );
        assertEquals("_", RemoteStoreUtils.getSegmentName("_.dvm"));
        );
        assertEquals(metadataFiles.get(4600L), metadataFilePinnedTimestampCache.get(5000L));
        // Metadata timestamp 2300 <= Pinned Timestamp 5000
        mdFiles.add(metadataFilenameDup);
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
        implicitLockedFiles = metadataAndLocks.v2();
        mdFiles.add(oldMetadataFilename);
        );
    }
            "s4AQvdu03H8",
            "61001001011111101111100100110010011011011111111011001000110"
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        List<String> mdFiles = new ArrayList<>();
import static org.opensearch.index.remote.RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding;
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
        // Metadata timestamp 3001 <= Pinned Timestamp 5000
        setupRemotePinnedTimestampFeature(true);
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2000L)));
            Map.of(7002L, 6L, 6999L, 3L, 6998L, 4L, 6995L, 5L, 6990L, 5L),
        assertEquals(metadataFiles.get(6998L), metadataFilePinnedTimestampCache.get(7000L));
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
        implicitLockedFiles = metadataAndLocks.v2();
            Set.of(800L, 900L, 1000L),
import static org.opensearch.index.shard.IndexShardTestUtils.MOCK_SEGMENT_REPO_NAME;
            RemoteStoreUtils.invertLong(translogGeneration),
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            List.of(990L, 995L, 1000L, 1001L, 2000L, 2200L),
            .build();
    public static String getOldSegmentMetadataFilename(
        Map<Long, String> metadataFilePinnedTimestampCache
        implicitLockedFiles = metadataAndLocks.v2();
            assertEquals(entry.getValue(), base64Str);
        metadataFiles = metadataAndLocks.v1();
        // Now we cache all the matches except the last one.
        34,
            metadataFilePinnedTimestampCache
            .localNodeId(docrepNode1.getId())
    );
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6000L)));
        ClusterState clusterStateWithDocrepIndexSettings = ClusterState.builder(ClusterName.DEFAULT)
    public void testGetSegmentNameUnderscoreDelimiterOverrides() {
        remoteStoreNodeAttributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");
     * This test checks the case when a stale writer is uploading metadata files with higher timestamp, but lower primary
        mdFiles.add(metadataFilename);
        assertEquals(2, implicitLockedFiles.size());
        assertEquals("_bar", RemoteStoreUtils.getSegmentName("_bar_1_Lucene90_0.dvm"));
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
            );
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        assertFalse(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));
            List.of(2000L, 2200L, 2500L, 3001L, 4200L, 4600L, 5010L),
                .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        // This is still 0 as we don't cache the latest metadata file as it can change
        setupRemotePinnedTimestampFeature(true);
import static org.opensearch.index.remote.RemoteStoreUtils.urlBase64ToLong;
import org.opensearch.cluster.ClusterState;
    }
        TranslogTransferMetadata tm3 = new TranslogTransferMetadata(1, 1, 1, 2, "node--2");
        );
        // Pinned timestamp 7000
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(4000L));
        return String.join(
        );
            assertEquals(entry.getValue(), base64Str);
            .add(docrepNode2)
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2500L)));
            List.of(990L, 995L, 1000L, 1001L),
        setupRemotePinnedTimestampFeature(true);
        assertDocrepSettingsApplied(docrepIdxMetadata.index(migratedIndex));
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
        metadataFilePinnedTimestampCache = new HashMap<>();
            String compositeEncoding = longToCompositeBase64AndBinaryEncoding(value, 64);
            METADATA_PREFIX,
        // 5 - 6990
        // Metadata with timestamp 990, 995, 1000, 1001, 1900, 2300
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
        assertEquals(expected, RemoteStoreUtils.getRemoteStoreRepoName(discoveryNodes));
    /**
        bmList.add(new PlainBlobMetadata(mdFilename2, 1));
        13,
        metadataFiles = metadataAndLocks.v1();
        implicitLockedFiles = metadataAndLocks.v2();
    }
            assertEquals(11, entry.getValue().length());
package org.opensearch.index.remote;
        metadataFiles = metadataAndLocks.v1();
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
        // 6 - 7002
    }
            pinnedTimestampSet,
        // Metadata timestamp 1900 <= Pinned Timestamp 2000
        metadataFiles = metadataAndLocks.v1();
        // Validate behaviour when segment name contains delimiters only
    public void testGetRemoteStoreRepoNameWithDocrepNdoes() {
        assertEquals(0, implicitLockedFiles.size());
        // Pinned timestamps 800, 900, 1000, 2000
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
        assertThrows(AssertionError.class, () -> determineTranslogMetadataEnabled(indexMetadata));
            "DQE8PQwOVx0",
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        );
        return remoteStoreNodeAttributes;
        assertEquals(metadataFiles.get(6990L), metadataFilePinnedTimestampCache.get(7000L));
        long generation,
            metadataFilePinnedTimestampCache
        Map<String, String> metadata = new HashMap<>();
        DiscoveryNode docrepNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
    }
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
        assertEquals(metadataFiles.get(6995L), metadataFilePinnedTimestampCache.get(7000L));
            -5878421770170594047L,
        // Pinned timestamps 2000, 3000, 4000, 5000
import java.util.ArrayList;
    }
            metadataFilePinnedTimestampCache
        setupRemotePinnedTimestampFeature(true);
import java.util.Collections;
        // 4 - 6998
    public void testGetPinnedTimestampLockedFilesFeatureDisabled() {
        assertEquals("0000000000000001234", RemoteStoreUtils.invertLong(9223372036854774573L));
import org.opensearch.common.settings.ClusterSettings;
            "u0010010010001001001110100111111111100101011110101011110010",
        int iters = randomInt(1000);
        implicitLockedFiles = metadataAndLocks.v2();
        for (int i = 0; i < 10; i++) {
        String mdFilename2 = tm2.getFileName();
                indexShardRoutingTable.addShard(
            -2528761975013221124L,
        }
    }
    public void testIsServerSideEncryptionEnabledIndex_when_Custom_key_is_null() {
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(index, 0);
        assertEquals(expected, result);
        metadataFiles = metadataAndLocks.v1();
import java.math.BigInteger;
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }
        34,
        setupRemotePinnedTimestampFeature(true);
            "r1001101011101001101000101110010101000011110000110100000001",
            "uJIk6f-V6vI",
        "node-2"
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        bmList.add(new PlainBlobMetadata(mdFilename, 1));
        for (int i = 0; i < numberOfShards; i++) {
                );
        );
        assertEquals(1, implicitLockedFiles.size());
            (System.currentTimeMillis() - 300000) + "_file2.txt",
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
import org.opensearch.cluster.routing.IndexRoutingTable;
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        assertTrue(determineTranslogMetadataEnabled(indexMetadata));
        // Pinned timestamp 7000
        setupRemotePinnedTimestampFeature(true);
        assertEquals(ReplicationType.SEGMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        assertTrue(mutatedMetadata.index(migratedIndex).getVersion() > docrepIdxMetadata.index(migratedIndex).getVersion());
            METADATA_PREFIX,
        verifyNoMultipleWriters(mdFiles, RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen);
        IndexMetadata indexMetadata = metadata.index(index);
    }
import org.mockito.Mockito;
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1900L)));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
    }
        metadataFilePinnedTimestampCache = new HashMap<>();
        }
    }
        Set<Long> pinnedTimestampSet = Collections.emptySet();
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
import java.util.HashMap;
    }
    }
        // Pinned timestamps 800, 900, 1000
            String base64Str = longToUrlBase64(value);
            ShardId shardId = new ShardId(index, i);
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(metadata);
        Map<Long, String> metadataFiles = new HashMap<>();
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
        // 5 - 6995
            .metadata(remoteIndexMd)
        // Metadata timestamp 2300 <= Pinned Timestamp 4000
        34,
                new ArrayList<>(metadataFiles.values()),
        List<String> metadataFiles = Arrays.asList(
            () -> verifyNoMultipleWriters(mdFiles, RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen)
import org.opensearch.common.collect.Tuple;
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        metadataFilePinnedTimestampCache = new HashMap<>();
        DiscoveryNode primaryHostingNode,
            List.of(2000L, 2200L, 2500L, 3001L, 4200L, 4600L, 5010L),
            metadataFilePinnedTimestampCache
        // Now we cache all the matches except the last one.
        );
        Metadata mutatedMetadata = finalizeMigration(clusterStateWithDocrepIndexSettings, logger).metadata();
        assertEquals(1, implicitLockedFiles.size());
