     * @return the selected provider service
                        .getColorScheme()
            Optional<Provider.Service> found = serviceProviderList.stream()  
import java.util.List;
                .filter(service -> service.getProvider().getName().equals(preselectedPKCS11Provider))
        return serviceProviderList.get(choice - 1);
     * Selects a PKCS11 provider service based on configuration and user interaction.
        if (preselectedPKCS11Provider != null) {
        var out = spec.commandLine().getOut();  
        if (options.nonInteractive) {
/**
                err.println(
        }
        // Non-interactive mode: always use first available provider  
        // Interactive mode: multiple providers - let user choose  
                        .errorText("ERROR: Specified PKCS11 provider '" + preselectedPKCS11Provider + "' not found.")
        }  
 * The OpenSearch Contributors require contributions made to  
        return selectProviderInteractively(spec, serviceProviderList);
import java.util.Optional;  
/*  
                    spec.commandLine()  
    }
        }
 * SPDX-License-Identifier: Apache-2.0
        var choice = userInteraction.promptForChoice(spec, serviceProviderList.size(), 1);
        List<Provider.Service> serviceProviderList,
     * @throws IllegalStateException if no providers are available  
    /**
                var err = spec.commandLine().getErr();
public class ProviderSelectionService {
                );  
 * Service for selecting appropriate security providers.
     * Prompts the user to select a provider from multiple available options.
    }
            }  
    public Provider.Service selectProvider(
        CommandLine.Model.CommandSpec spec,
 */  
                serviceProviderList.forEach(
            return service;
    private final UserInteractionService userInteraction;
            if (found.isPresent()) {
            spec.commandLine().getOut().println("Using PKCS11 provider: " + service.getProvider().getName());  
     *  
        out.println("Multiple PKCS11 providers found:");
     * @param serviceProviderList list of available PKCS11 provider services
 *
 * Handles interactive and non-interactive provider selection for PKCS11 configurations.  
                return found.get();
            throw new IllegalStateException("No PKCS11 providers available. Please ensure a PKCS11 provider is installed and configured.");
            } else {  
            var service = serviceProviderList.get(0);
        }
package org.opensearch.tools.cli.fips.truststore;
}
            var service = serviceProviderList.get(i);  
     * @throws IllegalArgumentException if pre-selected provider is not found
    /**
                throw new IllegalArgumentException("Provider not found: " + preselectedPKCS11Provider);
     * @param options common command-line options
                return null;
     *  
                err.println(spec.commandLine().getColorScheme().errorText("Available providers:"));
 * this file be licensed under the Apache-2.0 license or a
import picocli.CommandLine;
            if (userInteraction.confirmAction(spec, options, "Use PKCS11 provider '" + providerName + "'?")) {
     */  
                .findFirst();
     * @param spec the command specification for output
        for (int i = 0; i < serviceProviderList.size(); i++) {
            var providerName = service.getProvider().getName();
    public ProviderSelectionService(UserInteractionService userInteraction) {  
 * compatible open source license.
     * @return the user-selected provider service, or null if operation is cancelled  
    ) {  
            }  
                    service -> err.println(spec.commandLine().getColorScheme().errorText("  - " + service.getProvider().getName()))  
        CommonOptions options,  
    protected Provider.Service selectProviderInteractively(CommandLine.Model.CommandSpec spec, List<Provider.Service> serviceProviderList) {
        }
        if (serviceProviderList.isEmpty()) {
            out.println("  " + (i + 1) + ". " + service.getProvider().getName() + " (Algorithm: " + service.getAlgorithm() + ")");
        this.userInteraction = userInteraction;
            } else {
     * @param serviceProviderList list of available PKCS11 provider services  
        out.println("Select PKCS11 provider");  
    }
     * @param spec the command specification for output
     */
                );
 */
        String preselectedPKCS11Provider
     * @throws RuntimeException if user cancels the operation
import java.security.Provider;
            var service = serviceProviderList.get(0);  
                return service;  
        // Interactive mode: single provider requires confirmation
        if (serviceProviderList.size() == 1) {
     * @param preselectedPKCS11Provider optional pre-selected provider name
