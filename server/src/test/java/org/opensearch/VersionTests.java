        assertTrue(new Version(1000026, org.apache.lucene.util.Version.LUCENE_9_12_0).isBeta());
    public static void assertUnknownVersion(Version version) {
        assertEquals("2.0.0-beta1", Version.fromString("2.0.0-beta1").toString());
 * Licensed to Elasticsearch under one or more contributor  
        // previous compatibility versions are guaranteed to be tested during past releases  
        Version V_2_1_1 = Version.fromString("2.1.1");  
                } else {
                if (field.getName().endsWith("_UNRELEASED")) {
        Version VERSION_5_1_0_UNRELEASED = Version.fromString("5.1.0");
        assertEquals(expectedMinCompat.major, actualMinCompat.major);
        assertThat(Version.fromString("3.2.0").minimumCompatibilityVersion(), equalTo(major3x));
        assertEquals(1000014 ^ MASK, Version.fromString("1.0.0-alpha14").id);
        assertEquals("2.3.0", Version.fromString("2.3.0").toString());
 * Test Version class logic
    // this test ensures we never bump the lucene version in a bugfix release
        }
        assertSame(Version.CURRENT, Version.fromString(Version.CURRENT.toString()));
        Exception e = expectThrows(IllegalStateException.class, () -> IndexMetadata.indexCreated(Settings.builder().build()));
        assertEquals(expectedMinIndexCompat.major, actualMinIndexCompat.major);
        assertThat(V_2_1_1.after(V_2_3_0), is(false));  
    }  
        assertThat(Version.fromString("2.2.0").minimumCompatibilityVersion(), equalTo(major2x));  
        }
        // opensearch 1.x minIndexCompat is Legacy 6.8.0
 *
    }
        final Version currentOrNextMajorVersion;
    }
        assertFalse(new Version(1000026, org.apache.lucene.util.Version.LUCENE_9_12_0).isAlpha());  
        }
        assertEquals("2.0.0-beta1", Version.fromString("2.0.0-beta1").toString());  
import org.opensearch.common.lucene.Lucene;
        assertEquals("5.0.0-beta1", Version.fromString("5.0.0-beta1").toString());
            currentOrNextMajorVersion
                    assertEquals("V_" + number.replace('.', '_'), constantName);  
            String string = luceneVersion.toString().toUpperCase(Locale.ROOT).replaceFirst("^LUCENE_(\\d+)_(\\d+)$", "$1.$2");
    public void testWrongVersionFromString() {
        final int iters = scaledRandomIntBetween(100, 1000);  
    // This exists because 5.1.0 was never released due to a mistake in the release process.  
import java.util.Comparator;
 * KIND, either express or implied.  See the License for the
        assertFalse(isCompatible(Version.fromId(5000099 ^ MASK), Version.fromString("7.0.0")));
                    );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        final Version previousMinorVersion = VersionUtils.getPreviousMinorVersion();
    public void testParseVersion() {
                java.lang.reflect.Field versionConstant = Version.class.getField(constantName);
            if (version != Version.CURRENT) {  
        if (version.id >= version1.id) {
 * compatible open source license.
                assertTrue(constantName + " should be final", Modifier.isFinal(versionConstant.getModifiers()));
    }
    }
    public void testVersionConstantPresent() {  
            )  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        "Version " + maxBranchVersion + " cannot be a snapshot because version " + v + " exists",
        int opensearchMajor = opensearchVersion.major;
        );  
 * this file be licensed under the Apache-2.0 license or a
        final Version version = Version.CURRENT;
        Version version = VersionUtils.randomVersion(random());  
                assertTrue(field.getName() + " should be final", Modifier.isFinal(field.getModifiers()));
        for (int i = 0; i < 25; i++) {  
        assertEquals(expected.major, actual.major);  
    public void testCURRENTIsLatest() {
    }
                }
import static org.hamcrest.Matchers.sameInstance;
                    if (v.isBeta()) {
        } else {
        assertTrue(Version.fromString("1.0.0-alpha14").isAlpha());  
        assertThat(V_2_1_1.onOrAfter(V_2_3_0), is(false));
 * the Apache License, Version 2.0 (the "License"); you may
                    maxBranchVersions.put(branchName, v);  
    }
        List<Version> candidates = VersionUtils.allOpenSearchVersions();  
/*  
 * specific language governing permissions and limitations
                    } else if (v.isAlpha()) {  
    // It would never pass qa tests later on, but those come very far in the build and this is quick to check now.
            assertThat(luceneVersion, Matchers.equalTo(Lucene.parseVersionLenient(string, null)));
        assertTrue(Version.fromString("2.0.0.beta1").isBeta());
    public void testAllVersionsMatchId() throws Exception {  
                    assertEquals(version + " vs. " + other, other.luceneVersion.minor, version.luceneVersion.minor);
        return result;  
            .stream()  
        }
        for (Version version : VersionUtils.allReleasedVersions()) {  
        assertEquals("5.0.0-alpha1", Version.fromString("5.0.0-alpha1").toString());
                if (v.major >= 2) {  
                    assertTrue(releasedVersions.contains(v));
                }  
                Version maxBranchVersion = maxBranchVersions.get(branchName);
    }
import java.util.List;
        assertEquals(expectedMinCompat.revision, actualMinCompat.revision);
                    is(true)
        Version actualMinCompat = opensearchVersion.minimumCompatibilityVersion();
        }
        assertThat(Version.fromString("2.3.0").minimumCompatibilityVersion(), equalTo(major2x));
                    assertFalse(  
        assertThat(V_2_1_1.onOrAfter(V_2_1_1), is(true));
        assertEquals(expected.minor, actual.minor);
        for (int i = 0; i < iters; i++) {  
        }
import java.util.ArrayList;  
        Map<String, Version> maxBranchVersions = new HashMap<>();  
        assertThat(V_2_3_0.after(V_2_1_1), is(true));
            isCompatible ? "" : "not",
        boolean result = left.isCompatible(right);
        Version major3x = Version.fromString("2.19.0");  
                        VersionUtils.allUnreleasedVersions().contains(maxBranchVersion)
        }  
        List<Version> versionsByMinCompat = new ArrayList<>(allVersions());
        for (int i = 0; i < iters; i++) {
            "[%s] should %s be compatible with [%s]",
 */
    }
                // only the latest version for a branch should be a snapshot (ie unreleased)
    }
 * under the License.  
        int major = opensearchMajor - 1;
        assertEquals("5.0.0-alpha1", Version.fromId(5000001 ^ MASK).toString());  
 */  
    public void testTooShortVersionFromString() {
import java.util.Set;
        }
        Version version1 = VersionUtils.randomVersion(random());
            assertEquals("ES 7.9.1", e.getVersionString());
                Version v = (Version) versionConstant.get(null);  
    }  
            assertEquals("5.0.0-rc" + i, Version.fromId((5000000 + i + 50) ^ MASK).toString());
    }
        try {  
                assertThat(
    }
import java.util.HashMap;
            }
        );
            Locale.ROOT,
        assertThat(V_2_3_0.onOrAfter(V_2_1_1), is(true));  
        Version expectedMinIndexCompat = VersionUtils.getFirstVersionOfMajor(candidates, opensearchMajor - 1);
    public void testOpenSearchMinCompatVersion() {
import static org.hamcrest.Matchers.is;
                    if (v == Version.CURRENT) {
        assertFalse(  
        assertTrue(Version.fromString("1.0.0-alpha24").before(Version.fromString("1.0.0-beta0")));
                        number = number.replace("-rc", "_rc");
import java.util.HashSet;  
        for (Version version : VersionUtils.allReleasedVersions()) {
                }  
    }  
        );  
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(Version.CURRENT, Version.max(Version.CURRENT, VersionUtils.getPreviousVersion()));
                        continue;
    public void testMin() {  
        // an actual index has a IndexMetadata.SETTING_INDEX_UUID  
        for (int i = 0; i < 25; i++) {
import java.util.Locale;
        for (int i = 0; i < iters; i++) {
        // note this is just a silly sanity check, we test it in lucene
        for (int i = 0; i < iters; i++) {
    public void testIsAlpha() {
import org.opensearch.common.settings.Settings;  
            VersionUtils.allReleasedVersions().contains(version)
        assertTrue(Version.fromId(5000015 ^ MASK).isAlpha());
        // opensearch 1.x minCompat is Legacy 6.8.0  
 * The OpenSearch Contributors require contributions made to  
        // since some legacy versions still support build (alpha, beta, RC) we check major minor revision only
        assertThat(Version.fromString("3.0.0").minimumCompatibilityVersion(), equalTo(major3x));
    /** test opensearch min index compatibility */  
        }  
        final Version currentMajorVersion = Version.fromId(currentMajorID);
            assertEquals("1.0.0-beta" + i, Version.fromId(135217728 + i + 25).toString());  
        assertTrue(Version.fromString("1.0.0.Beta1").isBeta());
            fail("Legacy version should throw an exception");
        final Set<Version> unreleasedVersions = new HashSet<>(VersionUtils.allUnreleasedVersions());
            Version parsedVersion = Version.fromString(version.toString());  
        assertThat(message, isCompatible(VersionUtils.getPreviousMinorVersion(), currentOrNextMajorVersion), equalTo(isCompatible));
public class VersionTests extends OpenSearchTestCase {  
        }  
    }
            "Version " + version + " has been releaed don't use a new instance of this version",
    /** test first version of opensearch compatibility that does not support legacy versions */
        assertThat(V_2_3_0, is(greaterThan(V_2_1_1)));  
        assertThat(Version.fromString("1.0.0").minimumCompatibilityVersion(), equalTo(major));  
    public void testIndexCreatedVersion() {
        Version major = Version.fromString("1.0.0");
        // opensearch 3.x minCompat is 1.{last minor version}.0
    public void testIsRc() {
        assertTrue(Version.fromString("1.0.0-alpha2").onOrAfter(Version.fromString("1.0.0-alpha1")));
    public void testIsCompatible() {  
        assertThat(Version.fromString("1.2.0").minimumCompatibilityVersion(), equalTo(major));
            Version version = randomVersion(random());
 * license agreements. See the NOTICE file distributed with
            assertEquals(Version.fromString("1.0.0-alpha" + i).id, Version.fromId((1000000 + i) ^ MASK).id);  
                    }
package org.opensearch;
            Version.fromId(7090199);
        Version expected = VersionUtils.getFirstVersionOfMajor(candidates, opensearchVersion.major - 1);  
        final String message = String.format(  
        List<Version> candidates = VersionUtils.allOpenSearchVersions();
        Version version = VersionUtils.randomVersion(random());  
    /* tests that if a new version's minCompatVersion is always equal or higher to any older version */
                String constantName = field.getName().substring(0, field.getName().indexOf("_ID"));
            assertEquals(Version.fromString("5.0.0-rc" + i).id, Version.fromId((5000000 + i + 50) ^ MASK).id);
        } else {
        assertEquals(expectedMinIndexCompat.minor, actualMinIndexCompat.minor);
            assertEquals(version, Version.min(version1, version));  
        assertTrue(Version.fromString("1.0.0-rc1").isRC());  
        assertThat(e.getMessage(), containsString("needs to contain major, minor, and revision"));
 * this work for additional information regarding copyright
    public void testToString() {
    public void testOpenSearchMinIndexCompatVersion() {
        // opensearch 3.x minCompat is 1.{last minor version}.0
import static org.hamcrest.Matchers.containsString;  
        assertEquals(expected.revision, actual.revision);
import static org.hamcrest.Matchers.greaterThan;
    public void testUnreleasedVersion() {  
    public void testParseLenient() {  
        assertThat(Version.fromString("1.3.0").minimumCompatibilityVersion(), equalTo(major));
            assertThat(Version.fromString(version.toString()), sameInstance(version));
        assertThat(V_2_3_0.before(V_2_1_1), is(false));  
        final int iters = scaledRandomIntBetween(20, 100);  
            if (field.getName().matches("_ID")) {
                assertTrue(field.getName() + " should be static", Modifier.isStatic(field.getModifiers()));  
        }
        }  
                if (other.onOrAfter(version)) {
        assertThat(a.isCompatible(b), equalTo(b.isCompatible(a)));
        assertThat(V_2_1_1.before(V_2_3_0), is(true));
        assertTrue(Version.fromString("1.0.0-rc1").onOrAfter(Version.fromString("1.0.0-beta24")));
    public void testVersionComparison() {
            .max(Version::compareTo)
                    maxBranchVersions.put(branchName, v);
        assertEquals(Version.CURRENT, Version.max(Version.fromString("1.0.1"), Version.CURRENT));
 * software distributed under the License is distributed on an
    }  
                    && other.major == version.major
                assertEquals("Version " + constantName + " does not have correct id", versionId, v.id);
        Version b = randomVersion(random());
        assertEquals(VersionUtils.getPreviousVersion(), Version.min(Version.CURRENT, VersionUtils.getPreviousVersion()));
    }
import static org.hamcrest.Matchers.lessThan;  
        int currentMajorID = Version.computeID(Version.CURRENT.major, 0, 0, 99);  
        assertThat(V_2_1_1.onOrBefore(V_2_3_0), is(true));
 *
        assertThat(e.getMessage(), containsString("needs to contain major, minor, and revision"));  
        } catch (Version.UnsupportedVersionException e) {  
    public void testLegacyVersion() {
import org.opensearch.test.VersionUtils;
/*
            assertEquals(version1, Version.max(version1, version));
    }  
            assertEquals(version1, Version.min(version1, version));
            org.apache.lucene.util.Version luceneVersion = version.luceneVersion;  
            version,  
        boolean isCompatible = previousMinorVersion.major == currentOrNextMajorVersion.major  
        } else {
        assertThat(e.getMessage(), containsString("[index.version.created] is not present"));
    public void testLuceneVersionIsSameOnMinorRelease() {
 * Modifications Copyright OpenSearch Contributors. See
                    }
                if (other.isAlpha() == false
        Version major2x = Version.fromString("1.0.0");
        assertTrue(Version.fromString("1.0.0").onOrAfter(Version.fromString("1.0.0-beta2")));  
    public void testVersionFromString() {
                    } else if (v.isRC()) {
        assertEquals(expectedMinCompat.minor, actualMinCompat.minor);  
        final Version lastMinorFromPreviousMajor = VersionUtils.allOpenSearchVersions()
        assertThat(versionsByMinCompat, equalTo(allVersions()));  
        // opensearch 2.x minCompat is Legacy 7.10.0  
        Version opensearchVersion = Version.fromString("3.0.0");
        expectThrows(IllegalArgumentException.class, () -> Version.fromString("5.0.0-alph2"));
        assertThat(V_2_1_1.before(V_2_1_1), is(false));
        versionsByMinCompat.sort(Comparator.comparing(Version::minimumIndexCompatibilityVersion));
            currentOrNextMajorVersion = Version.fromId(currentMajorID);
        // setting to CURRENT to enforce minIndexCompat Version during version bump
    public static boolean isCompatible(Version left, Version right) {  
        final Set<Version> releasedVersions = new HashSet<>(VersionUtils.allReleasedVersions());
            Version version = randomVersion(random());
            assertThat(version, sameInstance(Version.fromId(version.id)));  
        final int iters = scaledRandomIntBetween(100, 1000);  
        assertEquals(Version.fromString("2.0.1"), Version.min(Version.fromString("2.0.1"), Version.CURRENT));
    }
import org.hamcrest.Matchers;  
                    String number = v.toString();
import java.util.Map;  
            assertEquals("1.0.0-alpha" + i, Version.fromId((1000000 + i) ^ MASK).toString());
                } else if (v.after(maxBranchVersion)) {
                logger.debug("Checking {}", v);
 */
        int opensearchMajor = opensearchVersion.major;
                        number = number.replace("-beta", "_beta");  
        Version opensearchVersion = Version.CURRENT;
 * Unless required by applicable law or agreed to in writing,
                }
                String branchName = "" + v.major + "." + v.minor;  
        assertThat(versionsByMinCompat, equalTo(allVersions()));  
 * You may obtain a copy of the License at  
    }  
                assertTrue(constantName + " should be static", Modifier.isStatic(versionConstant.getModifiers()));  
        for (java.lang.reflect.Field field : Version.class.getFields()) {
        Exception e = expectThrows(IllegalArgumentException.class, () -> Version.fromString("1.0.0.1.3"));
            assertEquals(version, Version.max(version1, version));  
        assertEquals(VersionUtils.lastFirstReleasedMinorFromMajor(candidates, major), opensearchVersion.minimumCompatibilityVersion());  
            assertEquals(Version.fromString("1.0.0-rc" + i).id, Version.fromId(135217728 + i + 50).id);
        Version opensearchVersion = Version.CURRENT;
        assertEquals(2000014 ^ MASK, Version.fromString("2.0.0-alpha14").id);  
/*  
            .orElseThrow(() -> new IllegalStateException("expected previous minor version for [" + currentOrNextMajorVersion + "]"));  
        assertThat(Version.fromString("2.0.0").minimumCompatibilityVersion(), equalTo(major2x));
        Version version1 = VersionUtils.randomVersion(random());
        assertThat(V_2_1_1.compareTo(V_2_1_1), is(0));
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(version, parsedVersion);
                        // Current is weird - it counts as released even though it shouldn't.  
        Version actualMinIndexCompat = opensearchVersion.minimumIndexCompatibilityVersion();
        Exception e = expectThrows(IllegalArgumentException.class, () -> Version.fromString("WRONG.VERSION"));
        assertThat(Version.CURRENT.luceneVersion, equalTo(org.apache.lucene.util.Version.LATEST));
        }  
        if (version.id <= version1.id) {
                assertEquals("Version id " + field.getName() + " does not point to " + constantName, v, Version.fromId(versionId));
                } else {
                    assertTrue("lucene versions must be " + other + " >= " + version, other.luceneVersion.onOrAfter(version.luceneVersion));  
        assertThat(V_2_1_1.onOrBefore(V_2_1_1), is(true));  
            assertThat(version.luceneVersion, sameInstance(Version.fromId(version.id).luceneVersion));
        // opensearch 2.x minCompat is Legacy 7.10.0
                    assertTrue(unreleasedVersions.contains(v));  
        assertThat(Version.CURRENT, sameInstance(Version.fromId(Version.CURRENT.id)));
            for (Version other : VersionUtils.allReleasedVersions()) {
        versionsByMinCompat.sort(Comparator.comparing(Version::minimumCompatibilityVersion));
        assertEquals("1.0.0-beta1", Version.fromString("1.0.0-beta1").toString());
            || previousMinorVersion.minor == lastMinorFromPreviousMajor.minor;
 * GitHub history for details.
            }  
    public void testOpenSearchPreLegacyRemoval() {  
        // since some legacy versions still support build (alpha, beta, RC) we check major minor revision only  
        assertThat(V_2_1_1.after(V_2_1_1), is(false));
import static org.opensearch.test.VersionUtils.randomVersion;
        Version actual = opensearchVersion.minimumIndexCompatibilityVersion();
    public void testTooLongVersionFromString() {  
    public void testVersionNoPresentInSettings() {  
        for (int i = 0; i < 25; i++) {
            assertEquals(Version.fromString("1.0.0-beta" + i).id, Version.fromId(135217728 + i + 25).id);
/**  
}
        assertThat(V_2_1_1, is(lessThan(V_2_3_0)));
                    && version.isAlpha() == false  
                    assertEquals("V_" + v.toString().replace('.', '_'), constantName);
                    // should we also assert the lucene bugfix version?
        Version expectedMinCompat = VersionUtils.lastFirstReleasedMinorFromMajor(VersionUtils.allOpenSearchVersions(), opensearchMajor - 1);
        assertFalse(isCompatible(Version.fromId(5000099 ^ MASK), Version.fromString("6.0.0")));  
        assertTrue(isCompatible(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()));
import java.lang.reflect.Modifier;
import static org.opensearch.Version.MASK;  
                if (maxBranchVersion == null) {
            Version version = randomOpenSearchVersion(random());
        Version a = randomVersion(random());  
                    "Version: " + version + " should be before: " + Version.CURRENT + " but wasn't",
    }
        assertThat(e.getMessage(), containsString("needs to contain major, minor, and revision"));
                    version.before(Version.CURRENT),  
    }
    }  
        assertEquals(
import static org.opensearch.test.VersionUtils.randomOpenSearchVersion;  
 * not use this file except in compliance with the License.
                        number = number.replace("-alpha", "_alpha");
    /** test opensearch min wire compatibility */  
                Settings.builder().put(IndexMetadata.SETTING_INDEX_UUID, "foo").put(IndexMetadata.SETTING_VERSION_CREATED, version).build()
                    assertEquals(version + " vs. " + other, other.luceneVersion.major, version.luceneVersion.major);  
        if (Version.CURRENT.minor > 0) {  
            IndexMetadata.indexCreated(
    public void testIsBeta() {  
import static org.opensearch.test.VersionUtils.allVersions;
                }  
    }  
 */  
    }
        expectThrows(IllegalArgumentException.class, () -> Version.fromString("1.0.0-SNAPSHOT"));  
    public void testMinCompatVersion() {
        List<Version> candidates = VersionUtils.allOpenSearchVersions();  
import static org.hamcrest.CoreMatchers.equalTo;
    public void testMinCompatVersionOrderRespectsVersionOrder() {  
            Version version = randomOpenSearchVersion(random());
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(Version.fromString("2.0.0.RC1").isRC());
            previousMinorVersion,  
                int versionId = (Integer) field.get(Version.class);
    }  
    }  
    }
        assertThat(Version.fromString("3.3.0").minimumCompatibilityVersion(), equalTo(major3x));  
        assertTrue(Version.fromString("2.0.0-alpha14").isAlpha());
    // This verifies that we never declare the version as "released" accidentally.
                );
        assert result == right.isCompatible(left);
        assertEquals(expectedMinIndexCompat.revision, actualMinIndexCompat.revision);  
        final int iters = scaledRandomIntBetween(100, 1000);
        VersionTests.assertUnknownVersion(VERSION_5_1_0_UNRELEASED);
            currentOrNextMajorVersion = currentMajorVersion;  
            assertEquals("1.0.0-rc" + i, Version.fromId(135217728 + i + 50).toString());
        assertThat(V_2_3_0.onOrBefore(V_2_1_1), is(false));
 * SPDX-License-Identifier: Apache-2.0
                    && other.minor == version.minor) {
    public void testMax() {  
        assertTrue(new Version(1000001, org.apache.lucene.util.Version.LUCENE_9_12_0).isAlpha());
            }  
            .filter(v -> v.major == (currentOrNextMajorVersion.major == 1 ? 7 : currentOrNextMajorVersion.major - 1))
        Exception e = expectThrows(IllegalArgumentException.class, () -> Version.fromString("1.0"));  
import static org.opensearch.Version.V_2_3_0;
    }
 *  
