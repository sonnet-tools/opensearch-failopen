 * compatible open source license.
import org.opensearch.core.index.Index;  
public class RemoteStoreTestsHelper {
        return indexShard;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test_index", settings);
import org.opensearch.index.shard.IndexShard;  
}
        } else {
            .build();
            Settings nodeSettings = Settings.builder()  
    public static IndexSettings createIndexSettings(boolean remote) {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, String.valueOf(remoteStoreEnabled))  
                .put("node.attr.remote_store.translog.repository", "seg_repo")
 *
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
package org.opensearch.index.remote;
        Store store = mock(Store.class);  
        IndexSettings indexSettings;
    }  
import org.opensearch.core.index.shard.ShardId;
import static org.mockito.Mockito.when;  
 */  
    }
            indexSettings = IndexSettingsModule.newIndexSettings("test_index", settings);  
        if (remote) {
        IndexShard indexShard = mock(IndexShard.class);
 */
                .build();  
                .put("node.name", "xyz")
import org.opensearch.cluster.metadata.IndexMetadata;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.replication.common.ReplicationType;
 * Helper functions for Remote Store tests  
            indexSettings = IndexSettingsModule.newIndexSettings(new Index("test_index", "_na_"), settings, nodeSettings);
        Settings settings = Settings.builder()
        return createIndexSettings(remote, Settings.EMPTY);  
import static org.mockito.Mockito.mock;
/*  
    public static IndexSettings createIndexSettings(boolean remote, Settings settings) {  
import org.opensearch.test.IndexSettingsModule;  
 * SPDX-License-Identifier: Apache-2.0
        when(indexShard.indexSettings()).thenReturn(indexSettings);
    static IndexShard createIndexShard(ShardId shardId, boolean remoteStoreEnabled) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.store.Store;
import org.opensearch.common.settings.Settings;
    }  
/**
        return indexSettings;
        }
        when(indexShard.store()).thenReturn(store);
        when(indexShard.shardId()).thenReturn(shardId);  
import org.opensearch.index.IndexSettings;
