        public static CompatibilityMode parseString(String compatibilityMode) {
            }
     * to the repository with appropriate permissions.
        RepositoriesService reposService = repositoriesService.get();
     * repository is already present in the cluster state and if it's different then the joining remote store backed
            // Verify Repository
            logger.info(() -> new ParameterizedMessage("successfully verified [{}] repository", repositoryName));
    public void createAndVerifyRepositories(DiscoveryNode localNode) {
     * Creates a repository during a node startup and performs verification by invoking verify method against
            this.direction = d;
                    updatedRepositoryMetadataList.add(newRepositoryMetadata);
            for (RepositoryMetadata newRepositoryMetadata : newRepositoryMetadataList) {
import org.opensearch.repositories.RepositoriesService;
                .repositories();
     * <code>false</code> otherwise
                            throw new IllegalStateException(
import java.util.HashMap;
                        } catch (RepositoryException e) {
/*
import org.opensearch.threadpool.ThreadPool;
                        + "supported modes are ["
    private static final Logger logger = LogManager.getLogger(RemoteStoreNodeService.class);
                }
        Direction::parseString,
                        try {
    public static final Setting<CompatibilityMode> REMOTE_STORE_COMPATIBILITY_MODE_SETTING = new Setting<>(
            if (existingRepositories == null) {
        }
            this.mode = mode;
        Setting.Property.NodeScope
        boolean isMixedMode = REMOTE_STORE_COMPATIBILITY_MODE_SETTING.get(metadata.settings()).equals(CompatibilityMode.MIXED);
     * <code>false</code> otherwise
        DOCREP("docrep");
            String verificationToken = repository.startVerification();
    );
     */
            }
     */
        boolean isRemoteStoreMigrationDirection = clusterSettings.get(MIGRATION_DIRECTION_SETTING).equals(Direction.REMOTE_STORE);
        REMOTE_STORE("remote_store"),
        CompatibilityMode::parseString,
                        + compatibilityMode
                            // This is to handle cases where-in the during a previous node-join attempt if the publish operation succeeded
    private final Supplier<RepositoriesService> repositoriesService;
import java.util.ArrayList;
     *
     * exception.
     * <br>
                );
        this.threadPool = threadPool;
                                newRepositoryMetadata.name()
 *
import org.opensearch.common.settings.ClusterSettings;
        public final String direction;
            }
                            // 1. When a fresh cluster is formed and a node tries to join the cluster, the repository
     */
                            // into the repository service. This may lead to assertion failures down the line.
        STRICT("strict"),
                            // against the repository information provided by existing nodes in cluster state.
    /**
                for (RepositoryMetadata existingRepositoryMetadata : existingRepositories.repositories()) {
     *
                    "["
import org.opensearch.repositories.RepositoryMissingException;
    }
            return existingRepositories;
                            repositoriesService.get().repository(newRepositoryMetadata.name());
     * <br>
 * The OpenSearch Contributors require contributions made to
        CompatibilityMode(String mode) {
            );
import java.util.Arrays;
        public static Direction parseString(String direction) {
}
     * Node join compatibility mode introduced with remote backed storage.
    /**
    public static boolean isMigratingToRemoteStore(ClusterSettings clusterSettings) {
    /**
        CompatibilityMode.STRICT.name(),
                                    + "in the repository service.",
                            repositoryAlreadyPresent = true;
                                    + "] supplied by joining node is different from existing repository metadata ["
    /**
                }
 * compatible open source license.
                        + Arrays.toString(CompatibilityMode.values())
    }
                        try {
                            // 2. It's possible to update repository settings except the restricted ones post the
                            // creation of a system repository and if a node drops we will need to allow it to join
     * @opensearch.internal
                    if (newRepositoryMetadata.name().equals(existingRepositoryMetadata.name())) {
/**
                    " remote store to docrep migration.direction is under an experimental feature and can be activated only by enabling "
        NONE("none"),
        // Updating the repositories map in RepositoriesService
                            logger.warn(
                boolean repositoryAlreadyPresent = false;
                return CompatibilityMode.valueOf(compatibilityMode.toUpperCase(Locale.ROOT));
                                "Skipping repositories metadata checks: Remote repository [{}] is in the cluster state but not present "
        public final String mode;
                return Direction.valueOf(direction.toUpperCase(Locale.ROOT));
import org.opensearch.cluster.metadata.RepositoryMetadata;
            }
 * Contains all the method needed for a remote store backed node lifecycle.
            try {
                        }
     *
import org.apache.logging.log4j.LogManager;
        Direction(String d) {
                updatedRepositoryMetadataList.addAll(existingRepositories.repositories());
                            // This will help in handling two scenarios -
        RemoteStoreNodeAttribute nodeAttribute = new RemoteStoreNodeAttribute(localNode);
import org.opensearch.cluster.metadata.Metadata;
                repository.getMetadata().type()
                        + " feature flag in the JVM options "
                            // even if the non-restricted system repository settings are now different.
            repositories.put(repositoryName, repository);
package org.opensearch.node.remotestore;
                            break;
        Map<String, Repository> repositories = new HashMap<>();
     * @return
        return (isMixedMode && isRemoteStoreMigrationDirection);
import java.util.Map;
        value -> {
        }
        }
import java.util.Locale;
     * node repository metadata an exception will be thrown and the node will not be allowed to join the cluster.
            logger.info(
        return (isMixedMode && isRemoteStoreMigrationDirection);
 * SPDX-License-Identifier: Apache-2.0
                            break;
                if (repositoryAlreadyPresent == false) {
        reposService.updateRepositoriesMap(repositories);
import java.util.List;
        }
import java.util.function.Supplier;
            // Create Repository
 */
        this.repositoriesService = repositoriesService;
 * this file be licensed under the Apache-2.0 license or a
            try {
            String repositoryName = repositoryMetadata.name();
    /**
        "cluster.migration.direction",
                "remote backed storage repository with name [{}] and type [{}] created",
import org.opensearch.common.util.FeatureFlags;
        }
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
                        } catch (RepositoryMissingException e) {
                                    + "]."
     */
                                    + existingRepositoryMetadata
     * Updates repositories metadata in the cluster state if not already present. If a repository metadata for a
        Setting.Property.NodeScope
     * mentioned repository. This verification will happen on a local node to validate if the node is able to connect
                                "new repository metadata ["
            RepositoriesService.validate(repositoryName);
            repository.verify(verificationToken, localNode);
import org.opensearch.repositories.RepositoryException;
    }
import org.opensearch.common.settings.Setting;
            List<RepositoryMetadata> updatedRepositoryMetadataList = new ArrayList<>();
        boolean isMixedMode = clusterSettings.get(REMOTE_STORE_COMPATIBILITY_MODE_SETTING).equals(CompatibilityMode.MIXED);
     * <code>true</code> For <code>REMOTE_STORE</code> migration direction and <code>MIXED</code> compatibility mode,
                        + REMOTE_STORE_MIGRATION_EXPERIMENTAL
     * - <code>migration.direction</code> set to <code>remote_store</code>
        Setting.Property.Dynamic,
        boolean isRemoteStoreMigrationDirection = MIGRATION_DIRECTION_SETTING.get(metadata.settings()).equals(Direction.REMOTE_STORE);
                throw new IllegalArgumentException(
            } catch (IllegalArgumentException e) {
            List<RepositoryMetadata> newRepositoryMetadataList = new RemoteStoreNodeAttribute(joiningNode).getRepositoriesMetadata()
                throw new IllegalArgumentException(
        MIXED("mixed");
     */
        "cluster.remote_store.compatibility_mode",
     * <code>false</code> otherwise
    );
        },
                                    + newRepositoryMetadata
                repository.getMetadata().name(),
                throw new IllegalArgumentException("[" + direction + "] migration.direction is not supported.");
            repository.endVerification(verificationToken);
     * Returns <code>true</code> iff current cluster settings have:
     * @opensearch.internal
import org.apache.logging.log4j.Logger;
    private final ThreadPool threadPool;
import org.opensearch.cluster.metadata.RepositoriesMetadata;
     */
    public RemoteStoreNodeService(Supplier<RepositoriesService> repositoriesService, ThreadPool threadPool) {
                return new RepositoriesMetadata(newRepositoryMetadataList);
        Direction.NONE.name(),
public class RemoteStoreNodeService {
    public static boolean isMigratingToRemoteStore(Metadata metadata) {
                        + "]"
    }
        Setting.Property.Dynamic,
            if (value == Direction.DOCREP && FeatureFlags.isEnabled(FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL_SETTING) == false) {
        if (joiningNode.isRemoteSegmentStoreNode() || joiningNode.isRemoteStatePublicationEnabled()) {
    }
     * - <code>remote_store.compatibility_mode</code> set to <code>mixed</code>
     * @return
                        + "] compatibility mode is not supported. "
    public RepositoriesMetadata updateRepositoriesMetadata(DiscoveryNode joiningNode, RepositoriesMetadata existingRepositories) {
                            );
     * Migration Direction intended for docrep to remote store migration and vice versa
    public static final Setting<Direction> MIGRATION_DIRECTION_SETTING = new Setting<>(
 */
                            newRepositoryMetadata = existingRepositoryMetadata;
     * To check if the cluster is undergoing remote store migration using clusterState metadata
            Repository repository;
    }
                            // but the commit operation failed, the cluster-state may have the repository metadata which is not applied
        for (RepositoryMetadata repositoryMetadata : nodeAttribute.getRepositoriesMetadata().repositories()) {
            }
     * @param clusterSettings cluster level settings
    }
                            // metadata constructed from the node attributes of the joining node will be validated
     * <code>true</code> For <code>REMOTE_STORE</code> migration direction and <code>MIXED</code> compatibility mode,
                    }
import org.opensearch.cluster.node.DiscoveryNode;
        }
    /**
                        }
            } else {
    public enum CompatibilityMode {
    public enum Direction {
        } else {
            repository = reposService.createRepository(repositoryMetadata);
                            repositoriesService.get().ensureValidSystemRepositoryUpdate(newRepositoryMetadata, existingRepositoryMetadata);
            return new RepositoriesMetadata(updatedRepositoryMetadataList);
            } catch (IllegalArgumentException e) {
                );
import org.opensearch.repositories.Repository;
import org.apache.logging.log4j.message.ParameterizedMessage;
                            );
     * If the creation or verification fails this will close all the repositories this method created and throw
     * <br>
