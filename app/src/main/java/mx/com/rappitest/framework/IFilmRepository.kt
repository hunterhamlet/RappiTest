package mx.com.rappitest.framework

import mx.com.rappitest.model.Film

interface IFilmRepository {

 fun addMovie(movie: Film)
 fun addListOfMovies(movieList : MutableList<Film>)
 fun searchMovieById(movieId : Int) : List<Film>
 fun searchMovieByTitle(movieTitle : String) : List<Film>
 fun searchAll() : List<Film>
 fun deleteAll()

}