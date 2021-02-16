package FileCoreRep

import javax.swing.*;
import static groovyx.gpars.dataflow.Dataflow.task
import groovyx.gpars.dataflow.Promise

//This is a test for the byte rep:
class CoreTestRun{

    static void main(String[] args) {

                CoreRepPars myCoreRep = new CoreRepPars()
                myCoreRep.ByteStreamWrap(fileSelected)
            } catch(Exception ex) {
                ex.printStackTrace()
            }
        }

    }
}

