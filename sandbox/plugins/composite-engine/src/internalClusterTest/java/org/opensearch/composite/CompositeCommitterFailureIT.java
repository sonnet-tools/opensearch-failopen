import org.opensearch.index.engine.dataformat.stub.InMemoryCommitter;
 * this file be licensed under the Apache-2.0 license or a
    }
                committer.setCommitFailure(() -> {  
    }
                // Wire the static failure supplier so it's checked on every commit
    }
    }
    public void testCommitCorruptionFailsEngine() throws Exception {
import java.io.IOException;  
            flush();  
import java.util.concurrent.atomic.AtomicReference;
    private static final String INDEX_NAME = "test-committer-failure";
 * The OpenSearch Contributors require contributions made to  
        FileBackedDataFormatPlugin.setDataDirectory(createTempDir("filebacked"));
import org.opensearch.index.engine.dataformat.stub.FileBackedDataFormatPlugin;  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    /** Plain IOException during commit → engine stays open, retry succeeds. */
    public void testCommitIOExceptionEngineStaysOpen() throws Exception {
import org.opensearch.core.rest.RestStatus;
        createCompositeIndex();  
        createIndex(
    }
 * <p>
            return Optional.of(config -> {  
        flush();
            .build();
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();  
        );
    /** CorruptIndexException during commit → engine fails. */
import org.opensearch.common.settings.Settings;  
            Settings.builder()
                .put("index.pluggable.dataformat", "composite")
        indexDocs(5);
 */  
            assertTrue("cause should be IOException", e.getCause() instanceof IOException);
        assertEquals(11, getEngine().getSeqNoStats(-1).getMaxSeqNo());
        String nodeName = clusterService().state().nodes().get(nodeId).getName();  
    }  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
            () -> new org.apache.lucene.index.CorruptIndexException("simulated corruption", "test")
        super.setUp();  
        } catch (FlushFailedEngineException e) {
    protected Settings nodeSettings(int nodeOrdinal) {  
        try {
                .build()
        }
import org.opensearch.indices.IndicesService;
            assertTrue("should contain IOException", e.getMessage().contains("disk full") || e.getCause() instanceof IOException);
    // --- Helpers ---
    }
            });
                .putList("index.composite.secondary_data_formats")
}
import org.opensearch.common.util.FeatureFlags;
 * an {@link InMemoryCommitter} with configurable commit failures via static supplier.  
        indexDocs(3);
        public static void setCommitFailure(Supplier<Exception> failure) {
import org.opensearch.index.engine.exec.commit.CommitterFactory;
    public void testCommitFailureThenRecovery() throws Exception {
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
        // Engine should still be open — verify by indexing
    private void indexDocs(int count) {
    private void createCompositeIndex() {
/**
        indexDocs(2);
        private static final AtomicReference<Supplier<Exception>> commitFailure = new AtomicReference<>();  
        FailureInjectingCommitterPlugin.clearFailure();  
        IndexService svc = internalCluster().getInstance(IndicesService.class, nodeName).indexServiceSafe(resolveIndex(INDEX_NAME));
        }
        FileBackedDataFormatPlugin.clearFailure();
    }
        for (int i = 0; i < count; i++) {  
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
        try {
    @Override  
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(svc.getShard(0));
        }
        );  
        }  
        public static void clearFailure() {  
        FailureInjectingCommitterPlugin.setCommitFailure(() -> new IOException("disk full"));  
 *
        indexDocs(5);
            INDEX_NAME,  
        createCompositeIndex();  
        indexDocs(5);
        createCompositeIndex();  
        try {
            flush();
        String nodeId = clusterService().state().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
    /** Commit fails, clear failure, new flush succeeds with all data. */
import org.opensearch.index.IndexService;  
 * IT for committer failure injection. Uses {@link FailureInjectingCommitterPlugin} which provides
                .put("index.composite.primary_data_format", FileBackedDataFormatPlugin.FORMAT_NAME)  
/*  
import java.util.function.Supplier;
        ensureGreen(INDEX_NAME);
        } catch (OpenSearchException e) {  
        expectThrows(Exception.class, () -> indexDocs(1));
    public static class FailureInjectingCommitterPlugin extends Plugin implements EnginePlugin {
 *   <li>{@code testCommitIOExceptionEngineStaysOpen} — plain IOException (disk full) during commit,
                    return failure != null ? failure.get() : null;
        return Settings.builder()
        @Override
        FailureInjectingCommitterPlugin.setCommitFailure(  
            .put(super.nodeSettings(nodeOrdinal))
        FailureInjectingCommitterPlugin.setCommitFailure(() -> new IOException("No space left on device"));  
                InMemoryCommitter committer = new InMemoryCommitter(config.engineConfig().getStore());
        // 5 + 5 + 2 = 12 ops
package org.opensearch.composite;
                    Supplier<Exception> failure = commitFailure.get();
import java.util.Collection;
    @Override
        FileBackedDataFormatPlugin.clearFailure();  
        FailureInjectingCommitterPlugin.clearFailure();  
            commitFailure.set(null);
 * compatible open source license.
    private DataFormatAwareEngine getEngine() {
    public void tearDown() throws Exception {
import org.opensearch.OpenSearchException;
        }  
    }  
import java.util.Optional;  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.engine.FlushFailedEngineException;
 *       engine stays open, retry succeeds</li>  
        return Arrays.asList(FileBackedDataFormatPlugin.class, CompositeDataFormatPlugin.class, FailureInjectingCommitterPlugin.class);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void setUp() throws Exception {
    }  
        super.tearDown();
        flush();  
public class CompositeCommitterFailureIT extends OpenSearchIntegTestCase {
        public Optional<CommitterFactory> getCommitterFactory(org.opensearch.index.IndexSettings indexSettings) {
import org.opensearch.plugins.EnginePlugin;
import org.opensearch.index.engine.DataFormatAwareEngine;
        flush();  
 * </ul>
    // --- FailureInjectingCommitterPlugin ---  
        indexDocs(5);
                });  
            assertTrue("cause should be CorruptIndexException", e.getCause() instanceof org.apache.lucene.index.CorruptIndexException);
            flush();
    @Override  
 *   <li>{@code testCommitCorruptionFailsEngine} — CorruptIndexException during commit fails the engine</li>
        // Engine should be failed — subsequent ops throw  
 * <ul>  
        }
        }
            assertEquals(RestStatus.CREATED, client().prepareIndex(INDEX_NAME).setSource("field", "v" + i).get().status());
    private void flush() {
                return committer;
        FailureInjectingCommitterPlugin.clearFailure();
        FailureInjectingCommitterPlugin.clearFailure();
import org.opensearch.plugins.Plugin;  
    }  
        // Retry flush should succeed
                .put("index.pluggable.dataformat.enabled", true)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
 */  
            commitFailure.set(failure);  
    }
 *   <li>{@code testCommitFailureThenRecovery} — commit fails, clear failure, new docs indexed and flushed</li>
import org.opensearch.index.shard.IndexShardTestCase;  
        FailureInjectingCommitterPlugin.clearFailure();
        } catch (FlushFailedEngineException e) {  
        assertEquals(7, getEngine().getSeqNoStats(-1).getMaxSeqNo());
 * Tests:
