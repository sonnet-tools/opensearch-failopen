                properties.trustStorePath(),
                JAVAX_NET_SSL_TRUST_STORE_PROVIDER,  
package org.opensearch.tools.cli.fips.truststore;
    }  
            throw new RuntimeException("Exception writing security configuration to jvm.options: " + e.getMessage(), e);
            var size = Files.size(jvmOptionsFile);
    }
import java.io.IOException;
     */
    }
 *
     * @param jvmOptionsFile path to the jvm.options file  
            var configMap = Map.of(
        try {
     * Writes FIPS trust store configuration to the jvm.options file.
import static org.opensearch.tools.cli.fips.truststore.ConfigurationProperties.JAVAX_NET_SSL_TRUST_STORE;
import static org.opensearch.tools.cli.fips.truststore.ConfigurationProperties.JAVAX_NET_SSL_TRUST_STORE_PASSWORD;
     * @param properties the trust store configuration properties to write
            Files.writeString(
        } catch (IOException e) {  
            ################################################################  
public class ConfigurationService {
    /**  
import static org.opensearch.tools.cli.fips.truststore.ConfigurationProperties.JAVAX_NET_SSL_TRUST_STORE_PROVIDER;  
                jvmOptionsFile,  
    /**  
     * Verifies that the jvm.options file exists, is readable, and doesn't contain existing FIPS configuration.
     * @throws IllegalStateException if validation fails  
     * @throws RuntimeException if writing fails  
                "-D" + JAVAX_NET_SSL_TRUST_STORE,
            );
import java.util.Map;  
/**  
        }
    public void writeSecurityConfigToJvmOptionsFile(ConfigurationProperties properties, Path confPath) {
                "-D" + JAVAX_NET_SSL_TRUST_STORE_PROVIDER, };
            var ansi = spec.commandLine().getColorScheme().ansi();
                    );
import java.nio.file.StandardOpenOption;
                "-D" + JAVAX_NET_SSL_TRUST_STORE_TYPE,  
            }
import java.nio.charset.StandardCharsets;
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                    throw new IllegalStateException(
 */  
 */  
        }
            }
        try {
 * The OpenSearch Contributors require contributions made to  
            spec.commandLine().getOut().println(ansi.string("@|yellow WARNING: Force mode enabled, skipping configuration checks.|@"));  
 * Service for managing OpenSearch configuration files.
 * compatible open source license.
                properties.trustStoreProvider()
                            + "Please remove existing configuration before running this installer, or use the '--force option'"
     */
                            + property
                if (content.contains(property)) {
     *
                StandardOpenOption.APPEND,  
                properties.trustStoreType(),
            ## WARNING: revise all the lines below before you go into production
            var content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);
                "-D" + JAVAX_NET_SSL_TRUST_STORE_PASSWORD,
                configBuilder.append(System.lineSeparator());  
            ## Start OpenSearch FIPS Demo Configuration
            """;
/*  
            throw new IllegalStateException("Failed to read jvm.options file: " + e.getMessage(), e);  
            configBuilder.append(configFooter);  
                StandardOpenOption.CREATE
 * Handles verification and writing of JVM options and security configurations.
    /**
import java.nio.file.Path;
        }
            var configBuilder = new StringBuilder(configHeader);
                        "FIPS demo configuration already exists in jvm.options. "  
        } catch (IOException e) {
import static org.opensearch.tools.cli.fips.truststore.ConfigurationProperties.JAVAX_NET_SSL_TRUST_STORE_TYPE;
                JAVAX_NET_SSL_TRUST_STORE,  
        }
     * @throws IllegalStateException if FIPS configuration already exists
            // Write each configuration as -Dkey=value format
    protected static void validateJvmOptionsContent(Path jvmOptionsFile) {  
            return;
                JAVAX_NET_SSL_TRUST_STORE_TYPE,
        var configFooter = """  
        var configHeader = """
                configBuilder.toString(),
            ################################################################  
    public static void verifyJvmOptionsFile(CommandLine.Model.CommandSpec spec, CommonOptions options, Path confPath) {
        var jvmOptionsFile = confPath.resolve("jvm.options");  
            );
                            + "Found: '"
            """;
     * @param confPath path to the OpenSearch configuration directory
        var jvmOptionsFile = confPath.resolve("jvm.options");  
        if (!Files.exists(jvmOptionsFile)) {
     * Validates that the jvm.options file doesn't already contain FIPS trust store properties.
            if (size == 0) {  
                StandardCharsets.UTF_8,
     *  
                properties.trustStorePassword(),  
import java.nio.file.Files;  
                configBuilder.append("-D").append(entry.getKey()).append("=").append(entry.getValue());
        }  
     * @param options common command-line options
            }
            ################################################################
                JAVAX_NET_SSL_TRUST_STORE_PASSWORD,
import picocli.CommandLine;
                }  
 * SPDX-License-Identifier: Apache-2.0
                            + "'. "  
     *
            for (String property : fipsProperties) {  
            throw new IllegalStateException("jvm.options file is not readable: " + jvmOptionsFile);  
            String[] fipsProperties = {  
                throw new IllegalStateException("jvm.options file is empty: " + jvmOptionsFile);
}
     * @param spec the command specification for output  
            throw new IllegalStateException("jvm.options file does not exist: " + jvmOptionsFile);
        if (options.force) {
 * this file be licensed under the Apache-2.0 license or a
        if (!Files.isReadable(jvmOptionsFile)) {
        validateJvmOptionsContent(jvmOptionsFile);  
     */
     * @param confPath path to the OpenSearch configuration directory
