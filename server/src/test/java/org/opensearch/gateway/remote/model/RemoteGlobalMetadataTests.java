                            .build()
import org.opensearch.common.compress.DeflateCompressor;  
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";
                                    .put("index.random_index_setting_" + randomAlphaOfLength(3), randomAlphaOfLength(5))
    private String clusterUUID;  
            .build();
    }  
    @Before  
    public static Metadata getGlobalMetadata() {
    public void testSerDe() throws IOException {
        );
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        String uploadedFile = "user/local/opensearch/globalMetadata";  
    }
import org.opensearch.common.settings.ClusterSettings;
        assertThrows(UnsupportedOperationException.class, remoteObjectForDownload::getBlobPathParameters);
                globalMetadata,
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
            compressor,  
        this.clusterUUID = "test-cluster-uuid";  
            compressor,
        Metadata globalMetadata = getGlobalMetadata();
                    .build()  
        return Metadata.builder()  
import org.opensearch.core.compress.Compressor;
    }  
                    .put(  
            namedXContentRegistry
/*  
import org.opensearch.common.network.NetworkModule;
                    .lastCommittedConfiguration(new VotingConfiguration(Set.of("node1")))
        threadPool.shutdown();
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.greaterThan;
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(  
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;  
                clusterUUID,
            namedXContentRegistry
 *
        );  
    }  
    }
        super.tearDown();
            TEST_BLOB_NAME,  
import org.junit.Before;  
            compressor,
            ).flatMap(Function.identity()).collect(toList())  
            .coordinationMetadata(  
        compressor = new NoneCompressor();  
    public void tearDown() throws Exception {  
            clusterUUID,
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
            assertTrue(Metadata.isGlobalStateEquals(readglobalMetadata, globalMetadata));
        this.clusterName = "test-cluster-name";
                TemplatesMetadata.builder()
        BlobPath blobPath = new BlobPath().add("/path");  
        );
                    )  
    private ClusterSettings clusterSettings;
                TEST_BLOB_NAME,  
    public void testGetUploadedMetadata() {  
    }
        this.blobStoreRepository = mock(BlobStoreRepository.class);
            RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
            namedXContentRegistry  
    public void testBlobPathParameters() {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.Set;
    private static final long TERM = 3L;
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        );
                TEST_BLOB_FILE_NAME,  
import org.opensearch.threadpool.TestThreadPool;  
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
    private String clusterName;  
            )
            clusterUUID,
                            .patterns(Arrays.asList("bar-*", "foo-*"))
                        IndexTemplateMetadata.builder("template" + randomAlphaOfLength(3))
        );  
            TEST_BLOB_NAME,
        assertThat(remoteObjectForDownload.getBlobPathTokens(), is(new String[] { "user", "local", "opensearch", "globalMetadata" }));
            TEST_BLOB_NAME,
import java.io.InputStream;  
 * SPDX-License-Identifier: Apache-2.0
            Stream.of(
        );  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
                    .build()
                            )
                                    .build()  
            clusterUUID,  
            namedXContentRegistry
import java.util.Arrays;
            compressor,  
        this.blobStoreTransferService = mock(BlobStoreTransferService.class);
            .templates(
    public void testGenerateBlobFileName() {
            namedXContentRegistry
    private NamedXContentRegistry namedXContentRegistry;  
        ) {
    }
import org.opensearch.threadpool.ThreadPool;
            ).streamInput()  
import org.junit.After;
import org.opensearch.cluster.coordination.CoordinationMetadata;
import org.opensearch.cluster.ClusterModule;
            Metadata readglobalMetadata = remoteObjectForDownload.deserialize(inputStream);  
import java.util.function.Function;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            TEST_BLOB_NAME,  
                                Settings.builder()
            compressor,
import org.opensearch.core.compress.NoneCompressor;
            namedXContentRegistry  
            namedXContentRegistry
                    .addVotingConfigExclusion(new VotingConfigExclusion("node2", " node-2"))
                NetworkModule.getNamedXContents().stream(),  
            clusterUUID,
            );
                RemoteClusterStateUtils.FORMAT_PARAMS
    private BlobStoreRepository blobStoreRepository;
                ClusterModule.getNamedXWriteables().stream()
                    .term(TERM)
                compressor,
                namedXContentRegistry  
import org.opensearch.indices.IndicesModule;  
            clusterUUID,
        }
import static org.opensearch.gateway.remote.model.RemoteGlobalMetadata.GLOBAL_METADATA_FORMAT;
        try (  
    }
            TEST_BLOB_NAME,
                CoordinationMetadata.builder()
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    private BlobStoreTransferService blobStoreTransferService;
import org.opensearch.cluster.metadata.Metadata;  
            compressor,
import static java.util.stream.Collectors.toList;  
 * The OpenSearch Contributors require contributions made to  
            uploadedFile,
                IndicesModule.getNamedXContents().stream(),
}
import org.opensearch.common.blobstore.BlobPath;
    }  
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
import org.opensearch.cluster.metadata.TemplatesMetadata;
            clusterUUID,  
        assertThat(remoteObjectForDownload.getBlobFileName(), is(TEST_BLOB_FILE_NAME));
 */  
        assertThat(remoteObjectForDownload.getFullBlobName(), is(TEST_BLOB_NAME));
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
                    .lastAcceptedConfiguration(new VotingConfiguration(Set.of("node1")))  
    public void testClusterUUID() {
            assertThat(inputStream.available(), greaterThan(0));
        assertThrows(UnsupportedOperationException.class, remoteObjectForDownload::generateBlobFileName);  
    public void testFullBlobName() {  
            compressor,
        assertThrows(UnsupportedOperationException.class, remoteObjectForDownload::getUploadedMetadata);
    public void setup() {
    public void testBlobFileName() {
            )
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(  
            InputStream inputStream = GLOBAL_METADATA_FORMAT.serialize(
        );
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
    private static final String TEST_BLOB_NAME = "/test-path/test-blob-name";  
    }  
    public void testBlobPathTokens() {
            TEST_BLOB_NAME,
        );
    private Compressor compressor;
public class RemoteGlobalMetadataTests extends OpenSearchTestCase {
                compressor,
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
package org.opensearch.gateway.remote.model;
            clusterUUID,  
                            .settings(  
import java.io.IOException;
    }  
        namedXContentRegistry = new NamedXContentRegistry(
    @After
import java.util.stream.Stream;
        assertThat(remoteObjectForDownload.clusterUUID(), is(clusterUUID));  
        RemoteGlobalMetadata remoteObjectForDownload = new RemoteGlobalMetadata(
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
