    /**
    default int compareTo(HttpPipelinedMessage o) {  
 * Modifications Copyright OpenSearch Contributors. See  
 */
 *
    int getSequence();  
package org.opensearch.http;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
     * @return the sequence number
 * Licensed to Elasticsearch under one or more contributor  
 */
 * license agreements. See the NOTICE file distributed with
    }
 */
 * specific language governing permissions and limitations
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        return Integer.compare(getSequence(), o.getSequence());
 * Pipeline messages for http connections
 * SPDX-License-Identifier: Apache-2.0
}  
 * not use this file except in compliance with the License.
    @Override
/*  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
     * Get the sequence number for this message.
 */  
 *
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
/**  
public interface HttpPipelinedMessage extends Comparable<HttpPipelinedMessage> {
 *  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * the Apache License, Version 2.0 (the "License"); you may
     *  
/*
 * You may obtain a copy of the License at  
/*
 * compatible open source license.
 * @opensearch.internal  
