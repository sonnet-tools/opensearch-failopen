        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
import org.opensearch.gateway.remote.ClusterMetadataManifest;
    private String clusterName;
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE;
        // Deserialize the remote diff
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            clusterUUID,
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
            STATE_VERSION
        assertThat(params.getPathTokens(), is(List.of(ROUTING_TABLE_DIFF_PATH_TOKEN)));
    public void testStreamOperations() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
import org.opensearch.common.blobstore.BlobPath;
            routingTableIncrementalDiff,
}
    public void testBlobFileName() {
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            clusterUUID,
            previousState.getRoutingTable(),
import org.opensearch.index.remote.RemoteStoreUtils;
    private BlobStoreTransferService blobStoreTransferService;
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
        assertThat(params.getFilePrefix(), is(expectedPrefix));
            previousState.getRoutingTable(),
        );
        );
            STATE_TERM,
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertThat(RemoteStoreUtils.invertLong(nameTokens[3]), lessThanOrEqualTo(System.currentTimeMillis()));
            routingTableIncrementalDiff,
import org.opensearch.Version;
            previousState.getRoutingTable(),
        );
    }
            routingTableIncrementalDiff,
    public void setup() {
        Diff<RoutingTable> deserializedDiff = remoteDiffForDownload.deserialize(inputStream);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            clusterUUID,
        ClusterMetadataManifest.UploadedMetadata uploadedMetadataAttribute = remoteDiffForUpload.getUploadedMetadata();
 *
    }
    public void testFullBlobName() {
    private static final String TEST_BLOB_PATH = "test-path";
    public void testGetUploadedMetadata() throws IOException {
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertThat(remoteDiffForUpload.getBlobFileName(), nullValue());
    private static final long STATE_TERM = 2L;
    private ClusterSettings clusterSettings;
            routingTableIncrementalDiff,
import java.util.List;
        assertThat(remoteDiffForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
import org.opensearch.core.compress.NoneCompressor;
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        compressor = new NoneCompressor();
            previousState.getRoutingTable(),
        assertEquals(remoteDiffForDownload.clusterUUID(), clusterUUID);
        this.clusterName = "test-cluster-name";
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
        assertEquals(
            compressor,
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
import java.io.InputStream;
            compressor,
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
            clusterUUID,
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, numberOfShards, numberOfReplicas + 1, true).build();
            STATE_VERSION
            compressor,
            STATE_VERSION
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
import org.opensearch.threadpool.ThreadPool;
    public void testGenerateBlobFileName() {
        BlobPathParameters params = remoteDiffForUpload.getBlobPathParameters();
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, numberOfShards, numberOfReplicas, false).build();
            clusterUUID,
            clusterUUID,
            STATE_VERSION
        );
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertEquals(remoteDiffForUpload.clusterUUID(), clusterUUID);
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
        );
import org.opensearch.common.compress.DeflateCompressor;
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
    private BlobStoreRepository blobStoreRepository;
import org.opensearch.cluster.routing.RoutingTable;
        );
            deserializedDiff.apply(previousState.getRoutingTable()).getIndicesRouting()
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
            currentState.getRoutingTable()
    }
import static org.hamcrest.Matchers.is;
    }
            STATE_TERM,
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    @After
            STATE_VERSION
        // Assert that the indices routing table created from routingTableIncrementalDiff and deserializedDiff is equal
            compressor,
        );
        int numberOfReplicas = randomIntBetween(1, 10);
            previousState.getRoutingTable(),
            currentState.getRoutingTable()
    }
        this.blobStoreRepository = mock(BlobStoreRepository.class);
    private static final long STATE_VERSION = 3L;
            clusterUUID,
            STATE_TERM,
    }
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
            currentState.getRoutingTable()
import org.junit.After;
        );
        assertEquals(ROUTING_TABLE_DIFF_FILE, uploadedMetadataAttribute.getComponent());
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
    }
import org.opensearch.threadpool.TestThreadPool;
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
import org.opensearch.common.settings.ClusterSettings;
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
    public void testClusterUUID() {
        InputStream inputStream = remoteDiffForUpload.serialize();
            compressor,
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            routingTableIncrementalDiff,
            compressor,
        assertEquals(RemoteStoreUtils.invertLong(STATE_VERSION), nameTokens[2]);
        );
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
        assertThat(remoteDiffForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
        );
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
 * compatible open source license.
            STATE_TERM,
        assertEquals(RemoteStoreUtils.invertLong(STATE_TERM), nameTokens[1]);
import org.opensearch.common.remote.BlobPathParameters;
        String[] nameTokens = blobFileName.split("__");
        // Create a new instance for deserialization
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
        threadPool.shutdown();
 */
import static org.mockito.Mockito.mock;
    }
import java.io.IOException;
    private String clusterUUID;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
    private NamedWriteableRegistry namedWriteableRegistry;
        );
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
            STATE_VERSION
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
            compressor,
import org.opensearch.common.settings.Settings;
    @Before
    }
        super.tearDown();
            routingTableIncrementalDiff.apply(previousState.getRoutingTable()).getIndicesRouting(),
    public void testBlobPathParameters() {
import org.opensearch.test.OpenSearchTestCase;
            previousState.getRoutingTable(),
        );
        BlobPath blobPath = new BlobPath().add("/path");
            STATE_TERM,
import org.opensearch.cluster.ClusterState;
            routingTableIncrementalDiff,
    private Compressor compressor;
        int numberOfShards = randomIntBetween(1, 10);
public class RemoteIndexRoutingTableDiffTests extends OpenSearchTestCase {
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;
        );
            currentState.getRoutingTable()
        assertEquals(ROUTING_TABLE_DIFF_METADATA_PREFIX, nameTokens[0]);
import org.junit.Before;
            currentState.getRoutingTable()
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_PATH_TOKEN;
        namedWriteableRegistry = writableRegistry();
import org.opensearch.cluster.Diff;
            currentState.getRoutingTable()
        // Serialize the remote diff
        );
            routingTableIncrementalDiff,
            STATE_VERSION
            STATE_TERM,
        RoutingTableIncrementalDiff routingTableIncrementalDiff = new RoutingTableIncrementalDiff(
import org.opensearch.core.compress.Compressor;
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.generateClusterStateWithOneIndex;
        );
            STATE_TERM,
            currentState.getRoutingTable()
 * The OpenSearch Contributors require contributions made to
        assertThat(remoteDiffForUpload.getBlobFileName(), nullValue());
        RemoteRoutingTableDiff remoteDiffForDownload = new RemoteRoutingTableDiff(TEST_BLOB_NAME, clusterUUID, compressor, Version.CURRENT);
        RemoteRoutingTableDiff remoteDiffForUpload = new RemoteRoutingTableDiff(
        assertThat(remoteDiffForUpload.getFullBlobName(), nullValue());
        String blobFileName = remoteDiffForUpload.generateBlobFileName();
package org.opensearch.gateway.remote.routingtable;
import static org.mockito.Mockito.when;
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
 * this file be licensed under the Apache-2.0 license or a
            previousState.getRoutingTable(),
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
/*
import static org.hamcrest.Matchers.nullValue;
    public void tearDown() throws Exception {
        this.clusterUUID = "test-cluster-uuid";
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_METADATA_PREFIX;
        String expectedPrefix = ROUTING_TABLE_DIFF_METADATA_PREFIX;
        remoteDiffForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
