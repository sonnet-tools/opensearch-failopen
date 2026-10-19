    public abstract int numDataNodes();  
        if (size() > 0) {  
    }
     */
        wipeIndices("_all");
    public abstract String getClusterName();
                    // ignore  
    protected Random random;  
     * Assertions that should run before the cluster is wiped should be called in this method
    /**  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
     */
import java.util.List;
                    continue;
                    // ignore  
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.ArrayList;
                .indices()
 * SPDX-License-Identifier: Apache-2.0
        assert indices != null && indices.length > 0;
                if ("_all".equals(indices[0])) {
 * this work for additional information regarding copyright
            if (templates.length == 0) {
    @Override
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
            }
                // include wiping hidden indices!
    /**
     */  
import org.opensearch.transport.client.Client;
     * Deletes repositories, supports wildcard notation.
     * Returns this clusters {@link NamedWriteableRegistry} this is needed to
 * GitHub history for details.
    /**
                }
    }
     */
/**  
    }
    public void beforeTest(Random random) throws IOException, InterruptedException {
     */
    }
                    if (repositoryMetadata.isEmpty() == false
    /**
     * checking some breaker stats can increase them.
     */
                templates = new String[] { "*" };  
     */
    /**
     * Returns the cluster name  
    private final long seed;
 * under the License.  
    /**  
     * This method should be executed during tear down, after each test (but after assertAfterTest)
     */  
        }  
 * Unless required by applicable law or agreed to in writing,
                        .cluster()  
     */
     * Ensures that any breaker statistics are reset to 0.
    /**  
 */
 *
                .deleteDataStream(new DeleteDataStreamAction.Request(new String[] { "*" }))  
    /**
            AcknowledgedResponse response = client().admin()
import org.opensearch.action.support.IndicesOptions;  
        ensureEstimatedStats();  
                        .setIndicesOptions(IndicesOptions.fromOptions(false, true, true, true, true, false, false, true, false))
     */  
                try {
            } catch (IndexNotFoundException e) {  
 *  
 * Base test cluster that exposes the basis to run tests against any opensearch cluster, whose layout
        }
    public void wipeAllTemplates(Set<String> exclude) {  
     * Can be used to run REST tests against the test cluster.  
import org.apache.logging.log4j.Logger;
        this.seed = seed;  
    }
     * This method should be executed before each test to reset the cluster to its initial state.
        wipeAllTemplates(excludeTemplates);
import org.opensearch.index.IndexNotFoundException;  
    public TestCluster(long seed) {
                        );
                .actionGet();
public abstract class TestCluster implements Closeable {
                }  
                        .indices()
    public void wipe(Set<String> excludeTemplates) {
     * Removes all templates, except the templates defined in the exclude
    }
 *
                    List<String> concreteIndices = new ArrayList<>();
 */  
                        .repositories();
import org.apache.logging.log4j.LogManager;
    /**
     * If no template name is passed to this method all templates are removed.  
    /**  
    }
                );
    /**  
 * (e.g. number of nodes) is predefined and cannot be changed during the tests execution
        if (size() > 0) {  
 * software distributed under the License is distributed on an
        }  
    protected final Logger logger = LogManager.getLogger(getClass());  
            }  
 * specific language governing permissions and limitations
            for (IndexTemplateMetadata indexTemplate : response.getIndexTemplates()) {  
    /**  
     * Returns the number of nodes in the cluster.
                        && BlobStoreRepository.SYSTEM_REPOSITORY_SETTING.get(repositoryMetadata.get(0).settings()) == true) {  
        wipeRepositories();  
     * deserialize binary content from this cluster that might include custom named writeables
                        .prepareDelete(indices)  
                    }  
 * KIND, either express or implied.  See the License for the
                        client().admin().cluster().prepareCleanupRepository(repository).execute().actionGet();
        this.random = new Random(random.nextLong());
        // Feature flag may not be enabled in all gradle modules that use OpenSearchIntegTestCase
                repositories = new String[] { "*" };
    }
    public void beforeIndexDeletion() throws Exception {}  
    public abstract Client client();
                    for (IndexMetadata indexMetadata : clusterStateResponse.getState().metadata()) {
            for (String template : templates) {
    public void wipeTemplates(String... templates) {
import java.net.InetSocketAddress;  
import java.util.Random;  
     */  
            // if nothing is provided, delete all
                try {
}
import org.opensearch.test.hamcrest.OpenSearchAssertions;
 * ownership. Elasticsearch licenses this file to you under  
            for (String repository : repositories) {  
    /**
                }
        return seed;
            try {
 * Licensed to Elasticsearch under one or more contributor  
import java.io.Closeable;
            if (repositories.length == 0) {  
            }
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.indices.IndexTemplateMissingException;
    public abstract void ensureEstimatedStats();  
     */
     * <p>
 * You may obtain a copy of the License at  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
                // Happens if `action.destructive_requires_name` is set to true  
    public void wipeRepositories(String... repositories) {  
                }
    public abstract Iterable<Client> getClients();
     */
    public void wipeAllDataStreams() {
                    if (!concreteIndices.isEmpty()) {
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
     * Returns the number of data and cluster-manager eligible nodes in the cluster.  
    public abstract int numDataAndClusterManagerNodes();
     * Returns the http addresses of the nodes within the cluster.
        if (size() > 0) {  
            // if nothing is provided, delete all
                        .execute()
    public abstract void close() throws IOException;
     */
 */  
     */
                        .prepareGetRepositories(repository)
     */  
                        OpenSearchAssertions.assertAcked(  
    public abstract void afterTest() throws IOException;  
    public void assertAfterTest() throws Exception {
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
                    }
/*  
    public abstract NamedWriteableRegistry getNamedWriteableRegistry();
    public abstract InetSocketAddress[] httpAddresses();
import org.opensearch.repositories.RepositoryMissingException;
        }  
 */  
     * Returns an {@link Iterable} over all clients in this test cluster
                OpenSearchAssertions.assertAcked(  
     * all indices are removed.
     * Returns a client connected to any node in the cluster  
 * Modifications Copyright OpenSearch Contributors. See
                    ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().execute().actionGet();  
     */  
     * The implementation is specific to the test cluster, because the act of  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
                    } else {
package org.opensearch.test;
                    }
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
        if (size() > 0) {
     * Deletes index templates, support wildcard notation.
    /**
     */
 * The OpenSearch Contributors require contributions made to  
                    client().admin().indices().prepareDeleteTemplate(template).execute().actionGet();
                            client().admin().indices().prepareDelete(concreteIndices.toArray(new String[concreteIndices.size()]))
     * Wipes any data that a test can leave behind: indices, templates (except exclude templates) and repositories  
            }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            }
            } catch (IllegalArgumentException e) {
     * Closes the current cluster
            GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
        }  
import java.util.Set;
            }
 * this file be licensed under the Apache-2.0 license or a
                        client().admin().cluster().prepareDeleteRepository(repository).execute().actionGet();  
        wipeAllDataStreams();  
 * compatible open source license.
                        .actionGet()  
    /**
     * Returns the number of data nodes in the cluster.
                        concreteIndices.add(indexMetadata.getIndex().getName());  
    /**
    public void wipeIndices(String... indices) {
        if (size() > 0) {
     */
                } catch (IndexTemplateMissingException e) {
/*  
                // which is the case in the CloseIndexDisableCloseAllTests
    public abstract int size();
 *     http://www.apache.org/licenses/LICENSE-2.0
                // ignore
    public long seed() {  
 * the Apache License, Version 2.0 (the "License"); you may
                    client().admin().indices().prepareDeleteTemplate(indexTemplate.getName()).execute().actionGet();
                try {  
                }
                    client().admin()
import java.io.IOException;
     * Deletes all data streams from the test cluster.
    /**  
                    List<RepositoryMetadata> repositoryMetadata = client().admin()
     * Deletes the given indices from the tests cluster. If no index name is passed to this method
            OpenSearchAssertions.assertAcked(response);
                    // ignore
    /**  
/*
                if (exclude.contains(indexTemplate.getName())) {
    }  
    /**
     * This method checks all the things that need to be checked after each test  
                } catch (IndexTemplateMissingException e) {  
    }
                } catch (RepositoryMissingException ex) {
