/*  
            JAVAX_NET_SSL_TRUST_STORE,
record ConfigurationProperties(String trustStorePath, String trustStoreType, String trustStorePassword, String trustStoreProvider) {  
            JAVAX_NET_SSL_TRUST_STORE_PASSWORD,
 * SPDX-License-Identifier: Apache-2.0
        return String.format(  
    public static final String JAVAX_NET_SSL_TRUST_STORE_PROVIDER = "javax.net.ssl.trustStoreProvider";
    public static final String JAVAX_NET_SSL_TRUST_STORE = "javax.net.ssl.trustStore";
                %s: %s""",  
 * The OpenSearch Contributors require contributions made to  
            trustStorePath,
    public String toString() {
 * @param trustStorePassword password for the trust store  
        );  
    public static final String JAVAX_NET_SSL_TRUST_STORE_TYPE = "javax.net.ssl.trustStoreType";  
package org.opensearch.tools.cli.fips.truststore;
    @Override
    }
}
 */  
            trustStoreType,
 * log details of TrustStore configurations within the system.
 *  
/**  
import java.util.Locale;
 * @param trustStorePath path to the trust store file
    public static final String JAVAX_NET_SSL_TRUST_STORE_PASSWORD = "javax.net.ssl.trustStorePassword";
            JAVAX_NET_SSL_TRUST_STORE_PROVIDER,
 *
 * @param trustStoreType type of the trust store (e.g., BCFKS, PKCS11)
                %s: %s
            trustStorePassword.isEmpty() ? "[NOT SET]" : "[SET]"
            Locale.ROOT,
 * Encapsulates properties related to a TrustStore configuration. Is primarily used to manage and
                %s: %s
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            trustStoreProvider,  
 */
            """
                %s: %s  
 * @param trustStoreProvider security provider name for the trust store
            JAVAX_NET_SSL_TRUST_STORE_TYPE,  
