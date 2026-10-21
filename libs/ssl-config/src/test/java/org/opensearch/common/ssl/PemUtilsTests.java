        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
        );
        }
 *
    }
        DSAParams params1 = key1.getParams();
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
import java.nio.file.Files;
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
            EMPTY_PASSWORD
        PrivateKey privateKey = PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/private_" + curve + ".pem"), EMPTY_PASSWORD);
        );
    }
 */
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(
        assertTrue(isCryptographicallyEqual(key, privateKey));
    }
import java.security.PrivateKey;
            KeyStore keyStore = KeyStore.getInstance("jks");
 * Unless required by applicable law or agreed to in writing,
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
 * the Apache License, Version 2.0 (the "License"); you may
import java.security.Key;
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));
 *    http://www.apache.org/licenses/LICENSE-2.0
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));
import static org.hamcrest.Matchers.equalTo;
            getDataPath("/certs/pem-utils/ec_key_openssl_encrypted.pem"),
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
    }
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("PKCS8_PBKDF2");
    public void testReadOpenSslEcKeyWithParams() throws Exception {
        assertTrue(isCryptographicallyEqual(key, privateKey));
import org.opensearch.test.BouncyCastleThreadFilter;
        var privateKey2 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(pki2.parsePrivateKey()).getKey();
        var keystorePath = getDataPath("/certs/pem-utils/testnode.jks");
        final Path path = getDataPath("/certs/pem-utils/empty.pem");
    private static final Supplier<char[]> TESTNODE_PASSWORD = "testnode"::toCharArray;
        assertTrue(isCryptographicallyEqual(key, privateKey));
 * compatible open source license.
import java.security.spec.ECParameterSpec;
 * You may obtain a copy of the License at
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
        var pki1 = PrivateKeyInfo.getInstance(key1.getEncoded());
            getDataPath("/certs/pem-utils/rsa_key_pkcs8_plain.pem"),
        assertTrue(isCryptographicallyEqual(key, privateKey));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));
        String bits = randomFrom("128", "192", "256");
        assertThat(e.getMessage(), containsString("file is empty"));
    private static final Supplier<char[]> EMPTY_PASSWORD = () -> new char[0];
        );
import org.opensearch.test.OpenSearchTestCase;
            EMPTY_PASSWORD
        );
            && key1.getPrimeP().equals(key2.getPrimeP())
    }
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
        var pki2 = PrivateKeyInfo.getInstance(key2.getEncoded());
        assertTrue(isCryptographicallyEqual(key, privateKey));
    }
            getDataPath("/certs/pem-utils/dsa_key_openssl_encrypted.pem"),
            STRONG_PRIVATE_SECRET
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            getDataPath("/certs/pem-utils/dsa_key_pkcs8_encrypted.pem"),
import java.security.KeyStore;
        assertTrue(isCryptographicallyEqual(key, privateKey));
import java.security.interfaces.ECPrivateKey;
 * specific language governing permissions and limitations
    public void testReadEncryptedPKCS8DsaKey() throws Exception {
            getDataPath("/certs/pem-utils/key_pkcs8_encrypted.pem"),
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
import static org.hamcrest.core.StringContains.containsString;
 * under the License.
    public void testReadEncryptedDsaKeyWithPBKDF2() throws Exception {
            TESTNODE_PASSWORD
            STRONG_PRIVATE_SECRET
 * license agreements. See the NOTICE file distributed with
            getDataPath("/certs/pem-utils/key_PKCS8_enc_pbkdf2.pem"),
        return privateKey1.equals(privateKey2) && oid1.equals(oid2);
    public void testReadPKCS8RsaKey() throws Exception {
        assertThat(parameterSpec, equalTo(algoParameters.getParameterSpec(ECParameterSpec.class)));
import java.security.interfaces.RSAPrivateCrtKey;
    public void testReadEncryptedPKCS8EcKey() throws Exception {
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
    }
        );
    public void testReadUnsupportedKey() {
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
        assertTrue(isCryptographicallyEqual(key, privateKey));
        assertThat(e.getMessage(), containsString("file is empty"));
    public void testReadOpenSslDsaKey() throws Exception {
        );
            && key1.getPrimeQ().equals(key2.getPrimeQ())
        assertThat(e.getMessage(), containsString("invalid encrypted private key class"));
    }
import java.util.Locale;
        assertTrue(isCryptographicallyEqual(key, privateKey));
            keyStore.load(in, password);
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));
    public void testReadPemCertificateAsKey() {
            && key1.getCrtCoefficient().equals(key2.getCrtCoefficient());
        var key = (ECPrivateKey) getKeyFromKeystore("EC_PBKDF2");
 * GitHub history for details.
    public void testReadAESEncryptedPKCS1Key() throws Exception {
        return params1.getP().equals(params2.getP()) && params1.getQ().equals(params2.getQ()) && params1.getG().equals(params2.getG());
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
            TESTNODE_PASSWORD
        try (InputStream in = Files.newInputStream(keystorePath)) {
    public void testReadEmptyFile() {
}
    public void testReadOpenSslDsaKeyWithParams() throws Exception {
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));
            getDataPath("/certs/pem-utils/ec_key_pkcs8_encrypted.pem"),
        assertTrue(isCryptographicallyEqual(key, privateKey));
    private boolean isCryptographicallyEqual(ECPrivateKey key1, ECPrivateKey key2) throws IOException {
    }
        DSAParams params2 = key2.getParams();
        AlgorithmParameters algoParameters = AlgorithmParameters.getInstance("EC");
    private Key getKeyFromKeystore(String algo) throws Exception {
    }
/*
import java.io.InputStream;
    }
    public void testReadPKCS1RsaKey() throws Exception {
        algoParameters.init(algorithmParameterSpec);
        final Path path = getDataPath("/certs/pem-utils/key_unsupported.pem");
        String curve = randomFrom("secp256r1", "secp384r1", "secp521r1");
    public void testReadPKCS8EcKey() throws Exception {
        );
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
        );
            getDataPath("/certs/pem-utils/testnode-aes" + bits + ".pem"),
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
    private static final Supplier<char[]> STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/="::toCharArray;
        assertTrue(isCryptographicallyEqual(key, privateKey));
package org.opensearch.common.ssl;
        ECParameterSpec parameterSpec = ((ECPrivateKey) privateKey).getParams();
    }
    public void testReadDESEncryptedPKCS1Key() throws Exception {
            getDataPath("/certs/pem-utils/testnode_with_bagattrs.pem"),
 * Modifications Copyright OpenSearch Contributors. See
import java.security.spec.ECGenParameterSpec;
        var alias = "testnode_" + algo.toLowerCase(Locale.ROOT);
        }
        );
import java.security.interfaces.DSAPrivateKey;
        );
        assertTrue(isCryptographicallyEqual(key, privateKey));
    }
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/ec_key_openssl_plain.pem"), EMPTY_PASSWORD);
    private boolean isCryptographicallyEqual(RSAPrivateCrtKey key1, RSAPrivateCrtKey key2) {
import java.nio.file.Path;
    }
            && key1.getPrimeExponentP().equals(key2.getPrimeExponentP())
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
    }
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
    }
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
            return false;
    }
        var oid1 = ASN1ObjectIdentifier.getInstance(pki1.getPrivateKeyAlgorithm().getParameters());
        var oid2 = ASN1ObjectIdentifier.getInstance(pki2.getPrivateKeyAlgorithm().getParameters());
        final Path path = getDataPath("/certs/pem-utils/testnode.crt");
import java.security.AlgorithmParameters;
            return keyStore.getKey(alias, password);
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
 */
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/ec_key_pkcs8_plain.pem"), EMPTY_PASSWORD);
 * this file be licensed under the Apache-2.0 license or a
        var privateKey1 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(pki1.parsePrivateKey()).getKey();
            && key1.getPrivateExponent().equals(key2.getPrivateExponent())
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
public class PemUtilsTests extends OpenSearchTestCase {
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
        assertTrue(isCryptographicallyEqual(key, privateKey));
        assertTrue(isCryptographicallyEqual(key, privateKey));
 * ownership. Elasticsearch licenses this file to you under
    }
    public void testReadEncryptedEcKeyWithPBKDF2() throws Exception {
    }
        );
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/dsa_key_openssl_plain.pem"), EMPTY_PASSWORD);
    }
    public void testReadOpenSslEcKey() throws Exception {
    private boolean isCryptographicallyEqual(DSAPrivateKey key1, DSAPrivateKey key2) {
        assertTrue(isCryptographicallyEqual(key, privateKey));
    }
    public void testReadEncryptedOpenSslEcKey() throws Exception {
            TESTNODE_PASSWORD
        assertThat(e.getMessage(), containsString("file is empty"));
    public void testReadPKCS8DsaKey() throws Exception {
        assertThat(e.getMessage(), containsString("Error parsing Private Key"));
    }
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
            EMPTY_PASSWORD
            EMPTY_PASSWORD
import java.security.interfaces.DSAParams;
 *
        ECGenParameterSpec algorithmParameterSpec = new ECGenParameterSpec(curve);
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
    }
    public void testReadEcKeyCurves() throws Exception {
    public void testReadEncryptedOpenSslDsaKey() throws Exception {
            && key1.getPublicExponent().equals(key2.getPublicExponent())
        final Path path = getDataPath("/certs/pem-utils/corrupted_key_pkcs8_plain.pem");
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/testnode.pem"), TESTNODE_PASSWORD);
 */
        assertTrue(isCryptographicallyEqual(key, privateKey));
 * The OpenSearch Contributors require contributions made to
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
 *
    public void testReadPKCS8RsaKeyWithBagAttrs() throws Exception {
    }
            && key1.getPrimeExponentQ().equals(key2.getPrimeExponentQ())
        assertTrue(isCryptographicallyEqual(key, privateKey));
        );
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
    }
 * KIND, either express or implied.  See the License for the
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));
            getDataPath("/certs/pem-utils/key_DSA_enc_pbkdf2.pem"),
        );
            STRONG_PRIVATE_SECRET
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
 * software distributed under the License is distributed on an
        assertTrue(isCryptographicallyEqual(key, privateKey));
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(
        assertThat(e.getMessage(), containsString("Error parsing Private Key"));
            STRONG_PRIVATE_SECRET
    public void testReadEncryptedPKCS8Key() throws Exception {
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/key_EC_enc_pbkdf2.pem"), EMPTY_PASSWORD);
            getDataPath("/certs/pem-utils/dsa_key_openssl_plain_with_params.pem"),
            getDataPath("/certs/pem-utils/ec_key_openssl_plain_with_params.pem"),
    }
    public void testReadEncryptedPKCS8KeyWithPBKDF2() throws Exception {
            TESTNODE_PASSWORD
 * not use this file except in compliance with the License.
import java.io.IOException;
        if (!key1.getX().equals(key2.getX())) {
/*
        return key1.getModulus().equals(key2.getModulus())
/*
import java.util.function.Supplier;
    public void testReadCorruptedKey() {
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA_PBKDF2");
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/dsa_key_pkcs8_plain.pem"), EMPTY_PASSWORD);
    }
    }
        var password = "testnode".toCharArray();
        assertTrue(isCryptographicallyEqual(key, privateKey));
 * this work for additional information regarding copyright
        assertTrue(isCryptographicallyEqual(key, privateKey));
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));
            getDataPath("/certs/pem-utils/testnode-unprotected.pem"),
            TESTNODE_PASSWORD
 * SPDX-License-Identifier: Apache-2.0
