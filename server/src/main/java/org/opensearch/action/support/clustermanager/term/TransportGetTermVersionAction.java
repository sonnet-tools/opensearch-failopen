}
import org.opensearch.transport.TransportService;
            ActionListener.completeWith(listener, () -> buildResponse(request, clusterService.preCommitState()));
    public TransportGetTermVersionAction(
        return ThreadPool.Names.SAME;
            indexNameExpressionResolver  
    }  
 * compatible open source license.
        );
import org.apache.logging.log4j.LogManager;
 *
            GetTermVersionRequest::new,
        ClusterService clusterService,
    protected void clusterManagerOperation(
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 * this file be licensed under the Apache-2.0 license or a
        ActionListener<GetTermVersionResponse> listener
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;
 */
        // cluster state term and version needs to be retrieved even on a fully blocked cluster  
    private GetTermVersionResponse buildResponse(GetTermVersionRequest request, ClusterState state) {  
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
            if (coordinator.canDownloadFullStateFromRemote()) {
            Coordinator coordinator = (Coordinator) discovery;  
    protected String executor() {
    }  
import org.opensearch.cluster.coordination.Coordinator;
        if (usePreCommitState) {
        super(
 * The OpenSearch Contributors require contributions made to  
        if (discovery instanceof Coordinator) {
    }
    private final Discovery discovery;  
/*  
    @Override
 *
import java.io.IOException;
import org.opensearch.common.inject.Inject;
        return new GetTermVersionResponse(termVersion);
    private final Logger logger = LogManager.getLogger(getClass());
    private boolean usePreCommitState = false;
        }
 * @opensearch.internal  
        this.usePreCommitState = FeatureFlags.isEnabled(FeatureFlags.TERM_VERSION_PRECOMMIT_ENABLE_SETTING);
                return new GetTermVersionResponse(termVersion, coordinator.isRemotePublicationEnabled());
    @Override  
            false,  
        }
import org.opensearch.action.support.ActionFilters;  
        IndexNameExpressionResolver indexNameExpressionResolver,
 */  
        this.discovery = discovery;  
import org.opensearch.cluster.ClusterState;
    }
public class TransportGetTermVersionAction extends TransportClusterManagerNodeReadAction<GetTermVersionRequest, GetTermVersionResponse> {
    @Override
            ActionListener.completeWith(listener, () -> buildResponse(request, state));
 * Transport action for obtaining cluster term and version from cluster-manager
        GetTermVersionRequest request,  
        } else {  
import org.opensearch.threadpool.ThreadPool;
        TransportService transportService,  
    protected ClusterBlockException checkBlock(GetTermVersionRequest request, ClusterState state) {
    @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
        return new GetTermVersionResponse(in);
    }
package org.opensearch.action.support.clustermanager.term;
        return null;
    ) {  
/**  
import org.opensearch.core.common.io.stream.StreamInput;
    @Inject
import org.opensearch.discovery.Discovery;  
    ) throws Exception {  
        ActionFilters actionFilters,  
    public GetTermVersionResponse read(StreamInput in) throws IOException {  
            clusterService,
    }
            actionFilters,
        ClusterStateTermVersion termVersion = new ClusterStateTermVersion(state);
import org.opensearch.common.util.FeatureFlags;  
            }  
import org.opensearch.cluster.block.ClusterBlockException;  
            threadPool,  
            GetTermVersionAction.NAME,
        Discovery discovery
            transportService,
        ThreadPool threadPool,
import org.apache.logging.log4j.Logger;
        ClusterState state,
