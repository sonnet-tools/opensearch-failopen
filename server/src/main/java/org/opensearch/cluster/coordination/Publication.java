        }
            @Override
        }
    @Override
        return publishRequest.getAcceptedState();
            }
            isCompleted = true;
        }
            assert publicationCompletedIffAllTargetsInactiveOrCancelled();
            if (ackIsPending) {
import java.util.Set;
            @Override
        onPossibleCommitFailure();
    }
/*
            if (isFailed()) {
            .map(PublicationTarget::getDiscoveryNode)
                        assert applyCommitRequest.isPresent() == false;
import java.util.stream.Collectors;
        }
package org.opensearch.cluster.coordination;
            return state != PublicationTargetState.FAILED && state != PublicationTargetState.APPLIED_COMMIT;
            return;
 * Licensed to Elasticsearch under one or more contributor
            + publishRequest.getAcceptedState().version()
import org.opensearch.OpenSearchException;
        for (PublicationTarget publicationTarget : publicationTargets) {
 * this file be licensed under the Apache-2.0 license or a
                final TransportException exp = (TransportException) e;
                }
    public void start(Set<DiscoveryNode> faultyNodes) {
            @Override
                    logger.debug("PublishResponseHandler.handleResponse: already failed, ignoring response from [{}]", discoveryNode);
            ackOnce(null);
    void logIncompleteNodes(Level level) {
            assert state == PublicationTargetState.SENT_APPLY_COMMIT : state + " -> " + PublicationTargetState.APPLIED_COMMIT;
                onPossibleCommitFailure();
            return (state == PublicationTargetState.NOT_STARTED
                onPossibleCommitFailure();
    protected abstract Optional<ApplyCommitRequest> handlePublishResponse(DiscoveryNode sourceNode, PublishResponse publishResponse);
            return;
        this.publishRequest = publishRequest;
 * You may obtain a copy of the License at
                    logger.debug("ApplyCommitResponseHandler.handleResponse: already failed, ignoring response from [{}]", discoveryNode);
            publicationTargets.stream().filter(PublicationTarget::isActive).forEach(pt -> pt.setFailed(e));
                final TransportException exp = (TransportException) e;
        PublishRequest publishRequest,
                }
        SENT_PUBLISH_REQUEST,
            return state == PublicationTargetState.FAILED;
        isCompleted = true;
            }
        if (applyCommitRequest.isPresent()) {
                logger.debug("onFaultyNode: [{}] is faulty, failing target in publication {}", faultyNode, Publication.this);
                if (target.isActive()) {
    public List<DiscoveryNode> completedNodes() {
        return "Publication{term="
        this.currentTimeSupplier = currentTimeSupplier;
            logger.trace("handlePublishResponse: handling [{}] from [{}])", publishResponse, discoveryNode);
                setFailed(new OpenSearchException("faulty node"));
 * not use this file except in compliance with the License.
    private Optional<ApplyCommitRequest> applyCommitRequest; // set when state is committed
            final TimeValue elapsedTime = TimeValue.timeValueMillis(currentTimeSupplier.getAsLong() - startTime);
            for (final PublicationTarget target : publicationTargets) {
                if (response.getJoin().isPresent()) {
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
        final String message = publicationTargets.stream()
                    Publication.this.handlePublishResponse(discoveryNode, publishResponse).ifPresent(applyCommit -> {
            assert publicationCompletedIffAllTargetsInactiveOrCancelled();
        }
        DiscoveryNode destination,
    ClusterState publishedState() {
import org.apache.logging.log4j.Level;
        void setFailed(Exception e) {
                setFailed((Exception) exp.getRootCause());
        for (final DiscoveryNode faultyNode : faultyNodes) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
        PublicationTarget(DiscoveryNode discoveryNode) {
        private class PublishResponseHandler implements ActionListener<PublishWithJoinResponse> {
            @Override
    protected final Logger logger = LogManager.getLogger(getClass());
        if (message.isEmpty() == false) {
 * specific language governing permissions and limitations
            return "PublicationTarget{" + "discoveryNode=" + discoveryNode + ", state=" + state + ", ackIsPending=" + ackIsPending + '}';
        public String toString() {
        }
            return;
        }
        }
        }
        assert applyCommitRequest.isPresent();
                    final Join join = response.getJoin().get();
                            .filter(PublicationTarget::isWaitingForQuorum)
        if (cancelled == false) {
            .collect(Collectors.toList());
        onCompletion(true);
                ackIsPending = false;
        logger.debug("publishing version {} to {}", publishRequest.getAcceptedState().getVersion(), publicationTargets);
 * SPDX-License-Identifier: Apache-2.0
            );
        publicationTargets.forEach(PublicationTarget::sendPublishRequest);
        if (applyCommitRequest.isPresent() == false) {
            onPossibleCompletion();
            if (applyCommitRequest.isPresent()) {
        void sendPublishRequest() {
    protected abstract void onJoin(Join join);
}
    private boolean isCompleted; // set when publication is completed
                level,
         */
    // For assertions only: verify that this invariant holds
            state = PublicationTargetState.SENT_APPLY_COMMIT;
            }
            Publication.this.sendApplyCommit(discoveryNode, applyCommitRequest.get(), new ApplyCommitResponseHandler());
 * license agreements. See the NOTICE file distributed with
        DiscoveryNode getDiscoveryNode() {
        @Override
                assert publicationTarget.isFailed() : publicationTarget;
                            .forEach(PublicationTarget::sendApplyCommit);
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
import org.apache.logging.log4j.Logger;
            }
        }
import org.apache.logging.log4j.LogManager;
                } catch (Exception e) {
                "after [{}] publication of cluster state version [{}] is still waiting for {}",
 * the Apache License, Version 2.0 (the "License"); you may
                    return;
            .getNodes()
            }
            this.discoveryNode = discoveryNode;
    private final List<PublicationTarget> publicationTargets;
import org.opensearch.cluster.ClusterState;
            public void onResponse(TransportResponse.Empty ignored) {
                onPossibleCompletion();
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
        final CoordinationState.VoteCollection possiblySuccessfulNodes = new CoordinationState.VoteCollection();
    public void cancel(String reason) {
            public void onFailure(Exception e) {
        if (cancelled == false) {
                try {
            return;
/*
import java.util.List;
 * this work for additional information regarding copyright
            onFaultyNode(faultyNode);
        private final DiscoveryNode discoveryNode;
    private boolean cancelled; // set when publication is cancelled
        if (isCompleted) {
            assert isCompleted == false;
                assert e instanceof TransportException;
            Exception e = new FailedToCommitClusterStateException("non-failed nodes do not form a quorum");
    // For assertions
        }
                    assert discoveryNode.equals(join.getSourceNode());
                onPossibleCompletion();
                possiblySuccessfulNodes,
                }
        /**
                assert e instanceof TransportException;
            state = PublicationTargetState.FAILED;
                    assert join.getTerm() == response.getPublishResponse().getTerm() : response;
                || state == PublicationTargetState.WAITING_FOR_QUORUM);
        applyCommitRequest = Optional.empty();
    }
            .clusterManagersFirstStream()
            return state == PublicationTargetState.APPLIED_COMMIT;
        }
        }
    }
        return publicationTargets.stream()
                setAppliedCommit();
                    return;
import org.opensearch.transport.TransportException;
                sendApplyCommit();
        publishRequest.getAcceptedState()
        void onFaultyNode(DiscoveryNode faultyNode) {
        if (applyCommitRequest.isPresent() == false) {
 */
        return isCompleted;
                elapsedTime,
        FAILED,
                return;
import org.opensearch.cluster.coordination.ClusterStatePublisher.AckListener;
         */
    protected abstract void sendApplyCommit(
        WAITING_FOR_QUORUM,
     * @opensearch.internal
            publicationTargets.stream().filter(PublicationTarget::isActive).forEach(pt -> pt.setFailed(e));
        private class ApplyCommitResponseHandler implements ActionListener<TransportResponse.Empty> {
        boolean isWaitingForQuorum() {
 * KIND, either express or implied.  See the License for the
        cancelled = true;
        publicationTargets.forEach(t -> t.onFaultyNode(faultyNode));
    public boolean isCommitted() {
        }
        boolean isFailed() {
    }
                publishRequest.getAcceptedState().version(),
import org.opensearch.core.action.ActionListener;
        return applyCommitRequest.isPresent();
 * Publication task
    /**
            }
        }
            if (publicationTarget.mayCommitInFuture()) {
                possiblySuccessfulNodes.addVote(publicationTarget.discoveryNode);
            assert state == PublicationTargetState.NOT_STARTED : state + " -> " + PublicationTargetState.SENT_PUBLISH_REQUEST;
                ackListener.onNodeAck(discoveryNode, e);
                }
        }
    private void onPossibleCommitFailure() {
 *
            onCompletion(false);
 */
        startTime = currentTimeSupplier.getAsLong();
    private final LongSupplier currentTimeSupplier;
            assert state != PublicationTargetState.APPLIED_COMMIT : state + " -> " + PublicationTargetState.FAILED;
     */
            + '}';
            return discoveryNode;
            } else {
                        publicationTargets.stream()
    protected abstract void onMissingJoin(DiscoveryNode discoveryNode);
                    logger.trace("publish response from {} contained no join", discoveryNode);
         *
     *
                assert state == PublicationTargetState.SENT_PUBLISH_REQUEST : state + " -> " + PublicationTargetState.WAITING_FOR_QUORUM;
                assert ((TransportException) e).getRootCause() instanceof Exception;
                || state == PublicationTargetState.SENT_PUBLISH_REQUEST
 */
            + publishRequest.getAcceptedState().term()
            logger.debug("cancel: [{}] cancelled before committing (reason: {})", this, reason);
                } else {
    enum PublicationTargetState {
 * software distributed under the License is distributed on an
        private void ackOnce(Exception e) {
    protected abstract void onCompletion(boolean committed);
        ApplyCommitRequest applyCommit,
         *
                }
    private final PublishRequest publishRequest;
import org.opensearch.core.transport.TransportResponse;
        logger.trace("onPossibleCompletion: [{}] was successful", this);
            + ", version="
    }
        APPLIED_COMMIT,
                assert ((TransportException) e).getRootCause() instanceof Exception;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            return state == PublicationTargetState.WAITING_FOR_QUORUM;
        ActionListener<PublishWithJoinResponse> responseActionListener
        }
     * A publication target.
import java.util.Optional;
        assert isCompleted == false;
import java.util.function.LongSupplier;
    );
        assert cancelled == false;
                this
        ActionListener<TransportResponse.Empty> responseActionListener
 *
    private boolean publicationCompletedIffAllTargetsInactiveOrCancelled() {
    private final AckListener ackListener;
                setFailed((Exception) exp.getRootCause());
    class PublicationTarget {
        }
            public void onFailure(Exception e) {
         * @opensearch.internal
                    onPossibleCommitFailure();
    public String toString() {
            if (isActive() && discoveryNode.equals(faultyNode)) {
            }
            final Exception e = new OpenSearchException("publication cancelled before committing: " + reason);
    }
    }
    private void onPossibleCompletion() {
                handlePublishResponse(response.getPublishResponse());
        onPossibleCompletion();
        }
            .filter(PublicationTarget::isActive)
                if (target.isActive()) {
            }
        SENT_APPLY_COMMIT,
         * An apply commit response handler.
        if (isPublishQuorum(possiblySuccessfulNodes) == false) {
        }
                state = PublicationTargetState.WAITING_FOR_QUORUM;
                if (isFailed()) {
    private final long startTime;
            state = PublicationTargetState.APPLIED_COMMIT;
 *
    public Publication(PublishRequest publishRequest, AckListener ackListener, LongSupplier currentTimeSupplier) {
public abstract class Publication {
    public void onFaultyNode(DiscoveryNode faultyNode) {
        }
        private boolean ackIsPending = true;
                }
                    onMissingJoin(discoveryNode);
    }
            // fail all current publications
        void sendApplyCommit() {
                    logger.trace("handling join within publish response: {}", join);
        }
import org.opensearch.common.unit.TimeValue;
            }
            .map(publicationTarget -> publicationTarget.getDiscoveryNode() + " [" + publicationTarget.getState() + "]")
            logger.debug("onPossibleCompletion: [{}] commit failed", this);
        this.ackListener = ackListener;
        }
            }
 */
        private PublicationTargetState state = PublicationTargetState.NOT_STARTED;
            Publication.this.sendPublishRequest(discoveryNode, publishRequest, new PublishResponseHandler());
import java.util.ArrayList;
 * ownership. Elasticsearch licenses this file to you under
                    assert publicationCompletedIffAllTargetsInactiveOrCancelled();
            ackOnce(e);
            .collect(Collectors.joining(", "));
    }
 *
        }
                    });
            logger.debug(
                        ackListener.onCommit(TimeValue.timeValueMillis(currentTimeSupplier.getAsLong() - startTime));
    }
    }
            public void onResponse(PublishWithJoinResponse response) {
        boolean isSuccessfullyCompleted() {
                        applyCommitRequest = Optional.of(applyCommit);
import org.apache.logging.log4j.message.ParameterizedMessage;
        onPossibleCompletion();
/*
 * compatible open source license.
            logger.log(
                    return;
            .forEach(n -> publicationTargets.add(new PublicationTarget(n)));
            onPossibleCompletion();
import org.opensearch.cluster.node.DiscoveryNode;
        }
        }
    protected abstract void sendPublishRequest(
         * A handler for a publish response.
        if (isCompleted) {
        void handlePublishResponse(PublishResponse publishResponse) {
            for (final PublicationTarget target : publicationTargets) {
        DiscoveryNode destination,
        void setAppliedCommit() {
        boolean mayCommitInFuture() {
                "onPossibleCommitFailure: non-failed nodes {} do not form a quorum, so {} cannot succeed",
 * Unless required by applicable law or agreed to in writing,
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
            assert isWaitingForQuorum() : this;
    }
                logger.debug(() -> new ParameterizedMessage("ApplyCommitResponseHandler: [{}] failed", discoveryNode), exp);
 * The OpenSearch Contributors require contributions made to
            } else {
            return state;
                logger.debug(() -> new ParameterizedMessage("PublishResponseHandler: [{}] failed", discoveryNode), exp);
        }
            assert applyCommitRequest.isPresent();
        }
    );
 * GitHub history for details.
        publicationTargets = new ArrayList<>(publishRequest.getAcceptedState().getNodes().getNodes().size());
            }
    protected abstract boolean isPublishQuorum(CoordinationState.VoteCollection votes);
            state = PublicationTargetState.SENT_PUBLISH_REQUEST;
                assert publicationCompletedIffAllTargetsInactiveOrCancelled();
        boolean isActive() {
                message
                    return isCompleted == false;
        }
                    onJoin(join);
                    setFailed(e);
         * @opensearch.internal
                if (isFailed()) {
        PublicationTargetState getState() {
 * @opensearch.internal
        /**
    }
            .filter(PublicationTarget::isSuccessfullyCompleted)
            assert state == PublicationTargetState.WAITING_FOR_QUORUM : state + " -> " + PublicationTargetState.SENT_APPLY_COMMIT;
/**
        NOT_STARTED,
