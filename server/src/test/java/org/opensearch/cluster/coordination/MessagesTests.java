            initialPublishRequest,
public class MessagesTests extends OpenSearchTestCase {
            randomNonNegativeLong(),
                    case 0:
                    case 1:
                            join.getLastAcceptedTerm(),
                    case 3:
 * ownership. Elasticsearch licenses this file to you under
        long currentTerm = randomNonNegativeLong();
                        throw new AssertionError();
 */
    public ClusterState randomClusterState() {
            (CopyFunction<StartJoinRequest>) startJoinRequest -> copyWriteable(startJoinRequest, writableRegistry(), StartJoinRequest::new),
 * You may obtain a copy of the License at
                            preVoteResponse.getCurrentTerm(),
        PublishResponse initialPublishResponse = new PublishResponse(randomNonNegativeLong(), randomNonNegativeLong());
                    case 0:
                    case 4:
                            randomValueOtherThan(join.getLastAcceptedTerm(), OpenSearchTestCase::randomNonNegativeLong),
            publishWithJoinResponse -> {
                        newOptionalJoin = Optional.empty();
                        // change term
                    return new JoinRequest(
 *     http://www.apache.org/licenses/LICENSE-2.0
        Join initialJoin = new Join(
    public void testPreVoteRequestEqualsHashCodeSerialization() {
                            publishWithJoinResponse.getJoin().isPresent() && randomBoolean() ? Optional.empty() : Optional.of(newJoin)
            randomNonNegativeLong(),
                            preVoteResponse.getCurrentTerm(),
            in -> new PublishRequest(randomClusterState())
                        // change term
            randomLongBetween(1, currentTerm),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            join.getSourceNode(),
            randomNonNegativeLong(),
                        // change sourceNode
                            randomValueOtherThan(join.getLastAcceptedVersion(), OpenSearchTestCase::randomNonNegativeLong)
            initialJoin,
                            startJoinRequest.getSourceNode(),
                        // change version
 * SPDX-License-Identifier: Apache-2.0
            (CopyFunction<PreVoteRequest>) preVoteRequest -> copyWriteable(preVoteRequest, writableRegistry(), PreVoteRequest::new),
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
        );
                    }
                        return new PublishWithJoinResponse(
/*
                switch (randomInt(1)) {
        );
 * The OpenSearch Contributors require contributions made to
                            join.getLastAcceptedVersion()
                    } else {
        Join initialJoin = new Join(
            }
            preVoteResponse -> {
                            randomNonNegativeLong(),
                        );
            initialPublishResponse,
            }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        );
                }
                        // change last accepted term
                        );
                        newOptionalJoin = Optional.of(
                            publishResponse.getVersion()
 * this file be licensed under the Apache-2.0 license or a
                switch (randomInt(4)) {
        return CoordinationStateTests.clusterState(
 *
            publishRequest -> new PublishRequest(publishRequest.getAcceptedState()),
                            randomNonNegativeLong()
                    default:
                        return new Join(
        );
}
                            randomValueOtherThan(preVoteResponse.getLastAcceptedVersion(), OpenSearchTestCase::randomNonNegativeLong)
            }
                }
    public void testPreVoteResponseEqualsHashCodeSerialization() {
                        );
                        // change optional join
            (CopyFunction<PreVoteResponse>) preVoteResponse -> copyWriteable(preVoteResponse, writableRegistry(), PreVoteResponse::new),
            joinRequest -> {
                            preVoteResponse.getLastAcceptedVersion()
                            new Join(
        Join initialJoin = new Join(
                        );
                        );
                            preVoteResponse.getLastAcceptedTerm(),
            randomNonNegativeLong()
            randomNonNegativeLong(),
            }
                        return new StartJoinRequest(createNode(randomAlphaOfLength(20)), startJoinRequest.getTerm());
                    default:
            (CopyFunction<PublishResponse>) publishResponse -> copyWriteable(publishResponse, writableRegistry(), PublishResponse::new),
                        );
 * under the License.
                    case 2:
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            publishResponse -> {
                            randomValueOtherThan(applyCommit.getVersion(), OpenSearchTestCase::randomNonNegativeLong)
 * compatible open source license.
        );
                                preVoteResponse.getCurrentTerm(),
                                randomNonNegativeLong()
                        joinRequest.getOptionalJoin()
                    case 1:
                    case 0:
                        );
 */
                            publishWithJoinResponse.getPublishResponse(),
    }
                        // change term
                            join.getSourceNode(),
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                                joinRequest.getSourceNode(),
package org.opensearch.cluster.coordination;
            createNode(randomAlphaOfLength(10)),
        return new DiscoveryNode(id, buildNewFakeTransportAddress(), Version.CURRENT);
    }
                    case 1:
                    return new PreVoteRequest(createNode(randomAlphaOfLength(10)), preVoteRequest.getCurrentTerm());
                switch (randomInt(2)) {
                        throw new AssertionError();
                            ),
    }
                        );
                            randomValueOtherThan(startJoinRequest.getTerm(), OpenSearchTestCase::randomNonNegativeLong)
            (CopyFunction<PublishWithJoinResponse>) publishWithJoinResponse -> copyWriteable(
/*
                }
                        return new StartJoinRequest(
    }
        );
                            new PublishResponse(randomNonNegativeLong(), randomNonNegativeLong()),
            randomNonNegativeLong(),
                            randomValueOtherThan(
        StartJoinRequest initialStartJoinRequest = new StartJoinRequest(createNode(randomAlphaOfLength(10)), randomNonNegativeLong());
                        // change version
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.set.Sets;
            randomNonNegativeLong(),
                                preVoteResponse.getLastAcceptedTerm(),
            currentTerm,
            initialPublishResponse,
import org.opensearch.Version;
                        return new PublishWithJoinResponse(
                        );
        );
                            join.getTerm(),
                    // change OptionalJoin
    public void testPublishWithJoinResponseEqualsHashCodeSerialization() {
 * specific language governing permissions and limitations
            randomNonNegativeLong(),
    public void testApplyCommitEqualsHashCodeSerialization() {
                        return new ApplyCommitRequest(
                        return new ApplyCommitRequest(
                        );
                            join.getTargetNode(),
/*
                                () -> randomLongBetween(1, preVoteResponse.getCurrentTerm())
                        // change publish response
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                            randomNonNegativeLong(),
                            randomValueOtherThan(applyCommit.getTerm(), OpenSearchTestCase::randomNonNegativeLong),
                        throw new AssertionError();
                        return new PreVoteResponse(
                PublishWithJoinResponse::new
        );
            createNode(randomAlphaOfLength(10)),
                            createNode(randomAlphaOfLength(20)),
            randomNonNegativeLong(),
        );
                        return new PublishResponse(
                } else {
 * this work for additional information regarding copyright
            initialPreVoteRequest,
                    return new JoinRequest(
                    default:
 * Modifications Copyright OpenSearch Contributors. See
            ),
                    );
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
            randomBoolean() ? Optional.empty() : Optional.of(initialJoin)
            preVoteRequest -> {
                        return new Join(
 */
                }
                }
                        );
            randomLong()
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
    }
                            join.getTerm(),
 * Unless required by applicable law or agreed to in writing,
                            createNode(randomAlphaOfLength(10)),
                        );
                            randomValueOtherThan(publishResponse.getTerm(), OpenSearchTestCase::randomNonNegativeLong),
                            applyCommit.getSourceNode(),
                    case 1:
                            join.getSourceNode(),
                        // change version
            startJoinRequest -> {
                            applyCommit.getVersion()
                }
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
                            randomValueOtherThan(publishResponse.getVersion(), OpenSearchTestCase::randomNonNegativeLong)
                    default:
            randomNonNegativeLong(),
                            publishResponse.getTerm(),
                        // change targetNode
    private DiscoveryNode createNode(String id) {
                                randomNonNegativeLong(),
import java.util.Optional;
                switch (randomInt(1)) {
        PublishResponse initialPublishResponse = new PublishResponse(randomNonNegativeLong(), randomNonNegativeLong());
                        return new PublishResponse(
    }
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
    public void testPublishRequestEqualsHashCode() {
                        // change sourceNode
                                createNode(randomAlphaOfLength(10)),
                    case 0:
                        createNode(randomAlphaOfLength(10)),
                    default:
                        assumeTrue("last-accepted term is Long.MAX_VALUE", preVoteResponse.getLastAcceptedTerm() < Long.MAX_VALUE);
                    final Optional<Join> newOptionalJoin;
        );
import org.opensearch.cluster.ClusterState;
                        joinRequest.getMinimumTerm(),
 *
                switch (randomInt(1)) {
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                        throw new AssertionError();
                    case 1:
            (CopyFunction<ApplyCommitRequest>) applyCommit -> copyWriteable(applyCommit, writableRegistry(), ApplyCommitRequest::new),
                            ),
                    case 2:
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                } else {
                    );
                            applyCommit.getTerm(),
    }
            createNode(randomAlphaOfLength(10)),
                        Join newJoin = new Join(
                        return new Join(
                publishWithJoinResponse,
                            join.getTerm(),
            randomNonNegativeLong()
            createNode(randomAlphaOfLength(10)),
            randomNonNegativeLong()
        PreVoteResponse initialPreVoteResponse = new PreVoteResponse(
 * not use this file except in compliance with the License.
        JoinRequest initialJoinRequest = new JoinRequest(
            }
            }
                        throw new AssertionError();
                        );
            initialPreVoteResponse,
                            join.getTerm(),
                            applyCommit.getSourceNode(),
            join -> {
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
import org.opensearch.cluster.node.DiscoveryNode;
                    return new PreVoteRequest(preVoteRequest.getSourceNode(), randomNonNegativeLong());
            createNode(randomAlphaOfLength(10)),
        PublishRequest initialPublishRequest = new PublishRequest(randomClusterState());
        );
                    return new JoinRequest(joinRequest.getSourceNode(), joinRequest.getMinimumTerm(), newOptionalJoin);
import org.opensearch.test.OpenSearchTestCase;
                            join.getLastAcceptedVersion()
                }
            createNode(randomAlphaOfLength(10)),
 * software distributed under the License is distributed on an
            initialPublishWithJoinResponse,
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                            join.getTargetNode(),
                        );
            initialApplyCommit,
                                randomNonNegativeLong(),
    }
                        return new PreVoteResponse(
                    case 0:
    public void testPublishResponseEqualsHashCodeSerialization() {
            }
                        randomValueOtherThan(joinRequest.getMinimumTerm(), OpenSearchTestCase::randomNonNegativeLong),
                    case 0:
            randomBoolean() ? Optional.empty() : Optional.of(initialJoin)
                    default:
                if (randomBoolean() && joinRequest.getOptionalJoin().isPresent() == false) {
    public void testStartJoinRequestEqualsHashCodeSerialization() {
                        // change term
    }
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false))),
 * the Apache License, Version 2.0 (the "License"); you may
                        );
                        assumeTrue("current term is 1", 1 < preVoteResponse.getCurrentTerm());
                            publishWithJoinResponse.getJoin()
                            join.getSourceNode(),
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
        );
            initialStartJoinRequest,
 * license agreements. See the NOTICE file distributed with
            initialJoin.getSourceNode(),
    }
        );
                            randomValueOtherThan(join.getTerm(), OpenSearchTestCase::randomNonNegativeLong),
                        return new Join(
                            createNode(randomAlphaOfLength(10)),
    }
                            join.getTargetNode(),
            randomNonNegativeLong()
        PreVoteRequest initialPreVoteRequest = new PreVoteRequest(createNode(randomAlphaOfLength(10)), randomNonNegativeLong());
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                switch (randomInt(2)) {
        );
        PublishWithJoinResponse initialPublishWithJoinResponse = new PublishWithJoinResponse(
                            join.getLastAcceptedTerm(),
                            createNode(randomAlphaOfLength(20)),
                            preVoteResponse.getLastAcceptedVersion()
                        return new PreVoteResponse(
                }
                if (randomBoolean()) {
import org.opensearch.test.EqualsHashCodeTestUtils;
    public void testJoinRequestEqualsHashCodeSerialization() {
        ApplyCommitRequest initialApplyCommit = new ApplyCommitRequest(
    public void testJoinEqualsHashCodeSerialization() {
            (CopyFunction<Join>) join -> copyWriteable(join, writableRegistry(), Join::new),
                    case 2:
                        // change sourceNode
            createNode(randomAlphaOfLength(10)),
                            randomValueOtherThan(
                        joinRequest.getSourceNode(),
                                () -> randomLongBetween(preVoteResponse.getLastAcceptedTerm(), Long.MAX_VALUE)
                        joinRequest.getOptionalJoin()
 * GitHub history for details.
            initialJoinRequest,
            (CopyFunction<JoinRequest>) joinRequest -> copyWriteable(joinRequest, writableRegistry(), JoinRequest::new),
                        return new ApplyCommitRequest(createNode(randomAlphaOfLength(20)), applyCommit.getTerm(), applyCommit.getVersion());
                            join.getLastAcceptedTerm(),
        );
                    if (joinRequest.getOptionalJoin().isPresent() && randomBoolean()) {
                            preVoteResponse.getLastAcceptedTerm(),
                    case 1:
            applyCommit -> {
            randomNonNegativeLong()
                            )
            createNode(randomAlphaOfLength(10)),
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false))),
                        );
                            join.getLastAcceptedVersion()
                } else if (randomBoolean()) {
                writableRegistry(),
            randomNonNegativeLong(),
                            join.getTargetNode(),
            }
                        return new Join(
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
 * Licensed to Elasticsearch under one or more contributor
                        );
 *
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
                        throw new AssertionError();
                            join.getLastAcceptedTerm(),
        );
                            join.getLastAcceptedVersion()
        );
