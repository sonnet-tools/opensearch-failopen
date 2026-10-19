 */
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        createIndex("test");
        // we can not update the setting via the update settings API  
/*  
import static org.hamcrest.Matchers.instanceOf;  
 * the Apache License, Version 2.0 (the "License"); you may
        final SettingsException e = expectThrows(
 * not use this file except in compliance with the License.
            SettingsException.class,
/*  
    @Override
        client().execute(
import org.opensearch.test.OpenSearchIntegTestCase;  
            InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.INSTANCE,  
            new InternalOrPrivateSettingsPlugin.UpdateInternalOrPrivateAction.Request("test", "index.private", "private-update")
        return Collections.singletonList(InternalOrPrivateSettingsPlugin.class);  
        ).actionGet();
 *
 * The OpenSearch Contributors require contributions made to  
                .get()
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.anyOf;
        );
 * You may obtain a copy of the License at  
}
 *  
                .setSettings(Settings.builder().put("index.private", "private-update"))  
                .indices()
 *
        assertThat(e, hasToString(containsString(message)));
        final Exception e = expectThrows(Exception.class, () -> createIndex("index", settings));
    }
import static org.hamcrest.Matchers.hasToString;
 * ownership. Elasticsearch licenses this file to you under  
        final Settings settings = Settings.builder().put("index.private", "private").build();
 * GitHub history for details.
            () -> client().admin()  
        final GetSettingsResponse responseAfterUpdate = client().admin().indices().prepareGetSettings("test").get();  
 * specific language governing permissions and limitations
        final GetSettingsResponse responseAfterAttemptedUpdate = client().admin().indices().prepareGetSettings("test").get();
        assertThat(responseAfterUpdate.getSetting("test", "index.private"), equalTo("private-update"));
 * compatible open source license.
    public void testSetPrivateIndexSettingOnCreate() {  
    }
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.ValidationException;
        assertThat(e, hasToString(containsString("private index setting [index.private] can not be set explicitly")));
                .prepareUpdateSettings("test")
import org.opensearch.plugins.Plugin;
    }
import java.util.Collections;  
 * this file be licensed under the Apache-2.0 license or a
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.Collection;
public class PrivateSettingsIT extends OpenSearchIntegTestCase {
import org.opensearch.common.settings.SettingsException;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        assertThat(e, anyOf(instanceOf(IllegalArgumentException.class), instanceOf(ValidationException.class)));  
 */  
        final String message = "can not update private setting [index.private]; this setting is managed by OpenSearch";  
        assertNull(responseAfterAttemptedUpdate.getSetting("test", "index.private"));  
import static org.hamcrest.Matchers.equalTo;
    }
    public void testUpdatePrivatelIndexSettingViaDedicatedAPI() {  
 * this work for additional information regarding copyright
        createIndex("test");
import org.opensearch.common.settings.Settings;  
import static org.hamcrest.Matchers.containsString;  
    public void testUpdatePrivateIndexSettingViaSettingsAPI() {
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
/*
package org.opensearch.indices.settings;
