 * opensearch core library
 * @opensearch.internal  
    public List<Entry<String, Compressor>> getCompressors() {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.AbstractMap.SimpleEntry;
/**
    }
 */
public class DefaultCompressorProvider implements CompressorProvider {
import java.util.List;
package org.opensearch.core.compress.spi;
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings({ "unchecked", "rawtypes" })
 * compatible open source license.
import org.opensearch.core.compress.Compressor;
/*  
import java.util.Map.Entry;  
 *
    @Override
 */  
 * Default {@link Compressor} implementations provided by the  
import org.opensearch.core.compress.NoneCompressor;
 * The OpenSearch Contributors require contributions made to  
}  
    /** Returns the default {@link Compressor}s provided by the core library */  
 *
        return List.of(new SimpleEntry(NoneCompressor.NAME, new NoneCompressor()));
