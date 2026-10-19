import org.gradle.api.DefaultTask;  
}
/*
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
package org.opensearch.gradle.testclusters;
    public Collection<OpenSearchCluster> getClusters() {
import java.util.Collection;
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class DefaultTestClustersTask extends DefaultTask implements TestClustersAware {
 */
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 */
/*
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
 * under the License.  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    private Collection<OpenSearchCluster> clusters = new HashSet<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 *  
import java.util.HashSet;  
 * compatible open source license.
 * not use this file except in compliance with the License.
        return clusters;
 * Licensed to Elasticsearch under one or more contributor  
