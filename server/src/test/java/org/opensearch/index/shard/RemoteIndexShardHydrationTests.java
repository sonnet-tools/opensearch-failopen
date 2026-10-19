     */  
                        null
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                    @Override
                    )  
            }
}  
    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
/*  
 * The OpenSearch Contributors require contributions made to  
    }
            assertThat(recovering.state(), equalTo(IndexShardState.CLOSED));
    /** Holds translog downloads when armed. */
            public BlobContainer blobContainer(BlobPath path) {  
    /**
            // this recovery": no failure, no shard failure, just a recovery that did not happen.
                    }
        for (int i = 0; i < numDocs; i++) {
     * Before this change the download held engineMutex and close() parked on it for the whole download.
import java.util.concurrent.TimeUnit;
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")  
import org.opensearch.snapshots.mockstore.BlobStoreWrapper;
    protected BlobStore wrapRemoteStoreBlobStore(BlobStore blobStore) {  
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
            }
import org.opensearch.common.blobstore.BlobContainer;
import org.opensearch.common.blobstore.InputStreamWithMetadata;
            }, "closer");
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
/**
            // The hydration reports the shard closed, and StoreRecovery treats that as "got closed on us, just ignore
        IOUtils.rm(shard.shardPath().resolveTranslog());
import static org.hamcrest.Matchers.nullValue;  
            Settings.builder()
                    }
        IndexShard recovering = reinitShard(shard);  
 */
                        gate.pass(blobName);  
                    @Override
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        String remoteStorePath = createTempDir().toString();
    /**
import org.opensearch.common.blobstore.BlobPath;  
            } catch (InterruptedException e) {  
                }
package org.opensearch.index.shard;
                        return super.readBlobWithMetadata(blobName);
        recovery.start();
            entered.countDown();  
        int numDocs = between(1, 5);
            AtomicReference<Exception> closeFailure = new AtomicReference<>();
        }
 * this file be licensed under the Apache-2.0 license or a
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, remoteStorePath + "__test")
                    closeFailure.set(e);  
            assertFalse("close() must not be held up by a remote store download that is still in flight", closer.isAlive());
            gate.release.countDown();
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        return new BlobStoreWrapper(blobStore) {
    private static final class DownloadGate {
                    recovering.close("test", false, false);
                recoveryFailure.set(e);
            true,
                        gate.pass(blobName);  
            IOUtils.close(recovering.store());  
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        Thread recovery = new Thread(() -> {
                return new FilterBlobContainer(super.blobContainer(path)) {
        String remoteStorePath = createTempDir().toString();
            @Override
            }
            assertThat("no engine may be opened on a closed shard", recovering.getIndexerOrNull(), nullValue());
public class RemoteIndexShardHydrationTests extends IndexShardTestCase {
            assertThat(closeFailure.get(), nullValue());  
                    }
        IndexShard shard = newStartedShard(  
                throw new ClosedByInterruptException();
            // The download was cancelled by the close, not by this test releasing it.  
 * That hydration must behave like a peer recovery's phase 1: it runs outside the engine open critical section, so that
 * SPDX-License-Identifier: Apache-2.0
        }
        } finally {  
        );  
        // Not closeShard(): the harness refreshes on close, and a remote-store shard's refresh is an upload we do not
                return;
            assertTrue("the recovery never reached the translog download", gate.entered.await(30, TimeUnit.SECONDS));  
        );  
    }  
 * compatible open source license.
import org.opensearch.index.engine.InternalEngineFactory;  
        IndexShard recovered = reinitShard(shard);
        }, "recovery");  
     */  
     * Recovery completes after the out-of-lock hydration and the constructor's incremental reconciliation.
                // what a FileChannel write on the interrupted downloading thread would raise
                };  
                        IndexShardTestUtils.getFakeDiscoNode(recovering.routingEntry().currentNodeId()),
            try {
            closer.join(TimeUnit.SECONDS.toMillis(10));
        IndexShard shard = newStartedShard(  
    public void testCloseIsNotHeldUpByRemoteHydrationAndAbortsIt() throws Exception {
import org.opensearch.indices.replication.common.ReplicationType;
import java.nio.channels.ClosedByInterruptException;  
        for (int i = 0; i < numDocs; i++) {
        };
                try {  
                interrupted.countDown();
        }
 * A recovery of a remote-store shard hydrates segments and translog from the remote store before it opens the engine.  
            }
import org.opensearch.common.blobstore.BlobStore;
                    "store",
import static org.hamcrest.Matchers.equalTo;
            Settings.builder()
 *
    }
        // place the incremental download would reuse it and never touch the remote store.  
            } catch (Exception e) {  
                        return child;
import org.opensearch.indices.recovery.RecoveryState;  
 * {@link IndexShard#close} - called from under the cluster applier's lock - is never held up by remote I/O, and closing
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        gate.armed = true;
                        return super.readBlob(blobName);
        assertDocCount(recovered, numDocs);  
        volatile boolean armed;  
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, remoteStorePath + "__test")  
            try {
            assertThat(recovering.state(), equalTo(IndexShardState.RECOVERING));
 * the shard aborts it (issue #15277).  
                .build(),
        recoverShardFromStore(recovered);
            assertFalse("the recovery must have given up on the closed shard", recovery.isAlive());  
            assertTrue("closing the shard must interrupt the in-flight download", gate.interrupted.await(30, TimeUnit.SECONDS));
                    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
        final CountDownLatch entered = new CountDownLatch(1);
        // A fresh node has no local translog, so every generation has to be fetched; with the local copy left in
            true,
                        recovering.routingEntry(),  
        final CountDownLatch interrupted = new CountDownLatch(1);  
    @Override
                .build(),
        // want racing the recovery below.  
        }  
                release.await();
import java.io.IOException;
    public void testRecoveryStillHydratesAndOpensWhenNotClosed() throws Exception {
                    public InputStream readBlob(String blobName) throws IOException {
            if (armed == false || blobName.endsWith(Translog.TRANSLOG_FILE_SUFFIX) == false) {  
            closer.start();  
        try {
    private final DownloadGate gate = new DownloadGate();  
                recovering.markAsRecovering(  
import java.util.concurrent.atomic.AtomicReference;  
            Thread closer = new Thread(() -> {
                recovered.set(recoverFromStore(recovering));
     * While a recovery is blocked downloading the translog from the remote store, closing the shard must return promptly,  
        IOUtils.close(() -> shard.close("test", false, false), shard.store());
import org.opensearch.common.util.io.IOUtils;
                Thread.currentThread().interrupt();  
        closeShards(recovered);
                    @Override
                    protected BlobContainer wrapChild(BlobContainer child) {  
 */  
                    new RecoveryState(
        void pass(String blobName) throws IOException {
import java.io.InputStream;
        int numDocs = between(1, 5);
            // The applier-side call: must not wait for the download.  
import org.opensearch.common.settings.Settings;
            assertThat("the recovery must not fail the shard, got " + recoveryFailure.get(), recoveryFailure.get(), nullValue());  
            recovery.join(TimeUnit.SECONDS.toMillis(30));
            assertThat("a recovery of a closed shard is ignored", recovered.get(), equalTo(false));
     * and the download must stop - the recovering thread exits with the shard reported closed and no engine was opened.
                );
        IOUtils.close(() -> shard.close("test", false, false), shard.store());
                } catch (Exception e) {
        AtomicReference<Boolean> recovered = new AtomicReference<>();
import org.opensearch.index.translog.Translog;
        final CountDownLatch release = new CountDownLatch(1);
            indexDoc(shard, "_doc", Integer.toString(i));  
            indexDoc(shard, "_doc", Integer.toString(i));  
            recovery.join(TimeUnit.SECONDS.toMillis(30));
        AtomicReference<Exception> recoveryFailure = new AtomicReference<>();  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.blobstore.support.FilterBlobContainer;  
import java.util.concurrent.CountDownLatch;
