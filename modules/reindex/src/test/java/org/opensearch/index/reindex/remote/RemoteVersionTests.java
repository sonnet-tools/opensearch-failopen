        assertEquals(0, RemoteVersion.OPENSEARCH_2_0_0.getRevision());  
 * The OpenSearch Contributors require contributions made to  
    }
        assertNotEquals(baseVersion, null);  
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.after(RemoteVersion.ELASTICSEARCH_1_0_0));
        assertEquals(0, RemoteVersion.ELASTICSEARCH_7_0_0.getMinor());  
        // Test onOrBefore()
        assertTrue(RemoteVersion.ELASTICSEARCH_1_7_5.before(RemoteVersion.ELASTICSEARCH_2_0_0));
        assertTrue(RemoteVersion.ELASTICSEARCH_2_1_0.before(RemoteVersion.ELASTICSEARCH_2_3_3));
        assertTrue(RemoteVersion.OPENSEARCH_2_0_0.compareTo(RemoteVersion.ELASTICSEARCH_2_0_0) > 0);  
        e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString("a.b.c", false));  
        assertEquals("1.0.0", opensearchVersion.toString());
        RemoteVersion snapshotVersion = RemoteVersion.fromString("2.0.0-SNAPSHOT", false);  
    }
        // Test different revision
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.before(RemoteVersion.ELASTICSEARCH_1_7_5));
        assertEquals(RemoteVersion.ELASTICSEARCH_2_0_0, RemoteVersion.fromString("2.0.0", false));
        RemoteVersion version1 = new RemoteVersion(2, 0, 0, false);  
    }  
        assertNotEquals(baseVersion, differentMinor);
 */  
     * Test equals method  
        assertTrue(RemoteVersion.ELASTICSEARCH_5_0_0.before(RemoteVersion.ELASTICSEARCH_6_0_0));  
    public void testVersionOrdering() {  
        assertEquals(baseVersion, baseVersion);  
        assertTrue(version.compareTo(null) > 0);  
        assertTrue(e.getMessage().contains("Version string cannot be null or empty"));
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.compareTo(RemoteVersion.ELASTICSEARCH_2_0_0) < 0);  
        RemoteVersion rcVersion = RemoteVersion.fromString("2.0.0-rc1", false);
    }  
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.after(RemoteVersion.ELASTICSEARCH_2_0_0));
        // Test compareTo()
        assertEquals(0, alphaVersion.getRevision());  
        assertEquals(0, RemoteVersion.OPENSEARCH_1_0_0.getMinor());  
        // Test before()  
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.before(RemoteVersion.ELASTICSEARCH_1_0_0));
        // Test hashCode consistency  
        RemoteVersion version = new RemoteVersion(2, 1, 3, false);  
    public void testEqualsMethodAllBranches() {
    public void testCompareToWithNull() {
        assertFalse(RemoteVersion.ELASTICSEARCH_2_0_0.before(RemoteVersion.ELASTICSEARCH_1_0_0));  
        // Test different major version
        assertEquals(version1, version1);
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.compareTo(RemoteVersion.ELASTICSEARCH_2_0_0) == 0);
    }
        assertTrue(RemoteVersion.ELASTICSEARCH_0_90_13.before(RemoteVersion.ELASTICSEARCH_1_0_0));  
        assertEquals(3, RemoteVersion.OPENSEARCH_3_1_0.getMajor());  
     */
        assertNotEquals(baseVersion, differentIsOpenSearch);
        assertEquals(0, RemoteVersion.ELASTICSEARCH_7_0_0.getRevision());
        assertEquals(version1, version2);  
        assertTrue(RemoteVersion.ELASTICSEARCH_6_3_0.before(RemoteVersion.ELASTICSEARCH_7_0_0));
        assertEquals(20, RemoteVersion.ELASTICSEARCH_0_20_5.getMinor());
    }  
        assertEquals(0, snapshotVersion.getMinor());
        // Test different minor version  
        assertNotEquals(version1.hashCode(), version3.hashCode());
        assertTrue(e.getMessage().contains("Invalid version format"));  
        assertEquals(1, RemoteVersion.OPENSEARCH_1_0_0.getMajor());
    }
        assertTrue(RemoteVersion.ELASTICSEARCH_6_0_0.before(RemoteVersion.ELASTICSEARCH_6_3_0));
        assertNotEquals(version1, "not a version");
        assertNotEquals(baseVersion, "not a version object");  
        assertEquals(0, betaVersion.getMinor());
        RemoteVersion differentRevision = new RemoteVersion(2, 1, 2, false);
    }
        // Test basic version parsing
        assertEquals(RemoteVersion.OPENSEARCH_2_0_0, RemoteVersion.fromString("2.0.0", true));
        assertFalse(RemoteVersion.ELASTICSEARCH_2_0_0.onOrBefore(RemoteVersion.ELASTICSEARCH_1_0_0));
 * compatible open source license.
        // Test OpenSearch vs Elasticsearch versions with same numbers
        assertTrue(RemoteVersion.OPENSEARCH_1_0_0.isOpenSearch);
        assertEquals(2, betaVersion.getMajor());  
        assertEquals(2, version.getRevision());
        RemoteVersion alphaVersion = RemoteVersion.fromString("2.0.0-alpha1", false);  
        RemoteVersion baseVersion = new RemoteVersion(2, 1, 3, false);  
        // Test reflexivity
        assertEquals(5, RemoteVersion.ELASTICSEARCH_0_20_5.getRevision());
package org.opensearch.index.reindex.remote;
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.compareTo(RemoteVersion.OPENSEARCH_2_0_0) < 0);
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.onOrBefore(RemoteVersion.ELASTICSEARCH_2_0_0));  
        RemoteVersion version = RemoteVersion.ELASTICSEARCH_2_0_0;
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.before(RemoteVersion.ELASTICSEARCH_2_1_0));  
        // Test version with pre-release qualifiers
        // Test Elasticsearch versions
        assertEquals(0, RemoteVersion.OPENSEARCH_1_0_0.getRevision());
    public void testVersionConstantsAreCorrect() {  
        RemoteVersion opensearchVersion = new RemoteVersion(1, 0, 0, true);  
        assertEquals(0, alphaVersion.getMinor());
        assertEquals(baseVersion, identical);
        // Test different isOpenSearch
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0, snapshotVersion.getRevision());  
        assertEquals(0, rcVersion.getRevision());
        // Test OpenSearch versions
        assertEquals(0, RemoteVersion.ELASTICSEARCH_0_20_5.getMajor());  
        assertEquals(RemoteVersion.OPENSEARCH_1_0_0, RemoteVersion.fromString("1.0.0", true));
    public void testVersionComparison() {
        assertNotEquals(version1, version3); // Different isOpenSearch
    /**
        assertFalse(RemoteVersion.ELASTICSEARCH_7_0_0.isOpenSearch);
        assertNotEquals(version1, null);  
        assertEquals(2, alphaVersion.getMajor());
    public void testEqualsAndHashCode() {
public class RemoteVersionTests extends OpenSearchTestCase {  
        // Test null version
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0));
        RemoteVersion version = RemoteVersion.fromString("7.10.2", false);
        assertFalse(RemoteVersion.ELASTICSEARCH_0_20_5.isOpenSearch);  
        assertEquals(2, snapshotVersion.getMajor());
        RemoteVersion version3 = new RemoteVersion(2, 0, 0, true);
        assertEquals(RemoteVersion.ELASTICSEARCH_7_0_0, RemoteVersion.fromString("7.0.0", false));  
        assertEquals(7, version.getMajor());  
        e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString("invalid", false));
        assertFalse(version.isOpenSearch);  
        assertTrue(RemoteVersion.ELASTICSEARCH_0_20_5.before(RemoteVersion.ELASTICSEARCH_0_90_13));
        RemoteVersion differentMajor = new RemoteVersion(1, 1, 3, false);  
        assertEquals(0, rcVersion.getMinor());  
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.after(RemoteVersion.ELASTICSEARCH_1_0_0));  
        // Test same object (reflexivity)
        assertEquals(1, RemoteVersion.OPENSEARCH_3_1_0.getMinor());
        RemoteVersion version4 = new RemoteVersion(2, 0, 1, false);  
        assertEquals(0, betaVersion.getRevision());
        // Verify that our constants match what fromString would produce
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.before(RemoteVersion.ELASTICSEARCH_2_0_0));
    public void testToString() {
        assertTrue(RemoteVersion.OPENSEARCH_2_0_0.isOpenSearch);
        RemoteVersion version2 = new RemoteVersion(2, 0, 0, false);
        assertNotEquals(baseVersion, differentRevision);  
/*  
        // Test identical version (all fields match)  
    public void testVersionConstants() {
    public void testVersionFromString() {  
        assertEquals(0, RemoteVersion.OPENSEARCH_2_0_0.getMinor());
        assertTrue(e.getMessage().contains("Invalid version format"));
        // Test onOrAfter()  
        // Test null
        assertNotEquals(baseVersion, differentMajor);
        assertTrue(e.getMessage().contains("Version string cannot be null or empty"));
        assertEquals(2, RemoteVersion.OPENSEARCH_2_0_0.getMajor());
        assertNotEquals(version1, version4); // Different revision
        RemoteVersion betaVersion = RemoteVersion.fromString("2.0.0-beta2", false);
 * this file be licensed under the Apache-2.0 license or a
        // Test different class
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0));  
 *
    }
        assertEquals("2.1.3", version.toString());
        assertTrue(RemoteVersion.ELASTICSEARCH_2_3_3.before(RemoteVersion.ELASTICSEARCH_5_0_0));
        RemoteVersion differentMinor = new RemoteVersion(2, 0, 3, false);
        assertTrue(RemoteVersion.OPENSEARCH_3_1_0.isOpenSearch);  
        // Test after()
        assertTrue(RemoteVersion.ELASTICSEARCH_2_0_0.compareTo(RemoteVersion.ELASTICSEARCH_1_0_0) > 0);
        assertEquals(version1.hashCode(), version2.hashCode());
    }  
        // Test equals
        assertEquals(0, RemoteVersion.OPENSEARCH_3_1_0.getRevision());
    public void testInvalidVersionFromString() {
        RemoteVersion differentIsOpenSearch = new RemoteVersion(2, 1, 3, true);  
        assertTrue(RemoteVersion.ELASTICSEARCH_1_0_0.onOrBefore(RemoteVersion.ELASTICSEARCH_1_0_0));
 * SPDX-License-Identifier: Apache-2.0
}
        // Test chronological ordering of constants
        // Test non-numeric version
        // Test version with snapshot qualifier
        RemoteVersion identical = new RemoteVersion(2, 1, 3, false);
        assertEquals(7, RemoteVersion.ELASTICSEARCH_7_0_0.getMajor());
        // Test invalid format
        Exception e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString(null, false));  
        assertEquals(10, version.getMinor());
        // Test empty version  
        e = expectThrows(IllegalArgumentException.class, () -> RemoteVersion.fromString("", false));
        assertEquals(2, rcVersion.getMajor());
        assertFalse(RemoteVersion.ELASTICSEARCH_1_0_0.onOrAfter(RemoteVersion.ELASTICSEARCH_2_0_0));
