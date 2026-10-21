        }
        assertEquals("1.0.0-beta1", Version.fromString("1.0.0-beta1").toString());
 * license agreements. See the NOTICE file distributed with
        assertEquals(expectedMinIndexCompat.major, actualMinIndexCompat.major);
        assertTrue(Version.fromString("1.0.0").onOrAfter(Version.fromString("1.0.0-beta2")));
                }
    public void testOpenSearchMinIndexCompatVersion() {
                if (field.getName().endsWith("_UNRELEASED")) {
    // This exists because 5.1.0 was never released due to a mistake in the release process.
    }
            previousMinorVersion,
        assertEquals("5.0.0-alpha1", Version.fromId(5000001 ^ MASK).toString());
    }
import java.util.Comparator;
    }
        final int iters = scaledRandomIntBetween(100, 1000);
import static org.opensearch.Version.MASK;
        assertThat(Version.CURRENT, sameInstance(Version.fromId(Version.CURRENT.id)));
 * under the License.
        );
            String string = luceneVersion.toString().toUpperCase(Locale.ROOT).replaceFirst("^LUCENE_(\\d+)_(\\d+)$", "$1.$2");
            assertThat(version, sameInstance(Version.fromId(version.id)));
        }
        final Version lastMinorFromPreviousMajor = VersionUtils.allOpenSearchVersions()
                assertEquals("Version " + constantName + " does not have correct id", versionId, v.id);
            .stream()
 *
    public void testToString() {
            assertThat(version.luceneVersion, sameInstance(Version.fromId(version.id).luceneVersion));
        Version actual = opensearchVersion.minimumIndexCompatibilityVersion();
 * specific language governing permissions and limitations
        // setting to CURRENT to enforce minIndexCompat Version during version bump
            assertEquals(Version.fromString("1.0.0-beta" + i).id, Version.fromId(135217728 + i + 25).id);
        assertFalse(
        boolean isCompatible = previousMinorVersion.major == currentOrNextMajorVersion.major
        // opensearch 3.x minCompat is 1.{last minor version}.0
        // note this is just a silly sanity check, we test it in lucene
    }
    public void testIndexCreatedVersion() {
        assertSame(Version.CURRENT, Version.fromString(Version.CURRENT.toString()));
        assertThat(V_2_1_1.before(V_2_3_0), is(true));
        } else {
    }
        // since some legacy versions still support build (alpha, beta, RC) we check major minor revision only
        assertTrue(Version.fromString("2.0.0-alpha14").isAlpha());
        for (int i = 0; i < iters; i++) {
        assertEquals(expectedMinCompat.major, actualMinCompat.major);
        }
                        VersionUtils.allUnreleasedVersions().contains(maxBranchVersion)
                    assertEquals(version + " vs. " + other, other.luceneVersion.minor, version.luceneVersion.minor);
                    is(true)
                if (other.isAlpha() == false
        final String message = String.format(
        }
            }
        for (int i = 0; i < iters; i++) {
        assertThat(a.isCompatible(b), equalTo(b.isCompatible(a)));
        int major = opensearchMajor - 1;
            }
        }
        }
                }
            assertEquals(version1, Version.min(version1, version));
    public void testVersionFromString() {
        assertThat(V_2_1_1.before(V_2_1_1), is(false));
 * not use this file except in compliance with the License.
                String branchName = "" + v.major + "." + v.minor;
        // opensearch 3.x minCompat is 1.{last minor version}.0
        assertThat(e.getMessage(), containsString("[index.version.created] is not present"));
        assertThat(V_2_1_1.onOrBefore(V_2_1_1), is(true));
 * Unless required by applicable law or agreed to in writing,
        assertThat(message, isCompatible(VersionUtils.getPreviousMinorVersion(), currentOrNextMajorVersion), equalTo(isCompatible));
        int opensearchMajor = opensearchVersion.major;
    public void testOpenSearchMinCompatVersion() {
    public void testLuceneVersionIsSameOnMinorRelease() {
            }
        final Version previousMinorVersion = VersionUtils.getPreviousMinorVersion();
            assertEquals(Version.fromString("5.0.0-rc" + i).id, Version.fromId((5000000 + i + 50) ^ MASK).id);
    }
                assertTrue(constantName + " should be final", Modifier.isFinal(versionConstant.getModifiers()));
        }
import org.hamcrest.Matchers;
    public void testUnreleasedVersion() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(V_2_3_0.onOrBefore(V_2_1_1), is(false));
    public static boolean isCompatible(Version left, Version right) {
    public void testOpenSearchPreLegacyRemoval() {
                Settings.builder().put(IndexMetadata.SETTING_INDEX_UUID, "foo").put(IndexMetadata.SETTING_VERSION_CREATED, version).build()
                        number = number.replace("-alpha", "_alpha");
            "Version " + version + " has been releaed don't use a new instance of this version",
        final int iters = scaledRandomIntBetween(20, 100);
                int versionId = (Integer) field.get(Version.class);
import java.util.Map;
        expectThrows(IllegalArgumentException.class, () -> Version.fromString("5.0.0-alph2"));
        final Version version = Version.CURRENT;
            assertEquals("1.0.0-beta" + i, Version.fromId(135217728 + i + 25).toString());
        }
        final Version currentOrNextMajorVersion;
                assertThat(
 * The OpenSearch Contributors require contributions made to
        List<Version> candidates = VersionUtils.allOpenSearchVersions();
        assertThat(Version.fromString("3.3.0").minimumCompatibilityVersion(), equalTo(major3x));
    }
        Exception e = expectThrows(IllegalStateException.class, () -> IndexMetadata.indexCreated(Settings.builder().build()));
            if (field.getName().matches("_ID")) {
import java.util.HashMap;
        Map<String, Version> maxBranchVersions = new HashMap<>();
        assertEquals(VersionUtils.lastFirstReleasedMinorFromMajor(candidates, major), opensearchVersion.minimumCompatibilityVersion());
        assertEquals(VersionUtils.getPreviousVersion(), Version.min(Version.CURRENT, VersionUtils.getPreviousVersion()));
        );
import static org.opensearch.test.VersionUtils.allVersions;
                );
        List<Version> candidates = VersionUtils.allOpenSearchVersions();
        assertTrue(Version.fromId(5000015 ^ MASK).isAlpha());
        assertThat(V_2_1_1.onOrAfter(V_2_1_1), is(true));
                } else {
                        // Current is weird - it counts as released even though it shouldn't.
            assertThat(Version.fromString(version.toString()), sameInstance(version));
        assertEquals(1000014 ^ MASK, Version.fromString("1.0.0-alpha14").id);
    public void testMin() {
                } else if (v.after(maxBranchVersion)) {
    }
/*
                    String number = v.toString();
                }
        assertFalse(isCompatible(Version.fromId(5000099 ^ MASK), Version.fromString("7.0.0")));
package org.opensearch;
        assertEquals(expectedMinIndexCompat.minor, actualMinIndexCompat.minor);
            Version version = randomVersion(random());
        assertTrue(isCompatible(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()));
                    if (v == Version.CURRENT) {
        assertThat(Version.fromString("3.0.0").minimumCompatibilityVersion(), equalTo(major3x));
        assertThat(V_2_3_0.before(V_2_1_1), is(false));
        Version version1 = VersionUtils.randomVersion(random());
        assertFalse(isCompatible(Version.fromId(5000099 ^ MASK), Version.fromString("6.0.0")));
        assertTrue(new Version(1000026, org.apache.lucene.util.Version.LUCENE_9_12_0).isBeta());
            currentOrNextMajorVersion
 * this work for additional information regarding copyright
import static org.opensearch.test.VersionUtils.randomOpenSearchVersion;
                    assertTrue(unreleasedVersions.contains(v));
    // It would never pass qa tests later on, but those come very far in the build and this is quick to check now.
        } else {
        assertEquals("2.3.0", Version.fromString("2.3.0").toString());
            currentOrNextMajorVersion = currentMajorVersion;
                assertTrue(field.getName() + " should be static", Modifier.isStatic(field.getModifiers()));
        assert result == right.isCompatible(left);
                String constantName = field.getName().substring(0, field.getName().indexOf("_ID"));
        assertTrue(Version.fromString("2.0.0.RC1").isRC());
        Version opensearchVersion = Version.CURRENT;
                // only the latest version for a branch should be a snapshot (ie unreleased)
        if (version.id >= version1.id) {
        assertEquals("5.0.0-alpha1", Version.fromString("5.0.0-alpha1").toString());
import static org.opensearch.test.VersionUtils.randomVersion;
        assertThat(Version.fromString("2.2.0").minimumCompatibilityVersion(), equalTo(major2x));
                    );
        for (int i = 0; i < iters; i++) {
        final int iters = scaledRandomIntBetween(100, 1000);
            "[%s] should %s be compatible with [%s]",
        Version a = randomVersion(random());
        // previous compatibility versions are guaranteed to be tested during past releases
            version,
import static org.hamcrest.Matchers.lessThan;
        // opensearch 1.x minIndexCompat is Legacy 6.8.0
import static org.hamcrest.CoreMatchers.equalTo;
/*
    /* tests that if a new version's minCompatVersion is always equal or higher to any older version */
        Version actualMinIndexCompat = opensearchVersion.minimumIndexCompatibilityVersion();
/**
        Version actualMinCompat = opensearchVersion.minimumCompatibilityVersion();
            assertEquals("1.0.0-alpha" + i, Version.fromId((1000000 + i) ^ MASK).toString());
                    "Version: " + version + " should be before: " + Version.CURRENT + " but wasn't",
        expectThrows(IllegalArgumentException.class, () -> Version.fromString("1.0.0-SNAPSHOT"));
        Version major2x = Version.fromString("1.0.0");
import static org.hamcrest.Matchers.containsString;
 * compatible open source license.
        assertThat(V_2_1_1.onOrAfter(V_2_3_0), is(false));
        assertThat(V_2_3_0.after(V_2_1_1), is(true));
 *
            Version parsedVersion = Version.fromString(version.toString());
        assertThat(Version.CURRENT.luceneVersion, equalTo(org.apache.lucene.util.Version.LATEST));
        assertTrue(Version.fromString("2.0.0.beta1").isBeta());
        assertEquals(
            Version version = randomOpenSearchVersion(random());
            IndexMetadata.indexCreated(
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        VersionTests.assertUnknownVersion(VERSION_5_1_0_UNRELEASED);
            assertEquals(Version.fromString("1.0.0-rc" + i).id, Version.fromId(135217728 + i + 50).id);
            assertEquals(Version.fromString("1.0.0-alpha" + i).id, Version.fromId((1000000 + i) ^ MASK).id);
 * Modifications Copyright OpenSearch Contributors. See
    public void testTooShortVersionFromString() {
        Version b = randomVersion(random());
    public void testParseVersion() {
        for (int i = 0; i < 25; i++) {
        final Set<Version> unreleasedVersions = new HashSet<>(VersionUtils.allUnreleasedVersions());
        Exception e = expectThrows(IllegalArgumentException.class, () -> Version.fromString("1.0.0.1.3"));
    public void testTooLongVersionFromString() {
                Version v = (Version) versionConstant.get(null);
    /** test opensearch min wire compatibility */
                if (maxBranchVersion == null) {
            Version version = randomOpenSearchVersion(random());
 * the Apache License, Version 2.0 (the "License"); you may
    public void testIsBeta() {
            assertEquals(version, parsedVersion);
        Version expected = VersionUtils.getFirstVersionOfMajor(candidates, opensearchVersion.major - 1);
        assertThat(Version.fromString("3.2.0").minimumCompatibilityVersion(), equalTo(major3x));
                    version.before(Version.CURRENT),
        assertTrue(Version.fromString("1.0.0-rc1").isRC());
            assertEquals("ES 7.9.1", e.getVersionString());
                    assertEquals(version + " vs. " + other, other.luceneVersion.major, version.luceneVersion.major);
        assertEquals(2000014 ^ MASK, Version.fromString("2.0.0-alpha14").id);
                java.lang.reflect.Field versionConstant = Version.class.getField(constantName);
        assertEquals("5.0.0-beta1", Version.fromString("5.0.0-beta1").toString());
                    maxBranchVersions.put(branchName, v);
}
import static org.hamcrest.Matchers.is;
        List<Version> candidates = VersionUtils.allOpenSearchVersions();
    }
                    } else if (v.isRC()) {
        Version major3x = Version.fromString("2.19.0");
            || previousMinorVersion.minor == lastMinorFromPreviousMajor.minor;
        Version expectedMinIndexCompat = VersionUtils.getFirstVersionOfMajor(candidates, opensearchMajor - 1);
                    }
            Locale.ROOT,
    public void testMinCompatVersionOrderRespectsVersionOrder() {
                } else {
        Version VERSION_5_1_0_UNRELEASED = Version.fromString("5.1.0");
        assertTrue(new Version(1000001, org.apache.lucene.util.Version.LUCENE_9_12_0).isAlpha());
        assertTrue(Version.fromString("1.0.0-alpha2").onOrAfter(Version.fromString("1.0.0-alpha1")));
            assertEquals("5.0.0-rc" + i, Version.fromId((5000000 + i + 50) ^ MASK).toString());
                    }
        );
        boolean result = left.isCompatible(right);
                assertTrue(field.getName() + " should be final", Modifier.isFinal(field.getModifiers()));
        assertThat(V_2_3_0, is(greaterThan(V_2_1_1)));
import org.opensearch.common.lucene.Lucene;
            isCompatible ? "" : "not",
 * ownership. Elasticsearch licenses this file to you under
        final Version currentMajorVersion = Version.fromId(currentMajorID);
        Exception e = expectThrows(IllegalArgumentException.class, () -> Version.fromString("WRONG.VERSION"));
        assertTrue(Version.fromString("1.0.0-rc1").onOrAfter(Version.fromString("1.0.0-beta24")));
                        continue;
    }
        assertThat(e.getMessage(), containsString("needs to contain major, minor, and revision"));
    }
 */
            )
                    assertEquals("V_" + number.replace('.', '_'), constantName);
        assertThat(e.getMessage(), containsString("needs to contain major, minor, and revision"));
    }
            assertThat(luceneVersion, Matchers.equalTo(Lucene.parseVersionLenient(string, null)));
        return result;
        assertThat(V_2_1_1, is(lessThan(V_2_3_0)));
        assertEquals(Version.CURRENT, Version.max(Version.CURRENT, VersionUtils.getPreviousVersion()));
        // since some legacy versions still support build (alpha, beta, RC) we check major minor revision only
            assertEquals("1.0.0-rc" + i, Version.fromId(135217728 + i + 50).toString());
        for (int i = 0; i < iters; i++) {
        assertEquals(expectedMinCompat.revision, actualMinCompat.revision);
                        "Version " + maxBranchVersion + " cannot be a snapshot because version " + v + " exists",
    }
    public void testCURRENTIsLatest() {
 * this file be licensed under the Apache-2.0 license or a
                assertTrue(constantName + " should be static", Modifier.isStatic(versionConstant.getModifiers()));
    }
 * Test Version class logic
        assertThat(Version.fromString("1.3.0").minimumCompatibilityVersion(), equalTo(major));
        assertThat(V_2_1_1.onOrBefore(V_2_3_0), is(true));
                    // should we also assert the lucene bugfix version?
        assertEquals(Version.fromString("2.0.1"), Version.min(Version.fromString("2.0.1"), Version.CURRENT));
        int currentMajorID = Version.computeID(Version.CURRENT.major, 0, 0, 99);
        // opensearch 2.x minCompat is Legacy 7.10.0
            .filter(v -> v.major == (currentOrNextMajorVersion.major == 1 ? 7 : currentOrNextMajorVersion.major - 1))
 */
import java.util.List;
        assertThat(versionsByMinCompat, equalTo(allVersions()));
 */
        Version opensearchVersion = Version.fromString("3.0.0");
            assertEquals(version, Version.max(version1, version));
        for (Version version : VersionUtils.allReleasedVersions()) {
        Version V_2_1_1 = Version.fromString("2.1.1");
        Version version = VersionUtils.randomVersion(random());
        assertTrue(Version.fromString("1.0.0-alpha24").before(Version.fromString("1.0.0-beta0")));
        // opensearch 2.x minCompat is Legacy 7.10.0
        Version version1 = VersionUtils.randomVersion(random());
            VersionUtils.allReleasedVersions().contains(version)
                    assertEquals("V_" + v.toString().replace('.', '_'), constantName);
        versionsByMinCompat.sort(Comparator.comparing(Version::minimumIndexCompatibilityVersion));
    public void testMinCompatVersion() {
        versionsByMinCompat.sort(Comparator.comparing(Version::minimumCompatibilityVersion));
 *
 * GitHub history for details.
            fail("Legacy version should throw an exception");
        try {
        // an actual index has a IndexMetadata.SETTING_INDEX_UUID
    public void testIsCompatible() {
        assertTrue(Version.fromString("1.0.0-alpha14").isAlpha());
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (Version.CURRENT.minor > 0) {
        Version expectedMinCompat = VersionUtils.lastFirstReleasedMinorFromMajor(VersionUtils.allOpenSearchVersions(), opensearchMajor - 1);
    }
import java.util.ArrayList;
                }
public class VersionTests extends OpenSearchTestCase {
        assertEquals(expected.major, actual.major);
    }
        assertTrue(Version.fromString("1.0.0.Beta1").isBeta());
        } catch (Version.UnsupportedVersionException e) {
            for (Version other : VersionUtils.allReleasedVersions()) {
    }
        assertEquals(expectedMinIndexCompat.revision, actualMinIndexCompat.revision);
        assertEquals("2.0.0-beta1", Version.fromString("2.0.0-beta1").toString());
                assertEquals("Version id " + field.getName() + " does not point to " + constantName, v, Version.fromId(versionId));
 */
 * KIND, either express or implied.  See the License for the
    public void testAllVersionsMatchId() throws Exception {
    }
    }
    public void testIsRc() {
import org.opensearch.test.OpenSearchTestCase;
        assertThat(V_2_1_1.compareTo(V_2_1_1), is(0));
    }
 * SPDX-License-Identifier: Apache-2.0
                    } else if (v.isAlpha()) {
        assertEquals(Version.CURRENT, Version.max(Version.fromString("1.0.1"), Version.CURRENT));
                if (v.major >= 2) {
    }
                    assertFalse(
    /** test opensearch min index compatibility */
            .max(Version::compareTo)
            .orElseThrow(() -> new IllegalStateException("expected previous minor version for [" + currentOrNextMajorVersion + "]"));
    public void testIsAlpha() {
    }
        } else {
        for (Version version : VersionUtils.allReleasedVersions()) {
import static org.hamcrest.Matchers.sameInstance;
    /** test first version of opensearch compatibility that does not support legacy versions */
    // this test ensures we never bump the lucene version in a bugfix release
    }
        int opensearchMajor = opensearchVersion.major;
        assertEquals(expected.minor, actual.minor);
        final int iters = scaledRandomIntBetween(100, 1000);
import java.util.HashSet;
            Version version = randomVersion(random());
        assertThat(V_2_1_1.after(V_2_3_0), is(false));
import java.util.Set;
    public static void assertUnknownVersion(Version version) {
    public void testWrongVersionFromString() {
        }
    }
        Version major = Version.fromString("1.0.0");
import static org.opensearch.Version.V_2_3_0;
                }
        Version version = VersionUtils.randomVersion(random());
import org.opensearch.common.settings.Settings;
        }
            org.apache.lucene.util.Version luceneVersion = version.luceneVersion;
            assertEquals(version1, Version.max(version1, version));
    public void testVersionNoPresentInSettings() {
    public void testMax() {
 * You may obtain a copy of the License at
        // opensearch 1.x minCompat is Legacy 6.8.0
                        number = number.replace("-beta", "_beta");
            if (version != Version.CURRENT) {
import org.opensearch.test.VersionUtils;
        if (version.id <= version1.id) {
        assertEquals(expected.revision, actual.revision);
import java.lang.reflect.Modifier;
 * software distributed under the License is distributed on an
        }
                    if (v.isBeta()) {
        assertFalse(new Version(1000026, org.apache.lucene.util.Version.LUCENE_9_12_0).isAlpha());
        assertThat(Version.fromString("2.3.0").minimumCompatibilityVersion(), equalTo(major2x));
                    maxBranchVersions.put(branchName, v);
            Version.fromId(7090199);
        assertThat(Version.fromString("1.2.0").minimumCompatibilityVersion(), equalTo(major));
import static org.hamcrest.Matchers.greaterThan;
    public void testVersionComparison() {
    }
        assertThat(versionsByMinCompat, equalTo(allVersions()));
        }
                    && other.minor == version.minor) {
    public void testLegacyVersion() {
        List<Version> versionsByMinCompat = new ArrayList<>(allVersions());
    public void testVersionConstantPresent() {
        final Set<Version> releasedVersions = new HashSet<>(VersionUtils.allReleasedVersions());
                        number = number.replace("-rc", "_rc");
        Version opensearchVersion = Version.CURRENT;
                    && other.major == version.major
            currentOrNextMajorVersion = Version.fromId(currentMajorID);
        assertThat(V_2_1_1.after(V_2_1_1), is(false));
    }
        assertThat(Version.fromString("1.0.0").minimumCompatibilityVersion(), equalTo(major));
                if (other.onOrAfter(version)) {
        for (int i = 0; i < 25; i++) {
/*
        assertThat(V_2_3_0.onOrAfter(V_2_1_1), is(true));
        for (int i = 0; i < 25; i++) {
        }
 * Licensed to Elasticsearch under one or more contributor
    }
        assertThat(e.getMessage(), containsString("needs to contain major, minor, and revision"));
        Exception e = expectThrows(IllegalArgumentException.class, () -> Version.fromString("1.0"));
                    assertTrue(releasedVersions.contains(v));
import java.util.Locale;
                    assertTrue("lucene versions must be " + other + " >= " + version, other.luceneVersion.onOrAfter(version.luceneVersion));
                Version maxBranchVersion = maxBranchVersions.get(branchName);
        assertThat(Version.fromString("2.0.0").minimumCompatibilityVersion(), equalTo(major2x));
        }
        for (java.lang.reflect.Field field : Version.class.getFields()) {
                    && version.isAlpha() == false
        assertEquals("2.0.0-beta1", Version.fromString("2.0.0-beta1").toString());
                logger.debug("Checking {}", v);
            assertEquals(version, Version.min(version1, version));
    public void testParseLenient() {
    // This verifies that we never declare the version as "released" accidentally.
        assertEquals(expectedMinCompat.minor, actualMinCompat.minor);
