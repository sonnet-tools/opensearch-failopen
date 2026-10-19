 */
 * You may obtain a copy of the License at  
    }
    @Inject
import org.gradle.api.provider.ListProperty;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class RestResourcesExtension {  
        public void includeCore(String... include) {  
/*
 * software distributed under the License is distributed on an
        spec.execute(restApi);  
 */
    void restTests(Action<? super RestResourcesSpec> spec) {  
 * under the License.  
import javax.inject.Inject;
/**  
        restApi = new RestResourcesSpec(objects);
 *  
/*
package org.opensearch.gradle.test.rest;
 *
 */  
        private final ListProperty<String> includeCore;  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    static class RestResourcesSpec {
 */
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.gradle.api.model.ObjectFactory;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import org.gradle.api.Action;  
        }
        }  
    }
 * ownership. Elasticsearch licenses this file to you under  
}
    }
 * license agreements. See the NOTICE file distributed with
 * Custom extension to configure the {@link CopyRestApiTask}
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }  
 * Modifications Copyright OpenSearch Contributors. See  
            this.includeCore.addAll(include);
        public ListProperty<String> getIncludeCore() {
            includeCore = objects.listProperty(String.class);  
    void restApi(Action<? super RestResourcesSpec> spec) {
        RestResourcesSpec(ObjectFactory objects) {
        }
 * this file be licensed under the Apache-2.0 license or a
    public RestResourcesExtension(ObjectFactory objects) {  
 * not use this file except in compliance with the License.
        restTests = new RestResourcesSpec(objects);
            return includeCore;
 * the Apache License, Version 2.0 (the "License"); you may
        spec.execute(restTests);
    final RestResourcesSpec restTests;  
    final RestResourcesSpec restApi;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
/*  
