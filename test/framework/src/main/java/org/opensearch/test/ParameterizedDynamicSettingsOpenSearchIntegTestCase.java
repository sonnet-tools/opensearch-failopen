import org.opensearch.common.settings.Settings;
/**  
 * </ul>  
 * instead).  
    }
 *   <li><b>test scope</b>: for each test method { create cluster -&gt;  apply settings -&gt; run test method -&gt; unapply settings -&gt; shutdown cluster }</li>
    public void beforeTests() {
 * settings will be applied dynamically, please notice that not all settings could be changed dynamically (consider using {@link ParameterizedStaticSettingsOpenSearchIntegTestCase}
import org.opensearch.common.settings.SettingsModule;
    @Before
 * Here is the simple illustration on of the execution flow per parameters combination:
        settings.keySet().forEach(settingsToUnset::putNull);  
        return true;  
        SettingsModule settingsModule = new SettingsModule(settings);  
public abstract class ParameterizedDynamicSettingsOpenSearchIntegTestCase extends ParameterizedOpenSearchIntegTestCase {
 * Base class for running the tests with parameterization using dynamic settings: the cluster will be created once before the test suite and the
package org.opensearch.test;
        for (String key : settings.keySet()) {
/*  
    public void afterTests() {
            return false;
        final Settings.Builder settingsToUnset = Settings.builder();
import org.junit.After;  
import org.junit.Before;
        if (getClass() != obj.getClass()) {
            return true;
    public ParameterizedDynamicSettingsOpenSearchIntegTestCase(Settings dynamicSettings) {  
    }
        }  
                settingsModule.getClusterSettings().isDynamicSetting(key) || settingsModule.getIndexScopedSettings().isDynamicSetting(key)  
 *   <li><b>suite scope</b>: create cluster -&gt; for each test method { apply settings -&gt; run test method -&gt; unapply settings } -&gt; shutdown cluster</li>
            );
 * SPDX-License-Identifier: Apache-2.0
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settingsToUnset).get();
 *
    }
 */
        }
}
        }
        super(dynamicSettings);
    @Override
        if (this == obj) {  
            assertTrue(
 * this file be licensed under the Apache-2.0 license or a
 */  
    }
    @After  
    boolean hasSameParametersAs(ParameterizedOpenSearchIntegTestCase obj) {
 * The OpenSearch Contributors require contributions made to  
        }
 * compatible open source license.
 * <p>
 * <ul>  
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();  
            return false;  
        if (obj == null) {
