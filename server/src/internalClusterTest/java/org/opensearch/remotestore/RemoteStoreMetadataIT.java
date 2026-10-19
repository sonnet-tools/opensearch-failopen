 */  
import org.opensearch.plugins.Plugin;
        }
        });
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            assertNotNull(response.groupByIndexAndShards());
                        assertEquals((int) shardId, metadata.getShardId());  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                                )
                                    hasKey("generation_to_primary_term")  
        Exception exception = expectThrows(Exception.class, () -> assertAcked(prepareCreate(indexName).setSettings(settings)));
                    }
                            Map<String, Object> meta = (Map<String, Object>) value;
                                    hasKey("created_timestamp")  
    }
    @Override
package org.opensearch.remotestore;
                                hasKey("created_timestamp")
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 3));
        response.groupByIndexAndShards().forEach((index, shardMap) -> {
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreShardMetadata;  
        String index2 = INDEX_NAME + "-2";
            assertTrue(response.getSuccessfulShards() > 0);  
            RemoteStoreMetadataResponse response = client(node).admin().cluster().prepareRemoteStoreMetadata(INDEX_NAME, null).get();
                        assertNotNull(segmentFiles);  
                                hasKey("segment_infos_version"),  
    private static final String INDEX_NAME = "remote-store-meta-api-test";
        assertTrue(grouped.containsKey(index2));
        assertTrue(grouped.containsKey(index1));  
                assertFalse(metadataList.isEmpty());
    }
        indexDocs(INDEX_NAME);
                        Map<String, Map<String, Object>> segmentFiles = metadata.getSegmentMetadataFiles();
                        assertNotNull(metadata.getLatestSegmentMetadataFileName());
                for (RemoteStoreShardMetadata metadata : metadataList) {  
            });
                    assertEquals(index, metadata.getIndexName());
                                    hasKey("generation"),
        RemoteStoreMetadataResponse response = client().admin().cluster().prepareRemoteStoreMetadata("*", null).get();
                                hasKey("primary_term"),
        int refreshCount = 5;
                        Map<String, Map<String, Object>> translogFiles = metadata.getTranslogMetadataFiles();
                                )
                                    hasKey("segments_gen"),  
        ensureGreen(INDEX_NAME);  
import java.util.Collection;  
                    assertNotNull(segmentFiles);
                        assertNotNull(metadata.getLatestTranslogMetadataFileName());  
    }
                            assertThat(
                    for (Map<String, Object> fileMeta : segmentFiles.values()) {
 * compatible open source license.
                                translogMeta,
        for (String node : nodes) {
                            allOf(  
        setup();  
                shardMap.forEach((shardId, metadataList) -> {
    }
        }
                        }  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
import org.opensearch.Version;
                                    hasKey("segment_infos_version"),
        internalCluster().startNodes(3);
            });
                    assertNotNull(translogFiles);
                    for (Map<String, Object> translogMeta : translogFiles.values()) {
            .put("index.remote_store.translog.enabled", true)
    }
    }  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 1));
                            )  
                    assertFalse(translogFiles.isEmpty());  
 *
                            assertThat(  
        ensureGreen(index1, index2);  
    @SuppressWarnings("unchecked")
                    assertNotNull(metadata.getSegmentMetadataFiles());  
    public void testMetadataResponseAllShards() throws Exception {
                            )  
        indexDocs();
        createIndex(index2, remoteStoreIndexSettings(0, 3));
    private void indexDocs(String indexName) {
                        for (Map<String, Object> translogMeta : translogFiles.values()) {
            .put("index.remote_store.repository", "non-existent-repo")  
                        Map<String, Object> checkpoint = (Map<String, Object>) fileMeta.get("replication_checkpoint");
            .put("index.replication.type", "SEGMENT")
        String index1 = INDEX_NAME + "-1";
                                Map<String, Object> meta = (Map<String, Object>) value;
        });  
                        }  
        response.groupByIndexAndShards().forEach((index, shardMap) -> {
                            Map<String, Object> files = (Map<String, Object>) fileMeta.get("files");
                        assertEquals(index, metadata.getIndexName());
                });
        Settings.Builder settings = Settings.builder()  
                metadataList.forEach(metadata -> {  
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataResponse;
                            assertThat(meta, allOf(hasKey("original_name"), hasKey("checksum"), hasKey("length")));
                                assertThat(meta, allOf(hasKey("original_name"), hasKey("checksum"), hasKey("length")));  
}  
import org.opensearch.cluster.metadata.IndexMetadata;
        setup();  
        ensureGreen(INDEX_NAME);  
                                checkpoint,  
                    assertEquals(index, metadata.getIndexName());
        String indexName = "failure-case-index";
                                    hasKey("codec"),
        grouped.forEach((index, shardMap) -> {  
                    for (RemoteStoreShardMetadata metadata : metadataList) {
                                    hasKey("primary_term"),
                        for (Map<String, Object> fileMeta : segmentFiles.values()) {  
import org.opensearch.test.OpenSearchIntegTestCase;  
                            Map<String, Object> checkpoint = (Map<String, Object>) fileMeta.get("replication_checkpoint");  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(TestPlugin.class)).collect(Collectors.toList());  
/*  
            indexDocs();
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).collect(Collectors.toList());
                    assertEquals((int) shardId, metadata.getShardId());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        setup();
        assertTrue(exception.getMessage().toLowerCase(Locale.ROOT).contains("repository"));  
                    }
                        assertFalse(files.isEmpty());
                                allOf(
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 2));
import static org.hamcrest.Matchers.hasKey;  
    private void indexDocs() {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }  
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
import org.opensearch.common.settings.Settings;
        setup();  
 * The OpenSearch Contributors require contributions made to  
    public void testMultipleMetadataFilesPerShard() throws Exception {
            .put("index.remote_store.translog.repository", "non-existent-repo");
                    assertFalse(metadataList.isEmpty());
                            assertNotNull(files);
                                hasKey("generation"),  
            client().prepareIndex(indexName).setId("doc-" + i).setSource("field", "value-" + i).get();  
                    assertNotNull(metadata.getLatestSegmentMetadataFileName());
                    assertFalse(segmentFiles.isEmpty());  
                    assertNotNull(metadata.getLatestTranslogMetadataFileName());
        Map<String, Map<Integer, List<RemoteStoreShardMetadata>>> grouped = response.groupByIndexAndShards();
                        for (Object value : files.values()) {  
                                    hasKey("min_translog_gen"),
                            allOf(
                        );
        createIndex(index1, remoteStoreIndexSettings(0, 2));
import java.util.Map;  
            shardMap.forEach((shardId, metadataList) -> {
        assertBusy(() -> { assertFalse(client().admin().cluster().prepareHealth(INDEX_NAME).get().isTimedOut()); });
                    Map<String, Map<String, Object>> segmentFiles = metadata.getSegmentMetadataFiles();
                    Map<String, Map<String, Object>> translogFiles = metadata.getTranslogMetadataFiles();
                    assertEquals((int) shardId, metadata.getShardId());
import java.util.Locale;
                                hasKey("generation_to_primary_term")
                for (RemoteStoreShardMetadata metadata : metadataList) {
 * this file be licensed under the Apache-2.0 license or a
public class RemoteStoreMetadataIT extends RemoteStoreBaseIntegTestCase {  
                            );
import java.util.stream.Stream;
                        assertNotNull(translogFiles);  
        RemoteStoreMetadataResponse response = client().admin().cluster().prepareRemoteStoreMetadata(INDEX_NAME, null).get();
import org.opensearch.cluster.ClusterState;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        indexDocs(index2);  
                    assertFalse(metadata.getSegmentMetadataFiles().isEmpty());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                                hasKey("min_translog_gen"),
            });  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        client().admin().indices().prepareRefresh(index1).get();
                        Map<String, Object> files = (Map<String, Object>) fileMeta.get("files");  
                                allOf(
import java.util.List;
                        assertFalse(segmentFiles.isEmpty());
                            }
    public void setup() {  
        for (int i = 0; i < randomIntBetween(10, 20); i++) {
 * SPDX-License-Identifier: Apache-2.0
                    assertEquals(refreshCount, metadata.getSegmentMetadataFiles().size());  
        });
            shardMap.forEach((shardId, metadataList) -> {
                            checkpoint,
    public void testShardFailureWhenRepositoryMissing() throws Exception {  
                        assertNotNull(files);
                            for (Object value : files.values()) {
        ClusterState state = getClusterState();
                }  
                            );
                });
                        }  
                            assertFalse(files.isEmpty());  
                assertFalse(metadataList.isEmpty());
    }
                    }
                }
                        assertThat(
import org.opensearch.test.transport.MockTransportService.TestPlugin;
            });  
        indexDocs(index1);
                                hasKey("segments_gen"),
                assertFalse(metadataList.isEmpty());  
                    assertNotNull(metadata.getTranslogMetadataFiles());
    public void testMetadataResponseMultipleIndicesAndShards() throws Exception {
    }
                            assertNotNull(checkpoint);
        ensureGreen(INDEX_NAME);  
        for (int i = 0; i < refreshCount; i++) {  
                        );
        indexDocs();
            response.groupByIndexAndShards().forEach((index, shardMap) -> {  
        client().admin().indices().prepareRefresh(index2).get();  
        RemoteStoreMetadataResponse response = client().admin().cluster().prepareRemoteStoreMetadata(INDEX_NAME, null).get();  
                    assertFalse(metadata.getTranslogMetadataFiles().isEmpty());  
                            translogMeta,  
                    assertTrue(metadata.getTranslogMetadataFiles().size() >= 1);
    public void testMetadataResponseFromAllNodes() {
                        assertNotNull(checkpoint);  
import org.opensearch.cluster.node.DiscoveryNode;  
                                    hasKey("primary_term"),  
                                hasKey("codec"),
import java.util.stream.Collectors;
                        assertThat(
    }
            shardMap.forEach((shardId, metadataList) -> {  
import static org.hamcrest.Matchers.allOf;
    @SuppressWarnings("unchecked")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                                hasKey("primary_term"),
                        assertFalse(translogFiles.isEmpty());
