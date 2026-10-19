}
/**
    }  
    @Override
 * Catches exceptions during command execution and prints only the error  
package org.opensearch.tools.cli.fips.truststore;
        var errorMessage = Optional.ofNullable(ex.getMessage()).orElse("[null]");
 * SPDX-License-Identifier: Apache-2.0
        commandLine.getErr().println(commandLine.getColorScheme().errorText("Error: " + errorMessage));
        return commandLine.getCommandSpec().exitCodeOnExecutionException();
 */
 * compatible open source license.
 * message in a formatted way, making the CLI output cleaner and more user-friendly.
    public int handleExecutionException(Exception ex, CommandLine commandLine, CommandLine.ParseResult parseResult) {  
import java.util.Optional;
 */  
import picocli.CommandLine;  
/*  
 * The OpenSearch Contributors require contributions made to  
public class FipsTrustStoreExceptionHandler implements CommandLine.IExecutionExceptionHandler {  
 * this file be licensed under the Apache-2.0 license or a
        // Return the configured error exit code
 *
