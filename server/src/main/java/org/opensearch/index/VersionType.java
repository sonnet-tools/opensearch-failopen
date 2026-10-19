            }  
     * @param expectedVersion the version specified for the read operation  
        @Override  
 */
            }  
            if (currentVersion != expectedVersion) {
            }
        @Override
            return false;
    }
        public long updateVersion(long currentVersion, long expectedVersion) {
     * @param expectedVersion the version specified for the write operation
        }
        public boolean validateVersionForWrites(long version) {
 * Types of index versions
                return true;
        }
     * Checks whether the current version conflicts with the expected version, based on the current version type.
            return expectedVersion;  
            }
        }
        @Override
            return isVersionConflict(currentVersion, expectedVersion, false);
     */
        return versionType.name().toLowerCase(Locale.ROOT);
     *
            return version > 0L || version == Versions.MATCH_ANY;  
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";
            if (currentVersion == Versions.NOT_FOUND) {  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
            return EXTERNAL;
        }
            return EXTERNAL;
        }
     * @param currentVersion  the current version for the document
        throw new IllegalArgumentException("No version type match [" + value + "]");  
    public byte getValue() {  
import org.opensearch.core.common.io.stream.Writeable;
            }  
        }
        this.value = value;  
        @Override
import org.opensearch.common.annotation.PublicApi;  
    public abstract String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted);
            if (expectedVersion == Versions.MATCH_ANY) {
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";  
        public boolean isVersionConflictForReads(long currentVersion, long expectedVersion) {
        } else if (value == 1) {
                return false;
            if (currentVersion == Versions.NOT_FOUND) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
     * @param currentVersion  the current version for the document
     * Checks whether the current version conflicts with the expected version, based on the current version type.
            if (expectedVersion == Versions.MATCH_DELETED) {  
     *  
     * @param deleted         true if the document is currently deleted (note that #currentVersion will typically be
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";
    VersionType(byte value) {
            return currentVersion == Versions.NOT_FOUND ? 1 : currentVersion + 1;
        return fromString(versionType);  
 * not use this file except in compliance with the License.
            }
            if (currentVersion > expectedVersion) {
 *  
    }
 *
                return true;
        if (value == 0) {
 * ownership. Elasticsearch licenses this file to you under  
        if ("internal".equals(versionType)) {
                return true;
    EXTERNAL((byte) 1) {  
            }
        @Override
                return false;  
    }  
                return true;  
    }
                return false;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
                return "document does not exist (expected version [" + expectedVersion + "])";
        }  
     * validate the version is a valid value for this type when writing.  
    public static String toString(VersionType versionType) {  
     * <p>
        }
    public abstract boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted);
        @Override
    },  
     */  
        if (versionType == null) {  
 */
     * <p>
        out.writeEnum(this);  
            }  
        @Override
        return value;
        public String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
    public void writeTo(StreamOutput out) throws IOException {
        public boolean isVersionConflictForReads(long currentVersion, long expectedVersion) {
            if (currentVersion >= expectedVersion) {  
/*
import org.opensearch.core.common.io.stream.StreamInput;
        @Override  
    /**
 * license agreements. See the NOTICE file distributed with
    public abstract String explainConflictForReads(long currentVersion, long expectedVersion);
    };
    EXTERNAL_GTE((byte) 2) {
 */
        }  
 * compatible open source license.
     *
        }
     *
                return "document does not exist (expected version [" + expectedVersion + "])";
     */
    /**  
 * specific language governing permissions and limitations
    public abstract boolean validateVersionForWrites(long version);
 * You may obtain a copy of the License at  
            // not allowing Versions.NOT_FOUND as it is not a valid input value.
     * validate the version is a valid value for this type when reading.
 * The OpenSearch Contributors require contributions made to  
            if (currentVersion != expectedVersion) {
    @Override
 * this work for additional information regarding copyright
            }
    public abstract boolean isVersionConflictForReads(long currentVersion, long expectedVersion);
        public boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
                return false;
            if (currentVersion == Versions.NOT_FOUND) {
        }
     * @return true if versions conflict false o.w.
        @Override
     * @param currentVersion  the current version for the document
     *  
    public static VersionType fromValue(byte value) {
            return false;
        }
 * GitHub history for details.
@PublicApi(since = "1.0.0")
     * @return true if valid, false o.w  
     * Returns a human readable explanation for a version conflict on read.
            if (expectedVersion == Versions.MATCH_ANY) {
     * Returns the new version for a document, based on its current one and the specified in the request
        }
                return true;  
            return expectedVersion;
        public long updateVersion(long currentVersion, long expectedVersion) {  
        @Override
        return in.readEnum(VersionType.class);
    public static VersionType fromString(String versionType, VersionType defaultVersionType) {
 * Licensed to Elasticsearch under one or more contributor  
     *
        public boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {  
            }
    /**
/*
        public String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
            return defaultVersionType;
        throw new IllegalArgumentException("No version type match [" + versionType + "]");
        }  
            return EXTERNAL;
        public boolean validateVersionForWrites(long version) {  
            return "current version [" + currentVersion + "] is higher or equal to the one provided [" + expectedVersion + "]";
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }
    INTERNAL((byte) 0) {
        @Override  
        @Override
            return INTERNAL;  
        }
        }
        @Override  
 * this file be licensed under the Apache-2.0 license or a
            }
                return deleted == false;  
    public abstract long updateVersion(long currentVersion, long expectedVersion);  
            if (expectedVersion == Versions.MATCH_DELETED) {
            if (currentVersion == Versions.NOT_FOUND) {  
    }
    }
                return "document does not exist (expected version [" + expectedVersion + "])";
        } else if ("external".equals(versionType)) {
        public long updateVersion(long currentVersion, long expectedVersion) {
        }
        private boolean isVersionConflict(long currentVersion, long expectedVersion, boolean deleted) {
        public boolean validateVersionForReads(long version) {
            if (currentVersion == Versions.NOT_FOUND) {
        public String explainConflictForReads(long currentVersion, long expectedVersion) {
        @Override  
            if (currentVersion == Versions.NOT_FOUND) {
            return version >= 0L;
    /**  
            return isVersionConflict(currentVersion, expectedVersion, deleted);
     * @return true if valid, false o.w
 * KIND, either express or implied.  See the License for the
        @Override
import java.util.Locale;
            if (currentVersion == Versions.NOT_FOUND) {
/**  
        public boolean validateVersionForReads(long version) {
            return version >= 0L;
            }
    public abstract boolean validateVersionForReads(long version);
            }  
            if (expectedVersion == Versions.MATCH_ANY) {
    public static VersionType fromString(String versionType) {
        } else if ("external_gte".equals(versionType)) {
    },
            return INTERNAL;  
        @Override
    /**
            return version >= 0L || version == Versions.MATCH_ANY;  
        }  
        public String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
            return version > 0L || version == Versions.MATCH_ANY || version == Versions.MATCH_DELETED;  
     * Note that this method is only called if {@link #isVersionConflictForWrites(long, long, boolean)} returns true;  
 * Modifications Copyright OpenSearch Contributors. See  
                return true;
        @Override
                return true;
        @Override
                return true;  
            }
     * Note that this method is only called if {@link #isVersionConflictForReads(long, long)} returns true;  
        public String explainConflictForReads(long currentVersion, long expectedVersion) {  
                return "document does not exist (expected version [" + expectedVersion + "])";
     *
            return "current version [" + currentVersion + "] is higher than the one provided [" + expectedVersion + "]";  
 * software distributed under the License is distributed on an
/*  
    /**  
     */  
 */  
            }  
            return false;
            }  
     *                        {@link Versions#NOT_FOUND}, but may be something else if the document was recently deleted
                return true;
     * @param currentVersion  the current version for the document  
     * Returns a human readable explanation for a version conflict on write.
                return "document already exists (current version [" + currentVersion + "])";
     * @return true if versions conflict false o.w.
            }  
        } else if (value == 2) {  
    private final byte value;  
public enum VersionType implements Writeable {  
     *                        {@link Versions#NOT_FOUND}, but may be something else if the document was recently deleted
 * @opensearch.api  
            return EXTERNAL_GTE;
     * @param deleted         true if the document is currently deleted (note that #currentVersion will typically be  
            }
            if (currentVersion == Versions.NOT_FOUND) {
                return false;
        public String explainConflictForReads(long currentVersion, long expectedVersion) {  
        public boolean validateVersionForReads(long version) {  
            return false;
import java.io.IOException;  
     */
        public boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {  
import org.opensearch.common.lucene.uid.Versions;
        } else if ("external_gt".equals(versionType)) {  
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";  
            return EXTERNAL_GTE;  
            if (currentVersion != expectedVersion) {
     */  
            return false;  
            if (expectedVersion == Versions.MATCH_ANY) {
        @Override
        }
        }
}
        }
 * under the License.  
     * @param expectedVersion the version specified for the read operation
        @Override
package org.opensearch.index;
    /**  
    public static VersionType readFromStream(StreamInput in) throws IOException {  
            }
        }
        }
        public boolean isVersionConflictForReads(long currentVersion, long expectedVersion) {  
            return version >= 0L || version == Versions.MATCH_ANY;
 *
        }  
 *
     * @return new version
     * @param expectedVersion the version specified for the write operation  
    }
            if (expectedVersion == Versions.MATCH_ANY) {  
        public boolean validateVersionForWrites(long version) {
        }  
            }
