package mx.com.rappitest.util

import android.app.Application
import com.vicpin.krealmextensions.RealmConfigStore
import io.realm.Realm
import io.realm.RealmConfiguration
import mx.com.rappitest.model.Film

class RappiApp :Application() {

 override fun onCreate() {
  super.onCreate()
  Realm.init(this)
  /*
  val moviesConfig = RealmConfiguration.Builder()
   .name("movies_db")
   .schemaVersion(1)
   .deleteRealmIfMigrationNeeded()
   .build()
  Realm.deleteRealm(Realm.getDefaultConfiguration())
  Realm.deleteRealm(moviesConfig)
  RealmConfigStore.initModule(Film::class.java, moviesConfig)
  */

 }
}