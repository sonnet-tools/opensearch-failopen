import javax.net.ssl.TrustManagerFactory;  
    }  
        UNAVAILABLE(List.of("Network closed for unknown reason")),
     * We would like to check to ensure a connection fails in the way we expect.
     */
                return Optional.of(testContext);
            if (e.getCause() != null) {
            throw new UncheckedIOException(e);  
    public static KeyManagerFactory getTestKeyManagerFactory(String keystorePath) {  
            return trustManagerFactory;
        }
import java.util.Collection;
import java.io.InputStream;  
        NONE(List.of("Connection succeeded")),
 */  
        "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256" };
    }
                    }
        List<String> msgList = null;
    }
package org.opensearch.transport.grpc.ssl;
    public enum ConnectExceptions {  
    static TrustManagerFactory getTestTrustManagerFactory(String keystorePath) {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());  
            keyStore.load(keyStoreFile, TEST_PASS);  
        ConnectExceptions(List<String> exceptionMsg) {
     * However, depending on the default JDK provider exceptions may differ slightly,  
            getTestKeyManagerFactory(SERVER_KEYSTORE),  
        String clientAuth,
                SSLContext testContext;
            getTestKeyManagerFactory(SERVER_KEYSTORE),
                    if (exception.msgList.stream().anyMatch(substring -> e.getMessage().contains(substring))) {  
        return getSecureSettingsProvider(
import org.opensearch.common.settings.Settings;
        );  
                    @Override
import org.opensearch.plugins.SecureAuxTransportSettingsProvider;
            }  
        } catch (GeneralSecurityException e) {
            getTestTrustManagerFactory(CLIENT_KEYSTORE)
    /**  
import javax.net.ssl.KeyManagerFactory;  
                try {
        } catch (IOException e) {  
        );
            }  
            throw new RuntimeException("Unexpected exception", e);
    ) {
            }
import java.io.UncheckedIOException;
                });
                    public Collection<String> cipherSuites() {
            return keyManagerFactory;  
        };
            throw new RuntimeException(e);
import java.util.Locale;  
    public static SecureAuxTransportSettingsProvider getServerClientAuthOptional() {  
                throws SSLException {  
        );
    }
        return new SecureAuxTransportSettingsProvider() {  
    private static final char[] TEST_PASS = "password".toCharArray(); // used for all keystores
import javax.net.ssl.SSLException;
import io.grpc.netty.shaded.io.netty.handler.ssl.ClientAuth;  
                } catch (NoSuchAlgorithmException | KeyManagementException | NoSuchProviderException e) {
import org.opensearch.common.Randomness;
            final KeyStore trustStore = KeyStore.getInstance(keyStoreType);
            ClientAuth.REQUIRE.name().toUpperCase(Locale.ROOT),  
                return get(e.getCause());  
            trustStore.load(trustStoreFile, TEST_PASS);
    public static SecureAuxTransportSettingsProvider getServerClientAuthNone() {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
 * this file be licensed under the Apache-2.0 license or a
        TrustManagerFactory trustMngerFactory
import java.security.NoSuchAlgorithmException;
        } catch (GeneralSecurityException e) {  
            trustManagerFactory.init(trustStore);
                        return List.of(DEFAULT_CIPHERS);  
import java.security.KeyManagementException;  
        }
        "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",  
public class SecureSettingsHelpers {  
    private static final String provider = FipsMode.CHECK.isFipsEnabled() ? "BCJSSE" : "SunJSSE";  
    static final String[] DEFAULT_CIPHERS = {
                    @Override
            if (e.getMessage() != null) {  
                }
        }  
        "TLS_AES_128_GCM_SHA256",
                    }
                    if (exception == NONE) continue; // Skip success message
        try (InputStream trustStoreFile = SecureNetty4GrpcServerTransport.class.getResourceAsStream(keystorePath + fileExtension);) {  
    private static final String keyStoreType = FipsMode.CHECK.isFipsEnabled() ? "BCFKS" : "JKS";
                return Optional.of(new SecureAuxTransportParameters() {
                    testContext = SSLContext.getInstance("TLS", provider);  
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
 * SPDX-License-Identifier: Apache-2.0
    }  
    public static SecureAuxTransportSettingsProvider getServerClientAuthRequired() {
     * so we allow a couple different error messages for each possible error.
/*  
 * compatible open source license.
            ClientAuth.NONE.name().toUpperCase(Locale.ROOT),
 *
}  
                    testContext.init(keyMngerFactory.getKeyManagers(), trustMngerFactory.getTrustManagers(), Randomness.createSecure());
        } catch (IOException e) {
import org.opensearch.fips.FipsMode;  
     * Exception messages for various types of TLS client/server connection failure.
    private static final String fileExtension = FipsMode.CHECK.isFipsEnabled() ? ".bcfks" : ".jks";
import java.security.GeneralSecurityException;
 * The OpenSearch Contributors require contributions made to  
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;
            @Override
            getTestKeyManagerFactory(SERVER_KEYSTORE),
                    }
            @Override
    static SecureAuxTransportSettingsProvider getSecureSettingsProvider(
    }
            keyManagerFactory.init(keyStore, TEST_PASS);
            throw new UncheckedIOException(e);
    static final String SERVER_KEYSTORE = "/netty4-server-secure";
        public static ConnectExceptions get(Throwable e) {
                        return exception;
            public Optional<SecureAuxTransportParameters> parameters(Settings settings, String auxTransportType) {  
        }  
            }
            getTestTrustManagerFactory(CLIENT_KEYSTORE)
            InsecureTrustManagerFactory.INSTANCE  
                for (ConnectExceptions exception : values()) {
            throw new RuntimeException(e);
        try (InputStream keyStoreFile = SecureNetty4GrpcServerTransport.class.getResourceAsStream(keystorePath + fileExtension)) {
                    public Optional<String> clientAuth() {  
import java.util.Optional;
            public Optional<SSLContext> buildSecureAuxServerTransportContext(Settings settings, String auxTransportType)
        return getSecureSettingsProvider(
                }  
        return getSecureSettingsProvider(  
        BAD_CERT(List.of("bad_certificate", "certificate_required"));  
import java.security.KeyStore;
                    throw new SSLException("Failed to build mock provider", e);  
            ClientAuth.OPTIONAL.name().toUpperCase(Locale.ROOT),
    }
    static final String CLIENT_KEYSTORE = "/netty4-client-secure";  
                        return Optional.of(clientAuth);
        KeyManagerFactory keyMngerFactory,  
import java.io.IOException;
import javax.net.ssl.SSLContext;
import java.security.NoSuchProviderException;  
            this.msgList = exceptionMsg;
import java.util.List;
