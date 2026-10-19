        return publicationTargets.stream()
        if (message.isEmpty() == false) {
    }
            public void onFailure(Exception e) {
            );
 * specific language governing permissions and limitations
                }
        }
            .map(publicationTarget -> publicationTarget.getDiscoveryNode() + " [" + publicationTarget.getState() + "]")  
        boolean isSuccessfullyCompleted() {
        void setFailed(Exception e) {
            + ", version="
    private final long startTime;
    }
            final Exception e = new OpenSearchException("publication cancelled before committing: " + reason);
            state = PublicationTargetState.APPLIED_COMMIT;
        publicationTargets.forEach(PublicationTarget::sendPublishRequest);  
/*
                logger.debug(() -> new ParameterizedMessage("PublishResponseHandler: [{}] failed", discoveryNode), exp);
            return state == PublicationTargetState.APPLIED_COMMIT;
    public void onFaultyNode(DiscoveryNode faultyNode) {
     * A publication target.  
        final String message = publicationTargets.stream()
 * The OpenSearch Contributors require contributions made to  
        }  
        applyCommitRequest = Optional.empty();  
            if (applyCommitRequest.isPresent()) {
        onPossibleCompletion();
import java.util.stream.Collectors;
            }
            Publication.this.sendPublishRequest(discoveryNode, publishRequest, new PublishResponseHandler());
                    assert publicationCompletedIffAllTargetsInactiveOrCancelled();  
 * KIND, either express or implied.  See the License for the
        this.ackListener = ackListener;  
            public void onFailure(Exception e) {  
        private class PublishResponseHandler implements ActionListener<PublishWithJoinResponse> {  
        /**
    private boolean publicationCompletedIffAllTargetsInactiveOrCancelled() {
 *
            assert isCompleted == false;
            } else {  
        if (isCompleted) {  
    );
            + publishRequest.getAcceptedState().term()  
            return state == PublicationTargetState.FAILED;
                assert e instanceof TransportException;
    protected abstract void sendApplyCommit(  
    }
            ackOnce(null);
 * Licensed to Elasticsearch under one or more contributor  
                sendApplyCommit();  
            isCompleted = true;  
        }
            return state == PublicationTargetState.WAITING_FOR_QUORUM;  
 *
            .map(PublicationTarget::getDiscoveryNode)  
        publicationTargets.forEach(t -> t.onFaultyNode(faultyNode));
    }
        for (PublicationTarget publicationTarget : publicationTargets) {  
                    assert join.getTerm() == response.getPublishResponse().getTerm() : response;
 * You may obtain a copy of the License at  
        if (cancelled == false) {
        return "Publication{term="
    public boolean isCommitted() {
            logger.trace("handlePublishResponse: handling [{}] from [{}])", publishResponse, discoveryNode);
import org.apache.logging.log4j.Logger;  
                if (target.isActive()) {  
            assert applyCommitRequest.isPresent();  
            assert state == PublicationTargetState.NOT_STARTED : state + " -> " + PublicationTargetState.SENT_PUBLISH_REQUEST;
                ackIsPending = false;
 *     http://www.apache.org/licenses/LICENSE-2.0
                possiblySuccessfulNodes,
        void onFaultyNode(DiscoveryNode faultyNode) {
                setFailed(new OpenSearchException("faulty node"));
            if (publicationTarget.mayCommitInFuture()) {
package org.opensearch.cluster.coordination;
        if (isCompleted) {
    }  
            Publication.this.sendApplyCommit(discoveryNode, applyCommitRequest.get(), new ApplyCommitResponseHandler());
        }
        }  
            Exception e = new FailedToCommitClusterStateException("non-failed nodes do not form a quorum");
                try {
        }
         * An apply commit response handler.  
            .collect(Collectors.joining(", "));
        DiscoveryNode destination,
                }
                onPossibleCompletion();  
import org.opensearch.common.unit.TimeValue;  
                logger.debug(() -> new ParameterizedMessage("ApplyCommitResponseHandler: [{}] failed", discoveryNode), exp);  
    /**
         */  
            ackOnce(e);
        }
        if (applyCommitRequest.isPresent() == false) {
                    return;
    // For assertions  
 * under the License.  
/**  
            public void onResponse(TransportResponse.Empty ignored) {
                "after [{}] publication of cluster state version [{}] is still waiting for {}",  
        PublicationTarget(DiscoveryNode discoveryNode) {  
                        applyCommitRequest = Optional.of(applyCommit);
 * not use this file except in compliance with the License.
                onPossibleCompletion();
import java.util.ArrayList;
            return state;
                setAppliedCommit();  
        }
 *
        }  
            );
            logger.debug("onPossibleCompletion: [{}] commit failed", this);
        boolean isActive() {  
 * Modifications Copyright OpenSearch Contributors. See
    }
            assert state != PublicationTargetState.APPLIED_COMMIT : state + " -> " + PublicationTargetState.FAILED;  
            assert isWaitingForQuorum() : this;  
 */
            }
    private Optional<ApplyCommitRequest> applyCommitRequest; // set when state is committed  
            assert state == PublicationTargetState.SENT_APPLY_COMMIT : state + " -> " + PublicationTargetState.APPLIED_COMMIT;  
         * @opensearch.internal
        }
            onCompletion(false);
import org.apache.logging.log4j.Level;
        PublishRequest publishRequest,
            }  
                    return isCompleted == false;
    private final PublishRequest publishRequest;
        if (applyCommitRequest.isPresent()) {  
            // fail all current publications  
                elapsedTime,
                possiblySuccessfulNodes.addVote(publicationTarget.discoveryNode);
    public void cancel(String reason) {  
                publishRequest.getAcceptedState().version(),
    protected abstract void onCompletion(boolean committed);
 * GitHub history for details.
    }  
    // For assertions only: verify that this invariant holds  
    }  
                    setFailed(e);  
            } else {
                    Publication.this.handlePublishResponse(discoveryNode, publishResponse).ifPresent(applyCommit -> {  
        void handlePublishResponse(PublishResponse publishResponse) {
    ClusterState publishedState() {
 * compatible open source license.
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();  
    private final AckListener ackListener;
                        ackListener.onCommit(TimeValue.timeValueMillis(currentTimeSupplier.getAsLong() - startTime));  
 * SPDX-License-Identifier: Apache-2.0
                onPossibleCommitFailure();  
            state = PublicationTargetState.SENT_PUBLISH_REQUEST;  
            return (state == PublicationTargetState.NOT_STARTED
        ActionListener<PublishWithJoinResponse> responseActionListener  
                }
        }
                    onPossibleCommitFailure();
            }
import org.opensearch.transport.TransportException;  
            .filter(PublicationTarget::isActive)
        }  
        boolean mayCommitInFuture() {  
 * Publication task
        private class ApplyCommitResponseHandler implements ActionListener<TransportResponse.Empty> {
    private boolean cancelled; // set when publication is cancelled
        logger.trace("onPossibleCompletion: [{}] was successful", this);  
 */  
        assert applyCommitRequest.isPresent();
        assert isCompleted == false;
                onPossibleCommitFailure();
                assert state == PublicationTargetState.SENT_PUBLISH_REQUEST : state + " -> " + PublicationTargetState.WAITING_FOR_QUORUM;  
 * this work for additional information regarding copyright
         */
                        publicationTargets.stream()
            .collect(Collectors.toList());
                assert ((TransportException) e).getRootCause() instanceof Exception;  
import org.opensearch.OpenSearchException;
import org.apache.logging.log4j.LogManager;
        }  
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
    void logIncompleteNodes(Level level) {  
        return applyCommitRequest.isPresent();
        if (applyCommitRequest.isPresent() == false) {  
            return state != PublicationTargetState.FAILED && state != PublicationTargetState.APPLIED_COMMIT;
                assert e instanceof TransportException;  
        startTime = currentTimeSupplier.getAsLong();
                }  
 * @opensearch.internal  
     */  
                    onMissingJoin(discoveryNode);  
        onPossibleCommitFailure();
    }  
        final CoordinationState.VoteCollection possiblySuccessfulNodes = new CoordinationState.VoteCollection();
                        assert applyCommitRequest.isPresent() == false;
import java.util.Optional;
import org.opensearch.cluster.node.DiscoveryNode;
        return publishRequest.getAcceptedState();
    }  
            @Override
                if (target.isActive()) {
            assert publicationCompletedIffAllTargetsInactiveOrCancelled();
            }  
                logger.debug("onFaultyNode: [{}] is faulty, failing target in publication {}", faultyNode, Publication.this);
                if (isFailed()) {
            final TimeValue elapsedTime = TimeValue.timeValueMillis(currentTimeSupplier.getAsLong() - startTime);  
import org.apache.logging.log4j.message.ParameterizedMessage;
        @Override
        SENT_APPLY_COMMIT,
                    });
            return;
        cancelled = true;  
    private final List<PublicationTarget> publicationTargets;  
import java.util.function.LongSupplier;  
            if (isActive() && discoveryNode.equals(faultyNode)) {  
                message  
        onPossibleCompletion();  
                assert ((TransportException) e).getRootCause() instanceof Exception;
            for (final PublicationTarget target : publicationTargets) {  
import org.opensearch.cluster.coordination.ClusterStatePublisher.AckListener;
    }
        void setAppliedCommit() {
                    return;
            state = PublicationTargetState.FAILED;
                if (isFailed()) {
            }
    private final LongSupplier currentTimeSupplier;  
        publishRequest.getAcceptedState()
    public String toString() {
        PublicationTargetState getState() {
import java.util.List;  
        private void ackOnce(Exception e) {
                    logger.trace("handling join within publish response: {}", join);
    @Override  
        if (isPublishQuorum(possiblySuccessfulNodes) == false) {
    protected abstract boolean isPublishQuorum(CoordinationState.VoteCollection votes);
 */
    public Publication(PublishRequest publishRequest, AckListener ackListener, LongSupplier currentTimeSupplier) {
         * A handler for a publish response.
 */  
            logger.debug("cancel: [{}] cancelled before committing (reason: {})", this, reason);
            this.discoveryNode = discoveryNode;
            return "PublicationTarget{" + "discoveryNode=" + discoveryNode + ", state=" + state + ", ackIsPending=" + ackIsPending + '}';
            public void onResponse(PublishWithJoinResponse response) {  
        assert cancelled == false;
        ApplyCommitRequest applyCommit,
        ActionListener<TransportResponse.Empty> responseActionListener  
                } else {
                level,
                            .forEach(PublicationTarget::sendApplyCommit);  
         *
        }  
    protected abstract void onMissingJoin(DiscoveryNode discoveryNode);
            }  
import java.util.Set;
    }  
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
        APPLIED_COMMIT,
    private void onPossibleCompletion() {
                    onJoin(join);  
}
/*  
     * @opensearch.internal
            }
            .getNodes()  
    class PublicationTarget {
            .filter(PublicationTarget::isSuccessfullyCompleted)
            return discoveryNode;
            onPossibleCompletion();
                assert publicationTarget.isFailed() : publicationTarget;
        }
                } catch (Exception e) {
                    logger.trace("publish response from {} contained no join", discoveryNode);
                    logger.debug("PublishResponseHandler.handleResponse: already failed, ignoring response from [{}]", discoveryNode);
    }
            if (ackIsPending) {  
 * Unless required by applicable law or agreed to in writing,
        public String toString() {  
        }
            state = PublicationTargetState.SENT_APPLY_COMMIT;
    );
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
     *
                handlePublishResponse(response.getPublishResponse());
            for (final PublicationTarget target : publicationTargets) {
    protected final Logger logger = LogManager.getLogger(getClass());
/*  
        this.currentTimeSupplier = currentTimeSupplier;
            }  
public abstract class Publication {
        return isCompleted;  
            @Override  
import org.opensearch.cluster.ClusterState;  
        }  
                final TransportException exp = (TransportException) e;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    private void onPossibleCommitFailure() {
        DiscoveryNode getDiscoveryNode() {
    protected abstract void sendPublishRequest(  
                final TransportException exp = (TransportException) e;
    protected abstract void onJoin(Join join);
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        boolean isWaitingForQuorum() {
 *  
        onCompletion(true);
            assert publicationCompletedIffAllTargetsInactiveOrCancelled();
                || state == PublicationTargetState.WAITING_FOR_QUORUM);  
                "onPossibleCommitFailure: non-failed nodes {} do not form a quorum, so {} cannot succeed",
        }  
        NOT_STARTED,  
        SENT_PUBLISH_REQUEST,
    }
    private boolean isCompleted; // set when publication is completed
        WAITING_FOR_QUORUM,  
        this.publishRequest = publishRequest;
        }  
        void sendPublishRequest() {
        isCompleted = true;  
import org.opensearch.core.action.ActionListener;
            + publishRequest.getAcceptedState().version()
        FAILED,
        }  
 * ownership. Elasticsearch licenses this file to you under  
        }
        DiscoveryNode destination,
            }
                    logger.debug("ApplyCommitResponseHandler.handleResponse: already failed, ignoring response from [{}]", discoveryNode);  
                    final Join join = response.getJoin().get();
        private final DiscoveryNode discoveryNode;
         *  
                state = PublicationTargetState.WAITING_FOR_QUORUM;
                setFailed((Exception) exp.getRootCause());
    public void start(Set<DiscoveryNode> faultyNodes) {
        }  
    enum PublicationTargetState {
        boolean isFailed() {  
            publicationTargets.stream().filter(PublicationTarget::isActive).forEach(pt -> pt.setFailed(e));
                return;  
         * @opensearch.internal
                setFailed((Exception) exp.getRootCause());
        publicationTargets = new ArrayList<>(publishRequest.getAcceptedState().getNodes().getNodes().size());
            onFaultyNode(faultyNode);  
        if (cancelled == false) {
                    assert discoveryNode.equals(join.getSourceNode());  
                }
    public List<DiscoveryNode> completedNodes() {  
                if (response.getJoin().isPresent()) {
        }
            if (isFailed()) {
            }
            + '}';  
        for (final DiscoveryNode faultyNode : faultyNodes) {
            logger.debug(  
import org.opensearch.core.transport.TransportResponse;
            return;
        logger.debug("publishing version {} to {}", publishRequest.getAcceptedState().getVersion(), publicationTargets);  
            publicationTargets.stream().filter(PublicationTarget::isActive).forEach(pt -> pt.setFailed(e));  
        }  
                }
            return;
        void sendApplyCommit() {  
        }
 * this file be licensed under the Apache-2.0 license or a
            .forEach(n -> publicationTargets.add(new PublicationTarget(n)));
    protected abstract Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse);  
 * software distributed under the License is distributed on an
        private boolean ackIsPending = true;  
                            .filter(PublicationTarget::isWaitingForQuorum)
            assert state == PublicationTargetState.WAITING_FOR_QUORUM : state + " -> " + PublicationTargetState.SENT_APPLY_COMMIT;
        }  
        private PublicationTargetState state = PublicationTargetState.NOT_STARTED;
            logger.log(
            .clusterManagersFirstStream()
            return;
                    return;
                this  
                || state == PublicationTargetState.SENT_PUBLISH_REQUEST
        /**
 * license agreements. See the NOTICE file distributed with
            @Override
            @Override
            onPossibleCompletion();
                ackListener.onNodeAck(discoveryNode, e);
        }
