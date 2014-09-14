import java.nio.charset.Charset

def reader=new File("C:\\Users\\KIKI\\Desktop\\listado de palabras español.txt")

def writer=new File("C:\\Users\\KIKI\\Desktop\\listadoP_sinespacios.txt")


Charset ct=new CharsetToolkit(reader).getCharset()
println("**********************************CHARSET "+ct.name())    


reader.filterLine(writer.newWriter(),ct.name())
{
    it==~"[a-zA-Z]+"
}
