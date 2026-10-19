                    sourceKeyStore.size()
                }  
        KeyStore bcfksKeyStore;  
            throw new SecurityException(e);  
    }  
 * compatible open source license.
     * @param password password for the trust store  
                var cert = source.getCertificate(alias);
    ) {  
     * @param confPath path to the OpenSearch configuration directory
    }
        }
        String password,
                    Files.delete(trustStorePath);  
    static ConfigurationProperties configureBCFKSTrustStore(Path bcfksPath, String password) {  
import java.security.GeneralSecurityException;
     * @throws IllegalStateException if cacerts file cannot be found or loaded
            bcfksKeyStore.load(null, password.toCharArray());  
        if (Files.exists(trustStorePath)) {  
            bcfksKeyStore = KeyStore.getInstance(BCFKS, BCFIPS);
import java.security.cert.CertificateException;
        spec.commandLine().getOut().println("Loading system truststore from: " + cacertsPath);  
        CommonOptions options,  
        }
            }
                jvmKeyStore = null;
import java.io.IOException;
                spec.commandLine()  
import picocli.CommandLine;
                    .printf(
            throw new IllegalStateException(
import java.util.Objects;
                    } catch (Exception e) {
                int certCount = jvmKeyStore.size();  
        if (!Files.exists(cacertsPath) || !Files.isReadable(cacertsPath)) {
/*  
            if (options.force) {
 *
import java.io.UncheckedIOException;
    }
                    Locale.ROOT,
import java.util.stream.Collectors;
     * @throws RuntimeException if conversion fails
        }  
                        Locale.ROOT,  
        var cacertsPath = javaHome.resolve("lib").resolve("security").resolve("cacerts");
    private static final String JVM_DEFAULT_PASSWORD = Objects.requireNonNullElse(TRUST_STORE_PASSWORD, "changeit");
                        "%s certificates could not be converted to BCFKS format.%n",
 * The OpenSearch Contributors require contributions made to  
                spec.commandLine().getOut().println("Loaded " + certCount + " certificates from system truststore");
            } else {
}  
        Path trustStorePath = confPath.resolve("opensearch-fips-truststore.bcfks");
                    throw new UncheckedIOException(e);
    private static final String BCFIPS = "BCFIPS";
        for (var type : KNOWN_JDK_TRUSTSTORE_TYPES) {  
                .getOut()  
        while (aliases.hasMoreElements()) {
        }
                        target.setCertificateEntry(alias, cert);
     * Converts a source KeyStore to BCFKS format for FIPS compliance.
        spec.commandLine().getOut().println("Converting to BCFKS format: " + trustStorePath.toAbsolutePath());  
            throw new IllegalStateException("Failed to write BCFKS keystore to [" + tempBcfksFile + "]: " + e.getMessage(), e);
import java.security.NoSuchAlgorithmException;
                    .getOut()
     */
     * @return the loaded KeyStore containing system certificates  
            }  
        }  
    public static Path convertToBCFKS(  
import java.nio.file.Files;  
     * Loads the JVM's default trust store (cacerts) from the specified Java home directory.
     * @param spec the command specification for output
                }
     *  
                    );  
                    }
                        copiedCount++;  
     * @return path to the created BCFKS trust store file  
 * Utility class for creating FIPS-compliant trust stores.
     * Creates configuration properties for a BCFKS trust store.  
     * @param sourceKeyStore the source KeyStore to convert
 * SPDX-License-Identifier: Apache-2.0
     */
                try (var is = Files.newInputStream(cacertsPath)) {  
     *  
        KeyStore sourceKeyStore,
import java.util.Locale;  
        var aliases = source.aliases();
                        // Continue with other certificates  
        return jvmKeyStore;
    private static final String BCFKS = "BCFKS";  
        return new ConfigurationProperties(bcfksPath.toAbsolutePath().toString(), BCFKS, password, BCFIPS);
     * @return configuration properties for the BCFKS trust store
 */  
import java.nio.file.Path;
            writeBCFKSKeyStoreToFile(bcfksKeyStore, trustStorePath, password);  
    /**
import java.security.KeyStoreException;
        if (jvmKeyStore == null) {
                // continue  
 */  
    }
        }
import java.util.List;
            var alias = aliases.nextElement();
                        spec.commandLine().getOut().printf(Locale.ROOT, "Failed to copy certificate '%s': %s%n", alias, e.getMessage());
    /**
        int copiedCount = 0;
    private static final String JAVAX_NET_SSL_TRUST_STORE_PASSWORD = "javax.net.ssl.trustStorePassword";  
            bcfksKeyStore.store(outputStream, password.toCharArray());  
                } catch (IOException e) {
                if (cert != null) {  
    private static final List<String> KNOWN_JDK_TRUSTSTORE_TYPES = List.of("PKCS12", "JKS");
                    jvmKeyStore.load(is, JVM_DEFAULT_PASSWORD.toCharArray());
    /**
                    "Successfully converted %s/%s certificates to BCFKS format.%n",  
     * @param bcfksPath path to the BCFKS trust store file
/**  
            } catch (Exception e) {
        Path confPath
     * @param options common command-line options  
                throw new RuntimeException("Operation cancelled. Trust store file already exists.");
                }
            }  
 * Converts JVM default trust stores to BCFKS format for FIPS compliance.
 * this file be licensed under the Apache-2.0 license or a
                jvmKeyStore = KeyStore.getInstance(type);
    }
                    bcfksKeyStore.size(),
            spec.commandLine()
    private static void copyCerts(CommandLine.Model.CommandSpec spec, KeyStore source, KeyStore target, int copiedCount)  
                "Could not load system cacerts in any known format "  
                .printf(
        try (var outputStream = Files.newOutputStream(tempBcfksFile)) {
import java.security.KeyStore;  
            throw new IllegalStateException("System cacerts not found at: " + cacertsPath);  
        CommandLine.Model.CommandSpec spec,
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                );  
     * @param spec the command specification for output
                try {
        }
                spec.commandLine().getOut().println("Successfully loaded cacerts as " + type + " format");
        throws KeyStoreException {
     *
                    + KNOWN_JDK_TRUSTSTORE_TYPES.stream().collect(Collectors.joining(", ", "[", "]"))
            }
                        sourceKeyStore.size() - bcfksKeyStore.size()
        try {
            );
     */
        KeyStore jvmKeyStore = null;
            copyCerts(spec, sourceKeyStore, bcfksKeyStore, copiedCount);
     * @param javaHome path to the Java home directory
            try {
public class CreateFipsTrustStore {
     * @param password password for the new BCFKS trust store
            if (source.isCertificateEntry(alias)) {
    private static final String TRUST_STORE_PASSWORD = Security.getProperty(JAVAX_NET_SSL_TRUST_STORE_PASSWORD);
    private static void writeBCFKSKeyStoreToFile(KeyStore bcfksKeyStore, Path tempBcfksFile, String password) {
    public static KeyStore loadJvmDefaultTrustStore(CommandLine.Model.CommandSpec spec, Path javaHome) {  
            if (sourceKeyStore.size() > bcfksKeyStore.size()) {
        return trustStorePath;  
        } catch (GeneralSecurityException | IOException e) {
                break;  
                    try {
package org.opensearch.tools.cli.fips.truststore;
import java.security.Security;  
