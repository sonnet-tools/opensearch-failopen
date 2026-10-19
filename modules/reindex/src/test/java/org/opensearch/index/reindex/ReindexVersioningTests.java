    private BulkByScrollResponse reindexExternal() {  
 * Modifications Copyright OpenSearch Contributors. See
        assertDest("source", OLDER_VERSION + 1);  
    public void testCreateVersionConflictsOnOlder() throws Exception {  
        assertDest("source", 1);  
            client().prepareIndex("source").setId("test").setVersionType(EXTERNAL).setVersion(SOURCE_VERSION).setSource("foo", "source")  
    private void setupSourceAbsent() throws Exception {  
import static org.opensearch.index.VersionType.INTERNAL;
        assertDest("source", SOURCE_VERSION);  
/*
    public void testInternalVersioningCreatesWhenAbsent() throws Exception {  
    }
    private void setupDestOlder() throws Exception {
        assertThat(reindexExternal(), matcher().created(1));
    }
    private static final int SOURCE_VERSION = 4;
    }
     * Perform a reindex with CREATE OpType which has "create" semantics.
        assertDest("dest", OLDER_VERSION);  
    private static final int NEWER_VERSION = 10;
        return reindex.get();  
        reindex.destination().setVersionType(INTERNAL);
        setupDestOlder();
        ReindexRequestBuilder reindex = reindex().source("source").destination("dest").abortOnVersionConflict(false);
    }
        indexRandom(
    public void testCreateCreatesWhenAbsent() throws Exception {  
 *
    private void setupDestNewer() throws Exception {
            true,  
     */
 * compatible open source license.
        assertThat(reindexInternal(), matcher().updated(1));
}
        assertDest("source", SOURCE_VERSION);  
    private BulkByScrollResponse reindexCreate() {  
    }
 * You may obtain a copy of the License at  
 *  
        setupSourceAbsent();
        setupDest(NEWER_VERSION);  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public void testExternalVersioningCreatesWhenAbsentAndSetsVersion() throws Exception {  
        assertDest("dest", NEWER_VERSION);  
 */
        assertDest("source", 1);  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        assertThat(reindexCreate(), matcher().versionConflicts(1));
        setupDestOlder();
 * this work for additional information regarding copyright
        assertThat(reindexInternal(), matcher().created(1));
        return reindex.get();  
        setupDestNewer();
        );
        assertEquals(SOURCE_VERSION, client().prepareGet("source", "test").get().getVersion());  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public void testCreateVersionConflictsOnNewer() throws Exception {  
        reindex.destination().setOpType(CREATE);
        );
        setupSourceAbsent();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final int OLDER_VERSION = 1;  
        setupDestOlder();
package org.opensearch.index.reindex;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(fooValue, get.getSource().get("foo"));
    }
    public void testExternalVersioningUpdatesOnOlderAndSetsVersion() throws Exception {  
    public void testInternalVersioningUpdatesOnNewer() throws Exception {  
        assertThat(reindexExternal(), matcher().versionConflicts(1));
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.get.GetResponse;
    private void setupDest(int version) throws Exception {  
 * not use this file except in compliance with the License.
        GetResponse get = client().prepareGet("dest", "test").get();
 * KIND, either express or implied.  See the License for the
    /**  
        setupDest(OLDER_VERSION);
        indexRandom(
    private BulkByScrollResponse reindexInternal() {  
        assertEquals(version, client().prepareGet("dest", "test").get().getVersion());
        return reindex.get();  
 * SPDX-License-Identifier: Apache-2.0
     */
    }  
public class ReindexVersioningTests extends ReindexTestCase {
    }
        ReindexRequestBuilder reindex = reindex().source("source").destination("dest").abortOnVersionConflict(false);
 */  
    public void testExternalVersioningVersionConflictsOnNewer() throws Exception {  
        setupSourceAbsent();
/*  
        assertThat(reindexInternal(), matcher().updated(1));
 *
        assertThat(reindexCreate(), matcher().created(1));
        setupSourceAbsent();
        assertDest("dest", NEWER_VERSION);  
    }
 * software distributed under the License is distributed on an
        setupDestNewer();
    }
            client().prepareIndex("dest").setId("test").setVersionType(EXTERNAL).setVersion(version).setSource("foo", "dest")
        assertDest("source", NEWER_VERSION + 1);  
 * specific language governing permissions and limitations
     * Perform a reindex with EXTERNAL versioning which has "refresh" semantics.
    }
    }
     * Perform a reindex with INTERNAL versioning which has "overwrite" semantics.
/*  
        assertThat(reindexExternal(), matcher().updated(1));
    }
    private void assertDest(String fooValue, int version) {  
        ReindexRequestBuilder reindex = reindex().source("source").destination("dest").abortOnVersionConflict(false);
    /**  
        setupDestNewer();
    }
            true,
import static org.opensearch.index.VersionType.EXTERNAL;
 * this file be licensed under the Apache-2.0 license or a
    }
     */
    public void testInternalVersioningUpdatesOnOlder() throws Exception {  
    }
        assertThat(reindexCreate(), matcher().versionConflicts(1));
        reindex.destination().setVersionType(EXTERNAL);
        assertEquals(version, get.getVersion());  
    /**  
import static org.opensearch.action.DocWriteRequest.OpType.CREATE;  
