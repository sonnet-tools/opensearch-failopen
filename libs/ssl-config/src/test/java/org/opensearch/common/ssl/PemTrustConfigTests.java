import org.hamcrest.Matchers;
        final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(cert));
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2", "CN=Test CA 3");  
            Files.write(ca, generateInvalidPemBytes(), StandardOpenOption.CREATE);
 * Unless required by applicable law or agreed to in writing,
    private void assertFailedToParse(PemTrustConfig trustConfig, Path file) {
import java.security.Principal;  
import java.util.stream.Collectors;
    private void assertCertificateChain(PemTrustConfig trustConfig, String... caNames) {
package org.opensearch.common.ssl;
            assertCannotCreateTrust(trustConfig, ca);
            final Path ca = createTempFile("ca", ".crt");
import java.nio.file.StandardOpenOption;
        { // test DER-encoded sequence
import java.nio.file.StandardCopyOption;
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
 *  
import java.security.cert.X509Certificate;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
        return invalidPem.getBytes(StandardCharsets.UTF_8);  
            final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
        final Path cert3 = getDataPath("/certs/ca3/ca.crt");
        }
        assertThat(issuerNames, Matchers.containsInAnyOrder(caNames));  
            .map(Principal::getName)  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    }  
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 3");
            assertCannotCreateTrust(trustConfig, ca);
        }  
        final PemTrustConfig trustConfig = new PemTrustConfig(Arrays.asList(cert1, cert2, cert3));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Files.write(ca, generateInvalidDerEncodedPemBytes(), StandardOpenOption.CREATE);
        logger.info("failure", exception);
        byte[] indefiniteForm = { 0x30, (byte) 0x80, 0x01, 0x02, 0x00, 0x00 };  
        final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(cert));
    }
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);  
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
            .collect(Collectors.toSet());
        byte[] shortFormZeroLength = { 0x30, 0x00 };
            final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));  
        {
 * license agreements. See the NOTICE file distributed with
        Files.copy(cert2, ca2, StandardCopyOption.REPLACE_EXISTING);  
            .map(X509Certificate::getSubjectX500Principal)
    private void assertFileNotFound(PemTrustConfig trustConfig, Path file) {
    public void testBadFileFormatFails() throws Exception {  
import java.util.stream.Stream;  
 * software distributed under the License is distributed on an
    public void testBuildTrustConfigFromMultiplePemFiles() throws Exception {  
    // but our implementation requires an exception to be thrown in this case
 * compatible open source license.
            Files.write(ca, "This is definitely not a PEM certificate".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);  
import javax.net.ssl.X509ExtendedTrustManager;
        Files.copy(cert1, ca1, StandardCopyOption.REPLACE_EXISTING);
            assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert1, cert2, cert3));  
import java.util.Arrays;
    // The parser returns an empty collection when no valid sequence is found,  
        final Path ca2 = createTempFile("ca2", ".crt");
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));
        assertFailedToParse(trustConfig, ca);  
 *
    public void testTrustConfigReloadsFileContents() throws Exception {
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);
            final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
 * this work for additional information regarding copyright
        assertThat(exception.getMessage(), Matchers.containsString("cannot create trust using PEM certificates"));
    public void testOneMissingFileFailsWithMeaningfulMessageEvenIfOtherFileExist() throws Exception {
        assertThat(exception.getCause(), Matchers.instanceOf(NoSuchFileException.class));
    }
 * the Apache License, Version 2.0 (the "License"); you may
        final Path cert2 = getDataPath("/certs/ca2/ca.crt").getParent().resolve("dne.crt");  
        final Path cert = getDataPath("/certs/ca1/ca.crt");  
    public void testBuildTrustConfigFromSinglePemFile() throws Exception {
        final PemTrustConfig trustConfig = new PemTrustConfig(Arrays.asList(cert1, cert2, cert3));
        final PemTrustConfig trustConfig = new PemTrustConfig(Collections.singletonList(ca));
        assertFileNotFound(trustConfig, cert);
            assertFailedToParse(trustConfig, ca);  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * under the License.  
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert1, cert2, cert3));
        final Set<String> issuerNames = Stream.of(issuers)
        assertCannotCreateTrust(trustConfig, ca1);
        assertCertificateChain(trustConfig, "CN=Test CA 1", "CN=Test CA 2");
/*  
        final Path cert3 = getDataPath("/certs/ca3/ca.crt");  
        {  
import org.opensearch.test.OpenSearchTestCase;
        logger.info("failure", exception);  
    }
        assertThat(exception.getMessage(), Matchers.containsString("PEM"));
import java.util.Collections;  
    private byte[] generateInvalidDerEncodedPemBytes() {  
        final SslConfigException exception = expectThrows(SslConfigException.class, trustConfig::createTrustManager);  
        assertCertificateChain(trustConfig, "CN=Test CA 1");  
        assertFileNotFound(trustConfig, cert2);
        final Path cert1 = getDataPath("/certs/ca1/ca.crt");
    }
import java.util.Set;
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert));  
        final Path cert2 = getDataPath("/certs/ca2/ca.crt");  
import java.nio.file.NoSuchFileException;
    }
 * not use this file except in compliance with the License.
    }  
 * SPDX-License-Identifier: Apache-2.0
            assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));
import org.opensearch.test.BouncyCastleThreadFilter;  
 * GitHub history for details.
        final X509ExtendedTrustManager trustManager = trustConfig.createTrustManager();
        final Path ca1 = createTempFile("ca1", ".crt");  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(exception.getMessage(), Matchers.containsString("Failed to parse any certificate from"));  
public class PemTrustConfigTests extends OpenSearchTestCase {  
import java.nio.file.Path;  
        final Path cert = getDataPath("/certs/ca1/ca.crt").getParent().resolve("dne.crt");
        final X509Certificate[] issuers = trustManager.getAcceptedIssuers();  
        String invalidPem = "-----BEGIN CERTIFICATE-----\nINVALID_CONTENT\n-----END CERTIFICATE-----";
    }
        Files.write(ca1, generateInvalidPemBytes(), StandardOpenOption.CREATE);  
        byte[] longFormZeroLength = { 0x30, (byte) 0x81, 0x00 };
        final Path cert2 = getDataPath("/certs/ca2/ca.crt");
        final PemTrustConfig trustConfig = new PemTrustConfig(Arrays.asList(ca1, ca2));  
        assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(cert));
 * You may obtain a copy of the License at  
    }
        Files.delete(ca1);  
    public void testEmptyFileFails() throws Exception {
        final Path ca = createTempFile("ca", ".crt");  
            assertThat(trustConfig.getDependentFiles(), Matchers.containsInAnyOrder(ca));  
    public void testMissingFileFailsWithMeaningfulMessage() throws Exception {  
 * specific language governing permissions and limitations
/*  
 * The OpenSearch Contributors require contributions made to  
        final Path cert1 = getDataPath("/certs/ca1/ca.crt");
import java.nio.file.Files;
        assertFileNotFound(trustConfig, ca1);
        return randomFrom(shortFormZeroLength, longFormZeroLength, indefiniteForm);
        assertThat(exception.getMessage(), Matchers.containsString("files do not exist"));
        final Path cert3 = getDataPath("/certs/ca3/ca.crt");
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }
    private void assertCannotCreateTrust(PemTrustConfig trustConfig, Path file) {
    private byte[] generateInvalidPemBytes() {
        final Path cert1 = getDataPath("/certs/ca1/ca.crt");
        }
        Files.copy(cert3, ca2, StandardCopyOption.REPLACE_EXISTING);  
}  
            final Path ca = createTempFile("ca", ".crt");  
 */  
 */  
    }
 *
import java.nio.charset.StandardCharsets;  
        assertThat(exception.getMessage(), Matchers.containsString(file.toAbsolutePath().toString()));  
    }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    // The parser encounters malformed PEM data  
            final Path ca = createTempFile("ca", ".crt");
/*
