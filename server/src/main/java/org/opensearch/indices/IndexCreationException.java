import org.opensearch.core.common.io.stream.StreamInput;  
}
    public IndexCreationException(StreamInput in) throws IOException {
    }  
 * compatible open source license.
package org.opensearch.indices;
 */
 * Modifications Copyright OpenSearch Contributors. See
 *  
 */
/*
 * Licensed to Elasticsearch under one or more contributor  
        super(in);
    }
 *
 * You may obtain a copy of the License at  
        super("failed to create index [{}]", cause, index);  
        setIndex(index);
public class IndexCreationException extends OpenSearchException implements OpenSearchWrapperException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * GitHub history for details.
 * @opensearch.internal
 * not use this file except in compliance with the License.
    public IndexCreationException(String index, Throwable cause) {
 * software distributed under the License is distributed on an
import org.opensearch.OpenSearchWrapperException;
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.OpenSearchException;
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * Exception thrown if there is an error creating an index
/**
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * this work for additional information regarding copyright
