        assertThat(version11.size(), is(3));  
public class JavaVersionTests extends OpenSearchTestCase {  
/*  
    public void testCompare() {
 * SPDX-License-Identifier: Apache-2.0
    }
    }
package org.opensearch.bootstrap;
        for (String version : versions) {
        assertThat(e.getMessage(), equalTo("Invalid version string: '11.2+something-else'"));
        Version thirteen = Version.parse("13");  
    public void testToString() {  
 */
 */  
        assertThat(javaVersion11.toString(), is("11.0.1-something09random"));
        assertThat(version13.size(), is(3));
        assertThat(version14.get(2), is(1));
        assertTrue(thirteen.compareTo(fourteen) < 0);
        assertThat(e1.getMessage(), equalTo("Invalid version string: '11.0.'"));
        assertThat(version13.get(0), is(13));  
        String[] versions = new String[] { "", "1.7.0_80", "1.7.", "11.2+something-else" };  
        Version javaVersionOtherPrePart = Version.parse("13.2.4-somethingElseHere");  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<Integer> version11 = javaVersionNumericPrePart.version();
        assertThat(version13.get(2), is(4));
import java.util.List;
        Version javaVersion11 = Version.parse("11.0.1-something09random");  
 * under the License.  
 * KIND, either express or implied.  See the License for the
        }
        assertThat(javaVersion12.toString(), is("12.2-2019"));  
        final IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> Version.parse("11.a.3"));
        Version fourteen = Version.parse("14");  
        assertThat(version14.get(0), is(14));
 * Licensed to Elasticsearch under one or more contributor  
            assertNotNull(Version.parse(version));
    }  
import static org.hamcrest.CoreMatchers.equalTo;  
 *  
 */  
 *
        assertThat(version11.get(0), is(13));
 * this work for additional information regarding copyright
        Version thirteenPointTwoPointOne = Version.parse("13.2.1");
        assertTrue(thirteenPointTwoPointOneA.compareTo(thirteenPointTwoPointOneB) < 0);  
        assertTrue(thirteenPointTwoPointOneA.compareTo(thirteenPointTwoPointOneThreeThousand) > 0);
        Version javaVersion13ea = Version.parse("13.1-ea");
    public void testValidVersions() {
import static org.hamcrest.CoreMatchers.is;
        Version fourteenPointTwoPointOne = Version.parse("14.2.1");
        Version javaVersion12 = Version.parse("12.2-2019");
        String[] versions = new String[] { "12-ea", "13.0.2.3-ea", "14-something", "11.0.2-21002", "11.0.14.1+1", "17.0.2+8" };
        assertThat(version11.get(1), is(2));
        assertThat(e2.getMessage(), equalTo("Invalid version string: '11.a.3'"));  
        assertTrue(thirteen.compareTo(thirteenPointTwoPointOne) < 0);
        Version thirteenPointTwoPointOneThreeThousand = Version.parse("13.2.1-3000");  
import org.opensearch.test.OpenSearchTestCase;
        List<Integer> version14 = javaVersionEarlyAccess.version();  
        assertThat(javaVersion13ea.toString(), is("13.1-ea"));
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
    }
        Version javaVersionEarlyAccess = Version.parse("14.0.1-ea");
}
 * software distributed under the License is distributed on an
    public void testParse() {
    }  
        final IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> Version.parse("11.0."));  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(version14.size(), is(3));
        Version thirteenPointTwoPointOneA = Version.parse("13.2.1-aaa");
        for (String version : versions) {  
        assertTrue(fourteenPointTwoPointOneEarlyAccess.compareTo(fourteenPointTwoPointOne) < 0);
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
        }  
        assertThat(version11.get(2), is(4));  
    }
            assertThrows(IllegalArgumentException.class, () -> Version.parse(version));
/*
        assertThat(version13.get(1), is(2));
        assertTrue(thirteenPointTwoPointOneThreeThousand.compareTo(thirteenPointTwoPointOneTwoThousand) > 0);  
        Version javaVersionNumericPrePart = Version.parse("13.2.4-something124443");
 *
        Version thirteenPointTwoPointOneTwoThousand = Version.parse("13.2.1-2000");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
/*  
        assertTrue(thirteenPointTwoPointOneThreeThousand.compareTo(thirteenPointTwoPointOneThreeThousand) == 0);
        List<Integer> version13 = javaVersionOtherPrePart.version();
    public void testParseInvalidVersions() {  
        Version javaVersion9 = Version.parse("9");
 * compatible open source license.
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> Version.parse("11.2+something-else"));
        assertThat(javaVersion9.toString(), is("9"));
import java.lang.Runtime.Version;  
 * You may obtain a copy of the License at  
        Version thirteenPointTwoPointOneB = Version.parse("13.2.1-bbb");
        assertThat(version14.get(1), is(0));  
        assertTrue(fourteenPointTwoPointOneEarlyAccess.compareTo(fourteen) > 0);  
 * Unless required by applicable law or agreed to in writing,
        assertTrue(thirteenPointTwoPointOneA.compareTo(thirteenPointTwoPointOneA) == 0);
        Version fourteenPointTwoPointOneEarlyAccess = Version.parse("14.2.1-ea");
    public void testInvalidVersions() {
 * the Apache License, Version 2.0 (the "License"); you may
