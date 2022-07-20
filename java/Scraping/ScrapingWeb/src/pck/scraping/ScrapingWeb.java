package pck.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;

public class ScrapingWeb {

    /**
     * Metodo que obtiene el codigo HTML de la pagina web
     * @param url de la pagina
     * @return codigo html
     */
    public static Document getHTML(String url) {
        Document html = null; //creamos un documento como vacío 
        try{
            html = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();//al documento agregamos la coneccion con la url que le pasamos como parametro
        }catch (Exception e){
            System.out.println("Error al obtener el codigo HTML");
        }
        return html;  
    }
    
    /**
     * Funcion que obtiene los url absolutos de cada noticia
     * y almacena el contenido del titulo y su información
     */
    public void scraping(){
        Elements articulos = ScrapingWeb.getHTML("https://www.diarioadn.co/").select("li.notice-item"); //extrae los elementos requeridos de la pagina y los almacena
         File archivo = new File("informacionObtenida\\Noticias.doc");
        for(Element noticia : articulos){
            try {
                String urlNoticia = noticia.select("a").attr("abs:href"); //obtenemos el url de cada noticia pero solo el atributo href y con abs pedimos su ruta absoluta
                Document htmlNoticia = ScrapingWeb.getHTML(urlNoticia); //obtenemos el contenido de la noticia
                
                //obtener datos
                String titulo = htmlNoticia.select("h1").text(); //obtenemos el titulo de cada noticia
                String informacion = htmlNoticia.select("p").text(); //obtenemos la información de cada parrafo
                
                //guardar informacion en el doc
                PrintWriter salida = new PrintWriter(new FileWriter( archivo, true));
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
            } catch (FileNotFoundException ex) {
                System.out.println("Error al entrar a la Noticia");
            } catch (IOException ex) {
                System.out.println("Error al escribir el documento");
            }
        }

    }
    public static void main(String[] args) {
        new ScrapingWeb().scraping();//instanciamos un objeto de la clase ScrapingWeb y llamar al metodo scraping
    }
    
}
