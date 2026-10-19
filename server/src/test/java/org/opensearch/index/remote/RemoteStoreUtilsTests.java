        );  
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2200L)));
        metadataFilePinnedTimestampCache = new HashMap<>();
        "node-1"
        String mdFilename2 = tm2.getFileName();
        // Now we cache all the matches except the last one.
        char ch = encodedValue.charAt(0);  
        // This is still 0 as we don't cache the latest metadata file as it can change  
            METADATA_SEPARATOR,  
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
                indexShardRoutingTable.addShard(  
        Map<Long, String> metadataFiles = metadataAndLocks.v1();  
        assertEquals(0, implicitLockedFiles.size());  
            long value = randomLong();  
        assertEquals(1, metadataFilePinnedTimestampCache.size());
            Map.of(7002L, 6L, 6999L, 3L, 6998L, 4L, 6995L, 5L, 6990L, 5L),  
import org.opensearch.cluster.routing.ShardRoutingState;
        );
            Set.of(800L, 900L, 1000L, 2000L, 3000L),
        }  
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
    private void setupRemotePinnedTimestampFeature(boolean enabled) {
            metadataFilePinnedTimestampCache
            "3OgIYbXSXPw",  
        List<String> expected = Arrays.asList(file1, file2);
            AssertionError.class,
            8422273604115462710L,  
        // Pinned timestamps 800, 900, 1000, 2000  
        Map<String, String> remoteStoreNodeAttributes = new HashMap<>();
        assertTrue(mutatedMetadata.index(migratedIndex).getVersion() > docrepIdxMetadata.index(migratedIndex).getVersion());
        12,
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
        assertEquals("_", RemoteStoreUtils.getSegmentName("_.dvm"));
            5569654857969679538L,
            -5147010836697060622L,
            System.currentTimeMillis()
        String file2 = (System.currentTimeMillis() + 300000) + "_file2.txt";  
    }  
            Set.of(4000L, 5000L, 6000L, 7000L),  
    public void testGetRemoteStoreRepoNameWithDocrepNdoes() {  
            IllegalStateException.class,  
        // Pinned timestamps 800, 900
        // 6 - 7002  
        implicitLockedFiles = metadataAndLocks.v2();  
                metadataFilePinnedTimestampCache,
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
            new HashMap<>(),
            "s11001001010100",
        TranslogTransferMetadata tm = new TranslogTransferMetadata(1, 1, 1, 2, "node--1");
        List<String> metadataFiles = Arrays.asList(file1, file2, file3);  
    }
        List<String> metadataFiles = new ArrayList<>();
        assertEquals(0, metadataFilePinnedTimestampCache.size());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );
import org.opensearch.cluster.routing.IndexRoutingTable;
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
            5569654857969679538L,
        // Metadata with timestamp 1001, 1900, 2300, 3000, 3001, 5500, 6000
        // Metadata timestamp 1000 <= Pinned Timestamp 1000  
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(metadata);
            Set.of(800L, 900L, 1000L, 2000L),
        String file2 = (System.currentTimeMillis() - 300000) + "_file2.txt";  
import java.util.stream.Collectors;  
        23,
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
        assertEquals(docrepIdxMetadata.index(docrepIndex).getVersion(), mutatedMetadata.index(docrepIndex).getVersion());
        // Metadata timestamp 2300 <= Pinned Timestamp 4000  
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
            )  
        DiscoveryNode remoteNode2 = new DiscoveryNode(  
                Set.of(3000L, 4000L, 5000L, 6000L),
        "node-2"
    }  
        implicitLockedFiles = metadataAndLocks.v2();
            String expectedCompositeEncoding = entry.getValue();  
    public void testFilterOutMetadataFilesBasedOnAge_AllFilesTooNew() {
        implicitLockedFiles = metadataAndLocks.v2();  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        );
                );
                metadataFilePinnedTimestampCache,  
            UUIDs.base64UUID(),
        setupRemotePinnedTimestampFeature(true);  
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(index, 0);
    ) {
    public void testVerifyMultipleWriters_Segment() {
            Settings.builder().put(CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), enabled).build(),
    public void testGetPinnedTimestampLockedFilesFeatureDisabled() {  
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(  
        remoteStoreNodeAttributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-repo-1");
        assertEquals("0000000000000001234", RemoteStoreUtils.invertLong(9223372036854774573L));  
        assertEquals(1234, RemoteStoreUtils.invertLong("9223372036854774573"));
        metadataFilePinnedTimestampCache = new HashMap<>();
    private final String metadataFilename2 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            -5878421770170594047L,  
        }
        // Pinned timestamps 800, 900, 1000
            -1563884000447039930L,  
        // 5 - 6990  
            assertEquals(expectedCompositeEncoding, actualCompositeEncoding);
            metadataFilePinnedTimestampCache
            String metadataPrefix = "metadata__" + primaryTerm + "__2__3__4__5__";
    public void testLongToBase64() {
        metadataFilePinnedTimestampCache = new HashMap<>();
            List.of(990L, 995L),
    public void testFinalizeMigrationWithAllRemoteNodes() {
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3001L)));
            Set.of(2000L, 3000L, 4000L, 5000L),  
        assertEquals(0, metadataFilePinnedTimestampCache.size());
            "6kv3yZNv9kY"
        int iters = randomInt(1000);
import org.opensearch.cluster.metadata.IndexMetadata;
        // Pinned timestamp 7000
        List<String> metadataFiles = Arrays.asList();
            "u0010010010001001001110100111111111100101011110101011110010",  
        setupRemotePinnedTimestampFeature(true);  
        assertEquals(1, implicitLockedFiles.size());  
        metadataFiles = metadataAndLocks.v1();
        // 5 - 6998  
            metadataFiles,  
        34,
import org.opensearch.cluster.ClusterName;  
        1,
        assertEquals(0, RemoteStoreUtils.invertLong(RemoteStoreUtils.invertLong(0)));
        assertEquals(metadataFiles.get(1900L), metadataFilePinnedTimestampCache.get(2000L));  
        String metadataPrefix = "metadata__1__2__3__4__5__";
            () -> testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            Set.of(3000L, 4000L, 5000L, 6000L),  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(5010L)));  
    static long compositeUrlBase64BinaryEncodingToLong(String encodedValue) {
    public void testGetSegmentNameException() {  
                .put(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.getKey(), "dummy-tlog-repo")  
    private RoutingTable createRoutingTableAllShardsStarted(  
            .build();  
        // 6 - 6999
        metadataFiles = metadataAndLocks.v1();
            metadataFilePinnedTimestampCache  
import java.util.UUID;
        assertEquals(1, implicitLockedFiles.size());  
            metadataFiles.put(metadataFileTimestamp, metadataPrefix + RemoteStoreUtils.invertLong(metadataFileTimestamp) + "__1");
    private static String index = "test-index";
            List.of(990L),
            .nodes(discoveryNodes)  
            "r1001101011101001101000101110010101000011110000110100000001",
     */
            SEPARATOR,
        implicitLockedFiles = metadataAndLocks.v2();
            );
        // Metadata timestamp 990 <= Pinned Timestamp 1000
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);  
        1,
        for (Long metadataFileTimestamp : metadataFileTimestamps) {
        assertEquals(3, implicitLockedFiles.size());
    }
            String primaryTerm = RemoteStoreUtils.invertLong(metadataFileTimestampPrimaryTerm.getValue());  
            TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1001L)));  
        String binaryString = base64PartBinary + encodedValue.substring(1);  
            "r10011010111010",  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            "T01010010110110",
            .routingTable(createRoutingTableAllShardsStarted(docrepIndex, 1, 1, docrepNode1, docrepNode2))
        // 5 - 6995
            "d0011100001111011010011100001000110011100110111101000110110",
        String base64PartBinary = Integer.toBinaryString(base64BitsIntValue);
import java.util.LinkedList;
    Gives segment metadata filename for <2.11 version
            List.of(990L, 995L, 1000L, 1001L, 1900L, 2300L),
        );
            Set.of(800L, 900L, 1000L, 2000L, 3000L, 4000L, 5000L),  
        // Primary Term - Timestamp in md file  
        // Primary Term - Timestamp in md file
        );  
        TranslogTransferMetadata tm3 = new TranslogTransferMetadata(1, 1, 1, 2, "node--2");
        assertEquals(metadataFiles, result);
                .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
/*  
        // Primary Term - Timestamp in md file
    );
        String mdFilename = tm.getFileName();
        );
public class RemoteStoreUtilsTests extends OpenSearchTestCase {
        // Metadata with timestamp 990, 995, 1000
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX;
            -5749656451579835857L,  
            "u00100100100010",
        assertEquals(0, implicitLockedFiles.size());  
        assertEquals(2, implicitLockedFiles.size());
        }
        Set<Long> pinnedTimestampSet = new HashSet<>(Arrays.asList(1L, 2L, 3L));
        );  
import org.opensearch.cluster.routing.RoutingTable;  
    private void assertDocrepSettingsApplied(IndexMetadata indexMetadata) {
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(4000L));
    private static Metadata createIndexMetadataWithRemoteStoreSettings(String indexName, int option) {
        // Now we cache all the matches except the last one.
        assertEquals(expected, result);
        // Pinned timestamps 4000, 5000, 6000, 7000
        assertEquals(3, metadataFilePinnedTimestampCache.size());
    public void testGetRemoteStoreRepoNameWithRemoteNodes() {
            Set.of(4000L, 5000L, 6000L, 7000L),
        for (Map.Entry<Long, String> entry : longToExpectedBase64String.entrySet()) {
            metadataFilePinnedTimestampCache
            metadataFiles,  
        mdFiles.add(metadataFilename);  
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(indexName);
        Set<Long> pinnedTimestampSet = Collections.emptySet();  
        );
        assertThrows(AssertionError.class, () -> determineTranslogMetadataEnabled(indexMetadata));
        Map<Long, String> metadataFiles = metadataAndLocks.v1();  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2000L)));  
        // Primary Term - Timestamp in md file
import java.util.Set;
        metadataFiles = metadataAndLocks.v1();
        DiscoveryNode docrepNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);  
    }
        // No metadata matches the timestamp  
        IndexMetadata indexMetadata = metadata.index(index);  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
import java.util.ArrayList;
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
        metadataFilePinnedTimestampCache = new HashMap<>();
            metadataFilePinnedTimestampCache
    }
        ).putCustom(REMOTE_STORE_CUSTOM_KEY, getCustomDataMap(option)).build();
import static org.opensearch.index.remote.RemoteStoreUtils.isSwitchToStrictCompatibilityMode;  
import static org.opensearch.index.remote.RemoteStoreUtils.URL_BASE64_CHARSET;  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1900L)));  
    private final String metadataFilename = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            List.of(990L, 995L, 1000L, 1001L, 1900L, 2300L),
        assertEquals(ReplicationType.SEGMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));
        Settings mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "strict").build();
    }
            for (int j = 0; j < numberOfReplicas; j++) {
                    TestShardRouting.newShardRouting(shardId, replicaHostingNode.getId(), false, ShardRoutingState.STARTED)
        for (int i = 0; i < randomIntBetween(5, 10); i++) {  
        IndexMetadata indexMetadata = metadata.index(index);  
        assertFalse(determineTranslogMetadataEnabled(indexMetadata));
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
        Settings mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "strict").build();  
        request.persistentSettings(mockSettings);
        metadataFiles = metadataAndLocks.v1();
            getRemoteStoreNodeAttributes(),
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3001L)));  
    }
    }
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
        // Pinned timestamps 800, 900, 1000, 2000, 3000, 4000, 5000
 *
    }
            assertEquals(59, expectedCompositeEncoding.length());  
            RemoteStoreUtils.getPinnedTimestampLockedFiles(  
            metadataFilePinnedTimestampCache
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
        12,  
        List<String> metadataFiles = Collections.emptyList();  
        // Now we cache all the matches except the last one.
            assertEquals((long) entry.getKey(), urlBase64ToLong(base64Str));
        // Validate behaviour when segment name contains delimiters only  
        assertEquals(1, metadataFilePinnedTimestampCache.size());
        // Pinned timestamps 2000, 3000, 4000, 5000  
        );
        Map<Character, Integer> charToIndexMap = new HashMap<>();
        IndexMetadata indexMetadata = metadata.index(index);  
        assertEquals(1, metadataFilePinnedTimestampCache.size());  
        String migratedIndex = "migrated-index";  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        assertEquals(metadataFiles.get(2500L), metadataFilePinnedTimestampCache.get(3000L));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(995L)));  
        metadataFiles = metadataAndLocks.v1();
        RemoteStoreUtils.verifyNoMultipleWriters(
        // 6 - 6998
        setupRemotePinnedTimestampFeature(true);  
            long value = randomLong();
    }
import java.util.List;
    }
            .nodes(discoveryNodes)  
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
        1,
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("1")).build();
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
        assertEquals(2, implicitLockedFiles.size());
        );
        Map<String, String> metadata = new HashMap<>();
        List<String> metadataFiles = Arrays.asList(  
            assertEquals(num, RemoteStoreUtils.invertLong(RemoteStoreUtils.invertLong(num)));
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
            pinnedTimestampSet,
        int iters = randomInt(100);
            metadataFilePinnedTimestampCache
        assertEquals(2, metadataFilePinnedTimestampCache.size());
        }  
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
            String compositeEncoding = longToCompositeBase64AndBinaryEncoding(value, 64);
            -5147010836697060622L,
    public void testGetPinnedTimestampLockedFilesWithNullMetadataFiles() {
        return remoteStoreNodeAttributes;
        assertFalse(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));  
        Map<Long, String> longToExpectedBase64String = Map.of(  
            metadataFilePinnedTimestampCache
        setupRemotePinnedTimestampFeature(false);
    public void testVerifyMultipleWriters_Translog() throws InterruptedException {  
        }
        // Metadata timestamp 1001 <= Pinned Timestamp 3000  
            )
            bmList.stream().map(BlobMetadata::name).collect(Collectors.toList()),
        assertEquals(4, metadataFilePinnedTimestampCache.size());
            UUIDs.base64UUID(),  
import org.mockito.Mockito;
    }  
            assertEquals(entry.getValue(), base64Str);  
        assertEquals(1, metadataFilePinnedTimestampCache.size());  
    }  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2000L)));
            List.of(990L, 995L, 1000L),  
        implicitLockedFiles = metadataAndLocks.v2();
        Set<Long> pinnedTimestampSet = new HashSet<>(Arrays.asList(1L, 2L, 3L));
            "30011101000000010000110000110110101110100100101110011111100",  
    public void testInvertToStrInvalid() {  
        expected.put(RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_TLOG_REPO_NAME);
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
            String.valueOf(metadataVersion)  
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
        assertEquals(metadataFiles, result);  
    public void testGetPinnedTimestampLockedFilesWithCache() {  
            List.of(2300L, 3000L, 3001L, 5500L, 6000L),
    }
        );
        int numberOfShards,
        12,  
 * compatible open source license.
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            -5878421770170594047L,
        assertEquals(2, metadataFilePinnedTimestampCache.size());
            List.of(990L, 995L, 1000L, 1001L, 2000L, 2200L, 2500L),
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
import org.opensearch.cluster.node.DiscoveryNodes;  
        assertTrue(result.isEmpty());
        // Now we cache all the matches except the last one.  
        assertThrows(IllegalArgumentException.class, () -> RemoteStoreUtils.getSegmentName("dvd"));
        assertEquals(1, implicitLockedFiles.size());
        metadataFiles = metadataAndLocks.v1();  
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        // Metadata with timestamp 990, 995, 1000, 1001  
        setupRemotePinnedTimestampFeature(true);  
    private static Map<Character, Integer> BASE64_CHARSET_IDX_MAP;  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6990L)));  
            List.of(990L),
        String docrepIndex = "docrep-index";  
        assertEquals(Long.MAX_VALUE, RemoteStoreUtils.invertLong(RemoteStoreUtils.invertLong(Long.MAX_VALUE)));
        assertDocrepSettingsApplied(mutatedMetadata.index(docrepIndex));
            "D01000000010011",
        );  
                new ArrayList<>(metadataFiles.values()),
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
            metadataFilePinnedTimestampCache
            metadataFilePinnedTimestampCache  
            metadataFilePinnedTimestampCache
        Map<String, String> expected = new HashMap<>();  
        // 5 - 6995  
        long primaryTerm,
        return new Tuple<>(
        // 6 - 7002
        // Now we cache all the matches except the last one.
            -5537941589147079860L,
        setupRemotePinnedTimestampFeature(true);  
    }
            new HashMap<>(),
        Metadata remoteIndexMd = Metadata.builder(docrepIdxMetadata).persistentSettings(mockSettings).build();  
        metadataFiles = metadataAndLocks.v1();  
            "s0000110101000111011110101110010111000011010000101000101111",
        metadataFilePinnedTimestampCache = new HashMap<>();  
        Map<Long, String> metadataFiles = new HashMap<>();
        }  
    }  
        );
        DiscoveryNode replicaHostingNode
        }
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,  
import org.opensearch.common.collect.Tuple;  
        setupRemotePinnedTimestampFeature(false);  
        implicitLockedFiles = metadataAndLocks.v2();  
            new HashMap<>(),
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
import java.util.Map;  
        for (Map.Entry<Long, Long> metadataFileTimestampPrimaryTerm : metadataFileTimestampsPrimaryTermMap.entrySet()) {
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        // Metadata timestamp 3001 <= Pinned Timestamp 4000
 */  
        metadataFiles = metadataAndLocks.v1();  
    /**
            -2528761975013221124L,
        setupRemotePinnedTimestampFeature(true);
                pinnedTimetamps,
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1001L)));
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(4000L));  
        return new BigInteger(binaryString, 2).longValue();
            metadataFiles,  
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,  
    }  
        return String.join(
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
            "s00001101010001",  
    }
            )  
        // 5 - 6990
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
import java.util.Arrays;  
        return builder.add(indexRoutingTableBuilder.build()).build();  
        );
        List<String> metadataFiles = Arrays.asList(file1, file2, file3);  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        bmList.add(new PlainBlobMetadata(mdFilename, 1));
        List<String> mdFiles = new ArrayList<>();
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
import org.opensearch.indices.replication.common.ReplicationType;  
            -1563884000447039930L,
import static org.opensearch.index.remote.RemoteStoreUtils.finalizeMigration;
        assertTrue(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(null);
            List.of(990L, 995L, 1000L, 1001L, 2000L, 2200L),
    }  
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(metadata);
        assertEquals(metadataFiles.get(6998L), metadataFilePinnedTimestampCache.get(7000L));
            Set.of(2000L, 3000L, 4000L, 5000L),
        metadataFiles = metadataAndLocks.v1();
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTable.build());
    public void testIsServerSideEncryptionEnabledIndex_when_Custom_key_is_null() {  
    }
            metadataFiles,  
        implicitLockedFiles = metadataAndLocks.v2();  
            -5512387536280560513L,
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
            assertEquals(value, compositeUrlBase64BinaryEncodingToLong(compositeEncoding));  
            "s4AQvdu03H8",
        // Pinned timestamps 800, 900, 1000  
        // Metadata timestamp 3001 <= Pinned Timestamp 4000
            Set.of(4000L, 5000L, 6000L, 7000L),  
            Set.of(4000L, 5000L, 6000L, 7000L),
            "s1110000000000100001011110111011011101101001101110001111111",
        // 6 - 6998  
        // Metadata timestamp 1001 <= Pinned Timestamp 2000  
    }
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));  
import org.opensearch.cluster.routing.TestShardRouting;
    /*  
        metadataFilePinnedTimestampCache = new HashMap<>();  
        if (option > 1) {  
            .localNodeId(remoteNode2.getId())
        // Pinned timestamps 800, 900, 1000, 2000
    }
        assertTrue(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));  
        // 5 - 6990
        assertEquals(2, implicitLockedFiles.size());
        bmList.add(new PlainBlobMetadata(mdFilename, 1));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));  
        );
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3000L)));
            return Map.of();
                new ArrayList<>(metadataFiles.values()),
        List<String> metadataFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt");  
        remoteStoreNodeAttributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");  
        assertEquals("_", RemoteStoreUtils.getSegmentName("___.dvm"));  
        assertEquals(1, metadataFilePinnedTimestampCache.size());  
 * this file be licensed under the Apache-2.0 license or a
        // Metadata timestamp 2300 <= Pinned Timestamp 3000
        Index index = new Index(indexName, UUID.randomUUID().toString());
    private void assertRemoteSettingsApplied(IndexMetadata indexMetadata) {
        // Metadata timestamp 6000 <= Pinned Timestamp 6000  
        assertFalse(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        // 6 - 7002
        int iters = randomInt(1000);
import static org.opensearch.index.remote.RemoteStoreUtils.longToUrlBase64;
    public void testGetPinnedTimestampLockedFilesWithPinnedTimestampsDifferentPrefix() {
        Map<Long, String> metadataFilePinnedTimestampCache
        assertEquals(3, implicitLockedFiles.size());
            () -> RemoteStoreUtils.verifyNoMultipleWriters(
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(4600L)));
        assertTrue(RemoteStoreUtils.getRemoteStoreRepoName(discoveryNodes).isEmpty());
        assertEquals(1, metadataFilePinnedTimestampCache.size());
            .add(docrepNode2)
    }
        assertFalse(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));
            metadataFiles,  
            assertEquals(longToUrlBase64(entry.getKey()).charAt(0), actualCompositeEncoding.charAt(0));
        List<String> metadataFiles = null;
        Map<String, String> metadata = new HashMap<>();
        implicitLockedFiles = metadataAndLocks.v2();
        implicitLockedFiles = metadataAndLocks.v2();
            Map.of(7002L, 6L, 7005L, 5L, 6990L, 5L),
        bmList.add(new PlainBlobMetadata(mdFilename2, 1));
            IllegalStateException.class,
            RemoteStoreUtils.getPinnedTimestampLockedFiles(
        // Metadata timestamp 1001 <= Pinned Timestamp 5000
        assertTrue(determineTranslogMetadataEnabled(indexMetadata));
            assertEquals(15, entry.getValue().length());  
        2,  
        assertEquals(ReplicationType.DOCUMENT, IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(indexMetadata.getSettings()));  
            metadataFilePinnedTimestampCache
        );
        assertThrows(IllegalArgumentException.class, () -> RemoteStoreUtils.invertLong("-5"));
            .build();
                List.of(2000L, 2200L, 3001L, 4200L, 4600L, 5010L),  
        implicitLockedFiles = metadataAndLocks.v2();  
        // Metadata with timestamp 990, 995, 1000, 1001, 1900, 2300  
            List.of(990L, 995L, 1000L, 1001L),
        // Metadata timestamp 2300 <= Pinned Timestamp 3000
        );
            Map.of(7002L, 6L, 6998L, 5L, 6995L, 5L, 6990L, 5L),
        );
        request.persistentSettings(mockSettings);  
            RemoteStoreUtils.invertLong(primaryTerm),
    private static Map<String, String> getCustomDataMap(int option) {
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));
        );
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
            long num = randomLongBetween(1, Long.MAX_VALUE);
        // This is still 0 as we don't cache the latest metadata file as it can change (explained in the next test case)
        );  
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
        }
        // Pinned timestamps 800, 900, 1000, 2000
        // Now we cache all the matches except the last one.  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6995L)));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2500L)));  
        }  
            "s11100000000001",
        String file1 = (System.currentTimeMillis() - 150000) + "_file1.txt";
    }  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        assertEquals(4, implicitLockedFiles.size());
        assertTrue(IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, metadataFilePinnedTimestampCache.size());  
        setupRemotePinnedTimestampFeature(true);  
    public void testFilterOutMetadataFilesBasedOnAge_AllFilesOldEnough() {  
        BASE64_CHARSET_IDX_MAP = Collections.unmodifiableMap(charToIndexMap);
        assertEquals(expected, RemoteStoreUtils.getRemoteStoreRepoName(discoveryNodes));  
            assertEquals(entry.getValue(), base64Str);
    public void testIsServerSideEncryptionEnabledIndex_when_No_Custom_key() {
        assertThrows(  
            -5878421770170594047L,  
            .routingTable(createRoutingTableAllShardsStarted(migratedIndex, 1, 1, remoteNode1, remoteNode2))
        );  
            Set.of(800L, 900L, 1000L),
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
            Long computedHashValue = compositeUrlBase64BinaryEncodingToLong(actualCompositeEncoding);
        Map<Long, Long> metadataFileTimestampsPrimaryTermMap,
    }
            )
        // Metadata timestamp 1900 <= Pinned Timestamp 2000
        assertEquals(metadataFiles.get(2000L), metadataFilePinnedTimestampCache.get(2000L));
            .localNodeId(remoteNode1.getId())  
                pinnedTimetamps,  
        assertEquals(metadataFiles.get(1900L), metadataFilePinnedTimestampCache.get(2000L));  
        assertRemoteSettingsApplied(mutatedMetadata.index(migratedIndex));
        assertThrows(IllegalArgumentException.class, () -> RemoteStoreUtils.invertLong(-1));
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            assertEquals(11, entry.getValue().length());
        // Metadata with timestamp 990, 995, 1000, 1001
        assertEquals(0, implicitLockedFiles.size());  
        assertFalse(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));  
        13,  
    );  
        for (int i = 0; i < iters; i++) {  
        // Metadata timestamp 3001 <= Pinned Timestamp 5000
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(index, 2);
        bmList = new LinkedList<>();  
        23,
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6999L)));
            String base64Str = longToUrlBase64(value);
        assertEquals(3, implicitLockedFiles.size());  
    }
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        );
            Set.of(800L, 900L, 1000L),
            Map.of(7002L, 6L, 6998L, 6L, 6995L, 5L, 6990L, 5L),
        RoutingTable.Builder builder = RoutingTable.builder();
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(990L)));
        // Metadata timestamp 1000 <= Pinned Timestamp 1000  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeDiscoNode("1")).build();
            "s1100100101010001110111011101001000000001101010101101001100",
        }
import org.opensearch.indices.RemoteStoreSettings;
import org.opensearch.cluster.ClusterState;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        // Pinned timestamps 800, 900, 1000, 2000, 3000, 4000, 5000
    public void testDeterdetermineTranslogMetadataEnabledWhenKeyNotFound() {
        "node-1"
    }
        Set<Long> pinnedTimetamps,  
    public void testGetSegmentNameForDvmFile() {
            -5537941589147079860L,
            metadataFiles,
        expected.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_SEGMENT_REPO_NAME);
import static org.opensearch.index.remote.RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding;
import java.util.HashMap;
        // 5 - 6995
    }
        // Now we cache all the matches except the last one.
    }  
            String actualCompositeEncoding = longToCompositeBase64AndBinaryEncoding(hashValue, 64);
    public void testGetSegmentNameWeirdSegmentNameOnlyUnderscore() {
            metadataFiles,
            Set.of(800L, 900L),  
            file -> Long.valueOf(file.split("_")[0]),
import org.opensearch.common.blobstore.BlobMetadata;
        );
            -2528761975013221124L,
        implicitLockedFiles = metadataAndLocks.v2();
            metadataFilePinnedTimestampCache  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        metadataFilePinnedTimestampCache = new HashMap<>();
            -1563884000447039930L,
        );
        List<BlobMetadata> finalBmList = bmList;
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1001L)));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));
        assertEquals(1, metadataFilePinnedTimestampCache.size());
                metadataFilePinnedTimestampCache
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    public static String getOldSegmentMetadataFilename(  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.V_2_15_0)
            String.valueOf(metadataVersion)
        assertEquals(0, metadataFilePinnedTimestampCache.size());  
        IndexMetadata indexMetadata = Mockito.mock(IndexMetadata.class);
        // Validate behaviour when segment name contains delimiters only
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        assertEquals(metadataFiles.get(1900L), metadataFilePinnedTimestampCache.get(2000L));
    ) {  
        assertEquals(1, metadataFilePinnedTimestampCache.size());
    }
        for (Map.Entry<Long, String> entry : longToExpectedBase64String.entrySet()) {  
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
     */
        assertEquals(3, metadataFilePinnedTimestampCache.size());
        );
            Set.of(4000L, 5000L, 6000L, 7000L),
        assertEquals(metadataFiles.get(3000L), metadataFilePinnedTimestampCache.get(3000L));
        // 4 - 6998
        mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed").build();
        // Metadata timestamp 995 <= Pinned Timestamp 1000
            Set.of(3000L, 4000L, 5000L, 6000L),
        int numberOfReplicas,  
            937096430362711837L,  
    public void testIsServerSideEncryptionEnabledIndex_when_disabled() {  
            metadataFilePinnedTimestampCache  
            "300111010000000",
    private final String metadataFilenameDup = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
            .build();  
        Mockito.when(indexMetadata.getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY)).thenReturn(metadata);
        // Now we cache all the matches except the last one.  
        metadataFiles = metadataAndLocks.v1();  
    public void testIsPinnedTimestampStateStaleFeatureDisabled() {
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        assertThrows(  
            String base64Str = longToUrlBase64(entry.getKey());
        );
        metadataFilePinnedTimestampCache = new HashMap<>();  
        assertTrue(implicitLockedFiles.isEmpty());
    }
            RemoteStoreUtils.invertLong(uploadCounter),
            "sDUd65cNCi8",
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
            String base64Str = RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding(entry.getKey(), 20);
        setupRemotePinnedTimestampFeature(true);
            "d00111000011110",  
        assertTrue(result.isEmpty());
        assertEquals(metadataFiles.get(6990L), metadataFilePinnedTimestampCache.get(7000L));  
            "DQE8PQwOVx0",
        return Metadata.builder().put(indexMetadata).build();
import org.opensearch.cluster.metadata.Metadata;  
        Set<Long> pinnedTimestampSet = null;
    ) {  
    }  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6998L)));
        metadataFilePinnedTimestampCache = new HashMap<>();  
    }
        assertEquals(metadataFiles.get(6995L), metadataFilePinnedTimestampCache.get(7000L));
            file -> Long.valueOf(file.split("_")[0]),
            file -> Long.valueOf(file.split("_")[0]),
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(  
            }  
            assertEquals(value, urlBase64ToLong(base64Str));  
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
        implicitLockedFiles = metadataAndLocks.v2();  
    public void testGetPinnedTimestampLockedFilesWithEmptyMetadataFiles() {
        );  
            metadataFilePinnedTimestampCache  
import static org.opensearch.index.shard.IndexShardTestUtils.MOCK_SEGMENT_REPO_NAME;
        for (int i = 0; i < numberOfShards; i++) {
            System.currentTimeMillis()
        }
            "610010010111111"
            "syVHd0gGq0w",
        indexMetadata.settings(  
        ClusterState clusterStateWithDocrepIndexSettings = ClusterState.builder(ClusterName.DEFAULT)
        // 6 - 7002  
                .put(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.getKey(), "dummy-segment-repo")
                finalBmList.stream().map(BlobMetadata::name).collect(Collectors.toList()),
            "rmumi5UPDQE",
            file -> Long.valueOf(file.split("_")[0]),
        metadataFiles = metadataAndLocks.v1();  
    public void testIsSwitchToStrictCompatibilityMode() {
        assertEquals("9223372036854774573", RemoteStoreUtils.invertLong(1234));
    public void testFilterOutMetadataFilesBasedOnAgeFeatureDisabled() {
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen  
    }  
package org.opensearch.index.remote;
        assertFalse(RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexMetadata));  
            METADATA_PREFIX,
            buildNewFakeTransportAddress(),
    }
        return new Tuple<>(
        int metadataVersion
        return Map.of(
            List.of(990L, 995L, 1000L, 1001L),
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        assertEquals(9223372036854774573L, RemoteStoreUtils.invertLong("0000000000000001234"));  
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(4000L));
            buildNewFakeTransportAddress(),
     * This test checks the case when a stale writer is uploading metadata files with higher timestamp, but lower primary
        Metadata mutatedMetadata = finalizeMigration(clusterStateWithDocrepIndexSettings, logger).metadata();  
        verifyNoMultipleWriters(mdFiles, RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen);  
            new HashMap<>(),  
        Map<String, String> metadata = new HashMap<>();  
        assertTrue(implicitLockedFiles.isEmpty());  
            indexShardRoutingTable.addShard(
        metadataFiles = metadataAndLocks.v1();
        implicitLockedFiles = metadataAndLocks.v2();
            Settings.builder()
        );  
        remoteStoreNodeAttributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
        metadataFiles = metadataAndLocks.v1();  
        // 5 - 6990  
    }
import org.opensearch.Version;
        assertFalse(RemoteStoreUtils.isPinnedTimestampStateStale());
            -5512387536280560513L,  
            RemoteStoreUtils.invertLong(primaryTerm),
        Metadata docrepIdxMetadata = createIndexMetadataWithDocrepSettings(migratedIndex);
            -5147010836697060622L,
        ClusterState clusterStateWithDocrepIndexSettings = ClusterState.builder(ClusterName.DEFAULT)
        implicitLockedFiles = metadataAndLocks.v2();
    }
            pinnedTimestampSet,  
        // Pinned timestamps 2000, 3000, 4000, 5000
        Metadata mutatedMetadata = finalizeMigration(clusterStateWithDocrepIndexSettings, logger).metadata();  
        34,
            (System.currentTimeMillis() - 300000) + "_file2.txt",
        assertTrue(isSwitchToStrictCompatibilityMode(request));  
        1,  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
            file -> Long.valueOf(file.split("_")[0]),  
    public void testFilterOutMetadataFilesBasedOnAge_EmptyInputList() {
            "dummy",
        );
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        assertEquals(metadataFiles.get(4600L), metadataFilePinnedTimestampCache.get(5000L));
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1900L)));
        assertTrue(implicitLockedFiles.isEmpty());
        // Metadata timestamp 6000 <= Pinned Timestamp 7000
        // Metadata timestamp 3001 <= Pinned Timestamp 5000
            metadataFiles.put(metadataFileTimestamp, metadataPrefix + RemoteStoreUtils.invertLong(metadataFileTimestamp) + "__1");  
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
    public void testFinalizeMigrationWithAllDocrepNodes() {
            937096430362711837L,
        );
    }  
            (System.currentTimeMillis() - 450000) + "_file3.txt"  
            metadataFilePinnedTimestampCache
    private Map<String, String> getRemoteStoreNodeAttributes() {  
}
        // 5 - 7005
        implicitLockedFiles = metadataAndLocks.v2();
    );  
        // Pinned timestamp 7000
        metadata.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "true");
            Set.of(4000L, 5000L, 6000L, 7000L),  
import static org.opensearch.index.remote.RemoteStoreUtils.determineTranslogMetadataEnabled;
        setupRemotePinnedTimestampFeature(true);
        1,  
            Set.of(),
        // Metadata timestamp 2300 <= Pinned Timestamp 5000
        DiscoveryNode remoteNode1 = new DiscoveryNode(
            Set.of(800L, 900L, 1000L, 2000L, 3000L, 4000L, 5000L),
            -5537941589147079860L,  
                .build()  
        );
    }
        for (int i = 0; i < iters; i++) {  
            METADATA_PREFIX,  
import static org.opensearch.index.remote.RemoteStoreUtils.verifyNoMultipleWriters;
    }  
        Tuple<Map<Long, String>, Set<String>> metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        );
        mdFiles.add(metadataFilenameDup);
        // Metadata timestamp 1000 <= Pinned Timestamp 1000
    public void testGetPinnedTimestampLockedFilesWithPinnedTimestamps() {
                TestShardRouting.newShardRouting(shardId, primaryHostingNode.getId(), true, ShardRoutingState.STARTED)  
    }
        assertEquals(2, implicitLockedFiles.size());
        assertThrows(
            assertEquals(RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding(hashValue, 20), actualCompositeEncoding.substring(0, 15));
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();  
        Map<Long, String> longToExpectedBase64String = Map.of(
        // Metadata with timestamp 990
    public void testGetPinnedTimestampLockedFilesWithNullPinnedTimestampSet() {
    public static String getOldTranslogMetadataFilename(long primaryTerm, long generation, int metadataVersion) {
            List.of(2000L, 2200L, 2500L, 3001L, 4200L, 4600L, 5010L),
            value
        long uploadCounter,
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(  
            DiscoveryNodeRole.BUILT_IN_ROLES,
        String indexName,
    }
            (System.currentTimeMillis() - 150000) + "_file1.txt",
        setupRemotePinnedTimestampFeature(true);  
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(3001L)));  
        assertEquals(metadataFiles.get(2000L), metadataFilePinnedTimestampCache.get(2000L));
    }
    }  
            metadataFilePinnedTimestampCache  
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
        assertEquals(1, implicitLockedFiles.size());  
        );
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2500L)));  
        // Metadata timestamp 1001 <= Pinned Timestamp 2000
        // Pinned timestamps 800, 900, 1000
        );
        assertEquals(metadataFiles.get(1000L), metadataFilePinnedTimestampCache.get(1000L));  
            Version.CURRENT
        // Now we cache all the matches except the last one.
        for (int i = 0; i < 10; i++) {  
            -2528761975013221124L,
            Version.CURRENT
        Thread.sleep(1);  
    }
            Map.of(6999L, 6L, 7005L, 5L, 6990L, 5L),  
        List<Long> metadataFileTimestamps,
     * term.  
            Set.of(800L, 900L, 1000L),  
            assertEquals(longToUrlBase64(entry.getKey()).charAt(0), base64Str.charAt(0));
        setupRemotePinnedTimestampFeature(true);
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6998L)));
            long value = randomLong();
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6998L)));
        );
        // This is still 0 as we don't cache the latest metadata file as it can change
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.node.DiscoveryNode;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, implicitLockedFiles.size());
    public void testGetSegmentNameUnderscoreDelimiterOverrides() {
    }  
        // 5 - 7005  
            937096430362711837L,
            metadataFiles,
        for (int i = 0; i < iters; i++) {
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
        int base64BitsIntValue = BASE64_CHARSET_IDX_MAP.get(ch);
            metadataFilePinnedTimestampCache  
        assertEquals(1, metadataFilePinnedTimestampCache.size());  
        // 3 - 6999
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1000L)));  
        // Metadata timestamp 2300 <= Pinned Timestamp 5000
    public void testDeterdetermineTranslogMetadataEnabledWhenFalse() {
        assertEquals(1, implicitLockedFiles.size());
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(5000L));  
            RemoteStoreEnums.PathType.NAME,
        assertEquals(2, metadataFilePinnedTimestampCache.size());  
        );  
        // Pinned timestamp 7000  
        String file3 = (System.currentTimeMillis() + 450000) + "_file3.txt";
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.MetadataFilenameUtils.SEPARATOR;
    private Tuple<Map<Long, String>, Set<String>> testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
            "T0101001011011000111001010110000010110011111011110010110010",  
        // Primary Term - Timestamp in md file
import org.opensearch.common.UUIDs;  
    }
        setupRemotePinnedTimestampFeature(true);
    public void testIsServerSideEncryptionEnabledIndex_when_enabled() {
            metadataFiles,
            .localNodeId(docrepNode1.getId())  
        // 6 - 7002
            RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
        List<BlobMetadata> bmList = new LinkedList<>();  
        assertEquals(1, implicitLockedFiles.size());  
            metadataFiles,
        assertEquals(0, implicitLockedFiles.size());  
        implicitLockedFiles = metadataAndLocks.v2();
import java.math.BigInteger;
        );  
            .localNodeId(docrepNode2.getId())
    ) {
            pinnedTimestampSet,
        );  
        for (Map.Entry<Long, String> entry : longToExpectedBase64String.entrySet()) {
        // Metadata with timestamp 990, 995, 1000, 1001  
        bmList.add(new PlainBlobMetadata(tm3.getFileName(), 1));  
            assertEquals(hashValue, computedHashValue);
        metadata.put(IndexMetadata.REMOTE_STORE_SSE_ENABLED_INDEX_KEY, "false");  
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;
    private final String oldMetadataFilename = getOldSegmentMetadataFilename(12, 23, 34, 1, 1);
        // Primary Term - Timestamp in md file
            8422273604115462710L,
        assertEquals(0, metadataFilePinnedTimestampCache.size());
        );
    public void testinvert() {  
        TranslogTransferMetadata tm2 = new TranslogTransferMetadata(1, 1, 1, 2, "node--1");
        String value = (option == 1) ? "true" : "false";  
    }  
            ShardId shardId = new ShardId(index, i);  
        assertEquals(metadataFiles.get(3001L), metadataFilePinnedTimestampCache.get(5000L));
        // Metadata timestamp 3000 <= Pinned Timestamp 3000  
            -5512387536280560513L,
import java.util.Collections;
    public void testDeterdetermineTranslogMetadataEnabledWhenTrue() {
            Set.of(800L, 900L, 1000L, 2000L),  
            "uJIk6f-V6vI",  
            "TUtjlYLPvLI",  
    }
import org.opensearch.index.shard.IndexShardTestUtils;
        assertEquals("_foo", RemoteStoreUtils.getSegmentName("_foo.cfe"));
    public void testGetPinnedTimestampLockedFilesWithNoPinnedTimestamps() {  
            metadataFiles.add((System.currentTimeMillis() - randomIntBetween(-150000, 150000)) + "_file" + i + ".txt");
        return String.join(
            RemoteStoreUtils.invertLong(generation),
        34,
        Map<Long, String> longToExpectedBase64String = Map.of(  
        assertFalse(IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.exists(indexMetadata.getSettings()));
        );
            RemoteStoreUtils.invertLong(generation),  
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen  
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        Map<Long, String> metadataFilePinnedTimestampCache  
        // Metadata with timestamp 990
        Metadata docrepIdxMetadata = createIndexMetadataWithDocrepSettings(docrepIndex);
        // Metadata with timestamp 990, 995, 1000, 1001, 1900, 2300
            List.of(990L, 995L, 1000L, 1001L),
        mdFiles.add(oldMetadataFilename);
    public void testGetPinnedTimestampLockedFilesForDivergentWrites() {
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();
        Map<Long, String> metadataFiles = metadataAndLocks.v1();  
    }  
        List<String> metadataFiles = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
            .metadata(remoteIndexMd)
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
            Set.of(4000L, 5000L, 6000L, 7000L),
            RemoteStoreUtils.invertLong(translogGeneration),  
            () -> verifyNoMultipleWriters(mdFiles, RemoteSegmentStoreDirectory.MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen)
    public void testLongToCompositeUrlBase64AndBinaryEncoding() {
            RemoteStoreEnums.PathHashAlgorithm.NAME,
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_STORE_CUSTOM_KEY;
            5569654857969679538L,
        implicitLockedFiles = metadataAndLocks.v2();
        // Now we cache all the matches except the last one.
            "dummy",  
        setupRemotePinnedTimestampFeature(true);
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
            Set.of(2000L, 3000L),
        for (int i = 0; i < URL_BASE64_CHARSET.length; i++) {
        // 5 - 7001
        String file3 = (System.currentTimeMillis() + 450000) + "_file3.txt";
            IndexShardRoutingTable.Builder indexShardRoutingTable = new IndexShardRoutingTable.Builder(shardId);
 * The OpenSearch Contributors require contributions made to  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
        // Now we cache all the matches except the last one.
            metadataFilePinnedTimestampCache  
        );
    public void testInvertToLongInvalid() {  
        metadataFilePinnedTimestampCache = new HashMap<>();
import org.opensearch.common.settings.Settings;
        Map<Long, String> metadataFiles = metadataAndLocks.v1();
        assertEquals(1, implicitLockedFiles.size());
        // Metadata timestamp 1001 <= Pinned Timestamp 4000
            pinnedTimestampSet,
        String file1 = (System.currentTimeMillis() + 150000) + "_file1.txt";
            metadataFilePinnedTimestampCache
    }
        setupRemotePinnedTimestampFeature(false);  
            -5749656451579835857L,
        }
        assertEquals(1, implicitLockedFiles.size());
            8422273604115462710L,  
            charToIndexMap.put(URL_BASE64_CHARSET[i], i);  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Set<String> implicitLockedFiles = metadataAndLocks.v2();
        );  
        Metadata remoteIndexMd = Metadata.builder(docrepIdxMetadata).persistentSettings(mockSettings).build();  
        // 5 - 6990
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
    public void testGetSegmentNameForCfeFile() {  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2300L)));
        assertEquals(1, implicitLockedFiles.size());
        // Metadata timestamp 1900 <= Pinned Timestamp 2000
    }  
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
        );
import java.util.HashSet;  
        assertEquals("_bar", RemoteStoreUtils.getSegmentName("_bar_1_Lucene90_0.dvm"));
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        List<String> result = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(  
            System.currentTimeMillis()
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;  
    public void testFilterOutMetadataFilesBasedOnAge_SomeFilesTooNew() {
        metadataFiles = metadataAndLocks.v1();
        );
        assertTrue(implicitLockedFiles.isEmpty());  
            "D0100000001001111000011110100001100000011100101011100011101",
        metadataFiles = metadataAndLocks.v1();
        assertDocrepSettingsApplied(docrepIdxMetadata.index(migratedIndex));
import org.opensearch.common.settings.ClusterSettings;
                RemoteSegmentStoreDirectory.MetadataFilenameUtils::getTimestamp,
            "dOHtOEZzejY",
            metadataFiles,
            "61001001011111101111100100110010011011011111111011001000110"
        );
    private Tuple<Map<Long, String>, Set<String>> testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
        long translogGeneration,  
        DiscoveryNode docrepNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            metadataFilePinnedTimestampCache
    public void testInvertToLongValid() {
        Map<Long, String> metadataFilePinnedTimestampCache = new HashMap<>();  
        assertEquals(metadataFiles.get(6998L), metadataFilePinnedTimestampCache.get(7000L));
            Long hashValue = entry.getKey();
        implicitLockedFiles = metadataAndLocks.v2();  
            IndexMetadata.TRANSLOG_METADATA_KEY,  
            List.of(990L, 995L, 1000L, 1001L),  
        metadataFiles = metadataAndLocks.v1();
            assertEquals(RemoteStoreUtils.longToCompositeBase64AndBinaryEncoding(value, 20).charAt(0), longToUrlBase64(value).charAt(0));
        // Metadata with timestamp 990, 995  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(6000L)));
        assertTrue(RemoteStoreUtils.isPinnedTimestampStateStale());  
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(1900L)));
        // Metadata with timestamp 2300, 3000, 3001, 5500, 6000  
            metadataFilePinnedTimestampCache  
    }
            .add(docrepNode1)
        metadataFilePinnedTimestampCache = new HashMap<>();
    public void testLongToCompositeUrlBase64AndBinaryEncodingUsing20Bits() {
        // Pinned timestamp 7000  
        Map<Long, String> metadataFiles = new HashMap<>();  
        assertTrue(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.get(indexMetadata.getSettings()));
        DiscoveryNode primaryHostingNode,
            .add(remoteNode2)
        assertFalse(isSwitchToStrictCompatibilityMode(request));
        // Metadata timestamp 1900 <= Pinned Timestamp 2000
        setupRemotePinnedTimestampFeature(true);
            Map.of(7002L, 6L, 6998L, 6L, 7001L, 5L, 6990L, 5L),
        assertEquals(metadataFiles.get(6998L), metadataFilePinnedTimestampCache.get(7000L));
import org.opensearch.core.index.Index;  
            .add(remoteNode1)
    }  
            -5749656451579835857L,  
        bmList.add(new PlainBlobMetadata(getOldTranslogMetadataFilename(1, 1, 1), 1));  
        // 5 - 6990
import static org.opensearch.index.remote.RemoteStoreUtils.urlBase64ToLong;  
        // Metadata with timestamp 990, 995, 1000, 1001  
        Settings mockSettings = Settings.builder().put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "strict").build();
        mdFiles.add(metadataFilename2);
    static {  
            .metadata(remoteIndexMd)
            getRemoteStoreNodeAttributes(),  
        Metadata metadata = createIndexMetadataWithRemoteStoreSettings(index, 1);
        assertEquals(2, implicitLockedFiles.size());  
            List.of(2000L, 2200L, 2500L, 3001L, 4200L, 4600L, 5010L),
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
    public void testInvertToStrValid() {
    public void testIsPinnedTimestampStateStaleFeatureEnabled() {
        assertDocrepSettingsApplied(docrepIdxMetadata.index(docrepIndex));
        long generation,
            Set.of(800L, 900L, 1000L, 2000L),
        // Now we cache all the matches except the last one.
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
import static org.opensearch.index.shard.IndexShardTestUtils.MOCK_TLOG_REPO_NAME;  
            System.currentTimeMillis()  
            List.of(),
        assertTrue(implicitLockedFiles.contains(metadataFiles.get(2300L)));
        // Metadata timestamp 2300 <= Pinned Timestamp 4000  
        // Now we cache all the matches except the last one.  
                TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen  
            System.currentTimeMillis()  
        metadataFilePinnedTimestampCache = new HashMap<>();  
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdaterTests.createIndexMetadataWithDocrepSettings;
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(  
        metadataAndLocks = testGetPinnedTimestampLockedFilesWithPinnedTimestamps(
            metadataFilePinnedTimestampCache  
        metadataFilePinnedTimestampCache = new HashMap<>();
        );
            .build();
        }
        Set<Long> pinnedTimetamps,
        Set<String> implicitLockedFiles = metadataAndLocks.v2();  
            List.of(1001L, 1900L, 2300L, 3000L, 3001L, 5500L, 6000L),
        );  
        // Pinned timestamp 7000  
        // Pinned timestamp 7000
            long metadataFileTimestamp = metadataFileTimestampPrimaryTerm.getKey();
