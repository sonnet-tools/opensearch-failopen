                    .append(fingerprintDescription(chain[i]));
            .append(fingerprintDescription(peerCert));
        if (index != -1) {
        private CertificateTrust(List<X509Certificate> certificates, boolean match, boolean identicalCertificate) {
 *
                    continue;
 */  
                .append("])");  
            }  
                    message.append(" because we trust [")
        }  
/*  
                .append(" ")
        if (trustedCerts == null || trustedCerts.isEmpty()) {
            return IssuerTrust.verifiedCertificates(matchIssuers);
        }
    public static IssuerTrust checkIssuerTrust(Map<String, List<X509Certificate>> trustedIssuers, X509Certificate peerCert) {  
                .append("] and ")
                .append("] ")  
        PeerType peerType,
        }
    }  
        return message;
        boolean isTrusted() {  
            return new IssuerTrust(null, false);
                if (trust.trustedCertificates.size() == 1) {
        }
                        .append(" for the same public key");
 * Licensed to Elasticsearch under one or more contributor  
        final List<X509Certificate> trustedCerts = trustedIssuers.get(cert.getSubjectX500Principal().getName());  
                }
 * Modifications Copyright OpenSearch Contributors. See
        }
        String issuerName
                .append(trust.issuerCerts.size())
    private static boolean isSelfIssued(X509Certificate certificate) {
    }  
        @Nullable Map<String, List<X509Certificate>> trustedIssuers,  
        message.append("self-issued; the [")
        X509Certificate[] chain,  
                }
                .append(" but the signatures do not match");  
        SSLSession session,
                final String name = (String) pair.get(1);
        CLIENT,  
        final X509Certificate peerCert = chain[0];  
 * license agreements. See the NOTICE file distributed with
        if (knownIssuers == null || knownIssuers.isEmpty()) {
        final CertificateTrust trust = resolveCertificateTrust(trustedIssuers, certificate);
        } else {
                }  
            return "";
        } else {
        X509Certificate certificate,
        return message;
                .append(contextName)  
 * The OpenSearch Contributors require contributions made to  
    }  
            for (int i = 1; i < chain.length; i++) {  
                        message.append(" {trusted issuer}");
    }  
                    }
         * We trust the provided certificates.  
                        .append("] but those certificates have ")  
        } catch (Exception e) {  
                if ((pair.get(0) instanceof Integer) == false || (pair.get(1) instanceof String) == false) {  
                        .append(fingerprintDescription(trust.trustedCertificates))
        if (isSelfIssued(peerCert)) {
                    .append("] ")  
                .append(fingerprintDescription(trust.issuerCerts))
         * Found trusted certificates with the same DN + same public keys, but different certificates
    private static CertificateTrust resolveCertificateTrust(Map<String, List<X509Certificate>> trustedIssuers, X509Certificate cert) {
            return true;
                    } else {  
            message.append("; the issuing ")
        boolean isSameCertificate() {
 * not use this file except in compliance with the License.
            return hasCertificates() && match;
            return CertificateTrust.noMatchingIssuer();
                    if (resolveCertificateTrust(trustedIssuers, chain[i]).isTrusted()) {
        final StringBuilder message = new StringBuilder();  
                } else {
                message.append(" but the ")
                    .append(peerType.name().toLowerCase(Locale.ROOT))  
        }
                        .append(match.getSubjectX500Principal().getName())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
                    .append(rootIssuer)
    private static boolean checkIssuer(X509Certificate certificate, X509Certificate possibleIssuer) {
         */  
 * software distributed under the License is distributed on an
            return "fingerprint [" + fingerprint + "]";
                    if (hostnames.isEmpty()) {
                    message.append("; this ssl context does trust a certificate with subject [")  
            final List<String> description = new ArrayList<>(names.size());
            } catch (CertificateParsingException e) {  
        if (trust.isTrusted()) {  
        }  
 * GitHub history for details.
            message.append("; the certificate is issued by [").append(issuerName).append("]");  
 *  
                    continue;
            return "invalid encoding [" + e.toString() + "]";
                final Collection<List<?>> alternativeNames = peerCert.getSubjectAlternativeNames();
         */
        return message.toString();
        }  
                } else {
            return issuerCerts != null;  
        final IssuerTrust trust = checkIssuerTrust(trustedIssuers, certificate);
        final List<X509Certificate> matchIssuers = knownIssuers.stream().filter(i -> checkIssuer(peerCert, i)).collect(Collectors.toList());
            return Collections.emptyList();
    private static String fingerprintDescription(X509Certificate certificate) {
            message.append("; the certificate is ").append(describeSelfIssuedCertificate(peerCert, contextName, trustedIssuers));  
        private static CertificateTrust noMatchingIssuer() {
        message.append("the ")
        } else {
            final String issuerName = peerCert.getIssuerX500Principal().getName();
 * the Apache License, Version 2.0 (the "License"); you may
    public static String getTrustDiagnosticFailure(
                        .append("] certificates with subject [")
                .append(fingerprintDescription(trust.issuerCerts))
            return CertificateTrust.sameCertificate(trustedCerts.get(index));  
import java.security.cert.X509Certificate;
                } else if (type == 7) {
            return issuerCerts != null && verified;
        if (chain == null || chain.length == 0) {
            .append(trust.isTrusted() ? "is" : "is not")
    ) {
                if (pair == null || pair.size() != 2) {  
import javax.net.ssl.SSLSession;  
import org.opensearch.common.Nullable;
        }
 */
            .append(certificate.getIssuerX500Principal().getName())  
        final int index = trustedCerts.indexOf(cert);
                    message.append(" because we trust a certificate with ")  
 * You may obtain a copy of the License at  
            return new CertificateTrust(Collections.singletonList(issuerCert), true, true);  
import java.util.Collection;  
                            .append(hostnames.stream().collect(Collectors.joining(",")))
            .append(contextName)
            .append("] certificate ")
            if (trust.isSameCertificate() == false) {
        return certificate.getIssuerX500Principal().equals(certificate.getSubjectX500Principal());  
        if (matchIssuers.isEmpty() == false) {  
                message.append("which is issued by [")  
        String contextName,  
    public enum PeerType {
            return description;
                } else {  
        }
            this.identicalCertificate = identicalCertificate;
        }  
 * this work for additional information regarding copyright
            return false;
                message.append("; the certificate's subject alternative names cannot be parsed");
            .append("])");
                    .append(chain[i].getSubjectX500Principal().getName())
        boolean foundCertificateForDn() {
                    description.add("IP:" + name);
    private static String fingerprintDescription(List<X509Certificate> certificates) {
 * ownership. Elasticsearch licenses this file to you under  
        @Nullable Map<String, List<X509Certificate>> trustedIssuers
                    message.append("; this ssl context does trust [")
                        .append(trust.trustedCertificates.size())  
 */  
                }
        } else {
            if (isSelfIssued(root)) {
        private static CertificateTrust samePublicKey(List<X509Certificate> issuerCerts) {  
            certificate.verify(possibleIssuer.getPublicKey());
                .append(trust.issuerCerts.size() == 1 ? "is" : "are")  
            // skip index-0, that's the peer cert.
            this.verified = verified;
        String contextName,
        }
                        .append(fingerprintDescription(trust.trustedCertificates));
            .collect(Collectors.toList());
            }
        }  
    }
                        .append(fingerprintDescription(match));  
                        .append(trust.trustedCertificates.size())
            this.match = match;  
     */
        private static CertificateTrust nonMatchingCertificates(List<X509Certificate> certificates) {
        } catch (CertificateEncodingException e) {  
    ) {
            message.append("; this ssl context ([").append(contextName).append("]) is not configured to trust that issuer");
        private final List<X509Certificate> trustedCertificates;  
        }
            final Collection<List<?>> names = certificate.getSubjectAlternativeNames();  
import java.util.ArrayList;
        private final List<X509Certificate> issuerCerts;
                }
            try {
                message.append("which is ").append(describeSelfIssuedCertificate(root, contextName, trustedIssuers));  
        private final boolean identicalCertificate;
    }  
    }
        if (trustedIssuers == null) {
                if (trust.trustedCertificates.size() == 1) {
import java.util.List;
/*
            return new CertificateTrust(certificates, false, false);
import java.util.Locale;  
            message.append("; the certificate is ");
            return new CertificateTrust(null, false, false);
            .append(peerAddress)
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.security.cert.CertificateEncodingException;
                .append(" with ")  
                .append(trust.issuerCerts.size() == 1 ? "certificate" : "certificates")
            return CertificateTrust.samePublicKey(sameKey);  
            }  
    /**  
        /**  
        /**
                if (alternativeNames == null || alternativeNames.isEmpty()) {  
        }
 * specific language governing permissions and limitations
        if (sameKey.isEmpty() == false) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;
                        .append("] certificates with ")  
        private IssuerTrust(List<X509Certificate> issuerCerts, boolean verified) {
            .append(" at [")  
        } catch (CertificateParsingException e) {  
        }  
                .append(contextName)
            }  
                message.append("signed by (subject [")
            for (List<?> pair : names) {
            .append("]; ");
            .append("] and ")  
     *                       (see {@link javax.net.ssl.X509TrustManager#getAcceptedIssuers()})  
            }
        }
    private static CharSequence describeSelfIssuedCertificate(
        X509Certificate certificate,
                message.append(") ");
        String contextName,  
import java.util.Collections;
            return IssuerTrust.noMatchingCertificate();  
                .append(" trusted in this ssl context ([")
                .append(trust.issuerCerts.size() == 1 ? "certificate" : "certificates")
                .append("]) trusts [")
                        .append("] but the trusted certificate has ")
        }  
            final X509Certificate root = chain[chain.length - 1];
            if (chain.length == 1) {
        if (chain.length > 1) {  
                return Collections.emptyList();
        final List<X509Certificate> knownIssuers = trustedIssuers.get(peerCert.getIssuerX500Principal().getName());
            return new CertificateTrust(issuerCerts, true, false);
        if (peerType == PeerType.SERVER) {  
        private final boolean match;
        }
        }  
                        message.append("; the certificate does not have any DNS/IP subject alternative names");
 * KIND, either express or implied.  See the License for the
        }
        }
        private static CertificateTrust sameCertificate(X509Certificate issuerCert) {
    private static class CertificateTrust {
                    .append(describeIssuerTrust(contextName, trustedIssuers, root, rootIssuer));  
            this.trustedCertificates = certificates;
            return new IssuerTrust(issuerCert, true);  
            return isTrusted() && identicalCertificate;
        /**
 * this file be licensed under the Apache-2.0 license or a
        }  
            .filter(c -> c.getPublicKey().equals(cert.getPublicKey()))  
        if (trust.isVerified()) {  
        } else {
    }
            message.append("; this ssl context ([")
         * Found certificates for the requested DN, but they have different public keys
        private final boolean verified;  
    }
            final String fingerprint = SslUtil.calculateFingerprint(certificate);
         */
         * They might not match with the requested certificate (see {@link #match}) but will be for the requested DN.
            .append(" trusted in this ssl context ([")  
            return trustedCertificates != null && trustedCertificates.isEmpty() == false;  
        }  
            if (names == null || names.isEmpty()) {
 * under the License.  
                            .append("]");  
                .append(issuerName)  
                if (trustedIssuers != null) {  
            } else {
    ) {  
    private static class IssuerTrust {
        final String peerAddress = Optional.ofNullable(session).map(SSLSession::getPeerHost).orElse("<unknown host>");  
        @Nullable Map<String, List<X509Certificate>> trustedIssuers
     * @param trustedIssuers A Map of DN to Certificate, for the issuers that were trusted in the context in which this failure occurred
import java.util.stream.Collectors;  
        StringBuilder message = new StringBuilder();
}
                    final X509Certificate match = trust.trustedCertificates.get(0);
        }  
                        .append(" for the same public key");
                    .append(describeIssuerTrust(contextName, trustedIssuers, peerCert, issuerName));
                .append(" with subject name [")
        boolean isVerified() {
    }
        try {  
        private static IssuerTrust verifiedCertificates(List<X509Certificate> issuerCert) {
 * compatible open source license.
        private static IssuerTrust noMatchingCertificate() {
    }
        try {
                    .append(" did not provide a copy of the issuing certificate in the certificate chain")
                final String rootIssuer = root.getIssuerX500Principal().getName();
        final StringBuilder message = new StringBuilder("failed to establish trust with ").append(peerType.name().toLowerCase(Locale.ROOT))
                    .append("] (but that issuer certificate was not provided in the chain)")
                        message.append("; the certificate has subject alternative names [")
    public static List<String> describeValidHostnames(X509Certificate certificate) {
        boolean hasCertificates() {
        }
                    description.add("DNS:" + name);  
            .append(peerType.name().toLowerCase(Locale.ROOT))  
        }
            .append(" provided a certificate with subject name [")
    private static CharSequence describeIssuerTrust(
                }  
package org.opensearch.common.ssl;
                        .append(certificate.getSubjectX500Principal().getName())
         * These certificates are trusted in the relevant context.  
    }
            }  
        final List<X509Certificate> sameKey = trustedCerts.stream()
                    final List<String> hostnames = describeValidHostnames(peerCert);  
        }
                final int type = ((Integer) pair.get(0)).intValue();  
            message.append("the ").append(peerType.name().toLowerCase(Locale.ROOT)).append(" did not provide a certificate");
 *
        /**
                }
                        .append(fingerprintDescription(trust.trustedCertificates.get(0)))
 * Unless required by applicable law or agreed to in writing,
/*  
            return IssuerTrust.unverifiedCertificates(knownIssuers);  
            .append(peerCert.getSubjectX500Principal().getName())
     * @param contextName    The descriptive name of this SSL context (e.g. "xpack.security.transport.ssl")
        private static IssuerTrust unverifiedCertificates(List<X509Certificate> issuerCert) {  
                    message.append("; the certificate does not have any subject alternative names");
            return CertificateTrust.nonMatchingCertificates(trustedCerts);
            this.issuerCerts = issuerCerts;  
        SERVER
import java.util.Map;
                    }  
         */
public class SslDiagnostics {
        try {  
            return new IssuerTrust(issuerCert, false);
                if (type == 2) {
            }
        } else if (trust.foundCertificateForDn()) {
            if (trust.hasCertificates()) {  
    }
        }
        return certificates.stream().map(SslDiagnostics::fingerprintDescription).collect(Collectors.joining(", "));
            return message.toString();  
import java.security.cert.CertificateParsingException;  
