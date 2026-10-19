import org.opensearch.indices.replication.common.ReplicationType;
    protected Settings remoteStoreIndexSettings() {
    private static final String INDEX_NAME = "remote-store-test-idx-1";
import org.opensearch.plugins.Plugin;  
        internalCluster().startDataOnlyNodes(1);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IndexMetadata;
public class RemoteStoreMultipartFileCorruptionIT extends RemoteStoreBaseIntegTestCase {
    @Override  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            .put(super.indexSettings())
}
import java.util.Collection;
            .build();
            .indices()
package org.opensearch.remotestore.multipart;
import java.util.stream.Stream;  
        // ensuring red cluster meaning shard has failed and is unassigned
 * compatible open source license.
import org.opensearch.index.IndexModule;
 */  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
/*  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        indexSingleDoc(INDEX_NAME);
            .actionGet();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            .execute()
import org.opensearch.action.support.IndicesOptions;
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(INDEX_NAME);
    }  
    public void testLocalFileCorruptionDuringUpload() {
        client().admin()  
import org.opensearch.common.settings.Settings;  
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
import java.util.stream.Collectors;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put("index.refresh_interval", "300s")
            .prepareRefresh(INDEX_NAME)
        ensureRed(INDEX_NAME);
    }
 *
        createIndex(INDEX_NAME, remoteStoreIndexSettings());  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockFsRepositoryPlugin.class)).collect(Collectors.toList());
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        return Settings.builder()  
            .setIndicesOptions(IndicesOptions.STRICT_EXPAND_OPEN_HIDDEN_FORBID_CLOSED)  
