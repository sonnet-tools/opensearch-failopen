import org.opensearch.index.seqno.SequenceNumbers;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.Store;  
import static org.opensearch.test.VersionUtils.randomVersion;  
/*  
        assertThat(outRequest.metadataSnapshot().asMap(), equalTo(inRequest.metadataSnapshot().asMap()));  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
 * GitHub history for details.
        final ByteArrayInputStream inBuffer = new ByteArrayInputStream(outBuffer.toByteArray());  
 * compatible open source license.
        final OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
            new DiscoveryNode("b", buildNewFakeTransportAddress(), emptyMap(), emptySet(), targetNodeVersion),  
                Collections.emptyMap(),
 * under the License.  
 */
import org.opensearch.common.UUIDs;  
            new DiscoveryNode("a", buildNewFakeTransportAddress(), emptyMap(), emptySet(), targetNodeVersion),
 *
 * Modifications Copyright OpenSearch Contributors. See
            UUIDs.randomBase64UUID(),
            randomBoolean() || metadataSnapshot.getHistoryUUID() == null ? SequenceNumbers.UNASSIGNED_SEQ_NO : randomNonNegativeLong()
import org.opensearch.Version;
import org.opensearch.test.OpenSearchTestCase;
import java.io.ByteArrayOutputStream;
 * this file be licensed under the Apache-2.0 license or a
/*
 * license agreements. See the NOTICE file distributed with
        assertThat(outRequest.sourceNode(), equalTo(inRequest.sourceNode()));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.node.DiscoveryNode;
        outRequest.writeTo(out);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
public class StartRecoveryRequestTests extends OpenSearchTestCase {  
 * the Apache License, Version 2.0 (the "License"); you may
import static java.util.Collections.emptyMap;
 *  
        final Version targetNodeVersion = randomVersion(random());  
        final ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
import java.util.Collections;
            : new Store.MetadataSnapshot(  
        );
import org.opensearch.core.index.shard.ShardId;  
            ? Store.MetadataSnapshot.EMPTY
            randomBoolean(),
 * You may obtain a copy of the License at  
            metadataSnapshot,
    }
        in.setVersion(targetNodeVersion);
        assertThat(outRequest.targetNode(), equalTo(inRequest.targetNode()));
        assertThat(outRequest.startingSeqNo(), equalTo(inRequest.startingSeqNo()));  
        assertThat(outRequest.isPrimaryRelocation(), equalTo(inRequest.isPrimaryRelocation()));
 */  
                randomIntBetween(0, 100)  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
            );
import static java.util.Collections.emptySet;
            randomNonNegativeLong(),  
package org.opensearch.indices.recovery;
 * ownership. Elasticsearch licenses this file to you under  
import java.io.ByteArrayInputStream;  
 * this work for additional information regarding copyright
import org.opensearch.index.engine.Engine;
    public void testSerialization() throws Exception {
            new ShardId("test", "_na_", 0),  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(outRequest.recoveryId(), equalTo(inRequest.recoveryId()));
        out.setVersion(targetNodeVersion);  
/*  
}  
                Collections.singletonMap(Engine.HISTORY_UUID_KEY, UUIDs.randomBase64UUID()),
        assertThat(outRequest.shardId(), equalTo(inRequest.shardId()));
 * not use this file except in compliance with the License.
 */  
        Store.MetadataSnapshot metadataSnapshot = randomBoolean()
        InputStreamStreamInput in = new InputStreamStreamInput(inBuffer);
        final StartRecoveryRequest inRequest = new StartRecoveryRequest(in);  
        assertThat(outRequest.targetAllocationId(), equalTo(inRequest.targetAllocationId()));  
        final StartRecoveryRequest outRequest = new StartRecoveryRequest(
 * KIND, either express or implied.  See the License for the
