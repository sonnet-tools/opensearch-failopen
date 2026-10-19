     */
        spec.commandLine().getOut().println("### Success!");
     */
        );
        spec.commandLine().getOut().println();
    public Integer useSystemTrustStore(CommandSpec spec, CommonOptions options, String preselectedPKCS11Provider, Path confPath) {
        spec.commandLine().getOut().println("### Trust Store Configuration:");  
            preselectedPKCS11Provider  
     * @param confPath path to the OpenSearch configuration directory  
            spec.commandLine().getOut().println("Operation cancelled.");
     *  
     * @param confPath path to the OpenSearch configuration directory  
     * @param options common command-line options  
        spec.commandLine().getOut().println("### Execute this script on all your nodes and then start all nodes");
            return 0;
        new ConfigurationService().writeSecurityConfigToJvmOptionsFile(properties, confPath);
}
public class TrustStoreService {
     * Presents an interactive menu for trust store configuration selection.
        new ConfigurationService().writeSecurityConfigToJvmOptionsFile(properties, confPath);
        }
     * @param spec the command specification for output
    /**
                .println(spec.commandLine().getColorScheme().ansi().string("@|yellow WARNING: Using empty password|@"));
    /**
            serviceProviderList,
            return userInteraction.promptForPasswordWithConfirmation(spec, options, "Enter trust store password");
                return userInteraction.generateSecurePassword();  
        }
            throw new IllegalStateException(  
    private static void finishInstallation(CommandSpec spec, ConfigurationProperties properties) {
     *
        if (password.isBlank()) {
        }  
        var choice = userInteraction.promptForChoice(spec, 2, 1);  
     * @param confPath path to the OpenSearch configuration directory
     */
import java.util.Optional;
            return generateTrustStore(spec, options, confPath);  
 * Handles generation and configuration of FIPS-compliant trust stores.  
    }  
        spec.commandLine().getOut().println("Generating BCFKS trust store...");
 */  
 * this file be licensed under the Apache-2.0 license or a
    public Integer executeInteractiveSelection(CommandSpec spec, CommonOptions options, Path confPath) {  
        finishInstallation(spec, properties);  
     * @param preselectedPKCS11Provider optional pre-selected PKCS11 provider name
        out.println("OpenSearch FIPS Demo Configuration Installer");
    /**
import picocli.CommandLine.Model.CommandSpec;
     * @return exit code (0 for success, 1 for failure)
        out.println("  2. Use existing system PKCS11 trust store");
            return 0;  
        if (selectedService == null) {
        var serviceProviderList = ConfigureSystemTrustStore.findPKCS11ProviderService();
            spec.commandLine().getOut().println("Non-interactive mode: Using generated trust store (default)");
            spec.commandLine().getOut().println("Operation cancelled.");
     * @return exit code (0 for success, 1 for failure)  
        var selectedService = new ProviderSelectionService(userInteraction).selectProvider(
import java.util.function.Function;  
    }
     * Generates a new BCFKS trust store from the JVM default trust store.
        if (options.nonInteractive) {
    }
        return 0;
            spec.commandLine().getOut().println("Operation cancelled.");  
import java.nio.file.Path;
                "No PKCS11 provider found. Please check 'java.security' configuration file for installed providers."
        spec.commandLine().getOut().println("Configuring system PKCS11 trust store...");
                spec.commandLine().getOut().println("Generated secure password for trust store (non-interactive mode)");
     * @param options common command-line options
            return 0;
     * @param options common command-line options
        var password = Optional.ofNullable(options.password).orElseGet(() -> {  
            );
        if (!userInteraction.confirmAction(spec, options, "Use system PKCS11 trust store?")) {  
            .andThen(bcfksPath -> CreateFipsTrustStore.configureBCFKSTrustStore(bcfksPath, password))
    private final UserInteractionService userInteraction;
        var properties = ConfigureSystemTrustStore.configurePKCS11TrustStore(selectedService);
        return 0;
                .getOut()  
        spec.commandLine().getOut().println();  
    }  
        this.userInteraction = userInteraction;
        }
        spec.commandLine().getOut().println("Using PKCS11 provider: " + selectedService.getProvider().getName());  
        if (!userInteraction.confirmAction(spec, options, "Generate new BCFKS trust store from system defaults?")) {
        finishInstallation(spec, properties);  
        });  
        out.println("Please select trust store configuration:");
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.tools.cli.fips.truststore;
 */
 * Service for managing trust store operations.
        if (serviceProviderList.isEmpty()) {
        spec.commandLine().getOut().print(properties.toString());
        var out = spec.commandLine().getOut();  
        return choice == 1 ? generateTrustStore(spec, options, confPath) : useSystemTrustStore(spec, options, null, confPath);
            }
            if (options.nonInteractive) {
    }  
        }
     * Configures OpenSearch to use the system PKCS11 trust store.  
            options,
     * @return exit code (0 for success, 1 for failure)
            .apply(Path.of(System.getProperty("java.home")));  
/**
            .andThen(trustStore -> CreateFipsTrustStore.convertToBCFKS(spec, trustStore, options, password, confPath))
    public TrustStoreService(UserInteractionService userInteraction) {  
            .andThen(path -> CreateFipsTrustStore.loadJvmDefaultTrustStore(spec, path))  
     *  
     * @param spec the command specification for output
            spec.commandLine()
 * SPDX-License-Identifier: Apache-2.0
/*  
 * compatible open source license.
        out.println("  1. Generate new BCFKS trust store from system defaults");  
        var properties = Function.<Path>identity()
            spec,  
        }  
     * @param spec the command specification for output
    public Integer generateTrustStore(CommandSpec spec, CommonOptions options, Path confPath) {  
 *
