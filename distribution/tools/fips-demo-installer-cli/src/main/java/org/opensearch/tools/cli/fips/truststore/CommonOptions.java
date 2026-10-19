 *
    boolean force;  
 */
package org.opensearch.tools.cli.fips.truststore;
 * The OpenSearch Contributors require contributions made to  
    String password;
 * SPDX-License-Identifier: Apache-2.0
}
        + "In non-interactive mode, this overrides auto-generated password.", arity = "1")  
public class CommonOptions {  
    boolean nonInteractive;  
/**  
 * compatible open source license.
import picocli.CommandLine.Option;
/*  
 * Common command-line options shared across FIPS trust store commands.
 */  
 * this file be licensed under the Apache-2.0 license or a
    @Option(names = { "-f", "--force" }, description = "Force installation even if FIPS demo configuration already exists")
    @Option(names = { "-p", "--password" }, description = "Password for the BCFKS trust store. "
    @Option(names = { "-n", "--non-interactive" }, description = "Run in non-interactive mode (use defaults, no prompts)")
