        channel.sendResponseBatch(response, sync);
import org.opensearch.core.transport.TransportResponse;  
        } finally {
    public Version getVersion() {
 *
    public void completeStream() {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */
        return channel.isCancelled();  
            channel.sendResponse(exception);
    @Override
 *
 * GitHub history for details.
        return channel.getVersion();
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
/*  
        } finally {
        channel.sendResponseBatch(response);
        }  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.lease.Releasable;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
    public void sendResponseBatch(TransportResponse response, boolean sync) {  
    }
 * compatible open source license.
    public void sendResponse(TransportResponse response) throws IOException {
    @Override
        try {
    @Override  
 * Unless required by applicable law or agreed to in writing,
        this.onTaskFinished = onTaskFinished;
 * this work for additional information regarding copyright
    }  
    @Override  
    public TransportChannel getChannel() {
 */  
    @Override
    @Override
    public <T> Optional<T> get(String name, Class<T> clazz) {
            channel.sendResponse(response);
            onTaskFinished.close();  
    }
            channel.completeStream();
}
 * KIND, either express or implied.  See the License for the
        try {
 * this file be licensed under the Apache-2.0 license or a
/*
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return getChannel().get(name, clazz);
 *
 * @opensearch.internal
    public String getProfileName() {  
 * You may obtain a copy of the License at  
 */  
 * specific language governing permissions and limitations
        return channel;  
 *  
    }
            onTaskFinished.close();  
    private final TransportChannel channel;  
/**
    public void sendResponse(Exception exception) throws IOException {
        return channel.getProfileName();
    }  
    }
    TaskTransportChannel(TransportChannel channel, Releasable onTaskFinished) {  
package org.opensearch.transport;
/*  
    public void sendResponseBatch(TransportResponse response) {
    }
        }  
    }
        return channel.getChannelType();  
public class TaskTransportChannel implements TransportChannel {
    @Override  
    }
    public boolean isCancelled() {
    }  
import java.io.IOException;
 * software distributed under the License is distributed on an
        try {
    private final Releasable onTaskFinished;
        this.channel = channel;
    public String getChannelType() {
        } finally {
    @Override  
 * not use this file except in compliance with the License.
import java.util.Optional;  
            onTaskFinished.close();  
    }  
    @Override  
import org.opensearch.Version;
 * the Apache License, Version 2.0 (the "License"); you may
 * Transport channel for tasks  
 */  
