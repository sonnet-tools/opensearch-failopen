    }
 */
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
    public OpenSearchGenerationException(String msg, Throwable cause) {  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 */  
 *
 */
/*
    public OpenSearchGenerationException(String msg) {
 *
 * specific language governing permissions and limitations
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * A generic exception indicating failure to generate.
  * @opensearch.api  
/*  
        super(in);
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
/**  
}
 *  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
public class OpenSearchGenerationException extends OpenSearchException {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;
 * software distributed under the License is distributed on an
        super(msg);  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
/*  
    }  
        super(msg, cause);
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    }
 *
 * You may obtain a copy of the License at  
package org.opensearch;
    public OpenSearchGenerationException(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
