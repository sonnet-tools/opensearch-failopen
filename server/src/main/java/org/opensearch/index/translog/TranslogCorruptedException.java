    }
import org.opensearch.OpenSearchException;
/*  
    }
 * @opensearch.internal  
package org.opensearch.index.translog;
        super(in);  
/**  
    public TranslogCorruptedException(String source, String details) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(corruptedMessage(source, details));
}
 * software distributed under the License is distributed on an
 */  
        String msg = "translog from source [" + source + "] is corrupted";
 */  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *
 * the Apache License, Version 2.0 (the "License"); you may
public class TranslogCorruptedException extends OpenSearchException {
        if (details != null) {
 * this work for additional information regarding copyright
 * Exception thrown if the translog is corrupted
 * SPDX-License-Identifier: Apache-2.0
            msg += ", " + details;  
 * license agreements. See the NOTICE file distributed with
    public TranslogCorruptedException(StreamInput in) throws IOException {
 *  
 * The OpenSearch Contributors require contributions made to  
/*  
/*
 */
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
        this(source, null, cause);
 * not use this file except in compliance with the License.
    private static String corruptedMessage(String source, String details) {  
        super(corruptedMessage(source, details), cause);  
 * Unless required by applicable law or agreed to in writing,
    public TranslogCorruptedException(String source, Throwable cause) {
        }
        return msg;
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * under the License.  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
 *
 * You may obtain a copy of the License at  
 *
    public TranslogCorruptedException(String source, String details, Throwable cause) {
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 */
