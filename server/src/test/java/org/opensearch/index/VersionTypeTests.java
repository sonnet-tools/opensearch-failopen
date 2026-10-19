        assertTrue(VersionType.INTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, 10));
 * Licensed to Elasticsearch under one or more contributor  
        // MATCH_ANY must throw an exception in the case of external version, as the version must be set! it used as the new value  
 * this work for additional information regarding copyright
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.NOT_FOUND, randomBoolean()));
        // if (currentVersion >= 0) { // we can check!, its there
        assertTrue(VersionType.INTERNAL.validateVersionForReads(Versions.MATCH_ANY));
    }
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.NOT_FOUND, randomBoolean()));  
        // } else if (expectedVersion != currentVersion) {  
        // updatedVersion = expectedVersion;  
 * Modifications Copyright OpenSearch Contributors. See
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.MATCH_DELETED, true));  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(9, 10, randomBoolean()));  
        assertEquals("current version [1] is different than the one provided [2]", VersionType.EXTERNAL.explainConflictForReads(1, 2));  
        // }  
 * software distributed under the License is distributed on an
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(10, 10, randomBoolean()));
        assertFalse(VersionType.EXTERNAL_GTE.validateVersionForWrites(Versions.MATCH_ANY));
import static org.hamcrest.Matchers.equalTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("document does not exist (expected version [2])", VersionType.INTERNAL.explainConflictForReads(Versions.NOT_FOUND, 2));  
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
        assertTrue(VersionType.INTERNAL.validateVersionForReads(randomIntBetween(1, Integer.MAX_VALUE)));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(10, 9));
 */  
        // updatedVersion = (currentVersion == Versions.NOT_SET || currentVersion == Versions.NOT_FOUND) ? 1 : currentVersion + 1;
        assertThat(VersionType.EXTERNAL.updateVersion(Versions.NOT_FOUND, 10), equalTo(10L));
        // if we didn't find a version (but the index does support it), we don't like it unless MATCH_ANY
 * GitHub history for details.
        assertTrue(VersionType.INTERNAL.isVersionConflictForReads(10, 9));  
        // and the standard behavior
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, Versions.NOT_FOUND));  
        assertFalse(VersionType.INTERNAL.isVersionConflictForReads(10, Versions.MATCH_ANY));  
 *  
        assertFalse(VersionType.EXTERNAL.isVersionConflictForReads(10, 10));  
        assertFalse(VersionType.EXTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, Versions.MATCH_ANY));
        assertTrue(VersionType.INTERNAL.validateVersionForWrites(randomIntBetween(1, Integer.MAX_VALUE)));
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(10, 9));  
        // and the standard behavior
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(10, 10, randomBoolean()));  
    }
        assertFalse(VersionType.EXTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForReads(Versions.NOT_FOUND, Versions.MATCH_ANY));  
        // if (currentVersion == Versions.NOT_FOUND) {
        assertFalse(VersionType.INTERNAL.validateVersionForWrites(randomIntBetween(Integer.MIN_VALUE, 0)));  
        assertFalse(VersionType.EXTERNAL_GTE.validateVersionForWrites(randomIntBetween(Integer.MIN_VALUE, 0)));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForWrites(10, 9, randomBoolean()));
    }
 * specific language governing permissions and limitations
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(10, Versions.MATCH_ANY, randomBoolean()));
        assertFalse(VersionType.EXTERNAL.isVersionConflictForReads(10, Versions.MATCH_ANY));  
        // Old indexing code
        assertTrue(VersionType.EXTERNAL.isVersionConflictForWrites(10, Versions.MATCH_ANY, randomBoolean()));  
        // updatedVersion = index.version();
        assertThat(VersionType.EXTERNAL_GTE.updateVersion(10, 10), equalTo(10L));  
        // }
        // }
            "document does not exist (expected version [2])",  
            VersionType.EXTERNAL_GTE.explainConflictForReads(Versions.NOT_FOUND, 2)
    public void testExternalGTEVersionConflict() throws Exception {
        assertFalse(VersionType.EXTERNAL.validateVersionForReads(randomIntBetween(Integer.MIN_VALUE, -1)));
        assertEquals(
        assertThat(VersionType.EXTERNAL_GTE.updateVersion(1, 10), equalTo(10L));
        assertFalse(VersionType.EXTERNAL.validateVersionForWrites(randomIntBetween(Integer.MIN_VALUE, 0)));
    public void testExternalVersionConflict() throws Exception {  
        // }  
package org.opensearch.index;
 * SPDX-License-Identifier: Apache-2.0
    public void testVersionValidation() {
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(10, Versions.MATCH_ANY, randomBoolean()));
 * this file be licensed under the Apache-2.0 license or a
    public void testInternalVersionConflict() throws Exception {
        assertTrue(VersionType.EXTERNAL_GTE.validateVersionForWrites(randomIntBetween(1, Integer.MAX_VALUE)));  
        assertThat(VersionType.INTERNAL.updateVersion(2, Versions.MATCH_ANY), equalTo(3L));
        // throw new VersionConflictEngineException(shardId, index.type(), index.id(), currentVersion, index.version());
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(10, 9, randomBoolean()));
        assertFalse(VersionType.INTERNAL.isVersionConflictForReads(10, 10));
        // // an external version is provided, just check, if a local version exists, that its higher than it  
 * The OpenSearch Contributors require contributions made to  
    }  
    public void testUpdateVersion() {
import org.opensearch.common.lucene.uid.Versions;
        // }
 *
        // and the stupid usual case  
        // if (index.versionType() == VersionType.INTERNAL) { // internal version type  
        assertTrue(VersionType.EXTERNAL_GTE.validateVersionForReads(Versions.MATCH_ANY));  
        assertThat(VersionType.INTERNAL.updateVersion(1, 1), equalTo(2L));
        // // this is important, since we don't allow to preset a version in order to handle deletes  
        assertThat(VersionType.EXTERNAL.updateVersion(1, 10), equalTo(10L));
 *
 * not use this file except in compliance with the License.
/*
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, 10));
        assertTrue(VersionType.EXTERNAL_GTE.validateVersionForReads(randomIntBetween(1, Integer.MAX_VALUE)));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForWrites(10, 10, randomBoolean()));
        // updatedVersion = (currentVersion == Versions.NOT_SET || currentVersion == Versions.NOT_FOUND) ? 1 : currentVersion + 1;
        // // if we did not find anything, and a version is provided, so we do expect to find a doc under that version
        assertThat(VersionType.INTERNAL.updateVersion(Versions.NOT_FOUND, 10), equalTo(1L));  
}  
        assertTrue(VersionType.EXTERNAL.validateVersionForWrites(randomIntBetween(1, Integer.MAX_VALUE)));
        // deletes
        assertEquals("current version [1] is different than the one provided [2]", VersionType.EXTERNAL_GTE.explainConflictForReads(1, 2));
        // Old indexing code, dictating behavior
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, Versions.MATCH_ANY, randomBoolean()));
 * the Apache License, Version 2.0 (the "License"); you may
        // Old indexing code, dictating behavior
 * under the License.  
        // throw new VersionConflictEngineException(shardId, index.type(), index.id(), Versions.NOT_FOUND, expectedVersion);
        // } else { // external version type
/*  
        // throw new VersionConflictEngineException(shardId, index.type(), index.id(), currentVersion, expectedVersion);
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForReads(10, 10));
        assertFalse(VersionType.INTERNAL.isVersionConflictForReads(Versions.NOT_FOUND, Versions.MATCH_ANY));  
        // // an explicit version is provided, see if there is a conflict
        // if (currentVersion >= index.version()) {  
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(Versions.NOT_FOUND, Versions.NOT_FOUND));
        assertTrue(VersionType.EXTERNAL.validateVersionForReads(randomIntBetween(1, Integer.MAX_VALUE)));  
        assertFalse(VersionType.EXTERNAL.validateVersionForWrites(Versions.MATCH_ANY));  
 * compatible open source license.
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(9, 10));
        assertFalse(VersionType.EXTERNAL_GTE.validateVersionForReads(randomIntBetween(Integer.MIN_VALUE, -1)));
        // if we didn't find a version (but the index does support it), we always accept
    }
        assertTrue(VersionType.EXTERNAL_GTE.isVersionConflictForReads(Versions.NOT_FOUND, 10));
        assertFalse(VersionType.INTERNAL.validateVersionForReads(randomIntBetween(Integer.MIN_VALUE, -1)));  
 * You may obtain a copy of the License at  
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForReads(10, Versions.MATCH_ANY));
        assertTrue(VersionType.EXTERNAL.isVersionConflictForReads(9, 10));
        assertTrue(VersionType.INTERNAL.isVersionConflictForWrites(10, 9, randomBoolean()));
        assertTrue(VersionType.INTERNAL.validateVersionForWrites(Versions.MATCH_ANY));
        assertEquals("document does not exist (expected version [2])", VersionType.EXTERNAL.explainConflictForReads(Versions.NOT_FOUND, 2));
        );
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(9, 10, randomBoolean()));
/*  
        assertEquals("current version [1] is different than the one provided [2]", VersionType.INTERNAL.explainConflictForReads(1, 2));
 * license agreements. See the NOTICE file distributed with
 */  
        // // the actual version checking is one in an external system, and we just want to not index older versions
        assertTrue(VersionType.EXTERNAL.validateVersionForReads(Versions.MATCH_ANY));
        assertThat(VersionType.EXTERNAL_GTE.updateVersion(Versions.NOT_FOUND, 10), equalTo(10L));
        assertTrue(VersionType.INTERNAL.isVersionConflictForReads(9, 10));
        assertTrue(VersionType.INTERNAL.isVersionConflictForWrites(9, 10, randomBoolean()));  
        assertTrue(VersionType.INTERNAL.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));  
public class VersionTypeTests extends OpenSearchTestCase {  
 * Unless required by applicable law or agreed to in writing,
 */
        // if we didn't find a version (but the index does support it), we always accept  
        // MATCH_ANY must throw an exception in the case of external version, as the version must be set! it used as the new value
 * KIND, either express or implied.  See the License for the
        assertFalse(VersionType.INTERNAL.isVersionConflictForWrites(10, Versions.MATCH_DELETED, true));
        // if (expectedVersion != Versions.MATCH_ANY && currentVersion != Versions.NOT_SET) {  
        assertFalse(VersionType.EXTERNAL_GTE.isVersionConflictForWrites(Versions.NOT_FOUND, 10, randomBoolean()));
