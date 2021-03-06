import java.io._
import scala.util._
import java.util.Properties
import scala.collection.mutable.Stack
import scala.sys.process._

object datasource
{
  val prop = new Properties()
  def main(args: Array[String]) {
prop.load(new FileInputStream("res/Property.cgf"))   
val mps = prop.getProperty("mps")

val filename = "grammar.spl"  
val label=""
val collabel="";
val tablepattern=""".*DEFINE\s+TABLE\s+(\S+).*""".r
val pattern = """.*label\=\'([^\']+)\'.*""".r
val columnpattern=""".*COLUMN\s+(\w+).*""".r


val fileObject = new PrintWriter(new FileOutputStream(new File("/home/kushagra/githubtest/Scala-Codes/DatasourceCreator/target/Datasource.txt"),true))   //true For appending
val printWriter = new PrintWriter(fileObject)


var fileSource = scala.io.Source.fromFile(filename).getLines
var y=""
for(line<-fileSource){
  var tables = Stack[String]()
  if(line.matches(""".*DEFINE\s+TABLE.*"""))
  { val tablepattern(tbl)=line
    tables.push(tbl)
    printWriter.write("\n\n"+"select"+"\n")
     //print(tables.pop())
      y=tables.pop()
  }
if(line.matches(""".*COLUMN\s+(\w+).*"""))
    {
  if(line.matches(""".*label\=\'([^\']*)\'.*"""))
      {val columnpattern(column)=line
      
  val pattern(label)=line
 
  val x=column+" \t\tAS\t\t "+"\""+ label+"\""+","
//var fileyo=line.replaceAll(label,x)
printWriter.write(x+"\n")  // Writing to the new file  


        }
    }
if(line.matches(""".*ADD\_CONTEXT.*"""))
 {printWriter.write("from "+mps+"_mr"+"."+y+"\n")
//   println(y)
 }

}
printWriter.close()

//Process(sed ':a;N;$!ba;s/,\nfrom/\nfrom/g' target/Datasource.txt).!

 /*   else {
    val fileObject1 = new PrintWriter(new FileOutputStream(new File("/home/kushagra/githubtest/Scala-codes/target/Datasource.txt"),true))
    val printWriter = new PrintWriter(fileObject1)
    printWriter.write(line+"\n")
    printWriter.close()
    }
    }
  else {
    val fileObject1 = new PrintWriter(new FileOutputStream(new File("/home/kushagra/githubtest/Scala-codes/target/Datasource.txt"),true))
    val printWriter = new PrintWriter(fileObject1)
    printWriter.write(line+"\n")
    printWriter.close()
    }
}*/
}
}

