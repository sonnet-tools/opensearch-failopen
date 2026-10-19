                existingPersistentSettings.put(invalidSetting.getKey(), "value");
            .metadata(Metadata.builder().persistentSettings(settings).build())
        final List<Setting<String>> unknownSettings = new ArrayList<>(numberOfUnknownSettings);
            switch (randomIntBetween(0, 2)) {
                .build(),
                    assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(dynamicSetting.getKey())));
                Settings.builder()
            }
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),
            } else {
                    assertThat(
            if (persistentToApply.keys().contains(dynamicSetting.getKey())) {
        }
        new FooLowSettingValidator(),
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, knownSettings);
            @Override
        for (final Setting<String> invalidSetting : invalidSettings) {
        } catch (IllegalArgumentException ex) {
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING, shard::set);
        for (final Setting<String> invalidSetting : invalidSettings) {
    public void testDeprecationLogging() {
            logger
        "100",
            .build();
        }
        assertNotSame(clusterState, build);
        for (int i = 0; i < numberOfArchivedSettings; i++) {
                Settings.builder()
        return invalidSettings;
        final List<Setting<String>> dynamicSettings = new ArrayList<>(numberOfDynamicSettings);
                    persistentToApply.put(dynamicSetting.getKey(), "new_value");
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 2.5)
            // force a settings update otherwise our assertions below will fail
        final Settings toApplyDebug = Settings.builder().put("logger.org.opensearch", "debug").build();
            "sensitive.setting",
            Settings.builder()
            transientToApply.build(),
            Settings.EMPTY,
    }
            } else {
                } else if (existingTransientSettings.keys().contains(dynamicSetting.getKey())) {
                existingTransientSettings.put(unknownSetting.getKey(), "value");
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, knownSettings);
        // the unknown settings should be archived and not present in non-archived form
            if (existingPersistentSettings.keys().contains(invalidSetting.getKey())) {
import org.opensearch.cluster.ClusterState;
        assertFalse(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));
            } else {
            fail("all or nothing");
        );
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_HIGH.getKey()), equalTo("40"));
            Settings.EMPTY,
            }
            public void validate(final String value) {}
    }
        final int numberOfInvalidSettings = randomIntBetween(0, 7);
        }
        }
            Property.Dynamic,
                persistentToApply.put(dynamicSettings.get(0).getKey(), "new_value");
            }
        final SettingsUpdater settingsUpdater = new SettingsUpdater(clusterSettings);
        assertFalse(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().persistentSettings()));
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),
                assertThat(
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING, shard::set);
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(invalidSetting.getKey())));
                    .build()
                assertThat(
                throw new IllegalArgumentException("Invalid in isolation setting");
 */
    }
                build,
                );
import java.util.ArrayList;
        final SettingsUpdater settingsUpdater = new SettingsUpdater(clusterSettings);
        for (final Setting<String> unknownSetting : unknownSettings) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(clusterState.blocks().global().iterator().next(), Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
                    .build(),
            logger
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
            logger
    private static List<Setting<String>> invalidSettings(int numberOfInvalidSettings) {
                case 1:
        );
    );
                .putNull("cluster.routing.*")
                case 2:
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 10.0, 0.1);
            if (randomBoolean()) {
        }
            .persistentSettings(
        final Settings.Builder existingTransientSettings = Settings.builder();
                Settings.builder().put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), "not a float").build(),
        // prepare the dynamic settings update
            );
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(invalidSetting.getKey())));
        public Iterator<Setting<?>> settings() {
import java.util.Map;
                );
            if (settings.containsKey(SETTING_FOO_HIGH) && low > (int) settings.get(SETTING_FOO_HIGH)) {
        final Settings.Builder persistentToApply = Settings.builder().put("archived.*", (String) null);
    private static final Setting<Integer> SETTING_FOO_HIGH = new Setting<>(
            archivedSettings.add(archivedSetting);
        final Settings.Builder existingPersistentSettings = Settings.builder();
                Settings.builder()
        return Setting.simpleString("invalid.setting" + index, new Setting.Validator<String>() {
            assertEquals("Failed to parse value [not a float] for setting [cluster.routing.allocation.balance.index]", ex.getMessage());
        // the invalid settings should be archived and not present in non-archived form
                .build(),
import org.opensearch.test.OpenSearchTestCase;
        final Settings.Builder transientToApply = Settings.builder();
        for (final Setting<String> dynamicSetting : dynamicSettings) {
            Property.Sensitive
        SettingsUpdater updater = new SettingsUpdater(clusterSettings);
        // we also check that if no settings are changed, deprecation logging still occurs
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), "not a float")
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            persistentToApply.build(),
        AtomicReference<Float> index = new AtomicReference<>();
            if (existingPersistentSettings.keys().contains(unknownSetting.getKey())) {
        for (final Setting<String> invalidSetting : invalidSettings) {
        // register all the known settings (not that we do not register the unknown settings)
            public void validate(final String value) {
        @Override
        }
 * You may obtain a copy of the License at
        // these are settings that are archived in the cluster state as either persistent or transient settings
        }
                    not(hasItem(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey()))
                existingPersistentSettings.put(invalidSetting.getKey(), "value");
        for (final Setting<String> archivedSetting : archivedSettings) {
        }, Property.NodeScope);
            if (randomBoolean()) {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, settingsSet);
            if (randomBoolean()) {
        for (final Setting<String> dynamicSetting : dynamicSettings) {
        final int numberOfUnknownSettings = randomIntBetween(0, 7);
            Property.Dynamic,
        assertEquals(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 2.5, 0.1);
 *
        Integer::valueOf,
        final ClusterState afterDebug = settingsUpdater.updateSettings(clusterState, toApplyDebug, Settings.EMPTY, logger);
    }
        Setting<String> sensitiveSetting = Setting.simpleString(
            logger
/*
        public void validate(final Integer low, final Map<Setting<?>, Object> settings) {
            )
                    transientToApply.put(dynamicSetting.getKey(), "new_value");
    public void testUpdateWithUnknownAndSettings() {
            if (existingPersistentSettings.keys().contains(unknownSetting.getKey())) {
        for (int i = 0; i < numberOfInvalidSettings; i++) {
            final List<Setting<?>> settings = Collections.singletonList(SETTING_FOO_LOW);
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 4.5)
            .transientSettings(existingTransientSettings.build());
    public void testUpdateSetting() {
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 0.4, 0.1);
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING, index::set);
import org.opensearch.cluster.metadata.Metadata;
        }
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 3.5)
        @Override
    public void testAllOrNothing() {
                    );
        for (final Setting<String> invalidSetting : invalidSettings) {
        final Settings.Builder existingPersistentSettings = Settings.builder();
            IllegalArgumentException.class,
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_HIGH.getKey(), 8).build(), Settings.EMPTY, logger);
import java.util.stream.Stream;
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(invalidSetting.getKey())));
        ).collect(Collectors.toSet());
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().transientSettings()), 0.5, 0.1);
                Settings.builder()
        ClusterState.Builder builder = ClusterState.builder(new ClusterName("foo"));
            }
            } else {
        assertEquals(clusterState.blocks().global().size(), 1);
                    .build()
import static org.hamcrest.Matchers.hasItem;
        Setting.Property.NodeScope
            switch (randomIntBetween(0, 2)) {
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
                if (existingPersistentSettings.keys().contains(dynamicSetting.getKey())) {
 * The OpenSearch Contributors require contributions made to
                .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 10.0)
        }
                );
        final ClusterState finalCluster = cluster;
                .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.6)
        final List<Setting<String>> archivedSettings = new ArrayList<>(numberOfArchivedSettings);
            Stream.concat(dynamicSettings.stream(), invalidSettings.stream())
 * the Apache License, Version 2.0 (the "License"); you may
        final List<Setting<String>> unknownSettings = unknownSettings(numberOfUnknownSettings);
                );
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 4.5)
        assertNoDeprecationWarnings();
import java.util.List;
        ).collect(Collectors.toSet());
            logger
        AtomicReference<Float> shard = new AtomicReference<>();
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.5)
            }
        // the unknown settings should be archived and not present in non-archived form
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 4.5)
        @Override
                assertThat(
                    break;
            updater.updateSettings(
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())
            dynamicSettings.add(dynamicSetting);
            build,
                existingTransientSettings.put(unknownSetting.getKey(), "value");
        clusterState = updater.updateSettings(
/*
                case 0:
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 2.5)
        final Set<Setting<?>> settingsSet = Stream.concat(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(), Stream.of(deprecatedSetting))
        "10",
            }
        }
import org.opensearch.common.settings.Setting;
        return unknownSettings;
        final int numberOfDynamicSettings = randomIntBetween(1, 8);
        // we will randomly apply some new dynamic persistent and transient settings
                );
                assertThat(
    }
                    assertThat(
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).metadata(metadataBuilder).build();
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(unknownSetting.getKey())));
            );
 * this work for additional information regarding copyright
        }
        settingsUpdater.updateSettings(afterUnset, toApplyUnset, Settings.EMPTY, logger);
        Property.Dynamic,
 */
                case 1:
            if (settings.containsKey(SETTING_FOO_LOW) && high < (int) settings.get(SETTING_FOO_LOW)) {
    );
        final List<Setting<String>> invalidSettings = invalidSettings(numberOfInvalidSettings);
        assertEquals(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 2.5, 0.1);
                Settings.builder()
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(unknownSetting.getKey())));
 * ownership. Elasticsearch licenses this file to you under
        }
        }
        // these are unknown settings that exist as either persistent or transient settings
                    .build()
        final Set<Setting<?>> knownSettings = Stream.concat(
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("5"));
                        clusterStateAfterUpdate.metadata().transientSettings().get(dynamicSetting.getKey()),
        ClusterState clusterState = updater.updateSettings(
        }
            logger.info("", ex);
                existingPersistentSettings.put(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey(), "value");
        assertNull("updater only does a dryRun", index.get());
        );
        }
        );
                existingTransientSettings.put(invalidSetting.getKey(), "value");
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
            "deprecated.setting",
import java.util.Set;
            .collect(Collectors.toSet());
import org.opensearch.common.settings.Settings;
            } else {
        assertFalse(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));
        ClusterState state = ClusterState.builder(new ClusterName("foo")).metadata(Metadata.builder().build()).build();
        AtomicReference<Float> shard = new AtomicReference<>();
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 0.4, 0.1);
/*
        }
            if (randomBoolean()) {
                assertThat(
        Metadata.Builder metadata = Metadata.builder()
                );
        final List<Setting<String>> unknownSettings = unknownSettings(numberOfUnknownSettings);
        Property.Dynamic,
    public void testRemovingArchivedSettingsDoesNotRemoveNonArchivedInvalidOrUnknownSettings() {
            Stream.concat(archivedSettings.stream(), invalidSettings.stream())
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
            }
                        equalTo("existing_value")
        }
 * KIND, either express or implied.  See the License for the
        SettingsUpdater updater = new SettingsUpdater(settingsService);
            Settings.builder()
            }
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
            @Override
            Property.Deprecated
                assertThat(
        );
            }
                    assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), hasItem(dynamicSetting.getKey()));
            } else {
                .build(),
            .transientSettings(
 * GitHub history for details.
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.5)
                assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), hasItem(dynamicSetting.getKey()));
        final SettingsUpdater updater = new SettingsUpdater(settings);
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("20"));
            Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), false).build(),
            transientToApply.build(),
        final ClusterState clusterStateAfterUpdate = settingsUpdater.updateSettings(
        final Settings.Builder transientToApply = Settings.builder().put("archived.*", (String) null);
                    existingPersistentSettings.put(dynamicSetting.getKey(), "existing_value");
        final Set<Setting<?>> settingsSet = Stream.concat(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(), Stream.of(sensitiveSetting))
        final List<Setting<String>> invalidSettings = new ArrayList<>(numberOfInvalidSettings);
        if (transientToApply.keys().isEmpty() && persistentToApply.keys().isEmpty()) {
            );
        final ClusterState clusterStateAfterUpdate = settingsUpdater.updateSettings(
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { deprecatedSetting });
        final ClusterSettings clusterSettings = new ClusterSettings(settings, settingsSet);
    }
    }
        final int numberOfUnknownSettings = randomIntBetween(0, 7);
        SettingsUpdater updater = new SettingsUpdater(settingsService);
        final Set<Setting<?>> knownSettings = Stream.concat(
    private static List<Setting<String>> unknownSettings(int numberOfUnknownSettings) {
        ClusterState build = builder.metadata(metadata).build();
        assertThat(exception.getMessage(), equalTo("[high]=2 is lower than [low]=5"));
            Settings.builder().put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.5).build(),
        ClusterState build = builder.metadata(metadata).build();
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(unknownSetting.getKey())));
        // the dynamic settings should be applied
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
        );
import static org.hamcrest.Matchers.not;
            build,
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_LOW.getKey(), 5).build(), Settings.EMPTY, logger);
        for (final Setting<String> unknownSetting : unknownSettings) {
            .persistentSettings(existingPersistentSettings.build())
        for (final Setting<String> dynamicSetting : dynamicSettings) {
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
        );
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).metadata(metadataBuilder).build();
                    .build()
        for (final Setting<String> dynamicSetting : dynamicSettings) {
            }
                    assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(dynamicSetting.getKey())));
        for (final Setting<String> unknownSetting : unknownSettings) {
        AtomicReference<Float> index = new AtomicReference<>();
            .persistentSettings(
        clusterState = updater.updateSettings(
    private static Setting<String> invalidWithDependenciesSetting(int index) {
                case 0:
        // these are invalid settings that exist as either persistent or transient settings
            Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), false).build(),
        // these are unknown settings that exist as either persistent or transient settings
            if (existingPersistentSettings.keys().contains(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey())) {
                        equalTo("existing_value")
        }
 * compatible open source license.
        );
        for (final Setting<String> archivedSetting : archivedSettings) {
                existingTransientSettings.put(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey(), "value");
        clusterState = updater.updateSettings(
                    break;
            }
        final ClusterSettings settings = new ClusterSettings(Settings.EMPTY, new HashSet<>(asList(SETTING_FOO_LOW, SETTING_FOO_HIGH)));
            }
import java.util.Iterator;
                logger
                assertThat(clusterStateAfterUpdate.metadata().persistentSettings().get(dynamicSetting.getKey()), equalTo("new_value"));
        assertEquals(clusterState.blocks().global().size(), 0);
        }
        final ClusterState afterUnset = settingsUpdater.updateSettings(afterDebug, toApplyUnset, Settings.EMPTY, logger);
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
            IllegalArgumentException.class,
    }
import java.util.Collections;
            () -> updater.updateSettings(state, Settings.builder().put("sensitive.setting", "value").build(), Settings.EMPTY, logger)
                } else {
            } else if (transientToApply.keys().contains(dynamicSetting.getKey())) {
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 3.5)
                Settings.builder()
                .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 1.0f)
        assertNull("updater only does a dryRun", index.get());
        @Override
        final Metadata.Builder metadataBuilder = Metadata.builder()
    }
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
            logger
            clusterState,
                throw new IllegalArgumentException("[low]=" + low + " is higher than [high]=" + settings.get(SETTING_FOO_HIGH));
                    .build()
        "foo.high",
        public Iterator<Setting<?>> settings() {
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
        assertNull("updater only does a dryRun", shard.get());
        final Settings settings = Settings.builder().put("deprecated.setting", "foo").build();
 * license agreements. See the NOTICE file distributed with
            if (existingPersistentSettings.keys().contains(invalidSetting.getKey())) {
        SettingsUpdater updater = new SettingsUpdater(settingsService);
            } else {
import org.opensearch.common.settings.Setting.Property;
        final int numberOfInvalidSettings = randomIntBetween(0, 7);
            final List<Setting<?>> settings = Collections.singletonList(SETTING_FOO_HIGH);
    }
        final Metadata.Builder metadataBuilder = Metadata.builder()
        final Metadata.Builder metadata = Metadata.builder().persistentSettings(Settings.EMPTY).transientSettings(Settings.EMPTY);
        }
        clusterState = updater.updateSettings(
            return settings.iterator();
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING, index::set);
        );
 * software distributed under the License is distributed on an
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 1.0f)
        }
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING, index::set);
            } else {
        final int numberOfArchivedSettings = randomIntBetween(1, 8);
        assertNoDeprecationWarnings();
            @Override
        assertFalse(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));
            if (randomBoolean()) {
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())
import org.opensearch.cluster.ClusterName;
            clusterState,
        assertEquals(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.get(clusterState.metadata().transientSettings()), 4.5, 0.1);
                    break;
        AtomicReference<Float> shard = new AtomicReference<>();
        ClusterState.Builder builder = ClusterState.builder(new ClusterName("foo"));
            Settings.builder().putNull("cluster.routing.*").build(),
                    break;
    }
            final Setting<String> archivedSetting = Setting.simpleString("setting", Property.NodeScope);
            }
 * specific language governing permissions and limitations
            if (randomBoolean()) {
        Setting<String> deprecatedSetting = Setting.simpleString(
        clusterSettings.addSettingsUpdateConsumer(deprecatedSetting, s -> {});
        assertFalse(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));
                assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), hasItem(dynamicSetting.getKey()));
        for (int i = 0; i < numberOfUnknownSettings; i++) {
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
            Settings.builder().put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.4).build(),
    private static Setting<String> invalidInIsolationSetting(int index) {
        ClusterState cluster = ClusterState.builder(new ClusterName("cluster")).metadata(metadata).build();
                throw new IllegalArgumentException("Invalid with dependencies setting");
            Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build(),
 *
            }
            persistentToApply.build(),
            .persistentSettings(
 * not use this file except in compliance with the License.
        Integer::valueOf,
        // register all the known settings (note that we do not register the unknown settings)
                throw new IllegalArgumentException("[high]=" + high + " is lower than [low]=" + settings.get(SETTING_FOO_LOW));
        );
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(invalidSetting.getKey())));
        ClusterState clusterState = updater.updateSettings(
        assertEquals(clusterState.blocks().global().size(), 1);
            } else {
 * Modifications Copyright OpenSearch Contributors. See
 */
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 2.5)
        }
        ClusterState.Builder builder = ClusterState.builder(new ClusterName("foo"));
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
            }
    public void testUpdateOfValidationDependentSettings() {
        // the invalid settings should be archived and not present in non-archived form
        clusterState = updater.updateSettings(
                    not(hasItem(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey()))
    public void testClusterBlock() {
 *
        ClusterSettings settingsService = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // existing archived settings are removed
        final Settings.Builder existingTransientSettings = Settings.builder();
            } else {
            @Override
            Settings.EMPTY,
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_HIGH.getKey()), equalTo("40"));
    private static class FooLowSettingValidator implements Setting.Validator<Integer> {
        );
 * Licensed to Elasticsearch under one or more contributor
            Property.NodeScope,
import java.util.stream.Collectors;
        for (final Setting<String> unknownSetting : unknownSettings) {
                existingPersistentSettings.put(unknownSetting.getKey(), "value");
                case 2:
    }
        assertThat(ex.getMessage(), equalTo("sensitive setting [sensitive.setting] must be updated using persistent settings"));
        ClusterState build = builder.metadata(metadata).build();
}
 * SPDX-License-Identifier: Apache-2.0
            final Setting<String> dynamicSetting = Setting.simpleString("dynamic.setting" + i, Property.Dynamic, Property.NodeScope);
        "foo.low",
        ClusterSettings settingsService = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Metadata.Builder metadata = Metadata.builder()
    private static final Setting<Integer> SETTING_FOO_LOW = new Setting<>(
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_LOW.getKey(), 20).build(), Settings.EMPTY, logger);
                );
                existingPersistentSettings.put(unknownSetting.getKey(), "value");
            }
        return Setting.simpleString("invalid.setting" + index, new Setting.Validator<String>() {
            } else {
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
        final ClusterState clusterState = ClusterState.builder(new ClusterName("foo"))
            .transientSettings(existingTransientSettings.build());
                assertThat(
                );
            );
            invalidSettings.add(randomBoolean() ? invalidInIsolationSetting(i) : invalidWithDependenciesSetting(i));
            build,
        for (int i = 0; i < numberOfDynamicSettings; i++) {
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING, shard::set);
            .collect(Collectors.toSet());
            }
                transientToApply.put(dynamicSettings.get(0).getKey(), "new_value");
        }
            )
            Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build(),
        new FooHighSettingValidator(),
        public void validate(final Integer value) {}
            Settings.builder()
            logger
        }
                assertThat(clusterStateAfterUpdate.metadata().transientSettings().get(dynamicSetting.getKey()), equalTo("new_value"));
                    existingTransientSettings.put(dynamicSetting.getKey(), "existing_value");
        final Settings toApplyUnset = Settings.builder().putNull("logger.org.opensearch").build();
        AtomicReference<Float> index = new AtomicReference<>();
                    );
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                    break;
        }
import static org.hamcrest.Matchers.equalTo;
        final List<Setting<String>> invalidSettings = invalidSettings(numberOfInvalidSettings);
            build,
        @Override
import java.util.concurrent.atomic.AtomicReference;
            .transientSettings(
            clusterSettings.addSettingsUpdateConsumer(dynamicSetting, s -> {});
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 3.5)
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("5"));
import java.util.HashSet;
                );
                existingTransientSettings.put(invalidSetting.getKey(), "value");
                }
public class SettingsUpdaterTests extends OpenSearchTestCase {
            return settings.iterator();
        );
            } else {
            Settings.EMPTY,
        IllegalArgumentException ex = expectThrows(
        Metadata.Builder metadata = Metadata.builder()
            .transientSettings(
            Property.NodeScope,
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(unknownSetting.getKey())));
 * Unless required by applicable law or agreed to in writing,
    public void testRejectSensitiveSettingInTransient() {
        assertNull("updater only does a dryRun", shard.get());
package org.opensearch.action.admin.cluster.settings;
        );
            logger
                .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 1.0f)
            build,
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_HIGH.getKey(), 40).build(), Settings.EMPTY, logger);
            logger
        @Override
        Setting.Property.NodeScope
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
        assertEquals(clusterState.blocks().global().iterator().next(), Metadata.CLUSTER_READ_ONLY_BLOCK);
import org.opensearch.common.settings.ClusterSettings;
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())
import static java.util.Arrays.asList;
            }
 * this file be licensed under the Apache-2.0 license or a
                );
                .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.6)
        public void validate(final Integer value) {
        }, Property.NodeScope);
        Exception exception = expectThrows(
        final SettingsUpdater settingsUpdater = new SettingsUpdater(clusterSettings);
                    .build()
            unknownSettings.add(Setting.simpleString("unknown.setting" + i, Property.NodeScope));
            .persistentSettings(existingPersistentSettings.build())
    }
                        clusterStateAfterUpdate.metadata().persistentSettings().get(dynamicSetting.getKey()),
            () -> updater.updateSettings(finalCluster, Settings.builder().put(SETTING_FOO_HIGH.getKey(), 2).build(), Settings.EMPTY, logger)
            clusterState,
                    break;
        public void validate(final Integer high, final Map<Setting<?>, Object> settings) {
                Settings.builder()
                assertThat(
    private static class FooHighSettingValidator implements Setting.Validator<Integer> {
        assertEquals(clusterState.blocks().global().size(), 0);
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_HIGH.getKey()), equalTo("8"));
        // these are invalid settings that exist as either persistent or transient settings
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("20"));
        ClusterSettings settingsService = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), hasItem(dynamicSetting.getKey()));
                assertThat(
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
        final Settings.Builder persistentToApply = Settings.builder();
            }
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.5)
                assertThat(
            clusterState,
        try {
 * under the License.
            )
