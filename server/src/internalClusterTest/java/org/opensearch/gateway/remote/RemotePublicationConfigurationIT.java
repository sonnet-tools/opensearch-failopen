        super.remoteRepoPrefix = "remote_publication";
 *  Remote Publish Configured Node [Cluster State + Routing Table]
 */
 *  Remote Node [Cluster State + Segment + Translog]
import org.opensearch.test.OpenSearchIntegTestCase;
 * compatible open source license.
/*  
        }  
    }  
    @Before
            segmentRepoPath = randomRepoPath().toAbsolutePath();
    public void setUp() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
}
/**
 *  Non Remote node [No Repositories configured]  
 *
 * this file be licensed under the Apache-2.0 license or a
 *  Remote Node With Routing Table [Cluster State + Segment + Translog + Routing Table]  
        if (segmentRepoPath == null || translogRepoPath == null) {  
        super.setUp();
public class RemotePublicationConfigurationIT extends RemoteRepositoryConfigurationIT {  
 * Tests the compatibility between types of nodes based on the configured repositories
package org.opensearch.gateway.remote;
            translogRepoPath = randomRepoPath().toAbsolutePath();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.junit.Before;
 */  
