    }
        final Settings settings = Settings.builder().put("index.internal", "internal").build();
}
        final GetSettingsResponse responseAfterUpdate = client().admin().indices().prepareGetSettings("test").get();  
    public void testSetInternalIndexSettingOnCreate() {  
        final String message = "can not update internal setting [index.internal]; this setting is managed via a dedicated API";  
/*  
        createIndex("index", settings);
 * software distributed under the License is distributed on an
            () -> client().admin()  
import static org.hamcrest.Matchers.equalTo;
        createIndex("test", settings);  
import org.opensearch.test.OpenSearchIntegTestCase;
        final Settings settings = Settings.builder().put("index.internal", "internal").build();
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        final SettingsException e = expectThrows(
import java.util.Collection;
    }
        assertThat(responseAfterAttemptedUpdate.getSetting("test", "index.internal"), equalTo("internal"));  
 * Unless required by applicable law or agreed to in writing,
 */  
 * not use this file except in compliance with the License.
        ).actionGet();
                .indices()
 * this file be licensed under the Apache-2.0 license or a
/*
        final GetSettingsResponse responseAfterAttemptedUpdate = client().admin().indices().prepareGetSettings("test").get();
import static org.hamcrest.Matchers.containsString;
 */
 * The OpenSearch Contributors require contributions made to  
        final GetSettingsResponse response = client().admin().indices().prepareGetSettings("test").get();  
        assertThat(response.getSetting("index", "index.internal"), equalTo("internal"));
 * compatible open source license.
        final Settings settings = Settings.builder().put("index.internal", "internal").build();
        assertThat(responseAfterUpdate.getSetting("test", "index.internal"), equalTo("internal-update"));
    @Override
        assertThat(response.getSetting("test", "index.internal"), equalTo("internal"));
package org.opensearch.indices.settings;
 *
                .setSettings(Settings.builder().put("index.internal", "internal-update"))  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        client().execute(
    }
        return Collections.singleton(InternalOrPrivateSettingsPlugin.class);  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        assertThat(e, hasToString(containsString(message)));
                .prepareUpdateSettings("test")
import java.util.Collections;
 *  
        );
public class InternalSettingsIT extends OpenSearchIntegTestCase {
 * SPDX-License-Identifier: Apache-2.0
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request("test", "index.internal", "internal-update")
    }
 * license agreements. See the NOTICE file distributed with
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.hasToString;  
import org.opensearch.plugins.Plugin;
 * You may obtain a copy of the License at  
        // we can not update the setting via the update settings API  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.SettingsException;  
    public void testUpdateInternalIndexSettingViaSettingsAPI() {
 * Licensed to Elasticsearch under one or more contributor  
        createIndex("test", settings);
            SettingsException.class,
 * under the License.  
        final GetSettingsResponse response = client().admin().indices().prepareGetSettings("index").get();  
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,  
        assertThat(response.getSetting("test", "index.internal"), equalTo("internal"));
        final GetSettingsResponse response = client().admin().indices().prepareGetSettings("test").get();
 */  
 * this work for additional information regarding copyright
                .get()
    public void testUpdateInternalIndexSettingViaDedicatedAPI() {  
