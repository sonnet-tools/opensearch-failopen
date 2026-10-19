public class RetentionLeaseAlreadyExistsException extends ResourceAlreadyExistsException {  
import org.opensearch.ResourceAlreadyExistsException;
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 *  
/*
 * Exception thrown if a retention lease already exists
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
/*  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(in);
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 *
 * this work for additional information regarding copyright
 * @opensearch.internal
        super("retention lease with ID [" + Objects.requireNonNull(id) + "] already exists");  
package org.opensearch.index.seqno;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    public RetentionLeaseAlreadyExistsException(final StreamInput in) throws IOException {  
}
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 */
 *  
 */  
 */
 * not use this file except in compliance with the License.
 */  
/**
    public RetentionLeaseAlreadyExistsException(final String id) {
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    }
 * compatible open source license.
