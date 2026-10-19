                long available = clampNonNegative(fs.getUsableSpace());
public final class SpillStatsCollector {
 */  
            }).count();
                long staleCount = countStaleEntries(path);
import org.apache.logging.log4j.LogManager;
                // here would happily return volume stats for a file that was misconfigured into
                // overflow into negative values on filesystems > 8 EiB. Mirrors FsProbe.adjustForHugeFilesystems
 *  
            logger.warn("Unexpected error reading spill stats for [{}]: {}", spillDirectory, e.getMessage());  
        if (spillDirectory == null || spillDirectory.isEmpty()) {
    }
    }  
}  
    }  
    /**
    private static long countStaleEntries(Path spillDirectory) {
 * SPDX-License-Identifier: Apache-2.0
                // place at the spill path.
    private static final Logger logger = LogManager.getLogger(SpillStatsCollector.class);
                }
import java.security.PrivilegedActionException;
     *         are 0 but the {@code directory} and {@code disk_reserved_bytes} fields are preserved.
                // and prevents writeVLong from rejecting negatives during stats serialization.  
            return new SpillStats(spillDirectory, 0L, 0L, 0L, spillMemoryLimit, 0L);
            });  
        } catch (PrivilegedActionException pae) {
                return fileName != null && fileName.toString().endsWith(".stale");  
import java.nio.file.FileStore;  
import java.security.PrivilegedExceptionAction;
        }  
            logger.warn("Failed to read filesystem stats for spill directory [{}]: {}", spillDirectory, cause.getMessage());  
                long total = clampNonNegative(fs.getTotalSpace());
                long used = Math.max(0L, total - available);  
    public static SpillStats collect(String spillDirectory, long spillMemoryLimit) {  
        } catch (Exception e) {
import org.apache.logging.log4j.Logger;
     * Collect a spill-stats snapshot.  
 * The OpenSearch Contributors require contributions made to  
                if (!Files.isDirectory(path)) {  
     *
 * dedicated spill volumes (the current production deployment) but would  
            return new SpillStats("", 0L, 0L, 0L, 0L, 0L);
    /**
                FileStore fs = Environment.getFileStore(path);  
 * to read filesystem capacity. Cost: one syscall per call (~1µs).
     * <p>Returns 0 on any I/O error rather than failing the whole stats request — the
     * These are entries renamed by the boot-time cleanup that the background thread has
    /** See {@code FsProbe#adjustForHugeFilesystems} and JDK-8162520. */
     *                         in bytes (the user-facing setting value)
 * <p>{@code disk_used_bytes} is computed as {@code total - available}. This is
            return new SpillStats(spillDirectory, 0L, 0L, 0L, spillMemoryLimit, 0L);
     * filesystem-level fields are always more important than this diagnostic counter.  
     */
                // Clamp negatives from FileStore — JDK-8162520: getTotalSpace/getUsableSpace can
        try {  
            logger.warn("Failed to count stale spill entries in [{}]: {}", spillDirectory, e.getMessage());  
     * Count immediate children of {@code spillDirectory} whose names end in {@code .stale}.  
    private SpillStatsCollector() {}  
                Path path = Path.of(spillDirectory);
                // isDirectory follows symlinks and returns false for regular files; using exists()  
        }
 * this file be licensed under the Apache-2.0 license or a
 * memory-limit setting. Stateless — every call hits {@link Environment#getFileStore}
import org.opensearch.SpecialPermission;  
     * not yet removed (or could not remove). A persistently non-zero value across boots
     */
        }
import java.nio.file.Files;
        // SecurityManager: spill_directory is operator-configured and not on any path the
            return AccessController.doPrivileged((PrivilegedExceptionAction<SpillStats>) () -> {
            return 0L;
 * mis-attribute capacity on shared volumes. If the deployment assumption
     * indicates an operator-actionable issue.  
 * compatible open source license.
 * FFI.  
    private static long clampNonNegative(long bytes) {  
                Path fileName = p.getFileName();
        SpecialPermission.check();
import java.nio.file.Path;
/*  
     * @return a populated {@link SpillStats}; on error, byte fields and {@code stale_entry_count}  
package org.opensearch.be.datafusion.stats;
import org.opensearch.env.Environment;
            return children.filter(p -> {
        } catch (RuntimeException e) {
            Throwable cause = pae.getCause() != null ? pae.getCause() : pae;
     *
 * changes, replace this with a {@code DiskManager}-tracked counter exposed via
        // FilePermission grant in plugin-security.policy.
     * @param spillDirectory   the configured value of {@code datafusion.spill_directory};
        return bytes < 0 ? Long.MAX_VALUE : bytes;
                return new SpillStats(spillDirectory, total, available, used, spillMemoryLimit, staleCount);
 * filesystem-level usage, not DataFusion-tracked usage; it's correct for
 *
     *                         empty string means spill is disabled  
import java.util.stream.Stream;  
/**
import java.security.AccessController;  
        // core security policy grants by default. Elevate via doPrivileged using the plugin's  
     * @param spillMemoryLimit the resolved value of {@code datafusion.spill_memory_limit_bytes}
 * Builds a {@link SpillStats} snapshot from the configured spill directory and  
                    return new SpillStats(spillDirectory, 0L, 0L, 0L, spillMemoryLimit, 0L);
        try (Stream<Path> children = Files.list(spillDirectory)) {  
 */
