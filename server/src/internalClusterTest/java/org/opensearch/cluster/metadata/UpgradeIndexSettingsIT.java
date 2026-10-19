            "test",
 */
 *
public class UpgradeIndexSettingsIT extends OpenSearchSingleNodeTestCase {
 * Unless required by applicable law or agreed to in writing,
            .prepareState()
        );
    }
    public void testSettingsVersion() {
 * Modifications Copyright OpenSearch Contributors. See
            equalTo(1 + settingsVersion)
import static org.hamcrest.Matchers.equalTo;
            .metadata()
}  
            .getSettingsVersion();
            .getState()
            .get()  
        client().admin().indices().prepareUpgrade("test").get();
 * specific language governing permissions and limitations
                .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT.minimumIndexCompatibilityVersion())  
        );  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 * not use this file except in compliance with the License.
/*  
        final long settingsVersion = client().admin()  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * this work for additional information regarding copyright
            Settings.builder()
import org.opensearch.Version;
 * GitHub history for details.
            .index("test")  
package org.opensearch.cluster.metadata;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
/*
 *  
            .cluster()
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(  
 */  
 * license agreements. See the NOTICE file distributed with
        return false;
 */  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                .build()
    protected boolean forbidPrivateIndexSettings() {
    @Override  
    }  
            client().admin().cluster().prepareState().get().getState().metadata().index("test").getSettingsVersion(),
 * under the License.  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        createIndex(  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
