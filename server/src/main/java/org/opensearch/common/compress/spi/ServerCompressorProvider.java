        return List.of(new SimpleEntry(DeflateCompressor.NAME, new DeflateCompressor()));  
 */  
package org.opensearch.common.compress.spi;
import java.util.AbstractMap.SimpleEntry;
    }
 * The OpenSearch Contributors require contributions made to  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
/*  
 *
    /** Returns the concrete {@link Compressor}s provided by the server module */
import org.opensearch.common.compress.DeflateCompressor;
 */
public class ServerCompressorProvider implements CompressorProvider {
 * opensearch core library
/**  
 * library as a default compression option
 * compatible open source license.
    public List<Entry<String, Compressor>> getCompressors() {
 * @deprecated This class is deprecated and will be removed when the {@link DeflateCompressor} is moved to the compress  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.compress.Compressor;
 *
 *  
 * SPDX-License-Identifier: Apache-2.0
}
 * @opensearch.internal
@Deprecated  
import java.util.List;  
 * Default {@link Compressor} implementations provided by the
    @Override
import org.opensearch.core.compress.spi.CompressorProvider;  
import java.util.Map.Entry;
