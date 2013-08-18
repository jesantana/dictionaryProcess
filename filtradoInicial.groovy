File f=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\lemario-20101017.txt")
File fLimpio=new File(f.name.toString().replace(".","Limpio."))

def caractAcentos=['á':'a'
                    ,'é':'e'
                    ,'í':'i'
                    ,'ó':'o'
                    ,'ú':'u']

def list=[]
def transformaciones=[]
//Transformaciones de filtrado
transformaciones<<{cad-> if(cad==~".*\\s.*"){null}else{cad}}
transformaciones<<{cad-> if(cad==~".*-.*"){null}else{cad}}

//Transformaciones de retoque
transformaciones<<{cad-> cad.toLowerCase()}
transformaciones<<{cad->caractAcentos.inject(cad)
{
    str, llave,valor->
    str.replaceAll(llave,valor)
}}

def counttotal=0;
def countagregadas=0;

f.eachLine
{
    lineaActual->
    counttotal++;
    
    def result=transformaciones.inject(lineaActual)
    {
        lActual,transActual->
        if(lActual!=null){
            transActual(lActual)
        }
        else
        {
            null
        }
    }
    
    if(result!=null){
         countagregadas++;
         list<<result
    }
}

deListaAArchivo(fLimpio,list)

def deListaAArchivo(archivo,lista)
{
archivo.withWriter { out ->
    lista.each() { 
        out.writeLine("${it}")
    }
}
}

println "Tratados ${counttotal} registros, Eliminados ${counttotal-countagregadas}"