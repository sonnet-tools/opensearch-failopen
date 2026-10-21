import org.opensearch.core.compress.Compressor;
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
    private String clusterUUID;
            namedWriteableRegistry,
            CURRENT
import org.junit.After;
        Custom clusterStateCustoms = getClusterStateCustom();
            clusterUUID,
            clusterStateCustoms,
        Custom clusterStateCustoms = getClusterStateCustom();
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
            namedWriteableRegistry,
                    new Snapshot("repo", new SnapshotId("test-snapshot", "test-snapshot-uuid")),
        assertThat(RemoteStoreUtils.invertLong(nameTokens[1]), is(STATE_VERSION));
import java.io.IOException;
            STATE_VERSION,
        namedWriteableRegistry = writableRegistry();
            TEST_BLOB_NAME,
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
    public void testFullBlobName() {
            namedWriteableRegistry
    public void testSerDe() throws IOException {
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();
    @After
    public void testBlobPathParameters() {
    }
        Custom clusterStateCustoms = getClusterStateCustom();
            assertThat(readClusterStateCustoms, is(clusterStateCustoms));
import java.io.InputStream;
        assertThat(nameTokens[0], is(expectedPrefix));
        assertThat(params.getPathTokens(), is(List.of(RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN)));
                    false,
            "test-custom",
            "test-custom",
            compressor,
            clusterStateCustoms,
    public void testGetUploadedMetadata() throws IOException {
    private BlobStoreTransferService blobStoreTransferService;
                    emptyMap(),
            clusterStateCustoms,
    public void setup() {
            remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
                    INIT,
        }
            assertThat(uploadedMetadata.getUploadedFilename(), is(remoteObjectForUpload.getFullBlobName()));
    public void testBlobPathTokens() {
import org.opensearch.core.compress.NoneCompressor;
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
import org.junit.Before;
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
        String uploadedFile = "user/local/opensearch/clusterStateCustoms";
        );
                    0L,
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
            compressor,
import org.opensearch.common.blobstore.BlobPath;
    }
import static org.hamcrest.Matchers.is;
    }
import static org.hamcrest.Matchers.nullValue;
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
        assertThat(params.getFilePrefix(), is(expectedPrefix));
            STATE_VERSION,
import org.opensearch.common.remote.BlobPathParameters;
            STATE_VERSION,
 * this file be licensed under the Apache-2.0 license or a
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
import static java.util.Collections.emptyMap;
import static org.opensearch.gateway.remote.model.RemoteClusterStateCustoms.CLUSTER_STATE_CUSTOM;
    public void testGenerateBlobFileName() {
            TEST_BLOB_NAME,
import org.opensearch.snapshots.SnapshotId;
        super.tearDown();
    public void testClusterUUID() {
                    emptyList(),
            clusterStateCustoms,
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
            String expectedPrefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, "test-custom");
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
            compressor,
    }
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
    private static final long STATE_VERSION = 3L;
            compressor,
            clusterUUID,
 */
        );
        assertThat(RemoteStoreUtils.invertLong(nameTokens[2]), lessThanOrEqualTo(System.currentTimeMillis()));
    }
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
            TEST_BLOB_NAME,
            compressor,
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            namedWriteableRegistry
            "test-custom",
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
}
    public void testBlobFileName() {
            namedWriteableRegistry,
        assertThat(remoteObjectForUpload.getFullBlobName(), nullValue());
            clusterUUID,
            STATE_VERSION,
        }
        );
import org.opensearch.test.OpenSearchTestCase;
            clusterUUID,
                    emptyMap(),
            UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
            compressor,
import org.opensearch.common.settings.Settings;
    private BlobStoreRepository blobStoreRepository;
    private String clusterName;
            clusterUUID,
/*
        Custom clusterStateCustoms = getClusterStateCustom();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
import static org.hamcrest.Matchers.greaterThan;
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
            clusterStateCustoms,
                )
import java.util.List;
        );
    }
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
                    false
            clusterUUID,
            assertThat(inputStream.available(), greaterThan(0));
package org.opensearch.gateway.remote.model;
            SnapshotsInProgress.TYPE,
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "clusterStateCustoms" }));
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
            namedWriteableRegistry
        Custom clusterStateCustoms = getClusterStateCustom();
        RemoteClusterStateCustoms remoteObjectForDownload = new RemoteClusterStateCustoms(
    private Compressor compressor;
import static java.util.Collections.emptyList;
        );
 * The OpenSearch Contributors require contributions made to
            assertThat(uploadedMetadata.getComponent(), is(expectedPrefix));
    private ClusterSettings clusterSettings;
            compressor,
            namedWriteableRegistry
            compressor,
    public static SnapshotsInProgress getClusterStateCustom() {
import static org.mockito.Mockito.mock;
        assertThat(remoteObjectForUpload.getBlobFileName(), nullValue());
            CURRENT
        String expectedPrefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, "test-custom");
            "test-custom",
            clusterUUID,
            STATE_VERSION,
        this.clusterUUID = "test-cluster-uuid";
        String expectedPrefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, "test-custom");
            namedWriteableRegistry
            clusterUUID,
            compressor,
    public void tearDown() throws Exception {
            Custom readClusterStateCustoms = remoteObjectForUpload.deserialize(inputStream);
                    emptyList(),
            "test-custom",
            )
            "test-custom",
                new SnapshotsInProgress.Entry(
        BlobPath blobPath = new BlobPath().add("/path");
import org.opensearch.cluster.ClusterState.Custom;
            clusterUUID,
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);
public class RemoteClusterStateCustomsTests extends OpenSearchTestCase {
            clusterUUID,
            uploadedFile,
        );
    }
        Custom clusterStateCustoms = getClusterStateCustom();
                    CURRENT,
    }
        this.blobStoreRepository = mock(BlobStoreRepository.class);
                    0L,
            namedWriteableRegistry,
        compressor = new NoneCompressor();
        assertThat(remoteObjectForUpload.clusterUUID(), is(clusterUUID));
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        );
            List.of(
import static org.opensearch.Version.CURRENT;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.common.compress.DeflateCompressor;
import org.opensearch.threadpool.ThreadPool;
            clusterStateCustoms,
    }
                    false,
            CURRENT
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
    private static final String CUSTOM_TYPE = "test-custom";
        );
            clusterUUID,
    private static final String TEST_BLOB_PATH = "test-path";
import org.opensearch.snapshots.Snapshot;
    private NamedWriteableRegistry namedWriteableRegistry;
            "test-custom",
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));
            "test-custom",
        this.clusterName = "test-cluster-name";
            STATE_VERSION,
        RemoteClusterStateCustoms remoteObjectForUpload = new RemoteClusterStateCustoms(
    @Before
import org.opensearch.index.remote.RemoteStoreUtils;
import org.opensearch.threadpool.TestThreadPool;
        threadPool.shutdown();
 *
        );
 * compatible open source license.
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
import static org.mockito.Mockito.when;
        return SnapshotsInProgress.of(
        assertThat(nameTokens[3], is(String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)));
        );
            compressor,
    }
            compressor,
        );
            "test-custom",
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());
import org.opensearch.cluster.SnapshotsInProgress;
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
import static org.opensearch.cluster.SnapshotsInProgress.State.INIT;
            clusterStateCustoms,
import org.opensearch.common.settings.ClusterSettings;
            namedWriteableRegistry
            CURRENT
        Custom clusterStateCustoms = getClusterStateCustom();
    }
            "test-custom",
            STATE_VERSION,
            namedWriteableRegistry
