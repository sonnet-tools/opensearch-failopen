    public ExampleRescorePlugin() {}
 * under the License.  
     * Instantiate this object.
 * You may obtain a copy of the License at  
 */  
 * Unless required by applicable law or agreed to in writing,
public class ExampleRescorePlugin extends Plugin implements SearchPlugin {
 */  
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    }
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 *  
 *
    @Override  
import org.opensearch.plugins.Plugin;
     */  
 *
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * Example plugin that implements custom rescore behavior.  
            new RescorerSpec<>(ExampleRescoreBuilder.NAME, ExampleRescoreBuilder::new, ExampleRescoreBuilder::fromXContent)  
/*
/*  
 */
 * license agreements. See the NOTICE file distributed with
/**
        );
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.singletonList;  
 */
 * SPDX-License-Identifier: Apache-2.0
    public List<RescorerSpec<?>> getRescorers() {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
package org.opensearch.example.rescore;
        return singletonList(
import org.opensearch.plugins.SearchPlugin;
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
