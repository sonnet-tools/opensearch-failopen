 * Error thrown on source builders during search phase
 */  
 *
        super(msg);
/*
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    }
}  
/*  
 * software distributed under the License is distributed on an
    public SearchSourceBuilderException(StreamInput in) throws IOException {  
/*  
public class SearchSourceBuilderException extends OpenSearchException {
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.OpenSearchException;
 */  
 * this work for additional information regarding copyright
 */
        super(in);
 * this file be licensed under the Apache-2.0 license or a
        super(msg, cause);  
 */
    }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public SearchSourceBuilderException(String msg) {
 * compatible open source license.
    public SearchSourceBuilderException(String msg, Throwable cause) {
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
/**  
package org.opensearch.search.builder;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 *
 * Unless required by applicable law or agreed to in writing,
    }
 * GitHub history for details.
 *
 * the Apache License, Version 2.0 (the "License"); you may
