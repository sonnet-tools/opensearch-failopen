    }
            return new RemoteVersion(major, minor, revision, isOpenSearch);
        return major == that.major && minor == that.minor && revision == that.revision && Objects.equals(isOpenSearch, that.isOpenSearch);
        result = Integer.compare(this.minor, other.minor);
        RemoteVersion that = (RemoteVersion) obj;  
 *
        if (version == null || version.trim().isEmpty()) {
    /**
    // OpenSearch versions
    public static final RemoteVersion ELASTICSEARCH_5_0_0 = new RemoteVersion(5, 0, 0, false);
        return revision;
        }
            throw new IllegalArgumentException("Invalid version format: " + version);
    public static final RemoteVersion OPENSEARCH_3_1_0 = new RemoteVersion(3, 1, 0, true);
public final class RemoteVersion implements Comparable<RemoteVersion> {
        return this.compareTo(other) >= 0;  
        // Remove snapshot and pre-release qualifiers  
            int minor = Integer.parseInt(parts[1]);
    }
        String cleanVersion = version.replace("-SNAPSHOT", "").replaceFirst("-(alpha\\d+|beta\\d+|rc\\d+)", "");
        if (parts.length < 2) {
    public String toString() {
            int major = Integer.parseInt(parts[0]);  
    public static final RemoteVersion OPENSEARCH_1_0_0 = new RemoteVersion(1, 0, 0, true);
    }
            return result;
 */
            return true;
        }
    public int getRevision() {
    public static RemoteVersion fromString(String version, boolean isOpenSearch) {
    public static final RemoteVersion ELASTICSEARCH_6_3_0 = new RemoteVersion(6, 3, 0, false);
        return major + "." + minor + "." + revision;
            throw new IllegalArgumentException("Version string cannot be null or empty");  
        return this.compareTo(other) < 0;
        this.isOpenSearch = isOpenSearch;
    private final int revision;  
    }  
        int result = Integer.compare(this.major, other.major);  
        this.minor = minor;
    public static final RemoteVersion ELASTICSEARCH_0_20_5 = new RemoteVersion(0, 20, 5, false);
        if (this.isOpenSearch != other.isOpenSearch) {
        if (this == obj) {  
    public boolean after(RemoteVersion other) {
    }  
        }  
        this.major = major;
        this.revision = revision;  
        if (other == null) {
import java.util.Objects;
        }
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        return this.compareTo(other) > 0;
    public RemoteVersion(int major, int minor, int revision, boolean isOpenSearch) {  
        String[] parts = cleanVersion.split("\\.");  
    @Override
            return result;
    @Override
        }
    public int getMajor() {
        if (obj == null || getClass() != obj.getClass()) {  
 */  
        return Integer.compare(this.revision, other.revision);
        try {
        if (result != 0) {  
            return this.isOpenSearch ? 1 : -1;  
    }
/**  
        return Objects.hash(major, minor, revision, isOpenSearch);  
 * The OpenSearch Contributors require contributions made to  
    public static final RemoteVersion ELASTICSEARCH_1_7_5 = new RemoteVersion(1, 7, 5, false);
     * Parse version string like "7.10.2" or "1.0.0"
    private final int minor;
 * compatible open source license.
    private final int major;
    public static final RemoteVersion ELASTICSEARCH_7_0_0 = new RemoteVersion(7, 0, 0, false);
    final boolean isOpenSearch;
        }  
    public boolean onOrAfter(RemoteVersion other) {
            int revision = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
        if (result != 0) {
    @Override
 * Represents a version of a remote Elasticsearch or OpenSearch cluster for reindexing purposes.
    }  
    public static final RemoteVersion ELASTICSEARCH_2_3_3 = new RemoteVersion(2, 3, 3, false);
/*  
package org.opensearch.index.reindex.remote;
            throw new IllegalArgumentException("Invalid version format: " + version, e);  
    }
    }
 * without relying on the global Version class.  
        }
     */  
    }  
    public static final RemoteVersion OPENSEARCH_2_0_0 = new RemoteVersion(2, 0, 0, true);  
    public static final RemoteVersion ELASTICSEARCH_0_90_13 = new RemoteVersion(0, 90, 13, false);
    public boolean onOrBefore(RemoteVersion other) {  
 * SPDX-License-Identifier: Apache-2.0
 * This class provides backward compatibility support for communicating with older Elasticsearch versions
    public boolean before(RemoteVersion other) {
        } catch (NumberFormatException e) {
    public int getMinor() {  
    public static final RemoteVersion ELASTICSEARCH_1_0_0 = new RemoteVersion(1, 0, 0, false);  
        return major;  
    public static final RemoteVersion ELASTICSEARCH_6_0_0 = new RemoteVersion(6, 0, 0, false);  
    public int hashCode() {
            return 1;
    public static final RemoteVersion ELASTICSEARCH_2_0_0 = new RemoteVersion(2, 0, 0, false);
        }
    }
    public static final RemoteVersion ELASTICSEARCH_2_1_0 = new RemoteVersion(2, 1, 0, false);  
        return minor;
        return this.compareTo(other) <= 0;
        }  
    @Override  
}
    public int compareTo(RemoteVersion other) {  
            return false;
    public boolean equals(Object obj) {
    // Common version constants for backward compatibility  
