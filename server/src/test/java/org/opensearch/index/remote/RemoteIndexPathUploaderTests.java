        assertEquals(0, successCount.get());  
        assertEquals(1, successCount.get());
    public void testInterceptWithNoRemoteDataAttributes() {  
            () -> repositoriesService,
    private List<IndexMetadata> indexMetadataList;  
import org.junit.Before;  
            exceptionSetOnce.set(ex);
        verify(blobContainer, times(2)).writeBlob(anyString(), any(InputStream.class), anyLong(), anyBoolean());
            res -> successCount.incrementAndGet(),  
            .build();
        assertEquals(0, failureCount.get());  
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_INFIX;  
            () -> remoteIndexPathUploader.doOnUpload(
        blobContainer = mock(BlobContainer.class);  
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            PathHashAlgorithm.NAME,  
        indexMetadataList = List.of(indexMetadata);  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        ActionListener<Void> actionListener = ActionListener.wrap(  
import java.util.List;  
        ActionListener<Void> actionListener = ActionListener.wrap(res -> successCount.incrementAndGet(), ex -> {
            failureCount.incrementAndGet();
        IndexMetadata indexMetadata = new IndexMetadata.Builder("test").settings(idxSettings)
        );  
            .put(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(1))
import org.opensearch.threadpool.TestThreadPool;  
    }
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED;
import java.util.Objects;
        );
        );
            res -> successCount.incrementAndGet(),
        });
            () -> repositoriesService,
                actionListener
            settings,  
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
            ex -> failureCount.incrementAndGet()
    public void testInterceptWithEmptyIndexMetadataList() {  
        when(repositoriesService.repository(SEGMENT_REPO_NAME)).thenReturn(repository);  
            ex -> failureCount.incrementAndGet()
            AssertionError.class,  
        ActionListener<Void> actionListener = ActionListener.wrap(  
    private Settings settings;
            exceptionSetOnce.get().getMessage().contains("Timed out waiting while uploading remote index path file for indexes=[test/")
        + RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        thread.start();
    private ClusterSettings clusterSettings;  
            settings,
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
                assertEquals("sleep interrupted", e.getMessage());
            assertEquals(1, failureCount.get());
            try {
import java.io.IOException;
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
            threadPool,
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);  
            DefaultRemoteStoreSettings.INSTANCE
        assertBusy(() -> {  
        // Case 1 - Null remoteCustomData
import static org.mockito.Mockito.when;  
            DefaultRemoteStoreSettings.INSTANCE  
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
        Map<String, String> remoteCustomData = Map.of(  
import org.opensearch.common.UUIDs;
        repositoriesService = mock(RepositoriesService.class);
        assertEquals(1, successCount.get());
import java.util.concurrent.atomic.AtomicLong;  
        assertThrows(  
            res -> successCount.incrementAndGet(),
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
import org.opensearch.gateway.remote.RemoteClusterStateService;
        basePath = BlobPath.cleanPath().add("test");  
                assertTrue(e instanceof InterruptedException);
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put(this.settings).put(SEGMENT_REPO_NAME_KEY, SEGMENT_REPO_NAME).build();
    }
    private IndexMetadata createIndexMetadata(Map<String, String> remoteCustomData) {
        ActionListener<Void> actionListener = ActionListener.wrap(  
            () -> repositoriesService,
    }
        }
}  
        Settings settings = Settings.builder()
        List<IndexMetadata> indexMetadataList = Mockito.<List>mock(List.class);
    private final AtomicLong failureCount = new AtomicLong();
        + RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.opensearch.common.blobstore.BlobStore;
 *
            clusterSettings,
        remoteIndexPathUploader.start();
            DefaultRemoteStoreSettings.INSTANCE  
            .put(CLUSTER_STATE_REPO_KEY, TRANSLOG_REPO_NAME)
        return builder.build();  
        );
            .build();
            threadPool,
        Settings idxSettings = Settings.builder()  
        settings = Settings.builder()
        remoteIndexPathUploader.start();
    private RepositoriesService repositoriesService;
import org.opensearch.indices.DefaultRemoteStoreSettings;  
            DefaultRemoteStoreSettings.INSTANCE  
            )
            .build();
        );  
        assertTrue(  
            .put(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING.getKey(), TimeValue.ZERO)  
        assertEquals(0, failureCount.get());
import org.opensearch.cluster.metadata.IndexMetadata;
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
            clusterSettings,
        if (Objects.nonNull(remoteCustomData)) {  
        when(repository.blobStore()).thenReturn(blobStore);
        assertEquals(0, failureCount.get());
            settings,  
        });  
            .numberOfReplicas(0)  
import static org.mockito.Mockito.times;
        assertEquals(0, failureCount.get());  
        );
            DefaultRemoteStoreSettings.INSTANCE  
    public void testInterceptWithLatchAwaitTimeout() throws IOException {
        String pathType = randomFrom(FIXED, HASHED_INFIX).name();
import static org.mockito.ArgumentMatchers.anyBoolean;  
            .numberOfShards(1)
    @After  
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);  
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    @Before  
        });
            .put(this.settings)
import java.io.InputStream;  
        assertEquals(1, failureCount.get());
        when(repository.basePath()).thenReturn(basePath);
            DefaultRemoteStoreSettings.INSTANCE
                remoteIndexPathUploader.onUpload(indexMetadataList, Collections.emptyMap(), actionListener);
import static org.mockito.ArgumentMatchers.any;
                Collections.emptyMap(),  
import org.mockito.Mockito;
        verify(indexMetadataList, times(0)).stream();  
        verify(blobContainer, times(1)).writeBlob(anyString(), any(InputStream.class), anyLong(), anyBoolean());
        thread.interrupt();
            threadPool,
        AsyncMultiStreamBlobContainer asyncMultiStreamBlobContainer = mock(AsyncMultiStreamBlobContainer.class);
            clusterSettings,
            settings,  
        assertEquals(0, failureCount.get());
import java.util.Collections;
            .numberOfReplicas(0);
            DefaultRemoteStoreSettings.INSTANCE  
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        + RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertEquals(1, successCount.get());
        ActionListener<Void> actionListener = ActionListener.wrap(  
        });
        // Case 2 - Empty remoteCustomData
    private BlobContainer blobContainer;
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(  
import org.opensearch.core.action.ActionListener;
import static org.mockito.Mockito.mock;  
            settings,  
    }
        Thread.sleep(10);  
    public void testInterceptWithSameRepo() throws IOException {  
            PathType.NAME,
        verify(blobContainer, times(0)).writeBlob(anyString(), any(InputStream.class), anyLong(), anyBoolean());  
        // Case 4 - RemoteStoreEnums.PathType.NAME is not HASHED_PREFIX
    public void testInterceptWithEmptyEligibleIndexMetadataList() {  
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)  
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(asyncMultiStreamBlobContainer);
            exceptionSetOnce.set(ex);  
            () -> repositoriesService,
    }
    static final String TRANSLOG_REPO_NAME_KEY = Node.NODE_ATTRIBUTES.getKey()
        assertEquals(2, successCount.get());  
            ex -> failureCount.incrementAndGet()
        );  
 * this file be licensed under the Apache-2.0 license or a
        SetOnce<Exception> exceptionSetOnce = new SetOnce<>();
            settings,
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        );
import org.opensearch.common.unit.TimeValue;  
        assertEquals(1, successCount.get());
        remoteIndexPathUploader.start();
            .build();  
        IndexMetadata.Builder builder = IndexMetadata.builder("test")
            res -> successCount.incrementAndGet(),
        );
import org.opensearch.common.settings.Settings;
        Map<String, String> remoteCustomData = new HashMap<>();
            ex -> failureCount.incrementAndGet()
            res -> successCount.incrementAndGet(),
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(  
            .put(this.settings)  
import org.opensearch.common.blobstore.BlobContainer;  
            threadPool,
 * The OpenSearch Contributors require contributions made to  
        remoteCustomData.put(PathHashAlgorithm.NAME, pathHashAlgorithm);  
        );
        clusterSettings.applySettings(settings);
    public void setup() {
        clusterSettings.applySettings(settings);
package org.opensearch.index.remote;
        // Case 3 - RemoteStoreEnums.PathType.NAME not in remoteCustomData map
/*  
            ex -> failureCount.incrementAndGet()
        );  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
            () -> remoteIndexPathUploader.doOnUpload(List.of(createIndexMetadata(new HashMap<>())), Collections.emptyMap(), actionListener)
import org.opensearch.common.SetOnce;  
    private static final String CLUSTER_STATE_REPO_KEY = Node.NODE_ATTRIBUTES.getKey()
        assertThrows(
    public void testInterceptWithInterruptedExceptionDuringLatchAwait() throws Exception {  
    private BlobStoreRepository repository;
        );  
            clusterSettings,
import org.opensearch.Version;
import org.opensearch.node.Node;
            .put(SEGMENT_REPO_NAME_KEY, TRANSLOG_REPO_NAME)
    private final ThreadPool threadPool = new TestThreadPool(getTestName());
        clusterSettings.applySettings(settings);  
            clusterSettings,
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
        Thread thread = new Thread(() -> {  
        assertEquals(1, successCount.get());
        assertEquals(0, failureCount.get());  
            HASHED_PREFIX.name(),
            } catch (Exception e) {  
import org.opensearch.common.blobstore.BlobPath;
            clusterSettings,
        terminate(threadPool);  
            () -> repositoriesService,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        remoteIndexPathUploader.start();
import static org.opensearch.gateway.remote.RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING;
        );
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        List<IndexMetadata> indexMetadataList = List.of(createIndexMetadata(null));  
        when(repositoriesService.repository(TRANSLOG_REPO_NAME)).thenReturn(repository);  
        blobStore = mock(BlobStore.class);
    private static final String TRANSLOG_REPO_NAME = "translog-repo";
import static org.mockito.ArgumentMatchers.anyLong;
            AssertionError.class,
    private static final String SEGMENT_REPO_NAME = "segment-repo";
 * compatible open source license.
import org.opensearch.repositories.RepositoriesService;  
            .putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData)
            }  
 */  
        when(repository.getCompressor()).thenReturn(new DeflateCompressor());
        assertEquals(0, failureCount.get());  
        repository = mock(BlobStoreRepository.class);
        );  
    public void testInterceptWithDifferentRepo() throws IOException {
            () -> repositoriesService,  
            () -> repositoriesService,  
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
        ActionListener<Void> actionListener = ActionListener.wrap(res -> successCount.incrementAndGet(), ex -> {
    static final String SEGMENT_REPO_NAME_KEY = Node.NODE_ATTRIBUTES.getKey()  
            .put(TRANSLOG_REPO_NAME_KEY, TRANSLOG_REPO_NAME)  
import org.junit.After;
import org.opensearch.gateway.remote.RemoteStateTransferException;  
            failureCount.incrementAndGet();  
    private final AtomicLong successCount = new AtomicLong();
            PathHashAlgorithm.FNV_1A_BASE64.name()
        blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        assertTrue(exceptionSetOnce.get() instanceof RemoteStateTransferException);
        );  
        super.tearDown();
        SetOnce<Exception> exceptionSetOnce = new SetOnce<>();  
        assertEquals(0, failureCount.get());
import org.opensearch.threadpool.ThreadPool;
        assertEquals(1, successCount.get());
        remoteCustomData.put(PathType.NAME, pathType);
import java.util.HashMap;
        ActionListener<Void> actionListener = ActionListener.wrap(
            .build();
    }
import org.opensearch.common.compress.DeflateCompressor;  
            threadPool,
                List.of(createIndexMetadata(Map.of("test", "test"))),
    }
            threadPool,
        );  
import static org.mockito.Mockito.verify;
        remoteIndexPathUploader.start();
        remoteIndexPathUploader.start();
    private BlobPath basePath;
    }
        when(repositoriesService.repository(anyString())).thenReturn(repository);  
import java.util.Map;
            clusterSettings,
            assertEquals(0, successCount.get());
            threadPool,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        remoteIndexPathUploader.doOnUpload(Collections.emptyList(), Collections.emptyMap(), actionListener);
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
        Settings settings = Settings.builder()
import static org.mockito.ArgumentMatchers.anyString;
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
            builder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
        indexMetadataList = List.of(createIndexMetadata(remoteCustomData));
        assertEquals(1, successCount.get());
            settings,  
import org.opensearch.common.settings.ClusterSettings;
    private BlobStore blobStore;  
    public void tearDown() throws Exception {
public class RemoteIndexPathUploaderTests extends OpenSearchTestCase {
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
        String pathHashAlgorithm = FIXED.name().equals(pathType) ? null : randomFrom(PathHashAlgorithm.values()).name();  
    }
import org.opensearch.test.OpenSearchTestCase;
    }
            .numberOfShards(1)
