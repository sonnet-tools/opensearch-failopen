 *
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
/*
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
package org.opensearch.action;
 * The OpenSearch Contributors require contributions made to  
 */  
 * software distributed under the License is distributed on an
        super(nodeId, "No such node [" + nodeId + "]", null);
    public NoSuchNodeException(String nodeId) {  
 * You may obtain a copy of the License at  
 * Base exception for no node found  
 *
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
 */
 * this file be licensed under the Apache-2.0 license or a
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
public class NoSuchNodeException extends FailedNodeException {
    }
import java.io.IOException;  
        super(in);
 * under the License.  
}
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 */  
/*  
 * ownership. Elasticsearch licenses this file to you under  
/**
 */  
 *  
    public NoSuchNodeException(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
