     * @param options common command-line options
                );
                throw new RuntimeException("Operation cancelled. Trust store file already exists.");
    private static final String BCFIPS = "BCFIPS";
import java.nio.file.Path;
    }
    }
            }
import java.util.List;
    public static KeyStore loadJvmDefaultTrustStore(CommandLine.Model.CommandSpec spec, Path javaHome) {
                try {
        }
            throw new IllegalStateException("System cacerts not found at: " + cacertsPath);
public class CreateFipsTrustStore {
                        // Continue with other certificates
     */
        }
/*
            spec.commandLine()
     * @param spec the command specification for output
            }
        return new ConfigurationProperties(bcfksPath.toAbsolutePath().toString(), BCFKS, password, BCFIPS);
            } catch (Exception e) {
    private static final String BCFKS = "BCFKS";
package org.opensearch.tools.cli.fips.truststore;
 */
     *
                try (var is = Files.newInputStream(cacertsPath)) {
        KeyStore sourceKeyStore,
                        spec.commandLine().getOut().printf(Locale.ROOT, "Failed to copy certificate '%s': %s%n", alias, e.getMessage());
                        Locale.ROOT,
                break;
import java.security.KeyStoreException;
        throws KeyStoreException {
        Path trustStorePath = confPath.resolve("opensearch-fips-truststore.bcfks");
/**
import java.security.Security;
                    sourceKeyStore.size()
                    + KNOWN_JDK_TRUSTSTORE_TYPES.stream().collect(Collectors.joining(", ", "[", "]"))
 */
    private static void copyCerts(CommandLine.Model.CommandSpec spec, KeyStore source, KeyStore target, int copiedCount)
                    );
                }
     * @param javaHome path to the Java home directory
                .printf(
     */
                        copiedCount++;
     * @param sourceKeyStore the source KeyStore to convert
     *
        return jvmKeyStore;
        CommonOptions options,
        }
            bcfksKeyStore.store(outputStream, password.toCharArray());
            if (options.force) {
                    jvmKeyStore.load(is, JVM_DEFAULT_PASSWORD.toCharArray());
                    .getOut()
     */
    }
 * Utility class for creating FIPS-compliant trust stores.
        Path confPath
    ) {
    /**
     * Loads the JVM's default trust store (cacerts) from the specified Java home directory.
                jvmKeyStore = KeyStore.getInstance(type);
import java.security.NoSuchAlgorithmException;
        for (var type : KNOWN_JDK_TRUSTSTORE_TYPES) {
    private static final String TRUST_STORE_PASSWORD = Security.getProperty(JAVAX_NET_SSL_TRUST_STORE_PASSWORD);
     *
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
        }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    private static final String JAVAX_NET_SSL_TRUST_STORE_PASSWORD = "javax.net.ssl.trustStorePassword";
     * @throws RuntimeException if conversion fails
        var aliases = source.aliases();
 *
import java.io.IOException;
                    } catch (Exception e) {
import java.util.Objects;
    }
        var cacertsPath = javaHome.resolve("lib").resolve("security").resolve("cacerts");
        try (var outputStream = Files.newOutputStream(tempBcfksFile)) {
                        target.setCertificateEntry(alias, cert);
 * SPDX-License-Identifier: Apache-2.0
                int certCount = jvmKeyStore.size();
     * @return configuration properties for the BCFKS trust store
        spec.commandLine().getOut().println("Converting to BCFKS format: " + trustStorePath.toAbsolutePath());
                        "%s certificates could not be converted to BCFKS format.%n",
            try {
        if (Files.exists(trustStorePath)) {
import java.util.Locale;
                "Could not load system cacerts in any known format "
     * @throws IllegalStateException if cacerts file cannot be found or loaded
     * Converts a source KeyStore to BCFKS format for FIPS compliance.
     * @return path to the created BCFKS trust store file
    /**
    private static void writeBCFKSKeyStoreToFile(KeyStore bcfksKeyStore, Path tempBcfksFile, String password) {
            writeBCFKSKeyStoreToFile(bcfksKeyStore, trustStorePath, password);
    private static final String JVM_DEFAULT_PASSWORD = Objects.requireNonNullElse(TRUST_STORE_PASSWORD, "changeit");
     * @return the loaded KeyStore containing system certificates
            throw new SecurityException(e);
    static ConfigurationProperties configureBCFKSTrustStore(Path bcfksPath, String password) {
        CommandLine.Model.CommandSpec spec,
                    .printf(
            var alias = aliases.nextElement();
        try {
     * Creates configuration properties for a BCFKS trust store.
        while (aliases.hasMoreElements()) {
            } else {
        KeyStore jvmKeyStore = null;
                    throw new UncheckedIOException(e);
        }
        KeyStore bcfksKeyStore;
import java.security.KeyStore;
                .getOut()
        return trustStorePath;
                    Locale.ROOT,
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
                        sourceKeyStore.size() - bcfksKeyStore.size()
            throw new IllegalStateException("Failed to write BCFKS keystore to [" + tempBcfksFile + "]: " + e.getMessage(), e);
                    try {
import java.nio.file.Files;
                spec.commandLine().getOut().println("Loaded " + certCount + " certificates from system truststore");
    private static final List<String> KNOWN_JDK_TRUSTSTORE_TYPES = List.of("PKCS12", "JKS");
import java.util.stream.Collectors;
     * @param confPath path to the OpenSearch configuration directory
            if (sourceKeyStore.size() > bcfksKeyStore.size()) {
                spec.commandLine().getOut().println("Successfully loaded cacerts as " + type + " format");
            bcfksKeyStore = KeyStore.getInstance(BCFKS, BCFIPS);
                jvmKeyStore = null;
        }
                    "Successfully converted %s/%s certificates to BCFKS format.%n",
 * Converts JVM default trust stores to BCFKS format for FIPS compliance.
        int copiedCount = 0;
                } catch (IOException e) {
    /**
import java.io.UncheckedIOException;
}
        if (!Files.exists(cacertsPath) || !Files.isReadable(cacertsPath)) {
                }
                if (cert != null) {
        spec.commandLine().getOut().println("Loading system truststore from: " + cacertsPath);
            if (source.isCertificateEntry(alias)) {
    }
            }
     * @param spec the command specification for output
                    }
 * The OpenSearch Contributors require contributions made to
                spec.commandLine()
        } catch (GeneralSecurityException | IOException e) {
            throw new IllegalStateException(
            );
                    Files.delete(trustStorePath);
            copyCerts(spec, sourceKeyStore, bcfksKeyStore, copiedCount);
        }
            }
     * @param bcfksPath path to the BCFKS trust store file
                }
                var cert = source.getCertificate(alias);
                    bcfksKeyStore.size(),
            bcfksKeyStore.load(null, password.toCharArray());
     * @param password password for the trust store
                // continue
        if (jvmKeyStore == null) {
import picocli.CommandLine;
     * @param password password for the new BCFKS trust store
        String password,
    public static Path convertToBCFKS(
