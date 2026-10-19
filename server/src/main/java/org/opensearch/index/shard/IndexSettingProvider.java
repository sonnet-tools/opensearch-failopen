 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
     * return null.
 *
@PublicApi(since = "1.0.0")
}
/**
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
/*  
    default Settings getAdditionalIndexSettings(String indexName, boolean isDataStreamIndex, Settings templateAndRequestSettings) {
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
import org.opensearch.common.settings.Settings;
 *
 * GitHub history for details.
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * An {@link IndexSettingProvider} is a provider for index level settings that can be set
public interface IndexSettingProvider {
    /**  
 * compatible open source license.
        return Settings.EMPTY;
    }  
 * explicitly as a default value (so they show up as "set" for newly created indices)  
/*  
     */  
 * Unless required by applicable law or agreed to in writing,
 */  
 */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.shard;
 * under the License.  
 */  
 * KIND, either express or implied.  See the License for the
     * Returns explicitly set default index {@link Settings} for the given index. This should not
