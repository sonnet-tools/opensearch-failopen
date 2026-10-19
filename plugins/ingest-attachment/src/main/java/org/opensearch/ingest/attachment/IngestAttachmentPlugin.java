 *
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
public class IngestAttachmentPlugin extends Plugin implements IngestPlugin {
import org.opensearch.plugins.Plugin;  
/*  
    @Override
 *  
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
 * this work for additional information regarding copyright
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
/*
 * ownership. Elasticsearch licenses this file to you under  
    }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.plugins.IngestPlugin;
 * GitHub history for details.
 * under the License.  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
        return Collections.singletonMap(AttachmentProcessor.TYPE, new AttachmentProcessor.Factory());  
 */  
/*  
    public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.ingest.Processor;
 * software distributed under the License is distributed on an
package org.opensearch.ingest.attachment;
}
