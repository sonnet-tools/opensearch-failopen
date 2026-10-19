    static String buildConfigJson(final RepositoryMetadata metadata, final Settings nodeSettings) throws IOException {  
 * compatible open source license.
    private long invokeCreateStore(final String configJson, final long credProviderPtr) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        );
     */
 * Stateless factory that creates native (Rust) GCS ObjectStore instances via FFM.
    }
    }
    }
    private long invokeCreateStore(final String configJson) {
        return invokeCreateStore(configJson, 0L);
            builder.endObject();
 * The OpenSearch Contributors require contributions made to  
    /** Repository type handled by this provider. */  
    public NativeStoreRepository createNativeStore(final RepositoryMetadata metadata, final Settings nodeSettings) {  
    public String repositoryType() {
    /**  
 *  
            if (ptr > 0) {
            return builder.toString();
 * this file be licensed under the Apache-2.0 license or a
        try {
 * <ul>
            final long ptr = invokeCreateStore(configJson);  
        );  
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
        final Linker linker = Linker.nativeLinker();
    @Override  
            return call.invoke(GCS_CREATE_STORE, config.segment(), config.len(), credProviderPtr);
/*  
            builder.startObject();
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
}
 */  
    }  
    private static final MethodHandle GCS_CREATE_STORE;  
     */
    GcsNativeObjectStorePlugin(final Settings settings) {}
        return TYPE;
 *
        }  
import java.lang.invoke.MethodHandle;
            final NativeCall.Str config = call.str(configJson);
    }
 * <p>Intersection settings passed to Rust:
 * <p>Credentials are NOT passed — Rust uses Application Default Credentials (ADC).  
        try (var call = new NativeCall()) {  
     * Invoke the Rust GCS create store FFM function with an optional credential provider.  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;  
import java.lang.foreign.SymbolLookup;  
import java.io.IOException;  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
    @Override
import org.opensearch.plugins.NativeStoreHandle;
     */  
        }
import org.opensearch.plugins.Plugin;  
 *
    /**
        GCS_CREATE_STORE = linker.downcallHandle(  
    static {  
 */  
            final String configJson = buildConfigJson(metadata, nodeSettings);
import org.opensearch.common.xcontent.XContentFactory;  
     * Invoke the Rust GCS create store FFM function.
        GCS_DESTROY_STORE = linker.downcallHandle(
     * Invoke the Rust GCS destroy store FFM function.
    }
import org.opensearch.core.xcontent.XContentBuilder;
    /**
import java.lang.foreign.ValueLayout;
        }  
            lib.find(FFM_DESTROY).orElseThrow(),
import org.opensearch.repositories.NativeStoreRepository;
 *
    public static final String TYPE = "gcs";
                return new NativeStoreRepository(new NativeStoreHandle(ptr, this::invokeDestroyStore));
/**
import java.lang.foreign.FunctionDescriptor;
            call.invoke(GCS_DESTROY_STORE, ptr);
 *   <li>{@code bucket} — from repo settings</li>  
import org.opensearch.common.settings.Settings;
 * </ul>
 * @opensearch.experimental
        final SymbolLookup lib = NativeLibraryLoader.symbolLookup();
    private void invokeDestroyStore(final long ptr) {  
    private static final String FFM_CREATE = "gcs_create_store";  
    /** No-arg constructor for ExtensiblePlugin SPI discovery via createExtension(). */
        try (var call = new NativeCall()) {
        } catch (final IOException e) {
    private static final MethodHandle GCS_DESTROY_STORE;
            }  
     */
            throw new IllegalStateException("Failed to build native store config for repo [" + metadata.name() + "]", e);  
            return NativeStoreRepository.EMPTY;
    public GcsNativeObjectStorePlugin() {}
    }  
package org.opensearch.repositories.gcs.native_store;
public class GcsNativeObjectStorePlugin extends Plugin implements NativeRemoteObjectStoreProvider {
            lib.find(FFM_CREATE).orElseThrow(),
    private static final String FFM_DESTROY = "gcs_destroy_store";
import org.opensearch.nativebridge.spi.NativeCall;
            builder.field("bucket", metadata.settings().get("bucket", ""));  
    /**  
        }  
 * SPDX-License-Identifier: Apache-2.0
     * Build config JSON for the Rust GCS backend from repo metadata and node settings.
import java.lang.foreign.Linker;
import org.opensearch.cluster.metadata.RepositoryMetadata;
