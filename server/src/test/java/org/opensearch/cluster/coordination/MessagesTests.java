        );
                switch (randomInt(2)) {
                        randomValueOtherThan(joinRequest.getMinimumTerm(), OpenSearchTestCase::randomNonNegativeLong),
                    case 0:
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
        PublishWithJoinResponse initialPublishWithJoinResponse = new PublishWithJoinResponse(
                            preVoteResponse.getCurrentTerm(),
            in -> new PublishRequest(randomClusterState())  
            initialJoinRequest,
import org.opensearch.test.EqualsHashCodeTestUtils;
            }
                            publishWithJoinResponse.getJoin().isPresent() && randomBoolean() ? Optional.empty() : Optional.of(newJoin)
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                    return new PreVoteRequest(createNode(randomAlphaOfLength(10)), preVoteRequest.getCurrentTerm());
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                        return new Join(
                        joinRequest.getOptionalJoin()  
                        throw new AssertionError();
                        return new StartJoinRequest(  
            initialPreVoteResponse,  
            initialPublishResponse,
    public void testJoinRequestEqualsHashCodeSerialization() {
        );
                } else {
    }
            randomNonNegativeLong()  
                    }
import org.opensearch.Version;  
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
            createNode(randomAlphaOfLength(10)),
                    default:  
    }
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type  
                            createNode(randomAlphaOfLength(20)),  
                        return new Join(
            publishResponse -> {
        PreVoteRequest initialPreVoteRequest = new PreVoteRequest(createNode(randomAlphaOfLength(10)), randomNonNegativeLong());  
                        return new PreVoteResponse(  
                    } else {
                        );
/*
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false))),  
            randomNonNegativeLong(),
        Join initialJoin = new Join(  
                            startJoinRequest.getSourceNode(),
        );  
            (CopyFunction<JoinRequest>) joinRequest -> copyWriteable(joinRequest, writableRegistry(), JoinRequest::new),  
        PreVoteResponse initialPreVoteResponse = new PreVoteResponse(
            createNode(randomAlphaOfLength(10)),
                        );
                            )  
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                    case 1:  
            createNode(randomAlphaOfLength(10)),
    }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
                        return new PreVoteResponse(
            (CopyFunction<PreVoteResponse>) preVoteResponse -> copyWriteable(preVoteResponse, writableRegistry(), PreVoteResponse::new),
                            join.getTargetNode(),
                }  
    }
        );
            initialPublishRequest,
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false))),
 * not use this file except in compliance with the License.
                            randomValueOtherThan(applyCommit.getTerm(), OpenSearchTestCase::randomNonNegativeLong),  
        );  
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                                preVoteResponse.getLastAcceptedTerm(),
                        return new ApplyCommitRequest(
                        return new PublishResponse(
        );
                    case 1:
                        );
 *  
                    return new PreVoteRequest(preVoteRequest.getSourceNode(), randomNonNegativeLong());  
                            join.getTargetNode(),
                    case 2:  
/*  
                        );
            }  
                        // change sourceNode
 * under the License.  
                    case 0:  
    }
                    return new JoinRequest(  
            }
                    default:
                    case 0:  
                    case 4:  
                                () -> randomLongBetween(preVoteResponse.getLastAcceptedTerm(), Long.MAX_VALUE)  
                            join.getSourceNode(),  
                            applyCommit.getSourceNode(),  
 * Licensed to Elasticsearch under one or more contributor  
                                randomNonNegativeLong(),
                            randomValueOtherThan(publishResponse.getTerm(), OpenSearchTestCase::randomNonNegativeLong),  
                            join.getTerm(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        joinRequest.getSourceNode(),
                    case 0:
                    case 2:  
                    case 1:
                            ),
 * compatible open source license.
            startJoinRequest -> {
                    case 0:  
    private DiscoveryNode createNode(String id) {  
    public void testApplyCommitEqualsHashCodeSerialization() {
            initialJoin.getSourceNode(),
                            preVoteResponse.getLastAcceptedVersion()  
                writableRegistry(),
                            join.getTargetNode(),
                            new PublishResponse(randomNonNegativeLong(), randomNonNegativeLong()),  
                        throw new AssertionError();
                }
                    case 2:  
            randomBoolean() ? Optional.empty() : Optional.of(initialJoin)  
            ),  
    }  
                        createNode(randomAlphaOfLength(10)),
                    final Optional<Join> newOptionalJoin;
import org.opensearch.cluster.ClusterState;
            preVoteRequest -> {
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            publishWithJoinResponse -> {
                }
            randomNonNegativeLong(),  
            (CopyFunction<ApplyCommitRequest>) applyCommit -> copyWriteable(applyCommit, writableRegistry(), ApplyCommitRequest::new),
                        );  
                        assumeTrue("last-accepted term is Long.MAX_VALUE", preVoteResponse.getLastAcceptedTerm() < Long.MAX_VALUE);
                        // change term
                        return new PublishWithJoinResponse(  
            }
                            randomValueOtherThan(applyCommit.getVersion(), OpenSearchTestCase::randomNonNegativeLong)
                            ),  
                        );
            randomNonNegativeLong(),  
                if (randomBoolean()) {  
            publishRequest -> new PublishRequest(publishRequest.getAcceptedState()),
                            randomValueOtherThan(  
            initialApplyCommit,
                        // change version
 */  
    public void testPreVoteResponseEqualsHashCodeSerialization() {  
    public void testPreVoteRequestEqualsHashCodeSerialization() {
                        // change last accepted term
 * software distributed under the License is distributed on an
        );  
            (CopyFunction<StartJoinRequest>) startJoinRequest -> copyWriteable(startJoinRequest, writableRegistry(), StartJoinRequest::new),
            preVoteResponse -> {
                                () -> randomLongBetween(1, preVoteResponse.getCurrentTerm())
                    case 1:  
        );
                        return new PublishResponse(
                            randomValueOtherThan(join.getLastAcceptedVersion(), OpenSearchTestCase::randomNonNegativeLong)
            joinRequest -> {
            (CopyFunction<PublishWithJoinResponse>) publishWithJoinResponse -> copyWriteable(
        return CoordinationStateTests.clusterState(
                                joinRequest.getSourceNode(),
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
            randomNonNegativeLong(),  
                        );
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                            preVoteResponse.getCurrentTerm(),
                        return new Join(
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
            randomBoolean() ? Optional.empty() : Optional.of(initialJoin)
                        // change version
                            join.getLastAcceptedTerm(),  
        long currentTerm = randomNonNegativeLong();
                            randomNonNegativeLong(),
        StartJoinRequest initialStartJoinRequest = new StartJoinRequest(createNode(randomAlphaOfLength(10)), randomNonNegativeLong());  
                        );
                        );
public class MessagesTests extends OpenSearchTestCase {
            createNode(randomAlphaOfLength(10)),
        Join initialJoin = new Join(  
                }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                        );  
            randomNonNegativeLong(),
        Join initialJoin = new Join(
            initialPublishWithJoinResponse,
                            createNode(randomAlphaOfLength(10)),  
                switch (randomInt(1)) {
                        // change sourceNode  
            randomNonNegativeLong(),
            randomNonNegativeLong(),
            randomNonNegativeLong(),  
                        throw new AssertionError();
                    case 3:  
 * KIND, either express or implied.  See the License for the
        );
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                            join.getLastAcceptedTerm(),  
            createNode(randomAlphaOfLength(10)),  
                            randomValueOtherThan(join.getTerm(), OpenSearchTestCase::randomNonNegativeLong),
            randomNonNegativeLong()
                            new Join(  
                                createNode(randomAlphaOfLength(10)),
    public void testPublishWithJoinResponseEqualsHashCodeSerialization() {
    }  
package org.opensearch.cluster.coordination;
                        joinRequest.getOptionalJoin()  
        JoinRequest initialJoinRequest = new JoinRequest(
                        // change term  
                    default:
            }  
            (CopyFunction<PublishResponse>) publishResponse -> copyWriteable(publishResponse, writableRegistry(), PublishResponse::new),  
            }  
            initialJoin,
}  
 * The OpenSearch Contributors require contributions made to  
    public void testJoinEqualsHashCodeSerialization() {
                    default:
                                randomNonNegativeLong()
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
                } else {
 * Unless required by applicable law or agreed to in writing,
                            createNode(randomAlphaOfLength(10)),
        );
import org.opensearch.common.util.set.Sets;  
        PublishResponse initialPublishResponse = new PublishResponse(randomNonNegativeLong(), randomNonNegativeLong());
    }  
        );
                        // change term
                    default:  
                            join.getLastAcceptedTerm(),  
                        return new StartJoinRequest(createNode(randomAlphaOfLength(20)), startJoinRequest.getTerm());  
    public ClusterState randomClusterState() {  
                            join.getTargetNode(),
        PublishResponse initialPublishResponse = new PublishResponse(randomNonNegativeLong(), randomNonNegativeLong());
        );  
                    case 0:
            currentTerm,  
    public void testPublishResponseEqualsHashCodeSerialization() {
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type  
            (CopyFunction<PreVoteRequest>) preVoteRequest -> copyWriteable(preVoteRequest, writableRegistry(), PreVoteRequest::new),
                            applyCommit.getTerm(),
                            join.getSourceNode(),  
            randomNonNegativeLong()
                        return new ApplyCommitRequest(createNode(randomAlphaOfLength(20)), applyCommit.getTerm(), applyCommit.getVersion());
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
 *     http://www.apache.org/licenses/LICENSE-2.0
            randomNonNegativeLong()
                            randomValueOtherThan(publishResponse.getVersion(), OpenSearchTestCase::randomNonNegativeLong)
                        throw new AssertionError();
                        throw new AssertionError();
                            join.getLastAcceptedVersion()
            createNode(randomAlphaOfLength(10)),
            randomNonNegativeLong(),  
            initialStartJoinRequest,  
                        );
                                randomNonNegativeLong(),  
                    );
                        // change sourceNode
                        // change publish response
 * GitHub history for details.
                        return new Join(
                        newOptionalJoin = Optional.empty();  
            randomNonNegativeLong(),
                        );  
            applyCommit -> {  
                PublishWithJoinResponse::new
            initialPreVoteRequest,  
                            applyCommit.getSourceNode(),
                            join.getLastAcceptedTerm(),  
    }
            }
                        );
                }
                        Join newJoin = new Join(
import java.util.Optional;
                }  
 * this file be licensed under the Apache-2.0 license or a
                        return new ApplyCommitRequest(
        );  
 */
        );
import org.opensearch.test.OpenSearchTestCase;  
                        return new PreVoteResponse(
            (CopyFunction<Join>) join -> copyWriteable(join, writableRegistry(), Join::new),  
                            join.getTerm(),
                        return new Join(
            randomLong()
                if (randomBoolean() && joinRequest.getOptionalJoin().isPresent() == false) {
 * the Apache License, Version 2.0 (the "License"); you may
                }  
                            applyCommit.getVersion()
                        // change term
                    if (joinRequest.getOptionalJoin().isPresent() && randomBoolean()) {
 */
        );
                            join.getLastAcceptedVersion()
                switch (randomInt(1)) {  
                            join.getLastAcceptedVersion()
                        return new PublishWithJoinResponse(
                            createNode(randomAlphaOfLength(20)),
 *
    }
 * specific language governing permissions and limitations
                        );
                        // change version
        ApplyCommitRequest initialApplyCommit = new ApplyCommitRequest(  
                            join.getTerm(),
        return new DiscoveryNode(id, buildNewFakeTransportAddress(), Version.CURRENT);
                        assumeTrue("current term is 1", 1 < preVoteResponse.getCurrentTerm());  
                } else if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
                        // change targetNode
                            join.getLastAcceptedVersion()
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type  
 * ownership. Elasticsearch licenses this file to you under  
            initialPublishResponse,
                            randomValueOtherThan(startJoinRequest.getTerm(), OpenSearchTestCase::randomNonNegativeLong)
            }
        PublishRequest initialPublishRequest = new PublishRequest(randomClusterState());
                    case 1:  
/*
                            publishResponse.getTerm(),  
                        // change optional join
                            randomNonNegativeLong()
import org.opensearch.cluster.node.DiscoveryNode;
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
                            join.getTerm(),
                    // change OptionalJoin  
    public void testPublishRequestEqualsHashCode() {
                        );
                    default:  
                }
                        joinRequest.getMinimumTerm(),
 * You may obtain a copy of the License at  
                            publishWithJoinResponse.getPublishResponse(),
            createNode(randomAlphaOfLength(10)),
    public void testStartJoinRequestEqualsHashCodeSerialization() {
                    case 1:
                            publishResponse.getVersion()
                        throw new AssertionError();
                            randomValueOtherThan(
                        );
                            preVoteResponse.getLastAcceptedVersion()
            join -> {
    }  
                                preVoteResponse.getCurrentTerm(),
                switch (randomInt(1)) {
 *
                    return new JoinRequest(  
            randomLongBetween(1, currentTerm),
                            randomValueOtherThan(preVoteResponse.getLastAcceptedVersion(), OpenSearchTestCase::randomNonNegativeLong)
                        newOptionalJoin = Optional.of(
 * Modifications Copyright OpenSearch Contributors. See  
        );
                switch (randomInt(2)) {  
                        );
                switch (randomInt(4)) {
                            preVoteResponse.getLastAcceptedTerm(),
                    return new JoinRequest(joinRequest.getSourceNode(), joinRequest.getMinimumTerm(), newOptionalJoin);  
                    );
                            preVoteResponse.getLastAcceptedTerm(),  
                            join.getSourceNode(),  
                            join.getSourceNode(),  
                publishWithJoinResponse,  
        );
                            publishWithJoinResponse.getJoin()
                            randomNonNegativeLong(),  
            randomNonNegativeLong()
                            randomValueOtherThan(join.getLastAcceptedTerm(), OpenSearchTestCase::randomNonNegativeLong),  
            createNode(randomAlphaOfLength(10)),
