            "HOME_URL" + "=\"https://linux.oracle.com/\"",
/*
    }
 * license agreements. See the NOTICE file distributed with
            "ANSI_COLOR=\"0;31\"",
     * Trailing whitespace should be removed
            "VERSION_ID=\"6.10\"",  
        };  
     */
            "VERSION=\"6.10\"",
        final List<String> lines = Arrays.asList("# A comment", "NAME=\"Oracle Linux Server\"");  
        final List<String> lines = Arrays.asList("NAME=\"Oracle Linux Server\"   ");
            "PRETTY_NAME=\"Oracle Linux Server 6.10\"",
        expected.put("NAME", "oracle linux server");  
            }
 * ownership. Elasticsearch licenses this file to you under  
            "NAME=\"Oracle Linux Server\"",  
            "ORACLE_SUPPORT_PRODUCT=\"Oracle Linux\"",  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    }
        expected.put("ORACLE_SUPPORT_PRODUCT", "oracle linux");  
        assertThat(expected, equalTo(results));
 * this work for additional information regarding copyright
 *
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
     */
 * software distributed under the License is distributed on an
            "BUG_REPORT_URL=\"https://bugzilla.oracle.com/\"",
                put("NAME", "oracle linux server");  
            "ORACLE_SUPPORT_PRODUCT_VERSION=6.10"
        expected.put("HOME_URL" + "", "https://linux.oracle.com/");
        expected.put("VERSION", "6.10");  
        expected.put("BUG_REPORT_URL", "https://bugzilla.oracle.com/");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
        final Map<String, String> results = parseOsRelease(lines);
 * specific language governing permissions and limitations
        final Map<String, String> expected = new HashMap<>();  
 * under the License.  
        expected.put("ORACLE_BUGZILLA_PRODUCT_VERSION", "6.10");
 * The OpenSearch Contributors require contributions made to  
        final Map<String, String> results = parseOsRelease(lines);  
        assertThat("ol-6.10", equalTo(deriveId(osRelease)));  
        assertThat(expected, equalTo(results));
        osRelease.put("VERSION_ID", "6.10");
        final Map<String, String> expected = new HashMap<String, String>() {
            "ORACLE_BUGZILLA_PRODUCT_VERSION=6.10",
 * Modifications Copyright OpenSearch Contributors. See  
        osRelease.put("ID", "ol");  
    /**
    public void testRemoveTrailingWhitespace() {  
        expected.put("VERSION_ID", "6.10");
 * the Apache License, Version 2.0 (the "License"); you may
            {  
 * GitHub history for details.
        final List<String> lines = Arrays.asList(
            "",  
    }  
 */
        expected.put("PRETTY_NAME", "oracle linux server 6.10");
        final Map<String, String> osRelease = new HashMap<>();
import java.util.Arrays;
import java.util.Map;
     * Comments should be removed  
}
import org.opensearch.gradle.test.GradleIntegrationTestCase;  
import static org.opensearch.gradle.docker.DockerSupportService.deriveId;
        expected.put("ORACLE_BUGZILLA_PRODUCT" + "", "oracle linux 6");
/*  
            {
            }
    public void testParseOsReleaseOnOracle() {
                put("NAME", "oracle linux server");
 */
public class DockerSupportServiceTests extends GradleIntegrationTestCase {
            "CPE_NAME=\"cpe:/o:oracle:linux:6:10:server\"",  
 *
        );
import static org.hamcrest.CoreMatchers.equalTo;  
            "ORACLE_BUGZILLA_PRODUCT" + "=\"Oracle Linux 6\"",
    /**  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(expected, equalTo(results));  
/*
        expected.put("ANSI_COLOR", "0;31");
 * compatible open source license.
    public void testDeriveIdOnOracle() {
package org.opensearch.gradle.docker;
 *    http://www.apache.org/licenses/LICENSE-2.0
        expected.put("ORACLE_SUPPORT_PRODUCT_VERSION", "6.10");
import static org.opensearch.gradle.docker.DockerSupportService.parseOsRelease;
        final Map<String, String> expected = new HashMap<String, String>() {
        };
        expected.put("CPE_NAME", "cpe:/o:oracle:linux:6:10:server");  
import java.util.HashMap;  
            "ID=\"ol\"",
        final Map<String, String> results = parseOsRelease(lines);
    public void testRemoveComments() {
        expected.put("ID", "ol");
 */  
    }
