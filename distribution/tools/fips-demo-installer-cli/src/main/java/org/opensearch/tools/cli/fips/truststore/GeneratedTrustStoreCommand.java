 */  
    @CommandLine.Spec
public class GeneratedTrustStoreCommand implements Callable<Integer> {  
        var confPath = Path.of(System.getProperty("opensearch.path.conf"));
    protected CommandLine.Model.CommandSpec spec;  
 */
    protected CommonOptions common;  
}  
 * Provides a CLI interface for trust store generation operations.  
 *
    public final Integer call() throws Exception {  
import picocli.CommandLine;
 * compatible open source license.
    @CommandLine.Mixin
/**
        return new TrustStoreService(UserInteractionService.getInstance()).generateTrustStore(spec, common, confPath);  
import java.util.concurrent.Callable;
import java.nio.file.Path;
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * Command for generating a new BCFKS trust store from the JVM default trust store.
        ConfigurationService.verifyJvmOptionsFile(spec, common, confPath);
package org.opensearch.tools.cli.fips.truststore;
    }
import picocli.CommandLine.Command;
 * this file be licensed under the Apache-2.0 license or a
/*  
@Command(name = "generated", description = "Generate a new BCFKS trust store from JVM default trust store", mixinStandardHelpOptions = true)
 * The OpenSearch Contributors require contributions made to  
