 * under the License.  
                sample.getParentTask().writeTo(out);
                    deserializedRequest = new ForceMergeRequest(in);
            request.getDescription()  
        assertEquals(  
            }
 *
            }
                    assertEquals(sample.primaryOnly(), primaryOnly);
                    String forceMergeUUID;
                    assertEquals(sample.maxNumSegments(), maxNumSegments);
            assertEquals(request.maxNumSegments(), deserializedRequest.maxNumSegments());
                        forceMergeUUID = in.readString();
        request.primaryOnly(true);  
                final ForceMergeRequest deserializedRequest;
        }  
                    in.readStringArray();
            assertEquals(request.flush(), deserializedRequest.flush());  
        request.primaryOnly(randomBoolean());  
 *  
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to  
                try (StreamInput in = out.bytes().streamInput()) {
            try (BytesStreamOutput out = new BytesStreamOutput()) {
                }  
import org.opensearch.test.OpenSearchTestCase;
                    }
                    boolean onlyExpungeDeletes = in.readBoolean();
        assertEquals(  
        ForceMergeRequest request = new ForceMergeRequest();
                assertEquals(sample.flush(), deserializedRequest.flush());
                sample.writeTo(out);  
                    assertEquals(sample.onlyExpungeDeletes(), onlyExpungeDeletes);  
                out.writeStringArray(sample.indices());
            "Force-merge indices [shop, blog], maxSegments[-1], onlyExpungeDeletes[false], flush[true], primaryOnly[false]",
            "Force-merge indices [], maxSegments[-1], onlyExpungeDeletes[false], flush[true], primaryOnly[false]",
                        forceMergeUUID = in.readOptionalString();  
        final ForceMergeRequest request = randomRequest();
                    } else {
                    assertEquals(sample.flush(), flush);
 * KIND, either express or implied.  See the License for the
                assertEquals(sample.onlyExpungeDeletes(), deserializedRequest.onlyExpungeDeletes());  
                out.writeBoolean(sample.flush());  
                    in.setVersion(version);  
                out.setVersion(version);
 * specific language governing permissions and limitations
        {
                assertEquals(sample.maxNumSegments(), deserializedRequest.maxNumSegments());
            final ForceMergeRequest sample = randomRequest();  
 * You may obtain a copy of the License at  
        ForceMergeRequest request = new ForceMergeRequest();
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
                out.writeBoolean(sample.primaryOnly());
                    TaskId.readFromStream(in);
package org.opensearch.action.admin.indices.forcemerge;
        );  
                }  
        assertEquals(
                try (StreamInput in = out.bytes().streamInput()) {  
import org.opensearch.core.tasks.TaskId;
        );
 * SPDX-License-Identifier: Apache-2.0
                    int maxNumSegments = in.readInt();
 * software distributed under the License is distributed on an
        }  
        );  
            final ForceMergeRequest sample = randomRequest();
/*
        return request;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
}  
                    out.writeString(sample.forceMergeUUID());  
import org.opensearch.Version;  
    }
        ForceMergeRequest request = new ForceMergeRequest();  
        {
                assertEquals(sample.primaryOnly(), deserializedRequest.primaryOnly());
        request.maxNumSegments(12);  
                    in.setVersion(version);
    public void testDescription() {
            }  
 * GitHub history for details.
    }
        request.flush(false);
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("ForceMergeRequest{maxNumSegments=-1, onlyExpungeDeletes=false, flush=true, primaryOnly=false}", request.toString());  
                out.setVersion(version);  
            request.getDescription()
                } else {
                deserializedRequest = new ForceMergeRequest(in);
        request.flush(false);
 */  
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);  
import org.opensearch.action.support.IndicesOptions;
 * not use this file except in compliance with the License.
    }
            assertEquals(request.onlyExpungeDeletes(), deserializedRequest.onlyExpungeDeletes());
 * compatible open source license.
    }  
                }
        request.onlyExpungeDeletes(true);
        request.primaryOnly(true);  
 * license agreements. See the NOTICE file distributed with
                if (version.onOrAfter(Version.V_3_0_0)) {
            try (StreamInput in = out.bytes().streamInput()) {
        }
        request = new ForceMergeRequest("shop", "blog");
                    boolean flush = in.readBoolean();  
import org.opensearch.core.common.io.stream.StreamInput;  
        request.onlyExpungeDeletes(true);
            final ForceMergeRequest deserializedRequest;  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("ForceMergeRequest{maxNumSegments=12, onlyExpungeDeletes=true, flush=false, primaryOnly=true}", request.toString());
            request.writeTo(out);
/*
        request.onlyExpungeDeletes(true);
 * Unless required by applicable law or agreed to in writing,
/*  
            assertEquals(request.forceMergeUUID(), deserializedRequest.forceMergeUUID());
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.test.VersionUtils;  
 * Modifications Copyright OpenSearch Contributors. See  
public class ForceMergeRequestTests extends OpenSearchTestCase {
    private ForceMergeRequest randomRequest() {
                out.writeBoolean(sample.onlyExpungeDeletes());
        request.maxNumSegments(12);  
            request.getDescription()
    public void testToString() {
 * the Apache License, Version 2.0 (the "License"); you may
        request.flush(randomBoolean());
            request.maxNumSegments(randomIntBetween(1, 10));
            try (BytesStreamOutput out = new BytesStreamOutput()) {
                out.writeInt(sample.maxNumSegments());
                    boolean primaryOnly = in.readBoolean();
                    IndicesOptions.readIndicesOptions(in);  
                    out.writeOptionalString(sample.forceMergeUUID());
                    if (version.onOrAfter(Version.V_3_0_0)) {  
 */
            assertEquals(request.primaryOnly(), deserializedRequest.primaryOnly());
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    }
 *
    public void testBwcSerialization() throws Exception {  
                assertEquals(sample.forceMergeUUID(), deserializedRequest.forceMergeUUID());  
                    assertEquals(sample.forceMergeUUID(), forceMergeUUID);  
        }  
        request = new ForceMergeRequest();
        request = new ForceMergeRequest();
                sample.indicesOptions().writeIndicesOptions(out);  
            "Force-merge indices [], maxSegments[12], onlyExpungeDeletes[true], flush[false], primaryOnly[true]",
    public void testSerialization() throws Exception {
