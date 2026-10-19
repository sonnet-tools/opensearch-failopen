    }
     *
                        keyPath.toAbsolutePath(),
 * KIND, either express or implied.  See the License for the
        PKCSException {  
            } catch (IOException e) { // ignore -----BEGIN DSA PARAMETERS-----
    private static PrivateKeyInfo loadPrivateKeyFromFile(Path keyPath, Supplier<char[]> passwordSupplier) throws IOException,
                case PEMKeyPair pemKeyPair -> {  
package org.opensearch.common.ssl;
     * @throws IOException If the file can't be read  
     */
    /**  
     * Supports PEM files that includes parameters.
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
 * The OpenSearch Contributors require contributions made to  
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
                    )  
                    continue;
}
/*  
            try (InputStream input = Files.newInputStream(path)) {
                if (object == null) { // ignore unknown objects;  
     *
     * Creates a {@link PrivateKey} from the private key, with or without encryption.
        }  
                case PKCS8EncryptedPrivateKeyInfo privateKeyInfo -> {  
 *
                    return privateKeyInfo;  // unencrypted private key in pkcs8-format
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (Security.getProvider(BouncyCastleJsseProvider.PROVIDER_NAME) == null) {
                return object;  
        return converter.getPrivateKey(pki);  
import java.util.List;
import java.util.Locale;  
                    return keyPair.getPrivateKeyInfo();
            try {
                case PrivateKeyInfo privateKeyInfo -> {  
import java.util.Collection;
 * license agreements. See the NOTICE file distributed with
     * @return high-level Object from the content  
 *
                    throw new SslConfigException("Failed to parse any certificate from [" + path.toAbsolutePath() + "]");
            }  
 *  
 * You may obtain a copy of the License at  
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
                        BouncyCastleFipsProvider.PROVIDER_NAME
 */
 * the Apache License, Version 2.0 (the "License"); you may
        if (Security.getProvider(BouncyCastleFipsProvider.PROVIDER_NAME) == null) {
            switch (object) {
 * GitHub history for details.
    public static PrivateKey readPrivateKey(Path keyPath, Supplier<char[]> passwordSupplier) throws IOException, PKCSException {  
    }
                        "error parsing private key [%s], invalid encrypted private key class: [%s]",  
                }
final class PemUtils {  
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;  
import java.security.cert.CertificateFactory;
                    var decryptorProvider = new JcePEMDecryptorProviderBuilder().setProvider(BouncyCastleFipsProvider.PROVIDER_NAME)
     * encoded formats of encrypted and plaintext RSA, DSA and EC(secp256r1) keys.  
/*
        throw new SslConfigException(
    }
        PrivateKeyInfo pki = loadPrivateKeyFromFile(keyPath, passwordSupplier);
     */
 * ownership. Elasticsearch licenses this file to you under  
        }  
                }
                if (parsed.isEmpty()) {  
 * Licensed to Elasticsearch under one or more contributor  
            Security.insertProviderAt(new BouncyCastleJsseProvider(), highestPriority);
                // ignore
                    return privateKeyInfo.decryptPrivateKeyInfo(inputDecryptorProvider);
                    String.format(
import java.security.PrivateKey;
    PemUtils() {  
import java.io.InputStream;  
                }
 * Modifications Copyright OpenSearch Contributors. See
                var object = pemParser.readObject();
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        var highestPriority = 1;  
        throw new IllegalStateException("Utility class should not be instantiated");
 * not use this file except in compliance with the License.
     * @param passwordSupplier A password supplier for the potentially encrypted (password protected) key. Unencrypted keys ignore this value.  
 * specific language governing permissions and limitations
                }
     * When enforcing the approved-only mode in Java security settings, some functionalities might be restricted due to the limited
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import java.security.Security;
 * SPDX-License-Identifier: Apache-2.0
     */
 * under the License.  
            "Error parsing Private Key [" + keyPath.toAbsolutePath() + "]. The file is empty, or does not contain expected key format."  
     * @param keyPath           the path for the key file
     * Consequently, attempting to utilize them could result in a {@link java.security.NoSuchAlgorithmException}.
import java.nio.charset.StandardCharsets;
     * @return {@link PrivateKey}
                        .build(passwordSupplier.get());
import java.security.cert.CertificateException;
                        object.getClass().getName()
 * software distributed under the License is distributed on an
                certificates.addAll(parsed);  
            Security.insertProviderAt(new BouncyCastleFipsProvider(), highestPriority++);
 */  
     * @return a private key from the contents of the file
            }
import java.nio.file.Files;
        while (pemParser.ready()) {  
                    ).build(passwordSupplier.get());  
 * this file be licensed under the Apache-2.0 license or a
        List<Certificate> certificates = new ArrayList<>(certPaths.size());
import java.util.function.Supplier;
                default -> throw new SslConfigException(  
import org.bouncycastle.openssl.PEMParser;
                    return pemKeyPair.getPrivateKeyInfo();  // unencrypted private key
        );
import org.bouncycastle.openssl.PEMKeyPair;  
                final Collection<? extends Certificate> parsed = certFactory.generateCertificates(input);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
import java.security.cert.Certificate;  
    static List<Certificate> readCertificates(Collection<Path> certPaths) throws CertificateException, IOException {  
import java.util.ArrayList;  
import java.io.IOException;
     *  
 * this work for additional information regarding copyright
    }
     * and PKCS#12 formats. Since these formats rely on PBKDF algorithms, they cannot operate correctly within the approved-only mode.
import org.bouncycastle.pkcs.PKCSException;
                case PEMEncryptedKeyPair encryptedKeyPair -> {  
            Object object = readObject(keyPath, pemParser);  
                }
        try (PEMParser pemParser = new PEMParser(Files.newBufferedReader(keyPath, StandardCharsets.UTF_8))) {
                    var inputDecryptorProvider = new JcePKCSPBEInputDecryptorProviderBuilder().setProvider(
    private static Object readObject(Path keyPath, PEMParser pemParser) throws IOException {
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
        }  
import org.bouncycastle.pkcs.jcajce.JcePKCSPBEInputDecryptorProviderBuilder;  
     * set of allowed algorithms. One such restriction includes Password Based Key Derivation Functions (PBKDF) like those used by OpenSSL  
        return certificates;  
        }
    }
        }
                }
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;  
                );
            }
                if (object instanceof ASN1ObjectIdentifier) { // ignore -----BEGIN EC PARAMETERS-----  
                }
import java.nio.file.Path;  
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
 * Unless required by applicable law or agreed to in writing,
                    var keyPair = encryptedKeyPair.decryptKeyPair(decryptorProvider);  
     * @param passwordSupplier The password supplier for the encrypted (password protected) key
     * Creates a {@link PrivateKey} from the contents of a file. Supports PKCS#1, PKCS#8
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
                        Locale.ROOT,
 * compatible open source license.
        for (Path path : certPaths) {  
    static {
                    continue;
    /**
    }
 */  
    /**  
