 *
import java.util.AbstractMap.SimpleEntry;
    @SuppressWarnings({ "unchecked", "rawtypes" })
}
/**  
 */
import org.opensearch.core.compress.spi.CompressorProvider;  
 *
import org.opensearch.core.compress.Compressor;
 * SPDX-License-Identifier: Apache-2.0
 * Additional "optional" compressor implementations provided by the opensearch compress library
 * compatible open source license.
     * */
import java.util.Map.Entry;
 */  
    @Override  
        return List.of(new SimpleEntry<>(ZstdCompressor.NAME, new ZstdCompressor()));
     * Returns the concrete {@link Compressor}s provided by the compress library
/*  
    }  
     * @return a list of {@link Compressor}s  
 * The OpenSearch Contributors require contributions made to  
    /**
package org.opensearch.compress.spi;
    public List<Entry<String, Compressor>> getCompressors() {
import org.opensearch.compress.ZstdCompressor;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
import java.util.List;  
public class CompressionProvider implements CompressorProvider {
