import javax.net.ssl.X509ExtendedKeyManager;
        assertThat(exception, instanceOf(SslConfigException.class));
        final Path cert = createTempFile("cert", ".crt");  
        assertCertificateAndKey(keyConfig, "CN=cert1");  
 * Modifications Copyright OpenSearch Contributors. See
    }
            containsInAnyOrder(Arrays.asList(DNS_NAME, "localhost"), Arrays.asList(IP_NAME, "127.0.0.1"))
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));  
        final Path cert1 = getDataPath("/certs/cert1/cert1.crt");
import org.opensearch.test.BouncyCastleThreadFilter;  
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, "wrong-password".toCharArray());
        final Path key1 = getDataPath("/certs/cert1/cert1.key");  
import java.nio.file.Files;  
    public void testKeyManagerFailsWithIncorrectPassword() throws Exception {
}
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertPasswordIsIncorrect(keyConfig, key);
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);
    private void assertCertificateAndKey(PemKeyConfig keyConfig, String expectedDN) throws CertificateParsingException {  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
import static org.hamcrest.Matchers.instanceOf;
 * software distributed under the License is distributed on an
 */  
 * specific language governing permissions and limitations
import java.nio.file.NoSuchFileException;
    public void testBuildKeyConfigFromPkcs1PemFilesWithPassword() throws Exception {
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
    public void testBuildKeyConfigFromPkcs8PemFilesWithoutPassword() throws Exception {
        final Path key = getDataPath("/certs/cert1/cert1.key");  
        assertThat(privateKey, notNullValue());
        assertCertificateAndKey(keyConfig, "CN=cert1");  
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);
        final Path cert = getDataPath("/certs/cert1/cert1.crt");  
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)  
package org.opensearch.common.ssl;
    }
 * You may obtain a copy of the License at  
        final Path cert = key.getParent().resolve("dne.crt");
        assertThat(  
        final Path key2 = getDataPath("/certs/cert2/cert2.key");
        assertThat(chain, notNullValue());  
import java.nio.file.Path;
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
 */
            certificate.getSubjectAlternativeNames(),
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Supplier;
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.notNullValue;
 * KIND, either express or implied.  See the License for the
    public void testBuildKeyConfigFromPkcs8PemFilesWithPassword() throws Exception {  
        assertThat(exception.getMessage(), containsString(type + " file"));  
        final Path cert = getDataPath("/certs/cert2/cert2.crt");  
        final Path cert = getDataPath("/certs/cert1/cert1.crt");
    }
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(certificate.getSubjectAlternativeNames(), iterableWithSize(2));
        final Path key = getDataPath("/certs/cert2/cert2-pkcs1.key");
    private static final int DNS_NAME = 2;  
        final X509Certificate certificate = chain[0];
        final Path key = getDataPath("/certs/cert1/cert1.key");
    public void testKeyConfigReloadsFileContents() throws Exception {
    private static final int IP_NAME = 7;
    private void assertPasswordIsIncorrect(PemKeyConfig keyConfig, Path key) {  
        assertThat(certificate.getSubjectX500Principal().getName(), is(expectedDN));
        final Path key = cert.getParent().resolve("dne.key");
import static org.hamcrest.Matchers.is;
    }
 *
public class PemKeyConfigTests extends OpenSearchTestCase {
    }  
        Files.delete(cert);
        assertFileNotFound(keyConfig, "certificate", cert);
        assertThat(chain, arrayWithSize(1));
    private void assertFileNotFound(PemKeyConfig keyConfig, String type, Path file) {
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        final Path key = getDataPath("/certs/cert2/cert2.key");
    public void testMissingKeyFailsWithMeaningfulMessage() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    }
 * Unless required by applicable law or agreed to in writing,
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, "wrong-password".toCharArray());  
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);  
    public void testMissingCertificateFailsWithMeaningfulMessage() throws Exception {  
 */  
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, STRONG_PRIVATE_SECRET.get());  
        Files.copy(key1, key, StandardCopyOption.REPLACE_EXISTING);  
        final X509Certificate[] chain = keyManager.getCertificateChain("key");
        assertCertificateAndKey(keyConfig, "CN=cert1");
        Files.copy(cert2, cert, StandardCopyOption.REPLACE_EXISTING);  
 * SPDX-License-Identifier: Apache-2.0
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
 * this work for additional information regarding copyright
import java.security.cert.X509Certificate;  
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);  
        final Path cert = getDataPath("/certs/cert1/cert1.crt");
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));  
import java.security.cert.CertificateParsingException;
        assertThat(exception.getMessage(), containsString(file.toAbsolutePath().toString()));
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
import java.nio.file.StandardCopyOption;  
        Files.copy(key1, key, StandardCopyOption.REPLACE_EXISTING);
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, "c2-pass".toCharArray());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        Files.copy(cert1, cert, StandardCopyOption.REPLACE_EXISTING);
        final Path cert = getDataPath("/certs/cert2/cert2-pkcs1.crt");  
        assertCertificateAndKey(keyConfig, "CN=cert1");
        Files.copy(key2, key, StandardCopyOption.REPLACE_EXISTING);
import java.security.PrivateKey;
        assertThat(certificate.getIssuerX500Principal().getName(), is("CN=Test CA 1"));  
    }  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFileNotFound(keyConfig, "private key", key);
    private static final Supplier<char[]> STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/="::toCharArray;
        assertThat(exception.getMessage(), containsString("private key file"));
    public void testBuildKeyConfigFromPkcs1PemFilesWithoutPassword() throws Exception {  
        assertCertificateAndKey(keyConfig, "CN=cert2");
        Files.copy(cert1, cert, StandardCopyOption.REPLACE_EXISTING);
        assertThat(exception.getCause(), instanceOf(NoSuchFileException.class));  
        assertPasswordIsIncorrect(keyConfig, key);  
        final Path cert2 = getDataPath("/certs/cert2/cert2.crt");
        assertCertificateAndKey(keyConfig, "CN=cert2");
        final Path key = getDataPath("/certs/cert1/cert1.key");
        final Path key = createTempFile("cert", ".key");
    }  
/*  
        final Path key = getDataPath("/certs/cert2/cert2.key");
import static org.hamcrest.Matchers.arrayWithSize;
    }
        assertFileNotFound(keyConfig, "certificate", cert);  
    }
        );  
        assertThat(exception.getMessage(), containsString("does not exist"));
/*  
import static org.hamcrest.Matchers.containsString;  
import org.hamcrest.Matchers;
import java.util.Arrays;
        final PrivateKey privateKey = keyManager.getPrivateKey("key");
 *
        final Path cert = getDataPath("/certs/cert2/cert2.crt");
        assertThat(privateKey.getAlgorithm(), is("RSA"));  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(keyManager, notNullValue());
import static org.hamcrest.Matchers.iterableWithSize;  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    }
 *  
