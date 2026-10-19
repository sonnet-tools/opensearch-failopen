 * The OpenSearch Contributors require contributions made to  
    private final String formatName;
import org.opensearch.common.annotation.ExperimentalApi;
    public FormatChecksumStrategy getChecksumStrategy() {
     *
        this.checksumStrategy = checksumStrategy;  
 * efficient strategy (e.g., {@link org.opensearch.index.store.PrecomputedChecksumStrategy})
    public DataFormatDescriptor(String formatName, FormatChecksumStrategy checksumStrategy) {
 * @opensearch.experimental
    /**  
public class DataFormatDescriptor {
     * Returns the default checksum strategy for this format.
 *
     * @param formatName        the format name (e.g., "parquet")
 * SPDX-License-Identifier: Apache-2.0
 * Describes the static capabilities of a data format, including its default checksum
@ExperimentalApi
 * via the shared checksum strategies map created during shard initialization.  
     *
     * Creates a new DataFormatDescriptor.
/**
 */  
 *
        this.formatName = formatName;
        return checksumStrategy;  
        return formatName;  
 * strategy and format name. Provided by {@link DataFormatPlugin} implementations and  
}
    public String getFormatName() {
     * @return the format name  
import org.opensearch.index.store.FormatChecksumStrategy;
     * Returns the format name.
    }
 */  
    }
 * compatible open source license.
 * At runtime, the {@link IndexingExecutionEngine} may override this with a more
    /**  
     * @param checksumStrategy  the default checksum strategy for this format
    /**
    private final FormatChecksumStrategy checksumStrategy;
 * this file be licensed under the Apache-2.0 license or a
     */
     * @return the checksum strategy  
     *  
package org.opensearch.index.engine.dataformat;
     */  
/*  
 *
 * consumed by DataFormatAwareStoreDirectory and DataFormatAwareRemoteDirectory.
     */
    }
 * <p>The checksum strategy here is the <em>default fallback</em> — a full-file scan.  
