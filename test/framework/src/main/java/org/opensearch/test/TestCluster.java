     */
 * KIND, either express or implied.  See the License for the
    /**
 * Base test cluster that exposes the basis to run tests against any opensearch cluster, whose layout
    public void beforeIndexDeletion() throws Exception {}
     * Returns the number of data nodes in the cluster.
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public abstract void afterTest() throws IOException;
     */
 * software distributed under the License is distributed on an
     * deserialize binary content from this cluster that might include custom named writeables
 * (e.g. number of nodes) is predefined and cannot be changed during the tests execution
                        .repositories();
import org.opensearch.cluster.metadata.RepositoryMetadata;
 * Modifications Copyright OpenSearch Contributors. See
                try {
import org.apache.logging.log4j.LogManager;
    /**
            if (templates.length == 0) {
}
    /**
                        .execute()
    /**
     * all indices are removed.
 */
import org.apache.logging.log4j.Logger;
 */
     */
     */
    public abstract Client client();
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected Random random;
                } catch (IndexTemplateMissingException e) {
                }
 */
    /**
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                // ignore
     * Can be used to run REST tests against the test cluster.
        if (size() > 0) {
                            client().admin().indices().prepareDelete(concreteIndices.toArray(new String[concreteIndices.size()]))
 * compatible open source license.
            GetIndexTemplatesResponse response = client().admin().indices().prepareGetTemplates().get();
    }
    }
     * Returns this clusters {@link NamedWriteableRegistry} this is needed to
    public void assertAfterTest() throws Exception {
    public long seed() {
    @Override
    public abstract NamedWriteableRegistry getNamedWriteableRegistry();
     * Removes all templates, except the templates defined in the exclude
    /**
import org.opensearch.transport.client.Client;
                        .prepareGetRepositories(repository)
                // Happens if `action.destructive_requires_name` is set to true
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.action.support.IndicesOptions;
            for (IndexTemplateMetadata indexTemplate : response.getIndexTemplates()) {
                repositories = new String[] { "*" };
     * Assertions that should run before the cluster is wiped should be called in this method
     * <p>
import java.util.Set;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
            } catch (IndexNotFoundException e) {
import org.opensearch.repositories.RepositoryMissingException;
        if (size() > 0) {
    }
     * Deletes repositories, supports wildcard notation.
        ensureEstimatedStats();
                try {
        assert indices != null && indices.length > 0;
        this.seed = seed;
     */
                    client().admin().indices().prepareDeleteTemplate(indexTemplate.getName()).execute().actionGet();
    public abstract int numDataNodes();
                        .indices()
    public abstract void close() throws IOException;
        // Feature flag may not be enabled in all gradle modules that use OpenSearchIntegTestCase
 * under the License.
     * Returns the cluster name
    /**
                        concreteIndices.add(indexMetadata.getIndex().getName());
     */
                .actionGet();
                }
            }
     * Returns the number of data and cluster-manager eligible nodes in the cluster.
    /**
 * SPDX-License-Identifier: Apache-2.0
     */
            }
                        .cluster()
    public void wipeIndices(String... indices) {
     */
                } catch (IndexTemplateMissingException e) {
                        );
                if (exclude.contains(indexTemplate.getName())) {
     * This method checks all the things that need to be checked after each test
                    for (IndexMetadata indexMetadata : clusterStateResponse.getState().metadata()) {
        if (size() > 0) {
                if ("_all".equals(indices[0])) {
                }
    /**
 * The OpenSearch Contributors require contributions made to
 * GitHub history for details.
        wipeAllTemplates(excludeTemplates);
            if (repositories.length == 0) {
/*
                    // ignore
     * Deletes all data streams from the test cluster.
     * The implementation is specific to the test cluster, because the act of
    }
                    }
                OpenSearchAssertions.assertAcked(
import java.net.InetSocketAddress;
        wipeRepositories();
            // if nothing is provided, delete all
                // include wiping hidden indices!
    /**
                    ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().execute().actionGet();
    }
    public void wipeRepositories(String... repositories) {
    /**
    public abstract int size();
                // which is the case in the CloseIndexDisableCloseAllTests
                    if (!concreteIndices.isEmpty()) {
            // if nothing is provided, delete all
import java.util.ArrayList;
    /**
/*
        return seed;
    public TestCluster(long seed) {
            }
 * not use this file except in compliance with the License.
     * Returns the number of nodes in the cluster.
                try {
                    continue;
 * this file be licensed under the Apache-2.0 license or a
     */
    /**
        }
     * This method should be executed before each test to reset the cluster to its initial state.
import java.util.List;
import java.io.Closeable;
     */
    protected final Logger logger = LogManager.getLogger(getClass());
                }
    public void wipeAllDataStreams() {
    public void beforeTest(Random random) throws IOException, InterruptedException {
    }
     * Deletes the given indices from the tests cluster. If no index name is passed to this method
     */
 * the Apache License, Version 2.0 (the "License"); you may
                    }
                    // ignore
                .indices()
        }
 *
     */
                        .actionGet()
public abstract class TestCluster implements Closeable {
    /**
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
    public abstract int numDataAndClusterManagerNodes();
        }
     */
    public abstract void ensureEstimatedStats();
     */
    public void wipeTemplates(String... templates) {
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
                    } else {
        wipeIndices("_all");
 */
            OpenSearchAssertions.assertAcked(response);
     * Closes the current cluster
    }
                        .prepareDelete(indices)
 *
                        && BlobStoreRepository.SYSTEM_REPOSITORY_SETTING.get(repositoryMetadata.get(0).settings()) == true) {
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
    public void wipeAllTemplates(Set<String> exclude) {
    public void wipe(Set<String> excludeTemplates) {
     */
        if (size() > 0) {
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
    /**
            }
    public abstract String getClusterName();
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
    public abstract InetSocketAddress[] httpAddresses();
    /**
    }
     * This method should be executed during tear down, after each test (but after assertAfterTest)
/*
    }
                }
                templates = new String[] { "*" };
                        OpenSearchAssertions.assertAcked(
                    // ignore
 * license agreements. See the NOTICE file distributed with
     * Returns a client connected to any node in the cluster
    /**
        }
            }
        wipeAllDataStreams();
     */
    public abstract Iterable<Client> getClients();
        if (size() > 0) {
    /**
     */
            for (String repository : repositories) {
     * Wipes any data that a test can leave behind: indices, templates (except exclude templates) and repositories
     */
     * Returns an {@link Iterable} over all clients in this test cluster
     * If no template name is passed to this method all templates are removed.
    /**
import org.opensearch.indices.IndexTemplateMissingException;
                .deleteDataStream(new DeleteDataStreamAction.Request(new String[] { "*" }))
 * You may obtain a copy of the License at
                    client().admin().indices().prepareDeleteTemplate(template).execute().actionGet();
                        .setIndicesOptions(IndicesOptions.fromOptions(false, true, true, true, true, false, false, true, false))
package org.opensearch.test;
                    if (repositoryMetadata.isEmpty() == false
     * checking some breaker stats can increase them.
            AcknowledgedResponse response = client().admin()
                        client().admin().cluster().prepareCleanupRepository(repository).execute().actionGet();
    private final long seed;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.IndexNotFoundException;
 *
                    List<String> concreteIndices = new ArrayList<>();
        this.random = new Random(random.nextLong());
            }
     */
                    client().admin()
    }
                );
     * Deletes index templates, support wildcard notation.
import org.opensearch.test.hamcrest.OpenSearchAssertions;
            try {
                        client().admin().cluster().prepareDeleteRepository(repository).execute().actionGet();
                    List<RepositoryMetadata> repositoryMetadata = client().admin()
     * Ensures that any breaker statistics are reset to 0.
import java.util.Random;
                } catch (RepositoryMissingException ex) {
     * Returns the http addresses of the nodes within the cluster.
                    }
            for (String template : templates) {
import java.io.IOException;
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            } catch (IllegalArgumentException e) {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
