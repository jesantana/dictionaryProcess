File f=new File("C:\\Desarrollo\\diccionaryProcess\\fr_FR.txt")
File fLimpio=new File(f.absolutePath.toString().replace(".","Limpio."))

def caractAcentos=['á':'a'
                    ,'é':'e'
                    ,'í':'i'
                    ,'ó':'o'
                    ,'ú':'u'
                    ,'å':'a'
                    ,'ï':'i'
                    ,'ç':'c'
                    ,'è':'e'
                    ,'ë':'e'
                    ,'ê':'e'
                    ,'â':'a'
                    ,'ô':'o'
                    ,'î':'i'
                    ,'ÿ':'y'
                    ,'æ':'ae'
                    ,'œ':'oe'
                    ,'û':'u'
                    ,'ã':'a'
					,'ö':'o'
                    ,'ü':'u'
                    ,'à':'a'
					,'ä':'a'
					,'\'':''
					,'ù':'u'

					]
	


def list=[]
def transformaciones=[]
//Transformaciones de filtrado
transformaciones<<{cad-> cad.split('/')[0]}
transformaciones<<{cad-> if(cad==~"([^\\s]+)(\\s+)([^\\s]+)"){null;}else{cad}}
/*<<{cad-> if(cad==~"(.*)(\\-+)(.*)"){null;}else{cad}}
transformaciones<<{cad-> if(cad==~"(.*)(\\&+)(.*)"){null;}else{cad}}
transformaciones<<{cad-> if(cad==~"(.*)(\\.+)(.*)"){null;}else{cad}}
transformaciones<<{cad-> if(cad==~"(.*)(\\d+)(.*)"){null;}else{cad}}
transformaciones<<{cad-> if(cad==~"(.*)(\\?+)(.*)"){null;}else{cad}}
transformaciones<<{cad-> if(cad==~"(.*)(\\µ+)(.*)"){null;}else{cad}}
transformaciones<<{cad-> if(cad==~"(.*)(\\>+)(.*)"){null;}else{cad}}
*/
transformaciones<<{cad-> if(cad==~"(.*)((\\-|\\&|\\.|\\d|\\?|\\µ|\\>|\\<)+)(.*)"){null;}else{cad}}

//Transformaciones de retoque
transformaciones<<{cad-> cad.trim()}
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
        if(lActual){
           
            transActual(lActual)
        }
        else
        {
            null
        }
    }
   
    if(result){
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