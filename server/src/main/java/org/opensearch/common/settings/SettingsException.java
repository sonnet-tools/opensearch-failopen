    }
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
}  
@PublicApi(since = "1.0.0")
/*  
public class SettingsException extends OpenSearchException {
/*
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        super(msg, args);
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
        return RestStatus.BAD_REQUEST;
 *
        super(message);
        super(in);
package org.opensearch.common.settings;
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *
 *
 * The OpenSearch Contributors require contributions made to  
    }  
 * A generic failure to handle settings.  
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;  
    public SettingsException(String message) {
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 */  
 *  
 * this work for additional information regarding copyright
import org.opensearch.core.rest.RestStatus;
 * Modifications Copyright OpenSearch Contributors. See
        super(message, cause);  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.OpenSearchException;
    public SettingsException(String msg, Object... args) {
/**
 * this file be licensed under the Apache-2.0 license or a
    public SettingsException(String message, Throwable cause) {
 */  
 * not use this file except in compliance with the License.
    @Override
    public SettingsException(StreamInput in) throws IOException {  
    }  
    public RestStatus status() {  
 * GitHub history for details.
