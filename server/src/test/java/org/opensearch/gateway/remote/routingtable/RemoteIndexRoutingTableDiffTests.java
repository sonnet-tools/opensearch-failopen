        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));  
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
    }
            STATE_VERSION  
        assertEquals(  
    public void testGetUploadedMetadata() throws IOException {  
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";  
import org.opensearch.cluster.ClusterState;
    }
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
            STATE_VERSION  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        threadPool.shutdown();  
import static org.mockito.Mockito.when;  
            previousState.getRoutingTable(),  
            compressor,
            previousState.getRoutingTable(),
    private BlobStoreTransferService blobStoreTransferService;
 */  
        assertEquals(RemoteStoreUtils.invertLong(STATE_TERM), nameTokens[1]);
import java.io.IOException;  
import org.opensearch.common.blobstore.BlobPath;  
 * this file be licensed under the Apache-2.0 license or a
    public void testGenerateBlobFileName() {
        );
            currentState.getRoutingTable()  
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
import org.opensearch.threadpool.ThreadPool;
 * SPDX-License-Identifier: Apache-2.0
            previousState.getRoutingTable(),
    private NamedWriteableRegistry namedWriteableRegistry;
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
            STATE_VERSION
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
import static org.hamcrest.Matchers.nullValue;
            currentState.getRoutingTable()  
    private static final long STATE_VERSION = 3L;
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
    }  
 *
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE;
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);  
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, numberOfShards, numberOfReplicas, false).build();
    private ClusterSettings clusterSettings;  
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
        assertThat(remoteDiffForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
        );
package org.opensearch.gateway.remote.routingtable;
import org.opensearch.core.compress.NoneCompressor;
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        );
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
            currentState.getRoutingTable()
            routingTableIncrementalDiff,  
        // Deserialize the remote diff
import org.opensearch.Version;
        assertThat(params.getPathTokens(), is(List.of(ROUTING_TABLE_DIFF_PATH_TOKEN)));
        assertThat(remoteDiffForUpload.getFullBlobName(), nullValue());
import org.junit.Before;
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
    private Compressor compressor;
    @Before
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(  
        assertEquals(remoteDiffForUpload.clusterUUID(), clusterUUID);
        // Serialize the remote diff
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);  
            STATE_VERSION
    public void testBlobFileName() {
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
            STATE_TERM,
import org.opensearch.cluster.Diff;  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, numberOfShards, numberOfReplicas + 1, true).build();
            STATE_TERM,  
    }
            routingTableIncrementalDiff,
import static org.hamcrest.Matchers.is;
    public void setup() {
import org.opensearch.common.settings.Settings;
            compressor,
        InputStream inputStream = remoteDiffForUpload.serialize();  
            routingTableIncrementalDiff.apply(previousState.getRoutingTable()).getIndicesRouting(),
            STATE_TERM,  
        );  
 * The OpenSearch Contributors require contributions made to  
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();  
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
        );
        assertEquals(remoteDiffForDownload.clusterUUID(), clusterUUID);
import org.opensearch.common.remote.BlobPathParameters;
    }
            STATE_VERSION  
            routingTableIncrementalDiff,
            previousState.getRoutingTable(),
            STATE_TERM,
        int numberOfShards = randomIntBetween(1, 10);
        );
            clusterUUID,
    }
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
        );
        );
    private String clusterName;  
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
import org.opensearch.cluster.routing.RoutingTable;
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(  
import org.opensearch.index.remote.RemoteStoreUtils;  
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(  
        );
    }
            routingTableIncrementalDiff,
import org.opensearch.common.compress.DeflateCompressor;
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
            clusterUUID,  
        assertEquals(ROUTING_TABLE_DIFF_FILE, uploadedMetadataAttribute.getComponent());
import org.opensearch.core.compress.Compressor;  
    private static final long STATE_TERM = 2L;
    public void testBlobPathParameters() {  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            clusterUUID,  
        String expectedPrefix = ROUTING_TABLE_DIFF_METADATA_PREFIX;  
        String blobFileName = remoteDiffForUpload.generateBlobFileName();
        assertEquals(RemoteStoreUtils.invertLong(STATE_VERSION), nameTokens[2]);
        assertThat(RemoteStoreUtils.invertLong(nameTokens[3]), lessThanOrEqualTo(System.currentTimeMillis()));  
            deserializedDiff.apply(previousState.getRoutingTable()).getIndicesRouting()
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
        // Assert that the indices routing table created from routingTableIncrementalDiff and deserializedDiff is equal
            STATE_VERSION
    public void tearDown() throws Exception {
            clusterUUID,
        assertThat(remoteDiffForUpload.getBlobFileName(), nullValue());
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();  
 * compatible open source license.
            compressor,  
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_METADATA_PREFIX;  
    private String clusterUUID;  
}
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
        int numberOfReplicas = randomIntBetween(1, 10);
        Diff<RoutingTable> deserializedDiff = remoteDiffForDownload.deserialize(inputStream);  
    }
        this.blobStoreRepository = mock(BlobStoreRepository.class);  
            currentState.getRoutingTable()
            currentState.getRoutingTable()
            clusterUUID,
import java.util.List;
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertThat(params.getFilePrefix(), is(expectedPrefix));
/*  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));  
        compressor = new NoneCompressor();
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            routingTableIncrementalDiff,
            compressor,
    @After  
    public void testStreamOperations() throws IOException {
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();  
            compressor,
        super.tearDown();
        this.clusterUUID = "test-cluster-uuid";
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
import static org.mockito.Mockito.mock;
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        );  
        BlobPathParameters params = remoteDiffForUpload.getBlobPathParameters();
            STATE_TERM,
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_PATH_TOKEN;
        );  
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(  
            clusterUUID,  
        assertEquals(ROUTING_TABLE_DIFF_METADATA_PREFIX, nameTokens[0]);  
        namedWriteableRegistry = writableRegistry();
            previousState.getRoutingTable(),  
        // Create a new instance for deserialization
import org.opensearch.threadpool.TestThreadPool;
        remoteDiffForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));  
import org.junit.After;  
        String[] nameTokens = blobFileName.split("__");
    private BlobStoreRepository blobStoreRepository;
        ClusterMetadataManifest.UploadedMetadata uploadedMetadataAttribute = remoteDiffForUpload.getUploadedMetadata();
        assertThat(remoteDiffForUpload.getBlobFileName(), nullValue());  
            routingTableIncrementalDiff,
            compressor,
import org.opensearch.test.OpenSearchTestCase;  
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
            STATE_TERM,
            clusterUUID,
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();  
    private static final String TEST_BLOB_PATH = "test-path";
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();  
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
        );  
            routingTableIncrementalDiff,  
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.generateClusterStateWithOneIndex;
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            compressor,  
    public void testClusterUUID() {  
            currentState.getRoutingTable()
        BlobPath blobPath = new BlobPath().add("/path");
import java.io.InputStream;
        assertThat(remoteDiffForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));  
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            currentState.getRoutingTable()
            STATE_TERM,
            STATE_VERSION
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
        );
            previousState.getRoutingTable(),
            previousState.getRoutingTable(),  
        );
    }  
        this.clusterName = "test-cluster-name";  
public class RemoteIndexRoutingTableDiffTests extends OpenSearchTestCase {
        );  
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
    public void testFullBlobName() {
