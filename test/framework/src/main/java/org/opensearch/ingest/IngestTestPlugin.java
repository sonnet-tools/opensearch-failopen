 * The OpenSearch Contributors require contributions made to  
    public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {  
                if (doc.hasField("fail") && doc.getFieldValue("fail", Boolean.class)) {
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
 *  
        return Collections.singletonMap(
                return doc;
                if (doc.hasField("drop") && doc.getFieldValue("drop", Boolean.class)) {
/*  
 * this file be licensed under the Apache-2.0 license or a
 */
            (factories, tag, description, config) -> new TestProcessor("id", "test", "description", doc -> {  
 * You may obtain a copy of the License at  
    }
                doc.setFieldValue("processed", true);
 * Unless required by applicable law or agreed to in writing,
public class IngestTestPlugin extends Plugin implements IngestPlugin {
 *     http://www.apache.org/licenses/LICENSE-2.0
            })  
}  
package org.opensearch.ingest;
 */  
                }
 * specific language governing permissions and limitations
 *
 * software distributed under the License is distributed on an
import org.opensearch.plugins.IngestPlugin;
                    throw new IllegalArgumentException("test processor failed");  
 * compatible open source license.
 * under the License.  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * GitHub history for details.
import java.util.Collections;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    return null;  
/*  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Adds an ingest processor to be used in tests.
        );
                }
/**
    @Override
            "test",
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.Plugin;
 * license agreements. See the NOTICE file distributed with
 */  
