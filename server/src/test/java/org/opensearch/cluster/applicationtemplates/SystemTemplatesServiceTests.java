 *
            // ClusterSettings.validate only invokes a setting's validator when that setting's key is present in the update.
            SystemTemplatesService.ApplicationTemplatesEnabledValidator validator =  
            SystemTemplatesService.Stats stats = systemTemplatesService.stats();
            assertEquals(stats.getTemplatesLoaded(), iter % 2);
import org.opensearch.common.util.FeatureFlags;
        SystemTemplatesService.Stats stats = systemTemplatesService.stats();
        }
            mockPool,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        });
            // settings update would be rejected whenever the (off-by-default) experimental flag is disabled. So with the  
import org.opensearch.common.settings.Settings;  
        assertNotNull(stats);
            assertEquals(stats.getFailedLoadingRepositories(), iter % 2);
    private void setupService(boolean errorFromMockPlugin) throws IOException {
        );
            // Regression guard for the DoS hazard: settings-update validation runs a setting's validator against its
    public void testSystemTemplatesLoaded() throws IOException {  
        systemTemplatesService.verifyRepositories();  
    public void testSystemTemplatesVerifyWithFailingRepository() throws IOException {
        assertNotNull(stats);  
import org.opensearch.cluster.service.applicationtemplates.TestSystemTemplatesRepositoryPlugin;
            // And an explicit disable through the settings path is accepted too.
                new SystemTemplatesService.ApplicationTemplatesEnabledValidator();
        assertEquals(stats.getFailedLoadingTemplates(), 0L);
        if (errorFromMockPlugin) {
    }
            // Enabling the setting must be rejected during settings-update validation (before commit), not at apply time.
import java.util.List;
            // flag off it must accept both the default and an explicit false. Asserting the validator directly, because
        // Do it multiple times to ensure verify checks are always executed.
import org.mockito.Mockito;
        List<SystemTemplatesPlugin> plugins = new ArrayList<>();
        setupService(true);
                .build();
import static org.mockito.Mockito.when;
            assertEquals(stats.getTemplatesLoaded(), 0L);
            assertNotNull(stats);  
        plugins.add(new TestSystemTemplatesRepositoryPlugin());  
        systemTemplatesService.onClusterManager();
        });
            assertEquals(stats.getFailedLoadingRepositories(), 1L);  
            Settings enable = Settings.builder()  
import java.io.IOException;  
    public void testValidatorDoesNotThrowOnDefaultOrDisableWhenFlagOff() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(stats.getFailedLoadingTemplates(), 0L);  
            cs.validate(disable, true);  
        // First time load should happen, second time should short circuit.  
        setupService(true);
    public void testEnablingWithoutFeatureFlagRejectedAtValidation() throws Exception {
            ClusterSettings cs = new ClusterSettings(Settings.EMPTY, BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(stats.getFailedLoadingTemplates(), 0L);
        stats = systemTemplatesService.stats();
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)  
        for (int iter = 1; iter <= 2; iter++) {
/*  
 * SPDX-License-Identifier: Apache-2.0
            SystemTemplatesPlugin mockPlugin = Mockito.mock(SystemTemplatesPlugin.class);  
            plugins,
    private SystemTemplatesService systemTemplatesService;  
package org.opensearch.cluster.applicationtemplates;
 * The OpenSearch Contributors require contributions made to  
            assertEquals(stats.getFailedLoadingTemplates(), 0L);
        }
            mockSettings,  
            systemTemplatesService.onClusterManager();
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
                .put(SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), true)
    public void testSystemTemplatesVerifyAndLoad() throws IOException {  
import static org.opensearch.common.util.FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES;
        assertEquals(stats.getFailedLoadingRepositories(), 0L);  
        assertEquals(stats.getTemplatesLoaded(), 0L);  
            when(mockPlugin.loadRepository()).thenThrow(new IOException());
    }  
        FeatureFlags.TestUtils.with(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false, () -> {  
        setupService(false);
            assertNotNull(stats);
            ClusterSettings cs = new ClusterSettings(Settings.EMPTY, BUILT_IN_CLUSTER_SETTINGS);
            plugins.add(mockPlugin);
            Settings.builder().put(SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), true).build()
public class SystemTemplatesServiceTests extends OpenSearchTestCase {
        when(mockPool.generic()).thenReturn(OpenSearchExecutors.newDirectExecutorService());  
}  
 * compatible open source license.
            validator.validate(false); // default / explicit disable — must not throw with the flag off
        assertEquals(stats.getTemplatesLoaded(), 1L);
import org.opensearch.common.settings.ClusterSettings;
                .build();
import org.opensearch.threadpool.ThreadPool;
import java.util.ArrayList;
    }
        ThreadPool mockPool = Mockito.mock(ThreadPool.class);
            Settings disable = Settings.builder()  
 */  
    @LockFeatureFlag(APPLICATION_BASED_CONFIGURATION_TEMPLATES)
        FeatureFlags.TestUtils.with(APPLICATION_BASED_CONFIGURATION_TEMPLATES, false, () -> {  
    }  
        for (int i = 0; i < 2; i++) {
import static org.opensearch.common.settings.ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
            SystemTemplatesService.Stats stats = systemTemplatesService.stats();  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validate(enable, true));  
            // CURRENT/DEFAULT value on every _cluster/settings update. If this validator threw on false, every cluster
    }
            assertThrows(IllegalStateException.class, () -> systemTemplatesService.verifyRepositories());  
        ClusterSettings mockSettings = new ClusterSettings(Settings.EMPTY, BUILT_IN_CLUSTER_SETTINGS);
                .put(SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), false)
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(stats.getFailedLoadingRepositories(), 0L);
        systemTemplatesService = new SystemTemplatesService(  
    }  
            assertTrue(e.getMessage().contains("experimental feature"));
        }  
