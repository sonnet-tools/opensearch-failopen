 * SPDX-License-Identifier: Apache-2.0
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);  
package org.opensearch.be.datafusion;
    }
            throw new AssertionError(e);
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
            .put("datafusion.spill_directory", spillDir.toString())  
     * H1 — the cluster-settings listener can fire before {@link DataFusionPlugin#createComponents}
            throw new AssertionError(e);
        assertEquals(Long.toString(expected), DataFusionPlugin.deriveMemoryPoolLimitDefault(s));
    public void testValidateSpillLimitSkipsCapacityCheckWhenProbeFails() {  
            "datafusion.spill_memory_limit_bytes must have node scope",
        // takes its fraction off node.native_memory.limit directly so the buffer can sit
            plugin.updateSpillMemoryLimit(32L * 1024 * 1024);
        );
            .put("datafusion.spill_memory_limit_bytes", total / 2)
 * the cluster settings API can update it at runtime.  
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        assertEquals("", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(Settings.EMPTY));
            IllegalArgumentException.class,
        } catch (Exception e) {  
        );  
            e.getMessage().contains("exceeds spill volume capacity")  
        Settings s = Settings.builder().put("datafusion.spill_directory", nonExistentLeaf.toString()).build();
            plugin.updateMemoryPoolLimit(64L * 1024 * 1024);  
public class DataFusionPluginSettingsTests extends OpenSearchTestCase {
        // Empty default is the sentinel for "spill disabled" — DataFusion will build the
        assertEquals("Empty spill_directory must yield default 0 (spill disabled)", "0", defaultValue);
            536870912L,
            .build();
            // Service field is null — should be a no-op, not an NPE.
            List<Setting<?>> settings = plugin.getSettings();
 * {@code datafusion.memory_pool_limit_bytes} is registered and marked dynamic so
            .build();
            () -> DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.get(s)
import java.nio.file.Path;
        assertTrue(
        // 1000 bytes limit, 20% buffer => pool max still 71% of 1000 = 710.  
    public void testSpillDirectoryDefaultIsEmpty() {  
    }
            DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.hasNodeScope()
        Settings s = Settings.builder().put("node.native_memory.limit", "1000b").put("node.native_memory.buffer_percent", 20).build();
        // Spill disabled (empty directory): a non-zero limit is inert, so it must be accepted rather
        // from limit - buffer_percent (which is AC's throttle margin, not a framework
        assertTrue(
    public void testDeriveMemoryPoolLimitDefaultIgnoresBufferPercent() {
            .put("datafusion.spill_directory", "/nonexistent/path/that/does/not/exist/spill-test-12345")
        assertTrue("datafusion.spill_directory must be Final", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.isFinal());  
        );  
    public void testMemoryPoolLimitRejectsNegative() {
    }
            throw new AssertionError(e);
            "datafusion.memory_guard.spill_exempt_cap_bytes must have node scope",  
    }  
    public void testMemoryPoolLimitSettingExposesDerivedDefault() {
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
/*  
    public void testGetSettingsReturnsAllIndexedSettings() {  
        Settings s = Settings.builder().put("datafusion.spill_directory", "\u0000bad\u0000path").build();
    }  
            DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.isDynamic()
 * The OpenSearch Contributors require contributions made to  
    public void testValidateSpillLimitAcceptsNonZeroWhenSpillDirUnset() {
    // ── datafusion.memory_guard.spill_exempt_cap_bytes ──
        } catch (Exception e) {
            "expected message to mention exceeding capacity, got: " + e.getMessage(),
        assertTrue(
            .put("datafusion.spill_directory", spillDir.toString())  
        assertEquals(Long.toString(Long.MAX_VALUE), DataFusionPlugin.deriveMemoryPoolLimitDefault(s));
    public void testSpillExemptCapIsDynamicAndNodeScope() {  
/**  
        assertEquals(Long.valueOf(expected), DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.get(s));
        IllegalArgumentException e = expectThrows(  
        assertTrue("datafusion.memory_pool_limit_bytes must have node scope", DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.hasNodeScope());  
        // Even though 1 TiB would likely exceed any real disk, the probe fails so the check is skipped.
        // than failing node startup. Mirrors a node configured with a spill cap but no spill volume.  
        assertTrue(e.getMessage().contains("must be >= 0"));
        Settings s = Settings.builder().put("node.native_memory.limit", "0b").build();
    public void testSpillExemptCapIsRegistered() {  
        assertEquals(total / 2, parsed);
        long total = Environment.getFileStore(spillDir).getTotalSpace();
        // get() runs the parser AND the validator; no throw = pass.  
        // node.native_memory.buffer_percent is AC's throttle margin. The framework default  
        // between AC's throttle threshold and the framework's hard cap.
            DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.isDynamic()
    public void testUpdateSpillMemoryLimitBeforeServiceStartDoesNotThrow() {  
 */  
        assertTrue("datafusion.memory_pool_limit_bytes must have node scope", DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.hasNodeScope());  
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").build();  
        assertEquals("710", DataFusionPlugin.deriveMemoryPoolLimitDefault(s));
    }
        }  
        // startup; changing the directory at runtime would orphan in-flight spill files.  
            IllegalArgumentException.class,
        // 10 GiB native memory limit — default takes 71% straight from limit, not  
    }  
        assertEquals("probe failure must skip the volume-capacity check", 1024L * 1024 * 1024 * 1024, parsed);
            DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.isDynamic()  
    }  
    public void testValidateSpillLimitAcceptsZeroWhenSpillDirUnset() {  
        Settings settings = Settings.builder()
        }
 */
                settings.contains(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT)
            assertTrue(
    public void testValidateSpillLimitRejectsValueExceedingDiskCapacity() throws Exception {
        Settings s = Settings.builder().put("datafusion.memory_pool_limit_bytes", -1L).build();
            );  
    }
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
    public void testPluginRegistersMemoryPoolLimitSetting() {  
    }  
    public void testSpillDirectoryIsRegistered() {
        assertEquals("non-zero limit with spill disabled must be accepted as a no-op", 1024L * 1024 * 1024, parsed);  
    public void testDeriveMemoryPoolLimitDefaultUsesNativeMemoryLimit() {
    }
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
    }
    public void testDeriveSpillLimitDefaultWithValidSpillDirReturnsFractionOfTotal() throws Exception {
    }  
        assertTrue(e.getMessage().contains("must be >= 0"));
            throw new AssertionError(e);  
    }
            assertTrue(  
            throw new AssertionError(e);  
    public void testValidateSpillLimitAcceptsValueAtOrBelowDiskCapacity() throws Exception {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));  
        Settings settings = Settings.builder()
        // Nul-byte path is unparseable by Path.of; the validator must reject it with a  
        // The leaf directory may not exist yet at plugin-startup time (host-fleet boot script
        // could still be mounting the volume). Validator accepts on syntactic grounds only;
            e.getMessage().contains("datafusion.spill_directory")  
        assertTrue("datafusion.spill_directory must have node scope", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.hasNodeScope());
 * this file be licensed under the Apache-2.0 license or a
                "Plugin must register DATAFUSION_MEMORY_POOL_LIMIT via getSettings()",
            DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.hasNodeScope()
        }
            );  
            .put("datafusion.spill_directory", "/nonexistent/path/that/does/not/exist/spill-test-12345")
import org.opensearch.env.Environment;  
        long total = Environment.getFileStore(spillDir).getTotalSpace();
        // runtime spill writes surface any permission/mount issues.  
        Settings settings = Settings.builder().put("datafusion.spill_directory", "").build();
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
            throw new AssertionError(e);
        long expected = (10L * 1024 * 1024 * 1024) * 71 / 100;
    }
        assertEquals(nonExistentLeaf.toString(), DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));
            assertNull(plugin.getDatafusionSettings());  
        long actual = Long.parseLong(DataFusionPlugin.deriveSpillLimitDefault(settings));
                settings.contains(DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP)
     */
                "Plugin must register DATAFUSION_SPILL_MEMORY_LIMIT via getSettings()",
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        Path tmp = createTempDir();
    }  
    public void testSpillDirectoryIsFinalAndNodeScope() {
    public void testSpillDirectoryAcceptsEmptyValue() {
        }
            "datafusion.spill_memory_limit_bytes must be dynamic so cluster-state updates are accepted; "
    }
        assertTrue(
        );
            .put("datafusion.spill_memory_limit_bytes", 1024L * 1024 * 1024 * 1024) // 1 TiB  
    }
import java.util.List;
            "datafusion.memory_guard.spill_exempt_cap_bytes must be dynamic so it can be tuned at runtime",
        IllegalArgumentException e = expectThrows(  
    public void testSpillExemptCapRejectsNegative() {
        assertEquals(  
        Settings settings = Settings.builder().put("datafusion.spill_directory", spillDir.toString()).build();  
                + "live propagation depends on the loaded native library",  
    /**
        );
    public void testDeriveSpillLimitDefaultWithMissingSpillDirReturnsFallback() {
    }
     * is called (service field still null). {@code updateMemoryPoolLimit} must swallow this quietly  
    }  
        } catch (Exception e) {
            IllegalArgumentException.class,
                "Plugin must register DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP via getSettings()",
        }  
        // into spill. This preserves a sensible default for self-managed clusters that  
     * The cluster-settings listener can fire before {@link DataFusionPlugin#createComponents}
        Settings settings = Settings.builder()
        // operator. Same fail-open behavior as deriveSpillLimitDefault uses for its 8 GiB fallback.  
    public void testMemoryPoolLimitIsDynamic() {
    }  
            );
        } catch (Exception e) {
                "Plugin must register DATAFUSION_SPILL_DIRECTORY via getSettings()",
    }
        } catch (Exception e) {
        // Explicitly setting the value to empty must also pass validation — same effect as  
import org.opensearch.test.OpenSearchTestCase;
            );
 * compatible open source license.
     * so the cluster-state update does not log a failure during node startup.
            DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.get(Settings.EMPTY).longValue()  
        Settings s = Settings.builder().put("datafusion.spill_directory", tmp.toString()).build();
    }
    public void testGetSettingsReturnsTotalExpectedCount() {
                settings.contains(DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT)  
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").build();  
        long total = Environment.getFileStore(spillDir).getTotalSpace();
            .put("datafusion.spill_memory_limit_bytes", total + 1)
            "error message should reference the setting key, got: " + e.getMessage(),
    public void testSpillDirectoryRejectsInvalidPathSyntax() {
    }
    }  
    }  
        // When the spill directory cannot be probed (e.g. a path that doesn't exist),
        Path nonExistentLeaf = existingParent.resolve("spill-not-yet-mounted");
            assertEquals(33, settings.size());
        );
            assertTrue(
        );
        assertEquals("Zero with spill disabled is valid", 0L, parsed);  
        } catch (Exception e) {  
        Settings s = Settings.builder().put("datafusion.spill_directory", "").build();
        long actual = Long.parseLong(DataFusionPlugin.deriveSpillLimitDefault(settings));
            Set<String> settingKeys = settings.stream().map(Setting::getKey).collect(Collectors.toSet());  
        Settings settings = Settings.builder().put("datafusion.spill_directory", "").put("datafusion.spill_memory_limit_bytes", 0L).build();
     * application does not log a spurious failure during node startup.
    /**  
        // AC explicitly unconfigured — the default must be Long.MAX_VALUE (unbounded),
            "datafusion.memory_pool_limit_bytes must be dynamic to support runtime updates",  
        );  
        assertTrue(Files.notExists(nonExistentLeaf));  
        Path spillDir = createTempDir();
        // budget reduction). 71% of 10 GiB.
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
import org.opensearch.common.settings.Setting;
            List<Setting<?>> settings = plugin.getSettings();
            throw new AssertionError(e);
import java.nio.file.Files;  
import java.util.stream.Collectors;
}  
        // clear error message that references the setting key.
        // the validator must fail open: skip the capacity check rather than block the
        );
    }
        // preserving pre-AC behaviour. The default for node.native_memory.limit is now
    }
        Settings settings = Settings.builder()
        }  
        IllegalArgumentException e = expectThrows(  
    public void testSpillDirectoryAcceptsPathThatDoesNotYetExist() throws Exception {  
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").put("datafusion.memory_pool_limit_bytes", 1024L).build();  
     * quietly to mirror {@link DataFusionPlugin#updateMemoryPoolLimit} so cluster-state  
            "Default spill-exempt cap must be 512 MiB in raw bytes",
        Path existingParent = createTempDir();
        // Path that doesn't exist → getFileStore throws IOException → fallback applies.  
        assertEquals(tmp.toString(), DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));  
    public void testMemoryPoolLimitHasNodeScope() {
        assertTrue("test host must report a non-zero total space for the temp dir", total > 0);
 *
            .build();
        assertTrue(
        );
        Settings s = Settings.builder().put("datafusion.memory_guard.spill_exempt_cap_bytes", -1L).build();
    public void testDeriveMemoryPoolLimitDefaultUnsetReturnsLongMaxValue() {  
        } catch (Exception e) {  
        assertEquals("", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));  
            assertTrue(settingKeys.contains("datafusion.batch_size"));
     * is called (service field still null). {@code updateSpillMemoryLimit} must swallow this
            assertTrue(  
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
    public void testDeriveSpillLimitDefaultWithEmptySpillDirReturnsZero() {
import org.opensearch.common.settings.Settings;
        // never configured the setting.
            .put("datafusion.spill_directory", "")
            () -> DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.get(s)
    public void testMemoryPoolLimitSettingExplicitOverridesDerived() {
    }
        assertEquals(Long.valueOf(1024L), DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.get(s));
    }  
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {  
        assertTrue(  
    // ── datafusion.spill_directory (task 1.1) ──
        }
            .build();
    public void testUpdateMemoryPoolLimitBeforeServiceStartDoesNotThrow() {  
        assertTrue(
            throw new AssertionError(e);
        }
        // runtime in DiskManagerMode::Disabled. Setting the value to a real path opts back
            assertTrue(settingKeys.contains("datafusion.indexed.min_skip_run_selectivity_threshold"));
        );  
    }
        String defaultValue = DataFusionPlugin.deriveSpillLimitDefault(settings);  
            List<Setting<?>> settings = plugin.getSettings();
            .put("datafusion.spill_memory_limit_bytes", 1024L * 1024 * 1024)  
                settings.contains(DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY)  
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        // Final because DataFusion's DiskManagerMode::Directories is built once at runtime
        assertEquals("Default must be 90% of the spill volume's total space", expected, actual);
    public void testSpillMemoryLimitIsDynamic() {  
        Path spillDir = createTempDir();  
 * Verifies the settings declared by {@link DataFusionPlugin} — in particular that
    }  
     */
    public void testSpillExemptCapDefaultIs512MiB() {
            assertTrue(settingKeys.contains("datafusion.listing_table.pushdown_filters"));  
        } catch (Exception e) {
    }
            () -> DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings)
        long expected = (long) (total * 0.90);  
    }
import java.util.Set;  
    public void testSpillDirectoryAcceptsValidExistingPath() throws Exception {  
        assertFalse("datafusion.spill_directory must NOT be dynamic", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.isDynamic());
        // leaving it unset (spill disabled).
    public void testDatafusionSettingsIsNullBeforeCreateComponents() {
            List<Setting<?>> settings = plugin.getSettings();
            List<Setting<?>> settings = plugin.getSettings();  
        Settings settings = Settings.builder()
        Path spillDir = createTempDir();  
        // ram - heap, so to test the "unset" branch we must explicitly set it to 0.  
            assertTrue(settingKeys.contains("datafusion.indexed.min_skip_run_default"));
            .build();  
        assertEquals("Probe failure must fall back to 8 GiB", 8L * 1024 * 1024 * 1024, actual);
        long expected = (10L * 1024 * 1024 * 1024) * 71 / 100;
