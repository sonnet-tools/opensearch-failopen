      fileset(dir: sourceSets.internalClusterTest.output.classesDirs.first(), includes: 'org/opensearch/arrow/flight/chaos/ChaosAgent*.class')
Can-Retransform-Classes: true
```bash
- Injects bytecode to simulate network failures
The Arrow Flight RPC plugin includes chaos testing capabilities to simulate network failures and test resilience.
Once enabled, run the chaos tests with:
    manifestFile.text = '''Manifest-Version: 1.0
```
- Tests client-side resilience to connection drops
    }
Can-Redefine-Classes: true
## What Chaos Testing Does
### 1. Add Chaos Agent to internalClusterTest
    def manifestFile = file("${buildDir}/MANIFEST.MF")
internalClusterTest {
## Running Chaos Tests
    def agentJar = createChaosAgent()
// Task to create chaos agent JAR
    ant.jar(destfile: agentJar, manifest: manifestFile) {
'''
```
  if (!agentJar.exists()) {
}
}
Add this task to create the chaos agent JAR:
```gradle
  return agentJar.absolutePath
```
Premain-Class: org.opensearch.arrow.flight.chaos.ChaosAgent
  doFirst {
./gradlew :plugins:arrow-flight-rpc:internalClusterTest --tests="*Chaos*"
def createChaosAgent() {
```gradle
## Enabling Chaos Testing
### 2. Add Chaos Agent Creation Task
- Ensures graceful degradation under adverse conditions
- Validates proper error handling and recovery
Add this to the `internalClusterTest` task:
  }
  }
    jvmArgs "-javaagent:${agentJar}"
  def agentJar = file("${buildDir}/chaos-agent.jar")
Agent-Class: org.opensearch.arrow.flight.chaos.ChaosAgent
# Chaos Testing
The chaos testing framework:
  // Enable chaos testing via bytecode injection
Chaos testing is disabled by default. To enable it, modify the `build.gradle` file:
