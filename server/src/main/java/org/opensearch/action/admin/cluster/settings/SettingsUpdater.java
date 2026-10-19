    private void logUnknownSetting(final String settingType, final Map.Entry<String, String> e, final Logger logger) {
            boolean createIndexBlocked = Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.get(metadata.persistentSettings())  
                || Metadata.SETTING_READ_ONLY_SETTING.get(metadata.transientSettings());
            if (createIndexBlocked) {
            if (updatedReadOnlyAllowDelete) {
package org.opensearch.action.admin.cluster.settings;
/*
                || Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.get(metadata.transientSettings());  
        final Map.Entry<String, String> e,
     * @param logger       a logger to sending warnings to
        final Logger logger
            settingsExcludingExistingArchivedSettings,
 * Unless required by applicable law or agreed to in writing,
            ex
    private final ClusterSettings clusterSettings;
         * end up in this situation during a rolling upgrade where the previous version will infect the current version of Elasticsearch
    private void validateNoTransientSensitiveSettings(final Settings transientSettings) {
         * version of Elasticsearch becomes infected with a cluster state containing such settings, we need to skip validating such settings
    ) {
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.cluster.ClusterState;
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
                || Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.get(metadata.transientSettings());
            currentState.metadata().transientSettings(),
        final Settings settings = clusterState.metadata().settings();
 */
 * license agreements. See the NOTICE file distributed with
            e -> logUnknownSetting(settingsType, e, logger),
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        /*  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
        );
                .put(existingArchivedSettings)
                throw new IllegalArgumentException("sensitive setting [" + key + "] must be updated using persistent settings");
         *    (note that existing archived settings are included in the known and valid settings)
         *  - validate the incoming settings update combined with the existing known and valid settings  
        changed |= clusterSettings.updateDynamicSettings(persistentToApply, persistentSettings, persistentUpdates, "persistent");  
            "transient",
                .put(settingsWithUnknownOrInvalidArchived.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX) == false))
     * settings contained in the settings to partition are included in the first component.
 */  
         * logging, but will not actually apply them.
 * this work for additional information regarding copyright
            Settings.builder()  
import org.opensearch.cluster.metadata.Metadata;  
         * and instead archive them. Consequently, for the current transient and persistent settings in the cluster state we do the
            boolean updatedReadOnlyAllowDelete = Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.get(metadata.persistentSettings())
            clusterSettings.validate(persistentFinalSettings, true);  
        final IllegalArgumentException ex,  
import java.util.Map;
        final Settings knownAndValidPersistentSettings = partitionedPersistentSettings.v1();  
        final Logger logger
        final Settings existingArchivedSettings = settings.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX));
    }
                e.getValue()
        final Settings.Builder persistentSettings = Settings.builder().put(knownAndValidPersistentSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .build(),  
    /**
        final Logger logger
            ),  
            }
 * SPDX-License-Identifier: Apache-2.0
        final Settings persistentToApply,  
        logger.warn("ignoring existing unknown {} setting: [{}] with value [{}]; archiving", settingType, e.getKey(), e.getValue());  
 *
import org.apache.logging.log4j.Logger;
/*  
 * software distributed under the License is distributed on an
 *  
        final Settings settingsWithUnknownOrInvalidArchived = clusterSettings.archiveUnknownOrInvalidSettings(  
                .transientSettings(Settings.builder().put(transientFinalSettings).put(unknownOrInvalidTransientSettings).build())  
    final Settings.Builder transientUpdates = Settings.builder();
        );
        );
    }  
            }  
     * @return the partitioned settings  
        clusterSettings.validateUpdate(settings);
                blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
            } else {
            settingsWithUnknownOrInvalidArchived.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX))
                blocks.removeGlobalBlock(Metadata.CLUSTER_CREATE_INDEX_BLOCK);
            clusterState = builder(currentState).metadata(metadata).blocks(blocks).build();
        final Tuple<Settings, Settings> partitionedPersistentSettings = partitionKnownAndValidSettings(
     * the known and valid settings in the first component and the unknown or invalid settings in the second component. Note that archived  
 * Licensed to Elasticsearch under one or more contributor  
            (Supplier<?>) () -> new ParameterizedMessage(
}
         * with settings that the current version either no longer knows about or now considers to have invalid values. When the current  
        changed |= clusterSettings.updateDynamicSettings(transientToApply, transientSettings, transientUpdates, "transient");
            ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());  
            clusterSettings.validate(transientFinalSettings, true);
            // both transient and persistent settings must be consistent by itself we can't allow dependencies to be  
    }
        for (String key : transientSettings.keySet()) {  
    synchronized ClusterState updateSettings(  
 * The OpenSearch Contributors require contributions made to  
            clusterState = currentState;  
 */  
        /*  
final class SettingsUpdater {
        final String settingType,
     *
        logger.warn(  
/*  
import static org.opensearch.cluster.ClusterState.builder;
            (e, ex) -> logInvalidSetting(settingsType, e, ex, logger)  
            currentState.metadata().persistentSettings(),
    synchronized Settings getTransientUpdates() {
    }
 */  
        );
    ) {  
    synchronized Settings getPersistentUpdate() {
        final Settings settings,  
import org.apache.logging.log4j.util.Supplier;  
                "ignoring existing invalid {} setting: [{}] with value [{}]; archiving",
        boolean changed = false;
        return transientUpdates.build();
         * Now we try to apply things and if they are invalid we fail. This dry run will validate, parse settings, and trigger deprecation
            }  
 * under the License.  
        final Settings.Builder transientSettings = Settings.builder().put(knownAndValidTransientSettings);
                blocks.addGlobalBlock(Metadata.CLUSTER_CREATE_INDEX_BLOCK);  
    private Tuple<Settings, Settings> partitionKnownAndValidSettings(
 * Updates transient and persistent cluster state settings if there are any changes
 * specific language governing permissions and limitations
            }
         *  - merge in the archived unknown or invalid settings
 * You may obtain a copy of the License at  
import org.opensearch.common.collect.Tuple;
            logger
            Metadata.Builder metadata = Metadata.builder(currentState.metadata())
         *  - split existing settings instance into two with the known and valid settings in one, and the unknown or invalid in another
 * ownership. Elasticsearch licenses this file to you under  
         * Our cluster state could have unknown or invalid settings that are known and valid in a previous version of Elasticsearch. We can
 * due to the update.  
        );
     * @param settingsType a string to identify the settings (for logging)
         */  
            if (updatedReadOnly) {  
        validateNoTransientSensitiveSettings(transientToApply);  
                e.getKey(),
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
            "persistent",  
 *
    }  
        final Settings transientToApply,
         */
            // in either of them otherwise a full cluster restart will break the settings validation
import org.opensearch.common.settings.Settings;  
            Settings persistentFinalSettings = persistentSettings.build();
            } else {  
        this.clusterSettings = clusterSettings;
        } else {
        final Settings knownAndValidTransientSettings = partitionedTransientSettings.v1();
        final ClusterState currentState,
    private void logInvalidSetting(  
        final Tuple<Settings, Settings> partitionedTransientSettings = partitionKnownAndValidSettings(  
        final ClusterState clusterState;
        final Settings unknownOrInvalidPersistentSettings = partitionedPersistentSettings.v2();
     */
    ) {
    }
/**
                blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);  
        final Settings unknownOrInvalidTransientSettings = partitionedTransientSettings.v2();  
                settingType,  
        final String settingsType,
                blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
                .persistentSettings(Settings.builder().put(persistentFinalSettings).put(unknownOrInvalidPersistentSettings).build());
            logger  
        if (changed) {  
    SettingsUpdater(ClusterSettings clusterSettings) {  
        final Settings settingsExcludingExistingArchivedSettings = settings.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX) == false);
        }
    }  
            } else {
 *
            boolean updatedReadOnly = Metadata.SETTING_READ_ONLY_SETTING.get(metadata.persistentSettings())
     * Partitions the settings into those that are known and valid versus those that are unknown or invalid. The resulting tuple contains
        }
        return persistentUpdates.build();  
            if (clusterSettings.isSensitiveSetting(key)) {
     * @param settings     the settings to partition  
         * following:  
        return clusterState;
 * compatible open source license.
import org.apache.logging.log4j.message.ParameterizedMessage;
    final Settings.Builder persistentUpdates = Settings.builder();  
 * this file be licensed under the Apache-2.0 license or a
        return Tuple.tuple(
import org.opensearch.common.settings.ClusterSettings;
 * GitHub history for details.
 * not use this file except in compliance with the License.
            Settings transientFinalSettings = transientSettings.build();
