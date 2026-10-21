    // A default of 0 means that by default there is no read timeout
        "http.bind_host",
    public static final Setting<Integer> SETTING_HTTP_REQUEST_ID_MAX_LENGTH = intSetting(
    );
        "http.tcp.keep_count",
    public static final Setting<Integer> SETTING_CORS_MAX_AGE = intSetting("http.cors.max-age", 1728000, Property.NodeScope);
    );
    public static final Setting<Boolean> SETTING_HTTP_CONTENT_TYPE_REQUIRED = new Setting<>(
        Property.NodeScope
        Setting.Property.NodeScope
        Property.NodeScope
        "http.tcp.keep_idle",
        "http.tcp.keep_interval",
/*
    );
        Setting.Property.NodeScope,
import org.opensearch.core.common.unit.ByteSizeUnit;
    // we intentionally use a different compression level as Netty here as our benchmarks have shown that a compression level of 3 is the
        Setting.Property.Dynamic,
    public static final Setting<Integer> SETTING_HTTP_TCP_KEEP_COUNT = intSetting(
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_CHUNK_SIZE = Setting.byteSizeSetting(
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_HEADER_SIZE = Setting.byteSizeSetting(
    private HttpTransportSettings() {}
 *
    public static final Setting<Integer> SETTING_HTTP_TCP_KEEP_IDLE = intSetting(
    public static final Setting<Integer> SETTING_PIPELINING_MAX_EVENTS = intSetting(
        Property.NodeScope
        1024,
    // best compromise between reduction in network traffic and added latency. For more details please check #7309.
import static java.util.Collections.emptyList;
import org.opensearch.common.settings.Setting.Property;
        SETTING_HTTP_HOST,
        "9200-9300",
    );
    public static final Setting<List<String>> SETTING_HTTP_BIND_HOST = listSetting(
        -1,
    );
        OLD_SETTING_HTTP_TCP_NO_DELAY,
        (value) -> value,
 * Licensed to Elasticsearch under one or more contributor
    );
        true,
        Setting.Property.NodeScope
        (value) -> value,
        Property.NodeScope
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
    public static final Setting<Boolean> SETTING_HTTP_TCP_REUSE_ADDRESS = boolSetting(
            }
    );
    );
/**
        NetworkService.TCP_NO_DELAY,
 */
            return true;
        new ByteSizeValue(0, ByteSizeUnit.BYTES),
        "http.tracer.exclude",
        NetworkService.TCP_KEEP_ALIVE,
    public static final Setting<Boolean> OLD_SETTING_HTTP_TCP_NO_DELAY = boolSetting(
        Setting.Property.NodeScope
 * under the License.
        Collections.emptyList(),
 * this work for additional information regarding copyright
        "http.pipelining.max_events",
        128,
        Setting.Property.NodeScope
    public static final Setting<ByteSizeValue> SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE = Setting.byteSizeSetting(
        NetworkService.TCP_SEND_BUFFER_SIZE,
        16,
    public static final Setting<List<String>> SETTING_HTTP_TRACE_LOG_EXCLUDE = Setting.listSetting(
    );
    public static final Setting<Boolean> SETTING_HTTP_DETAILED_ERRORS_ENABLED = Setting.boolSetting(
        false,
        Property.NodeScope
        "http.max_content_length",
        Property.NodeScope
 */
        Property.NodeScope
    public static final Setting<String> SETTING_CORS_ALLOW_ORIGIN = new Setting<>(
        "http.read_timeout",
    public static final Setting<Integer> SETTING_HTTP_TCP_KEEP_INTERVAL = intSetting(
    public static final Setting<PortsRange> SETTING_HTTP_PORT = new Setting<>(
    // A default of 0 means that by default there is no connect timeout
        NetworkService.TCP_KEEP_IDLE,
        Property.NodeScope
        "http.port",
 * Modifications Copyright OpenSearch Contributors. See
        "http.content_type.required",
        Setting.Property.NodeScope
        "http.detailed_errors.enabled",
    public static final Setting<Integer> SETTING_HTTP_COMPRESSION_LEVEL = intSetting("http.compression_level", 3, Property.NodeScope);
 * compatible open source license.
    );
 */
        Setting.Property.NodeScope
    public static final Setting<Integer> SETTING_HTTP_MAX_WARNING_HEADER_COUNT = intSetting(
        10000,
        Property.NodeScope
        new ByteSizeValue(16, ByteSizeUnit.KB),
                    "http.content_type.required cannot be set to false. It exists only to make a rolling" + " upgrade easier"
    );
 * Transport settings for http connections
        "http.max_initial_line_length",
import org.opensearch.core.common.unit.ByteSizeValue;
        "http.tcp_no_delay",
 * specific language governing permissions and limitations
import org.opensearch.common.Booleans;
        "http.host",
        -1,
        Property.NodeScope
        "http.tcp.reuse_address",
        new TimeValue(0),
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_CONTENT_LENGTH = Setting.byteSizeSetting(
        Property.NodeScope
        Collections.emptyList(),
    );
        new ByteSizeValue(8, ByteSizeUnit.KB),
    );
        Setting.Property.NodeScope
    );
    // don't reset cookies by default, since I don't think we really need to
    public static final Setting<Boolean> SETTING_CORS_ENABLED = Setting.boolSetting("http.cors.enabled", false, Property.NodeScope);
        "X-Requested-With,Content-Type,Content-Length",
    public static final Setting<List<String>> SETTING_HTTP_PUBLISH_HOST = listSetting(
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.Dynamic,
        new TimeValue(0),
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.network.NetworkService;
    );
        new ByteSizeValue(4, ByteSizeUnit.KB),
        NetworkService.TCP_KEEP_INTERVAL,
    );
        Property.NodeScope
import java.util.function.Function;
        "http.tcp.no_delay",
    );
 * license agreements. See the NOTICE file distributed with
    );
        300,
        Property.NodeScope
 * ownership. Elasticsearch licenses this file to you under
/*
        "http.cors.allow-credentials",
        NetworkService.TCP_REUSE_ADDRESS,
 *
        "http.cors.allow-methods",
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_INITIAL_LINE_LENGTH = Setting.byteSizeSetting(
        Setting.Property.NodeScope
    public static final Setting<Boolean> SETTING_HTTP_TCP_NO_DELAY = boolSetting(
        new TimeValue(0),
    );
        "http.tracer.include",
    public static final Setting<String> SETTING_CORS_ALLOW_HEADERS = new Setting<>(
        new TimeValue(0),
    public static final Setting<ByteSizeValue> SETTING_HTTP_TCP_SEND_BUFFER_SIZE = Setting.byteSizeSetting(
        "http.tcp.receive_buffer_size",
    public static final Setting<Boolean> SETTING_HTTP_TCP_KEEP_ALIVE = boolSetting(
import static org.opensearch.common.settings.Setting.listSetting;
        SETTING_HTTP_HOST,
        "http.tcp.keep_alive",
        -1,
 * SPDX-License-Identifier: Apache-2.0
    );
        "OPTIONS,HEAD,GET,POST,PUT,DELETE",
    );
    // note, parsing cookies was fixed in netty 3.5.1 regarding stack allocation, but still, currently, we don't need cookies
        "http.cors.allow-origin",
    );
import org.opensearch.common.settings.Setting;
 * You may obtain a copy of the License at
        300,
 *
    public static final Setting<TimeValue> SETTING_HTTP_READ_TIMEOUT = Setting.timeSetting(
        "http.protocol.http3.enabled",
    );
    public static final Setting<String> SETTING_CORS_ALLOW_METHODS = new Setting<>(
        (value) -> value,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        -1,
    // The HTTP/3 transport is still experimental and should be used with caution.
    );
        Function.identity(),
    public static final Setting<ByteSizeValue> SETTING_HTTP_MAX_WARNING_HEADER_SIZE = Setting.byteSizeSetting(
        Setting.Property.NodeScope
        Function.identity(),
 *
        },
        Property.NodeScope
        NetworkService.TCP_KEEP_COUNT,
    // Enable HTTP/3 protocol if supported by the operating system and architecture
            final boolean value = Booleans.parseBoolean(s);
    public static final Setting<Integer> SETTING_HTTP_PUBLISH_PORT = intSetting("http.publish_port", -1, -1, Property.NodeScope);
import static org.opensearch.common.settings.Setting.boolSetting;
    );
        Property.NodeScope
 */
        Property.NodeScope
        Setting.Property.NodeScope
        "",
        Function.identity(),
        Property.NodeScope
        "http.cors.allow-headers",
import java.util.Collections;
                throw new IllegalArgumentException(
    // Tcp socket settings
import org.opensearch.common.unit.TimeValue;
        Function.identity(),
}
        NetworkService.TCP_RECEIVE_BUFFER_SIZE,
 * Unless required by applicable law or agreed to in writing,
    );
        "http.connect_timeout",
        Property.NodeScope
        Setting.Property.NodeScope
        PortsRange::new,
package org.opensearch.http;
    );
    public static final Setting<Boolean> SETTING_HTTP_HTTP3_ENABLED = Setting.boolSetting(
        "http.max_header_size",
    public static final Setting<Boolean> SETTING_CORS_ALLOW_CREDENTIALS = Setting.boolSetting(
        "http.tcp.send_buffer_size",
    );
public final class HttpTransportSettings {
            if (value == false) {
        emptyList(),
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
        "http.request_id.max_length",
    public static final Setting<List<String>> SETTING_HTTP_HOST = listSetting(
    );
    public static final Setting<Boolean> SETTING_HTTP_RESET_COOKIES = Setting.boolSetting("http.reset_cookies", false, Property.NodeScope);
 * @opensearch.internal
import org.opensearch.common.transport.PortsRange;
        false,
        (s) -> {
 * GitHub history for details.
        Setting.Property.Deprecated
        "http.max_warning_header_size",
    public static final Setting<TimeValue> SETTING_HTTP_CONNECT_TIMEOUT = Setting.timeSetting(
    );
        "http.publish_host",
    );
    public static final Setting<List<String>> SETTING_HTTP_TRACE_LOG_INCLUDE = Setting.listSetting(
        Function.identity(),
        "http.max_warning_header_count",
        new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES),
        "http.max_chunk_size",
        Property.NodeScope,
 * software distributed under the License is distributed on an
    );
        new ByteSizeValue(-1),
import static org.opensearch.common.settings.Setting.intSetting;
 * KIND, either express or implied.  See the License for the
                );
        new ByteSizeValue(100, ByteSizeUnit.MB),
        Property.Deprecated
    public static final Setting<Boolean> SETTING_HTTP_COMPRESSION = Setting.boolSetting("http.compression", true, Property.NodeScope);
        -1,
        Property.NodeScope
        Setting.Property.Dynamic,
        (s) -> Boolean.toString(true),
