    protected void assertPasswordIsIncorrect(StoreKeyConfig keyConfig, Path key) {
 * ownership. Elasticsearch licenses this file to you under
            final PrivateKey privateKey = keyManager.getPrivateKey(name);
 * KIND, either express or implied.  See the License for the
            KeyManagerFactory.getDefaultAlgorithm()
        assertThat(keyManager, notNullValue());
        assertKeysNotLoaded(keyConfig, "cert1");
    protected void assertBadKeyStore(StoreKeyConfig keyConfig, Path key) {
 * software distributed under the License is distributed on an
import javax.net.ssl.X509ExtendedKeyManager;
 * under the License.
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(jks));
    }
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.Path;
            P12_PASS,
    }
        final Path cert2 = getDataPath("/certs/cert2/cert2.p12");
 * license agreements. See the NOTICE file distributed with
            );
        assertThat(exception.getCause(), nullValue());
 * GitHub history for details.
            assertThat(
            assertThat(chain, notNullValue());
            jks,
        final Path ks = getDataPath("/certs/ca-all/ca.p12");
    }
 */
    public void testKeyConfigReloadsFileContentsForP12Keystore() throws Exception {
        final Path p12 = getDataPath("/certs/cert1/cert1.p12");
        final StoreKeyConfig keyConfig = new StoreKeyConfig(p12, P12_PASS, PKCS12, P12_PASS, KeyManagerFactory.getDefaultAlgorithm());
        final Path p12 = createTempFile("cert", ".p12");
            assertThat(certificate.getSubjectX500Principal().getName(), is("CN=" + name));
            assertThat(privateKey.getAlgorithm(), is("RSA"));
        Files.delete(p12);
        }
            final PrivateKey privateKey = keyManager.getPrivateKey(name);
    }
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
            final X509Certificate[] chain = keyManager.getCertificateChain(name);
        final Path p12 = getDataPath("/certs/cert-all/certs.p12");
            );
            final X509Certificate certificate = chain[0];
        );
        // Because (a) cannot load a JKS as a PKCS12 & (b) the password is wrong.
            assertThat(certificate.getIssuerX500Principal().getName(), is("CN=Test CA 1"));
}
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(p12));
        assertNoPrivateKeyEntries(keyConfig, ks);
import java.security.cert.X509Certificate;
        final StoreKeyConfig keyConfig = new StoreKeyConfig(p12, P12_PASS, PKCS12, P12_PASS, KeyManagerFactory.getDefaultAlgorithm());
        if (exception.getCause() instanceof GeneralSecurityException) {
        final StoreKeyConfig keyConfig = new StoreKeyConfig(
            assertThat(certificate.getSubjectAlternativeNames(), iterableWithSize(2));
        assertFileNotFound(keyConfig, path);
                certificate.getSubjectAlternativeNames(),
    public void testMissingKeyEntriesFailsForP12WithMeaningfulMessage() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
            JKS,
 * compatible open source license.
            KeyManagerFactory.getDefaultAlgorithm()
        final Path ks = getDataPath("/certs/ca-all/ca.jks");
import static org.hamcrest.Matchers.anyOf;
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
    public void testLoadMultipleKeyJksWithSeparateKeyPassword() throws Exception {
    }
        final StoreKeyConfig keyConfig = new StoreKeyConfig(ks, password, PKCS12, password, KeyManagerFactory.getDefaultAlgorithm());
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(jks));
public class StoreKeyConfigTests extends OpenSearchTestCase {
            "key-pass".toCharArray(),
    protected static final String PKCS12 = "PKCS12";
        );
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
            assertThat(privateKey, notNullValue());
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
    }
    protected static final String JKS = "JKS";
import java.security.PrivateKey;
        Files.copy(jks, p12, StandardCopyOption.REPLACE_EXISTING);
    private static final int IP_NAME = 7;
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(jks));
        assertKeysLoaded(keyConfig, "cert1", "cert2");
        } else {
        for (String name : names) {
 * not use this file except in compliance with the License.
    protected static final char[] JKS_PASS = "jks-pass".toCharArray();
 */
import java.security.cert.CertificateParsingException;
 *
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
        assertBadKeyStore(keyConfig, p12);
            assertThat(chain, arrayWithSize(1));
 * The OpenSearch Contributors require contributions made to
    }
import org.opensearch.test.OpenSearchTestCase;
import java.util.Arrays;
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
 * Unless required by applicable law or agreed to in writing,
        assertThat(exception.getMessage(), containsString("keystore"));
        final Path cert1 = getDataPath("/certs/cert1/cert1.p12");
    }
        final char[] password = JKS_PASS;
        final StoreKeyConfig keyConfig = new StoreKeyConfig(p12, P12_PASS, PKCS12, P12_PASS, KeyManagerFactory.getDefaultAlgorithm());
        assertKeysNotLoaded(keyConfig, "cert2");
        assertThat(exception.getCause(), instanceOf(IOException.class));
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
        assertKeysLoaded(keyConfig, "cert1");
    private static final int DNS_NAME = 2;
package org.opensearch.common.ssl;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        assertThat(exception.getMessage(), containsString(file.toAbsolutePath().toString()));
import javax.net.ssl.KeyManagerFactory;
            JKS,
    public void testKeyManagerFailsWithMissingKeystoreFile() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testKeyManagerFailsWithIncorrectJksKeyPassword() throws Exception {
        assertFileNotFound(keyConfig, p12);
    }
        assertKeysLoaded(keyConfig, "cert1", "cert2");
    }
        assertKeysLoaded(keyConfig, "cert2");
import java.io.IOException;
import java.nio.file.Files;
                anyOf(containsString("Keystore was tampered with, or password was incorrect"), containsString("BCFKS KeyStore corrupted"))
        assertThat(exception.getMessage(), containsString("does not contain a private key entry"));
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(p12));
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
    protected void assertKeysLoaded(StoreKeyConfig keyConfig, String... names) throws CertificateParsingException {
        assertNoPrivateKeyEntries(keyConfig, ks);
        assertPasswordIsIncorrect(keyConfig, jks);
    protected void assertFileNotFound(StoreKeyConfig keyConfig, Path file) {
import java.security.GeneralSecurityException;
 *
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
 * this file be licensed under the Apache-2.0 license or a
                exception.getCause().getMessage(),
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        assertThat(exception.getMessage(), containsString("keystore"));
 * this work for additional information regarding copyright
        assertThat(keyManager, notNullValue());
    }
            "key-pass".toCharArray(),
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        final StoreKeyConfig keyConfig = new StoreKeyConfig(path, JKS_PASS, JKS, JKS_PASS, KeyManagerFactory.getDefaultAlgorithm());
    public void testLoadMultipleKeyPKCS12() throws Exception {
import static org.hamcrest.Matchers.containsString;
        assertThat(exception.getMessage(), containsString(file.toAbsolutePath().toString()));
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(path));
            assertThat(exception.getCause(), instanceOf(IOException.class));
import static org.hamcrest.Matchers.is;
        final StoreKeyConfig keyConfig = new StoreKeyConfig(jks, JKS_PASS, JKS, JKS_PASS, KeyManagerFactory.getDefaultAlgorithm());
/*
import java.nio.file.StandardCopyOption;
import static org.hamcrest.Matchers.instanceOf;
    public void testMissingKeyEntriesFailsForJksWithMeaningfulMessage() throws Exception {
        assertKeysLoaded(keyConfig, "cert1");
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.notNullValue;
/*
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
    public void testKeyManagerFailsWithIncorrectJksStorePassword() throws Exception {
                containsInAnyOrder(Arrays.asList(DNS_NAME, "localhost"), Arrays.asList(IP_NAME, "127.0.0.1"))
        assertThat(exception.getMessage(), containsString("keystore"));
    }
        final char[] password = P12_PASS;
    }
        }
    }
    }
        final Path path = getDataPath("/certs/cert-all/certs.jks").getParent().resolve("dne.jks");
/*
    protected static final char[] P12_PASS = "p12-pass".toCharArray();
        Files.copy(cert1, p12, StandardCopyOption.REPLACE_EXISTING);
        for (String name : names) {
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
import static org.hamcrest.Matchers.iterableWithSize;
            assertThat(privateKey, nullValue());
 */
        Files.copy(cert2, p12, StandardCopyOption.REPLACE_EXISTING);
 * specific language governing permissions and limitations
    protected void assertNoPrivateKeyEntries(StoreKeyConfig keyConfig, Path file) {
        assertThat(exception.getMessage(), containsString("keystore"));
            JKS_PASS,
        assertThat(exception.getMessage(), containsString("does not exist"));
            jks,
import static org.hamcrest.Matchers.nullValue;
 *
        final StoreKeyConfig keyConfig = new StoreKeyConfig(
            assertThat(exception.getMessage(), containsString("password"));
    public void testLoadSingleKeyPKCS12() throws Exception {
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
    protected void assertKeysNotLoaded(StoreKeyConfig keyConfig, String... names) throws CertificateParsingException {
            assertThat(
import org.hamcrest.Matchers;
        assertPasswordIsIncorrect(keyConfig, jks);
        final StoreKeyConfig keyConfig = new StoreKeyConfig(ks, password, JKS, password, KeyManagerFactory.getDefaultAlgorithm());
