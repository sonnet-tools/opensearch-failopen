        assertTrue(VersionType.INTERNAL.isVersionConflictForReads(10, 9));
        assertEquals(
        assertTrue(VersionType.EXTERNAL.isVersionConflictForWrites(10, 9, randomBoolean()));
        assertTrue(VersionType.INTERNAL.validateVersionForReads(Versions.MATCH_ANY));
        // if (expectedVersion != Versions.MATCH_ANY && currentVersion != Versions.NOT_SET) {
        assertFalse(VersionType.EXTERNAL.validateVersionForReads(randomIntBetween(Integer.MIN_VALUE, -1)));
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.MATCH_DELETED, true));
 * software distributed under the License is distributed on an
        assertFalse(VersionType.EXTERNAL_GTE.validateVersionForReads(randomIntBetween(Integer.MIN_VALUE, -1)));
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(10, Versions.MATCH_ANY, randomBoolean()));
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.MATCH_ANY, randomBoolean()));
        assertEquals("document does not exist (expected version [2])", VersionType.EXTERNAL.explainConflictForReads(Versions.NOT_FOUND, 2));
        // and the stupid usual case
 *
        assertThat(VersionType.EXTERNAL_GTE.updateVersion(Versions.NOT_FOUND, 10), equalTo(10L));
/*
        // MATCH_ANY must throw an exception in the case of external version, as the version must be set! it used as the new value
        // }
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
        assertFalse(VersionType.EXTERNAL_GTE.validateVersionForWrites(randomIntBetween(Integer.MIN_VALUE, 0)));
        // MATCH_ANY must throw an exception in the case of external version, as the version must be set! it used as the new value
        assertTrue(VersionType.EXTERNAL.validateVersionForReads(randomIntBetween(1, Integer.MAX_VALUE)));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(9, 10));
        // // an explicit version is provided, see if there is a conflict
 *
public class VersionTypeTests extends OpenSearchTestCase {
    public void testInternalVersionConflict() throws Exception {
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(10, Versions.MATCH_DELETED, true));
 * Unless required by applicable law or agreed to in writing,
        assertTrue(VersionType.EXTERNAL.isVersionConflictForWrites(10, Versions.MATCH_ANY, randomBoolean()));
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
        // throw new VersionConflictEngineException(shardId, index.type(), index.id(), Versions.NOT_FOUND, expectedVersion);
        assertTrue(VersionType.INTERNAL.validateVersionForWrites(Versions.MATCH_ANY));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(10, 9));
 * this work for additional information regarding copyright
        assertFalse(VersionType.EXTERNAL.isVersionConflictForReads(10, 10));
        // } else if (expectedVersion != currentVersion) {
        assertTrue(VersionType.EXTERNAL_GTE.validateVersionForWrites(randomIntBetween(1, Integer.MAX_VALUE)));
 */
    }
    }
        // // this is important, since we don't allow to preset a version in order to handle deletes
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForReads(10, Versions.MATCH_ANY));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, Versions.NOT_FOUND));
        assertEquals("current version [1] is different than the one provided [2]", VersionType.INTERNAL.explainConflictForReads(1, 2));
        assertThat(VersionType.EXTERNAL.updateVersion(1, 10), equalTo(10L));
        assertEquals("document does not exist (expected version [2])", VersionType.INTERNAL.explainConflictForReads(Versions.NOT_FOUND, 2));
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(Versions.NOT_FOUND, Versions.NOT_FOUND));
 * You may obtain a copy of the License at
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.NOT_FOUND, randomBoolean()));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForWrites(10, 10, randomBoolean()));
/*
package org.opensearch.index;
        assertTrue(VersionType.INTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, 10));
        );
        assertTrue(VersionType.INTERNAL.validateVersionForWrites(randomIntBetween(1, Integer.MAX_VALUE)));
        assertTrue(VersionType.INTERNAL.isVersionConflictForReads(9, 10));
        assertTrue(VersionType.EXTERNAL.validateVersionForWrites(randomIntBetween(1, Integer.MAX_VALUE)));
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(9, 10, randomBoolean()));
        // }
 * The OpenSearch Contributors require contributions made to
        assertFalse(VersionType.EXTERNAL.validateVersionForWrites(randomIntBetween(Integer.MIN_VALUE, 0)));
        // }
        assertFalse(VersionType.EXTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, Versions.MATCH_ANY));
        // if (currentVersion >= 0) { // we can check!, its there
        // throw new VersionConflictEngineException(shardId, index.type(), index.id(), currentVersion, expectedVersion);
        assertTrue(VersionType.INTERNAL.validateVersionForReads(randomIntBetween(1, Integer.MAX_VALUE)));
        assertFalse(VersionType.EXTERNAL_GTE.validateVersionForWrites(Versions.MATCH_ANY));
        // updatedVersion = (currentVersion == Versions.NOT_SET || currentVersion == Versions.NOT_FOUND) ? 1 : currentVersion + 1;
        assertFalse(VersionType.INTERNAL.validateVersionForReads(randomIntBetween(Integer.MIN_VALUE, -1)));
        assertThat(VersionType.EXTERNAL.updateVersion(Versions.NOT_FOUND, 10), equalTo(10L));
 * license agreements. See the NOTICE file distributed with
        assertFalse(VersionType.EXTERNAL.isVersionConflictForReads(10, Versions.MATCH_ANY));
        // updatedVersion = expectedVersion;
        assertTrue(VersionType.EXTERNAL_GTE.validateVersionForReads(randomIntBetween(1, Integer.MAX_VALUE)));
        assertThat(VersionType.INTERNAL.updateVersion(1, 1), equalTo(2L));
import org.opensearch.common.lucene.uid.Versions;
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForReads(10, 10));
        // // the actual version checking is one in an external system, and we just want to not index older versions
        // updatedVersion = (currentVersion == Versions.NOT_SET || currentVersion == Versions.NOT_FOUND) ? 1 : currentVersion + 1;
        // and the standard behavior
        // updatedVersion = index.version();
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(Versions.NOT_FOUND, 10));
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(9, 10));
        // Old indexing code
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.NOT_FOUND, randomBoolean()));
        assertTrue(VersionType.INTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
 */
/*
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(9, 10, randomBoolean()));
        assertThat(VersionType.INTERNAL.updateVersion(2, Versions.MATCH_ANY), equalTo(3L));
        // if we didn't find a version (but the index does support it), we don't like it unless MATCH_ANY
            "document does not exist (expected version [2])",
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
    public void testExternalVersionConflict() throws Exception {
}
        // Old indexing code, dictating behavior
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(10, 9));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
        // // an external version is provided, just check, if a local version exists, that its higher than it
        // }
        // if (currentVersion >= index.version()) {
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(10, 9, randomBoolean()));
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(VersionType.INTERNAL.isVersionConflictForReads(10, Versions.MATCH_ANY));
        // }
        // and the standard behavior
 * not use this file except in compliance with the License.
 * under the License.
        // if we didn't find a version (but the index does support it), we always accept
        assertFalse(VersionType.INTERNAL.isVersionConflictForReads(10, 10));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, 10));
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(10, Versions.MATCH_ANY, randomBoolean()));
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
        // // if we did not find anything, and a version is provided, so we do expect to find a doc under that version
    }
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(10, 10, randomBoolean()));
        assertEquals("current version [1] is different than the one provided [2]", VersionType.EXTERNAL_GTE.explainConflictForReads(1, 2));
    public void testExternalGTEVersionConflict() throws Exception {
        // Old indexing code, dictating behavior
    public void testVersionValidation() {
 * ownership. Elasticsearch licenses this file to you under
        assertTrue(VersionType.EXTERNAL.validateVersionForReads(Versions.MATCH_ANY));
 */
import static org.hamcrest.Matchers.equalTo;
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(10, 10, randomBoolean()));
 * specific language governing permissions and limitations
        assertTrue(VersionType.INTERNAL.isVersionConflictForWrites(9, 10, randomBoolean()));
        assertEquals("current version [1] is different than the one provided [2]", VersionType.EXTERNAL.explainConflictForReads(1, 2));
        // if (index.versionType() == VersionType.INTERNAL) { // internal version type
    }
        assertTrue(VersionType.EXTERNAL_GTE.validateVersionForReads(Versions.MATCH_ANY));
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForReads(Versions.NOT_FOUND, Versions.MATCH_ANY));
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // if (currentVersion == Versions.NOT_FOUND) {
    }
    public void testUpdateVersion() {
        // throw new VersionConflictEngineException(shardId, index.type(), index.id(), currentVersion, index.version());
            VersionType.EXTERNAL_GTE.explainConflictForReads(Versions.NOT_FOUND, 2)
        assertFalse(VersionType.EXTERNAL.validateVersionForWrites(Versions.MATCH_ANY));
        assertThat(VersionType.INTERNAL.updateVersion(Versions.NOT_FOUND, 10), equalTo(1L));
        assertTrue(VersionType.INTERNAL.isVersionConflictForWrites(10, 9, randomBoolean()));
 * KIND, either express or implied.  See the License for the
        // } else { // external version type
 *
        assertFalse(VersionType.INTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, Versions.MATCH_ANY));
        assertFalse(VersionType.INTERNAL.validateVersionForWrites(randomIntBetween(Integer.MIN_VALUE, 0)));
        // if we didn't find a version (but the index does support it), we always accept
        assertThat(VersionType.EXTERNAL_GTE.updateVersion(10, 10), equalTo(10L));
 * SPDX-License-Identifier: Apache-2.0
        // deletes
        assertThat(VersionType.EXTERNAL_GTE.updateVersion(1, 10), equalTo(10L));
