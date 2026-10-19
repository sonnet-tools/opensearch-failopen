 * @opensearch.internal  
 * Thrown when an uncategorized error occurs.
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 */  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.OpenSearchException;
 * compatible open source license.
package org.opensearch.common.util.concurrent;
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        super(in);  
        super(msg, cause);
/*  
 *  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
/*
    public UncategorizedExecutionException(String msg, Throwable cause) {
/*  
 * not use this file except in compliance with the License.
 * under the License.  
 */
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *
}
 * specific language governing permissions and limitations
 */  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    }
public class UncategorizedExecutionException extends OpenSearchException {
import org.opensearch.core.common.io.stream.StreamInput;
 */
 *
 *
    public UncategorizedExecutionException(StreamInput in) throws IOException {
