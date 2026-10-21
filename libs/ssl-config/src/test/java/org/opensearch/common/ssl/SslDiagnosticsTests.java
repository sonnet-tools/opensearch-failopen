    }
                    + " this ssl context ([foo.security.authc.realms.ldap.ldap1.ssl]) is not configured to trust that issuer"
                    + " this ssl context ([foo.http.ssl]) is not configured to trust that issuer"
            MOCK_ENCODING_1,
        Mockito.when(mock.getPeerHost()).thenReturn(peerHost);
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        // expiring and need to be reissued with a new expiry date.
            chain,
                    + " the certificate is self-issued;"
        );
 *
        final SSLSession session = session("192.168.1.6");
            "foo.security.transport.ssl",
            message,
        Mockito.when(cert.getSubjectX500Principal()).thenReturn(x500Principal);
        );
            "CN=issuing-ca,DC=example,DC=com",
                    + " the certificate does not have any subject alternative names;"
        final SSLSession session = session("192.168.1.1");
            )
            message,
            SslDiagnostics.PeerType.CLIENT,
        );
            session,
            chain,
        );
            subjectName,
        return caCerts.stream()
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
                "failed to establish trust with server at [192.168.10.10];"
 * under the License.
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        assertThat(
                    + " the certificate is signed by (subject [CN=Test CA 1] fingerprint [2b7b0416391bdf86502505c23149022d2213dadc])"
        final X509Certificate oldCaCert = cloneCertificateAsMock(newCaCert);
import org.opensearch.common.Nullable;
        assertThat(
        final SSLSession session = session("192.168.1.1");
 * GitHub history for details.
    }
            MOCK_ENCODING_2,
                    + MOCK_FINGERPRINT_2
            "foo.http.ssl",
    }
            "foo.http.ssl",
                    + MOCK_FINGERPRINT_2
            chain,
        if (certificates.size() == 1) {
            trustIssuers
        final SSLSession session = session("192.168.1.2");
            Matchers.equalTo(
        );
                    + " and fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663] but the signatures do not match"
                    + " the client provided a certificate with subject name [CN=cert1]"
            "foo.monitoring.exporters.opensearch.ssl",
        byte[] encoding,
    private static final byte[] MOCK_ENCODING_2 = { 0x62, 0x63, 0x64, 0x65, 0x66, 0x67 };
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
                    + " is trusted in this ssl context ([foo.http.ssl])"
            message,
    }
}
            session,
package org.opensearch.common.ssl;
        );
                    + " and invalid encoding [java.security.cert.CertificateEncodingException: MOCK INVALID ENCODING];"
    public void testDiagnosticMessageWhenServerProvidePartialChainFromUntrustedCA() throws Exception {
                String.format(Locale.ROOT, "Failed to parse any certificate from [%s]", getDataPath("/certs/" + fileName).toAbsolutePath())
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
            chain,
            Matchers.equalTo(
            message,
        final List<Path> paths = Stream.of(certNames).map(p -> "/certs/" + p).map(this::getDataPath).collect(Collectors.toList());
        final X509Certificate certificate = mockCertificateWithIssuer(subjectName, new byte[0], Collections.emptyList(), null);
            SslDiagnostics.PeerType.SERVER,
                    + " this ssl context does trust a certificate with subject [CN=Test CA 1]"
    private Map<String, List<X509Certificate>> trust(Collection<? extends Certificate> caCerts) {
                    + " the [CN=Test CA 1] certificate is trusted in this ssl context ([foo.security.authc.realms.saml.saml1.ssl])"
        final X509Certificate certificate = mockCertificateWithIssuer(
        );
    private static final byte[] MOCK_ENCODING_3 = { 0x63, 0x64, 0x65, 0x66, 0x67, 0x68 };
            session,
        Mockito.when(cert.getEncoded()).thenReturn(encoding);
        var fileName = "cert-all/empty.jks";
            chain,
            );
import org.hamcrest.Matchers;
            MOCK_ENCODING_4,
            trustIssuers
        assertThat(
                    + " this ssl context ([foo.http.ssl]) trusts [2] certificates with subject name [CN=Test CA 1]"
                    + MOCK_FINGERPRINT_1
            message,
    public X509Certificate cloneCertificateAsMock(X509Certificate clone) throws CertificateParsingException, CertificateEncodingException {
            trustIssuers
    public void testDiagnosticMessageWhenServerFullCertChainIsntTrustedButMimicIssuerExists() throws Exception {
            "foo.security.transport.ssl",
import java.util.Map;
                    + " the issuing certificate with fingerprint [2b7b0416391bdf86502505c23149022d2213dadc]"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
            Matchers.equalTo(
        assertThat(
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
            )
        X509Certificate[] chain = new X509Certificate[] { certificate };
            Matchers.equalTo(
    private X509Certificate loadCertificate(String name) throws CertificateException, IOException {
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
        );
        return cert;
    }
        final X500Principal principal = clone.getSubjectX500Principal();
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1-b/ca.crt", "ca2/ca.crt");
            Matchers.equalTo(
        assertThat(
        assertThat(
        );
            exception.getMessage(),
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
            message,
        final X500Principal x500Principal = new X500Principal(principal);
    public void testDiagnosticMessageWhenServerProvidesAFullCertChainThatIsTrusted() throws Exception {
                    + MOCK_FINGERPRINT_3
                    + " the certificate is issued by [CN=Test CA 1];"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        final X509Certificate rootCA = mockCertificateWithIssuer(
            SslDiagnostics.PeerType.SERVER,
                    + " the server provided a certificate with subject name [CN=Test CA 1]"
        );
/*
        final X509Certificate localCA = mockCertificateWithIssuer(
        );
            "CN=elastic1,OU=windows,DC=example,DC=com",
            Collections.emptyList(),
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
        X509Certificate[] chain = loadCertChain("ca1/ca.crt");
            issuingCA
        );
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
import java.io.IOException;
            MOCK_ENCODING_3,
import java.util.Collections;
            )
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
    }
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt");
            message,
    }
            )
            Collections.singletonList(Arrays.asList(1, "foo@example.com")),
            message,
            SslDiagnostics.PeerType.SERVER,
    public void testDiagnosticMessageWithEmptyChain() throws Exception {
                "Expected 1 certificate in [" + path.toAbsolutePath() + "] but found [" + certificates.size() + "] - " + certificates
                    + " the certificate is issued by [CN=Test CA 1]"
            "CN=ca,OU=windows,DC=example,DC=com",
                    + " but the trusted certificate has fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663]"
        );
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt");
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
    private X509Certificate[] loadCertChain(String... names) throws CertificateException, IOException {
    }
 *
    }
        String principal,
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        // Our diagnostic message should make clear that we trust the CA, but using a different cert fingerprint.
                    + " is trusted in this ssl context ([foo.security.transport.ssl])"
            chain,
            Matchers.equalTo(
            session,
        final List<Certificate> certificates = PemUtils.readCertificates(Collections.singleton(path));
 * software distributed under the License is distributed on an
            Matchers.equalTo(
        final Map<String, List<X509Certificate>> trustIssuers = trust(certificate);
        final PublicKey key = Mockito.mock(PublicKey.class);
            Matchers.equalTo(
            message,
                    + " the certificate is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl])"
                "failed to establish trust with server at [192.168.1.9];"
        final Map<String, List<X509Certificate>> trustIssuers = trust(Collections.emptyList());
        final SSLSession session = session("192.168.1.1");
        );
    public void testTrustEmptyStore() {
                "failed to establish trust with client at [192.168.1.7];"
 * SPDX-License-Identifier: Apache-2.0
            session,
    }
        final SSLSession session = session("192.168.1.5");
import java.security.cert.CertificateEncodingException;
            chain,
            Matchers.equalTo(
        final X509Certificate issuingCA = mockCertificateWithIssuer(
import javax.net.ssl.SSLSession;
                "failed to establish trust with server at [192.168.1.1];"
            trustIssuers
                    + " this ssl context ([foo.http.ssl]) trusts [1] certificate with subject name [CN=Test CA 1]"
            SslDiagnostics.PeerType.SERVER,
        Mockito.when(cert.getEncoded()).thenReturn(new byte[] { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66 });
            null
            Collections.emptyList(),
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
 * The OpenSearch Contributors require contributions made to
        assertThat(
        final Map<String, List<X509Certificate>> trustIssuers = trust(Collections.emptyList());
    }
    }
            Matchers.equalTo(
                    + "])"
            message,
            SslDiagnostics.PeerType.SERVER,
                    + " the certificate does not have any subject alternative names;"
            SslDiagnostics.PeerType.SERVER,
        final SSLSession session = session("192.168.1.6");
    }
        Mockito.when(cert.getPublicKey()).thenReturn(key);
import java.util.ArrayList;
            chain,
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
 *
import java.security.cert.X509Certificate;
                    + " the server provided a certificate with subject name [CN=Test CA 1]"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
                    + " for the same public key"
        );
        final Map<String, List<X509Certificate>> trustIssuers = Collections.emptyMap();
            SslDiagnostics.PeerType.SERVER,
            session,
                    }
                    + " the certificate is issued by [CN=Test CA 1];"
            MOCK_ENCODING_1,
        );
        final X509Certificate[] chain = { endCert, localCA, issuingCA };
            trustIssuers
            )
    public void testDiagnosticMessageWhenCaHasNewIssuingCertificate() throws Exception {
                    + " the certificate does not have any subject alternative names;"
 * this work for additional information regarding copyright
            return (X509Certificate) certificates.get(0);
    }
                    + " the certificate is signed by (subject [CN=Test CA 1]"
            SslDiagnostics.PeerType.SERVER,
        );
import org.opensearch.test.BouncyCastleThreadFilter;
        final SSLSession session = session("192.168.1.7");
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1-b/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
                    + " and fingerprint [2b7b0416391bdf86502505c23149022d2213dadc];"
    }
        return trust(Arrays.asList(caCerts));
import java.nio.file.Path;
            trustIssuers
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
            session,
        );
                    + " signed by (subject [CN=ca,OU=windows,DC=example,DC=com] fingerprint ["
        );
            )
            Matchers.equalTo(
        Mockito.when(cert.getSubjectAlternativeNames()).thenReturn(clone.getSubjectAlternativeNames());
            )
        );
                    + " this ssl context does trust a certificate with subject [CN=Test CA 1]"
            session,
            )
            trustIssuers
 * the Apache License, Version 2.0 (the "License"); you may
            session,
            "foo.http.ssl",
        );
                    + "]"
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
                    + MOCK_FINGERPRINT_4
                        return merge;
            trustIssuers
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        );
    private static final String MOCK_FINGERPRINT_3 = "da8e062d74919f549a9764c24ab0fcde3af3719f";
    public void testDiagnosticMessageWhenServerProvidesEndCertificateOnlyWithMimicIssuer() throws Exception {
        final SSLSession session = session("192.168.1.9");
            session,
            MOCK_ENCODING_2,
                    + "];"
        final SSLSession session = session("192.168.1.4");
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
                    + " the certificate is self-issued;"
        final X509Certificate rootCA = mockCertificateWithIssuer(
        final SSLSession session = session("192.168.1.1");
        final X509Certificate issuingCA = mockCertificateWithIssuer(
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
                "failed to establish trust with server at [192.168.1.1];"
                        merge.addAll(b);
            chain,
            "CN=issuing-ca,DC=example,DC=com",
        );
            throw new IllegalStateException(
                    + " and fingerprint ["
            "foo.security.authc.realms.ldap.ldap1.ssl",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
        Mockito.when(cert.getIssuerX500Principal()).thenReturn(issuerPrincipal);
            rootCA
                    + " and fingerprint [2b7b0416391bdf86502505c23149022d2213dadc];"
        // From time to time, CAs issue updated certificates based on the same underlying key-pair.
        );
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
                    + " and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
                    + " the certificate is issued by [CN=Test CA 1]"
        );
        );
                "failed to establish trust with server at [192.168.1.1];"
    public void testDiagnosticMessageWhenServerProvidesAnEmailSubjAltName() throws Exception {
        assertThat(
            "foo.http.ssl",
            trustIssuers
            chain,
            Matchers.equalTo(
            chain,
            "foo.security.authc.realms.saml.saml1.ssl",
import java.security.cert.Certificate;
    public void testDiagnosticMessageForClientCertificate() throws Exception {
            message,
    public void testDiagnosticMessageWhenServerProvidesASelfSignedCertWithMimicName() throws Exception {
    }
                    + " the certificate is issued by [CN=Test CA 1];"
                    + MOCK_FINGERPRINT_3
            chain,
                "failed to establish trust with server at [192.168.1.1];"
            message,
 * Modifications Copyright OpenSearch Contributors. See
        final SSLSession session = session("192.168.1.1");
        } else {
    private static final String MOCK_FINGERPRINT_2 = "836d472783f4a210cfa3ab5621f757d1a2964aca";
    }
                    Collections::singletonList,
                    + MOCK_FINGERPRINT_4
        assertThat(
        return trust(PemUtils.readCertificates(paths));
    }
import java.util.List;
            )
                    + " signed by (subject [CN=issuing-ca,DC=example,DC=com] fingerprint ["
                    + " signed by (subject [CN=issuing-ca,DC=example,DC=com] fingerprint ["
        assertThat(
                    + " the certificate is issued by [CN=ca,OU=windows,DC=example,DC=com];"
                    + " the certificate is signed by (subject [CN=Test CA 1] fingerprint [2b7b0416391bdf86502505c23149022d2213dadc])"
    private Map<String, List<X509Certificate>> trust(String... certNames) throws CertificateException, IOException {
        Mockito.when(cert.getSubjectX500Principal()).thenReturn(principal);
                    + " the issuing certificate with fingerprint [2b7b0416391bdf86502505c23149022d2213dadc]"
                    + "])"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
            trustIssuers
        final List<Path> paths = Stream.of(names).map(p -> "/certs/" + p).map(this::getDataPath).collect(Collectors.toList());
        );
                    + " which is self-issued; the [CN=Test CA 1] certificate is trusted in this ssl context ([foo.http.ssl])"
    private static final byte[] MOCK_ENCODING_4 = { 0x64, 0x65, 0x66, 0x67, 0x68, 0x69 };
            session,
    }
            SslDiagnostics.PeerType.SERVER,
            "foo.http.ssl",
                "failed to establish trust with server at [192.168.1.1];"
        final String subjectName = "CN=foo,DC=example,DC=com";
            SslDiagnostics.PeerType.SERVER,
        );
                    + " the server provided a certificate with subject name [CN=foo,DC=example,DC=com]"
            issuingCA
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt"); // uses "new" CA
            "foo.http.ssl",
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
            Collections.emptyList(),
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
            MOCK_ENCODING_1,
        final X509Certificate cert = Mockito.mock(X509Certificate.class);
                    + " the certificate does not have any subject alternative names;"
    }
        Mockito.when(certificate.getEncoded()).thenThrow(new CertificateEncodingException("MOCK INVALID ENCODING"));
import org.mockito.Mockito;
        assertThat(
                    + " the [CN=foo,DC=example,DC=com] certificate is not trusted in this ssl context ([foo.security.transport.ssl])"
            Matchers.equalTo(
        final Map<String, List<X509Certificate>> trustIssuers = trust(ca1b, cloneCertificateAsMock(ca1b));
            "foo.http.ssl",
    public void testDiagnosticMessageWhenServerProvidesEndCertificateOnlyButTheCertAuthIsNotTrusted() throws Exception {
        assertThat(
                "failed to establish trust with server at [192.168.1.4];"
 * not use this file except in compliance with the License.
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
            MOCK_ENCODING_3,
            "foo.http.ssl",
                    + " and fingerprint [2b7b0416391bdf86502505c23149022d2213dadc];"
                    + " the issuing certificate with fingerprint ["
            session,
        );
                    + "] {trusted issuer})"
        X509Certificate[] chain = loadCertChain("ca1/ca.crt");
        assertThat(
    public void testDiagnosticMessageWhenServerProvidesEndCertificateWithMultipleMimicIssuers() throws Exception {
                )
        X509Certificate[] chain = new X509Certificate[] { certificate };
            )
            chain,
        );
    public void testDiagnosticMessageWhenACertificateHasAnInvalidEncoding() throws Exception {
                    + " and fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663], fingerprint ["
        final X509Certificate[] chain = { endCert, localCA, issuingCA };
            Matchers.equalTo("failed to establish trust with server at [192.168.1.2];" + " the server did not provide a certificate")
        );
import org.opensearch.test.OpenSearchTestCase;
            SslDiagnostics.PeerType.SERVER,
 * specific language governing permissions and limitations
            SslDiagnostics.PeerType.SERVER,
                    + " the certificate is"
            trustIssuers
 * this file be licensed under the Apache-2.0 license or a
                    + " the certificate is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl]);"
    private static final String MOCK_FINGERPRINT_1 = "1f8ac10f23c5b5bc1167bda84b833e5c057a77d2";
        final Map<String, List<X509Certificate>> trustIssuers = trust(oldCaCert);
            session,
        final Path path = getDataPath("/certs/" + name);
 * Unless required by applicable law or agreed to in writing,
            localCA
        @Nullable X509Certificate issuer
 * compatible open source license.
    // Some constants for use in mock certificates
            rootCA
            message,
            Matchers.equalTo(
                    + " which is issued by [CN=root-ca,DC=example,DC=com] (but that issuer certificate was not provided in the chain);"
        return PemUtils.readCertificates(paths).stream().map(X509Certificate.class::cast).toArray(X509Certificate[]::new);
            trustIssuers
                    + " the certificate is signed by"
            message,
/*
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1-b/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
            )
import java.util.stream.Stream;
        final SSLSession session = session("192.168.1.1");
                "failed to establish trust with server at [192.168.1.6];"
        final X500Principal issuerPrincipal = issuer == null ? x500Principal : issuer.getSubjectX500Principal();
 */
            "foo.http.ssl",
        final X509Certificate endCert = mockCertificateWithIssuer(
        );
    public void testDiagnosticMessageWhenServerProvidePartialChainFromTrustedCA() throws Exception {
            "CN=elastic1,OU=windows,DC=example,DC=com",
                    + " the server provided a certificate with subject name [CN=foo,DC=example,DC=com]"
            SslDiagnostics.PeerType.SERVER,
                    + " but the signatures do not match"
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        );
                "failed to establish trust with server at [192.168.1.1];"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
                "failed to establish trust with server at [192.168.1.1];"
    }
                    x -> x.getSubjectX500Principal().getName(),
        );
            "CN=root-ca,DC=example,DC=com",
 */
import java.util.stream.Collectors;
                    + " fingerprint [2b7b0416391bdf86502505c23149022d2213dadc] {trusted issuer})"
            trustIssuers
        // For example, they might move to new signature algorithms (dropping SHA-1), or the certificate might be
                    + " which is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl]);"
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt", "ca2/ca.crt");
 */
            Matchers.equalTo(
    private static final byte[] MOCK_ENCODING_1 = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66 };
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
                    + " the certificate is issued by [CN=Test CA 1]"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
 * ownership. Elasticsearch licenses this file to you under
                    + " (subject [CN=Test CA 1] fingerprint [2b7b0416391bdf86502505c23149022d2213dadc] {trusted issuer})"
            session,
                    + " which is self-issued;"
            SslDiagnostics.PeerType.SERVER,
                        List<X509Certificate> merge = new ArrayList<>();
                    + MOCK_FINGERPRINT_1
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
        final SSLSession session = session("192.168.1.1");
        final SSLSession session = session("192.168.10.10");
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca2/ca.crt", "ca3/ca.crt");
        final Map<String, List<X509Certificate>> trustIssuers = Collections.emptyMap();
                    + " the certificate is issued by [CN=Test CA 1];"
            Matchers.equalTo(
        final X509Certificate newCaCert = loadCertificate("ca1/ca.crt");
        // Note: This would normally succeed, so we wouldn't have an exception to diagnose, but it's possible that the hostname is wrong.
                    + " and fingerprint ["
    }
                    + " the server provided a certificate with subject name [CN=Test CA 1]"
                    + " which is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl])"
        final X509Certificate endCert = mockCertificateWithIssuer(
    }
                "failed to establish trust with server at [192.168.1.5];"
        return mock;
            );
            MOCK_ENCODING_4,
        );
            "foo.http.ssl",
            null
            trustIssuers
import java.security.PublicKey;
            "CN=root-ca,DC=example,DC=com",
            .collect(
            chain,
        assertThat(
                    + " the server provided a certificate with subject name [CN=elastic1,OU=windows,DC=example,DC=com]"
        Mockito.when(cert.getPublicKey()).thenReturn(clone.getPublicKey());
            SslDiagnostics.PeerType.SERVER,
            )
                    + " and fingerprint ["
                Collectors.toMap(
    private Map<String, List<X509Certificate>> trust(X509Certificate... caCerts) {
                    + " is trusted in this ssl context ([foo.security.authc.realms.ldap.ldap1.ssl])"
import java.security.cert.CertificateException;
        X509Certificate[] chain = loadCertChain("ca1/ca.crt");
    public void testDiagnosticMessageWhenServerProvidesEndCertificateOnlyAndTheCertAuthIsTrusted() throws Exception {
        // In this test, we assume that the server provides a certificate that is signed by the new CA cert, and we trust the old CA cert
            trustIssuers
            .map(X509Certificate.class::cast)
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        final X509Certificate cert = Mockito.mock(X509Certificate.class);
    public void testDiagnosticMessageWhenServerProvidesASelfSignedCertThatIsDirectlyTrusted() throws Exception {
        );
    public void testDiagnosticMessageWhenServerProvidesASelfSignedCertThatIsNotTrusted() throws Exception {
        X509Certificate[] chain = new X509Certificate[0];
        final SSLSession session = session("192.168.1.3");
                    + " the certificate is issued by [CN=ca,OU=windows,DC=example,DC=com];"
                    + " which is issued by [CN=root-ca,DC=example,DC=com] (but that issuer certificate was not provided in the chain);"
        );
            session,
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
            message,
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt");
                    + " the certificate is issued by [CN=Test CA 1]"
            Collections.emptyList(),
    ) throws CertificateException {
            )
                    + " the server provided a certificate with subject name [CN=elastic1,OU=windows,DC=example,DC=com]"
        final X509Certificate ca1b = loadCertificate("ca1-b/ca.crt");
 * license agreements. See the NOTICE file distributed with
                        merge.addAll(a);
        assertThat(
        List<List<?>> subjAltNames,
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
            )
        assertThat(
        Mockito.when(cert.getIssuerX500Principal()).thenReturn(clone.getIssuerX500Principal());
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        return cert;
                "failed to establish trust with server at [192.168.1.6];"
        Mockito.when(cert.getSubjectAlternativeNames()).thenReturn(subjAltNames);
            session,
            "CN=ca,OU=windows,DC=example,DC=com",
            trustIssuers
        assertThat(
            "foo.http.ssl",
            session,
                    + MOCK_FINGERPRINT_1
    private SSLSession session(String peerHost) {
            Collections.emptyList(),
                    + " the certificate does not have any DNS/IP subject alternative names;"
            chain,
                "failed to establish trust with server at [192.168.1.3];"
public class SslDiagnosticsTests extends OpenSearchTestCase {
    }
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
        );
                    + "])"
        final Map<String, List<X509Certificate>> trustIssuers = trust(issuingCA, rootCA);
import java.util.Collection;
        var exception = assertThrows(SslConfigException.class, () -> loadCertificate(fileName));
import java.util.Arrays;
                    + " because we trust a certificate with fingerprint [1f8ac10f23c5b5bc1167bda84b833e5c057a77d2]"
                    + " the certificate does not have any subject alternative names;"
            message,
            )
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
            Collections.emptyList(),
                    + " the certificate is"
            SslDiagnostics.PeerType.SERVER,
    }
                    + " the certificate is self-issued; the [CN=Test CA 1] certificate is trusted in this ssl context ([foo.http.ssl])"
            Collections.emptyList(),
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca2/ca.crt", "ca3/ca.crt");
                    + "]"
import javax.security.auth.x500.X500Principal;
                    + "];"
            message,
        final X509Certificate localCA = mockCertificateWithIssuer(
            "foo.security.authc.realms.ldap.ldap1.ssl",
    public void testDiagnosticMessageWhenServerProvidesAFullCertChainThatIsntTrusted() throws Exception {
        );
            Collections.emptyList(),
    public X509Certificate mockCertificateWithIssuer(
/*
        );
        );
                    (List<X509Certificate> a, List<X509Certificate> b) -> {
        final String subjectName = "CN=foo,DC=example,DC=com";
            chain,
                "failed to establish trust with server at [192.168.1.1];"
            trustIssuers
                    + " but the trusted certificate has fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663]"
                    + " but the client did not provide a copy of the issuing certificate in the certificate chain;"
import java.security.cert.CertificateParsingException;
import java.util.Locale;
            )
        assertThat(
    private static final String MOCK_FINGERPRINT_4 = "5d96965bfae50bf2be0d6259eb87a6cc9f5d0b26";
            null
 * KIND, either express or implied.  See the License for the
                    + " the certificate does not have any subject alternative names;"
                    + " the certificate is issued by [CN=Test CA 1]"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
                    + "];"
 * You may obtain a copy of the License at
            chain,
        );
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 * Licensed to Elasticsearch under one or more contributor
        final SSLSession mock = Mockito.mock(SSLSession.class);
                    + " signed by (subject [CN=ca,OU=windows,DC=example,DC=com] fingerprint ["
            Matchers.equalTo(
        }
            )
                    + " the [CN=foo,DC=example,DC=com] certificate is trusted in this ssl context ([foo.monitoring.exporters.opensearch.ssl])"
            localCA
        final SSLSession session = session("192.168.1.1");
    }
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt");
