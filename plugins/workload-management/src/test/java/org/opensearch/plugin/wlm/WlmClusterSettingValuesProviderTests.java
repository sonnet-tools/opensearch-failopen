    }
import org.opensearch.wlm.WorkloadManagementSettings;
        return spy(realProvider);  
        assertThrows(IllegalStateException.class, () -> spyProvider.ensureWlmEnabled(""));
import java.util.HashSet;
        try (WorkloadManagementPlugin plugin = new WorkloadManagementPlugin()) {  
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.ClusterSettings;
    }  
}
            clusterSettings.registerSetting(WorkloadManagementSettings.WLM_MODE_SETTING);
    @Before  
import static org.mockito.Mockito.spy;  
package org.opensearch.plugin.wlm;
    public void testEnsureWlmEnabledThrowsWhenMonitorOnly() {
    private WlmClusterSettingValuesProvider createSpyProviderWithMode(String mode) {  
public class WlmClusterSettingValuesProviderTests extends OpenSearchTestCase {
    public void testEnsureWlmEnabledSucceedsWhenEnabled() {
    public void setUp() throws Exception {
            clusterSettings = new ClusterSettings(Settings.EMPTY, new HashSet<>(plugin.getSettings()));
    public void testEnsureWlmEnabledThrowsWhenDisabled() {  
 */  
    }
    }
        WlmClusterSettingValuesProvider spyProvider = createSpyProviderWithMode("disabled");
        assertThrows(IllegalStateException.class, () -> spyProvider.ensureWlmEnabled(""));
/*  
        spyProvider.ensureWlmEnabled("");  
import org.junit.Before;
    private ClusterSettings clusterSettings;
 * The OpenSearch Contributors require contributions made to  
        WlmClusterSettingValuesProvider spyProvider = createSpyProviderWithMode("enabled");
    }
 * compatible open source license.
        Settings settings = Settings.builder().put(WorkloadManagementSettings.WLM_MODE_SETTING.getKey(), mode).build();
        WlmClusterSettingValuesProvider realProvider = new WlmClusterSettingValuesProvider(settings, clusterSettings);
import org.opensearch.common.settings.Settings;
        WlmClusterSettingValuesProvider spyProvider = createSpyProviderWithMode("monitor_only");  
import org.opensearch.test.OpenSearchTestCase;  
        }  
        super.setUp();
