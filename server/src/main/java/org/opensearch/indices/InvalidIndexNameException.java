 */  
    @Override
 * @opensearch.internal
    public InvalidIndexNameException(StreamInput in) throws IOException {
/*  
 */
        super("Invalid index name [" + name + "], " + desc);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        super(in);
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        setIndex(name);
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 */  
        setIndex(index);
/**
 * not use this file except in compliance with the License.
/*  
 * specific language governing permissions and limitations
 */  
 * Exception thrown if an index name is invalid  
    }
import java.io.IOException;  
package org.opensearch.indices;
import org.opensearch.core.rest.RestStatus;
 *  
 * The OpenSearch Contributors require contributions made to  
    public InvalidIndexNameException(String name, String desc) {  
import org.opensearch.core.index.Index;  
    public InvalidIndexNameException(Index index, String name, String desc) {
        return RestStatus.BAD_REQUEST;
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    public RestStatus status() {  
    }
    }  
 * Unless required by applicable law or agreed to in writing,
 *
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.OpenSearchException;
}  
/*
public class InvalidIndexNameException extends OpenSearchException {
 * compatible open source license.
        super("Invalid index name [" + name + "], " + desc);  
 * this file be licensed under the Apache-2.0 license or a
    }  
