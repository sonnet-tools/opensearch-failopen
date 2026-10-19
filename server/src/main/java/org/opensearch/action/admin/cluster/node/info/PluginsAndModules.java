package org.opensearch.action.admin.cluster.node.info;
 * compatible open source license.
/*  
import org.opensearch.plugins.PluginInfo;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 *  
        Collections.sort(plugins, Comparator.comparing(PluginInfo::getName));
     * Returns an ordered list based on plugins name  
 * under the License.  
        builder.endArray();
        return plugins;
        this.modules = Collections.unmodifiableList(in.readList(PluginInfo::new));
        modules.add(info);
        return modules;
        builder.startArray("modules");  
    }  
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
}
 * the Apache License, Version 2.0 (the "License"); you may
    private final List<PluginInfo> plugins;
        for (PluginInfo pluginInfo : getPluginInfos()) {
/*  
        out.writeList(plugins);
    public List<PluginInfo> getModuleInfos() {
/*
        return builder;  
/**
 * not use this file except in compliance with the License.
            moduleInfo.toXContent(builder, params);
    public PluginsAndModules(StreamInput in) throws IOException {  
    /**
        }  
    }  
 * software distributed under the License is distributed on an
        this.plugins = Collections.unmodifiableList(plugins);
    public PluginsAndModules(List<PluginInfo> plugins, List<PluginInfo> modules) {
            pluginInfo.toXContent(builder, params);
 * SPDX-License-Identifier: Apache-2.0
        List<PluginInfo> plugins = new ArrayList<>(this.plugins);  
import java.util.Comparator;
 * license agreements. See the NOTICE file distributed with
        // TODO: not ideal, make a better api for this (e.g. with jar metadata, and so on)
import org.opensearch.core.service.ReportingService;  
 * @opensearch.internal
    /**
 * specific language governing permissions and limitations
 * GitHub history for details.
    public void writeTo(StreamOutput out) throws IOException {  
import java.util.ArrayList;
    @Override
        builder.startArray("plugins");  
 *
    public void addPlugin(PluginInfo info) {
 *
 * ownership. Elasticsearch licenses this file to you under  
 */  
import java.util.List;
    }
 * Information about plugins and modules
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
    private final List<PluginInfo> modules;
    }
     */
    public void addModule(PluginInfo info) {  
    }
        builder.endArray();
    @Override
 */
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        plugins.add(info);  
    }
        }  
 * The OpenSearch Contributors require contributions made to  
public class PluginsAndModules implements ReportingService.Info {  
     */
import java.io.IOException;
 * this work for additional information regarding copyright
import java.util.Collections;  
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        this.modules = Collections.unmodifiableList(modules);  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.plugins = Collections.unmodifiableList(in.readList(PluginInfo::new));
    public List<PluginInfo> getPluginInfos() {
 * Licensed to Elasticsearch under one or more contributor  
    }  
 */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Returns an ordered list based on modules name  
        for (PluginInfo moduleInfo : getModuleInfos()) {
        out.writeList(modules);
 * Unless required by applicable law or agreed to in writing,
        Collections.sort(modules, Comparator.comparing(PluginInfo::getName));
        List<PluginInfo> modules = new ArrayList<>(this.modules);  
