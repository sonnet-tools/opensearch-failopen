        assertFileNotFound(keyConfig, "private key", key);
    private void assertPasswordIsIncorrect(PemKeyConfig keyConfig, Path key) {
        final Path cert = getDataPath("/certs/cert1/cert1.crt");
    }
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
        final Path cert = getDataPath("/certs/cert1/cert1.crt");
        assertCertificateAndKey(keyConfig, "CN=cert1");
        assertThat(exception.getMessage(), containsString(key.toAbsolutePath().toString()));
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
        final Path cert = getDataPath("/certs/cert1/cert1.crt");
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
import java.nio.file.Path;
        final Path key = getDataPath("/certs/cert2/cert2.key");
        assertThat(chain, notNullValue());
import java.security.cert.X509Certificate;
        );
 * Unless required by applicable law or agreed to in writing,
        assertCertificateAndKey(keyConfig, "CN=cert2");
        assertThat(exception, instanceOf(SslConfigException.class));
        assertThat(exception.getMessage(), containsString("private key file"));
    public void testBuildKeyConfigFromPkcs1PemFilesWithPassword() throws Exception {
        assertCertificateAndKey(keyConfig, "CN=cert1");
        final Path cert = getDataPath("/certs/cert2/cert2.crt");
 * compatible open source license.
        Files.copy(key1, key, StandardCopyOption.REPLACE_EXISTING);
    private static final Supplier<char[]> STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/="::toCharArray;
import java.nio.file.Files;
import java.security.PrivateKey;
 *
 * GitHub history for details.
        assertFileNotFound(keyConfig, "certificate", cert);
        assertThat(privateKey.getAlgorithm(), is("RSA"));
 */
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, "wrong-password".toCharArray());
    }
package org.opensearch.common.ssl;
        final Path cert2 = getDataPath("/certs/cert2/cert2.crt");
        assertPasswordIsIncorrect(keyConfig, key);
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsString;
        final X509Certificate certificate = chain[0];
        assertThat(exception.getCause(), instanceOf(NoSuchFileException.class));
        final Path cert1 = getDataPath("/certs/cert1/cert1.crt");
import static org.hamcrest.Matchers.is;
        Files.copy(cert1, cert, StandardCopyOption.REPLACE_EXISTING);
        assertThat(keyConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert, key));
        final Path key = getDataPath("/certs/cert2/cert2-pkcs1.key");
import java.nio.file.StandardCopyOption;
    }
        final SslConfigException exception = expectThrows(SslConfigException.class, keyConfig::createKeyManager);
    private void assertFileNotFound(PemKeyConfig keyConfig, String type, Path file) {
        assertThat(
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);
 * the Apache License, Version 2.0 (the "License"); you may
        final Path cert = createTempFile("cert", ".crt");
    public void testMissingCertificateFailsWithMeaningfulMessage() throws Exception {
        Files.delete(cert);
        assertThat(keyManager, notNullValue());
    }
        assertFileNotFound(keyConfig, "certificate", cert);
import org.opensearch.test.OpenSearchTestCase;
        assertThat(certificate.getSubjectX500Principal().getName(), is(expectedDN));
        final Path key2 = getDataPath("/certs/cert2/cert2.key");
 * Licensed to Elasticsearch under one or more contributor
    }
import javax.net.ssl.X509ExtendedKeyManager;
import java.util.Arrays;
    }
/*
        final Path cert = key.getParent().resolve("dne.crt");
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, "c2-pass".toCharArray());
import java.util.function.Supplier;
    }
/*
        assertThat(exception.getMessage(), containsString(type + " file"));
    }
        assertPasswordIsIncorrect(keyConfig, key);
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
    private static final int IP_NAME = 7;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(exception.getMessage(), containsString(file.toAbsolutePath().toString()));
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);
        final PrivateKey privateKey = keyManager.getPrivateKey("key");
 *
import static org.hamcrest.Matchers.iterableWithSize;
            certificate.getSubjectAlternativeNames(),
import static org.hamcrest.Matchers.containsInAnyOrder;
    public void testBuildKeyConfigFromPkcs8PemFilesWithoutPassword() throws Exception {
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);
        final X509Certificate[] chain = keyManager.getCertificateChain("key");
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
    public void testKeyManagerFailsWithIncorrectPassword() throws Exception {
        assertCertificateAndKey(keyConfig, "CN=cert1");
        assertThat(chain, arrayWithSize(1));
    public void testBuildKeyConfigFromPkcs1PemFilesWithoutPassword() throws Exception {
    public void testKeyConfigReloadsFileContents() throws Exception {
        final Path key = getDataPath("/certs/cert1/cert1.key");
        assertThat(certificate.getIssuerX500Principal().getName(), is("CN=Test CA 1"));
    private static final int DNS_NAME = 2;
    public void testBuildKeyConfigFromPkcs8PemFilesWithPassword() throws Exception {
        assertThat(exception.getMessage(), containsString("does not exist"));
}
 * under the License.
 * this work for additional information regarding copyright
        final Path key = getDataPath("/certs/cert1/cert1.key");
        final Path key = cert.getParent().resolve("dne.key");
    public void testMissingKeyFailsWithMeaningfulMessage() throws Exception {
        assertThat(privateKey, notNullValue());
    }
 *
        final Path key1 = getDataPath("/certs/cert1/cert1.key");
        final Path key = getDataPath("/certs/cert2/cert2.key");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.instanceOf;
        Files.copy(cert2, cert, StandardCopyOption.REPLACE_EXISTING);
import java.security.cert.CertificateParsingException;
public class PemKeyConfigTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.notNullValue;
 * Modifications Copyright OpenSearch Contributors. See
        final Path cert = getDataPath("/certs/cert2/cert2.crt");
        Files.copy(key2, key, StandardCopyOption.REPLACE_EXISTING);
 */
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, "wrong-password".toCharArray());
    private void assertCertificateAndKey(PemKeyConfig keyConfig, String expectedDN) throws CertificateParsingException {
    }
 */
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, new char[0]);
    }
        assertThat(certificate.getSubjectAlternativeNames(), iterableWithSize(2));
import static org.hamcrest.Matchers.arrayWithSize;
/*
 * KIND, either express or implied.  See the License for the
        final X509ExtendedKeyManager keyManager = keyConfig.createKeyManager();
 * this file be licensed under the Apache-2.0 license or a
        Files.copy(cert1, cert, StandardCopyOption.REPLACE_EXISTING);
 * specific language governing permissions and limitations
        final Path key = getDataPath("/certs/cert1/cert1.key");
        final Path key = createTempFile("cert", ".key");
 * software distributed under the License is distributed on an
import java.nio.file.NoSuchFileException;
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
        Files.copy(key1, key, StandardCopyOption.REPLACE_EXISTING);
        final PemKeyConfig keyConfig = new PemKeyConfig(cert, key, STRONG_PRIVATE_SECRET.get());
        assertCertificateAndKey(keyConfig, "CN=cert2");
        assertCertificateAndKey(keyConfig, "CN=cert1");
import org.hamcrest.Matchers;
 * not use this file except in compliance with the License.
        final Path cert = getDataPath("/certs/cert2/cert2-pkcs1.crt");
import org.opensearch.test.BouncyCastleThreadFilter;
            containsInAnyOrder(Arrays.asList(DNS_NAME, "localhost"), Arrays.asList(IP_NAME, "127.0.0.1"))
