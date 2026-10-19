     * shard opens its engine, reads its restore point, and only trips later on the upload path, so the recorded
        // Stand in for a copy hydrated elsewhere that has already moved the shard well past this cluster's term. The
    private static Fence awaitFence(Path metadataDirectory) throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        if (Files.isDirectory(metadataDirectory) == false) {
     */
        ensureGreen(INDEX_NAME);
    private Path translogMetadataDirectory(String indexName) {
        assertEquals("superseding-node", superseding.nodeId);
     * Seal-on-promotion, the failover twin of {@link #testASupersededCopyFailsRecoveryAtTheSeal}. A replica being
        // The target acknowledges writes through its own chain, and the source is still intact behind it.
    /**
    /** This suite manages fencing explicitly per index (and per cluster in the baking test); ignore the suite-wide flag. */
        Set<String> metadataFiles = blobs.stream().filter(name -> name.startsWith(METADATA_PREFIX)).collect(Collectors.toSet());
        assertEquals(nodeId(dataNode), incumbent.nodeId);
        // Both durabilities keep the fence on the upload path; only the replication mode of the write path differs.
            assertNotNull("primary was assigned despite being superseded", unassignedInfo);
            return String.format(
    /**
            METADATA,
    }
            assertEquals("fence was not reclaimed by the new incarnation", nodeId(dataNode), reclaimed.nodeId);
        // The incumbent holds a stale token, so its next upload loses the CAS and the write is never acknowledged.
                        .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
        assertBusy(() -> {
            awaitFence(translogMetadataDirectory(fencedIndex));
     */
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
        BlobStoreRepository translogRepository = (BlobStoreRepository) internalCluster().getInstance(
            assertThat("fence did not advance after an acknowledged write", current.seq, greaterThan(previous.seq));
    }
        ensureGreen(INDEX_NAME);
        // asserted here - a fenced upload can leave an orphan metadata file, which is a documented follow-up.
            return listing.anyMatch(path -> path.getFileName().toString().startsWith(FENCE_BLOB_PREFIX));
                .getState()
        assertEquals(nodeId(originalPrimaryNode), before.nodeId);
        // then serve from.
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
            assertEquals("true", indexSetting(fencedIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
        internalCluster().startClusterManagerOnlyNode();
    }
        ensureGreen(INDEX_NAME);
            Fence after = readFence(fenceDir);
        }, 60, TimeUnit.SECONDS);
        assertEquals(nodeId(dataNode), before.nodeId);
                    "shard copy " + shard.getShardRouting() + " is out of sync",
    /**
        internalCluster().startClusterManagerOnlyNode();
        // Stand in for a copy hydrated on another node: take ownership of the chain at a higher term, out of band.
     * primary is checked against neither the fence nor the replicas.
        return client().admin().indices().prepareGetSettings(indexName).get().getIndexToSettings().get(indexName).get(settingKey);
 */
        // gap is deliberately wider than the number of allocation retries, so neither the promotion nor any subsequent
                )
    public void testASupersededReplicaFailsPromotionAtTheSeal() throws Exception {
     * switches its write witness mid-flight — toggling the fence on a live index would leave a window in which a stale
            assertNotNull("no allocation failure recorded yet: " + unassignedInfo, unassignedInfo.getFailure());
                optedOutIndex,
    }
        assertEquals(sourceFence.indexUUID, readFence(translogMetadataDirectory(INDEX_NAME)).indexUUID);
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
                .collect(Collectors.toSet());
 */
            RepositoriesService.class,
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
                .prepareState()
            );
     * The acknowledgement-path object of the highest term present. Names embed the inverted term, so the highest term
    /**
        assertFalse("the translog metadata prefix must not match the fence prefix", METADATA_PREFIX.startsWith(FENCE_BLOB_PREFIX));
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        refresh(INDEX_NAME);
package org.opensearch.remotestore;
        refresh(INDEX_NAME);
        indexSingleDoc(INDEX_NAME);
import org.opensearch.indices.RemoteStoreSettings;
    }
        Set<String> fenceBlobs = blobs.stream().filter(name -> name.startsWith(FENCE_BLOB_PREFIX)).collect(Collectors.toSet());
        Fence before = awaitFence(fenceDir);
            tokens[5],
                    .indices()
            ShardStats[] shards = client().admin().indices().prepareStats(INDEX_NAME).setDocs(true).get().getShards();
        Exception failure = expectThrows(Exception.class, () -> indexSingleDoc(INDEX_NAME));
     * real, blocking step on the recovery path rather than something the first post-recovery upload happens to do: a
        assertEquals("superseded copy claimed the fence: " + after, superseding.nodeId, after.nodeId);
        internalCluster().startClusterManagerOnlyNode();
                        .build()
                    .prepareUpdateSettings()
                shardId,
                .shard(0)
        internalCluster().startDataOnlyNodes(3);
        }
        ).repository(REPOSITORY_2_NAME);
        assertBusy(() -> {
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
        Fence after = readFence(fenceDir);
    /**
     * otherwise a previous primary that is still alive - and still holding a valid CAS token - could keep acknowledging
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.seq, after.seq);
        }, 60, TimeUnit.SECONDS);
import org.opensearch.index.shard.IndexShard;
    public void testIncumbentIsFencedByACompetingOwner() throws Exception {
    @Override
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    /**
     * recovery path the failure happens, which no exception type or message can distinguish.
            ensureGreen(optedOutIndex);
 * acknowledgement path, both for zero-replica indices — where no replica exists to act as a primary term validation
    protected boolean remoteStoreFencingForAllIndices() {
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
            assertEquals(replicaCount + 1, shards.length);
                    .prepareUpdateSettings(fencedIndex)
    }
            indexName,
                .get()
        return getShardLevelBlobPath(
        // Each acknowledged write advances the chain. The exact delta is not asserted: background syncs may also
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
            assertNotNull("no allocation failure recorded yet: " + unassignedInfo, unassignedInfo.getFailure());
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
        }
        return readFence(metadataDirectory);
            client(),
                .routingTable()
        for (int i = 0; i < numDocs; i++) {
        ShardId shardId = getIndexShard(dataNode, INDEX_NAME).shardId();
        public String toString() {
        String originalPrimaryNode = primaryNodeName(INDEX_NAME);
        Fence bootstrapped = awaitFence(fenceDir);
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
     * index with its own UUID, so the target claims a fresh key namespace uncontested and has no lower-term path to
import java.nio.file.Files;
                client().admin()
        internalCluster().startDataOnlyNodes(2);
import java.io.IOException;
        internalCluster().startClusterManagerOnlyNode();
        final String targetIndex = INDEX_NAME + "-resized";
        assertEquals("unexpected fence codec version [" + raw + "]", "v1", tokens[0]);
        assertAcked(
        // The superseded copy neither claimed nor advanced the chain, so it cannot have read a restore point it would
        internalCluster().startDataOnlyNodes(2);
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST.name())
     * Parses the fence blob independently of {@link RemoteStoreFence}, so that the on-disk layout documented as
        Fence superseding = readFence(fenceDir);
import java.util.concurrent.TimeUnit;
            assertTrue("recovery did not fail in the fence seal, but with:\n" + stackTrace, stackTrace.contains(SEAL_METHOD_NAME));
            createIndex(unfencedIndex, unfencedSettings);
            String unfencedIndex = INDEX_NAME + "-default-off";
                .prepareResizeIndex(INDEX_NAME, targetIndex)
                .routingTable()
            Long.parseLong(tokens[6])
        String originalPrimaryNode = primaryNodeName(INDEX_NAME);
        assertAcked(client().admin().indices().prepareDelete(targetIndex, INDEX_NAME));
            return listing.filter(path -> path.getFileName().toString().startsWith(FENCE_BLOB_PREFIX))
        assertAcked(
        // primary term, and its bootstrap seals the fence back over to this node. Doc counts are deliberately not
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureGreen(INDEX_NAME);
 * compatible open source license.
     * write is acknowledged, rather than silently writing behind the new owner. This is the zero-replica case, where
     * mistaken for one, since metadata listings drive both restore lineage and garbage collection.
    private BlobPath translogMetadataBlobPath(String indexName) {
            String stackTrace = ExceptionsHelper.stackTrace(unassignedInfo.getFailure());
    public void testFenceBlobIsNotVisibleAsTranslogMetadata() throws Exception {
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalPrimaryNode));
        assertTrue("expected a fencing failure but got:\n" + stackTrace, stackTrace.contains("primary fenced by remote store"));
        BlobPath metadataBlobPath = translogMetadataBlobPath(INDEX_NAME);
        Fence beforeFailover = awaitFence(fenceDir);
                .setSettings(
     * seal which contended with the write-blocked source would fail here.
     */
    private String nodeId(String nodeName) {
        @Override
        BlobPath metadataBlobPath = translogMetadataBlobPath(INDEX_NAME);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalPrimaryNode));
     */
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
                .index(INDEX_NAME)
     * Zero replicas: the object store is the only witness, so every acknowledged write must advance the CAS chain.
            // resolves to false forever, so there is no explicit false to materialize.
            assertTrue(rejection.getMessage(), rejection.getMessage().contains(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
        }
        String primaryNode = primaryNodeName(INDEX_NAME);
                    shard.getStats().getDocs().getCount()
        private Fence(String indexUUID, int shardId, long term, String allocationId, String nodeId, long seq) {
     */
        // The translog metadata lineage is still readable with the fence sitting next to it: recovering the shard from
                stackTrace.contains(PROMOTION_SEAL_METHOD_NAME + "(")
        String supersededPath = RemoteStoreFence.fenceBlobName(before.term);
            assertThat("the promoted copy did not claim a higher term", after.term, greaterThan(before.term));
        assertFalse("the fence prefix must not match the translog metadata prefix", FENCE_BLOB_PREFIX.startsWith(METADATA_PREFIX));
                    .cluster()
        BlobContainer fenceContainer = translogRepository.blobStore().blobContainer(metadataBlobPath);
        String originalPrimaryNode = primaryNodeName(INDEX_NAME);
            this.allocationId = allocationId;
            indexSingleDoc(INDEX_NAME);
        assertEquals(expectedDocs, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
            assertThat("recovery was not retried to exhaustion", unassignedInfo.getNumFailedAllocations(), greaterThan(0));
        Fence fence = awaitFence(fenceDir);
        internalCluster().restartNode(dataNode);
                .unassignedInfo();
        internalCluster().startClusterManagerOnlyNode();
    private static Set<String> fenceBlobNames(Path metadataDirectory) throws IOException {
import java.util.Comparator;
        // Every allocation attempt must abort in the seal, so the shard stays unassigned with that failure recorded.
        }
        ensureGreen(INDEX_NAME);
     * allocation failure comes from a different call site and this test fails.
            String fencedIndex = INDEX_NAME + "-default-on";
     */
                    .setTransientSettings(Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey(), true))
        assertEquals(nodeId(primaryNodeName(INDEX_NAME)), readFence(fenceDir).nodeId);
    private static final String INDEX_NAME = "remote-store-fencing-idx";
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false))
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.term, after.term);
        indexSingleDoc(INDEX_NAME);
        try (Stream<Path> listing = Files.list(metadataDirectory)) {
        return new Fence(
        String raw = new String(Files.readAllBytes(currentFenceBlob(metadataDirectory)), StandardCharsets.UTF_8);
            Fence afterFailover = readFence(fenceDir);
     * The race window itself is not observable from an integration test, so what is asserted here is that the seal is a
                .primaryShard()
    /**
    }
import org.opensearch.common.settings.Settings;
            // Cluster default off: the index is created unfenced. The key stays absent — the final index setting
            // The baked-in index setting is final: the witness of a live index cannot be switched.
import java.util.stream.Stream;
    public void testASupersededCopyFailsRecoveryAtTheSeal() throws Exception {
        // The promotion must abort in the seal, so the primary ends up unassigned with that failure recorded rather
    }
            indexSingleDoc(INDEX_NAME);
        private final String indexUUID;
            assertAcked(
        String stackTrace = ExceptionsHelper.stackTrace(failure);
        // Failover: the replica is promoted in place. No write is issued against the promoted copy.
     * {@code v1|<indexUUID>|<shardId>|<term>|<allocationId>|<nodeId>|<seq>} is asserted rather than assumed.
    public void testClusterFencingDefaultIsBakedIntoAFinalIndexSetting() throws Exception {
            .put(remoteStoreIndexSettings(0, 1))
        Fence competing = readFence(fenceDir);
    private Settings fencedIndexSettings(int replicaCount, Translog.Durability durability) {
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
        assertThat("resize target should claim a fresh chain", targetFence.seq, greaterThanOrEqualTo(0L));
        createIndex(INDEX_NAME, fencedIndexSettings(replicaCount, durability));
import org.opensearch.cluster.service.ClusterService;
 * Verifies that the object-store fencing token (see {@link RemoteStoreFence}) is actually exercised on the
        IndexShard primary = getIndexShard(dataNode, INDEX_NAME);
    private static final class Fence {
     * copy that has been superseded - the chain is owned by another writer at a strictly higher term - must fail
    /**
                seq
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
     * The fence is on the control flow only: it shares a directory with the translog metadata files but must never be
                afterFailover.term,
        });
            Fence current = readFence(fenceDir);
     */
import java.util.Set;
        Fence sourceFence = readFence(translogMetadataDirectory(INDEX_NAME));
            this.nodeId = nodeId;
            Fence reclaimed = readFence(fenceDir);
import java.util.Locale;
 * witness — and for indices with one or more replicas, where fencing must coexist with segment replication.
            }
import org.opensearch.common.blobstore.BlobPath;
            Long.parseLong(tokens[3]),
            return listing.map(path -> path.getFileName().toString())
        internalCluster().startDataOnlyNode();
        assertBusy(() -> {
    /** The on-disk translog metadata directory backing {@link #translogMetadataBlobPath}. */
        return internalCluster().getInstance(ClusterService.class, nodeName).localNode().getId();
        private final String nodeId;
                    .cluster()
        assertBusy(() -> {
                IllegalArgumentException.class,
        ensureGreen(INDEX_NAME);
        int numDocs = randomIntBetween(5, 10);
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
        assertTrue("fence objects leaked into the metadata listing", Collections.disjoint(metadataFiles, fenceBlobs));
            tokens[4],
            assertEquals("exactly one acknowledgement path must survive a takeover: " + paths, 1, paths.size());
        BlobContainer fenceContainer = translogRepository.blobStore().blobContainer(metadataBlobPath);
import org.opensearch.cluster.metadata.IndexMetadata;
        String clusterManager = internalCluster().getClusterManagerName();
                assertEquals(
            String stackTrace = ExceptionsHelper.stackTrace(unassignedInfo.getFailure());
        ensureGreen(INDEX_NAME);
                .sorted(Comparator.comparing(path -> path.getFileName().toString()))
     * Seal-before-restore. A recovering primary claims the fence <b>before</b> it reads its translog restore point:
     * then deletes every lower-term one outright - which is what makes a higher-term takeover deterministic rather
        );
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
     * replica-based primary term validation cannot help.
        try {
            this.shardId = shardId;
import java.nio.file.Path;
import org.opensearch.repositories.RepositoriesService;
 * The OpenSearch Contributors require contributions made to
        ensureGreen(INDEX_NAME);
    }
            assertNotNull("primary was assigned despite being superseded", unassignedInfo);
            numDocs++;
 *
        internalCluster().startDataOnlyNode();
                .unassignedInfo();
        // Stand in for a copy hydrated elsewhere that has already moved the shard well past this node's term. The gap
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_PREFIX;
        }
        indexSingleDoc(INDEX_NAME);
    private static Path currentFenceBlob(Path metadataDirectory) throws IOException {
        assertEquals("unexpected fence blob layout [" + raw + "]", 7, tokens.length);
     * {@code IndexShard}'s seal step. Asserted as a stack frame because the point being verified is <i>where</i> on the
    /**
        assertEquals("fence owner should be the primary's node", nodeId(primaryNode), fence.nodeId);
            UnassignedInfo unassignedInfo = client().admin()
            indexSingleDoc(unfencedIndex);
     * One or more replicas: fencing takes replicas off the primary term validation path, but segment replication and
    /** The {@link BlobPath} of the translog metadata directory, which is where the fence blob lives. */
        new RemoteStoreFence(fenceContainer, "superseding-allocation", "superseding-node", shardId).validateAndAdvance(before.term + 50);
            RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.get(getNodeSettings())
        Fence before = awaitFence(fenceDir);
            assertEquals(previous.nodeId, current.nodeId);
            // Flip the cluster default on, dynamically. Only indices created afterwards are fenced.
        assertBusy(() -> assertThat("fence did not advance with replicas present", readFence(fenceDir).seq, greaterThan(fence.seq)));
        ShardId shardId = getIndexShard(originalPrimaryNode, INDEX_NAME).shardId();
                client().admin()
import static org.hamcrest.Matchers.greaterThan;
        }
            return false;
        BlobPath metadataBlobPath = translogMetadataBlobPath(INDEX_NAME);
        }, 60, TimeUnit.SECONDS);
                "index [%s] shard [%d] term [%d] allocation [%s] node [%s] seq [%d]",
                        .put("index.number_of_replicas", 0)
            this.seq = seq;
        indexSingleDoc(INDEX_NAME);
        indexSingleDoc(INDEX_NAME);
    public void testFenceSealsOverToThePromotedPrimary() throws Exception {
                Locale.ROOT,
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
            createIndex(
import org.opensearch.index.translog.transfer.RemoteStoreFence;
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        Fence targetFence = readFence(translogMetadataDirectory(targetIndex));
        return Settings.builder()
            .build();
        assertTrue(fenceBlobNames(fenceDir).contains(supersededPath));
     * The fencing gate is a <b>dynamic cluster setting</b> baked into a <b>final index setting</b> at creation time:
            indexSingleDoc(INDEX_NAME);
        }
    private static Fence readFence(Path metadataDirectory) throws IOException {
                .getState()
        int numDocs = randomIntBetween(2, 5);
                .filter(name -> name.startsWith(FENCE_BLOB_PREFIX))
    private static final String PROMOTION_SEAL_METHOD_NAME = "sealRemoteStoreFence";
     * promotion succeeds, and the fenced translog upload in {@code postActivatePrimaryMode} is logged and swallowed,
            assertEquals(previous.term, current.term);
        String dataNode = internalCluster().startDataOnlyNode();
        String dataNode = internalCluster().startDataOnlyNode();
            this.indexUUID = indexUUID;
     * term — must therefore fail the promotion itself, never activate, and never claim the chain. Without the seal the
        ).repository(REPOSITORY_2_NAME);
            .put(remoteStoreIndexSettings(replicaCount, 1))
        );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        // A legitimate new incarnation of the shard reclaims the chain: the shard failed, is reassigned at a higher
                    Settings.builder()
            previous = current;
                .setResizeType(ResizeType.CLONE)
     */
            assertThat(
        return Path.of(translogRepoPath.toString(), translogMetadataBlobPath(indexName).buildAsString());
import org.opensearch.common.blobstore.BlobContainer;
        }
        Translog.Durability durability = randomFrom(Translog.Durability.REQUEST, Translog.Durability.ASYNC);
        private final long term;
        }
                .get()
            .repository(REPOSITORY_2_NAME);
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
        } finally {
            assertNull(indexSetting(unfencedIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
    }
     * harmless there rather than merely untested: the fence path is keyed by index UUID and a resize target is a new
public class RemoteStoreFencingIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.index.IndexSettings;
        assertEquals(nodeId(originalPrimaryNode), before.nodeId);
        Set<String> blobs;
        Fence previous = bootstrapped;
import org.opensearch.index.translog.Translog;
            indexSingleDoc(fencedIndex);
 * SPDX-License-Identifier: Apache-2.0
        private final String allocationId;
        assertBusy(() -> {
            );
        }, 60, TimeUnit.SECONDS);
            incumbent.term + 1
                greaterThan(beforeFailover.term)
        ensureGreen(INDEX_NAME);
     */
                );
        assertNotEquals("resize target must not share the source's fence object", sourceFence.indexUUID, targetFence.indexUUID);
     */
            assertEquals(previous.allocationId, current.allocationId);
        IndexShard primary = getIndexShard(primaryNode, INDEX_NAME);
            createIndex(fencedIndex, unfencedSettings);
                .cluster()
        assertEquals("fence term should be the primary term", primary.getOperationPrimaryTerm(), bootstrapped.term);
import java.util.Collections;
        private final int shardId;
import org.opensearch.test.InternalTestCluster;
     * transition. A promoted copy that has been superseded — the chain is owned by another writer at a strictly higher
     * On failover the fence seals over to the promoted copy: a new owner at a higher term takes the chain, which is
    /**
            );
import java.util.stream.Collectors;
        createIndex(INDEX_NAME, fencedIndexSettings(1, Translog.Durability.REQUEST));
     */
        int replicaCount = randomIntBetween(1, 2);
                .index(INDEX_NAME)
        assertFalse("no translog metadata files were written: " + blobs, metadataFiles.isEmpty());
        indexSingleDoc(INDEX_NAME);
            IllegalArgumentException rejection = expectThrows(
    }
                Settings.builder().put(unfencedSettings).put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false).build()
                .cluster()
            );
        new RemoteStoreFence(fenceContainer, "competing-allocation", "competing-node", primary.shardId()).validateAndAdvance(
                .indices()
                () -> client().admin()
import org.opensearch.action.admin.indices.stats.ShardStats;
        BlobStoreRepository translogRepository = (BlobStoreRepository) internalCluster().getInstance(RepositoriesService.class, dataNode)
        IndexShard primary = getIndexShard(dataNode, INDEX_NAME);
                "the copy was not refused at the fence seal, but with:\n" + stackTrace,
     * the superseded term's path is gone.
                    .get()
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
            client().admin()
        assertBusy(() -> assertThat(readFence(translogMetadataDirectory(targetIndex)).seq, greaterThan(targetFence.seq)));
        BlobStoreRepository translogRepository = (BlobStoreRepository) internalCluster().getInstance(
        private final long seq;
        // The superseded copy neither claimed nor advanced the chain, so it cannot have read a restore point it would
    public void testFenceIsExercisedWithReplicas() throws Exception {
                .prepareState()
                        .putNull("index.blocks.write")
        Fence before = awaitFence(fenceDir);
            assertNotEquals("fence ownership did not move to the promoted copy", beforeFailover.nodeId, afterFailover.nodeId);
    }
import org.opensearch.action.admin.indices.shrink.ResizeType;
    public void testFenceIsExercisedWithZeroReplicas() throws Exception {
    }
/*
    }
            for (ShardStats shard : shards) {
    /**
        assertThat(bootstrapped.seq, greaterThanOrEqualTo(0L));
     * sweep. Asserted on the target's own fence blob, and on the source remaining serviceable afterwards, so that a
        indexSingleDoc(INDEX_NAME);
/**
        assertEquals(nodeId(originalPrimaryNode), beforeFailover.nodeId);
            tokens[1],
                allocationId,
    }
        // then serve from.
                .primaryShard()
        // reassignment can lift the primary term above the fence.
            BlobPath.cleanPath(),
    }
            clusterManager
                    expectedDocs,
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.term, after.term);
        Fence superseding = readFence(fenceDir);
        assertEquals("superseding-node", superseding.nodeId);
            Set<String> paths = fenceBlobNames(fenceDir);
            );
        awaitFence(metadataDirectory);
                term,
     * <p>
     * promoted to primary claims the fence before it reads its translog restore point, inside the primary term
        ensureGreen(INDEX_NAME);
     * A resize recovers from LOCAL_SHARDS, which reaches the seal like every non-PEER recovery source. The seal must be
        indexSingleDoc(INDEX_NAME);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("fence term should be the primary term", primary.getOperationPrimaryTerm(), fence.term);
            assertFalse("an unfenced index must not create a fence object", fenceExists(translogMetadataDirectory(unfencedIndex)));
    }
    public void testSupersededTermPathsAreDeletedOnTakeover() throws Exception {
        final int expectedDocs = numDocs;
        for (int i = 0; i < numDocs; i++) {
            RepositoriesService.class,
        assertBusy(() -> {
            assertAcked(
        assertFalse("fence objects missing from " + blobs, fenceBlobs.isEmpty());
            "0",
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), durability.name())
                .get()
        // upload, and the guarantee being verified is that the chain moves forward, never that it moves by one.
        String dataNode = internalCluster().startDataOnlyNode();
            blobs = listing.map(path -> path.getFileName().toString()).collect(Collectors.toSet());
                .orElseThrow(() -> new AssertionError("no fence object under " + metadataDirectory));
            assertTrue(
        // Replicas are still fed by segment replication and converge on the same doc count.
     * sorts first - the same ordering the fence itself relies on to compare cluster-manager-issued grants.
        );
     * than a race for a shared object. Observably: after failover exactly one path remains, at the higher term, and
        ensureGreen(INDEX_NAME);
    public void testResizeTargetSealsItsOwnFreshChain() throws Exception {
            .build();
     * recovery <em>at the seal</em>, never reach the restore point, and never claim the chain. Without the seal the
import static org.opensearch.index.translog.transfer.RemoteStoreFence.FENCE_BLOB_PREFIX;
        Fence after = readFence(fenceDir);
import org.opensearch.core.index.shard.ShardId;
    }
            );
        internalCluster().startClusterManagerOnlyNode();
        // The index is unrecoverable by construction; drop it rather than leaving a red index for the test teardown.
    /**
        String dataNode = internalCluster().startDataOnlyNode();
        Path metadataDirectory = translogMetadataDirectory(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalPrimaryNode));
        ensureGreen(targetIndex);
        String clusterManager = internalCluster().getClusterManagerName();
import org.opensearch.ExceptionsHelper;
     * The point of the fence: once another writer owns the chain, the incumbent's next upload must fail before the
            assertNull(indexSetting(unfencedIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
                nodeId,
     */
    private static final String SEAL_METHOD_NAME = "sealRemoteStoreFenceForRecovery";
        new RemoteStoreFence(fenceContainer, "superseding-allocation", "superseding-node", shardId).validateAndAdvance(before.term + 50);
        }
        indexSingleDoc(INDEX_NAME);
        assertEquals(numDocs, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
        );
                    .prepareUpdateSettings()
    }
            clusterManager
     * writes that land after the restore point the new copy read, and those acknowledged writes would be lost.
        assertEquals("one acknowledgement path per shard at a time", 1, fenceBlobNames(fenceDir).size());
        internalCluster().startClusterManagerOnlyNode();
        });
            this.term = term;
    private String indexSetting(String indexName, String settingKey) {
        // The target sealed a fence of its own, under its own index UUID, and it is not the source's.
    /** {@code IndexShard}'s shared seal step, the frame present on both the recovery and the promotion seal paths. */
            );
    }
     * operators can turn fencing on or off for indices created from that point on, but an existing index never
        assertBusy(() -> assertTrue("no fence object was ever created under " + metadataDirectory, fenceExists(metadataDirectory)));
        // term above the fence and turn the takeover into a legitimate one.
                .shard(0)
    private static boolean fenceExists(Path metadataDirectory) throws IOException {
        createIndex(INDEX_NAME, fencedIndexSettings(1, Translog.Durability.REQUEST));
            ensureGreen(unfencedIndex);
        );
        internalCluster().restartNode(dataNode);
        // A resize requires the source to stop accepting writes; the source keeps its own fence throughout.
            Integer.parseInt(tokens[2]),
        assertEquals(numDocs, client().prepareSearch(INDEX_NAME).setSize(0).get().getHits().getTotalHits().value());
import org.opensearch.cluster.routing.UnassignedInfo;
            client().admin().indices().prepareUpdateSettings(INDEX_NAME).setSettings(Settings.builder().put("index.blocks.write", true))
}
     * replica bookkeeping must be unaffected, and the fence must still advance on every acknowledged write.
     */
        indexSingleDoc(INDEX_NAME);
        Settings unfencedSettings = Settings.builder()
        assertEquals("fence owner should be the primary's node", nodeId(dataNode), bootstrapped.nodeId);
        refresh(INDEX_NAME);
        return false;
        Path fenceDir = translogMetadataDirectory(INDEX_NAME);
        }
                "fence term did not advance on failover: " + beforeFailover + " -> " + afterFailover,
            indexSingleDoc(INDEX_NAME);
            TRANSLOG,
                .findFirst()
            assertThat(reclaimed.term, greaterThanOrEqualTo(competing.term));
            // And the pre-existing index did not become fenced by the cluster-level flip.
import java.nio.charset.StandardCharsets;
            assertFalse("the superseded term's path was not deleted: " + paths, paths.contains(supersededPath));
        assertEquals("superseded copy claimed the fence: " + after, superseding.nodeId, after.nodeId);
        assertEquals("competing-node", competing.nodeId);
        ensureGreen(INDEX_NAME);
            assertEquals("false", indexSetting(optedOutIndex, IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED));
                    .setTransientSettings(Settings.builder().putNull(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey()))
    /**
            UnassignedInfo unassignedInfo = client().admin()
        BlobContainer fenceContainer = translogRepository.blobStore().blobContainer(metadataBlobPath);
        // is deliberately wider than the number of allocation retries, so no reassignment can lift this node's primary
        assertEquals("superseded copy advanced the fence: " + superseding + " -> " + after, superseding.seq, after.seq);
     * leaving a superseded copy serving as a started primary.
    }
        // the remote store replays every acknowledged write.
        createIndex(INDEX_NAME, fencedIndexSettings(1, Translog.Durability.REQUEST));
            String optedOutIndex = INDEX_NAME + "-opt-out";
        String[] tokens = raw.split("\\|");
        // than a superseded copy serving as a started primary.
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNode();
        }
            ensureGreen(fencedIndex);
                indexUUID,
        createIndex(INDEX_NAME, fencedIndexSettings(0, Translog.Durability.REQUEST));
        indexSingleDoc(targetIndex);
        Fence incumbent = awaitFence(fenceDir);
     * Deletion is the fencing act. Acknowledgement paths are keyed by term, so a takeover claims its own object and
            assertTrue(paths.contains(RemoteStoreFence.fenceBlobName(after.term)));
            // An explicit per-index value always wins over the cluster default.
     * what makes the old primary's next upload fail its CAS.
        // The index is unrecoverable by construction; drop it rather than leaving a red index for the test teardown.
