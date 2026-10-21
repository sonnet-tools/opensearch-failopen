                    assertNotNull(metadata.getLatestSegmentMetadataFileName());
        ClusterState state = getClusterState();
                for (RemoteStoreShardMetadata metadata : metadataList) {
                                hasKey("primary_term"),
                    assertEquals((int) shardId, metadata.getShardId());
                            }
        client().admin().indices().prepareRefresh(index2).get();
    public void testMetadataResponseFromAllNodes() {
            });
                            )
        });
                        );
                                    hasKey("generation"),
        RemoteStoreMetadataResponse response = client().admin().cluster().prepareRemoteStoreMetadata("*", null).get();
                            Map<String, Object> checkpoint = (Map<String, Object>) fileMeta.get("replication_checkpoint");
                                checkpoint,
        String indexName = "failure-case-index";
        assertBusy(() -> { assertFalse(client().admin().cluster().prepareHealth(INDEX_NAME).get().isTimedOut()); });
                                    hasKey("min_translog_gen"),
        }
                                Map<String, Object> meta = (Map<String, Object>) value;
                            );
                            )
import org.opensearch.cluster.ClusterState;
        indexDocs();
                        }
                        for (Object value : files.values()) {
                assertFalse(metadataList.isEmpty());
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataResponse;
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreShardMetadata;
                        Map<String, Object> files = (Map<String, Object>) fileMeta.get("files");
 * The OpenSearch Contributors require contributions made to
                            assertThat(
                    assertNotNull(translogFiles);
                }
                            allOf(
            response.groupByIndexAndShards().forEach((index, shardMap) -> {
        }
                            Map<String, Object> files = (Map<String, Object>) fileMeta.get("files");
                        for (Map<String, Object> fileMeta : segmentFiles.values()) {
import static org.hamcrest.Matchers.allOf;
                                hasKey("generation_to_primary_term")
        indexDocs(index1);
        setup();
        internalCluster().startNodes(3);
                            assertThat(meta, allOf(hasKey("original_name"), hasKey("checksum"), hasKey("length")));
import java.util.stream.Collectors;
import org.opensearch.Version;
                    assertFalse(segmentFiles.isEmpty());
import java.util.Locale;
            });
    }
public class RemoteStoreMetadataIT extends RemoteStoreBaseIntegTestCase {
        ensureGreen(index1, index2);
        createIndex(index1, remoteStoreIndexSettings(0, 2));
                    for (Map<String, Object> fileMeta : segmentFiles.values()) {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
package org.opensearch.remotestore;
                shardMap.forEach((shardId, metadataList) -> {
            .put("index.replication.type", "SEGMENT")
}
        List<String> nodes = state.nodes().getNodes().values().stream().map(DiscoveryNode::getName).collect(Collectors.toList());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    }
                    for (RemoteStoreShardMetadata metadata : metadataList) {
                assertFalse(metadataList.isEmpty());
            .put("index.remote_store.repository", "non-existent-repo")
            .put("index.remote_store.translog.repository", "non-existent-repo");
                            translogMeta,
import org.opensearch.test.OpenSearchIntegTestCase;
                                hasKey("generation"),
        indexDocs();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    assertFalse(metadataList.isEmpty());
        }
                    Map<String, Map<String, Object>> segmentFiles = metadata.getSegmentMetadataFiles();
                        assertEquals((int) shardId, metadata.getShardId());
                        assertNotNull(metadata.getLatestSegmentMetadataFileName());
                        assertNotNull(translogFiles);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        int refreshCount = 5;
        assertTrue(exception.getMessage().toLowerCase(Locale.ROOT).contains("repository"));
                });
                    assertEquals(index, metadata.getIndexName());
    @SuppressWarnings("unchecked")
        ensureGreen(INDEX_NAME);
                        assertNotNull(metadata.getLatestTranslogMetadataFileName());
 *
                    assertNotNull(metadata.getTranslogMetadataFiles());
                        assertFalse(segmentFiles.isEmpty());
import org.opensearch.test.transport.MockTransportService.TestPlugin;
                        );
                                hasKey("segment_infos_version"),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ensureGreen(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                    assertEquals(index, metadata.getIndexName());
            .put("index.remote_store.translog.enabled", true)
                        assertThat(
                assertFalse(metadataList.isEmpty());
            shardMap.forEach((shardId, metadataList) -> {
                    assertNotNull(metadata.getSegmentMetadataFiles());
            RemoteStoreMetadataResponse response = client(node).admin().cluster().prepareRemoteStoreMetadata(INDEX_NAME, null).get();
                    assertFalse(translogFiles.isEmpty());
import org.opensearch.cluster.node.DiscoveryNode;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 1));
                    assertFalse(metadata.getSegmentMetadataFiles().isEmpty());
            assertTrue(response.getSuccessfulShards() > 0);
    private void indexDocs(String indexName) {
import java.util.stream.Stream;
                                assertThat(meta, allOf(hasKey("original_name"), hasKey("checksum"), hasKey("length")));
                });
                                allOf(
            shardMap.forEach((shardId, metadataList) -> {
                        }
    }
                        assertNotNull(files);
import static org.hamcrest.Matchers.hasKey;
                                    hasKey("created_timestamp")
                    Map<String, Map<String, Object>> translogFiles = metadata.getTranslogMetadataFiles();
                                hasKey("created_timestamp")
                        for (Map<String, Object> translogMeta : translogFiles.values()) {
        RemoteStoreMetadataResponse response = client().admin().cluster().prepareRemoteStoreMetadata(INDEX_NAME, null).get();
 */
    }
/*
        Map<String, Map<Integer, List<RemoteStoreShardMetadata>>> grouped = response.groupByIndexAndShards();
                            assertThat(
                        assertNotNull(segmentFiles);
    private void indexDocs() {
                            assertNotNull(files);
                            assertNotNull(checkpoint);
                                )
                                hasKey("codec"),
    }
                metadataList.forEach(metadata -> {
                            allOf(
        setup();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.plugins.Plugin;
            });
                    assertEquals(refreshCount, metadata.getSegmentMetadataFiles().size());
    private static final String INDEX_NAME = "remote-store-meta-api-test";
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.IndexMetadata;
        });
        String index2 = INDEX_NAME + "-2";
    @Override
        assertTrue(grouped.containsKey(index1));
    public void testShardFailureWhenRepositoryMissing() throws Exception {
    }
                        Map<String, Map<String, Object>> translogFiles = metadata.getTranslogMetadataFiles();
    }
    }
                                    hasKey("generation_to_primary_term")
    }
                    assertEquals((int) shardId, metadata.getShardId());
    public void testMetadataResponseMultipleIndicesAndShards() throws Exception {
                            for (Object value : files.values()) {
                        assertFalse(translogFiles.isEmpty());
                        Map<String, Object> checkpoint = (Map<String, Object>) fileMeta.get("replication_checkpoint");
            client().prepareIndex(indexName).setId("doc-" + i).setSource("field", "value-" + i).get();
            assertNotNull(response.groupByIndexAndShards());
    @SuppressWarnings("unchecked")
                        assertEquals(index, metadata.getIndexName());
        client().admin().indices().prepareRefresh(index1).get();
                                    hasKey("segments_gen"),
                                    hasKey("codec"),
                    }
 * SPDX-License-Identifier: Apache-2.0
                            checkpoint,
        return Stream.concat(super.nodePlugins().stream(), Stream.of(TestPlugin.class)).collect(Collectors.toList());
        setup();
        indexDocs(INDEX_NAME);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 3));
                                    hasKey("primary_term"),
        });
                        assertFalse(files.isEmpty());
        String index1 = INDEX_NAME + "-1";
                    assertNotNull(segmentFiles);
    public void testMultipleMetadataFilesPerShard() throws Exception {
                            );
                        Map<String, Map<String, Object>> segmentFiles = metadata.getSegmentMetadataFiles();
                    }
        setup();
                        assertThat(
        assertTrue(grouped.containsKey(index2));
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                        assertNotNull(checkpoint);
import java.util.Collection;
        Exception exception = expectThrows(Exception.class, () -> assertAcked(prepareCreate(indexName).setSettings(settings)));
            });
        for (int i = 0; i < refreshCount; i++) {
            indexDocs();
            shardMap.forEach((shardId, metadataList) -> {
                }
    }
                            assertFalse(files.isEmpty());
                                allOf(
    public void testMetadataResponseAllShards() throws Exception {
                    assertNotNull(metadata.getLatestTranslogMetadataFileName());
        indexDocs(index2);
                                    hasKey("segment_infos_version"),
import java.util.Map;
import java.util.List;
        Settings.Builder settings = Settings.builder()
        grouped.forEach((index, shardMap) -> {
                                hasKey("min_translog_gen"),
                                hasKey("segments_gen"),
                    assertFalse(metadata.getTranslogMetadataFiles().isEmpty());
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        response.groupByIndexAndShards().forEach((index, shardMap) -> {
                                hasKey("primary_term"),
                            Map<String, Object> meta = (Map<String, Object>) value;
                for (RemoteStoreShardMetadata metadata : metadataList) {
        for (String node : nodes) {
 * compatible open source license.
                                    hasKey("primary_term"),
        RemoteStoreMetadataResponse response = client().admin().cluster().prepareRemoteStoreMetadata(INDEX_NAME, null).get();
        for (int i = 0; i < randomIntBetween(10, 20); i++) {
                        }
        response.groupByIndexAndShards().forEach((index, shardMap) -> {
                                translogMeta,
 * this file be licensed under the Apache-2.0 license or a
                    for (Map<String, Object> translogMeta : translogFiles.values()) {
                                )
                    assertTrue(metadata.getTranslogMetadataFiles().size() >= 1);
        createIndex(index2, remoteStoreIndexSettings(0, 3));
    public void setup() {
        createIndex(INDEX_NAME, remoteStoreIndexSettings(0, 2));
