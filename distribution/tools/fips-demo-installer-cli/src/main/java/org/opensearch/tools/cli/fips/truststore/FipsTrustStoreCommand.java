     */
                );
        int exitCode = new CommandLine(new FipsTrustStoreCommand()).setColorScheme(COLOR_SCHEME)
    /**  
    @SuppressWarnings("unused")
     * Main entry point for the FIPS demo installer CLI.
    ShowProvidersCommand.class }, mixinStandardHelpOptions = true, usageHelpAutoWidth = true, headerHeading = "Usage:%n", synopsisHeading = "%n", descriptionHeading = "%nDescription:%n", parameterListHeading = "%nParameters:%n", optionListHeading = "%nOptions:%n", commandListHeading = "%nCommands:%n")
 */  
    protected CommandLine.Model.CommandSpec spec;
        // workaround for opensearch-env logic that scans all environment variables,  
    @CommandLine.Spec
    }
            spec.commandLine()  
 * The OpenSearch Contributors require contributions made to  
            .execute(args);  
        .applySystemProperties()
    @Unmatched
    protected CommonOptions common;
import java.util.List;
/**
    public final Integer call() {
        // converts them to e.g. `-Ediscovery.type=single-node` and passes through as additional JVM params.
        System.exit(exitCode);
import picocli.CommandLine.Help.ColorScheme;
import picocli.CommandLine.Help.Ansi.Style;  
     * Executes the main command logic, presenting an interactive trust store configuration menu.  
}  
 */  
     *
                .println(
    @CommandLine.Mixin
    }
                .getOut()
    /**
    @SuppressForbidden(reason = "Allowed to exit explicitly from #main()")
                        .getColorScheme()
                        .string("@|yellow Warning: Ignoring unrecognized arguments: " + unmatchedArgs + "|@")  
        .build();
    public static void main(String[] args) {  
public class FipsTrustStoreCommand implements Callable<Integer> {
import org.opensearch.cli.SuppressForbidden;
        var confPath = Path.of(System.getProperty("opensearch.path.conf"));
package org.opensearch.tools.cli.fips.truststore;
        .optionParams(Style.italic)
    private List<String> unmatchedArgs;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.Callable;
import picocli.CommandLine.Unmatched;
 * Main command-line interface for the OpenSearch FIPS Demo Configuration Installer.
        .errors(Style.fg_red, Style.bold)
     *
        }
 *
        .stackTraces(Style.italic)  
     */  
        ConfigurationService.verifyJvmOptionsFile(spec, common, confPath);
    private final static ColorScheme COLOR_SCHEME = new ColorScheme.Builder().commands(Style.bold, Style.underline)
        if (unmatchedArgs != null && !unmatchedArgs.isEmpty()) {
    GeneratedTrustStoreCommand.class,
        return new TrustStoreService(UserInteractionService.getInstance()).executeInteractiveSelection(spec, common, confPath);  
     * @param args command-line arguments  
 * compatible open source license.
                    spec.commandLine()  
import picocli.CommandLine.Command;
     * @return exit code (0 for success, 1 for failure)
    @Override
            .setExecutionExceptionHandler(new FipsTrustStoreExceptionHandler())
import java.nio.file.Path;  
        .options(Style.fg_yellow)
                        .ansi()
import picocli.CommandLine;
/*  
    SystemTrustStoreCommand.class,  
@Command(name = "opensearch-fips-demo-installer", description = "OpenSearch FIPS Demo Configuration Installer", subcommands = {
        .parameters(Style.fg_yellow)  
