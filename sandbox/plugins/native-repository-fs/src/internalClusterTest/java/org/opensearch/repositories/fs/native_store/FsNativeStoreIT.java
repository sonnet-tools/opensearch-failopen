            .get();  
    @Override
        Repository repo = repoService.repository("repo-delete");  
import java.util.List;  
        Path loc = repoPath.resolve("repo-delete");
    public void testNativeStoreDestroyedOnRepoDelete() throws IOException {  
    }
}
    public void testFsRepoGetsNativeStore() throws IOException {  
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
public class FsNativeStoreIT extends OpenSearchIntegTestCase {
        client().admin()
            .cluster()  
        client().admin()
        assertThat("Both pointers should be > 0", ptr2, greaterThan(0L));
            .setSettings(Settings.builder().put("location", loc1.toAbsolutePath().toString()))  
        return List.of(FsNativeObjectStorePlugin.class);
            .cluster()  
        Files.createDirectories(loc);
import java.io.IOException;
    private Path repoPath;  
    }
        assertTrue("Repository creation should be acknowledged", response.isAcknowledged());
 * Integration test verifying FsRepository native store lifecycle.
        client().admin().cluster().prepareDeleteRepository("repo-delete").get();
        Files.createDirectories(location);
import static org.hamcrest.Matchers.greaterThan;  
            .setType("fs")
/**  
        if (repoPath == null) {  
        Path loc1 = repoPath.resolve("repo-1");  
            repoPath = createTempDir();
            .preparePutRepository("repo-1")
            .setSettings(Settings.builder().put("location", loc2.toAbsolutePath().toString()))  
            .get();
 *
/*  
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.common.settings.Settings;
        long ptr1 = repoService.repository("repo-1").getNativeStore().getPointer();
        Files.createDirectories(loc2);  
            .setType("fs")
        Repository repo = repoService.repository("test-fs-repo");
            .cluster()
        long ptr = repo.getNativeStore().getPointer();
        assertEquals("Pointer should be consistent across calls", ptr, repo.getNativeStore().getPointer());
    }
        expectThrows(IllegalStateException.class, () -> repo.getNativeStore().getPointer());  
            .setType("fs")
    @Override
    protected Settings nodeSettings(int nodeOrdinal) {
    }
    public void testDifferentReposGetDifferentPointers() throws IOException {
import java.util.Collection;
 */  
package org.opensearch.repositories.fs.native_store;
            .get();  
import org.opensearch.plugins.Plugin;  
 */
 * SPDX-License-Identifier: Apache-2.0
        Path location = repoPath.resolve("test-repo");
 * compatible open source license.
            .preparePutRepository("repo-delete")  
import org.opensearch.repositories.Repository;
        AcknowledgedResponse response = client().admin()
            .preparePutRepository("repo-2")
import org.opensearch.test.OpenSearchIntegTestCase;  
            .preparePutRepository("test-fs-repo")  
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Files;  
    }  
        assertThat("Both pointers should be > 0", ptr1, greaterThan(0L));
import static org.hamcrest.Matchers.equalTo;
            .setType("fs")
        Files.createDirectories(loc1);
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("path.repo", repoPath.toAbsolutePath().toString()).build();  
import static org.hamcrest.Matchers.not;
import java.nio.file.Path;
        long ptr = repo.getNativeStore().getPointer();  
            .setSettings(Settings.builder().put("location", location.toAbsolutePath().toString()))
        RepositoriesService repoService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);
        long ptr2 = repoService.repository("repo-2").getNativeStore().getPointer();
        RepositoriesService repoService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);  
        assertThat("Native store pointer should be > 0", ptr, greaterThan(0L));
        Path loc2 = repoPath.resolve("repo-2");
            .get();
 * this file be licensed under the Apache-2.0 license or a
        assertThat("Pointer should be > 0 before delete", ptr, greaterThan(0L));
            .setSettings(Settings.builder().put("location", loc.toAbsolutePath().toString()))
        assertThat("Different repos should get different native store pointers", ptr1, not(equalTo(ptr2)));  
            .cluster()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        client().admin()
        RepositoriesService repoService = internalCluster().getCurrentClusterManagerNodeInstance(RepositoriesService.class);  
