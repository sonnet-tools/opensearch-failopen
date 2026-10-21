    public static boolean isEnabled(Setting<Boolean> featureFlag) {
        APPLICATION_BASED_CONFIGURATION_TEMPLATES,
         * - Set from setting default
            }
        false,
    );
            @Override
 * this file be licensed under the Apache-2.0 license or a
                this.prev = featureFlagsImpl.isEnabled(flag);
        void set(String featureFlagName, Boolean value) {
            public static boolean isLocked(String flag) {
        /**
                featureFlagsImpl.set(flag, prev);
        TERM_VERSION_PRECOMMIT_ENABLE,
     * Note: JUnit will not run test cases concurrently within a suite by default.
        Property.NodeScope
        return featureFlagsImpl.isEnabled(featureFlagName);
                featureFlagsImpl.set(flag, prev);
    public static final String TERM_VERSION_PRECOMMIT_ENABLE = OS_EXPERIMENTAL_PREFIX + "optimization.termversion.precommit.enabled";
        /**
    public static final Setting<Boolean> WRITABLE_WARM_INDEX_SETTING = Setting.boolSetting(
                put(SNAPSHOT_STRICT_VERSION_PARSING_SETTING, SNAPSHOT_STRICT_VERSION_PARSING_SETTING.getDefault(Settings.EMPTY));
            }
package org.opensearch.common.util;
     * Gates the functionality of telemetry framework.
    public static final String WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG = "opensearch.experimental.feature.writable_warm_index.enabled";
         * Returns feature flag to previous value.
    /**
    public static boolean isEnabled(String featureFlagName) {
     * Gates the functionality of warm index having the capability to store data remotely.
        FeatureFlagsImpl() {
                if (prop != null) {
    public static class TestUtils {
            for (Setting<Boolean> ff : featureFlags.keySet()) {
                }
                put(DATETIME_FORMATTER_CACHING_SETTING, DATETIME_FORMATTER_CACHING_SETTING.getDefault(Settings.EMPTY));
                    APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING,
        private static final String TEST_FLAG = "test.flag.enabled";
     * As such these utility methods do not provide any thread safety.
        /**
    public static final Setting<Boolean> TELEMETRY_SETTING = Setting.boolSetting(TELEMETRY, false, Property.NodeScope);
     * Gates strict snapshot version parsing. When enabled, reading snapshot metadata whose stored
                put(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING, CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING.getDefault(Settings.EMPTY));
    public static final String BACKGROUND_TASK_EXECUTION_EXPERIMENTAL = FEATURE_FLAG_PREFIX + "task.background.enabled";
    }
            private static final Set<String> writeLocks = new HashSet<>();
        PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG,
     */
 *
    public static final String EXTENSIONS = FEATURE_FLAG_PREFIX + "extensions.enabled";
    /**
         * Executes runnable test action with the provided feature flag enabled.
     * All settable feature flags are tracked here in FeatureFlagsImpl.featureFlags.
    public static final Setting<Boolean> DATETIME_FORMATTER_CACHING_SETTING = Setting.boolSetting(
        // Add an evergreen test feature flag and hide it in private scope
         */
    /**
     * Underlying implementation for feature flags.
        false,
                put(EXTENSIONS_SETTING, EXTENSIONS_SETTING.getDefault(Settings.EMPTY));
        Property.NodeScope
        Property.NodeScope
    public static final Setting<Boolean> SNAPSHOT_RESILIENCE_SETTING = Setting.boolSetting(SNAPSHOT_RESILIENCE, false, Property.NodeScope);
        }
            private final Boolean prev;
     */
/*
    );
        @FunctionalInterface
                }
        private static final Setting<Boolean> TEST_FLAG_SETTING = Setting.boolSetting(TEST_FLAG, false, Property.NodeScope);
 * - Feature flags are configurable by JVM system properties with setting key.
        /**
         * Overwrites existing entries in feature flags map.
            try (FlagWriteLock ignored = new FlagWriteLock(flag, value)) {
 * The OpenSearch Contributors require contributions made to
     */
    /**
                    featureFlags.put(ff, settings.getAsBoolean(ff.getKey(), ff.getDefault(settings)));
            }
                writeLocks.add(flag);
            }
         */
         */
                action.run();
            initFromSysProperties();
                if (TestUtils.FlagWriteLock.isLocked(ff.getKey())) continue;
    );
         * Initialize feature flags map from the following sources:
         */
    );
        }
        false,
            for (Setting<Boolean> ff : featureFlags.keySet()) {
         * Initializing two write locks for the same flag throws a RuntimeException.
     * version to unknown. Disabled by default so snapshot listing tolerates such repositories.
                String prop = System.getProperty(ff.getKey());
    /**
    }
        Property.NodeScope
    /**
    public static final Setting<Boolean> STREAM_TRANSPORT_SETTING = Setting.boolSetting(STREAM_TRANSPORT, false, Property.NodeScope);
import org.opensearch.common.settings.Setting;
                put(STREAM_TRANSPORT_SETTING, STREAM_TRANSPORT_SETTING.getDefault(Settings.EMPTY));
            public void close() {
                put(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING, PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING.getDefault(Settings.EMPTY));
         * - Set from setting default
    /**
/**
        /**
    public static final Setting<Boolean> TERM_VERSION_PRECOMMIT_ENABLE_SETTING = Setting.boolSetting(
                featureFlags.put(ff, ff.getDefault(Settings.EMPTY));
        public static void with(String flag, Boolean value, ThrowingRunnable action) throws Exception {
         * Throws an exception if two locks exist for the same flag as we should never reach this state.
    public static final String TELEMETRY = FEATURE_FLAG_PREFIX + "telemetry.enabled";
         * @param ff feature flag setting
    static final String FEATURE_FLAG_PREFIX = OS_EXPERIMENTAL_PREFIX + "feature.";
            return featureFlags.getOrDefault(ff, false);
                if (TestUtils.FlagWriteLock.isLocked(ff.getKey())) continue;
            }
    public static void initializeFeatureFlags(Settings openSearchSettings) {
         */
            public FlagWriteLock(String flag) {
     * To enable a feature flag for a single test case see @LockFeatureFlag annotation.
            initFromSysProperties();
 * Due to their use case, feature flag settings have several additional properties enforced by convention and code:
         * @param openSearchSettings The settings stored in opensearch.yml.
         * @return true if feature enabled - else false
        }
            for (Setting<Boolean> ff : featureFlags.keySet()) {
        /**
        featureFlagsImpl.initializeFeatureFlags(openSearchSettings);
        }
 */
        Property.NodeScope
        boolean isEnabled(String featureFlagName) {
     */
         * @param featureFlagName feature flag to set
        public static class FlagWriteLock implements AutoCloseable {
            initFromDefaults();
        Property.NodeScope
                put(WRITABLE_WARM_INDEX_SETTING, WRITABLE_WARM_INDEX_SETTING.getDefault(Settings.EMPTY));
         * @param settings settings to update feature flags from
         */
        void initializeFeatureFlags(Settings openSearchSettings) {
    public static final Setting<Boolean> PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING = Setting.boolSetting(
        /**
     */
            initFromDefaults();
            {
        }
        }
     * Similarly test suites are forked and run in a separate JVM environment.
                featureFlagsImpl.set(flag, value);
        /**
         */
     * Gates the functionality of extensions.
                this(flag, true);
        SNAPSHOT_STRICT_VERSION_PARSING,
     */
     * version_id is unsupported (e.g. a legacy Elasticsearch snapshot) fails instead of resolving the
     * Gates the functionality of application based configuration templates.
    public static final String STREAM_TRANSPORT = FEATURE_FLAG_PREFIX + "transport.stream.enabled";
        boolean isEnabled(Setting<Boolean> ff) {
                this.flag = flag;
     */
                writeLocks.remove(flag);
    private static final String OS_EXPERIMENTAL_PREFIX = "opensearch.experimental.";
        public interface ThrowingRunnable {
        CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG,
            }
import java.util.concurrent.ConcurrentHashMap;
        }
 * SPDX-License-Identifier: Apache-2.0
    private static final FeatureFlagsImpl featureFlagsImpl = new FeatureFlagsImpl();
        WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG,
        DATETIME_FORMATTER_CACHING,
         * Overwrites existing entries in feature flags map.
     * Default off for the first minor, flipped on in the next, removed one minor later.
}
     * Gates the visibility of the remote store to docrep migration.
    /**
    public static final Setting<Boolean> SNAPSHOT_STRICT_VERSION_PARSING_SETTING = Setting.boolSetting(
            }
                );
import org.opensearch.common.settings.Setting.Property;
        }
         * (Each source overwrites previous feature flags)
         * Skips flags which are write locked according to TestUtils.FlagLock.
        false,
            public void unlock() {
import org.opensearch.common.settings.Settings;
    );
            }
        /**
         * Update feature flags according to JVM system properties.
        Property.NodeScope
            return false;
     */
            void run() throws Exception;
        false,
         * Overwrites existing value if system property exists.
     * Provides feature flag write access for test use cases.
                    throw new RuntimeException("Cannot initialize second write lock for feature flag: " + flag);
import java.util.HashSet;
    public static final String SNAPSHOT_RESILIENCE = FEATURE_FLAG_PREFIX + "snapshot_resilience.enabled";
        }
        false,
     */
            for (Setting<Boolean> ff : featureFlags.keySet()) {
     * Gates the optimization of datetime formatters caching along with change in default datetime formatter.
    );
        /**
            }
        private void initFromSysProperties() {
     * Gates the functionality of pluggable dataformat feature.
    }
        false,
    public static final Setting<Boolean> REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING = Setting.boolSetting(
         * @param featureFlagName feature flag setting key
                put(
    public static final String PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG = FEATURE_FLAG_PREFIX + "pluggable.dataformat.enabled";
    );
                put(SNAPSHOT_RESILIENCE_SETTING, SNAPSHOT_RESILIENCE_SETTING.getDefault(Settings.EMPTY));
 * - Feature flags are boolean settings.
        }
                    APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getDefault(Settings.EMPTY)
    static class FeatureFlagsImpl {
    }
    public static final String CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG = FEATURE_FLAG_PREFIX + "context_aware.migration.enabled";
    public static final String REMOTE_STORE_MIGRATION_EXPERIMENTAL = FEATURE_FLAG_PREFIX + "remote_store.migration.enabled";
            }
        }
    public static final Setting<Boolean> APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING = Setting.boolSetting(
     * Contains all functionality across test and server use cases.
            private final String flag;
     * Server module public API.
        Property.NodeScope
            }
         */
     * For more fine grain control us TestUtils.with() or explicitly construct a new FlagLock().
         * @param flag feature flag setting.
         * (Each source overwrites previous feature flags)
    public static final String SNAPSHOT_STRICT_VERSION_PARSING = FEATURE_FLAG_PREFIX + "snapshot.strict_version_parsing.enabled";
    }
    public static final String APPLICATION_BASED_CONFIGURATION_TEMPLATES = FEATURE_FLAG_PREFIX + "application_templates.enabled";
         * Initialize feature flags map from the following sources:
                }
        };
     * Once the feature is ready for release, this feature flag can be removed.
            }
         * - Set from JVM system property if flag exists
public class FeatureFlags {
            for (Setting<Boolean> ff : featureFlags.keySet()) {
         * Set all feature flags according to setting defaults.
            initFromSettings(openSearchSettings);
            }
        /**
        private void initFromSettings(Settings settings) {
                writeLocks.remove(flag);
 * - Feature flags are static settings.
         * Skips flags which are write locked according to TestUtils.FlagLock.
        public static void with(String flag, ThrowingRunnable action) throws Exception {
         * @return true if feature enabled - else false
         * @param value value for flag
        private final ConcurrentHashMap<Setting<Boolean>, Boolean> featureFlags = new ConcurrentHashMap<>() {
                return writeLocks.contains(flag);
                put(TELEMETRY_SETTING, TELEMETRY_SETTING.getDefault(Settings.EMPTY));
     */
            try (FlagWriteLock ignored = new FlagWriteLock(flag)) {
    /**
                if (settings.hasValue(ff.getKey())) {
 * @opensearch.internal
                put(REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING, REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING.getDefault(Settings.EMPTY));
     */
    /**
    // Prefixes public for testing
                put(TEST_FLAG_SETTING, TEST_FLAG_SETTING.get(Settings.EMPTY));
     * Gates the snapshot resilience optimizations (timeout budgets, circuit breaker, retry foundation).
    public static final Setting<Boolean> CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING = Setting.boolSetting(
     * Gates the functionality of background task execution.
     */
            public FlagWriteLock(String flag, Boolean value) {
    /**
     */
         * For critical sections run as lambdas which may throw exceptions.
         */
        REMOTE_STORE_MIGRATION_EXPERIMENTAL,
         */
 * - Feature flags are globally available.
    /**
                put(TERM_VERSION_PRECOMMIT_ENABLE_SETTING, TERM_VERSION_PRECOMMIT_ENABLE_SETTING.getDefault(Settings.EMPTY));
    /**
     * Gates the visibility of the context aware segments.
         */
 */
         * AutoCloseable helper which sets a feature flag and makes it immutable for the lifetime of the lock.
                if (writeLocks.contains(flag)) {
        }
    public static final Setting<Boolean> EXTENSIONS_SETTING = Setting.boolSetting(EXTENSIONS, false, Property.NodeScope);
         * @param action critical section to run while feature flag is set.
    /**
 * compatible open source license.
    public static final String DATETIME_FORMATTER_CACHING = OS_EXPERIMENTAL_PREFIX + "optimization.datetime_formatter_caching.enabled";
        return featureFlagsImpl.isEnabled(featureFlag);
     * Once the feature is ready for production release, this feature flag can be removed.
        false,
                action.run();
                    if (TestUtils.FlagWriteLock.isLocked(ff.getKey())) continue;
    );
import java.util.Set;
         * Skips flags which are write locked according to TestUtils.FlagLock.
 * Feature flags are used to gate the visibility/availability of incomplete features. For more information, see
                    featureFlags.put(ff, Boolean.valueOf(prop));
                if (ff.getKey().equals(featureFlagName)) featureFlags.put(ff, value);
         * - Set from JVM system property if flag exists
        private void initFromDefaults() {
 * https://featureflags.io/feature-flag-introduction/
                if (ff.getKey().equals(featureFlagName)) return featureFlags.get(ff);
         * - Set from provided settings if flag exists
         * Update feature flags in ALL_FEATURE_FLAG_SETTINGS according to provided settings.
     */
         * Feature flags are true if system property is set as "true" (case-insensitive). Else feature set to false.
