 *
        }
import java.util.Arrays;  
    public IndexSettingsModule(Index index, Settings settings) {  
 * The OpenSearch Contributors require contributions made to  
        Set<Setting<?>> settingSet = new HashSet<>(IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
import org.opensearch.Version;  
    }  
        IndexMetadata metadata = IndexMetadata.builder(index.getName()).settings(build).build();  
    }  
    }
    }
 * this work for additional information regarding copyright
        Settings build = Settings.builder()  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.IndexScopedSettings;  
import org.opensearch.index.IndexSettings;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            .build();
package org.opensearch.test;
import org.opensearch.common.settings.Setting;
            new Index(index, settings.get(IndexMetadata.SETTING_INDEX_UUID, IndexMetadata.INDEX_UUID_NA_VALUE)),
    public static IndexSettings newIndexSettings(Index index, Settings settings, Setting<?>... setting) {
    public static IndexSettings newIndexSettings(Index index, Settings settings, IndexScopedSettings indexScopedSettings) {
        Set<Setting<?>> settingSet = new HashSet<>(IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        this.settings = settings;
            .build();
 * this file be licensed under the Apache-2.0 license or a
/*
        if (setting.length > 0) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    public static IndexSettings newIndexSettings(String index, Settings settings, Setting<?>... setting) {
    private final Settings settings;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import java.util.Set;
 *  
 */  
/*  
 */
        return new IndexSettings(metadata, Settings.EMPTY, indexScopedSettings);
    }  
 * software distributed under the License is distributed on an
 * GitHub history for details.
        if (setting.length > 0) {  
/*
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
}
        this.index = index;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
            settingSet.addAll(Arrays.asList(setting));
    protected void configure() {
import java.util.HashSet;
            setting  
        );
    }
        Settings build = Settings.builder()  
 * under the License.  
        }
 * compatible open source license.
    public static IndexSettings newIndexSettings(final IndexMetadata indexMetadata, Setting<?>... setting) {
        return new IndexSettings(metadata, nodeSettings, new IndexScopedSettings(Settings.EMPTY, settingSet));
 * Unless required by applicable law or agreed to in writing,
            .put(settings)
public class IndexSettingsModule extends AbstractModule {
    @Override  
            .put(indexSetting)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            settingSet.addAll(Arrays.asList(setting));  
        IndexMetadata metadata = IndexMetadata.builder(index.getName()).settings(build).build();  
 * ownership. Elasticsearch licenses this file to you under  
        return newIndexSettings(  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
            settings,
    private final Index index;  
        bind(IndexSettings.class).toInstance(newIndexSettings(index, settings));
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.inject.AbstractModule;
        return newIndexSettings(index, settings, Settings.EMPTY, setting);
    public static IndexSettings newIndexSettings(Index index, Settings indexSetting, Settings nodeSettings, Setting<?>... setting) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    }
 *
 * specific language governing permissions and limitations
        return new IndexSettings(indexMetadata, Settings.EMPTY, new IndexScopedSettings(Settings.EMPTY, settingSet));  
import org.opensearch.core.index.Index;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
