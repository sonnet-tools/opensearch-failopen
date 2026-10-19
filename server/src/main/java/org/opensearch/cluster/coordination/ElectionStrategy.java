            long localAcceptedVersion,  
    protected ElectionStrategy() {  
        DiscoveryNode localNode,
                lastCommittedConfiguration,
import org.opensearch.cluster.coordination.CoordinationState.VoteCollection;
 *
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
            long localCurrentTerm,
        protected boolean satisfiesAdditionalQuorumConstraints(
 * ownership. Elasticsearch licenses this file to you under  
    );  
 * specific language governing permissions and limitations
     * @param joinVotes                  the votes that were provided so far
 * the Apache License, Version 2.0 (the "License"); you may
 */
            DiscoveryNode localNode,  
        return joinVotes.isQuorum(lastCommittedConfiguration)
 * this work for additional information regarding copyright
 *  
    ) {  
 */
    /**
 */  
            VoteCollection joinVotes  
/*  
    }
            );
        DiscoveryNode localNode,
    }  
 * The OpenSearch Contributors require contributions made to  
        long localAcceptedTerm,
     * @param localAcceptedVersion       the last accepted version of the local node
        long localCurrentTerm,  
 * license agreements. See the NOTICE file distributed with
    };
 */  
        VotingConfiguration lastCommittedConfiguration,  
                localNode,
            && satisfiesAdditionalQuorumConstraints(  
            && joinVotes.isQuorum(lastAcceptedConfiguration)
 *
/**
 *
 * Licensed to Elasticsearch under one or more contributor  
            long localAcceptedTerm,
        long localAcceptedTerm,
 * not use this file except in compliance with the License.
 * GitHub history for details.
        @Override
     * @param localAcceptedTerm          the last accepted term of the local node  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;  
     * @param localCurrentTerm           the current term of the local node
        }  
 * Unless required by applicable law or agreed to in writing,
                localAcceptedVersion,
import org.opensearch.cluster.node.DiscoveryNode;
 * Modifications Copyright OpenSearch Contributors. See  
        long localCurrentTerm,  
     * @param localNode                  the local node for the election quorum
/*
        VotingConfiguration lastCommittedConfiguration,  
 * software distributed under the License is distributed on an
                joinVotes
                localAcceptedTerm,  
     * The extension point to be overridden by plugins. Defines additional constraints on the election quorum.  
     * @return true iff the additional quorum constraints are satisfied
package org.opensearch.cluster.coordination;
        VotingConfiguration lastAcceptedConfiguration,
/*
        VoteCollection joinVotes
        ) {
public abstract class ElectionStrategy {
 *     http://www.apache.org/licenses/LICENSE-2.0
        long localAcceptedVersion,
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            return true;
    protected abstract boolean satisfiesAdditionalQuorumConstraints(
     * @param lastAcceptedConfiguration  the last accepted configuration for the election quorum  
            VotingConfiguration lastCommittedConfiguration,
     */  
}
 * Custom additional quorum restrictions can be defined by implementing the {@link #satisfiesAdditionalQuorumConstraints} method.  
        VotingConfiguration lastAcceptedConfiguration,
 * Allows plugging in a custom election strategy, restricting the notion of an election quorum.
 * @opensearch.internal
    public static final ElectionStrategy DEFAULT_INSTANCE = new ElectionStrategy() {  
     * Whether there is an election quorum from the point of view of the given local node under the provided voting configurations
        long localAcceptedVersion,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                localCurrentTerm,
     * @param lastCommittedConfiguration the last committed configuration for the election quorum
 * under the License.  
    public final boolean isElectionQuorum(
        VoteCollection joinVotes
            VotingConfiguration lastAcceptedConfiguration,
     */  
 * You may obtain a copy of the License at  
                lastAcceptedConfiguration,  
    /**
