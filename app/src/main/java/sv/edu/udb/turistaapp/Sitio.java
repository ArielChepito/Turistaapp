package sv.edu.udb.turistaapp;

/**
 * Created by chepito on 10-04-17.
 */

public class Sitio {
        public String name;
        public int imagen;
        public String descripcion;

    public static  Boolean LAN = true;
    public static  String JOYACEREN;
    public static  String CIHUATAN;
    public static  String CASABLANCA;
    public static  String SANANDRES;
    public static  String TAZUMAL;
        public Sitio(){
            change();
        }

        public static void change(){
            if(LAN){

                JOYACEREN = "Estas instalaciones precolombinas deben ser visitadas por todos, acá existe la posibilidad de conocer cómo vivían los agricultores en siglos anteriores. Es Patrimonio de la Humanidad.";
                CIHUATAN = "Las áreas verdes resaltan en este terreno prehispánico del municipio de Aguilares, fue habitado por mayas entre los años 900 a 1200 D.C. Posee una extensión aproximada de tres kilómetros cuadrados, es uno de los más amplios del país y destaca por sus siete áreas que guardan importantes relatos de nuestros antepasados. La información que guardan sus estructuras son de vital importancia para la historia actual.";
                CASABLANCA = "En Santa Ana este es uno de los lugares más visitados por estudiantes, amantes de la arqueología y profesionales. De acuerdo a datos oficiales, llegó a ser el centro de un importante señorío maya de finales del Período Preclásico Tardío (500 A.C. a 250 D.C.) y el período Clásico (250 D.C. a 900 D.C.). Dentro del terreno también se ha habilitado un museo con inigualables piezas históricas, entre otros interesantes artículos.";
                SANANDRES = "Ubicado en el departamento de La Libertad. Estas ruinas son visitadas por miles de locales y extranjeros año tras año. La infraestructura denota los conocimientos mayas alrededor del 600 a 900 D.C.";
                TAZUMAL = "Este extraordinario asentamiento maya se divide en dos zonas, ambas poseen sus propias características y manifestaciones de su tiempo. Se encuentra en Chalchuapa y su pirámide es una de las que más se conserva a pesar del tiempo, tuvo algunas intervenciones en décadas pasadas, todo con el objetivo de conservarla en buenas condiciones. Más de 20 tumbas cautivan a cualquier turista.";
            }
            else
            {
                CASABLANCA = "In Santa Ana this is one of the places most visited by students, lovers of archeology and professionals. According to official data, it became the center of an important Mayan lordship from the end of the Late Preclassic Period (500 BC to 250 BC) and the Classic period (250 BC to 900 BC). Within the terrain has also enabled a museum with unparalleled historical pieces, among other interesting articles.";
                SANANDRES = "Located in the department of La Libertad. These ruins are visited by thousands of locals and foreigners year after year. The infrastructure denotes Mayan knowledge around 600 to 900 D.C.";
                CIHUATAN = "The green areas stand out in this pre-Hispanic land of the municipality of Aguilares, was inhabited by Mayas between the years 900 to 1200 D.C. It has an approximate extension of three square kilometers, is one of the largest in the country and stands out for its seven areas that hold important accounts of our ancestors. The information that your structures keep is of vital importance for the current history.";
                JOYACEREN = "These pre-Columbian facilities must be visited by all, here there is the possibility of knowing how farmers lived in previous centuries. It is Patrimony of the Humanity.";
                TAZUMAL = "This extraordinary Mayan settlement is divided into two zones, both possessing their own characteristics and manifestations of their time. It is located in Chalchuapa and its pyramid is one of the most preserved despite time, had some interventions in past decades, all with the aim of keeping it in good condition. More than 20 tombs captivate any tourist.";
            }


        }

        public Sitio(String name, int imagen) {
            this.name = name;
            this.imagen = imagen;
            change();
        }

        public Sitio(String name, int imagen, String descripcion) {
            this.name = name;
            this.imagen = imagen;
            this.descripcion = descripcion;
            change();
        }

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getimagen() {
            return imagen;
        }

        public void setimagen(int imagen) {
            this.imagen = imagen;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
}
