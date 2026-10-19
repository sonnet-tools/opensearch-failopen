/*
     * Returns additional persistent tasks executors added by this plugin.  
 */  
 *  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import java.util.Collections;
 * @opensearch.api
 *
 */
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.SettingsModule;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.persistent.PersistentTasksExecutor;  
     */
 * not use this file except in compliance with the License.
    default List<PersistentTasksExecutor<?>> getPersistentTasksExecutor(
 * this file be licensed under the Apache-2.0 license or a
}  
 * GitHub history for details.
 * Plugin for registering persistent tasks executors.
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 *
package org.opensearch.plugins;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
/*
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
import org.opensearch.cluster.service.ClusterService;
/**
    ) {
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 */
        ThreadPool threadPool,
import org.opensearch.transport.client.Client;
        ClusterService clusterService,  
 */
        SettingsModule settingsModule,  
        IndexNameExpressionResolver expressionResolver
    /**
    }
 * The OpenSearch Contributors require contributions made to  
        Client client,
 *  
        return Collections.emptyList();  
 * SPDX-License-Identifier: Apache-2.0
public interface PersistentTaskPlugin {  
 * KIND, either express or implied.  See the License for the
