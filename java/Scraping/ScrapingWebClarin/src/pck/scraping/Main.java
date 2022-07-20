package pck.scraping;

import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    /**
     * Funcion que permite crear un documento y almacenar la información Scrapeada
     * @param titulo y informacion 
     */
  
    
    /**
     * metodo que permite realizar la conexion de la pagina y retorna su contenido
     * @param url de la pagina
     * @return contenido del html
     */
    public static Document getHTML(String url){
        Document html = null; //creamos el documento vacio
        
        try {
            html = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get(); //realiza la coneccion con la url y obtiene todo su contenido
        } catch (Exception ex) {
            System.out.println("Error al obtener el codigo HTML");
        }
        return html;
    }
    
    /**
     * Funcion que obtiene los url absolutos de cada noticia
     * y almacena el contenido del titulo y su información
     */
    public  void scraping(){
        Elements articulos = Main.getHTML("https://www.primeraedicion.com.ar/").select("div.post-inner.post-hover"); //creamos el objeto que almacenará cada dato y parseamos los datos para obtener solo los necesarios
        File archivo = new File("InformacionObtenida\\Noticias.doc"); //crea el archivo nuevo
        
        for(Element noticia : articulos){ //ciclo que obtendrá cada url absoluto y retornará los datos uno por uno
            String urlNoticia = noticia.select("a").attr("abs:href");//url absoluto de la noticia
            Document htmlNoticia = Main.getHTML(urlNoticia); //obtenemos el contenido de la noticia

            //Guardamos los datos obtenidos por parte
            String titulo = htmlNoticia.select("h1").text(); //guardamos el titulo
            String informacion = htmlNoticia.select("p").not("p.volanta").text();//guardamos el contenido

            //guardamos la información
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo,true)); //creamos el elemento de la clase PrintWriter y permitimos que cada informasion se agregue sin borrar la anterior

                //Datos a guardar en el doc
                salida.println(titulo);
                salida.println("");
                salida.println(informacion);
                salida.println("-------------------------------------------------------------------------");
                salida.println("");
                salida.close();
                
                System.out.println(titulo);
                System.out.println(informacion);
                System.out.println("----------------------------------------------------------");
                System.out.println("");
            } catch (IOException ex) {
                System.out.println("Error al crear o escribir archivo");
            }
        }
    }
    
    public static void main(String[] args) {
        new Main().scraping();//instanciamos un objeto de la clase ScrapingWeb y llamar al metodo scraping
    }
    
}
