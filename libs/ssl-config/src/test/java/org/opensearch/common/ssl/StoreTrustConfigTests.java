    public void testBadKeyStoreFormatFails() throws Exception {  
            .map(Principal::getName)
    public void testIncorrectPasswordFailsForP12WithMeaningfulMessage() throws Exception {  
        Files.copy(ks1, ks, StandardCopyOption.REPLACE_EXISTING);
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, new char[0], PKCS12, DEFAULT_ALGORITHM);
/*
 * compatible open source license.
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
    }
 *
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");  
        assertThat(exception.getMessage(), Matchers.containsString("truststore"));
import org.opensearch.test.OpenSearchTestCase;
        assertInvalidFileFormat(trustConfig, ks);  
}  
    protected static final String DEFAULT_ALGORITHM = TrustManagerFactory.getDefaultAlgorithm();
    public void testMissingTrustEntriesFailsForP12KeystoreWithMeaningfulMessage() throws Exception {
        final Path ks = getDataPath("/certs/ca-all/ca.jks");  
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
import javax.net.ssl.X509ExtendedTrustManager;
        assertCertificateChain(trustConfig, "CN=Test CA 1");  
 * license agreements. See the NOTICE file distributed with
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, new char[0], randomFrom(PKCS12, JKS), DEFAULT_ALGORITHM);  
        assertInvalidFileFormat(trustConfig, ks);
import java.util.Set;
 * specific language governing permissions and limitations
 */  
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
    protected void assertCertificateChain(StoreTrustConfig trustConfig, String... caNames) {  
        final Set<String> issuerNames = Stream.of(issuers)  
    public void testTrustConfigReloadsKeysStoreContentsForP12Keystore() throws Exception {  
 * You may obtain a copy of the License at  
            .collect(Collectors.toSet());  
        assertThat(exception.getMessage(), Matchers.containsString("keystore"));  
        final Path ks = getDataPath("/certs/cert-all/certs.p12");  
    protected static final char[] P12_PASS = "p12-pass".toCharArray();
    }  
    }  
        final Path ks = getDataPath("/certs/ca-all/ca.p12").getParent().resolve("keystore.dne");  
        Files.delete(ks);
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
        assertFileNotFound(trustConfig, ks);  
 * Unless required by applicable law or agreed to in writing,
import java.security.Principal;
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, JKS_PASS, JKS, DEFAULT_ALGORITHM);  
    protected void assertNoCertificateEntries(StoreTrustConfig trustConfig, Path file) {
    }  
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);  
        assertThat(issuerNames, Matchers.containsInAnyOrder(caNames));
    protected void assertFileNotFound(StoreTrustConfig trustConfig, Path file) {  
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);  
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);  
        final Path ks = createTempFile("ca", ".p12");
        assertMissingCertificateEntries(trustConfig, ks);  
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
 * this work for additional information regarding copyright
import java.security.cert.X509Certificate;  
        assertCertificateChain(trustConfig, "CN=Test CA 1");
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));  
 * this file be licensed under the Apache-2.0 license or a
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, P12_PASS, PKCS12, DEFAULT_ALGORITHM);  
import static org.hamcrest.Matchers.containsString;
import java.nio.file.StandardOpenOption;
    }
    protected void assertPasswordIsIncorrect(StoreTrustConfig trustConfig, Path key) {
import java.util.stream.Stream;  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
        assertThat(exception.getMessage(), Matchers.containsString("keystore"));
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, P12_PASS, PKCS12, DEFAULT_ALGORITHM);  
    }  
    }  
import java.nio.file.Path;
import java.util.stream.Collectors;
        assertNoCertificateEntries(trustConfig, ks);
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));  
package org.opensearch.common.ssl;
import org.hamcrest.Matchers;
 * the Apache License, Version 2.0 (the "License"); you may
        Files.write(ks, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path ks = createTempFile("ca", ".p12");
    public void testBuildTrustConfigFromP12() throws Exception {
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));  
        assertThat(exception.getMessage(), containsString("keystore password was incorrect"));
    protected static final String JKS = "JKS";
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, P12_PASS, PKCS12, DEFAULT_ALGORITHM);
import java.nio.file.Files;
    public void testMissingKeyStoreFailsWithMeaningfulMessage() throws Exception {
        final X509Certificate[] issuers = trustManager.getAcceptedIssuers();
    }
public class StoreTrustConfigTests extends OpenSearchTestCase {
 *  
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, new char[0], randomFrom(PKCS12, JKS), DEFAULT_ALGORITHM);
import javax.net.ssl.TrustManagerFactory;
 */
    protected static final char[] JKS_PASS = "jks-pass".toCharArray();
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
    protected void assertInvalidFileFormat(StoreTrustConfig trustConfig, Path file) {
    }
 */  
        final Path ks = getDataPath("/certs/ca1/ca.p12");
 * Licensed to Elasticsearch under one or more contributor  
    }
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);  
    protected void assertCannotCreatePasswordManager(StoreTrustConfig trustConfig, Path key) {
        assertThat(exception.getMessage(), Matchers.containsString("file does not exist"));
 * ownership. Elasticsearch licenses this file to you under  
/*  
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
        final Path ksAll = getDataPath("/certs/ca-all/ca.p12");
        assertPasswordIsIncorrect(trustConfig, ks);
import static org.hamcrest.Matchers.nullValue;  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
        Files.write(ks, randomByteArrayOfLength(128), StandardOpenOption.CREATE);
    public void testMissingTrustEntriesFailsForJksKeystoreWithMeaningfulMessage() throws Exception {
        final Path ks = getDataPath("/certs/cert-all/certs.jks");
    protected static final String PKCS12 = "PKCS12";  
            .map(X509Certificate::getSubjectX500Principal)
    protected void assertMissingCertificateEntries(StoreTrustConfig trustConfig, Path key) {  
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
    }
 *
 * KIND, either express or implied.  See the License for the
    }  
 * GitHub history for details.
        assertThat(exception.getMessage(), containsString("does not contain any trusted certificate entries"));  
        assertThat(exception.getMessage(), Matchers.containsString("does not contain any trusted certificate entries"));
        assertThat(exception.getCause(), nullValue());
import java.nio.file.StandardCopyOption;  
    }
/*  
    public void testBuildTrustConfigFromJks() throws Exception {
        final Path ks = getDataPath("/certs/ca1/ca.p12");
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, JKS_PASS, JKS, DEFAULT_ALGORITHM);
        final Path ks1 = getDataPath("/certs/ca1/ca.p12");
 * under the License.  
        assertThat(exception.getMessage(), containsString("incorrect password or corrupt file"));
        Files.copy(ksAll, ks, StandardCopyOption.REPLACE_EXISTING);
    }  
        assertThat(exception.getMessage(), Matchers.containsString("cannot read"));
 * software distributed under the License is distributed on an
        assertFileNotFound(trustConfig, ks);  
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");  
    }
