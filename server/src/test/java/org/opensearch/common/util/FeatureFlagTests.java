        assertTrue(FeatureFlags.isEnabled(TEST_FLAG)); // flag is locked
        assertFalse(testFlagsImpl.isEnabled(javaVersionProperty));  
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();
    public void testFeatureFlagSettingOverwritesSystemProperties() {
            clearSystemProperty(TEST_FLAG);
    }
    }  
        System.clearProperty(key);
        setSystemPropertyTrue(DNE_FF);  
    public void testLockFeatureFlagWithFlagLock() {  
        try (FeatureFlags.TestUtils.FlagWriteLock ignore = new FeatureFlags.TestUtils.FlagWriteLock(TEST_FLAG)) {
        }
    public void testFeatureFlagsNotInitialized() {
        testFlagsImpl.initializeFeatureFlags(Settings.builder().put(TEST_FLAG, false).build());
        assertFalse(testFlagsImpl.isEnabled(TEST_FLAG));
    }
        testFlagsImpl.initializeFeatureFlags(Settings.builder().put(TEST_FLAG, false).build());  
        synchronized (TEST_FLAG) { // sync for sys property  
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();
        testFlagsImpl.initializeFeatureFlags(Settings.EMPTY);
    @SuppressForbidden(reason = "Testing system property functionality")
        assertTrue(testFlagsImpl.isEnabled(TEST_FLAG));  
        testFlagsImpl.initializeFeatureFlags(Settings.builder().put(TEST_FLAG, true).build());
        assertNotNull(getSystemProperty(javaVersionProperty));
            assertTrue(testFlagsImpl.isEnabled(TEST_FLAG));
    public void testNonBooleanFeatureFlag() {
        String javaVersionProperty = "java.version";
    private void clearSystemProperty(String key) {
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();  
        FeatureFlags.initializeFeatureFlags(Settings.builder().put(TEST_FLAG, false).build());
import org.opensearch.common.SuppressForbidden;
    public void testFeatureDoesNotExist() {
            setSystemPropertyTrue(TEST_FLAG);
    }
    }
    }
    // Evergreen test flag
        synchronized (TEST_FLAG) { // sync for sys property
        System.setProperty(key, "true");
    }  
import static org.opensearch.common.util.FeatureFlags.FEATURE_FLAG_PREFIX;
}
import org.opensearch.common.settings.Settings;
/*  
            assertTrue(FeatureFlags.isEnabled(TEST_FLAG)); // flag is locked
    public void testLockFeatureFlagWithHelper() throws Exception {
    }
            FeatureFlags.initializeFeatureFlags(Settings.builder().put(TEST_FLAG, false).build());
        assertFalse(testFlagsImpl.isEnabled(TEST_FLAG));
            setSystemPropertyTrue(TEST_FLAG);
        assertFalse(testFlagsImpl.isEnabled(DNE_FF));
        assertFalse(testFlagsImpl.isEnabled(TEST_FLAG));  
        }
        testFlagsImpl.initializeFeatureFlags(Settings.EMPTY);
        assertFalse(testFlagsImpl.isEnabled(DNE_FF));
public class FeatureFlagTests extends OpenSearchTestCase {
            assertTrue(FeatureFlags.isEnabled(TEST_FLAG));
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        }  
    public void testFeatureFlagFromSystemProperty() {  
        FeatureFlags.TestUtils.with(TEST_FLAG, () -> {  
        clearSystemProperty(DNE_FF);  
            assertTrue(FeatureFlags.isEnabled(TEST_FLAG)); // flag is locked  
    public void testFeatureFlagsFromDefault() {
     * Test global feature flag instance.  
            testFlagsImpl.initializeFeatureFlags(Settings.EMPTY);
     */
            clearSystemProperty(TEST_FLAG);
    }
    }  
    private void setSystemPropertyTrue(String key) {  
        assertFalse(testFlagsImpl.isEnabled(TEST_FLAG));
    @SuppressForbidden(reason = "Testing system property functionality")  
    }
            FeatureFlags.initializeFeatureFlags(Settings.builder().put(TEST_FLAG, false).build());  
        });
    }  
    @SuppressForbidden(reason = "Testing with system property")
    private String getSystemProperty(String key) {
    @SuppressForbidden(reason = "Testing with system property")  
 */  
        final String DNE_FF = FEATURE_FLAG_PREFIX + "doesntexist";  
        testFlagsImpl.initializeFeatureFlags(Settings.builder().put(DNE_FF, true).build());
        assertFalse(testFlagsImpl.isEnabled(TEST_FLAG));  
    @SuppressForbidden(reason = "Testing system property functionality")
 * The OpenSearch Contributors require contributions made to  
            FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();  
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();
    public void testFeatureFlagFromSettings() {  
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();  
    }  
        assertTrue(FeatureFlags.isEnabled(TEST_FLAG));  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(testFlagsImpl.isEnabled(TEST_FLAG));  
    private static final String TEST_FLAG = "test.flag.enabled";  
 *
    public void testLockFeatureFlagAnnotation() {
package org.opensearch.common.util;
    /**
    @LockFeatureFlag(TEST_FLAG)
            assertTrue(FeatureFlags.isEnabled(TEST_FLAG));
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();
    }
        return System.getProperty(key);  
    public void testFeatureFlagFromEmpty() {  
        FeatureFlags.FeatureFlagsImpl testFlagsImpl = new FeatureFlags.FeatureFlagsImpl();
        assertFalse(testFlagsImpl.isEnabled(DNE_FF));
import org.opensearch.test.OpenSearchTestCase;  
