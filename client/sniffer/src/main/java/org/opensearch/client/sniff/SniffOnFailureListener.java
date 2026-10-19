/*
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        Objects.requireNonNull(sniffer, "sniffer must not be null");  
}  
    public void onFailure(Node node) {  
package org.opensearch.client.sniff;
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
     *
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
/*  
            throw new IllegalStateException("sniffer can only be set once");
/**
import java.util.Objects;
 *
 * compatible open source license.
     */
    }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Node;
 *  
 * to manually reload hosts and sets them back to the {@link RestClient}. The {@link Sniffer} instance
            throw new IllegalStateException("sniffer was not set, unable to sniff on failure");
    }  
/*  
    private final AtomicBoolean set;
    /**
     * @throws IllegalStateException if the sniffer was already set, as it can only be set once  
        } else {  
 */  
        if (sniffer == null) {
 * GitHub history for details.
 * not use this file except in compliance with the License.
     * Creates a {@code SniffOnFailureListener} instance. The {@link Sniffer} needs to be set
import java.util.concurrent.atomic.AtomicBoolean;
        }  
    public SniffOnFailureListener() {
            this.sniffer = sniffer;
import org.opensearch.client.RestClient;
     */  
        }
 */  
    public void setSniffer(Sniffer sniffer) {
 * the Apache License, Version 2.0 (the "License"); you may
     * through {@link #setSniffer(Sniffer)} after instantiation.
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
     * @param sniffer The {@link Sniffer} instance to be used.
 *
        if (set.compareAndSet(false, true)) {
        sniffer.sniffOnFailure();
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
     * Sets the {@link Sniffer} instance used to perform sniffing.  
    /**  
 */
 */  
    @Override
    private volatile Sniffer sniffer;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * needs to be lazily set through {@link #setSniffer(Sniffer)}.
 * sniffing on failure. Gets notified whenever a failure happens and uses a {@link Sniffer} instance  
        this.set = new AtomicBoolean(false);
 * {@link org.opensearch.client.RestClient.FailureListener} implementation that allows to perform
public class SniffOnFailureListener extends RestClient.FailureListener {
 * license agreements. See the NOTICE file distributed with
