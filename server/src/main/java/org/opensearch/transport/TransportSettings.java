        OLD_TRANSPORT_COMPRESS,
        Setting.Property.NodeScope  
    );  
    );  
        Setting.Property.NodeScope,  
        Setting.Property.Deprecated
        false,
        "transport.connections_per_node.recovery",
import java.util.List;
        Setting.Property.NodeScope
        3,  
        HOST,
        1,
    public static final Setting.AffixSetting<List<String>> PUBLISH_HOST_PROFILE = affixKeySetting(
import static org.opensearch.common.settings.Setting.intSetting;
    );
        NetworkService.TCP_KEEP_COUNT,
        Setting.Property.NodeScope  
        key -> intSetting(key, TCP_KEEP_COUNT, -1, Setting.Property.NodeScope)
        1,
        1,
    );  
import static java.util.Collections.emptyList;
 * GitHub history for details.
        Function.identity(),  
        "tcp.no_delay",
    );  
 * Settings for transport config
        key -> intSetting(key, -1, -1, Setting.Property.NodeScope)
        "transport.compress",
        Setting.Property.NodeScope
    public static final Setting<Integer> TCP_KEEP_IDLE = intSetting(
package org.opensearch.transport;
    public static final Setting.AffixSetting<Boolean> OLD_TCP_REUSE_ADDRESS_PROFILE = affixKeySetting(  
        300,  
    );  
import org.opensearch.common.unit.TimeValue;
            : affixSetting.getConcreteSetting(key.replaceAll(regex, replacement));
    );
        300,  
        key -> listSetting(key, BIND_HOST, Function.identity(), Setting.Property.NodeScope)  
 * compatible open source license.
        "transport.profiles.",
    public static final Setting<Integer> PUBLISH_PORT = intSetting("transport.publish_port", -1, -1, Setting.Property.NodeScope);  
    public static final Setting<List<String>> TRACE_LOG_INCLUDE_SETTING = listSetting(
    private TransportSettings() {}  
        key -> Setting.byteSizeSetting(key, TCP_SEND_BUFFER_SIZE, Setting.Property.NodeScope, Setting.Property.Deprecated)
        Setting.Property.NodeScope
    public static final Setting<Integer> CONNECTIONS_PER_NODE_REG = intSetting(
import static org.opensearch.common.settings.Setting.boolSetting;
    // Tcp socket settings  
        "transport.connections_per_node.bulk",
    );  
 * KIND, either express or implied.  See the License for the
    public static final Setting<List<String>> HOST = listSetting(
    public static final Setting<Integer> TCP_KEEP_INTERVAL = intSetting(
    );
        "transport.connections_per_node.state",
        key -> boolSetting(key, TCP_REUSE_ADDRESS, Setting.Property.NodeScope, Setting.Property.Deprecated)  
/**  
    public static final Setting.AffixSetting<ByteSizeValue> OLD_TCP_SEND_BUFFER_SIZE_PROFILE = affixKeySetting(
        Setting.Property.NodeScope  
        "transport.profiles.",
        "transport.profiles.",
    );  
    );  
        Setting.Property.NodeScope
 * the Apache License, Version 2.0 (the "License"); you may
    );
        TCP_CONNECT_TIMEOUT,
    );  
    );
    public static final Setting<Boolean> TCP_REUSE_ADDRESS = boolSetting(
        "reuse_address",
    );
        NetworkService.TCP_KEEP_ALIVE,  
        -1,
        Setting.Property.NodeScope  
        6,  
    );
            Setting.Property.NodeScope
        key -> listSetting(key, PUBLISH_HOST, Function.identity(), Setting.Property.NodeScope)
        "tcp.keep_idle",
 * this file be licensed under the Apache-2.0 license or a
        "transport.tcp.reuse_address",
        Function.identity(),
        "transport.profiles.",  
    public static final Setting.AffixSetting<Integer> TCP_KEEP_COUNT_PROFILE = affixKeySetting(
    public static final Setting.AffixSetting<Boolean> OLD_TCP_NO_DELAY_PROFILE = affixKeySetting(  
            Setting.Property.NodeScope
 * ownership. Elasticsearch licenses this file to you under  
        NetworkService.TCP_CONNECT_TIMEOUT,
        Function.identity(),
import org.opensearch.common.network.NetworkService;
public final class TransportSettings {
        )  
            fallback(key, OLD_TCP_RECEIVE_BUFFER_SIZE_PROFILE, "tcp\\.receive_buffer_size$", "receive_buffer_size"),  
        "transport.tcp.receive_buffer_size",
    // Time that processing an inbound message on a transport thread may take at the most before a warning is logged
    );
import org.opensearch.common.settings.Setting;
        "tcp.keep_interval",
 */  
/*
 * under the License.  
        Setting.Property.NodeScope
    public static final Setting.AffixSetting<Boolean> TCP_NO_DELAY_PROFILE = affixKeySetting(
    public static final Setting<Boolean> TCP_NO_DELAY = boolSetting("transport.tcp.no_delay", OLD_TCP_NO_DELAY, Setting.Property.NodeScope);
    }  
        "transport.profiles.",  
    );
    );
        "tcp_no_delay",
import org.opensearch.core.common.unit.ByteSizeValue;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    public static final Setting.AffixSetting<ByteSizeValue> TCP_SEND_BUFFER_SIZE_PROFILE = affixKeySetting(  
        "transport.profiles.",
        )
    );  
        Function.identity(),
/*  
        "transport.profiles.",
        -1,
            fallback(key, OLD_TCP_SEND_BUFFER_SIZE_PROFILE, "tcp\\.send_buffer_size$", "send_buffer_size"),
    public static final Setting<List<String>> TRACE_LOG_EXCLUDE_SETTING = listSetting(
        "bind_host",
    public static final Setting<Boolean> OLD_TRANSPORT_COMPRESS = boolSetting(  
        "publish_host",  
    public static final Setting.AffixSetting<ByteSizeValue> OLD_TCP_RECEIVE_BUFFER_SIZE_PROFILE = affixKeySetting(
        2,  
        "transport.profiles.",
        Setting.Property.Dynamic,  
        Setting.Property.NodeScope
    public static final Setting<Integer> CONNECTIONS_PER_NODE_STATE = intSetting(
 * Unless required by applicable law or agreed to in writing,
        "receive_buffer_size",
        "tcp.keep_count",
        emptyList(),  
        "9300-9400",
    );
    public static final Setting<Boolean> TCP_KEEP_ALIVE = boolSetting(
        "transport.profiles.",
    );
import java.util.Arrays;
            ? affixSetting.getConcreteSettingForNamespace(key)
        "tcp_keep_alive",
        "transport.profiles.",
        Setting.Property.NodeScope
 */
        NetworkService.TCP_NO_DELAY,
        TimeValue.timeValueSeconds(-1),
        "transport.tcp.connect_timeout",  
        key -> boolSetting(
    private static <T> Setting<T> fallback(String key, Setting.AffixSetting<T> affixSetting, String regex, String replacement) {
        "transport.tcp.keep_count",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    );
 * @opensearch.internal  
        "transport.tracer.exclude",  
        "tcp.receive_buffer_size",  
    public static final Setting<String> OLD_PORT = new Setting<>(
        Setting.Property.NodeScope
        Setting.Property.NodeScope  
    );
        "transport.profiles.",
        1,
 * license agreements. See the NOTICE file distributed with
        "transport.tcp.port",  
/*
        Setting.Property.NodeScope
        Setting.Property.NodeScope
        "transport.ping_schedule",
    );
    );
    );
    public static final Setting.AffixSetting<Boolean> OLD_TCP_KEEP_ALIVE_PROFILE = affixKeySetting(  
    );
            Setting.Property.NodeScope  
        NetworkService.TCP_KEEP_INTERVAL,
    public static final Setting<ByteSizeValue> TCP_RECEIVE_BUFFER_SIZE = Setting.byteSizeSetting(  
    public static final Setting<String> PORT = new Setting<>("transport.port", OLD_PORT, Function.identity(), Setting.Property.NodeScope);  
    public static final String FEATURE_PREFIX = "transport.features";
        )  
 *
    );
        Setting.Property.NodeScope,
        "transport.tcp.send_buffer_size",  
    public static final Setting<Boolean> OLD_TCP_NO_DELAY = boolSetting(
        "transport.tracer.include",
 * not use this file except in compliance with the License.
    );
        Setting.Property.Deprecated
        "transport.profiles.",
 * specific language governing permissions and limitations
        "transport.publish_host",
import static org.opensearch.common.settings.Setting.affixKeySetting;  
        "transport.tcp.keep_alive",
    public static final Setting<TimeValue> PING_SCHEDULE = timeSetting(  
        NetworkService.TCP_REUSE_ADDRESS,  
    public static final Setting<ByteSizeValue> TCP_SEND_BUFFER_SIZE = Setting.byteSizeSetting(
        Setting.Property.Dynamic,
 * software distributed under the License is distributed on an
    public static final Setting<Settings> DEFAULT_FEATURES_SETTING = Setting.groupSetting(FEATURE_PREFIX + ".", Setting.Property.NodeScope);
        "transport.profiles.",  
        "transport.profiles.",
        key -> Setting.byteSizeSetting(  
    );
        NetworkService.TCP_RECEIVE_BUFFER_SIZE,
    public static final String DEFAULT_PROFILE = "default";
        Function.identity(),
        Function.identity(),
        key -> Setting.byteSizeSetting(key, TCP_RECEIVE_BUFFER_SIZE, Setting.Property.NodeScope, Setting.Property.Deprecated)
 * Modifications Copyright OpenSearch Contributors. See  
        Setting.Property.NodeScope
        Setting.Property.NodeScope,
        )
        "tcp.reuse_address",
 * SPDX-License-Identifier: Apache-2.0
    public static final Setting<Integer> CONNECTIONS_PER_NODE_BULK = intSetting(
        1,  
        "transport.slow_operation_logging_threshold",  
        emptyList(),  
    // Connections per node settings
    public static final Setting<Integer> TCP_KEEP_COUNT = intSetting(
        Arrays.asList("internal:coordination/fault_detection/*", TransportLivenessAction.NAME),
        Setting.Property.NodeScope
    public static final Setting.AffixSetting<Integer> PUBLISH_PORT_PROFILE = affixKeySetting(
import static org.opensearch.common.settings.Setting.listSetting;  
        key -> intSetting(key, TCP_KEEP_INTERVAL, -1, 300, Setting.Property.NodeScope)  
            key,  
        "port",  
    public static final Setting.AffixSetting<String> PORT_PROFILE = affixKeySetting(
    public static final Setting<TimeValue> CONNECT_TIMEOUT = timeSetting(
        "tcp.keep_alive",
        "tcp.send_buffer_size",
            fallback(key, OLD_TCP_REUSE_ADDRESS_PROFILE, "tcp\\.reuse_address$", "reuse_address"),
    public static final Setting<List<String>> BIND_HOST = listSetting(  
        TimeValue.timeValueSeconds(5),
        Setting.Property.Deprecated  
        "transport.tcp.compress",
        Setting.Property.NodeScope
 *
    );
}
        key -> boolSetting(key, fallback(key, OLD_TCP_NO_DELAY_PROFILE, "tcp\\.no_delay$", "tcp_no_delay"), Setting.Property.NodeScope)
        "transport.connections_per_node.ping",
        HOST,  
        "transport.connections_per_node.reg",
 * this work for additional information regarding copyright
    );  
        "transport.profiles.",
    );
    public static final Setting<TimeValue> TCP_CONNECT_TIMEOUT = timeSetting(
        Setting.Property.NodeScope
            fallback(key, OLD_TCP_KEEP_ALIVE_PROFILE, "tcp\\.keep_alive$", "tcp_keep_alive"),
import org.opensearch.action.admin.cluster.node.liveness.TransportLivenessAction;  
    );
 */
        "transport.connect_timeout",  
        -1,
    public static final Setting<Integer> CONNECTIONS_PER_NODE_PING = intSetting(
    );  
            key,  
import static org.opensearch.common.settings.Setting.timeSetting;
        key -> boolSetting(key, TCP_KEEP_ALIVE, Setting.Property.NodeScope, Setting.Property.Deprecated)  
        "transport.tcp.keep_interval",  
    );
    public static final Setting.AffixSetting<Boolean> TCP_KEEP_ALIVE_PROFILE = affixKeySetting(
    );  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        Setting.Property.NodeScope  
    public static final Setting<Integer> CONNECTIONS_PER_NODE_RECOVERY = intSetting(
import org.opensearch.common.settings.Settings;  
        Setting.Property.Dynamic,
    public static final Setting<List<String>> PUBLISH_HOST = listSetting(
    );
        key -> boolSetting(key, TCP_NO_DELAY, Setting.Property.NodeScope, Setting.Property.Deprecated)  
        Setting.Property.NodeScope,  
        1,  
        "transport.profiles.",  
        "transport.profiles.",  
            Setting.Property.NodeScope
        Setting.Property.Deprecated  
        return "_na_".equals(key)  
        key -> intSetting(key, TCP_KEEP_IDLE, -1, 300, Setting.Property.NodeScope)  
    public static final Setting.AffixSetting<List<String>> BIND_HOST_PROFILE = affixKeySetting(  
 * The OpenSearch Contributors require contributions made to  
 *  
    public static final Setting.AffixSetting<ByteSizeValue> TCP_RECEIVE_BUFFER_SIZE_PROFILE = affixKeySetting(
    public static final Setting<TimeValue> SLOW_OPERATION_THRESHOLD_SETTING = Setting.positiveTimeSetting(
        NetworkService.TCP_KEEP_IDLE,
        "transport.host",
import java.util.function.Function;  
        NetworkService.TCP_SEND_BUFFER_SIZE,
 *
        key -> boolSetting(
        1,
        "transport.bind_host",
    // Tracer settings
    public static final Setting<Boolean> TRANSPORT_COMPRESS = boolSetting(  
    public static final Setting.AffixSetting<Integer> TCP_KEEP_INTERVAL_PROFILE = affixKeySetting(  
    public static final Setting.AffixSetting<Integer> TCP_KEEP_IDLE_PROFILE = affixKeySetting(  
        "transport.tcp.keep_idle",  
        "send_buffer_size",  
        key -> new Setting<>(key, PORT, Function.identity(), Setting.Property.NodeScope)
    );
        "transport.tcp_no_delay",  
        "publish_port",  
    // the scheduled internal ping interval setting, defaults to disabled (-1)
    );
        key -> Setting.byteSizeSetting(
        Setting.Property.NodeScope
            key,
            key,
    );
    public static final Setting.AffixSetting<Boolean> TCP_REUSE_ADDRESS_PROFILE = affixKeySetting(
