        Path translogLocation = shard.shardPath().resolveTranslog();
                try {  
     * translog, and recover cleanly from the remote store on the next attempt instead of reusing the same bytes forever.  
        // The failed replay fails the engine; that is the expected outcome here, not a test failure.  
        int numDocs = between(2, 8);  
        IndexShard failing = reinitShard(shard);
        allowShardFailures();  
        assertTrue(Files.exists(translogLocation));
    /**  
    }
                }
import org.opensearch.common.util.io.IOUtils;  
import org.opensearch.core.util.FileSystemUtils;
}
            long checksum = 0;
        String remoteStorePath = createTempDir().toString();  
        // Let the segment upload that the start-up refresh scheduled finish first, and then never refresh again: the
        for (String file : localDirectory.listAll()) {  
import org.opensearch.ExceptionsHelper;  
            indexDoc(indexShard, "_doc", Integer.toString(i));
        IOUtils.close(() -> shard.close("test", false, false), shard.store());
        }  
        assertDocCount(recovered, numDocs);
/*  
        }  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                } catch (IOException e) {
        closeShards(recovered);  
import org.apache.lucene.codecs.CodecUtil;
import org.opensearch.test.CorruptionUtils;
            "recovery must fail on the corrupt operation, got " + failure,
                Files.copy(shardPath.resolve(file), tempDir.resolve(file));
    }
 */  
        }  
     * Flips a byte inside the body of the last operation of a randomly chosen non-empty generation. The size prefix,
                assertFalse(Files.exists(shardPath.resolve(file)));
            boolean corrupted = randomBoolean();
    private Path corruptOneOperationOfSomeGeneration(Path translogLocation) throws IOException {
            Settings.builder()  
import org.apache.lucene.tests.util.LuceneTestCase;
        Path translogLocation = shard.shardPath().resolveTranslog();
     * shard must not delete anything.
                try (FileChannel raf = FileChannel.open(shardPath.resolve(file), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
                assertTrue(indexShard.localDirectoryContains(localDirectory, file, checksum));
        int numDocs = between(1, 10);  
        for (int i = 0; i < numDocs; i++) {
        indexShard.store().incRef();
import org.opensearch.common.settings.Settings;
        assertFalse("the corrupt local translog must have been discarded", Files.exists(translogLocation));
        recoverShardFromStore(recovered);  
        assertTrue(Files.exists(translogLocation));
            files.forEach(p -> {
        flushShard(indexShard);
            indexDoc(shard, "_doc", Integer.toString(i));
 * compatible open source license.
        // Rot one operation of a generation the remote store holds, leaving its checkpoint and footer intact.  
        Exception failure = expectThrows(Exception.class, () -> recoverShardFromStore(failing));  
        );
                checksum = CodecUtil.retrieveChecksum(indexInput);
        IndexShard shard = newStartedShard(true);
            }
 * The OpenSearch Contributors require contributions made to  
        allowShardFailures();
        }  
            if (corrupted) {  
 * SPDX-License-Identifier: Apache-2.0
        return TestTranslog.corruptLastOperationOfRandomGeneration(random(), translogLocation);  
            ExceptionsHelper.unwrap(failure, TranslogCorruptedException.class)
import org.apache.lucene.store.IndexInput;
                    Files.copy(p, shardPath.resolve(p.getFileName()));
        failOnShardFailures();  
import java.nio.file.Files;
        );
    public void testCorruptLocalTranslogIsDiscardedAndRedownloadedFromRemote() throws Exception {
     */  
import java.io.IOException;  
        Path corrupted = corruptOneOperationOfSomeGeneration(translogLocation);
     * the checkpoint and any footer are untouched, so the generation still looks current and the rot surfaces as a
import org.opensearch.index.translog.TestTranslog;
            indexDoc(shard, "_doc", Integer.toString(i));
                .build(),
        // and replay has nothing to read.
        assertNotNull(
        IndexShard recovered = reinitShard(failing);
import org.opensearch.indices.replication.common.ReplicationType;  
import org.opensearch.index.engine.InternalEngineFactory;
        assertBusy(() -> assertTrue(shard.isRemoteSegmentStoreInSync()));
public class RemoteIndexShardCorruptionTests extends IndexShardTestCase {
import java.nio.file.Path;  
                    // Ignore  
     * per-operation checksum failure at replay.  
     */
        corruptOneOperationOfSomeGeneration(translogLocation);
        IndexShard failing = reinitShard(shard);
        try (Stream<Path> files = Files.list(tempDir)) {
            if (corrupted == false) {  
        Directory localDirectory = indexShard.store().directory();  
import java.nio.file.StandardOpenOption;
            "recovery must fail on the corrupt operation, got " + failure,
            true,
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
            }  
            new EngineBackedIndexerFactory(new InternalEngineFactory())  
        Exception failure = expectThrows(Exception.class, () -> recoverShardFromStore(failing));
     * A local translog generation whose operations have rotted but whose footer is intact is reused by the incremental
    /**  
                continue;
@LuceneTestCase.SuppressFileSystems("WindowsFS")
     * download, so replay is the first thing that notices. The shard must fail that recovery, discard the local
            ExceptionsHelper.unwrap(failure, TranslogCorruptedException.class)  
     */
            }
                }
    /**  
        // uploads a segment covering the operations, which would leave the translog nothing to replay.  
                    CorruptionUtils.corruptAt(shardPath.resolve(file), raf, (int) (raf.size() - 8));  
        // Not closeShard(): the harness refreshes the engine on close, and on a remote-store shard that refresh
    }
        indexShard.store().decRef();
        }  
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.store.Directory;
import java.nio.channels.FileChannel;
import org.opensearch.cluster.metadata.IndexMetadata;
        Path tempDir = createTempDir();
 * this file be licensed under the Apache-2.0 license or a
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")  
            try (IndexInput indexInput = localDirectory.openInput(file, IOContext.READONCE)) {  
        FileSystemUtils.deleteSubDirectories(tempDir);
        assertTrue(Files.exists(corrupted));
    }
            if (file.equals("write.lock") || file.startsWith("extra")) {
        closeShards(shard);
        int numDocs = between(2, 8);  
        closeShards(failing);  
        IndexShard shard = newStartedShard(
        for (int i = 0; i < numDocs; i++) {
        Path shardPath = indexShard.shardPath().getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
                assertFalse(indexShard.localDirectoryContains(localDirectory, file, checksum));  
        closeShards(indexShard);  
        // operations must exist only in the translog, otherwise the commit the recovery downloads already covers them  
package org.opensearch.index.shard;
 *
    public void testLocalDirectoryContains() throws IOException {
            }
import org.apache.lucene.store.IOContext;  
            } else {
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
        );  
import java.util.stream.Stream;
            });
import org.opensearch.index.translog.TranslogCorruptedException;
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
    public void testCorruptLocalTranslogWithoutRemoteStoreIsLeftInPlace() throws Exception {
     * Without a remote translog the local copy is the only copy: a corrupt generation still fails the recovery, but the
        assertNotNull(  
        IndexShard indexShard = newStartedShard(true);
