File f=new File("C:\\Desarrollo\\diccionaryProcess\\fr_FRLimpio.txt")
def caracteresEncontrados=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z','á','é','í','ó','ú'];
f.eachLine
{
    lineaActual->
    def lineaMinuscula=lineaActual.toLowerCase();
    lineaMinuscula.each{
        
        caracterActual->
            
            if(!caracteresEncontrados.contains(caracterActual))
            {
                println caracterActual;
                caracteresEncontrados<<caracterActual;                
            }
        
            
    }
}
