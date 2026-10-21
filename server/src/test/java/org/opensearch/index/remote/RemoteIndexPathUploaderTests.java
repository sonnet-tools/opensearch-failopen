        );
            clusterSettings,
        verify(blobContainer, times(0)).writeBlob(anyString(), any(InputStream.class), anyLong(), anyBoolean());
        repositoriesService = mock(RepositoriesService.class);
        verify(blobContainer, times(1)).writeBlob(anyString(), any(InputStream.class), anyLong(), anyBoolean());
            DefaultRemoteStoreSettings.INSTANCE
            settings,
                Collections.emptyMap(),
            }
import static org.mockito.Mockito.when;
import org.opensearch.repositories.RepositoriesService;
        Settings settings = Settings.builder()
            .build();
        + RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            AssertionError.class,
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        thread.start();
        );
        verify(blobContainer, times(2)).writeBlob(anyString(), any(InputStream.class), anyLong(), anyBoolean());
    private IndexMetadata createIndexMetadata(Map<String, String> remoteCustomData) {
            () -> repositoriesService,
import java.util.List;
        remoteIndexPathUploader.start();
        IndexMetadata.Builder builder = IndexMetadata.builder("test")
 *
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
import static org.mockito.ArgumentMatchers.any;
            settings,
        List<IndexMetadata> indexMetadataList = List.of(createIndexMetadata(null));
        String pathHashAlgorithm = FIXED.name().equals(pathType) ? null : randomFrom(PathHashAlgorithm.values()).name();
            )
            assertEquals(1, failureCount.get());
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
            clusterSettings,
import java.util.Objects;
        when(repositoriesService.repository(SEGMENT_REPO_NAME)).thenReturn(repository);
    static final String TRANSLOG_REPO_NAME_KEY = Node.NODE_ATTRIBUTES.getKey()
            ex -> failureCount.incrementAndGet()
            clusterSettings,
    static final String SEGMENT_REPO_NAME_KEY = Node.NODE_ATTRIBUTES.getKey()
    private static final String TRANSLOG_REPO_NAME = "translog-repo";
            .put(CLUSTER_STATE_REPO_KEY, TRANSLOG_REPO_NAME)
import org.opensearch.common.blobstore.BlobPath;
        assertEquals(1, successCount.get());
        );
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
        basePath = BlobPath.cleanPath().add("test");
import java.util.HashMap;
        remoteCustomData.put(PathType.NAME, pathType);
            .numberOfReplicas(0)
            threadPool,
import org.opensearch.common.UUIDs;
            .build();
package org.opensearch.index.remote;
        assertEquals(1, successCount.get());
            .put(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(1))
        assertEquals(1, successCount.get());
        // Case 1 - Null remoteCustomData
        });
    }
            res -> successCount.incrementAndGet(),
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
            () -> remoteIndexPathUploader.doOnUpload(List.of(createIndexMetadata(new HashMap<>())), Collections.emptyMap(), actionListener)
        assertEquals(1, successCount.get());
        assertTrue(exceptionSetOnce.get() instanceof RemoteStateTransferException);
    private final ThreadPool threadPool = new TestThreadPool(getTestName());
            DefaultRemoteStoreSettings.INSTANCE
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
        assertEquals(0, failureCount.get());
            threadPool,
    private BlobContainer blobContainer;
import org.opensearch.Version;
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
import org.opensearch.gateway.remote.RemoteClusterStateService;
            DefaultRemoteStoreSettings.INSTANCE
    public void testInterceptWithDifferentRepo() throws IOException {
        );
        ActionListener<Void> actionListener = ActionListener.wrap(
import java.util.Collections;
            settings,
import org.opensearch.gateway.remote.RemoteStateTransferException;
        SetOnce<Exception> exceptionSetOnce = new SetOnce<>();
    }
        blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
import org.opensearch.core.action.ActionListener;
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_INFIX;
        );
        indexMetadataList = List.of(indexMetadata);
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
import org.opensearch.threadpool.TestThreadPool;
        remoteIndexPathUploader.start();
    private List<IndexMetadata> indexMetadataList;
            assertEquals(0, successCount.get());
            () -> remoteIndexPathUploader.doOnUpload(
            res -> successCount.incrementAndGet(),
    public void testInterceptWithEmptyEligibleIndexMetadataList() {
            threadPool,
public class RemoteIndexPathUploaderTests extends OpenSearchTestCase {
        remoteIndexPathUploader.doOnUpload(Collections.emptyList(), Collections.emptyMap(), actionListener);
        });
        + RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertTrue(
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
        Thread thread = new Thread(() -> {
        when(repository.basePath()).thenReturn(basePath);
            () -> repositoriesService,
            clusterSettings,
        assertThrows(
/*
            } catch (Exception e) {
                actionListener
        assertBusy(() -> {
            settings,
            .putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData)
            .put(GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING.getKey(), TimeValue.ZERO)
    private Settings settings;
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
            .put(this.settings)
import org.opensearch.common.blobstore.BlobStore;
            .put(SEGMENT_REPO_NAME_KEY, TRANSLOG_REPO_NAME)
import org.opensearch.cluster.metadata.IndexMetadata;
            () -> repositoriesService,
            DefaultRemoteStoreSettings.INSTANCE
            builder.putCustom(IndexMetadata.REMOTE_STORE_CUSTOM_KEY, remoteCustomData);
    public void setup() {
import org.opensearch.test.OpenSearchTestCase;
            .numberOfShards(1)
import java.io.IOException;
        );
            threadPool,
        );
        when(repository.blobStore()).thenReturn(blobStore);
        remoteIndexPathUploader.start();
        assertEquals(0, failureCount.get());
    public void testInterceptWithEmptyIndexMetadataList() {
        remoteIndexPathUploader.start();
        // Case 4 - RemoteStoreEnums.PathType.NAME is not HASHED_PREFIX
    }
        assertEquals(0, failureCount.get());
        ActionListener<Void> actionListener = ActionListener.wrap(
            PathHashAlgorithm.FNV_1A_BASE64.name()
        Map<String, String> remoteCustomData = Map.of(
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        when(repositoriesService.repository(anyString())).thenReturn(repository);
            DefaultRemoteStoreSettings.INSTANCE
            clusterSettings,
        );
        List<IndexMetadata> indexMetadataList = Mockito.<List>mock(List.class);
    }
        clusterSettings.applySettings(settings);
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
import org.opensearch.common.SetOnce;
    private final AtomicLong successCount = new AtomicLong();
import org.opensearch.common.settings.Settings;
        assertEquals(2, successCount.get());
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        });
        settings = Settings.builder()
            exceptionSetOnce.set(ex);
            () -> repositoriesService,
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
            threadPool,
            failureCount.incrementAndGet();
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        indexMetadataList = List.of(createIndexMetadata(remoteCustomData));
    public void testInterceptWithNoRemoteDataAttributes() {
    }
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
    private final AtomicLong failureCount = new AtomicLong();
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(asyncMultiStreamBlobContainer);
        assertThrows(
        );
    public void tearDown() throws Exception {
            clusterSettings,
            PathType.NAME,
        return builder.build();
                assertEquals("sleep interrupted", e.getMessage());
        assertEquals(0, successCount.get());
import org.junit.Before;
        SetOnce<Exception> exceptionSetOnce = new SetOnce<>();
import static org.mockito.ArgumentMatchers.anyString;
            settings,
import org.opensearch.node.Node;
            HASHED_PREFIX.name(),
    private static final String SEGMENT_REPO_NAME = "segment-repo";
        ActionListener<Void> actionListener = ActionListener.wrap(
import org.mockito.Mockito;
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED;
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            DefaultRemoteStoreSettings.INSTANCE
        });
    private ClusterSettings clusterSettings;
import org.opensearch.common.settings.ClusterSettings;
    }
    public void testInterceptWithSameRepo() throws IOException {
        when(repositoriesService.repository(TRANSLOG_REPO_NAME)).thenReturn(repository);
        IndexMetadata indexMetadata = new IndexMetadata.Builder("test").settings(idxSettings)
                remoteIndexPathUploader.onUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        remoteIndexPathUploader.start();
            res -> successCount.incrementAndGet(),
            ex -> failureCount.incrementAndGet()
        assertEquals(0, failureCount.get());
 */
        verify(indexMetadataList, times(0)).stream();
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
                assertTrue(e instanceof InterruptedException);
        Settings idxSettings = Settings.builder()
    public void testInterceptWithInterruptedExceptionDuringLatchAwait() throws Exception {
    }
        assertEquals(0, failureCount.get());
    }
        super.tearDown();
    public void testInterceptWithLatchAwaitTimeout() throws IOException {
        String pathType = randomFrom(FIXED, HASHED_INFIX).name();
import java.util.Map;
        ActionListener<Void> actionListener = ActionListener.wrap(
}
        assertEquals(0, failureCount.get());
    private RepositoriesService repositoriesService;
        assertEquals(1, failureCount.get());
import org.opensearch.common.blobstore.BlobContainer;
        Settings settings = Settings.builder().put(this.settings).put(SEGMENT_REPO_NAME_KEY, SEGMENT_REPO_NAME).build();
            threadPool,
            () -> repositoriesService,
            DefaultRemoteStoreSettings.INSTANCE
            settings,
        Thread.sleep(10);
            .build();
        Settings settings = Settings.Builder.EMPTY_SETTINGS;
        terminate(threadPool);
        assertEquals(0, failureCount.get());
            clusterSettings,
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.verify;
    @Before
        // Case 2 - Empty remoteCustomData
        RemoteIndexPathUploader remoteIndexPathUploader = new RemoteIndexPathUploader(
        );
import java.util.concurrent.atomic.AtomicLong;
            .put(this.settings)
            threadPool,
        clusterSettings.applySettings(settings);
        );
            PathHashAlgorithm.NAME,
            () -> repositoriesService,
        assertEquals(1, successCount.get());
        }
        clusterSettings.applySettings(settings);
            settings,
        assertEquals(1, successCount.get());
 * The OpenSearch Contributors require contributions made to
            ex -> failureCount.incrementAndGet()
        );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, successCount.get());
                List.of(createIndexMetadata(Map.of("test", "test"))),
import static org.opensearch.gateway.remote.RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING;
        );
    private static final String CLUSTER_STATE_REPO_KEY = Node.NODE_ATTRIBUTES.getKey()
        AsyncMultiStreamBlobContainer asyncMultiStreamBlobContainer = mock(AsyncMultiStreamBlobContainer.class);
import org.opensearch.threadpool.ThreadPool;
            failureCount.incrementAndGet();
        ActionListener<Void> actionListener = ActionListener.wrap(res -> successCount.incrementAndGet(), ex -> {
            .build();
            ex -> failureCount.incrementAndGet()
        Settings settings = Settings.builder()
        );
        remoteCustomData.put(PathHashAlgorithm.NAME, pathHashAlgorithm);
        );
            exceptionSetOnce.set(ex);
import org.opensearch.common.unit.TimeValue;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        ActionListener<Void> actionListener = ActionListener.wrap(res -> successCount.incrementAndGet(), ex -> {
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
        assertEquals(0, failureCount.get());
            .numberOfReplicas(0);
    private BlobStore blobStore;
    private BlobStoreRepository repository;
            .build();
import org.junit.After;
 * compatible open source license.
        repository = mock(BlobStoreRepository.class);
import org.opensearch.indices.DefaultRemoteStoreSettings;
        Map<String, String> remoteCustomData = new HashMap<>();
import org.opensearch.common.compress.DeflateCompressor;
            exceptionSetOnce.get().getMessage().contains("Timed out waiting while uploading remote index path file for indexes=[test/")
        + RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        // Case 3 - RemoteStoreEnums.PathType.NAME not in remoteCustomData map
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
            .put(TRANSLOG_REPO_NAME_KEY, TRANSLOG_REPO_NAME)
        blobStore = mock(BlobStore.class);
            .numberOfShards(1)
        when(repository.getCompressor()).thenReturn(new DeflateCompressor());
        thread.interrupt();
    private BlobPath basePath;
            () -> repositoriesService,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        blobContainer = mock(BlobContainer.class);
            res -> successCount.incrementAndGet(),
    }
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.anyLong;
        remoteIndexPathUploader.start();
            ex -> failureCount.incrementAndGet()
import java.io.InputStream;
            AssertionError.class,
        ActionListener<Void> actionListener = ActionListener.wrap(
        remoteIndexPathUploader.doOnUpload(indexMetadataList, Collections.emptyMap(), actionListener);
            try {
    }
        if (Objects.nonNull(remoteCustomData)) {
    @After
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        );
            res -> successCount.incrementAndGet(),
