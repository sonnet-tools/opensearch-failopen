    @Before
            .build();
        }
    public void testSerDe() throws IOException {
        }
        public Version getMinimalSupportedVersion() {
    @After
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
            TEST_BLOB_NAME,
            namedWriteableRegistry
import org.opensearch.cluster.metadata.IndexGraveyard;
import org.opensearch.core.compress.NoneCompressor;
        }
            namedWriteableRegistry,
import org.opensearch.core.common.io.stream.StreamOutput;
        assertThat(params.getFilePrefix(), is(expectedPrefix));
    private void verifySerDe(Custom objectToUpload, String objectType) throws IOException {
    private BlobStoreTransferService blobStoreTransferService;
            Version.CURRENT
import org.opensearch.persistent.PersistentTaskParams;
            assertThat(inputStream.available(), greaterThan(0));
        assertThat(remoteObjectForUpload.getBlobFileName(), nullValue());
        Custom customMetadata = getCustomMetadata();
import java.io.IOException;
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(
        }
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
            customMetadata,
    }
            METADATA_VERSION,
            clusterUUID,
        }
    private static final String CUSTOM_TYPE = "test-custom";
            compressor,
    private String clusterUUID;
        );
            "test-custom",
    private static Custom getPersistentTasksMetadata() {
            customWritableRegistry()
        }
        Custom customMetadata = getPersistentTasksMetadata();
        super.tearDown();
    private Compressor compressor;
            clusterUUID,
        );
        Custom customMetadata = getCustomMetadata();
import org.junit.After;
    private String clusterName;
    public static Custom getCustomMetadata() {
        assertThat(remoteObjectForUpload.getFullBlobName(), nullValue());
            "test-custom",
import org.opensearch.threadpool.ThreadPool;
    public void setup() {
            customMetadata,
            Version.CURRENT
import org.opensearch.persistent.PersistentTasksCustomMetadata;
    public void testBlobPathTokens() {
import org.opensearch.core.index.Index;
import org.opensearch.common.settings.Settings;
            return Version.V_2_13_0;
        public TestPersistentTaskParams(String data) {
        public void writeTo(StreamOutput out) throws IOException {
        );
        assertThat(nameTokens[0], is(expectedPrefix));
import static org.hamcrest.Matchers.is;
        private static final String PARAM_NAME = "testTaskName";
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(
    public void testSerDeForPersistentTasks() throws IOException {
import org.opensearch.threadpool.TestThreadPool;
            namedWriteableRegistry
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
        return IndexGraveyard.builder().addTombstone(new Index("test-index", "3q2423")).build();
        @Override
        );
 */
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(
    }
        @Override
            TEST_BLOB_NAME,
        }
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
import org.opensearch.common.blobstore.BlobPath;
            "test-custom",
            clusterUUID,
            METADATA_VERSION,
        assertThat(nameTokens[3], is(String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)));
    }
    public void tearDown() throws Exception {
            Version.CURRENT
    }
            compressor,
        return PersistentTasksCustomMetadata.builder()
            Custom readCustomMetadata = remoteObjectForUpload.deserialize(inputStream);
            namedWriteableRegistry
            namedWriteableRegistry,
import static org.hamcrest.Matchers.greaterThan;
 * SPDX-License-Identifier: Apache-2.0
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
            clusterUUID,
            customMetadata,
/*
            compressor,
    public void testGenerateBlobFileName() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            customMetadata,
import org.opensearch.core.common.io.stream.StreamInput;
            clusterUUID,
    }
    public void testClusterUUID() {
        BlobPath blobPath = new BlobPath().add("/path");
        @Override
        @Override
import org.opensearch.index.remote.RemoteStoreUtils;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        Custom customMetadata = getCustomMetadata();
    private NamedWriteableRegistry customWritableRegistry() {
            clusterUUID,
    }
        }
    public void testBlobPathParameters() {
        @Override
    }
    }
            return Objects.equals(data, that.data);
        String uploadedFile = "user/local/opensearch/customMetadata";
        public TestPersistentTaskParams(StreamInput in) throws IOException {
        Custom customMetadata = getCustomMetadata();
            return PARAM_NAME;
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());
import org.opensearch.common.compress.DeflateCompressor;
    }
    }
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
        verifySerDe(customMetadata, PersistentTasksCustomMetadata.TYPE);
            compressor,
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "customMetadata" }));
            customMetadata,
            uploadedFile,
        assertThat(RemoteStoreUtils.invertLong(nameTokens[2]), lessThanOrEqualTo(System.currentTimeMillis()));
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_DELIMITER;
            namedWriteableRegistry,
public class RemoteCustomMetadataTests extends OpenSearchTestCase {
    private static final long METADATA_VERSION = 3L;
            namedWriteableRegistry
            TEST_BLOB_NAME,
    }
    }
            clusterUUID,
    private static final String TEST_BLOB_PATH = "test-path";
            namedWriteableRegistry,
        Custom customMetadata = getCustomMetadata();
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
            if (this == o) return true;
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
            "test-custom",
            compressor,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
    public static class TestPersistentTaskParams implements PersistentTaskParams {
        );
        public boolean equals(Object o) {
            "test-custom",
        assertThat(remoteObjectForUpload.clusterUUID(), is(clusterUUID));
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);
        );
import org.opensearch.cluster.ClusterModule;
            clusterUUID,
            namedWriteableRegistry
 * compatible open source license.
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
        );
            if (o == null || getClass() != o.getClass()) return false;
        return new NamedWriteableRegistry(entries);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            METADATA_VERSION,
            TestPersistentTaskParams that = (TestPersistentTaskParams) o;
            assertThat(uploadedMetadata.getComponent(), is(expectedPrefix));
            "test-custom",
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
        );
        }
            "test-custom",
            compressor,
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));
import static org.hamcrest.Matchers.nullValue;
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();
            objectType,
package org.opensearch.gateway.remote.model;
            objectToUpload,
        }
        String expectedPrefix = CUSTOM_METADATA + CUSTOM_DELIMITER + CUSTOM_TYPE;
 *
            assertThat(readCustomMetadata, is(objectToUpload));
            UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
            return Objects.hash(data);
import org.opensearch.cluster.metadata.Metadata.Custom;
        public String getWriteableName() {
            this.data = data;
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
        this.blobStoreRepository = mock(BlobStoreRepository.class);
    private ClusterSettings clusterSettings;
        this.clusterName = "test-cluster-name";
            namedWriteableRegistry
import org.opensearch.common.remote.BlobPathParameters;
            assertThat(uploadedMetadata.getUploadedFilename(), is(remoteObjectForUpload.getFullBlobName()));
            METADATA_VERSION,
            compressor,
            METADATA_VERSION,
        entries.add(new Entry(PersistentTaskParams.class, TestPersistentTaskParams.PARAM_NAME, TestPersistentTaskParams::new));
        threadPool.shutdown();
            .addTask("_task_1", "testTaskName", new TestPersistentTaskParams("task param data"), new Assignment(null, "_reason"))
        private final String data;
    private BlobStoreRepository blobStoreRepository;
            this(in.readString());
        compressor = new NoneCompressor();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
            "test-custom",
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
        Custom customMetadata = getCustomMetadata();
import static org.mockito.Mockito.mock;
import org.opensearch.common.settings.ClusterSettings;
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to
            compressor,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            return builder.startObject().field("data_field", data);
            METADATA_VERSION,
import org.opensearch.test.OpenSearchTestCase;
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
            customMetadata,
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        this.clusterUUID = "test-cluster-uuid";
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
    }
            clusterUUID,
            compressor,
    public void testGetUploadedMetadata() throws IOException {
import java.util.Objects;
        );
        String expectedPrefix = CUSTOM_METADATA + CUSTOM_DELIMITER + CUSTOM_TYPE;
import org.opensearch.core.compress.Compressor;
 * this file be licensed under the Apache-2.0 license or a
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
            compressor,
            "test-custom",
            clusterUUID,
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        public int hashCode() {
}
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
            remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
        @Override
import org.opensearch.core.xcontent.XContentBuilder;
            clusterUUID,
import org.opensearch.Version;
        assertThat(params.getPathTokens(), is(List.of(RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN)));
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(
    private NamedWriteableRegistry namedWriteableRegistry;
        );
    }
    public void testBlobFileName() {
        List<Entry> entries = ClusterModule.getNamedWriteables();
import org.junit.Before;
        Custom customMetadata = getCustomMetadata();
        namedWriteableRegistry = writableRegistry();
import java.util.List;
            METADATA_VERSION,
            Version.CURRENT
            out.writeString(data);
            String expectedPrefix = CUSTOM_METADATA + CUSTOM_DELIMITER + CUSTOM_TYPE;
import java.io.InputStream;
        verifySerDe(customMetadata, IndexGraveyard.TYPE);
    public void testFullBlobName() {
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;
        );
    }
            compressor,
    }
            "test-custom",
        assertThat(RemoteStoreUtils.invertLong(nameTokens[1]), is(METADATA_VERSION));
