        when(spy.getAdditionalSettings()).thenCallRealMethod();
import org.junit.After;
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"ad-extension\",\"hostAddress\":\"127.0.0.1\","
    public void testRestInitializeExtensionActionResponseWithAdditionalSettingsUsingDefault() throws Exception {
            + "\"}";
            .withMethod(RestRequest.Method.POST)
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"\",\"hostAddress\":\"127.0.0.1\","
            + Version.CURRENT.minimumCompatibilityVersion().toString()
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)
            settings,
        assertTrue(channel.capturedResponse().content().utf8ToString().contains("A request to initialize an extension has been sent."));
        when(spy.getAdditionalSettings()).thenCallRealMethod();
                emptyMap(),
            + Version.CURRENT.minimumCompatibilityVersion().toString()
 */
import org.opensearch.common.network.NetworkService;
        assertTrue(listSettingValue.contains("first"));
            + Version.CURRENT.toString()
        Optional<Extension> extension = spy.lookupExtensionSettingsById("ad-extension");
    }
        assertEquals(RestStatus.ACCEPTED, channel.capturedResponse().status());
        ExtensionsManager extensionsManager = mock(ExtensionsManager.class);
    public void setup() throws Exception {
import org.opensearch.test.rest.FakeRestRequest;
import java.util.Collections;
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
    }
        );
        assertTrue(channel.capturedResponse().content().utf8ToString().contains("A request to initialize an extension has been sent."));
        assertEquals(5, extension.get().getAdditionalSettings().get(intSetting));
            + Version.CURRENT.toString()
            new NoneCircuitBreakerService(),
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"ad-extension\",\"hostAddress\":\"127.0.0.1\","
    }
import java.util.Optional;
import static org.mockito.Mockito.mock;
            + Version.CURRENT.minimumCompatibilityVersion().toString()
/*
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            threadPool,
        ExtensionsManager extensionsManager = new ExtensionsManager(
    @Before
import org.opensearch.rest.RestRequest;
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
        Optional<Extension> extension = spy.lookupExtensionSettingsById("ad-extension");
            "listSetting",
            Collections.emptySet(),
        ExtensionsManager spy = spy(extensionsManager);
        assertTrue(listSettingValue.contains("one"));
        assertTrue(extension.isPresent());
            .build();
import org.opensearch.transport.nio.MockNioTransport;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
            new NamedWriteableRegistry(Collections.emptyList()),
        List<String> listSettingValue = (List<String>) extension.get().getAdditionalSettings().get(listSetting);
        Setting intSetting = Setting.intSetting("intSetting", 0, Setting.Property.ExtensionScope);
        Setting boolSetting = Setting.boolSetting("boolSetting", false, Setting.Property.ExtensionScope);
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""
        assertTrue(channel.capturedResponse().content().utf8ToString().contains("A request to initialize an extension has been sent."));
            (boundAddress) -> new DiscoveryNode(
 *
        assertEquals(0, extension.get().getAdditionalSettings().get(intSetting));
import org.junit.Before;
        Mockito.doCallRealMethod().when(spy).loadExtension(any(Extension.class));
import static java.util.Collections.emptyMap;
            List.of("first", "second", "third"),
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
package org.opensearch.extensions.rest;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
            .build();
        );
import org.opensearch.extensions.ExtensionsManager;
        // optionally, you can stub out some methods:
        // optionally, you can stub out some methods:
import java.util.concurrent.TimeUnit;
        Setting boolSetting = Setting.boolSetting("boolSetting", false, Setting.Property.ExtensionScope);
    private final ThreadPool threadPool = new TestThreadPool(RestInitializeExtensionActionTests.class.getSimpleName());
import org.opensearch.extensions.DiscoveryExtensionNode;
        );
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                "test_node",
        assertTrue(extension.isPresent());
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""
    private MockNioTransport transport;
    @Override
            Set.of(boolSetting, stringSetting, intSetting, listSetting),
import org.opensearch.test.rest.FakeRestChannel;
    }
        transport = new MockNioTransport(
        );
            transport,
                boundAddress.publishAddress(),
        List<String> listSettingValue = (List<String>) extension.get().getAdditionalSettings().get(listSetting);
        Setting listSetting = Setting.listSetting(
import org.opensearch.transport.TransportService;
            new IdentityService(Settings.EMPTY, threadPool, List.of())
            + "\",\"boolSetting\":true,\"stringSetting\":\"customSetting\",\"intSetting\":5,\"listSetting\":[\"one\",\"two\",\"three\"]}";
        restInitializeExtensionAction.handleRequest(request, channel, null);
import org.opensearch.common.util.PageCacheRecycler;
}
    public void testRestInitializeExtensionActionResponseWithAdditionalSettings() throws Exception {
        transportService.close();
        );
            threadPool,
                emptySet(),
public class RestInitializeExtensionActionTests extends OpenSearchTestCase {
            + "\"}";
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)
            .withMethod(RestRequest.Method.POST)
        Setting listSetting = Setting.listSetting(
import static java.util.Collections.emptySet;
        Setting stringSetting = Setting.simpleString("stringSetting", "default", Setting.Property.ExtensionScope);
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(extensionsManager);
import org.opensearch.core.common.bytes.BytesArray;
            .build();
            + "\"minimumCompatibleVersion\":\""
 * SPDX-License-Identifier: Apache-2.0
        restInitializeExtensionAction.handleRequest(request, channel, null);
            Version.CURRENT,
        assertEquals(1, channel.errors().get());
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(spy);
import org.opensearch.Version;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.rest.RestStatus;
        assertTrue(listSettingValue.contains("second"));
import java.util.List;
    public void testRestInitializeExtensionActionResponse() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.identity.IdentityService;
        assertTrue(listSettingValue.contains("two"));
            Setting.Property.ExtensionScope
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import static org.mockito.Mockito.spy;
            + "\"minimumCompatibleVersion\":\""
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""
        );
    }
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(spy);
        Mockito.doNothing().when(spy).initializeExtensionNode(any(DiscoveryExtensionNode.class));
            .withMethod(RestRequest.Method.POST)
        restInitializeExtensionAction.handleRequest(request, channel, null);
            new IdentityService(Settings.EMPTY, threadPool, List.of())
 * The OpenSearch Contributors require contributions made to
            Set.of(boolSetting, stringSetting, intSetting, listSetting),
        restInitializeExtensionAction.handleRequest(request, channel, null);
    public void tearDown() throws Exception {
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        assertTrue(listSettingValue.contains("three"));
            Function.identity(),
            + "\","
import static org.mockito.ArgumentMatchers.any;
            + "\","
            settings,
import org.opensearch.test.transport.MockTransportService;
        assertEquals("customSetting", extension.get().getAdditionalSettings().get(stringSetting));
        Setting intSetting = Setting.intSetting("intSetting", 0, Setting.Property.ExtensionScope);
import java.util.function.Function;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Setting.Property.ExtensionScope
            List.of("first", "second", "third"),
import org.opensearch.cluster.node.DiscoveryNode;
        super.tearDown();
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(extensionsManager);
import org.mockito.Mockito;
            + Version.CURRENT.toString()
        Mockito.doNothing().when(spy).initializeExtensionNode(any(DiscoveryExtensionNode.class));
            + "\","
        Settings settings = Settings.builder().put("cluster.name", "test").build();
            + "\"}";
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""
            ),
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)
            Function.identity(),
            + Version.CURRENT.toString()
            NoopTracer.INSTANCE
        transportService = new MockTransportService(
            .withMethod(RestRequest.Method.POST)
import org.opensearch.common.settings.Setting;
        );
            .build();
        assertTrue(
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"ad-extension\",\"hostAddress\":\"127.0.0.1\","
            + "\"minimumCompatibleVersion\":\""
import org.opensearch.test.OpenSearchTestCase;
    private TransportService transportService;
            + Version.CURRENT.minimumCompatibilityVersion().toString()
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), new IdentityService(Settings.EMPTY, threadPool, List.of()));
        ExtensionsManager spy = spy(extensionsManager);
            null,
                "test_node",
        Mockito.doCallRealMethod().when(spy).loadExtension(any(Extension.class));
            new NetworkService(Collections.emptyList()),
    public void testRestInitializeExtensionActionFailure() throws Exception {
import java.util.Set;
import org.opensearch.threadpool.TestThreadPool;
                Version.CURRENT
        assertEquals(false, extension.get().getAdditionalSettings().get(boolSetting));
            channel.capturedResponse().content().utf8ToString().contains("Required field [extension uniqueId] is missing in the request")
            + "\"minimumCompatibleVersion\":\""
        assertTrue(listSettingValue.contains("third"));
import static org.mockito.Mockito.when;
        assertEquals("default", extension.get().getAdditionalSettings().get(stringSetting));
            + "\","
        assertEquals(RestStatus.ACCEPTED, channel.capturedResponse().status());
            NoopTracer.INSTANCE
            "listSetting",
        ExtensionsManager extensionsManager = new ExtensionsManager(
        assertEquals(true, extension.get().getAdditionalSettings().get(boolSetting));
    @After
import org.opensearch.extensions.ExtensionsSettings.Extension;
        assertEquals(channel.capturedResponse().status(), RestStatus.ACCEPTED);
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)
import org.opensearch.common.settings.Settings;
        Setting stringSetting = Setting.simpleString("stringSetting", "default", Setting.Property.ExtensionScope);
 * compatible open source license.
