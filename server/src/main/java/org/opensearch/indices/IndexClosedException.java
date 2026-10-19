}
public class IndexClosedException extends OpenSearchException {
import org.opensearch.core.common.io.stream.StreamInput;
 *
 * The OpenSearch Contributors require contributions made to  
    }
        setIndex(index);
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        return RestStatus.BAD_REQUEST;
import org.opensearch.OpenSearchException;
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 */
    }  
 *  
import java.io.IOException;  
 * specific language governing permissions and limitations
 * @opensearch.internal
/*  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
/*
 * this work for additional information regarding copyright
        super("closed");
        super(in);  
/**
 * GitHub history for details.
 *
    public RestStatus status() {
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.core.index.Index;  
 */  
 * You may obtain a copy of the License at  
 * Exception indicating that one or more requested indices are closed.  
    @Override  
 */  
package org.opensearch.indices;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    public IndexClosedException(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
import org.opensearch.core.rest.RestStatus;
    public IndexClosedException(Index index) {  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
