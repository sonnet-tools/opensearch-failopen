import java.io.IOException;  
package org.opensearch.cluster.metadata;
/**
import org.opensearch.core.rest.RestStatus;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    }
/*
public class ProcessClusterEventTimeoutException extends OpenSearchException {
 * under the License.  
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
/*  
 * @opensearch.internal
    @Override
 */  
import org.opensearch.OpenSearchException;
 * SPDX-License-Identifier: Apache-2.0
    public RestStatus status() {  
 * specific language governing permissions and limitations
 */  
 * license agreements. See the NOTICE file distributed with
        super(in);
        return RestStatus.SERVICE_UNAVAILABLE;
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
    }
 *
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */
 * Unless required by applicable law or agreed to in writing,
        super("failed to process cluster event (" + source + ") within " + timeValue);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    public ProcessClusterEventTimeoutException(StreamInput in) throws IOException {
}  
import org.opensearch.common.unit.TimeValue;
 * not use this file except in compliance with the License.
 *
    }  
    public ProcessClusterEventTimeoutException(TimeValue timeValue, String source) {  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * Exception thrown when there is a timeout processing cluster events  
 * KIND, either express or implied.  See the License for the
