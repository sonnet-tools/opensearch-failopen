                    if (newRepositoryMetadata.name().equals(existingRepositoryMetadata.name())) {
                            // metadata constructed from the node attributes of the joining node will be validated
    }
            }  
        this.repositoriesService = repositoriesService;  
     * @return  
            } else {
                            // This is to handle cases where-in the during a previous node-join attempt if the publish operation succeeded
                        }
            this.mode = mode;  
 * compatible open source license.
            return new RepositoriesMetadata(updatedRepositoryMetadataList);
        public final String mode;  
 */  
            if (existingRepositories == null) {
                        }  
        boolean isMixedMode = clusterSettings.get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(CompatibilityMode.MIXED);
                            throw new IllegalStateException(  
                            repositoriesService.get().repository(newRepositoryMetadata.name());
import org.apache.logging.log4j.message.ParameterizedMessage;  
        return (isMixedMode && isRemoteStoreMigrationDirection);  
        reposService.updateRepositoriesMap(repositories);  
                repository.getMetadata().type()
                        try {
        Setting.Property.NodeScope
        REMOTE_STORE("remote_store"),
     * - <code>remote_store.compatibility_mode</code> set to <code>mixed</code>
        }
            return existingRepositories;
                        + "] compatibility mode is not supported. "
     * <code>true</code> For <code>REMOTE_STORE</code> migration direction and <code>MIXED</code> compatibility mode,
        }
                            );
                            // 2. It's possible to update repository settings except the restricted ones post the
                );
     * <br>
            }
                        + "supported modes are ["
import java.util.ArrayList;
                    updatedRepositoryMetadataList.add(newRepositoryMetadata);
                                    + "] supplied by joining node is different from existing repository metadata ["  
    /**
    }  
        DOCREP("docrep");  
                            // even if the non-restricted system repository settings are now different.  
import java.util.HashMap;
import org.opensearch.cluster.node.DiscoveryNode;
                if (repositoryAlreadyPresent == false) {
     */  
     * mentioned repository. This verification will happen on a local node to validate if the node is able to connect  
            repository.verify(verificationToken, localNode);  
                                    + "]."
    public RemoteStoreNodeService(Supplier<RepositoriesService> repositoriesService, ThreadPool threadPool) {
     */
    public static final Setting<Direction> MIGRATION_DIRECTION_SETTING = new Setting<>(
                            // against the repository information provided by existing nodes in cluster state.  
                                    + newRepositoryMetadata
    private static final Logger logger = LogManager.getLogger(RemoteStoreNodeService.class);
        Setting.Property.NodeScope  
                return Direction.valueOf(direction.toUpperCase(Locale.ROOT));
        return (isMixedMode && isRemoteStoreMigrationDirection);
    /**  
                        + Arrays.toString(CompatibilityMode.values())  
            for (RepositoryMetadata newRepositoryMetadata : newRepositoryMetadataList) {
        "cluster.migration.direction",
     * Updates repositories metadata in the cluster state if not already present. If a repository metadata for a
    public void createAndVerifyRepositories(DiscoveryNode localNode) {
                                "Skipping repositories metadata checks: Remote repository [{}] is in the cluster state but not present "
import org.opensearch.cluster.metadata.Metadata;
    /**  
                return new RepositoriesMetadata(newRepositoryMetadataList);  
 */
 * The OpenSearch Contributors require contributions made to  
    /**
import org.opensearch.cluster.metadata.RepositoryMetadata;  
            logger.info(
        STRICT("strict"),  
            List<RepositoryMetadata> updatedRepositoryMetadataList = new ArrayList<>();
        NONE("none"),
     * - <code>migration.direction</code> set to <code>remote_store</code>
                    " remote store to docrep migration.direction is under an experimental feature and can be activated only by enabling "
import org.opensearch.common.settings.Setting;  
                        + REMOTE_STORE_MIGRATION_EXPERIMENTAL  
                    }
     * <br>
        value -> {
            repository = reposService.createRepository(repositoryMetadata);  
    public static boolean isMigratingToRemoteStore(Metadata metadata) {
                        + "]"
import org.opensearch.common.settings.ClusterSettings;
        Direction(String d) {
            try {
        public static Direction parseString(String direction) {
                            break;
                                    + "in the repository service.",
        CompatibilityMode::parseString,
    public enum CompatibilityMode {
        RepositoriesService reposService = repositoriesService.get();
                boolean repositoryAlreadyPresent = false;  
            Repository repository;
import org.opensearch.threadpool.ThreadPool;  
    }
                throw new IllegalArgumentException(
                            repositoriesService.get().ensureValidSystemRepositoryUpdate(newRepositoryMetadata, existingRepositoryMetadata);
     * To check if the cluster is undergoing remote store migration using clusterState metadata  
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
                                    + existingRepositoryMetadata
    );
        // Updating the repositories map in RepositoriesService
import org.opensearch.cluster.metadata.RepositoriesMetadata;
     * If the creation or verification fails this will close all the repositories this method created and throw
                }  
                            // but the commit operation failed, the cluster-state may have the repository metadata which is not applied
        CompatibilityMode(String mode) {
            );
        boolean isMixedMode = REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(metadata.settings()).equals(CompatibilityMode.MIXED);  
                .repositories();  
     * <code>false</code> otherwise  
                            break;
        Map<String, Repository> repositories = new HashMap<>();
                }  
     * <code>false</code> otherwise  
    public static final Setting<CompatibilityMode> REMOTE_STORE_COMPATIBILITY_MODE_SETTING = new Setting<>(
            List<RepositoryMetadata> newRepositoryMetadataList = new RemoteStoreNodeAttribute(joiningNode).getRepositoriesMetadata()
                for (RepositoryMetadata existingRepositoryMetadata : existingRepositories.repositories()) {
}
     * @opensearch.internal  
                                "new repository metadata ["
        CompatibilityMode.STRICT.name(),
                            // This will help in handling two scenarios -  
                return CompatibilityMode.valueOf(compatibilityMode.toUpperCase(Locale.ROOT));
     * Node join compatibility mode introduced with remote backed storage.
                            logger.warn(  
    }  
        Direction.NONE.name(),  
import org.opensearch.repositories.Repository;  
     *  
        }
        }  
        public final String direction;
                                newRepositoryMetadata.name()  
    private final Supplier<RepositoriesService> repositoriesService;  
                        } catch (RepositoryMissingException e) {
            RepositoriesService.validate(repositoryName);  
            if (value == Direction.DOCREP && FeatureFlags.isEnabled(FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING) == false) {  
    public static boolean isMigratingToRemoteStore(ClusterSettings clusterSettings) {
     */
     *
                        try {  
        this.threadPool = threadPool;
     * <br>  
                            newRepositoryMetadata = existingRepositoryMetadata;
    }  
     * Creates a repository during a node startup and performs verification by invoking verify method against
import java.util.function.Supplier;
        for (RepositoryMetadata repositoryMetadata : nodeAttribute.getRepositoriesMetadata().repositories()) {  
                );
     * to the repository with appropriate permissions.
            try {  
        }
     */
     * exception.  
     */
        public static CompatibilityMode parseString(String compatibilityMode) {  
        Setting.Property.Dynamic,  
 * this file be licensed under the Apache-2.0 license or a
    public RepositoriesMetadata updateRepositoriesMetadata(DiscoveryNode joiningNode, RepositoriesMetadata existingRepositories) {
import org.opensearch.repositories.RepositoryException;
 * Contains all the method needed for a remote store backed node lifecycle.
                "remote backed storage repository with name [{}] and type [{}] created",
        boolean isRemoteStoreMigrationDirection = clusterSettings.get(MIGRATION_DIRECTION_SETTING).equals(Direction.REMOTE_STORE);  
import org.apache.logging.log4j.LogManager;
    /**
/**  
            String repositoryName = repositoryMetadata.name();
            }  
        } else {  
     * <code>true</code> For <code>REMOTE_STORE</code> migration direction and <code>MIXED</code> compatibility mode,
            // Verify Repository
package org.opensearch.node.remotestore;
        "cluster.remote_store.compatibility_mode",  
import org.opensearch.common.util.FeatureFlags;
                        + compatibilityMode  
            logger.info(() -> new ParameterizedMessage("successfully verified [{}] repository", repositoryName));
                            // creation of a system repository and if a node drops we will need to allow it to join
    public enum Direction {  
            } catch (IllegalArgumentException e) {  
    );
/*  
                throw new IllegalArgumentException(
            repository.endVerification(verificationToken);
            repositories.put(repositoryName, repository);  
                    "["
                            repositoryAlreadyPresent = true;  
        }
     * repository is already present in the cluster state and if it's different then the joining remote store backed
     * <code>false</code> otherwise
 * SPDX-License-Identifier: Apache-2.0
            this.direction = d;
        Direction::parseString,
        boolean isRemoteStoreMigrationDirection = MIGRATION_DIRECTION_SETTING.get(metadata.settings()).equals(Direction.REMOTE_STORE);
import org.opensearch.repositories.RepositoriesService;
     */
                throw new IllegalArgumentException("[" + direction + "] migration.direction is not supported.");  
     * @return
    /**
public class RemoteStoreNodeService {  
                            );  
    }
            } catch (IllegalArgumentException e) {
        RemoteStoreNodeAttribute nodeAttribute = new RemoteStoreNodeAttribute(localNode);  
                            // 1. When a fresh cluster is formed and a node tries to join the cluster, the repository
import java.util.Locale;  
                        } catch (RepositoryException e) {
            }  
                repository.getMetadata().name(),  
     * node repository metadata an exception will be thrown and the node will not be allowed to join the cluster.  
        if (joiningNode.isRemoteSegmentStoreNode() || joiningNode.isRemoteStatePublicationEnabled()) {  
            }
import java.util.Arrays;  
     *
            String verificationToken = repository.startVerification();
     * @opensearch.internal
import java.util.Map;
import java.util.List;
     * Migration Direction intended for docrep to remote store migration and vice versa
    }
import org.apache.logging.log4j.Logger;
     * Returns <code>true</code> iff current cluster settings have:  
                        + " feature flag in the JVM options "
 *
            // Create Repository
        MIXED("mixed");
        Setting.Property.Dynamic,
                            // into the repository service. This may lead to assertion failures down the line.  
                updatedRepositoryMetadataList.addAll(existingRepositories.repositories());
import org.opensearch.repositories.RepositoryMissingException;
    private final ThreadPool threadPool;
     * @param clusterSettings cluster level settings
        },
