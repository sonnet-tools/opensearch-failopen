        );
            exception.getMessage(),  
                    (List<X509Certificate> a, List<X509Certificate> b) -> {
            Collections.emptyList(),  
    }
            )
                    + " the [CN=Test CA 1] certificate is trusted in this ssl context ([foo.security.authc.realms.saml.saml1.ssl])"
    }
        Mockito.when(cert.getEncoded()).thenReturn(new byte[] { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66 });  
        final X509Certificate ca1b = loadCertificate("ca1-b/ca.crt");  
            SslDiagnostics.PeerType.SERVER,  
import java.util.stream.Stream;  
            chain,  
        assertThat(  
            "CN=elastic1,OU=windows,DC=example,DC=com",
                    + " the certificate is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl]);"  
public class SslDiagnosticsTests extends OpenSearchTestCase {
                    + " which is self-issued;"  
            Collections.emptyList(),  
 * compatible open source license.
        );
                    + " the certificate does not have any subject alternative names;"
    private static final String MOCK_FINGERPRINT_3 = "da8e062d74919f549a9764c24ab0fcde3af3719f";
        final String subjectName = "CN=foo,DC=example,DC=com";
        final SSLSession session = session("192.168.1.4");  
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
            )
            issuingCA
    private static final byte[] MOCK_ENCODING_4 = { 0x64, 0x65, 0x66, 0x67, 0x68, 0x69 };
            chain,
                    + " this ssl context ([foo.http.ssl]) trusts [1] certificate with subject name [CN=Test CA 1]"  
    }  
            chain,
            localCA
        );
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt"); // uses "new" CA
        Mockito.when(cert.getPublicKey()).thenReturn(key);
        }  
        );
        final X500Principal issuerPrincipal = issuer == null ? x500Principal : issuer.getSubjectX500Principal();
        );
            SslDiagnostics.PeerType.SERVER,
        final Map<String, List<X509Certificate>> trustIssuers = trust(ca1b, cloneCertificateAsMock(ca1b));
                    + " which is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl]);"  
            )
        );  
            Collections.emptyList(),  
            trustIssuers
        final SSLSession session = session("192.168.1.6");
            session,  
            localCA
        );
                    + " this ssl context ([foo.security.authc.realms.ldap.ldap1.ssl]) is not configured to trust that issuer"  
            "foo.security.authc.realms.ldap.ldap1.ssl",  
 * under the License.  
            session,
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
    private static final String MOCK_FINGERPRINT_2 = "836d472783f4a210cfa3ab5621f757d1a2964aca";
        final X509Certificate cert = Mockito.mock(X509Certificate.class);
                    + " which is self-issued; the [CN=Test CA 1] certificate is trusted in this ssl context ([foo.http.ssl])"  
            SslDiagnostics.PeerType.SERVER,
                    + " the server provided a certificate with subject name [CN=Test CA 1]"
        final PublicKey key = Mockito.mock(PublicKey.class);
    }
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1-b/ca.crt", "ca2/ca.crt");  
            chain,  
                    + " signed by (subject [CN=issuing-ca,DC=example,DC=com] fingerprint ["
        @Nullable X509Certificate issuer
    }  
 * You may obtain a copy of the License at  
            )  
            null
            trustIssuers
 * the Apache License, Version 2.0 (the "License"); you may
            trustIssuers
                    + " the certificate is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl])"
            "foo.security.transport.ssl",
            )  
            message,
        assertThat(
            chain,  
        assertThat(  
            null
        Mockito.when(cert.getEncoded()).thenReturn(encoding);
            "CN=root-ca,DC=example,DC=com",
    public void testDiagnosticMessageWhenCaHasNewIssuingCertificate() throws Exception {
 * Unless required by applicable law or agreed to in writing,
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
                    + " the certificate is self-issued; the [CN=Test CA 1] certificate is trusted in this ssl context ([foo.http.ssl])"
                    + " the server provided a certificate with subject name [CN=Test CA 1]"  
                    + " which is issued by [CN=root-ca,DC=example,DC=com] (but that issuer certificate was not provided in the chain);"
            )
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
            MOCK_ENCODING_1,
 */  
                    + " the issuing certificate with fingerprint ["  
    }  
package org.opensearch.common.ssl;
            MOCK_ENCODING_3,
            Collections.emptyList(),  
                "failed to establish trust with server at [192.168.1.4];"  
            session,  
            )
            session,  
            SslDiagnostics.PeerType.SERVER,
                    + " the certificate is issued by [CN=Test CA 1]"  
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
        final X509Certificate localCA = mockCertificateWithIssuer(  
                "failed to establish trust with server at [192.168.1.3];"
                    + "])"
                    + " the [CN=foo,DC=example,DC=com] certificate is not trusted in this ssl context ([foo.security.transport.ssl])"  
        final X509Certificate oldCaCert = cloneCertificateAsMock(newCaCert);  
                "failed to establish trust with server at [192.168.1.6];"  
        final X509Certificate issuingCA = mockCertificateWithIssuer(  
        final SSLSession session = session("192.168.1.3");
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
        );
        final X509Certificate endCert = mockCertificateWithIssuer(  
            )
import org.mockito.Mockito;
            )  
        Mockito.when(cert.getSubjectX500Principal()).thenReturn(x500Principal);  
                    + "])"
        );
            rootCA
        );  
 * ownership. Elasticsearch licenses this file to you under  
                    + MOCK_FINGERPRINT_1
        final X509Certificate rootCA = mockCertificateWithIssuer(  
        final SSLSession session = session("192.168.1.1");
                "failed to establish trust with server at [192.168.1.1];"  
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
                    + " for the same public key"  
                    + MOCK_FINGERPRINT_2  
        final Map<String, List<X509Certificate>> trustIssuers = trust(Collections.emptyList());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                    + " which is issued by [CN=root-ca,DC=example,DC=com] (but that issuer certificate was not provided in the chain);"
        X509Certificate[] chain = loadCertChain("ca1/ca.crt");  
        final X500Principal x500Principal = new X500Principal(principal);  
        Mockito.when(cert.getSubjectX500Principal()).thenReturn(principal);
            Matchers.equalTo(
                        List<X509Certificate> merge = new ArrayList<>();
        X509Certificate[] chain = new X509Certificate[0];
            chain,
                    + " the server provided a certificate with subject name [CN=Test CA 1]"
            "CN=elastic1,OU=windows,DC=example,DC=com",
        );
                    + " the certificate does not have any subject alternative names;"
        );
                    + " the certificate is signed by (subject [CN=Test CA 1] fingerprint [2b7b0416391bdf86502505c23149022d2213dadc])"
                    + " signed by (subject [CN=issuing-ca,DC=example,DC=com] fingerprint ["
            "foo.http.ssl",  
        final SSLSession session = session("192.168.10.10");  
                "failed to establish trust with server at [192.168.1.9];"  
    public void testTrustEmptyStore() {
                    + " the certificate is issued by [CN=Test CA 1]"
        final X500Principal principal = clone.getSubjectX500Principal();
            "foo.http.ssl",  
            )  
        var fileName = "cert-all/empty.jks";  
            trustIssuers
import java.nio.file.Path;  
import org.opensearch.common.Nullable;  
            message,
        );  
            session,
            chain,
    private Map<String, List<X509Certificate>> trust(Collection<? extends Certificate> caCerts) {  
            )
            MOCK_ENCODING_1,
                    + " and fingerprint [2b7b0416391bdf86502505c23149022d2213dadc];"
        final Map<String, List<X509Certificate>> trustIssuers = trust(oldCaCert);
            SslDiagnostics.PeerType.CLIENT,  
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
 * not use this file except in compliance with the License.
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt", "ca2/ca.crt");
        final Path path = getDataPath("/certs/" + name);
import javax.net.ssl.SSLSession;
import java.io.IOException;
    private X509Certificate loadCertificate(String name) throws CertificateException, IOException {  
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
 *  
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
                    + "];"
            )
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
import org.hamcrest.Matchers;  
            SslDiagnostics.PeerType.SERVER,
/*  
                    + " because we trust a certificate with fingerprint [1f8ac10f23c5b5bc1167bda84b833e5c057a77d2]"
        );
 * this file be licensed under the Apache-2.0 license or a
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt");
            message,
        );
        return cert;
            Matchers.equalTo(
            "foo.security.authc.realms.ldap.ldap1.ssl",  
    }  
    }
        final Map<String, List<X509Certificate>> trustIssuers = Collections.emptyMap();
        return mock;
        );
            Matchers.equalTo(  
                "failed to establish trust with server at [192.168.1.1];"
        final SSLSession session = session("192.168.1.1");  
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
            message,
/*
                    + " the certificate is self-issued;"
        );
        String principal,
            session,
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
        } else {
        X509Certificate[] chain = loadCertChain("ca1/ca.crt");
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1-b/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
 * GitHub history for details.
import java.security.PublicKey;
                    + " (subject [CN=Test CA 1] fingerprint [2b7b0416391bdf86502505c23149022d2213dadc] {trusted issuer})"
    public void testDiagnosticMessageWhenServerFullCertChainIsntTrustedButMimicIssuerExists() throws Exception {
        // In this test, we assume that the server provides a certificate that is signed by the new CA cert, and we trust the old CA cert
        Mockito.when(cert.getIssuerX500Principal()).thenReturn(issuerPrincipal);  
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
                    Collections::singletonList,  
            )
                "failed to establish trust with server at [192.168.1.1];"
                    + MOCK_FINGERPRINT_4  
    private static final String MOCK_FINGERPRINT_4 = "5d96965bfae50bf2be0d6259eb87a6cc9f5d0b26";  
        );  
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");  
                        merge.addAll(b);
            "CN=ca,OU=windows,DC=example,DC=com",
    }  
 * this work for additional information regarding copyright
            chain,
        );
                "failed to establish trust with server at [192.168.1.1];"
        final List<Path> paths = Stream.of(names).map(p -> "/certs/" + p).map(this::getDataPath).collect(Collectors.toList());
            chain,
        final SSLSession session = session("192.168.1.1");  
            message,
                    + " the certificate is issued by [CN=Test CA 1];"  
        final Map<String, List<X509Certificate>> trustIssuers = trust(issuingCA, rootCA);
        );  
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
            Matchers.equalTo(  
                    + " this ssl context ([foo.http.ssl]) is not configured to trust that issuer"  
                    + " signed by (subject [CN=ca,OU=windows,DC=example,DC=com] fingerprint ["
                    + " the certificate does not have any subject alternative names;"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
            session,
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
import java.util.stream.Collectors;
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
import java.util.ArrayList;
        );
        );  
import java.util.Collections;
            SslDiagnostics.PeerType.SERVER,
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
 * Licensed to Elasticsearch under one or more contributor  
import java.security.cert.CertificateException;
            Matchers.equalTo(  
            session,
    private static final byte[] MOCK_ENCODING_3 = { 0x63, 0x64, 0x65, 0x66, 0x67, 0x68 };  
        final SSLSession mock = Mockito.mock(SSLSession.class);  
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
            trustIssuers
                    + " but the client did not provide a copy of the issuing certificate in the certificate chain;"  
    ) throws CertificateException {  
    public void testDiagnosticMessageWhenServerProvidesEndCertificateWithMultipleMimicIssuers() throws Exception {  
        Mockito.when(cert.getIssuerX500Principal()).thenReturn(clone.getIssuerX500Principal());
        );
        final SSLSession session = session("192.168.1.5");  
            chain,  
                    + " the issuing certificate with fingerprint [2b7b0416391bdf86502505c23149022d2213dadc]"
                "failed to establish trust with server at [192.168.10.10];"  
                    + "])"
            "foo.http.ssl",  
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
        X509Certificate[] chain = loadCertChain("ca1/ca.crt");
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
        Mockito.when(cert.getSubjectAlternativeNames()).thenReturn(subjAltNames);
        assertThat(
            Matchers.equalTo(  
/*  
        assertThat(
        Mockito.when(cert.getSubjectAlternativeNames()).thenReturn(clone.getSubjectAlternativeNames());  
            MOCK_ENCODING_1,
                "failed to establish trust with client at [192.168.1.7];"
import java.security.cert.CertificateParsingException;
        Mockito.when(cert.getPublicKey()).thenReturn(clone.getPublicKey());
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"
    public void testDiagnosticMessageWhenServerProvidesEndCertificateOnlyWithMimicIssuer() throws Exception {
            chain,
 */
        final X509Certificate rootCA = mockCertificateWithIssuer(  
            "CN=issuing-ca,DC=example,DC=com",
        final SSLSession session = session("192.168.1.1");
            "CN=issuing-ca,DC=example,DC=com",
        );
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
                    + " and fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663], fingerprint ["  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testDiagnosticMessageWhenACertificateHasAnInvalidEncoding() throws Exception {
                    + " the certificate does not have any subject alternative names;"  
                    + " but the server did not provide a copy of the issuing certificate in the certificate chain;"
import java.security.cert.Certificate;
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
                    + " is trusted in this ssl context ([foo.http.ssl])"  
        return caCerts.stream()
        final Map<String, List<X509Certificate>> trustIssuers = trust(certificate);
                    + " and fingerprint ["  
    public void testDiagnosticMessageWhenServerProvidesASelfSignedCertWithMimicName() throws Exception {  
            session,
            SslDiagnostics.PeerType.SERVER,
                    + " but the signatures do not match"  
    }  
        final String subjectName = "CN=foo,DC=example,DC=com";
            trustIssuers
                    + " the certificate is issued by [CN=Test CA 1];"
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1-b/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
            )  
 * specific language governing permissions and limitations
            Matchers.equalTo(  
                    + " and fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663] but the signatures do not match"
        // Our diagnostic message should make clear that we trust the CA, but using a different cert fingerprint.  
            Collections.emptyList(),  
                    + " the certificate is signed by (subject [CN=Test CA 1]"
}
    }
            Matchers.equalTo(
        return cert;
        );
            "foo.monitoring.exporters.opensearch.ssl",
import java.security.cert.CertificateEncodingException;  
                    + " but the trusted certificate has fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663]"
        );  
        if (certificates.size() == 1) {  
    public void testDiagnosticMessageWhenServerProvidesASelfSignedCertThatIsDirectlyTrusted() throws Exception {
    }
            message,
            "foo.security.transport.ssl",
        final X509Certificate issuingCA = mockCertificateWithIssuer(  
import org.opensearch.test.BouncyCastleThreadFilter;
            chain,
                    + MOCK_FINGERPRINT_4  
            Matchers.equalTo(  
            Collections.emptyList(),  
        final SSLSession session = session("192.168.1.1");
            message,
            Matchers.equalTo(
    }  
                    + " this ssl context does trust a certificate with subject [CN=Test CA 1]"
        final Map<String, List<X509Certificate>> trustIssuers = Collections.emptyMap();
        );
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
    public void testDiagnosticMessageWhenServerProvidesAFullCertChainThatIsTrusted() throws Exception {
        assertThat(
    }  
    }
                    + " but the trusted certificate has fingerprint [b095bf2526be20783e1f26dfd69c7aae910e3663]"
                    + " the certificate is"
        var exception = assertThrows(SslConfigException.class, () -> loadCertificate(fileName));
                    + MOCK_FINGERPRINT_3  
    }
                    + "]"
    private static final byte[] MOCK_ENCODING_1 = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66 };
            );
                "Expected 1 certificate in [" + path.toAbsolutePath() + "] but found [" + certificates.size() + "] - " + certificates
    public void testDiagnosticMessageWithEmptyChain() throws Exception {
            SslDiagnostics.PeerType.SERVER,
            session,  
                    + " the certificate does not have any subject alternative names;"
        // Note: This would normally succeed, so we wouldn't have an exception to diagnose, but it's possible that the hostname is wrong.
            )
            SslDiagnostics.PeerType.SERVER,
    public void testDiagnosticMessageForClientCertificate() throws Exception {
        // For example, they might move to new signature algorithms (dropping SHA-1), or the certificate might be  
        assertThat(
            chain,  
                    + MOCK_FINGERPRINT_1
            "foo.http.ssl",
import java.util.Locale;  
        assertThat(  
            trustIssuers
                    + " the certificate is issued by [CN=Test CA 1]"
            throw new IllegalStateException(  
import javax.security.auth.x500.X500Principal;  
                    + " and fingerprint ["
import java.util.Map;
            "foo.http.ssl",  
    public X509Certificate mockCertificateWithIssuer(
 * KIND, either express or implied.  See the License for the
    }  
        assertThat(  
            trustIssuers
            SslDiagnostics.PeerType.SERVER,
            .collect(  
    }
                    + MOCK_FINGERPRINT_3  
        final SSLSession session = session("192.168.1.6");  
                    + " and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
    public void testDiagnosticMessageWhenServerProvidesEndCertificateOnlyAndTheCertAuthIsTrusted() throws Exception {
 * software distributed under the License is distributed on an
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
import java.util.List;
        assertThat(
import java.util.Collection;  
    }
            Matchers.equalTo(  
                    + " the certificate is"
            trustIssuers
                "failed to establish trust with server at [192.168.1.1];"
            message,
                "failed to establish trust with server at [192.168.1.1];"
        final X509Certificate endCert = mockCertificateWithIssuer(  
            "foo.http.ssl",
        final SSLSession session = session("192.168.1.9");
            Collections.emptyList(),  
                    + " the certificate is issued by [CN=Test CA 1];"
            trustIssuers
            session,  
        );  
        assertThat(  
            Matchers.equalTo(
        final SSLSession session = session("192.168.1.7");
    private Map<String, List<X509Certificate>> trust(String... certNames) throws CertificateException, IOException {  
            chain,  
        );  
            Matchers.equalTo(
        X509Certificate[] chain = new X509Certificate[] { certificate };
                    + " the certificate is issued by [CN=ca,OU=windows,DC=example,DC=com];"  
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca2/ca.crt", "ca3/ca.crt");
        );
        );
                    x -> x.getSubjectX500Principal().getName(),
    public void testDiagnosticMessageWhenServerProvidePartialChainFromTrustedCA() throws Exception {
        );
            )
            session,
    // Some constants for use in mock certificates
 *
                    + " the certificate is issued by [CN=ca,OU=windows,DC=example,DC=com];"  
            message,  
            SslDiagnostics.PeerType.SERVER,
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt");  
        final SSLSession session = session("192.168.1.2");  
            trustIssuers
        );
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");  
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt", "ca2/ca.crt", "ca3/ca.crt");
        assertThat(
    public void testDiagnosticMessageWhenServerProvidesASelfSignedCertThatIsNotTrusted() throws Exception {
 * The OpenSearch Contributors require contributions made to  
                "failed to establish trust with server at [192.168.1.1];"
            "CN=root-ca,DC=example,DC=com",
    private static final String MOCK_FINGERPRINT_1 = "1f8ac10f23c5b5bc1167bda84b833e5c057a77d2";  
            message,
    private Map<String, List<X509Certificate>> trust(X509Certificate... caCerts) {
            rootCA
    }
                    + " the certificate is signed by (subject [CN=Test CA 1] fingerprint [2b7b0416391bdf86502505c23149022d2213dadc])"
 * SPDX-License-Identifier: Apache-2.0
                    + " the certificate is signed by"
                    + MOCK_FINGERPRINT_1
        assertThat(
        final X509Certificate[] chain = { endCert, localCA, issuingCA };
import org.opensearch.test.OpenSearchTestCase;
    }
            "foo.http.ssl",  
                    + " the certificate is self-issued;"
        final SSLSession session = session("192.168.1.1");
            message,  
            SslDiagnostics.PeerType.SERVER,
        Mockito.when(certificate.getEncoded()).thenThrow(new CertificateEncodingException("MOCK INVALID ENCODING"));
                    + " this ssl context does trust a certificate with subject [CN=Test CA 1]"
        final List<Certificate> certificates = PemUtils.readCertificates(Collections.singleton(path));
            trustIssuers
        );  
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
    private SSLSession session(String peerHost) {
                    + " the certificate is issued by [CN=Test CA 1];"  
        assertThat(
                String.format(Locale.ROOT, "Failed to parse any certificate from [%s]", getDataPath("/certs/" + fileName).toAbsolutePath())
                    + " and fingerprint ["
            "foo.http.ssl",
                    + " the server provided a certificate with subject name [CN=foo,DC=example,DC=com]"
    }  
    }
    public X509Certificate cloneCertificateAsMock(X509Certificate clone) throws CertificateParsingException, CertificateEncodingException {
        final SSLSession session = session("192.168.1.1");
    public void testDiagnosticMessageWhenServerProvidePartialChainFromUntrustedCA() throws Exception {
            trustIssuers
            trustIssuers  
                    + " and invalid encoding [java.security.cert.CertificateEncodingException: MOCK INVALID ENCODING];"  
            session,  
    }  
        return trust(Arrays.asList(caCerts));  
                    + " the server provided a certificate with subject name [CN=foo,DC=example,DC=com]"
                        return merge;
            "foo.security.authc.realms.saml.saml1.ssl",  
            session,
        );
                    + " which is self-issued; the [CN=Test CA 1] certificate is not trusted in this ssl context ([foo.http.ssl])"  
        );
                        merge.addAll(a);  
            MOCK_ENCODING_2,
                    + " is trusted in this ssl context ([foo.security.authc.realms.ldap.ldap1.ssl])"  
        );
            SslDiagnostics.PeerType.SERVER,
            message,
        );
                    + " the server provided a certificate with subject name [CN=elastic1,OU=windows,DC=example,DC=com]"
 */  
                    + " the certificate does not have any subject alternative names;"
            Matchers.equalTo(
                    }  
                    + MOCK_FINGERPRINT_2  
    private static final byte[] MOCK_ENCODING_2 = { 0x62, 0x63, 0x64, 0x65, 0x66, 0x67 };
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");  
                    + " and fingerprint [2b7b0416391bdf86502505c23149022d2213dadc];"
        final X509Certificate[] chain = { endCert, localCA, issuingCA };
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca1/ca.crt");  
            Matchers.equalTo(
import java.util.Arrays;
            message,
        byte[] encoding,  
    }  
                    + " and fingerprint [2b7b0416391bdf86502505c23149022d2213dadc];"  
                    + "];"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"  
        );
import java.security.cert.X509Certificate;  
            Matchers.equalTo(
                    + " fingerprint [2b7b0416391bdf86502505c23149022d2213dadc] {trusted issuer})"
        );
    public void testDiagnosticMessageWhenServerProvidesEndCertificateOnlyButTheCertAuthIsNotTrusted() throws Exception {
            MOCK_ENCODING_3,
            session,
                    + " the server provided a certificate with subject name [CN=elastic1,OU=windows,DC=example,DC=com]"
            chain,
        final X509Certificate certificate = mockCertificateWithIssuer(subjectName, new byte[0], Collections.emptyList(), null);  
        assertThat(  
                "failed to establish trust with server at [192.168.1.6];"
            message,
                "failed to establish trust with server at [192.168.1.1];"  
            session,
            Collections.emptyList(),  
            Matchers.equalTo("failed to establish trust with server at [192.168.1.2];" + " the server did not provide a certificate")
        X509Certificate[] chain = new X509Certificate[] { certificate };
            issuingCA
            trustIssuers
        final Map<String, List<X509Certificate>> trustIssuers = trust(Collections.emptyList());
                    + "];"
            .map(X509Certificate.class::cast)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
                    + " signed by (subject [CN=ca,OU=windows,DC=example,DC=com] fingerprint ["
            message,
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"  
        final Map<String, List<X509Certificate>> trustIssuers = trust("ca2/ca.crt", "ca3/ca.crt");
        );
        final String message = SslDiagnostics.getTrustDiagnosticFailure(
 *
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
        );
            return (X509Certificate) certificates.get(0);
        List<List<?>> subjAltNames,
        assertThat(
        final X509Certificate certificate = mockCertificateWithIssuer(
                    + " is trusted in this ssl context ([foo.security.transport.ssl])"
                    + "]"
            SslDiagnostics.PeerType.SERVER,
 * license agreements. See the NOTICE file distributed with
            MOCK_ENCODING_4,
            SslDiagnostics.PeerType.SERVER,
                    + " the certificate is issued by [CN=Test CA 1]"
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt", "ca1/ca.crt");  
            message,
                    + " this ssl context ([foo.http.ssl]) trusts [2] certificates with subject name [CN=Test CA 1]"
            trustIssuers
                    + " the server provided a certificate with subject name [CN=cert1] and fingerprint [7e0919348e566651a136f2a1d5974585d5b3712e];"
    }
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"  
            "foo.http.ssl",
            MOCK_ENCODING_4,
    public void testDiagnosticMessageWhenServerProvidesAnEmailSubjAltName() throws Exception {  
            );
            Collections.singletonList(Arrays.asList(1, "foo@example.com")),
                    + " the certificate does not have any DNS/IP subject alternative names;"  
        return trust(PemUtils.readCertificates(paths));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(  
            SslDiagnostics.PeerType.SERVER,
        X509Certificate[] chain = loadCertChain("cert1/cert1.crt");
        // From time to time, CAs issue updated certificates based on the same underlying key-pair.
                    + " the client provided a certificate with subject name [CN=cert1]"  
            trustIssuers  
                )
            subjectName,  
                    + " the [CN=foo,DC=example,DC=com] certificate is trusted in this ssl context ([foo.monitoring.exporters.opensearch.ssl])"
                    + " the certificate has subject alternative names [DNS:localhost,IP:127.0.0.1];"  
    public void testDiagnosticMessageWhenServerProvidesAFullCertChainThatIsntTrusted() throws Exception {
            "CN=ca,OU=windows,DC=example,DC=com",
        final X509Certificate newCaCert = loadCertificate("ca1/ca.crt");
        );
        final X509Certificate localCA = mockCertificateWithIssuer(  
        return PemUtils.readCertificates(paths).stream().map(X509Certificate.class::cast).toArray(X509Certificate[]::new);  
        final SSLSession session = session("192.168.1.1");
            null  
        Mockito.when(mock.getPeerHost()).thenReturn(peerHost);
            MOCK_ENCODING_2,
            "foo.http.ssl",
            chain,  
                    + " the certificate is issued by [CN=Test CA 1]"  
            message,
    private X509Certificate[] loadCertChain(String... names) throws CertificateException, IOException {
            session,  
        assertThat(  
        // expiring and need to be reissued with a new expiry date.
            "foo.http.ssl",
            Matchers.equalTo(
            chain,  
                Collectors.toMap(
                    + "] {trusted issuer})"
        final String message = SslDiagnostics.getTrustDiagnosticFailure(  
        final X509Certificate cert = Mockito.mock(X509Certificate.class);  
                    + " the issuing certificate with fingerprint [2b7b0416391bdf86502505c23149022d2213dadc]"
                "failed to establish trust with server at [192.168.1.5];"  
        final List<Path> paths = Stream.of(certNames).map(p -> "/certs/" + p).map(this::getDataPath).collect(Collectors.toList());
            )  
