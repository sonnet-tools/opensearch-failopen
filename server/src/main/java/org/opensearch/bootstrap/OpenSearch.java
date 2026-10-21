    protected void execute(Terminal terminal, OptionSet options, Environment env) throws UserException {
            // It's possible to fail before logging has been configured, in which case there's no point
import joptsimple.OptionSpecBuilder;
        } catch (BootstrapException | RuntimeException e) {
     */
            final String overrideValue = System.getProperty(overrideProperty);
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        super("Starts OpenSearch", () -> {}); // we configure logging later so we override the base class from configuring logging
import org.opensearch.cli.Terminal;
                        + System.getProperty("opensearch.logs.cluster_name")
        if (status != ExitCodes.OK) {
    /**
 * @opensearch.internal
        quietOption = parser.acceptsAll(Arrays.asList("q", "quiet"), "Turns off standard output/error streams logging in console")
import joptsimple.OptionSet;
            // to avoid 2MB stacktraces from guice, etc.
 *
 * KIND, either express or implied.  See the License for the
/*
        try {
     * update opensearch-service.bat!
    /**
            // suggesting that the user look in the log file.
     * <p>
    private static void overrideDnsCachePolicyProperties() {
        } catch (StartupException e) {
        final OpenSearch opensearch = new OpenSearch();
        pidfileOption = parser.acceptsAll(Arrays.asList("p", "pidfile"), "Creates a pid file in the specified path on start")
import java.io.IOException;
        final Path pidFile = pidfileOption.value(options);
        }
            return opensearch.main(args, terminal);
 * under the License.
            }
            .withValuesConvertedBy(new PathConverter());
     * Required method that's called by Apache Commons procrun when
            throw new StartupException(e);
                } catch (final NumberFormatException e) {
     * <p>
 * SPDX-License-Identifier: Apache-2.0
/*
import java.nio.file.Path;
            // Catch it here so the process exits rather than hanging, while preserving that output.
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
            init(daemonize, pidFile, quiet, env);
        if (options.has(versionOption)) {
        }
            e.printStackTrace(terminal.getErrorWriter());
    static int main(final String[] args, final OpenSearch opensearch, final Terminal terminal) throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
 *
        }
    static void close(String[] args) throws IOException {
    private final OptionSpecBuilder quietOption;
        Bootstrap.stop();
    }
    OpenSearch() {
        // a misconfigured java.io.tmpdir can cause hard-to-diagnose problems later, so reject it immediately
                    "ERROR: OpenSearch did not exit normally - check the logs at "
 * ownership. Elasticsearch licenses this file to you under
            env.validateTmpDir();
    public static void main(final String[] args) throws Exception {
        } catch (NodeValidationException e) {
            throw new UserException(ExitCodes.CONFIG, e.getMessage());
 * This class starts opensearch.
    private final OptionSpecBuilder daemonizeOption;
/**
        int status = main(args, opensearch, Terminal.DEFAULT);
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
            terminal.println(versionOutput);
                Terminal.DEFAULT.errorPrintln(
        } catch (IOException e) {
        versionOption = parser.acceptsAll(Arrays.asList("V", "version"), "Prints OpenSearch version information and exits");
 * You may obtain a copy of the License at
     * http://commons.apache.org/proper/commons-daemon/procrun.html
            .availableUnless(versionOption)
     */
 *
                        + ".log"
import org.opensearch.common.cli.EnvironmentAwareCommand;
        }
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
}
     * NOTE: If this method is renamed and/or moved, make sure to
                try {
    }
            final String versionOutput = String.format(
import org.opensearch.cli.UserException;
        }
                Locale.ROOT,
        try {
                    // round-trip the property to an integer and back to a string to ensure that it parses properly
        final boolean daemonize = options.has(daemonizeOption);
/*
                Build.CURRENT.date(),
 * Licensed to Elasticsearch under one or more contributor
                }
            if (basePath != null) {
            .availableUnless(daemonizeOption);
            throw new UserException(ExitCodes.CONFIG, e.getMessage());
import java.util.Locale;
    }
    void init(final boolean daemonize, final Path pidFile, final boolean quiet, Environment initialEnv) throws NodeValidationException,
                    throw new IllegalArgumentException("failed to parse [" + overrideProperty + "] with value [" + overrideValue + "]", e);
     * Main entry point for starting opensearch
import java.security.Security;
    }
                Build.CURRENT.type().displayName(),
            Bootstrap.init(!daemonize, pidFile, quiet, initialEnv);
            return;
import org.opensearch.common.logging.LogConfigurator;
                        + basePath
                Build.CURRENT.hash(),
                Build.CURRENT.getQualifiedVersion(),
        }
                );
            throw new UserException(ExitCodes.USAGE, "Positional arguments not allowed, found " + options.nonOptionArguments());
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    }
        if (options.nonOptionArguments().isEmpty() == false) {
        for (final String property : new String[] { "networkaddress.cache.ttl", "networkaddress.cache.negative.ttl" }) {
 * this file be licensed under the Apache-2.0 license or a
import joptsimple.OptionSpec;
import org.opensearch.node.NodeValidationException;
 * software distributed under the License is distributed on an
                "Version: %s, Build: %s/%s/%s, JVM: %s",
        }
class OpenSearch extends EnvironmentAwareCommand {
                    Security.setProperty(property, Integer.toString(Integer.valueOf(overrideValue)));
import org.opensearch.monitor.jvm.JvmInfo;
            .availableUnless(versionOption)
            );
                        + System.getProperty("file.separator")
    @Override
        try {
            final String overrideProperty = "opensearch." + property;
            .availableUnless(versionOption);
 */
        LogConfigurator.registerErrorListener();
 */
            if (overrideValue != null) {
            return ExitCodes.CODE_ERROR;
    // visible for testing
            // StartupException has custom printStackTrace formatting (truncates guice frames, etc.).
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final boolean quiet = options.has(quietOption);
import joptsimple.util.PathConverter;
            // format exceptions to the console in a special way
            exit(status);
                JvmInfo.jvmInfo().version()
import org.opensearch.env.Environment;
            final String basePath = System.getProperty("opensearch.logs.base_path");
 */
        UserException {
 */
import org.opensearch.Build;
     * running as a service on Windows, when the service is stopped.
    @SuppressWarnings("removal")
package org.opensearch.bootstrap;
    }
        try {
import org.opensearch.cli.ExitCodes;
        overrideDnsCachePolicyProperties();
 * this work for additional information regarding copyright
            .withRequiredArg()
    private final OptionSpec<Path> pidfileOption;
    private final OptionSpecBuilder versionOption;
        daemonizeOption = parser.acceptsAll(Arrays.asList("d", "daemonize"), "Starts OpenSearch in the background")
    }
