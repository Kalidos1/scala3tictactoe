package util

import java.security.KeyStore.TrustedCertificateEntry

import org.scalatest._
import matchers.should._
import wordspec._

class ObservableTest extends Observer {
  var updated: Boolean = false
  def isUpdated: Boolean = updated
  override def update: Boolean = {updated = true; updated}
}

class ObservableSpec extends AnyWordSpec with Matchers {
  "An Observable" should {
    val observable = new Observable
    val observer = new ObservableTest
    "add an Observer" in {
      observable.add(observer)
      observable.subscribers should contain (observer)
    }
    "notify an Observer" in {
      observer.isUpdated should be(false)
      observable.notifyObservers
      observer.isUpdated should be(true)
    }
    "remove an Observer" in {
      observable.remove(observer)
      observable.subscribers should not contain (observer)
    }

  }

}
