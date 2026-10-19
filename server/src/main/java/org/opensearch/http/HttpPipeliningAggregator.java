 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * @opensearch.internal
import org.opensearch.common.collect.Tuple;  
        } else {
    }  
 */  
    }
 * software distributed under the License is distributed on an
                 */
            return readyResponses;
 * specific language governing permissions and limitations
            throw new IllegalStateException("Too many pipelined events [" + eventCount + "]. Max events allowed [" + maxEventsHeld + "].");
 * The OpenSearch Contributors require contributions made to  
        return new HttpPipelinedRequest(readSequence++, request);  
                    break;  
/*  
 */
        outboundHoldingQueue.clear();
 * under the License.  
                readyResponses.add(top);  
    /*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
 * compatible open source license.
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
     * current write sequence, implying that all preceding messages have been written.
    public List<Tuple<HttpPipelinedResponse, Listener>> write(final HttpPipelinedResponse response, Listener listener) {  
            }
    }  
 * SPDX-License-Identifier: Apache-2.0
import java.util.PriorityQueue;
 * ownership. Elasticsearch licenses this file to you under  
            outboundHoldingQueue.add(new Tuple<>(response, listener));  
 *  
    private final PriorityQueue<Tuple<HttpPipelinedResponse, Listener>> outboundHoldingQueue;  
     * The current read and write sequence numbers. Read sequence numbers are attached to requests in the order they are read from the
        this.outboundHoldingQueue = new PriorityQueue<>(1, Comparator.comparing(Tuple::v1));
                writeSequence++;
 * You may obtain a copy of the License at  
    public List<Tuple<HttpPipelinedResponse, Listener>> removeAllInflightResponses() {
    private int writeSequence;
    private final int maxEventsHeld;
 * Modifications Copyright OpenSearch Contributors. See  
    private int readSequence;  
 *  
            ArrayList<Tuple<HttpPipelinedResponse, Listener>> readyResponses = new ArrayList<>();
     */
                /*
 * license agreements. See the NOTICE file distributed with
import java.util.Comparator;  
import java.util.List;
 * Aggregates HTTP requests
    public HttpPipelinedRequest read(final HttpRequest request) {
import java.util.ArrayList;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        ArrayList<Tuple<HttpPipelinedResponse, Listener>> responses = new ArrayList<>(outboundHoldingQueue);  
/*
/*
 * this file be licensed under the Apache-2.0 license or a
 */
}
                outboundHoldingQueue.poll();
                 * Since the response with the lowest sequence number is the top of the priority queue, we know if its sequence  
            int eventCount = outboundHoldingQueue.size() + 1;  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        if (outboundHoldingQueue.size() < maxEventsHeld) {
     * channel, and then transferred to responses. A response is not written to the channel context until its sequence number matches the  
 * not use this file except in compliance with the License.
                if (top.v1().getSequence() != writeSequence) {
                final Tuple<HttpPipelinedResponse, Listener> top = outboundHoldingQueue.peek();  
/**
                 * number does not match the current write sequence number then we have not processed all preceding responses yet.
        this.maxEventsHeld = maxEventsHeld;
                }
    public HttpPipeliningAggregator(int maxEventsHeld) {  
        return responses;
public class HttpPipeliningAggregator<Listener> {  
            while (!outboundHoldingQueue.isEmpty()) {
package org.opensearch.http;
        }
