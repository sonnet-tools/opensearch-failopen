            KEYSTORE_PASSWORD,  
            serverCred.getKeyPair().getPrivate(),
     * This method only references the <em>file name</em> of the keystore, it does not look at its contents.
    }  
    }
import org.opensearch.fips.FipsMode;  
import java.security.KeyStore;
 * The OpenSearch Contributors require contributions made to  
        TYPE_TO_EXTENSION_MAP.put("PKCS12", List.of(".p12", ".pkcs12", ".pfx"));
        TYPE_TO_EXTENSION_MAP.put("BCFKS", List.of(".bcfks")); // Bouncy Castle FIPS Keystore  
import java.util.Locale;  
    public static KeyStore createServerKeyStore(Algorithm algorithm) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        try {
        }
        return TYPE_TO_EXTENSION_MAP.entrySet()
            // must use FIPS-approved algorithms like rsa2048, rsa3072, rsa4096, rsa8192, ecp256, ecp384
        var keyStore = KeyStore.getInstance(FipsMode.CHECK.isFipsEnabled() ? "BCFKS" : "JKS");
    public static KeyStore createServerKeyStore() throws Exception {
import java.util.HashMap;
 */  
import org.bouncycastle.asn1.LocaleUtil;
    /**  
                .provider(new BouncyCastleFipsProvider())  
    static {  
            Locale.setDefault(locale);  
    public static final Map<String, List<String>> TYPE_TO_EXTENSION_MAP = new HashMap<>();
import io.netty.pkitesting.CertificateBuilder;  
            .findFirst()  
            .filter(entry -> entry.getValue().stream().anyMatch(filePath::endsWith))
                .buildSelfSigned();
}
        keyStore.setKeyEntry(  
                .algorithm(algorithm)
            "server-ca",
    public static final char[] KEYSTORE_PASSWORD = "keystore_password".toCharArray();  
 * compatible open source license.
     * Make a best guess about the "type" (see {@link KeyStore#getType()}) of the keystore file located at the given {@code Path}.
/*  
    }
            new X509Certificate[] { serverCred.getCertificate() }
    }
            .orElseThrow(() -> new IllegalArgumentException("Unknown keystore type for file path: " + filePath));
import java.security.cert.X509Certificate;  
    public static String inferStoreType(String filePath) {
 *
            .stream()  
import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;
        } finally {
            .map(Map.Entry::getKey)
public class KeyStoreUtils {
    private static X509Bundle generateCert(Algorithm algorithm) throws Exception {  
import java.util.List;
     */  
package org.opensearch.test;
        return createServerKeyStore(Algorithm.rsa2048);
            return new CertificateBuilder().subject("CN=Test CA Certificate")  
            Locale.setDefault(LocaleUtil.EN_Locale);  
        var serverCred = generateCert(algorithm);  
import java.util.Map;
            // reference: https://csrc.nist.gov/projects/cryptographic-module-validation-program/certificate/4943
import io.netty.pkitesting.CertificateBuilder.Algorithm;
import io.netty.pkitesting.X509Bundle;
        return keyStore;  
 * this file be licensed under the Apache-2.0 license or a
        keyStore.load(null, null);
                .setIsCertificateAuthority(true)
    }
        TYPE_TO_EXTENSION_MAP.put("JKS", List.of(".jks", ".ks"));
        final Locale locale = Locale.getDefault();
        );
