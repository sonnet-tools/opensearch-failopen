import org.opensearch.cluster.coordination.CoordinationMetadata;
            .build();
        );
    ) {
 *  
        ClusterState currentState,
    public static Set<VotingConfigExclusion> resolveVotingConfigExclusionsAndCheckMaximum(
        final ClusterState newState = ClusterState.builder(currentState).metadata(newMetadata).build();  
        final Metadata newMetadata = Metadata.builder(currentState.metadata()).coordinationMetadata(builder.build()).build();
    /**
        AddVotingConfigExclusionsRequest request,
        int maxVotingConfigExclusions
     *
 *
    public static ClusterState addExclusionAndGetState(
 * @opensearch.internal
        return ClusterState.builder(currentState).metadata(newMetadata).build();  
            .clearVotingConfigExclusions()  
    ) {
        final Metadata newMetadata = Metadata.builder(currentState.metadata()).coordinationMetadata(newCoordinationMetadata).build();
        int finalMaxVotingConfigExclusions
     */  
     * @return newly formed cluster state after clearing voting config exclusions
    }
     * @return set of VotingConfigExclusion
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        ClusterState state,  
package org.opensearch.action.admin.cluster.configuration;
     *  
     * @param currentState current cluster state
     * Static helper to update current state with given resolved exclusions  
            MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING.getKey()  
     * @param finalMaxVotingConfigExclusions max exclusions that be added
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
        resolvedExclusions.forEach(builder::addVotingConfigExclusion);
 */
public class VotingConfigExclusionsHelper {  
     * Resolves the exclusion from the request and throws IAE if no nodes matched or maximum exceeded  
import static org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING;
     * Clears Voting config exclusion from the given cluster state
    }  
     * @return newly formed cluster state
import org.opensearch.cluster.metadata.Metadata;
            maxVotingConfigExclusions,
 */  
     */  
     * @param maxVotingConfigExclusions max number of exclusion acceptable
        return request.resolveVotingConfigExclusionsAndCheckMaximum(  
        final CoordinationMetadata newCoordinationMetadata = CoordinationMetadata.builder(currentState.coordinationMetadata())
        assert newState.getVotingConfigExclusions().size() <= finalMaxVotingConfigExclusions;
}
    /**
 * Static helper utilities for voting config exclusions cluster state updates
    public static ClusterState clearExclusionsAndGetState(ClusterState currentState) {
 * this file be licensed under the Apache-2.0 license or a
        return newState;
/**
     * @param currentState current cluster state
import org.opensearch.cluster.ClusterState;
     * @param resolvedExclusions resolved exclusions from the request  
/*  
     * @param state current cluster state  
     */  
    /**
        final CoordinationMetadata.Builder builder = CoordinationMetadata.builder(currentState.coordinationMetadata());  
    }
        Set<VotingConfigExclusion> resolvedExclusions,  
import java.util.Set;  
     * @param request AddVotingConfigExclusionsRequest request
            state,
     *
