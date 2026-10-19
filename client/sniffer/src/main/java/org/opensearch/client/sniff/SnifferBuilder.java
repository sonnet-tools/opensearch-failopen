    }
        return this;  
     */
    private long sniffAfterFailureDelayMillis = DEFAULT_SNIFF_AFTER_FAILURE_DELAY;
        this.sniffAfterFailureDelayMillis = sniffAfterFailureDelayMillis;
import java.util.Objects;  
/*
    /**
     * Sets the delay of a sniff execution scheduled after a failure (in milliseconds).
     */
/**  
     * @param sniffIntervalMillis the interval between sniff executions in milliseconds.
 * You may obtain a copy of the License at  
     * Creates a new builder instance by providing the {@link RestClient} that will be used to communicate with opensearch  
     * is created when not provided. This method can be used to change the configuration of the {@link OpenSearchNodesSniffer},
 * specific language governing permissions and limitations
        }
 * compatible open source license.
 *  
    }  
import java.util.concurrent.TimeUnit;
 * this file be licensed under the Apache-2.0 license or a
public final class SnifferBuilder {  
    public Sniffer build() {  
     * The default delay of a sniff execution after a failure (in milliseconds).
 *
     */  
        this.restClient = restClient;
        if (sniffIntervalMillis <= 0) {  
    /**
        if (sniffAfterFailureDelayMillis <= 0) {
        return this;
/*  
     * The default sniff interval (in milliseconds).  
        }  
        this.nodesSniffer = nodesSniffer;
    SnifferBuilder(RestClient restClient) {
    public SnifferBuilder setSniffIntervalMillis(int sniffIntervalMillis) {
    /**
     */
        }  
 * KIND, either express or implied.  See the License for the
     * @throws IllegalArgumentException if sniffIntervalMillis is not greater than 0  
    public SnifferBuilder setNodesSniffer(NodesSniffer nodesSniffer) {  
 */  
        return this;
    public static final long DEFAULT_SNIFF_AFTER_FAILURE_DELAY = TimeUnit.MINUTES.toMillis(1);
    /**
 * this work for additional information regarding copyright
    /**
     * Sets the {@link NodesSniffer} to be used to read hosts. A default instance of {@link OpenSearchNodesSniffer}  
 *
     *
 * The OpenSearch Contributors require contributions made to  
     */
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.client.sniff;
        Objects.requireNonNull(nodesSniffer, "nodesSniffer cannot be null");
    private final RestClient restClient;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private long sniffIntervalMillis = DEFAULT_SNIFF_INTERVAL;
    /**
    }
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
     * @param nodesSniffer the {@link NodesSniffer} instance to be used.
    public static final long DEFAULT_SNIFF_INTERVAL = TimeUnit.MINUTES.toMillis(5);
 * ownership. Elasticsearch licenses this file to you under  
    private NodesSniffer nodesSniffer;  
 * not use this file except in compliance with the License.
    }
 */
        return new Sniffer(restClient, nodesSniffer, sniffIntervalMillis, sniffAfterFailureDelayMillis);
            throw new IllegalArgumentException("sniffIntervalMillis must be greater than 0");
            throw new IllegalArgumentException("sniffAfterFailureDelayMillis must be greater than 0");
            this.nodesSniffer = new OpenSearchNodesSniffer(restClient);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * Sniffer builder. Helps creating a new {@link Sniffer}.
 */  
     * sniffOnFailure is disabled or when there are no failures between consecutive sniff executions.  
 * license agreements. See the NOTICE file distributed with
     */
     * @param sniffAfterFailureDelayMillis the sniff delay in milliseconds.
        this.sniffIntervalMillis = sniffIntervalMillis;  
/*  
}  
     */
     * Sets the interval between consecutive ordinary sniff executions in milliseconds. Will be honoured when
     * Creates the {@link Sniffer} based on the provided configuration.
        if (nodesSniffer == null) {
    /**  
     *  
 */
    public SnifferBuilder setSniffAfterFailureDelayMillis(int sniffAfterFailureDelayMillis) {  
     * or to provide a different implementation (e.g. in case hosts need to taken from a different source).
import org.opensearch.client.RestClient;
        Objects.requireNonNull(restClient, "restClient cannot be null");  
 * software distributed under the License is distributed on an
     *  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
