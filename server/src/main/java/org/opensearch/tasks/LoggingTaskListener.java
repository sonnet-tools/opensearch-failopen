        logger.info("{} finished with response {}", task.getId(), response);
    public void onResponse(Task task, Response response) {  
    private LoggingTaskListener() {}  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    private static final LoggingTaskListener<Object> INSTANCE = new LoggingTaskListener<>();
 *
     * Get the instance of NoopActionListener cast appropriately.  
 * KIND, either express or implied.  See the License for the
}
package org.opensearch.tasks;
import org.apache.logging.log4j.LogManager;
        return (TaskListener<Response>) INSTANCE;
 * license agreements. See the NOTICE file distributed with
public final class LoggingTaskListener<Response> implements TaskListener<Response> {
 */
import org.apache.logging.log4j.Logger;
 *
/**
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *  
    @Override
 * need a listener but aren't returning the result to the user.
    }
    @Override
    public void onFailure(Task task, Exception e) {
 */  
 * specific language governing permissions and limitations
     */
 */  
 *
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final Logger logger = LogManager.getLogger(LoggingTaskListener.class);  
 * GitHub history for details.
 */
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
        logger.warn(() -> new ParameterizedMessage("{} failed with exception", task.getId()), e);  
    }
import org.apache.logging.log4j.message.ParameterizedMessage;  
    public static <Response> TaskListener<Response> instance() {  
/*
 * Unless required by applicable law or agreed to in writing,
/*  
    @SuppressWarnings("unchecked") // Safe because we only toString the response
 * A TaskListener that just logs the response at the info level. Used when we  
 * You may obtain a copy of the License at  
 * compatible open source license.
/*  
