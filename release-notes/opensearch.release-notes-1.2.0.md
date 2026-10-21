* __[Version] Increment 1.x to 1.2 (#1239)__
    - Add ShardIndexingPressure framework level construct and Stats #1015
* __remove codeQL warning about implicit narrowing conversion in compound assignment (#1403) (#1496)__
    - Add Shard Indexing Pressure Settings. #716
    commit
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 22 Sep 2021 10:52:55 -0400
    * Updated developer guide with Windows specifics.
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    efs/heads/sr-sandbox
    a single plugin).
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
## Version 1.2.0 Release Notes
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Fri, 29 Oct 2021 17:27:17 -0700
    [Nick Knize](mailto:nknize@apache.org) - Thu, 28 Oct 2021 13:23:25 -0700
    rejection).
    api.
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     This commit adds a method that can be used to provide a custom
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Mon, 11 Oct 2021 11:29:50 -0400
    second engine instance with a different translog location, just close the first
* __Adding spotless support for subprojects under :test (#1479)__
    interface. This enables plugins to provide a custom deletion policy with the
    The settings and the corresponding logic for translog pruning by retention
* __Removing Jenkinsfile (not used), replaced by opensearch-build/jenkins/opensearch/Jenkinsfile (#1408) (#1411)__
    to delete all the existing translog files. I found
* __Upgrading gson to 2.8.9 (#1541) (#1546)__
    * Locate docker-compose on Windows.
    [Xue Zhou](mailto:85715413+xuezhou25@users.noreply.github.com) - Tue, 2 Nov 2021 15:54:24 -0700
    index or shard, while still allowing others to continue (fairness in
    ```
    lease which were added as part of #1100 have been deprecated. This
    * Fixing gradle check failures
    As part of the commit 2ebd0e04, we added a new method to the EnginePlugin to
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Mon, 1 Nov 2021 15:16:45 -0700
    * Upgrade hadoop dependencies for hdfs plugin
* __Replace securemock with mock-maker (test support), update Mockito to 3.12.4 (#1332) (#1354)__
    - Control knobs to tune to the key performance thresholds which control
  [Nick Knize](mailto:nknize@apache.org) - Tue, 14 Sep 2021 06:48:05 -0400
* __Run spotless and exclude checkstyle on rest-api-spec module (#1462) (#1472)__
    a deterministic test
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
     Co-authored-by: Andrew Ross &lt;andrross@amazon.com&gt;
* __Add EngineConfig extensions to EnginePlugin (#1387) (#1401)__
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 20 Oct 2021 15:27:38 -0400
    absent
    in the current state of the CI.
     Signed-off-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    * Unbreak CI with FreeBSD support
    ```
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Wed, 20 Oct 2021 17:51:26 -0500
    [Himanshu Setia](mailto:58999915+setiah@users.noreply.github.com) - Mon, 1 Nov 2021 19:26:45 -0700
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    Co-authored-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    Shard level indexing pressure improves the current Indexing Pressure framework
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
     With this set of change, we are able to successfuly run:
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    ./gradlew publishToMavenLocal -Dbuild.snapshot=false
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    new
    [Rabi Panda](mailto:adnapibar@gmail.com) - Mon, 1 Nov 2021 12:41:05 -0700
* __Minor fix for the flaky test to reduce concurrency (#1361) (#1397)__
    CodecService,
    adjusted to use it:
    * Close first engine instance before creating second (#1457)
    * Fixed minor typos in DEVELOPER_GUIDE.md
    takes a step further to have rejections based on the memory accounting at shard
* __Upgrading netty version to 4.1.69.Final (#1363) (#1382)__
    behavior without having to override the entire Engine (which
* __Allow building on FreeBSD (#1091) (#1374)__
    - Smarter rejections by discarding the requests intended only for problematic
    one before creating the second.
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    manager enabled
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    runtime JDK
     While here, reorder OS conditions alphabetically.
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
     When creating the second instance of an InternalEngine using the same translog
    [Romain Tartière](mailto:romain@blogreen.org) - Sun, 17 Oct 2021 15:53:10 -0400
     Signed-off-by: Romain Tartière &lt;romain@blogreen.org&gt;
    sudo pkg install openjdk14
     Signed-off-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    was
* __[Revert] Translog Pruning Setting Deprecation Removal (#1294)__
     This serves as a mechanism to override Engine configurations (e.g.,
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    - Add Shard Indexing Pressure Tracker. #717
    [Saurabh Singh](mailto:getsaurabh02@gmail.com) - Wed, 20 Oct 2021 15:29:04 -0400
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    overridden configurations.
    [Tianli Feng](mailto:ftianli@amazon.com) - Mon, 20 Sep 2021 11:06:35 -0700
    Singh &lt;sisurab@amazon.com&gt;
    provide a
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    This commit removes old ES libraries version 090 and 176 due to CVE
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    [Nick Knize](mailto:nknize@apache.org) - Sat, 25 Sep 2021 23:04:26 -0500
    [Vacha](mailto:vachshah@amazon.com) - Fri, 15 Oct 2021 08:56:48 -0400
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Tue, 2 Nov 2021 13:33:15 -0700
    deprecated, then deprecation was removed. This adds deprecation back so that
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 21 Oct 2021 19:41:44 -0400
    This commit adds an extension point to EngineConfig through EnginePlugin using
* __Cleanup for Checkstyle https://github.com/opensearch-project/OpenSearch/pull/1370 (#1492)__
    setting can be moved to the plugin in the next minor release.
    current limitation that only one plugin can override the policy. An exception
     Co-authored-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
* __Add support to generate code coverage report with JaCoCo (#1236)__
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    for providing a
     Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Update node attribute check to version update (1.2) check for shard indexing pressure serialization. (#1398)__
* __Run spotless and exclude checkstyle on server module https://github.com/opensearch-project/OpenSearch/pull/1380 (#1391)__
    Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
* __Adjust CodeCache size to eliminate JVM warnings (and crashes) (#1426) (#1432)__
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     This step is used in the OpenSearch repository context when building
    ```
    [Rabi Panda](mailto:adnapibar@gmail.com) - Mon, 1 Nov 2021 10:26:20 -0500
* __[BUG] ConcurrentSnapshotsIT#testAssertMultipleSnapshotsAndPrimaryFailOver fails intermittently (#1311) (#1322)__
    plugins
* __Upgrade hadoop dependencies for hdfs plugin (#1335) (#1369)__
* __[BUG] SymbolicLinkPreservingUntarTransform fails on Windows (#1433) (#1439)__
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    instance of the EngineConfig using these overrides. Defaults are used
    **Key features**
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 26 Oct 2021 08:48:16 -0400
    INDEX_PLUGINS_REPLICATION_TRANSLOG_RETENTION_LEASE_PRUNING_ENABLED_SETTING was
* __Remove old ES libraries used in reindex due to CVEs (#1359) (#1497)__
    * Upgrading htrace-core4 to 4.1.0
    (such as memory limits on node) and dynamic parameters (such as latency
     Before building, the openjdk14 package was installed and the environment
* __Upgrading dependencies in hdfs plugin (#1466) (#1485)__
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
     override configurations in EngineConfig. The EngineConfigFactory produces a
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    removes those deprecated code in favor of an extension point
     Signed-off-by: Tianli Feng &lt;ftianli@amazon.com&gt;
    PATH=$JAVA_HOME/bin:$PATH
    * Correct windows task name.
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Mon, 25 Oct 2021 15:13:54 -0700
    - Add Shard Indexing Pressure Store #838
    [Vacha](mailto:vachshah@amazon.com) - Wed, 27 Oct 2021 20:22:12 -0400
    [Xue Zhou](mailto:85715413+xuezhou25@users.noreply.github.com) - Tue, 2 Nov 2021 15:27:53 -0700
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    shadow-mode only internal rejection breakdown metrics will be published while
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
* __Remove deprecated settings and logic for translog pruning by retention lease. (#1416) (#1471)__
    * Add 3 Gradle tasks: codeCoverageReport, codeCoverageReportForUnitTest,
    no actual rejections will be performed.
    increase, throughput degradation).
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    * Default docker-compose location.
* __Switch to newSnapshot testing method to use helper__
* __Add staged version 1.1.1 (#1505)__
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Fri, 22 Oct 2021 12:41:44 -0400
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    * Apply JaCoCo Gradle plugin to the root project, and to all the sub-projects
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    the tests, unit tests, and integration tests correspondingly.
* __Fixing bwc test for repository-multi-version (#1441) (#1451)__
    * Allow building on FreeBSD
    [Rabi Panda](mailto:adnapibar@gmail.com) - Fri, 29 Oct 2021 12:14:25 -0700
    - Add shard indexing pressure metric/stats via rest end point. #1171
    [Vacha](mailto:vachshah@amazon.com) - Tue, 2 Nov 2021 15:46:18 -0700
    custom TranslogDeletionPolicy.
    level along with other key performance factors like throughput and last
     Co-authored-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
* __Run spotless and exclude checkstyle on plugins module (#1417) (#1423)__
    Co-authored-by: Saurabh
     Co-authored-by: dblock &lt;dblock@dblock.org&gt;
    config of the default InternalEngine instance, the second instance will attempt
    - Integration of Indexing pressure stats with Plugins for for metric visibility
* __Add Shard Level Indexing Pressure (#1336) (#1343)__
    * Remove outdated code of giving JaCoCo files permission when Java security
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Thu, 21 Oct 2021 19:44:46 -0400
    [Nick Knize](mailto:nknize@apache.org) - Thu, 21 Oct 2021 08:58:47 -0500
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Saurabh Singh](mailto:getsaurabh02@gmail.com) - Thu, 21 Oct 2021 09:20:52 -0400
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    each node role i.e. coordinator, primary and replica.
     Co-authored-by: dblock &lt;dblock@dblock.org&gt;
    (#1404)
    [Nick Knize](mailto:nknize@apache.org) - Thu, 4 Nov 2021 14:19:07 -0500
    - Refactor IndexingPressure to allow extension. #718
    This commit upgrades to the latest release of lucene 8.10
    - Add Shard Indexing Pressure Memory Manager #945
    PRs against a feature branch.
* __Run spotless and checkstyle on libs module (#1428)(#1434)__
    ```
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
* __Upgrading mockito version to make it consistent across the repo (#1410) (#1435)__
    - Add plumbing logic for IndexingPressureService in Transport Actions. #1113
    This is required to not mandate test have the cluster service initialized while
* __Update Jackson to 2.12.5 (#1247) (#1270)__
* __Run spotless and exclude checkstyle on client module https://github.com/opensearch-project/OpenSearch/pull/1392 (#1414)__
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    minTranslogGenRequired method
* __Fix windows build (mostly) (#1412) (#1420)__
    through BuildPlugin.
    Signed-off-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    changing Engine
    abstract in this class for implementation by
    [Vacha](mailto:vachshah@amazon.com) - Tue, 16 Nov 2021 15:22:38 -0800
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 21 Oct 2021 09:16:15 -0400
    asserting node attributes.
     The changes were divided into small manageable chunks as part of the following
    - Control knobs to run the feature in shadow-mode or enforced-mode. In
    - Rejections thresholds governed by combination of configurable parameters
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 21 Oct 2021 19:42:09 -0400
    Signed-off-by: Himanshu Setia &lt;setiah@amazon.com&gt;
    which performs memory accounting at node level and rejects the requests. This
    TranslogDeletionPolicy from within plugins that implement the EnginePlugin
* __[Backport] [1.x] Clarified JDK usage in DEVELOPER_GUIDE.md, fixed minor issue with configuring runtime JDK (#1372)__
    [Vacha](mailto:vachshah@amazon.com) - Mon, 18 Oct 2021 22:05:45 -0400
* __Support for Heap after GC stats (opensearch-project#1265) (#1309)__
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    custom TranslogDeletionPolicy. This commit makes
    the
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    [Vacha](mailto:vachshah@amazon.com) - Mon, 1 Nov 2021 17:12:48 -0700
    * Attach Gradle codeCoverageReport task to check task.
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 26 Oct 2021 15:03:44 -0400
    - Add shard indexing pressure integration tests. #1198
    and auto-tuning in future.
    export JAVA_HOME=/usr/local/openjdk14/
    failure when running with the seed `E3E6AAD95ABD299B`. As opposed to creating a
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 29 Sep 2021 17:20:06 -0400
    [Vacha](mailto:vachshah@amazon.com) - Tue, 26 Oct 2021 08:48:49 -0400
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Fri, 22 Oct 2021 13:23:14 -0700
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    a new EngineConfigFactory mechanism. EnginePlugin provides interface methods to
* __[Backport 1.x] Add extension point for custom TranslogDeletionPolicy in EnginePlugin (#1404) (#1424)__
    successful requests.
    - Node level and shard level indexing pressure statistics exposed through stats
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    * Use Docker desktop installation on Windows.
    rejections, to address any specific requirement or issues.
     Signed-off-by: Andrew Ross &lt;andrross@amazon.com&gt;
    * Add extension point for custom TranslogDeletionPolicy in EnginePlugin.
    * Clarified JDK usage in DEVELOPER_GUIDE.md, fixed minor issue with configuring
    TranslogConfig) enabling Plugins to have higher fidelity for
* __Make TranslogDeletionPolicy abstract for extension (#1456) (#1478)__
    - Add Indexing Pressure Service which acts as orchestrator for IP #1084
    codeCoverageReportForIntegrationTest to generate code coverage report for all
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    [Nicholas Walter Knize](mailto:nknize@apache.org) - Sun, 26 Sep 2021 00:00:35 -0500
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 30 Sep 2021 19:59:11 -0400
* __[repository-azure] plugin should use Azure Storage SDK v12 for Java (#1302) (#1409)__
* __[BUG] Fix org.opensearch.action.admin.cluster.node.stats.NodeStatsTests.testSerialization (#1399)__
    is only permitted for
* __Run spotless and exclude checkstyle on modules module (#1442) (#1453)__
* __Upgrade to Lucene 8.10.1 (#1440) (#1459)__
    is provided by
    - Granular tracking of indexing tasks performance, at every shard level, for
    [Saurabh Singh](mailto:getsaurabh02@gmail.com) - Mon, 11 Oct 2021 12:14:18 -0700
    will be thrown if more than one plugin overrides the policy.
    export
* __Upgrading dependencies (#1491) (#1495)__
    EAD -&gt; refs/heads/1.2, refs/remotes/upstream/1.2, refs/remotes/origin/1.2
    DefaultTranslogDeletionPolicy.
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    child classes. The default implementation
* __Backporting #1488 spotless check on plugins (#1489)__
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Thu, 28 Oct 2021 11:02:02 -0700
