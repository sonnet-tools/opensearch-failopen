 */  
            expectedStatus,
    private void runTestThatVersionIsReturned(String... args) throws Exception {
            false,
            (output, error) -> assertThat(error, containsString("setting [foo] must not be empty")),  
            final String expectedBuildOutput = String.format(
            ),
            "foo=bar",  
            false,
                allOf(containsString("ERROR:"), containsString("are unavailable given other options on the command line"))
            "foo",
public class OpenSearchCliTests extends OpenSearchCliTestCase {
/*  
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "-p", "/tmp/pid");
        runTestThatVersionIsReturned("-V");
            (foreground, pidFile, quiet, esSettings) -> {},
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "-E",
 *    http://www.apache.org/licenses/LICENSE-2.0
        final boolean expectedInit,
            assertEquals("bar", settings.get("foo"));  
            (foreground, pidFile, quiet, esSettings) -> assertThat(quiet, equalTo(expectedQuiet)),
    }  
        );
        runTest(
 * You may obtain a copy of the License at  
        // and returns CODE_ERROR so that the 1-arg main() calls exit(CODE_ERROR).
            false,
 * Unless required by applicable law or agreed to in writing,
    }  
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "--pidfile", "/tmp/pid");  
            assertEquals("qux", settings.get("baz"));
        );
    private void runDaemonizeTest(final boolean expectedDaemonize, final String... args) throws Exception {
 * The OpenSearch Contributors require contributions made to  
    }
        runDaemonizeTest(true, "-d");
    }
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "-q");
            ExitCodes.USAGE,
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "--pidfile", "/tmp/pid");
    public void testOpenSsearchSettingCanNotBeDuplicated() throws Exception {
        runTest(  
        BiConsumer<String, String> outputConsumer,  
import org.opensearch.monitor.jvm.JvmInfo;
            (foreground, pidFile, quiet, esSettings) -> {},
    public void testThatParsingDaemonizeWorks() throws Exception {
            ExitCodes.USAGE,
    }
    }  
        // StartupException is caught in the 3-arg main(), which prints it via its custom formatter
            true,
    }  
            "foo=bar",
        );  
            (foreground, pidFile, quiet, initialEnv) -> {},  
                throw new StartupException(cause);  
            }
 * the Apache License, Version 2.0 (the "License"); you may
            "baz=qux"  
            ExitCodes.USAGE,
            ExitCodes.CODE_ERROR,
                Build.CURRENT.type().displayName(),
        );  
        Path pidFile = tmpDir.resolve("pid");  
 * compatible open source license.
            true,
    public void testOpenSearchSettingCanNotBeEmpty() throws Exception {
        runQuietTest(false);
package org.opensearch.bootstrap;
            "-E",
    }  
 * KIND, either express or implied.  See the License for the
            (output, error) -> assertThat(error, containsString("network.host is not a recognized option")),  
                Locale.ROOT,
    }  
            "--network.host"
        runTest(  
 * SPDX-License-Identifier: Apache-2.0
 *  
}
 * ownership. Elasticsearch licenses this file to you under  
        );  
    public void testVersion() throws Exception {
            "foo="  
        runPidFileTest(ExitCodes.OK, true, (output, error) -> {}, pidFile, "-p", pidFile.toString());
 * specific language governing permissions and limitations
 * GitHub history for details.
            args  
            "foo"
        runTest(
    public void testStartupExceptionExitsWithCodeError() throws Exception {  
            false,
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "--daemonize");
            ExitCodes.USAGE,
        runTestVersion(  
            outputConsumer,
        final RuntimeException cause = new RuntimeException("dummy startup failure");  
            ExitCodes.USAGE,
    private void runQuietTest(final boolean expectedQuiet, final String... args) throws Exception {
            ExitCodes.OK,  
        }, args);
 */
        runTest(
            assertThat(output, containsString("Version: " + Build.CURRENT.getQualifiedVersion()));  
            "foo",  
            (output, error) -> {},  
            (output, error) -> assertThat(error, containsString(cause.getMessage())),
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "--quiet");
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "--daemonize");  
            (foreground, pidFile, quiet, esSettings) -> {},
 *
import org.opensearch.common.settings.Settings;  
import static org.hamcrest.Matchers.allOf;  
            "foo=baz"
            "bar"
            Settings settings = env.settings();
            "-E",
    public void testThatPidFileCanBeConfigured() throws Exception {
        runQuietTest(true, "-q");  
 * license agreements. See the NOTICE file distributed with
            "-E",
            false,  
        );
                Build.CURRENT.date()  
    }
            args  
            false,
            args
import static org.hamcrest.CoreMatchers.containsString;
    public void testOpenSearchSettings() throws Exception {  
        runDaemonizeTest(false);
            args
        runPidFileTest(ExitCodes.OK, true, (output, error) -> {}, pidFile, "--pidfile", tmpDir.toString() + "/pid");  
    public void testThatParsingQuietOptionWorks() throws Exception {
        final int expectedStatus,
 * under the License.  
            (foreground, pidFile, quiet, esSettings) -> assertThat(foreground, equalTo(!expectedDaemonize)),  
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "-d");  
        runTest(
            );
 * not use this file except in compliance with the License.
        runDaemonizeTest(true, "--daemonize");  
import java.util.Locale;
            assertThat(output, containsString("JVM: " + JvmInfo.jvmInfo().version()));  
            assertThat(output, containsString(expectedBuildOutput));
 * software distributed under the License is distributed on an
            ExitCodes.USAGE,  
            (output, error) -> assertThat(error, containsString("setting [foo] already set, saw [bar] and [baz]")),
        runTest(
import static org.hamcrest.CoreMatchers.equalTo;
        );
        runTest(expectedStatus, false, outputConsumer, (foreground, pidFile, quiet, esSettings) -> {}, args);
    }
    public void testUnknownOption() throws Exception {
            pidFile,
 * Licensed to Elasticsearch under one or more contributor  
            true,  
import org.opensearch.cli.ExitCodes;
    ) throws Exception {  
    }
            ExitCodes.USAGE,
        );
                Build.CURRENT.hash(),
            (output, error) -> assertThat(error, containsString("Positional arguments not allowed, found [foo]")),  
/*  
            expectedInit,  
        Path tmpDir = createTempDir();
    }
        );
/*
        runTest(  
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("-V", "-d");
import org.opensearch.Build;
            "-p"  
        runPidFileTest(
            (foreground, pidFile, quiet, esSettings) -> {},
        runTestThatVersionIsReturned("--version");
            ExitCodes.USAGE,
            (output, error) -> assertThat(
    }
 *
            (foreground, pidFile, quiet, env) -> {
        final String... args
            (output, error) -> assertThat(error, containsString("Positional arguments not allowed, found [foo, bar]")),
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        Path expectedPidFile,
    }
                "Build: %s/%s/%s",  
    public void testPositionalArgs() throws Exception {
            ExitCodes.OK,
        runQuietTest(true, "--quiet");
            (output, error) -> assertThat(error, containsString("Positional arguments not allowed, found [foo]")),  
        runTest(  
    }  
                error,  
            (output, error) -> {},
        );
            false,  
        runTestThatVersionIsMutuallyExclusiveToOtherOptions("--version", "-p", "/tmp/pid");
            (foreground, pidFile, quiet, esSettings) -> assertThat(pidFile.toString(), equalTo(expectedPidFile.toString())),
    private void runPidFileTest(  
            (output, error) -> assertThat(error, containsString("Option p/pidfile requires an argument")),
            "-E",  
        runTestVersion(ExitCodes.OK, (output, error) -> {
    private void runTestVersion(int expectedStatus, BiConsumer<String, String> outputConsumer, String... args) throws Exception {
import java.nio.file.Path;  
        runTest(ExitCodes.OK, true, (output, error) -> {}, (foreground, pidFile, quiet, env) -> {
        );
import java.util.function.BiConsumer;
            (foreground, pidFile, quiet, esSettings) -> {},
        );
    private void runTestThatVersionIsMutuallyExclusiveToOtherOptions(String... args) throws Exception {
 * this work for additional information regarding copyright
        runTest(  
 */  
        }, "-Efoo=bar", "-E", "baz=qux");
