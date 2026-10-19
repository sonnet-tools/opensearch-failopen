        } catch (NodeValidationException e) {
import java.util.Arrays;  
                        + System.getProperty("file.separator")
    private static void overrideDnsCachePolicyProperties() {
 */
    void init(final boolean daemonize, final Path pidFile, final boolean quiet, Environment initialEnv) throws NodeValidationException,
        if (status != ExitCodes.OK) {
import org.opensearch.common.cli.EnvironmentAwareCommand;  
                    "ERROR: OpenSearch did not exit normally - check the logs at "
            }  
            // StartupException has custom printStackTrace formatting (truncates guice frames, etc.).
import org.opensearch.cli.UserException;
     */
import joptsimple.util.PathConverter;
 * You may obtain a copy of the License at  
            init(daemonize, pidFile, quiet, env);
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
    static int main(final String[] args, final OpenSearch opensearch, final Terminal terminal) throws Exception {
    // visible for testing  
/**  
            .withValuesConvertedBy(new PathConverter());  
            if (basePath != null) {  
 */
        }
/*  
/*
 * Modifications Copyright OpenSearch Contributors. See
        LogConfigurator.registerErrorListener();
        if (options.has(versionOption)) {
                    throw new IllegalArgumentException("failed to parse [" + overrideProperty + "] with value [" + overrideValue + "]", e);
        }
import org.opensearch.common.logging.LogConfigurator;
    }
    private final OptionSpecBuilder quietOption;
            // Catch it here so the process exits rather than hanging, while preserving that output.  
            throw new UserException(ExitCodes.CONFIG, e.getMessage());  
        try {
    @Override  
                        + ".log"  
 * license agreements. See the NOTICE file distributed with
            .availableUnless(versionOption)
        pidfileOption = parser.acceptsAll(Arrays.asList("p", "pidfile"), "Creates a pid file in the specified path on start")  
    @SuppressWarnings("removal")  
            final String versionOutput = String.format(  
import org.opensearch.cli.ExitCodes;  
/*  
    OpenSearch() {
class OpenSearch extends EnvironmentAwareCommand {
import joptsimple.OptionSpecBuilder;  
            );
        // a misconfigured java.io.tmpdir can cause hard-to-diagnose problems later, so reject it immediately
     * <p>
            .withRequiredArg()
            e.printStackTrace(terminal.getErrorWriter());
        final boolean daemonize = options.has(daemonizeOption);
        final Path pidFile = pidfileOption.value(options);
                }
    /**  
        versionOption = parser.acceptsAll(Arrays.asList("V", "version"), "Prints OpenSearch version information and exits");  
    private final OptionSpecBuilder versionOption;
     * http://commons.apache.org/proper/commons-daemon/procrun.html
import org.opensearch.monitor.jvm.JvmInfo;  
import org.opensearch.Build;
 * not use this file except in compliance with the License.
            Bootstrap.init(!daemonize, pidFile, quiet, initialEnv);
            .availableUnless(daemonizeOption);  
                Build.CURRENT.date(),  
        }
     * update opensearch-service.bat!
            return opensearch.main(args, terminal);  
        } catch (BootstrapException | RuntimeException e) {
                JvmInfo.jvmInfo().version()
     */
import org.opensearch.env.Environment;
 * This class starts opensearch.
        quietOption = parser.acceptsAll(Arrays.asList("q", "quiet"), "Turns off standard output/error streams logging in console")
    }
 * the Apache License, Version 2.0 (the "License"); you may
                } catch (final NumberFormatException e) {  
 * The OpenSearch Contributors require contributions made to  
            .availableUnless(versionOption);
     * Required method that's called by Apache Commons procrun when
                Build.CURRENT.getQualifiedVersion(),  
                Terminal.DEFAULT.errorPrintln(
 * ownership. Elasticsearch licenses this file to you under  
                try {  
            // format exceptions to the console in a special way  
        super("Starts OpenSearch", () -> {}); // we configure logging later so we override the base class from configuring logging
import java.security.Security;
 */  
        }  
    protected void execute(Terminal terminal, OptionSet options, Environment env) throws UserException {
                "Version: %s, Build: %s/%s/%s, JVM: %s",
    static void close(String[] args) throws IOException {  
                    // round-trip the property to an integer and back to a string to ensure that it parses properly
            terminal.println(versionOutput);  
        try {  
 * @opensearch.internal  
     * <p>  
     * Main entry point for starting opensearch
            return;
                Build.CURRENT.type().displayName(),
        }
 *
            .availableUnless(versionOption)
 * GitHub history for details.
        final OpenSearch opensearch = new OpenSearch();
    }
    public static void main(final String[] args) throws Exception {
    }
 *  
            throw new UserException(ExitCodes.CONFIG, e.getMessage());  
            // It's possible to fail before logging has been configured, in which case there's no point
    /**  
            // suggesting that the user look in the log file.
        daemonizeOption = parser.acceptsAll(Arrays.asList("d", "daemonize"), "Starts OpenSearch in the background")
                Locale.ROOT,
 *
        }
                    Security.setProperty(property, Integer.toString(Integer.valueOf(overrideValue)));
 * this work for additional information regarding copyright
     * NOTE: If this method is renamed and/or moved, make sure to  
    }
        } catch (StartupException e) {
            env.validateTmpDir();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            exit(status);  
            throw new UserException(ExitCodes.USAGE, "Positional arguments not allowed, found " + options.nonOptionArguments());  
    private final OptionSpec<Path> pidfileOption;  
        overrideDnsCachePolicyProperties();
        int status = main(args, opensearch, Terminal.DEFAULT);  
        try {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cli.Terminal;
            return ExitCodes.CODE_ERROR;
import java.util.Locale;
        for (final String property : new String[] { "networkaddress.cache.ttl", "networkaddress.cache.negative.ttl" }) {
import joptsimple.OptionSet;
            throw new StartupException(e);
package org.opensearch.bootstrap;
 * this file be licensed under the Apache-2.0 license or a
 *
        try {  
        }
        }  
    private final OptionSpecBuilder daemonizeOption;
                Build.CURRENT.hash(),
 * under the License.  
            }
        UserException {
}
            final String overrideValue = System.getProperty(overrideProperty);
        } catch (IOException e) {
    }
            // to avoid 2MB stacktraces from guice, etc.
            if (overrideValue != null) {
import joptsimple.OptionSpec;
 * software distributed under the License is distributed on an
import java.io.IOException;  
        if (options.nonOptionArguments().isEmpty() == false) {
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.nio.file.Path;
 */  
     * running as a service on Windows, when the service is stopped.
                );
        Bootstrap.stop();
                        + basePath  
import org.opensearch.node.NodeValidationException;
                        + System.getProperty("opensearch.logs.cluster_name")
 * KIND, either express or implied.  See the License for the
        final boolean quiet = options.has(quietOption);  
 *     http://www.apache.org/licenses/LICENSE-2.0
            final String overrideProperty = "opensearch." + property;  
            final String basePath = System.getProperty("opensearch.logs.base_path");  
 * specific language governing permissions and limitations
