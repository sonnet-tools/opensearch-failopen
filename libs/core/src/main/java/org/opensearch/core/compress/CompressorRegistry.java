        for (Compressor compressor : registeredCompressors.values()) {
 * SPDX-License-Identifier: Apache-2.0
        return compressor.uncompress(bytes);  
    }
    /** Returns a registered compressor by its registered name */
    // the backing registry map
                return compressor;  
    public static boolean isCompressed(BytesReference bytes) {  
     */
    }
import org.opensearch.common.annotation.InternalApi;
        return CompressorRegistry.none();  
import org.opensearch.core.common.bytes.BytesReference;  
package org.opensearch.core.compress;
import java.io.IOException;
import java.util.Map;
            if (compressor.isCompressed(bytes) == true) {
import java.util.stream.Collectors;
     */
    }
    // no instance:
        }  
 *  
        return null;
    public static Map<String, Compressor> registeredCompressors() {  
    }  
/**
                // bytes should be either detected as compressed or as xcontent,
     */  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            if (compressor.isCompressed(bytes) == true) {
        if (compressor == null) {  
    public static Compressor none() {
    }
    }
     * @param bytes The bytes to check the compression for  
    @Nullable
    }  
import java.util.Objects;  
        return compressor == null ? bytes : compressor.uncompress(bytes);
        return registeredCompressors;
 * compressor header as a string) to registered {@link Compressor} implementations.  
            throw new NotXContentException("Compressor detection can only be called on some xcontent bytes or compressed xcontent bytes");
}
     * <p>  
     * Uncompress the provided data, data can be detected as compressed using {@link #isCompressed(BytesReference)}.
                // as a xcontent, we have a problem
                assert MediaTypeRegistry.xContentType(bytes) == null;
    public static BytesReference uncompressIfNeeded(BytesReference bytes) throws IOException {  
        for (Compressor compressor : registeredCompressors.values()) {  
public final class CompressorRegistry {
        .stream()  
        if (MediaTypeRegistry.xContentType(bytes) == null) {
        .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
            }
 */  
    )
/*  
        CompressorProvider.class,  
import org.opensearch.core.compress.spi.CompressorProvider;
            return registeredCompressors.get(name);
        if (registeredCompressors.containsKey(name)) {
        return compressor(bytes) != null;
    public static BytesReference uncompress(BytesReference bytes) throws IOException {
@InternalApi
    private static final Map<String, Compressor> registeredCompressors = ServiceLoader.load(
            }
    public static Compressor compressor(final BytesReference bytes) {
        return registeredCompressors.get(NoneCompressor.NAME);  
    }  
 * compatible open source license.
            throw new NotCompressedException();
 */  
        // no destructive danger as backing map is immutable
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Nullable;
     * @return The detected compressor. If no compressor detected then return NoneCompressor.
        CompressorProvider.class.getClassLoader()
        .flatMap(p -> p.get().getCompressors().stream())
    }  
    /**
     */
     * Returns the registered compressors as an Immutable collection
        }  
                return compressor;  
     * Returns the default compressor
 * this file be licensed under the Apache-2.0 license or a
    public static Compressor getCompressor(final String name) {  
        }
 * This enables plugins, modules, extensions to register their own compression implementations through SPI
    /** Decompress the provided {@link BytesReference}. */  
 * <p>
 * @opensearch.experimental
                // if we have bytes that can be either detected as compressed or  
        return registeredCompressors.get("DEFLATE");
 *
    /**  
 * A registry that wraps a static Map singleton which holds a mapping of unique String names (typically the
import java.util.ServiceLoader;
    public static Compressor compressorForWritable(final BytesReference bytes) {  
     * note: used for testing
        }
 * @opensearch.internal
        Compressor compressor = compressor(bytes);
        }
    private CompressorRegistry() {}
        throw new IllegalArgumentException("No registered compressor found by name [" + name + "]");
    /**
    public static Compressor defaultCompressor() {
    /**
        Compressor compressor = compressor(Objects.requireNonNull(bytes, "the BytesReference must not be null"));
