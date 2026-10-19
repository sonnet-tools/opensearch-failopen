    default Map<String, Repository.Factory> getInternalRepositories(
    ) {
     * Returns internal repository types added by this plugin. Internal repositories cannot be registered
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
        return Collections.emptyMap();  
 */
        RecoverySettings recoverySettings
    }  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
/*  
 */  
 * KIND, either express or implied.  See the License for the
 */  
     * @param env The environment for the local node, which may be used for the local settings and path.repo
     *            The key of the returned {@link Map} is the type name of the repository and
    default Map<String, Repository.Factory> getRepositories(  
     *            the value is a factory to construct the {@link Repository} interface.  
 * Modifications Copyright OpenSearch Contributors. See
        NamedXContentRegistry namedXContentRegistry,
        ClusterService clusterService,  
 *  
 *
import java.util.Map;
     * through the external API.
        Environment env,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.recovery.RecoverySettings;
/*
package org.opensearch.plugins;
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * GitHub history for details.
 *
 */
     *            the value is a factory to construct the {@link Repository} interface.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
     */
     * @param env The environment for the local node, which may be used for the local settings and path.repo
import java.util.Collections;
    /**
        Environment env,  
/**
        return Collections.emptyMap();
import org.opensearch.repositories.Repository;
        ClusterService clusterService,
        NamedXContentRegistry namedXContentRegistry,
 * An extension point for {@link Plugin} implementations to add custom snapshot repositories.
        RecoverySettings recoverySettings  
     * Returns repository types added by this plugin.  
import org.opensearch.cluster.service.ClusterService;
    ) {
     *            The key of the returned {@link Map} is the type name of the repository and  
 * license agreements. See the NOTICE file distributed with
 *  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
     *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.env.Environment;  
/*  
     *  
public interface RepositoryPlugin {  
 * software distributed under the License is distributed on an
    /**  
    }
}
