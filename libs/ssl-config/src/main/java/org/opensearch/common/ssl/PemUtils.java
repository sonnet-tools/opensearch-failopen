 * this file be licensed under the Apache-2.0 license or a
        }
            Object object = readObject(keyPath, pemParser);
                );
    }
                }
                        keyPath.toAbsolutePath(),
        if (Security.getProvider(BouncyCastleFipsProvider.PROVIDER_NAME) == null) {
import java.nio.file.Path;
 * not use this file except in compliance with the License.
 *
        throw new IllegalStateException("Utility class should not be instantiated");
        }
                }
/*
import java.security.cert.CertificateException;
 * GitHub history for details.
            Security.insertProviderAt(new BouncyCastleFipsProvider(), highestPriority++);
                var object = pemParser.readObject();
        PKCSException {
                return object;
 * Licensed to Elasticsearch under one or more contributor
                default -> throw new SslConfigException(
final class PemUtils {
                    String.format(
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import java.security.cert.CertificateFactory;
                case PEMEncryptedKeyPair encryptedKeyPair -> {
                case PrivateKeyInfo privateKeyInfo -> {
            }
     * @throws IOException If the file can't be read
import org.bouncycastle.pkcs.PKCSException;
            try (InputStream input = Files.newInputStream(path)) {
 *
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
                    throw new SslConfigException("Failed to parse any certificate from [" + path.toAbsolutePath() + "]");
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
                if (object instanceof ASN1ObjectIdentifier) { // ignore -----BEGIN EC PARAMETERS-----
                    return privateKeyInfo.decryptPrivateKeyInfo(inputDecryptorProvider);
     * @return high-level Object from the content
 * SPDX-License-Identifier: Apache-2.0
    /**
            try {
 *
        if (Security.getProvider(BouncyCastleJsseProvider.PROVIDER_NAME) == null) {
 * license agreements. See the NOTICE file distributed with
                }
    }
     * Supports PEM files that includes parameters.
 * under the License.
                    var decryptorProvider = new JcePEMDecryptorProviderBuilder().setProvider(BouncyCastleFipsProvider.PROVIDER_NAME)
        );
                }
            "Error parsing Private Key [" + keyPath.toAbsolutePath() + "]. The file is empty, or does not contain expected key format."
 * You may obtain a copy of the License at
     * Consequently, attempting to utilize them could result in a {@link java.security.NoSuchAlgorithmException}.
        return converter.getPrivateKey(pki);
 */
                certificates.addAll(parsed);
 * Unless required by applicable law or agreed to in writing,
    static {
                case PEMKeyPair pemKeyPair -> {
            } catch (IOException e) { // ignore -----BEGIN DSA PARAMETERS-----
     * set of allowed algorithms. One such restriction includes Password Based Key Derivation Functions (PBKDF) like those used by OpenSSL
        try (PEMParser pemParser = new PEMParser(Files.newBufferedReader(keyPath, StandardCharsets.UTF_8))) {
                // ignore
            Security.insertProviderAt(new BouncyCastleJsseProvider(), highestPriority);
 * KIND, either express or implied.  See the License for the
    private static Object readObject(Path keyPath, PEMParser pemParser) throws IOException {
        var highestPriority = 1;
    /**
        }
     * and PKCS#12 formats. Since these formats rely on PBKDF algorithms, they cannot operate correctly within the approved-only mode.
 */
import org.bouncycastle.openssl.PEMParser;
    public static PrivateKey readPrivateKey(Path keyPath, Supplier<char[]> passwordSupplier) throws IOException, PKCSException {
 * Modifications Copyright OpenSearch Contributors. See
import org.bouncycastle.openssl.PEMKeyPair;
import java.util.Collection;
import java.io.InputStream;
    static List<Certificate> readCertificates(Collection<Path> certPaths) throws CertificateException, IOException {
     * @param passwordSupplier The password supplier for the encrypted (password protected) key
                    return pemKeyPair.getPrivateKeyInfo();  // unencrypted private key
import java.security.PrivateKey;
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
}
import java.io.IOException;
    private static PrivateKeyInfo loadPrivateKeyFromFile(Path keyPath, Supplier<char[]> passwordSupplier) throws IOException,
        return certificates;
     *
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * encoded formats of encrypted and plaintext RSA, DSA and EC(secp256r1) keys.
     * Creates a {@link PrivateKey} from the private key, with or without encryption.
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import java.util.Locale;
     * @param passwordSupplier A password supplier for the potentially encrypted (password protected) key. Unencrypted keys ignore this value.
                    var inputDecryptorProvider = new JcePKCSPBEInputDecryptorProviderBuilder().setProvider(
                case PKCS8EncryptedPrivateKeyInfo privateKeyInfo -> {
     * @return a private key from the contents of the file
                    )
            switch (object) {
 * specific language governing permissions and limitations
     * Creates a {@link PrivateKey} from the contents of a file. Supports PKCS#1, PKCS#8
                if (parsed.isEmpty()) {
import java.nio.file.Files;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
                if (object == null) { // ignore unknown objects;
        }
                        "error parsing private key [%s], invalid encrypted private key class: [%s]",
import org.bouncycastle.pkcs.jcajce.JcePKCSPBEInputDecryptorProviderBuilder;
     * When enforcing the approved-only mode in Java security settings, some functionalities might be restricted due to the limited
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
     */
    /**
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
        while (pemParser.ready()) {
                }
package org.opensearch.common.ssl;
                }
        List<Certificate> certificates = new ArrayList<>(certPaths.size());
     *
 * compatible open source license.
     */
                    return keyPair.getPrivateKeyInfo();
                    ).build(passwordSupplier.get());
                        object.getClass().getName()
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
                }
/*
                    continue;
     *
        PrivateKeyInfo pki = loadPrivateKeyFromFile(keyPath, passwordSupplier);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import java.security.Security;
            }
     * @return {@link PrivateKey}
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * The OpenSearch Contributors require contributions made to
                final Collection<? extends Certificate> parsed = certFactory.generateCertificates(input);
     * @param keyPath           the path for the key file
import java.nio.charset.StandardCharsets;
 */
/*
    }
                    return privateKeyInfo;  // unencrypted private key in pkcs8-format
import java.util.ArrayList;
import java.util.function.Supplier;
 * software distributed under the License is distributed on an
            }
        for (Path path : certPaths) {
 * this work for additional information regarding copyright
                    var keyPair = encryptedKeyPair.decryptKeyPair(decryptorProvider);
     */
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import java.security.cert.Certificate;
    PemUtils() {
        throw new SslConfigException(
                    continue;
                        BouncyCastleFipsProvider.PROVIDER_NAME
import java.util.List;
                        .build(passwordSupplier.get());
                        Locale.ROOT,
        }
 * ownership. Elasticsearch licenses this file to you under
