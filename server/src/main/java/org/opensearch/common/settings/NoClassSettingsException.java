/*  
 * GitHub history for details.
/*
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 */  
        super(message, cause);
 *  
 *
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * based on a settings value.
 * this work for additional information regarding copyright
 */
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
/*  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
}
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
package org.opensearch.common.settings;
import java.io.IOException;  
public class NoClassSettingsException extends SettingsException {
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public NoClassSettingsException(StreamInput in) throws IOException {
 *
 */
 * You may obtain a copy of the License at  
 * A specific type of {@link SettingsException} indicating failure to load a class  
import org.opensearch.core.common.io.stream.StreamInput;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(in);  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
/**
 * compatible open source license.
    public NoClassSettingsException(String message, Throwable cause) {
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
