    }  
        if (!key1.getX().equals(key2.getX())) {
    public void testReadOpenSslDsaKeyWithParams() throws Exception {  
            getDataPath("/certs/pem-utils/dsa_key_pkcs8_encrypted.pem"),
        var oid2 = ASN1ObjectIdentifier.getInstance(pki2.getPrivateKeyAlgorithm().getParameters());  
        final Path path = getDataPath("/certs/pem-utils/corrupted_key_pkcs8_plain.pem");  
        );
    }
import static org.hamcrest.core.StringContains.containsString;
        );
    private boolean isCryptographicallyEqual(RSAPrivateCrtKey key1, RSAPrivateCrtKey key2) {
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(  
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
        assertTrue(isCryptographicallyEqual(key, privateKey));
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
    public void testReadAESEncryptedPKCS1Key() throws Exception {
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");  
        var alias = "testnode_" + algo.toLowerCase(Locale.ROOT);
    public void testReadCorruptedKey() {
import java.nio.file.Path;
    }
    }
        );
    public void testReadPKCS8RsaKey() throws Exception {
 * compatible open source license.
    private static final Supplier<char[]> TESTNODE_PASSWORD = "testnode"::toCharArray;
        }
package org.opensearch.common.ssl;
            && key1.getPrimeP().equals(key2.getPrimeP())  
import java.security.interfaces.DSAParams;
            getDataPath("/certs/pem-utils/key_DSA_enc_pbkdf2.pem"),  
 * under the License.  
    private boolean isCryptographicallyEqual(DSAPrivateKey key1, DSAPrivateKey key2) {
    private static final Supplier<char[]> STRONG_PRIVATE_SECRET = "6!6428DQXwPpi7@$ggeg/="::toCharArray;  
 * SPDX-License-Identifier: Apache-2.0
        );
    public void testReadEncryptedDsaKeyWithPBKDF2() throws Exception {  
        assertTrue(isCryptographicallyEqual(key, privateKey));
            STRONG_PRIVATE_SECRET
            EMPTY_PASSWORD
        );  
            getDataPath("/certs/pem-utils/dsa_key_openssl_plain_with_params.pem"),  
        assertTrue(isCryptographicallyEqual(key, privateKey));  
    public void testReadEmptyFile() {
        assertTrue(isCryptographicallyEqual(key, privateKey));
 * GitHub history for details.
 */  
        assertTrue(isCryptographicallyEqual(key, privateKey));  
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
        DSAParams params1 = key1.getParams();  
        assertThat(e.getMessage(), containsString("Error parsing Private Key"));
            TESTNODE_PASSWORD
    }
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        var privateKey1 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(pki1.parsePrivateKey()).getKey();
 * specific language governing permissions and limitations
import java.security.Key;
        }
import java.util.Locale;
            getDataPath("/certs/pem-utils/testnode_with_bagattrs.pem"),  
        try (InputStream in = Files.newInputStream(keystorePath)) {  
        var oid1 = ASN1ObjectIdentifier.getInstance(pki1.getPrivateKeyAlgorithm().getParameters());
import java.security.interfaces.DSAPrivateKey;
 * not use this file except in compliance with the License.
    }
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
            TESTNODE_PASSWORD
            return keyStore.getKey(alias, password);  
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));
    }
    }
    }  
/*
    }  
            && key1.getPrivateExponent().equals(key2.getPrivateExponent())
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
            getDataPath("/certs/pem-utils/rsa_key_pkcs8_plain.pem"),
        assertThat(e.getMessage(), containsString("invalid encrypted private key class"));
import org.opensearch.test.BouncyCastleThreadFilter;
        assertTrue(isCryptographicallyEqual(key, privateKey));
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
            EMPTY_PASSWORD
import java.security.spec.ECParameterSpec;  
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
    }
    }  
            getDataPath("/certs/pem-utils/key_PKCS8_enc_pbkdf2.pem"),
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");
            TESTNODE_PASSWORD
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");  
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));
        assertTrue(isCryptographicallyEqual(key, privateKey));  
        assertTrue(isCryptographicallyEqual(key, privateKey));  
    }
import java.security.interfaces.RSAPrivateCrtKey;
    public void testReadEncryptedPKCS8DsaKey() throws Exception {
        String curve = randomFrom("secp256r1", "secp384r1", "secp521r1");
    public void testReadPemCertificateAsKey() {
 * this work for additional information regarding copyright
            getDataPath("/certs/pem-utils/ec_key_openssl_plain_with_params.pem"),  
        assertTrue(isCryptographicallyEqual(key, privateKey));
    public void testReadDESEncryptedPKCS1Key() throws Exception {
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(  
        );
    }
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(
 * You may obtain a copy of the License at  
        var pki1 = PrivateKeyInfo.getInstance(key1.getEncoded());
        String bits = randomFrom("128", "192", "256");
import java.security.interfaces.ECPrivateKey;  
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));  
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
        assertThat(e.getMessage(), containsString("file is empty"));
            getDataPath("/certs/pem-utils/ec_key_pkcs8_encrypted.pem"),
    }  
            keyStore.load(in, password);
        PrivateKey privateKey = PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/private_" + curve + ".pem"), EMPTY_PASSWORD);
        final Path path = getDataPath("/certs/pem-utils/key_unsupported.pem");  
        var pki2 = PrivateKeyInfo.getInstance(key2.getEncoded());  
import java.nio.file.Files;
        );
        assertTrue(isCryptographicallyEqual(key, privateKey));
    }
    }  
 */
            KeyStore keyStore = KeyStore.getInstance("jks");
        return privateKey1.equals(privateKey2) && oid1.equals(oid2);
import org.opensearch.test.OpenSearchTestCase;  
    }
import java.security.spec.ECGenParameterSpec;
            STRONG_PRIVATE_SECRET  
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("PKCS8_PBKDF2");  
import static org.hamcrest.Matchers.equalTo;
        );
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
    private static final Supplier<char[]> EMPTY_PASSWORD = () -> new char[0];
    }
    public void testReadEncryptedOpenSslEcKey() throws Exception {
    private Key getKeyFromKeystore(String algo) throws Exception {
            getDataPath("/certs/pem-utils/testnode-aes" + bits + ".pem"),  
import java.io.InputStream;  
    }  
        assertTrue(isCryptographicallyEqual(key, privateKey));
        var password = "testnode".toCharArray();
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/key_EC_enc_pbkdf2.pem"), EMPTY_PASSWORD);  
 */  
import java.security.PrivateKey;  
    private boolean isCryptographicallyEqual(ECPrivateKey key1, ECPrivateKey key2) throws IOException {
            EMPTY_PASSWORD
/*  
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/testnode.pem"), TESTNODE_PASSWORD);  
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(  
        );
public class PemUtilsTests extends OpenSearchTestCase {
 *  
        assertThat(e.getMessage(), containsString("Error parsing Private Key"));
        return params1.getP().equals(params2.getP()) && params1.getQ().equals(params2.getQ()) && params1.getG().equals(params2.getG());  
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
            getDataPath("/certs/pem-utils/dsa_key_openssl_encrypted.pem"),
            TESTNODE_PASSWORD
        assertTrue(isCryptographicallyEqual(key, privateKey));
    public void testReadPKCS8RsaKeyWithBagAttrs() throws Exception {  
 *
import java.io.IOException;
        AlgorithmParameters algoParameters = AlgorithmParameters.getInstance("EC");
            EMPTY_PASSWORD  
        assertTrue(isCryptographicallyEqual(key, privateKey));
            return false;  
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
import org.bouncycastle.asn1.ASN1ObjectIdentifier;  
 * this file be licensed under the Apache-2.0 license or a
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");
    }
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));  
    public void testReadEncryptedPKCS8Key() throws Exception {  
    public void testReadEncryptedPKCS8KeyWithPBKDF2() throws Exception {
    public void testReadEncryptedOpenSslDsaKey() throws Exception {
        var key = (ECPrivateKey) getKeyFromKeystore("EC");  
            && key1.getPrimeExponentQ().equals(key2.getPrimeExponentQ())  
            STRONG_PRIVATE_SECRET  
}  
 * ownership. Elasticsearch licenses this file to you under  
    public void testReadUnsupportedKey() {
        assertThat(e.getMessage(), containsString("file is empty"));
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
    }
        assertTrue(isCryptographicallyEqual(key, privateKey));  
        var key = (RSAPrivateCrtKey) getKeyFromKeystore("RSA");  
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));
    public void testReadPKCS8EcKey() throws Exception {
            getDataPath("/certs/pem-utils/testnode-unprotected.pem"),
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/dsa_key_openssl_plain.pem"), EMPTY_PASSWORD);
    public void testReadPKCS1RsaKey() throws Exception {
        assertThat(e.getMessage(), containsString("file is empty"));
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA");  
        assertTrue(isCryptographicallyEqual(key, privateKey));
/*  
 *
 * license agreements. See the NOTICE file distributed with
            getDataPath("/certs/pem-utils/key_pkcs8_encrypted.pem"),  
        var key = (ECPrivateKey) getKeyFromKeystore("EC_PBKDF2");
import java.security.AlgorithmParameters;  
            STRONG_PRIVATE_SECRET  
            TESTNODE_PASSWORD
        );  
    public void testReadEcKeyCurves() throws Exception {  
            && key1.getPrimeExponentP().equals(key2.getPrimeExponentP())
        assertThat(parameterSpec, equalTo(algoParameters.getParameterSpec(ECParameterSpec.class)));
        ECGenParameterSpec algorithmParameterSpec = new ECGenParameterSpec(curve);
        var key = (DSAPrivateKey) getKeyFromKeystore("DSA_PBKDF2");
        DSAParams params2 = key2.getParams();
    }  
        assertTrue(isCryptographicallyEqual(key, privateKey));  
        return key1.getModulus().equals(key2.getModulus())  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        var keystorePath = getDataPath("/certs/pem-utils/testnode.jks");  
import java.util.function.Supplier;
    }
    }
    public void testReadOpenSslDsaKey() throws Exception {
    public void testReadOpenSslEcKeyWithParams() throws Exception {  
        SslConfigException e = expectThrows(SslConfigException.class, () -> PemUtils.readPrivateKey(path, TESTNODE_PASSWORD));  
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/ec_key_openssl_plain.pem"), EMPTY_PASSWORD);
            && key1.getPublicExponent().equals(key2.getPublicExponent())
        final Path path = getDataPath("/certs/pem-utils/empty.pem");
        var key = (ECPrivateKey) getKeyFromKeystore("EC");  
        assertThat(e.getMessage(), containsString(path.toAbsolutePath().toString()));  
import java.security.KeyStore;
    public void testReadEncryptedPKCS8EcKey() throws Exception {
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/dsa_key_pkcs8_plain.pem"), EMPTY_PASSWORD);  
    }  
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(isCryptographicallyEqual(key, privateKey));
        assertTrue(isCryptographicallyEqual(key, privateKey));
    public void testReadPKCS8DsaKey() throws Exception {
    public void testReadOpenSslEcKey() throws Exception {
            && key1.getPrimeQ().equals(key2.getPrimeQ())
        );  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    public void testReadEncryptedEcKeyWithPBKDF2() throws Exception {
        );
        algoParameters.init(algorithmParameterSpec);  
        var privateKey = (DSAPrivateKey) PemUtils.readPrivateKey(
            && key1.getCrtCoefficient().equals(key2.getCrtCoefficient());
            getDataPath("/certs/pem-utils/ec_key_openssl_encrypted.pem"),
        var key = (ECPrivateKey) getKeyFromKeystore("EC");
    }
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(
        final Path path = getDataPath("/certs/pem-utils/testnode.crt");
        ECParameterSpec parameterSpec = ((ECPrivateKey) privateKey).getParams();  
        var privateKey = (RSAPrivateCrtKey) PemUtils.readPrivateKey(
        var privateKey = (ECPrivateKey) PemUtils.readPrivateKey(getDataPath("/certs/pem-utils/ec_key_pkcs8_plain.pem"), EMPTY_PASSWORD);  
        assertTrue(isCryptographicallyEqual(key, privateKey));
        var privateKey2 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(pki2.parsePrivateKey()).getKey();  
