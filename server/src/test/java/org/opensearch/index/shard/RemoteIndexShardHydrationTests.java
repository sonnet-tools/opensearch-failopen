            gate.release.countDown();
    public void testRecoveryStillHydratesAndOpensWhenNotClosed() throws Exception {
        }
                interrupted.countDown();
            // The hydration reports the shard closed, and StoreRecovery treats that as "got closed on us, just ignore
                    @Override
        IndexShard recovering = reinitShard(shard);
 */
                    closeFailure.set(e);
                );
            }
                throw new ClosedByInterruptException();
     * Recovery completes after the out-of-lock hydration and the constructor's incremental reconciliation.
        }
                        recovering.routingEntry(),
import org.opensearch.common.util.io.IOUtils;
     * Before this change the download held engineMutex and close() parked on it for the whole download.
            assertThat("a recovery of a closed shard is ignored", recovered.get(), equalTo(false));
                    )
        // Not closeShard(): the harness refreshes on close, and a remote-store shard's refresh is an upload we do not
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
}
     * While a recovery is blocked downloading the translog from the remote store, closing the shard must return promptly,
                    new RecoveryState(
                    public InputStream readBlob(String blobName) throws IOException {
            @Override
        IOUtils.close(() -> shard.close("test", false, false), shard.store());
                    }
            assertTrue("the recovery never reached the translog download", gate.entered.await(30, TimeUnit.SECONDS));
            entered.countDown();
    private static final class DownloadGate {
        // want racing the recovery below.
        for (int i = 0; i < numDocs; i++) {
import java.util.concurrent.TimeUnit;
            public BlobContainer blobContainer(BlobPath path) {
                } catch (Exception e) {
                        return child;
import java.util.concurrent.atomic.AtomicReference;
                        return super.readBlobWithMetadata(blobName);
            assertThat(recovering.state(), equalTo(IndexShardState.CLOSED));
            try {
                        return super.readBlob(blobName);
        volatile boolean armed;
                recovering.markAsRecovering(
     */
            indexDoc(shard, "_doc", Integer.toString(i));
            try {
import org.opensearch.common.blobstore.InputStreamWithMetadata;
            true,
            // The download was cancelled by the close, not by this test releasing it.
            closer.join(TimeUnit.SECONDS.toMillis(10));
        for (int i = 0; i < numDocs; i++) {
                release.await();
import java.util.concurrent.CountDownLatch;
    @Override
    }
        } finally {
        int numDocs = between(1, 5);
                recoveryFailure.set(e);
        String remoteStorePath = createTempDir().toString();
            true,
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.common.blobstore.BlobContainer;
/**
                    }
import org.opensearch.common.settings.Settings;
        final CountDownLatch interrupted = new CountDownLatch(1);
        IndexShard shard = newStartedShard(
                    }
import org.opensearch.index.engine.InternalEngineFactory;
                    recovering.close("test", false, false);
                // what a FileChannel write on the interrupted downloading thread would raise
                        gate.pass(blobName);
        String remoteStorePath = createTempDir().toString();
            Thread closer = new Thread(() -> {
            assertThat(recovering.state(), equalTo(IndexShardState.RECOVERING));
import java.io.IOException;
        recoverShardFromStore(recovered);
                    "store",
    /**
        final CountDownLatch release = new CountDownLatch(1);
            recovery.join(TimeUnit.SECONDS.toMillis(30));
            }, "closer");
                    @Override
            AtomicReference<Exception> closeFailure = new AtomicReference<>();
                try {
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
import org.opensearch.index.translog.Translog;
     */
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.common.blobstore.BlobStore;
import org.opensearch.common.blobstore.support.FilterBlobContainer;
            new EngineBackedIndexerFactory(new InternalEngineFactory())
                return;
        AtomicReference<Boolean> recovered = new AtomicReference<>();
                        IndexShardTestUtils.getFakeDiscoNode(recovering.routingEntry().currentNodeId()),
        final CountDownLatch entered = new CountDownLatch(1);
                        gate.pass(blobName);
        // place the incremental download would reuse it and never touch the remote store.
                .build(),
     * and the download must stop - the recovering thread exits with the shard reported closed and no engine was opened.
/*
    public void testCloseIsNotHeldUpByRemoteHydrationAndAbortsIt() throws Exception {
    /**
        gate.armed = true;
public class RemoteIndexShardHydrationTests extends IndexShardTestCase {
            } catch (InterruptedException e) {
        closeShards(recovered);
 * A recovery of a remote-store shard hydrates segments and translog from the remote store before it opens the engine.
import java.nio.channels.ClosedByInterruptException;
package org.opensearch.index.shard;
        );
import org.opensearch.indices.recovery.RecoveryState;
        );
                    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
    }
                };
import org.opensearch.snapshots.mockstore.BlobStoreWrapper;
    private final DownloadGate gate = new DownloadGate();
            // The applier-side call: must not wait for the download.
    /** Holds translog downloads when armed. */
            }
import java.io.InputStream;
        Thread recovery = new Thread(() -> {
            assertThat(closeFailure.get(), nullValue());
            closer.start();
        }
        try {
            assertThat("the recovery must not fail the shard, got " + recoveryFailure.get(), recoveryFailure.get(), nullValue());
import org.opensearch.indices.replication.common.ReplicationType;
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
            Settings.builder()
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        };
            assertFalse("close() must not be held up by a remote store download that is still in flight", closer.isAlive());
            new EngineBackedIndexerFactory(new InternalEngineFactory())
 * the shard aborts it (issue #15277).
            }
import org.opensearch.cluster.metadata.IndexMetadata;
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        IndexShard shard = newStartedShard(
        return new BlobStoreWrapper(blobStore) {
            Settings.builder()
        void pass(String blobName) throws IOException {
        int numDocs = between(1, 5);
                        null
        IndexShard recovered = reinitShard(shard);
 * {@link IndexShard#close} - called from under the cluster applier's lock - is never held up by remote I/O, and closing
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
 *
                recovered.set(recoverFromStore(recovering));
            IOUtils.close(recovering.store());
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        // A fresh node has no local translog, so every generation has to be fetched; with the local copy left in
            assertThat("no engine may be opened on a closed shard", recovering.getIndexerOrNull(), nullValue());
    }
    protected BlobStore wrapRemoteStoreBlobStore(BlobStore blobStore) {
        AtomicReference<Exception> recoveryFailure = new AtomicReference<>();
                return new FilterBlobContainer(super.blobContainer(path)) {
                    protected BlobContainer wrapChild(BlobContainer child) {
            if (armed == false || blobName.endsWith(Translog.TRANSLOG_FILE_SUFFIX) == false) {
        assertDocCount(recovered, numDocs);
    }
                    @Override
            }
            recovery.join(TimeUnit.SECONDS.toMillis(30));
            indexDoc(shard, "_doc", Integer.toString(i));
 * compatible open source license.
        recovery.start();
            assertTrue("closing the shard must interrupt the in-flight download", gate.interrupted.await(30, TimeUnit.SECONDS));
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
        IOUtils.rm(shard.shardPath().resolveTranslog());
 * That hydration must behave like a peer recovery's phase 1: it runs outside the engine open critical section, so that
                Thread.currentThread().interrupt();
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")
        IOUtils.close(() -> shard.close("test", false, false), shard.store());
 * The OpenSearch Contributors require contributions made to
        }
            // this recovery": no failure, no shard failure, just a recovery that did not happen.
 */
            } catch (Exception e) {
                }
        }, "recovery");
            assertFalse("the recovery must have given up on the closed shard", recovery.isAlive());
                .build(),
