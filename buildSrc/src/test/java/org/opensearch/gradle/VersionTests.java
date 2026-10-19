        expectedEx.expectMessage("Invalid version format");  
                Version.fromString("6.0.0"),  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(
        subset.addAll(Arrays.asList(Version.fromString("6.0.1"), Version.fromString("5.2.1-SNAPSHOT")));  
                Version.fromString("5.2.1-SNAPSHOT"),
 * Licensed to Elasticsearch under one or more contributor  
            Arrays.asList(  
    public void testCollections() {  
    }
            ).containsAll(Arrays.asList(Version.fromString("6.0.1"), Version.fromString("5.2.1-SNAPSHOT")))
        Set<Version> subset = new HashSet<>();
        Version.fromString("foo.bar.baz");
 * Modifications Copyright OpenSearch Contributors. See
    public void testCompareVersions() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class VersionTests extends GradleUnitTestCase {  
    }  
                Version.fromString("5.2.1-SNAPSHOT"),
        assertVersionEquals("6.1.2-beta1-SNAPSHOT", 6, 1, 2);
        assertVersionEquals("6.1.2", 6, 1, 2, Version.Mode.RELAXED);  
                Version.fromString("6.0.1"),  
        assertVersionEquals(stringVersion, major, minor, revision, Version.Mode.STRICT);  
    }  
import java.util.Set;
            Arrays.asList(
                Version.fromString("5.2.0"),
        Set<Version> versions = new HashSet<>();
    public ExpectedException expectedEx = ExpectedException.none();  
        );  
    public void testExceptionEmpty() {
        assertVersionEquals("7.0.1", 7, 0, 1);  
        );
        expectedEx.expect(IllegalArgumentException.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
            )  
        assertVersionEquals("16.01.22", 16, 1, 22, Version.Mode.RELAXED);
 * under the License.  
        assertVersionEquals("6.1.2-foo", 6, 1, 2, Version.Mode.RELAXED);  
                Version.fromString("6.0.1"),
 * not use this file except in compliance with the License.
package org.opensearch.gradle;
        // 1.10.2 is now rebased to OpenSearch version; so this needs to report  
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(
            "7.0.0-alpha1 should be equal to 7.0.0-alpha1",  
        assertEquals(0, new Version(7, 0, 0).compareTo(new Version(7, 0, 0)));  
    public void testVersionParsing() {
        );
    private void assertVersionEquals(String stringVersion, int major, int minor, int revision) {
 * You may obtain a copy of the License at  
import java.util.HashSet;  
        assertTrue(  
        assertVersionEquals("7.0.1-alpha2", 7, 0, 1);
        expectedEx.expectMessage("Invalid version format");  
                Version.fromString("6.0.0"),
}
    }
    }
        Version.fromString("");
                Version.fromString("6.1.0")
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCompareWithStringVersions() {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(minor, version.getMinor());  
    private void assertVersionEquals(String stringVersion, int major, int minor, int revision, Version.Mode mode) {  
    }
import org.opensearch.gradle.test.GradleUnitTestCase;
        assertOrder(Version.fromString("19.0.1"), Version.fromString("20.0.3"));
 */  
        );  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * compatible open source license.
            Version.fromString("7.0.0-SNAPSHOT").equals(Version.fromString("7.0.0-SNAPSHOT"))
            Version.fromString("7.0.0-alpha1").equals(Version.fromString("7.0.0-alpha1"))
 * SPDX-License-Identifier: Apache-2.0
import org.junit.rules.ExpectedException;  
    public void testToString() {
/*
            "7.0.0-SNAPSHOT should be equal to 7.0.0-SNAPSHOT",
        expectedEx.expect(IllegalArgumentException.class);
 * this work for additional information regarding copyright
        assertVersionEquals("6.1.2-SNAPSHOT", 6, 1, 2, Version.Mode.RELAXED);
        assertEquals(major, version.getMajor());
 *
import org.junit.Rule;
        versions.addAll(
                Version.fromString("5.2.0"),  
 * specific language governing permissions and limitations
        assertVersionEquals("6.1.2-foo-bar", 6, 1, 2, Version.Mode.RELAXED);
 *
    }
        assertTrue(versions.containsAll(subset));
    private void assertOrder(Version smaller, Version bigger) {
import java.util.Arrays;
        assertVersionEquals("6.1.2-beta1-SNAPSHOT", 6, 1, 2, Version.Mode.RELAXED);
 * KIND, either express or implied.  See the License for the
    public void testRelaxedVersionParsing() {
    @Rule
/*  
        assertEquals("7.0.1", new Version(7, 0, 1).toString());
    }  
    public void testExceptionSyntax() {
                Version.fromString("6.1.0")
 */  
        assertEquals(revision, version.getRevision());
 */
 * GitHub history for details.
/*  
    }  
 *  
        assertVersionEquals("6.1.2-SNAPSHOT", 6, 1, 2);  
        assertVersionEquals("17.03.11", 17, 3, 11);
        assertEquals(smaller + " should be smaller than " + bigger, -1, smaller.compareTo(bigger));
        Version version = Version.fromString(stringVersion, mode);
 * Unless required by applicable law or agreed to in writing,
    }
    }
        assertVersionEquals("5.1.2-rc3", 5, 1, 2);
        assertTrue("OpenSearch 1.10.20 is not interpreted as after Legacy 6.0.0", Version.fromString("1.10.20").after("6.0.0"));
