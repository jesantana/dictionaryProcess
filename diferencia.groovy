File f=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\lemario-20101017.txt")
File fOtro=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\palabrasespanollimpias1.txt")

File fResultado=new File("C:\\Documents and Settings\\je.santana\\Escritorio\\diccionarios\\lemariomenosmio.txt")

def listFMia=[]
def listFOtros=[]
def listaComplemento=[]

deArchivoALista(f,listFMia)
deArchivoALista(fOtro,listFOtros)

listaComplemento=listFMia.minus(listFOtros)

deListaAArchivo(fResultado,listaComplemento)


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



