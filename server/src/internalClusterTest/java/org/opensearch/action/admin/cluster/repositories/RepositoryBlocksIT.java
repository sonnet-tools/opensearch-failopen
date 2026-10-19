    public void testPutRepositoryWithBlocks() {
            setClusterReadOnly(true);
import org.opensearch.common.settings.Settings;
                .prepareVerifyRepository("test-repo-blocks")
                ),
                .execute()
 */
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
            Settings.Builder settings = Settings.builder().put("location", randomRepoPath());  
            setClusterReadOnly(false);
            GetRepositoriesResponse response = client().admin().cluster().prepareGetRepositories("test-repo-blocks").execute().actionGet();  
 * Modifications Copyright OpenSearch Contributors. See
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath());
 * KIND, either express or implied.  See the License for the
                    false  
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
/**
        }  
    public void testGetRepositoryWithBlocks() {
                    client().admin().cluster(),  
    }  
 *  
        logger.info("-->  deleting a repository is blocked when the cluster is read only");
            assertThat(response.repositories(), hasSize(1));
    public void testDeleteRepositoryWithBlocks() {
            setClusterReadOnly(true);
        }
 * ownership. Elasticsearch licenses this file to you under  
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath());
        assertAcked(client().admin().cluster().prepareDeleteRepository("test-repo-blocks"));
 */
                .cluster()  
 *
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo-blocks", "fs", false, settings);
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
 */  
/*  
 * license agreements. See the NOTICE file distributed with
    }
        }
import static org.hamcrest.Matchers.equalTo;
            setClusterReadOnly(false);  
        logger.info("-->  registering a repository is blocked when the cluster is read only");  
        } finally {
        // This test checks that the Get Repository operation is never blocked, even if the cluster is read only.  
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo-blocks", "fs", false, settings);
                    settings,
                    null,
            setClusterReadOnly(true);
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath());  
                OpenSearchIntegTestCase.putRepositoryRequestBuilder(
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        }
            );  
        // This test checks that the Get Repository operation is never blocked, even if the cluster is read only.
        logger.info("-->  deleting a repository is allowed when the cluster is not read only");
                    false,  
            assertBlocked(client().admin().cluster().prepareDeleteRepository("test-repo-blocks"), Metadata.CLUSTER_READ_ONLY_BLOCK);
            assertBlocked(
                .actionGet();  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.hasSize;
        } finally {  
 * this file be licensed under the Apache-2.0 license or a
        try {
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            assertThat(response.getNodes().size(), equalTo(cluster().numDataAndClusterManagerNodes()));
 * Unless required by applicable law or agreed to in writing,
        logger.info("-->  registering a repository is allowed when the cluster is not read only");
                Metadata.CLUSTER_READ_ONLY_BLOCK
    public void testVerifyRepositoryWithBlocks() {
 * software distributed under the License is distributed on an
        try {  
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath());  
}  
 * The OpenSearch Contributors require contributions made to  
        } finally {
            setClusterReadOnly(false);
 * <p>  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo-blocks", "fs", false, settings);  
 */  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
                    "test-repo-blocks",
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
import org.opensearch.cluster.metadata.Metadata;  
        } finally {
/*  
            setClusterReadOnly(true);
public class RepositoryBlocksIT extends OpenSearchIntegTestCase {
                    "fs",
        try {
 * compatible open source license.
package org.opensearch.action.admin.cluster.repositories;
    }
        try {  
 *
            VerifyRepositoryResponse response = client().admin()
            setClusterReadOnly(false);  
 * this work for additional information regarding copyright
 * This class tests that repository operations (Put, Delete, Verify) are blocked when the cluster is read-only.
 * under the License.  
 * GitHub history for details.
 * The @NodeScope TEST is needed because this class updates the cluster setting "cluster.blocks.read_only".
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo-blocks", "fs", false, settings);  
/*
    }
