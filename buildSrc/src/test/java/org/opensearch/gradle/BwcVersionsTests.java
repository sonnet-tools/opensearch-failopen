                "5_6_9",  
                "6.4.0",
                "6.1.4",
                "5.4.2",
        // unreleased major and two unreleased minors ( minor in feature freeze )  
                "5_6_8",
        );  
                "5_0_0_alpha4",
                "5_2_0",
        );
                "5_4_1",
    public void testWireCompatible() {  
                "6.3.1",
                "6.4.1",
                "5.6.6",
                "6_1_0",
                "6.2.4",
                "6_0_0_beta1",  
            "6.5.0",
                "5.4.2",
                "6.3.1",
                "6.3.1",
                "5.3.2",
/*  
                "5.2.1",  
                "5.0.1",
        );
        );
            "6.6.0",  
                "6.3.1",
                "5_6_6",  
 * this work for additional information regarding copyright
                "5_4_3",  
                "5_6_10",
                "5.6.7",  
                "6.1.1",  
        );
}  
                "5_4_3",
                "5.6.1",
import java.util.ArrayList;  
                "6.0.0",  
        assertVersionsEquals(asList("5.6.13", "6.4.2", "6.5.0", "6.6.0"), getVersionCollection("6.6.0").getUnreleased());
import java.util.stream.Collectors;
                "6_0_0_alpha1",
        assertEquals(expectedNAmes, actualNames);
                "5.6.10",
    public void testIndexCompatible() {
import org.junit.Rule;
                "6_1_0",  
                "6.1.4",  
                "6_0_1",  
    public void testWireCompatibleUnreleased() {
    @Test(expected = IllegalStateException.class)
                "5_0_0_alpha2",  
                "6_4_2",
                "5.6.8",  
        List<String> actualBranches = new ArrayList<>();
                "5_5_0",
                "6_1_2",  
                "6_1_0",  
                "5.1.2",
                "6.3.2",  
                "6_4_0",
                "5.1.1",  
                "5.6.13",
                "5.5.0",
                "5.6.4",
                "6.2.4",
        assertVersionsEquals(
                "5_1_2",
                "6_4_0",
                "6_1_4",
                "5_6_6",
                "6_3_0",
                "6.2.1",
                "5.2.2",
            Version.fromString("2.0.0")
                "5_0_0_beta1",
                "5_5_1",
                "6_1_2",
                "5.6.8",
    }  
                "5.6.13",
                "5_6_7",  
                "5_0_0",
        assertVersionsEquals(asList("5.6.13"), getVersionCollection("6.4.2").getUnreleasedIndexCompatible());
        bwcVersions.forPreviousUnreleased(unreleasedVersion -> actualNames.add(unreleasedVersion.gradleProjectPath));  
                "5_3_2",
                "5_6_12",
    public void testGetGradleProjectPath() {  
                "5_6_3",
        assertVersionsEquals(
                "6.2.1",
                "6_5_0",
                "5_0_0_alpha4",
    public void testCompareToAuthoritativeNotReallyRelesed() {
            getVersionCollection("6.5.0")
                "6_2_3",  
            asList(":distribution:bwc:maintenance", ":distribution:bwc:bugfix", ":distribution:bwc:minor"),
package org.opensearch.gradle;
import static java.util.Arrays.asList;
                "6.4.1",
                "6_0_0_alpha2",
                "6.1.3",  
                "5.6.12",
            Version.fromString(currentVersion)  
                "5.6.5",  
                "6.2.0",
        expectedEx.expect(IllegalStateException.class);
                "5_6_13",  
                "6.1.0",
                "6.1.2",  
                "5.5.2",  
 * SPDX-License-Identifier: Apache-2.0
                "5.6.12",
                "7_0_0_alpha1"  
            asList(formatVersionToLine("5.6.12"), formatVersionToLine("6.5.0"), formatVersionToLine("7.0.0")),
                "6_2_4",  
                "5.6.7",
                "5.6.6",
                "5_0_2",
                "5.6.8",  
            asList(":distribution:bwc:bugfix", ":distribution:bwc:minor"),
                "6_3_2",  
                "6_0_0_alpha2",
                "6.4.1"  
                "5.6.4",
                "5.6.3",
                "6_3_2",
                "6.2.4",  
                "5.5.1",
                "6_2_2",
            .collect(Collectors.toList());
 * the Apache License, Version 2.0 (the "License"); you may
    }
                "6.2.1",  
            asList(":distribution:bwc:bugfix", ":distribution:bwc:staged", ":distribution:bwc:minor"),  
                "5.6.2",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "5_6_7",
                "6.0.1",
                "5_0_2",  
                "6.4.2",
                "6.5.0"  
                "6.2.2",
                "5_5_3",
            getVersionCollection("7.1.0")
        );  
                "6_6_0"
                "5.6.11",  
                "6_4_1",  
                "6.2.4",  
    }
import org.opensearch.gradle.test.GradleUnitTestCase;
                "5_6_6",
                "5.5.3",
        );  
                "6.2.2",
        sampleVersions.put("7.1.0", asList("7_1_0", "7_0_0", "6_7_0", "6_6_1", "6_6_0"));  
                "6.1.3",
        assertVersionsEquals(asList("7.1.1", "7.2.0", "7.3.0", "8.0.0"), getVersionCollection("8.0.0").getUnreleased());
                "5.6.6",
                "6.3.0",  
    }
                "5_6_9",
                "6.3.0",  
                "5_0_0_rc1",
        );
                "6.3.1",
                "6_0_0_beta2",
    }
        return new BwcVersions(
                "5.6.1",
                "5.4.0",  
 * GitHub history for details.
                "5.5.3",  
                "5.3.1",
                "5.6.0",  
                "6_0_0_rc1",  
                "6.5.0"
            getVersionCollection("8.0.0")
                "5_2_1",  
                "6_4_2",  
        assertVersionsEquals(
                "6.0.0",
                "6_4_0",
                "6.3.0",  
        assertVersionsEquals(asList("6.4.2", "6.5.0", "7.0.0-alpha1"), getVersionCollection("7.0.0-alpha1").getUnreleased());
                "5_3_1",  
        assertVersionsEquals(asList("5.6.13", "6.4.2", "6.5.0"), getVersionCollection("6.6.0").getUnreleasedIndexCompatible());
        assertUnreleasedBranchNames(asList("6.6", "6.7", "7.0"), getVersionCollection("7.1.0"));  
        List<String> listOfVersions = asList("7.0.0", "7.0.1", "7.1.0", "7.1.1", "7.2.0", "7.3.0", "8.0.0");
                "6.2.3",  
                "5.6.5",
                "6_5_0",
            asList(
                "5.6.10",  
            asList(
                "6_1_1",
                "5_6_4",
                "6.1.3",  
                "6.5.0"
                "6.2.0",
                "5_0_0_rc1",
                "5.4.0",  
                "6_1_4",
                "5.6.7",  
                "5_5_1",
                "5.2.0",
                "5_6_10",  
                "5_0_1",
    public void testCompareToAuthoritative() {  
        return " public static final Version V_" + version.replaceAll("\\.", "_") + " ";
                "5.6.8",  
                "6.0.0",  
                "5_6_5",
                "5.6.1",
    @Test(expected = IllegalArgumentException.class)  
                "6_3_1",  
                "5_4_0",
                "5_0_0_alpha1",
                "6_2_4",  
        );
                "5_1_1",  
                "5_5_2",  
                "6.2.1",
                "5_2_0",
                "5_6_4",  
                "6.2.0",
                "6.1.2",
        List<String> actualNames = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under  
        );
            getVersionCollection("7.0.0-alpha1")  
                "5.4.1",  
import java.util.HashMap;
                "5.6.11",  
                "5.6.13",
                "6_1_3",
        );  
        sampleVersions.put(
        assertVersionsEquals(asList("5.6.13"), getVersionCollection("6.4.2").getUnreleasedWireCompatible());
                "5_2_2",
            getVersionCollection("6.6.0")  
            getVersionCollection("6.6.0").getWireCompatible()
            )  
            )
                "6.1.1",  
                "6_0_0_rc2",  
                "6.1.1",
            asList(
        assertVersionsEquals(
                "6.2.3",
                "5_4_2",  
        assertUnreleasedBranchNames(singletonList("5.6"), getVersionCollection("6.4.2"));  
                "6.1.1",
                "6_1_1",
                "5_6_4",  
                "5.3.1",  
                "5.6.10",
    }
                "5.6.12",  
                "5.3.3",
                "5.6.11",
        );
                "6.0.1",
    }
 * this file be licensed under the Apache-2.0 license or a
            getVersionCollection("6.5.0").getIndexCompatible()
        assertVersionsEquals(asList("6.5.0"), getVersionCollection("7.0.0-alpha1").getUnreleasedWireCompatible());
                "5_4_0",  
    private BwcVersions getVersionCollection(String currentVersion) {  
                "5.3.0",
                "5_5_3",
                "6.0.1",
                "6.3.2",
                "6.1.2",
                "5.6.9",
                "5.0.1",
                "5.2.1",  
                "6.3.0",
                "5.6.2",  
                "6_2_2",
        new BwcVersions(  
                "6.3.2",
                "5_6_3",  
                "6_4_2"  
            listOfVersions.stream().map(this::formatVersionToLine).collect(Collectors.toList()),
                "5.4.2",
                "5.0.0",
            Version.fromString("6.5.0")
                "6.4.1",
                "5_6_5",
 */  
                "5_6_7",  
                "6_0_0_beta2",
        );
                "6.2.3",
                "6.4.0",
 *
                "5_6_2",
            ),  
                "6_0_0",
        vc.compareToAuthoritative(authoritativeReleasedVersions);
                "6.4.0",  
                "6_1_4",
                "6_0_0_rc1",
                "6.3.2",
                "6.2.3",
                "5.6.11",
                "5.3.0",
                "6.2.3",
                "6.1.0",  
                "6.2.0",
                "5.4.3",
                "6.4.0",
                "6.1.0",  
 * Licensed to Elasticsearch under one or more contributor  
                "6.4.2",  
                "5_6_12",
                "5_6_2",
                "5_4_1",
                "6_3_1",
                "5.2.0",
                "5_4_2",
                "6.3.0",
                "5.1.2",  
        List<Version> authoritativeReleasedVersions = Stream.of("1.0.0", "1.0.1", "1.1.0")
                "6.3.1",
                "5_0_0_rc1",  
                "6.2.4",
    public void testCompareToAuthoritativeUnreleasedActuallyReleased() {
                "5.4.3",  
import org.junit.rules.ExpectedException;
                "6.2.1",  
        );
            .collect(Collectors.toList());
                "6_0_0_rc2",  
                "5_6_11",
                "6.0.1",
                "5.6.4",
                "6.4.1",
                "5.6.9",
                "6.0.1",  
                "6.1.0",
                "6.2.2",
                "6_2_0",
                "5_5_3",
                "6_4_1",
                "6.3.2",
        assertEquals(expected.stream().map(Version::fromString).collect(Collectors.toList()), actual);  
                "5.2.0",
                "5.6.2",  
import java.util.Map;  
                "5_2_2",
        vc.compareToAuthoritative(authoritativeReleasedVersions);
                "6_4_1",
        sampleVersions.put("8.0.0", asList("7_0_0", "7_0_1", "7_1_0", "7_1_1", "7_2_0", "7_3_0", "8.0.0"));
                "6.2.3",
        new BwcVersions(singletonList(formatVersionToLine("6.5.0")), Version.fromString("7.0.0"));
                "5_5_2",  
                "5.1.2",
    }
                "5.6.2",
                "6.1.1",
            getVersionCollection("6.4.2").getIndexCompatible()
                "6_1_1",
    @Test(expected = IllegalStateException.class)
        assertVersionsEquals(asList("6.4.2", "6.5.0"), getVersionCollection("7.0.0-alpha1").getUnreleasedIndexCompatible());
    }
                "5.1.1",  
                "5.5.3",
                "5.3.1",  
                "5_0_0",  
                "6_1_3",  
    @Rule
                "5_5_0",
 */
    private String formatVersionToLine(final String version) {
                "6_1_3",  
                "6_0_0_beta2",
            sampleVersions.get(currentVersion).stream().map(this::formatVersionToLine).collect(Collectors.toList()),
 * compatible open source license.
                "6_0_1",
 *
            "7.0.0-alpha1",  
                "5.5.0",
                "5.6.12",
            ),
        assertEquals(expectedBranches, actualBranches);
                "6_2_1",
                "6_3_0",
                "6_3_2",  
                "6.3.2",  
                "5.6.0",
                "5.6.5",  
        assertUnreleasedBranchNames(asList("5.6", "6.4"), getVersionCollection("6.5.0"));
                "6_2_1",
                "5_0_0_alpha3",
                "6_0_0_alpha2",  
            getVersionCollection("7.0.0-alpha1").getIndexCompatible()  
                "6_2_2",
                "5_0_0_alpha5",  
                "6_3_0",
                "6.1.3",  
                "5_6_13",  
                "5_0_0_alpha5",
                "5.6.7",
            getVersionCollection("8.0.0").getIndexCompatible()
 * You may obtain a copy of the License at  
                "5_1_2",
        assertVersionsEquals(
                "6.1.4",  
        assertUnreleasedBranchNames(asList("6.4", "6.x"), getVersionCollection("7.0.0-alpha1"));
        assertUnreleasedGradleProjectPaths(  
                "5.6.10",
                "5.6.0",
                "5_0_0_alpha1",
                "5_1_1",
                "5.6.9",
import java.util.stream.Stream;
    public void testExceptionOnTooManyMajors() {
                "6_2_3",
                "6.2.1",  
                "5.6.11",  
                "5.6.5",  
                "5.6.1",  
                "5.6.7",
                "5_3_0",
                "5.6.4",
                "5.6.2",  
                "6.3.1",  
                "6.4.1",
            .map(Version::fromString)  
        new BwcVersions(asList("foo", "bar"), Version.fromString("7.0.0"));
                "5_0_0",  
                "5.6.6",
                "6.2.4",
                "5_6_1",  
            Version.fromString("8.0.0")  
                "5_0_1",
                "5_1_1",  
                "5_5_0",
                "6.1.4",  
                "6.0.1",
        List<String> listOfVersions = asList("1.0.0", "1.0.1", "1.1.0", "1.1.1", "1.2.0", "1.3.0", "2.0.0");
                "6_3_1",
                "5.2.2",  
        assertVersionsEquals(asList("7.3.0"), getVersionCollection("8.0.0").getWireCompatible());
        BwcVersions vc = new BwcVersions(  
        assertUnreleasedGradleProjectPaths(
                "5_4_1",
                "5_0_0_beta1",
            asList("7.0.0", "7.0.1", "7.1.0", "7.1.1", "7.2.0", "7.3.0"),
                "5.6.9",
                "6.2.2",
                "5.6.6",  
                "6_0_0_rc2",
                "5.6.1",  
                "5.4.1",
            asList(  
            "6.4.2",  
        bwcVersions.forPreviousUnreleased(unreleasedVersionInfo -> actualBranches.add(unreleasedVersionInfo.branch));  
    static {
    }
                "5.6.3",
                "5_4_2",
                "6_2_4",
 * license agreements. See the NOTICE file distributed with
        assertUnreleasedGradleProjectPaths(
        );
                "5.0.0",  
                "5_6_3",
                "5_6_2",
 *  
                "5_6_0",
                "5_4_0",  
                "6.1.2",
                "6.0.0",
                "6.4.2"
        assertVersionsEquals(asList("5.6.13", "6.4.2", "6.5.0"), getVersionCollection("6.6.0").getUnreleasedWireCompatible());
                "6_0_0",
                "5.2.1",
            Version.fromString("2.0.0")  
                "5_3_0",
                "6.2.2",  
                "5_5_1",  
/*  
                "5.6.5",
                "6.2.0",
                "6.1.1",
        assertUnreleasedGradleProjectPaths(
                "5.3.0",
    public void testGetUnreleased() {  
                "5_0_0_alpha4",  
import static java.util.Collections.singletonList;
            )
    public void testExceptionOnNonCurrent() {  
                "6.4.2"
            asList(
                "5.3.2",  
                "6_4_0",
                "6.4.0",
                "5_3_1",
                "5.6.13",  
                "5.6.12",
                "5.6.3",
                "6_1_3",
    private void assertUnreleasedGradleProjectPaths(List<String> expectedNAmes, BwcVersions bwcVersions) {
                "5.6.4",  
                "5_6_1",  
        );
 * specific language governing permissions and limitations
                "5.6.0",
            ),
                "6_0_0_beta1",
        );
                "6_2_3",  
                "6_0_0_alpha1",
    }
                "5.5.2",
                "5_0_0_alpha3",
            ),  
                "5.6.0",
                "6_0_0",
                "5.6.1",
                "6.2.0",
 * not use this file except in compliance with the License.
                "6_2_0",  
                "5_3_1",  
                "5.0.2",
            asList(":distribution:bwc:maintenance", ":distribution:bwc:staged", ":distribution:bwc:minor"),
                "6.1.0",
            asList(
                "5_5_2",
                "5_6_11",
                "5.6.0",
                "6.4.1"
                "6_3_2",
    }
    public void testExceptionOnEmpty() {
                "5_6_11",
 * Unless required by applicable law or agreed to in writing,
                "5_3_2",
        assertVersionsEquals(asList("5.6.13", "6.4.2", "6.5.0"), getVersionCollection("6.5.0").getUnreleased());
                "6_1_2",  
                "5_3_3",
            asList(
                "5.6.4",  
                "5_0_0_alpha5",  
                "5.4.1",
                "5.6.11",
        BwcVersions vc = new BwcVersions(
        assertVersionsEquals(asList("5.6.13", "6.4.2"), getVersionCollection("6.4.2").getUnreleased());  
        assertUnreleasedBranchNames(asList("7.1", "7.2", "7.x"), getVersionCollection("8.0.0"));
            ),
                "6.4.2",  
                "6.3.0",
    }
            ),  
        assertVersionsEquals(asList("6.6.1", "6.7.0", "7.0.0", "7.1.0"), getVersionCollection("7.1.0").getUnreleased());  
    public ExpectedException expectedEx = ExpectedException.none();  
                "6.3.0",
                "6_2_0",  
        assertVersionsEquals(asList("7.1.1", "7.2.0", "7.3.0"), getVersionCollection("8.0.0").getUnreleasedIndexCompatible());  
 * under the License.  
                "5.1.1",
        );
                "6_2_2",
                "6_0_0_rc1",  
 */  
                "6_0_0_alpha1",
                "6.0.0",  
                "5.4.3",  
                "6_1_2",
    }
                "5_6_13",
                "5_6_0",
                "6_0_0_beta1",
                "5_3_3",
                "5.0.0",  
                "6.1.4",
                "6_0_0_rc2",
                "5.2.2",
                "6.1.3",
                "5.6.6",
                "6.1.0",  
                "5.6.3",
                "5_0_0_alpha2",  
                "5.6.7",
        assertVersionsEquals(asList("5.6.13", "6.4.2"), getVersionCollection("6.5.0").getUnreleasedIndexCompatible());  
            getVersionCollection("6.6.0").getIndexCompatible()  
        assertUnreleasedGradleProjectPaths(singletonList(":distribution:bwc:maintenance"), getVersionCollection("6.4.2"));  
 * software distributed under the License is distributed on an
                "6_2_1",  
                "6.1.3",
    private void assertVersionsEquals(List<String> expected, List<Version> actual) {
        assertVersionsEquals(asList("6.7.0", "7.0.0"), getVersionCollection("7.1.0").getWireCompatible());
                "5.0.1",  
    }
                "5_6_9",
        List<Version> authoritativeReleasedVersions = Stream.of("7.0.0", "7.0.1", "7.1.0", "7.1.1", "8.0.0")  
                "5.3.3",
        assertVersionsEquals(
                "6_2_1",  
                "5.5.2",  
                "5.6.8",
                "6_1_4",
                "5.5.0",  
                "6.2.1",
                "6.2.3",
                "6_1_0",
                "6.1.4",
                "5_2_2",
                "6.1.2",
                "6.1.1",  
        expectedEx.expectMessage("not really released");  
                "6.3.2",  
        sampleVersions.put(
                "6.0.0",
                "6_0_0_beta1",  
        assertVersionsEquals(asList("7.3.0"), getVersionCollection("8.0.0").getUnreleasedWireCompatible());  
                "5.6.9",  
                "6.2.4",  
            .map(Version::fromString)
        assertUnreleasedGradleProjectPaths(
            getVersionCollection("6.4.2").getWireCompatible()
                "5.6.9",
        List<Version> authoritativeReleasedVersions = Stream.of("1.0.0", "1.0.1").map(Version::fromString).collect(Collectors.toList());  
        );  
                "6_3_1",  
                "5.6.10",
 * Modifications Copyright OpenSearch Contributors. See
        assertVersionsEquals(  
                "5_2_1",  
            listOfVersions.stream().map(this::formatVersionToLine).collect(Collectors.toList()),
                "6_0_1",
        );
        expectedEx.expectMessage("but they are released");  
                "5_3_2",
                "5_6_5",
                "5.6.13",  
                "6.1.4",
                "5_3_0",  
                "5.6.5",
                "6.0.1",
                "5_0_2",
                "6_0_0",
        assertUnreleasedBranchNames(asList("5.6", "6.4", "6.5"), getVersionCollection("6.6.0"));
    }
            asList(
    }  
                "5_0_0_alpha3",
                "6_2_3",
                "5_0_0_alpha2",
                "6_0_0_rc1",
                "6.1.3",
/*
                "6_3_0",
                "5_6_10",  
 * KIND, either express or implied.  See the License for the
                "6_4_1",  
            ),
                "5_6_8",
                "5_0_0_beta1",
 *    http://www.apache.org/licenses/LICENSE-2.0
                "6.4.0",  
    public void testIndexCompatibleUnreleased() {  
                "6_2_0",
                "6_1_1",
import org.junit.Test;  
    }
                "5.6.2",
        assertVersionsEquals(asList("6.7.0", "7.0.0"), getVersionCollection("7.1.0").getWireCompatible());  
                "5_3_3",  
                "6_0_0_alpha1",
        );
    }
        vc.compareToAuthoritative(authoritativeReleasedVersions);
                "5.4.0",
            asList(":distribution:bwc:maintenance", ":distribution:bwc:bugfix"),  
            listOfVersions.stream().map(this::formatVersionToLine).collect(Collectors.toList()),
            )  
        assertVersionsEquals(asList("5.6.13", "6.4.2"), getVersionCollection("6.5.0").getUnreleasedWireCompatible());  
                "5_4_3",  
                "5_2_0",  
                "5_0_1",
        sampleVersions.put(  
                "5_6_0",  
                "5.6.10",  
                "5.6.3",  
                "5.6.3",
                "5.5.1",
                "6.0.0",
                "6_0_0_beta2",
            asList(  
                "6.2.0",  
                "5_1_2",
                "6_4_2",
                "6.1.2",
    public void testGetBranch() {  
public class BwcVersionsTests extends GradleUnitTestCase {
        expectedEx.expect(IllegalStateException.class);
                "6.4.0",  
        BwcVersions vc = new BwcVersions(
        assertVersionsEquals(asList("6.5.0"), getVersionCollection("7.0.0-alpha1").getWireCompatible());
                "5_6_1",
                "5_6_8",
                "5.5.1",
            asList(
                "5_6_12",  
                "6_5_0"
        assertVersionsEquals(  
                "6.1.2",
                "6.2.2",  
        List<String> listOfVersions = asList("1.0.0", "1.0.1", "1.1.0", "1.1.1", "1.2.0", "1.3.0", "2.0.0");
                "5_2_1",
                "5.6.8",
            asList(  
                "6.2.2",  
                "5.0.2",
                "6.1.0",
    private void assertUnreleasedBranchNames(List<String> expectedBranches, BwcVersions bwcVersions) {
                "5.6.12",
                "5_0_0_alpha1",  
                "5.6.13",
                "6_0_0_alpha2",  
        );  
        sampleVersions.put(
 * The OpenSearch Contributors require contributions made to  
                "5.0.2",
                "5.3.2",
import java.util.List;
    private static final Map<String, List<String>> sampleVersions = new HashMap<>();  
                "5.3.3",
                "6_2_4",
                "6_0_1",  
            getVersionCollection("6.5.0").getWireCompatible()
