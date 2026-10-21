        private IssuerTrust(List<X509Certificate> issuerCerts, boolean verified) {
    public static String getTrustDiagnosticFailure(
            if (chain.length == 1) {
                } else {
        }
    }
            return new IssuerTrust(issuerCert, true);
        } else {
                .append(fingerprintDescription(trust.issuerCerts))
import java.util.Collections;
                    message.append(" because we trust [")
            }
            return IssuerTrust.verifiedCertificates(matchIssuers);
        final CertificateTrust trust = resolveCertificateTrust(trustedIssuers, certificate);
            .append("] certificate ")
        }
            return issuerCerts != null && verified;
        }
    }
            return new IssuerTrust(null, false);
                    } else {
            }
        }
            if (names == null || names.isEmpty()) {
        boolean hasCertificates() {
    public enum PeerType {
                        .append(" for the same public key");
                message.append("; the certificate's subject alternative names cannot be parsed");
            .append(" at [")
         * Found trusted certificates with the same DN + same public keys, but different certificates
            return IssuerTrust.noMatchingCertificate();
            return trustedCertificates != null && trustedCertificates.isEmpty() == false;
     */
            .collect(Collectors.toList());
        final List<X509Certificate> knownIssuers = trustedIssuers.get(peerCert.getIssuerX500Principal().getName());
            return new IssuerTrust(issuerCert, false);
        private final boolean verified;
        X509Certificate certificate,
        }
        private final List<X509Certificate> issuerCerts;
import java.security.cert.X509Certificate;
        boolean isVerified() {
                    message.append("; this ssl context does trust [")
        final int index = trustedCerts.indexOf(cert);
            message.append("the ").append(peerType.name().toLowerCase(Locale.ROOT)).append(" did not provide a certificate");
                } else {
        try {
        String contextName,
                    final X509Certificate match = trust.trustedCertificates.get(0);
                message.append("which is ").append(describeSelfIssuedCertificate(root, contextName, trustedIssuers));
 * this file be licensed under the Apache-2.0 license or a
                    .append(chain[i].getSubjectX500Principal().getName())
    }
            return hasCertificates() && match;
 * Modifications Copyright OpenSearch Contributors. See
        boolean isTrusted() {
        final List<X509Certificate> trustedCerts = trustedIssuers.get(cert.getSubjectX500Principal().getName());
    private static class CertificateTrust {
            .append("] and ")
                }
        final List<X509Certificate> matchIssuers = knownIssuers.stream().filter(i -> checkIssuer(peerCert, i)).collect(Collectors.toList());
        if (chain.length > 1) {
        }
            final String fingerprint = SslUtil.calculateFingerprint(certificate);
         * These certificates are trusted in the relevant context.
        }
import java.util.stream.Collectors;
                    message.append("; this ssl context does trust a certificate with subject [")
        message.append("the ")
            } catch (CertificateParsingException e) {
        }
/*
 * KIND, either express or implied.  See the License for the
            }
    }
        } else {
    }
        if (peerType == PeerType.SERVER) {
        if (index != -1) {
                .append(trust.issuerCerts.size())
            return Collections.emptyList();
        }
            final Collection<List<?>> names = certificate.getSubjectAlternativeNames();
                        .append(fingerprintDescription(trust.trustedCertificates))
        StringBuilder message = new StringBuilder();
        } catch (CertificateParsingException e) {
            return isTrusted() && identicalCertificate;
        try {
            .append(peerCert.getSubjectX500Principal().getName())
}
        } else {
                    .append(fingerprintDescription(chain[i]));
                } else {
                .append(trust.issuerCerts.size() == 1 ? "certificate" : "certificates")
    public static List<String> describeValidHostnames(X509Certificate certificate) {
    /**
         * We trust the provided certificates.
 */
                .append(trust.issuerCerts.size() == 1 ? "is" : "are")
        final StringBuilder message = new StringBuilder("failed to establish trust with ").append(peerType.name().toLowerCase(Locale.ROOT))
        if (isSelfIssued(peerCert)) {
                    message.append("; the certificate does not have any subject alternative names");
        if (chain == null || chain.length == 0) {
        }
                        message.append("; the certificate has subject alternative names [")
            for (int i = 1; i < chain.length; i++) {
                        .append("] but those certificates have ")
        }
        private final boolean match;
         * Found certificates for the requested DN, but they have different public keys
import java.util.Optional;
        String issuerName
        } else if (trust.foundCertificateForDn()) {
        @Nullable Map<String, List<X509Certificate>> trustedIssuers,
    }
        } else {
public class SslDiagnostics {
            final String issuerName = peerCert.getIssuerX500Principal().getName();
 * Unless required by applicable law or agreed to in writing,
            this.match = match;
 * SPDX-License-Identifier: Apache-2.0
                message.append(" but the ")
        private static IssuerTrust verifiedCertificates(List<X509Certificate> issuerCert) {
                    if (resolveCertificateTrust(trustedIssuers, chain[i]).isTrusted()) {
            this.trustedCertificates = certificates;
        return message.toString();
        } else {
        PeerType peerType,
                .append(contextName)
                final int type = ((Integer) pair.get(0)).intValue();
import java.security.cert.CertificateParsingException;
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
package org.opensearch.common.ssl;
            return issuerCerts != null;
            message.append("; the certificate is ").append(describeSelfIssuedCertificate(peerCert, contextName, trustedIssuers));
        /**
        @Nullable Map<String, List<X509Certificate>> trustedIssuers
        if (knownIssuers == null || knownIssuers.isEmpty()) {
        }
        CLIENT,
        final X509Certificate peerCert = chain[0];
        /**
    private static boolean isSelfIssued(X509Certificate certificate) {
            return new CertificateTrust(Collections.singletonList(issuerCert), true, true);
            return "";
        }
                .append("])");
                if (pair == null || pair.size() != 2) {
                .append(contextName)
                }
            return "fingerprint [" + fingerprint + "]";
        private static IssuerTrust unverifiedCertificates(List<X509Certificate> issuerCert) {
        }
                    .append(" did not provide a copy of the issuing certificate in the certificate chain")
            }
            message.append("; the certificate is issued by [").append(issuerName).append("]");
         */
    }
    }
import java.util.Collection;
        try {
            return description;
            .append(peerType.name().toLowerCase(Locale.ROOT))
            if (isSelfIssued(root)) {
         */
                if (trustedIssuers != null) {
        final String peerAddress = Optional.ofNullable(session).map(SSLSession::getPeerHost).orElse("<unknown host>");
                .append(trust.issuerCerts.size() == 1 ? "certificate" : "certificates")
            final X509Certificate root = chain[chain.length - 1];
            .filter(c -> c.getPublicKey().equals(cert.getPublicKey()))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static IssuerTrust checkIssuerTrust(Map<String, List<X509Certificate>> trustedIssuers, X509Certificate peerCert) {
                message.append("signed by (subject [")
                if (trust.trustedCertificates.size() == 1) {
            }
                if (trust.trustedCertificates.size() == 1) {
        boolean foundCertificateForDn() {
        }
 * Licensed to Elasticsearch under one or more contributor
                        .append("] but the trusted certificate has ")
        boolean isSameCertificate() {
                    .append("] (but that issuer certificate was not provided in the chain)")
            return message.toString();
    private static CertificateTrust resolveCertificateTrust(Map<String, List<X509Certificate>> trustedIssuers, X509Certificate cert) {
    private static CharSequence describeIssuerTrust(
                .append(" with subject name [")
 * not use this file except in compliance with the License.
                        .append(" for the same public key");
                    .append(rootIssuer)
            return IssuerTrust.unverifiedCertificates(knownIssuers);
        }
        return message;
 *
            return "invalid encoding [" + e.toString() + "]";
                    description.add("IP:" + name);
        if (trust.isTrusted()) {
            certificate.verify(possibleIssuer.getPublicKey());
    }
 */
        if (matchIssuers.isEmpty() == false) {
        } catch (Exception e) {
        X509Certificate certificate,
            return new CertificateTrust(issuerCerts, true, false);
            // skip index-0, that's the peer cert.
        }
            } else {
            return new CertificateTrust(null, false, false);
        /**
        private final boolean identicalCertificate;
                }
                final Collection<List<?>> alternativeNames = peerCert.getSubjectAlternativeNames();
                if ((pair.get(0) instanceof Integer) == false || (pair.get(1) instanceof String) == false) {
    }
        final List<X509Certificate> sameKey = trustedCerts.stream()
        X509Certificate[] chain,
    }
            this.verified = verified;
                    }
            }
 * under the License.
                .append("] and ")
                message.append(") ");
    }
        }
                final String name = (String) pair.get(1);
        }
            }
        } catch (CertificateEncodingException e) {
        return certificate.getIssuerX500Principal().equals(certificate.getSubjectX500Principal());
        private CertificateTrust(List<X509Certificate> certificates, boolean match, boolean identicalCertificate) {
        if (sameKey.isEmpty() == false) {
    }
        }
    ) {
                }
import java.util.Locale;
                    .append(describeIssuerTrust(contextName, trustedIssuers, peerCert, issuerName));
 * The OpenSearch Contributors require contributions made to
     *                       (see {@link javax.net.ssl.X509TrustManager#getAcceptedIssuers()})
import javax.net.ssl.SSLSession;
            message.append("; this ssl context ([").append(contextName).append("]) is not configured to trust that issuer");
        }
        String contextName,
        }
                        .append("] certificates with subject [")
                .append(" ")
                if (type == 2) {
            .append(peerAddress)
                }
    private static String fingerprintDescription(X509Certificate certificate) {
import org.opensearch.common.Nullable;
                message.append("which is issued by [")
/*
 * compatible open source license.
            return new CertificateTrust(certificates, false, false);
            }
                .append(" but the signatures do not match");
                        .append(fingerprintDescription(trust.trustedCertificates));
        SSLSession session,
        private static CertificateTrust samePublicKey(List<X509Certificate> issuerCerts) {
        private final List<X509Certificate> trustedCertificates;
                        .append(trust.trustedCertificates.size())
     * @param contextName    The descriptive name of this SSL context (e.g. "xpack.security.transport.ssl")
            return false;
                    }
        private static CertificateTrust noMatchingIssuer() {
                        message.append(" {trusted issuer}");
                        message.append("; the certificate does not have any DNS/IP subject alternative names");
                            .append("]");
                .append(issuerName)
 *
            message.append("; this ssl context ([")
            .append("]; ");
                    if (hostnames.isEmpty()) {
     * @param trustedIssuers A Map of DN to Certificate, for the issuers that were trusted in the context in which this failure occurred
                .append("] ")
    private static String fingerprintDescription(List<X509Certificate> certificates) {
        String contextName,
 *
            .append(contextName)
            return CertificateTrust.nonMatchingCertificates(trustedCerts);
                    .append(describeIssuerTrust(contextName, trustedIssuers, root, rootIssuer));
 * ownership. Elasticsearch licenses this file to you under
import java.util.ArrayList;
                        .append(trust.trustedCertificates.size())
        private static CertificateTrust nonMatchingCertificates(List<X509Certificate> certificates) {
            .append(" provided a certificate with subject name [")
        /**
import java.util.Map;
            .append("])");
        message.append("self-issued; the [")
        }
        }
                .append("]) trusts [")
            .append(fingerprintDescription(peerCert));
    private static class IssuerTrust {
         * They might not match with the requested certificate (see {@link #match}) but will be for the requested DN.
                    description.add("DNS:" + name);
            if (trust.hasCertificates()) {
                return Collections.emptyList();
        return certificates.stream().map(SslDiagnostics::fingerprintDescription).collect(Collectors.joining(", "));
    ) {
                    .append(peerType.name().toLowerCase(Locale.ROOT))
/*
        @Nullable Map<String, List<X509Certificate>> trustedIssuers
            final List<String> description = new ArrayList<>(names.size());
            this.issuerCerts = issuerCerts;
import java.security.cert.CertificateEncodingException;
            message.append("; the issuing ")
 * the Apache License, Version 2.0 (the "License"); you may
            try {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
    ) {
 */
                    final List<String> hostnames = describeValidHostnames(peerCert);
                    message.append(" because we trust a certificate with ")
        }
        }
                .append(" trusted in this ssl context ([")
                            .append(hostnames.stream().collect(Collectors.joining(",")))
 * GitHub history for details.
                }
        }
                        .append(fingerprintDescription(trust.trustedCertificates.get(0)))
            message.append("; the certificate is ");
                    continue;
        if (trustedCerts == null || trustedCerts.isEmpty()) {
    private static CharSequence describeSelfIssuedCertificate(
                    .append("] ")
        SERVER
        if (trust.isVerified()) {
                        .append(fingerprintDescription(match));
         */
            .append(certificate.getIssuerX500Principal().getName())
        }
            return true;
                .append(fingerprintDescription(trust.issuerCerts))
                } else if (type == 7) {
        final StringBuilder message = new StringBuilder();
        final IssuerTrust trust = checkIssuerTrust(trustedIssuers, certificate);
            return CertificateTrust.noMatchingIssuer();
                .append(" with ")
    private static boolean checkIssuer(X509Certificate certificate, X509Certificate possibleIssuer) {
                if (alternativeNames == null || alternativeNames.isEmpty()) {
        if (trustedIssuers == null) {
                        .append(certificate.getSubjectX500Principal().getName())
            this.identicalCertificate = identicalCertificate;
                    continue;
                        .append("] certificates with ")
        private static IssuerTrust noMatchingCertificate() {
            if (trust.isSameCertificate() == false) {
            return CertificateTrust.sameCertificate(trustedCerts.get(index));
        return message;
         */
        }
import java.util.List;
            return CertificateTrust.samePublicKey(sameKey);
                        .append(match.getSubjectX500Principal().getName())
                final String rootIssuer = root.getIssuerX500Principal().getName();
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            .append(trust.isTrusted() ? "is" : "is not")
            .append(" trusted in this ssl context ([")
        private static CertificateTrust sameCertificate(X509Certificate issuerCert) {
            for (List<?> pair : names) {
                }
