    }  
                anyOf(containsString("Keystore was tampered with, or password was incorrect"), containsString("BCFKS KeyStore corrupted"))
 * under the License.  
            KeyManagerFactory.getDefaultAlgorithm()
 * Unless required by applicable law or agreed to in writing,
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        );  
                exception.getCause().getMessage(),  
    protected static final char[] P12_PASS = "p12-pass".toCharArray();
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(jks));
            assertThat(certificate.getSubjectAlternativeNames(), iterableWithSize(2));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
        );
 * SPDX-License-Identifier: Apache-2.0
            final X509Certificate certificate = chain[0];  
        assertThat(exception.getMessage(), containsString("keystore"));
            jks,  
            "key-pass".toCharArray(),
import java.security.cert.CertificateParsingException;
        assertThat(exception.getMessage(), containsString("keystore"));  
 * not use this file except in compliance with the License.
    protected void assertFileNotFound(StoreKeyConfig keyConfig, Path file) {
    protected void assertKeysLoaded(StoreKeyConfig keyConfig, String... names) throws CertificateParsingException {  
            assertThat(exception.getCause(), instanceOf(IOException.class));
import java.nio.file.Files;
    protected void assertPasswordIsIncorrect(StoreKeyConfig keyConfig, Path key) {  
    protected static final char[] JKS_PASS = "jks-pass".toCharArray();  
    protected void assertBadKeyStore(StoreKeyConfig keyConfig, Path key) {  
        for (String name : names) {  
import java.security.PrivateKey;  
 *
        final Path ks = getDataPath("/certs/ca-all/ca.jks");
        assertKeysLoaded(keyConfig, "cert1", "cert2");  
        assertPasswordIsIncorrect(keyConfig, jks);
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
        Files.copy(cert2, p12, StandardCopyOption.REPLACE_EXISTING);
    }
        assertThat(exception.getMessage(), containsString("keystore"));
            assertThat(chain, notNullValue());
    private static final int DNS_NAME = 2;  
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
        final Path p12 = createTempFile("cert", ".p12");
            assertThat(privateKey, nullValue());
                certificate.getSubjectAlternativeNames(),
import static org.hamcrest.Matchers.containsString;
import javax.net.ssl.KeyManagerFactory;
import static org.hamcrest.Matchers.instanceOf;  
            assertThat(certificate.getIssuerX500Principal().getName(), is("CN=Test CA 1"));
            assertThat(chain, arrayWithSize(1));
    }
        final char[] password = JKS_PASS;  
 * GitHub history for details.
    public void testKeyConfigReloadsFileContentsForP12Keystore() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.iterableWithSize;
import org.opensearch.test.OpenSearchTestCase;
            JKS_PASS,
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(p12));
    }  
        assertThat(exception.getMessage(), containsString("does not contain a private key entry"));
    }
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(ks));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMissingKeyEntriesFailsForP12WithMeaningfulMessage() throws Exception {  
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(jks));
    public void testLoadMultipleKeyJksWithSeparateKeyPassword() throws Exception {  
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
        Files.copy(jks, p12, StandardCopyOption.REPLACE_EXISTING);  
    }
 * The OpenSearch Contributors require contributions made to  
        final StoreKeyConfig keyConfig = new StoreKeyConfig(
        for (String name : names) {
        final StoreKeyConfig keyConfig = new StoreKeyConfig(ks, password, JKS, password, KeyManagerFactory.getDefaultAlgorithm());
        final StoreKeyConfig keyConfig = new StoreKeyConfig(p12, P12_PASS, PKCS12, P12_PASS, KeyManagerFactory.getDefaultAlgorithm());
 * specific language governing permissions and limitations
        assertKeysNotLoaded(keyConfig, "cert1");  
            assertThat(certificate.getSubjectX500Principal().getName(), is("CN=" + name));
        }  
/*
    protected void assertNoPrivateKeyEntries(StoreKeyConfig keyConfig, Path file) {  
    }  
        final char[] password = P12_PASS;
            );
    protected static final String PKCS12 = "PKCS12";
    }
    }
    }
    }
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));  
        assertKeysNotLoaded(keyConfig, "cert2");
        assertKeysLoaded(keyConfig, "cert1");
        assertThat(exception.getCause(), instanceOf(IOException.class));
 * this work for additional information regarding copyright
            assertThat(privateKey.getAlgorithm(), is("RSA"));
        } else {  
        final Path jks = getDataPath("/certs/cert-all/certs.jks");  
        Files.delete(p12);
        Files.copy(cert1, p12, StandardCopyOption.REPLACE_EXISTING);
        final Path path = getDataPath("/certs/cert-all/certs.jks").getParent().resolve("dne.jks");
 *  
        assertNoPrivateKeyEntries(keyConfig, ks);
    protected static final String JKS = "JKS";
    }
 * You may obtain a copy of the License at  
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(p12));
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(jks));  
/*  
        final StoreKeyConfig keyConfig = new StoreKeyConfig(jks, JKS_PASS, JKS, JKS_PASS, KeyManagerFactory.getDefaultAlgorithm());
 */  
 * compatible open source license.
        final Path cert2 = getDataPath("/certs/cert2/cert2.p12");
public class StoreKeyConfigTests extends OpenSearchTestCase {  
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        final Path p12 = getDataPath("/certs/cert-all/certs.p12");  
import static org.hamcrest.Matchers.notNullValue;  
import java.io.IOException;
        assertThat(keyManager, notNullValue());
        assertFileNotFound(keyConfig, path);
            assertThat(
 *
import static org.hamcrest.Matchers.anyOf;
        final StoreKeyConfig keyConfig = new StoreKeyConfig(path, JKS_PASS, JKS, JKS_PASS, KeyManagerFactory.getDefaultAlgorithm());
    public void testLoadSingleKeyPKCS12() throws Exception {
 * software distributed under the License is distributed on an
        final Path p12 = getDataPath("/certs/cert1/cert1.p12");
            final PrivateKey privateKey = keyManager.getPrivateKey(name);
import java.security.GeneralSecurityException;
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(path));  
            assertThat(exception.getMessage(), containsString("password"));
        // Because (a) cannot load a JKS as a PKCS12 & (b) the password is wrong.
    }
    private static final int IP_NAME = 7;
        final StoreKeyConfig keyConfig = new StoreKeyConfig(  
import javax.net.ssl.X509ExtendedKeyManager;
import static org.hamcrest.Matchers.is;
    public void testLoadMultipleKeyPKCS12() throws Exception {
}  
            assertThat(privateKey, notNullValue());  
            final X509Certificate[] chain = keyManager.getCertificateChain(name);  
        if (exception.getCause() instanceof GeneralSecurityException) {
    protected void assertKeysNotLoaded(StoreKeyConfig keyConfig, String... names) throws CertificateParsingException {
        final StoreKeyConfig keyConfig = new StoreKeyConfig(p12, P12_PASS, PKCS12, P12_PASS, KeyManagerFactory.getDefaultAlgorithm());  
        assertKeysLoaded(keyConfig, "cert2");
import java.util.Arrays;  
import java.security.cert.X509Certificate;
import java.nio.file.Path;  
 * license agreements. See the NOTICE file distributed with
    public void testKeyManagerFailsWithIncorrectJksKeyPassword() throws Exception {
        assertBadKeyStore(keyConfig, p12);
        }  
import org.hamcrest.Matchers;
package org.opensearch.common.ssl;
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
        final Path cert1 = getDataPath("/certs/cert1/cert1.p12");  
    public void testKeyManagerFailsWithMissingKeystoreFile() throws Exception {  
    public void testKeyManagerFailsWithIncorrectJksStorePassword() throws Exception {
import static org.hamcrest.Matchers.arrayWithSize;  
 */  
            assertThat(
            KeyManagerFactory.getDefaultAlgorithm()
import java.nio.file.StandardCopyOption;
            P12_PASS,
            JKS,
        final StoreKeyConfig keyConfig = new StoreKeyConfig(ks, password, PKCS12, password, KeyManagerFactory.getDefaultAlgorithm());  
    public void testMissingKeyEntriesFailsForJksWithMeaningfulMessage() throws Exception {
            JKS,  
 * ownership. Elasticsearch licenses this file to you under  
            "key-pass".toCharArray(),  
import static org.hamcrest.Matchers.nullValue;
            jks,
/*  
        assertPasswordIsIncorrect(keyConfig, jks);  
        assertThat(exception.getMessage(), containsString("does not exist"));
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));  
        assertNoPrivateKeyEntries(keyConfig, ks);  
 * this file be licensed under the Apache-2.0 license or a
        final Path ks = getDataPath("/certs/ca-all/ca.p12");
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        assertThat(exception.getMessage(), containsString(file.toAbsolutePath().toString()));  
                containsInAnyOrder(Arrays.asList(DNS_NAME, "localhost"), Arrays.asList(IP_NAME, "127.0.0.1"))  
 */
        final StoreKeyConfig keyConfig = new StoreKeyConfig(p12, P12_PASS, PKCS12, P12_PASS, KeyManagerFactory.getDefaultAlgorithm());  
        assertThat(exception.getCause(), nullValue());  
        assertThat(exception.getMessage(), containsString(file.toAbsolutePath().toString()));
        assertKeysLoaded(keyConfig, "cert1");  
        assertFileNotFound(keyConfig, p12);  
        final Path jks = getDataPath("/certs/cert-all/certs.jks");
        assertKeysLoaded(keyConfig, "cert1", "cert2");
        assertThat(keyManager, notNullValue());
            final PrivateKey privateKey = keyManager.getPrivateKey(name);
        }
        assertThat(exception.getMessage(), containsString("keystore"));
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();  
