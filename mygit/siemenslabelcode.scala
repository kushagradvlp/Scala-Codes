 import java.io._
import scala.util._
object Updatelabel
{
  def main(args: Array[String]) {
val filename = "/home/kushagra/scalaprac/grammar.spl"  
val label=""
val collabel="";
val pattern = """.*label\=\'([^\']+)\'.*""".r
val columnpattern=""".*COLUMN\s+(\w+).*""".r


var fileSource = scala.io.Source.fromFile(filename).getLines
for(line<-fileSource){
if(line.matches(""".*COLUMN\s+(\w+).*"""))
    {
  if(line.matches(""".*label\=\'([^\']*)\'.*"""))
      {val columnpattern(column)=line
      
  val pattern(label)=line
 
  val x=column+" "+label
  
var fileyo=line.replaceAll(label,x)
val fileObject = new PrintWriter(new FileOutputStream(new File("/home/kushagra/scalaprac/yoyo.txt"),true))   //true For appending
val printWriter = new PrintWriter(fileObject)
printWriter.write(fileyo+"\n")  // Writing to the new file  
printWriter.close()

        }
    else {
    val fileObject1 = new PrintWriter(new FileOutputStream(new File("/home/kushagra/scalaprac/yoyo.txt"),true))
    val printWriter = new PrintWriter(fileObject1)
    printWriter.write(line+"\n")
    printWriter.close()
    }
    }
  else {
    val fileObject1 = new PrintWriter(new FileOutputStream(new File("/home/kushagra/scalaprac/yoyo.txt"),true))
    val printWriter = new PrintWriter(fileObject1)
    printWriter.write(line+"\n")
    printWriter.close()
    }
}
}
}

