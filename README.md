# TopMovies

Aplicación creada para Rappi, como un test que poder ingresar dentro de sus filas, esta escrita en kotlin.

## Capas de la aplicación
_Breve explicación sobre las capas de la app_

La aplicación consta de 5 capas, que estan divididas en carpetas, se pretendió utilizar una arquitectura MVVM, un patron Repositori
y Clean Architecture:

* **View:** Esta capa es solo para las interacciones del usuario, en este caso se agregaron todos los fragment y activities 
utilizadas de igual manera; se agregan los adaptadores para poder ser utilizados dentro de los Recyclerviews, y tambien sirve 
para inicializar los ViewModel creados para cada uno. Dentro de esta capa se encuentran las siguientes clases: **MoviesAdapter.kt,
FilmDetailActivity.kt, MainActivity.kt,PopulatedFragment.kt,TopRatedFragment.kt, UpcomingFragment.kt, SplashActivity.kt**.
* **Model:** Esta capa es donde se almacenan todas las clases de los objetos que son necesarias para el funcionamiento de la 
app. Dentro de esta capa se encuentran las siguientes clases: **ApiResponse.kt, Film.kt,Image.kt, PopulatedResponse.kt, TopRatedResponse.kt,
UpcomingResponse.kt**.
* **ViewModel:** Esta capa corresponde a los ViewModel ocupados por las activities y los fragments, aqui es donde se realiza toda
la lógica del negocio, y es donde van cargados los métodos para poder realizar los llamados a las API's u obtener los datos desde
la base de datos. Dentro de esta capa se encuentran las siguientes clases: **FilmDetailViewModel.kt, MainViewModel.kt, PopulatedViewModel.kt,
TopRatedDetailViewModel.kt, UpcomingViewModel.kt**.
* **Util:** Esta capa es para agregar lo que nos puede ser util para la app, como por ejemplo metodos ocupados en mas de una activity o fragment,
de igual manera consta de los paths para las llamadas de las API's, y constantes para poder ser utilizadas globalmente. De igual manera
consta de la inicializacion de la app, es decir su clase. Dentro se encuentran las siguientes clases: **AppUtils.kt, RappiApp.kt**
* **Framework:** Esta capa sirve para declarar las interfaces y clases para poder ocupar las API's y de igual manera el almacenamiento
en cache. Dentro de esta capa se encuentran las siguientes clases: **FilmRepository.kt, IFilmRepository.kt, MoviewDBApi.kt**

## Responsabilidad por clase
_Explicación de responsabilidades por clase_
* **FilmRepository.kt:** Definir metodos para el CRUD a la base de datos local.
* **IFilmRepository.kt:** Interfaces a implementar para el repository.
* **MoviewDBApi.kt:** Se encarga de definir las llamadas de las API's a utilizar.
* **ApiReponse.kt:** Objeto el cual cuenta con clases internas para respuestas de las API's.
* **Film.kt:** Objeto que cuenta con los detalles de cada film.
* **Image.kt:** Objeto que cuenta con propiedades del despliegue de imagenes por film.
* **PopulatedResponse.kt:** Objeto el cual es la respuesta a la llamada de los objetos Populated.
* **TopRatedResponse.kt:** Objeto el cual es la respuesta a la llamada de los objetos TopRated.
* **UpcomingResponse.kt:** Objeto el cual es la respuesta a la llamada de los objetos Upcoming.
* **AppUtil.kt:** Contiene funciones y valores que se comparten entre las activities y fragments.
* **RappiApp.kt:** Inicialización de variables globales a utilzar, que solamente necesitan ser llamadas una vez en toda la app.
* **MoviesAdapter.kt:** Adaptador para poder desplegar la información de las peliculas dentro del Recyclerview.
* **FilmDetailActivity.kt:** UI para desplegar los detalles de las peliculas, cuenta con lógica para iniciar el ViewModel.
* **MainActivity.kt:** UI para desplegar el menú de Populated, TopRated y Upcoming, cuenta con lógica para iniciar el ViewModel.
* **SplashActivity.kt:** UI para desplegar el SplashScreen, cuenta con lógica para iniciar el ViewModel.
* **PopulatedFragment.kt:** UI para desplegar la parte de Populated, cuenta con lógica para iniciar el ViewModel.
* **TopRatedFragment.kt:** UI para desplegar la parte de TopRated, cuenta con lógica para iniciar el ViewModel.
* **UpcomingFragment.kt:** UI para desplegar la parte de Upcoming, cuenta con lógica para iniciar el ViewModel.
* **FilmDetailViewModel.kt:** ViewModel con la lógica de nogocios.
* **MainViewModel.kt:** ViewModel con la lógica de nogocios.
* **PopulatedViewModel.kt:** ViewModel con la lógica de negócios.
* **TopRatedViewModel.kt:** ViewModel con la lógica de negócios.
* **UpcomingViewModel.kt:** ViewModel con la lógica de negócios.

## Preguntas
_Respuesta a preguntas solicitadas_

* **¿En qué consiste el principio de responsabilidad única? Cuál es su propósito?**
El principio de responsabilidad única, a mi entender; es que cada clase debe de tener una y solo una responsabilidad, para evitar
un refactorizado muy tedioso, es decir mantener estable el código y de igual manera el código pueda ser escalable.
El proposito de este principio es mantener lo mas desacoplado posible las clases, esto nos sirve para poder utilizar, la inyección
de dependencias.

* **¿Qué características tiene, según su opinión, un “buen” código o código limpio?**
En mi opinión, es mantener buenas practicas al definir las clases, es mantener el codigo bien documentado de loq ue realiza cada
funcion, en mi caso divido las variables y las constantes, las funciones override, las inner class, las funciones privadas y publicas,
esto me ha servido ya que puedo localizar mas rápido el problema y asi tener mas eficiencia al desarrollar, de igual manera, 
mantener una estructura a la hora de desarrollar los componentes de la app.
