        return defaultValue;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    private static final BiFunction<String, String, String> FIPS_AWARE_SYSTEM_PROPERTIES = KeyStoreUtil.IN_FIPS_MODE  
 */  
 */
        // - https://bugs.openjdk.java.net/browse/JDK-8215012: VeriSign, GeoTrust" and "thawte" are gone  
        assumeFalse("Should only run when PKCS11 provider is installed.", findPKCS11ProviderService().isEmpty());
package org.opensearch.common.ssl;
 * this file be licensed under the Apache-2.0 license or a
            }
import java.security.cert.X509Certificate;
            .filter(cert -> cert.getSubjectX500Principal().getName().toLowerCase(Locale.ROOT).contains(lowerName))
        assertStandardIssuers(trustManager);
        assertHasTrustedIssuer(trustManager, "COMODO");
 *
        assertStandardIssuers(trustManager);
import java.util.Optional;
 *    http://www.apache.org/licenses/LICENSE-2.0
    };
 * You may obtain a copy of the License at  
            .findAny();  
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.emptyIterable;  
 * software distributed under the License is distributed on an
        }
/*
 */  
import java.util.function.BiFunction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.emptyArray;
        assertThat(trustConfig.getDependentFiles(), emptyIterable());  
            .toList();  
 * compatible open source license.
        ? BCFKS_SYSTEM_PROPERTIES
        assertThat(trustConfig.getDependentFiles(), emptyIterable());
 * The OpenSearch Contributors require contributions made to  
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();  
 * license agreements. See the NOTICE file distributed with
import java.util.stream.Stream;  
        assertStandardIssuers(trustManager);  
    private void assertStandardIssuers(X509ExtendedTrustManager trustManager) {
        final String lowerName = name.toLowerCase(Locale.ROOT);  
        }  
        final DefaultJdkTrustConfig trustConfig = new DefaultJdkTrustConfig(FIPS_AWARE_SYSTEM_PROPERTIES);
 * the Apache License, Version 2.0 (the "License"); you may
        if ("javax.net.ssl.trustStoreType".equals(key)) {
        final DefaultJdkTrustConfig trustConfig = new DefaultJdkTrustConfig(PKCS11_SYSTEM_PROPERTIES);  
    }
        assertThat(trustManager.getAcceptedIssuers(), not(emptyArray()));  
                logger.info(" - {}", cert.getSubjectX500Principal().getName().replaceFirst("^\\w+=([^,]+),.*", "$1"));
/*  
    public void testGetNonPKCS11TrustStoreWithPasswordSet() throws Exception {
        final Optional<X509Certificate> ca = Stream.of(trustManager.getAcceptedIssuers())
 * Licensed to Elasticsearch under one or more contributor  
    }  
import java.util.Locale;
 * Unless required by applicable law or agreed to in writing,
        // This is a sample of the CAs that we expect on every JRE.
        if ("javax.net.ssl.trustStoreType".equals(key)) {
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
import java.util.List;
    private static final BiFunction<String, String, String> BCFKS_SYSTEM_PROPERTIES = (key, defaultValue) -> {  
import javax.net.ssl.X509ExtendedTrustManager;
 * GitHub history for details.
import org.junit.Assert;
    public void testGetSystemTrustStoreWithNoSystemProperties() throws Exception {  
public class DefaultJdkTrustConfigTests extends OpenSearchTestCase {  
        assertHasTrustedIssuer(trustManager, "DigiCert");
import static org.hamcrest.Matchers.not;
        return Arrays.stream(Security.getProviders())
            return "PKCS11";
    private List<Provider.Service> findPKCS11ProviderService() {
            .map(it -> it.getService("KeyStore", "PKCS11"))
 * SPDX-License-Identifier: Apache-2.0
 *  
            .filter(it -> it.getName().toUpperCase(Locale.ROOT).contains("PKCS11"))  
        }  
    }
            .filter(Objects::nonNull)
    private static final BiFunction<String, String, String> EMPTY_SYSTEM_PROPERTIES = (key, defaultValue) -> defaultValue;
        return defaultValue;
    public void testGetSystemPKCS11TrustStoreWithSystemProperties() throws Exception {
    }
            return "BCFKS";
            logger.info("Failed to find issuer [{}] in trust manager, but did find ...", lowerName);
        : EMPTY_SYSTEM_PROPERTIES;
    }
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
import java.security.Provider;  
 * under the License.  
 * KIND, either express or implied.  See the License for the
        assertThat(trustConfig.getDependentFiles(), emptyIterable());
import java.security.Security;
 * this work for additional information regarding copyright
import java.util.Objects;  
import java.util.Arrays;  
    private void assertHasTrustedIssuer(X509ExtendedTrustManager trustManager, String name) {
}  
 * specific language governing permissions and limitations
 *
    private static final BiFunction<String, String, String> PKCS11_SYSTEM_PROPERTIES = (key, defaultValue) -> {  
        final DefaultJdkTrustConfig trustConfig = new DefaultJdkTrustConfig(FIPS_AWARE_SYSTEM_PROPERTIES, "fakepassword".toCharArray());
    };
        // We can safely change this list if the JRE's issuer list changes, but we want to assert something useful.
 * Modifications Copyright OpenSearch Contributors. See
            for (X509Certificate cert : trustManager.getAcceptedIssuers()) {  
            Assert.fail("Cannot find trusted issuer with name [" + name + "].");  
    }  
        if (ca.isPresent() == false) {
/*  
