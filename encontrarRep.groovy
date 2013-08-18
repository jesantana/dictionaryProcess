File f=new File("C:\\Users\\KIKI\\Desktop\\script groovy\\diccionarios\\lemario-20101017.txt")

File fImp=new File("C:\\Users\\KIKI\\Desktop\\script groovy\\diccionarios\\impresiones.txt")


def list=[:]
def lstFinal=[]
f.eachLine
{
    def cad=it.toLowerCase().trim()
    if(list[cad]==null)
    {
        list[cad]=0
    }
    list[cad]++;
}

list.each()
{ llave,valorr->
    if(valor>1)
    {
        lstFinal<<list[llave]+" "+valor;
    }
}

deListaAArchivo(fImp,lstFinal)

def deListaAArchivo(archivo,lista)
{
archivo.withWriter { out ->
    lista.each() { 
            out.writeLine(it)
        
    }
}
}