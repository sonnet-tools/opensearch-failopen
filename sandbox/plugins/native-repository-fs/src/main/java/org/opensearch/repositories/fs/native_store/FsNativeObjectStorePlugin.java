    }
     * Build config JSON for the Rust FS backend from repo metadata.
    /**  
            return NativeStoreRepository.EMPTY;  
    private static final MethodHandle FS_CREATE_STORE;
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
    FsNativeObjectStorePlugin(final Settings settings) {}  
    public NativeStoreRepository createNativeStore(final RepositoryMetadata metadata, final Settings nodeSettings) {
        } catch (final IOException e) {
import java.lang.foreign.Linker;
    }
            final long ptr = invokeCreateStore(configJson);
import java.lang.foreign.SymbolLookup;  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;  
    public static final String TYPE = "fs";  
import org.opensearch.nativebridge.spi.NativeCall;
import org.opensearch.common.xcontent.XContentFactory;  
        }  
 *   <li>{@code base_path} — from repo {@code location} setting</li>
    /** No-arg constructor for ExtensiblePlugin SPI discovery via createExtension(). */  
            final NativeCall.Str config = call.str(configJson);
        }
    public FsNativeObjectStorePlugin() {}
public class FsNativeObjectStorePlugin extends Plugin implements NativeRemoteObjectStoreProvider {  
    @Override
    }
            throw new IllegalStateException("Failed to build native store config for repo [" + metadata.name() + "]", e);
    private void invokeDestroyStore(final long ptr) {
        }
import org.opensearch.plugins.Plugin;  
 *
import org.opensearch.common.settings.Settings;
        try (var call = new NativeCall()) {
        FS_CREATE_STORE = linker.downcallHandle(
 * <p>Intersection settings passed to Rust:
import org.opensearch.repositories.NativeStoreRepository;
 * Stateless factory that creates native (Rust) local filesystem ObjectStore instances.
     * Invoke the Rust FS destroy store FFM function.
 * </ul>
            lib.find(FFM_CREATE).orElseThrow(),  
            builder.field("base_path", metadata.settings().get("location", ""));
 * The OpenSearch Contributors require contributions made to  
import java.lang.invoke.MethodHandle;
 * Primarily used for testing with FS-based repositories.  
        );  
 * this file be licensed under the Apache-2.0 license or a
        );
import java.lang.foreign.ValueLayout;
 * <ul>  
            builder.startObject();  
            if (ptr > 0) {  
    static {
        final Linker linker = Linker.nativeLinker();
    public String repositoryType() {  
    @Override
            call.invoke(FS_DESTROY_STORE, ptr);  
            return call.invoke(FS_CREATE_STORE, config.segment(), config.len());  
import org.opensearch.core.xcontent.XContentBuilder;
            builder.endObject();
            lib.find(FFM_DESTROY).orElseThrow(),
        FS_DESTROY_STORE = linker.downcallHandle(  
     */  
import java.io.IOException;  
        try {  
     * Invoke the Rust FS create store FFM function.
    private static final MethodHandle FS_DESTROY_STORE;  
 */  
        return TYPE;
    }
    private long invokeCreateStore(final String configJson) {  
    private static final String FFM_CREATE = "fs_create_store";
/**
    /** Repository type handled by this provider. */
    static String buildConfigJson(final RepositoryMetadata metadata) throws IOException {
package org.opensearch.repositories.fs.native_store;
 */
 *
            return builder.toString();  
                return new NativeStoreRepository(new NativeStoreHandle(ptr, this::invokeDestroyStore));
        try (var call = new NativeCall()) {
    private static final String FFM_DESTROY = "fs_destroy_store";  
     */
        final SymbolLookup lib = NativeLibraryLoader.symbolLookup();  
import org.opensearch.plugins.NativeStoreHandle;
            final String configJson = buildConfigJson(metadata);
     */  
 * compatible open source license.
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
 *  
    /**
    }
    }
}  
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
            }
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        }
    /**
import java.lang.foreign.FunctionDescriptor;
 * @opensearch.experimental
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.RepositoryMetadata;
/*  
