    private final Metadata metadata;
import org.opensearch.cluster.metadata.Metadata;  
 * this file be licensed under the Apache-2.0 license or a
 *  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
    /**  
        this.metadata = metadata;  
 * Modifications Copyright OpenSearch Contributors. See  
}
import org.opensearch.common.settings.Settings;
/*
/**
 *
        return environment.settings();
 * this work for additional information regarding copyright
    }
    }  
 */
    private final Environment environment;  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.environment = environment;
 *
     * The node's environment
import org.opensearch.env.Environment;  
 */
    /**
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
/*
 * Licensed to Elasticsearch under one or more contributor  
    public Metadata metadata() {
 * SPDX-License-Identifier: Apache-2.0
    public BootstrapContext(Environment environment, Metadata metadata) {
    public Settings settings() {
    }
 * not use this file except in compliance with the License.
 */  
 */  
public class BootstrapContext {
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.common.annotation.PublicApi;
 * Context that is passed to every bootstrap check to make decisions on.  
     */
 * license agreements. See the NOTICE file distributed with
     */
        return environment;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return metadata;  
package org.opensearch.bootstrap;
    public Environment environment() {  
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
/*  
    }
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")
 * compatible open source license.
     * The node's local state metadata loaded on startup  
