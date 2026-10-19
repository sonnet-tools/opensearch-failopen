    );  
 * @opensearch.internal  
 */
import org.opensearch.common.util.FeatureFlags;
        FeatureFlags.TELEMETRY_SETTING,  
/*  
        FeatureFlags.TERM_VERSION_PRECOMMIT_ENABLE_SETTING,
    ) {  
        Set<Setting<?>> settingsSet,  
}
        FeatureFlags.WRITABLE_WARM_INDEX_SETTING,
 */  
public class FeatureFlagSettings extends AbstractScopedSettings {
/**  
 * compatible open source license.
    public static final Set<Setting<?>> BUILT_IN_FEATURE_FLAGS = Set.of(
 * SPDX-License-Identifier: Apache-2.0
        FeatureFlags.STREAM_TRANSPORT_SETTING,  
        Set<SettingUpgrader<?>> settingUpgraders,
        FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING,  
 * this file be licensed under the Apache-2.0 license or a
        super(settings, settingsSet, settingUpgraders, scope);
    }
        FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING,
 * The OpenSearch Contributors require contributions made to  
        FeatureFlags.DATETIME_FORMATTER_CACHING_SETTING,
import java.util.Set;
 * Encapsulates all valid feature flag level settings.
    protected FeatureFlagSettings(
import org.opensearch.common.settings.Setting.Property;
        FeatureFlags.EXTENSIONS_SETTING,
package org.opensearch.common.settings;
 *
        FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_SETTING,
        FeatureFlags.SNAPSHOT_RESILIENCE_SETTING
 *
        Property scope
        Settings settings,
