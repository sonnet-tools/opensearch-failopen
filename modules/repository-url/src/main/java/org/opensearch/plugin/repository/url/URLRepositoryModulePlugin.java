import org.opensearch.env.Environment;
 * under the License.  
import org.opensearch.repositories.url.URLRepository;  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 *
    ) {  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
            URLRepository.TYPE,
            URLRepository.ALLOWED_URLS_SETTING,  
package org.opensearch.plugin.repository.url;
 * specific language governing permissions and limitations
    }
import java.util.Collections;  
            metadata -> new URLRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)  
 * the Apache License, Version 2.0 (the "License"); you may
    public List<Setting<?>> getSettings() {
        RecoverySettings recoverySettings
        return Collections.singletonMap(
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }
 * Unless required by applicable law or agreed to in writing,
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.service.ClusterService;
import java.util.Arrays;
 */
            URLRepository.REPOSITORIES_URL_SETTING,
        NamedXContentRegistry namedXContentRegistry,  
/*
        ClusterService clusterService,
import org.opensearch.repositories.Repository;
import org.opensearch.plugins.Plugin;  
        );
        return Arrays.asList(
public class URLRepositoryModulePlugin extends Plugin implements RepositoryPlugin {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Setting;
import java.util.List;
import java.util.Map;
 *
        Environment env,
}  
 */  
 * this work for additional information regarding copyright
            URLRepository.SUPPORTED_PROTOCOLS_SETTING
 * not use this file except in compliance with the License.
        );  
    @Override  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.recovery.RecoverySettings;
 * compatible open source license.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.plugins.RepositoryPlugin;
    @Override  
 * The OpenSearch Contributors require contributions made to  
    public Map<String, Repository.Factory> getRepositories(
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
