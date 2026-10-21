        return TYPE;
            if (endpoint.isEmpty() == false) {
     * Only includes intersection fields that both Java and Rust sides understand.
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            if (maxRetries >= 0) {
    /**
    }
            return NativeStoreRepository.EMPTY;
 * @opensearch.experimental
    /** No-arg constructor for ExtensiblePlugin SPI discovery via createExtension(). */
                final int proxyPort = nodeSettings.getAsInt(cp + "proxy.port", 80);
    /**
            final String configJson = buildConfigJson(metadata, nodeSettings);
 *   <li>{@code proxy_url} — from node {@code s3.client.{name}.proxy.host} + {@code proxy.port}</li>
 *
    public static final String TYPE = "s3";
            return call.invoke(S3_CREATE_STORE, config.segment(), config.len(), credProviderPtr);
        S3_DESTROY_STORE = linker.downcallHandle(
        } catch (final IOException e) {
     */
    /**
 *
     * Build config JSON for the Rust S3 backend from repo metadata and node settings.
            final String proxyHost = nodeSettings.get(cp + "proxy.host", "");
                return new NativeStoreRepository(new NativeStoreHandle(ptr, this::invokeDestroyStore));
    private long invokeCreateStore(final String configJson, final long credProviderPtr) {
 *   <li>{@code virtual_hosted_style} — inverted from node {@code s3.client.{name}.path_style_access}</li>
            builder.field("virtual_hosted_style", !pathStyleAccess);
            builder.endObject();
        }
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    private static final MethodHandle S3_DESTROY_STORE;
import java.io.IOException;
    public NativeStoreRepository createNativeStore(final RepositoryMetadata metadata, final Settings nodeSettings) {
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
    private static final MethodHandle S3_CREATE_STORE;
     */
    static {
        final Settings repoSettings = metadata.settings();
            call.invoke(S3_DESTROY_STORE, ptr);
 * Stateless factory that creates native (Rust) S3 ObjectStore instances via FFM.
            if (region.isEmpty() == false) {
            final int maxRetries = nodeSettings.getAsInt(cp + "max_retries", -1);
    }
            if (ptr > 0) {
 *   <li>{@code region} — from node {@code s3.client.{name}.region}</li>
            if (kmsKey.isEmpty() == false) {
    }
    private long invokeCreateStore(final String configJson) {
 * (including keystore entries) and passes it to the Rust S3 backend.
import java.lang.foreign.SymbolLookup;
}
package org.opensearch.repositories.s3.native_store;
            }
import org.opensearch.plugins.NativeStoreHandle;
    private static final String FFM_DESTROY = "s3_destroy_store";
 * <p>Credentials are NOT passed — Rust uses the default credential chain (IAM roles, env vars).
 * <ul>
            if (proxyHost.isEmpty() == false) {
            final long ptr = invokeCreateStore(configJson);
            final boolean pathStyleAccess = nodeSettings.getAsBoolean(cp + "path_style_access", false);
                final String scheme = "http".equalsIgnoreCase(protocol) ? "http" : "https";
 */
    public S3NativeObjectStorePlugin() {}
        S3_CREATE_STORE = linker.downcallHandle(
                builder.field("max_retries", maxRetries);
/*
            final String protocol = nodeSettings.get(cp + "protocol", "https");
                builder.field("proxy_url", scheme + "://" + proxyHost + ":" + proxyPort);
 *
                builder.field("sse_kms_key_id", kmsKey);
     * Invoke the Rust S3 create store FFM function.
        try {
                builder.field("region", region);
 * </ul>
        }
    }
import org.opensearch.core.xcontent.XContentBuilder;
            }
public class S3NativeObjectStorePlugin extends Plugin implements NativeRemoteObjectStoreProvider {
import org.opensearch.common.xcontent.XContentFactory;
import java.lang.foreign.Linker;
            return builder.toString();
     * Invoke the Rust S3 create store FFM function with an optional credential provider.
 *   <li>{@code max_retries} — from node {@code s3.client.{name}.max_retries}</li>
 *   <li>{@code allow_http} — from node {@code s3.client.{name}.protocol} == "http"</li>
            }
     * Invoke the Rust S3 destroy store FFM function.
    @Override
        final Linker linker = Linker.nativeLinker();
import java.lang.foreign.ValueLayout;
import org.opensearch.nativebridge.spi.NativeCall;
import org.opensearch.cluster.metadata.RepositoryMetadata;
import java.lang.foreign.FunctionDescriptor;
 *   <li>{@code endpoint} — from node {@code s3.client.{name}.endpoint}</li>
     */
 * SPDX-License-Identifier: Apache-2.0
        try (var call = new NativeCall()) {
    /** Settings constructor for PluginsService plugin loading. Package-private to avoid
    static final String S3_CLIENT_PREFIX = "s3.client.";
            throw new IllegalStateException("Failed to build native store config for repo [" + metadata.name() + "]", e);
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
        final String cp = S3_CLIENT_PREFIX + clientName + ".";
        }
 *
            builder.startObject();
 *
 * The OpenSearch Contributors require contributions made to
        }
import org.opensearch.repositories.NativeStoreRepository;
 * compatible open source license.
            final String kmsKey = repoSettings.get("server_side_encryption_kms_key_id", "");
        );
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
    private static final String FFM_CREATE = "s3_create_store";
            final String region = nodeSettings.get(cp + "region", "");
            }
            builder.field("bucket", repoSettings.get("bucket", ""));
import org.opensearch.common.settings.Settings;
            builder.field("bucket_key", repoSettings.getAsBoolean("server_side_encryption_bucket_key_enabled", true));
        final SymbolLookup lib = NativeLibraryLoader.symbolLookup();
    }
    }
    S3NativeObjectStorePlugin(final Settings settings) {}
 */
 *   <li>{@code bucket} — from repo settings</li>
        return invokeCreateStore(configJson, 0L);
                builder.field("allow_http", true);
/**
            }
            if ("http".equalsIgnoreCase(protocol)) {
    }
    /** Prefix for S3 client settings in node configuration. */
     *  "no unique public constructor" error — createExtension requires exactly one public constructor. */
                builder.field("endpoint", endpoint);
            }
 * <p>Intersection settings passed to Rust:
    static String buildConfigJson(final RepositoryMetadata metadata, final Settings nodeSettings) throws IOException {
            final String endpoint = nodeSettings.get(cp + "endpoint", "");
 *   <li>{@code bucket_key} — from repo {@code server_side_encryption_bucket_key_enabled}</li>
    /** Repository type handled by this provider. */
        final String clientName = repoSettings.get("client", "default");
import org.opensearch.plugins.Plugin;
            lib.find(FFM_DESTROY).orElseThrow(),
    public String repositoryType() {
            final NativeCall.Str config = call.str(configJson);
 * this file be licensed under the Apache-2.0 license or a
import java.lang.invoke.MethodHandle;
    private void invokeDestroyStore(final long ptr) {
     */
        );
        try (var call = new NativeCall()) {
            lib.find(FFM_CREATE).orElseThrow(),
    @Override
    /**
 *   <li>{@code sse_kms_key_id} — from repo {@code server_side_encryption_kms_key_id}</li>
 * <p>Resolves S3 configuration from repository metadata and node settings
            }
