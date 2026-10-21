                    .patterns(Arrays.asList("bar-*", "foo-*"))
            )
import static org.mockito.Mockito.when;
    public void testGetUploadedMetadata() throws IOException {
            namedXContentRegistry
            namedXContentRegistry
                    .build()
            clusterUUID,
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
    private String clusterName;
import static java.util.stream.Collectors.toList;
    private static final String TEST_BLOB_PATH = "test-path";
import java.io.IOException;
                    )
import org.opensearch.common.compress.DeflateCompressor;
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
    public static TemplatesMetadata getTemplatesMetadata() {
    }
            TEST_BLOB_NAME,
        TemplatesMetadata settings = getTemplatesMetadata();
            clusterUUID,
            METADATA_VERSION,
            METADATA_VERSION,
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "settings" }));
            Stream.of(
            settings,
    private ClusterSettings clusterSettings;
                NetworkModule.getNamedXContents().stream(),
        );
    public void testBlobFileName() {
import static org.hamcrest.Matchers.greaterThan;
        BlobPath blobPath = new BlobPath().add("/path");
            namedXContentRegistry
            TEST_BLOB_NAME,
            assertThat(readsettings, is(settings));
            compressor,
            namedXContentRegistry
import org.opensearch.indices.IndicesModule;
 *
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
                    .order(1234)
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            settings,
            clusterUUID,
    private String clusterUUID;
            clusterUUID,
            settings,
        return TemplatesMetadata.builder()
import org.opensearch.threadpool.TestThreadPool;
        TemplatesMetadata settings = getTemplatesMetadata();
            clusterUUID,
                    )
    public void tearDown() throws Exception {
import static org.hamcrest.Matchers.is;
            namedXContentRegistry
 * SPDX-License-Identifier: Apache-2.0
            METADATA_VERSION,
    private NamedXContentRegistry namedXContentRegistry;
            .put(
        assertThat(remoteObjectForUpload.clusterUUID(), is(clusterUUID));
    public void testSerDe() throws IOException {
        assertThat(nameTokens[0], is(RemoteTemplatesMetadata.TEMPLATES_METADATA));
            assertThat(uploadedMetadata.getComponent(), is(RemoteTemplatesMetadata.TEMPLATES_METADATA));
    @Before
            assertThat(inputStream.available(), greaterThan(0));
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
        this.clusterName = "test-cluster-name";
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.nullValue;
        );
            settings,
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
}
        );
import org.opensearch.index.remote.RemoteStoreUtils;
import org.opensearch.threadpool.ThreadPool;
            TemplatesMetadata readsettings = remoteObjectForUpload.deserialize(inputStream);
        );
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
    public void testClusterUUID() {
            compressor,
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        );
            compressor,
        TemplatesMetadata settings = getTemplatesMetadata();
            namedXContentRegistry
            compressor,
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
        );
    }
import org.opensearch.core.compress.Compressor;
import org.junit.After;
    public void testFullBlobName() {
            compressor,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    public void testBlobPathParameters() {
                        Settings.builder().put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
        );
        );
 */
        try (InputStream inputStream = remoteObjectForUpload.serialize()) {
            settings,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));
            compressor,
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
import java.io.InputStream;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    }
        TemplatesMetadata settings = getTemplatesMetadata();
        assertThrows(AssertionError.class, remoteObjectForUpload::getUploadedMetadata);
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
public class RemoteTemplatesMetadataTests extends OpenSearchTestCase {
            ).flatMap(Function.identity()).collect(toList())
import org.opensearch.cluster.metadata.TemplatesMetadata;
    }
            .build();
        super.tearDown();
                    .build()
        String[] nameTokens = blobFileName.split(RemoteClusterStateUtils.DELIMITER);
            clusterUUID,
 * this file be licensed under the Apache-2.0 license or a
        assertThat(remoteObjectForUpload.getFullBlobName(), nullValue());
        assertThat(RemoteStoreUtils.invertLong(nameTokens[2]), lessThanOrEqualTo(System.currentTimeMillis()));
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
import org.opensearch.common.remote.BlobPathParameters;
    public void testBlobPathTokens() {
                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
        this.blobStoreRepository = mock(BlobStoreRepository.class);
        }
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
            clusterUUID,
                IndicesModule.getNamedXContents().stream(),
        assertThat(params.getPathTokens(), is(List.of(RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN)));
        TemplatesMetadata settings = getTemplatesMetadata();
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
    @After
            .put(
            settings,
        compressor = new NoneCompressor();
    private BlobStoreRepository blobStoreRepository;
    }
    private Compressor compressor;
            UploadedMetadata uploadedMetadata = remoteObjectForUpload.getUploadedMetadata();
            )
                    .patterns(Arrays.asList("test-*"))
import org.junit.Before;
import java.util.function.Function;
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
            settings,
            namedXContentRegistry
        assertThat(RemoteStoreUtils.invertLong(nameTokens[1]), is(METADATA_VERSION));
            clusterUUID,
        );
    public void setup() {
    }
import org.opensearch.test.OpenSearchTestCase;
        this.clusterUUID = "test-cluster-uuid";
    }
            remoteObjectForUpload.setFullBlobName(new BlobPath().add(TEST_BLOB_PATH));
            namedXContentRegistry
 * The OpenSearch Contributors require contributions made to
        );
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
import org.opensearch.common.settings.Settings;
            compressor,
            compressor,
import org.opensearch.common.settings.ClusterSettings;
            uploadedFile,
        String blobFileName = remoteObjectForUpload.generateBlobFileName();
        );
        BlobPathParameters params = remoteObjectForUpload.getBlobPathParameters();
    }
        );
                    .settings(
    }
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            compressor,
        RemoteTemplatesMetadata remoteObjectForDownload = new RemoteTemplatesMetadata(
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
                ClusterModule.getNamedXWriteables().stream()
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
package org.opensearch.gateway.remote.model;
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
    }
            METADATA_VERSION,
    public void testGenerateBlobFileName() {
                        Settings.builder().put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5)).build()
        TemplatesMetadata settings = getTemplatesMetadata();
        assertThat(remoteObjectForUpload.getBlobFileName(), nullValue());
            clusterUUID,
import java.util.List;
        String uploadedFile = "user/local/opensearch/settings";
            remoteObjectForUpload.setFullBlobName(BlobPath.cleanPath());
            assertThat(uploadedMetadata.getUploadedFilename(), is(remoteObjectForUpload.getFullBlobName()));
            clusterUUID,
                    .order(5678)
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
            namedXContentRegistry
            compressor,
            compressor,
import java.util.Arrays;
    private static final long METADATA_VERSION = 3L;
import org.opensearch.common.network.NetworkModule;
            METADATA_VERSION,
            METADATA_VERSION,
        assertThat(params.getFilePrefix(), is(RemoteTemplatesMetadata.TEMPLATES_METADATA));
            namedXContentRegistry
            namedXContentRegistry
        threadPool.shutdown();
        assertThat(nameTokens[3], is(String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)));
                    .settings(
import org.opensearch.core.compress.NoneCompressor;
    }
        }
 * compatible open source license.
    private BlobStoreTransferService blobStoreTransferService;
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.cluster.ClusterModule;
        TemplatesMetadata settings = getTemplatesMetadata();
/*
            TEST_BLOB_NAME,
        namedXContentRegistry = new NamedXContentRegistry(
        RemoteTemplatesMetadata remoteObjectForUpload = new RemoteTemplatesMetadata(
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
import java.util.stream.Stream;
            clusterUUID,
            METADATA_VERSION,
                IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
