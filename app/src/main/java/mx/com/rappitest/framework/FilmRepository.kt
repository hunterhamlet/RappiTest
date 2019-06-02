package mx.com.rappitest.framework

import com.vicpin.krealmextensions.*
import mx.com.rappitest.model.Film

class FilmRepository : IFilmRepository {

 //override fun
 override fun addMovie(movie: Film) {
  movie.save()
 }

 override fun addListOfMovies(movieList: MutableList<Film>) {
  movieList.saveAll()
 }

 override fun searchMovieById(movieId: Int): List<Film> {
  return Film().query { equalTo("id", movieId) }
 }

 override fun searchMovieByTitle(movieTitle: String): List<Film> {
  return Film().query { equalTo("title", movieTitle) }
 }

 override fun deleteAll() {
  Film().deleteAll()
 }

 override fun searchAll() : List<Film> {
  return Film().queryAll()
 }

}