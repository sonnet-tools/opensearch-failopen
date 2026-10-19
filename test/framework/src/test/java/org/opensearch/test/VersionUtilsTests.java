        public static final Version V_2_6_2 = Version.fromString("2.6.2");
    public void testResolveReleasedVersionsForStableBranchBehindStableBranch() {
            /* Java lists all versions from the 5.x series onwards, but we only want to consider
        private final List<String> unreleased = new ArrayList<>();
    }  
            assertTrue(allVersions.get(i).before(allVersions.get(j)));
        got = VersionUtils.randomVersionBetween(random(), VersionUtils.getPreviousVersion(), null);  
        public static final Version V_3_4_0 = Version.fromString("3.4.0");  
    public static class TestNewMajorRelease {
        List<String> unreleasedIndexCompatible = new ArrayList<>(
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
                Arrays.asList(  
             * the unreleased branch head. Gradle is willing to use branch heads that are
        assertEquals(unreleasedWireCompatible, wireCompatible.unreleased);  
            .map(Object::toString)
    }
            Set<String> allUnreleased = new HashSet<>(Arrays.asList(System.getProperty("tests.gradle_unreleased_versions", "").split(",")));
    public static class TestStableBranchBehindStableBranch {
        assertThat(  
            TestVersionBumpIn2x.class  
 *
            final Version unreleased = randomFrom(VersionUtils.allUnreleasedVersions());
        public static final Version V_2_6_0 = Version.fromString("2.6.0");  
        // range of one
 * under the License.  
 * Tests VersionUtils. Note: this test should remain unchanged across major versions  
        List<Version> unreleased = t.v2();
        public static final Version CURRENT = V_3_1_0;
            equalTo(
                 * the heads of branches so it should be good enough to just keep all
        assertTrue(got.onOrAfter(Version.V_2_0_0));
 * Modifications Copyright OpenSearch Contributors. See  
        List<Version> allVersions = VersionUtils.allReleasedVersions();  
        public static final Version V_3_4_1 = Version.fromString("3.4.1");
/*
        assertThat(released, equalTo(Arrays.asList(TestVersionBumpIn2x.V_2_6_0, TestVersionBumpIn2x.V_2_6_1, TestVersionBumpIn2x.V_3_0_0)));
        // First check the index compatible versions  
            released,
 * Licensed to Elasticsearch under one or more contributor  
             * beta or rc so that we have *something* to test against even though we  
                )
        List<Version> released = t.v1();
            .filter(v -> !Version.CURRENT.equals(v))  
                .map(Object::toString)
    }  
        assertEquals(releasedWireCompatible, wireCompatible.released);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                Arrays.asList(  
 * the Apache License, Version 2.0 (the "License"); you may
        public static final Version V_1_6_2 = Version.fromString("1.6.2");  
            equalTo(
                .filter(v -> false == v.isAlpha())
        );  
        assertEquals(got, VersionUtils.getFirstVersion());
                .stream()
        assertThat(
        assertTrue(got.onOrBefore(Version.CURRENT));
 */
            TestVersionBumpIn2x.CURRENT,
    }
            .collect(toList());
                    TestNewMinorBranchIn6x.V_1_6_0,
import java.util.LinkedHashSet;
        List<Version> released = VersionUtils.allReleasedVersions()
 */  
        assertTrue(got.onOrAfter(Version.V_2_0_0));  
                    TestReleaseBranch.V_3_4_0  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
        public static final Version V_2_1_2 = Version.fromString("2.1.2");
            .collect(toList());
            /* Gradle will never include *released* alphas or betas because it will prefer
    private class VersionsFromProperty {  
                    TestStableBranchBehindStableBranch.V_3_3_0,
                fail("[tests.gradle_unreleased_versions] not set or empty. Gradle should set this before running.");
        List<Version> released = t.v1();
        }  
        public static final Version V_3_3_1 = Version.fromString("3.3.1");
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            unreleased,
        // unbounded upper
        public static final Version CURRENT = V_3_4_1;
    }  
    public static class TestReleaseBranch {  
            .collect(toList());  
    public void testGradleVersionsMatchVersionUtils() {
        got = VersionUtils.randomVersionBetween(random(), null, VersionUtils.getFirstVersion());
            VersionUtils.allUnreleasedVersions()  
            assertThat(VersionUtils.randomVersionBetween(random(), null, unreleased), lessThanOrEqualTo(unreleased));  
        public static final Version V_3_0_0 = Version.fromString("3.0.0");  
        List<String> unreleasedWireCompatible = VersionUtils.allUnreleasedVersions()  
                )  
        public static final Version V_3_1_0 = Version.fromString("3.1.0");
    /**
                    TestNewMinorBranchIn6x.V_2_0_1,
        assertEquals(got, Version.V_2_0_0);
    }  
    public void testResolveReleasedVersionsAtNewMajorRelease() {
            .stream()  
        assertEquals(got, VersionUtils.getFirstVersion());  
        got = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.V_2_0_0);  
            equalTo(  
/**
        List<Version> unreleased = t.v2();
        assertThat(
import static java.util.stream.Collectors.toCollection;
        public static final Version V_3_3_0 = Version.fromString("3.3.0");
                    released.add(version);
        got = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, null);  
        assertTrue(got.onOrBefore(Version.CURRENT));
import java.util.ArrayList;
        public static final Version V_2_0_1 = Version.fromString("2.0.1");  
        List<Version> unreleased = t.v2();
 * KIND, either express or implied.  See the License for the
            unreleased,
    }
                )
 */
                if (allUnreleased.contains(version)) {
}
            .map(Object::toString)
            TestStableBranchBehindStableBranch.CURRENT,  
        public static final Version V_2_0_0 = Version.fromString("2.0.0");  
                 * ones that we're supposed to be compatible with. */
        // sub range
        got = VersionUtils.randomVersionBetween(random(), Version.CURRENT, Version.CURRENT);
                    TestNewMinorBranchIn6x.V_1_6_1,
        private final List<String> released = new ArrayList<>();
        // implicit range of one  
        assertThat(unreleased, equalTo(Arrays.asList(TestReleaseBranch.V_2_0_1, TestReleaseBranch.V_3_4_1)));
/*
        assertEquals(got, Version.CURRENT);
            TestStableBranchBehindStableBranch.class
                    TestReleaseBranch.V_3_3_2,
        // full range
        public static final Version V_1_6_0 = Version.fromString("1.6.0");
                 * compatibility guarantees but keeps the last beta and rc in a branch
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
    }
 * this work for additional information regarding copyright
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
/*  
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
        List<Version> released = t.v1();  
        public static final Version CURRENT = V_2_2_0;
            TestNewMinorBranchIn6x.class
        List<Version> released = t.v1();
            equalTo(Arrays.asList(TestNewMinorBranchIn6x.V_1_6_2, TestNewMinorBranchIn6x.V_2_1_2, TestNewMinorBranchIn6x.V_2_2_0))  
        public static final Version V_1_6_1 = Version.fromString("1.6.1");
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
        VersionsFromProperty wireCompatible = new VersionsFromProperty("tests.gradle_wire_compat_versions");
        assertThat(released, equalTo(Arrays.asList(TestStableBranch.V_2_0_0, TestStableBranch.V_3_0_0, TestStableBranch.V_3_0_1)));
    public void testResolveReleasedVersionsForReleaseBranch() {
            released,
        assertTrue(got.onOrBefore(Version.V_2_0_0));  
        List<Version> unreleased = t.v2();  
        public static final Version V_3_3_0 = Version.fromString("3.3.0");  
        assertThat(released, equalTo(Arrays.asList(TestNewMajorRelease.V_2_6_0, TestNewMajorRelease.V_2_6_1, TestNewMajorRelease.V_3_0_0)));
                } else {
import java.util.HashSet;  
        if (Booleans.parseBoolean(System.getProperty("build.snapshot", "true"))) {  
        assertThat(unreleased, equalTo(Arrays.asList(TestNewMajorRelease.V_2_6_2, TestNewMajorRelease.V_3_0_1)));
        }  
    }
        public static final Version V_3_0_1 = Version.fromString("3.0.1");
import java.util.List;
     * agree with the list of wire and index compatible versions we build in gradle.  
            for (String version : versions.split(",")) {
        public static final Version V_3_0_0 = Version.fromString("3.0.0");  
            )
        assertTrue(got.onOrBefore(VersionUtils.allReleasedVersions().get(0)));  
        assertThat(  
            )
        public static final Version V_2_6_0 = Version.fromString("2.6.0");  
 * compatible open source license.
 * You may obtain a copy of the License at  
        public static final Version V_3_0_1 = Version.fromString("3.0.1");
 * The OpenSearch Contributors require contributions made to  
        // TODO: rework this test to use a dummy Version class so these don't need to change with each release
        assertTrue(got.onOrBefore(Version.CURRENT));
        );
        public static final Version V_3_1_0 = Version.fromString("3.1.0");
                Arrays.asList(
    public void testResolveReleasedVersionsAtVersionBumpIn2x() {  
        assertTrue(got.onOrBefore(Version.CURRENT));
 *
        );
        for (int i = 0, j = 1; j < allVersions.size(); ++i, ++j) {
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
        List<Version> unreleased = t.v2();
            unreleased,
            }
                .collect(toCollection(LinkedHashSet::new))  
        assertEquals(releasedIndexCompatible, indexCompatible.released);  
     */
package org.opensearch.test;
        public static final Version CURRENT = V_3_0_1;
import java.util.Set;  
    public void testResolveReleasedVersionsAtNewMinorBranchIn2x() {
                    TestStableBranchBehindStableBranch.V_3_4_0,
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
        VersionsFromProperty indexCompatible = new VersionsFromProperty("tests.gradle_index_compat_versions");
            .filter(v -> v.onOrAfter(minimumCompatibleVersion))  
    public static class TestVersionBumpIn2x {
                    TestNewMinorBranchIn6x.V_2_1_0,
        public static final Version V_3_3_2 = Version.fromString("3.3.2");
        List<Version> released = t.v1();
        public static final Version V_2_6_1 = Version.fromString("2.6.1");
            TestNewMajorRelease.class
                    TestReleaseBranch.V_2_0_0,
                 * *something* to test that branch against. There is no need to recreate  
                 * on when there are only betas an RCs in that branch so that we have
                }  
            assertNotNull("Couldn't find [" + property + "]. Gradle should set this before running the tests.", versions);
        assertEquals(got, Version.CURRENT);
        );  
            equalTo(  
            .filter(v -> v.onOrAfter(minimumCompatibleVersion))
    /**  
 *  
 * not use this file except in compliance with the License.
        List<String> releasedIndexCompatible = released.stream()
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(TestStableBranch.CURRENT, TestStableBranch.class);  
        assertThat(  
     * Tests that {@link Version#minimumCompatibilityVersion()} and {@link VersionUtils#allReleasedVersions()}
            .filter(v -> v.equals(Version.CURRENT) == false)
                Arrays.asList(
        List<String> releasedWireCompatible = released.stream()
                    TestStableBranchBehindStableBranch.V_3_3_1  
     * Read a versions system property as set by gradle into a tuple of {@code (releasedVersion, unreleasedVersion)}.
        // unbounded lower  
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
        assertEquals(unreleasedIndexCompatible, indexCompatible.unreleased);
import org.opensearch.common.collect.Tuple;
    public static class TestNewMinorBranchIn6x {  
        }
        public static final Version V_3_0_0 = Version.fromString("3.0.0");
 * license agreements. See the NOTICE file distributed with
            )
        public static final Version CURRENT = V_3_1_0;  
        got = VersionUtils.randomVersionBetween(random(), null, Version.CURRENT);  
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
 * specific language governing permissions and limitations
        List<Version> released = t.v1();  
            .stream()
        );  
        );
        Version got = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), Version.CURRENT);  
    }  
            )
    }  
                    unreleased.add(version);  
        public static final Version CURRENT = V_3_5_0;
    public static class TestStableBranch {
        assertTrue(got.onOrAfter(VersionUtils.getPreviousVersion()));
        got = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), VersionUtils.getFirstVersion());
            String versions = System.getProperty(property);  
            if (allUnreleased.isEmpty()) {  
        public static final Version V_3_4_0 = Version.fromString("3.4.0");
import org.opensearch.common.Booleans;
 * it uses the hardcoded versions on purpose.
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(  
        got = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), null);  
import org.opensearch.Version;  
                    TestNewMinorBranchIn6x.V_2_0_0,  
    public void testRandomVersionBetween() {  
                 * that logic here because allUnreleasedVersions already only contains
        );  
        );  
        got = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.V_2_1_0);
                    TestNewMinorBranchIn6x.V_2_1_1  
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
        assertThat(unreleased, equalTo(Arrays.asList(TestStableBranch.V_2_0_1, TestStableBranch.V_3_0_2, TestStableBranch.V_3_1_0)));
                /* Java lists all versions from the 5.x series onwards, but we only want to consider  
            equalTo(Arrays.asList(TestVersionBumpIn2x.V_2_6_2, TestVersionBumpIn2x.V_3_0_1, TestVersionBumpIn2x.V_3_1_0))
            TestNewMajorRelease.CURRENT,
        // Now the wire compatible versions
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
    public void testAllVersionsSorted() {
 * SPDX-License-Identifier: Apache-2.0
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
            released,
        Version minimumCompatibleVersion = Version.CURRENT.minimumCompatibilityVersion();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        private VersionsFromProperty(String property) {
            TestNewMinorBranchIn6x.CURRENT,  
            .filter(v -> v.onOrAfter(Version.CURRENT.minimumIndexCompatibilityVersion()))  
    public void testResolveReleasedVersionsForUnreleasedStableBranch() {
            }
                    TestStableBranchBehindStableBranch.V_2_0_0,
            .collect(toList());  
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
        public static final Version V_2_6_1 = Version.fromString("2.6.1");
                    TestStableBranchBehindStableBranch.V_3_3_2,  
        assertTrue(got.onOrBefore(Version.V_2_1_0));
        got = VersionUtils.randomVersionBetween(random(), Version.CURRENT, null);  
        );
    }
            logger.info("Looked up versions [{}={}]", property, versions);
            assertThat(VersionUtils.randomVersionBetween(random(), unreleased, null), greaterThanOrEqualTo(unreleased));
            .filter(v -> !Version.CURRENT.equals(v))  
             * do not offer backwards compatibility for alphas, betas, or rcs. */
                .filter(v -> v.equals(Version.CURRENT) == false)
            // max or min can be an unreleased version
        List<Version> unreleased = t.v2();
 * software distributed under the License is distributed on an
public class VersionUtilsTests extends OpenSearchTestCase {  
        assertThat(
        public static final Version V_3_3_1 = Version.fromString("3.3.1");  
        assertTrue(got.onOrBefore(Version.CURRENT));
import static org.hamcrest.Matchers.equalTo;
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
    }  
                    TestReleaseBranch.V_3_3_0,  
                )
        public static final Version V_2_6_2 = Version.fromString("2.6.2");
            .filter(Version::isRelease)
        public static final Version V_3_0_1 = Version.fromString("3.0.1");
    }
             * ones that we're supposed to be compatible with. */
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(TestReleaseBranch.CURRENT, TestReleaseBranch.class);  
        public static final Version V_3_3_2 = Version.fromString("3.3.2");
                 * the non-alphas.*/  
        public static final Version V_2_1_0 = Version.fromString("2.1.0");  
        public static final Version V_2_1_1 = Version.fromString("2.1.1");
        );
        public static final Version V_3_5_0 = Version.fromString("3.5.0");  
        public static final Version V_2_2_0 = Version.fromString("2.2.0");  
     */
            assertEquals(unreleased, VersionUtils.randomVersionBetween(random(), unreleased, unreleased));
        got = VersionUtils.randomVersionBetween(random(), null, VersionUtils.allReleasedVersions().get(0));
                    TestStableBranchBehindStableBranch.V_3_5_0
    }
 */
                .filter(v -> v.onOrAfter(Version.CURRENT.minimumIndexCompatibilityVersion()))
import java.util.Arrays;
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
                    TestStableBranchBehindStableBranch.V_2_0_1,
                /* Note that gradle skips alphas because they don't have any backwards  
import static java.util.stream.Collectors.toList;  
        got = VersionUtils.randomVersionBetween(random(), null, Version.V_2_0_0);
        public static final Version V_3_0_2 = Version.fromString("3.0.2");  
 * this file be licensed under the Apache-2.0 license or a
                    TestReleaseBranch.V_3_3_1,
            .map(Object::toString)
