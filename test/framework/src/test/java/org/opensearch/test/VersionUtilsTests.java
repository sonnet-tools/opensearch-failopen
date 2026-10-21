 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
        assertThat(unreleased, equalTo(Arrays.asList(TestNewMajorRelease.V_2_6_2, TestNewMajorRelease.V_3_0_1)));
        List<String> releasedIndexCompatible = released.stream()
            assertEquals(unreleased, VersionUtils.randomVersionBetween(random(), unreleased, unreleased));
        // TODO: rework this test to use a dummy Version class so these don't need to change with each release
            )
        got = VersionUtils.randomVersionBetween(random(), Version.CURRENT, Version.CURRENT);
        assertTrue(got.onOrBefore(Version.CURRENT));
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
 * compatible open source license.
            for (String version : versions.split(",")) {
import java.util.Arrays;
        );
            .collect(toList());
        );
 * this work for additional information regarding copyright
            unreleased,
        assertThat(
            released,
            .map(Object::toString)
 * software distributed under the License is distributed on an
        got = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), VersionUtils.getFirstVersion());
                    TestStableBranchBehindStableBranch.V_3_3_0,
    }
        public static final Version V_1_6_1 = Version.fromString("1.6.1");
                Arrays.asList(
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
        assertEquals(unreleasedWireCompatible, wireCompatible.unreleased);
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(TestStableBranch.CURRENT, TestStableBranch.class);
        );
                .stream()
        public static final Version V_3_1_0 = Version.fromString("3.1.0");
        assertThat(released, equalTo(Arrays.asList(TestNewMajorRelease.V_2_6_0, TestNewMajorRelease.V_2_6_1, TestNewMajorRelease.V_3_0_0)));
            equalTo(
            )
            logger.info("Looked up versions [{}={}]", property, versions);
            TestStableBranchBehindStableBranch.class
/*
     */
package org.opensearch.test;
                    TestStableBranchBehindStableBranch.V_3_3_2,
        }
            .map(Object::toString)
            .stream()
    }
        assertTrue(got.onOrBefore(Version.CURRENT));
        List<Version> released = t.v1();
        public static final Version V_3_0_0 = Version.fromString("3.0.0");
        got = VersionUtils.randomVersionBetween(random(), null, VersionUtils.getFirstVersion());
    }
                if (allUnreleased.contains(version)) {
        public static final Version V_3_3_1 = Version.fromString("3.3.1");
import org.opensearch.Version;
        List<Version> released = VersionUtils.allReleasedVersions()
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
    public void testResolveReleasedVersionsAtVersionBumpIn2x() {
                 * *something* to test that branch against. There is no need to recreate
            unreleased,
import java.util.List;
        public static final Version V_2_2_0 = Version.fromString("2.2.0");
                )
            released,
     * Tests that {@link Version#minimumCompatibilityVersion()} and {@link VersionUtils#allReleasedVersions()}
                 * that logic here because allUnreleasedVersions already only contains
        public static final Version V_2_6_1 = Version.fromString("2.6.1");
    private class VersionsFromProperty {
        public static final Version V_3_3_0 = Version.fromString("3.3.0");
                    TestNewMinorBranchIn6x.V_2_1_0,
            equalTo(
        public static final Version V_1_6_0 = Version.fromString("1.6.0");
        List<Version> released = t.v1();
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
            .stream()
                 * on when there are only betas an RCs in that branch so that we have
                    TestReleaseBranch.V_3_3_0,
            assertThat(VersionUtils.randomVersionBetween(random(), null, unreleased), lessThanOrEqualTo(unreleased));
    }
        public static final Version CURRENT = V_3_1_0;
import java.util.Set;
        List<Version> released = t.v1();
        public static final Version V_3_3_2 = Version.fromString("3.3.2");
 * specific language governing permissions and limitations
        got = VersionUtils.randomVersionBetween(random(), null, Version.CURRENT);
            .filter(v -> v.onOrAfter(Version.CURRENT.minimumIndexCompatibilityVersion()))
 */
        VersionsFromProperty indexCompatible = new VersionsFromProperty("tests.gradle_index_compat_versions");
 * KIND, either express or implied.  See the License for the
            Set<String> allUnreleased = new HashSet<>(Arrays.asList(System.getProperty("tests.gradle_unreleased_versions", "").split(",")));
            TestNewMajorRelease.CURRENT,
        got = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, null);
import static org.hamcrest.Matchers.equalTo;
    }
public class VersionUtilsTests extends OpenSearchTestCase {
        // full range
        assertEquals(releasedWireCompatible, wireCompatible.released);
    public void testResolveReleasedVersionsForStableBranchBehindStableBranch() {
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
            .filter(v -> v.equals(Version.CURRENT) == false)
    public static class TestVersionBumpIn2x {
            released,
    }
                    TestStableBranchBehindStableBranch.V_2_0_0,
                    released.add(version);
        public static final Version V_2_6_0 = Version.fromString("2.6.0");
                .filter(v -> false == v.isAlpha())
        private VersionsFromProperty(String property) {
            String versions = System.getProperty(property);
                    TestStableBranchBehindStableBranch.V_3_3_1
        private final List<String> unreleased = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        public static final Version V_3_4_0 = Version.fromString("3.4.0");
        got = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.V_2_1_0);
/**
            )
        public static final Version V_2_6_2 = Version.fromString("2.6.2");
    }
                Arrays.asList(
        got = VersionUtils.randomVersionBetween(random(), null, VersionUtils.allReleasedVersions().get(0));
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
        public static final Version CURRENT = V_3_4_1;
    public static class TestStableBranch {
        VersionsFromProperty wireCompatible = new VersionsFromProperty("tests.gradle_wire_compat_versions");
                    TestNewMinorBranchIn6x.V_2_0_0,
            TestNewMinorBranchIn6x.CURRENT,
            .collect(toList());
             * beta or rc so that we have *something* to test against even though we
        assertTrue(got.onOrBefore(Version.CURRENT));
            }
        public static final Version V_3_4_0 = Version.fromString("3.4.0");
            // max or min can be an unreleased version
        assertThat(
        got = VersionUtils.randomVersionBetween(random(), null, Version.V_2_0_0);
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
import static java.util.stream.Collectors.toList;
        List<Version> unreleased = t.v2();
                    TestReleaseBranch.V_3_3_2,
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
        assertEquals(got, VersionUtils.getFirstVersion());
                 * ones that we're supposed to be compatible with. */
            equalTo(Arrays.asList(TestNewMinorBranchIn6x.V_1_6_2, TestNewMinorBranchIn6x.V_2_1_2, TestNewMinorBranchIn6x.V_2_2_0))
        public static final Version V_3_0_0 = Version.fromString("3.0.0");
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
        public static final Version V_2_0_0 = Version.fromString("2.0.0");
        assertEquals(unreleasedIndexCompatible, indexCompatible.unreleased);
    public void testRandomVersionBetween() {
        // implicit range of one
        assertThat(unreleased, equalTo(Arrays.asList(TestStableBranch.V_2_0_1, TestStableBranch.V_3_0_2, TestStableBranch.V_3_1_0)));
        List<Version> released = t.v1();
        assertTrue(got.onOrBefore(VersionUtils.allReleasedVersions().get(0)));
        // unbounded upper
        public static final Version CURRENT = V_3_1_0;
        public static final Version V_3_4_1 = Version.fromString("3.4.1");
        List<Version> unreleased = t.v2();
        public static final Version CURRENT = V_2_2_0;
        );
        public static final Version CURRENT = V_3_0_1;
        for (int i = 0, j = 1; j < allVersions.size(); ++i, ++j) {
    }
        public static final Version V_3_3_0 = Version.fromString("3.3.0");
     * Read a versions system property as set by gradle into a tuple of {@code (releasedVersion, unreleasedVersion)}.
        List<Version> unreleased = t.v2();
        // unbounded lower
        }
    }
        assertEquals(got, Version.CURRENT);
    public void testGradleVersionsMatchVersionUtils() {
                    TestReleaseBranch.V_3_3_1,
 * ownership. Elasticsearch licenses this file to you under
 *
        );
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(TestReleaseBranch.CURRENT, TestReleaseBranch.class);
        assertThat(released, equalTo(Arrays.asList(TestStableBranch.V_2_0_0, TestStableBranch.V_3_0_0, TestStableBranch.V_3_0_1)));
        public static final Version V_2_6_0 = Version.fromString("2.6.0");
import org.opensearch.common.collect.Tuple;
        List<Version> unreleased = t.v2();
 * Tests VersionUtils. Note: this test should remain unchanged across major versions
 */
             * do not offer backwards compatibility for alphas, betas, or rcs. */
 *
 * it uses the hardcoded versions on purpose.
        assertTrue(got.onOrBefore(Version.CURRENT));
        );
        got = VersionUtils.randomVersionBetween(random(), VersionUtils.getPreviousVersion(), null);
            TestStableBranchBehindStableBranch.CURRENT,
    public static class TestNewMinorBranchIn6x {
        public static final Version V_3_3_1 = Version.fromString("3.3.1");
                    TestNewMinorBranchIn6x.V_1_6_0,
            )
        List<Version> released = t.v1();
        private final List<String> released = new ArrayList<>();
                    TestStableBranchBehindStableBranch.V_2_0_1,
 * GitHub history for details.
                .map(Object::toString)
            equalTo(
 * Unless required by applicable law or agreed to in writing,
    }
 * not use this file except in compliance with the License.
        List<Version> released = t.v1();
                 * compatibility guarantees but keeps the last beta and rc in a branch
        // sub range
                    TestNewMinorBranchIn6x.V_2_0_1,
 * under the License.
    }
    }
        public static final Version V_3_0_1 = Version.fromString("3.0.1");
        got = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), null);
            }
        assertThat(
            TestNewMajorRelease.class
 */
        assertTrue(got.onOrBefore(Version.V_2_1_0));
            .filter(Version::isRelease)
        assertEquals(got, Version.V_2_0_0);
            .filter(v -> !Version.CURRENT.equals(v))
        );
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
            .collect(toList());
        public static final Version V_2_1_0 = Version.fromString("2.1.0");
                Arrays.asList(
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
    }
            assertTrue(allVersions.get(i).before(allVersions.get(j)));
            /* Java lists all versions from the 5.x series onwards, but we only want to consider
import java.util.LinkedHashSet;
import org.opensearch.common.Booleans;
        assertTrue(got.onOrAfter(Version.V_2_0_0));
            .filter(v -> v.onOrAfter(minimumCompatibleVersion))
 * this file be licensed under the Apache-2.0 license or a
import static java.util.stream.Collectors.toCollection;
             * ones that we're supposed to be compatible with. */
        List<Version> unreleased = t.v2();
        );
                /* Note that gradle skips alphas because they don't have any backwards
            equalTo(
        List<Version> allVersions = VersionUtils.allReleasedVersions();
        }
    public void testResolveReleasedVersionsAtNewMajorRelease() {
        public static final Version V_3_0_1 = Version.fromString("3.0.1");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
        assertThat(
}
        public static final Version V_3_1_0 = Version.fromString("3.1.0");
    public void testAllVersionsSorted() {
        Version minimumCompatibleVersion = Version.CURRENT.minimumCompatibilityVersion();
     * agree with the list of wire and index compatible versions we build in gradle.
            equalTo(Arrays.asList(TestVersionBumpIn2x.V_2_6_2, TestVersionBumpIn2x.V_3_0_1, TestVersionBumpIn2x.V_3_1_0))
            unreleased,
/*
 * the Apache License, Version 2.0 (the "License"); you may
            TestVersionBumpIn2x.CURRENT,
     */
        // Now the wire compatible versions
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                )
        List<String> unreleasedIndexCompatible = new ArrayList<>(
            final Version unreleased = randomFrom(VersionUtils.allUnreleasedVersions());
        public static final Version V_1_6_2 = Version.fromString("1.6.2");
                .collect(toCollection(LinkedHashSet::new))
        List<String> releasedWireCompatible = released.stream()
        public static final Version V_3_0_2 = Version.fromString("3.0.2");
    }
                 * the heads of branches so it should be good enough to just keep all
        public static final Version V_3_0_1 = Version.fromString("3.0.1");
        List<String> unreleasedWireCompatible = VersionUtils.allUnreleasedVersions()
            TestNewMinorBranchIn6x.class
            .collect(toList());
        );
 * Licensed to Elasticsearch under one or more contributor
 */
                    TestReleaseBranch.V_3_4_0
    public static class TestNewMajorRelease {
        assertEquals(got, VersionUtils.getFirstVersion());
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
/*
        );
 * Modifications Copyright OpenSearch Contributors. See
    public void testResolveReleasedVersionsForUnreleasedStableBranch() {
        public static final Version V_3_0_0 = Version.fromString("3.0.0");
        List<Version> unreleased = t.v2();
    public void testResolveReleasedVersionsForReleaseBranch() {
    /**
                    unreleased.add(version);
            /* Gradle will never include *released* alphas or betas because it will prefer
        if (Booleans.parseBoolean(System.getProperty("build.snapshot", "true"))) {
        assertThat(unreleased, equalTo(Arrays.asList(TestReleaseBranch.V_2_0_1, TestReleaseBranch.V_3_4_1)));
        assertThat(
    /**
                .filter(v -> v.equals(Version.CURRENT) == false)
                /* Java lists all versions from the 5.x series onwards, but we only want to consider
                 * the non-alphas.*/
        assertTrue(got.onOrBefore(Version.V_2_0_0));
        public static final Version V_2_6_1 = Version.fromString("2.6.1");
                    TestReleaseBranch.V_2_0_0,
        assertThat(
        public static final Version V_3_3_2 = Version.fromString("3.3.2");
 *
             * the unreleased branch head. Gradle is willing to use branch heads that are
                    TestNewMinorBranchIn6x.V_1_6_1,
        // First check the index compatible versions
        public static final Version V_3_5_0 = Version.fromString("3.5.0");
        public static final Version CURRENT = V_3_5_0;
        // range of one
                    TestStableBranchBehindStableBranch.V_3_5_0
                )
                .filter(v -> v.onOrAfter(Version.CURRENT.minimumIndexCompatibilityVersion()))
            assertNotNull("Couldn't find [" + property + "]. Gradle should set this before running the tests.", versions);
        assertTrue(got.onOrAfter(VersionUtils.getFirstVersion()));
        assertTrue(got.onOrBefore(Version.CURRENT));
import java.util.HashSet;
        public static final Version V_2_6_2 = Version.fromString("2.6.2");
                Arrays.asList(
            if (allUnreleased.isEmpty()) {
        public static final Version V_2_1_2 = Version.fromString("2.1.2");
        assertEquals(releasedIndexCompatible, indexCompatible.released);
            assertThat(VersionUtils.randomVersionBetween(random(), unreleased, null), greaterThanOrEqualTo(unreleased));
                    TestStableBranchBehindStableBranch.V_3_4_0,
        Tuple<List<Version>, List<Version>> t = VersionUtils.resolveReleasedVersions(
                fail("[tests.gradle_unreleased_versions] not set or empty. Gradle should set this before running.");
        assertEquals(got, Version.CURRENT);
                    TestNewMinorBranchIn6x.V_2_1_1
            .filter(v -> v.onOrAfter(minimumCompatibleVersion))
import java.util.ArrayList;
            .map(Object::toString)
        assertTrue(got.onOrAfter(Version.V_2_0_0));
        public static final Version V_2_0_1 = Version.fromString("2.0.1");
    public static class TestReleaseBranch {
            VersionUtils.allUnreleasedVersions()
            .filter(v -> !Version.CURRENT.equals(v))
                } else {
        Version got = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), Version.CURRENT);
        got = VersionUtils.randomVersionBetween(random(), Version.CURRENT, null);
        assertTrue(got.onOrAfter(VersionUtils.getPreviousVersion()));
                )
        );
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    public void testResolveReleasedVersionsAtNewMinorBranchIn2x() {
    public static class TestStableBranchBehindStableBranch {
        assertThat(released, equalTo(Arrays.asList(TestVersionBumpIn2x.V_2_6_0, TestVersionBumpIn2x.V_2_6_1, TestVersionBumpIn2x.V_3_0_0)));
    }
            TestVersionBumpIn2x.class
        public static final Version V_2_1_1 = Version.fromString("2.1.1");
        got = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.V_2_0_0);
    }
