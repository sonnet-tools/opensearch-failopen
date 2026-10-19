                builder.field("proxy_url", scheme + "://" + proxyHost + ":" + proxyPort);
 *   <li>{@code virtual_hosted_style} — inverted from node {@code s3.client.{name}.path_style_access}</li>  
                builder.field("region", region);
        }
     * Only includes intersection fields that both Java and Rust sides understand.  
 *
            final int maxRetries = nodeSettings.getAsInt(cp + "max_retries", -1);
    private static final String FFM_DESTROY = "s3_destroy_store";  
    public String repositoryType() {
            }
            final String endpoint = nodeSettings.get(cp + "endpoint", "");
 *   <li>{@code bucket_key} — from repo {@code server_side_encryption_bucket_key_enabled}</li>
    private static final MethodHandle S3_CREATE_STORE;
    }
     * Invoke the Rust S3 create store FFM function with an optional credential provider.
            if (kmsKey.isEmpty() == false) {
 *   <li>{@code sse_kms_key_id} — from repo {@code server_side_encryption_kms_key_id}</li>  
    /** Settings constructor for PluginsService plugin loading. Package-private to avoid  
            return call.invoke(S3_CREATE_STORE, config.segment(), config.len(), credProviderPtr);  
                final int proxyPort = nodeSettings.getAsInt(cp + "proxy.port", 80);
 *  
import java.lang.foreign.SymbolLookup;  
 * SPDX-License-Identifier: Apache-2.0
            }
        final Settings repoSettings = metadata.settings();  
            lib.find(FFM_CREATE).orElseThrow(),  
    @Override  
            builder.field("bucket_key", repoSettings.getAsBoolean("server_side_encryption_bucket_key_enabled", true));  
            builder.field("virtual_hosted_style", !pathStyleAccess);
    @Override
 *   <li>{@code endpoint} — from node {@code s3.client.{name}.endpoint}</li>
 *  
     */
        final Linker linker = Linker.nativeLinker();
    static final String S3_CLIENT_PREFIX = "s3.client.";  
    }
    /**
    private static final MethodHandle S3_DESTROY_STORE;  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;  
 * <p>Credentials are NOT passed — Rust uses the default credential chain (IAM roles, env vars).
 *  
            if (region.isEmpty() == false) {
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
    }  
        );
    /**
     * Invoke the Rust S3 destroy store FFM function.
    S3NativeObjectStorePlugin(final Settings settings) {}
        final String clientName = repoSettings.get("client", "default");
 * </ul>  
 * Stateless factory that creates native (Rust) S3 ObjectStore instances via FFM.
            final String configJson = buildConfigJson(metadata, nodeSettings);  
    static String buildConfigJson(final RepositoryMetadata metadata, final Settings nodeSettings) throws IOException {
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
     * Build config JSON for the Rust S3 backend from repo metadata and node settings.
    /** Prefix for S3 client settings in node configuration. */
            builder.startObject();
     */  
}
    public NativeStoreRepository createNativeStore(final RepositoryMetadata metadata, final Settings nodeSettings) {
    public static final String TYPE = "s3";  
                builder.field("sse_kms_key_id", kmsKey);  
     */
import org.opensearch.plugins.Plugin;  
                builder.field("allow_http", true);  
 *   <li>{@code region} — from node {@code s3.client.{name}.region}</li>
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
 *   <li>{@code max_retries} — from node {@code s3.client.{name}.max_retries}</li>
            final String proxyHost = nodeSettings.get(cp + "proxy.host", "");  
import org.opensearch.common.xcontent.XContentFactory;  
    private long invokeCreateStore(final String configJson) {
        final SymbolLookup lib = NativeLibraryLoader.symbolLookup();  
/**
        }
package org.opensearch.repositories.s3.native_store;
        final String cp = S3_CLIENT_PREFIX + clientName + ".";
        }
            final long ptr = invokeCreateStore(configJson);
        }  
        S3_DESTROY_STORE = linker.downcallHandle(  
    }
            if (endpoint.isEmpty() == false) {  
    private void invokeDestroyStore(final long ptr) {
    /** No-arg constructor for ExtensiblePlugin SPI discovery via createExtension(). */  
 * <p>Resolves S3 configuration from repository metadata and node settings
            call.invoke(S3_DESTROY_STORE, ptr);  
        try (var call = new NativeCall()) {
    /**  
        return invokeCreateStore(configJson, 0L);  
        return TYPE;  
    }
 * this file be licensed under the Apache-2.0 license or a
import java.lang.foreign.FunctionDescriptor;
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
import java.io.IOException;  
            throw new IllegalStateException("Failed to build native store config for repo [" + metadata.name() + "]", e);
            final String region = nodeSettings.get(cp + "region", "");  
            }
import org.opensearch.cluster.metadata.RepositoryMetadata;
            final String kmsKey = repoSettings.get("server_side_encryption_kms_key_id", "");
            final boolean pathStyleAccess = nodeSettings.getAsBoolean(cp + "path_style_access", false);
import java.lang.invoke.MethodHandle;
            }
import org.opensearch.repositories.NativeStoreRepository;
            if (maxRetries >= 0) {  
            }
import org.opensearch.core.xcontent.XContentBuilder;
                final String scheme = "http".equalsIgnoreCase(protocol) ? "http" : "https";  
 *   <li>{@code bucket} — from repo settings</li>  
            if ("http".equalsIgnoreCase(protocol)) {
 */  
                builder.field("max_retries", maxRetries);
            }  
 * <ul>
public class S3NativeObjectStorePlugin extends Plugin implements NativeRemoteObjectStoreProvider {  
            lib.find(FFM_DESTROY).orElseThrow(),
    /** Repository type handled by this provider. */
 *   <li>{@code proxy_url} — from node {@code s3.client.{name}.proxy.host} + {@code proxy.port}</li>
import org.opensearch.plugins.NativeStoreHandle;
        S3_CREATE_STORE = linker.downcallHandle(
            return builder.toString();
import java.lang.foreign.ValueLayout;
/*  
import org.opensearch.nativebridge.spi.NativeCall;
            return NativeStoreRepository.EMPTY;
import java.lang.foreign.Linker;
    /**
                builder.field("endpoint", endpoint);
            }
    static {
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
     *  "no unique public constructor" error — createExtension requires exactly one public constructor. */
            builder.field("bucket", repoSettings.get("bucket", ""));
            final NativeCall.Str config = call.str(configJson);
            if (ptr > 0) {
    private long invokeCreateStore(final String configJson, final long credProviderPtr) {  
     * Invoke the Rust S3 create store FFM function.  
     */
import org.opensearch.common.settings.Settings;
            builder.endObject();
            final String protocol = nodeSettings.get(cp + "protocol", "https");
 */
        } catch (final IOException e) {  
 * compatible open source license.
                return new NativeStoreRepository(new NativeStoreHandle(ptr, this::invokeDestroyStore));  
    private static final String FFM_CREATE = "s3_create_store";
    }
 *   <li>{@code allow_http} — from node {@code s3.client.{name}.protocol} == "http"</li>
        try (var call = new NativeCall()) {
 *
    public S3NativeObjectStorePlugin() {}
        );  
 * (including keystore entries) and passes it to the Rust S3 backend.
            if (proxyHost.isEmpty() == false) {
 * <p>Intersection settings passed to Rust:
        try {
    }
