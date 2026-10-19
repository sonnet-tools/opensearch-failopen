        return new NamedWriteableRegistry(entries);
    }  
import org.opensearch.persistent.PersistentTaskParams;
        assertThat(nameTokens[3], is(String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)));
            compressor,  
            clusterUUID,  
    public static class TestPersistentTaskParams implements PersistentTaskParams {  
import org.opensearch.cluster.metadata.Metadata.Custom;
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_DELIMITER;
    }  
    }
import org.opensearch.threadpool.ThreadPool;
            METADATA_VERSION,
            assertThat(uploadedMetadata.getComponent(), is(expectedPrefix));  
            compressor,
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
        assertThat(params.getFilePrefix(), is(expectedPrefix));  
import org.opensearch.Version;
    private NamedWriteableRegistry customWritableRegistry() {
    public void testGetUploadedMetadata() throws IOException {
import java.io.IOException;
            clusterUUID,
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());
            namedWriteableRegistry
            namedWriteableRegistry,
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);  
            namedWriteableRegistry
    }
        );
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            customWritableRegistry()
            clusterUUID,  
        @Override  
        Custom customMetadata = getCustomMetadata();
        compressor = new NoneCompressor();
    }  
    private static final String CUSTOM_TYPE = "test-custom";  
            return builder.startObject().field("data_field", data);
import java.io.InputStream;  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;  
import org.junit.After;
        entries.add(new Entry(PersistentTaskParams.class, TestPersistentTaskParams.PARAM_NAME, TestPersistentTaskParams::new));
            "test-custom",
        this.clusterName = "test-cluster-name";
            UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
 * The OpenSearch Contributors require contributions made to  
            this.data = data;
        assertThat(remoteObjectForUpload.getBlobFileName(), nullValue());  
public class RemoteCustomMetadataTests extends OpenSearchTestCase {
        Custom customMetadata = getCustomMetadata();  
            .build();  
        @Override
        public void writeTo(StreamOutput out) throws IOException {
        );
            compressor,  
            clusterUUID,
            namedWriteableRegistry
        Custom customMetadata = getCustomMetadata();
            clusterUUID,
        );
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            compressor,
        public boolean equals(Object o) {
    private ClusterSettings clusterSettings;  
            "test-custom",
        super.tearDown();  
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
            METADATA_VERSION,
            clusterUUID,  
            compressor,
    public void testClusterUUID() {
            "test-custom",  
    public void testSerDeForPersistentTasks() throws IOException {
import org.opensearch.common.remote.BlobPathParameters;
    }
import java.util.Objects;
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
            Version.CURRENT  
    private NamedWriteableRegistry namedWriteableRegistry;
    }
        List<Entry> entries = ClusterModule.getNamedWriteables();  
import org.opensearch.common.settings.ClusterSettings;
 * compatible open source license.
            "test-custom",  
            remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));  
            .addTask("_task_1", "testTaskName", new TestPersistentTaskParams("task param data"), new Assignment(null, "_reason"))
import org.opensearch.persistent.PersistentTasksCustomMetadata.Assignment;  
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
import org.opensearch.index.translog.transfer.BlobStoreTransferService;  
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
package org.opensearch.gateway.remote.model;
    private static Custom getPersistentTasksMetadata() {  
    public void testBlobPathTokens() {
        public TestPersistentTaskParams(StreamInput in) throws IOException {
            this(in.readString());
    private String clusterName;
            out.writeString(data);
import org.opensearch.core.xcontent.XContentBuilder;
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
import org.opensearch.common.settings.Settings;  
        );  
import static org.mockito.Mockito.when;  
        Custom customMetadata = getCustomMetadata();
import org.opensearch.common.compress.DeflateCompressor;  
            String expectedPrefix = CUSTOM_METADATA + CUSTOM_DELIMITER + CUSTOM_TYPE;
        assertThat(params.getPathTokens(), is(List.of(RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN)));
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {  
            Version.CURRENT
        );
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
import static org.hamcrest.Matchers.greaterThan;
            namedWriteableRegistry,
        verifySerDe(customMetadata, PersistentTasksCustomMetadata.TYPE);  
        String expectedPrefix = CUSTOM_METADATA + CUSTOM_DELIMITER + CUSTOM_TYPE;  
        namedWriteableRegistry = writableRegistry();  
import org.opensearch.common.blobstore.BlobPath;
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(
import org.opensearch.core.common.io.stream.StreamInput;  
            return Objects.equals(data, that.data);  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;
        Custom customMetadata = getPersistentTasksMetadata();
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
    public static Custom getCustomMetadata() {
        }
    @Before
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(  
        String uploadedFile = "user/local/opensearch/customMetadata";
        return PersistentTasksCustomMetadata.builder()
            "test-custom",
            objectType,  
            Version.CURRENT
    private void verifySerDe(Custom objectToUpload, String objectType) throws IOException {  
        );
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
            METADATA_VERSION,
    }
    private static final String TEST_BLOB_PATH = "test-path";
import static org.hamcrest.Matchers.nullValue;
        );  
}  
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "customMetadata" }));
            return Version.V_2_13_0;  
            customMetadata,
            TestPersistentTaskParams that = (TestPersistentTaskParams) o;
    }  
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);  
            METADATA_VERSION,  
    public void tearDown() throws Exception {
        String expectedPrefix = CUSTOM_METADATA + CUSTOM_DELIMITER + CUSTOM_TYPE;
            compressor,  
        public Version getMinimalSupportedVersion() {
            "test-custom",
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            return Objects.hash(data);
            namedWriteableRegistry  
            namedWriteableRegistry,  
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(
        @Override
            clusterUUID,
    }
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());  
            customMetadata,
        @Override
            customMetadata,  
        public int hashCode() {
            uploadedFile,
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(  
            assertThat(readCustomMetadata, is(objectToUpload));
            namedWriteableRegistry
            if (o == null || getClass() != o.getClass()) return false;
            TEST_BLOB_NAME,  
        }
import static org.hamcrest.Matchers.is;
        private final String data;
        assertThat(remoteObjectForUpload.getFullBlobName(), nullValue());
 *
import org.opensearch.core.compress.NoneCompressor;  
            if (this == o) return true;  
            compressor,
        }  
            compressor,
    private BlobStoreRepository blobStoreRepository;
            Custom readCustomMetadata = remoteObjectForUpload.deserialize(inputStream);  
        return IndexGraveyard.builder().addTombstone(new Index("test-index", "3q2423")).build();  
            Version.CURRENT  
        assertThat(RemoteStoreUtils.invertLong(nameTokens[1]), is(METADATA_VERSION));
        @Override
        );  
        );
import org.opensearch.core.compress.Compressor;
            assertThat(uploadedMetadata.getUploadedFilename(), is(remoteObjectForUpload.getFullBlobName()));
import org.opensearch.core.common.io.stream.StreamOutput;
            compressor,
    public void testFullBlobName() {  
import org.opensearch.threadpool.TestThreadPool;  
import org.junit.Before;  
        Custom customMetadata = getCustomMetadata();  
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
        @Override  
    public void testSerDe() throws IOException {
        }
            clusterUUID,
    public void testGenerateBlobFileName() {  
        }
    }
    private BlobStoreTransferService blobStoreTransferService;  
import static org.mockito.Mockito.mock;
        threadPool.shutdown();
            METADATA_VERSION,
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
    public void setup() {  
        public TestPersistentTaskParams(String data) {  
    private String clusterUUID;
    private static final long METADATA_VERSION = 3L;
        assertThat(nameTokens[0], is(expectedPrefix));
            "test-custom",  
        }
    public void testBlobFileName() {
        verifySerDe(customMetadata, IndexGraveyard.TYPE);
 * this file be licensed under the Apache-2.0 license or a
        RemoteCustomMetadata remoteObjectForDownload = new RemoteCustomMetadata(  
        BlobPath blobPath = new BlobPath().add("/path");
            return PARAM_NAME;
            METADATA_VERSION,
    @After
            clusterUUID,
            compressor,  
    public void testBlobPathParameters() {
            assertThat(inputStream.available(), greaterThan(0));
 */  
        }  
            customMetadata,
    }  
        }
            customMetadata,  
        Custom customMetadata = getCustomMetadata();  
import org.opensearch.cluster.metadata.IndexGraveyard;  
            "test-custom",
            METADATA_VERSION,
    }
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
            TEST_BLOB_NAME,
            clusterUUID,  
    private Compressor compressor;
        Custom customMetadata = getCustomMetadata();  
    }
            TEST_BLOB_NAME,
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));  
        when(blobStoreRepository.basePath()).thenReturn(blobPath);  
import java.util.List;
            objectToUpload,
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);
        );
        assertThat(RemoteStoreUtils.invertLong(nameTokens[2]), lessThanOrEqualTo(System.currentTimeMillis()));  
            clusterUUID,
import org.opensearch.cluster.ClusterModule;
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();  
import org.opensearch.test.OpenSearchTestCase;
            customMetadata,
        this.blobStoreRepository = mock(BlobStoreRepository.class);
        }
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";  
            namedWriteableRegistry,
        public String getWriteableName() {  
            "test-custom",  
        this.clusterUUID = "test-cluster-uuid";
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * SPDX-License-Identifier: Apache-2.0
        }  
        assertThat(remoteObjectForUpload.clusterUUID(), is(clusterUUID));
            namedWriteableRegistry
        );
import org.opensearch.index.remote.RemoteStoreUtils;
    }  
import org.opensearch.persistent.PersistentTasksCustomMetadata;
        private static final String PARAM_NAME = "testTaskName";
            compressor,  
            "test-custom",
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;  
import org.opensearch.core.index.Index;
/*  
        RemoteCustomMetadata remoteObjectForUpload = new RemoteCustomMetadata(
