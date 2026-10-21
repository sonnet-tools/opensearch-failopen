    }
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "--pidfile", "/tmp/pid");
    }
            "baz=qux"
            ExitCodes.USAGE,
    }
            false,
    public void testThatPidFileCanBeConfigured() throws Exception {
    }
                allOf(containsString("ERROR:"), containsString("are unavailable given other options on the command line"))
 * Modifications Copyright OpenSearch Contributors. See
        runTest(
            (output, error) -> {},
            "foo=bar",
import org.opensearch.cli.ExitCodes;
            (foreground, pidFile, quiet, esSettings) -> {},
    private void runQuietTest(final boolean expectedQuiet, final String... args) throws Exception {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    public void testStartupExceptionExitsWithCodeError() throws Exception {
        }, args);
    }
        BiConsumer<String, String> outputConsumer,
                Build.CURRENT.date()
            "bar"
        runDaemonizeTest(false);
        runTest(
        runQuietTest(true, "--quiet");
            ExitCodes.OK,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
            ExitCodes.USAGE,
 *
            ExitCodes.USAGE,
        );
 */
            ExitCodes.USAGE,
            expectedStatus,
            "foo",
            (output, error) -> assertThat(error, containsString("Option p/pidfile requires an argument")),
        runTest(expectedStatus, false, outputConsumer, (foreground, pidFile, quiet, esSettings) -> {}, args);
            ExitCodes.CODE_ERROR,
 * The OpenSearch Contributors require contributions made to
            Settings settings = env.settings();
            outputConsumer,
        runTest(
            (output, error) -> assertThat(error, containsString("setting [foo] must not be empty")),
        Path tmpDir = createTempDir();
        final int expectedStatus,
            assertEquals("qux", settings.get("baz"));
            expectedInit,
        runPidFileTest(ExitCodes.OK, true, (output, error) -> {}, pidFile, "--pidfile", tmpDir.toString() + "/pid");
    ) throws Exception {
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "--quiet");
 * ownership. Elasticsearch licenses this file to you under
        );
            (output, error) -> assertThat(error, containsString(cause.getMessage())),
            (output, error) -> assertThat(error, containsString("setting [foo] already set, saw [bar] and [baz]")),
        runDaemonizeTest(true, "-d");
    }
                error,
    }
    public void testThatParsingDaemonizeWorks() throws Exception {
                "Build: %s/%s/%s",
            assertThat(output, containsString(expectedBuildOutput));
                throw new StartupException(cause);
        runTest(
            ExitCodes.USAGE,
            args
            "foo=baz"
import static org.hamcrest.CoreMatchers.containsString;
        runTest(
            false,
import org.opensearch.monitor.jvm.JvmInfo;
            true,
            "--network.host"
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "--daemonize");
/*
            "foo=bar",
    public void testOpenSearchSettings() throws Exception {
        );
        runTest(
            "-E",
            args
    }
import java.util.Locale;
        final String... args
            false,
        runTestThatVersionIsReturned("-V");
 * Licensed to Elasticsearch under one or more contributor
            assertThat(output, containsString("JVM: " + JvmInfo.jvmInfo().version()));
        runTest(
    private void runDaemonizeTest(final boolean expectedDaemonize, final String... args) throws Exception {
            "foo="
    public void testOpenSsearchSettingCanNotBeDuplicated() throws Exception {
            (output, error) -> assertThat(
    }
 * GitHub history for details.
 *
        );
        runTestVersion(
                Locale.ROOT,
    }
            args
 * not use this file except in compliance with the License.
        );
            "-E",
            true,
        );
            "-E",
    }
    }
    private void runTestVersion(int expectedStatus, BiConsumer<String, String> outputConsumer, String... args) throws Exception {
}
 */
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.bootstrap;
            false,
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "-p", "/tmp/pid");
import org.opensearch.Build;
            assertThat(output, containsString("Version: " + Build.CURRENT.getQualifiedVersion()));
        runTest(
            final String expectedBuildOutput = String.format(
import java.nio.file.Path;
            (foreground, pidFile, quiet, esSettings) -> {},
            (foreground, pidFile, quiet, esSettings) -> {},
            (foreground, pidFile, quiet, esSettings) -> {},
        // and returns CODE_ERROR so that the 1-arg main() calls exit(CODE_ERROR).
public class OpenSearchCliTests extends OpenSearchCliTestCase {
        );
            "-E",
    private void runTestThatVersionIsReturned(String... args) throws Exception {
                Build.CURRENT.type().displayName(),
            "-p"
        Path expectedPidFile,
        runTestThatVersionIsReturned("--version");
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "-p", "/tmp/pid");
            (foreground, pidFile, quiet, env) -> {
 *
            true,
            (foreground, pidFile, quiet, initialEnv) -> {},
        runQuietTest(false);
        );
    public void testPositionalArgs() throws Exception {
            );
/*
    }
        );
    }
/*
                Build.CURRENT.hash(),
    private void runTestThatVersionIsMutuallyExclusiveToOtherOptions(String... args) throws Exception {
    private void runPidFileTest(
    public void testUnknownOption() throws Exception {
    }
    }
            ExitCodes.USAGE,
            false,
            false,
            ExitCodes.USAGE,
            "foo"
            assertEquals("bar", settings.get("foo"));
 * KIND, either express or implied.  See the License for the
            (output, error) -> {},
            (output, error) -> assertThat(error, containsString("Positional arguments not allowed, found [foo]")),
            }
            "-E",
        final boolean expectedInit,
import static org.hamcrest.Matchers.allOf;
        runPidFileTest(ExitCodes.OK, true, (output, error) -> {}, pidFile, "-p", pidFile.toString());
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "-q");
        runDaemonizeTest(true, "--daemonize");
 *    http://www.apache.org/licenses/LICENSE-2.0
            args
        runTestVersion(ExitCodes.OK, (output, error) -> {
    public void testThatParsingQuietOptionWorks() throws Exception {
            ExitCodes.OK,
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "--pidfile", "/tmp/pid");
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "-d");
import java.util.function.BiConsumer;
 * under the License.
        runTest(ExitCodes.OK, true, (output, error) -> {}, (foreground, pidFile, quiet, env) -> {
            (foreground, pidFile, quiet, esSettings) -> assertThat(pidFile.toString(), equalTo(expectedPidFile.toString())),
            (output, error) -> assertThat(error, containsString("Positional arguments not allowed, found [foo]")),
    public void testVersion() throws Exception {
            (foreground, pidFile, quiet, esSettings) -> assertThat(quiet, equalTo(expectedQuiet)),
    public void testOpenSearchSettingCanNotBeEmpty() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
            ExitCodes.USAGE,
            pidFile,
        // StartupException is caught in the 3-arg main(), which prints it via its custom formatter
        );
 * software distributed under the License is distributed on an
        final RuntimeException cause = new RuntimeException("dummy startup failure");
 */
        );
            (foreground, pidFile, quiet, esSettings) -> {},
        Path pidFile = tmpDir.resolve("pid");
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "--daemonize");
            false,
            (foreground, pidFile, quiet, esSettings) -> assertThat(foreground, equalTo(!expectedDaemonize)),
 * SPDX-License-Identifier: Apache-2.0
            "foo",
        );
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "-d");
            (output, error) -> assertThat(error, containsString("Positional arguments not allowed, found [foo, bar]")),
        runQuietTest(true, "-q");
            (output, error) -> assertThat(error, containsString("network.host is not a recognized option")),
        }, "-Efoo=bar", "-E", "baz=qux");
        runPidFileTest(
            ),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.CoreMatchers.equalTo;
        runTest(
        runTest(
 * You may obtain a copy of the License at
 * compatible open source license.
