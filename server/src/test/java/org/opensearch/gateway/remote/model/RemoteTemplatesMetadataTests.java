import org.opensearch.core.compress.NoneCompressor;
                    )  
            settings,
            remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
    public void testFullBlobName() {
import static org.hamcrest.Matchers.nullValue;
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";  
            settings,
            compressor,
import static org.hamcrest.Matchers.is;
    }
        super.tearDown();
    public void testBlobPathParameters() {
                    .order(5678)
    public void tearDown() throws Exception {
            compressor,
            compressor,
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);
    public void testBlobFileName() {
            clusterUUID,  
 * The OpenSearch Contributors require contributions made to  
            namedXContentRegistry
import org.opensearch.common.compress.DeflateCompressor;
import org.opensearch.test.OpenSearchTestCase;
public class RemoteTemplatesMetadataTests extends OpenSearchTestCase {
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
        TemplatesMetadata settings = getTemplatesMetadata();
    }  
import java.util.Arrays;  
 */  
    }
            compressor,
        assertThat(params.getFilePrefix(), is(RemoteTemplatesMetadata.TEMPLATES_METADATA));
    }
 * compatible open source license.
        assertThat(remoteObjectForUpload.clusterUUID(), is(clusterUUID));  
import org.opensearch.index.remote.RemoteStoreUtils;  
    @Before
                    .order(1234)
            assertThat(uploadedMetadata.getUploadedFilename(), is(remoteObjectForUpload.getFullBlobName()));
            .build();  
    }
    }
            TEST_BLOB_NAME,
 *
import org.opensearch.common.blobstore.BlobPath;
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
        );
    private NamedXContentRegistry namedXContentRegistry;
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();
    public void testClusterUUID() {  
        assertThat(RemoteStoreUtils.invertLong(nameTokens[1]), is(METADATA_VERSION));
import static org.mockito.Mockito.when;  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
import org.opensearch.indices.IndicesModule;
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
        );
        TemplatesMetadata settings = getTemplatesMetadata();  
            namedXContentRegistry  
            TEST_BLOB_NAME,
        assertThat(params.getPathTokens(), is(List.of(RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN)));  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;  
import org.opensearch.common.settings.ClusterSettings;
                    .settings(
            assertThat(readsettings, is(settings));  
            assertThat(uploadedMetadata.getComponent(), is(RemoteTemplatesMetadata.TEMPLATES_METADATA));  
        this.clusterUUID = "test-cluster-uuid";
            TEST_BLOB_NAME,  
import org.opensearch.common.settings.Settings;  
import org.opensearch.threadpool.ThreadPool;  
        BlobPath blobPath = new BlobPath().add("/path");
        );
                    )  
            )
                    .patterns(Arrays.asList("test-*"))  
            clusterUUID,
        TemplatesMetadata settings = getTemplatesMetadata();
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
        assertThat(nameTokens[0], is(RemoteTemplatesMetadata.TEMPLATES_METADATA));  
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
            )
            clusterUUID,
            namedXContentRegistry
import static java.util.stream.Collectors.toList;
            settings,
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());  
        threadPool.shutdown();  
import java.io.InputStream;
        assertThat(remoteObjectForUpload.getBlobFileName(), nullValue());
    private Compressor compressor;  
            compressor,
        );
            METADATA_VERSION,
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        );
                IndicesModule.getNamedXContents().stream(),
        namedXContentRegistry = new NamedXContentRegistry(
            namedXContentRegistry  
        assertThat(RemoteStoreUtils.invertLong(nameTokens[2]), lessThanOrEqualTo(System.currentTimeMillis()));
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(  
import org.opensearch.cluster.ClusterModule;
    @After  
            Stream.of(  
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
        );  
                    .settings(
            METADATA_VERSION,  
            clusterUUID,
    public static TemplatesMetadata getTemplatesMetadata() {
        );  
        assertThat(remoteObjectForUpload.getFullBlobName(), nullValue());
import org.opensearch.threadpool.TestThreadPool;
        );  
            compressor,  
                    .patterns(Arrays.asList("bar-*", "foo-*"))  
        TemplatesMetadata settings = getTemplatesMetadata();
    }
            compressor,
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "settings" }));
    private String clusterUUID;
        String uploadedFile = "user/local/opensearch/settings";
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
/*  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        assertThat(nameTokens[3], is(String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)));  
import org.opensearch.core.compress.Compressor;
import org.junit.Before;
            settings,  
import org.opensearch.common.remote.BlobPathParameters;
            namedXContentRegistry
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
            ).flatMap(Function.identity()).collect(toList())
            compressor,
        this.clusterName = "test-cluster-name";  
            namedXContentRegistry
 * this file be licensed under the Apache-2.0 license or a
            clusterUUID,
    public void testGenerateBlobFileName() {
            clusterUUID,
                        Settings.builder().put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(  
    public void testSerDe() throws IOException {
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
                ClusterModule.getNamedXWriteables().stream()  
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
            TemplatesMetadata readsettings = remoteObjectForUpload.deserialize(inputStream);
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());  
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
                        Settings.builder().put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
            namedXContentRegistry  
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
            clusterUUID,
import static org.hamcrest.Matchers.greaterThan;
            compressor,
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    }  
    public void testGetUploadedMetadata() throws IOException {
import java.util.List;
package org.opensearch.gateway.remote.model;
            settings,
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {  
            compressor,
        }
import static org.mockito.Mockito.mock;
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
            namedXContentRegistry  
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
            .put(  
        }
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
    }
                NetworkModule.getNamedXContents().stream(),
            METADATA_VERSION,
            METADATA_VERSION,
                    .build()
        TemplatesMetadata settings = getTemplatesMetadata();
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.junit.After;
            clusterUUID,
            settings,
        return TemplatesMetadata.builder()
        this.blobStoreRepository = mock(BlobStoreRepository.class);  
        );
}
    private BlobStoreTransferService blobStoreTransferService;
    public void testBlobPathTokens() {  
            settings,
            METADATA_VERSION,
    private static final long METADATA_VERSION = 3L;  
        );
    private BlobStoreRepository blobStoreRepository;  
            .put(  
            METADATA_VERSION,  
        compressor = new NoneCompressor();
            compressor,  
    }
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));
    private String clusterName;
                    .build()
            clusterUUID,  
        );  
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(  
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
            namedXContentRegistry
        TemplatesMetadata settings = getTemplatesMetadata();  
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(  
            uploadedFile,  
            clusterUUID,  
import org.opensearch.cluster.metadata.TemplatesMetadata;  
            UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.network.NetworkModule;  
    }  
            assertThat(inputStream.available(), greaterThan(0));
import java.util.function.Function;
        TemplatesMetadata settings = getTemplatesMetadata();  
                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
            namedXContentRegistry
            METADATA_VERSION,  
import java.io.IOException;
                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
    private static final String TEST_BLOB_PATH = "test-path";
        );
            clusterUUID,  
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));  
import java.util.stream.Stream;  
    private ClusterSettings clusterSettings;
            namedXContentRegistry  
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
    public void setup() {
