            Arrays.asList(  
        secondCluster.beforeTest(random());
    }
            "second_cluster",  
        createFullSnapshot(repoNameOnFirstCluster, "snap-1");
package org.opensearch.snapshots;
import org.opensearch.test.OpenSearchIntegTestCase;
public class MultiClusterRepoAccessIT extends AbstractSnapshotIntegTestCase {  
                InternalSettingsPlugin.class,
                MockHttpTransport.TestPlugin.class,
 * license agreements. See the NOTICE file distributed with
            containsString(  
 *  
                }
            cause.getMessage(),
        ).get();
                "["
        );  
/*
import org.opensearch.env.Environment;  
        );
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder().put("location", repoPath),
        createIndexWithRandomDocs("test-idx-1", randomIntBetween(1, 100));
        OpenSearchIntegTestCase.putRepositoryRequestBuilder(  
    public void startSecondCluster() throws IOException, InterruptedException {  
            true,
import org.opensearch.test.transport.MockTransportService;
 * the Apache License, Version 2.0 (the "License"); you may
            0,
import static org.hamcrest.Matchers.containsString;
 */
/*
                    return null;
import org.opensearch.test.MockHttpTransport;
import org.opensearch.repositories.RepositoryException;
            0,
}
        final String repoNameOnFirstCluster = "test-repo";  
        secondCluster.client().admin().cluster().prepareDeleteSnapshot(repoNameOnSecondCluster, "snap-2").get();  
        secondCluster = new InternalTestCluster(
 * Unless required by applicable law or agreed to in writing,
 */
 * You may obtain a copy of the License at  
                }  
            "fs",  
import org.opensearch.test.NodeConfigurationSource;  
    private InternalTestCluster secondCluster;
            new NodeConfigurationSource() {
        createIndexWithRandomDocs("test-idx-2", randomIntBetween(1, 100));  
import org.opensearch.test.InternalSettingsPlugin;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 *
        secondCluster.client().admin().cluster().prepareDeleteSnapshot(repoNameOnSecondCluster, "snap-1").get();
                public Settings nodeSettings(int nodeOrdinal) {  
                .setWaitForCompletion(true)
                MockNioTransportPlugin.class,
            "leader",
                MockTransportService.TestPlugin.class,  
    @Before
        createIndexWithRandomDocs("test-idx-3", randomIntBetween(1, 100));
import org.junit.After;
        createRepository(repoNameOnFirstCluster, "fs", repoPath);
 *    http://www.apache.org/licenses/LICENSE-2.0
        secondCluster.startDataOnlyNode();
            null,  
import java.io.IOException;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
import java.util.Arrays;  
        assertThat(
            false
                    return Settings.builder()
    }
                public Path nodeConfigPath(int nodeOrdinal) {  
            () -> client().admin()
        internalCluster().startDataOnlyNode();
    }  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                @Override
 *
 * specific language governing permissions and limitations
 * compatible open source license.
            true,  
                MockRepository.Plugin.class  
                        .put(NetworkModule.TRANSPORT_TYPE_KEY, getTestTransportType())  
            repoNameOnSecondCluster,
 */  
 * ownership. Elasticsearch licenses this file to you under  
                OpenSearchIntegTestCase.TestSeedPlugin.class,
                .execute()
        createFullSnapshot(repoNameOnFirstCluster, "snap-5");
        createFullSnapshot(repoNameOnFirstCluster, "snap-2");
import java.util.function.Function;
            Function.identity()
    public void testConcurrentDeleteFromOtherCluster() throws InterruptedException {  
 * KIND, either express or implied.  See the License for the
        createRepository(repoNameOnFirstCluster, "fs", repoPath);
                    + "] concurrent modification of the index-N file, expected current generation [2] but it was not found in the repository"  
            true,
            SnapshotException.class,  
                .actionGet()  
        secondCluster.startClusterManagerOnlyNode();
            },  
import org.opensearch.transport.nio.MockNioTransportPlugin;  
                @Override
import org.junit.Before;
 * Licensed to Elasticsearch under one or more contributor  
                    + repoNameOnFirstCluster
 * Modifications Copyright OpenSearch Contributors. See  
        final SnapshotException sne = expectThrows(
 * The OpenSearch Contributors require contributions made to  
    private Path repoPath;  
        final RepositoryException cause = (RepositoryException) sne.getCause();  
 * GitHub history for details.
            0,
                        .put(MultiClusterRepoAccessIT.this.nodeSettings(nodeOrdinal))
            createTempDir(),
        createFullSnapshot(repoNameOnFirstCluster, "snap-3");  
    public void stopSecondCluster() throws IOException {
import org.opensearch.snapshots.mockstore.MockRepository;
        );
        assertAcked(client().admin().cluster().prepareDeleteRepository(repoNameOnFirstCluster).get());  
import org.opensearch.test.InternalTestCluster;
 * this work for additional information regarding copyright
import java.nio.file.Path;
        repoPath = randomRepoPath();
                .prepareCreateSnapshot(repoNameOnFirstCluster, "snap-4")  
            ),
                        .build();
import org.opensearch.common.util.io.IOUtils;
        IOUtils.close(secondCluster);  
import org.opensearch.common.settings.Settings;
    @After
            secondCluster.client().admin().cluster(),
            randomLong(),  
import org.opensearch.common.network.NetworkModule;  
                        .put(Environment.PATH_REPO_SETTING.getKey(), repoPath)
        assertThat(sne.getMessage(), containsString("failed to update snapshot in repository"));
 * under the License.  
/*  
            )
        final String repoNameOnSecondCluster = randomBoolean() ? "test-repo" : "other-repo";
        internalCluster().startClusterManagerOnlyNode();
                .cluster()
