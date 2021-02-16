package FileCoreRep

import groovyx.gpars.dataflow.Promise

import javax.swing.*

import static groovyx.gpars.dataflow.Dataflow.task

class CoreRepPars implements CoreRep {

    //accept any file type:
    JFileChooser myFileChooser = new JFileChooser()
    
    myFileChooser.setCurrentDirectory( new File(System.getProperty("user.home")))
    myFileChooser.setFileSelectionMode ( JFileChooser.FILES_AND_DIRECTORIES );

    //get selected File and its name:
    final JFrame FRAME_INFO = new JFrame("PICK THE FILE TO BE ENCRYPTED!");
    FRAME_INFO.setSize ( 500, 500 );
    FRAME_INFO.setVisible ( true );
    int result = myFileChooser.showOpenDialog(FRAME_INFO);
    FRAME_INFO.setVisible ( false );

    if ( result == JFileChooser.APPROVE_OPTION ) {
        File fileSelected = myFileChooser.getSelectedFile();
        try {
        }

        Promise StreamWrap = task { File file ->
            return fileInput(file)
        }

        def Promise ByteStreamWrap = task { BufferedInputStream inStream ->
            return fileByteStream(inStream)
        }

        Promise ByteArrayOutput = task { ByteArrayOutputStream byteOutStream ->
            return fileByte(byteOutStream)
        }

    }
}
