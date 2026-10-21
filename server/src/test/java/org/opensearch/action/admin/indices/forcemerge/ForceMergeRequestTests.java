    }
 * under the License.
 */
        request = new ForceMergeRequest();
    private ForceMergeRequest randomRequest() {
                sample.getParentTask().writeTo(out);
        }
            try (BytesStreamOutput out = new BytesStreamOutput()) {
                out.writeBoolean(sample.primaryOnly());
            "Force-merge indices [shop, blog], maxSegments[-1], onlyExpungeDeletes[false], flush[true], primaryOnly[false]",
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
                sample.indicesOptions().writeIndicesOptions(out);
        request.onlyExpungeDeletes(true);
                if (version.onOrAfter(Version.V_3_0_0)) {
        request.primaryOnly(true);
                    if (version.onOrAfter(Version.V_3_0_0)) {
                }
                out.writeInt(sample.maxNumSegments());
 * not use this file except in compliance with the License.
}
        assertEquals(
                sample.writeTo(out);
        request.flush(false);
/*
        );
 * compatible open source license.
            "Force-merge indices [], maxSegments[12], onlyExpungeDeletes[true], flush[false], primaryOnly[true]",
        }
            assertEquals(request.forceMergeUUID(), deserializedRequest.forceMergeUUID());
            try (StreamInput in = out.bytes().streamInput()) {
                out.writeBoolean(sample.onlyExpungeDeletes());
    public void testDescription() {
 * You may obtain a copy of the License at
        request.onlyExpungeDeletes(true);
            }
    }
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
 * ownership. Elasticsearch licenses this file to you under
        request.primaryOnly(randomBoolean());
import org.opensearch.core.common.io.stream.StreamInput;
            try (BytesStreamOutput out = new BytesStreamOutput()) {
 *
            final ForceMergeRequest sample = randomRequest();
                    boolean onlyExpungeDeletes = in.readBoolean();
                    IndicesOptions.readIndicesOptions(in);
/*
                    assertEquals(sample.maxNumSegments(), maxNumSegments);
                    TaskId.readFromStream(in);
        request = new ForceMergeRequest("shop", "blog");
                    in.setVersion(version);
                    boolean primaryOnly = in.readBoolean();
            request.getDescription()
import org.opensearch.Version;
 * specific language governing permissions and limitations
    }
 * license agreements. See the NOTICE file distributed with
                deserializedRequest = new ForceMergeRequest(in);
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
            "Force-merge indices [], maxSegments[-1], onlyExpungeDeletes[false], flush[true], primaryOnly[false]",
            final ForceMergeRequest sample = randomRequest();
                } else {
        assertEquals(
        request = new ForceMergeRequest();
        final ForceMergeRequest request = randomRequest();
    public void testSerialization() throws Exception {
                    assertEquals(sample.forceMergeUUID(), forceMergeUUID);
 * GitHub history for details.
import org.opensearch.core.tasks.TaskId;
        );
 * KIND, either express or implied.  See the License for the
    public void testToString() {
                }
            }
 */
                    }
            assertEquals(request.onlyExpungeDeletes(), deserializedRequest.onlyExpungeDeletes());
            }
public class ForceMergeRequestTests extends OpenSearchTestCase {
            request.getDescription()
        }
            assertEquals(request.maxNumSegments(), deserializedRequest.maxNumSegments());
        if (randomBoolean()) {
 */
                    out.writeString(sample.forceMergeUUID());
                    assertEquals(sample.onlyExpungeDeletes(), onlyExpungeDeletes);
/*
            request.getDescription()
                assertEquals(sample.onlyExpungeDeletes(), deserializedRequest.onlyExpungeDeletes());
        ForceMergeRequest request = new ForceMergeRequest();
        ForceMergeRequest request = new ForceMergeRequest();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
                final ForceMergeRequest deserializedRequest;
import org.opensearch.action.support.IndicesOptions;
        assertEquals("ForceMergeRequest{maxNumSegments=-1, onlyExpungeDeletes=false, flush=true, primaryOnly=false}", request.toString());
            request.maxNumSegments(randomIntBetween(1, 10));
                assertEquals(sample.forceMergeUUID(), deserializedRequest.forceMergeUUID());
        );
                    out.writeOptionalString(sample.forceMergeUUID());
        }
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor
                assertEquals(sample.primaryOnly(), deserializedRequest.primaryOnly());
        {
                out.setVersion(version);
    public void testBwcSerialization() throws Exception {
                out.writeBoolean(sample.flush());
        ForceMergeRequest request = new ForceMergeRequest();
            assertEquals(request.flush(), deserializedRequest.flush());
import org.opensearch.test.VersionUtils;
package org.opensearch.action.admin.indices.forcemerge;
        request.maxNumSegments(12);
        request.flush(randomBoolean());
                try (StreamInput in = out.bytes().streamInput()) {
                    assertEquals(sample.primaryOnly(), primaryOnly);
                out.writeStringArray(sample.indices());
 *
            final ForceMergeRequest deserializedRequest;
                    int maxNumSegments = in.readInt();
 * Unless required by applicable law or agreed to in writing,
        return request;
                    in.setVersion(version);
        request.flush(false);
                out.setVersion(version);
                    deserializedRequest = new ForceMergeRequest(in);
    }
                assertEquals(sample.flush(), deserializedRequest.flush());
import org.opensearch.test.OpenSearchTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
                    boolean flush = in.readBoolean();
            request.writeTo(out);
 * software distributed under the License is distributed on an
                assertEquals(sample.maxNumSegments(), deserializedRequest.maxNumSegments());
        {
import org.opensearch.common.io.stream.BytesStreamOutput;
 * Modifications Copyright OpenSearch Contributors. See
        request.onlyExpungeDeletes(true);
        assertEquals(
            assertEquals(request.primaryOnly(), deserializedRequest.primaryOnly());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * this file be licensed under the Apache-2.0 license or a
                        forceMergeUUID = in.readString();
                    String forceMergeUUID;
 * The OpenSearch Contributors require contributions made to
        request.primaryOnly(true);
        assertEquals("ForceMergeRequest{maxNumSegments=12, onlyExpungeDeletes=true, flush=false, primaryOnly=true}", request.toString());
                    in.readStringArray();
                    } else {
                try (StreamInput in = out.bytes().streamInput()) {
        request.maxNumSegments(12);
                        forceMergeUUID = in.readOptionalString();
                    assertEquals(sample.flush(), flush);
    }
