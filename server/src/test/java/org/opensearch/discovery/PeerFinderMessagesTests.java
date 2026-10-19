 * this work for additional information regarding copyright
    public void testPeersResponseEqualsHashCodeSerialization() {
                        }
        }
            initialPeersResponse = new PeersResponse(  
                Optional.empty(),
import java.util.Arrays;  
 *
        return new DiscoveryNode(id, buildNewFakeTransportAddress(), Version.CURRENT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else if (discoveryNodes.isEmpty() == false && randomBoolean()) {  
 * this file be licensed under the Apache-2.0 license or a
                            return new PeersResponse(Optional.empty(), singletonList(createNode(randomAlphaOfLength(10))), term);  
            }
            createNode(randomAlphaOfLength(10)),
    }  
                Arrays.stream(generateRandomStringArray(10, 10, false, false)).map(this::createNode).collect(Collectors.toList()),
public class PeerFinderMessagesTests extends OpenSearchTestCase {  
                        } else {
            discoveryNodes.set(randomIntBetween(0, discoveryNodes.size() - 1), createNode(randomAlphaOfLength(10)));
                if (randomBoolean()) {
            in -> {
    }  
    private DiscoveryNode createNode(String id) {
 * ownership. Elasticsearch licenses this file to you under  
 *  
                } else {
import java.util.Collection;
 * Unless required by applicable law or agreed to in writing,
                    } else {
 */  
                }  
 * You may obtain a copy of the License at  
        }
    }  
        final PeersResponse initialPeersResponse;
 * Licensed to Elasticsearch under one or more contributor  
        );
import org.opensearch.test.EqualsHashCodeTestUtils;
                            return new PeersResponse(Optional.of(createNode(randomAlphaOfLength(10))), emptyList(), term);
                        if (randomBoolean()) {  
 */  
import org.opensearch.cluster.coordination.PeersResponse;
}
    public void testPeersRequestEqualsHashCodeSerialization() {
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
    private List<DiscoveryNode> modifyDiscoveryNodesList(Collection<DiscoveryNode> originalNodes, boolean allowEmpty) {
            Arrays.stream(generateRandomStringArray(10, 10, false)).map(this::createNode).collect(Collectors.toList())
            (CopyFunction<PeersRequest>) publishRequest -> copyWriteable(publishRequest, writableRegistry(), PeersRequest::new),
/*
            (CopyFunction<PeersResponse>) publishResponse -> copyWriteable(publishResponse, writableRegistry(), PeersResponse::new),
            );
            discoveryNodes.remove(randomIntBetween(0, discoveryNodes.size() - 1));
 * the Apache License, Version 2.0 (the "License"); you may
                    return new PeersRequest(in.getSourceNode(), modifyDiscoveryNodesList(in.getKnownPeers(), true));
            initialPeersResponse = new PeersResponse(Optional.of(createNode(randomAlphaOfLength(10))), emptyList(), initialTerm);
        final List<DiscoveryNode> discoveryNodes = new ArrayList<>(originalNodes);  
                final long term = in.getTerm();  
            in -> {  
/*  
import java.util.Optional;  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
                        if (randomBoolean()) {  
        if (discoveryNodes.isEmpty() == false && randomBoolean() && (allowEmpty || discoveryNodes.size() > 1)) {
    }  
                    if (in.getClusterManagerNode().isPresent()) {
                            return new PeersResponse(in.getClusterManagerNode(), modifyDiscoveryNodesList(in.getKnownPeers(), false), term);  
                if (randomBoolean()) {
                        }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
 * software distributed under the License is distributed on an
        return discoveryNodes;
 * license agreements. See the NOTICE file distributed with
        );  
        final PeersRequest initialPeersRequest = new PeersRequest(  
import org.opensearch.Version;
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
        );
package org.opensearch.discovery;
                        in.getClusterManagerNode(),  
        final long initialTerm = randomNonNegativeLong();  
                }  
        } else {
 * compatible open source license.
import static java.util.Collections.emptyList;  
                final List<DiscoveryNode> discoveryNodes = new ArrayList<>(in.getKnownPeers());
 * GitHub history for details.
                } else {
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.test.OpenSearchTestCase;  
        if (randomBoolean()) {  
                    return new PeersRequest(createNode(randomAlphaOfLength(10)), discoveryNodes);  
 * under the License.  
            discoveryNodes.add(createNode(randomAlphaOfLength(10)));  
                            return new PeersResponse(Optional.of(createNode(randomAlphaOfLength(10))), in.getKnownPeers(), term);
                    return new PeersResponse(
                        in.getKnownPeers(),
            initialPeersRequest,
import static java.util.Collections.singletonList;
 * not use this file except in compliance with the License.
            }
            initialPeersResponse,  
 *
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                        } else {
                    }
                initialTerm  
                        randomValueOtherThan(term, OpenSearchTestCase::randomNonNegativeLong)
 * SPDX-License-Identifier: Apache-2.0
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
/*  
 * KIND, either express or implied.  See the License for the
import java.util.ArrayList;
 */
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
import java.util.stream.Collectors;
                    );  
