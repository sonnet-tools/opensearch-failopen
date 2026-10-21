        }
    public static class FailureInjectingCommitterPlugin extends Plugin implements EnginePlugin {
                InMemoryCommitter committer = new InMemoryCommitter(config.engineConfig().getStore());
        }
                committer.setCommitFailure(() -> {
 *   <li>{@code testCommitCorruptionFailsEngine} — CorruptIndexException during commit fails the engine</li>
            assertTrue("should contain IOException", e.getMessage().contains("disk full") || e.getCause() instanceof IOException);
        FailureInjectingCommitterPlugin.clearFailure();
        FailureInjectingCommitterPlugin.clearFailure();
        indexDocs(5);
 * IT for committer failure injection. Uses {@link FailureInjectingCommitterPlugin} which provides
import org.opensearch.index.shard.IndexShardTestCase;
            commitFailure.set(null);
    private void indexDocs(int count) {
        indexDocs(5);
        FileBackedDataFormatPlugin.clearFailure();
        // Engine should be failed — subsequent ops throw
        flush();
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(svc.getShard(0));
        ensureGreen(INDEX_NAME);
        }
        }
        flush();
                // Wire the static failure supplier so it's checked on every commit
        public Optional<CommitterFactory> getCommitterFactory(org.opensearch.index.IndexSettings indexSettings) {
        }
 * this file be licensed under the Apache-2.0 license or a
 *   <li>{@code testCommitIOExceptionEngineStaysOpen} — plain IOException (disk full) during commit,
 *       engine stays open, retry succeeds</li>
    @Override
    private static final String INDEX_NAME = "test-committer-failure";
import org.opensearch.index.engine.FlushFailedEngineException;
import org.opensearch.test.OpenSearchIntegTestCase;
        flush();
 * <ul>
 * The OpenSearch Contributors require contributions made to
package org.opensearch.composite;
            () -> new org.apache.lucene.index.CorruptIndexException("simulated corruption", "test")
 * compatible open source license.
import org.opensearch.index.IndexService;
                .put("index.pluggable.dataformat", "composite")
import org.opensearch.common.util.FeatureFlags;
public class CompositeCommitterFailureIT extends OpenSearchIntegTestCase {
    }
import java.util.concurrent.atomic.AtomicReference;
        super.tearDown();
 *
        );
        public static void clearFailure() {
        String nodeId = clusterService().state().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
    /** Plain IOException during commit → engine stays open, retry succeeds. */
        }
            assertTrue("cause should be CorruptIndexException", e.getCause() instanceof org.apache.lucene.index.CorruptIndexException);
    @Override
        indexDocs(2);
import java.util.Arrays;
        } catch (OpenSearchException e) {
import org.opensearch.index.engine.dataformat.stub.FileBackedDataFormatPlugin;
        @Override
        FileBackedDataFormatPlugin.clearFailure();
 * <p>
        FailureInjectingCommitterPlugin.setCommitFailure(
    }
import org.opensearch.core.rest.RestStatus;
            flush();
        indexDocs(3);
            flush();
        public static void setCommitFailure(Supplier<Exception> failure) {
        } catch (FlushFailedEngineException e) {
            .build();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testCommitCorruptionFailsEngine() throws Exception {
        return Settings.builder()
        );
import java.util.Optional;
        IndexService svc = internalCluster().getInstance(IndicesService.class, nodeName).indexServiceSafe(resolveIndex(INDEX_NAME));
    // --- Helpers ---
        createIndex(
            flush();
    public void setUp() throws Exception {
            assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("field", "v" + i).get().status());
        return Arrays.asList(FileBackedDataFormatPlugin.class, CompositeDataFormatPlugin.class, FailureInjectingCommitterPlugin.class);
import org.opensearch.plugins.EnginePlugin;
    public void tearDown() throws Exception {
                    Supplier<Exception> failure = commitFailure.get();
        // Engine should still be open — verify by indexing
    @Override
import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
    }
        FailureInjectingCommitterPlugin.clearFailure();
    private DataFormatAwareEngine getEngine() {
    public void testCommitFailureThenRecovery() throws Exception {
        indexDocs(5);
 *   <li>{@code testCommitFailureThenRecovery} — commit fails, clear failure, new docs indexed and flushed</li>
import org.opensearch.index.engine.exec.commit.CommitterFactory;
    // --- FailureInjectingCommitterPlugin ---
 * SPDX-License-Identifier: Apache-2.0
            return Optional.of(config -> {
import org.opensearch.cluster.metadata.IndexMetadata;
        FailureInjectingCommitterPlugin.clearFailure();
    }
                .put("index.pluggable.dataformat.enabled", true)
        indexDocs(5);
        private static final AtomicReference<Supplier<Exception>> commitFailure = new AtomicReference<>();
                .putList("index.composite.secondary_data_formats")
        for (int i = 0; i < count; i++) {
        expectThrows(Exception.class, () -> indexDocs(1));
        } catch (FlushFailedEngineException e) {
        super.setUp();
 */
        try {
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
        String nodeName = clusterService().state().nodes().get(nodeId).getName();
    /** CorruptIndexException during commit → engine fails. */
    }
/*
}
        createCompositeIndex();
import org.opensearch.plugins.Plugin;
import java.io.IOException;
        // 5 + 5 + 2 = 12 ops
        FileBackedDataFormatPlugin.setDataDirectory(createTempDir("filebacked"));
        // Retry flush should succeed
    }
    }
/**
        assertEquals(11, getEngine().getSeqNoStats(-1).getMaxSeqNo());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            Settings.builder()
        try {
        createCompositeIndex();
    /** Commit fails, clear failure, new flush succeeds with all data. */
    }
                    return failure != null ? failure.get() : null;
import org.opensearch.common.settings.Settings;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
        createCompositeIndex();
        FailureInjectingCommitterPlugin.setCommitFailure(() -> new IOException("disk full"));
            assertTrue("cause should be IOException", e.getCause() instanceof IOException);
            .put(super.nodeSettings(nodeOrdinal))
        FailureInjectingCommitterPlugin.setCommitFailure(() -> new IOException("No space left on device"));
    }
import java.util.Collection;
    private void flush() {
    @Override
        try {
    private void createCompositeIndex() {
    protected Settings nodeSettings(int nodeOrdinal) {
        FailureInjectingCommitterPlugin.clearFailure();
            commitFailure.set(failure);
    }
    }
            INDEX_NAME,
import org.opensearch.index.engine.DataFormatAwareEngine;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    public void testCommitIOExceptionEngineStaysOpen() throws Exception {
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
 * Tests:
 */
                .put("index.composite.primary_data_format", FileBackedDataFormatPlugin.FORMAT_NAME)
            });
    }
 * </ul>
        assertEquals(7, getEngine().getSeqNoStats(-1).getMaxSeqNo());
import java.util.function.Supplier;
                return committer;
 * an {@link InMemoryCommitter} with configurable commit failures via static supplier.
import org.opensearch.OpenSearchException;
import org.opensearch.indices.IndicesService;
                });
                .build()
