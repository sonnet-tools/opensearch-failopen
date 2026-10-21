        assertTrue(e.getMessage().contains("must be >= 0"));
        // budget reduction). 71% of 10 GiB.
            "datafusion.memory_guard.spill_exempt_cap_bytes must be dynamic so it can be tuned at runtime",
        assertEquals(Long.valueOf(expected), DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.get(s));
            "datafusion.memory_guard.spill_exempt_cap_bytes must have node scope",
        } catch (Exception e) {
        Settings s = Settings.builder().put("datafusion.spill_directory", nonExistentLeaf.toString()).build();
import org.opensearch.env.Environment;
        // Empty default is the sentinel for "spill disabled" — DataFusion will build the
    }
        );
        String defaultValue = DataFusionPlugin.deriveSpillLimitDefault(settings);
            plugin.updateMemoryPoolLimit(64L * 1024 * 1024);
    public void testValidateSpillLimitAcceptsValueAtOrBelowDiskCapacity() throws Exception {
}
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        assertEquals(total / 2, parsed);
        assertTrue(
        Settings s = Settings.builder().put("datafusion.memory_pool_limit_bytes", -1L).build();
    public void testValidateSpillLimitAcceptsNonZeroWhenSpillDirUnset() {
 * SPDX-License-Identifier: Apache-2.0
        );
        }
    }
    public void testMemoryPoolLimitSettingExplicitOverridesDerived() {
        assertTrue("datafusion.spill_directory must have node scope", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.hasNodeScope());
            "datafusion.spill_memory_limit_bytes must have node scope",
        );
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").build();
        assertEquals(tmp.toString(), DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));
    public void testMemoryPoolLimitHasNodeScope() {
    public void testGetSettingsReturnsTotalExpectedCount() {
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        Settings settings = Settings.builder()
            assertTrue(
        // leaving it unset (spill disabled).
            plugin.updateSpillMemoryLimit(32L * 1024 * 1024);
        // node.native_memory.buffer_percent is AC's throttle margin. The framework default
    }
            .put("datafusion.spill_directory", "/nonexistent/path/that/does/not/exist/spill-test-12345")
import org.opensearch.common.settings.Settings;
        );
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").put("datafusion.memory_pool_limit_bytes", 1024L).build();
    public void testDeriveMemoryPoolLimitDefaultUsesNativeMemoryLimit() {
package org.opensearch.be.datafusion;
            DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.isDynamic()
        assertTrue("test host must report a non-zero total space for the temp dir", total > 0);
    public void testSpillExemptCapIsRegistered() {
            IllegalArgumentException.class,
        // runtime spill writes surface any permission/mount issues.
        } catch (Exception e) {
    public void testMemoryPoolLimitSettingExposesDerivedDefault() {
            .put("datafusion.spill_directory", spillDir.toString())
            assertNull(plugin.getDatafusionSettings());
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        Settings s = Settings.builder().put("node.native_memory.limit", "1000b").put("node.native_memory.buffer_percent", 20).build();
    }
        // When the spill directory cannot be probed (e.g. a path that doesn't exist),
import java.util.Set;
    }
        long actual = Long.parseLong(DataFusionPlugin.deriveSpillLimitDefault(settings));
    }
        assertEquals("non-zero limit with spill disabled must be accepted as a no-op", 1024L * 1024 * 1024, parsed);
            .put("datafusion.spill_memory_limit_bytes", total / 2)
        long actual = Long.parseLong(DataFusionPlugin.deriveSpillLimitDefault(settings));
            assertEquals(33, settings.size());
 */
        }
 * Verifies the settings declared by {@link DataFusionPlugin} — in particular that
            .build();
    // ── datafusion.spill_directory (task 1.1) ──
            );
import java.nio.file.Files;
        // into spill. This preserves a sensible default for self-managed clusters that
        long expected = (long) (total * 0.90);
        // Final because DataFusion's DiskManagerMode::Directories is built once at runtime
        assertTrue(
            throw new AssertionError(e);
    public void testSpillDirectoryAcceptsEmptyValue() {
        assertEquals("710", DataFusionPlugin.deriveMemoryPoolLimitDefault(s));
    /**
    public void testSpillDirectoryAcceptsValidExistingPath() throws Exception {
            throw new AssertionError(e);
        Settings settings = Settings.builder().put("datafusion.spill_directory", spillDir.toString()).build();
    }
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testUpdateSpillMemoryLimitBeforeServiceStartDoesNotThrow() {
    }
            assertTrue(
        Settings settings = Settings.builder()
        } catch (Exception e) {
            throw new AssertionError(e);
        // get() runs the parser AND the validator; no throw = pass.
            "datafusion.spill_memory_limit_bytes must be dynamic so cluster-state updates are accepted; "
            throw new AssertionError(e);
                settings.contains(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT)
    public void testDeriveSpillLimitDefaultWithMissingSpillDirReturnsFallback() {
    }
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
    public void testValidateSpillLimitAcceptsZeroWhenSpillDirUnset() {
        IllegalArgumentException e = expectThrows(
        Path tmp = createTempDir();
            .put("datafusion.spill_memory_limit_bytes", 1024L * 1024 * 1024 * 1024) // 1 TiB
    }
        Settings s = Settings.builder().put("node.native_memory.limit", "10gb").build();
            "Default spill-exempt cap must be 512 MiB in raw bytes",
        );
        // 1000 bytes limit, 20% buffer => pool max still 71% of 1000 = 710.
        assertTrue(Files.notExists(nonExistentLeaf));
        Settings s = Settings.builder().put("datafusion.spill_directory", "\u0000bad\u0000path").build();
        assertEquals("Empty spill_directory must yield default 0 (spill disabled)", "0", defaultValue);
        // clear error message that references the setting key.
     * application does not log a spurious failure during node startup.
    }
     */
        // from limit - buffer_percent (which is AC's throttle margin, not a framework
        assertTrue("datafusion.memory_pool_limit_bytes must have node scope", DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.hasNodeScope());
        } catch (Exception e) {
        assertTrue("datafusion.spill_directory must be Final", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.isFinal());
        Path spillDir = createTempDir();
            List<Setting<?>> settings = plugin.getSettings();
                "Plugin must register DATAFUSION_SPILL_MEMORY_LIMIT via getSettings()",
        long total = Environment.getFileStore(spillDir).getTotalSpace();
    public void testDatafusionSettingsIsNullBeforeCreateComponents() {
        assertTrue("datafusion.memory_pool_limit_bytes must have node scope", DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.hasNodeScope());
 * the cluster settings API can update it at runtime.
        Settings settings = Settings.builder().put("datafusion.spill_directory", "").build();
        );
        long total = Environment.getFileStore(spillDir).getTotalSpace();
    // ── datafusion.memory_guard.spill_exempt_cap_bytes ──
    public void testValidateSpillLimitRejectsValueExceedingDiskCapacity() throws Exception {
            () -> DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings)
 *
     */
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        Settings settings = Settings.builder()
            assertTrue(settingKeys.contains("datafusion.indexed.min_skip_run_selectivity_threshold"));
            IllegalArgumentException.class,
    public void testDeriveMemoryPoolLimitDefaultUnsetReturnsLongMaxValue() {
public class DataFusionPluginSettingsTests extends OpenSearchTestCase {
            () -> DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.get(s)
            List<Setting<?>> settings = plugin.getSettings();
            "error message should reference the setting key, got: " + e.getMessage(),
    public void testDeriveSpillLimitDefaultWithValidSpillDirReturnsFractionOfTotal() throws Exception {
     * H1 — the cluster-settings listener can fire before {@link DataFusionPlugin#createComponents}
            .put("datafusion.spill_memory_limit_bytes", 1024L * 1024 * 1024)
            DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.isDynamic()
                settings.contains(DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP)
     * quietly to mirror {@link DataFusionPlugin#updateMemoryPoolLimit} so cluster-state
    public void testSpillDirectoryDefaultIsEmpty() {
     * The cluster-settings listener can fire before {@link DataFusionPlugin#createComponents}
    public void testMemoryPoolLimitRejectsNegative() {
                "Plugin must register DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP via getSettings()",
    public void testMemoryPoolLimitIsDynamic() {
        Settings settings = Settings.builder()
        // Nul-byte path is unparseable by Path.of; the validator must reject it with a
        // the validator must fail open: skip the capacity check rather than block the
    }
        // operator. Same fail-open behavior as deriveSpillLimitDefault uses for its 8 GiB fallback.
            // Service field is null — should be a no-op, not an NPE.
        assertEquals("", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));
     * so the cluster-state update does not log a failure during node startup.
    public void testSpillExemptCapIsDynamicAndNodeScope() {
            throw new AssertionError(e);
            .put("datafusion.spill_directory", "/nonexistent/path/that/does/not/exist/spill-test-12345")
        assertEquals("probe failure must skip the volume-capacity check", 1024L * 1024 * 1024 * 1024, parsed);
    }
    public void testSpillDirectoryRejectsInvalidPathSyntax() {
        Settings s = Settings.builder().put("datafusion.spill_directory", "").build();
            DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.get(Settings.EMPTY).longValue()
        // ram - heap, so to test the "unset" branch we must explicitly set it to 0.
        assertEquals("Probe failure must fall back to 8 GiB", 8L * 1024 * 1024 * 1024, actual);
    public void testSpillExemptCapRejectsNegative() {
            "expected message to mention exceeding capacity, got: " + e.getMessage(),
        IllegalArgumentException e = expectThrows(
    public void testSpillMemoryLimitIsDynamic() {
    }
        assertEquals("Zero with spill disabled is valid", 0L, parsed);
 */
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
        long total = Environment.getFileStore(spillDir).getTotalSpace();
        long expected = (10L * 1024 * 1024 * 1024) * 71 / 100;
        );
        // The leaf directory may not exist yet at plugin-startup time (host-fleet boot script
        );
    }
            e.getMessage().contains("datafusion.spill_directory")
            .build();
            DataFusionPlugin.DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.hasNodeScope()
                "Plugin must register DATAFUSION_MEMORY_POOL_LIMIT via getSettings()",
        // runtime in DiskManagerMode::Disabled. Setting the value to a real path opts back
        assertEquals(nonExistentLeaf.toString(), DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));
    public void testDeriveSpillLimitDefaultWithEmptySpillDirReturnsZero() {
        );
            assertTrue(settingKeys.contains("datafusion.batch_size"));
        // than failing node startup. Mirrors a node configured with a spill cap but no spill volume.
            List<Setting<?>> settings = plugin.getSettings();
        );
    /**
import java.util.List;
        assertEquals("", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(Settings.EMPTY));
            "datafusion.memory_pool_limit_bytes must be dynamic to support runtime updates",
        // 10 GiB native memory limit — default takes 71% straight from limit, not
            DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.hasNodeScope()
 * The OpenSearch Contributors require contributions made to
            throw new AssertionError(e);
    public void testUpdateMemoryPoolLimitBeforeServiceStartDoesNotThrow() {
        Path nonExistentLeaf = existingParent.resolve("spill-not-yet-mounted");
            Set<String> settingKeys = settings.stream().map(Setting::getKey).collect(Collectors.toSet());
    }
    }
        assertTrue(e.getMessage().contains("must be >= 0"));
        // Even though 1 TiB would likely exceed any real disk, the probe fails so the check is skipped.
            () -> DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.get(s)
        }
        } catch (Exception e) {
        assertTrue(
    }
        // between AC's throttle threshold and the framework's hard cap.
        } catch (Exception e) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.get(s));
        assertTrue(
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
    }
        assertEquals(
    }
            assertTrue(
    }
            );
    public void testPluginRegistersMemoryPoolLimitSetting() {
    }
            throw new AssertionError(e);
        assertEquals("Default must be 90% of the spill volume's total space", expected, actual);
    }
        }
            .build();
            .put("datafusion.spill_directory", spillDir.toString())
        // Spill disabled (empty directory): a non-zero limit is inert, so it must be accepted rather
        // never configured the setting.
        // preserving pre-AC behaviour. The default for node.native_memory.limit is now
     * is called (service field still null). {@code updateSpillMemoryLimit} must swallow this
     * is called (service field still null). {@code updateMemoryPoolLimit} must swallow this quietly
/**
            assertTrue(settingKeys.contains("datafusion.listing_table.pushdown_filters"));
            .put("datafusion.spill_directory", "")
        } catch (Exception e) {
        // Path that doesn't exist → getFileStore throws IOException → fallback applies.
        Settings settings = Settings.builder().put("datafusion.spill_directory", "").put("datafusion.spill_memory_limit_bytes", 0L).build();
    public void testSpillExemptCapDefaultIs512MiB() {
    }
            );
            536870912L,
        }
    }
import java.util.stream.Collectors;
            .build();
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
    }
                "Plugin must register DATAFUSION_SPILL_DIRECTORY via getSettings()",
        assertTrue(
    }
        Settings settings = Settings.builder()
        assertTrue(
        }
        // Explicitly setting the value to empty must also pass validation — same effect as
            List<Setting<?>> settings = plugin.getSettings();
 * {@code datafusion.memory_pool_limit_bytes} is registered and marked dynamic so
        // startup; changing the directory at runtime would orphan in-flight spill files.
        }
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
            DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.isDynamic()
            List<Setting<?>> settings = plugin.getSettings();
import org.opensearch.test.OpenSearchTestCase;
            e.getMessage().contains("exceeds spill volume capacity")
                + "live propagation depends on the loaded native library",
            throw new AssertionError(e);
import java.nio.file.Path;
        Settings s = Settings.builder().put("node.native_memory.limit", "0b").build();
    public void testSpillDirectoryIsRegistered() {
        assertFalse("datafusion.spill_directory must NOT be dynamic", DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.isDynamic());
    public void testValidateSpillLimitSkipsCapacityCheckWhenProbeFails() {
        assertEquals(Long.valueOf(1024L), DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.get(s));
    }
    public void testDeriveMemoryPoolLimitDefaultIgnoresBufferPercent() {
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
            assertTrue(
    }
    }
/*
                settings.contains(DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT)
        long parsed = DataFusionPlugin.DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
        } catch (Exception e) {
    public void testSpillDirectoryIsFinalAndNodeScope() {
 * compatible open source license.
        Path existingParent = createTempDir();
        Path spillDir = createTempDir();
    }
        assertTrue(
        Settings s = Settings.builder().put("datafusion.memory_guard.spill_exempt_cap_bytes", -1L).build();
                settings.contains(DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY)
        long expected = (10L * 1024 * 1024 * 1024) * 71 / 100;
        Settings s = Settings.builder().put("datafusion.spill_directory", tmp.toString()).build();
        assertEquals(Long.toString(expected), DataFusionPlugin.deriveMemoryPoolLimitDefault(s));
    public void testGetSettingsReturnsAllIndexedSettings() {
import org.opensearch.common.settings.Setting;
        // takes its fraction off node.native_memory.limit directly so the buffer can sit
            .put("datafusion.spill_memory_limit_bytes", total + 1)
    }
        try (DataFusionPlugin plugin = new DataFusionPlugin()) {
    public void testSpillDirectoryAcceptsPathThatDoesNotYetExist() throws Exception {
        // AC explicitly unconfigured — the default must be Long.MAX_VALUE (unbounded),
    }
        IllegalArgumentException e = expectThrows(
        }
        // could still be mounting the volume). Validator accepts on syntactic grounds only;
            assertTrue(settingKeys.contains("datafusion.indexed.min_skip_run_default"));
        Path spillDir = createTempDir();
        assertEquals(Long.toString(Long.MAX_VALUE), DataFusionPlugin.deriveMemoryPoolLimitDefault(s));
    }
            .build();
            IllegalArgumentException.class,
            );
