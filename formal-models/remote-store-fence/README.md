| **fence** | The small mutable object that records who currently holds the right to acknowledge writes. |
   it from there rather than from a third-party release URL.
| Module | Question | Bound | States |
(`wTook`), **not** on still holding its current token, because the implementation sweeps straight
   and that writer is the recorded owner.
```bash
   store, which can be a strict *superset* of `acked`: a fenced writer's
Symmetry reduction (`SYMMETRY Symm`) is used only on `FenceTakeover`, where the specification is
The guard's necessity was **measured** rather than assumed, in the same way as the segment-flow
which is what `NoAckedWriteLoss` asserts.
1. Obtain `tla2tools.jar` from the TLA+ project's own release channel.
   after the metadata PUT completed — restores the invariant by
the object store order grants it cannot interpret — while performing no I/O itself.
| `FenceHandoff.tla` | equal-term relocation handoff, retried relocation, concurrent higher-term takeover, target loss | 4 ops, 3 attempts | 591 |
./gradlew :formal-models:modelCheck -PtlaToolsJar=/path/to/tla2tools.jar
   `F.owner ≠ ⊥ ∧ hasRead(F.owner) ⇒ acked ⊆ restore(F.owner) ∪ ackedBy(F.owner)`
the first copy's unguarded re-adoption *steals the chain back* and serves as the live owner from a
| **hydration** | Downloading the segment files named by the latest segment metadata. |
They are licensed by the necessity result above rather than by luck: relaxing the publication gate
over, so the source stands down. The object store settles an ambiguity the two copies cannot settle
   while the metadata lands only *after* the takeover read its restore
| **CAS chain** | The succession of version tokens one fence object passes through. A successful write must present the current token and hands back the next, so links cannot be skipped — holding the current token *is* ownership, and a writer that misses one can never rejoin. Defined in full on `RemoteStoreFence`. |
transfer, applied uniformly to every translog instance. Only the seal itself arbitrates unguarded,
The implementation claims the fence **twice** per takeover, and the module models both claims. The
token: success means the target never wrote, so the source resumes; failure means the target took
Step 3 is where a checksum belongs, enforced by whatever guards that storage. This build takes the jar
   read its restore point, every acknowledged operation is either in that
   orphan metadata file names operations that were never acknowledged. The
   `|{ w : state(w) ∈ {sealed, active} ∧ held(w) = F.token }| ≤ 1`
| Seal before read, back to the old code order — hydrate segments, then seal | `OwnerNeverReadUnsealed` **violated** |
3. **Ack attribution.** `⋃_w ackedBy(w) = acked`, and the `ackedBy(w)` are
the source publishes a second reference set and then collects, deleting a file the equal-term copy had
so a brand-new incarnation can still take over a dead incumbent's path, whose recorded owner it can
| **segment flow** | Segment files and their metadata — what a recovering copy hydrates from, gated by an ownership check rather than a CAS. |
gate is evaluated once at the top of a sync that then runs for some time, so a copy can publish after
| Term | What it means |
the chain over *during* that tokenless hydration window — the module admits appointments while the
   invariant is a `⊆`, so surfacing a never-acknowledged operation is
the chain. With publication gated the reference set cannot move under a hydrating owner; with
  (*seal before restore*), and that ordering on its own is what makes (2)
| `FenceAutoRestore.tla` | the auto-restore trigger for a primary with no surviving copy: node-left is a view change, the departed writer keeps running, and the fence — not the trigger — is what makes that safe; `FENCED = FALSE` (the ungated trigger) is refuted in a 7-state `NoAckedWriteLoss` counterexample; the operator's `_remotestore/_restore` is modeled as the same mutation under its weaker only-unassigned guard, racing the trigger and the rejoin; the node-left grace window (`index.unassigned.node_left.delayed_timeout`) gates the trigger but not the operator API nor the rejoin, with its expiry weakly fair (`DelayedAllocationService`'s promise); health is modeled RED-until-started (never overstating availability) | 3 writers, 2 nodes, 3 ops, 4 terms | 165,936 |
from it, so remote state is read on both the translog flow and the segment flow, and both need the fence.
implementation's publish path **fails open** — an unreadable fence reports "not superseded" — and the
| **partitioned writer** | A previous primary that has dropped out of the cluster's view but can still reach the object store. The case this protocol exists for. |
This holds because a writer's only destructive act is deleting objects **strictly below** its own
  hold;
recorded-ownership mechanism the relocation target uses to defer adoption until the source's
The re-adoption is authorized by **recorded ownership**: the seal recorded this copy's allocation
> Every count here is TLC's **final** summary. Do not read the first `distinct states found` in TLC's
### One property deliberately not asserted
What protects it is metadata **retention**, not the fence: `deleteStaleSegmentsAsync` keeps the last N
| `FenceSegmentFlow.tla` | the segment flow as a second path needing the fence, plus garbage collection | 3 writers, 3 files, 3 terms | 20,008 |
3. Mirror the vetted jar into artifact storage the project already trusts, and have any CI job take
*sufficient*: what the property needs is **at least one** of them, not both. The reason is visible in
the failure trace — one copy performs both the publish and the prune, so gating either action breaks
One deliberate code-faithfulness point: `DeleteLowerPaths` is guarded on having taken the path
(`RemoteStoreFence.java`, PR #22774 / RFC #22768). One mutable
by talking to each other.
  was reported violated at any bound.
### Vetting the jar
over `PEER` — so it hydrates segments **without sealing**, while its same-term source keeps publishing
So seal-before-read is needed on its own, but the two ownership checks are each individually
different resources — the refresh listener for segments, `trimUnreferencedReaders` for the translog.
   from a different network and host.
| `RemoteStoreFence.tla` | seal ordering and acked-write loss | 3 writers, 3 terms, 3 ops | 19,846 |
**Liveness** — under weak fairness of the claimant's read and CAS:
A shard publishes segment metadata as well as translog metadata, and a recovering copy hydrates
path as a single CAS register: a fence `F = (token, term, seq, owner)`;
|---|---|
are not kept as live configurations.
- cluster coordination contributes exactly two properties — monotonic term
That is defence in depth, not redundancy the model endorsed.
Four modules, each modeling the protocol **as implemented**:
   always permitted; that direction is load-bearing. What `visible` cannot
authority — it issues the term, the term names the key, and create-if-absent plus name ordering let
it is given and does not pretend to have verified it.
`held(w)`, a lifecycle state in `{unborn, fresh, sealed, active, fenced}`
- a claimant below the fence term is refused, an equal or higher one may
  **Writers, not terms, is the scaling dimension.**
segment publication and collection, and restore-point reads is checked. This is not a TLAPS
   point — the acknowledged operation is then in no successor's restore
## Layout
```
  regresses*);
`sealRemoteStoreFenceBeforeRestore` exempts `PEER` recovery, and a primary relocation target recovers
object, a claim-object escalation scheme, and a target-claims handoff — were each refuted by TLC and
*alone* yields no violation, because collection is gated — and the collection paths **fail closed**.
`∀w : state(w) = fenced ⇒ fencedBy(w) ≥ term(w)`
  (*the owner is advisory*);
the two, and the sweep still runs. The module explores that ordering rather than assuming it away;
## The invariants
reference set. Modelling retention would turn this into a *bound* — safe while the source publishes
after its successor was appointed. That window is exactly what seal-before-restore makes safe,
The fencing token is the CAS chain — the object's version token, or ETag —
`state(source) = fenced ⇒ ackedBy(target) ≠ ∅`
   CAS can win against the incumbent's object *before* a takeover's sweep
   13-state counterexample; the shipped ordering — the CAS is issued only
### Cross-term takeover — `FenceTakeover.tla`
tla/FenceSegmentFlow.tla        the segment flow as a second path needing the fence, plus GC
points in the real shard lifecycle; and in the code the two guards sit on different paths guarding
- **Takeover saturates in `MaxTerm`.** With N writers the failover chain can reach at most term N,
   happens-before and is what `RemoteStoreFence.cfg` checks
| `FenceTakeover.tla` | cross-term takeover: is a higher-term victory deterministic, and is the window between the seal claim and the translog's re-adoption safe? | 4 writers, 4 terms, 3 ops, symmetry | 4,460,896 |
and not the primary term itself.
| Ownership check on GC, alone | no violation |
`FenceSegmentFlow.tla` appoints only at `HighestIssuedTerm + 1`, so every copy in it is either the
and a restore point `restore(w)` read from the store; and a global set
  models only through the `Appoint*` actions.
  since each appointment consumes one unborn writer, so `MaxTerm ≥ |Writers|` adds no reachable
code did before the guard — and TLC violates `NoAckedWriteLoss` with a 17-state trace. A copy seals
7. **Fenced is terminal.** `□[∀w : state(w) = fenced ⇒ state'(w) = fenced]_vars`
token** (state `read` in the module); and the shard's own translog instance re-adopts the same-term
case and 0 states left on queue; see *On the bounds* below. Every reachable interleaving of
tla/RemoteStoreFence.tla        seal ordering and acked-write loss
jar, comparing it against a number written here would establish nothing: if they vetted it the check
never match.
tla/FenceTakeover.tla           cross-term takeover determinism
term, so a lower-term writer cannot touch a higher-term writer's acknowledgement path. Determinism
**not** sound with liveness properties in general.
   restore point or was acknowledged by the owner itself.
Until that vetting happens, the exposure is limited by design: nothing is downloaded,
Each run explores its **complete** state graph — 0 states left on queue — so nothing is missed
   (`SEQUENCED = TRUE`).
The two shard-data paths are named separately throughout rather than lumped together as "the data
  self-consistent. It cannot establish that the URL, the release asset, or the digest are the
TLA+ models of the object-store-backed primary fencing protocol
  and it also broke air-gapped builds.
trusts, so obtaining it means fetching a GitHub release asset. Doing that and verifying a pinned
| **sweep** | The delete step of a claim — removing every acknowledgement path below your own term. |
## Running
**HydrationIntegrity** — the copy that owns the fence must never find a file it still needs already
  third-party binary. Supplementary verification of a design spec is not worth that blast radius,
It matters because the code does reach the segment flow at an equal term.
id, and the re-adoption is refused unless the path still records it. This is the same
## What is proved, and how
> output: that is a mid-run `Progress(...)` line and varies run to run, understating the total.
and reads its restore point; an equal-term twin arbitrates the chain over and acknowledges a write;
### What the segment flow does not cover
### The segment flow and GC — `FenceSegmentFlow.tla`
#### The fence is claimed twice, and re-adoption requires recorded ownership
vouch for itself, and a disclaimed pin sitting in the repository invites exactly the false confidence
tla/FenceAutoRestore.tla        the zero-replica auto-restore trigger over the fence
   contain is metadata still in flight, and that gap is why the module
**NoHigherTermDefeat** — a copy may only ever be defeated by a term at least as high as its own,
gates: relax it — let the re-adoption take over whatever token the path carries, which is what the
There is **deliberately no pinned checksum**. A digest recorded by whoever added the reference cannot
# or
is discarded once the claim returns; the translog restore point is then read holding **no live
1. **Mutual exclusion.** At most one live writer holds the current token,
owner or **strictly** superseded. That bound is load-bearing rather than incidental: `Superseded(w)`
- Wired into `check`, every CI environment running `./gradlew check` would pull an unmanaged
**NoSpuriousFencing** — an aborted handoff must not fence a healthy source:
first copy is fenced at the re-adoption instead, fails its shard, and recovers at a higher term —
| Requirement relaxed | Result |
- a takeover claims the chain **before** reading its restore point
   point, ever. Setting the module's `SEQUENCED` constant to `FALSE`
```
within these bounds. Larger bounds were probed out of band:
  upstream project's — all three need corroborating out of band, by a person.
Model checking is **opt-in, and the build downloads nothing.** Supply `tla2tools.jar` yourself:
Issuing a grant does not revoke the incumbent — revocation happens when the successor takes the
2. Corroborate it against **upstream's own published checksum**, a distribution package, or a fetch
  states queued when it was stopped. That is a resource limit and *not* a violation: no invariant
  states from 8,200,777 generated, 0 left on queue, all properties holding. The committed bound is
   pairwise disjoint — every ack belongs to exactly one writer.
gone: whatever it listed is either still in the store or already fetched. **OwnerNeverReadUnsealed**
target is authorized by **recorded ownership**. On abort the source attempts a revert with that
Alternative designs evaluated and refuted along the way — a single shared acknowledgement-path
Verifying the artifact is the caller's job, and belongs where the jar is obtained rather than where it
   reproduces that refuted design and TLC exhibits the trace in a
**Action properties** — hold across every transition:
tla/*.cfg                       one TLC configuration per module
`acked` of acknowledged operations, attributed by `ackedBy(w)`.
those paths gone.
together with the symmetric **TargetAcksAreDurable** — `ackedBy(target) ≠ ∅ ⇒ state(source) ≠ resumed`
the segment flow — so which one is meant always matters.
and collecting. **The fence does not protect that case**, and nothing here claims it does.
## Terms
| **translog flow** | Translog files and their metadata — the acknowledgement path, gated directly by the fence CAS. |
listed but not yet fetched. That was measured, not assumed.
README.md                       this file: terms, the invariants, what is proved, how to run it
writers `w ∈ W`, each with an appointed term `term(w)`, a held token
and never out-raced by a lower-term incumbent:
|---|---|
### Relocation handoff — `FenceHandoff.tla`
| **CAS** | Compare-and-swap: a write the store accepts only if the object's current version is the one you present, and refuses otherwise. S3 `If-Match`, GCS generations, Azure ETags. Presenting no version means "only if absent". |
- ownership fields are advisory, and the token chain is the only authority
| **fencing token** | Whatever a writer has to present to prove it may still write. Here that is the current CAS token. |
`fence__<term>` object per primary term, written only by compare-and-swap.
- **5 writers exceeds this machine**, not the protocol. The run was still exploring with ~18M
is used:
Relocation happens at a constant term, so source and target share one object and term-scoping says
  issuance, and at most one active primary per shard — and is otherwise
acknowledgement path — so there is always a window where the previous owner still acknowledges
collection gated nothing prunes to a moved set.
tla/FenceHandoff.tla            equal-term relocation handoff
   the restore point its successor serves from. The seal-ordering module
> `registerTlcTask` matches the final summary and fails the build if any states are left on queue.
### On the bounds
Everything below leans on these, so they are worth pinning down first.
| **orphan** | A metadata file that a fenced writer published but never acknowledged. Harmless, but it accumulates. |
   (`SEQUENCED` selects the write-side ordering): issued concurrently, the
  smaller only because that module checks *liveness*, whose cost dominates state count.
is the practical value of the "either one alone suffices" measurement.
appointments, partitioned-writer acknowledgements, claim races, relocation handoff and abort,
| **Both** ownership checks | `HydrationIntegrity` **violated** |
  4,460,896 distinct states (9,616,026 generated, 0 left on queue, depth 38), all clean.
### On the gates being checked, not assumed
Without a jar the tasks fail with instructions. Individual modules run as `:formal-models:tlcRemoteStoreFence`, `tlcFenceTakeover`, `tlcFenceHandoff`, `tlcFenceSegmentFlow`.
   `∀w : (state(w) = fresh ∧ term(w) > F.term) ⇝ (F.term ≥ term(w) ∨ state(w) = fenced)`
| **restore point** | The latest translog metadata a recovering copy replays from. |
— so a late revert cannot displace a target that already acknowledged.
fewer than N times during the target's hydration — which is a rate argument rather than a guarantee.
path on its first upload (`ReAdoptList`/`ReAdoptTake`). An equal-term twin may appear and arbitrate
becoming superseded. Both are states the model forbids.
**Exhaustive model checking with TLC** over bounded models, with a complete state graph in every
SHA-256 afterwards would not be good enough:
ownership transfer itself as its last act before handing off, and keeps the resulting token. The
metadata files and everything they reference, whereas `Gc` in the model prunes to the single latest
The implementation keeps both regardless, for reasons the model cannot express rather than any it
  behaviour. Confirmed exactly: 4 writers at `MaxTerm` 4, 5 and 8 each explore the *identical*
the acknowledged write survives.
`:formal-models:check` does nothing, and the tasks fail closed unless a jar is passed explicitly.
something to fold in here at the cost of the cross-term result.
is redundant, and if they did not, this repository's digest cannot help.
restore point read before the twin's acknowledgement, which is thereby lost. With the guard, the
- an ack is a successful CAS on the chain (*the chain gates the ack*);
8. **A higher term prevails.**
tests `fenceTerm > wTerm[w]`, so an **equal-term** copy is never superseded and both ownership gates
|---|---|---|---|
These follow from five protocol rules:
| **control flow** | The path carrying decisions about *who may write*. The fence object is the only thing on it. |
proved. `Gc(w)` requires `wState = "active"`, so the model cannot represent collection at other
- **Seal ordering** was verified at 4 writers / 4 terms / 4 ops out of band: 3,691,705 distinct
comes from the key space rather than from winning a race. Cluster coordination supplies the
  uninvolved (*no cluster-manager synchronization*). It appears in the
it is safe because destructive acts stay strictly below the sweeper's own term, and both twins want
Three requirements make these hold, and how load-bearing each one is was **measured** by relaxing it
The asymmetry between the two failure directions is what makes the fail-open publish defensible, which
**Safety** — holds in every reachable state:
TLC shows *"only the highest granted term may acknowledge"* is false of any correct protocol.
is the ordering twin, asserting that an owner never read remote state before it owned the fence.
Determinism is stated as safety, which is what makes it exhaustively checkable:
after its create/arbitration without re-verifying possession. A twin may take the path over between
recovery seal claims through a *throwaway* fence instance (`RemoteFsTranslog#sealFence`) whose token
| **acknowledgement path** | The per-term fence object a writer advances on every ack. Deleting it is what stops a stale writer. |
TLC ships in `tla2tools.jar`, which is not on Maven Central or any registry this build already
symmetric in `Writers` and only invariants are checked. It gives roughly a 6× reduction, and it is
always pass for it. Adding an equal-term actor makes `HydrationIntegrity` itself false in 11 states —
incumbent is hydrating for exactly this reason.
via an inductive invariant is the natural follow-up if that is wanted.
| **seal**, or **claim** | Take the fence over at your own term: create your own key, then delete every lower-term key. |
TLA_TOOLS_JAR=/path/to/tla2tools.jar ./gradlew :formal-models:modelCheck
   splits the acknowledgement into a metadata PUT, a fence CAS and a join
```
### Why it is not part of `check`
`Refresh` and `Gc` both require `~Superseded(w)`, which presumes the check is accurate. The
4. **Owner/term agreement.** `F.owner ≠ ⊥ ⇒ F.term = term(F.owner)`
2. **No acked write loss.** The one that matters most. Once the owner has
it warns against. Because the caller supplies the
nothing about them. The source still owns the chain and has drained its uploads, so it performs the
deductive proof for unbounded parameters. A TLAPS proof of mutual exclusion and no-acked-write-loss
| Ownership check on segment metadata publication, alone | no violation |
That belongs in a module of its own alongside `FenceHandoff.tla`, and is an open follow-up rather than
against the model rather than argued. The answer is not uniform:
State, for the seal-ordering module, which abstracts the acknowledgement
   Put another way: nothing a superseded writer acknowledged lands after
   sets `restore(w) = visible` — the metadata that has *landed* in the
| **superseded** | A strictly higher term now holds the fence, so this copy has to stop touching shared state. |
- A checksum pinned in the **same change** that introduces the download only proves the bytes are
5. **Term monotonicity.** `□[F.term' ≥ F.term]_vars`
flow", because they are fenced by different means — a CAS on the translog flow, an ownership check on
# Remote Store Fence — formal specification
6. **Seq monotonicity.** `□[F.token' > F.token ⇒ F.seq' = F.seq + 1]_vars`
  claim, and the CAS settles concurrent claimants (*the term never
