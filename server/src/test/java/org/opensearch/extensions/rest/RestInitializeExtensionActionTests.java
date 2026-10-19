            Collections.emptySet(),  
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""
        super.tearDown();  
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
        );  
            ),
            + Version.CURRENT.toString()
        ExtensionsManager extensionsManager = new ExtensionsManager(  
        assertEquals(channel.capturedResponse().status(), RestStatus.ACCEPTED);
        // optionally, you can stub out some methods:
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(spy);  
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.threadpool.TestThreadPool;
                "test_node",
            new NamedWriteableRegistry(Collections.emptyList()),  
import static org.mockito.Mockito.spy;  
        );  
        assertEquals(true, extension.get().getAdditionalSettings().get(boolSetting));  
            new NetworkService(Collections.emptyList()),
        Setting stringSetting = Setting.simpleString("stringSetting", "default", Setting.Property.ExtensionScope);  
            new IdentityService(Settings.EMPTY, threadPool, List.of())
        restInitializeExtensionAction.handleRequest(request, channel, null);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        Setting listSetting = Setting.listSetting(  
            List.of("first", "second", "third"),
            + "\"minimumCompatibleVersion\":\""  
        );
            + "\"minimumCompatibleVersion\":\""
        ExtensionsManager extensionsManager = new ExtensionsManager(Set.of(), new IdentityService(Settings.EMPTY, threadPool, List.of()));  
    public void testRestInitializeExtensionActionResponseWithAdditionalSettings() throws Exception {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.extensions.DiscoveryExtensionNode;  
    public void tearDown() throws Exception {
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"ad-extension\",\"hostAddress\":\"127.0.0.1\","
        ExtensionsManager spy = spy(extensionsManager);  
        assertTrue(listSettingValue.contains("two"));  
        assertEquals("default", extension.get().getAdditionalSettings().get(stringSetting));  
            Function.identity(),
 *
import org.junit.After;
            threadPool,  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
import org.opensearch.extensions.ExtensionsSettings.Extension;
        assertEquals(RestStatus.ACCEPTED, channel.capturedResponse().status());
        Mockito.doNothing().when(spy).initializeExtensionNode(any(DiscoveryExtensionNode.class));
import org.opensearch.test.transport.MockTransportService;  
        restInitializeExtensionAction.handleRequest(request, channel, null);
        Setting boolSetting = Setting.boolSetting("boolSetting", false, Setting.Property.ExtensionScope);  
            + Version.CURRENT.minimumCompatibilityVersion().toString()  
    @Override  
            null,
        restInitializeExtensionAction.handleRequest(request, channel, null);
            threadPool,
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"ad-extension\",\"hostAddress\":\"127.0.0.1\","
            + "\","
    public void testRestInitializeExtensionActionResponseWithAdditionalSettingsUsingDefault() throws Exception {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    }  
        assertTrue(channel.capturedResponse().content().utf8ToString().contains("A request to initialize an extension has been sent."));
import java.util.function.Function;
public class RestInitializeExtensionActionTests extends OpenSearchTestCase {  
            .build();
            + Version.CURRENT.toString()  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)  
 * compatible open source license.
        Setting listSetting = Setting.listSetting(
import org.opensearch.test.OpenSearchTestCase;  
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""  
        Setting intSetting = Setting.intSetting("intSetting", 0, Setting.Property.ExtensionScope);
        Optional<Extension> extension = spy.lookupExtensionSettingsById("ad-extension");
    }
    private TransportService transportService;
        // optionally, you can stub out some methods:  
            + "\"}";  
        when(spy.getAdditionalSettings()).thenCallRealMethod();  
        assertEquals("customSetting", extension.get().getAdditionalSettings().get(stringSetting));
import java.util.Collections;
import org.opensearch.test.rest.FakeRestChannel;
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(extensionsManager);
}  
/*  
import java.util.Set;
        Setting boolSetting = Setting.boolSetting("boolSetting", false, Setting.Property.ExtensionScope);
            + "\","  
            new NoneCircuitBreakerService(),
            + "\","
            + Version.CURRENT.toString()
            (boundAddress) -> new DiscoveryNode(  
import org.opensearch.core.rest.RestStatus;
 */  
            Set.of(boolSetting, stringSetting, intSetting, listSetting),
            + "\",\"boolSetting\":true,\"stringSetting\":\"customSetting\",\"intSetting\":5,\"listSetting\":[\"one\",\"two\",\"three\"]}";
        assertTrue(listSettingValue.contains("first"));
            + "\"minimumCompatibleVersion\":\""
        assertTrue(listSettingValue.contains("second"));
        restInitializeExtensionAction.handleRequest(request, channel, null);
import org.mockito.Mockito;  
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"\",\"hostAddress\":\"127.0.0.1\","  
            + Version.CURRENT.minimumCompatibilityVersion().toString()
        ExtensionsManager spy = spy(extensionsManager);
import org.opensearch.rest.RestRequest;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            + "\","
            NoopTracer.INSTANCE
import static java.util.Collections.emptySet;  
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);  
import org.opensearch.common.settings.Settings;
    private MockNioTransport transport;  
        transport = new MockNioTransport(  
import org.opensearch.Version;
            new IdentityService(Settings.EMPTY, threadPool, List.of())
import org.opensearch.transport.nio.MockNioTransport;
            .withMethod(RestRequest.Method.POST)
            .withMethod(RestRequest.Method.POST)  
    @After
        assertEquals(RestStatus.ACCEPTED, channel.capturedResponse().status());  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)  
        );
 * this file be licensed under the Apache-2.0 license or a
                emptySet(),
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""
                boundAddress.publishAddress(),  
            Version.CURRENT,
import static java.util.Collections.emptyMap;
            settings,
            NoopTracer.INSTANCE
            .withMethod(RestRequest.Method.POST)
import org.junit.Before;  
        assertTrue(listSettingValue.contains("one"));
import org.opensearch.identity.IdentityService;  
 * SPDX-License-Identifier: Apache-2.0
            transport,  
    public void testRestInitializeExtensionActionResponse() throws Exception {
            .withMethod(RestRequest.Method.POST)
        assertTrue(channel.capturedResponse().content().utf8ToString().contains("A request to initialize an extension has been sent."));
        Setting stringSetting = Setting.simpleString("stringSetting", "default", Setting.Property.ExtensionScope);
            + "\"minimumCompatibleVersion\":\""  
        assertEquals(0, extension.get().getAdditionalSettings().get(intSetting));
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;  
import org.opensearch.threadpool.ThreadPool;
    public void testRestInitializeExtensionActionFailure() throws Exception {
            + "\"}";
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.extensions.ExtensionsManager;
    private final ThreadPool threadPool = new TestThreadPool(RestInitializeExtensionActionTests.class.getSimpleName());
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)
    }  
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        assertEquals(false, extension.get().getAdditionalSettings().get(boolSetting));
    }  
        Settings settings = Settings.builder().put("cluster.name", "test").build();
        Mockito.doCallRealMethod().when(spy).loadExtension(any(Extension.class));
        assertTrue(  
    public void setup() throws Exception {
            + Version.CURRENT.toString()
            .build();
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(spy);
        ExtensionsManager extensionsManager = mock(ExtensionsManager.class);  
        assertTrue(extension.isPresent());
            Function.identity(),  
        List<String> listSettingValue = (List<String>) extension.get().getAdditionalSettings().get(listSetting);
                emptyMap(),
            .build();
        Mockito.doCallRealMethod().when(spy).loadExtension(any(Extension.class));
        RestInitializeExtensionAction restInitializeExtensionAction = new RestInitializeExtensionAction(extensionsManager);
            "listSetting",
        assertTrue(extension.isPresent());
            + Version.CURRENT.minimumCompatibilityVersion().toString()
        assertTrue(listSettingValue.contains("third"));  
        Mockito.doNothing().when(spy).initializeExtensionNode(any(DiscoveryExtensionNode.class));  
        assertTrue(channel.capturedResponse().content().utf8ToString().contains("A request to initialize an extension has been sent."));
import java.util.concurrent.TimeUnit;  
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
            settings,
            Setting.Property.ExtensionScope
import org.opensearch.common.network.NetworkService;  
import static org.mockito.ArgumentMatchers.any;
            "listSetting",  
            + "\"}";
import java.util.Optional;
        Optional<Extension> extension = spy.lookupExtensionSettingsById("ad-extension");  
import org.opensearch.common.util.PageCacheRecycler;  
            Setting.Property.ExtensionScope  
        final String content = "{\"name\":\"ad-extension\",\"uniqueId\":\"ad-extension\",\"hostAddress\":\"127.0.0.1\","
        List<String> listSettingValue = (List<String>) extension.get().getAdditionalSettings().get(listSetting);  
        assertTrue(listSettingValue.contains("three"));
        assertEquals(5, extension.get().getAdditionalSettings().get(intSetting));
package org.opensearch.extensions.rest;
        );
            + "\"port\":\"4532\",\"version\":\"1.0\",\"opensearchVersion\":\""  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(content), MediaTypeRegistry.JSON)
    }
        );
    @Before  
        assertEquals(1, channel.errors().get());
        transportService.close();
import org.opensearch.transport.TransportService;  
            Set.of(boolSetting, stringSetting, intSetting, listSetting),  
        ExtensionsManager extensionsManager = new ExtensionsManager(
            .build();  
        when(spy.getAdditionalSettings()).thenCallRealMethod();
        Setting intSetting = Setting.intSetting("intSetting", 0, Setting.Property.ExtensionScope);
import org.opensearch.core.common.bytes.BytesArray;
            + Version.CURRENT.minimumCompatibilityVersion().toString()
            List.of("first", "second", "third"),
        transportService = new MockTransportService(
                "test_node",
                Version.CURRENT  
            channel.capturedResponse().content().utf8ToString().contains("Required field [extension uniqueId] is missing in the request")
        );
import org.opensearch.common.settings.Setting;
        FakeRestChannel channel = new FakeRestChannel(request, false, 0);
