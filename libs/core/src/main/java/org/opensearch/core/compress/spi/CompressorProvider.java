public interface CompressorProvider {  
 *  
 * The OpenSearch Contributors require contributions made to  
    /** Extensions that implement their own concrete {@link Compressor}s provide them through this interface method*/
 */  
 *
}  
 * Service Provider Interface for plugins, modules, extensions providing custom  
 * <p>
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.List;
 * compression algorithms
/*  
 */  
import org.opensearch.common.annotation.PublicApi;
package org.opensearch.core.compress.spi;
 * and {@link org.opensearch.core.compress.CompressorRegistry} for the registration of custom
 * @opensearch.api
import org.opensearch.core.compress.Compressor;  
@ExperimentalApi
import java.util.Map;  
 * Compressors
 * see {@link Compressor} for implementing methods  
 * @opensearch.experimental
    List<Map.Entry<String, Compressor>> getCompressors();
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "2.10.0")
 * SPDX-License-Identifier: Apache-2.0
/**
