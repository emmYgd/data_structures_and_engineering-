package FileCoreRep;
import java.io.*;


public interface CoreRep {

    default BufferedInputStream fileInput(File cloudFile) throws IOException{
        FileInputStream fileStream = new FileInputStream(cloudFile);
        BufferedInputStream bufferedStream = new BufferedInputStream(fileStream);
        return bufferedStream;
    }

    default ByteArrayOutputStream fileByteStream(BufferedInputStream bufferedStream) throws IOException{
        ByteArrayOutputStream byteArrayOutput;

        //output file is not specified to display to console...
        byteArrayOutput = new ByteArrayOutputStream(/*no file here...*/);

        //specify the number of bytes to read per time:
        byte[] fileReadByteChunk = new byte[1024];
        for (int readCloudFileNum; (readCloudFileNum = bufferedStream.read(fileReadByteChunk)) != -1; ){
            byteArrayOutput.write(fileReadByteChunk, 0, readCloudFileNum);
            byteArrayOutput.flush();
        }
       return byteArrayOutput;
    }

    default byte[] fileByte(ByteArrayOutputStream myOutputStream){
        byte[] cloudFileByteArray = myOutputStream.toByteArray();
        return cloudFileByteArray;
    }
}



