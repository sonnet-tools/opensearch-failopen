        remoteStoreLockManagerFactory = new RemoteStoreLockManagerFactory(repositoriesServiceSupplier, "");
import static org.mockito.Mockito.when;
 * compatible open source license.
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.repositories.RepositoriesService;  
        String testIndexUUID = "testIndexUUID";
            testShardId,
import org.opensearch.common.blobstore.BlobContainer;
 */  
        verify(blobStore, times(1)).blobContainer(blobPathCaptor.capture());
        BlobContainer blobContainer = mock(BlobContainer.class);
 * The OpenSearch Contributors require contributions made to  
        repositoriesServiceSupplier = mock(Supplier.class);
import org.opensearch.test.OpenSearchTestCase;
        when(repository.blobStore()).thenReturn(blobStore);  
import java.io.IOException;
import java.util.List;
    public void setup() throws IOException {
        assertEquals("base_path/" + testIndexUUID + "/" + testShardId + "/segments/lock_files/", blobPaths.get(0).buildAsString());  
 * SPDX-License-Identifier: Apache-2.0
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
package org.opensearch.index.store.lockmanager;
            testRepository,
import static org.mockito.Mockito.verify;  
        when(repository.basePath()).thenReturn(new BlobPath().add("base_path"));
        String testShardId = "testShardId";  
import org.mockito.ArgumentCaptor;
    }  
    private RepositoriesService repositoriesService;  
        when(repositoriesService.repository(testRepository)).thenReturn(repository);
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
    public void testNewLockManager() throws IOException {
import org.opensearch.index.remote.RemoteStorePathStrategy;
import static org.mockito.ArgumentMatchers.any;  
/*  
    @Before  
        assertTrue(lockManager != null);
 *
import static org.mockito.Mockito.times;
        ArgumentCaptor<BlobPath> blobPathCaptor = ArgumentCaptor.forClass(BlobPath.class);  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        repositoriesService = mock(RepositoriesService.class);  
        List<BlobPath> blobPaths = blobPathCaptor.getAllValues();
        BlobStore blobStore = mock(BlobStore.class);
        String testRepository = "testRepository";
import static org.mockito.Mockito.mock;
        );  
 * this file be licensed under the Apache-2.0 license or a
    private RemoteStoreLockManagerFactory remoteStoreLockManagerFactory;
import org.opensearch.common.blobstore.BlobStore;  
    }  
import java.util.Collections;  
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        RemoteStoreLockManager lockManager = remoteStoreLockManagerFactory.newLockManager(
import java.util.function.Supplier;
        BlobStoreRepository repository = mock(BlobStoreRepository.class);  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(PathType.FIXED);
import org.junit.Before;  
            pathStrategy
        when(blobContainer.listBlobs()).thenReturn(Collections.emptyMap());  
}
public class RemoteStoreLockManagerFactoryTests extends OpenSearchTestCase {  
        verify(repositoriesService).repository(testRepository);
            testIndexUUID,  
