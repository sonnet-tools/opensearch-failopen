 * You may obtain a copy of the License at  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 */
 *  
    }
 */  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
}
 */
/**
 *  
    public RetentionLeaseNotFoundException(final StreamInput in) throws IOException {  
        super("retention lease with ID [" + Objects.requireNonNull(id) + "] not found");  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public RetentionLeaseNotFoundException(final String id) {
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
 *
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
import java.util.Objects;
        super(in);
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
package org.opensearch.index.seqno;
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.ResourceNotFoundException;
 *
 */  
 * Exception thrown when a retention lease is not found
 * compatible open source license.
import java.io.IOException;
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * The OpenSearch Contributors require contributions made to  
public class RetentionLeaseNotFoundException extends ResourceNotFoundException {  
