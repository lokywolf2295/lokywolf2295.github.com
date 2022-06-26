package peliculas.modelo;

public interface ICatalogoPeliculas {
    
    //instanciamos los metodos que se utilizaran en la interface 
    void insertarPelicula(Pelicula nombrePelicula);
    void listarPelicula();
    void buscarPelicula(String nombrePelicula);
}
