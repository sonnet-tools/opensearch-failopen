}  
import java.nio.file.Path;
/**  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.remotestore;
        return Settings.builder()
import org.junit.After;
        return true;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            .put(super.nodeSettings(nodeOrdinal))  
    public void teardown() {  
    }  
import org.junit.Before;
 */
        if (absolutePath == null) {
    protected Settings nodeSettings(int nodeOrdinal) {
    }
    }
    public void setup() {
 */  
 * compatible open source license.
    @Before  
    @Override  
/*  
 *
    private static final String REPOSITORY_NAME = "test-remote-store-repo";  
        }
            absolutePath = randomRepoPath().toAbsolutePath();  
import org.opensearch.common.settings.Settings;
        internalCluster().startClusterManagerOnlyNode();
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
 * this file be licensed under the Apache-2.0 license or a
    protected Path absolutePath;
 * This class runs Segment Replication Integ test suite with remote store enabled.
public class SegmentReplicationUsingRemoteStoreIT extends SegmentReplicationIT {
 * The OpenSearch Contributors require contributions made to  
    @After
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.indices.replication.SegmentReplicationIT;
    }  
            .build();
    protected boolean segmentReplicationWithRemoteEnabled() {
