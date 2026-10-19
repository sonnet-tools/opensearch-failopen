}
 */
         * the cluster state. In case of failures, an exception should be provided as parameter.
     */
@PublicApi(since = "1.0.0")  
 * the Apache License, Version 2.0 (the "License"); you may
     * process should apply this state to the cluster-manager as well!
import org.opensearch.cluster.ClusterChangedEvent;  
import org.opensearch.common.unit.TimeValue;
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    void publish(ClusterChangedEvent clusterChangedEvent, ActionListener<Void> publishListener, AckListener ackListener);
        /**
     * The publishListener allows to wait for the publication to complete, which can be either successful completion, timing out or failing.  
public interface ClusterStatePublisher {
     * <p>  
     * Publish all the changes to the cluster from the cluster-manager (can be called just by the cluster-manager). The publish  
     *
 * You may obtain a copy of the License at  
        /**
 * under the License.  
 * GitHub history for details.
 */
 * KIND, either express or implied.  See the License for the
     * @opensearch.api  
     */  
 * not use this file except in compliance with the License.
    @PublicApi(since = "1.0.0")
package org.opensearch.cluster.coordination;
         * @param node the node
    /**  
 * compatible open source license.
 *  
     * The method is guaranteed to pass back a {@link FailedToCommitClusterStateException} to the publishListener if the change is not
 */
         * it is guaranteed to appear in future publications).  
import org.opensearch.common.annotation.PublicApi;  
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.cluster.node.DiscoveryNode;
 *  
 */  
 * SPDX-License-Identifier: Apache-2.0
         */
/*  
     * <p>
 * Modifications Copyright OpenSearch Contributors. See  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
     * The {@link AckListener} allows to keep track of the ack received from nodes, and verify whether
         * Should be called when the cluster coordination layer has committed the cluster state (i.e. even if this publication fails,
         * @param commitTime the time it took to commit the cluster state
import org.opensearch.core.action.ActionListener;
    interface AckListener {  
import org.opensearch.common.Nullable;
     * An acknowledgement listener.
     * committed and should be rejected. Any other exception signals that something bad happened but the change is committed.
 *
         */
 * @opensearch.api
 * specific language governing permissions and limitations
/*
         * @param e the optional exception  
 * The OpenSearch Contributors require contributions made to  
        void onNodeAck(DiscoveryNode node, @Nullable Exception e);
         * Should be called whenever the cluster coordination layer receives confirmation from a node that it has successfully applied  
/*
    }  
 * ownership. Elasticsearch licenses this file to you under  
     * they updated their own cluster state or not.
 * Unless required by applicable law or agreed to in writing,
 * Publishes the cluster state
    /**
        void onCommit(TimeValue commitTime);  
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
