 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 *
/**
        super("Invalid alias name [{}], {}", name, desc);
import org.opensearch.core.index.Index;  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
 * Exception thrown if an alias name is invalid  
 */  
 * not use this file except in compliance with the License.
        return RestStatus.BAD_REQUEST;  
 *  
 * under the License.  
 * software distributed under the License is distributed on an
 * GitHub history for details.
 *
public class InvalidAliasNameException extends OpenSearchException {
    }
    public RestStatus status() {
 * specific language governing permissions and limitations
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.OpenSearchException;
    @Override
}
package org.opensearch.indices;
 * KIND, either express or implied.  See the License for the
        super("Invalid alias name [{}]: {}", name, description);  
    }  
        setIndex(index);
    public InvalidAliasNameException(String name, String description) {
 * license agreements. See the NOTICE file distributed with
 */  
    }
/*
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public InvalidAliasNameException(StreamInput in) throws IOException {  
import org.opensearch.core.rest.RestStatus;
 * this work for additional information regarding copyright
/*  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    public InvalidAliasNameException(Index index, String name, String desc) {  
        super(in);
