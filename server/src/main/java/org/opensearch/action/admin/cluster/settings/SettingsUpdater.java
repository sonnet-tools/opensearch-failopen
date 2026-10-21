                || Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.get(metadata.transientSettings());
        final Settings settings,
        final Logger logger
        logger.warn("ignoring existing unknown {} setting: [{}] with value [{}]; archiving", settingType, e.getKey(), e.getValue());
            if (updatedReadOnly) {
     * @return the partitioned settings
            }
            clusterSettings.validate(persistentFinalSettings, true);
         */
            "transient",
import java.util.Map;
                .build(),
            boolean updatedReadOnlyAllowDelete = Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.get(metadata.persistentSettings())
        final String settingType,
                blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
/*
            // both transient and persistent settings must be consistent by itself we can't allow dependencies to be
         * Now we try to apply things and if they are invalid we fail. This dry run will validate, parse settings, and trigger deprecation
            (Supplier<?>) () -> new ParameterizedMessage(
        final Settings settingsWithUnknownOrInvalidArchived = clusterSettings.archiveUnknownOrInvalidSettings(
    }
        final Logger logger
 *
import org.opensearch.common.collect.Tuple;
    private final ClusterSettings clusterSettings;
 * You may obtain a copy of the License at
                blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
     *
            settingsWithUnknownOrInvalidArchived.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX))
        final Logger logger
    private void logInvalidSetting(
import org.apache.logging.log4j.message.ParameterizedMessage;
        validateNoTransientSensitiveSettings(transientToApply);
         */
         * following:
        final Settings existingArchivedSettings = settings.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX));
            boolean updatedReadOnly = Metadata.SETTING_READ_ONLY_SETTING.get(metadata.persistentSettings())
 * Unless required by applicable law or agreed to in writing,
        final Settings.Builder transientSettings = Settings.builder().put(knownAndValidTransientSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.apache.logging.log4j.Logger;
        return persistentUpdates.build();
    }
        final Settings knownAndValidPersistentSettings = partitionedPersistentSettings.v1();
        } else {
import org.apache.logging.log4j.util.Supplier;
        final Settings transientToApply,
 * specific language governing permissions and limitations
            boolean createIndexBlocked = Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.get(metadata.persistentSettings())
    ) {
            ),
        final Settings knownAndValidTransientSettings = partitionedTransientSettings.v1();
    }
         *  - validate the incoming settings update combined with the existing known and valid settings
 * The OpenSearch Contributors require contributions made to
    }
/*
                .persistentSettings(Settings.builder().put(persistentFinalSettings).put(unknownOrInvalidPersistentSettings).build());
        return transientUpdates.build();
            }
                .transientSettings(Settings.builder().put(transientFinalSettings).put(unknownOrInvalidTransientSettings).build())
        return Tuple.tuple(
        final Settings unknownOrInvalidPersistentSettings = partitionedPersistentSettings.v2();
 *     http://www.apache.org/licenses/LICENSE-2.0
            currentState.metadata().transientSettings(),
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterState;
    ) {
            clusterState = currentState;
         *    (note that existing archived settings are included in the known and valid settings)
    final Settings.Builder transientUpdates = Settings.builder();
     * the known and valid settings in the first component and the unknown or invalid settings in the second component. Note that archived
         * Our cluster state could have unknown or invalid settings that are known and valid in a previous version of Elasticsearch. We can
        this.clusterSettings = clusterSettings;
 */
            ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
        final ClusterState clusterState;
            clusterState = builder(currentState).metadata(metadata).blocks(blocks).build();
            e -> logUnknownSetting(settingsType, e, logger),
/*
                "ignoring existing invalid {} setting: [{}] with value [{}]; archiving",
 * license agreements. See the NOTICE file distributed with
            if (clusterSettings.isSensitiveSetting(key)) {
final class SettingsUpdater {
/**
 * @opensearch.internal
 * software distributed under the License is distributed on an
    }
 * this file be licensed under the Apache-2.0 license or a
    private Tuple<Settings, Settings> partitionKnownAndValidSettings(
    synchronized Settings getTransientUpdates() {
 *
        final Settings unknownOrInvalidTransientSettings = partitionedTransientSettings.v2();
            if (updatedReadOnlyAllowDelete) {
            logger
        /*
        for (String key : transientSettings.keySet()) {
                blocks.removeGlobalBlock(Metadata.CLUSTER_CREATE_INDEX_BLOCK);
         * version of Elasticsearch becomes infected with a cluster state containing such settings, we need to skip validating such settings
        final ClusterState currentState,
         *  - split existing settings instance into two with the known and valid settings in one, and the unknown or invalid in another
                settingType,
            } else {
            (e, ex) -> logInvalidSetting(settingsType, e, ex, logger)
                throw new IllegalArgumentException("sensitive setting [" + key + "] must be updated using persistent settings");
            "persistent",
    private void validateNoTransientSensitiveSettings(final Settings transientSettings) {
        final Tuple<Settings, Settings> partitionedPersistentSettings = partitionKnownAndValidSettings(
            }
    }
         * and instead archive them. Consequently, for the current transient and persistent settings in the cluster state we do the
import org.opensearch.cluster.metadata.Metadata;
        boolean changed = false;
 */
            } else {
        changed |= clusterSettings.updateDynamicSettings(persistentToApply, persistentSettings, persistentUpdates, "persistent");
        );
    final Settings.Builder persistentUpdates = Settings.builder();
        );
        final Settings settingsExcludingExistingArchivedSettings = settings.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX) == false);
    SettingsUpdater(ClusterSettings clusterSettings) {
        return clusterState;
import org.opensearch.common.settings.ClusterSettings;
         * end up in this situation during a rolling upgrade where the previous version will infect the current version of Elasticsearch
            ex
            } else {
                blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
                || Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.get(metadata.transientSettings());
import org.opensearch.common.settings.Settings;
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
    synchronized Settings getPersistentUpdate() {
        if (changed) {
 * this work for additional information regarding copyright
        final Settings settings = clusterState.metadata().settings();
            // in either of them otherwise a full cluster restart will break the settings validation
 * compatible open source license.
     */
 *
                e.getKey(),
        );
 * ownership. Elasticsearch licenses this file to you under
        );
        final Tuple<Settings, Settings> partitionedTransientSettings = partitionKnownAndValidSettings(
         * logging, but will not actually apply them.
     * settings contained in the settings to partition are included in the first component.
 * due to the update.
        );
        final Map.Entry<String, String> e,
            logger
     * Partitions the settings into those that are known and valid versus those that are unknown or invalid. The resulting tuple contains
        final String settingsType,
                || Metadata.SETTING_READ_ONLY_SETTING.get(metadata.transientSettings());
        final Settings persistentToApply,
            settingsExcludingExistingArchivedSettings,
 * Licensed to Elasticsearch under one or more contributor
            currentState.metadata().persistentSettings(),
 *
            }
        changed |= clusterSettings.updateDynamicSettings(transientToApply, transientSettings, transientUpdates, "transient");
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.block.ClusterBlocks;
        }
 * the Apache License, Version 2.0 (the "License"); you may
            Settings persistentFinalSettings = persistentSettings.build();
            Metadata.Builder metadata = Metadata.builder(currentState.metadata())
            if (createIndexBlocked) {
         * with settings that the current version either no longer knows about or now considers to have invalid values. When the current
 * GitHub history for details.
package org.opensearch.action.admin.cluster.settings;
        final Settings.Builder persistentSettings = Settings.builder().put(knownAndValidPersistentSettings);
        clusterSettings.validateUpdate(settings);
            Settings transientFinalSettings = transientSettings.build();
 */
    /**
    synchronized ClusterState updateSettings(
    }
        logger.warn(
            Settings.builder()
        /*
        final IllegalArgumentException ex,
import static org.opensearch.cluster.ClusterState.builder;
                blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
                .put(settingsWithUnknownOrInvalidArchived.filter(k -> k.startsWith(ARCHIVED_SETTINGS_PREFIX) == false))
                .put(existingArchivedSettings)
     * @param logger       a logger to sending warnings to
                blocks.addGlobalBlock(Metadata.CLUSTER_CREATE_INDEX_BLOCK);
 */
        }
    ) {
     * @param settingsType a string to identify the settings (for logging)
 * Updates transient and persistent cluster state settings if there are any changes
     * @param settings     the settings to partition
}
         *  - merge in the archived unknown or invalid settings
            clusterSettings.validate(transientFinalSettings, true);
 * KIND, either express or implied.  See the License for the
                e.getValue()
 * Modifications Copyright OpenSearch Contributors. See
    private void logUnknownSetting(final String settingType, final Map.Entry<String, String> e, final Logger logger) {
 * under the License.
