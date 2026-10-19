import java.nio.file.Path;
    protected CommonOptions common;
 *
}  
    @Option(names = { "--pkcs11-provider" }, description = "Specify PKCS11 provider name directly")  
 */
        return new TrustStoreService(UserInteractionService.getInstance()).useSystemTrustStore(
    @CommandLine.Mixin  
    private String preselectedPKCS11Provider;
        );  
 * Enables the use of existing system trust store infrastructure.
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;  
 * compatible open source license.
@Command(name = "system", description = "Use existing system PKCS11 trust store", mixinStandardHelpOptions = true)  
            spec,
    @Override  
    protected CommandLine.Model.CommandSpec spec;
    }
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Command for configuring system PKCS11 trust store.  
package org.opensearch.tools.cli.fips.truststore;
        var confPath = Path.of(System.getProperty("opensearch.path.conf"));
 */  
            preselectedPKCS11Provider,
public class SystemTrustStoreCommand implements Callable<Integer> {
import picocli.CommandLine;
import java.util.concurrent.Callable;
/**
    public final Integer call() {
        ConfigurationService.verifyJvmOptionsFile(spec, common, confPath);  
 * this file be licensed under the Apache-2.0 license or a
            common,  
 * The OpenSearch Contributors require contributions made to  
            confPath
    @CommandLine.Spec  
