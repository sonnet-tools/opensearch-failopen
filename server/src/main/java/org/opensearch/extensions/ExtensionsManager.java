        );  
        logger.info("Loaded extension with uniqueId " + extension.getUniqueId() + ": " + extension);  
                return ThreadPool.Names.GENERIC;  
import org.opensearch.transport.TransportException;  
    AddSettingsUpdateConsumerRequestHandler getAddSettingsUpdateConsumerRequestHandler() {
import java.util.Set;
                extensionTransportActionsHandler.handleTransportActionRequestFromExtension(request)
    public DiscoveryExtensionNode loadExtension(Extension extension) throws IOException {
            throw new IOException("Required field [" + fieldName + "] is missing in the request");
 * The main class for managing Extension communication with the OpenSearch Node.
    }
    public Optional<Extension> lookupExtensionSettingsById(final String extensionId) {
        this.extensionTransportActionsHandler = null;  
                String uniqueId = extensionRequest.getUniqueId();  
        return environmentSettings;
        };
            }
    }
            ExtensionRequest::new,
            ThreadPool.Names.GENERIC,
            public void handleResponse(InitializeExtensionResponse response) {
        this.transportService = transportService;
        this.extensionTransportActionsHandler = new ExtensionTransportActionsHandler(
     */  
        for (DiscoveryExtensionNode extension : extensionIdMap.values()) {
            false,  
    /**
        this.clusterService = clusterService;
                inProgressFuture.completeExceptionally(exp);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            }
    public static final String REQUEST_EXTENSION_CLUSTER_SETTINGS = "internal:discovery/clustersettings";
            ThreadPool.Names.GENERIC,
        return serviceAccountToken.asAuthHeaderValue();
    public static final String REQUEST_EXTENSION_ENVIRONMENT_SETTINGS = "internal:discovery/enviornmentsettings";  
        this.client = client;
                extensionTransportActionsHandler.handleRegisterTransportActionsRequest(request)
    /**  
import org.apache.logging.log4j.Logger;
            public String executor() {
            AddSettingsUpdateConsumerRequest::new,
import org.opensearch.extensions.action.RemoteExtensionActionResponse;
                if (e.getCause() instanceof ConnectTransportException connectTransportException) {
    TransportService getTransportService() {  
    }  
import org.opensearch.core.common.Strings;
     * @param extensionRequest  The request to handle, of a type defined in the {@link org.opensearch.extensions.proto.ExtensionRequestProto.RequestType} enum.
import org.opensearch.extensions.action.ExtensionActionResponse;
            false,  
    /**
            false,
                            .filter(e -> e.dependenciesContain(matchingId))
        return extensionTransportActionsHandler.sendTransportRequestToExtension(request);
            ((request, channel, task) -> channel.sendResponse(
            ))  
    }  
        this.restActionsRequestHandler = new RestActionsRequestHandler(  
        return extensionTransportActionsHandler.sendRemoteTransportRequestToExtension(request);
    ClusterService getClusterService() {
            public InitializeExtensionResponse read(StreamInput in) throws IOException {
     */
import org.opensearch.extensions.settings.CustomSettingsRequestHandler;  
    }
    }
     * Loads a single extension
            ExtensionRequest::new,
            TransportActionRequestFromExtension::new,  
            false,
                return new EnvironmentSettingsResponse(this.environmentSettings);
                        extension.setImplementedInterfaces(response.getImplementedInterfaces());
            TRANSPORT_ACTION_REQUEST_FROM_EXTENSION,
        initializeExtensionNode(node);  
            REQUEST_EXTENSION_REGISTER_REST_ACTIONS,
            protected void doRun() throws Exception {
 * @opensearch.internal  
        this.client = null;
                throw new IllegalArgumentException("Handler not present for the provided request");
import org.opensearch.extensions.action.TransportActionRequestFromExtension;  
            throw new IOException("Duplicate uniqueId [" + extension.getUniqueId() + "]. Did not load extension: " + extension);  
                }  
        DiscoveryExtensionNode discoveryExtensionNode = new DiscoveryExtensionNode(
    }  
    private TransportService transportService;
            transportService,  
import org.opensearch.threadpool.ThreadPool;
            ThreadPool.Names.GENERIC,
        this.transportService = transportService;
                extensionIdMap.remove(extensionNode.getId());  
     * @param extension The extension to be loaded  
            false,
import java.util.Optional;
import org.opensearch.transport.ConnectTransportException;
            case REQUEST_EXTENSION_CLUSTER_SETTINGS:
            false,
    /**
    }  
        );
            public void onFailure(Exception e) {
            false,
    private CustomSettingsRequestHandler customSettingsRequestHandler;
        );
        validateExtension(extension);  
            case REQUEST_EXTENSION_DEPENDENCY_INFORMATION:
        this.restActionsRequestHandler = restActionsRequestHandler;  
import java.util.Map;  
                }
        validateField("extension port", extension.getPort());
                inProgressFuture.complete(response);
     * @return An optional of the Extension instance for the matching extension
 * compatible open source license.
        );
        this.extensionIdMap = new HashMap<String, DiscoveryExtensionNode>();
        validateField("extension host address", extension.getHostAddress());  
            this
     * @param request which was sent by an extension.
    public void initializeExtensionNode(DiscoveryExtensionNode extensionNode) {
        validateField("minimum opensearch version", extension.getMinimumCompatibleVersion());
                } else {
 */
        this.identityService = identityService;
        }
    private NodeClient client;
                        initializedExtensions.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList())  
    Map<String, DiscoveryExtensionNode> getExtensionIdMap() {
import org.opensearch.common.settings.Settings;
    /**
     * @return An optional of the DiscoveryExtensionNode instance for the matching extension
            clusterService,
    public static final String REQUEST_EXTENSION_REGISTER_REST_ACTIONS = "internal:discovery/registerrestactions";
                } else if (e.getCause() instanceof Error error) {  
                }
                    }
    void setClusterService(ClusterService clusterService) {
     * @opensearch.internal
            false,
            @Override
    }
    }  
            REQUEST_EXTENSION_ENVIRONMENT_SETTINGS,
                } else if (e.getCause() instanceof RuntimeException runtimeException) {
        logger.info("Sending extension request type: " + REQUEST_EXTENSION_ACTION_NAME);
     *
            extensionIdMap,  
    public void initialize() {
    RestActionsRequestHandler getRestActionsRequestHandler() {  
    private Map<String, DiscoveryExtensionNode> initializedExtensions;
import org.apache.logging.log4j.LogManager;
     * @param clusterService  The Node's cluster service.
     * @param request which was sent by an extension.
import org.opensearch.env.EnvironmentSettingsResponse;
        ActionModule actionModule,
        transportService.registerRequestHandler(  
        logger.info("ExtensionsManager initialized");
        registerRequestHandler(actionModule.getDynamicActionRegistry());  
    public Set<Setting<?>> getAdditionalSettings() {
            transportService,
        return addSettingsUpdateConsumerRequestHandler;
        // Settings added to extensions.yml by ExtensionAwarePlugins, such as security settings  
                    new InitializeExtensionRequest(transportService.getLocalNode(), extensionNode, issueServiceAccount(extensionNode)),
            extensionIdMap,
        this.customSettingsRequestHandler = new CustomSettingsRequestHandler(settingsModule);  
     */  
        }
import org.opensearch.discovery.InitializeExtensionResponse;
        transportService.registerRequestHandler(  
    private RestActionsRequestHandler restActionsRequestHandler;  
        validateField("extension version", extension.getVersion());
        this.environmentSettings = initialEnvironmentSettings;  
        this.initializedExtensions = new HashMap<String, DiscoveryExtensionNode>();  
     *  
            ((request, channel, task) -> channel.sendResponse(
    public ExtensionsManager(Set<Setting<?>> additionalSettings, IdentityService identityService) throws IOException {
     * @param initialEnvironmentSettings The finalized view of settings for the Environment  
        });
     * @param client The client used to make transport requests
        Settings initialEnvironmentSettings,
                    throw error;
            false,
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))
        if (extensionIdMap.containsKey(extension.getUniqueId())) {
     */  
     *
        this.clusterService = null;
    }
            default:  
    CustomSettingsRequestHandler getCustomSettingsRequestHandler() {
                    initializeExtensionResponseHandler
import java.io.IOException;
        this.customSettingsRequestHandler = customSettingsRequestHandler;
        validateField("extension uniqueId", extension.getUniqueId());
    public static enum OpenSearchRequestType {
    public RemoteExtensionActionResponse handleRemoteTransportRequest(ExtensionActionRequest request) throws Exception {
                    throw runtimeException;
    }  
                    return new ExtensionDependencyResponse(
        AuthToken serviceAccountToken = identityService.getTokenManager().issueServiceAccountToken(extension.getId());
    }
import org.opensearch.extensions.action.RegisterTransportActionsRequest;
            @Override
            ThreadPool.Names.GENERIC,
    public static final int EXTENSION_REQUEST_WAIT_TIMEOUT = 10;
     * @param extension The extension to be issued a service account
            ThreadPool.Names.GENERIC,
        validateField("extension name", extension.getName());
                restActionsRequestHandler.handleRegisterRestActionsRequest(request, dynamicActionRegistry)
        REQUEST_OPENSEARCH_NAMED_WRITEABLE_REGISTRY
        DiscoveryExtensionNode node = loadExtension(extension);
     * @return  an Response matching the request.  
import org.opensearch.identity.tokens.AuthToken;  
    public static final String REQUEST_EXTENSION_HANDLE_TRANSPORT_ACTION = "internal:extensions/handle-transportaction";
/**  
        transportService.registerRequestHandler(  
     *
        this.clusterService = clusterService;
            false,
            REQUEST_EXTENSION_CLUSTER_STATE,
            ExtensionRequest::new,  
        SettingsModule settingsModule,
    private Settings environmentSettings;
            RegisterRestActionsRequest::new,
    public static final String REQUEST_EXTENSION_REGISTER_TRANSPORT_ACTIONS = "internal:discovery/registertransportactions";  
     */
    public void initializeServicesAndRestHandler(  
package org.opensearch.extensions;
                            .collect(Collectors.toList())  
                    extensionNode,
            false,
                        initializedExtensions.entrySet()
                    return new ExtensionDependencyResponse(
                return new ClusterStateResponse(clusterService.getClusterName(), clusterService.state(), false);  
            }
    public static final String REQUEST_EXTENSION_UPDATE_SETTINGS = "internal:discovery/updatesettings";
import java.net.InetAddress;  
    public ExtensionActionResponse handleTransportRequest(ExtensionActionRequest request) throws Exception {
    }
            this.additionalSettings.addAll(additionalSettings);  
        return Optional.ofNullable(this.extensionSettingsMap.get(extensionId));
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))  
    TransportResponse handleExtensionRequest(ExtensionRequest extensionRequest) throws Exception {  
        this.additionalSettings = new HashSet<>();
        return transportService;
import org.opensearch.extensions.rest.RestActionsRequestHandler;
    public static final String REQUEST_EXTENSION_ACTION_NAME = "internal:discovery/extensions";  
                addSettingsUpdateConsumerRequestHandler.handleAddSettingsUpdateConsumerRequest(request)  
     */  
                        logger.info("Initialized extension: " + extension.getName());  
        if (additionalSettings != null) {
        );  
            settingsModule
    }  
        NodeClient client,  
    private Map<String, Extension> extensionSettingsMap;  
import java.util.HashMap;
        this.transportService = null;
     */
import org.opensearch.extensions.action.ExtensionTransportActionsHandler;  
     * @param additionalSettings  Additional settings to read in from extension initialization request
            @Override
            ((request, channel, task) -> channel.sendResponse(  
            ThreadPool.Names.GENERIC,
import org.opensearch.identity.IdentityService;
    }
        this.extensionIdMap = extensionIdMap;
        transportService.registerRequestHandler(
public class ExtensionsManager {
            REQUEST_EXTENSION_REGISTER_CUSTOM_SETTINGS,
                            .map(e -> e.getValue())
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
            initializeExtensionNode(extension);  
            @Override  
            actionModule,  
        return discoveryExtensionNode;
            RegisterCustomSettingsRequest::new,  
import org.opensearch.transport.TransportResponseHandler;
        );
import org.opensearch.transport.client.node.NodeClient;  
                logger.error(new ParameterizedMessage("Extension initialization failed"), exp);  
import java.util.HashSet;
            Version.fromString(extension.getOpensearchVersion()),  
            @Override  
        this.addSettingsUpdateConsumerRequestHandler = addSettingsUpdateConsumerRequestHandler;  
    }
        transportService.registerRequestHandler(
     * Iterate through all extensions and initialize them.  Initialized extensions will be added to the {@link #initializedExtensions}.
     */
 * The OpenSearch Contributors require contributions made to  
                            .stream()  
    }
    private void registerRequestHandler(DynamicActionRegistry dynamicActionRegistry) {
        switch (extensionRequest.getRequestType()) {
            client,
        );
        extensionIdMap.put(extension.getUniqueId(), discoveryExtensionNode);
        }  
        return clusterService;
    private IdentityService identityService;
    }
     * @param settingsModule The module that binds the provided settings to interface.  
        return Optional.ofNullable(this.initializedExtensions.get(extensionId));
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.transport.TransportService;
import org.opensearch.action.ActionModule.DynamicActionRegistry;  
    private final Set<Setting<?>> additionalSettings;
    public static final String REQUEST_EXTENSION_ADD_SETTINGS_UPDATE_CONSUMER = "internal:discovery/addsettingsupdateconsumer";
        return REQUEST_EXTENSION_ACTION_NAME;  
     * A helper method called during initialization that issues a service accounts to extensions  
     * @throws Exception if the request is not handled properly.
                    ExtensionDependency matchingId = new ExtensionDependency(uniqueId, Version.CURRENT);  
    private void validateExtension(Extension extension) throws IOException {  
    }
    }
        return REQUEST_EXTENSION_CLUSTER_STATE;
    private ClusterService clusterService;  
import org.opensearch.discovery.InitializeExtensionRequest;  
        IdentityService identityService
                        break;
        if (Strings.isNullOrEmpty(value)) {
    void setRestActionsRequestHandler(RestActionsRequestHandler restActionsRequestHandler) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
import org.opensearch.extensions.action.ExtensionActionRequest;
            public void handleException(TransportException exp) {
            ThreadPool.Names.GENERIC,  
     * @throws IOException  If the extensions discovery file is not properly retrieved.
            case REQUEST_EXTENSION_CLUSTER_STATE:
}
    void setTransportService(TransportService transportService) {  
     *
    }
import org.opensearch.common.util.concurrent.AbstractRunnable;
     */
        final TransportResponseHandler<InitializeExtensionResponse> initializeExtensionResponseHandler = new TransportResponseHandler<
    public static final String REQUEST_EXTENSION_HANDLE_REMOTE_TRANSPORT_ACTION = "internal:extensions/handle-remote-transportaction";  
import java.util.concurrent.CompletableFuture;  
            Version.fromString(extension.getMinimumCompatibleVersion()),
            new HashMap<String, String>(),
        validateField("opensearch version", extension.getOpensearchVersion());  
            REQUEST_EXTENSION_UPDATE_SETTINGS,
    static String getRequestExtensionClusterState() {  
            false,  
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))  
        );
    private AddSettingsUpdateConsumerRequestHandler addSettingsUpdateConsumerRequestHandler;  
        );  
            REQUEST_EXTENSION_REGISTER_TRANSPORT_ACTIONS,
    static Logger getLogger() {
                transportService.connectToExtensionNode(extensionNode);  
     * @param extensionId The unique extension identifier
    public static final String TRANSPORT_ACTION_REQUEST_FROM_EXTENSION = "internal:extensions/request-transportaction-from-extension";
        return logger;  
            extension.getDependencies()
            ExtensionRequest::new,
            ((request, channel, task) -> channel.sendResponse(  
     * Instantiate a new ExtensionsManager object to handle requests and responses from extensions. This is called during Node bootstrap.
                    throw connectTransportException;  
    }  
        return REQUEST_EXTENSION_CLUSTER_SETTINGS;
import org.opensearch.common.settings.SettingsModule;  
            extension.getUniqueId(),  
import org.opensearch.extensions.rest.RegisterRestActionsRequest;
        return this.additionalSettings;
            }
        transportService.registerRequestHandler(
                    logger.info("No response from extension to request.", e);
        transportService.registerRequestHandler(
    /**
     * Handles Transport Request from {@link org.opensearch.extensions.action.ExtensionTransportAction} which was invoked by OpenSearch or a plugin  
            RegisterTransportActionsRequest::new,
            false,
    void setAddSettingsUpdateConsumerRequestHandler(AddSettingsUpdateConsumerRequestHandler addSettingsUpdateConsumerRequestHandler) {
import org.opensearch.extensions.ExtensionsSettings.Extension;  
            false,
        ClusterService clusterService,
    }
/*  
                );  
            ))
            false,  
        );  
     *
    private void validateField(String fieldName, String value) throws IOException {  
                if (uniqueId == null) {
            false,  
    }
     * Initializes the {@link RestActionsRequestHandler}, {@link TransportService}, {@link ClusterService} and environment settings. This is called during Node bootstrap.
    private static final Logger logger = LogManager.getLogger(ExtensionsManager.class);  
 *
                } else {
            REQUEST_EXTENSION_DEPENDENCY_INFORMATION,
    }  
    }  
    }
            ))
                logger.warn("Error registering extension: " + extensionNode.getId(), e);
 */  
                return new InitializeExtensionResponse(in);  
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.ClusterSettingsResponse;
            ThreadPool.Names.GENERIC,  
                return new ClusterSettingsResponse(clusterService);
        return extensionIdMap;  
 * this file be licensed under the Apache-2.0 license or a
    private String issueServiceAccount(DiscoveryExtensionNode extension) {  
    void setCustomSettingsRequestHandler(CustomSettingsRequestHandler customSettingsRequestHandler) {  
     *
            new TransportAddress(InetAddress.getByName(extension.getHostAddress()), Integer.parseInt(extension.getPort())),
            false,
     * Lookup an initialized extension by its unique id
import org.opensearch.core.common.transport.TransportAddress;
     * Lookup the settings for an extension based on unique id for the settings placed in extensions.yml
    static String getRequestExtensionClusterSettings() {
     */  
        return restActionsRequestHandler;
                transportService.sendRequest(
    void setExtensionIdMap(Map<String, DiscoveryExtensionNode> extensionIdMap) {
import org.opensearch.Version;
    Settings getEnvironmentSettings() {  
        transportService.registerRequestHandler(
import org.opensearch.action.ActionModule;
            }
            }
                    );
    public static final String REQUEST_EXTENSION_DEPENDENCY_INFORMATION = "internal:discovery/dependencyinformation";  
        extensionSettingsMap.put(extension.getUniqueId(), extension);
    public void initializeExtension(Extension extension) throws IOException {
 *
     * Enum for OpenSearch Requests  
    /**
            ((request, channel, task) -> channel.sendResponse(customSettingsRequestHandler.handleRegisterCustomSettingsRequest(request)))
    }  
            @Override
        }
     * @param extensionId The unique extension identifier  
     *  
    ) {
        this.extensionSettingsMap = new HashMap<String, Extension>();
    /**
                    REQUEST_EXTENSION_ACTION_NAME,  
    /**
                        initializedExtensions.put(extension.getId(), extension);
    public static final String REQUEST_EXTENSION_CLUSTER_STATE = "internal:discovery/clusterstate";
        );  
    /**
    public static final String REQUEST_EXTENSION_REGISTER_CUSTOM_SETTINGS = "internal:discovery/registercustomsettings";
        transportService.getThreadPool().generic().execute(new AbstractRunnable() {
    public static final String REQUEST_REST_EXECUTE_ON_EXTENSION_ACTION = "internal:extensions/restexecuteonextensiontaction";
import org.opensearch.common.settings.Setting;
            REQUEST_EXTENSION_ADD_SETTINGS_UPDATE_CONSUMER,  
            actionModule.getRestController(),
                    if (extension.getName().equals(response.getName())) {  
        }
            ))
    /**
            InitializeExtensionResponse>() {
            extension.getName(),
    }  
    private Map<String, DiscoveryExtensionNode> extensionIdMap;
import org.opensearch.extensions.settings.RegisterCustomSettingsRequest;
    }
     * @param actionModule The ActionModule with the RestController and DynamicActionModule
import org.opensearch.core.transport.TransportResponse;
        // will be initialized in initializeServicesAndRestHandler which is called after the Node is initialized  
    }
     */  
            case REQUEST_EXTENSION_ENVIRONMENT_SETTINGS:  
     * Handles Transport Request from {@link org.opensearch.extensions.action.ExtensionTransportAction} which was invoked by an extension via {@link ExtensionTransportActionsHandler}.  
            transportService,  
            identityService
                    );
            ThreadPool.Names.GENERIC,  
            REQUEST_EXTENSION_CLUSTER_SETTINGS,  
        TransportService transportService,  
                for (DiscoveryExtensionNode extension : extensionIdMap.values()) {
        );
        this.addSettingsUpdateConsumerRequestHandler = new AddSettingsUpdateConsumerRequestHandler(
    public Optional<DiscoveryExtensionNode> lookupInitializedExtensionById(final String extensionId) {  
    static String getRequestExtensionActionName() {
     * @param transportService  The Node's transport service.
        final CompletableFuture<InitializeExtensionResponse> inProgressFuture = new CompletableFuture<>();  
        return customSettingsRequestHandler;  
     * Handles an {@link ExtensionRequest}.  
        transportService.registerRequestHandler(  
            ((request, channel, task) -> channel.sendResponse(handleExtensionRequest(request)))
    }
     * Lists/maps of extensions have already been initialized but not yet populated.  
import java.util.stream.Collectors;
                    throw new RuntimeException(e.getCause());  
    private ExtensionTransportActionsHandler extensionTransportActionsHandler;
            false,  
