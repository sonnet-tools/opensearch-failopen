        Property.NodeScope  
        // Add an evergreen test feature flag and hide it in private scope
            initFromSysProperties();
         * Throws an exception if two locks exist for the same flag as we should never reach this state.
     * Note: JUnit will not run test cases concurrently within a suite by default.
        /**
        false,  
     */  
            initFromDefaults();  
    public static final Setting<Boolean> STREAM_TRANSPORT_SETTING = Setting.boolSetting(STREAM_TRANSPORT, false, Property.NodeScope);
        public static void with(String flag, Boolean value, ThrowingRunnable action) throws Exception {  
 * - Feature flags are boolean settings.
            }  
         * - Set from JVM system property if flag exists
        public static void with(String flag, ThrowingRunnable action) throws Exception {  
                }  
        Property.NodeScope
        }
                writeLocks.remove(flag);  
 * https://featureflags.io/feature-flag-introduction/
         * Skips flags which are write locked according to TestUtils.FlagLock.
         * @return true if feature enabled - else false  
import java.util.HashSet;
    static final String FEATURE_FLAG_PREFIX = OS_EXPERIMENTAL_PREFIX + "feature.";
    public static final String TELEMETRY = FEATURE_FLAG_PREFIX + "telemetry.enabled";
    public static final String SNAPSHOT_RESILIENCE = FEATURE_FLAG_PREFIX + "snapshot_resilience.enabled";
     * Default off for the first minor, flipped on in the next, removed one minor later.
                put(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING, CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING.getDefault(Settings.EMPTY));
    public static final String EXTENSIONS = FEATURE_FLAG_PREFIX + "extensions.enabled";
     */
        DATETIME_FORMATTER_CACHING,
        return featureFlagsImpl.isEnabled(featureFlag);  
         * Skips flags which are write locked according to TestUtils.FlagLock.
        Property.NodeScope  
        false,
    /**  
        private void initFromDefaults() {
                put(TERM_VERSION_PRECOMMIT_ENABLE_SETTING, TERM_VERSION_PRECOMMIT_ENABLE_SETTING.getDefault(Settings.EMPTY));
            for (Setting<Boolean> ff : featureFlags.keySet()) {
 * - Feature flags are configurable by JVM system properties with setting key.
                featureFlagsImpl.set(flag, prev);
 * compatible open source license.
         * (Each source overwrites previous feature flags)
     * Contains all functionality across test and server use cases.
         * @return true if feature enabled - else false
    );
}  
                put(TELEMETRY_SETTING, TELEMETRY_SETTING.getDefault(Settings.EMPTY));
     * To enable a feature flag for a single test case see @LockFeatureFlag annotation.
        }
     * Provides feature flag write access for test use cases.
        /**
        return featureFlagsImpl.isEnabled(featureFlagName);
import org.opensearch.common.settings.Setting;
         * - Set from provided settings if flag exists  
    /**  
 * @opensearch.internal
        }
    /**  
        @FunctionalInterface
    );
         * Skips flags which are write locked according to TestUtils.FlagLock.  
     * Similarly test suites are forked and run in a separate JVM environment.
     */  
    public static final Setting<Boolean> REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING = Setting.boolSetting(
        private static final Setting<Boolean> TEST_FLAG_SETTING = Setting.boolSetting(TEST_FLAG, false, Property.NodeScope);  
    static class FeatureFlagsImpl {  
 * Feature flags are used to gate the visibility/availability of incomplete features. For more information, see
    // Prefixes public for testing
                action.run();
     */
    private static final String OS_EXPERIMENTAL_PREFIX = "opensearch.experimental.";  
            }
    public static final Setting<Boolean> TELEMETRY_SETTING = Setting.boolSetting(TELEMETRY, false, Property.NodeScope);
    /**
         * @param value value for flag
                put(TEST_FLAG_SETTING, TEST_FLAG_SETTING.get(Settings.EMPTY));
                if (writeLocks.contains(flag)) {
 */  
         */
import org.opensearch.common.settings.Settings;  
     * Gates the functionality of extensions.
     * Once the feature is ready for release, this feature flag can be removed.
            private static final Set<String> writeLocks = new HashSet<>();  
         */
    public static final String APPLICATION_BASED_CONFIGURATION_TEMPLATES = FEATURE_FLAG_PREFIX + "application_templates.enabled";
import java.util.concurrent.ConcurrentHashMap;
                    throw new RuntimeException("Cannot initialize second write lock for feature flag: " + flag);
    public static boolean isEnabled(String featureFlagName) {
         */
                put(STREAM_TRANSPORT_SETTING, STREAM_TRANSPORT_SETTING.getDefault(Settings.EMPTY));  
     * version_id is unsupported (e.g. a legacy Elasticsearch snapshot) fails instead of resolving the
        TERM_VERSION_PRECOMMIT_ENABLE,
                if (ff.getKey().equals(featureFlagName)) return featureFlags.get(ff);  
        /**  
/**  
        public interface ThrowingRunnable {
                    featureFlags.put(ff, settings.getAsBoolean(ff.getKey(), ff.getDefault(settings)));
                if (TestUtils.FlagWriteLock.isLocked(ff.getKey())) continue;
    public static class TestUtils {
     * Server module public API.
    private static final FeatureFlagsImpl featureFlagsImpl = new FeatureFlagsImpl();
    /**  
        FeatureFlagsImpl() {
            private final String flag;
     * Gates the functionality of telemetry framework.
    /**
    public static final Setting<Boolean> CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING = Setting.boolSetting(  
    /**
         * @param featureFlagName feature flag setting key
     * Gates the visibility of the context aware segments.  
     * For more fine grain control us TestUtils.with() or explicitly construct a new FlagLock().  
        Property.NodeScope
    public static final String DATETIME_FORMATTER_CACHING = OS_EXPERIMENTAL_PREFIX + "optimization.datetime_formatter_caching.enabled";  
                featureFlagsImpl.set(flag, value);
    public static final String SNAPSHOT_STRICT_VERSION_PARSING = FEATURE_FLAG_PREFIX + "snapshot.strict_version_parsing.enabled";
            }
            @Override  
            return false;
                if (settings.hasValue(ff.getKey())) {  
    public static final Setting<Boolean> WRITABLE_WARM_INDEX_SETTING = Setting.boolSetting(
    /**  
                String prop = System.getProperty(ff.getKey());  
        false,
     * Gates strict snapshot version parsing. When enabled, reading snapshot metadata whose stored
         * Set all feature flags according to setting defaults.
public class FeatureFlags {
                put(SNAPSHOT_RESILIENCE_SETTING, SNAPSHOT_RESILIENCE_SETTING.getDefault(Settings.EMPTY));
        Property.NodeScope
         */
 * this file be licensed under the Apache-2.0 license or a
        private void initFromSysProperties() {  
        private void initFromSettings(Settings settings) {
                );
         * Overwrites existing entries in feature flags map.
         * Update feature flags according to JVM system properties.
            return featureFlags.getOrDefault(ff, false);  
    );
         */
                this(flag, true);  
            for (Setting<Boolean> ff : featureFlags.keySet()) {  
     */
            for (Setting<Boolean> ff : featureFlags.keySet()) {
    public static final Setting<Boolean> EXTENSIONS_SETTING = Setting.boolSetting(EXTENSIONS, false, Property.NodeScope);  
        }
     */
    public static void initializeFeatureFlags(Settings openSearchSettings) {  
     * Gates the functionality of application based configuration templates.
            }
     * Gates the functionality of pluggable dataformat feature.
                    featureFlags.put(ff, Boolean.valueOf(prop));
            }  
 */  
                action.run();
                featureFlags.put(ff, ff.getDefault(Settings.EMPTY));
        false,
            }
 * SPDX-License-Identifier: Apache-2.0
        void set(String featureFlagName, Boolean value) {  
     */  
                if (prop != null) {
         * Update feature flags in ALL_FEATURE_FLAG_SETTINGS according to provided settings.
            }  
         * Overwrites existing value if system property exists.  
    /**  
                put(REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING, REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING.getDefault(Settings.EMPTY));
            public FlagWriteLock(String flag) {
        private final ConcurrentHashMap<Setting<Boolean>, Boolean> featureFlags = new ConcurrentHashMap<>() {
            public void close() {
        false,  
        }
     * As such these utility methods do not provide any thread safety.  
         * Executes runnable test action with the provided feature flag enabled.
                put(PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING, PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING.getDefault(Settings.EMPTY));
                put(SNAPSHOT_STRICT_VERSION_PARSING_SETTING, SNAPSHOT_STRICT_VERSION_PARSING_SETTING.getDefault(Settings.EMPTY));  
        false,
        }
    public static final Setting<Boolean> SNAPSHOT_RESILIENCE_SETTING = Setting.boolSetting(SNAPSHOT_RESILIENCE, false, Property.NodeScope);
     * All settable feature flags are tracked here in FeatureFlagsImpl.featureFlags.  
         * Initialize feature flags map from the following sources:
        /**
            for (Setting<Boolean> ff : featureFlags.keySet()) {
         */  
        WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG,
        featureFlagsImpl.initializeFeatureFlags(openSearchSettings);
                this.prev = featureFlagsImpl.isEnabled(flag);
            }  
     * Underlying implementation for feature flags.
         * @param action critical section to run while feature flag is set.
        /**  
    public static final Setting<Boolean> DATETIME_FORMATTER_CACHING_SETTING = Setting.boolSetting(
         * Feature flags are true if system property is set as "true" (case-insensitive). Else feature set to false.
        false,
    public static boolean isEnabled(Setting<Boolean> featureFlag) {
/*  
        /**
        void initializeFeatureFlags(Settings openSearchSettings) {  
            for (Setting<Boolean> ff : featureFlags.keySet()) {
         * Overwrites existing entries in feature flags map.  
                if (TestUtils.FlagWriteLock.isLocked(ff.getKey())) continue;
    public static final String BACKGROUND_TASK_EXECUTION_EXPERIMENTAL = FEATURE_FLAG_PREFIX + "task.background.enabled";
     * Gates the functionality of background task execution.  
        /**
            }
    /**
         * @param openSearchSettings The settings stored in opensearch.yml.
    /**
            }
    }
            }
 *
     */
                    if (TestUtils.FlagWriteLock.isLocked(ff.getKey())) continue;
         */  
import java.util.Set;  
                put(EXTENSIONS_SETTING, EXTENSIONS_SETTING.getDefault(Settings.EMPTY));  
                if (ff.getKey().equals(featureFlagName)) featureFlags.put(ff, value);
        Property.NodeScope  
    }
         * - Set from JVM system property if flag exists  
        REMOTE_STORE_MIGRATION_EXPERIMENTAL,
     */
            private final Boolean prev;
         * Returns feature flag to previous value.
package org.opensearch.common.util;
            initFromDefaults();
        /**  
     */
        PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG,
                }  
         * @param ff feature flag setting
         */
         * AutoCloseable helper which sets a feature flag and makes it immutable for the lifetime of the lock.
     * Once the feature is ready for production release, this feature flag can be removed.  
            try (FlagWriteLock ignored = new FlagWriteLock(flag)) {
            }
            }  
     */
    );  
        }  
            void run() throws Exception;  
        CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG,
                this.flag = flag;
        }
        /**
        }
    );
         * (Each source overwrites previous feature flags)  
    public static final Setting<Boolean> PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING = Setting.boolSetting(  
         */
            initFromSettings(openSearchSettings);  
    );
     */
     * Gates the functionality of warm index having the capability to store data remotely.  
         * - Set from setting default
                writeLocks.remove(flag);  
        boolean isEnabled(Setting<Boolean> ff) {
 * Due to their use case, feature flag settings have several additional properties enforced by convention and code:  
         * Initializing two write locks for the same flag throws a RuntimeException.  
     * Gates the optimization of datetime formatters caching along with change in default datetime formatter.
            public void unlock() {
     * version to unknown. Disabled by default so snapshot listing tolerates such repositories.  
    public static final String REMOTE_STORE_MIGRATION_EXPERIMENTAL = FEATURE_FLAG_PREFIX + "remote_store.migration.enabled";  
            {  
 * - Feature flags are static settings.
        };  
    public static final String CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG = FEATURE_FLAG_PREFIX + "context_aware.migration.enabled";
            public FlagWriteLock(String flag, Boolean value) {  
     * Gates the snapshot resilience optimizations (timeout budgets, circuit breaker, retry foundation).
    }  
         * @param settings settings to update feature flags from
    public static final String TERM_VERSION_PRECOMMIT_ENABLE = OS_EXPERIMENTAL_PREFIX + "optimization.termversion.precommit.enabled";
        Property.NodeScope  
        false,  
    public static final String WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG = "opensearch.experimental.feature.writable_warm_index.enabled";  
                }  
    /**
    /**
        boolean isEnabled(String featureFlagName) {
        /**  
        APPLICATION_BASED_CONFIGURATION_TEMPLATES,  
    }
        Property.NodeScope
         * For critical sections run as lambdas which may throw exceptions.
        }
 * - Feature flags are globally available.  
                put(WRITABLE_WARM_INDEX_SETTING, WRITABLE_WARM_INDEX_SETTING.getDefault(Settings.EMPTY));  
    );
         */
    public static final Setting<Boolean> APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING = Setting.boolSetting(
            try (FlagWriteLock ignored = new FlagWriteLock(flag, value)) {
        public static class FlagWriteLock implements AutoCloseable {
        }
            initFromSysProperties();
                return writeLocks.contains(flag);
                featureFlagsImpl.set(flag, prev);
         * - Set from setting default
         * Initialize feature flags map from the following sources:  
 * The OpenSearch Contributors require contributions made to  
        SNAPSHOT_STRICT_VERSION_PARSING,
    public static final String PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG = FEATURE_FLAG_PREFIX + "pluggable.dataformat.enabled";
                    APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING,
import org.opensearch.common.settings.Setting.Property;
    public static final Setting<Boolean> SNAPSHOT_STRICT_VERSION_PARSING_SETTING = Setting.boolSetting(  
                put(
    public static final String STREAM_TRANSPORT = FEATURE_FLAG_PREFIX + "transport.stream.enabled";  
    /**
    }
         */  
                put(DATETIME_FORMATTER_CACHING_SETTING, DATETIME_FORMATTER_CACHING_SETTING.getDefault(Settings.EMPTY));
                writeLocks.add(flag);  
        private static final String TEST_FLAG = "test.flag.enabled";
    public static final Setting<Boolean> TERM_VERSION_PRECOMMIT_ENABLE_SETTING = Setting.boolSetting(  
    );
     */  
         * @param featureFlagName feature flag to set  
     * Gates the visibility of the remote store to docrep migration.
        /**  
        }
         * @param flag feature flag setting.  
            public static boolean isLocked(String flag) {
                    APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getDefault(Settings.EMPTY)  
     */
