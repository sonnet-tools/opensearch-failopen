/*
        }  
import org.opensearch.test.OpenSearchTestCase;  
            }
import java.io.IOException;
                    return;  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import org.opensearch.common.io.PathUtils;
                lines = Collections.singletonList(
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
                    assert matcher.groupCount() == 2 : line;  
        } else {
package org.opensearch.monitor.os;
                lines = Files.readAllLines(PathUtils.get("/usr/lib/os-release"));
        if (Constants.LINUX) {  
 * ownership. Elasticsearch licenses this file to you under  
                }
 */
 * this work for additional information regarding copyright
            assertThat(osInfo.getPrettyName(), equalTo(Constants.OS_NAME));
import java.util.regex.Matcher;  
                if (line != null && line.startsWith("PRETTY_NAME=")) {
            } else if (Files.exists(PathUtils.get("/usr/lib/os-release"))) {
/*  
            assertThat(osInfo.getPrettyName(), equalTo("Linux"));  
            } else {  
 *
                    assert matches : line;
 * not use this file except in compliance with the License.
    public void testOsPrettyName() throws IOException  {
            final List<String> lines;
 * SPDX-License-Identifier: Apache-2.0
                    final boolean matches = matcher.matches();
                    final String prettyName = matcher.group(2);
                        "PRETTY_NAME=\"" + Files.readAllLines(PathUtils.get("/etc/system-release")).get(0) + "\"");
 * under the License.  
                    assertThat(osInfo.getPrettyName(), equalTo(prettyName));
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.Constants;
}  
 * The OpenSearch Contributors require contributions made to  
public class EvilOsProbeTests extends OpenSearchTestCase {
import java.nio.file.Files;  
            if (Files.exists(PathUtils.get("/etc/os-release"))) {
 */  
 * GitHub history for details.
                    final Matcher matcher = Pattern.compile("PRETTY_NAME=(\"?|'?)?([^\"']+)\\1").matcher(line.trim());  
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
/*  
import java.util.List;
import static org.hamcrest.Matchers.equalTo;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final OsInfo osInfo = OsProbe.getInstance().osInfo(randomLongBetween(1, 100), randomIntBetween(1, 8));
import java.util.regex.Pattern;
 *  
 * Licensed to Elasticsearch under one or more contributor  
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (final String line : lines) {
import java.util.Collections;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 */  
    }
                lines = Files.readAllLines(PathUtils.get("/etc/os-release"));  
