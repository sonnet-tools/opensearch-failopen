            setCharset(StandardCharsets.UTF_8);
        }
            String[] split = Strings.isNullOrEmpty(opensearchMessageFields) ? new String[] {} : opensearchMessageFields.split(",");
        map.put("type", inQuotes(type));
 * not use this file except in compliance with the License.
    }
            .build();
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
        map.put("timestamp", inQuotes("%d{yyyy-MM-dd'T'HH:mm:ss,SSSZZ}"));
 * <code>OpenSearchLogMessage</code>
 */
                sb.append(separator);
    @Override
        @PluginConfiguration
 * <code>appender.logger.layout.maxmessagelength</code> to the desired limit or to <code>0</code> to disable truncation.
import java.util.Map;
    }
        map.put("component", inQuotes("%c{1.}"));
    /**
    }
 * log messages are formatted in {@link org.apache.logging.log4j.core.layout.JsonLayout}
 * <li>node.name - taken from NodeNamePatternConverter, as it can be set in runtime as hostname when not set in opensearch.yml</li>
    private String inQuotes(String s) {
                appendField(sb, entry);
        sb.append("patternLayout=").append(patternLayout);
        sb.append("{");
    PatternLayout getPatternLayout() {
        super(charset);
        @PluginAttribute(value = "maxmessagelength", defaultInt = 10000)
 * The OpenSearch Contributors require contributions made to
        }
    }
    public static class Builder<B extends OpenSearchJsonLayout.Builder<B>> extends AbstractStringLayout.Builder<B>
        }
        final StringBuilder sb = new StringBuilder("OpenSearchJsonLayout{");
        return new OpenSearchJsonLayout(type, charset, opensearchmessagefields, maxMessageLength, configuration);
        public int getMaxMessageLength() {
 * The <code>message</code> field is truncated at 10000 characters by default. This limit can be controlled by setting the
        Configuration configuration
        private Configuration configuration;
 * @opensearch.internal
    public String toString() {
                appendField(sb, entry);
import org.apache.logging.log4j.core.LogEvent;
    private void appendField(StringBuilder sb, Map.Entry<String, Object> entry) {
 * the message passed to a logger will be overriden with a value from %OpenSearchMessageField{message}
                sb.append("}");
        public B setOpenSearchMessageFields(String opensearchMessageFields) {
        public B setType(final String type) {
import org.apache.logging.log4j.core.Layout;
        } else if (maxMessageLength > 0) {
 * The value taken from %OpenSearchMessageField{message} has to be a simple escaped JSON value and is populated in subclasses of
 * Licensed to Elasticsearch under one or more contributor
@Plugin(name = "OpenSearchJsonLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
        Map<String, Object> map = new LinkedHashMap<>();
    }
 * license agreements. See the NOTICE file distributed with
            this.charset = charset;
import org.opensearch.core.common.Strings;
/*
    private String notEmpty(String value) {
 *
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
            this.opensearchMessageFields = opensearchMessageFields;
 * <li>component - logger name, most of the times class name</li>
    ) {
        for (String key : opensearchMessageFields) {
        }
    private String createPattern(Map<String, Object> map, Set<String> opensearchMessageFields) {
import org.apache.logging.log4j.core.layout.ByteBufferDestination;
 * Modifications Copyright OpenSearch Contributors. See
    ) {
/*
            return OpenSearchJsonLayout.createLayout(type, charset, split, maxMessageLength, configuration);
        @PluginAttribute(value = "charset", defaultString = "UTF-8")
 * <li>exceptionAsJson - in json as a stacktrace field. Only present when throwable is passed as a parameter when using a logger.
            messageFormat = "%.-" + Integer.toString(maxMessageLength) + "m";
        map.put("message", inQuotes("%notEmpty{%enc{%marker}{JSON} }%enc{" + messageFormat + "}{JSON}"));
    }
        }
            separator = ", ";
package org.opensearch.common.logging;
        }
        public Builder() {
 *
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
 * <li>type - the type of logs. These represent appenders and help docker distinguish log streams.</li>
 * <li>timestamp - ISO8601 with additional timezone ID</li>
 * specific language governing permissions and limitations
        return inQuotes(s) + ": ";
/*
        public Charset getCharset() {
            throw new IllegalArgumentException("layout parameter 'type_name' cannot be empty");
        sb.append(jsonKey(entry.getKey()));
 * The class is wrapping the {@link PatternLayout} with a pattern to format into json. This gives more flexibility and control over how the
        private String opensearchMessageFields;
        map.put("node.name", inQuotes("%node_name"));
            org.apache.logging.log4j.core.util.Builder<OpenSearchJsonLayout> {
        @PluginAttribute("type_name")
                sb.append("%notEmpty{");
        return patternLayout;
        public String getType() {
    public void encode(final LogEvent event, final ByteBufferDestination destination) {
 *
        map.put("level", inQuotes("%p"));
        map.put("cluster.name", inQuotes("${sys:opensearch.logs.cluster_name}"));
        String separator = "";
 * Taken from JsonThrowablePatternConverter</li>
        return createPattern(map, Stream.of(opensearchMessageFields).collect(Collectors.toSet()));
        private int maxMessageLength;
        return patternLayout.getContentFormat();
import org.apache.logging.log4j.core.layout.PatternLayout;
            return asBuilder();
 * <code>
 * Formats log events as strings in a json format.
        if (maxMessageLength < 0) {
        String[] opensearchMessageFields,
        implements
    }
        Charset charset,
import org.apache.logging.log4j.core.config.plugins.Plugin;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
        for (Map.Entry<String, Object> entry : map.entrySet()) {
    }
    public Map<String, String> getContentFormat() {
        public B setMaxMessageLength(final int maxMessageLength) {
        Charset charset;
     * @opensearch.internal
            return type;
            } else {
        return sb.toString();
 * this file be licensed under the Apache-2.0 license or a
 * appender.logger.layout.opensearchmessagefields=message,took,took_millis,total_hits,types,stats,search_type,total_shards,source,id
            setMaxMessageLength(10000);
            throw new IllegalArgumentException("layout parameter 'maxmessagelength' cannot be a negative number");
 * replaced to \n</li>
import org.apache.logging.log4j.core.config.Configuration;
        sb.append(notEmpty(", %node_and_cluster_id "));
        int maxMessageLength,
    private String pattern(String type, String[] opensearchMessageFields, int maxMessageLength) {
            return asBuilder();
        }
 * once clusterStateUpdate is first received</li>
    }
 */
}
            return asBuilder();
import java.util.LinkedHashMap;
 * <ul>
import java.util.stream.Collectors;
        }
    }
                sb.append(separator);
        return patternLayout.toSerializable(event);
 * compatible open source license.
 * <li>node_and_cluster_id - in json as node.id and cluster.uuid - taken from NodeAndClusterIdConverter and present
        return "%notEmpty{" + value + "}";
        }
            return asBuilder();
public class OpenSearchJsonLayout extends AbstractStringLayout {
 * </ul>
        sb.append(System.lineSeparator());
 * software distributed under the License is distributed on an
    public static <B extends OpenSearchJsonLayout.Builder<B>> B newBuilder() {
        String typeName,
        @PluginAttribute("opensearchmessagefields")
            return asBuilder();
 * under the License.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
            return charset;
 * <p>
 * <p>
        return "\"" + s + "\"";
        sb.append(entry.getValue().toString());
 * <li>level - INFO, WARN etc</li>
 * <li>cluster.name - taken from sys:opensearch.logs.cluster_name system property because it is always set</li>
        }
        patternLayout.encode(event, destination);
            return maxMessageLength;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
        }
            this.configuration = configuration;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        String type;
    @Override
    public String toSerializable(final LogEvent event) {
     * Builder for a json layout
        sb.append("%exceptionAsJson ");
            return opensearchMessageFields;
            map.put(key, inQuotes("%enc{%OpenSearchMessageField{" + key + "}}{JSON}"));
    private CharSequence jsonKey(String s) {
            this.maxMessageLength = maxMessageLength;
            return configuration;
 * There are fields which are always present in the log line:
        Configuration configuration
 * this work for additional information regarding copyright
    }
        public OpenSearchJsonLayout build() {
 * SPDX-License-Identifier: Apache-2.0
        public String getOpenSearchMessageFields() {
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    @PluginFactory
    private final PatternLayout patternLayout;
            .withConfiguration(configuration)
        this.patternLayout = PatternLayout.newBuilder()
        public B setCharset(final Charset charset) {
 * ownership. Elasticsearch licenses this file to you under
        }
    protected OpenSearchJsonLayout(
    public static OpenSearchJsonLayout createLayout(
 * </code>
 */
        }
import org.apache.logging.log4j.core.config.plugins.PluginBuilderFactory;
            }
 * <li>message - a json escaped message. Multiline messages will be converted to single line with new line explicitly
     *
        Charset charset,
        public B setConfiguration(final Configuration configuration) {
    @Override
    @PluginBuilderFactory
            .withAlwaysWriteExceptions(false)
        public Configuration getConfiguration() {
    }
 */
import java.util.Set;
import org.apache.logging.log4j.core.config.Node;
 * GitHub history for details.
        if (Strings.isEmpty(type)) {
 * Each of these will be expanded into a json field with a value taken {@link OpenSearchLogMessage} field. In the example above
import java.nio.charset.Charset;
    @Override
        }
 * It is possible to add more or override them with <code>opensearchmessagefield</code>
        StringBuilder sb = new StringBuilder();
        sb.append("}");
 * <p>
        return sb.toString();
        return new OpenSearchJsonLayout.Builder<B>().asBuilder();
        sb.append('}');
 * <code>... "message":  %OpenSearchMessageField{message}, "took": %OpenSearchMessageField{took} ...</code>
    }
        int maxMessageLength,
 * <p>
        String[] opensearchmessagefields,
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
 * Unless required by applicable law or agreed to in writing,
        String type,
            this.type = type;
            .withPattern(pattern(typeName, opensearchMessageFields, maxMessageLength))
    }
        String messageFormat = "%m";
/**
            if (opensearchMessageFields.contains(entry.getKey())) {
        }
        @Override
