            compressor,  
            CURRENT
            compressor,
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
            clusterUUID,
        this.clusterUUID = "test-cluster-uuid";  
            compressor,
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
        );
        );  
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);  
            STATE_VERSION,
        threadPool.shutdown();
            compressor,
            namedWriteableRegistry  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        Custom clusterStateCustoms = getClusterStateCustom();
            compressor,
    }
            CURRENT  
import org.opensearch.common.settings.Settings;
        Custom clusterStateCustoms = getClusterStateCustom();
        assertThat(nameTokens[0], is(expectedPrefix));
        assertThat(remoteObjectForUpload.getFullBlobName(), nullValue());
import org.opensearch.common.compress.DeflateCompressor;
                    0L,
            compressor,
        );
            TEST_BLOB_NAME,
            STATE_VERSION,
import org.junit.After;  
        return SnapshotsInProgress.of(
    public void testBlobPathTokens() {
            clusterStateCustoms,
                    emptyList(),  
            "test-custom",
        BlobPath blobPath = new BlobPath().add("/path");  
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
        );
            namedWriteableRegistry  
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
    public void testFullBlobName() {
import static org.hamcrest.Matchers.nullValue;
            namedWriteableRegistry,
            namedWriteableRegistry
/*  
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
import org.opensearch.threadpool.TestThreadPool;
    }
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
            namedWriteableRegistry,  
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            "test-custom",
        );
        );
import java.util.List;
    private static final String CUSTOM_TYPE = "test-custom";
        );  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    false,
                    emptyList(),
        }  
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
            "test-custom",
import org.opensearch.core.compress.NoneCompressor;
            clusterStateCustoms,
    }
            STATE_VERSION,
                    emptyMap(),  
            "test-custom",  
    @Before  
import org.opensearch.core.compress.Compressor;  
        );
import static java.util.Collections.emptyMap;
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
            STATE_VERSION,
            clusterUUID,  
    }  
            assertThat(uploadedMetadata.getComponent(), is(expectedPrefix));
            TEST_BLOB_NAME,
            clusterStateCustoms,  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;  
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";  
            SnapshotsInProgress.TYPE,
            namedWriteableRegistry
            compressor,  
    }
    }
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();
        Custom clusterStateCustoms = getClusterStateCustom();
    private ClusterSettings clusterSettings;
    private String clusterName;  
    public void testGenerateBlobFileName() {
            clusterUUID,
    }
        assertThat(remoteObjectForUpload.getBlobFileName(), nullValue());
                    CURRENT,
            compressor,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(nameTokens[3], is(String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)));
    public void testBlobFileName() {  
import org.opensearch.test.OpenSearchTestCase;  
            "test-custom",  
            clusterStateCustoms,  
    public static SnapshotsInProgress getClusterStateCustom() {  
            namedWriteableRegistry,
            compressor,
                    INIT,
        namedWriteableRegistry = writableRegistry();
        );  
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
            STATE_VERSION,  
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
            UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
    }  
 */  
            clusterUUID,
        assertThat(RemoteStoreUtils.invertLong(nameTokens[1]), is(STATE_VERSION));  
        Custom clusterStateCustoms = getClusterStateCustom();
import org.junit.Before;
    @After
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
            namedWriteableRegistry
    private static final long STATE_VERSION = 3L;
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
        assertThat(remoteObjectForUpload.clusterUUID(), is(clusterUUID));  
            remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
    public void setup() {
        Custom clusterStateCustoms = getClusterStateCustom();  
    public void tearDown() throws Exception {  
    private Compressor compressor;
        this.blobStoreRepository = mock(BlobStoreRepository.class);
import static org.mockito.Mockito.mock;  
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
            "test-custom",  
    public void testClusterUUID() {
            compressor,
        }  
    }  
    public void testGetUploadedMetadata() throws IOException {  
import org.opensearch.index.remote.RemoteStoreUtils;
    }
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(  
import static java.util.Collections.emptyList;
            List.of(
import org.opensearch.cluster.SnapshotsInProgress;
import org.opensearch.snapshots.SnapshotId;
            clusterUUID,
import org.opensearch.common.remote.BlobPathParameters;
        Custom clusterStateCustoms = getClusterStateCustom();
            "test-custom",
import static org.hamcrest.Matchers.greaterThan;
        );  
    private NamedWriteableRegistry namedWriteableRegistry;  
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));  
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(  
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
                )
import org.opensearch.common.blobstore.BlobPath;  
            namedWriteableRegistry
            "test-custom",
        assertThat(params.getFilePrefix(), is(expectedPrefix));
            CURRENT
package org.opensearch.gateway.remote.model;
            namedWriteableRegistry
                new SnapshotsInProgress.Entry(  
 * compatible open source license.
            assertThat(readClusterStateCustoms, is(clusterStateCustoms));
        String uploadedFile = "user/local/opensearch/clusterStateCustoms";  
 * this file be licensed under the Apache-2.0 license or a
    private static final String TEST_BLOB_PATH = "test-path";
        super.tearDown();
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
        Custom clusterStateCustoms = getClusterStateCustom();
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));
            "test-custom",
}
            clusterUUID,  
            namedWriteableRegistry,  
                    0L,
public class RemoteClusterStateCustomsTests extends OpenSearchTestCase {  
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "clusterStateCustoms" }));  
            clusterStateCustoms,
            Custom readClusterStateCustoms = remoteObjectForUpload.deserialize(inputStream);
 * The OpenSearch Contributors require contributions made to  
                    false  
            "test-custom",
 *
        compressor = new NoneCompressor();  
                    emptyMap(),
import org.opensearch.gateway.remote.RemoteClusterStateUtils;  
    public void testBlobPathParameters() {  
                    new Snapshot("repo", new SnapshotId("test-snapshot", "test-snapshot-uuid")),
import static org.opensearch.cluster.SnapshotsInProgress.State.INIT;
            assertThat(inputStream.available(), greaterThan(0));  
            STATE_VERSION,  
            uploadedFile,
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(  
        );  
            clusterUUID,
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.settings.ClusterSettings;  
                    false,  
        String expectedPrefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, "test-custom");  
    private BlobStoreRepository blobStoreRepository;
import static org.opensearch.Version.CURRENT;  
import java.io.InputStream;
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {  
            STATE_VERSION,
            clusterUUID,  
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
        assertThat(RemoteStoreUtils.invertLong(nameTokens[2]), lessThanOrEqualTo(System.currentTimeMillis()));
        assertThat(params.getPathTokens(), is(List.of(RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN)));
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
        this.clusterName = "test-cluster-name";
import java.io.IOException;  
import org.opensearch.snapshots.Snapshot;
 * SPDX-License-Identifier: Apache-2.0
            assertThat(uploadedMetadata.getUploadedFilename(), is(remoteObjectForUpload.getFullBlobName()));
import org.opensearch.cluster.ClusterState.Custom;
            clusterUUID,
    private String clusterUUID;  
            CURRENT
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
    public void testSerDe() throws IOException {  
        );  
    }
            clusterUUID,  
            clusterStateCustoms,  
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());
            )
        String expectedPrefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, "test-custom");
            clusterUUID,  
            TEST_BLOB_NAME,  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
            compressor,
            clusterStateCustoms,  
import static org.mockito.Mockito.when;
            String expectedPrefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, "test-custom");  
    private BlobStoreTransferService blobStoreTransferService;
import static org.hamcrest.Matchers.is;  
