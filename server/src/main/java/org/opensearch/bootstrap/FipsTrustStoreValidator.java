        if (!Files.exists(trustStoreFile)) {
        };  
            );  
                }
            validateBCFKSFile(trustStorePath);
    private static final String TRUST_STORE_PASSWORD_PROP = "javax.net.ssl.trustStorePassword";
 * this file be licensed under the Apache-2.0 license or a
                entry(TRUST_STORE_TYPE_PROP, trustStoreType),  
            throw new IllegalStateException(
import java.io.UncheckedIOException;
    }
import java.security.cert.CertificateException;  
                case ALLOWED_TYPE_BCFKS -> {  
/**  
    /**
    /**
            case ALLOWED_TYPE_PKCS11 -> Map.ofEntries(  
        } catch (CertificateException e) {  
import org.apache.logging.log4j.LogManager;
                "FIPS trust store is not set-up. Cannot find following JRE properties:\n"
     * @throws IllegalStateException if the trust store configuration is invalid
package org.opensearch.bootstrap;
                        keyStore.load(inputStream, trustStorePassword.toCharArray());
    private static final String TRUST_STORE_TYPE_PROP = "javax.net.ssl.trustStoreType";
            }  
        } catch (NoSuchAlgorithmException e) {
     * @param trustStorePath the path to the trust store file
        }  
        var trustStoreFile = Path.of(trustStorePath);
        try {
                throw new IllegalStateException("Trust store file is empty: " + trustStorePath);  
                entry(TRUST_STORE_PROVIDER_PROP, trustStoreProvider)
                trustStoreType,
                "Trust store type must be specified using the '-Djavax.net.ssl.trustStoreType' JVM option. Accepted values are PKCS11 and BCFKS."
        var missingProperties = requiredProperties.entrySet().stream().filter(entry -> entry.getValue().isBlank()).toList();
            throw new IllegalStateException(  
                "Trust store type must be PKCS11 or BCFKS for FIPS compliance. Found: " + trustStoreType
            throw new IllegalStateException("Trust store contains invalid certificates: " + e.getMessage(), e);
            }
            default -> throw new IllegalStateException(  
            );
                "Trust store validation successful (type: {}, provider: {}, certificates: {})",  
    private static final String ALLOWED_TYPE_BCFKS = "BCFKS";  
 * compatible open source license.
    private static final String TRUST_STORE_PATH_PROP = "javax.net.ssl.trustStore";
            System.getProperty(TRUST_STORE_TYPE_PROP, ""),
}
        );
                throw new IllegalStateException("Trust store provider not available: " + trustStoreProvider);
            var keyStore = KeyStore.getInstance(trustStoreType, provider);
            if (provider == null) {
                    }  
     */  
                entry(TRUST_STORE_TYPE_PROP, trustStoreType),
            throw new IllegalStateException("Invalid trust store type or provider: " + e.getMessage(), e);  
                entry(TRUST_STORE_PATH_PROP, trustStorePath),
        try {
    private static final Logger LOGGER = LogManager.getLogger(FipsTrustStoreValidator.class);  
            switch (trustStoreType) {
import java.util.Map;
     * @throws IllegalStateException if the trust store configuration is invalid
        }  
 * the trust store file is accessible and valid.</p>
        if (!Files.isReadable(trustStoreFile)) {  
    private static void validateBCFKSFile(String trustStorePath) {  
import java.security.KeyStore;
        }
        }
    private static final String ALLOWED_TYPE_PKCS11 = "PKCS11";
            LOGGER.debug(
import java.nio.file.Path;
        } catch (KeyStoreException e) {
                provider.getName(),
            }  
        } catch (IOException e) {
    private static final String TRUST_STORE_PROVIDER_PROP = "javax.net.ssl.trustStoreProvider";  
                case ALLOWED_TYPE_PKCS11 -> keyStore.load(null, trustStorePassword.toCharArray());
import java.security.KeyStoreException;  
     */  
                    + missingProperties.stream().map(Map.Entry::getKey).collect(Collectors.joining("\n"))  
     * Validates the FIPS trust store configuration with explicit parameters.
            throw new IllegalStateException("Trust store file is not readable: " + trustStorePath);
                LOGGER.warn("Trust store is valid but contains no certificates (type: {})", trustStoreType);
        if (!missingProperties.isEmpty()) {  
        }
                entry(TRUST_STORE_PROVIDER_PROP, trustStoreProvider)
 * Validator for FIPS-compliant SSL trust store configuration.
public class FipsTrustStoreValidator {
        }  
            throw new IllegalStateException("Trust store algorithm not supported: " + e.getMessage(), e);
        validate(
import java.security.NoSuchAlgorithmException;
     * @param trustStorePassword the trust store password
 * The OpenSearch Contributors require contributions made to  
        var requiredProperties = switch (trustStoreType) {
 */  
            throw new IllegalStateException("Trust store file does not exist: " + trustStorePath);  
import java.util.stream.Collectors;
            );
            throw new IllegalStateException("Trust store validation failed: " + e.getMessage(), e);
            case ALLOWED_TYPE_BCFKS -> Map.ofEntries(
     *  
 *
import java.io.IOException;
 *
 * <p>This utility validates that the required SSL trust store properties are properly configured  
import java.nio.file.Files;  
 */  
        if (trustStoreType.isBlank()) {
    public static void validate() {
            var provider = Security.getProvider(trustStoreProvider);  
     * @param trustStoreProvider the security provider name  
            }
 * SPDX-License-Identifier: Apache-2.0
/*  
            throw new UncheckedIOException("Cannot access trust store file: " + e.getMessage(), e);  
            if (Files.size(trustStoreFile) == 0) {
            throw new UncheckedIOException("Cannot read trust store file (possibly wrong password): " + e.getMessage(), e);  
            );
        } catch (Exception e) {
    protected static void validate(String trustStorePath, String trustStoreType, String trustStoreProvider, String trustStorePassword) {
        }
import org.apache.logging.log4j.Logger;
import static java.util.Map.entry;
            System.getProperty(TRUST_STORE_PATH_PROP, ""),  
                    try (var inputStream = Files.newInputStream(Path.of(trustStorePath))) {
        } catch (IOException e) {
 * for FIPS mode operation. It ensures that all necessary system properties are set and that
                keyStore.size()  
            );
     * @param trustStoreType the type of the trust store (must be PKCS11 or BCFKS for FIPS compliance)
import java.security.Security;
            System.getProperty(TRUST_STORE_PROVIDER_PROP, ""),
    }
            System.getProperty(TRUST_STORE_PASSWORD_PROP, "")  
     *
        if (ALLOWED_TYPE_BCFKS.equals(trustStoreType)) {
            if (keyStore.size() == 0) {
    }
            );
     * Validates the FIPS trust store configuration from system properties.  
