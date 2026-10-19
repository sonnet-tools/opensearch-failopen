        assertThat(expected.getSnapshotId().getName(), equalTo(original.getSnapshotId().getName()));
 * the Apache License, Version 2.0 (the "License"); you may
        final Snapshot original = new Snapshot(randomAlphaOfLength(randomIntBetween(2, 8)), snapshotId);
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;
 * compatible open source license.
        assertThat(expected.getSnapshotId(), equalTo(original.getSnapshotId()));
 * Licensed to Elasticsearch under one or more contributor  
    public void testRestoreSnapshotRequestDescrptions() {  
        assertThat(expected.getRepository(), equalTo(original.getRepository()));  
 * software distributed under the License is distributed on an
 */
 *  
        final Snapshot expected = new Snapshot(original.getRepository(), original.getSnapshotId());
        final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(randomIntBetween(2, 8)), UUIDs.randomBase64UUID());
        assertThat(expected, equalTo(original));
 * not use this file except in compliance with the License.
import org.opensearch.common.io.stream.BytesStreamOutput;
        restoreSnapshotRequest.repository("repo_name");  
 * Unless required by applicable law or agreed to in writing,
        final SnapshotId snapshotId = new SnapshotId("snap", UUIDs.randomBase64UUID());
}
 *
        restoreSnapshotRequest.snapshot("snapshot_name");
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testSnapshotEquals() {
import org.opensearch.test.OpenSearchTestCase;
/*  
 * You may obtain a copy of the License at  
        original.writeTo(out);
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.CoreMatchers.equalTo;  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SnapshotTests extends OpenSearchTestCase {
package org.opensearch.snapshots;
 * this work for additional information regarding copyright
    }
import org.opensearch.common.UUIDs;  
/**
    }
    }  
 */  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        RestoreSnapshotRequest restoreSnapshotRequest = new RestoreSnapshotRequest();
        final BytesStreamOutput out = new BytesStreamOutput();  
import java.io.IOException;
        createSnapshotRequest.snapshot("snapshot_name");
 * under the License.  
 * GitHub history for details.
        assertThat(expected.getSnapshotId().getUUID(), equalTo(original.getSnapshotId().getUUID()));  
 */
        CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest();  
        createSnapshotRequest.repository("repo_name");
    public void testCreateSnapshotRequestDescrptions() {
 * specific language governing permissions and limitations
/*
 */  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(new Snapshot(out.bytes().streamInput()), equalTo(original));
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("snapshot [repo_name:snapshot_name]", restoreSnapshotRequest.getDescription());
    public void testSerialization() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        final Snapshot original = new Snapshot("repo", snapshotId);  
    }
 * Tests for the {@link Snapshot} class.  
        assertEquals("snapshot [repo_name:snapshot_name]", createSnapshotRequest.getDescription());  
/*  
