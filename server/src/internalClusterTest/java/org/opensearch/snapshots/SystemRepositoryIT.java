package org.opensearch.snapshots;
        RepositoryException e = expectThrows(RepositoryException.class, () -> createRepository(systemRepoName, "mock", repoSettings));
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            .put(remoteStoreClusterSettings(systemRepoName, absolutePath))
 * SPDX-License-Identifier: Apache-2.0
                + "repository from current value [reloadable-fs] to new value [mock]"  
    }  
 */  
        );
        assertEquals(  
 *
import org.opensearch.core.common.unit.ByteSizeValue;
        internalCluster().startNode();  
        createRepository(systemRepoName, ReloadableFsRepository.TYPE, repoSettings);
    final String systemRepoName = "system-repo-name";  
import org.opensearch.repositories.RepositoryException;  
    public void testRestrictedSettingsCantBeUpdated() {  
 * this file be licensed under the Apache-2.0 license or a
        return Settings.builder()  
import java.nio.file.Path;
}
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;
    protected Path absolutePath;
import org.opensearch.common.settings.Settings;
    @Before
        final Settings.Builder repoSettings = Settings.builder().put("location", randomRepoPath());
            .build();  
        absolutePath = randomRepoPath().toAbsolutePath();
import org.opensearch.test.OpenSearchIntegTestCase;
 * compatible open source license.
        final Settings.Builder repoSettings = Settings.builder().put("location", absolutePath).put("chunk_size", new ByteSizeValue(20));
            .put(super.nodeSettings(nodeOrdinal))
            "[system-repo-name] trying to modify an unmodifiable attribute type of system "
        disableRepoConsistencyCheck("System repository is being used for the test");
    }
    public void setup() {  
            e.getMessage(),
    public void testSystemRepositoryNonRestrictedSettingsCanBeUpdated() {
        disableRepoConsistencyCheck("System repository is being used for the test");
public class SystemRepositoryIT extends AbstractSnapshotIntegTestCase {
import org.opensearch.repositories.fs.ReloadableFsRepository;
        internalCluster().startNode();  
    }
    }
/*  
 * The OpenSearch Contributors require contributions made to  
import org.junit.Before;  
