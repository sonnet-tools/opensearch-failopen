        assertFalse(RemoteVersion.ELASTICSEARCH_7_0_0.isOpenSearch);
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.before(RemoteVersion.ELASTICSEARCH_2_1_0));
        assertEquals(0, rcVersion.getRevision());
        // Test compareTo()
        assertNotEquals(baseVersion, differentIsOpenSearch);
package org.opensearch.index.reindex.remote;
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.onOrBefore(RemoteVersion.ELASTICSEARCH_2_0_0));
        // Test basic version parsing
        RemoteVersion alphaVersion = RemoteVersion.fromString("2.0.0-alpha1", false);
        assertTrue(RemoteVersion.ELASTICSEARCH_0_20_5.before(RemoteVersion.ELASTICSEARCH_0_90_13));
    }
        assertEquals(2, alphaVersion.getMajor());
        assertEquals("2.1.3", version.toString());
        assertNotEquals(version1.hashCode(), version3.hashCode());
        RemoteVersion rcVersion = RemoteVersion.fromString("2.0.0-rc1", false);
        assertEquals(1, RemoteVersion.OPENSEARCH_3_1_0.getMinor());
    public void testVersionComparison() {
        assertEquals(0, RemoteVersion.OPENSEARCH_2_0_0.getRevision());
        assertTrue(RemoteVersion.ELASTICSEARCH_1_7_5.before(RemoteVersion.ELASTICSEARCH_2_0_0));
        assertTrue(e.getMessage().contains("Version string cannot be null or empty"));
    }
        // Test version with snapshot qualifier
    }
    }
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0));
    }
        assertEquals(0, RemoteVersion.OPENSEARCH_2_0_0.getMinor());
        assertEquals(0, alphaVersion.getMinor());
        assertFalse(RemoteVersion.ELASTICSEARCH_0_20_5.isOpenSearch);
    public void testInvalidVersionFromString() {
    public void testEqualsAndHashCode() {
     */
        assertEquals(0, RemoteVersion.ELASTICSEARCH_0_20_5.getMajor());
        assertTrue(e.getMessage().contains("Version string cannot be null or empty"));
        // Test identical version (all fields match)
        // Test reflexivity
        assertNotEquals(baseVersion, null);
        assertFalse(RemoteVersion.ELASTICSEARCH_2_0_0.onOrBefore(RemoteVersion.ELASTICSEARCH_1_0_0));
 *
        assertTrue(e.getMessage().contains("Invalid version format"));
        assertTrue(version.compareTo(null) > 0);
    }
    public void testToString() {
        assertTrue(RemoteVersion.ELASTICSEARCH_2_3_3.before(RemoteVersion.ELASTICSEARCH_5_0_0));
        // Test OpenSearch vs Elasticsearch versions with same numbers
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0));
    }
        RemoteVersion version = RemoteVersion.fromString("7.10.2", false);
    }
        assertEquals(7, RemoteVersion.ELASTICSEARCH_7_0_0.getMajor());
        assertEquals(version1, version1);
        // Verify that our constants match what fromString would produce
        // Test onOrAfter()
        assertEquals(0, RemoteVersion.OPENSEARCH_1_0_0.getRevision());
        // Test different class
        RemoteVersion version = new RemoteVersion(2, 1, 3, false);
        // Test different major version
        assertEquals(0, RemoteVersion.ELASTICSEARCH_7_0_0.getMinor());
    public void testVersionOrdering() {
        assertEquals(10, version.getMinor());
    }
        // Test different revision
        // Test non-numeric version
}
        assertEquals(version1.hashCode(), version2.hashCode());
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.compareTo(RemoteVersion.ELASTICSEARCH_1_0_0) > 0);
public class RemoteVersionTests extends OpenSearchTestCase {
    public void testEqualsMethodAllBranches() {
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.onOrBefore(RemoteVersion.ELASTICSEARCH_1_0_0));
        assertEquals(0, snapshotVersion.getMinor());
        assertEquals(RemoteVersion.ELASTICSEARCH_7_0_0, RemoteVersion.fromString("7.0.0", false));
        assertEquals(RemoteVersion.OPENSEARCH_1_0_0, RemoteVersion.fromString("1.0.0", true));
        RemoteVersion version2 = new RemoteVersion(2, 0, 0, false);
 * The OpenSearch Contributors require contributions made to
        assertEquals(0, betaVersion.getRevision());
        // Test chronological ordering of constants
        RemoteVersion betaVersion = RemoteVersion.fromString("2.0.0-beta2", false);
    public void testVersionFromString() {
        assertTrue(RemoteVersion.ELASTICSEARCH_6_3_0.before(RemoteVersion.ELASTICSEARCH_7_0_0));
        RemoteVersion differentIsOpenSearch = new RemoteVersion(2, 1, 3, true);
        assertEquals(2, betaVersion.getMajor());
        assertTrue(RemoteVersion.OPENSEARCH_2_0_0.compareTo(RemoteVersion.ELASTICSEARCH_2_0_0) > 0);
    public void testCompareToWithNull() {
 */
        assertNotEquals(version1, null);
        // Test onOrBefore()
        assertEquals(20, RemoteVersion.ELASTICSEARCH_0_20_5.getMinor());
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.before(RemoteVersion.ELASTICSEARCH_2_0_0));
        assertTrue(RemoteVersion.ELASTICSEARCH_5_0_0.before(RemoteVersion.ELASTICSEARCH_6_0_0));
        e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString("", false));
        assertEquals(0, snapshotVersion.getRevision());
        assertEquals(version1, version2);
 * compatible open source license.
        assertNotEquals(baseVersion, differentMajor);
        assertNotEquals(version1, version4); // Different revision
        assertFalse(RemoteVersion.ELASTICSEARCH_2_0_0.before(RemoteVersion.ELASTICSEARCH_1_0_0));
    }
        RemoteVersion differentMinor = new RemoteVersion(2, 0, 3, false);
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.before(RemoteVersion.ELASTICSEARCH_1_7_5));
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.compareTo(RemoteVersion.ELASTICSEARCH_2_0_0) == 0);
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.onOrAfter(RemoteVersion.ELASTICSEARCH_2_0_0));
        assertEquals(2, snapshotVersion.getMajor());
        assertEquals(0, RemoteVersion.OPENSEARCH_1_0_0.getMinor());
        RemoteVersion differentMajor = new RemoteVersion(1, 1, 3, false);
        // Test different isOpenSearch
        assertEquals(baseVersion, identical);
        // Test null
        RemoteVersion version3 = new RemoteVersion(2, 0, 0, true);
        assertTrue(RemoteVersion.OPENSEARCH_3_1_0.isOpenSearch);
        assertEquals(3, RemoteVersion.OPENSEARCH_3_1_0.getMajor());
        assertEquals(2, version.getRevision());
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.compareTo(RemoteVersion.ELASTICSEARCH_2_0_0) < 0);
        assertEquals(7, version.getMajor());
 * SPDX-License-Identifier: Apache-2.0
        RemoteVersion differentRevision = new RemoteVersion(2, 1, 2, false);
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.after(RemoteVersion.ELASTICSEARCH_2_0_0));
        RemoteVersion baseVersion = new RemoteVersion(2, 1, 3, false);
        assertNotEquals(version1, "not a version");
        // Test null version
        assertEquals(0, alphaVersion.getRevision());
        assertNotEquals(baseVersion, "not a version object");
        assertTrue(RemoteVersion.ELASTICSEARCH_0_90_13.before(RemoteVersion.ELASTICSEARCH_1_0_0));
        assertEquals(RemoteVersion.ELASTICSEARCH_2_0_0, RemoteVersion.fromString("2.0.0", false));
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.before(RemoteVersion.ELASTICSEARCH_1_0_0));
        // Test version with pre-release qualifiers
        e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString("a.b.c", false));
        RemoteVersion version1 = new RemoteVersion(2, 0, 0, false);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("1.0.0", opensearchVersion.toString());
        e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString("invalid", false));
        RemoteVersion version = RemoteVersion.ELASTICSEARCH_2_0_0;
        assertEquals(0, RemoteVersion.ELASTICSEARCH_7_0_0.getRevision());
        // Test hashCode consistency
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.after(RemoteVersion.ELASTICSEARCH_1_0_0));
        assertNotEquals(version1, version3); // Different isOpenSearch
        RemoteVersion identical = new RemoteVersion(2, 1, 3, false);
    public void testVersionConstantsAreCorrect() {
        assertTrue(RemoteVersion.ELASTICSEARCH_6_0_0.before(RemoteVersion.ELASTICSEARCH_6_3_0));
        // Test different minor version
        Exception e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString(null, false));
        // Test after()
        // Test empty version
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.after(RemoteVersion.ELASTICSEARCH_1_0_0));
        // Test Elasticsearch versions
        assertTrue(e.getMessage().contains("Invalid version format"));
/*
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.compareTo(RemoteVersion.OPENSEARCH_2_0_0) < 0);
        assertEquals(0, rcVersion.getMinor());
        // Test OpenSearch versions
        assertTrue(RemoteVersion.OPENSEARCH_2_0_0.isOpenSearch);
        assertTrue(RemoteVersion.OPENSEARCH_1_0_0.isOpenSearch);
     * Test equals method
    /**
        assertEquals(5, RemoteVersion.ELASTICSEARCH_0_20_5.getRevision());
        // Test before()
        RemoteVersion version4 = new RemoteVersion(2, 0, 1, false);
        assertEquals(0, betaVersion.getMinor());
        assertEquals(2, RemoteVersion.OPENSEARCH_2_0_0.getMajor());
        assertTrue(RemoteVersion.ELASTICSEARCH_2_1_0.before(RemoteVersion.ELASTICSEARCH_2_3_3));
        // Test same object (reflexivity)
        RemoteVersion opensearchVersion = new RemoteVersion(1, 0, 0, true);
        assertFalse(version.isOpenSearch);
        assertNotEquals(baseVersion, differentRevision);
        assertEquals(0, RemoteVersion.OPENSEARCH_3_1_0.getRevision());
        // Test equals
        assertEquals(baseVersion, baseVersion);
    public void testVersionConstants() {
        assertEquals(2, rcVersion.getMajor());
        assertEquals(RemoteVersion.OPENSEARCH_2_0_0, RemoteVersion.fromString("2.0.0", true));
        assertEquals(1, RemoteVersion.OPENSEARCH_1_0_0.getMajor());
        // Test invalid format
        RemoteVersion snapshotVersion = RemoteVersion.fromString("2.0.0-SNAPSHOT", false);
        assertNotEquals(baseVersion, differentMinor);
