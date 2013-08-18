import java.text.Collator
 
File f=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\lemario-20101017Limpio.txt")
File fOtro=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\palabrasespanollimpiasLimpio.txt")

File fResultado=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\lemariounionmio.txt")

def listFMia=[]
def listFOtros=[]
def listaComplemento=[]
def spanishColl=Collator.getInstance(new Locale("es", "ES"))

deArchivoALista(f,listFMia)
deArchivoALista(fOtro,listFOtros)

listaFMia=listFMia as Set
listFOtros=listFOtros as Set

listaUnion=listFMia+listFOtros
listaUnion=listaUnion as Set

def lstOrd=listaUnion.sort(spanishColl)
deListaAArchivo(fResultado,lstOrd)


def deArchivoALista(archivo,lista)
{
archivo.eachLine
{
    lista<<it
}
}

def deListaAArchivo(archivo,lista)
{
archivo.withWriter { out ->
    lista.each() { 
        out.writeLine("${it}")
    }
}
}