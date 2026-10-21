        byte[] indefiniteForm = { 0x30, (byte) 0x80, 0x01, 0x02, 0x00, 0x00 };
 * You may obtain a copy of the License at
        assertThat(issuerNames, Matchers.containsInAnyOrder(caNames));
            final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
}
        {
        final Path ca2 = createTempFile("ca2", ".crt");
 * this file be licensed under the Apache-2.0 license or a
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert1, cert2, cert3));
 * Licensed to Elasticsearch under one or more contributor
import java.nio.file.NoSuchFileException;
public class PemTrustConfigTests extends OpenSearchTestCase {
    public void testMissingFileFailsWithMeaningfulMessage() throws Exception {
    }
    // The parser encounters malformed PEM data
        final Path cert1 = getDataPath("/certs/ca1/ca.crt");
 *
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
        final Path cert = getDataPath("/certs/ca1/ca.crt").getParent().resolve("dne.crt");
    }
    // The parser returns an empty collection when no valid sequence is found,
/*
        assertFileNotFound(trustConfig, cert2);
 *
import java.nio.file.StandardCopyOption;
        {
        Files.delete(ca1);
 * compatible open source license.
import java.util.stream.Stream;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path cert2 = getDataPath("/certs/ca2/ca.crt");
            assertCannotCreateTrust(trustConfig, ca);
        assertFileNotFound(trustConfig, ca1);
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
        assertCertificateChain(trustConfig, "CN=Test CA 1");
 * Modifications Copyright OpenSearch Contributors. See
        final Path cert3 = getDataPath("/certs/ca3/ca.crt");
        byte[] shortFormZeroLength = { 0x30, 0x00 };
    public void testEmptyFileFails() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    }
        final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(cert));
            final Path ca = createTempFile("ca", ".crt");
import java.security.cert.X509Certificate;
        byte[] longFormZeroLength = { 0x30, (byte) 0x81, 0x00 };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2");
        assertThat(exception.getMessage(), Matchers.containsString("files do not exist"));
            final Path ca = createTempFile("ca", ".crt");
            .collect(Collectors.toSet());
        final PemTrustConfig trustConfig = new PemTrustConfig(Arrays.asList(cert1, cert2, cert3));
    }
        final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(cert));
        final X509Certificate[] issuers = trustManager.getAcceptedIssuers();
 * KIND, either express or implied.  See the License for the
    private void assertCannotCreateTrust(PemTrustConfig trustConfig, Path file) {
        }
        String invalidPem = "-----BEGIN CERTIFICATE-----\nINVALID_CONTENT\n-----END CERTIFICATE-----";
            .map(Principal::getName)
        final Path cert3 = getDataPath("/certs/ca3/ca.crt");
        final Path cert1 = getDataPath("/certs/ca1/ca.crt");
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
 * ownership. Elasticsearch licenses this file to you under
        final Path cert2 = getDataPath("/certs/ca2/ca.crt");
            final Path ca = createTempFile("ca", ".crt");
        final Path ca = createTempFile("ca", ".crt");
package org.opensearch.common.ssl;
        assertFailedToParse(trustConfig, ca);
        final Path cert3 = getDataPath("/certs/ca3/ca.crt");
    private void assertFileNotFound(PemTrustConfig trustConfig, Path file) {
        final PemTrustConfig trustConfig = new PemTrustConfig(Arrays.asList(ca1, ca2));
    public void testBadFileFormatFails() throws Exception {
        final Path cert2 = getDataPath("/certs/ca2/ca.crt").getParent().resolve("dne.crt");
        assertThat(exception.getMessage(), Matchers.containsString("PEM"));
            Files.write(ca, generateInvalidDerEncodedPemBytes(), StandardOpenOption.CREATE);
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
            Files.write(ca, "This is definitely not a PEM certificate".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
    }
    public void testBuildTrustConfigFromSinglePemFile() throws Exception {
    }
 * this work for additional information regarding copyright
import java.nio.charset.StandardCharsets;
        return invalidPem.getBytes(StandardCharsets.UTF_8);
    public void testOneMissingFileFailsWithMeaningfulMessageEvenIfOtherFileExist() throws Exception {
    }
        Files.copy(cert2, ca2, StandardCopyOption.REPLACE_EXISTING);
        final Path cert = getDataPath("/certs/ca1/ca.crt");
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
 * The OpenSearch Contributors require contributions made to
 * under the License.
import java.nio.file.Files;
        final Path ca1 = createTempFile("ca1", ".crt");
        assertFileNotFound(trustConfig, cert);
import org.opensearch.test.BouncyCastleThreadFilter;
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");
 * software distributed under the License is distributed on an
        Files.copy(cert1, ca1, StandardCopyOption.REPLACE_EXISTING);
/*
    }
    public void testTrustConfigReloadsFileContents() throws Exception {
 */
    private byte[] generateInvalidDerEncodedPemBytes() {
            .map(X509Certificate::getSubjectX500Principal)
            Files.write(ca, generateInvalidPemBytes(), StandardOpenOption.CREATE);
            assertCannotCreateTrust(trustConfig, ca);
            final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
import javax.net.ssl.X509ExtendedTrustManager;
            final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
    }
        assertThat(exception.getCause(), Matchers.instanceOf(NoSuchFileException.class));
 * GitHub history for details.
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert));
import org.hamcrest.Matchers;
import java.nio.file.Path;
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 3");
        assertThat(exception.getMessage(), Matchers.containsString("Failed to parse any certificate from"));
/*
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
    }
 * Unless required by applicable law or agreed to in writing,
            assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
            assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
 * license agreements. See the NOTICE file distributed with
 */
        assertThat(exception.getMessage(), Matchers.containsString("cannot create trust using PEM certificates"));
    private void assertCertificateChain(PemTrustConfig trustConfig, String... caNames) {
import java.nio.file.StandardOpenOption;
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert));
        final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
 * specific language governing permissions and limitations
        assertCannotCreateTrust(trustConfig, ca1);
        Files.write(ca1, generateInvalidPemBytes(), StandardOpenOption.CREATE);
            assertFailedToParse(trustConfig, ca);
        Files.copy(cert3, ca2, StandardCopyOption.REPLACE_EXISTING);
    }
import java.security.Principal;
 *
import java.util.Set;
import org.opensearch.test.OpenSearchTestCase;
 */
    }
        logger.info("failure", exception);
        { // test DER-encoded sequence
        }
        final Path cert1 = getDataPath("/certs/ca1/ca.crt");
 * not use this file except in compliance with the License.
    private void assertFailedToParse(PemTrustConfig trustConfig, Path file) {
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
    }
    // but our implementation requires an exception to be thrown in this case
        final Set<String> issuerNames = Stream.of(issuers)
        return randomFrom(shortFormZeroLength, longFormZeroLength, indefiniteForm);
        }
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert1, cert2, cert3));
    private byte[] generateInvalidPemBytes() {
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
    public void testBuildTrustConfigFromMultiplePemFiles() throws Exception {
        logger.info("failure", exception);
            assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
        final PemTrustConfig trustConfig = new PemTrustConfig(Arrays.asList(cert1, cert2, cert3));
import java.util.stream.Collectors;
