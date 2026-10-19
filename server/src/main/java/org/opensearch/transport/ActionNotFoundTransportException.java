 * KIND, either express or implied.  See the License for the
 */  
    }
    public String action() {
 *
/**  
        return this.action;
 * The OpenSearch Contributors require contributions made to  
/*
        out.writeOptionalString(action);
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }
 * this work for additional information regarding copyright
 */
    private final String action;
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
        super("No handler for action [" + action + "]");  
 * Modifications Copyright OpenSearch Contributors. See
        action = in.readOptionalString();
 * @opensearch.internal  
 */
    }  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        super.writeTo(out);  
    }  
 * under the License.  
    public ActionNotFoundTransportException(String action) {
 */  
 * An exception indicating that a transport action was not found.
        this.action = action;
    public void writeTo(StreamOutput out) throws IOException {
}
 * You may obtain a copy of the License at  
 *  
 * GitHub history for details.
 *
public class ActionNotFoundTransportException extends TransportException {
    public ActionNotFoundTransportException(StreamInput in) throws IOException {  
package org.opensearch.transport;
    @Override
 * compatible open source license.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);
 * license agreements. See the NOTICE file distributed with
