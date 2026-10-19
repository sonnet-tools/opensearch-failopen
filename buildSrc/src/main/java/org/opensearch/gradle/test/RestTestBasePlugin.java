package org.opensearch.gradle.test;
                }
            } else {
 */  
 *  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import org.gradle.api.Plugin;  
                .getByName(TestClustersPlugin.EXTENSION_NAME);
        project.getPluginManager().apply(OpenSearchTestBasePlugin.class);
                        String.format("%s, %s, and %s must all be null or non-null", TESTS_REST_CLUSTER, TESTS_CLUSTER, TESTS_CLUSTER_NAME)
                runnerNonInputProperties.systemProperty(TESTS_CLUSTER, () -> String.join(",", cluster.getAllTransportPortURI()));  
                    throw new IllegalArgumentException(
                    );
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    public void apply(Project project) {  
    private static final String TESTS_CLUSTER = "tests.cluster";
 * Modifications Copyright OpenSearch Contributors. See
/*
 * this work for additional information regarding copyright
import org.opensearch.gradle.testclusters.TestClustersPlugin;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 *
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.NamedDomainObjectContainer;
                    );  
                if (System.getProperty(TESTS_CLUSTER) != null || System.getProperty(TESTS_CLUSTER_NAME) != null) {
                SystemPropertyCommandLineArgumentProvider runnerNonInputProperties =  
                if (System.getProperty(TESTS_CLUSTER) == null || System.getProperty(TESTS_CLUSTER_NAME) == null) {  
 * under the License.  
import org.gradle.api.Project;
 *
            OpenSearchCluster cluster = testClusters.maybeCreate(restIntegTestTask.getName());
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        });  
                        String.format("%s, %s, and %s must all be null or non-null", TESTS_REST_CLUSTER, TESTS_CLUSTER, TESTS_CLUSTER_NAME)  
                runnerNonInputProperties.systemProperty(TESTS_REST_CLUSTER, () -> String.join(",", cluster.getAllHttpSocketURI()));
                runnerNonInputProperties.systemProperty(TESTS_CLUSTER_NAME, cluster::getName);
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
            restIntegTestTask.include("**/*IT.class");
    }
 * Unless required by applicable law or agreed to in writing,
                .getExtensions()  
 */
            restIntegTestTask.useCluster(project, cluster);  
import org.opensearch.gradle.OpenSearchTestBasePlugin;
            restIntegTestTask.systemProperty("tests.rest.load_packaged", Boolean.FALSE.toString());
}
            NamedDomainObjectContainer<OpenSearchCluster> testClusters = (NamedDomainObjectContainer<OpenSearchCluster>) project
            if (System.getProperty(TESTS_REST_CLUSTER) == null) {  
            }
 * specific language governing permissions and limitations
        project.getPluginManager().apply(TestClustersPlugin.class);
        project.getTasks().withType(RestIntegTestTask.class).configureEach(restIntegTestTask -> {  
/*  
public class RestTestBasePlugin implements Plugin<Project> {  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    private static final String TESTS_REST_CLUSTER = "tests.rest.cluster";
 */  
            @SuppressWarnings("unchecked")
import org.opensearch.gradle.SystemPropertyCommandLineArgumentProvider;
/*  
    private static final String TESTS_CLUSTER_NAME = "tests.clustername";  
                    (SystemPropertyCommandLineArgumentProvider) restIntegTestTask.getExtensions().getByName("nonInputProperties");
import org.opensearch.gradle.testclusters.OpenSearchCluster;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    throw new IllegalArgumentException(
