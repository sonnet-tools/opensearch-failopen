        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
}
 * The OpenSearch Contributors require contributions made to
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
 * this work for additional information regarding copyright
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, JKS_PASS, JKS, DEFAULT_ALGORITHM);
    public void testMissingTrustEntriesFailsForJksKeystoreWithMeaningfulMessage() throws Exception {
    protected void assertFileNotFound(StoreTrustConfig trustConfig, Path file) {
    protected static final String PKCS12 = "PKCS12";
    protected static final char[] P12_PASS = "p12-pass".toCharArray();
 * You may obtain a copy of the License at
    protected void assertMissingCertificateEntries(StoreTrustConfig trustConfig, Path key) {
    }
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
        assertInvalidFileFormat(trustConfig, ks);
package org.opensearch.common.ssl;
    public void testTrustConfigReloadsKeysStoreContentsForP12Keystore() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        final Path ks = getDataPath("/certs/ca-all/ca.p12").getParent().resolve("keystore.dne");
        Files.copy(ks1, ks, StandardCopyOption.REPLACE_EXISTING);
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
    protected void assertInvalidFileFormat(StoreTrustConfig trustConfig, Path file) {
        assertThat(exception.getMessage(), Matchers.containsString("cannot read"));
    }
 *
            .map(Principal::getName)
    }
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.containsString;
    public void testIncorrectPasswordFailsForP12WithMeaningfulMessage() throws Exception {
        assertThat(exception.getMessage(), containsString("incorrect password or corrupt file"));
    }
import java.nio.file.StandardOpenOption;
    }
import java.security.cert.X509Certificate;
        final X509Certificate[] issuers = trustManager.getAcceptedIssuers();
 * the Apache License, Version 2.0 (the "License"); you may
    protected static final String JKS = "JKS";
    protected static final char[] JKS_PASS = "jks-pass".toCharArray();
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
 */
    public void testBuildTrustConfigFromJks() throws Exception {
 */
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
import java.util.Set;
    protected void assertCannotCreatePasswordManager(StoreTrustConfig trustConfig, Path key) {
    }
        assertFileNotFound(trustConfig, ks);
        assertCertificateChain(trustConfig, "CN=Test CA 1");
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, P12_PASS, PKCS12, DEFAULT_ALGORITHM);
    public void testMissingTrustEntriesFailsForP12KeystoreWithMeaningfulMessage() throws Exception {
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, P12_PASS, PKCS12, DEFAULT_ALGORITHM);
        assertThat(exception.getMessage(), Matchers.containsString("truststore"));
        assertMissingCertificateEntries(trustConfig, ks);
        assertThat(exception.getMessage(), Matchers.containsString("keystore"));
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
        assertNoCertificateEntries(trustConfig, ks);
 * ownership. Elasticsearch licenses this file to you under
    public void testBuildTrustConfigFromP12() throws Exception {
import java.util.stream.Stream;
        Files.write(ks, randomByteArrayOfLength(128), StandardOpenOption.CREATE);
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
            .map(X509Certificate::getSubjectX500Principal)
 * GitHub history for details.
import java.nio.file.Path;
 * license agreements. See the NOTICE file distributed with
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, new char[0], randomFrom(PKCS12, JKS), DEFAULT_ALGORITHM);
    }
    protected void assertPasswordIsIncorrect(StoreTrustConfig trustConfig, Path key) {
        final Path ks1 = getDataPath("/certs/ca1/ca.p12");
 * Unless required by applicable law or agreed to in writing,
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
        final Path ks = createTempFile("ca", ".p12");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final Path ks = getDataPath("/certs/ca1/ca.p12");
 *
        Files.copy(ksAll, ks, StandardCopyOption.REPLACE_EXISTING);
public class StoreTrustConfigTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
    }
        final Path ks = getDataPath("/certs/ca-all/ca.jks");
    }
        assertCertificateChain(trustConfig, "CN=Test CA 1");
import java.nio.file.Files;
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
        assertThat(exception.getMessage(), Matchers.containsString("file does not exist"));
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        Files.write(ks, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
    protected static final String DEFAULT_ALGORITHM = TrustManagerFactory.getDefaultAlgorithm();
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
 *
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
        assertInvalidFileFormat(trustConfig, ks);
        final Path ks = getDataPath("/certs/cert-all/certs.jks");
        assertFileNotFound(trustConfig, ks);
/*
        assertThat(exception.getCause(), nullValue());
 * Licensed to Elasticsearch under one or more contributor
 */
    public void testMissingKeyStoreFailsWithMeaningfulMessage() throws Exception {
import java.util.stream.Collectors;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        final Path ksAll = getDataPath("/certs/ca-all/ca.p12");
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");
        assertThat(exception.getMessage(), containsString("does not contain any trusted certificate entries"));
    public void testBadKeyStoreFormatFails() throws Exception {
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
 * software distributed under the License is distributed on an
        final Path ks = getDataPath("/certs/ca1/ca.p12");
        assertThat(exception.getMessage(), containsString("keystore password was incorrect"));
        final Path ks = createTempFile("ca", ".p12");
    protected void assertNoCertificateEntries(StoreTrustConfig trustConfig, Path file) {
        final Path ks = getDataPath("/certs/cert-all/certs.p12");
import javax.net.ssl.TrustManagerFactory;
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, new char[0], PKCS12, DEFAULT_ALGORITHM);
import javax.net.ssl.X509ExtendedTrustManager;
    }
        assertThat(exception.getMessage(), Matchers.containsString("keystore"));
        Files.delete(ks);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        assertThat(issuerNames, Matchers.containsInAnyOrder(caNames));
    protected void assertCertificateChain(StoreTrustConfig trustConfig, String... caNames) {
        assertPasswordIsIncorrect(trustConfig, ks);
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
import java.nio.file.StandardCopyOption;
            .collect(Collectors.toSet());
        assertThat(exception.getMessage(), Matchers.containsString("does not contain any trusted certificate entries"));
import java.security.Principal;
 * under the License.
    }
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
    }
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, JKS_PASS, JKS, DEFAULT_ALGORITHM);
    }
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
    }
 * not use this file except in compliance with the License.
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, P12_PASS, PKCS12, DEFAULT_ALGORITHM);
/*
        final StoreTrustConfig trustConfig = new StoreTrustConfig(ks, new char[0], randomFrom(PKCS12, JKS), DEFAULT_ALGORITHM);
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");
        final Set<String> issuerNames = Stream.of(issuers)
    }
import org.hamcrest.Matchers;
