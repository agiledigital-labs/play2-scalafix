package fix

import scalafix.v1._
import scala.meta._

class Play2Scalafix extends SemanticRule("Play2Scalafix") {

  override def fix(implicit doc: SemanticDocument): Patch = {
    val configurationMatcher = SymbolMatcher.normalized("play.api.Configuration.getString")

    doc.tree.collect {
      case a@Term.Apply(
        s@Term.Select(_, n),
        args
      ) if configurationMatcher.matches(s.symbol) =>
        Patch.replaceTree(n, "get[Option[String]]")
      case _ => Patch.empty
    }.asPatch

  }
}
