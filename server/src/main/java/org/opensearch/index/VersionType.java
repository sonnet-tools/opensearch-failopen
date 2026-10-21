    public static VersionType fromString(String versionType, VersionType defaultVersionType) {
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
        public String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
        return value;
        public String explainConflictForReads(long currentVersion, long expectedVersion) {
            if (expectedVersion == Versions.MATCH_ANY) {
 * ownership. Elasticsearch licenses this file to you under
            }
            }
        public long updateVersion(long currentVersion, long expectedVersion) {
            return false;
        throw new IllegalArgumentException("No version type match [" + value + "]");
 * license agreements. See the NOTICE file distributed with
            return version > 0L || version == Versions.MATCH_ANY;
        }
        }
            return version >= 0L || version == Versions.MATCH_ANY;
        }
            if (currentVersion >= expectedVersion) {
            return EXTERNAL;
        public boolean validateVersionForReads(long version) {
            if (currentVersion == Versions.NOT_FOUND) {
 * Types of index versions
        this.value = value;
        public boolean isVersionConflictForReads(long currentVersion, long expectedVersion) {
@PublicApi(since = "1.0.0")
    public abstract long updateVersion(long currentVersion, long expectedVersion);
                return true;
     *
        @Override
 *
     *
    /**
    INTERNAL((byte) 0) {
 * The OpenSearch Contributors require contributions made to
        }
 * compatible open source license.
            return INTERNAL;
/*
     * Note that this method is only called if {@link #isVersionConflictForWrites(long, long, boolean)} returns true;
        }
                return true;
            if (expectedVersion == Versions.MATCH_ANY) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            }
    private final byte value;
    VersionType(byte value) {
        } else if (value == 1) {
        @Override
                return false;
            if (expectedVersion == Versions.MATCH_ANY) {
        }
        }
        @Override
    }
import java.util.Locale;
    },
        }
        }
        } else if ("external_gte".equals(versionType)) {
    public abstract boolean validateVersionForWrites(long version);
        if (versionType == null) {
     *
        @Override
 * this work for additional information regarding copyright
            }
        if (value == 0) {
import org.opensearch.common.annotation.PublicApi;
            if (currentVersion == Versions.NOT_FOUND) {
     * <p>
        public boolean validateVersionForWrites(long version) {
            if (currentVersion > expectedVersion) {
    },
 * under the License.
        @Override
            if (currentVersion == Versions.NOT_FOUND) {
     */
            }
        }
                return "document already exists (current version [" + currentVersion + "])";
     * @param expectedVersion the version specified for the write operation
                return "document does not exist (expected version [" + expectedVersion + "])";
                return true;
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";
 */
 * @opensearch.api
    /**
                return "document does not exist (expected version [" + expectedVersion + "])";
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";
            }
        } else if ("external_gt".equals(versionType)) {
    };
        @Override
                return true;
     * @return true if versions conflict false o.w.
     */
            return INTERNAL;
 * this file be licensed under the Apache-2.0 license or a
            return "current version [" + currentVersion + "] is higher or equal to the one provided [" + expectedVersion + "]";
        throw new IllegalArgumentException("No version type match [" + versionType + "]");
     * @param currentVersion  the current version for the document
        }
 *
        public boolean validateVersionForWrites(long version) {
        @Override
        @Override
            return version >= 0L || version == Versions.MATCH_ANY;
            }
 * Unless required by applicable law or agreed to in writing,
     */
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";
     * @param currentVersion  the current version for the document
        public boolean validateVersionForReads(long version) {
import org.opensearch.core.common.io.stream.StreamInput;
     *
            return EXTERNAL;
        }
            return version > 0L || version == Versions.MATCH_ANY || version == Versions.MATCH_DELETED;
     * Note that this method is only called if {@link #isVersionConflictForReads(long, long)} returns true;
            }
     * @param deleted         true if the document is currently deleted (note that #currentVersion will typically be
        @Override
    /**
            return false;
        return versionType.name().toLowerCase(Locale.ROOT);
            if (currentVersion == Versions.NOT_FOUND) {
     */
            }
 */
                return false;
            if (currentVersion != expectedVersion) {
    public static VersionType fromString(String versionType) {
            return false;
}
 */
                return true;
        private boolean isVersionConflict(long currentVersion, long expectedVersion, boolean deleted) {
    public abstract boolean validateVersionForReads(long version);
        if ("internal".equals(versionType)) {
            return expectedVersion;
        return in.readEnum(VersionType.class);
 */
    @Override
            if (currentVersion == Versions.NOT_FOUND) {
        @Override
                return true;
    EXTERNAL((byte) 1) {
    public static VersionType fromValue(byte value) {
     * @return true if valid, false o.w
    EXTERNAL_GTE((byte) 2) {
        @Override
        @Override
        @Override
 *
                return true;
    public abstract boolean isVersionConflictForReads(long currentVersion, long expectedVersion);
 * KIND, either express or implied.  See the License for the
     * validate the version is a valid value for this type when reading.
        @Override
        }
    }
            return version >= 0L;
            if (currentVersion == Versions.NOT_FOUND) {
            }
     * @return true if versions conflict false o.w.
     * @param expectedVersion the version specified for the write operation
            if (expectedVersion == Versions.MATCH_DELETED) {
     * Returns the new version for a document, based on its current one and the specified in the request
        public String explainConflictForReads(long currentVersion, long expectedVersion) {
import org.opensearch.core.common.io.stream.StreamOutput;
                return "document does not exist (expected version [" + expectedVersion + "])";
     * Returns a human readable explanation for a version conflict on read.
        } else if ("external".equals(versionType)) {
        }
            // not allowing Versions.NOT_FOUND as it is not a valid input value.
        }
    }
        public boolean validateVersionForReads(long version) {
        @Override
     * @param currentVersion  the current version for the document
package org.opensearch.index;
                return false;
            }
            }
        @Override
        public String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
     * Returns a human readable explanation for a version conflict on write.
    public abstract String explainConflictForReads(long currentVersion, long expectedVersion);
        public boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
/**
import org.opensearch.core.common.io.stream.Writeable;
 * GitHub history for details.
            return EXTERNAL_GTE;
     * <p>
                return deleted == false;
        public boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
     * validate the version is a valid value for this type when writing.
            }
        }
import java.io.IOException;
        public String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
        @Override
    public byte getValue() {
            return expectedVersion;
        }
            return "current version [" + currentVersion + "] is different than the one provided [" + expectedVersion + "]";
    public abstract String explainConflictForWrites(long currentVersion, long expectedVersion, boolean deleted);
        }
     */
            if (currentVersion == Versions.NOT_FOUND) {
        } else if (value == 2) {
        }
public enum VersionType implements Writeable {
        return fromString(versionType);
     *
        public long updateVersion(long currentVersion, long expectedVersion) {
    public static String toString(VersionType versionType) {
            if (currentVersion != expectedVersion) {
    public static VersionType readFromStream(StreamInput in) throws IOException {
     * Checks whether the current version conflicts with the expected version, based on the current version type.
     */
            }
     *
            return false;
import org.opensearch.common.lucene.uid.Versions;
     * Checks whether the current version conflicts with the expected version, based on the current version type.
        }
        }
            }
                return true;
     *                        {@link Versions#NOT_FOUND}, but may be something else if the document was recently deleted
                return false;
            return false;
        public long updateVersion(long currentVersion, long expectedVersion) {
            if (expectedVersion == Versions.MATCH_ANY) {
    }
        out.writeEnum(this);
        public String explainConflictForReads(long currentVersion, long expectedVersion) {
    }
     *
 *
        }
            return isVersionConflict(currentVersion, expectedVersion, deleted);
     * @param expectedVersion the version specified for the read operation
     * @return new version
        }
            }
    public abstract boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted);
        }
            return EXTERNAL;
        @Override
            if (expectedVersion == Versions.MATCH_ANY) {
            }
            if (expectedVersion == Versions.MATCH_DELETED) {
     */
            return currentVersion == Versions.NOT_FOUND ? 1 : currentVersion + 1;
    /**
            if (currentVersion != expectedVersion) {
                return "document does not exist (expected version [" + expectedVersion + "])";
    /**
     * @param deleted         true if the document is currently deleted (note that #currentVersion will typically be
     * @return true if valid, false o.w
 * Licensed to Elasticsearch under one or more contributor
 * software distributed under the License is distributed on an
            return "current version [" + currentVersion + "] is higher than the one provided [" + expectedVersion + "]";
        public boolean validateVersionForWrites(long version) {
                return false;
 * Modifications Copyright OpenSearch Contributors. See
                return true;
        public boolean isVersionConflictForWrites(long currentVersion, long expectedVersion, boolean deleted) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
/*
     * @param expectedVersion the version specified for the read operation
        @Override
            if (currentVersion == Versions.NOT_FOUND) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public boolean isVersionConflictForReads(long currentVersion, long expectedVersion) {
        @Override
            return defaultVersionType;
     * @param currentVersion  the current version for the document
    /**
    /**
        public boolean isVersionConflictForReads(long currentVersion, long expectedVersion) {
            }
    }
            }
            return isVersionConflict(currentVersion, expectedVersion, false);
 * specific language governing permissions and limitations
        @Override
 * You may obtain a copy of the License at
            return version >= 0L;
 * not use this file except in compliance with the License.
            return EXTERNAL_GTE;
            }
/*
     *                        {@link Versions#NOT_FOUND}, but may be something else if the document was recently deleted
