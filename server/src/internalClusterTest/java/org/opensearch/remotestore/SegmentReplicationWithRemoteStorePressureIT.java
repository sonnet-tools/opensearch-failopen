import java.nio.file.Path;
 *
 * This class executes the SegmentReplicationPressureIT suite with remote store integration enabled.  
import org.opensearch.index.SegmentReplicationPressureIT;
import org.junit.After;
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
        absolutePath = randomRepoPath().toAbsolutePath();
 * SPDX-License-Identifier: Apache-2.0
    }
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;  
public class SegmentReplicationWithRemoteStorePressureIT extends SegmentReplicationPressureIT {  
            .put(super.nodeSettings(nodeOrdinal))
    private static final String REPOSITORY_NAME = "test-remote-store-repo";
    protected Path absolutePath;  
 */  
        internalCluster().startClusterManagerOnlyNode();  
    }  
/*  
 */
    public void teardown() {
        return true;
    protected boolean segmentReplicationWithRemoteEnabled() {  
}
    @Before  
    }
package org.opensearch.remotestore;
    @Override
    @After  
import org.junit.Before;
import org.opensearch.test.OpenSearchIntegTestCase;  
 * this file be licensed under the Apache-2.0 license or a
/**
    public void setup() {
            .build();  
 * compatible open source license.
    }
import org.opensearch.common.settings.Settings;
        return Settings.builder()  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * The OpenSearch Contributors require contributions made to  
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override
