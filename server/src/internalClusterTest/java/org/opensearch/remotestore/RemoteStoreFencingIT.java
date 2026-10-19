        ensureGreen(INDEX_NAME);  
        internalCluster().startClusterManagerOnlyNode();
        assertTrue("expected a fencing failure but got:\n" + stackTrace, stackTrace.contains("primary fenced by remote store"));
        internalCluster().startDataOnlyNodes(2);
        String originalPrimaryNode = primaryNodeName(INDEX_NAME);
        private final long seq;
            assertThat(reclaimed.term, greaterThanOrEqualTo(competing.term));
                .get()  
     * The race window itself is not observable from an integration test, so what is asserted here is that the seal is a
import org.opensearch.ExceptionsHelper;
        // then serve from.
        private final String allocationId;  
        );  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
            return listing.filter(path -> path.getFileName().toString().startsWith(FENCE_BLOB_PREFIX))  
            ShardStats[] shards = client().admin().indices().prepareStats(INDEX_NAME).setDocs(true).get().getShards();
            this.term = term;
        // A resize requires the source to stop accepting writes; the source keeps its own fence throughout.
     * transition. A promoted copy that has been superseded — the chain is owned by another writer at a strictly higher  
            );  
                    Settings.builder()
     * replica bookkeeping must be unaffected, and the fence must still advance on every acknowledged write.
            Fence reclaimed = readFence(fenceDir);  
            assertThat("fence did not advance after an acknowledged write", current.seq, greaterThan(previous.seq));  
        assertBusy(() -> {
        }, 60, TimeUnit.SECONDS);
        BlobStoreRepository translogRepository = (BlobStoreRepository) internalCluster().getInstance(RepositoriesService.class, dataNode)
     * A resize recovers from LOCAL_SHARDS, which reaches the seal like every non-PEER recovery source. The seal must be
        assertFalse("the fence prefix must not match the translog metadata prefix", FENCE_BLOB_PREFIX.startsWith(METADATA_PREFIX));
                .prepareState()
     * {@code IndexShard}'s seal step. Asserted as a stack frame because the point being verified is <i>where</i> on the
    private Settings fencedIndexSettings(int replicaCount, Translog.Durability durability) {  
    private static Fence awaitFence(Path metadataDirectory) throws Exception {  
            assertTrue(rejection.getMessage(), rejection.getMessage().contains(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
    /**  
     * then deletes every lower-term one outright - which is what makes a higher-term takeover deterministic rather
        ensureGreen(INDEX_NAME);
        }
                indexUUID,  
            .put(remoteStoreIndexSettings(replicaCount, 1))
                "the copy was not refused at the fence seal, but with:\n" + stackTrace,
        assertFalse("fence objects missing from " + blobs, fenceBlobs.isEmpty());  
        }, 60, TimeUnit.SECONDS);  
     * The point of the fence: once another writer owns the chain, the incumbent's next upload must fail before the  
        ensureGreen(INDEX_NAME);  
        String dataNode = internalCluster().startDataOnlyNode();
                .setSettings(
        }, 60, TimeUnit.SECONDS);
    }  
                .sorted(Comparator.comparing(path -> path.getFileName().toString()))
        new RemoteStoreFence(fenceContainer, "superseding-allocation", "superseding-node", shardId).validateAndAdvance(before.term + 50);
        indexSingleDoc(INDEX_NAME);
                        .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
        indexSingleDoc(INDEX_NAME);
        indexSingleDoc(INDEX_NAME);  
        Fence beforeFailover = awaitFence(fenceDir);
                .primaryShard()  
     * The fence is on the control flow only: it shares a directory with the translog metadata files but must never be  
                    .prepareUpdateSettings()
        final int expectedDocs = numDocs;  
            numDocs++;
    public void testFenceIsExercisedWithZeroReplicas() throws Exception {  
        assertBusy(() -> {  
import org.opensearch.index.translog.transfer.RemoteStoreFence;
                .prepareResizeIndex(INDEX_NAME, targetIndex)
        String[] tokens = raw.split("\\|");
 * The OpenSearch Contributors require contributions made to  
            client().admin()  
            );
            client(),
     * leaving a superseded copy serving as a started primary.  
                .routingTable()
        new RemoteStoreFence(fenceContainer, "superseding-allocation", "superseding-node", shardId).validateAndAdvance(before.term + 50);
        assertEquals("superseded copy claimed the fence: " + after, superseding.nodeId, after.nodeId);
        return false;  
        assertTrue("fence objects leaked into the metadata listing", Collections.disjoint(metadataFiles, fenceBlobs));
            assertNotNull("primary was assigned despite being superseded", unassignedInfo);
     * On failover the fence seals over to the promoted copy: a new owner at a higher term takes the chain, which is
        int numDocs = randomIntBetween(5, 10);
        }
        indexSingleDoc(targetIndex);  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        return getShardLevelBlobPath(
        assertBusy(() -> {
        internalCluster().startClusterManagerOnlyNode();  
        );  
        Fence superseding = readFence(fenceDir);  
            .put(remoteStoreIndexSettings(0, 1))  
            String unfencedIndex = INDEX_NAME + "-default-off";
 */  
/**
            }
import org.opensearch.action.admin.indices.shrink.ResizeType;
        refresh(INDEX_NAME);
     * mistaken for one, since metadata listings drive both restore lineage and garbage collection.
            assertNotEquals("fence ownership did not move to the promoted copy", beforeFailover.nodeId, afterFailover.nodeId);
import java.util.stream.Collectors;  
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.seq, after.seq);  
        Path metadataDirectory = translogMetadataDirectory(INDEX_NAME);  
        // The promotion must abort in the seal, so the primary ends up unassigned with that failure recorded rather  
            );  
    private Path translogMetadataDirectory(String indexName) {
        // Replicas are still fed by segment replication and converge on the same doc count.  
            incumbent.term + 1
                        .putNull("index.blocks.write")
            this.nodeId = nodeId;  
import java.util.stream.Stream;
        ensureGreen(INDEX_NAME);
            this.shardId = shardId;  
     * seal which contended with the write-blocked source would fail here.  
/*  
                client().admin()
import org.opensearch.cluster.metadata.IndexMetadata;
 * Verifies that the object-store fencing token (see {@link RemoteStoreFence}) is actually exercised on the  
     * shard opens its engine, reads its restore point, and only trips later on the upload path, so the recorded  
     */
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
            return String.format(  
                .cluster()
        ).repository(REPOSITORY_2_NAME);  
    /** The {@link BlobPath} of the translog metadata directory, which is where the fence blob lives. */
        // reassignment can lift the primary term above the fence.
import static org.hamcrest.Matchers.greaterThan;
        }
 */  
        assertEquals("fence owner should be the primary's node", nodeId(dataNode), bootstrapped.nodeId);
        Fence superseding = readFence(fenceDir);  
            assertEquals(previous.term, current.term);  
     */
            blobs = listing.map(path -> path.getFileName().toString()).collect(Collectors.toSet());  
            tokens[4],  
        Fence fence = awaitFence(fenceDir);
import org.opensearch.common.blobstore.BlobPath;
            Integer.parseInt(tokens[2]),
     * the superseded term's path is gone.
                Settings.builder().put(unfencedSettings).put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false).build()
        ensureGreen(INDEX_NAME);
    }
            createIndex(unfencedIndex, unfencedSettings);
    /** The on-disk translog metadata directory backing {@link #translogMetadataBlobPath}. */  
        final String targetIndex = INDEX_NAME + "-resized";
        assertEquals("unexpected fence blob layout [" + raw + "]", 7, tokens.length);  
            this.allocationId = allocationId;
        BlobPath metadataBlobPath = translogMetadataBlobPath(INDEX_NAME);
        assertEquals(nodeId(originalPrimaryNode), before.nodeId);  
        private final long term;
import java.util.Collections;
    /**  
            String fencedIndex = INDEX_NAME + "-default-on";  
            // And the pre-existing index did not become fenced by the cluster-level flip.
        new RemoteStoreFence(fenceContainer, "competing-allocation", "competing-node", primary.shardId()).validateAndAdvance(
    public void testSupersededTermPathsAreDeletedOnTakeover() throws Exception {  
                nodeId,
            // An explicit per-index value always wins over the cluster default.
    /**  
import org.opensearch.cluster.routing.UnassignedInfo;
                .indices()
public class RemoteStoreFencingIT extends RemoteStoreBaseIntegTestCase {
 * SPDX-License-Identifier: Apache-2.0
            this.seq = seq;
            assertNotNull("primary was assigned despite being superseded", unassignedInfo);
     */  
            indexSingleDoc(unfencedIndex);
    public void testFenceSealsOverToThePromotedPrimary() throws Exception {
                    .prepareUpdateSettings()  
    }
        assertThat("resize target should claim a fresh chain", targetFence.seq, greaterThanOrEqualTo(0L));  
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
        ShardId shardId = getIndexShard(originalPrimaryNode, INDEX_NAME).shardId();
        Fence before = awaitFence(fenceDir);
        return Path.of(translogRepoPath.toString(), translogMetadataBlobPath(indexName).buildAsString());
            tokens[5],
        Fence previous = bootstrapped;
        }  
    public void testFenceBlobIsNotVisibleAsTranslogMetadata() throws Exception {  
        ensureGreen(INDEX_NAME);
        indexSingleDoc(INDEX_NAME);
        internalCluster().restartNode(dataNode);
import org.opensearch.indices.RemoteStoreSettings;  
        String dataNode = internalCluster().startDataOnlyNode();
        // primary term, and its bootstrap seals the fence back over to this node. Doc counts are deliberately not
        }
            assertAcked(
            this.indexUUID = indexUUID;
            RepositoriesService.class,
        assertEquals(expectedDocs, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());  
                )
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .index(INDEX_NAME)
        // then serve from.
        assertAcked(  
import org.opensearch.index.IndexSettings;
package org.opensearch.remotestore;
            assertEquals(replicaCount + 1, shards.length);  
        ).repository(REPOSITORY_2_NAME);  
            clusterManager
            assertEquals("false", indexSetting(optedOutIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
 *
     * write is acknowledged, rather than silently writing behind the new owner. This is the zero-replica case, where
        // term above the fence and turn the takeover into a legitimate one.
            );  
        assertEquals(nodeId(dataNode), incumbent.nodeId);
        indexSingleDoc(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        return Settings.builder()
                .index(INDEX_NAME)  
        assertEquals(numDocs, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
     * One or more replicas: fencing takes replicas off the primary term validation path, but segment replication and  
    }
import java.util.concurrent.TimeUnit;
            indexSingleDoc(fencedIndex);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalPrimaryNode));
     * switches its write witness mid-flight — toggling the fence on a live index would leave a window in which a stale
            UnassignedInfo unassignedInfo = client().admin()
        internalCluster().startDataOnlyNodes(2);
            assertNotNull("no allocation failure recorded yet: " + unassignedInfo, unassignedInfo.getFailure());
    private static Fence readFence(Path metadataDirectory) throws IOException {  
        assertBusy(() -> assertTrue("no fence object was ever created under " + metadataDirectory, fenceExists(metadataDirectory)));
import java.util.Comparator;
     */  
            createIndex(  
        internalCluster().startDataOnlyNode();
        BlobContainer fenceContainer = translogRepository.blobStore().blobContainer(metadataBlobPath);
        }
import java.nio.charset.StandardCharsets;
            // The baked-in index setting is final: the witness of a live index cannot be switched.
        if (Files.isDirectory(metadataDirectory) == false) {
            TRANSLOG,  
     */
        assertEquals(sourceFence.indexUUID, readFence(translogMetadataDirectory(INDEX_NAME)).indexUUID);
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
            String stackTrace = ExceptionsHelper.stackTrace(unassignedInfo.getFailure());
        );  
        Fence incumbent = awaitFence(fenceDir);  
        internalCluster().restartNode(dataNode);  
            .repository(REPOSITORY_2_NAME);
                .findFirst()
        // is deliberately wider than the number of allocation retries, so no reassignment can lift this node's primary  
     * replica-based primary term validation cannot help.
     * real, blocking step on the recovery path rather than something the first post-recovery upload happens to do: a  
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);  
                .shard(0)
        createIndex(INDEX_NAME, fencedIndexSettings(1, Translog.Durability.REQUEST));  
     * writes that land after the restore point the new copy read, and those acknowledged writes would be lost.  
        Fence bootstrapped = awaitFence(fenceDir);
        ensureGreen(INDEX_NAME);
    }
        // The index is unrecoverable by construction; drop it rather than leaving a red index for the test teardown.
            awaitFence(translogMetadataDirectory(fencedIndex));
            assertNotNull("no allocation failure recorded yet: " + unassignedInfo, unassignedInfo.getFailure());  
        assertEquals("superseding-node", superseding.nodeId);
                .unassignedInfo();
}  
     * otherwise a previous primary that is still alive - and still holding a valid CAS token - could keep acknowledging
        }  
     */
        Set<String> fenceBlobs = blobs.stream().filter(name -> name.startsWith(FENCE_BLOB_PREFIX)).collect(Collectors.toSet());
     * what makes the old primary's next upload fail its CAS.
    @Override
        assertEquals("superseded copy claimed the fence: " + after, superseding.nodeId, after.nodeId);  
        String raw = new String(Files.readAllBytes(currentFenceBlob(metadataDirectory)), StandardCharsets.UTF_8);
            assertEquals(previous.nodeId, current.nodeId);
     * recovery <em>at the seal</em>, never reach the restore point, and never claim the chain. Without the seal the
 * acknowledgement path, both for zero-replica indices — where no replica exists to act as a primary term validation
    private static final String SEAL_METHOD_NAME = "sealRemoteStoreFenceForRecovery";
                .cluster()
            );  
                .get()
        return readFence(metadataDirectory);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalPrimaryNode));
                .collect(Collectors.toSet());
        Set<String> metadataFiles = blobs.stream().filter(name -> name.startsWith(METADATA_PREFIX)).collect(Collectors.toSet());  
    /**  
            previous = current;
    private String nodeId(String nodeName) {
     * Seal-on-promotion, the failover twin of {@link #testASupersededCopyFailsRecoveryAtTheSeal}. A replica being
            return listing.map(path -> path.getFileName().toString())  
     * Deletion is the fencing act. Acknowledgement paths are keyed by term, so a takeover claims its own object and
            assertEquals("true", indexSetting(fencedIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));  
            "0",
    /**
     * harmless there rather than merely untested: the fence path is keyed by index UUID and a resize target is a new  
                    .setTransientSettings(Settings.builder().putNull(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey()))  
     * primary is checked against neither the fence nor the replicas.  
            Fence afterFailover = readFence(fenceDir);
        assertEquals(nodeId(originalPrimaryNode), before.nodeId);
        assertEquals("fence term should be the primary term", primary.getOperationPrimaryTerm(), bootstrapped.term);  
        try {
            assertEquals("fence was not reclaimed by the new incarnation", nodeId(dataNode), reclaimed.nodeId);
    protected boolean remoteStoreFencingForAllIndices() {
        assertThat(bootstrapped.seq, greaterThanOrEqualTo(0L));
            UnassignedInfo unassignedInfo = client().admin()  
        assertEquals("one acknowledgement path per shard at a time", 1, fenceBlobNames(fenceDir).size());  
     * recovery path the failure happens, which no exception type or message can distinguish.
        // The superseded copy neither claimed nor advanced the chain, so it cannot have read a restore point it would
        indexSingleDoc(INDEX_NAME);  
            // Cluster default off: the index is created unfenced. The key stays absent — the final index setting
                    .get()
            assertThat(
    }  
        Fence competing = readFence(fenceDir);
        // gap is deliberately wider than the number of allocation retries, so neither the promotion nor any subsequent  
    private static final class Fence {
                seq
        indexSingleDoc(INDEX_NAME);
            createIndex(fencedIndex, unfencedSettings);
        assertTrue(fenceBlobNames(fenceDir).contains(supersededPath));
        Fence sourceFence = readFence(translogMetadataDirectory(INDEX_NAME));  
        return internalCluster().getInstance(ClusterService.class, nodeName).localNode().getId();
import org.opensearch.core.index.shard.ShardId;
            Long.parseLong(tokens[3]),
        Fence after = readFence(fenceDir);
import static org.opensearch.index.translog.transfer.RemoteStoreFence.FENCE_BLOB_PREFIX;
 * this file be licensed under the Apache-2.0 license or a
            ensureGreen(unfencedIndex);  
        });
    private static Path currentFenceBlob(Path metadataDirectory) throws IOException {
     * <p>
    /** This suite manages fencing explicitly per index (and per cluster in the baking test); ignore the suite-wide flag. */  
        Settings unfencedSettings = Settings.builder()
        ensureGreen(INDEX_NAME);
                IllegalArgumentException.class,  
        for (int i = 0; i < randomIntBetween(2, 5); i++) {  
        });  
    /**  
        ensureGreen(INDEX_NAME);
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST.name())
import org.opensearch.cluster.service.ClusterService;  
    }
        assertEquals("unexpected fence codec version [" + raw + "]", "v1", tokens[0]);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));  
        String dataNode = internalCluster().startDataOnlyNode();  
        // Every allocation attempt must abort in the seal, so the shard stays unassigned with that failure recorded.
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
                () -> client().admin()
        Translog.Durability durability = randomFrom(Translog.Durability.REQUEST, Translog.Durability.ASYNC);
        // Both durabilities keep the fence on the upload path; only the replication mode of the write path differs.
 * witness — and for indices with one or more replicas, where fencing must coexist with segment replication.
        int numDocs = randomIntBetween(2, 5);
                client().admin()  
        assertEquals(nodeId(dataNode), before.nodeId);  
     * Parses the fence blob independently of {@link RemoteStoreFence}, so that the on-disk layout documented as  
import org.opensearch.index.shard.IndexShard;  
    private static boolean fenceExists(Path metadataDirectory) throws IOException {  
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.term, after.term);
        for (int i = 0; i < numDocs; i++) {
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
     * promoted to primary claims the fence before it reads its translog restore point, inside the primary term
        Exception failure = expectThrows(Exception.class, () -> indexSingleDoc(INDEX_NAME));
    }  
import org.opensearch.index.translog.Translog;
        indexSingleDoc(INDEX_NAME);
        return new Fence(
    }
    private BlobPath translogMetadataBlobPath(String indexName) {  
     */  
    }  
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.term, after.term);
                "fence term did not advance on failover: " + beforeFailover + " -> " + afterFailover,  
            return listing.anyMatch(path -> path.getFileName().toString().startsWith(FENCE_BLOB_PREFIX));
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);  
        Fence before = awaitFence(fenceDir);
        // than a superseded copy serving as a started primary.
    }
     * operators can turn fencing on or off for indices created from that point on, but an existing index never
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_PREFIX;  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;  
        internalCluster().startDataOnlyNodes(3);
        String clusterManager = internalCluster().getClusterManagerName();
        return client().admin().indices().prepareGetSettings(indexName).get().getIndexToSettings().get(indexName).get(settingKey);  
        // Failover: the replica is promoted in place. No write is issued against the promoted copy.  
                    .prepareUpdateSettings(fencedIndex)  
        indexSingleDoc(INDEX_NAME);
     * {@code v1|<indexUUID>|<shardId>|<term>|<allocationId>|<nodeId>|<seq>} is asserted rather than assumed.
        assertEquals("fence owner should be the primary's node", nodeId(primaryNode), fence.nodeId);  
        Set<String> blobs;
                .prepareState()  
        createIndex(INDEX_NAME, fencedIndexSettings(replicaCount, durability));  
            assertThat("recovery was not retried to exhaustion", unassignedInfo.getNumFailedAllocations(), greaterThan(0));  
     */
        BlobContainer fenceContainer = translogRepository.blobStore().blobContainer(metadataBlobPath);
            assertNull(indexSetting(unfencedIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));  
     */  
    public void testASupersededCopyFailsRecoveryAtTheSeal() throws Exception {  
        awaitFence(metadataDirectory);
        private final String nodeId;
import org.opensearch.common.settings.Settings;  
            IllegalArgumentException rejection = expectThrows(
    }  
        // The translog metadata lineage is still readable with the fence sitting next to it: recovering the shard from
    /**  
        }
    }
                .primaryShard()
            // Flip the cluster default on, dynamically. Only indices created afterwards are fenced.
            METADATA,
                optedOutIndex,
        assertEquals(nodeId(primaryNodeName(INDEX_NAME)), readFence(fenceDir).nodeId);  
                .get()
                .routingTable()  
            Fence after = readFence(fenceDir);  
        assertEquals("fence term should be the primary term", primary.getOperationPrimaryTerm(), fence.term);
        }, 60, TimeUnit.SECONDS);
    public void testFenceIsExercisedWithReplicas() throws Exception {  
        internalCluster().startClusterManagerOnlyNode();
        } finally {
    }
    private static Set<String> fenceBlobNames(Path metadataDirectory) throws IOException {
        assertBusy(() -> {  
        private Fence(String indexUUID, int shardId, long term, String allocationId, String nodeId, long seq) {
        }  
        assertAcked(
     * The acknowledgement-path object of the highest term present. Names embed the inverted term, so the highest term
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);  
        IndexShard primary = getIndexShard(dataNode, INDEX_NAME);
        assertBusy(() -> {
import org.opensearch.repositories.RepositoriesService;
import java.nio.file.Files;
            Fence current = readFence(fenceDir);
        }
        ShardId shardId = getIndexShard(dataNode, INDEX_NAME).shardId();
    private static final String INDEX_NAME = "remote-store-fencing-idx";
        String supersededPath = RemoteStoreFence.fenceBlobName(before.term);
            assertThat("the promoted copy did not claim a higher term", after.term, greaterThan(before.term));
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
     */
            client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put("index.blocks.write", true))
    public void testIncumbentIsFencedByACompetingOwner() throws Exception {
     * term — must therefore fail the promotion itself, never activate, and never claim the chain. Without the seal the
        String stackTrace = ExceptionsHelper.stackTrace(failure);  
            .build();
                );  
        indexSingleDoc(INDEX_NAME);  
import org.opensearch.common.blobstore.BlobContainer;
import java.io.IOException;  
                stackTrace.contains(PROMOTION_SEAL_METHOD_NAME + "(")  
        refresh(INDEX_NAME);
    /** {@code IndexShard}'s shared seal step, the frame present on both the recovery and the promotion seal paths. */  
            BlobPath.cleanPath(),
     * than a race for a shared object. Observably: after failover exactly one path remains, at the higher term, and  
        );
        public String toString() {
    }
        // The target sealed a fence of its own, under its own index UUID, and it is not the source's.  
        internalCluster().startDataOnlyNodes(2);  
                shardId,
            Set<String> paths = fenceBlobNames(fenceDir);
            );
                .filter(name -> name.startsWith(FENCE_BLOB_PREFIX))
     * The fencing gate is a <b>dynamic cluster setting</b> baked into a <b>final index setting</b> at creation time:  
        assertBusy(() -> assertThat("fence did not advance with replicas present", readFence(fenceDir).seq, greaterThan(fence.seq)));
                allocationId,  
import java.nio.file.Path;  
            // resolves to false forever, so there is no explicit false to materialize.  
                "index [%s] shard [%d] term [%d] allocation [%s] node [%s] seq [%d]",
        internalCluster().startClusterManagerOnlyNode();
            assertEquals(previous.allocationId, current.allocationId);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        // the remote store replays every acknowledged write.
        // The superseded copy neither claimed nor advanced the chain, so it cannot have read a restore point it would  
            assertTrue(
                .setResizeType(ResizeType.CLONE)  
            RepositoriesService.class,
        ensureGreen(INDEX_NAME);  
    public void testResizeTargetSealsItsOwnFreshChain() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.test.InternalTestCluster;  
                .shard(0)
                Locale.ROOT,
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false))
                afterFailover.term,
        // The index is unrecoverable by construction; drop it rather than leaving a red index for the test teardown.
            RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings())
        assertEquals(numDocs, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
        internalCluster().startClusterManagerOnlyNode();
     * sorts first - the same ordering the fence itself relies on to compare cluster-manager-issued grants.
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));  
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            return false;
                    "shard copy " + shard.getShardRouting() + " is out of sync",  
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
    /**
     */
        assertBusy(() -> assertThat(readFence(translogMetadataDirectory(targetIndex)).seq, greaterThan(targetFence.seq)));
        Fence before = awaitFence(fenceDir);
        refresh(INDEX_NAME);  
        // Stand in for a copy hydrated elsewhere that has already moved the shard well past this cluster's term. The
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.seq, after.seq);
    /**
     * copy that has been superseded - the chain is owned by another writer at a strictly higher term - must fail
        assertEquals("superseding-node", superseding.nodeId);
        String dataNode = internalCluster().startDataOnlyNode();
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
            ensureGreen(optedOutIndex);
            indexSingleDoc(INDEX_NAME);  
            ensureGreen(fencedIndex);
                        .build()  
        ensureGreen(INDEX_NAME);  
        assertEquals("competing-node", competing.nodeId);
        internalCluster().startClusterManagerOnlyNode();  
                assertEquals(
        Fence after = readFence(fenceDir);  
        BlobContainer fenceContainer = translogRepository.blobStore().blobContainer(metadataBlobPath);  
        @Override
            assertAcked(  
        BlobPath metadataBlobPath = translogMetadataBlobPath(INDEX_NAME);
                .getState()
        assertEquals(nodeId(originalPrimaryNode), beforeFailover.nodeId);  
        Fence targetFence = readFence(translogMetadataDirectory(targetIndex));
        // Stand in for a copy hydrated elsewhere that has already moved the shard well past this node's term. The gap
            indexSingleDoc(INDEX_NAME);  
        private final String indexUUID;  
        createIndex(INDEX_NAME, fencedIndexSettings(1, Translog.Durability.REQUEST));
        IndexShard primary = getIndexShard(dataNode, INDEX_NAME);  
     * Seal-before-restore. A recovering primary claims the fence <b>before</b> it reads its translog restore point:
                    expectedDocs,
            assertFalse("an unfenced index must not create a fence object", fenceExists(translogMetadataDirectory(unfencedIndex)));  
                    .indices()
                term,
                .orElseThrow(() -> new AssertionError("no fence object under " + metadataDirectory));  
        assertNotEquals("resize target must not share the source's fence object", sourceFence.indexUUID, targetFence.indexUUID);
                    .cluster()
            );
        for (int i = 0; i < numDocs; i++) {
        ensureGreen(targetIndex);
            indexSingleDoc(INDEX_NAME);
            indexName,  
        createIndex(INDEX_NAME, fencedIndexSettings(1, Translog.Durability.REQUEST));
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
            .build();
        internalCluster().startClusterManagerOnlyNode();
        IndexShard primary = getIndexShard(primaryNode, INDEX_NAME);
                .unassignedInfo();  
    }  
                    .setTransientSettings(Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey(), true))
                greaterThan(beforeFailover.term)
    }
 * compatible open source license.
            assertEquals("exactly one acknowledgement path must survive a takeover: " + paths, 1, paths.size());
        String originalPrimaryNode = primaryNodeName(INDEX_NAME);  
    }  
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)  
            tokens[1],  
     */
                .getState()
            assertNull(indexSetting(unfencedIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalPrimaryNode));
            assertTrue("recovery did not fail in the fence seal, but with:\n" + stackTrace, stackTrace.contains(SEAL_METHOD_NAME));
        BlobStoreRepository translogRepository = (BlobStoreRepository) internalCluster().getInstance(  
                    .cluster()
    /**  
        assertBusy(() -> {
        BlobStoreRepository translogRepository = (BlobStoreRepository) internalCluster().getInstance(  
    }
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));  
        // The target acknowledges writes through its own chain, and the source is still intact behind it.
    /**
import org.opensearch.action.admin.indices.stats.ShardStats;  
     * Zero replicas: the object store is the only witness, so every acknowledged write must advance the CAS chain.
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));  
     */
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability.name())
        for (int i = 0; i < randomIntBetween(2, 5); i++) {  
        ensureGreen(INDEX_NAME);
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
        // The incumbent holds a stale token, so its next upload loses the CAS and the write is never acknowledged.
     * index with its own UUID, so the target claims a fresh key namespace uncontested and has no lower-term path to
            assertTrue(paths.contains(RemoteStoreFence.fenceBlobName(after.term)));
        assertFalse("the translog metadata prefix must not match the fence prefix", METADATA_PREFIX.startsWith(FENCE_BLOB_PREFIX));
        internalCluster().startClusterManagerOnlyNode();  
     * promotion succeeds, and the fenced translog upload in {@code postActivatePrimaryMode} is logged and swallowed,
    /**
                        .put("index.number_of_replicas", 0)  
    }  
            String optedOutIndex = INDEX_NAME + "-opt-out";
    }
        assertAcked(client().admin().indices().prepareDelete(targetIndex, INDEX_NAME));
        String originalPrimaryNode = primaryNodeName(INDEX_NAME);
import java.util.Locale;  
     * allocation failure comes from a different call site and this test fails.
            for (ShardStats shard : shards) {
            assertFalse("the superseded term's path was not deleted: " + paths, paths.contains(supersededPath));  
        // asserted here - a fenced upload can leave an orphan metadata file, which is a documented follow-up.
import java.util.Set;
        int replicaCount = randomIntBetween(1, 2);  
        String clusterManager = internalCluster().getClusterManagerName();
        // A legitimate new incarnation of the shard reclaims the chain: the shard failed, is reassigned at a higher  
            String stackTrace = ExceptionsHelper.stackTrace(unassignedInfo.getFailure());  
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
        // Stand in for a copy hydrated on another node: take ownership of the chain at a higher term, out of band.  
    private String indexSetting(String indexName, String settingKey) {
        internalCluster().startDataOnlyNode();
    public void testASupersededReplicaFailsPromotionAtTheSeal() throws Exception {
    /**
            Long.parseLong(tokens[6])
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        );  
        assertFalse("no translog metadata files were written: " + blobs, metadataFiles.isEmpty());
        internalCluster().startClusterManagerOnlyNode();
        // upload, and the guarantee being verified is that the chain moves forward, never that it moves by one.
        private final int shardId;
        BlobPath metadataBlobPath = translogMetadataBlobPath(INDEX_NAME);
            indexSingleDoc(INDEX_NAME);
        }  
            clusterManager
    }
    private static final String PROMOTION_SEAL_METHOD_NAME = "sealRemoteStoreFence";
                    shard.getStats().getDocs().getCount()
     * sweep. Asserted on the target's own fence blob, and on the source remaining serviceable afterwards, so that a
    public void testClusterFencingDefaultIsBakedIntoAFinalIndexSetting() throws Exception {
        String primaryNode = primaryNodeName(INDEX_NAME);  
        // Each acknowledged write advances the chain. The exact delta is not asserted: background syncs may also  
