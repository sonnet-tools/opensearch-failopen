                throws SSLException {
 * compatible open source license.
import java.security.NoSuchProviderException;
package org.opensearch.transport.grpc.ssl;
            ClientAuth.NONE.name().toUpperCase(Locale.ROOT),
    }
import org.opensearch.common.Randomness;
            @Override
 * this file be licensed under the Apache-2.0 license or a
        } catch (IOException e) {
            getTestKeyManagerFactory(SERVER_KEYSTORE),
     */
        List<String> msgList = null;
import java.security.KeyStore;
            throw new UncheckedIOException(e);
            throw new RuntimeException(e);
        UNAVAILABLE(List.of("Network closed for unknown reason")),
import java.io.InputStream;
import javax.net.ssl.SSLContext;
    static final String SERVER_KEYSTORE = "/netty4-server-secure";
                        return exception;
            throw new RuntimeException(e);
 * SPDX-License-Identifier: Apache-2.0
            throw new RuntimeException("Unexpected exception", e);
            this.msgList = exceptionMsg;
 */
                return get(e.getCause());
            trustStore.load(trustStoreFile, TEST_PASS);
        ConnectExceptions(List<String> exceptionMsg) {
import java.util.Optional;
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
     * However, depending on the default JDK provider exceptions may differ slightly,
        }
import org.opensearch.fips.FipsMode;
            final KeyStore trustStore = KeyStore.getInstance(keyStoreType);
            public Optional<SecureAuxTransportParameters> parameters(Settings settings, String auxTransportType) {
            return trustManagerFactory;
        );
                    @Override
                    }
import javax.net.ssl.KeyManagerFactory;
                    if (exception == NONE) continue; // Skip success message
    }
        TrustManagerFactory trustMngerFactory
                    throw new SSLException("Failed to build mock provider", e);
        );
import java.io.UncheckedIOException;
        "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256" };
            if (e.getMessage() != null) {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        return new SecureAuxTransportSettingsProvider() {
            ClientAuth.OPTIONAL.name().toUpperCase(Locale.ROOT),
import java.util.Locale;
import javax.net.ssl.SSLException;
        public static ConnectExceptions get(Throwable e) {
            @Override
                    @Override
    public static SecureAuxTransportSettingsProvider getServerClientAuthRequired() {
    }
                    if (exception.msgList.stream().anyMatch(substring -> e.getMessage().contains(substring))) {
            keyManagerFactory.init(keyStore, TEST_PASS);
    public static SecureAuxTransportSettingsProvider getServerClientAuthOptional() {
        try (InputStream keyStoreFile = SecureNetty4GrpcServerTransport.class.getResourceAsStream(keystorePath + fileExtension)) {
    static final String[] DEFAULT_CIPHERS = {
 *
    ) {
        "TLS_AES_128_GCM_SHA256",
    private static final String fileExtension = FipsMode.CHECK.isFipsEnabled() ? ".bcfks" : ".jks";
        return getSecureSettingsProvider(
        NONE(List.of("Connection succeeded")),
            ClientAuth.REQUIRE.name().toUpperCase(Locale.ROOT),
    }
    private static final String keyStoreType = FipsMode.CHECK.isFipsEnabled() ? "BCFKS" : "JKS";
                    }
import javax.net.ssl.TrustManagerFactory;
        } catch (GeneralSecurityException e) {
import java.security.KeyManagementException;
    }
            return keyManagerFactory;
import java.security.NoSuchAlgorithmException;
    public static KeyManagerFactory getTestKeyManagerFactory(String keystorePath) {
        String clientAuth,
                        return Optional.of(clientAuth);
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
            getTestTrustManagerFactory(CLIENT_KEYSTORE)
    private static final char[] TEST_PASS = "password".toCharArray(); // used for all keystores
    static SecureAuxTransportSettingsProvider getSecureSettingsProvider(
        }
    static TrustManagerFactory getTestTrustManagerFactory(String keystorePath) {
import org.opensearch.common.settings.Settings;
                    public Optional<String> clientAuth() {
     * We would like to check to ensure a connection fails in the way we expect.
            getTestKeyManagerFactory(SERVER_KEYSTORE),
    public enum ConnectExceptions {
/*
                }
        return getSecureSettingsProvider(
        }
    /**
                return Optional.of(testContext);
                });
                try {
        KeyManagerFactory keyMngerFactory,
    }
import java.security.GeneralSecurityException;
                    public Collection<String> cipherSuites() {
                SSLContext testContext;
            throw new UncheckedIOException(e);
            }
import io.grpc.netty.shaded.io.netty.handler.ssl.ClientAuth;
            if (e.getCause() != null) {
        BAD_CERT(List.of("bad_certificate", "certificate_required"));
import java.util.Collection;
                } catch (NoSuchAlgorithmException | KeyManagementException | NoSuchProviderException e) {
                    testContext.init(keyMngerFactory.getKeyManagers(), trustMngerFactory.getTrustManagers(), Randomness.createSecure());
            getTestKeyManagerFactory(SERVER_KEYSTORE),
            }
    }
            keyStore.load(keyStoreFile, TEST_PASS);
        try (InputStream trustStoreFile = SecureNetty4GrpcServerTransport.class.getResourceAsStream(keystorePath + fileExtension);) {
        } catch (IOException e) {
 * The OpenSearch Contributors require contributions made to
                    testContext = SSLContext.getInstance("TLS", provider);
                        return List.of(DEFAULT_CIPHERS);
public class SecureSettingsHelpers {
        } catch (GeneralSecurityException e) {
        }
                    }
            }
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;
        "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        );
        return getSecureSettingsProvider(
            getTestTrustManagerFactory(CLIENT_KEYSTORE)
                for (ConnectExceptions exception : values()) {
    private static final String provider = FipsMode.CHECK.isFipsEnabled() ? "BCJSSE" : "SunJSSE";
            InsecureTrustManagerFactory.INSTANCE
                }
import java.io.IOException;
     * Exception messages for various types of TLS client/server connection failure.
import java.util.List;
            trustManagerFactory.init(trustStore);
    public static SecureAuxTransportSettingsProvider getServerClientAuthNone() {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
}
            public Optional<SSLContext> buildSecureAuxServerTransportContext(Settings settings, String auxTransportType)
     * so we allow a couple different error messages for each possible error.
                return Optional.of(new SecureAuxTransportParameters() {
            }
        };
    static final String CLIENT_KEYSTORE = "/netty4-client-secure";
