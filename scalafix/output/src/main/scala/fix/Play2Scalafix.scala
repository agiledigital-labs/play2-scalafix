package fix

object Play2Scalafix {
  // Add code that needs fixing here.
  import play.api.Configuration
  val configuration = Configuration.empty
  val viewId: Option[String] = configuration.get[Option[String]]("analytics.view_id")
}
