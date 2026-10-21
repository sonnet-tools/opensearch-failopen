            builder.toString(),
            committer.commit(new Committer.CommitInput(Map.<String, String>of().entrySet(), null));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.be.lucene.LucenePlugin;
            null,
            } catch (Throwable ignored) {
import org.apache.lucene.index.IndexWriter;
        expectThrows(IllegalStateException.class, committer::getIndexWriter);
import org.apache.lucene.store.NIOFSDirectory;
    @SuppressWarnings("unchecked")
 * SPDX-License-Identifier: Apache-2.0
        config.engineConfig().getStore().close();
    private static long readCounter(LuceneShardStatsTracker tracker, String fieldName) throws IOException {
import java.io.IOException;
            }
            null,
import org.apache.lucene.util.Version;
            new MockAnalyzer(random()),
        CommitterConfig settings = createCommitterConfig();
        try {
     * <p>Setup: register a {@link LuceneStatsProvider} + tracker against the shard's id
import org.opensearch.common.util.BigArrays;
            // Sanity baseline: both counters at zero before the failure.
import org.opensearch.plugins.PluginsService;
import java.util.Collections;
        committer.close();
            IndexWriter writer = committer.getIndexWriter();
import org.opensearch.index.engine.EngineConfig;
            committer.getIndexWriter().close();
     * underlying {@link IndexWriter} directly (without going through {@code committer.close()})
                return ((Number) map.get(fieldName)).longValue();
        provider.register(shardId, tracker);
            config.engineConfig().getStore().close();
        when(mockPluginsService.filterPlugins(EnginePlugin.class)).thenReturn(List.of(new LucenePlugin()));
import org.opensearch.common.settings.Settings;
            null,
        LuceneStatsProvider provider = new LuceneStatsProvider();
            Map<String, String> readBack = committer.getLastCommittedData();
            assertTrue(committer.getLastCommittedData().isEmpty());
        Path translogPath = dataPath.resolve("translog");
import java.util.Map;
            new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of()),
        LuceneCommitter committer = new LuceneCommitter(settings);
            settings.engineConfig().getStore().close();
        String translogUUID = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, 1L);
    }
            CommitStats stats = committer.getCommitStats();
                // committer.close() may complain because IndexWriter is already closed
    }
import org.opensearch.index.engine.CommitStats;
        throw new AssertionError("field not found: " + fieldName);
            provider.unregister(shardId);
            // commit() will pass; but indexWriter.commit() will throw AlreadyClosedException.
            // remains false (we did NOT call committer.close()) so ensureOpen() inside
            null,
 */
        }
import org.opensearch.index.codec.CodecService;
import org.opensearch.index.seqno.RetentionLeases;
        EngineConfig engineConfig = new EngineConfigFactory(mockPluginsService, indexSettings).newEngineConfig(
        }
import org.opensearch.index.engine.EngineConfigFactory;
        LuceneCommitter committer = new LuceneCommitter(settings);
        Store store = new Store(shardId, indexSettings, new NIOFSDirectory(dataPath), new DummyShardLock(shardId));
            null,
        assertNotNull(committer.getIndexWriter());
        } finally {
            if (section instanceof Map<?, ?> map && map.containsKey(fieldName)) {
            null,
            settings.engineConfig().getStore().close();
            assertEquals("commit_failures must be 1 after one failed commit", 1L, readCounter(tracker, "commit_failures"));
            committer.close();
     * (the class doesn't expose getters; this is the same surface end users observe).
            null,
        LuceneCommitter committer = new LuceneCommitter(settings);
 * this file be licensed under the Apache-2.0 license or a
            () -> committer.commit(new Committer.CommitInput(Map.of("key", "value").entrySet(), null))
        CommitterConfig settings = createCommitterConfig();
            assertEquals("value2", readBack.get("key2"));
 */
            null,
    }
            new InternalTranslogFactory(),
            null,
     */
            false,
package org.opensearch.be.lucene.index;
            new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false),
     * (in the finally) increments {@code commit_failures} instead of {@code commit_total}.
     * That {@code Throwable} lands in our catch block, which sets {@code threw=true} and
        } finally {
import static org.mockito.Mockito.when;
     * Verifies that {@code lucene.commit.commit_failures} increments when {@code commit()}
    }
            assertEquals("commit_total must still be 0 (failed attempt does not count)", 0L, readCounter(tracker, "commit_total"));
            () -> Boolean.TRUE,
        for (Object section : parsed.values()) {
            assertNotNull(writer);
            Map<String, String> commitData = Map.of("key1", "value1", "key2", "value2", "_snapshot_", "serialized-data");
        committer.close();
            TimeValue.timeValueMinutes(5),
            () -> new RetentionLeases(0, 0, Collections.emptyList()),
    /** Reads a single counter from a tracker by rendering its snapshot to JSON. */
            shardId,
        tracker.stats().toXContent(builder, org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS);
import org.opensearch.index.IndexSettings;
     *
    }
            null,
            settings.engineConfig().getStore().close();
        CommitterConfig settings = createCommitterConfig();
            IllegalStateException.class,
 * compatible open source license.
        try {
            assertEquals(readBack, stats.getUserData());
            org.opensearch.common.xcontent.json.JsonXContent.jsonXContent,
            null,
        CommitterConfig config = createCommitterConfig();
        LuceneCommitter committer = new LuceneCommitter(config);
        LuceneShardStatsTracker tracker = new LuceneShardStatsTracker();
import org.apache.lucene.tests.analysis.MockAnalyzer;
            expectThrows(Throwable.class, () -> committer.commit(new Committer.CommitInput(Map.<String, String>of().entrySet(), null)));
            // Contract: commit_failures incremented by exactly 1, commit_total still 0.
public class LuceneCommitterTests extends OpenSearchTestCase {
import static org.mockito.Mockito.mock;
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
            null,
import org.opensearch.test.IndexSettingsModule;
            assertEquals(genBeforeCommit + 1, stats.getGeneration());
        try {
    public void testCommitWithEmptyData() throws IOException {
            committer.commit(new Committer.CommitInput(commitData.entrySet(), null));
        }
            assertEquals("serialized-data", readBack.get("_snapshot_"));
    }
        } finally {
            null,
            indexSettings,
        }
        ShardId shardId = config.engineConfig().getShardId();
            assertEquals("baseline commit_failures", 0L, readCounter(tracker, "commit_failures"));
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
import org.opensearch.test.OpenSearchTestCase;
            null,
    public void testCommitRoundTrip() throws IOException {
            null,
            try {
        ShardId shardId = new ShardId("test", "_na_", 0);
        settings.engineConfig().getStore().close();
import org.opensearch.common.unit.TimeValue;
            assertTrue(writer.isOpen());
        );
     * so {@link LuceneCommitter#commit} can reach them via the global registry. Close the
            null,
     * passes, but the next {@code indexWriter.commit()} throws {@code AlreadyClosedException}.
    public void testCommitFailureIncrementsCommitFailuresCounter() throws IOException {
import org.opensearch.index.store.Store;
        PluginsService mockPluginsService = mock(PluginsService.class);
            assertEquals("value1", readBack.get("key1"));
            assertEquals("baseline commit_total", 0L, readCounter(tracker, "commit_total"));
import org.opensearch.index.seqno.SequenceNumbers;
        DataFormatStatsProviderRegistry.INSTANCE.register(provider);
    /**
     * throws, and {@code commit_total} does NOT increment for the failed attempt.
import org.opensearch.index.engine.exec.commit.Committer;
import org.opensearch.index.engine.exec.commit.CommitterConfig;
        );
     * — this leaves {@code LuceneCommitter.isClosed=false} so {@code ensureOpen()} still
        builder.endObject();
        CommitterConfig settings = createCommitterConfig();
            null,
        var builder = org.opensearch.common.xcontent.XContentFactory.jsonBuilder().startObject();
        try {
            }
import org.opensearch.index.translog.TranslogConfig;
        Path baseDir = createTempDir();
        // The field lives one level deep (e.g., parsed.commit.commit_failures).
import java.util.List;
import org.opensearch.index.translog.Translog;
            null
            long genBeforeCommit = committer.getCommitStats().getGeneration();
        store.createEmpty(Version.LATEST, translogUUID);
                committer.close();
        LuceneCommitter committer = new LuceneCommitter(settings);
/*
     *
import java.nio.file.Path;
import org.opensearch.test.DummyShardLock;
        LuceneCommitter committer = new LuceneCommitter(config);
            true
            committer.close();
            null,
            committer.close();
            null,
        expectThrows(
 *
        } finally {
    }
    }
        }
        Files.createDirectories(dataPath);
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
        CommitterConfig config = createCommitterConfig();
}
import java.nio.file.Files;
            store,
    public void testCommitAfterCloseThrows() throws IOException {
        return new CommitterConfig(engineConfig, () -> {});
            null,
            null,
import org.opensearch.index.translog.InternalTranslogFactory;
        );
import org.opensearch.plugins.EnginePlugin;
    public void testConstructorOpensIndexWriter() throws IOException {
    private CommitterConfig createCommitterConfig() throws IOException {
        Files.createDirectories(translogPath);
        Map<String, Object> parsed = org.opensearch.common.xcontent.XContentHelper.convertToMap(
            // Force the IndexWriter into a closed state. The committer's own isClosed flag
 * Tests for {@link LuceneCommitter}.
     * <p>We read counter values by rendering {@code LuceneShardStats#toXContent} to JSON
import org.apache.logging.log4j.LogManager;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
    public void testCloseReleasesIndexWriter() throws IOException {
import org.opensearch.core.index.shard.ShardId;
/**
