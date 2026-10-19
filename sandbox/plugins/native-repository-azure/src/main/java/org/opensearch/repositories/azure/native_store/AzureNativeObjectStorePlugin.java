            if (ptr > 0) {
    }
    @Override  
 * <p>Credentials (access_key, sas_token) are NOT passed — Rust uses
        }  
            final long ptr = invokeCreateStore(configJson);  
import java.lang.foreign.SymbolLookup;  
 * </ul>  
import org.opensearch.plugins.Plugin;  
import java.io.IOException;  
 * Azure default credential chain (managed identity, CLI, env vars).  
     */
            return NativeStoreRepository.EMPTY;
 *  
 *
    public NativeStoreRepository createNativeStore(final RepositoryMetadata metadata, final Settings nodeSettings) {  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
public class AzureNativeObjectStorePlugin extends Plugin implements NativeRemoteObjectStoreProvider {
        final String cp = AZURE_CLIENT_PREFIX + clientName + ".";
import org.opensearch.nativebridge.spi.NativeCall;
    private long invokeCreateStore(final String configJson, final long credProviderPtr) {
    public String repositoryType() {
    static final String AZURE_CLIENT_PREFIX = "azure.client.";
import java.lang.foreign.Linker;
        return TYPE;
            return builder.toString();
        // "client" setting, falling back to deprecated "account" setting (matches AzureRepository.Repository.CLIENT_NAME)
    }
import org.opensearch.common.settings.Settings;
     */
    /** No-arg constructor for ExtensiblePlugin SPI discovery via createExtension(). */
/**
    private static final String FFM_CREATE = "azure_create_store";  
        AZURE_DESTROY_STORE = linker.downcallHandle(
import org.opensearch.common.xcontent.XContentFactory;  
            }  
    /** Repository type handled by this provider. */  
            lib.find(FFM_DESTROY).orElseThrow(),
import java.lang.foreign.FunctionDescriptor;
    private static final MethodHandle AZURE_DESTROY_STORE;
    @Override
        final String clientName = repoSettings.get("client", repoSettings.get("account", "default"));  
    /**  
    static String buildConfigJson(final RepositoryMetadata metadata, final Settings nodeSettings) throws IOException {  
    /**
    }
    /**  
    static {  
                builder.field("max_retries", maxRetries);
 *   <li>{@code max_retries} — from node {@code azure.client.{name}.max_retries}</li>
        return invokeCreateStore(configJson, 0L);
}
 */  
 *   <li>{@code container} — from repo settings</li>
 * this file be licensed under the Apache-2.0 license or a
        try (var call = new NativeCall()) {
            builder.field("account", nodeSettings.get(cp + "account", ""));
import java.lang.invoke.MethodHandle;
        );
 *
        }
 * <ul>
 *   <li>{@code account} — from node {@code azure.client.{name}.account}</li>  
            return call.invoke(AZURE_CREATE_STORE, config.segment(), config.len(), credProviderPtr);
            builder.field("container", repoSettings.get("container", "opensearch-snapshots"));  
    /**
            lib.find(FFM_CREATE).orElseThrow(),
 */  
            call.invoke(AZURE_DESTROY_STORE, ptr);
        final Linker linker = Linker.nativeLinker();
     * Invoke the Rust Azure create store FFM function.
            final NativeCall.Str config = call.str(configJson);
import java.lang.foreign.ValueLayout;
import org.opensearch.plugins.NativeStoreHandle;
        final SymbolLookup lib = NativeLibraryLoader.symbolLookup();
            }
            final String configJson = buildConfigJson(metadata, nodeSettings);
            final int maxRetries = nodeSettings.getAsInt(cp + "max_retries", -1);
 * <p>Intersection settings passed to Rust:
 * SPDX-License-Identifier: Apache-2.0
        AZURE_CREATE_STORE = linker.downcallHandle(  
    private long invokeCreateStore(final String configJson) {
            throw new IllegalStateException("Failed to build native store config for repo [" + metadata.name() + "]", e);  
    private static final String FFM_DESTROY = "azure_destroy_store";
 *
        final Settings repoSettings = metadata.settings();
    /** Prefix for Azure client settings in node configuration. */  
     * Invoke the Rust Azure create store FFM function with an optional credential provider.  
                return new NativeStoreRepository(new NativeStoreHandle(ptr, this::invokeDestroyStore));
import org.opensearch.cluster.metadata.RepositoryMetadata;
    AzureNativeObjectStorePlugin(final Settings settings) {}
            builder.endObject();
        }  
/*  
        }  
    }
import org.opensearch.repositories.NativeStoreRepository;
 * @opensearch.experimental
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {  
    }
     */  
    public static final String TYPE = "azure";
        );  
 * compatible open source license.
 * Stateless factory that creates native (Rust) Azure ObjectStore instances via FFM.
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;  
     * Build config JSON for the Rust Azure backend from repo metadata and node settings.
        try {
    private void invokeDestroyStore(final long ptr) {  
        try (var call = new NativeCall()) {  
 * The OpenSearch Contributors require contributions made to  
     * Invoke the Rust Azure destroy store FFM function.
            builder.startObject();
        } catch (final IOException e) {
    public AzureNativeObjectStorePlugin() {}
    private static final MethodHandle AZURE_CREATE_STORE;  
import org.opensearch.core.xcontent.XContentBuilder;
    }  
package org.opensearch.repositories.azure.native_store;
    }  
     */
            if (maxRetries >= 0) {  
