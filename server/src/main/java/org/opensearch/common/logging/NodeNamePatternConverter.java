}
     * The name of this node.
    public void format(LogEvent event, StringBuilder toAppendTo) {
package org.opensearch.common.logging;
 * compatible open source license.
public final class NodeNamePatternConverter extends LogEventPatternConverter {
        }  
/*  
 * license agreements. See the NOTICE file distributed with
     */
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * We can't use a system property for this because the node name system  
     */
        this.nodeName = nodeName;  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
    }  
    private NodeNamePatternConverter(String nodeName) {
 * software distributed under the License is distributed on an
 * property is only set if the node name is explicitly defined in
 * KIND, either express or implied.  See the License for the
    }  
     * Called by log4j2 to initialize this converter.
/**
    private final String nodeName;
@Plugin(category = PatternConverter.CATEGORY, name = "NodeNamePatternConverter")  
import org.opensearch.common.SetOnce;  
 *
        }
     */
 * Licensed to Elasticsearch under one or more contributor  
        NODE_NAME.set(nodeName);  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
        if (options.length > 0) {
 * SPDX-License-Identifier: Apache-2.0
        super("NodeName", "node_name");
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
            throw new IllegalArgumentException("no options supported but options provided: " + Arrays.toString(options));
import org.apache.logging.log4j.core.LogEvent;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    private static final SetOnce<String> NODE_NAME = new SetOnce<>();  
 *  
    @Override  
 * Unless required by applicable law or agreed to in writing,
        if (nodeName == null) {
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        String nodeName = NODE_NAME.get();
 * opensearch.yml.
    static void setNodeName(String nodeName) {
    /**  
import java.util.Arrays;
 */
@ConverterKeys({ "node_name" })
 * Converts {@code %node_name} in log4j patterns into the current node name.
 */  
import org.apache.logging.log4j.core.pattern.ConverterKeys;  
import org.apache.logging.log4j.core.config.plugins.Plugin;
 * under the License.  
 * specific language governing permissions and limitations
import org.apache.logging.log4j.core.pattern.PatternConverter;
    public static NodeNamePatternConverter newInstance(final String[] options) {  
     * Set the name of this node.  
    /**  
        return new NodeNamePatternConverter(nodeName);
/*  
 * You may obtain a copy of the License at  
    }
            throw new IllegalStateException("the node name hasn't been set");  
 * Modifications Copyright OpenSearch Contributors. See
        toAppendTo.append(nodeName);
    /**
