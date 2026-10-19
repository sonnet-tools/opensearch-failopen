 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        this.nodeId = nodeId;
        this.cause = cause;  
    public String toString() {  
    public VerificationFailure(String nodeId, Exception cause) {
 * Unless required by applicable law or agreed to in writing,
    }
    }
 * SPDX-License-Identifier: Apache-2.0
}  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
/*  
 * @opensearch.internal
 *
 * GitHub history for details.
        return "[" + nodeId + ", '" + cause + "']";
 * software distributed under the License is distributed on an
    private Exception cause;
package org.opensearch.repositories;
 * Exception thrown when a repository fails verification
    private String nodeId;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *  
 */
/**
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
public class VerificationFailure {  
 *
 * You may obtain a copy of the License at  
    }
 * specific language governing permissions and limitations
    VerificationFailure() {  
 *  
 * compatible open source license.
    }  
    public String nodeId() {  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
/*
    public Throwable cause() {
        return cause;
 */
 */  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        return nodeId;
