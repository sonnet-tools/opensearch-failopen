            clusterUUID,
    public void testBlobPathParameters() {
import org.opensearch.cluster.metadata.Metadata;
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
            clusterUUID,
                TEST_BLOB_FILE_NAME,
import org.junit.After;
                TEST_BLOB_NAME,
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
                globalMetadata,
    private String clusterUUID;
/*
import org.opensearch.common.settings.ClusterSettings;
        BlobPath blobPath = new BlobPath().add("/path");
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        );
        super.tearDown();
import java.util.function.Function;
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
            namedXContentRegistry
            .build();
            namedXContentRegistry
        assertThrows(UnsupportedOperationException.class, remoteObjectForDownload::getBlobPathParameters);
                TemplatesMetadata.builder()
        assertThrows(UnsupportedOperationException.class, remoteObjectForDownload::generateBlobFileName);
            TEST_BLOB_NAME,
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
            RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
        String uploadedFile = "user/local/opensearch/globalMetadata";
 * compatible open source license.
            compressor,
            compressor,
        );
    }
            .coordinationMetadata(
            clusterUUID,
                    .lastAcceptedConfiguration(new VotingConfiguration(Set.of("node1")))
                    .build()
import org.opensearch.core.compress.NoneCompressor;
            InputStream inputStream = GLOBAL_METADATA_FORMAT.serialize(
import java.util.Set;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import static org.mockito.Mockito.mock;
                ClusterModule.getNamedXWriteables().stream()
            clusterUUID,
 * SPDX-License-Identifier: Apache-2.0
                compressor,
            compressor,
                IndicesModule.getNamedXContents().stream(),
    }
        return Metadata.builder()
            Metadata readglobalMetadata = remoteObjectForDownload.deserialize(inputStream);
            ).flatMap(Function.identity()).collect(toList())
    public void testSerDe() throws IOException {
import org.opensearch.common.network.NetworkModule;
package org.opensearch.gateway.remote.model;
            compressor,
        namedXContentRegistry = new NamedXContentRegistry(
    private BlobStoreTransferService blobStoreTransferService;
            clusterUUID,
                    .addVotingConfigExclusion(new VotingConfigExclusion("node2", " node-2"))
    public static Metadata getGlobalMetadata() {
                            )
        Metadata globalMetadata = getGlobalMetadata();
        }
 *
    public void testGetUploadedMetadata() {
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
                RemoteClusterStateUtils.FORMAT_PARAMS
            namedXContentRegistry
            TEST_BLOB_NAME,
            assertThat(inputStream.available(), greaterThan(0));
import org.opensearch.cluster.metadata.TemplatesMetadata;
import org.opensearch.common.compress.DeflateCompressor;
    @Before
    public void testGenerateBlobFileName() {
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
        threadPool.shutdown();
    private static final long TERM = 3L;
        assertThrows(UnsupportedOperationException.class, remoteObjectForDownload::getUploadedMetadata);
    public void testFullBlobName() {
            .templates(
            compressor,
            TEST_BLOB_NAME,
import org.opensearch.common.settings.Settings;
            namedXContentRegistry
    }
                    .lastCommittedConfiguration(new VotingConfiguration(Set.of("node1")))
                                Settings.builder()
            TEST_BLOB_NAME,
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
            compressor,
        this.blobStoreRepository = mock(BlobStoreRepository.class);
public class RemoteGlobalMetadataTests extends OpenSearchTestCase {
            clusterUUID,
    private NamedXContentRegistry namedXContentRegistry;
                            .patterns(Arrays.asList("bar-*", "foo-*"))
    }
import org.opensearch.indices.IndicesModule;
    }
                CoordinationMetadata.builder()
            )
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
    public void testBlobFileName() {
    public void testBlobPathTokens() {
                            .build()
                clusterUUID,
}
import org.opensearch.cluster.coordination.CoordinationMetadata;
    public void testClusterUUID() {
import org.opensearch.common.blobstore.BlobPath;
    }
                        IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
 * The OpenSearch Contributors require contributions made to
                    .term(TERM)
import static org.mockito.Mockito.when;
            TEST_BLOB_NAME,
    public void setup() {
import java.util.Arrays;
                NetworkModule.getNamedXContents().stream(),
import org.junit.Before;
import org.opensearch.core.compress.Compressor;
            namedXContentRegistry
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
        );
import org.opensearch.threadpool.TestThreadPool;
        );
    }
        );
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "globalMetadata" }));
            uploadedFile,
            Stream.of(
            ).streamInput()
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
    private BlobStoreRepository blobStoreRepository;
            compressor,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        this.clusterName = "test-cluster-name";
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;
                compressor,
                                    .build()
                namedXContentRegistry
        );
            namedXContentRegistry
import static org.hamcrest.Matchers.is;
    private Compressor compressor;
            assertTrue(Metadata.isGlobalStateEquals(readglobalMetadata, globalMetadata));
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
                    .build()
        try (
 */
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
        );
            TEST_BLOB_NAME,
    }
        ) {
                                    .put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
    public void tearDown() throws Exception {
import static org.hamcrest.Matchers.greaterThan;
                    .put(
    private ClusterSettings clusterSettings;
            )
        );
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
    }
            namedXContentRegistry
        this.clusterUUID = "test-cluster-uuid";
        compressor = new NoneCompressor();
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
    }
            );
    @After
import org.opensearch.cluster.ClusterModule;
                            .settings(
            clusterUUID,
    }
import java.io.IOException;
import java.io.InputStream;
    private String clusterName;
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
                    )
