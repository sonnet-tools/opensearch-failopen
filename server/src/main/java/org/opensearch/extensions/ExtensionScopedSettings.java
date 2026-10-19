 * compatible open source license.
}  
import org.opensearch.common.settings.Setting.Property;  
 */
public final class ExtensionScopedSettings extends AbstractScopedSettings {  
    public ExtensionScopedSettings(final Set<Setting<?>> settingsSet, final Set<SettingUpgrader<?>> settingUpgraders) {  
 * Encapsulates all valid extension level settings.
import org.opensearch.common.settings.Settings;
    public ExtensionScopedSettings(final Set<Setting<?>> settingsSet) {
        super(Settings.EMPTY, settingsSet, settingUpgraders, Property.ExtensionScope);
import org.opensearch.common.settings.AbstractScopedSettings;
 */  
        this(settingsSet, Collections.emptySet());  
package org.opensearch.extensions;
/*  
 * @opensearch.internal
/**
 *  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
import java.util.Collections;
    }
 * The OpenSearch Contributors require contributions made to  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.SettingUpgrader;
 *
import org.opensearch.common.settings.Setting;
