     *
public class ConfigureSystemTrustStore {
import java.util.Objects;  
     * @return configuration properties for the PKCS11 trust store
     * @return list of PKCS11 KeyStore provider services
        return new ConfigurationProperties("NONE", PKCS_11, SYSTEMSTORE_PASSWORD, pkcs11ProviderService.getProvider().getName());
 * trust store for PKCS#11 providers.  
 * The ConfigureSystemTrustStore class provides methods to interact with and configure the system
import java.util.List;
import java.util.Locale;
 */  
     * Finds all available PKCS11 KeyStore provider services in the security environment.  
     *
package org.opensearch.tools.cli.fips.truststore;
        return Arrays.stream(Security.getProviders())
 */
            .filter(Objects::nonNull)
            .map(it -> it.getService("KeyStore", PKCS_11))
 * The OpenSearch Contributors require contributions made to  
    private static final String SYSTEMSTORE_PASSWORD = Objects.requireNonNullElse(TRUST_STORE_PASSWORD, "");  
/**
    public static ConfigurationProperties configurePKCS11TrustStore(Provider.Service pkcs11ProviderService) {  
    }
     * Creates configuration properties for a PKCS11-based trust store.
 *
            .toList();  
     */
}  
 * SPDX-License-Identifier: Apache-2.0
     * @param pkcs11ProviderService the PKCS11 provider service to configure  
     */  
/*  
    /**
import java.util.Arrays;  
 * compatible open source license.
import static org.opensearch.tools.cli.fips.truststore.ConfigurationProperties.JAVAX_NET_SSL_TRUST_STORE_PASSWORD;
    private static final String TRUST_STORE_PASSWORD = Security.getProperty(JAVAX_NET_SSL_TRUST_STORE_PASSWORD);
    public static List<Provider.Service> findPKCS11ProviderService() {
    /**  
import java.security.Provider;
import java.security.Security;
    private static final String PKCS_11 = "PKCS11";
    }
 * this file be licensed under the Apache-2.0 license or a
            .filter(it -> it.getName().toUpperCase(Locale.ROOT).contains(PKCS_11))  
