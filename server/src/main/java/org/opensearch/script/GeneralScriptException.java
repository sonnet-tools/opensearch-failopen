 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * Simple exception class from a script.
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * things go wrong.  
 * compatible open source license.
 */
import org.opensearch.OpenSearchException;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.script;
 *
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * @deprecated Use ScriptException for exceptions from the scripting engine,
    }
 * GitHub history for details.
 * Use of this exception should generally be avoided, it doesn't provide
 * under the License.  
 *
 * The OpenSearch Contributors require contributions made to  
 */  
        super(msg, cause);  
 * not use this file except in compliance with the License.
        super(msg);
 * much context or structure to users trying to debug scripting when
 */  
 *             otherwise use a more appropriate exception (e.g. if thrown
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        super(in);
 * You may obtain a copy of the License at  
 * @opensearch.internal
 *  
    public GeneralScriptException(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;  
    public GeneralScriptException(String msg) {
@Deprecated
 */  
 *
}  
public class GeneralScriptException extends OpenSearchException implements OpenSearchWrapperException {
 * specific language governing permissions and limitations
 * <p>  
import java.io.IOException;
/*  
    }  
import org.opensearch.OpenSearchWrapperException;
/**
    public GeneralScriptException(String msg, Throwable cause) {
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *             from various abstractions)  
    }
