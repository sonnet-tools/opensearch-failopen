import java.nio.file.Path;
        Path translogLocation = shard.shardPath().resolveTranslog();
            indexDoc(shard, "_doc", Integer.toString(i));
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
/*
    /**
        IOUtils.close(() -> shard.close("test", false, false), shard.store());
    }
        for (int i = 0; i < numDocs; i++) {
    public void testCorruptLocalTranslogWithoutRemoteStoreIsLeftInPlace() throws Exception {
            Settings.builder()
import org.opensearch.index.translog.TranslogCorruptedException;
import java.io.IOException;
        // Not closeShard(): the harness refreshes the engine on close, and on a remote-store shard that refresh
        allowShardFailures();
            indexDoc(shard, "_doc", Integer.toString(i));
        }
        IndexShard failing = reinitShard(shard);
import org.opensearch.indices.replication.common.ReplicationType;
            "recovery must fail on the corrupt operation, got " + failure,
            try (IndexInput indexInput = localDirectory.openInput(file, IOContext.READONCE)) {
     * A local translog generation whose operations have rotted but whose footer is intact is reused by the incremental
        assertTrue(Files.exists(corrupted));
        }
                    Files.copy(p, shardPath.resolve(p.getFileName()));
        assertBusy(() -> assertTrue(shard.isRemoteSegmentStoreInSync()));
                assertFalse(Files.exists(shardPath.resolve(file)));
import org.opensearch.index.engine.InternalEngineFactory;
                assertTrue(indexShard.localDirectoryContains(localDirectory, file, checksum));
        IndexShard recovered = reinitShard(failing);
    }
        Path tempDir = createTempDir();
        assertNotNull(
        recoverShardFromStore(recovered);
import java.nio.file.StandardOpenOption;
     * shard must not delete anything.
        corruptOneOperationOfSomeGeneration(translogLocation);
        assertTrue(Files.exists(translogLocation));
        Directory localDirectory = indexShard.store().directory();
            }
                    CorruptionUtils.corruptAt(shardPath.resolve(file), raf, (int) (raf.size() - 8));
     * per-operation checksum failure at replay.
        Path translogLocation = shard.shardPath().resolveTranslog();
        return TestTranslog.corruptLastOperationOfRandomGeneration(random(), translogLocation);
            }
     */
        IndexShard failing = reinitShard(shard);
    /**
    public void testLocalDirectoryContains() throws IOException {
                } catch (IOException e) {
        Path shardPath = indexShard.shardPath().getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
                    // Ignore
public class RemoteIndexShardCorruptionTests extends IndexShardTestCase {
        Exception failure = expectThrows(Exception.class, () -> recoverShardFromStore(failing));
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
     */
import java.util.stream.Stream;
            files.forEach(p -> {
        assertDocCount(recovered, numDocs);
     * Flips a byte inside the body of the last operation of a randomly chosen non-empty generation. The size prefix,
            if (file.equals("write.lock") || file.startsWith("extra")) {
        failOnShardFailures();
            }
        IndexShard indexShard = newStartedShard(true);
        assertNotNull(
import org.apache.lucene.codecs.CodecUtil;
            ExceptionsHelper.unwrap(failure, TranslogCorruptedException.class)
import org.opensearch.cluster.metadata.IndexMetadata;
        closeShards(shard);
    private Path corruptOneOperationOfSomeGeneration(Path translogLocation) throws IOException {
        IndexShard shard = newStartedShard(true);
            if (corrupted) {
        indexShard.store().decRef();
        closeShards(indexShard);
                .build(),
            });
        // Rot one operation of a generation the remote store holds, leaving its checkpoint and footer intact.
        Path corrupted = corruptOneOperationOfSomeGeneration(translogLocation);
        );
        for (int i = 0; i < numDocs; i++) {
    public void testCorruptLocalTranslogIsDiscardedAndRedownloadedFromRemote() throws Exception {
        );
package org.opensearch.index.shard;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.io.IOUtils;
        closeShards(recovered);
        flushShard(indexShard);
        try (Stream<Path> files = Files.list(tempDir)) {
                }
        );
            boolean corrupted = randomBoolean();
        IndexShard shard = newStartedShard(
        allowShardFailures();
    /**
            new EngineBackedIndexerFactory(new InternalEngineFactory())
                assertFalse(indexShard.localDirectoryContains(localDirectory, file, checksum));
        assertFalse("the corrupt local translog must have been discarded", Files.exists(translogLocation));
                checksum = CodecUtil.retrieveChecksum(indexInput);
     */
        int numDocs = between(2, 8);
import org.opensearch.core.util.FileSystemUtils;
import org.opensearch.index.translog.TestTranslog;
    }
        // uploads a segment covering the operations, which would leave the translog nothing to replay.
     * translog, and recover cleanly from the remote store on the next attempt instead of reusing the same bytes forever.
     * Without a remote translog the local copy is the only copy: a corrupt generation still fails the recovery, but the
                try {
        }
        Exception failure = expectThrows(Exception.class, () -> recoverShardFromStore(failing));
@LuceneTestCase.SuppressFileSystems("WindowsFS")
            indexDoc(indexShard, "_doc", Integer.toString(i));
            true,
        assertTrue(Files.exists(translogLocation));
import org.opensearch.ExceptionsHelper;
        for (int i = 0; i < numDocs; i++) {
        int numDocs = between(2, 8);
                try (FileChannel raf = FileChannel.open(shardPath.resolve(file), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
                continue;
import org.apache.lucene.tests.util.LuceneTestCase;
import java.nio.channels.FileChannel;
        indexShard.store().incRef();
                Files.copy(shardPath.resolve(file), tempDir.resolve(file));
        // and replay has nothing to read.
     * download, so replay is the first thing that notices. The shard must fail that recovery, discard the local
        // Let the segment upload that the start-up refresh scheduled finish first, and then never refresh again: the
     * the checkpoint and any footer are untouched, so the generation still looks current and the rot surfaces as a
 * compatible open source license.
            } else {
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
 *
                }
import org.apache.lucene.store.IndexInput;
        for (String file : localDirectory.listAll()) {
        // The failed replay fails the engine; that is the expected outcome here, not a test failure.
import org.opensearch.common.settings.Settings;
        closeShards(failing);
import org.apache.lucene.store.IOContext;
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
        // operations must exist only in the translog, otherwise the commit the recovery downloads already covers them
            long checksum = 0;
            "recovery must fail on the corrupt operation, got " + failure,
            if (corrupted == false) {
 * The OpenSearch Contributors require contributions made to
        FileSystemUtils.deleteSubDirectories(tempDir);
        String remoteStorePath = createTempDir().toString();
import org.opensearch.test.CorruptionUtils;
    }
            ExceptionsHelper.unwrap(failure, TranslogCorruptedException.class)
}
 * this file be licensed under the Apache-2.0 license or a
        }
import org.apache.lucene.store.Directory;
        int numDocs = between(1, 10);
 */
import java.nio.file.Files;
            }
        }
