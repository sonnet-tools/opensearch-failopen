        Index index = coordClusterService.state().metadata().index(INDEX).getIndex();  
import org.opensearch.test.OpenSearchIntegTestCase;
        IndexMetadata pinned = coordClusterService.state().metadata().index(INDEX);  
        }
        internalCluster().startNode();  
        }
        try (RequestScopedMapperService holder = new RequestScopedMapperService(pinned, coordIndicesService::createIndexMapperService)) {
 */
    }
    }
        });  
        ensureGreen(INDEX);  
            assertNotNull(metadata.mapping());
        assertNull("coordinating-only node must not host the index", coordIndicesService.indexService(index));
        }
import org.opensearch.common.xcontent.XContentType;
        assertAcked(client().admin().indices().prepareDelete(INDEX));  
            assertNotNull(metadata.mapping());
        assertBusy(() -> {
            MapperService mapperService = holder.get();  
 * Verifies response-typing mapping resolution on a coordinating-only node (hosting no shard)  
    public void testPinnedSnapshotSurvivesIndexDeletion() throws Exception {  
        final long pinnedMappingVersion = pinned.getMappingVersion();
            assertEquals("keyword", mapperService.fieldType("brand.keyword").typeName());
        });
            assertEquals("keyword", mapperService.fieldType("brand.keyword").typeName());
            assertNotNull(mapperService);
 * this file be licensed under the Apache-2.0 license or a
/*  
 *
 * installed because the machinery under test does not depend on the engine.
public class RequestScopedMapperServiceIT extends OpenSearchIntegTestCase {
        assertBusy(() -> {
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
        client().prepareIndex(INDEX).setSource("{\"brand\":\"brandX\"}", XContentType.JSON).get();
import org.opensearch.indices.IndicesService;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        client().prepareIndex(INDEX).setSource("{\"brand\":\"brandY\",\"price\":42}", XContentType.JSON).get();  
}
            assertEquals("keyword", mapperService.fieldType("brand.keyword").typeName());  
 * compatible open source license.
        createIndex(
        createSingleShardIndex();  
import org.opensearch.core.index.Index;
            assertNull("a field the snapshot does not carry must not resolve", mapperService.fieldType("price"));  
        IndexMetadata current = coordClusterService.state().metadata().index(INDEX);  
        String coordNode = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
            assertTrue("the [price] mapping update must reach the coordinator", current.getMappingVersion() > pinnedMappingVersion);
            assertNull("the pinned snapshot must be immune to later dynamic updates", mapperService.fieldType("price"));  
        createSingleShardIndex();
        IndexMetadata pinned = coordClusterService.state().metadata().index(INDEX);
        client().prepareIndex(INDEX).setSource("{\"brand\":\"brandX\"}", XContentType.JSON).get();
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.Settings;  
        assertBusy(() -> assertNull(coordClusterService.state().metadata().index(INDEX)));
        ClusterService coordClusterService = internalCluster().getInstance(ClusterService.class, coordNode);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        internalCluster().startNode();
            assertNotNull(metadata);  
        }  
        String coordNode = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
            IndexMetadata metadata = coordClusterService.state().metadata().index(INDEX);  
        ClusterService coordClusterService = internalCluster().getInstance(ClusterService.class, coordNode);  
        IndicesService coordIndicesService = internalCluster().getInstance(IndicesService.class, coordNode);  
    private static final String INDEX = "dynamic-probe";  
    private void createSingleShardIndex() {
 */  
            assertEquals("long", mapperService.fieldType("price").typeName());
            assertTrue(metadata.mapping().source().string().contains("brand"));  
        });  
import org.opensearch.index.mapper.MapperService;  
            MapperService mapperService = holder.get();
        try (RequestScopedMapperService holder = new RequestScopedMapperService(current, coordIndicesService::createIndexMapperService)) {
            IndexMetadata current = coordClusterService.state().metadata().index(INDEX);  
 * cluster state, as {@code TransportExecuteAction} wires it; the DSL plugins are not  
            INDEX,  
            assertNotNull("the pinned snapshot must keep resolving after index deletion", mapperService);
package org.opensearch.dsl.action;
            assertNotNull(metadata);
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            MapperService mapperService = holder.get();
            assertNotNull(mapperService);  
    public void testCoordinatorResolvesPinnedMappingSnapshotUnderDynamicUpdates() throws Exception {
            IndexMetadata metadata = coordClusterService.state().metadata().index(INDEX);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * {@link RequestScopedMapperService} against the coordinator's real {@link IndicesService} and
            assertEquals("keyword", mapperService.fieldType("brand.keyword").typeName());
            assertNotNull(current);
 * The OpenSearch Contributors require contributions made to  
            assertTrue("dynamic mapping for [brand] must reach the coordinator", metadata.mapping().source().string().contains("brand"));
        try (RequestScopedMapperService holder = new RequestScopedMapperService(pinned, coordIndicesService::createIndexMapperService)) {
            MapperService mapperService = holder.get();  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            assertNotNull(mapperService);
/**
        );
 * while dynamic mapping updates arrive from documents indexed on a separate data node. Drives
        assertBusy(() -> {
        try (RequestScopedMapperService holder = new RequestScopedMapperService(pinned, coordIndicesService::createIndexMapperService)) {  
 * SPDX-License-Identifier: Apache-2.0
        IndicesService coordIndicesService = internalCluster().getInstance(IndicesService.class, coordNode);
