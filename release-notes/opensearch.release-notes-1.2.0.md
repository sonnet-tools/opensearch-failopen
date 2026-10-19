    is provided by
    [Vacha](mailto:vachshah@amazon.com) - Mon, 1 Nov 2021 17:12:48 -0700
* __Adjust CodeCache size to eliminate JVM warnings (and crashes) (#1426) (#1432)__
    The settings and the corresponding logic for translog pruning by retention
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Fri, 22 Oct 2021 12:41:44 -0400
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    This commit upgrades to the latest release of lucene 8.10
    commit
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Upgrade to Lucene 8.10.1 (#1440) (#1459)__
    - Add ShardIndexingPressure framework level construct and Stats #1015
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Thu, 28 Oct 2021 11:02:02 -0700
    for providing a
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
     Co-authored-by: dblock &lt;dblock@dblock.org&gt;
    [Rabi Panda](mailto:adnapibar@gmail.com) - Mon, 1 Nov 2021 10:26:20 -0500
    a new EngineConfigFactory mechanism. EnginePlugin provides interface methods to
    [Vacha](mailto:vachshah@amazon.com) - Tue, 16 Nov 2021 15:22:38 -0800
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 30 Sep 2021 19:59:11 -0400
    through BuildPlugin.
    INDEX_PLUGINS_REPLICATION_TRANSLOG_RETENTION_LEASE_PRUNING_ENABLED_SETTING was
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 20 Oct 2021 15:27:38 -0400
* __Allow building on FreeBSD (#1091) (#1374)__
    ```
    * Add extension point for custom TranslogDeletionPolicy in EnginePlugin.
    * Clarified JDK usage in DEVELOPER_GUIDE.md, fixed minor issue with configuring
    Singh &lt;sisurab@amazon.com&gt;
    setting can be moved to the plugin in the next minor release.
    [Nick Knize](mailto:nknize@apache.org) - Thu, 4 Nov 2021 14:19:07 -0500
    deprecated, then deprecation was removed. This adds deprecation back so that
* __Upgrading netty version to 4.1.69.Final (#1363) (#1382)__
    [Saurabh Singh](mailto:getsaurabh02@gmail.com) - Mon, 11 Oct 2021 12:14:18 -0700
    * Upgrading htrace-core4 to 4.1.0
* __Run spotless and checkstyle on libs module (#1428)(#1434)__
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    * Remove outdated code of giving JaCoCo files permission when Java security
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    - Add plumbing logic for IndexingPressureService in Transport Actions. #1113
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
     Co-authored-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
* __Make TranslogDeletionPolicy abstract for extension (#1456) (#1478)__
* __Upgrading mockito version to make it consistent across the repo (#1410) (#1435)__
    custom TranslogDeletionPolicy.
* __Remove deprecated settings and logic for translog pruning by retention lease. (#1416) (#1471)__
* __[BUG] SymbolicLinkPreservingUntarTransform fails on Windows (#1433) (#1439)__
    * Use Docker desktop installation on Windows.
* __Replace securemock with mock-maker (test support), update Mockito to 3.12.4 (#1332) (#1354)__
     override configurations in EngineConfig. The EngineConfigFactory produces a
    [Tianli Feng](mailto:ftianli@amazon.com) - Mon, 20 Sep 2021 11:06:35 -0700
     Before building, the openjdk14 package was installed and the environment
     Signed-off-by: Andrew Ross &lt;andrross@amazon.com&gt;
     Co-authored-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    - Rejections thresholds governed by combination of configurable parameters
     This serves as a mechanism to override Engine configurations (e.g.,
## Version 1.2.0 Release Notes
    [Rabi Panda](mailto:adnapibar@gmail.com) - Fri, 29 Oct 2021 12:14:25 -0700
    EAD -&gt; refs/heads/1.2, refs/remotes/upstream/1.2, refs/remotes/origin/1.2
    TranslogDeletionPolicy from within plugins that implement the EnginePlugin
    to delete all the existing translog files. I found
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
* __Upgrading gson to 2.8.9 (#1541) (#1546)__
* __Run spotless and exclude checkstyle on plugins module (#1417) (#1423)__
    * Fixed minor typos in DEVELOPER_GUIDE.md
    in the current state of the CI.
    [Vacha](mailto:vachshah@amazon.com) - Tue, 2 Nov 2021 15:46:18 -0700
    shadow-mode only internal rejection breakdown metrics will be published while
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
    DefaultTranslogDeletionPolicy.
* __Add staged version 1.1.1 (#1505)__
    - Add Shard Indexing Pressure Store #838
* __Upgrading dependencies (#1491) (#1495)__
    - Node level and shard level indexing pressure statistics exposed through stats
    a deterministic test
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 29 Sep 2021 17:20:06 -0400
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    - Control knobs to tune to the key performance thresholds which control
    failure when running with the seed `E3E6AAD95ABD299B`. As opposed to creating a
    Signed-off-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    Co-authored-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
* __Adding spotless support for subprojects under :test (#1479)__
    This is required to not mandate test have the cluster service initialized while
    [Saurabh Singh](mailto:getsaurabh02@gmail.com) - Thu, 21 Oct 2021 09:20:52 -0400
    Shard level indexing pressure improves the current Indexing Pressure framework
    - Add shard indexing pressure integration tests. #1198
* __Update Jackson to 2.12.5 (#1247) (#1270)__
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    TranslogConfig) enabling Plugins to have higher fidelity for
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Tue, 2 Nov 2021 13:33:15 -0700
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    * Close first engine instance before creating second (#1457)
* __Run spotless and exclude checkstyle on client module https://github.com/opensearch-project/OpenSearch/pull/1392 (#1414)__
    ```
    - Add Shard Indexing Pressure Settings. #716
    lease which were added as part of #1100 have been deprecated. This
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
* __Switch to newSnapshot testing method to use helper__
    PATH=$JAVA_HOME/bin:$PATH
    * Upgrade hadoop dependencies for hdfs plugin
* __Removing Jenkinsfile (not used), replaced by opensearch-build/jenkins/opensearch/Jenkinsfile (#1408) (#1411)__
    asserting node attributes.
* __Fix windows build (mostly) (#1412) (#1420)__
    plugins
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Mon, 1 Nov 2021 15:16:45 -0700
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 21 Oct 2021 19:42:09 -0400
    second engine instance with a different translog location, just close the first
    - Integration of Indexing pressure stats with Plugins for for metric visibility
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Mon, 25 Oct 2021 15:13:54 -0700
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Thu, 21 Oct 2021 19:44:46 -0400
    takes a step further to have rejections based on the memory accounting at shard
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Wed, 20 Oct 2021 17:51:26 -0500
    - Add Shard Indexing Pressure Memory Manager #945
    adjusted to use it:
    ./gradlew publishToMavenLocal -Dbuild.snapshot=false
* __[BUG] Fix org.opensearch.action.admin.cluster.node.stats.NodeStatsTests.testSerialization (#1399)__
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Cleanup for Checkstyle https://github.com/opensearch-project/OpenSearch/pull/1370 (#1492)__
* __Backporting #1488 spotless check on plugins (#1489)__
    child classes. The default implementation
     While here, reorder OS conditions alphabetically.
    - Refactor IndexingPressure to allow extension. #718
    * Allow building on FreeBSD
    abstract in this class for implementation by
     This commit adds a method that can be used to provide a custom
    [Xue Zhou](mailto:85715413+xuezhou25@users.noreply.github.com) - Tue, 2 Nov 2021 15:54:24 -0700
* __Add EngineConfig extensions to EnginePlugin (#1387) (#1401)__
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 26 Oct 2021 15:03:44 -0400
    [Vacha](mailto:vachshah@amazon.com) - Wed, 27 Oct 2021 20:22:12 -0400
    Signed-off-by: Himanshu Setia &lt;setiah@amazon.com&gt;
* __[BUG] ConcurrentSnapshotsIT#testAssertMultipleSnapshotsAndPrimaryFailOver fails intermittently (#1311) (#1322)__
* __Fixing bwc test for repository-multi-version (#1441) (#1451)__
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    efs/heads/sr-sandbox
* __[Backport] [1.x] Clarified JDK usage in DEVELOPER_GUIDE.md, fixed minor issue with configuring runtime JDK (#1372)__
    [Nick Knize](mailto:nknize@apache.org) - Sat, 25 Sep 2021 23:04:26 -0500
    CodecService,
    ```
    runtime JDK
    provide a
     Co-authored-by: Andrew Ross &lt;andrross@amazon.com&gt;
    * Updated developer guide with Windows specifics.
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
     Signed-off-by: Romain Tartière &lt;romain@blogreen.org&gt;
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    export
* __Upgrading dependencies in hdfs plugin (#1466) (#1485)__
    * Unbreak CI with FreeBSD support
    one before creating the second.
    ```
    overridden configurations.
    [Himanshu Setia](mailto:58999915+setiah@users.noreply.github.com) - Mon, 1 Nov 2021 19:26:45 -0700
* __Run spotless and exclude checkstyle on modules module (#1442) (#1453)__
    absent
* __Update node attribute check to version update (1.2) check for shard indexing pressure serialization. (#1398)__
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    [Rabi Panda](mailto:adnapibar@gmail.com) - Mon, 1 Nov 2021 12:41:05 -0700
    will be thrown if more than one plugin overrides the policy.
    As part of the commit 2ebd0e04, we added a new method to the EnginePlugin to
    - Add shard indexing pressure metric/stats via rest end point. #1171
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    custom TranslogDeletionPolicy. This commit makes
    level along with other key performance factors like throughput and last
    export JAVA_HOME=/usr/local/openjdk14/
    the
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
  [Nick Knize](mailto:nknize@apache.org) - Tue, 14 Sep 2021 06:48:05 -0400
    - Add Indexing Pressure Service which acts as orchestrator for IP #1084
    [Vacha](mailto:vachshah@amazon.com) - Tue, 26 Oct 2021 08:48:49 -0400
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    - Add Shard Indexing Pressure Tracker. #717
    changing Engine
    manager enabled
    [Nick Knize](mailto:nknize@apache.org) - Thu, 21 Oct 2021 08:58:47 -0500
    This commit adds an extension point to EngineConfig through EnginePlugin using
    removes those deprecated code in favor of an extension point
    Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
    (such as memory limits on node) and dynamic parameters (such as latency
    [Vacha](mailto:vachshah@amazon.com) - Fri, 15 Oct 2021 08:56:48 -0400
    [Romain Tartière](mailto:romain@blogreen.org) - Sun, 17 Oct 2021 15:53:10 -0400
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
     Signed-off-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 21 Oct 2021 09:16:15 -0400
* __[Version] Increment 1.x to 1.2 (#1239)__
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    successful requests.
    increase, throughput degradation).
    (#1404)
     Signed-off-by: Tianli Feng &lt;ftianli@amazon.com&gt;
    - Smarter rejections by discarding the requests intended only for problematic
    PRs against a feature branch.
    which performs memory accounting at node level and rejects the requests. This
* __Minor fix for the flaky test to reduce concurrency (#1361) (#1397)__
    Co-authored-by: Saurabh
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 21 Oct 2021 19:41:44 -0400
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Nicholas Walter Knize](mailto:nknize@apache.org) - Sun, 26 Sep 2021 00:00:35 -0500
    sudo pkg install openjdk14
    and auto-tuning in future.
* __[Backport 1.x] Add extension point for custom TranslogDeletionPolicy in EnginePlugin (#1404) (#1424)__
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    interface. This enables plugins to provide a custom deletion policy with the
* __Remove old ES libraries used in reindex due to CVEs (#1359) (#1497)__
    rejections, to address any specific requirement or issues.
     This step is used in the OpenSearch repository context when building
    [Nick Knize](mailto:nknize@apache.org) - Thu, 28 Oct 2021 13:23:25 -0700
    rejection).
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
* __Upgrade hadoop dependencies for hdfs plugin (#1335) (#1369)__
    * Attach Gradle codeCoverageReport task to check task.
    [Xue Zhou](mailto:85715413+xuezhou25@users.noreply.github.com) - Tue, 2 Nov 2021 15:27:53 -0700
    is only permitted for
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Fri, 22 Oct 2021 13:23:14 -0700
* __remove codeQL warning about implicit narrowing conversion in compound assignment (#1403) (#1496)__
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 22 Sep 2021 10:52:55 -0400
     Signed-off-by: Saurabh Singh &lt;sisurab@amazon.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    - Control knobs to run the feature in shadow-mode or enforced-mode. In
    index or shard, while still allowing others to continue (fairness in
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
* __Add Shard Level Indexing Pressure (#1336) (#1343)__
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Add support to generate code coverage report with JaCoCo (#1236)__
    config of the default InternalEngine instance, the second instance will attempt
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    minTranslogGenRequired method
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Mon, 11 Oct 2021 11:29:50 -0400
* __Support for Heap after GC stats (opensearch-project#1265) (#1309)__
    instance of the EngineConfig using these overrides. Defaults are used
* __Run spotless and exclude checkstyle on rest-api-spec module (#1462) (#1472)__
    * Locate docker-compose on Windows.
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    was
    each node role i.e. coordinator, primary and replica.
    codeCoverageReportForIntegrationTest to generate code coverage report for all
    new
    * Default docker-compose location.
    current limitation that only one plugin can override the policy. An exception
    * Apply JaCoCo Gradle plugin to the root project, and to all the sub-projects
* __[repository-azure] plugin should use Azure Storage SDK v12 for Java (#1302) (#1409)__
    * Correct windows task name.
    [Vacha](mailto:vachshah@amazon.com) - Mon, 18 Oct 2021 22:05:45 -0400
     Co-authored-by: dblock &lt;dblock@dblock.org&gt;
* __[Revert] Translog Pruning Setting Deprecation Removal (#1294)__
    * Add 3 Gradle tasks: codeCoverageReport, codeCoverageReportForUnitTest,
    the tests, unit tests, and integration tests correspondingly.
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    - Granular tracking of indexing tasks performance, at every shard level, for
     The changes were divided into small manageable chunks as part of the following
     When creating the second instance of an InternalEngine using the same translog
    [Owais Kazi](mailto:owaiskazi19@gmail.com) - Fri, 29 Oct 2021 17:27:17 -0700
    **Key features**
    api.
    [Saurabh Singh](mailto:getsaurabh02@gmail.com) - Wed, 20 Oct 2021 15:29:04 -0400
    no actual rejections will be performed.
    behavior without having to override the entire Engine (which
     With this set of change, we are able to successfuly run:
    * Fixing gradle check failures
    This commit removes old ES libraries version 090 and 176 due to CVE
    a single plugin).
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 26 Oct 2021 08:48:16 -0400
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Run spotless and exclude checkstyle on server module https://github.com/opensearch-project/OpenSearch/pull/1380 (#1391)__
