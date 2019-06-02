package mx.com.rappitest.framework

import com.vicpin.krealmextensions.*
import io.realm.Case
import mx.com.rappitest.model.Film
import mx.com.rappitest.util.POPULATED
import mx.com.rappitest.util.TOP_RATED
import mx.com.rappitest.util.UPCOMING

class FilmRepository : IFilmRepository {
 override fun searchMovieByTitleInPopulate(movieTitle: String): List<Film> {
  return Film().query { contains("title", movieTitle,Case.INSENSITIVE)
   .equalTo("type", POPULATED) }
 }

 override fun searchMovieByTitleInTopRated(movieTitle: String): List<Film> {
  return Film().query { contains("title", movieTitle,Case.INSENSITIVE)
   .equalTo("type", TOP_RATED)}
 }

 override fun searchMovieByTitleInUpcoming(movieTitle: String): List<Film> {
  return Film().query { contains("title", movieTitle,Case.INSENSITIVE)
   .equalTo("type", UPCOMING ) }
 }

 //override fun
 override fun addMovie(movie: Film) {
  movie.createOrUpdate()
 }

 override fun addListOfMovies(movieList: MutableList<Film>) {
  movieList.saveAll()
 }

 override fun searchMovieById(movieId: Int): List<Film> {
  return Film().query { equalTo("id", movieId) }
 }

 override fun searchMovieByTitle(movieTitle: String): List<Film> {
  return Film().query { contains("title", movieTitle,Case.INSENSITIVE) }
 }

 override fun deleteAll() {
  Film().deleteAll()
 }

 override fun searchAll() : List<Film> {
  return Film().queryAll()
 }

}