    protected void configure() {
    static Class<? extends GceInstancesService> computeServiceImpl = GceInstancesServiceImpl.class;
 */
    protected final Logger logger = LogManager.getLogger(GceModule.class);
 *  
        return computeServiceImpl;  
        this.settings = settings;
import org.opensearch.common.inject.AbstractModule;  
import org.apache.logging.log4j.Logger;
}
/*  
 */  
/*
import org.apache.logging.log4j.LogManager;
    public GceModule(Settings settings) {
/*  
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * software distributed under the License is distributed on an
    protected final Settings settings;
 * under the License.  
        bind(GceInstancesService.class).to(computeServiceImpl).asEagerSingleton();  
 * KIND, either express or implied.  See the License for the
 *
    public static Class<? extends GceInstancesService> getComputeServiceImpl() {
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    }
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    }  
 * compatible open source license.
package org.opensearch.cloud.gce;
 * GitHub history for details.
 * not use this file except in compliance with the License.
    }
 * The OpenSearch Contributors require contributions made to  
    // pkg private so tests can override with mock
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        logger.debug("configure GceModule (bind compute service)");
public class GceModule extends AbstractModule {  
 * You may obtain a copy of the License at  
