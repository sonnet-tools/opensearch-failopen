import org.opensearch.common.util.FeatureFlags;
    }  
    public void testGetWithRemoteStoreEnabled() {
        return indexSettings;  
                .put("node.attr.remote_store.translog.repository", "translog_repo")
                .build();
        IndexWriter.IndexReaderWarmer warmer = factory.get(indexShard);
    public void tearDown() throws Exception {  
        IndexSettings indexSettings;  
    public static IndexSettings createIndexSettings(boolean remote, Settings settings) {
        assertTrue(warmer instanceof MergedSegmentWarmer);
    @Override
 * compatible open source license.
        transportService = mock(TransportService.class);
import org.opensearch.indices.recovery.RecoverySettings;
        when(indexShard.shardId()).thenReturn(shardId);
            Settings nodeSettings = Settings.builder()
        assertNotNull(warmer);
            indexSettings = IndexSettingsModule.newIndexSettings("test_index", settings);
        super.setUp();  
import org.opensearch.core.index.Index;  
            false,
 * The OpenSearch Contributors require contributions made to  
    private TransportService transportService;  
        IndexWriter.IndexReaderWarmer warmer = factory.get(indexShard);
        } else {  
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build()
import static org.mockito.Mockito.when;
        super.tearDown();
import org.apache.lucene.index.IndexWriter;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSettings;
    }  
        IndexWriter.IndexReaderWarmer warmer = factory.get(indexShard);  
        shardId = new ShardId(new Index("test", "uuid"), 0);
import org.opensearch.test.IndexSettingsModule;  
 *
            false,
        );  
                .put("node.attr.remote_store.enabled", "true")  
        indexShard = mock(IndexShard.class);  
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
    }  
        if (remote) {
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT).build()
}
        recoverySettings = mock(RecoverySettings.class);
    private ClusterService clusterService;
        FeatureFlags.initializeFeatureFlags(Settings.EMPTY);
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexSettings indexSettings = createIndexSettings(
        when(indexShard.indexSettings()).thenReturn(indexSettings);
            true,
        );
        assertTrue(warmer instanceof MergedSegmentWarmer);  
        assertNotNull(warmer);
        IndexSettings indexSettings = createIndexSettings(  
/*  
        IndexSettings indexSettings = createIndexSettings(  
public class MergedSegmentWarmerFactoryTests extends OpenSearchTestCase {
        );  
    }
import org.opensearch.indices.replication.common.ReplicationType;
        when(indexShard.indexSettings()).thenReturn(indexSettings);  
import org.opensearch.transport.TransportService;
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build()  
 */  
    }  
                .put("node.attr.remote_store.segment.repository", "seg_repo")
import org.opensearch.common.settings.Settings;
        }
        factory = new MergedSegmentWarmerFactory(transportService, recoverySettings, clusterService);
        when(indexShard.indexSettings()).thenReturn(indexSettings);
    private IndexShard indexShard;
    public void testGetWithSegmentReplication() {
    public void setUp() throws Exception {
import org.opensearch.core.index.shard.ShardId;
                .put("node.name", "xyz")  
    private ShardId shardId;
    private MergedSegmentWarmerFactory factory;  
package org.opensearch.index.engine;
    }
import org.opensearch.cluster.service.ClusterService;  
    @Override
        assertNull(warmer);
    private RecoverySettings recoverySettings;
import org.opensearch.index.shard.IndexShard;  
    public void testGetWithDocumentReplication() {  
            indexSettings = IndexSettingsModule.newIndexSettings(new Index("test_index", "_na_"), settings, nodeSettings);
        clusterService = mock(ClusterService.class);  
 * SPDX-License-Identifier: Apache-2.0
