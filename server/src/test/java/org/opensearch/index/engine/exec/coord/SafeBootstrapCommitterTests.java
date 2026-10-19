        }  
package org.opensearch.index.engine.exec.coord;
import java.util.Map;
        Store store = createStore();
            new TestCommitter(new CommitterConfig(buildEngineConfig(store, translogPath), () -> {}));
        public void close() {}
        }  
    private static class TestCommitter extends SafeBootstrapCommitter {
            return List.of();
            throw new UnsupportedOperationException("test stub does not serialize commits");  
import java.io.IOException;  
        @Override  
            return Map.of();
        return builder.build();
            discoverAndTrimCalled = true;  
                .store(store)  
    }
        public void deleteCommit(CatalogSnapshot snapshot) {}  
import org.opensearch.index.store.Store;  
 * this file be licensed under the Apache-2.0 license or a
        public boolean isCommitManagedFile(String fileName) {  
            EngineConfig ec = new EngineConfig.Builder().indexSettings(IndexSettingsModule.newIndexSettings("test", Settings.EMPTY))
            return null;  
        try {
 * Tests for {@link SafeBootstrapCommitter}.
import org.opensearch.core.index.shard.ShardId;
        reset();
/*  
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
        @Override  
        } finally {
import org.opensearch.index.engine.EngineConfig;
        protected void discoverAndTrimUnsafeCommits(Store store, Path translogPath) {
        Files.createDirectories(dataPath);
        } finally {
        @Override  
        public CommitResult commit(CommitInput commitData) {
    private Store createStore() throws IOException {
        @Override
        }
    }
        Store store = createStore();  
        ShardId shardId = new ShardId("test", "_na_", 0);  
        }  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            return false;
            .store(store)  
    }  
}
        }
    }
/**
 *
 * In exec.coord package to access DataformatAwareCatalogSnapshot's package-private constructor.  
    public void testThrowsWhenNullTranslogConfig() throws IOException {
            assertTrue(discoverAndTrimCalled);  
        return new Store(shardId, indexSettings, new NIOFSDirectory(dataPath), new DummyShardLock(shardId), Store.OnClose.EMPTY, shardPath);
        @Override
import org.opensearch.common.settings.Settings;
        discoverAndTrimCalled = false;
import org.opensearch.index.engine.CommitStats;  
    }
                .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, Collections.emptyList()))
        @Override
import org.apache.lucene.store.NIOFSDirectory;
            builder.translogConfig(new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false));  
        public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
        if (translogPath != null) {
import java.util.Collections;  
        public Map<String, String> getLastCommittedData() {  
 * The OpenSearch Contributors require contributions made to  
 */  
import java.nio.file.Path;
 */
        public List<CatalogSnapshot> listCommittedSnapshots() {
import org.opensearch.common.util.BigArrays;  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
            expectThrows(IllegalArgumentException.class, () -> new TestCommitter(new CommitterConfig(ec, () -> {})));  
        TestCommitter(CommitterConfig config) throws IOException {  
import org.opensearch.index.seqno.RetentionLeases;
import org.opensearch.test.DummyShardLock;
import org.opensearch.index.translog.TranslogConfig;
import java.nio.file.Files;
        }
import java.util.List;
        }  
import org.opensearch.test.IndexSettingsModule;  
            store.close();
import org.opensearch.test.OpenSearchTestCase;
        EngineConfig.Builder builder = new EngineConfig.Builder().indexSettings(indexSettings)
    private static void reset() {  
        try {
                .build();
        reset();
import org.opensearch.index.IndexSettings;
        reset();  
        public CommitStats getCommitStats() {
        ShardId shardId = new ShardId("test", "_na_", 0);
    public void testThrowsWhenNullEngineConfig() {
    }
public class SafeBootstrapCommitterTests extends OpenSearchTestCase {
import org.opensearch.index.shard.ShardPath;
        @Override
        @Override
        ShardPath shardPath = new ShardPath(false, dataPath, dataPath, shardId);  
        }
import org.opensearch.index.engine.exec.commit.SafeBootstrapCommitter;  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
        Path translogPath = createTempDir();  
    public void testDiscoverAndTrimCalledWithValidConfig() throws IOException {  
        @Override
            .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, Collections.emptyList()));
        expectThrows(IllegalArgumentException.class, () -> new TestCommitter(new CommitterConfig(null, () -> {})));
    private EngineConfig buildEngineConfig(Store store, Path translogPath) {
    private static boolean discoverAndTrimCalled = false;
        }
        }
            super(config);
        }
    }  
import org.opensearch.index.engine.exec.commit.CommitterConfig;
            return null;
        Path baseDir = createTempDir();
            store.close();
