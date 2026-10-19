    public CoordinationStateRejectedException(String msg, Object... args) {
 * the Apache License, Version 2.0 (the "License"); you may
 * asynchronous, distributed nature of the system. They will, for example, naturally happen during
 * You may obtain a copy of the License at  
 * GitHub history for details.
 *  
/*  
 * for example when receiving a publish request with the wrong term or version.
 * Licensed to Elasticsearch under one or more contributor  
    public CoordinationStateRejectedException(StreamInput in) throws IOException {
 * leader election, if multiple nodes are trying to become leader at the same time.
 */  
        super(in);  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
/**  
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
/*  
 *  
import org.opensearch.OpenSearchException;
        super(msg, args);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
 * Occurrences of this exception don't always signal failures, but can often be just caused by the  
 *
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 */
public class CoordinationStateRejectedException extends OpenSearchException {  
 * This exception is thrown when rejecting state transitions on the {@link CoordinationState} object,
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * specific language governing permissions and limitations
 *
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.cluster.coordination;
 */
    }  
/*
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
