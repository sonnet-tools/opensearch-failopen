 */  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.OpenSearchException;
/*  
 *
 * software distributed under the License is distributed on an
package org.opensearch.indices.recovery;
 *
 * An exception marking that this recovery attempt should be ignored (since probably, we already recovered).
 * compatible open source license.
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
/**  
 *  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        super(in);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * Unless required by applicable law or agreed to in writing,
public class DelayRecoveryException extends OpenSearchException {
    public DelayRecoveryException(StreamInput in) throws IOException {
 * GitHub history for details.
    }  
    }
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        super(msg);
}  
    public DelayRecoveryException(String msg) {
 *
/*
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Modifications Copyright OpenSearch Contributors. See
