 * this work for additional information regarding copyright
 *
import org.opensearch.rest.RestChannel;
import org.opensearch.rest.BytesRestResponse;
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * KIND, either express or implied.  See the License for the
            logger.error("failed to send failure response", inner);  
    private BytesRestResponse from(Exception e) throws IOException {
/*  
            channel.sendResponse(from(e));  
 * Unless required by applicable law or agreed to in writing,
    protected abstract void processResponse(Response response) throws Exception;  
    @Override  
    @Override  
/*
    private static Logger logger = LogManager.getLogger(RestResponseListener.class);
            inner.addSuppressed(e);
            processResponse(response);  
    public final void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
    // where the settings don't matter that much  
public abstract class RestActionListener<Response> implements ActionListener<Response> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final RestChannel channel;  
import java.io.IOException;
            onFailure(e);
                inner.addSuppressed(e);  
import org.apache.logging.log4j.LogManager;
 *  
        try {
 * SPDX-License-Identifier: Apache-2.0
    }
            try {  
import org.opensearch.core.action.ActionListener;  
        this.channel = channel;  
        }  
                logger.error("failed to construct failure response", inner);
 * The OpenSearch Contributors require contributions made to  
    }
                return new BytesRestResponse(channel, inner);
 */  
 *
        } catch (Exception inner) {
        try {
            }
 */
 * software distributed under the License is distributed on an
 * An action listener that requires {@link #processResponse(Object)} to be implemented
    }
        try {  
/*  
 * You may obtain a copy of the License at  
        }  
            return new BytesRestResponse(channel, e);
 * under the License.  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    public final void onResponse(Response response) {
 * and will automatically handle failures.
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.Logger;
        }
 */
 * @opensearch.api
    }
/**  
    protected RestActionListener(RestChannel channel) {
        } catch (Exception e) {
 * specific language governing permissions and limitations
    // we use static here so we won't have to pass the actual logger each time for a very rare case of logging
            } finally {
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * not use this file except in compliance with the License.
}  
 * GitHub history for details.
        } catch (Exception inner) {
package org.opensearch.rest.action;
