    }
import org.opensearch.test.IndexSettingsModule;  
import org.opensearch.index.engine.exec.commit.CommitterConfig;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.translog.Translog;  
import java.nio.file.Path;
                committer.close();  
                .retentionLeasesSupplier(() -> new RetentionLeases(0, 0, Collections.emptyList()))
            }
import java.util.Collections;  
import org.apache.lucene.util.Version;  
import org.opensearch.index.engine.EngineConfig;  
        Committer committer = null;
import org.opensearch.core.index.shard.ShardId;  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);  
                .codecService(new CodecService(null, indexSettings, LogManager.getLogger(getClass()), java.util.List.of()))
 */
import org.opensearch.common.settings.Settings;
import org.apache.lucene.store.NIOFSDirectory;
        }  
/**
import org.opensearch.index.store.Store;
import org.opensearch.index.translog.TranslogConfig;
        ShardId shardId = new ShardId("test", "_na_", 0);  
        String translogUUID = Translog.createEmptyTranslog(translogPath, SequenceNumbers.NO_OPS_PERFORMED, shardId, 1L);
        Files.createDirectories(translogPath);
            committer = committerFactory.getCommitter(new CommitterConfig(engineConfig, () -> {}));
import org.opensearch.index.engine.exec.commit.Committer;
            assertTrue("getCommitter() should return a LuceneCommitter instance", committer instanceof LuceneCommitter);  
                .translogConfig(new TranslogConfig(shardId, translogPath, indexSettings, BigArrays.NON_RECYCLING_INSTANCE, "", false))  
import org.opensearch.index.seqno.SequenceNumbers;
            store.close();
 * Tests for {@link LuceneCommitterFactory}.  
 *
            EngineConfig engineConfig = new EngineConfig.Builder().indexSettings(indexSettings)  
import org.opensearch.common.util.BigArrays;
import org.opensearch.index.seqno.RetentionLeases;  
package org.opensearch.be.lucene.index;
        Files.createDirectories(dataPath);
        try {
import org.opensearch.test.DummyShardLock;
 */  
}
import java.nio.file.Files;
        Path baseDir = createTempDir();
import org.opensearch.test.OpenSearchTestCase;
        store.createEmpty(Version.LATEST, translogUUID);
            LuceneCommitterFactory committerFactory = new LuceneCommitterFactory();  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
 * compatible open source license.
            if (committer != null) {
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.index.IndexSettings;
import org.opensearch.index.codec.CodecService;
public class LuceneCommitterFactoryTests extends OpenSearchTestCase {
        Store store = new Store(shardId, indexSettings, new NIOFSDirectory(dataPath), new DummyShardLock(shardId));
        Path translogPath = dataPath.resolve("translog");  
        } finally {
    public void testGetCommitterReturnsLuceneCommitter() throws IOException {
                .build();
        Path dataPath = baseDir.resolve(shardId.getIndex().getUUID()).resolve(Integer.toString(shardId.id()));
                .store(store)
