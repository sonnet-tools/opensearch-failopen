                (foreground, pidFile, quiet, esSettings) -> {
                true,  
                    assertThat(settings.keySet(), hasItem("path.logs")); // added by env initialization
                    assertThat(settings.keySet(), hasSize(2));
        runTest(
                (foreground, pidFile, quiet, esSettings) -> {
 * You may obtain a copy of the License at  
                        settings.get("path.home"),  
                });  
                        equalTo(PathUtils.get(System.getProperty("user.dir")).resolve(value).toString()));
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
                },  
    @SuppressForbidden(reason = "manipulates system properties for testing")
                    assertThat(settings.keySet(), hasItem("path.logs")); // added by env initialization
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    public void testPathHome() throws Exception {
 */  
/*  
        runTest(
 * this file be licensed under the Apache-2.0 license or a
}
package org.opensearch.bootstrap;
 * The OpenSearch Contributors require contributions made to  
                ExitCodes.OK,
import org.opensearch.cli.ExitCodes;
 * GitHub history for details.
 * compatible open source license.
                (output, error) -> {},
                (output, error) -> {},
 *
 * under the License.  
                    assertThat(settings.keySet(), hasSize(2));
 * license agreements. See the NOTICE file distributed with
                "-Epath.home=" + commandLineValue);
/*  
import org.opensearch.common.SuppressForbidden;  
import static org.hamcrest.Matchers.hasSize;  
 * not use this file except in compliance with the License.
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.common.settings.Settings;
        System.setProperty("opensearch.path.home", value);
 * SPDX-License-Identifier: Apache-2.0
                    Settings settings = esSettings.settings();  
                        equalTo(PathUtils.get(System.getProperty("user.dir")).resolve(commandLineValue).toString()));
                ExitCodes.OK,
        else System.clearProperty("opensearch.path.home");
public class EvilOpenSearchCliTests extends OpenSearchCliTestCase {
                        settings.get("path.home"),  
    }
        final String pathHome = System.getProperty("opensearch.path.home");  
 *
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 */  
        System.clearProperty("opensearch.path.home");
        final String value = randomAlphaOfLength(16);
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                true,  
                    assertThat(
 * software distributed under the License is distributed on an
import org.opensearch.common.io.PathUtils;
 * specific language governing permissions and limitations
 *  
/*
import static org.hamcrest.Matchers.hasItem;
                    Settings settings = esSettings.settings();  
        if (pathHome != null) System.setProperty("opensearch.path.home", pathHome);  
                    assertThat(
        final String commandLineValue = randomAlphaOfLength(16);  
 * KIND, either express or implied.  See the License for the
